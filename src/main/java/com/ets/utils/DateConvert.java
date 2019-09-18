package com.ets.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateConvert {
	
	public static  LocalDate dateToLocalDate(Date date){
		
		Instant instant1 = Instant.ofEpochMilli(date.getTime());
		LocalDateTime res = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault());
		LocalDate localDate1 = res.toLocalDate();
		
		return localDate1;
	
	}

}
