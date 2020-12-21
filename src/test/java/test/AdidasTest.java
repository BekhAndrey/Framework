package test;

import model.Item;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HoodiePage;
import page.SneakerPage;
import service.ItemCreator;

import java.util.List;

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
                .selectItemSize()
                .addItemsToBag()
                .openBagPage()
                .removeFromBag()
                .getBagAmountText();
        assertThat(emptyBagText, equalTo(expectedMessage));
    }

    @Test
    public void addToBagWithoutSize(){
        String expectedMessage = "Please select your size";
        String noSizeSelectedText = new HoodiePage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .addItemsToBag()
                .getNoSizeSelectedMessage();
        assertThat(noSizeSelectedText, equalTo(expectedMessage));
    }

    @Test
    public void addMultipleItemsToBag(){
        Item expectedItemInfo = ItemCreator.withCredentialsFromPropertyForBag("second");
        Item bagItemInfo = new HoodiePage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .selectItemSize()
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
        String deliveryValue = new HoodiePage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .selectItemSize()
                .addItemsToBag()
                .closeModal()
                .addItemsToBag()
                .openBagPage()
                .getDeliveryValue();
        Assert.assertEquals(deliveryValue, expectedDeliveryValue);
    }

    @Test
    public void colorFilterTest(){
        String expectedColor = "Purple";
        String selectedItemColor = new SneakerPage(driver,"https://www.adidas.com/us/men-shoes")
                .openPage()
                .applyColorFilter()
                .openItemWithFilter()
                .getItemColor();
        Assert.assertTrue(selectedItemColor.contains(expectedColor));
    }

    @Test
    public void sortByPriceTest(){
        List<Integer> itemsPriceList = new SneakerPage(driver,"https://www.adidas.com/us/men-shoes")
                .openPage()
                .sortByPrice()
                .getItemsPriceList();
        Assert.assertTrue(itemsPriceList.get(0) >=itemsPriceList.get(1));
    }
}
