package selenium;

import java.util.Map;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    private static Driver instance;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private Actions windowView;

    private Driver() {

    }

    public static Driver getInstance() {
        if(instance == null) {
            instance = new Driver();
        }

        return instance;
    }

    private void configChrome(String driverPath) {
        // Setting ChromeDriver
        System.setProperty("webdriver.chrome.driver", driverPath);

        // Setting Notifications OFF
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        webDriver = new ChromeDriver(options);

        // Maximizing Browser
        webDriver.manage().window().maximize();
    }

    public void setDriver(String driverPath, String browserType, int driverSecondsTimeout) {
        switch (browserType) {
            case "chrome":
                configChrome(driverPath);

                webDriverWait = new WebDriverWait(webDriver, driverSecondsTimeout);
                windowView = new Actions(webDriver);
                break;
            default:
                System.out.println("Browser unrecognized '" + browserType + "'");
                break;
        }
    }

    public WebElement findElement(By element) {
        return webDriver.findElement(element);
    }

    public WebElement waitUntilPresenceOf(By element) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public Actions getWindowView() {
        return windowView;
    }

    // Not used for now
//    public void closeAndQuitDriver() {
//        webDriver.close();
//        webDriver.quit();
//    }

    public void goTo(String url) {
        webDriver.navigate().to(url);
    }
}
