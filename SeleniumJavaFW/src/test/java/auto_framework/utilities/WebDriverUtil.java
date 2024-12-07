package auto_framework.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

@Getter
@Setter
public class WebDriverUtil {
    private WebDriver driver;

    public void setDriver(String browserName){
        switch (browserName.toLowerCase()){
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
    }

    public void launchBrowser(String webUrl){
        try{
            driver.manage().window().maximize();
            driver.get(webUrl);
        }catch (Exception e){
            throw new RuntimeException("Failed to launch application with url: " + webUrl);
        }
    }

}
