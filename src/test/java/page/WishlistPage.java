package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class WishlistPage {

    private WebDriver driver;
    private final By closeDialogLocator = By.xpath("//button[@class=\"gl-modal__close\"]");
    private final By wishlistResultLocator = By.xpath("//div[@class=\"col-s-12 col-l-16 col-xl-18 \"]/p");

    public WishlistPage(WebDriver driver){
        this.driver = driver;
    }

    public String getWishlistResult(){
        WebElement closeDialogBnt = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(closeDialogLocator));
        closeDialogBnt.click();
        WebElement wishlistResult = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(wishlistResultLocator));
        return wishlistResult.getText();
    }
}
