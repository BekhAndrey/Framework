package page;
import static util.Resolver.resolveTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends AbstractPage {

    private final By selectSizeLocator = By.xpath("//button[@data-di-id=\"size_M\"]");
    private  By testSizeLocator;
    private final By addToBagLocator = By.xpath("//button[@data-auto-id=\"add-to-bag\"]");
    private final By closeModalLocator = By.xpath("//button[@class=\"gl-modal__close\"]");
    private final By goToBagLocator = By.xpath("//button[@data-auto-id=\"view-bag-desktop\"]");
    private final By addToWishlistLocator = By.xpath("//div[@data-auto-id=\"wishlist-button\"]");
    private final By goToWishlistLocator = By.xpath("//div[@class=\"right-side-menu___16Ik7\"]/div[3]");
    private final By itemByFilterColorLocator = By.xpath("//h5[@class= \"gl-label color___3xvLb\"]");
    private final By noSizeSelectedLocator = By.xpath("//div[@class=\"scarcity-message___3reHV gl-vspace\" ]");
    private final By itemOutOfStockLocator = By.xpath("//div[@data-auto-id = \"cart-error-message\"]");
    private String url;


    public ProductPage(WebDriver driver, String productUrl){
        super(driver);
        this.url = productUrl;
    }

    public ProductPage(WebDriver driver){
        super(driver);
    }

    @Override
    public ProductPage openPage()
    {
        driver.get(url);
        return this;
    }

    public ProductPage addItemToWishlist(){
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

    public ProductPage addItemsToBag(){
        WebElement addToBagBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(addToBagLocator));
        addToBagBtn.click();
        return this;
    }

    public ProductPage selectItemSize(String size){
        String sizeXpath = resolveTemplate("//button[@class=\"gl-label size___TqqSo\"]/span[text() =\"%s\"]", size);
        testSizeLocator = By.xpath(sizeXpath);
        WebElement selectSizeBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(testSizeLocator));
        selectSizeBtn.click();
        return this;
    }

    public String getItemColor(){
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(itemByFilterColorLocator)).getText();
    }

    public String getNoSizeSelectedMessage(){
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(noSizeSelectedLocator)).getText();
    }

    public ProductPage closeModal(){
        WebElement closeModalBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(closeModalLocator));
        closeModalBtn.click();
        return this;
    }

    public BagPage openBagPage(){
        WebElement goToBagBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(goToBagLocator));
        goToBagBtn.click();
        return new BagPage(driver);
    }

    public String getOutOfStockMessage(){
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(itemOutOfStockLocator)).getText();
    }
}
