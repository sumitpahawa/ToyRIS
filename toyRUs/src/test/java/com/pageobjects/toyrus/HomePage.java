package com.pageobjects.toyrus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id='hdrSection2']/ul/li[6]/div/div[2]")
	WebElement MyAccount_SingIn_ItemList;
	@FindBy(xpath="//*[@id='kw']") 
	private WebElement searchTextBox;

	@FindBy(xpath="//*[@id='hdrSection2']/ul/li[2]/a")
	private WebElement babyRegistryLink;

	@FindBy(xpath="//*[@id='hdrSection2']/ul/li[3]/a")
	private WebElement wishListLink;


	@FindBy(xpath="//*[@id='hdrSection2']/ul/li[4]/a")
	private WebElement giftCardsLink;

	@FindBy(xpath="//*[@id='hdrSection2']/ul/li[5]/a")
	private WebElement giftFinderLink;

	@FindBy(xpath="//*[@id='hdrWelcomeLoginText']")
	private WebElement myAccount_signInLink;

Actions act ;
	public WishListPage clickOnBayRegistryLink(){

		if(wishListLink.isDisplayed()||wishListLink.isEnabled())
			wishListLink.click();
		return new WishListPage();

	}

	public BabyRegistryPage clickOnBabyRegistryLink(){

		if(babyRegistryLink.isDisplayed()||babyRegistryLink.isEnabled())
			babyRegistryLink.click();
		return new BabyRegistryPage();
	}


	public GiftCardsPage clickOnGiftCardsLink(){

		if(giftCardsLink.isDisplayed()||giftCardsLink.isEnabled())
			giftCardsLink.click();
		return new GiftCardsPage();

	}

	public GiftFinderPage clickOnGiftFinderLink(){

		if(giftFinderLink.isDisplayed()||giftFinderLink.isEnabled())
			giftFinderLink.click();
		return new GiftFinderPage();

	}

	public boolean clickOnMyAccount_SignInLink(){

		if(myAccount_signInLink.isDisplayed()||myAccount_signInLink.isEnabled())
			return true;
		else
			return false;


	}

	public boolean search(String searchText){
		if(searchTextBox.isDisplayed()||searchTextBox.isEnabled())
			searchTextBox.clear();
		searchTextBox.sendKeys(searchText,Keys.ENTER);
		if(driver.getCurrentUrl().contains(searchText))
			return true;
		else 
			return false;
	}

	public boolean selectOptionFromMyAcoount_SignInList(String itemName){

		if(clickOnMyAccount_SignInLink()){
			act=new Actions(driver);
			act.moveToElement(myAccount_signInLink).build().perform();
			List<WebElement> menuItems = MyAccount_SingIn_ItemList.findElements(By.tagName("a"));
			for (WebElement name:menuItems){
				if(name.getText().equals(itemName)){
					name.click();
					break;
				}
			}
			return true;

		}
		return false;

	}

	public SignInPage clickonSignInLink(){
		selectOptionFromMyAcoount_SignInList("Sign In");
			return new SignInPage(driver);			
	}

}
