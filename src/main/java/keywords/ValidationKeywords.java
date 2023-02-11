package keywords;

import org.openqa.selenium.support.ui.Select;

public class ValidationKeywords extends GenericKeywords{

	public boolean validateSelectedValueInDropdown(String locatorKey,String optionText)
	{
		
		Select s1=new Select(getElement(locatorKey));
		
		String selectedOptionText=s1.getFirstSelectedOption().getText();
		
		return selectedOptionText.equalsIgnoreCase(optionText);
		
	}
	
	public boolean validateElementPresent(String locatorKey)
	{
			 
		boolean status= isElementPresent(locatorKey);
		
		return status;
		
	}
	
	public boolean validateTitle(String expectedTitle)
	{
		
		 boolean status=getTitle().equalsIgnoreCase(expectedTitle);
		 
		 if(status==false)
		 {
			 log(expectedTitle+" is not matched with title "+getTitle());
		 }
		 else
		 {
			 log(expectedTitle+" is  matched with title "+getTitle());
		 }
		return status;
		
	}
}
