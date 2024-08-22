package technia;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class luanchtech {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Playwright playwright = Playwright.create();
       Browser browser=playwright.chromium().launch(
    		   new LaunchOptions().setHeadless(false));//it will launch the browser 
       Page page=browser.newPage();//it will launch new tab
       page.navigate("https://23xdemo.technia.net/");
       assertThat(page).hasTitle("Technia");
     Locator Spacewithcas = page.locator("//a[contains(.,'3DSpace with CAS')]");
     Spacewithcas.click();
     //page.click("//a[contains(.,'3DSpace with CAS')]");
     Locator Username=page.locator("//input[@name='username']");
     page.getByPlaceholder("Email or username").fill("admin_platform");
     page.getByPlaceholder("Password").fill("enoviaV6");
     page.click("//input[@value='Log in']");
     page.click("//div[@class='add topbar-menu-item topbar-cmd enabled fonticon fonticon-plus']");
    // page.close();
    // browser.close();
     //playwright.close();
     
       
       
	}

}
