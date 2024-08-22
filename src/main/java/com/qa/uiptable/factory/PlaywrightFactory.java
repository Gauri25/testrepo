package com.qa.uiptable.factory;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

public class PlaywrightFactory {
	  private Playwright playwright;
	  private Browser browser;
	  private BrowserContext browserContext;
	  private Page page;
	public Page intiBrowser(String browserName) {
		System.out.println("browser name is: " +browserName);
		 playwright = Playwright.create();
		 switch (browserName.toLowerCase()) {
         case "chromium":
             browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
             break;
         case "firefox":
             browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
             break;
         case "chrome":
             browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
             break;
         case "edge":
             browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
             break;
             
         case "edge":
             browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
             break;
         default:
             throw new IllegalArgumentException("Please pass the right browser name...");
     }
		 
		    browserContext = browser.newContext();
	        page = browserContext.newPage();
	        page.navigate("http://localhost:8080/");
		 return page;
	} 
	  public BrowserContext getBrowserContext() {
	        if (page == null) {
	            throw new IllegalStateException("Page has not been initialized. Call initBrowser() first.");
	        }
	        return page.context();
	    }

	    public void close() {
	        if (page != null) {
	            page.close();
	        }
	        if (browserContext != null) {
	            browserContext.close();
	        }
	        if (browser != null) {
	            browser.close();
	        }
	      
	    }
	
}
