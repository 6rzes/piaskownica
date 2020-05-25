import models.MobileSortBy;
import pages.CardPage;
import pages.DetailsPage;
import pages.HomePage;

import org.junit.Test;
import pages.MobilePage;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class SignUpFormTest extends FunctionalTest{
    @Test
    public void sortingMobiles(){
        driver.get("http://live.demoguru99.com/index.php/");

        HomePage homePage = new HomePage(driver);
        assertEquals("Home page", homePage.getTitle());

        MobilePage mobilePage = homePage.clickMobileLink();
        assertEquals("Mobile", mobilePage.getTitle());

        mobilePage.setSortOrder(MobileSortBy.NAME);

        List<String> tmpList = mobilePage.getItemNames();
        Collections.sort(tmpList);
        assertEquals(tmpList,mobilePage.getItemNames());
    }

    @Test
    public void comparePrices(){
        driver.get("http://live.demoguru99.com/index.php/");

        HomePage homePage = new HomePage(driver);
        MobilePage mobilePage = homePage.clickMobileLink();
        String itemPriceMobilePage = mobilePage.getItemPriceByName("Sony Xperia");
        assertEquals("$100.00", itemPriceMobilePage);

        DetailsPage detailsPage = mobilePage.clickOnItemName("Sony Xperia");
        assertEquals(itemPriceMobilePage, detailsPage.getItemPrice());
    }

    @Test
    public void errorVerification() {
        driver.get("http://live.demoguru99.com/index.php/");
        HomePage homePage = new HomePage(driver);
        MobilePage mobilePage = homePage.clickMobileLink();
        CardPage cardPage = mobilePage.addToCardByName("Sony Xperia");
        cardPage.setQty("1000");
    }
}
