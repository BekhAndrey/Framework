package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HoodiePage;
import page.SneakerPage;


public class AdidasTest {

    private WebDriver driver;
    private static final String RESOURCES_PATH = "src\\test\\resources\\";

    @BeforeMethod(alwaysRun = true)
    public void driverSetup(){
        driver = DriverSingleton.getDriver();
    }

    @Test
    public void addToWishlistTest() {
        String expectedWishlistResult = "1 ITEM";
        String wishlistResult = new SneakerPage(driver,"https://www.adidas.com/us/nmd_r1-shoes/D96635.html?pr=product_rr&slot=1")
                .openPage()
                .addItemToWishlist()
                .openWishlistPage()
                .getWishlistResult();
        Assert.assertEquals(wishlistResult, expectedWishlistResult);
    }

    @Test
    public void freeDeliveryTest() {
        String expectedDeliveryValue = "FREE";
        String deliveryValue = new HoodiePage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .addItemsToBag()
                .getDeliveryValue();
        Assert.assertEquals(deliveryValue, expectedDeliveryValue);
    }

    @AfterMethod(alwaysRun = true)
    public void driverShutDown(){
        DriverSingleton.closeDriver();
    }
}
