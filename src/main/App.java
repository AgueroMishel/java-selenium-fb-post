package main;

import objects.facebook.Login;
import objects.facebook.PostBox;
import selenium.Driver;

public class App {
    public static void main(String[] args) {
        // Arguments
        String driverPath = "";
        String url = "https://www.facebook.com/";
        String email = "";
        String password = "";
        String message = "Hello World!";

        // Driver settings
        String browser = "chrome";
        int driverSecondsTimeout = 30;

        // Driver initialization
        Driver driver = Driver.getInstance();
        driver.setDriver(driverPath, browser, driverSecondsTimeout);

        // Go to Facebook, Signin and Post
        driver.goTo(url);

        Login login = new Login();
        login.signIn(email, password);

        PostBox postBox = new PostBox();
        postBox.post(message);
    }
}
