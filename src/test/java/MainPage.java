import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BaseSeleniumPage {

    private static WebDriverWait wait;

    @FindBy(xpath = "//*[@id='app']//div[2]//article[1]//div[3]/p[3]/a")
    private WebElement firstProductAddBasket;

    @FindBy(xpath = "//*[@id='app']//div[2]//article[2]//div[3]/p[3]/a")
    private WebElement secondProductAddBasket;

    @FindBy(xpath = "//*[@id='app']//div[2]//article[3]//div[3]/p[3]/a")
    private WebElement thirdProductAddBasket;

    public MainPage() {
        driver.get("https://www.wildberries.ru/");
        PageFactory.initElements(driver, this);
    }

    public void addProductsToBasket() {
        firstProductAddBasket.click();
        secondProductAddBasket.click();
        thirdProductAddBasket.click();

    }
}
