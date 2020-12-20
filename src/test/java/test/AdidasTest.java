package test;

import driver.DriverSingleton;
import model.Item;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HoodiePage;
import service.ItemCreator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class AdidasTest extends CommonConditions {

    @Test
    public void addToWishlistTest() {
        Item expectedItem = ItemCreator.withCredentialsFromPropertyForWishlist("first");
        Item wishlistItem = new HoodiePage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .addItemToWishlist()
                .openWishlistPage()
                .getWishlistResult();
        assertThat(wishlistItem, equalTo(expectedItem));
    }

    @Test
    public void removeFromBagTest(){
        String expectedMessage = "YOUR BAG IS EMPTY";
        String emptyBagText = new HoodiePage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .addItemsToBag()
                .goToBag()
                .removeFromBag()
                .getBagAmountText();
        assertThat(emptyBagText, equalTo(expectedMessage));
    }

    @Test
    public void addToBagWithoutSize(){
        String expectedMessage = "Please select your size";
        String noSizeSelectedText = new HoodiePage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .addItemsToBagWithoutSize();
        assertThat(noSizeSelectedText, equalTo(expectedMessage));
    }

    @Test
    public void addMultipleItemsToBag(){
        Item expectedItemInfo = ItemCreator.withCredentialsFromPropertyForBag("second");
        Item bagItemInfo = new HoodiePage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .addItemsToBag()
                .closeModal()
                .addItemsToBag()
                .goToBag()
                .getBagItemsInfo();
        assertThat(bagItemInfo, equalTo(expectedItemInfo));
    }

    @Test
    public void freeDeliveryTest() {
        String expectedDeliveryValue = "FREE";
        String deliveryValue = new HoodiePage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .addItemsToBag()
                .closeModal()
                .addItemsToBag()
                .goToBag()
                .getDeliveryValue();
        Assert.assertEquals(deliveryValue, expectedDeliveryValue);
    }
}
