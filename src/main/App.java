package main;

import objects.facebook.Login;
import objects.facebook.PostBox;
import selenium.DriverFactory;

public class App {
    public static void main(String[] args) {
        // Arguments
        String url = "https://www.facebook.com/";
        String email = "";
        String password = "";
        String message = "Hello World!";

        // Driver settings
        String browser = "chrome";
        int driverSecondsTimeout = 30;

        // Driver initialization
        DriverFactory driver = DriverFactory.getInstance();
        driver.setDriver(browser, driverSecondsTimeout);

        driver.goTo(url);
        Login.signIn(email, password);
        PostBox.post(message);
    }
}
