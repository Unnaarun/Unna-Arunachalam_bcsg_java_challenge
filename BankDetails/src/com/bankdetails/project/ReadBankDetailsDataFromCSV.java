package com.bankdetails.project;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author unna
 * 
 */

public class ReadBankDetailsDataFromCSV {

	public static void main(String[] args) {

		ReadBankDetailsDataFromCSV readCSV = new ReadBankDetailsDataFromCSV();
		readCSV.readFromFile();

	}

	public void readFromFile() {

		String csvFile = StringUtils.filePath;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			Map<BankDetails, String> bankExpiryDateMap = new TreeMap<>(
					new CardExpiryDateComparator());

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] bankData = line.split(cvsSplitBy);

				bankExpiryDateMap.put(new BankDetails(bankData[0], bankData[1],
						BankDetailUtils.getDate(bankData[2])), bankData[0]);

			}

			Set<BankDetails> keySet = bankExpiryDateMap.keySet();
			System.out.println("BANK | MASKED-CARD NUMBER  | EXPIRY DATE");

			for (BankDetails bankDetail : keySet) {

				System.out.println(bankDetail.toString());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		
	}

}
