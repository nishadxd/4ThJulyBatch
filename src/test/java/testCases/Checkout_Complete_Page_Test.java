package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.CheckOut_Page_One;
import pages.CheckOut_Page_Two;
import pages.Checkout_Complete_Page;
import pages.InventoryPage;
import pages.Login;

public class Checkout_Complete_Page_Test extends TestBase
{
	Login login;
	InventoryPage invent;
	Cart_Page cart;
	CheckOut_Page_One check;
	CheckOut_Page_Two check2;
	Checkout_Complete_Page last;
	@BeforeMethod
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
		check.InputInformation();
		check2=new CheckOut_Page_Two();
		check2.finishBtn();
		last=new Checkout_Complete_Page();
	}
	@Test
	public void verifyLastPageURL()
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=last.verifyLastPageURL();
		Assert.assertEquals(expURL,actURL);
	}
	@Test
	public void verifyLastPageTitle()
	{
		String expTitle="Swag Labs";
		String actTitle=last.verifyLastPageTitle();
		Assert.assertEquals(expTitle,actTitle);
	}
	@Test
	public void verifyLastPageLabel()
	{
		String expLabel="Checkout: Complete!";
		String actLabel=last.verifyLastPageLabel();
		Assert.assertEquals(expLabel,actLabel);
	}
	@Test
	public void verifyPony()
	{
		boolean result=last.verifyPony();
		Assert.assertEquals(result,true);
	}
	@Test
	public void verifyBackHomeBtn1()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=last.verifyBackHomeBtn1();
		Assert.assertEquals(expURL,actURL);
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	

}
