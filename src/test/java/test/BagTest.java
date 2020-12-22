package test;

import model.Item;
import org.testng.annotations.Test;
import page.ProductPage;
import service.ProductCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BagTest extends CommonConditions {

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
}
