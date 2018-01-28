package objects.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.Driver;

public class Login {
    private Driver driver;

    private static final String email = "email";
    private static final String password = "pass";

    public Login() {
        driver = Driver.getInstance();
    }

    private static By getEmailBy() {
        return By.id(email);
    }

    private static By getPasswordBy() {
        return By.id(password);
    }

    public void signIn(String email, String password) {
//        WebElement emailBox = DriverFactory.getInstance().getWebDriver().findElement(Login.getEmailBy());
        WebElement emailBox = driver.findElement(Login.getEmailBy());
        emailBox.sendKeys(email);

//        WebElement passwordBox = DriverFactory.getInstance().getWebDriver().findElement(Login.getPasswordBy());
        WebElement passwordBox = driver.findElement(Login.getPasswordBy());
        passwordBox.sendKeys(password);

        emailBox.submit();
    }
}