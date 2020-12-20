package page;
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

    public HoodiePage addItemsToBag(){
        WebElement selectSizeBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(selectSizeLocator));
        selectSizeBtn.click();
        WebElement addToBagBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(addToBagLocator));
        addToBagBtn.click();
        WebElement closeModalBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(closeModalLocator));
        closeModalBtn.click();
        addToBagBtn.click();
        WebElement goToBagBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(goToBagLocator));
        goToBagBtn.click();
        return this;
    }

    public String getDeliveryValue(){
        WebElement deliveryValue = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(deliveryValueLocator));
        return deliveryValue.getText();
    }
}
