package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SneakerPage extends AbstractPage  {

    private final By closeModalLocator = By.xpath("//button[@class=\"gl-modal__close\"]");
    private final By colorFilterLocator = By.xpath("//div[@data-auto-id = \"plp-collapsable-sidebar-item-container_Color\"]");
    private final By colorLocator = By.xpath("//a[@title = \"Purple\"]");
    private final By itemByFilterLocator = By.xpath("//div[@data-grid-id = \"FZ0832\"]");
    private final By itemByFilterColorLocator = By.xpath("//h5[@class= \"gl-label color___3xvLb\"]");
    private final By sortByDropdownLocator = By.xpath("//button[@title= \"Sort By\"]");
    private final By priceHighToLowLocator = By.xpath("//button[@value= \"price-high-to-low\"]");
    private final By priceHighToLowSelectedLocator = By.xpath("//span[@class=\"gl-dropdown-custom__select-label-text\" and text() = \"Price (high - low)\"]");
    private final By itemsPriceLocator = By.xpath("//div[@class= \"gl-price-item gl-price-item--small notranslate\"]");
    private String url;
    public SneakerPage(WebDriver driver, String hoodieUrl){
        super(driver);
        this.url = hoodieUrl;
    }

    @Override
    public SneakerPage openPage() {
        driver.get(url);
        return this;
    }

    public SneakerPage applyColorFilter(){
        WebElement colorFilterBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(colorFilterLocator));
        colorFilterBtn.click();
        WebElement colorBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(colorLocator));
        colorBtn.click();
        WebElement closeModalBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(closeModalLocator));
        closeModalBtn.click();
        return this;
    }

    public SneakerPage openItemWithFilter(){
        WebElement itemByFilterBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(itemByFilterLocator));
        itemByFilterBtn.click();
        return this;
    }

    public String getItemColor(){
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(itemByFilterColorLocator)).getText();
    }

    public SneakerPage sortByPrice() {
        WebElement sortByDropdown = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(sortByDropdownLocator));
        sortByDropdown.click();
        WebElement priceHighToLowBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(priceHighToLowLocator));
        priceHighToLowBtn.click();
        WebElement closeModalBtn = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(closeModalLocator));
        closeModalBtn.click();
        WebElement priceHighToLowSelected = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(priceHighToLowSelectedLocator));
        Boolean priceToLoad = new WebDriverWait(driver,10)
                .until(ExpectedConditions.textMatches(itemsPriceLocator, Pattern.compile(".+")));
        return this;
    }

    public List<Integer> getItemsPriceList(){
//        List<Integer> priceList = Resolver.getIntegerPriceList(new WebDriverWait(driver,10)
//                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemsPriceLocator)));
        List<Integer> priceList = Resolver.getIntegerPriceList(new WebDriverWait(driver,20)
              .until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemsPriceLocator)));
        return priceList;
    }
}
