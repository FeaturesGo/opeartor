package com.www.opeartor.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * @author hwg
 */
public class DateUtil {
	
	
	public static String getNowFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(new Date());
	}

	public static String getTest(){
		return null;
	}


	public static String getTest2(){
		return null;
	}

}
