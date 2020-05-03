package IKEA;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UITests {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/maksimstarsev/Desktop/SeleniumJava/UITests/src/main/resources/Drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,5);
    }

    @Test
    public void loginPositiveTest() {
        String URL = "https://www.ikea.com/ru/ru/";
        String loginButton = "a[title='Мой профиль']";
        String emailInput = "input[rel='Введите ваш e-mail']";
        String passwordInput = "input[rel='Введите пароль']";
        String submitButton = "blueBtn";
        String container = "ppContentContainer";

        driver.get(URL);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(loginButton)).click();
//        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(emailInput)));
        driver.findElement(By.cssSelector(emailInput)).sendKeys("0960746@mail.ru");
        driver.findElement(By.cssSelector(passwordInput)).sendKeys("**********");
        driver.findElement(By.className(submitButton)).click();
        Assert.assertTrue(driver.findElement(By.id(container)).isDisplayed());
    }

    @After
    public void close() {
        driver.quit();
    }
}
