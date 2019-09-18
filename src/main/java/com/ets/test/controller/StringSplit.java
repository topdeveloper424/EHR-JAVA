package com.ets.test.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

public class StringSplit {

	public  static void strToDate(){
		
		
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        String dateInString = "07/06/2013";

	        try {

	            Date date = formatter.parse(dateInString);
	          //  System.out.println("####### "+date);
	            System.out.println("@@@@@@@@@@"+formatter.format(date));

	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

		
		

    
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		strToDate();
		
		String patientDetail = "9/12";

		String str[] = patientDetail.split("/");
		
		System.out.println("String 1 : " +str[0]);
		System.out.println("String 2 : " +str[1]);
		
		int year = Year.now().getValue();
		
		System.out.println("Year is : " +year);

	}
	
	
	
	

}
