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
    private final By deliveryValueLocator = By.xpath("//span[@data-auto-id=\"glass-cart-summary-delivery-value\"]");
    private final By addToWishlistLocator = By.xpath("//div[@data-auto-id=\"wishlist-button\"]");
    private final By goToWishlistLocator = By.xpath("//div[@class=\"right-side-menu___16Ik7\"]/div[3]");
    private final By removeFromBagLocator = By.xpath("//button[@data-auto-id =\"glass-cart-line-item-delete\" ]");
    private final By emptyBagLocator = By.xpath("//h3[@data-auto-id =\"glass-cart-empty-title\" ]");
    private final By noSizeSelectedLocator = By.xpath("//div[@class=\"scarcity-message___3reHV gl-vspace\" ]");
    private final By itemNameLocator =By.xpath("//span[@data-auto-id=\"glass-cart-line-item-name\" ]");
    private final By itemColorLocator =By.xpath("//span[@data-auto-id=\"cart-line-item-attribute-color\" ]");
    private final By itemSizeLocator =By.xpath("//span[@data-auto-id=\"cart-line-item-attribute-size\" ]");
    private final By itemPriceLocator =By.xpath("//div[@data-auto-id=\"glass-cart-line-item-price\" ]");
    private final By itemAmountLocator =By.xpath("//span[@class=\"gl-dropdown-custom__select-label-text\" ]");
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
        WebElement selectSizeBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(selectSizeLocator));
        selectSizeBtn.click();
        WebElement addToBagBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(addToBagLocator));
        addToBagBtn.click();
        return this;
    }

    public String addItemsToBagWithoutSize(){
        WebElement addToBagBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(addToBagLocator));
        addToBagBtn.click();
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(noSizeSelectedLocator)).getText();
    }

    public HoodiePage closeModal(){
        WebElement closeModalBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(closeModalLocator));
        closeModalBtn.click();
        return this;
    }

    public HoodiePage goToBag(){
        WebElement goToBagBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(goToBagLocator));
        goToBagBtn.click();
        return this;
    }

    public HoodiePage removeFromBag(){
        WebElement removeFromBagBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(removeFromBagLocator));
        removeFromBagBtn.click();
        return this;
    }

    public String getBagAmountText(){
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(emptyBagLocator)).getText();
    }

    public Item getBagItemsInfo(){
        String itemName = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(itemNameLocator)).getText();
        String itemPrice = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(itemPriceLocator)).getText();
        String itemColor = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(itemColorLocator)).getText();
        String itemSize = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(itemSizeLocator)).getText();
        String itemAmount = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(itemAmountLocator)).getText();
        return new Item(itemName,itemColor,itemSize,itemPrice, itemAmount);
    }

    public String getDeliveryValue(){
        WebElement deliveryValue = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(deliveryValueLocator));
        return deliveryValue.getText();
    }
}
