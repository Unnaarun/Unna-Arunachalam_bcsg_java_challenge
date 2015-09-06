package com.bankdetails.project;

public class StringUtils 
{
	
	public static final String filePath = "D:\\JAVA\\mid-test.csv";
	
	/**
	* Check whether the supplied string[] is null or empty
	* 
	* @param input
	* @return true if the string is null or has zero length
	*/
	public static boolean isNullOrEmpty(String[] input)
	{
		if (input == null)
		{
			return true; 
		}
		
		for (int i = 0; i< input.length; i++)
		{
			if (isNullOrEmpty(input[i]))
			{
				return true;
			}
		}

		return false;
	}
	
	
	/**
	* Check whether the supplied string is null or empty
	* 
	* @param input
	* @return true if the string is null or has zero length
	*/
	public static boolean isNullOrEmpty(String input)
	{
		return input == null || input.length() == 0 || input.equals("null");
	}

}
