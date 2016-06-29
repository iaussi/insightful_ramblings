package selenium;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.collections.Pair;


public class TestInvestingSearchPage {
	public WebDriver Driver;
	
    @BeforeSuite
    public void init(){
    	DriverFactory d = new DriverFactory();
    	Driver = d.getDriver("IE");
    }

    @AfterSuite
    public void clearUp() {
    	Driver.quit();
    }

    @Test
    public void testInvestingRegister() {
          	
    	String str_FName = null, str_LName = null, str_Email = null, str_Password = null, str_Phone = null, str_Country = null;
    	//, str_Gender = null;

    	Driver.navigate().to("http://www.investing.com");
        
        InvestingSearchPage page = PageFactory.initElements(Driver, InvestingSearchPage.class);

    	File file = new File("F:\\workspace\\Investing\\src\\XML\\user.xml");
        
        try
        {
		JAXBContext jaxbContext = JAXBContext.newInstance(NewUserInfo.class);
		 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		NewUserInfo user = (NewUserInfo) jaxbUnmarshaller.unmarshal(file);

			
		str_FName = user.getFName();
		str_LName = user.getLName();
		str_Email = user.getEmail();
		str_Password = user.getPassword();
		str_Phone = user.getPhone();
		str_Country = user.getCountry();
		//str_Gender = user.getGender();
				
        }
        catch(JAXBException ex) 
        {
    		ex.printStackTrace();
        }
        
       
        
        page._click_Continue_To_Site();
        //page._Click_Link_Register();
        
        Driver.findElement(By.linkText("Register")).click();
        
        page._Enter_FirstName(str_FName);
        page._Enter_LastName(str_LName);
        page._Select_Country(str_Country);
        page._Enter_Phone_Area(str_Phone.substring(3, 6));
        page._Enter_Phone_Number(str_Phone.substring(8, 15));
        page._Enter_Email(str_Email);
        page._Enter_Password(str_Password);
        
        page._Select_CheckBox_Agree_To_Terms_Conditions();
        
        Driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        
        //page._Click_Register();
        
    }
    
    
    @Test
    public void testInvestingReadColumns() 
    {
    	Pair<String, String> KeyPair1 = null;
    	Pair<String, String> KeyPair2 = null;
   	
       	Driver.navigate().to("http://www.investing.com");
        
        InvestingSearchPage page = PageFactory.initElements(Driver, InvestingSearchPage.class);  
       
        try
        {
        	Thread.sleep(1000);
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }
        //page._click_Continue_To_Site();
        //page._Click_Link_Register();
 
        
        WebElement IndiceTable = Driver.findElement(By.cssSelector(".genTbl.openTbl.quotesSideBlockTbl.collapsedTbl"));
        int RowCount = IndiceTable.findElements(By.tagName("tr")).size();
        int i = 0;
        
        
        while( i < RowCount-1)
        {
        	KeyPair1 = page._read_table_col_rows(Driver,IndiceTable, 1, i);
        	KeyPair2 = page._read_table_col_rows(Driver,IndiceTable, 2, i);

        	if(KeyPair1.first().contains("Nikkei 225"))
        	{
        		Assert.assertEquals(KeyPair1, new Pair<>("Nikkei 225", "20,544.18"));
        		Assert.assertEquals(KeyPair2, new Pair<>("Nikkei 225", "-25.69"));
        	}
        	
        	i++;
        }
        
        
    }
}