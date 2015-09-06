package com.bankdetails.project;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * @author unna
 *
 */

public class BankDetailUtils {
	

	/**
	 * @param dateInString
	 * @return
	 */
	public static Date getDate(String dateInString) {

		SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
		Date date = null;
		try {

			date = (Date) formatter.parse(dateInString);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}
	

	/**
	 * @param bank
	 * @param cardNo
	 * @return
	 */
	public static String getMaskedNumbersForBank(String bank, String cardNo) {
		String maskedCardNo = null;
		if (!StringUtils.isNullOrEmpty(bank) &&  !StringUtils.isNullOrEmpty(cardNo))
		{
			
			if("HSBC Canada".equals(bank))
			{
				maskedCardNo = cardNo.substring(0, 2) + "xx-xxxx-xxxx-xxxx";
				
			}
			else if("Royal Bank of  Canada".equals(bank))
			{
				maskedCardNo = cardNo.substring(0, 4) + "-xxxx-xxxx-xxxx";
			}
			else if("American Express".equals(bank))
			{
				maskedCardNo = "xxxx-xxxx-xxxx-" + cardNo.substring(cardNo.length() - 3);
				
			}
			
		} 
		
		return maskedCardNo;

	}

}
