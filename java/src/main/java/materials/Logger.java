package materials;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	File logFile;
	File salesReport;
	SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss aa");
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
	Date theDate = new Date();
	String logDT = dateFormat.format(theDate).toString() + "  " + timeFormat.format(theDate).toString();

	public Logger() throws IOException {
		logFile = new File("logFile.txt");
		logFile.createNewFile();
		salesReport = new File(".txt");
		salesReport.createNewFile();
	}

	public void addToLogVending(String name, String slotLocation, String bpBalance, String balance) throws IOException {

		try (FileWriter fw = new FileWriter(logFile, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter writer = new PrintWriter(bw);) {

			writer.print(" >" + String.format("%-8s", logDT) + " " + String.format("%-8s", name) + " " + slotLocation
					+ " " + bpBalance + " " + balance);

		} catch (IOException ex) {

		}
	}

	public void addToLogMoney(String type, String numFormat1, String numFormat2) {

		try (FileWriter fw = new FileWriter(logFile, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter writer = new PrintWriter(bw);) {

			writer.print(" >" + String.format("%-8s", logDT) + " " + String.format("%-8s", type) + " " + numFormat1
					+ " " + numFormat2);

		} catch (IOException ex) {

		}
	}

	public void addToLogGiveChange(String type, String bcBalance, String balance) throws IOException {

		final Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		try (FileWriter fw = new FileWriter(logFile, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter writer = new PrintWriter(bw);) {

			writer.print(" >" + String.format("%-8s", logDT) + " " + String.format("%-8s", type) + " " + bcBalance + " "
					+ balance + " >");
			writer.println(" ");

		} catch (IOException ex) {

		}
	}

}
