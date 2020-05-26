package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageObject{

    @FindBy(xpath = "//strong[text()=\"My Wishlist\"] | //a[text()=\"My Wishlist\"]")
    private WebElement myWishlist;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public MyWishlist myWishList() {
        myWishlist.click();
        return new MyWishlist(driver);
    }
}
