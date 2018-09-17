package com.retail.app;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Utility {

	public static int getYearDifference(Date first, Date second) {
		Calendar a = getCalendar(first);
	    Calendar b = getCalendar(second);
	    int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
	    if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) || 
	        (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
	        diff--;
	    }
	    return diff;

	}
	
	public static Calendar getCalendar(Date date) {
	    Calendar cal = Calendar.getInstance(Locale.US);
	    cal.setTime(date);
	    return cal;
	}
	
	public static void main(String[] args) {
		
		Calendar day = Calendar.getInstance(Locale.US);
		day.setTime(new GregorianCalendar(2017, 8, 16).getTime());
		
		System.out.println("yr Diff : " + Utility.getYearDifference(day.getTime(), new Date()));
		
		
	}

}
