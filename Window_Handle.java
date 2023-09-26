package demo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_Handle {

    ChromeDriver driver;
    public Window_Handle()
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
        System.out.println("End Test: Window_Handle");
        driver.close();
        driver.quit();

    }

    
    public  void windowHandle(){
        System.out.println("Start Test case: Window_Handle");

        //Navigate to url https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open  
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        driver.switchTo().frame("iframeResult");

        //Click on the "Try it" button at the top of the page Using Locator "XPath" "//button[text()='Try it']"
        WebElement button = driver.findElement(By.xpath("//button[text()='Try it']"));
        button.click();

        Set<String> handles = driver.getWindowHandles();

        String parentHandle = driver.getWindowHandle();

        for (String handle : handles) {
            
         if (!handle.equals(parentHandle)){
        
          //Switch to new tab
          driver.switchTo().window(handle);

          //Get the URL, Title of newly opened window  Using the getCurrentUrl() and getTitle()
          String url = driver.getCurrentUrl();
          System.out.println("URL of newly opened window: "+url);

          String title = driver.getTitle();
          System.out.println("Title of newly opened window: "+title);

         }
        }
        //Close the new window
        driver.close();

        //Switch back to the original window by using the window handle 
        driver.switchTo().window(parentHandle);
        
    }

}
