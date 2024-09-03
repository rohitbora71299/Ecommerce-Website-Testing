package TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.LandingPage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public String prodName = "ZARA COAT 3";
    public String email = "unknown@gmail.com", password = "Unknown@123";
    public String country = "India";
    public LandingPage landingPage;
    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {

        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\GlobalData.properties";
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream(path);
        prop.load(file);
        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();

        }
        else if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod
    public LandingPage launchApplication() throws IOException {
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
