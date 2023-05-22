package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedinPost {
    ChromeDriver driver;
    public void Post_linkin(){
        this.driver = TestCases.TestCasesInitializer();
        
        System.out.println("Start testCase: testCase03");
        // Navigate to URL https://www.linkedin.com/
        driver.get("https://www.linkedin.com/");
        
		// Type "Email or phone: in Username textbox Using Locator "Name" session_key
        driver.findElementByName("session_key").sendKeys("******@gmail.com");
        
		// Type "Password" in password textbox Using Locator "Name" session_password
        driver.findElementByName("session_password").sendKeys("*****");
        
		// Click on "Sign in" button Using Locator "XPath" //button[@type='submit']
        driver.findElementByXPath("//button[@type='submit']").click();
        
		// Print the count of "Who's viewed your profile" Using Locator "XPath"
        // //*[contains(text(),'viewed your
        // profile')]/../../following-sibling::div//strong
        String viewedProfile = driver
                .findElement(
                        By.xpath("//*[contains(text(),'viewed your profile')]/../../following-sibling::div//strong"))
                .getText();
        System.out.println("Who's viewed your profile: " + viewedProfile);
       
	   // Print the count of "Impressions of your post" Using Locator "XPath"
        // //*[text()='Impressions of your post']/../../following-sibling::div//strong

        String impressionPost = driver
                .findElement(By.xpath("//*[text()='Impressions of your post']/../../following-sibling::div//strong"))
                .getText();
        System.out.println("Impressions of your post: " + impressionPost);

        // Click on "Start a post" button Using Locator "XPath" //button[contains(@class,'share-box-feed-entry__trigger')]
        driver.findElementByXPath("//button[contains(@class,'share-box-feed-entry__trigger')]").click();

        // Type message in textbox Using Locator "XPath" //div[@data-placeholder='What do you want to talk about?']
        driver.findElementByXPath("//div[@data-placeholder='What do you want to talk about?']").sendKeys("SDLC");
        //Thread.sleep(1000);
        // Click on "Post" button Using Locator "XPath"
        // //button[contains(@class,'share-actions__primary-action artdeco-button')]
        driver.findElementByXPath("//button[contains(@class,'share-actions__primary-action artdeco-button')]")
                .click();
        // Verify that "Post successful" message is displayed Using Locator "XPath" //*[text()='Post successful.']
        boolean isDisplayed = driver.findElementByXPath("//*[text()='Post successful.']").isDisplayed();
        System.out.println("Post is posted successfully: " + isDisplayed);
    }
}
