package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CardPage extends PageObject{
    @FindBy(xpath = "//input[@class=\"input-text qty\"]")
    private WebElement quantityInput;

    public CardPage(WebDriver driver) {
        super(driver);
    }

    public void setQty(String quantity) {
        quantityInput.clear();
        quantityInput.sendKeys("1000");
        System.out.println("halo");
    }
}
