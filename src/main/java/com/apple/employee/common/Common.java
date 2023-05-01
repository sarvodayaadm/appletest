package com.apple.employee.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class Common {

	public static String getCurrentTimeUsingDate() {
		Date date = new Date();
		String strDateFormat = "hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate = dateFormat.format(date);
		System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
		return formattedDate;

	}

	public static LocalDateTime getCurrlocalDateTime() {
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		LocalDateTime fromDateAndTime = LocalDateTime.of(currentDate, currentTime);
		return fromDateAndTime;
	}

	public static String getCurrentTimeUsingCalendar() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = dateFormat.format(date);
		System.out.println("Current time of the day using Calendar - 24 hour format: " + formattedDate);
		return formattedDate;
	}

	public static String getCurrentDateTimeUsingDate() {
		Date date = new Date();
		String strDateFormat = "dd/MM/yyyy' 'HH:mm:ss.SSS";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate = dateFormat.format(date);
		System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
		return formattedDate;
	}
}