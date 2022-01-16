package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.print.PrintOptions;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver driver;

    public  WebDriver initializeDriver(String brwserName, Properties properties){

        System.out.println("Browser name is : "+brwserName);

        switch (brwserName.toLowerCase()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\OneDrive\\Desktop\\ChromeDriver\\chromedriver.exe");
                driver = new ChromeDriver();

                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                System.out.println("Please pass the valid browser");
            break;
        }

        driver.get(properties.getProperty("url"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20L,TimeUnit.SECONDS);
        return driver;

    }
}
