package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.techelevator.view.Menu;
import materials.Funds;
import materials.Logger;
import com.techelevator.Sellables;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTIONS_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTIONS_EXIT };
	private static final String[] PURCHASE_MENU = { "Feed Money", "Select Product", "Finish Transaction", "Back" };
	private static final String[] FEED_MONEY_MENU = { "1", "5", "10", "Back" };
	private Menu menu;
	private Funds funds = new Funds();

	// List containing data from vendingmachine.csv.
	private static List<Sellables> itemsList = new ArrayList<Sellables>();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
/////////////////////////////READ FILE AND PUT IT IN A LIST///////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void loadInventory() throws FileNotFoundException {
		File inputFile = new File("vendingmachine.csv");
		Scanner fileScanner = new Scanner(inputFile);

		while (fileScanner.hasNextLine()) {

			String lineOfData = fileScanner.nextLine();
			String[] lineOfDataArr = lineOfData.split("\\|");

			String slotLocation = lineOfDataArr[0];
			String name = lineOfDataArr[1];
			String price1 = lineOfDataArr[2];
			BigDecimal price = new BigDecimal(price1);
			String type = lineOfDataArr[3];
			String noise = "";

			if (type.equals("Chip")) {
				noise = "Crunch Crunch, Yum!";
				Sellables chip = new Chip(name, price, slotLocation, type, noise);
				itemsList.add(chip);
			}
			if (type.equals("Candy")) {
				noise = "Munch Munch, Yum!";
				Sellables candy = new Candy(name, price, slotLocation, type, noise);
				itemsList.add(candy);
			}
			if (type.equals("Drink")) {
				noise = "Glug Glug, Yum!";
				Sellables drink = new Drink(name, price, slotLocation, type, noise);
				itemsList.add(drink);
			}
			if (type.equals("Gum")) {
				noise = "Chew Chew, Yum!";
				Sellables gum = new Gum(name, price, slotLocation, type, noise);
				itemsList.add(gum);
			}
		}

	}

