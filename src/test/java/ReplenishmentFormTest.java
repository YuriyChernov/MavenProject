import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReplenishmentFormTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void checkPaySectionTitle() {
        driver.get("https://www.mts.by");
        driver.findElement(By.xpath("//*[@id='cookie-agree']")).click();
        WebElement paySection = driver.findElement(By.xpath("//*[@id='pay-section']//div[2]/section/div/h2"));
        String paySectionTitle = paySection.getText();
        Assert.assertTrue(paySectionTitle.contains("Онлайн пополнение\n" +
                "без комиссии"));
    }

    @Test
    public void checkLogosVisibility() {
        WebElement logosImage = driver.findElement(By.className("pay__partners"));
        Assert.assertTrue(logosImage.isDisplayed());
    }

    @Test
    public void linkTest() {
        String expectedTitle = driver.getTitle();

        WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));
        wait.until(ExpectedConditions.elementToBeClickable(link));
        link.click();

        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(expectedTitle, actualTitle);
        driver.navigate().back();
    }

    @Test
    public void checkPaymentForm() {
        WebElement phoneInput = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        phoneInput.click();
        phoneInput.sendKeys("297777777");

        WebElement paymentInput = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        paymentInput.click();
        paymentInput.sendKeys("50");

        WebElement emailInput = driver.findElement(By.xpath("//*[@id='connection-email']"));
        emailInput.click();
        emailInput.sendKeys("example@mail.ru");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        continueButton.click();
    }

    @AfterClass
    public static void finish() {
        driver.quit();
    }
}
