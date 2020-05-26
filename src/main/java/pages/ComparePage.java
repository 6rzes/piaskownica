package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ComparePage extends PageObject{

    @FindBy(xpath = "//h2[@class=\"product-name\"]")
    private List<WebElement> product_names;

    @FindBy(xpath = "//span[text()=\"Close Window\"]")
    private WebElement close_button;

    public ComparePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductNames() {
        return product_names.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void close() {
        close_button.click();

    }
}
