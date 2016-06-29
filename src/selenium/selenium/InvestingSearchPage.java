package selenium;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.interactions.*;
import org.testng.internal.collections.Pair;

public class InvestingSearchPage {

	@FindBy(how = How.LINK_TEXT, using= "Continue to Investing.com")
	private WebElement _Link_ClosePopup;
	
	@FindBy(how = How.LINK_TEXT, using = "Register")
	private WebElement _Link_Register;
	
	@FindBy(how = How.ID, using = "RegistersiteuserForm_user_firstname")
	private WebElement _Text_FirstName;
	
	@FindBy(how = How.ID, using = "RegistersiteuserForm_user_lastname")
	private WebElement _Text_LastName;
	

	@FindBy(how = How.ID, using = "RegistersiteuserForm_company_country_ID")
	private WebElement _Select_Country;
	

	@FindBy(how = How.CSS, using = "#RegistersiteuserForm_member_phone_area")
	private WebElement _Text_Phone_Area;
	
	@FindBy(how = How.CSS, using = "#RegistersiteuserForm_member_phone_phone")
	private WebElement _Text_Phone_Number;
	
	@FindBy(how = How.CSS, using = "#RegistersiteuserForm_user_email")
	private WebElement _Text_Email;
	
	//@FindBy(how = How.CSS, using = "#RegistersiteuserForm_user_email")
	//private WebElement _Text_Verify_Email;
	
	@FindBy(how = How.CSS, using = "#RegistersiteuserForm_password")
	private WebElement _Text_Password;
	
	@FindBy(how = How.CSS, using = "#RegistersiteuserForm_termsAndConditions")
	private WebElement _CheckBox_Agree_To_Terms_Conditions;
	
	
	@FindBy(how = How.CLASS_NAME, using = "#newBtn Arrow LightGray")
	private WebElement _Button_Register;
	
//	@FindBy(how = How.CSS, using = ".genTbl.openTbl.quotesSideBlockTbl.collapsedTbl")
//	private WebElement _Table_Market_Prices;
	
	@FindBy(how = How.ID, using = "searchTextTop")
	private WebElement _Text_Search;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@FindBy(how = How.CSS, using = ".genTbl.openTbl.quotesSideBlockTbl.collapsedTbl")
	private WebElement _Table_Indices;
	
	
	
	
	public void _click_Continue_To_Site(){
		try
		{
			_Link_ClosePopup.click();
		}
		catch (NoSuchElementException ex)
		{
			System.out.println("Continue on to site.");
		}
	}
	
	
	public void _search_text(){
		_Text_Search.click();
		_Text_Search.sendKeys("GOOG");
		_Text_Search.submit();
	}
	
	public List<WebElement> _read_table(WebElement ele)
	{
		return ele.findElements(By.tagName("tr"));
	
	}
	
	public Pair<String, String> _read_table_col_rows(WebDriver d, WebElement ele, int col, int row)
	{
		
		Pair<String, String> simplePair = null;
		String indice_name = null, indice_val = null;
		Actions builder = new Actions(d);
		int row_count = 0; 
		List<WebElement> obj_rows = _read_table(ele);
		
		for(WebElement tr : obj_rows)
		{
    		if(row_count == row)
    		{
    			builder.moveToElement(tr.findElements(By.tagName("a")).get(0)).perform();

    			System.out.println(tr.findElements(By.tagName("a")).get(0).getText());

    			System.out.println(tr.findElements(By.tagName("td")).get(col + 1).getText());
    			 indice_name = tr.findElements(By.tagName("a")).get(0).getText().toString();
    			 indice_val = tr.findElements(By.tagName("td")).get(col + 1).getText().toString();
    			 simplePair = new Pair<>(indice_name, indice_val);
    		}
    		row_count++;
		}
		
		
		return simplePair;
	}
	
	
	public void _Click_Link_Register(){
		_Link_Register.click();	
	}
	
	public void _Enter_FirstName(String str_FirstName){
		
		_Text_FirstName.sendKeys(str_FirstName);
	}
	
	public void _Enter_LastName(String str_LastName){
		_Text_LastName.sendKeys(str_LastName);
	}

	public void _Enter_Phone_Area(String str_PhoneArea){
		_Text_Phone_Area.sendKeys(str_PhoneArea);
	}
	
	public void _Enter_Phone_Number(String str_PhoneNumber){
		_Text_Phone_Number.sendKeys(str_PhoneNumber);
	}
	
	public void _Select_Country(String str_Country)
	{
		Select dropdown_Country = new Select(_Select_Country);
		dropdown_Country.selectByVisibleText(str_Country);
	}
	
	public void _Enter_Email(String str_Email){
		_Text_Email.sendKeys(str_Email);
	}
	
	//public void _Enter_Verify_Email(String str_Email){
	//	_Text_Verify_Email.sendKeys(str_Email);
	//}
	
	public void _Enter_Password(String str_Password){
		_Text_Password.sendKeys(str_Password);
	}
	
	public void _Select_CheckBox_Agree_To_Terms_Conditions(){
		_CheckBox_Agree_To_Terms_Conditions.click();
	}
	
	public void _Click_Register(){
		_Button_Register.click();
	}
	

	
}
