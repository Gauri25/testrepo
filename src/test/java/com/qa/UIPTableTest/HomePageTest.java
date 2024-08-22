package com.qa.UIPTableTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.qa.UIPtablepages.HomePage;
import com.qa.uiptable.factory.PlaywrightFactory;
public class HomePageTest {
	PlaywrightFactory pf = new PlaywrightFactory();
	//PlaywrightFactory pf;
	private Page page;
	HomePage homePage;
	@BeforeTest
	public void setup()
	{
		 Page page = pf.intiBrowser("chrome");
		  
		//pf=new PlaywrightFactory();
		//pf.intiBrowser("chromium");
		homePage=new HomePage(page);
	}
	@Test
	public void homePageTitleTest()
	{
		String Actualtitle=homePage.getHomePageTitle();
		Assert.assertEquals(Actualtitle, "React App");
	}
	@Test
	public void creatingGroup() throws InterruptedException
	{
		String Actualdatagropby=homePage.createGroup();
		Assert.assertEquals(Actualdatagropby,"Name" );
		
		
	}
	/*@AfterTest
	public void tearDown()
	{
		//BrowserContext context = pf.getBrowserContext();
		//page.context().browser().close();
		//page.context().browser().close();
		//pf.close();
		
	}*/
	

}
