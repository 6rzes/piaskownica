package pages;

import models.MobileSortBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;


public class MobilePage extends PageObject {

    @FindBys( { @FindBy(xpath = "//li[@class=\"item last\"]//h2[@class=\"product-name\"]") } )
    private List<WebElement> productNames;

    @FindBy(xpath = "//div[@class=\"sort-by\"]/select")
    private WebElement Select;
    private Select sortBySelect = new Select(Select);

    @FindBy(xpath = "//button[@title=\"Compare\"]")
    private WebElement compare;

    public MobilePage(WebDriver driver) {
        super(driver);
    }

    public void setSortOrder(MobileSortBy sortBy) {
        sortBySelect.selectByVisibleText(sortBy.getText());
    }

    public List<String> getItemNames() {
        return productNames.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getItemPriceByName(String itemName) {
        String locator = String.format("//a[@title=\"%s\"]/parent::h2/parent::div[@class=\"product-info\"]//span[@class=\"price\"]", itemName);
        return driver.findElement(By.xpath(locator)).getText();
    }

    public DetailsPage clickOnItemName(String itemName) {
        String locator = String.format("//a[@title=\"%s\"]", itemName);
        driver.findElement(By.xpath(locator)).click();
        return new DetailsPage(driver);
    }

    public CardPage addToCardByName(String itemName) {
        String locator = String.format("//a[@title=\"%s\"]/parent::h2/parent::div[@class=\"product-info\"]//button", itemName);
        driver.findElement(By.xpath(locator)).click();
        return new CardPage(driver);
    }

    public void addToCompareByName(String itemName) {
        String locator = String.format("//a[@title=\"%s\"]/parent::h2/parent::div[@class=\"product-info\"]//a[@class=\"link-compare\"]", itemName);
        driver.findElement(By.xpath(locator)).click();
    }

    public ComparePage clickCompareButton() {
        compare.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        return new ComparePage(driver);
    }

    public MyAccountPage addToWishlistByName(String itemName) {
        String locator = String.format("//a[@title=\"%s\"]/parent::h2/parent::div[@class=\"product-info\"]//a[@class=\"link-wishlist\"]", itemName);
        driver.findElement(By.xpath(locator)).click();
        return new MyAccountPage(driver);
    }

}
