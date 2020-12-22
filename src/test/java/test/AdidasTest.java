package test;

import model.Item;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;
import page.CatalogPage;
import service.ProductCreator;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class AdidasTest extends CommonConditions {

//    @Test
//    public void addToWishlistTest() {
//        Item expectedItem = ProductCreator.withCredentialsFromPropertyForWishlist("first");
//        Item wishlistItem = new ProductPage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
//                .openPage()
//                .addItemToWishlist()
//                .openWishlistPage()
//                .getWishlistResult();
//        assertThat(wishlistItem, equalTo(expectedItem));
//    }
//
//    @Test
//    public void removeFromBagTest(){
//        String expectedMessage = "YOUR BAG IS EMPTY";
//        String emptyBagText = new ProductPage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
//                .openPage()
//                .selectItemSize("M")
//                .addItemsToBag()
//                .openBagPage()
//                .removeFromBag()
//                .getBagAmountText();
//        assertThat(emptyBagText, equalTo(expectedMessage));
//    }
//
//    @Test
//    public void addToBagWithoutSize(){
//        String expectedMessage = "Please select your size";
//        String noSizeSelectedText = new ProductPage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
//                .openPage()
//                .addItemsToBag()
//                .getNoSizeSelectedMessage();
//        assertThat(noSizeSelectedText, equalTo(expectedMessage));
//    }
//
//    @Test
//    public void addMultipleItemsToBag(){
//        Item expectedItemInfo = ProductCreator.withCredentialsFromPropertyForBag("second");
//        Item bagItemInfo = new ProductPage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
//                .openPage()
//                .selectItemSize("M")
//                .addItemsToBag()
//                .closeModal()
//                .addItemsToBag()
//                .openBagPage()
//                .getBagItemsInfo();
//        assertThat(bagItemInfo, equalTo(expectedItemInfo));
//    }
//
//    @Test
//    public void freeDeliveryTest() {
//        String expectedDeliveryValue = "FREE";
//        String deliveryValue = new ProductPage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
//                .openPage()
//                .selectItemSize("M")
//                .addItemsToBag()
//                .closeModal()
//                .addItemsToBag()
//                .openBagPage()
//                .getDeliveryValue();
//        Assert.assertEquals(deliveryValue, expectedDeliveryValue);
//    }
//
//    @Test
//    public void colorFilterTest(){
//        String expectedColor = "Purple";
//        String selectedItemColor = new CatalogPage(driver,"https://www.adidas.com/us/men-shoes")
//                .openPage()
//                .applyColorFilter()
//                .openItemWithFilter()
//                .getItemColor();
//        Assert.assertTrue(selectedItemColor.contains(expectedColor));
//    }
//
//    @Test
//    public void sortByPriceTest(){
//        List<Integer> itemsPriceList = new CatalogPage(driver,"https://www.adidas.com/us/men-shoes")
//                .openPage()
//                .sortByPrice()
//                .getItemsPriceList();
//        Assert.assertTrue(itemsPriceList.get(0) >=itemsPriceList.get(1));
//    }
//
//    @Test
//    public void addItemOutOfStockTest(){
//        String expectedMessage = "Selected size is no longer available";
//        String outOfStockMessage = new ProductPage(driver,"https://www.adidas.com/us/type-o-4-shoes/FV7638.html")
//                .openPage()
//                .selectItemSize("M 11.5 / W 12.5")
//                .addItemsToBag()
//                .closeModal()
//                .addItemsToBag()
//                .closeModal()
//                .addItemsToBag()
//                .getOutOfStockMessage();
//        assertThat(outOfStockMessage, equalTo(expectedMessage));
//    }

    @Test
    public void applyCouponTest(){
        List<Double> originalAndNewPrice = new ProductPage(driver, "https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .selectItemSize("M")
                .addItemsToBag()
                .openBagPage()
                .applyCoupon("ADPRHS18")
                .getOriginalAndTotalPrice();
        Assert.assertTrue(originalAndNewPrice.get(0) > originalAndNewPrice.get(1));
    }
}
