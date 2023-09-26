package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nested_Frames_Text {

    ChromeDriver driver;
    public Nested_Frames_Text()
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
        System.out.println("End Test: Nested_Frames_Text");
        driver.close();
        driver.quit();

    }

    
    public  void nestedFrames(){
        System.out.println("Start Test case: Nested_Frames_Text");

        //Navigate to url https://the-internet.herokuapp.com/nested_frames  
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        List<String> alltext = new ArrayList<>();

        //Switch to frame contains text LEFT
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");

        //Find the text that present on this frame Using Locator "XPath" "//frameset[@name='frameset-middle']/frame"
        String text1 = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();    
        alltext.add(text1);

        //Switch back to main page
        driver.switchTo().parentFrame();

        //Switch to frame contains text LEFT
        driver.switchTo().frame("frame-middle");

        //Find the text that present on this frame Using Locator "XPath" "//frameset[@name='frameset-middle']/frame"
        String text2 = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]")).getText();    
        alltext.add(text2);

        //Switch back to main page
        driver.switchTo().parentFrame();

        //Switch to frame contains text LEFT
        driver.switchTo().frame("frame-right");

        //Find the text that present on this frame Using Locator "XPath" "//frameset[@name='frameset-middle']/frame"
        String text3 = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();    
        alltext.add(text3);

        //Switch back to main page
        driver.switchTo().parentFrame();

        driver.switchTo().defaultContent();

        //Switch to frame contains text LEFT
        driver.switchTo().frame("frame-bottom");

        //Find the text that present on this frame Using Locator "XPath" "//frameset[@name='frameset-middle']/frame"
        String text4 = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();    
        alltext.add(text4);

        //Switch back to main page
        driver.switchTo().defaultContent();

        System.out.println("All text present on the page : "+alltext);
    }

}
