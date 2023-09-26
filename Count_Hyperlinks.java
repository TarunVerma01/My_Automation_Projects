package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Count_Hyperlinks {

    ChromeDriver driver;
    public Count_Hyperlinks()
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
        System.out.println("End Test: Count_Hyperlinks");
        driver.close();
        driver.quit();

    }

    
    public  void countHyperlinks(){
        System.out.println("Start Test case: Count_Hyperlinks");
        
        //Navigate to url https://in.bookmyshow.com/explore/home/chennai  
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        //List down the count of all the hyperlinks present in this page. Using Locator "Tag Name" "a" 
        List<WebElement> elements = driver.findElements(By.tagName("a"));

        //Print the count of all the hyperlinks  
        System.out.println("Total count of all the hyperlinks present in this page: "+elements.size());

    }

}