/////////////////////////////////START START START START//////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public void run() throws IOException {
		loadInventory();

		while (true) {

			System.out.println("Welcome to the Vendo-Matic 800");
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

/////////////////////////////////GET ME OUT OF HERE IMMEDIATELY!///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			if (choice.equals(MAIN_MENU_OPTIONS_EXIT)) {
				System.exit(1);

/////////////////////////////////DISPLAY ITEMS AVAILABLE FOR PURCHASE//////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			} else if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				// iterate through the itemsList list and use the getters in sellables to print
				// out what you need:

				for (Sellables item : itemsList) {
					if (item.getQuantity() > 0) {
						System.out.println(item.getSlotLocation() + " > " + item.getName() + " > " + "$"
								+ item.getPrice() + " > " + "Available: " + item.getQuantity());
					} else if (item.getQuantity() <= 0) {
						System.out.println(item.getSlotLocation() + " > " + item.getName() + " > " + "$"
								+ item.getPrice() + " > " + "SOLD OUT");
					}
				}
/////////////////////////////////MAIN MENU OPTIONS PURCHASE////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				String selection = "";

				while (!selection.equals("Back")) {
					selection = (String) menu.getChoiceFromOptions(PURCHASE_MENU);

/////////////////////////////////FEED MONEY////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

					if (selection.equals("Feed Money")) {
						processMoney();

/////////////////////////////////Finish Transaction////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

					} else if (selection.equals("Finish Transaction")) {

						// Return balance to user in nickels, dimes and quarters.
						MathContext mc = new MathContext(4);
						BigDecimal centsConvert = new BigDecimal(100);
						BigDecimal cents = funds.getBalance().multiply(centsConvert, mc);
						BigDecimal quartersConvert = new BigDecimal(25);
						BigDecimal dimesConvert = new BigDecimal(10);
						BigDecimal nickelConvert = new BigDecimal(5);

						BigDecimal numQuarters = cents.divide(quartersConvert);
						BigDecimal numDimes = (cents.remainder(quartersConvert)).divide(dimesConvert);
						BigDecimal numNickels = ((cents.remainder(quartersConvert).remainder(dimesConvert)
								.divide(nickelConvert)));

						System.out.println("Thank You For Your Purchase!: " + "Quarters: "
								+ Integer.valueOf(numQuarters.intValue()) + " Dimes: "
								+ Integer.valueOf(numDimes.intValue()) + " Nickels: "
								+ Integer.valueOf(numNickels.intValue()));

						// Create variable to store balance before balance is reset.
						BigDecimal bcBalance = new BigDecimal(0);
						bcBalance = funds.getBalance();

						// reset balance to zero.
						BigDecimal resetBalance = new BigDecimal(0.00);
						funds.resetBalance(resetBalance);

						// Add Give Change to Logger.
						Logger logger = new Logger();
						logger.addToLogGiveChange("GIVE CHANGE: ", NumberFormat.getCurrencyInstance().format(bcBalance),
								NumberFormat.getCurrencyInstance().format(funds.getBalance()));

						// return to start to keep using vending machine.
						run();

/////////////////////////////////SELECT A PRODUCT//////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

					} else if (selection.equals("Select Product")) {

						for (Sellables item : itemsList) {
							if (item.getQuantity() > 0) {
								System.out.println(item.getSlotLocation() + " > " + item.getName() + " > " + "$"
										+ item.getPrice() + " > " + " > " + "Available: " + item.getQuantity());

							} else if (item.getQuantity() <= 0) {
								System.out.println(item.getSlotLocation() + " > " + item.getName() + " > " + "$"
										+ item.getPrice() + " > " + "SOLD OUT");
							}

						}

						System.out.println("Please select your item>>");
						Scanner userInput = new Scanner(System.in);

						String codeInput = userInput.nextLine();

						// Create Array that stores valid product codes.
						String[] slotCodes = new String[] { "A1", "A2", "A3", "A4", "B1", "B2", "B3", "B4", "C1", "C2",
								"C3", "C4", "D1", "D2", "D3", "D4" };

						boolean contains = true;

						for (String str : slotCodes) {
							if (str.equals(codeInput)) {
								contains = true;
								break;
							} else {
								contains = false;

							}
						}

						// Check for empty, space, null entry or invalid product code.
						if (codeInput.equals("") || codeInput.equals(" ") || codeInput == null || !contains) {
							System.out.println("Product Code Does Not Exist");
							continue;
						}

						for (Sellables item : itemsList) {

							if (item.getSlotLocation().equals(codeInput) && item.getQuantity() == 0) {
								System.out.println("SOLD OUT, Please Select Another Item");
								continue;

							}

							if (item.getSlotLocation().equals(codeInput)) {

								// Check to ensure enough funds are available.
								int res;
								res = item.getPrice().compareTo(funds.getBalance());

								if (res == 1) {
									System.out.println(
											"Insufficents Funds Available, Please Feed More Money To Complete Purchase");
									continue;
								}

								// proceed with dispensing.

								// Variable to hold balance before purchase(for logger).
								BigDecimal bpBalance = new BigDecimal(0);
								bpBalance = funds.getBalance();

								// deduct quantity.
								int existingQuantity = item.getQuantity();
								int newQuantity = existingQuantity - 1;
								item.setQuantity(newQuantity);

								// deduct balance.
								funds.deductBalance(item.getPrice());

								// Add purchase to logger.
								Logger logger = new Logger();
								logger.addToLogVending(item.getName(), item.getSlotLocation(),
										NumberFormat.getCurrencyInstance().format(bpBalance),
										NumberFormat.getCurrencyInstance().format(funds.getBalance()));

								// print dispense statement.
								System.out.println(item.getNoise() + " Enjoy your " + item.getName() + " >> Cost is $"
										+ item.getPrice() + " >> " + "Total Balance remaining is "
										+ NumberFormat.getCurrencyInstance().format(funds.getBalance()));
								continue;
							}

						}

					}

				}

				System.out.println("You selected from the 2nd level: " + selection);
			}
		}
	}

	public void processMoney() throws IOException {
		Logger logger = new Logger();
		String selection = "";
		while (!selection.equals("Back")) {

			selection = (String) menu.getChoiceFromOptions(FEED_MONEY_MENU);

			if (selection.equals("1")) {
				BigDecimal selectionA = new BigDecimal(1);
				funds.setBalance(new BigDecimal(1));
				logger.addToLogMoney("FEED MONEY: ", NumberFormat.getCurrencyInstance().format(selectionA),
						NumberFormat.getCurrencyInstance().format(funds.getBalance()));

			} else if (selection.equals("5")) {
				funds.setBalance(new BigDecimal(5));
				BigDecimal selectionB = new BigDecimal(5);
				logger.addToLogMoney("FEED MONEY: ", NumberFormat.getCurrencyInstance().format(selectionB),
						NumberFormat.getCurrencyInstance().format(funds.getBalance()));

			} else if (selection.equals("10")) {
				funds.setBalance(new BigDecimal(10));
				BigDecimal selectionC = new BigDecimal(10);
				logger.addToLogMoney("FEED MONEY: ", NumberFormat.getCurrencyInstance().format(selectionC),
						NumberFormat.getCurrencyInstance().format(funds.getBalance()));
			}

			System.out.println("You have " + NumberFormat.getCurrencyInstance().format(funds.getBalance()));
		}
	}

	public static void main(String[] args) throws IOException {

		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();

	}
}
