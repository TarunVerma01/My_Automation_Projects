package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Image_URLs {

    WebDriver driver;
    public Image_URLs()
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
        System.out.println("End Test: Image_URLs");
        driver.close();
        driver.quit();

    }

    
    public  void imageURLs() throws InterruptedException{
        System.out.println("Start Test case: Image_URLs");
        
        //Navigate to url https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        //Find the image URLs for all the “Recommended Movies” Using Locator "XPath"  "//h2[text()='Recommended Movies']/../../../following-sibling::div/div/div/div/a/div/div/div/img"
        List<WebElement> elements1 = driver.findElements(By.xpath("//h2[text()='Recommended Movies']/../../../following-sibling::div/div/div/div/a/div/div/div/img"));
                
        driver.findElement(By.xpath("//h2[text()='Recommended Movies']/../../../following-sibling::div/div/div[2]")).click();

        Thread.sleep(5000);

        List<WebElement> elements2 = driver.findElements(By.xpath("//h2[text()='Recommended Movies']/../../../following-sibling::div/div/div/div/a/div/div/div/div/img"));
        
        System.out.println("Image URLs for all the Recommended Movies: ");

        for (WebElement url1 : elements1){
            System.out.println("\n"+url1.getAttribute("src"));
        }

        for (WebElement url2 : elements2) {
            System.out.println("\n"+url2.getAttribute("src")); 
        }
        
        //Find Name of the 2nd item in the “Premiere” list Using Locator "XPath"  "//h2[text()='Premieres']/ancestor::div[3]/following-sibling::div/div/div/a[2]/div/div[3]/div[1]/div"
        WebElement name = driver.findElement(By.xpath("//h2[text()='Premieres']/ancestor::div[3]/following-sibling::div/div/div/a[2]/div/div[3]/div[1]/div"));
        System.out.println("Name of the 2nd item in the “Premiere” list: "+name.getText());

        //Find Language of the 2nd item in the “Premiere” list Using Locator "XPath"  "//h2[text()='Premieres']/ancestor::div[3]/following-sibling::div/div/div/a[2]/div/div[3]/div[2]/div"
        WebElement language = driver.findElement(By.xpath("//h2[text()='Premieres']/ancestor::div[3]/following-sibling::div/div/div/a[2]/div/div[3]/div[2]/div"));
        System.out.println("Name of the 2nd item in the “Premiere” list: "+language.getText());
        
    }

}
