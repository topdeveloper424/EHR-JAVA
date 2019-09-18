package com.ets.test.controller;


import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToTime {

	public static void main(String[] args) {
		
		String myTime = "10:30 PM";
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
		Date date = null;
		try {
		    date = sdf.parse(myTime);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		String formattedTime = sdf.format(date);

		System.out.println(formattedTime);

	}

}
