package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPage1 {
  public TestPage1(){
    PageFactory.initElements(Driver.getDriver(),this);
  }
   /*
      store all elements for all Acceptance Criteria's,
        each providing with information to it.
    */

   //AC #11. User should be able to click on upload files icon to upload files and pictures from local disks, download from external drive, select documents from bixtrix24, and create files to upload.


  @FindBy(xpath = "//span[contains(text(),'Message')]")
  public WebElement msgButton;
  @FindBy(id = "bx-b-uploadfile-blogPostForm")
  ////div[@class='feed-add-post-form-wrap']//div//div[@class='diskuf-uploader']
  public WebElement uploadFileIcon;
  @FindBy(xpath = "//div[@class='feed-add-post-form-wrap']//div//div[@class='diskuf-uploader']")
  public WebElement dragAndDrop;
  @FindBy(xpath = "(//span[@class='wd-fa-add-file-light-title-text'])[2]")
  public WebElement externalDrive;
  @FindBy(xpath = "(//span[.='Select document from Bitrix24'])[1]")
  public WebElement docBitx;
  @FindBy(xpath = "(//span[contains(text(),'Create')])[1]")
  public WebElement createDeskApp;
  @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
  public WebElement msgIframe;
  @FindBy(xpath = "//a[.='negative1.jpg']")
  public WebElement fileSelected;
  @FindBy(xpath = "//span[.='Select document']")
  public WebElement selectButton;

 //AC#2 User should be able to add users from selecting contact from E-mail user, Employees and Departments and Recent contact lists.

  @FindBy(id = "bx-destination-tag")
  public WebElement addMore;
  @FindBy(xpath = "//a[@class='bx-finder-box-tab bx-lm-tab-email']")
  public WebElement emailUser;
  @FindBy(xpath = "//a[@class='bx-finder-box-tab bx-lm-tab-last bx-finder-box-tab-selected']")
  public WebElement recent;
  @FindBy(xpath = "//a[@class='bx-finder-box-tab bx-lm-tab-department']")
  public WebElement empAndDep;

  //AC #3 User should be able to attach link by clicking on the link icon.

  @FindBy(xpath = "//*[@id='bx-b-link-blogPostForm']/span/i")
  public WebElement linkAttachIcon;

  //AC 4. User should be able to insert videos by clicking on the video icon and entering the video URL.

  @FindBy(xpath = "//*[@id='bx-b-video-blogPostForm']/span/i")
  public WebElement videoAttachIcon;
  @FindBy(className = "bxhtmled-90-input")
  public WebElement videoUrl;

  //AC 5. User should be able to create a quote by clicking on the Comma icon.

  @FindBy(xpath = "//*[@id=\"bx-b-quote-blogPostForm\"]/span/i")
  public WebElement quoteIcon;

  //AC 6. User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.

  @FindBy(xpath = "//span[@id='bx-b-mention-blogPostForm']")
  public WebElement addMention;
//pick one of them to add a mention
//  @FindBy(id = "destLastTab_destination4901996")
//  public WebElement recent;
//  @FindBy(id = "destDepartmentTab_destination4901996")
//  public WebElement empAndDep;

  //AC 7. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.

  @FindBy(xpath = "//span[@class='feed-add-post-form-editor-btn feed-add-post-form-btn-active']")
  public WebElement visualEdIcon;
  @FindBy(xpath = "//span[@class='bxhtmled-top-bar-wrap']")
  public WebElement testBarDisplay;



  //AC 8. User should be able to click on the Topic icon to see the Message Topic text box displays on top of the message box.

  @FindBy(id = "lhe_button_title_blogPostForm")
  public WebElement topic_text;
  @FindBy(xpath = "//input[@placeholder='Topic']")
  public WebElement msg_box;


  //AC 9. User should be able to click on "Record Video" tab to record a video and attach it with the message.
  @FindBy(xpath = "//span[.='Record Video']")
  public WebElement recordVideo;
  @FindBy(xpath = "//span[.='Allow']")
  public WebElement allow;

  @FindBy(id = "blog-submit-button-save")
  public WebElement sendBttn;


}