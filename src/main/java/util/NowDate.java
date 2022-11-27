package util;

import java.sql.Date;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class NowDate {
	
	public Date getNowDate() {
		
		java.util.Date d = new java.util.Date();
		TimeZone tz = TimeZone.getTimeZone("Asia/Tokyo");
		
		SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");
		d1.setTimeZone(tz);
		String c1 = d1.format(d);
		
		Date date = Date.valueOf(c1);
		
		return date;
	}
	
	public String getNowDate00() {
		
		Calendar c = Calendar.getInstance();
		DateFormatSymbols dfs = DateFormatSymbols.getInstance();
		TimeZone tz = TimeZone.getTimeZone("Asia/Tokyo");
		
		SimpleDateFormat d1 = new SimpleDateFormat("MM/dd HH:mm",dfs);
		d1.setTimeZone(tz);
		
		String date = d1.format(c.getTime()).toString();
		
		String str = "(";
		str+=date;
		str+="追記)<br><br>";
		
		return str;
	}
}
