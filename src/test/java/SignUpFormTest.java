import models.MobileSortBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.*;


import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignUpFormTest extends FunctionalTest {

    private HomePage homePage;

    @BeforeEach
    public void openPage() {
        driver.get("http://live.demoguru99.com/index.php/");
        homePage = new HomePage(driver);
    }

    @Test
    @Disabled
    public void sortingMobiles() {
        assertEquals("Home page", homePage.getTitle());
        MobilePage mobilePage = homePage.clickMobileLink();
        assertEquals("Mobile", mobilePage.getTitle());
        mobilePage.setSortOrder(MobileSortBy.NAME);
        List<String> tmpList = mobilePage.getItemNames();
        Collections.sort(tmpList);
        assertEquals(tmpList, mobilePage.getItemNames());
    }

    @Test
    @Disabled
    public void comparePrices() {
        MobilePage mobilePage = homePage.clickMobileLink();
        String itemPriceMobilePage = mobilePage.getItemPriceByName("Sony Xperia");
        assertEquals("$100.00", itemPriceMobilePage);
        DetailsPage detailsPage = mobilePage.clickOnItemName("Sony Xperia");
        assertEquals(itemPriceMobilePage, detailsPage.getItemPrice());
    }

    @Test
    @Disabled
    public void errorVerification() {
        MobilePage mobilePage = homePage.clickMobileLink();
        CardPage cardPage = mobilePage.addToCardByName("Sony Xperia");
        cardPage.setQty("1000");
    }

    @Test
    @Disabled
    public void handlingPopup() {
        MobilePage mobilePage = homePage.clickMobileLink();
        mobilePage.addToCompareByName("Sony Xperia");
        mobilePage.addToCompareByName("IPhone");
        ComparePage comparePage = mobilePage.clickCompareButton();
        List<String> product_names = comparePage.getProductNames();
        assertThat(product_names).contains("SONY XPERIA").contains("IPHONE");
    }

    @Test
    @Disabled
    public void accountCreation() {
        AccountPanePage accountPanePage = homePage.clickAccountLink();
        RegisterPage registerPage = accountPanePage.clickOnRegister();
        MyAccountPage myAccountPage = registerPage.setFirstName("asd")
                                                  .setMiddleName("asd")
                                                  .setLastName("asd")
                                                  .setEmailAddress("asd@wp.pl")
                                                  .setPassword("123456")
                                                  .setConfirmation("123456")
                                                  .clickRegister();
        MobilePage mobilePage = homePage.clickMobileLink();
        mobilePage.addToWishlistByName("Sony Xperia");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setPassword("123456").setEmail("asd@wp.pl").login();
        List <String> productNames = myAccountPage.myWishList().getProductNames();
        assertThat(productNames.contains("Sony Xperia"));
    }
}
