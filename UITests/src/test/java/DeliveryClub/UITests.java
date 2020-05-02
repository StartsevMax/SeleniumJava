package DeliveryClub;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UITests {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/maksimstarsev/Desktop/SeleniumJava/UITests/src/main/resources/Drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest() {
        driver.get("https://www.delivery-club.ru");
        driver.findElement(By.cssSelector(".vendors-suggests__input")).sendKeys("пицца");
    }

    @After
    public void close() {
        driver.quit();
    }
}
