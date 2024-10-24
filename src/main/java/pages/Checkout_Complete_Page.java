package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Complete_Page extends TestBase
{
	//object repository
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement verifyLastPageTitle;
	@FindBy(xpath="//span[@class='title']") private WebElement verifyLastPageLabel;
	@FindBy(xpath="//img[@alt='Pony Express']") private WebElement verifyPony;
	@FindBy(xpath="//button[@id='back-to-products']") private WebElement verifyBackHomeBtn1;
	
	public Checkout_Complete_Page()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyLastPageURL()
	{
	    return driver.getCurrentUrl();
	}
	public String verifyLastPageTitle()
	{
		return driver.getTitle();
	}
	public String verifyLastPageLabel()
	{
		return verifyLastPageLabel.getText();
	}
	public boolean verifyPony()
	{
		return verifyPony.isDisplayed();
	}
	public String verifyBackHomeBtn1()
	{
		verifyBackHomeBtn1.click();
		return driver.getCurrentUrl();
	}

}
