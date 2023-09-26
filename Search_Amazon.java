package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Search_Amazon {

    ChromeDriver driver;
    public Search_Amazon()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: Search_Amazon");
        driver.close();
        driver.quit();

    }

    
    public  void searchAmazon(){
        System.out.println("Start Test case: Search_Amazon");
        
        //Navigate to google.com  
        driver.get("https://www.google.com");

        //Enter amazon in search text field Using Locator "Name" q |  sendKeys("amazon")
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("amazon");
        
        //In search text box press enter key Using Locator "Name" q |  sendKeys(Keys.RETURN)
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

        //Verify whether amazon.in or amazon.com link is present on the page Using Locator "XPath" q |  sendKeys(Keys. RETURN)
        boolean result = driver.findElement(By.xpath("//span[text()='Amazon.in' or text()='Amazon.com']")).isDisplayed();

        System.out.println("Is amazon.in or amazon.com link is present on the page? "+ result);

        }

}
