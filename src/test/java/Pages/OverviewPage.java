package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OverviewPage extends BasePage{
    private By total = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
    private By cancelBtn = By.id("cancel");
    private By finishBtn = By.id("finish");
    public OverviewPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getTotal() {
        return getDriver().findElement(total);
    }

    public  WebElement getCancelBtn() {
        return getDriver().findElement(cancelBtn);
    }

    public WebElement getFinishBtn() {
        return getDriver().findElement(finishBtn);
    }

    public void finishOrder() {
        getFinishBtn().click();
    }
}
