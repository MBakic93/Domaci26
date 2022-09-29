package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutCompeletePage extends  BasePage{
    private By completedMessage = By.xpath("//*[@id=\"checkout_complete_container\"]");
    private By backHomeBtn = By.id("back-to-products");

    public CheckoutCompeletePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public WebElement getCompletedMessage() {
        return getDriver().findElement(completedMessage);
    }

    public WebElement getBackHomeBtn() {
        return getDriver().findElement(backHomeBtn);
    }

    public boolean isCompletedMessagePresented() {
        return getCompletedMessage().isDisplayed();
    }

    public void backToHomePage() {
        getBackHomeBtn().click();
    }
}
