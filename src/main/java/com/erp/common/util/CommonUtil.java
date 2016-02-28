package com.erp.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;

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
	
	public static String getCurrentDate(String fmt){
		SimpleDateFormat format = new SimpleDateFormat(fmt);
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
	
	public static String getNextSeqNo(String seqNo,int length){
		int nextNo = Integer.parseInt(seqNo);
		nextNo ++;
		seqNo = "" + nextNo;
		for(int i = seqNo.length();i < length; i++){
			seqNo = "0" + seqNo;
		}
		seqNo = StringUtils.leftPad(seqNo, length);
		return seqNo;
	}
	
	public static String getNextRKSeqNo(String rKseqNo){
		
		String current = rKseqNo.substring(10,14);
		String next = getNextSeqNo(current,4);
		rKseqNo = rKseqNo.substring(0,10);
		rKseqNo = rKseqNo + next;
		//System.out.println(current);
		return rKseqNo;
	}
	
	public static String getNextCKSeqNo(String CKseqNo){
		String current = CKseqNo.substring(10,14);
		String next = getNextSeqNo(current,4);
		CKseqNo = CKseqNo.substring(0,10);
		CKseqNo = CKseqNo + next;
		//System.out.println(current);
		return CKseqNo;
	}
	
	public static String dataFormat(String str){
		if(str.length() <= 10){
			return str;
		}else{
			return str.substring(0,10);
		}
	}


	public static void main(String[] args) {
		
		System.out.println(getNextCKSeqNo("CK201501010001"));
	}

}
