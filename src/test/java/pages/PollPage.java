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
    1. User should be able to click on upload files icon to upload files and pictures from local disks,
     download from external drive, select documents from bixtrix24, and create files to upload.
     */
    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-vote']/span")
    public WebElement poll;

    @FindBy(xpath = "//span[@id='bx-b-uploadfile-blogPostForm']")
    public WebElement uploadFile;

    @FindBy(xpath= "//input[@name='bxu_files[]']")
    public WebElement uploadFilesAndImages;

    @FindBy(xpath = "(//span[contains(text(),'Select document')])[1]")
    public WebElement SelectDocBitrix;

    ////span[contains(text(),'Download from external drive')])[1]
    @FindBy(xpath= "(//span[contains(text(),'Download from external drive')])[1]")
    public WebElement externalDrive;

    @FindBy(xpath = "(//span[contains(text(),'Create')])[1]")
    public WebElement createDoc;




    @FindBy(className = "bxhtmled-button-link")
    public WebElement link;

    @FindBy(className = "bxhtmled-button-video")
    public WebElement insertVideo;

    @FindBy(className = "bxhtmled-button-quote")
    public WebElement quoteText;

    @FindBy(id = "bx-b-mention-blogPostFormbx-b-mention-blogPostForm" )
    public WebElement addMention ;

    @FindBy(className = "feed-add-tag")
    public WebElement addTag;

    @FindBy(xpath = "//span[@class='feed-add-post-form-but-cnt feed-add-videomessage'][1]")
    public WebElement recordVideo;

    /*
        2. User should be able to add users from selecting contact from
         E-mail user, Employees and Departments and Recent contact lists.

     */
    @FindBy(xpath= "//a[@id='bx-destination-tag']")
    public WebElement addMore;

    //-//a[@id='destLastTab_destination7168194']
    //"//a[@href='#switchTab'][contains(text(),'Recent')]"
    @FindBy(xpath= "//a[@href='#switchTab'][contains(text(),'Recent')]")
    public WebElement recentUser;

    @FindBy(xpath = "(//div[@class='bx-finder-box-item-t7-name'])[1]")
    public WebElement allEmployees;

    @FindBy(xpath = "//div[@id='popup-window-content-BXSocNetLogDestination']//a[2]")
    public WebElement employeesAndDepartments;

    @FindBy(xpath = "//div[@id='popup-window-content-BXSocNetLogDestination']//a[3]")
    public WebElement emailUser;

    @FindBy(className = "bx-finder-company-department-text")
    public WebElement cyberVet;

    @FindBy(xpath = "//span[@class='bx-finder-groupbox-name']")
    public WebElement people;











}
