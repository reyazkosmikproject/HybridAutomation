package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilKit {
	
	
	public static String resourceFolder="src\\test\\resources";
	
	public static Object[][] getData(String testcaseName,String sheetName) 
	{
		
		XSSFSheet ws = null;
		try
		{
		FileInputStream fis= new FileInputStream(resourceFolder+"\\testdata\\excels\\MasterTestData.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		 ws=wb.getSheet(sheetName);
		
		}
		catch(Exception e)
		{
			
		}
		
		
		
		
		ArrayList<Row> testCaseRows=findRows(testcaseName,ws);
		
		
		System.out.println("No of Rows found with Matched Test Case Name "+testCaseRows.size());
		
		
		Object[][] data=new Object[testCaseRows.size()-1][testCaseRows.get(0).getLastCellNum()-1];
		
		
		for(int i=0;i<testCaseRows.size()-1;i++)
		{
			
			for(int j=0;j<testCaseRows.get(0).getLastCellNum()-1;j++)
			{
				
				
				data[i][j]=testCaseRows.get(i+1).getCell(j+1).getStringCellValue();
				
				System.out.print(data[i][j]+"\t");
			}
			
			System.out.println();
			
		}
		
		return data;
	}

	private static ArrayList<Row> findRows(String testcaseName, Sheet ws) {
		
		
		ArrayList<Row> allRows=new ArrayList<Row>();
		
		ArrayList<Row> testCaseRows=new ArrayList<Row>();
		
		int noOfRows=ws.getLastRowNum();
		
		System.out.println("noOfRows "+noOfRows);
		
		for(int i=0;i<=noOfRows;i++)
		{
			
			if(!(ws.getRow(i)==null))
			{
				allRows.add(ws.getRow(i));
			}
			
		}
		
		
		for(int i=0;i<allRows.size();i++)
		{
			if(allRows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testcaseName))
			{
				testCaseRows.add(allRows.get(i));
			}
		}
		
		return testCaseRows;
		
		
		
	}
	
	

}
