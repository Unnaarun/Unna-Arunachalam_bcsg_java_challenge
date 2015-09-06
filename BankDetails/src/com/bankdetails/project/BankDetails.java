package com.bankdetails.project;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author unna
 *
 */
public class BankDetails 
{

	
	private String bankName;
	private String cardNo;
	private Date expiryDate;
	public static final SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
	
	public BankDetails(String bankName, String cardNo, Date expiryDate)
	{
		super();
		this.bankName = bankName;
		this.cardNo = cardNo;
		this.expiryDate = expiryDate;
		
	}
	
	
	public String getBankName() 
	{
		return bankName;
	}
	public void setBankName(String bankName) 
	{
		this.bankName = bankName;
	}
	public String getCardNo() 
	{
		return cardNo;
	}
	public void setCardNo(String cardNo)
	{
		this.cardNo = cardNo;
	}

	public Date getExpiryDate() 
	{
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) 
	{
		this.expiryDate = expiryDate;
	}
	
	
	public String toString()
	{
		
		return bankName + "| " + BankDetailUtils.getMaskedNumbersForBank(bankName, cardNo) + " |" + formatter.format(expiryDate);
	}
	
	

}
