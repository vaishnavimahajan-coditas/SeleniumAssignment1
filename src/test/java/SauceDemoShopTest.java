import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SauceDemoShopTest {
    static WebDriver driver;
    static final String BASE = "https://sauce-demo.myshopify.com";

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Execution execution = new Execution(driver);

        execution.task1_HomePageVerification();

        execution.task2_NavigateToAboutUs();

        execution.task3_CatalogAndProducts();

        execution.task4_ProductDetailPage();

        execution.task5_BrowserNavigation();

        execution.task6_HeaderLinksAndCart();

        System.out.println("\n====== ALL TASKS COMPLETE ======");

        driver.quit();
    }
}
