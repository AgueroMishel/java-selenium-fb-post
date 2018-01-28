package objects.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import selenium.Driver;

public class PostBox {
    private Driver driver;

    private static final String postBoxPath = "//*[@aria-label=\"Create a post\"]";
    private static final String inputBoxPath = "/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div[2]/div/div[3]/div/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div[1]/div[2]/div/div/div/div/div/div/div/div/div/div";
    private static final String postButtonTag = "button";

    public PostBox() {
        driver = Driver.getInstance();
    }

    public static By getPostBox() {
        return By.xpath(postBoxPath);
    }

    public static By getInputBox() {
        return By.xpath(inputBoxPath);
    }

    public static By getPostButton() {
        return By.tagName(postButtonTag);
    }

    public void post(String message) {
        // Looking for Post Box
        WebElement postBox = driver.waitUntilPresenceOf(PostBox.getPostBox());
        postBox.click();

        // Entering Message
        WebElement inputBox = driver.waitUntilPresenceOf(PostBox.getInputBox());

        Actions action = driver.getWindowView();
        action.moveToElement(inputBox);
        action.click();
        action.sendKeys(message);
        action.perform();

        // Posting Message
        WebElement button = postBox.findElement(PostBox.getPostButton());
        button.click();
    }
}
