package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class Login extends TestBase
{
	//object repository
	@FindBy(xpath = "//input[@id='user-name']") private WebElement usernameTxtBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passwordTextBox;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement loginBtn;
	public Login()
	{
		PageFactory.initElements(driver, this);
	}
	public String loginToApplication() throws IOException
	{
		logger=report.createTest("Login into the sauce lab Application");
		usernameTxtBox.sendKeys(ReadData.readPropertyFile("Username"));
		logger.log(Status.INFO,"User name is entered");
		passwordTextBox.sendKeys(ReadData.readPropertyFile("Password"));
		logger.log(Status.INFO,"Password is entered");
		loginBtn.click();
		logger.log(Status.INFO,"Login button is clicked");
		logger.log(Status.PASS,"Login Successfull");
		return driver.getCurrentUrl(); //https://www.saucedemo.com/inventory.html
	}
	public String verifyMultiCreds(String un, String password)
	{
		usernameTxtBox.sendKeys(un);
		passwordTextBox.sendKeys(password);
		loginBtn.click();
		return driver.getCurrentUrl(); //https://www.saucedemo.com/inventory.html
	}
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
	}
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
	}

}
