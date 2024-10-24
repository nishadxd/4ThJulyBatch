package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOut_Page_One extends TestBase
{
	//object repository
	@FindBy(xpath="//span[text()='Checkout: Your Information']") private WebElement checkLabel;
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstNameTxtBox;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastNameTxtBox;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement zipCodeTxtBox;
	@FindBy(xpath="//input[@id='continue']") private WebElement continueBtn;
	
	public CheckOut_Page_One()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyCheckLabel()
	{
		return checkLabel.getText();
	}
	public String InputInformation()
	{
		firstNameTxtBox.sendKeys("Harry");
		lastNameTxtBox.sendKeys("Potter");
		zipCodeTxtBox.sendKeys("441123");
		continueBtn.click();
		return driver.getCurrentUrl(); //https://www.saucedemo.com/checkout-step-two.html
	}

}
