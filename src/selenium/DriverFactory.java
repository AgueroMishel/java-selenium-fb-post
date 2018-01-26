package selenium;

import java.io.File;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
    private static DriverFactory instance;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private Actions windowView;

    private DriverFactory() {

    }

    public static DriverFactory getInstance() {
        if(instance == null) {
            instance = new DriverFactory();
        }

        return instance;
    }

    private void configChrome(String osName) {
        // Getting ChromeDriver
        String pathToDriver = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;
        if (osName.equals("windows")) {
            System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver");
        }

        // Setting Notifications OFF
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        webDriver = new ChromeDriver(options);

        // Maximizing Browser
        webDriver.manage().window().maximize();
    }

    public void setDriver(String browserType, int driverSecondsTimeout) {
        String osName = (System.getProperty("os.name").toLowerCase().contains("mac") ? "mac" : "windows");

        switch (browserType) {
            case "chrome":
                configChrome(osName);

                webDriverWait = new WebDriverWait(webDriver, driverSecondsTimeout);
                windowView = new Actions(webDriver);
                break;
            default:
                System.out.println("Browser unrecognized '" + browserType + "'");
                break;
        }
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
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
