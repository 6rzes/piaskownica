package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(xpath="//a[text()=\"Mobile\"]")
    private WebElement mobileLink;


    public HomePage(WebDriver driver) {
        super(driver);

    }

    public MobilePage clickMobileLink() {
        mobileLink.click();
        return new MobilePage(driver);
    }
}