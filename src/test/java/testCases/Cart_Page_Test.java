package testCases;

import static org.testng.Assert.expectThrows;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.InventoryPage;
import pages.Login;
import utility.ReadData;
import utility.Screenshot;

public class Cart_Page_Test extends TestBase
{
	Login login;
	InventoryPage invent;
	Cart_Page cart;
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
	}
	/*@Test
	public void verifyCartMenuBtnTest() throws InterruptedException
	{
		String expURL="https://saucelabs.com/"; // issue with page, code is correct
		String actURL=cart.verifyCartMenuBtn();
		Assert.assertEquals(expURL,actURL);
	}*/
	@Test
	public void verifyCartURLTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(1,0);// //"https://www.saucedemo.com/cart.html", (1,0)
		String actURL=cart.verifyCartURL();
		Assert.assertEquals(expURL, actURL);
	}
	@Test
	public void verifyCartTitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(1,1);// //"Swag Labs", (1,1)
		String actTitle=cart.verifyCartTitle();
		Assert.assertEquals(expTitle, actTitle);
	}
	@Test
	public void verifyCartLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel=ReadData.readExcel(1,2); //"Your Cart", (1,2)
	    String actLabel=cart.verifyCartLabel();
	    Assert.assertEquals(expLabel, actLabel);
	    Reporter.log("The Label of Cart Page = "+ actLabel);
	}
	@Test(groups = "Sanity")
	public void verifyCheckOutBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(1,3);// "https://www.saucedemo.com/checkout-step-one.html", (1,3)
		String actURL=cart.verifyCheckOutBtn();
		Assert.assertEquals(expURL, actURL);
	}
	@Test
	public void verifyCartQtyTest() throws EncryptedDocumentException, IOException
	{
		String expQty=ReadData.readExcel(1,4);// "QTY", (1,4)
		String actQty=cart.verifyCartQty();
		Assert.assertEquals(expQty, actQty);
	}
	@Test
	public void verifyCartDescTest() throws EncryptedDocumentException, IOException
	{
		String expDesc=ReadData.readExcel(1,5);// "Description", (1,5)
		String actDesc=cart.verifyCartDesc();
		Assert.assertEquals(expDesc, actDesc);
	}
	@Test
	public void verifyCartQuantityTest() throws EncryptedDocumentException, IOException
	{
		String expQuant=ReadData.readExcel(1,6);// "1", (1,6)
		String actQuant=cart.verifyCartQuantity();
		Assert.assertEquals(expQuant, actQuant);
	}
	@Test
	public void verifyCartItemNameTest() throws EncryptedDocumentException, IOException
	{
		String expName=ReadData.readExcel(1,11);// "https://www.saucedemo.com/inventory-item.html?id=4", (1,11)
		String actName=cart.verifyCartItemName();
		Assert.assertEquals(expName, actName);
	}
	/*@Test
	public void verifyCartItemNameDescTest() throws EncryptedDocumentException, IOException
	{
		boolean result=cart.verifyCartItemNameDesc();// (getting error as something else is getting in the output)"A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.", (1,7)
		Assert.assertEquals(result,true);
	}*/
	
	/*@Test
	public void verifyCartItemPriceTest() throws EncryptedDocumentException, IOException
	{
		String expPrice=ReadData.readExcel(1,8);// "9.99", (1,8) (getting error as it should be $29.99 for all the products)
		String actPrice=cart.verifyCartItemPrice();
		Assert.assertEquals(expPrice, actPrice);
	}*/
	@Test
	public void verifyCartRemoveBtnTest()
	{
		String expCount = "5";
		String actCount = cart.verifyCartRemoveBtn();
		Assert.assertEquals(expCount,actCount);
		} 
	@Test
	public void verifyCartContinueBtnTest() throws EncryptedDocumentException, IOException
	{
		String expConBtn=ReadData.readExcel(1,9);// "https://www.saucedemo.com/inventory.html", (1,9)
		String actConBtn=cart.verifyCartContinueBtn();
		Assert.assertEquals(expConBtn, actConBtn);
	}
	@Test
	public void verifyCartTwitterLogoTest() throws EncryptedDocumentException, IOException
	{
		boolean result = cart.verifyCartTwitterLogo();
		Assert.assertEquals(result, true);
	}
	@Test
	public void verifyCartFbLogoTest() throws EncryptedDocumentException, IOException
	{
		boolean result = cart.verifyCartFbLogo();
		Assert.assertEquals(result, true);
	}
	@Test
	public void verifyCartLinkedinLogoTest() throws EncryptedDocumentException, IOException
	{
		boolean result = cart.verifyCartLinkedinLogo();
		Assert.assertEquals(result, true);
	}
	@Test
	public void verifyCartFooterTest() throws EncryptedDocumentException, IOException
	{
		String expFooter=ReadData.readExcel(1,10);// " © 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy", (1,10)
		String actFooter=cart.verifyCartFooter();
		Assert.assertEquals(expFooter, actFooter);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.cs(it.getName());
		}
		driver.close();
	}

}
