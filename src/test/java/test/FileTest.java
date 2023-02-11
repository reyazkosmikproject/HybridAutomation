package test;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(System.getProperty("user.dir"));
	   File screenshotDir= new File(System.getProperty("user.dir")+"\\screenshots");
	   screenshotDir.mkdir();

	}

}
