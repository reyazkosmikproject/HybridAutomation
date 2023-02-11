package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		
		
		Date d=new Date();
		
		System.out.println(d.toString().replace(":", "-"));
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		String date = simpleDateFormat.format(new Date());
		System.out.println(date.toString().replace(":", "-"));
		

	}

}
