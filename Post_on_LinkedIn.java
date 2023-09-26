package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Post_on_LinkedIn {

    ChromeDriver driver;
    public Post_on_LinkedIn()
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
        System.out.println("End Test: Post_on_LinkedIn");
        driver.close();
        driver.quit();

    }

    
    public  void linkedinPost(){
        System.out.println("Start Test case: Post_on_LinkedIn");
       
        //Navigate to url https://www.linkedin.com/feed/ 
        driver.get("https://www.linkedin.com/feed/");

        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        driver.findElement(By.id("username")).sendKeys("testUser123");
        driver.findElement(By.id("password")).sendKeys("testUser123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //After login into account Click on the Me button  Using Locator "XPath" "//span[text()="Me"]/preceding-sibling::img" | click()
        driver.findElement(By.xpath("//span[text()='Me']/preceding-sibling::img")).click();

        //Click on the View profile button on the popup menu 
        Actions key = new Actions(driver);
        key.sendKeys(Keys.ARROW_DOWN).perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        key.sendKeys(Keys.ARROW_DOWN).perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        key.sendKeys(Keys.ENTER).perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Print the count of `Who's viewed your profile` Using Locator "XPath" "//a[@target="_self"]/div/div/div/div/span[contains(text(),'profile view')][1]"
        WebElement views = driver.findElement(By.xpath("//a[@target='_self']/div/div/div/div/span[contains(text(),'profile view')][1]"));
        System.out.println("Count of `Who's viewed your profile`: "+views.getText());

        //Print the count of `Impressions of your post`  Using Locator "XPath" "//a[@target="_self"]/div/div/div/div/span[contains(text(),"post impressions")][1]"
        WebElement impressions = driver.findElement(By.xpath("//a[@target='_self']/div/div/div/div/span[contains(text(),'post impressions')][1]"));
        System.out.println("Count of `Impressions of your post`: "+impressions.getText());

        //Create a post by clicking on button 'Create a post' Using Locator "XPath" "//span[text()='Create a post']"
        driver.findElement(By.xpath("//span[text()='Create a post']")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Click on the Post setting button Using Locator "XPath" "//div[@type='circle']"
        driver.findElement(By.xpath("//div[@type='circle']")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Select the `Connections only` radio button to allow only connections to see the post Using Locator "ID" "CONNECTIONS_ONLY"
        driver.findElement(By.id("CONNECTIONS_ONLY")).click();

        //Click on the Done button to confirm Using Locator "XPath" "//span[text()="Done"]"
        driver.findElement(By.xpath("//span[text()='Done']")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Enter the text in the textarea Using Locator "XPath" "//div[@data-placeholder="What do you want to talk about?"]"
        WebElement textarea = driver.findElement(By.xpath("//div[@data-placeholder='What do you want to talk about?']"));
        textarea.sendKeys("This is my new post");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Click on the Post button to finally post Using Locator "XPath" "//span[text()='Post']"
        driver.findElement(By.xpath("//span[text()='Post']")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       
        //Check if the post is successfully posted Using Locator "XPath" "//span[text()='Post successful.']"
        WebElement finalpost = driver.findElement(By.xpath("//span[text()='Post successful.']"));
        System.out.println("Check if the post is successfully posted: "+finalpost.isDisplayed());

    }

}
