package com.testbase.toyrus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class TestBaseSetup {

	private WebDriver driver;

	public WebDriver getDriver(){
		return driver;
	}


	public void setDriver(String browserType ,String appURL){
		switch (browserType){

		case "Firefox":
			driver=initFirefoxDriver(appURL);
			break;
		case "IE":
			driver=initFirefoxDriver(appURL);
			break;
		case "Chrome":
			driver=initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("Wrong Browser Type Sellction ,So Lsunching spp in Firefox browser");
			driver=initFirefoxDriver(appURL);
		}


	}

	public static WebDriver initIEDriver(String appURL){
		System.getProperty("D:\\drivers\\IEDriverServer.exe");
		WebDriver driver= new InternetExplorerDriver();
		EventFiringWebDriver edriver= new EventFiringWebDriver(driver);
		edriver.manage().window().maximize();
		edriver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		return edriver;
	}
	public static WebDriver initChromeDriver(String appURL){
		System.getProperty("D:\\drivers\\IEDriverServer.exe");
		WebDriver driver= new ChromeDriver();
		EventFiringWebDriver edriver= new EventFiringWebDriver(driver);
		edriver.manage().window().maximize();
		edriver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		return edriver;
	}
	public static WebDriver initFirefoxDriver(String appURL){
		WebDriver driver= new FirefoxDriver();
		EventFiringWebDriver edriver= new EventFiringWebDriver(driver);
		edriver.manage().window().maximize();
		edriver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		return edriver;
	}
@Parameters({"browserType","appURL"})
	@BeforeClass
	public void initializeTestBaseSetUp(String browserType, String appURL){
		try{
			setDriver(browserType,appURL);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
    @AfterClass
	public void tearDown(){
		driver.quit();
	}
}
