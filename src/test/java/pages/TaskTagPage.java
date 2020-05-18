package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class TaskTagPage {
    public TaskTagPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "feed-add-post-form-tab-tasks")
    public WebElement taskTab;

    @FindBy(id = "tasks-task-priority-cb")
    public WebElement highPriCheckbox;

    @FindBy(xpath = "//input[@data-bx-id='task-edit-priority']")
    public WebElement highPriIcon;

    @FindBy(xpath = "//input[@data-bx-id='task-edit-title']")
    public WebElement thingToDoBox;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(css = ".feed-create-task-popup-title")
    public WebElement taskcreatedMessage;

    @FindBy(xpath = "//div/span[@class='popup-window-button']")
    public WebElement viewTaskButton;

    @FindBy(css = ".side-panel-iframe")
    public WebElement IFrameIndex2;

    @FindBy(xpath = "//*[@id='task-detail-important-button']")
    public WebElement highPriViewIcon;

    @FindBy(id = "lhe_button_editor_task-form-lifefeed_task_form")
    public WebElement visualEditorIcon;

    @FindBy(id = "bx-html-editor-tlbr-cnt-lifefeed_task_form")
    public WebElement visualEditor;

    @FindBy(id = "bx-b-uploadfile-task-form-lifefeed_task_form")
    public WebElement uploadFilesIcon;

    @FindBy(xpath = "(//div[@class='diskuf-files-entity diskuf-selectdialog bx-disk'])[3]")
    public WebElement uploadFilesWindow;

    @FindBy(xpath = "//input[@name='bxu_files[]']")
    public WebElement uploadFromLocalFile;

    @FindBy(xpath = "//tbody[@class='diskuf-placeholder-tbody']/tr")
    public List<WebElement> verifyLocalFiles;

    @FindBy(xpath = "//tbody[@class='diskuf-placeholder-tbody']/tr/td[4]")
    public List<WebElement> allInsertInTextButton;

    @FindBy(xpath = "(//iframe[@class='bx-editor-iframe'])[2]")
    public WebElement taskTextboxFrame;

    @FindBy(xpath = "//iframe[@class='side-panel-iframe']")
    public WebElement iframeTwoForQuotes;

    @FindBy(xpath = "//html/body/span")
    public List<WebElement> textBox;

    @FindBy(xpath = "//html/body/a")
    public List<WebElement> messageBoxAllLink;

    @FindBy(xpath = "(//span[text()='Select document from Bitrix24'])[5]")
    public WebElement uploadFromBitrix24;

    @FindBy(xpath = "//span[@class='popup-window-titlebar-text']")
    public WebElement selectDocumentBitrix24;

    @FindBy(xpath = "//div[@id='bx-file-dialog-content-DiskFileDialog']/div/div[3]/div//a")
    public List<WebElement> recentItemsFiles;

    @FindBy(xpath = "//span[.='Select document']")
    public WebElement selectButton;

    @FindBy(xpath = "//span[@title='My Drive']")
    public WebElement myDriveButton;

    @FindBy(xpath = "//a[.='Uploaded files']")
    public WebElement myDriveUploadFiles;

    @FindBy(xpath = "//div[@class='bx-file-dialog-content-wrap']/div//a")
    public List<WebElement> myDriveFiles;

    @FindBy(xpath = "//span[@title='Sales and marketing']")
    public WebElement salesAndMarketingButton;

    @FindBy(linkText = "Marketing and advertising")
    public WebElement marketingAndAdvertisingLink;

    @FindBy(xpath = "//div[@id='bx-file-dialog-content-DiskFileDialog']/div[3]/div//a")
    public List<WebElement> marketingAndAdvertisingFiles;

    @FindBy(linkText = "Quotes")
    public WebElement quotesLink;

    @FindBy(xpath = "//div[@id='bx-file-dialog-content-DiskFileDialog']/div[3]/div//a")
    public List<WebElement> quotesFiles;

    @FindBy(xpath = "(//span[text()='Download from external drive'])[5]")
    public WebElement uploadFromExternalDrive;

    @FindBy(css = ".ui-notification-balloon-message")
    public WebElement popUpMessage;

    @FindBy(xpath = "//span[.='Box']")
    public WebElement boxExternalDrive;

    @FindBy(xpath = "//span[@title='Dropbox']")
    public WebElement dropboxExternalDrive;

    @FindBy(xpath = "//span[@title='Google Drive']")
    public WebElement googleDriveExternalDrive;

    @FindBy(xpath = "//span[@title='Office 365']")
    public WebElement office365ExternalDrive;

    @FindBy(xpath = "//span[@title='OneDrive']")
    public WebElement oneDriveExternalDrive;

    @FindBy(xpath = "//span[@title='Yandex.Disk']")
    public WebElement yandexDiskExternalDrive;

    @FindBy(xpath = "(//span[@title='Quote text'])[2]")
    public WebElement doubleQuoteIcon;

    @FindBy(className= "bxhtmled-quote")
    public WebElement quoteTextBox;

    @FindBy(xpath = "//div[@id='task-detail-description']//tbody/tr/td")
    public WebElement verifyQuoteBox;

    @FindBy(id = "bx-b-mention-task-form-lifefeed_task_form")
    public WebElement addMentionIcon;

    @FindBy(xpath = "//a[.='Recent']")
    public WebElement addMentionRecent;

    @FindBy(xpath = "//span[@class='bx-finder-groupbox-content']/a")
    public List<WebElement> emailListInRecent;

    @FindBy(xpath = "//a[.='Employees and departments']")
    public WebElement addMentionEmpAndDep;

    @FindBy(xpath = "//div[@class='bx-finder-company-department-employees']/a")
    public List<WebElement> cyberVetEmailList;

    @FindBy(xpath = "(//span[@title='Link'])[2]")
    public WebElement linkIcon;

    @FindBy(className = "bx-core-adm-dialog-head-inner")
    public WebElement linkPopUpTitle;

    @FindBy(id = "linklifefeed_task_form-text")
    public WebElement textInLink;

    @FindBy(id = "linklifefeed_task_form-href")
    public WebElement urlInLink;

    @FindBy(id = "undefined")
    public WebElement saveInLink;

    @FindBy(className = "tasks-task-mpf-link")
    public WebElement checkListIcon;

    @FindBy(className = "task-checklist-title")
    public WebElement checkListTitle;

    @FindBy(xpath = "//div[@data-block-name='SE_CHECKLIST']/div/div/div[3]//span/input")
    public WebElement checkListThingsToDo;

    @FindBy(xpath = "(//span[.='add'])[2]")
    public WebElement checkListAddLink;

    @FindBy(xpath = "(//span[.='separator'])[2]")
    public WebElement checkListSeparator;

    @FindBy(xpath = "//div[@id='bx-component-scope-lifefeed_task_form-checklist']/div[3]/span/span/span[1]")
    public WebElement checkListAddIcon;

    @FindBy(xpath = "//div[@data-block-name='SE_CHECKLIST']/div/div/div[2]/div[2]/div/div/span[4]")
    public WebElement checkListXIcon;

    @FindBy(xpath = "//div[@class='js-id-checklist-is-items js-id-checklist-items-ongoing tasks-checklist-dropzone']/div//label/span[2]")
    public List<WebElement> checkListAllList;

    @FindBy(xpath = "//div[@id='bx-component-scope-lifefeed_task_form-checklist']/div[2]/div")
    public List<WebElement> verifySeparator;

    @FindBy(xpath = "//div[@data-bx-id='task-edit-additional-header']")
    public WebElement moreLink;

    @FindBy(xpath = "//div[@id='bx-component-scope-lifefeed_task_form-responsible']/span[2]/a[1]")
    public WebElement addMoreLink;

    @FindBy(linkText = "Recent")
    public WebElement addMoreRecent;

    @FindBy(xpath = "//div[@id='bx-component-scope-lifefeed_task_form-responsible']/span[1]/span/a")
    public List<WebElement> addMoreResponsiblePerList;

    @FindBy(xpath = "//tr/td/div/span/span[2]/a")
    public List<WebElement> addMoreRecentEmailList;

    @FindBy(xpath = "//div[@id='BXSocNetLogDestination']/span")
    public WebElement addMoreRecentXIcon;

    @FindBy(linkText = "Employees and departments")
    public WebElement addMoreEmploAndDep;

    @FindBy(xpath = "//div[@id='bx-lm-box-last-content']//div[2]/div[2]/div/a")
    public List<WebElement> addMoreEmpAllEmailList;

    @FindBy(linkText = "E-mail users")
    public WebElement addMoreEmailUser;

    @FindBy(xpath = "//span[@title='Cancel selection']")
    public List<WebElement> cancelSelections;

    @FindBy(xpath = "(//span[.='Created by'])[1]")
    public WebElement createdByLink;

    @FindBy(xpath = "//div[@id='bx-component-scope-lifefeed_task_form-originator']/span/span/a")
    public WebElement createByTextBoxWebElement;

    @FindBy(xpath = "//*[@id='bx-component-scope-lifefeed_task_form-originator']/span[2]/a")
    public WebElement createByChangeLink;

    @FindBy(xpath = "(//span[.='Participants'])[1]")
    public WebElement participantsLink;

    @FindBy(xpath = "//div[@data-bx-id='task-edit-accomplice']")
    public WebElement verifyParticipantsLink;

    @FindBy(xpath = "//div[@id='bx-component-scope-lifefeed_task_form-accomplice']/span/span/a")
    public List<WebElement> participantsList;

    @FindBy(xpath = "//*[@id='bx-component-scope-lifefeed_task_form-accomplice']/span[2]/a[2]")
    public WebElement participantsAddLink;

    @FindBy(xpath = "//*[@id='bx-component-scope-lifefeed_task_form-accomplice']/span[2]/a[1]")
    public WebElement participantsAddMoreLink;

    @FindBy(xpath = "(//span[.='Observers'])[1]")
    public WebElement observersLink;

    @FindBy(xpath = "//div[@data-bx-id='task-edit-auditor']")
    public WebElement verifyObserversLink;

    @FindBy(xpath = "//div[@id='bx-component-scope-lifefeed_task_form-auditor']/span/span/a")
    public List<WebElement> observersList;

    @FindBy(xpath = "//div[@id='bx-component-scope-lifefeed_task_form-auditor']/span[2]/a[2]")
    public WebElement observersAddLink;

    @FindBy(xpath = "//div[@id='bx-component-scope-lifefeed_task_form-auditor']/span[2]/a[1]")
    public WebElement observersAddMoreLink;

    // for AC-9

    @FindBy(xpath = "(//input[@data-bx-id='datepicker-display'])[1]")
    public WebElement deadlineBox;

    @FindBy(xpath = "(//div[@class='popup-window'])[2]")
    public WebElement verifyDateTable;

    @FindBy(css = ".bx-calendar-top-year")
    public WebElement yearClick;

    @FindBy(xpath = "//div[@id='bx-calendar-year-content']/span")
    public List<WebElement> yearSelect;

    @FindBy(css = ".bx-calendar-top-month")
    public WebElement monthClick;

    @FindBy(xpath = "//div[@class='bx-calendar-month-content']/span")
    public List<WebElement> monthSelect;

    @FindBy(xpath = "//a[@class='bx-calendar-cell' or @class='bx-calendar-cell bx-calendar-weekend']")
    public List<WebElement> daySelect;

    @FindBy(css = ".bx-calendar-cell.bx-calendar-active")
    public WebElement activeDay;

    @FindBy(xpath = "(//input[@class='bx-calendar-form-input'])[1]")
    public WebElement hourSend;

    @FindBy(xpath = "(//input[@class='bx-calendar-form-input'])[2]")
    public WebElement minuteSend;

    @FindBy(xpath = "//span[@class='bx-calendar-AM-PM-text']")
    public WebElement timeAmPmClick;

    @FindBy(xpath ="(//span[@class='bx-calendar-button-text'])[1]")
    public WebElement dateSelectButton;

    @FindBy(xpath = "(//input[@data-bx-id='datepicker-value'])[1]")
    public WebElement dateVerify;

    @FindBy(xpath = "//span[.='Time planning']")
    public WebElement timePlanning;

    @FindBy(xpath = "//div[@data-bx-id='task-edit-date-plan']")
    public WebElement verifyTimePlanning;

    @FindBy(xpath = "(//input[@data-bx-id='datepicker-value'])[2]")
    public WebElement verifyStartTaskDate;

    @FindBy(xpath = "(//input[@data-bx-id='datepicker-display'])[2]")
    public WebElement startTaskOn;

    @FindBy(xpath = "//input[@data-bx-id='dateplanmanager-duration']")
    public WebElement timeDuration;

    @FindBy(xpath = "(//input[@data-bx-id='datepicker-display'])[3]")
    public WebElement timeFinish;

    @FindBy(xpath = "(//input[@data-bx-id='datepicker-value'])[3]")
    public WebElement verifyFinishDate;

}
