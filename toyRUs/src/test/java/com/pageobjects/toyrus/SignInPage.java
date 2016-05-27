package com.pageobjects.toyrus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	private WebDriver driver;
	public SignInPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='emailId']")
	WebElement email_txtbox;
	@FindBy(xpath="//*[@id='passwd']")
	WebElement password_txtbox;
	@FindBy(xpath="//*[@id='container']/table[3]/tbody/tr/td[1]/table/tbody/tr[2]/td/input[3]")
	WebElement signIn_btn;
	@FindBy(xpath="//*[@id='container']/table[3]/tbody/tr/td[1]/table/tbody/tr[2]/td/a")
	WebElement forgot_password_link;

	public MyAccountPage SignInAction(String emailId,String password){
		if(email_txtbox.isEnabled())
			email_txtbox.sendKeys(emailId);
		if(password_txtbox.isEnabled())
			password_txtbox.sendKeys(password);
		if(signIn_btn.isEnabled())
			signIn_btn.click();
		return new MyAccountPage();
	}


}
