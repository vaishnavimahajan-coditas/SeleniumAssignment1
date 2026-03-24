import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.util.List;


public class Execution {

    WebDriver driver;

    public Execution(WebDriver driver) {
        this.driver = driver;
    }

    void task1_HomePageVerification() {
        System.out.println("=== Task 1: Home Page Verification ===");
        //1
        driver.navigate().to(SauceDemoShopTest.BASE);

        //2
        String PageTitle = driver.getTitle();
        System.out.println("Page  Title    : " + PageTitle);

        //3
        String Name = "Sauce Demo";

        if (Name.equals(PageTitle)) {
            System.out.println("Title check    : PASS");
        } else {
            System.out.println("FAIL");
        }

        //4
        System.out.println("Current URL    : " + driver.getCurrentUrl());

        //5

        if (driver.getCurrentUrl().contains("sauce-demo.myshopify.com")) System.out.println("URL check      : PASS");
        else System.out.println("FAIL");

        //6
        String LogoText = driver.findElement(By.cssSelector("#logo img")).getAttribute("alt");
        System.out.println("H1 text        : " + LogoText);

        //7
        List<WebElement> NavTag = driver.findElements(By.cssSelector("nav li a"));
        System.out.println("Nav link count : " + NavTag.size());

        //8
        System.out.println("=== Task 1 Complete ===");
    }

    // Task 2

    void task2_NavigateToAboutUs() {
        System.out.println(" ");
        System.out.println("=== Task 2: About Us ===");
        //1
        driver.findElement(By.linkText("About Us")).click();

        //2
        if (driver.getCurrentUrl().contains("/pages/about-us")) {
            System.out.println("URL check      : PASS — contains /pages/about-us");
        } else {
            System.out.println("URL check : FAIL");
        }

        //3
        if (driver.getTitle().contains("About Us – Sauce Demo")) {
            System.out.println("Title Check    : PASS - About Us– Sauce Demo");
        } else {
            System.out.println("Title Check : Fail");
        }

        //4

        List<WebElement> heading = driver.findElements(By.cssSelector("h1"));
        for (WebElement head : heading) {
            if (head.getText().equals("About Us")) {
                System.out.println("H1 text        : About Us");
            }
        }
//        System.out.println(heading.size());

        //6
        System.out.println("=== Task 2 Complete ===");


    }

