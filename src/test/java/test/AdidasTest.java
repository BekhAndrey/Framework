package test;

import model.Item;
import model.User;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.ProductPage;
import service.ProductCreator;
import service.UserCreator;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class AdidasTest extends CommonConditions {

    @Test
    public void addToWishlistTest() {
        Item expectedItem = ProductCreator.withCredentialsFromPropertyForWishlist("first");
        Item wishlistItem = new ProductPage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .addItemToWishlist()
                .openWishlistPage()
                .getWishlistResult();
        assertThat(wishlistItem, equalTo(expectedItem));
    }

    @Test
    public void removeFromBagTest(){
        String expectedMessage = "YOUR BAG IS EMPTY";
        String emptyBagText = new ProductPage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .selectItemSize("M")
                .addItemsToBag()
                .openBagPage()
                .removeFromBag()
                .getBagAmountText();
        assertThat(emptyBagText, equalTo(expectedMessage));
    }

    @Test
    public void addToBagWithoutSize(){
        String expectedMessage = "Please select your size";
        String noSizeSelectedText = new ProductPage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .addItemsToBag()
                .getNoSizeSelectedMessage();
        assertThat(noSizeSelectedText, equalTo(expectedMessage));
    }

    @Test
    public void addMultipleItemsToBag(){
        Item expectedItemInfo = ProductCreator.withCredentialsFromPropertyForBag("second");
        Item bagItemInfo = new ProductPage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .selectItemSize("M")
                .addItemsToBag()
                .closeModal()
                .addItemsToBag()
                .openBagPage()
                .getBagItemsInfo();
        assertThat(bagItemInfo, equalTo(expectedItemInfo));
    }

    @Test
    public void freeDeliveryTest() {
        String expectedDeliveryValue = "FREE";
        String deliveryValue = new ProductPage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .selectItemSize("M")
                .addItemsToBag()
                .closeModal()
                .addItemsToBag()
                .openBagPage()
                .getDeliveryValue();
        assertThat(deliveryValue, equalTo(expectedDeliveryValue));
    }

    @Test
    public void colorFilterTest(){
        String expectedColor = "Purple";
        String selectedItemColor = new CatalogPage(driver,"https://www.adidas.com/us/men-shoes")
                .openPage()
                .applyColorFilter()
                .openItemWithFilter()
                .getItemColor();
        assertThat(selectedItemColor, containsString(expectedColor));
    }

    @Test
    public void sortByPriceTest(){
        List<Integer> itemsPriceList = new CatalogPage(driver,"https://www.adidas.com/us/men-shoes")
                .openPage()
                .sortByPrice()
                .getItemsPriceList();
        assertThat(itemsPriceList.get(0), greaterThanOrEqualTo(itemsPriceList.get(1)));
    }

    @Test
    public void addItemOutOfStockTest(){
        String expectedMessage = "Selected size is no longer available";
        String outOfStockMessage = new ProductPage(driver,"https://www.adidas.com/us/type-o-4-shoes/FV7638.html")
                .openPage()
                .selectItemSize("M 11.5 / W 12.5")
                .addItemsToBag()
                .closeModal()
                .addItemsToBag()
                .closeModal()
                .addItemsToBag()
                .getOutOfStockMessage();
        assertThat(outOfStockMessage, equalTo(expectedMessage));
    }

    @Test
    public void applyCouponTest(){
        List<Double> originalAndNewPrice = new ProductPage(driver, "https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .selectItemSize("M")
                .addItemsToBag()
                .openBagPage()
                .applyCoupon("ADPRHS18")
                .getOriginalAndTotalPrice();
        assertThat(originalAndNewPrice.get(0), greaterThan(originalAndNewPrice.get(1)));
    }

    @Test
    public void wrongDeliveryCredentialsTest(){
        User user = UserCreator.withIncorrectAddress();
        List<WebElement> credentialsErrorsList = new ProductPage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .selectItemSize("M")
                .addItemsToBag()
                .openBagPage()
                .openCheckoutPage()
                .enterCredentials(user)
                .getAddressMessage();
        Assert.assertTrue(credentialsErrorsList.size() >0);
        assertThat(credentialsErrorsList, not(empty()));
    }
}
