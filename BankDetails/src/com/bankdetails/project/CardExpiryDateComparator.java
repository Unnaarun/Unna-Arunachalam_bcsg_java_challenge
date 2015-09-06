package com.bankdetails.project;

import java.util.Comparator;
/**
 * @author unna
 *
 */

public class CardExpiryDateComparator implements Comparator<BankDetails>
{

	@Override
	public int compare(BankDetails b1, BankDetails b2) 
	{
		return b2.getExpiryDate().compareTo(b1.getExpiryDate());
		
	}
	
	

}
