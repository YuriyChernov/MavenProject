import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final List<String> mainPageItemTitles;

    By firstItemCard = By.xpath("//*[@id='app']//div[2]//article[1]/div/a");
    By firstItemAddButton = By.xpath("//*[@id='app']//div[2]//article[1]//div[3]/p[3]/a");
    By secondItemCard = By.xpath("//*[@id='app']//div[2]//article[2]/div/a");
    By secondItemAddButton = By.xpath("//*[@id='app']//div[2]//article[2]//div[3]/p[3]/a");
    By shoppingCart = By.xpath("//*[@id='basketContent']/div[3]/a");

    public List<String> getMainPageItemTitles() {
        return mainPageItemTitles;
    }

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        mainPageItemTitles = new ArrayList<>();
    }

    public void findFirstItem() {
        WebElement firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemCard));
        String firstItemTitle = firstItem.getAttribute("aria-label");
        mainPageItemTitles.add(firstItemTitle);
    }

    public void getFirstItemToShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstItemAddButton)).click();
    }

    public void findSecondItem() {
        WebElement secondItem = wait.until(ExpectedConditions.visibilityOfElementLocated(secondItemCard));
        String secondItemTitle = secondItem.getAttribute("aria-label");
        mainPageItemTitles.add(secondItemTitle);
    }

    public void getSecondItemToShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(secondItemAddButton)).click();
    }

    public void goToShoppingCart() {
        driver.findElement(shoppingCart).click();
    }
}
