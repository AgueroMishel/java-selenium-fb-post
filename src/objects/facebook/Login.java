package objects.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.DriverFactory;

public class Login {
    private static final String email = "email";
    private static final String password = "pass";

    private static By getEmailBy() {
        return By.id(email);
    }

    private static By getPasswordBy() {
        return By.id(password);
    }

    public static void signIn(String email, String password) {
        WebElement emailBox = DriverFactory.getInstance().getWebDriver().findElement(Login.getEmailBy());
        emailBox.sendKeys(email);

        WebElement passwordBox = DriverFactory.getInstance().getWebDriver().findElement(Login.getPasswordBy());
        passwordBox.sendKeys(password);

        emailBox.submit();
    }
}