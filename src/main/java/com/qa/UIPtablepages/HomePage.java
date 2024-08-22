package com.qa.UIPtablepages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;

public class HomePage {

	//String locators (Object repository )
	Page page;
	
	private String dataGrouping ="//button[normalize-space()='Data Grouping']";
	private String createGroup="//button[normalize-space()='Craete Group']";
	private String dataGroup="//div[.='Name']";
	// Locator locator = page.locator("//div[.='Name']");
     //locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(60000)); // Wait up to 60 seconds
	
	//Page.SelectOptionOptions(selector:"#Group By",values:"Name");
	
	//page constructor 
	public HomePage(Page page)
	{
		this.page=page;
	}
	
	public String getHomePageTitle() {
		String title= page.title();
		System.out.println("Page title: ");
		return title;
	}

	public String getHomePageURL() {
		
		String url=page.url();
		System.out.println("Page url :"+url);
		return url;
	}
	public String createGroup() throws InterruptedException
	{
		page.click("//button[normalize-space()='Data Grouping']");
		page.click("select.dg-select-input-box");
		page.selectOption("select.dg-select-input-box", new SelectOption().setValue("Name"));

		
		//Locator loc=page.locator("select.dg-select-input-box:has(option[value='Name'])");
		//loc.wait(60000);
		//loc.allInnerTexts().forEach(e->System.out.println(e));
		//loc.click();
		//loc.wait(60000);
		 Locator createGroupLocator = page.locator("//button[normalize-space()='Craete Group']");  // Replace with the actual selector for the createGroup button
         createGroupLocator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(60000));

         // Click the 'createGroup' button
         createGroupLocator.click();
		//page.click(createGroup);
		String datagropby= page.textContent(dataGroup);
		// Locator locator = page.locator("//div[.='Name']");
		//datagropby.wait(60000); // Wait up to 60 seconds
		//System.out.println("Elements are grouped by"+datagropby)Whi;
		return datagropby;
		
	}
}
