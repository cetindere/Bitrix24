package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AnnouncementsPage {
    public AnnouncementsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    /**
     * Below I will locate all elements for AC #1
     */

    @FindBy(id = "feed-add-post-form-link-text")
    public WebElement moreBttn;

    @FindBy(xpath = "(//span[@class='menu-popup-item-text'])[3]")
    public WebElement announcementBttn;

    @FindBy(xpath = "//span[@id='bx-b-uploadfile-blogPostForm']")
    public WebElement uploadIcon;

    @FindBy(xpath = "//input[@name='bxu_files[]']")
    public WebElement uploadFilesAndImages;

    @FindBy(xpath = "(//span[contains(text(),'Download from external drive')])[1]")
    public WebElement externalDrive;

    @FindBy(xpath = "(//span[contains(text(),'Select document')])[1]")
    public WebElement selectDocument;

    @FindBy(xpath = "(//span[contains(text(),'Create')])[1]")
    public WebElement createDesktop;


    /**
     * Below I will locate all elements for AC #2
     */

    @FindBy(xpath = "//a[@id='bx-destination-tag']")
    public WebElement addMore;

    @FindBy(xpath = "//a[@href='#switchTab'][contains(text(),'Recent')]")
    public WebElement recent;

    @FindBy(xpath = "//a[@href='#switchTab'][contains(text(),'Employees and departments')]")
    public WebElement employeesAndDept;

    @FindBy(xpath = "//a[@href='#switchTab'][contains(text(),'E-mail users')]")
    public WebElement emailUser;

    // Locating Cyber Vet text, to verify that under this section there are contacts listed
    @FindBy(xpath = "//div[@class='bx-finder-company-department-text'][contains(text(),'Cyber Vet')]")
    public WebElement cyberVetText;

    // Locating "People" and "All employees" text, to verify that I am on the right page
    @FindBy(xpath = "//span[contains(text(),'People')]")
    public WebElement peopleText;

    @FindBy(xpath = "//div[@class='bx-finder-box-item-t7-name'][contains(text(),'All employees')]")
    public WebElement allEmployees;


    /**
     * Below, I will locate all elements for AC #3
     */

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link']/i")
    public WebElement linkBttn;

    // Locating "Link" text, to verify that I am on the right page
    @FindBy(xpath = "//span[@class='bx-core-adm-dialog-head-inner'][.='Link']")
    public WebElement linkText;

    @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-text']")
    public WebElement inputBoxLinkText;

    @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-href']")
    public WebElement inputBoxLinkUrl;

    @FindBy(id = "undefined")
    public WebElement submitBttn;

    /*
    // // Locating "Apply to Cybertek! " link, to verify that link is presented when hover over on text
    @FindBy(xpath = "//a[contains(text(),'Cybertek')]")
    public WebElement applyCybertek;
     */  // I DON'T KNOW, why it couldn't locate my text that I have typed?  NOT IMPORTANT!

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendBttn;


    /**
     * Below, I will locate all elements for AC #4
     */

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-video']/i")
    public WebElement insertVideo;

    @FindBy(xpath = "(//td[@class='bxhtmled-right-c'])[1]/input")
    public WebElement inputVideoBox;
    //
    @FindBy(id = "video_idPostFormLHE_blogPostForm-title")
    public WebElement videoTitle;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement saveBttn;

    /**
     * Below, I will locate all elements for AC #5
     */

    @FindBy(xpath = "//span[@title='Quote text']/i")
    public WebElement quoteText;

    // Iframe
    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement iFrame;

    @FindBy(xpath = "//blockquote[@class='bxhtmled-quote']/br")
    public WebElement inputQuoteText;

    @FindBy(id = "blog-submit-button-save")
    public WebElement submitBttn5;

    /**
     * Below, I will locate all elements for AC #6
     */

    @FindBy(id = "bx-b-mention-blogPostForm")
    public WebElement addMention;

    // Here I am only locating contact, that contains number '11'
    @FindBy(xpath = "//div[@class='bx-finder-box-item-t7-name'][contains(text(),'11')]")
    public WebElement contact11;

    @FindBy(xpath = "//div[@class='bx-finder-box-item-t7-name'][contains(text(),'77')]")
    public WebElement contact77;

    @FindBy(id = "blog-submit-button-save")
    public WebElement submitBttn6;

    /**
     * Below, I will locate all elements for AC #7
     */

    @FindBy(id = "lhe_button_editor_blogPostForm")
    public WebElement visualEditor;

    @FindBy(xpath = "/html/body")
    public WebElement body;

    /**
     * Below, I will locate all elements for AC #8
     */

    @FindBy(xpath = "//span[@id='lhe_button_title_blogPostForm']")
    public WebElement topic;

    @FindBy(xpath = "//input[@id='POST_TITLE']")
    public WebElement inputTopicBox;

    @FindBy(xpath = "//input[@id='POST_TITLE']")
    public WebElement verifyTopic;

    /**
     * Below, I will locate all elements for AC #9
     */

    @FindBy(xpath = "(//span[@class='feed-add-post-form-but-cnt feed-add-videomessage'])[1]")
    public WebElement recordVideo;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-blue'][.='Allow']")
    public WebElement allow;
}

