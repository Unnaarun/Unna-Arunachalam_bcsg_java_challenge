package com.bankdetails.project;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Test;

public class BankDetailUtilsTest 
{
	
	
	@Test
	public void testExpiryDateDescendingOrder_positive()
	{
	
		String expected[] = {"Dec-2018", "Nov-2017", "Oct-2017"};
		String[] result = geStaticDateList();
		
		
		Assert.assertArrayEquals(expected, result);
		
	
		
		
	}
	
	@Test
	public void testExpiryDateDescendingOrder_negative()
	{
	
		String expected[] = {"Dec-2018", "Oct-2017", "Nov-2017"};
		String[] result = geStaticDateList();
		
		
		Assert.assertThat(result, IsNot.not(IsEqual.equalTo(expected)));
		
		
	
	}

	
	@Test
	public void testCardMasking_For_HSBC()
	{
		
		String cardNo = "5601-2345-3446-5678";
		
		String result = BankDetailUtils.getMaskedNumbersForBank("HSBC Canada", cardNo);
		
		
		String expectedResult = "56xx-xxxx-xxxx-xxxx";
		assertEquals(expectedResult, result);
		
		
		
	}
	
	
	@Test
	public void testCardMasking_For_AMERICANEXPRESS()
	{
		
		String cardNo = "3786-7334-8965-345";
		
		String result = BankDetailUtils.getMaskedNumbersForBank("American Express", cardNo);
		
		
		String expectedResult = "xxxx-xxxx-xxxx-345";
		assertEquals(expectedResult, result);
		
		
		
	}
	
	@Test
	public void testCardMasking_For_ROYALBANK_CANADA()
	{
		
		String cardNo = "4519-4532-4524-2456";
		
		String result = BankDetailUtils.getMaskedNumbersForBank("Royal Bank of  Canada", cardNo);
		
		
		String expectedResult = "4519-xxxx-xxxx-xxxx";
		assertEquals(expectedResult, result);
		
	}
	
	public String[]  geStaticDateList()
	{
		String[] result = null;
		String dateOne = "DEC-2018";
		String dateTwo = "OCT-2017";
		String dateThree = "NOV-2017";
		Date dateObjectOne = BankDetailUtils.getDate(dateOne);
		Date dateObjectTwo = BankDetailUtils.getDate(dateTwo);
		Date dateObjectThree = BankDetailUtils.getDate(dateThree);
		BankDetails detailsObjectOne = new BankDetails("American Express", "12345667777", dateObjectOne);
		BankDetails detailsObjectTwo = new BankDetails("Royal Bank of  Canada", "12345667777", dateObjectTwo);
		BankDetails detailsObjectThree = new BankDetails("HSBC Canada", "12345667777", dateObjectThree);
		ArrayList<String>  dateList  = new ArrayList<String>();
		
		List<BankDetails> listBankDetails = new ArrayList<BankDetails>();
		listBankDetails.add(detailsObjectOne);
		listBankDetails.add(detailsObjectTwo);
		listBankDetails.add(detailsObjectThree);
		
	    Collections.sort(listBankDetails, new CardExpiryDateComparator());
		
		for(BankDetails date : listBankDetails)
		{
			dateList.add(BankDetails.formatter.format(date.getExpiryDate()));
			
			
		}
		 result = dateList.toArray(new String[dateList.size()]);
		 return result;
		
		
	}
	
	

}
