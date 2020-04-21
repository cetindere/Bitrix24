package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PollPage {
    public PollPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    /*
    I will locate all webelements for AC1
    1. User should be able to click on upload files icon to upload files and pictures from local disks, download from external drive, select documents from bixtrix24, and create files to upload.
     */
    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-vote']/span")
    public WebElement poll;

    @FindBy(xpath = "//span[@id='bx-b-uploadfile-blogPostForm']")
    public WebElement uploadFile;

}
