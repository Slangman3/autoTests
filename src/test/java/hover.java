import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class hover {
    public static final String URL = "http://the-internet.herokuapp.com/hovers";

    @Test
    public void checkHover() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.get(URL);
        driver.manage().window().fullscreen();
        List<WebElement> arr = driver.findElements(By.xpath("//div[@class='figure']"));

        for (int i = 1; i < 3; i++) {
            WebElement firstFigure = arr.get(i);
            action.moveToElement(firstFigure).perform();
            WebElement figureLink = firstFigure.findElement(By.tagName("a"));
            WebElement nameOfFigure = firstFigure.findElement(By.tagName("h5"));
            assertEquals(figureLink.getText(), "View profile");
            assertEquals(nameOfFigure.getText(), "name: user" + ++i);
            figureLink.click();
            WebElement nextPage = driver.findElementByTagName("h1");
            assertEquals(nextPage.getText(), "Not Found");
            driver.navigate().back();
//            не получается сделать проверку, что все на месте.
//            firstFigure.isDisplayed();
        }
        driver.quit();
    }
}
