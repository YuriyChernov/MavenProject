
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Singleton {
    public static WebDriver driverInstance = null;
    public static WebDriverWait driverWaitInstance = null;

    private Singleton() {}

    public static WebDriver getWebDriverInstance() {
        if(driverInstance == null) {
            System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
            driverInstance = new ChromeDriver();
        }
        return driverInstance;
    }

    public static WebDriverWait getWebDriverWaitInstance() {
        if(driverWaitInstance == null) {
            driverWaitInstance = new WebDriverWait(getWebDriverInstance(), 10);
        }
        return driverWaitInstance;
    }
}