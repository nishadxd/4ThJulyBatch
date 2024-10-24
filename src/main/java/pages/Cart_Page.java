package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import utility.HandleDropDownList;
import utility.ReadData;

public class Cart_Page extends TestBase
{
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement cartMenuBtn;
	@FindBy(xpath="//title[text()='Swag Labs']") private WebElement cartTitle;
	@FindBy(xpath="//span[text()='Your Cart']") private WebElement cartLabel;
	@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement cartQty;
	@FindBy(xpath="//div[@class='cart_desc_label']") private WebElement cartDesc;
	@FindBy(xpath="//div[@class='cart_quantity']")private WebElement cartQuantity;
	@FindBy(xpath="//div[@class='inventory_item_name']") private WebElement cartItemName;
	@FindBy(xpath="//div[@class='inventory_item_desc']") private WebElement cartItemNameDesc;
	@FindBy(xpath="//div[@class='inventory_item_price']") private WebElement cartItemPrice;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement cartAddItem;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement cartRemoveBtn;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath="//button[@class='btn btn_secondary back btn_medium']") private WebElement cartContinueBtn;
	@FindBy(xpath="//button[@class='btn btn_action btn_medium checkout_button ']") private WebElement checkoutBtn;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement cartTwitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement cartFbLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement cartLinkedinLogo;
	@FindBy(xpath="//div[@class='footer_copy']") private WebElement cartFooter;
	public Cart_Page()
	{
		PageFactory.initElements(driver, this);
	}
	/*public String verifyCartMenuBtn() throws InterruptedException
	{
		HandleDropDownList.handlelistBox(cartMenuBtn,"About");
		Thread.sleep(3000);
		return driver.getCurrentUrl(); //https://saucelabs.com/
	}*/
	public String verifyCartURL()
	{
		return driver.getCurrentUrl(); //"https://www.saucedemo.com/cart.html"
	}
	public String verifyCartTitle()
	{
		return driver.getTitle(); //"Swag Labs"
	}
	public String verifyCartLabel()
	{
		return cartLabel.getText(); //"Your Cart"
	}
	public String verifyCartQty()
	{
		return cartQty.getText(); //"QTY"
	}
	public String verifyCartDesc()
	{
		return cartDesc.getText(); //"Description"
	}
	public String verifyCartQuantity()
	{
		return cartQuantity.getText(); //"1"
	}
	public String verifyCartItemName()
	{
		cartItemName.click();
		return driver.getCurrentUrl(); //"https://www.saucedemo.com/inventory-item.html?id=0"
	}
	/*public boolean verifyCartItemNameDesc()
	{
		return cartItemNameDesc.isDisplayed(); //"A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."
	}
	public String verifyCartItemPrice()
	{
		return cartItemPrice.getText(); //"9.99" or "$"
	}*/
	public String verifyCartRemoveBtn()
	{
		cartRemoveBtn.click();
		return cartCount.getText();
	}
	public String verifyCartContinueBtn()
	{
		cartContinueBtn.click();
		return driver.getCurrentUrl(); //"https://www.saucedemo.com/inventory.html"
	}
	public String verifyCheckOutBtn()
	{
		checkoutBtn.click();
		return driver.getCurrentUrl(); //"https://www.saucedemo.com/checkout-step-one.html"
	}
	public boolean verifyCartTwitterLogo()
	{
		return cartTwitterLogo.isDisplayed();
	}
	public boolean verifyCartFbLogo()
	{
		return cartFbLogo.isDisplayed();
	}
	public boolean verifyCartLinkedinLogo()
	{
		return cartLinkedinLogo.isDisplayed();
	}
	public String verifyCartFooter()
	{
		return cartFooter.getText(); // " Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"
	}

}
