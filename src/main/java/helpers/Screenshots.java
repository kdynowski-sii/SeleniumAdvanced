package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class Screenshots {
    public static void takeScreenshot(WebDriver driver, String methodUsed){
        // Declaring a file
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String absPath = new File("src/screenshots").getAbsolutePath();

        // Getting a browser name - can be done here
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        browserName = browserName.substring(0, 1).toUpperCase() + browserName.substring(1).toLowerCase();

        // Getting current date and time, can be done here
        String temp = LocalDateTime.now().withNano(0).toString().replace(".", "_")
                .replace(" ", "")
                .replace(":", "_")
                .replace("-", "_");

        // This directory is project specific, can be altered when needed, for now can stay
        try {
            FileUtils.copyFile(file, new File(absPath + "/" + temp +
                    methodUsed + browserName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
