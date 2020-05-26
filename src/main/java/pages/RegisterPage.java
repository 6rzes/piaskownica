package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageObject{
    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "middlename")
    private WebElement middleName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "email_address")
    private WebElement emailAddress;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirmation")
    private WebElement confirmation;

    @FindBy(xpath = "//button[@title=\"Register\"]")
    private WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    public RegisterPage setFirstName(String firstName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        return this;
    }

    public RegisterPage setMiddleName(String middleName) {
        this.middleName.clear();
        this.middleName.sendKeys(middleName);
        return this;
    }

    public RegisterPage setLastName(String lastName) {
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        return this;
    }

    public RegisterPage setEmailAddress(String emailAddress) {
        this.emailAddress.clear();
        this.emailAddress.sendKeys(emailAddress);
        return this;
    }

    public RegisterPage setPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
        return this;
    }

    public RegisterPage setConfirmation(String confirmation) {
        this.confirmation.clear();
        this.confirmation.sendKeys(confirmation);
        return this;
    }
    public MyAccountPage clickRegister() {
        registerButton.click();
        return new MyAccountPage(driver);
    }

}
