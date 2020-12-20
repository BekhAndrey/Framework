package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SneakerPage extends AbstractPage {

    private final By addToWishlistLocator = By.xpath("//div[@data-auto-id=\"wishlist-button\"]");
    private final By goToWishlistLocator = By.xpath("//div[@class=\"gl-wishlist-icon wishlist_button___3ppwb solid-icon-color___1IHWy\"]");
    private String url;


    public SneakerPage(WebDriver driver, String sneakerUrl){
        super(driver);
        this.url = sneakerUrl;
    }


    @Override
    public SneakerPage openPage()
    {
        driver.get(url);
        return this;
    }

    public SneakerPage addItemToWishlist(){
        WebElement addToWishlistBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(addToWishlistLocator));
        addToWishlistBtn.click();
        return this;
    }

    public WishlistPage openWishlistPage(){
        WebElement goToWishlistBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(goToWishlistLocator));
        goToWishlistBtn.click();
        return new WishlistPage(driver);
    }
}
