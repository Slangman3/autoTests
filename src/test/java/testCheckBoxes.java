import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class testCheckBoxes {
    public static final String URL = "http://the-internet.herokuapp.com/checkboxes";

    @Test public void checkByCheck(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().fullscreen();
        List <WebElement> arr = driver.findElements(By.xpath("//*[@type='checkbox']"));
        WebElement firstCheckBox = arr.get(0);
        assertFalse(firstCheckBox.isSelected());
        firstCheckBox.click();
        assertTrue(firstCheckBox.isSelected());
        driver.quit();
    }
}