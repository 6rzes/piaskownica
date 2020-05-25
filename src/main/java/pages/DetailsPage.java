package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsPage extends PageObject {

    @FindBy(xpath="//span[@class=\"price\"]")
    private WebElement itemPrice;


    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }
}