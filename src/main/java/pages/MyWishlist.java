package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyWishlist extends PageObject{

    public MyWishlist(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductNames() {
        List<WebElement> productNames = driver.findElements(By.xpath("//h3[@class=\"product-name\"]"));
        return productNames.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
