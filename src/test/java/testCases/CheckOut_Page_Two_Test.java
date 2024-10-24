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
import pages.InventoryPage;
import pages.Login;

public class CheckOut_Page_Two_Test extends TestBase
{
	Login login;
	InventoryPage invent;
	Cart_Page cart;
	CheckOut_Page_One check;
	CheckOut_Page_Two check2;
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
	}
	@Test
	public void verifyURLTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=check2.verifyURL();
		Assert.assertEquals(expURL,actURL);
	}
	@Test
	public void verifyTitleTest()
	{
		String expTitle="Swag Labs";
		String actTitle=check2.verifyTitle();
		Assert.assertEquals(expTitle,actTitle);
	}
	@Test
	public void verifyLabelTest()
	{
		boolean result=check2.verifyLabel();
		Assert.assertEquals(result,true);
	}
	@Test
	public void verifyQTYTest()
	{
		String expTitle="QTY";
		String actTitle=check2.verifyQTY();
		Assert.assertEquals(expTitle,actTitle);
	}
	@Test
	public void cancelBtnTest()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=check2.cancelBtn();
		Assert.assertEquals(expURL,actURL);
	}
	@Test
	public void finishBtn()
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=check2.finishBtn();
		Assert.assertEquals(expURL,actURL);
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
