package com.pageobjects.toyrus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Two {
	WebDriver driver;
	@Test
	public static void main(String args[]){


		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.toysrus.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
/*		List<WebElement> links =driver.findElements(By.tagName("a"));
		int count = links.size();
		System.out.println(count);
		for (WebElement link : links){
			System.out.println(link.getText());
			if(link.getText().equalsIgnoreCase("Wish List"))
				link.click();

		}*/
		
		WebElement ele= driver.findElement(By.xpath("//*[@id='hdrSection2']/ul/li[5]/a"));
		Actions action = new Actions(driver);
		action.contextClick(ele.findElement(By.xpath("//*[@id='hdrSection2']/ul/li[5]/div/div[2]"))).perform();
	
	}

}


