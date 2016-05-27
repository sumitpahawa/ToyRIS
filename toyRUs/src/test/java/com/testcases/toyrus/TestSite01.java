package com.testcases.toyrus;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageobjects.toyrus.HomePage;
import com.pageobjects.toyrus.SignInPage;
import com.testbase.toyrus.TestBaseSetup;

public class TestSite01 extends TestBaseSetup {
	private WebDriver driver;
	@BeforeClass
	public void setUp(){
		driver=getDriver();
	}
	
@Test
public void loginTest(){
	HomePage hp = new HomePage(driver);
	hp.clickonSignInLink();
	SignInPage sp = new SignInPage(driver);
	sp.SignInAction("s.pahawa@gmail.com", "Sum@2506");
}



}
