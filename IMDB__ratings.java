package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDB__ratings {

    ChromeDriver driver;
    public IMDB__ratings()
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
        System.out.println("End Test: IMDB__ratings");
        driver.close();
        driver.quit();

    }

    
    public  void imdbRatings(){
        System.out.println("Start Test case: IMDB__ratings");

        //Navigate to url https://www.imdb.com/chart/top  
        driver.get("https://www.imdb.com/chart/top");

        //Find the highest rated movie on IMDb Using Locator "XPath" "//a[@href='/title/tt0111161/?ref_=chttp_t_1']/h3" | getText()
        WebElement highrated = driver.findElement(By.xpath("//a[@href='/title/tt0111161/?ref_=chttp_t_1']/h3"));
        System.out.println("Highest rated movie on IMDb: "+highrated.getText());

        //Find which movie has the most user ratings Using Locator "XPath" "//a[@href='/title/tt0111161/?ref_=chttp_t_1']/h3" | getText()
        WebElement mostuser = driver.findElement(By.xpath("//a[@href='/title/tt0111161/?ref_=chttp_t_1']/h3"));
        System.out.println("Most user ratings movie: "+mostuser.getText());

        //Find total movies included in the table Using Locator "XPath" "//div[@class='ipc-lockup-overlay__screen']" 
        List<WebElement> totMov = driver.findElements(By.xpath("//div[@class='ipc-lockup-overlay__screen']"));
        System.out.println("Total movies included in the table: "+totMov.size()); 
        
        //Sort the list by clicking on Release date under Sort by
        driver.findElement(By.xpath("//option[@value='RELEASE_DATE']")).click();

        //Find the oldest movie on the list Using Locator "XPath" "//a[@href='/title/tt0012349/?ref_=chttp_t_250']/h3" | getText()
        WebElement oldMovie = driver.findElement(By.xpath("//a[@href='/title/tt0012349/?ref_=chttp_t_250']/h3"));
        System.out.println("Oldest movie on the list: "+oldMovie.getText());

        //Find the most recent movie on the list Using Locator "XPath" "//a[@href='/title/tt15398776/?ref_=chttp_t_1']/h3" | getText()
        WebElement mostrecent = driver.findElement(By.xpath("//a[@href='/title/tt15398776/?ref_=chttp_t_1']/h3"));
        System.out.println("Most recent movie on the list: "+mostrecent.getText());
        

    }

}
