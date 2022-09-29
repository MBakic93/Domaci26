package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {
    private By continueSoppingBtn= By.id("continue-shopping");
    private By remove= By.id("remove-sauce-labs-backpack");
    private By checkout= By.id("checkout");
    public By cartItem = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]");


    public CartPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getContinueSoppingBtn() {
        return getDriver().findElement(continueSoppingBtn);
    }

    public WebElement getRemove() {
        return getDriver().findElement(remove);
    }

    public WebElement getCheckout() {
        return getDriver().findElement(checkout);
    }

    public WebElement getCartItem(){
        return getDriver().findElement(cartItem);
    }
    public boolean isGetCartItemPresented() {
        return getCartItem().isDisplayed();
    }

    public boolean isContinueShoppingBtnPresented() {
        return getContinueSoppingBtn().isDisplayed();
    }

    public boolean isRemoveButtonPresented() {
        return getRemove().isDisplayed();
    }


    public boolean isCheckoutBtnPresented(){
        return getCheckout().isDisplayed();
    }

    public void checkout() {
        getCheckout().click();
    }

}
