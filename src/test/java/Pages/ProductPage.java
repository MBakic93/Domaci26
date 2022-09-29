package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ProductPage extends  BasePage{

    private By products= By.id("inventory_container");
    private By removeBtn= By.id("remove-sauce-labs-backpack");
    private By cart= By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private By cartWithProduct= By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private By logout=By.id("logout_sidebar_link");
    private By addToCartBtn=By.id("add-to-cart-sauce-labs-backpack");


    public ProductPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getProducts() {
        return getDriver().findElement(products);
    }

    public WebElement getAddToCartBtn(){
        return getDriver().findElement(addToCartBtn);
    }

    public WebElement getRemoveBtn(){
        return getDriver().findElement(removeBtn);
    }

    public WebElement getCart(){
        return getDriver().findElement(cart);
    }

    public WebElement getCartWithProduct(){
        return getDriver().findElement(cartWithProduct);
    }

    public WebElement getLogout() {
        return getDriver().findElement(logout);
    }


    public boolean isProductsPresented(){
        return getProducts().isDisplayed();
    }

    public boolean isAddToCartBtnPresented() {
        return getAddToCartBtn().isDisplayed();
    }

    public boolean isCartWithProductPresented() {
        return getCartWithProduct().isDisplayed();
    }

    public boolean isRemoveBtnPresented() {
        return getRemoveBtn().isDisplayed();
    }

    public void addProductToCart() {
        getAddToCartBtn().click();
    }
    public void goToCart(){
        getCart().click();
    }

    public void logout(){
        WebElement menu= getDriver().findElement(By.id("react-burger-menu-btn"));
        menu.click();
        getLogout().click();
    }


}
