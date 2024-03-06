import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[@id='basketContent']/div[3]/a")
    private WebElement basket;

    @FindBy(xpath = "//*[@id='app']/div[4]//div[1]/form//div[1]//div[2]//div[1]//a/span[1]")
    private WebElement firstProductTitle;

    @FindBy(xpath = "//*[@id='app']/div[4]//div[1]/form//div[1]//div[2]/div/div[1]/div/a/span[1]")
    private WebElement secondProductTitle;

    @FindBy(xpath = "//*[@id='app']/div[4]//div[1]/form//div[1]//div[2]//div[3]//div[1]//a/span[1]")
    private WebElement thirdProductTitle;

    @FindBy(xpath = "//*[@id='app']/div[4]//div[1]/form//div[2]//input")
    private WebElement firstProductQuantity;

    @FindBy(xpath = "//*[@id='app']/div[4]//div[1]/form//div[1]//div[2]/div/div[2]/div/div/input")
    private WebElement secondProductQuantity;

    @FindBy(xpath = "//*[@id='app']/div[4]//div[1]/form//div[2]//div[3]//div[2]//input")
    private WebElement thirdProductQuantity;

    @FindBy(xpath = "//*[@id='app']/div[4]//div[1]/form//div[1]//div[2]//div[1]/div/div[3]/div[3]")
    private WebElement firstProductPrice;

    @FindBy(xpath = "//*[@id='app']/div[4]//div[1]/form//div[1]//div[2]/div/div/div[3]")
    private WebElement secondProductPrice;

    @FindBy(xpath = "//*[@id='app']/div[4]//div[1]/form//div[1]//div[2]//div[3]//div[3]/div[3]")
    private WebElement thirdProductPrice;

    @FindBy(xpath = "//*[@id='app']/div[4]//div[1]/form//div[2]/div/span[1]")
    private WebElement totalProductsQuantity;

    @FindBy(xpath = "//*[@id='app']/div[4]//div[1]/form//div[2]/p/span[2]/span")
    private WebElement totalProductsPrice;


    public BasketPage() {
        driver.get("https://www.wildberries.ru/");
        PageFactory.initElements(driver, this);
    }

    public void convertProductPricesToText() {
        basket.click();
        firstProductPrice.getText();
        secondProductPrice.getText();
        thirdProductPrice.getText();
    }


//        WebElement firstProductPrice = driver.findElement(By.xpath(
//                "//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/div[3]/div[3]"));
//        String firstProductPriceText = firstProductPrice.getText();
//        int firstProductPriceInt = Integer.parseInt(firstProductPriceText);
//
//
//        WebElement secondProductPrice = driver.findElement(By.xpath(
//                "//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[3]/div[3]"));
//        String secondProductPriceText = secondProductPrice.getText();
//        int secondProductPriceInt = Integer.parseInt(secondProductPriceText);
//
//
//        WebElement thirdProductPrice = driver.findElement(By.xpath(
//                "//*[@id='app']/div[4]//div[1]/form//div[1]//div[2]//div[3]//div[3]/div[3]"));
//        String thirdProductPriceText = thirdProductPrice.getText();
//        int thirdProductPriceInt = Integer.parseInt(thirdProductPriceText);
//
//        int count = firstProductPriceInt + secondProductPriceInt + thirdProductPriceInt;
//
//        WebElement totalProductPrice = driver.findElement(By.xpath(
//                "//*[@id='app']/div[4]//div[1]/form//div[2]/p/span[2]/span"));
//        String totalProductPriceText = totalProductPrice.getText();
//        int totalProductPriceInt = Integer.parseInt(totalProductPriceText);
//
//        Assert.assertEquals(count, totalProductPriceInt);
//    }
}
