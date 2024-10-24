package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.CheckOut_Page_One;
import pages.InventoryPage;
import pages.Login;

public class CheckOut_Page_One_Test extends TestBase
{
	Login login;
	InventoryPage invent;
	Cart_Page cart;
	CheckOut_Page_One check;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		initialization();
		login=new Login();
		login.loginToApplication();
		invent=new InventoryPage();
		invent.add6Products();
		invent.clickonCartIcon();
		cart=new Cart_Page();
		cart.verifyCheckOutBtn();
		check=new CheckOut_Page_One();	
	}
	@Test(groups = "Sanity")
	public void verifyCheckLabelTest()
	{
		String expLabel="Checkout: Your Information";
		String actLabel=check.verifyCheckLabel();
		Assert.assertEquals(expLabel, actLabel);
	}
	@Test(groups = "Sanity")
	public void InputInformation()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=check.InputInformation();
		Assert.assertEquals(expURL, actURL);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}

}
