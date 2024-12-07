package auto_framework.utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import org.apache.hc.client5.http.utils.Base64;
import org.openqa.selenium.*;

public class ExtentReportUtil {

    public static ExtentReports report(String filePath){
        ExtentReports extent;
        try{
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(filePath);
            extent.attachReporter(spark);
            spark
                    .viewConfigurer()
                    .viewOrder()
                    .as(new ViewName[]{ViewName.TEST, ViewName.DASHBOARD})
                    .apply();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return extent;
    }

    public static Media captureScreenshot(WebDriver driver){
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        String base64Screenshot = Base64.encodeBase64String(screenshot);
        Media screenShotAsMedia = MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build();
        return screenShotAsMedia;
    }

}

