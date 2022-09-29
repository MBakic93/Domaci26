package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutYourInformationPage extends BasePage {
    private By ceckOutYourPage= By.xpath("//*[@id=\"checkout_info_container\"]/div/form");
    private By firstName= By.id("");
    private By lastaName=By.id("");
    private By postalCode= By.id("");
    private By contnueBtn=By.id("");
    private By cancelBtn= By.id("");

    public CheckoutYourInformationPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getCeckOutYourPage() {
        return getDriver().findElement(ceckOutYourPage);
    }

    public WebElement getFirstName() {
        return getDriver().findElement(firstName);
    }

    public WebElement getLastaName() {
        return getDriver().findElement(lastaName);
    }

    public WebElement getPostalCode() {
        return getDriver().findElement(postalCode);
    }

    public WebElement getContnueBtn() {
        return getContnueBtn().findElement(contnueBtn);
    }

    public WebElement getCancelBtn() {
        return getDriver().findElement(cancelBtn);
    }
    public WebElement getceckOutYourPage() {
        return getDriver().findElement(ceckOutYourPage);
    }

    public boolean isContinueBtnPresented(){
        return getContnueBtn().isDisplayed();
    }
    public boolean isCancelBtnPresented(){
        return getCancelBtn().isDisplayed();
    }

    public void checkout(String firstName, String lastName, String postalCode){
        getFirstName().sendKeys(firstName);
        getLastaName().sendKeys(lastName);
        getPostalCode().sendKeys(postalCode);
    }
    public boolean isGetFormPresented() {
        return getCeckOutYourPage().isDisplayed();
    }
}
