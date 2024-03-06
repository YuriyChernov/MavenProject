import org.junit.Test;

public class WildberriesTest extends BaseSeleniumTest {

    @Test
    public void checkBasket() {
        MainPage mainPage = new MainPage();
        mainPage.addProductsToBasket();
        BasketPage basketPage = new BasketPage();
        basketPage.convertProductPricesToText();
    }
}
