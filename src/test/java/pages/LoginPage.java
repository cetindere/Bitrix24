package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

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
        Driver.highlightElement(Driver.getDriver(), this.username);
        this.username.sendKeys(username);
        Driver.highlightElement(Driver.getDriver(), this.password);
        this.password.sendKeys(password);
        Driver.highlightElement(Driver.getDriver(), this.loginBttn);
        loginBttn.click();
    }


    public void login(String user) {
        String username;
        String password;
        switch (user) {
            case "helpdesk":
                username = ConfigurationReader.getProperty("helpdesk_username");
                password = ConfigurationReader.getProperty("helpdesk_password");
                Driver.highlightElement(Driver.getDriver(), this.username);
                this.username.sendKeys(username);
                Driver.highlightElement(Driver.getDriver(), this.password);
                this.password.sendKeys(password);
                Driver.highlightElement(Driver.getDriver(), this.loginBttn);
                loginBttn.click();
                break;
            case "helpdesk2":
                username = ConfigurationReader.getProperty("helpdesk_username2");
                password = ConfigurationReader.getProperty("helpdesk_password2");
                Driver.highlightElement(Driver.getDriver(), this.username);
                this.username.sendKeys(username);
                Driver.highlightElement(Driver.getDriver(), this.password);
                this.password.sendKeys(password);
                Driver.highlightElement(Driver.getDriver(), this.loginBttn);
                loginBttn.click();
                break;
            case "marketing":
                username = ConfigurationReader.getProperty("marketing_username");
                password = ConfigurationReader.getProperty("marketing_password");
                Driver.highlightElement(Driver.getDriver(), this.username);
                this.username.sendKeys(username);
                Driver.highlightElement(Driver.getDriver(), this.password);
                this.password.sendKeys(password);
                Driver.highlightElement(Driver.getDriver(), this.loginBttn);
                loginBttn.click();
                break;
            case "marketing2":
                username = ConfigurationReader.getProperty("marketing_username2");
                password = ConfigurationReader.getProperty("marketing_password2");
                Driver.highlightElement(Driver.getDriver(), this.username);
                this.username.sendKeys(username);
                Driver.highlightElement(Driver.getDriver(), this.password);
                this.password.sendKeys(password);
                Driver.highlightElement(Driver.getDriver(), this.loginBttn);
                loginBttn.click();
                break;
            case "hr":
                username = ConfigurationReader.getProperty("hr_username");
                password = ConfigurationReader.getProperty("hr_password");
                Driver.highlightElement(Driver.getDriver(), this.username);
                this.username.sendKeys(username);
                Driver.highlightElement(Driver.getDriver(), this.password);
                this.password.sendKeys(password);
                Driver.highlightElement(Driver.getDriver(), this.loginBttn);
                loginBttn.click();
                break;
            case "hr2":
                username = ConfigurationReader.getProperty("hr_username2");
                password = ConfigurationReader.getProperty("hr_password2");
                Driver.highlightElement(Driver.getDriver(), this.username);
                this.username.sendKeys(username);
                Driver.highlightElement(Driver.getDriver(), this.password);
                this.password.sendKeys(password);
                Driver.highlightElement(Driver.getDriver(), this.loginBttn);
                loginBttn.click();
                break;
            default:
                System.out.println("ERROR: Invalid user type provided!");
        }
    }
}

