package page;
import model.Item;
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

public class BagPage {

    private WebDriver driver;
    private final By itemColorLocator =By.xpath("//span[@data-auto-id=\"cart-line-item-attribute-color\" ]");
    private final By itemSizeLocator =By.xpath("//span[@data-auto-id=\"cart-line-item-attribute-size\" ]");
    private final By itemNameLocator =By.xpath("//span[@data-auto-id=\"glass-cart-line-item-name\" ]");
    private final By itemPriceLocator =By.xpath("//div[@data-auto-id=\"glass-cart-line-item-price\" ]");
    private final By itemAmountLocator =By.xpath("//span[@class=\"gl-dropdown-custom__select-label-text\" ]");
    private final By removeFromBagLocator = By.xpath("//button[@data-auto-id =\"glass-cart-line-item-delete\" ]");
    private final By emptyBagLocator = By.xpath("//h3[@data-auto-id =\"glass-cart-empty-title\" ]");
    private final By deliveryValueLocator = By.xpath("//span[@data-auto-id=\"glass-cart-summary-delivery-value\"]");

    public BagPage(WebDriver driver){
        this.driver = driver;
    }

    public BagPage removeFromBag(){
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
