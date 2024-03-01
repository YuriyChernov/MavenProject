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

    public void clickSelectButton() {
        WebElement selectButton = driver.findElement(By.xpath("//*[@id='pay-section']//div[2]/section//div[1]/div[2]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(selectButton));
        selectButton.click();
    }

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by");
        driver.findElement(By.xpath("//*[@id='cookie-agree']")).click();
    }

    @Test
    public void checkPaySectionTitle() {
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
    public void checkCommunicationServicesBox() {
        clickSelectButton();
        WebElement communicationServicesButton = driver.findElement(By.xpath(
                "//*[@id='pay-section']//div[2]/section//div[1]/div[1]/div[2]/ul/li[1]"));
        communicationServicesButton.click();

        WebElement phoneNumberSectionTitle = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        String phoneNumberPlaceholderTitle = phoneNumberSectionTitle.getAttribute("placeholder");
        Assert.assertEquals(phoneNumberPlaceholderTitle, "Номер телефона");

        WebElement paymentSectionTitle = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        String paymentPlaceholderTitle = paymentSectionTitle.getAttribute("placeholder");
        Assert.assertEquals(paymentPlaceholderTitle, "Сумма");

        WebElement emailSectionTitle = driver.findElement(By.xpath("//*[@id='connection-email']"));
        String emailPlaceholderTitle = emailSectionTitle.getAttribute("placeholder");
        Assert.assertEquals(emailPlaceholderTitle, "E-mail для отправки чека");
    }

    @Test
    public void checkHomeInternetBox() {
        clickSelectButton();
        WebElement homeInternetButton = driver.findElement(By.xpath(
                "//*[@id='pay-section']//div[2]/section//div[1]/div[1]/div[2]/ul/li[2]/p"));
        homeInternetButton.click();

        WebElement phoneNumberSectionTitle = driver.findElement(By.xpath("//*[@id='internet-phone']"));
        String phoneNumberPlaceholderTitle = phoneNumberSectionTitle.getAttribute("placeholder");
        Assert.assertEquals(phoneNumberPlaceholderTitle, "Номер абонента");

        WebElement paymentSectionTitle = driver.findElement(By.xpath("//*[@id='internet-sum']"));
        String paymentPlaceholderTitle = paymentSectionTitle.getAttribute("placeholder");
        Assert.assertEquals(paymentPlaceholderTitle, "Сумма");

        WebElement emailSectionTitle = driver.findElement(By.xpath("//*[@id='internet-email']"));
        String emailPlaceholderTitle = emailSectionTitle.getAttribute("placeholder");
        Assert.assertEquals(emailPlaceholderTitle, "E-mail для отправки чека");
    }

    @Test
    public void checkInstallmentPlanBox() {

        clickSelectButton();
        WebElement installmentPlanButton = driver.findElement(By.xpath(
                "//*[@id='pay-section']//div[2]/section//div[1]/div[1]/div[2]/ul/li[3]"));
        installmentPlanButton.click();

        WebElement accountNumberTitle = driver.findElement(By.xpath("//*[@id='score-instalment']"));
        String accountNumberPlaceholderTitle = accountNumberTitle.getAttribute("placeholder");
        Assert.assertEquals(accountNumberPlaceholderTitle, "Номер счета на 44");

        WebElement paymentSectionTitle = driver.findElement(By.xpath("//*[@id='instalment-sum']"));
        String paymentPlaceholderTitle = paymentSectionTitle.getAttribute("placeholder");
        Assert.assertEquals(paymentPlaceholderTitle, "Сумма");

        WebElement emailSectionTitle = driver.findElement(By.xpath("//*[@id='instalment-email']"));
        String emailPlaceholderTitle = emailSectionTitle.getAttribute("placeholder");
        Assert.assertEquals(emailPlaceholderTitle, "E-mail для отправки чека");
    }

    @Test
    public void checkDebtBox() {
        clickSelectButton();
        WebElement debtButton = driver.findElement(By.xpath(
                "//*[@id='pay-section']//div[2]/section//div[1]/div[1]/div[2]/ul/li[4]"));
        debtButton.click();

        WebElement accountNumberTitle = driver.findElement(By.xpath("//*[@id='score-arrears']"));
        String accountNumberPlaceholderTitle = accountNumberTitle.getAttribute("placeholder");
        Assert.assertEquals(accountNumberPlaceholderTitle, "Номер счета на 2073");

        WebElement paymentSectionTitle = driver.findElement(By.xpath("//*[@id='arrears-sum']"));
        String paymentPlaceholderTitle = paymentSectionTitle.getAttribute("placeholder");
        Assert.assertEquals(paymentPlaceholderTitle, "Сумма");

        WebElement emailSectionTitle = driver.findElement(By.xpath("//*[@id='arrears-email']"));
        String emailPlaceholderTitle = emailSectionTitle.getAttribute("placeholder");
        Assert.assertEquals(emailPlaceholderTitle, "E-mail для отправки чека");
    }

    @Test
    public void checkPopup() {
        clickSelectButton();
        WebElement communicationServicesButton = driver.findElement(By.xpath(
                "//*[@id='pay-section']//div[2]/section//div[1]/div[1]/div[2]/ul/li[1]"));
        communicationServicesButton.click();
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

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/app-root/div/div/app-payment-container/app-header/header//div/span[1]")));

        WebElement paymentHeader = driver.findElement(By.xpath(
                "/html/body/app-root//div/app-payment-container/app-header/header//div/span[1]"));
        String paymentHeaderTitle = paymentHeader.getText();
        Assert.assertTrue(paymentHeaderTitle.contains("50"));

        WebElement phoneHeader = driver.findElement(By.xpath(
                "/html/body/app-root//div/app-payment-container/app-header/header//div/p"));
        String phoneHeaderTitle = phoneHeader.getText();
        Assert.assertTrue(phoneHeaderTitle.contains("297777777"));

        WebElement paymentButton = driver.findElement(By.xpath(
                "/html/body/app-root//div/app-payment-container/section/app-card-page//div[1]/button"));
        Assert.assertTrue(paymentButton.getText().contains("50"));

        WebElement paymentContainer = driver.findElement(By.xpath(
                "/html/body/app-root//div/app-payment-container/section/app-card-page//div[1]/app-card-input/form/div[1]"));
        String paymentValue = paymentContainer.getText();
        Assert.assertTrue(paymentValue.contains("Номер карты"));
        Assert.assertTrue(paymentValue.contains("Срок действия"));
        Assert.assertTrue(paymentValue.contains("CVC"));
        Assert.assertTrue(paymentValue.contains("Имя держателя (как на карте)"));

        WebElement logos = driver.findElement(By.xpath(
                "/html/body/app-root//div/app-payment-container/section/app-card-page//div[1]/app-card-input/form//div[1]/app-input//div/div[2]//div"));
        Assert.assertTrue(logos.isDisplayed());

        WebElement popupExit = driver.findElement(By.xpath(
                "/html/body/app-root//div/app-payment-container/app-header/header/app-back-navigation//div/svg-icon"));
        popupExit.click();
    }

    @AfterClass
    public static void finish() {
        driver.quit();
    }
}
