package com.erp.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CommonUtil {
	
	public static String getFirstDayOfTheMonth(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
	    Date date = calendar.getTime();
	    GregorianCalendar gregorianCalendar = (GregorianCalendar)Calendar.getInstance();
	    gregorianCalendar.setTime(date);
	    gregorianCalendar.set(Calendar.DAY_OF_MONTH , 1);
	    date = gregorianCalendar.getTime();
	    return format.format(date);
 
	}
	
	public static String getCurrentDate(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        return format.format(date);

	}
	
	public static String getLastDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();
        String s = df.format(theDate);
        StringBuffer str = new StringBuffer().append(s).append(" 23:59:59");
        return str.toString();

    }
	
	public static String dateFormat(Date date,String format){
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}


	public static void main(String[] args) {
		

		System.out.println(getFirstDayOfTheMonth());
		
		System.out.println(getLastDay());
	}

}
