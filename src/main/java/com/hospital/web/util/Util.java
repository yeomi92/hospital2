package com.hospital.web.util;

import java.util.Calendar;

public class Util {
	public static String[] getInfo(String jumin) {
		String[] info=new String[2];
		int ssn=Integer.parseInt(jumin.substring(0,2));
		switch(jumin.charAt(7)){
			case '1':case '2':
				info[0]=String.valueOf(Calendar.getInstance().get(Calendar.YEAR)-(1900+ssn)+1)+"세";
				info[1]="19"+jumin.substring(0,2)+"년"+jumin.substring(2,4)+"월"+jumin.substring(4,6)+"일";
				break;
			case '3':case '4':
				info[0]=String.valueOf(Calendar.getInstance().get(Calendar.YEAR)-(2000+ssn)+1)+"세";
				info[1]="20"+jumin.substring(0,2)+"년"+jumin.substring(2,4)+"월"+jumin.substring(4,6)+"일";
				break;
		}
		return info;
	}
}
