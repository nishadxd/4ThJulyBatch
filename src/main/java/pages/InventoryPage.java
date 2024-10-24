package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropDownList;

public class InventoryPage extends TestBase
{
	//object repository
	//add product
	@FindBy(xpath="//span[text()='Products']")private WebElement productLabel;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-backpack']") private WebElement backpackProduct;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-bike-light']") private WebElement bikelightProduct;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement tshirtProduct;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-fleece-jacket']") private WebElement jacketProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesieProduct;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement redTshirtProduct;
	//remove product
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement removebackpackProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement removebikelightProduct;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement dropdownlistBox;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cartIcon;
	public InventoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyTitleOfInventoryPage()
	{
		return driver.getTitle();
	}
	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	public String add6Products()
	{
		HandleDropDownList.handlelistBox(dropdownlistBox, "Price (low to high)");
		backpackProduct.click();
		bikelightProduct.click();
		tshirtProduct.click();
		jacketProduct.click();
		onesieProduct.click();
		redTshirtProduct.click();
		return cartCount.getText();
		
	}
	public String remove2Products()
	{
		add6Products(); //calling add product method
		removebackpackProduct.click();
		removebikelightProduct.click();
		return cartCount.getText();
	}
	public void clickonCartIcon()
	{
		cartIcon.click();
	}

}
