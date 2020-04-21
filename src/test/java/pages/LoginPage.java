package pages;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Located the username input box
    @FindBy(name = "USER_LOGIN")
    public WebElement username;
    // Located the password input box
    @FindBy(name = "USER_PASSWORD")
    public WebElement password;
    // located the button
    @FindBy(xpath = "//*[@*='submit']")
    public WebElement loginBttn;

    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginBttn.click();
    }

    public void login(String user) {
        String username;
        String password;
        switch (user) {
            case "helpdesk":
                username = ConfigurationReader.getProperty("helpdesk_username");
                password = ConfigurationReader.getProperty("helpdesk_password");

                this.username.sendKeys(username);

                this.password.sendKeys(password);
                loginBttn.click();
                break;
            case "marketing":
                username = ConfigurationReader.getProperty("marketing_username");
                password = ConfigurationReader.getProperty("marketing_password");
                this.username.sendKeys(username);
                this.password.sendKeys(password);
                loginBttn.click();
                break;
            case "hr":
                username = ConfigurationReader.getProperty("hr_username");
                password = ConfigurationReader.getProperty("hr_username");
                this.username.sendKeys(username);
                this.password.sendKeys(password);
                loginBttn.click();
                break;
            default:
                System.out.println("ERROR: Invalid user type provided!");
        }
    }
}
