package page;
import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HoodiePage extends AbstractPage {

    private final By selectSizeLocator = By.xpath("//button[@data-di-id=\"size_M\"]");
    private final By addToBagLocator = By.xpath("//button[@data-auto-id=\"add-to-bag\"]");
    private final By closeModalLocator = By.xpath("//button[@class=\"gl-modal__close\"]");
    private final By goToBagLocator = By.xpath("//button[@data-auto-id=\"view-bag-desktop\"]");
    private final By addToWishlistLocator = By.xpath("//div[@data-auto-id=\"wishlist-button\"]");
    private final By goToWishlistLocator = By.xpath("//div[@class=\"right-side-menu___16Ik7\"]/div[3]");
    private final By noSizeSelectedLocator = By.xpath("//div[@class=\"scarcity-message___3reHV gl-vspace\" ]");
    private String url;


    public HoodiePage(WebDriver driver, String hoodieUrl){
        super(driver);
        this.url = hoodieUrl;
    }

    @Override
    public HoodiePage openPage()
    {
        driver.get(url);
        return this;
    }

    public HoodiePage addItemToWishlist(){
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

    public HoodiePage addItemsToBag(){
        WebElement addToBagBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(addToBagLocator));
        addToBagBtn.click();
        return this;
    }

    public HoodiePage selectItemSize(){
        WebElement selectSizeBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(selectSizeLocator));
        selectSizeBtn.click();
        return this;
    }

    public String getNoSizeSelectedMessage(){
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(noSizeSelectedLocator)).getText();
    }

    public HoodiePage closeModal(){
        WebElement closeModalBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(closeModalLocator));
        closeModalBtn.click();
        return this;
    }

    public BagPage openBagPage(){
        WebElement goToBagBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(goToBagLocator));
        goToBagBtn.click();
        return new BagPage(driver);
    }
}
