package com.adactin.Mobileapphoteladactin1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import com.adactin.Mobileapphoteladactin1.base.BaseClass;
import com.adactin.Mobileapphoteladactin1.util.ExcelUtil;
import com.adactin.Mobileapphoteladactin1.util.Log;

import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.HideKeyboardStrategy;
import io.appium.java_client.ios.IOSDriver;
public class Book_Hotel extends BaseClass{

	public Book_Hotel() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
/**
 * Method to enter the booking details to the Book Hotel page
 * Clicks on Book now after all the fields are entered
 * @param i row number
 * @throws Exception
 */
	public void enterBookingDetails(int i) throws Exception
	{

		String xpath_scrollable="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]";
		
		//String xpath_month="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]";
		//String xpath_year="//XCUIElementTypeApplication[@name=\"Adactin Hotel App”]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]";
		String xpath_year="//XCUIElementTypeApplication[@name=\"Adactin Hotel App\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]\n" + "";
		String fname=ExcelUtil.getCellData(i,15);
		String lname=ExcelUtil.getCellData(i,16);
		String billaddress=ExcelUtil.getCellData(i,17);
		String ccnumber=ExcelUtil.getCellData(i,18);
		String cctype=ExcelUtil.getCellData(i,19);
		//String ccexpiry=ExcelUtil.getCellData(i,20);
		String cvvnumber=ExcelUtil.getCellData(i,21);
		
		iOSScrollDown(xpath_scrollable);
		iOSScrollDown(xpath_scrollable);
		
		MobileElement firstName=(MobileElement)driver.findElement(By.name("Enter First Name"));
		firstName.click();
		firstName.sendKeys(fname);
		
		MobileElement lastName=(MobileElement)driver.findElement(By.name("Enter Last Name"));
		lastName.click();
		lastName.sendKeys(lname);
		lastName.sendKeys(Keys.RETURN);
		
		MobileElement billingAddress=(MobileElement)driver.findElement(By.name("Enter Billing Address"));
		billingAddress.click();
		billingAddress.sendKeys(billaddress);
		
		
		iOSScrollDown(xpath_scrollable);
		
		MobileElement CCNumber=(MobileElement)driver.findElement(By.name("Enter Card Number"));
		CCNumber.click();
		CCNumber.sendKeys(ccnumber);

		
		//iOSScrollToElement(xpath_scrollable);
		
		MobileElement CCType=(MobileElement)driver.findElement(By.name("Select Credit Card Type"));
		
		CCType.click();
		MobileElement ccard_type_option=(MobileElement) driver.findElement(By.name(cctype));
		Log.info(ccard_type_option.getText());
		ccard_type_option.click();
		
		
		MobileElement CCExpiry=(MobileElement)driver.findElement(By.name("Select Expiry Month & Year"));
		CCExpiry.click();
		iOSScrollDown(xpath_year);
		iOSScrollDown(xpath_year);
		MobileElement done_button=(MobileElement)driver.findElement(By.name("Done"));
		done_button.click();
		
		MobileElement CVV=(MobileElement)driver.findElement(By.name("Enter CVV Number"));
		CVV.click();
		CVV.sendKeys(cvvnumber);
		CVV.sendKeys(Keys.RETURN);
		
		MobileElement bookNow=(MobileElement)driver.findElement(By.name("Book Now"));
		bookNow.click();

		
	}

}
