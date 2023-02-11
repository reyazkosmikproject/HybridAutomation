package reports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	static ExtentReports reports;
	
	public static String reportsFolderPath;
	
	public static ExtentReports getReports()
	{
		
		if(reports==null)
		{
			reports=new ExtentReports();
			
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			String date = simpleDateFormat.format(new Date());
			date=date.replace(":", "-");
			System.out.println(date);
			
			
			reportsFolderPath=System.getProperty("user.dir")+"\\reports";
			
			File reportsFolder=new File(reportsFolderPath);
			
			reportsFolder.mkdir();
			
			
			String reportFilePath=reportsFolderPath+"\\"+date+".html";
			
			File reportFile=new File(reportFilePath);
			
			ExtentSparkReporter reporter=new ExtentSparkReporter(reportFile);
			reporter.config().setReportName("QA regression Testing ");
			reporter.config().setDocumentTitle("Automation Reports");
			reporter.config().setTheme(Theme.DARK);
			reports.attachReporter(reporter);
			
		}
		
		
		return reports;
		
	}

}