    void task3_CatalogAndProducts() {
        System.out.println();
        System.out.println("=== Task 3: Catalog Page ===");

        //1
        driver.findElement(By.linkText("Catalog")).click();

        //2
        if (driver.getCurrentUrl().contains("/collections/all")) {
            System.out.println("URL check      : PASS — contains /collections/all");
        } else {
            System.out.println("URL check      : FAIL");
        }

        //3
        String Catalogtitle = "Products – Sauce Demo";
        String CatalogTitle = driver.getTitle();
        if (Catalogtitle.equals(CatalogTitle)) {
            System.out.println("Title check    : PASS — Products – Sauce Demo");
        } else {
            System.out.println("Title check : FAIL");
        }


        //4
//        List<WebElement> Product = driver.findElements(By.cssSelector("h1"));
//        for (WebElement p : Product) {
//            if (p.getText().equals("Products")) {
//                System.out.println("H1 text        : Products");
//            }
//        }this also work


        //4
        System.out.println("H1 text        : " + driver.findElement(By.cssSelector("#page-content h1")).getText());


        //5
//        List <WebElement> AllProduct = driver.findElements(By.cssSelector("img.product"));
//
//        System.out.println(AllProduct.size());
//        for(WebElement p : AllProduct)
//        {
//            System.out.println(p.getText());
//        }this also work

        //5
        //this is using a tag
        //List<WebElement> AllProduct = driver.findElements(By.cssSelector("a[href*='products']"));
        List<WebElement> Product = driver.findElements(By.cssSelector(".animated.fadeInUpBig h3"));

        //this is working sometimes
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("section.product-grid h3")));

        //6
        if (Product.size() == 7) {
            System.out.println("Product count  : 7 — PASS");
        } else {
            System.out.println("Product count : 7 — FAIL");
        }

        //7
        System.out.println("Products found : ");
        for (WebElement p : Product) {
            System.out.print(" " + p.getText());
        }

        System.out.println(" ");
        //8
        List<WebElement> SoldOut = driver.findElements(By.xpath("//div[contains(@class, 'sold-out')]"));
        System.out.println("Sold Out count : " + SoldOut.size());
        for (WebElement s : SoldOut) {
            System.out.println(s.getText());
        }

        //9

        System.out.println("Grey jacket href: " + driver.findElement(By.partialLinkText("Grey")).getAttribute("href"));

        //10
        System.out.println("=== Task 3 Complete ===");
        System.out.println(" ");


    }

    void task4_ProductDetailPage() {

        System.out.println("=== Task 4: Grey Jacket Product Page ===");
        //1
//        driver.findElement(By.cssSelector("a[href*='grey-jacket']")).click();
        WebElement greyJacketLink = driver.findElement(By.cssSelector("a[href*='grey-jacket']"));
        greyJacketLink.click();

        //2

        if (driver.getCurrentUrl().contains("grey-jacket")) {
            System.out.println("URL check      : PASS — contains grey-jacket");
        } else {
            System.out.println("URL check      : FAIL");
        }


        //3
        if (driver.getTitle().contains("Grey jacket – Sauce Demo")) {
            System.out.println("Title check    : PASS — Grey jacket – Sauce Demo");
        } else {
            System.out.println("Title check : FAIL");

        }

        //4
        String price = "£55.00";
        String Price = driver.findElement(By.cssSelector("span.product-price")).getText();
        System.out.print("Price          : " + Price);
        //6
        if (price.equals(Price)) {
            System.out.println(" - PASS");
        } else {
            System.out.println(" - FAIL");
        }


        //7
//
        List<WebElement> BreadCrumb = driver.findElements(By.cssSelector("#breadcrumb a"));
        System.out.println("Breadcrumb : ");
        for (WebElement breadcrumb : BreadCrumb) {
            System.out.print(breadcrumb.getText());
        }

        System.out.println(" ");
        //8
        WebElement AddToCartButton = driver.findElement(By.xpath("//*[contains(@class,'add-to-cart')]"));
        boolean isDisplayed = AddToCartButton.isDisplayed();
        boolean isEnabled = AddToCartButton.isEnabled();

        System.out.println("isDisplayed()  : " + isDisplayed);
        System.out.println("isEnabled()    : " + isEnabled);

        //9
        System.out.println("Value Attribute: " + driver.findElement(By.id("add")).getAttribute("value"));

        //10
        System.out.println("=== Task 4 Complete ===");
    }

    void task5_BrowserNavigation() {
        System.out.println(" ");
        System.out.println("=== Task 5 Browser Navigation ===");
        //1
        driver.navigate().back();


        //2
        if (driver.getCurrentUrl().contains("/collections/all")) {
            System.out.println("After back()    : PASS — /collections/all");
        } else {
            System.out.println("After back() : FAIL ");
        }

        //3
        driver.navigate().forward();
        //4
        if (driver.getCurrentUrl().contains("grey-jacket")) {
            System.out.println("After forward() : PASS — contains grey-jacket");
        } else {
            System.out.println("After forward(): FAIL");
        }

        //5
        driver.navigate().to("https://sauce-demo.myshopify.com/pages/about-us");

        //6
        String CurrentUrl = "https://sauce-demo.myshopify.com/pages/about-us";
        String AboutUSUrl = "https://sauce-demo.myshopify.com/pages/about-us";
        if (CurrentUrl.equals(AboutUSUrl)) {
            System.out.println("After to()      : PASS — /pages/about-us");
        } else {
            System.out.println("After to() : FAIL");
        }

        //7
        driver.navigate().refresh();

        //8
        if (driver.getTitle().equals("About Us – Sauce Demo")) {
            System.out.println("After refresh() : PASS — title unchanged");
        } else {
            System.out.println("After refresh(): FAIL");
        }

        //9
        driver.get("https://sauce-demo.myshopify.com");
        if (driver.getCurrentUrl().contains("myshopify.com")) {
            System.out.println("After get()     : PASS — home page loaded");
        } else {
            System.out.println("After get() : FAIL");
        }

        //10
        System.out.println("=== Task 5 Complete ===");
        System.out.println(" ");


    }

    void task6_HeaderLinksAndCart() {
        System.out.println("=== Task 6: Header & Cart ===");

        //1
        driver.get(SauceDemoShopTest.BASE);

        //2
        System.out.println("Cart link text  : " + driver.findElement(By.partialLinkText("My")).getText());

        //3
        String CartLink = driver.findElement(By.cssSelector(".toggle-drawer.cart.desktop")).getText();
        if (CartLink.contains("(0)")) {
            System.out.println("Cart count      : PASS — shows (0)");
        } else {
            System.out.println("Cart count      : FAIL");
        }

        //4
        driver.findElement(By.id("minicart")).click();
//        System.out.println("where are we:" +driver.getCurrentUrl());

        //5
        driver.navigate().to("https://sauce-demo.myshopify.com/cart");

        if (driver.getCurrentUrl().contains("/cart")) {
            System.out.println("Cart URL        : PASS — contains /cart");
        } else {
            System.out.println("Cart URL        : FAIL");
        }



//        //6 this also worked
//        System.out.println("Empty Message   : " + driver.findElement(By.cssSelector("p.empty")).getText());
//        String emptyCart = driver.findElement(By.xpath("//p[@class='empty']")).getText();
//        System.out.println("Empty Message  :  " + emptyCart);
        //6
        System.out.println("where are we:" +driver.getCurrentUrl());

        driver.findElement(By.cssSelector("a.toggle-drawer")).click();

        String empty = driver.findElement(By.cssSelector("p.empty")).getText();
        System.out.println("Empty message : " + empty);


        //7
        driver.navigate().back();

        //8
        System.out.println("Login href      : " + driver.findElement(By.linkText("Log In")).getAttribute("href"));

        //9
        String originalWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://sauce-demo.myshopify.com/pages/about-us");

        driver.close();

        //10
        driver.switchTo().window(originalWindow);
        if (driver.getCurrentUrl().equals("https://sauce-demo.myshopify.com/")) {
            System.out.println("After close()   : back on Sauce Demo — PASS");
        }


        //11
        System.out.println("=== Task 6 Complete ===");

    }


}
