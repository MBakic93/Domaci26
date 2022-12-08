package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Test {
    private LoginPage loginPage;
    private  ProductPage productPage;
    private CartPage cartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    private OverviewPage overviewPage;
    private CheckoutCompeletePage checkoutCompeletePage;


    private WebDriver driver;
    private WebDriverWait driverWait;
    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dusanic\\Desktop\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage= new LoginPage(driver,driverWait);
        productPage= new ProductPage(driver,driverWait);
        cartPage= new CartPage(driver,driverWait);
        checkoutYourInformationPage= new CheckoutYourInformationPage(driver,driverWait);
        overviewPage= new OverviewPage(driver,driverWait);
        checkoutCompeletePage= new CheckoutCompeletePage(driver,driverWait);


    }
 @org.testng.annotations.Test (priority = 1)
    public void loginTest(){
        loginPage.login("standard_user","secret_sauce");

     Assert.assertTrue(productPage.isProductsPresented());

    }
    @org.testng.annotations.Test (priority = 2)
    public void addProductTest(){
        Assert.assertTrue(productPage.isAddToCartBtnPresented());

        productPage.addProductToCart();
        Assert.assertTrue(productPage.isRemoveBtnPresented());
        Assert.assertTrue(productPage.isCartWithProductPresented());
        productPage.goToCart();
    }
    @org.testng.annotations.Test (priority = 3)
    public void checkoutProductTest() {
        Assert.assertTrue(cartPage.isGetCartItemPresented());
        Assert.assertTrue(cartPage.isRemoveButtonPresented());
        Assert.assertTrue(cartPage.isContinueShoppingBtnPresented());
        Assert.assertTrue(cartPage.isCheckoutBtnPresented());
        cartPage.checkout();

        Assert.assertTrue(checkoutYourInformationPage.isGetFormPresented());
    }

    @org.testng.annotations.Test (priority = 4)
    public void informationFormTest() {

        Assert.assertTrue(checkoutYourInformationPage.isContinueBtnPresented());
        Assert.assertTrue(checkoutYourInformationPage.isCancelBtnPresented());
        checkoutYourInformationPage.checkout("Djordje", "Cvarkov", "21233");

        String expectedResult = "Total: $32.39";
        String actualResult = overviewPage.getTotal().getText();

        Assert.assertEquals(expectedResult,actualResult);

        overviewPage.finishOrder();
    }

    @org.testng.annotations.Test (priority = 5)

    public void completePageTest() {
        Assert.assertTrue(checkoutCompeletePage.isCompletedMessagePresented());
        checkoutCompeletePage.backToHomePage();

        Assert.assertTrue(productPage.isProductsPresented());
    }

   @org.testng.annotations.Test (priority = 6)
    public void logoutTest() {
        productPage.logout();
    }

    @org.testng.annotations.Test (priority = 7)
    public void cartWithoutLogin() {
        driver.navigate().to("https://www.saucedemo.com/cart.html ");

        Assert.assertTrue(loginPage.isLoginBtnPresented());
    }


    @AfterClass
    public void afterClas(){
        driver.quit();
    }




}
