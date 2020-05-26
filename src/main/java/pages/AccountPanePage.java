package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPanePage extends PageObject{



    @FindBy(xpath="//a[@title=\"Register\"]")
    private WebElement registerLink;


    public AccountPanePage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage clickOnRegister() {
        registerLink.click();
        return new RegisterPage(driver);
    }


}
