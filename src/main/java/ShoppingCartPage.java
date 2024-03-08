import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage {
    private final WebDriverWait wait;

    By shoppingCartItems = By.className("list-item__wrap");
    By shoppingCartItemsTitle = By.className("good-info__good-name");
    @FindBy(xpath = "//input[@type='number']")
    List<WebElement> quantity;

    public ShoppingCartPage(WebDriverWait wait) {
        this.wait = wait;
    }

    public List<WebElement> findShoppingCartItems() {
        List<WebElement> cartItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(shoppingCartItems));
        System.out.println(cartItems.size());
        return cartItems;
    }

    public List<String> getShoppingCartItemTitles(List<WebElement> cartItemsToFindTitles) {
        List<String> cartPageItemTittles = new ArrayList<>();
        for (int i = cartItemsToFindTitles.size() - 1; i >= 0; i--) {
            wait.until(ExpectedConditions.visibilityOf(cartItemsToFindTitles.get(i)));
            String shoppingCartPageItemTitle = cartItemsToFindTitles.get(i).findElement(shoppingCartItemsTitle).getText();
            cartPageItemTittles.add(shoppingCartPageItemTitle);
        }
        return cartPageItemTittles;
    }

    public List<WebElement> getQuantity() {
        wait.until(ExpectedConditions.visibilityOfAllElements(quantity));
        return quantity;
    }
}
