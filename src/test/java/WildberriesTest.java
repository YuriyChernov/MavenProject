import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WildberriesTest {
    private WebDriver driver;
    private MainPage mainPage;
    private ShoppingCartPage shoppingCartPage;

    public void checkItemsTitle(List<String> mainPageItemTitles, List<String> shoppingCartPageItemTitles) {
        for (int i = 0; i < mainPageItemTitles.size(); i++) {
            Assert.assertTrue(mainPageItemTitles.get(i).contains(shoppingCartPageItemTitles.get(i)));
        }
    }

    public void checkQuantity(List<WebElement> quantity) {
        for (WebElement quantityItems : quantity) {
            Assert.assertEquals(quantityItems.getAttribute("value"), "1");
        }
    }

    @BeforeClass
    public void setup() {
        driver = Singleton.getWebDriverInstance();
        WebDriverWait wait = Singleton.getWebDriverWaitInstance();

        mainPage = new MainPage(driver, wait);
        shoppingCartPage = new ShoppingCartPage(wait);
        PageFactory.initElements(driver, shoppingCartPage);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.wildberries.ru/");
        driver.manage().window().maximize();
    }

    @Test
    public void urlTest() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.wildberries.ru/");
    }

    @Test(dependsOnMethods = {"urlTest"})
    public void pickItems() {
        mainPage.findFirstItem();
        mainPage.findSecondItem();
        mainPage.getFirstItemToShoppingCart();
        mainPage.getSecondItemToShoppingCart();
        mainPage.goToShoppingCart();
    }

    @Test(dependsOnMethods = {"pickItems"})
    public void cartUrlTest() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.wildberries.ru/lk/basket");
    }

    @Test(dependsOnMethods = {"cartUrlTest"})
    public void checkItemsTitle() {
        List<String> shoppingCartItemTitles = shoppingCartPage.getShoppingCartItemTitles(shoppingCartPage.findShoppingCartItems());
        checkItemsTitle(mainPage.getMainPageItemTitles(), shoppingCartItemTitles);
    }

    @Test(dependsOnMethods = {"cartUrlTest"})
    public void shoppingCartQuantity() {
        checkQuantity(shoppingCartPage.getQuantity());
    }

    @AfterClass
    public void finish() {
        driver.quit();
        driver = null;
    }
}
//не понял как реализовать сравнение цен продуктов с суммой в корзине
