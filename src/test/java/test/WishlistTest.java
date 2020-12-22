package test;

import model.Item;
import org.testng.annotations.Test;
import page.ProductPage;
import service.ProductCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WishlistTest extends CommonConditions {

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
}
