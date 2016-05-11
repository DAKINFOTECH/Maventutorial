package com.dakinfotech.maventutorialtutor;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FlightBooking {
	WebDriver driver;
	Flightlib config=new Flightlib();
	String pass1="1";
	String pass2="2";
	String pass3="3";
	String pass4="4";
	
//Registration Test.	  
@Test(priority=0,dataProvider="Regiss")
 public void regtest(String name1,String name2,String pnone,String username,String address1,
		              String address2,String city,String state,String pincode,String country,
		              String email,String passwd1,String passwd2) throws InterruptedException 
		{
	    driver=new FirefoxDriver();
        driver.get("http://newtours.demoaut.com/");
        driver.manage().window().maximize();
		driver.findElement(By.linkText("REGISTER")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("firstName")).sendKeys(name1);
		driver.findElement(By.name("lastName")).sendKeys(name2);
		driver.findElement(By.name("phone")).sendKeys(pnone);
		driver.findElement(By.id("userName")).sendKeys(username);
		driver.findElement(By.name("address1")).sendKeys(address1);
		driver.findElement(By.name("address2")).sendKeys(address2);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(pincode);
		Select countryname=new Select(driver.findElement(By.name("country")));
		countryname.selectByVisibleText(country);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(passwd1);
		driver.findElement(By.name("confirmPassword")).sendKeys(passwd2);
		driver.findElement(By.name("register")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("SIGN-OFF")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.close();
		
 }
//Flight booking Test.
@Test(priority=1,dataProvider="Flbook")
public void flightbooking(String usrname,String password,String trip,String pass,String fport,String fmonth,String fday,
		                  String tport,String tmonth,String tday,String srvclass,String airbus,String oflight,String iflight,
		                  String pfname,String plname,String meeals,String cccard,String ccnum,String ccmonth,String ccyear,
		                  String first,String middle,String last,String add1,String add2,String city,String state,String pincode,
		                  String contry,String pfname1,String plname1,String meeals1,String pfname2,String plname2,String meeals2,
		                  String pfname3,String plname3,String meeals3) throws InterruptedException {
	    //Login Page
	    driver=new FirefoxDriver();
        driver.get("http://newtours.demoaut.com/");
        driver.manage().window().maximize();
		driver.findElement(By.name("userName")).sendKeys(usrname);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Flight book
		config.rdclick(driver,"tripType", trip);
		Select passenger=new Select(driver.findElement(By.name("passCount")));
		passenger.selectByValue(pass);
		Select Dform=new Select(driver.findElement(By.name("fromPort")));
		Dform.selectByValue(fport);
		Select Dmonth=new Select(driver.findElement(By.name("fromMonth")));
		Dmonth.selectByValue(fmonth);
		Select Dday=new Select(driver.findElement(By.name("fromDay")));
		Dday.selectByValue(fday);
		Select Aform =new Select(driver.findElement(By.name("toPort")));
		Aform.selectByValue(tport);
		Select Amonth=new Select(driver.findElement(By.name("toMonth")));
		Amonth.selectByValue(tmonth);
		Select Aday=new Select(driver.findElement(By.name("toDay")));
		Aday.selectByValue(tday); 
		config.rdclick(driver,"servClass", srvclass); 
		Select Airways=new Select(driver.findElement(By.name("airline")));
		Airways.selectByVisibleText(airbus);		
		driver.findElement(By.name("findFlights")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Flight Details
		config.rdclick(driver,"outFlight",oflight);
		config.rdclick(driver,"inFlight",iflight);
		driver.findElement(By.name("reserveFlights")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Payment  
		//Passenger information
		/*Start*/
		if(pass.contentEquals(pass1)){
		driver.findElement(By.name("passFirst0")).sendKeys(pfname);
		driver.findElement(By.name("passLast0")).sendKeys(plname);
		Select Meal=new Select(driver.findElement(By.name("pass.0.meal")));
		Meal.selectByVisibleText(meeals);
		}else if(pass.contentEquals(pass2)){
		driver.findElement(By.name("passFirst0")).sendKeys(pfname);
		driver.findElement(By.name("passLast0")).sendKeys(plname);
		Select Meal=new Select(driver.findElement(By.name("pass.0.meal")));
		Meal.selectByVisibleText(meeals);
		driver.findElement(By.name("passFirst1")).sendKeys(pfname1);
		driver.findElement(By.name("passLast1")).sendKeys(plname1);
		Select Meal1=new Select(driver.findElement(By.name("pass.1.meal")));
		Meal1.selectByVisibleText(meeals1);
		}else if(pass.contentEquals(pass3)){
		driver.findElement(By.name("passFirst0")).sendKeys(pfname);
		driver.findElement(By.name("passLast0")).sendKeys(plname);
		Select Meal=new Select(driver.findElement(By.name("pass.0.meal")));
		Meal.selectByVisibleText(meeals);
		driver.findElement(By.name("passFirst1")).sendKeys(pfname1);
		driver.findElement(By.name("passLast1")).sendKeys(plname1);
		Select Meal1=new Select(driver.findElement(By.name("pass.1.meal")));
		Meal1.selectByVisibleText(meeals1);
		driver.findElement(By.name("passFirst2")).sendKeys(pfname2);
		driver.findElement(By.name("passLast2")).sendKeys(plname2);
		Select Meal2=new Select(driver.findElement(By.name("pass.2.meal")));
		Meal2.selectByVisibleText(meeals2);
		}else if(pass.contentEquals(pass4)){
		driver.findElement(By.name("passFirst0")).sendKeys(pfname);
		driver.findElement(By.name("passLast0")).sendKeys(plname);
		Select Meal=new Select(driver.findElement(By.name("pass.0.meal")));
		Meal.selectByVisibleText(meeals);
		driver.findElement(By.name("passFirst1")).sendKeys(pfname1);
		driver.findElement(By.name("passLast1")).sendKeys(plname1);
		Select Meal1=new Select(driver.findElement(By.name("pass.1.meal")));
		Meal1.selectByVisibleText(meeals1);
		driver.findElement(By.name("passFirst2")).sendKeys(pfname2);
		driver.findElement(By.name("passLast2")).sendKeys(plname2);
		Select Meal2=new Select(driver.findElement(By.name("pass.2.meal")));
		Meal2.selectByVisibleText(meeals2);
		driver.findElement(By.name("passFirst3")).sendKeys(pfname3);
		driver.findElement(By.name("passLast3")).sendKeys(plname3);
		Select Meal3=new Select(driver.findElement(By.name("pass.3.meal")));
		Meal3.selectByVisibleText(meeals3);
		}/*End*/
		Select Card=new Select(driver.findElement(By.name("creditCard")));
		Card.selectByVisibleText(cccard);
		driver.findElement(By.name("creditnumber")).sendKeys(ccnum);
		Select Expdate=new Select(driver.findElement(By.name("cc_exp_dt_mn")));
		Expdate.selectByVisibleText(ccmonth);
		Select Expyear=new Select(driver.findElement(By.name("cc_exp_dt_yr")));
		Expyear.selectByVisibleText(ccyear);
		driver.findElement(By.name("cc_frst_name")).sendKeys(first);
		driver.findElement(By.name("cc_mid_name")).sendKeys(middle);
		driver.findElement(By.name("cc_last_name")).sendKeys(last);
		driver.findElement(By.name("ticketLess")).click();
		driver.findElement(By.name("billAddress1")).clear();
		driver.findElement(By.name("billAddress1")).sendKeys(add1);
		driver.findElement(By.name("billAddress2")).sendKeys(add2);
		driver.findElement(By.name("billCity")).clear();
		driver.findElement(By.name("billCity")).sendKeys(city);
		driver.findElement(By.name("billState")).clear();
		driver.findElement(By.name("billState")).sendKeys(state);
		driver.findElement(By.name("billZip")).clear();
		driver.findElement(By.name("billZip")).sendKeys(pincode);
		Select Country=new Select(driver.findElement(By.name("billCountry")));
		Country.selectByVisibleText(contry);
		driver.findElement(By.xpath("(.//input[@name='ticketLess'])[2]")).click();
		driver.findElement(By.name("buyFlights")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//E-ticket Scroll Down
		JavascriptExecutor javascript = (JavascriptExecutor) driver;  
		javascript.executeScript("window.scrollBy(0,900)", "");
		//Screenshot
		config.captureScreenshot(driver, pfname+"Eticket");
		Thread.sleep(2000);
		driver.findElement(By.linkText("SIGN-OFF")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.close();
}
//Data provider for Registration.
@DataProvider(name="Regiss")
  public Object[][] passData(){
  config.Excelpath("C:\\Users\\arunkavi\\git\\Maventutorial\\com.dakinfotech.maventutorial\\src\\main\\resources\\Injectfile.xls",0);
  int rows=config.Excelcount();
  int roww=rows-1;
  Object[][] data=new Object[roww][13];
  for(int i=1;i<rows;i++)
  {
	  for(int j=0;j<13;j++){
		int k=i-1;  
 	    data[k][j]=config.Exceldata(i, j);
   	  }
  }

  return data;
  }
//Data provider for Flight booking.
@DataProvider(name="Flbook")
public Object[][] passData1(){
config.Excelpath("C:\\Users\\arunkavi\\git\\Maventutorial\\com.dakinfotech.maventutorial\\src\\main\\resources\\Injectfile.xls",1);
int rows=config.Excelcount();
int roww=rows-1;
Object[][] data1=new Object[roww][39];
for(int i=1;i<rows;i++)
{
	  for(int j=0;j<39;j++){
		int k=i-1;  
	    data1[k][j]=config.Exceldata(i, j);
 	  }
}

return data1;
}
	
//It will take failure screenshots
  @AfterMethod
  public void tearDown(ITestResult result){
	  if(ITestResult.FAILURE==result.getStatus())
	  {
		  config.captureScreenshot(driver,result.getName());
	  }
  }


}
