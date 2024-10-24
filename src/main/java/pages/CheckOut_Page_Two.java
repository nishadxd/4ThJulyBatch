package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOut_Page_Two extends TestBase
{
	//object repository
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement verifyTitle;
	@FindBy(xpath="//span[text()='Checkout: Overview']") private WebElement verifyLabel;
	@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement verifyQTY;
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancelBtn;
	@FindBy(xpath="//button[@id='finish']") private WebElement finishBtn;
	
	public CheckOut_Page_Two()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyURL()
	{
	    return driver.getCurrentUrl();
	}
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	public boolean verifyLabel()
	{
		return verifyLabel.isDisplayed();
	}
	public String verifyQTY()
	{
		return verifyQTY.getText(); //QTY
	}
	public String cancelBtn()
	{
		cancelBtn.click();
		return driver.getCurrentUrl();
	}
	public String finishBtn()
	{
		finishBtn.click();
		return driver.getCurrentUrl();
	}

}
