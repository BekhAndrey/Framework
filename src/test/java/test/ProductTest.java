package test;

import model.Item;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.ProductPage;
import service.ProductCreator;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ProductTest extends CommonConditions {

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
    public void addToBagWithoutSize(){
        String expectedMessage = "Please select your size";
        String noSizeSelectedText = new ProductPage(driver,"https://www.adidas.com/us/trefoil-hoodie/DT7963.html")
                .openPage()
                .addItemsToBag()
                .getNoSizeSelectedMessage();
        assertThat(noSizeSelectedText, equalTo(expectedMessage));
    }
}
