package tests;
// Author: Edilbek Browne
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class US_7 extends TestBase {
    /*
    User Story #7:
    As a user, I should be able to send announcement from
    Announcement subheading from "More" under Activity Stream.
     */

    /**
     * 1. User should be able to click on upload files icon to upload files and pictures from local disks,
     * download from external drive, select documents from bixtrix24, and create files to upload.
     */
    @Test
    public void AC_1() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
        loginPage.login("helpdesk");
        wait.until(ExpectedConditions.titleContains("Portal"));
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.moreBttn));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.moreBttn);
        announcementsPage.moreBttn.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.announcementBttn));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.announcementBttn);
        announcementsPage.announcementBttn.click();

        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.uploadIcon));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.uploadIcon);
        announcementsPage.uploadIcon.click();

//        In this line I can upload a file from my Computer to Application, but I didnt get clear idea of AC1
//        testsPage.uploadFilesAndImages.sendKeys("/Users/EdilbekBrowne/Desktop/screenJava/Screen Shot 2020-04-05 at 12.40.57.png");

//        In this part I am checking whether user have these 4 option to upload a file
        assertTrue(announcementsPage.uploadFilesAndImages.isEnabled());
        assertEquals(announcementsPage.externalDrive.getText(), "Download from external drive");
        assertEquals(announcementsPage.selectDocument.getText(), "Select document from Bitrix24");
    }
    /**
     * 2. User should be able to add users and recipients from selecting contact from: E-mail user, Employees and Departments and Recent contact lists.
     */
    @Test
    public void AC_2() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
        // Here I have overloaded two methods in LoginPage class, in order to simplify the code.
        loginPage.login("helpdesk");
        wait.until(ExpectedConditions.titleContains("Portal"));
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.moreBttn));
        announcementsPage.moreBttn.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.announcementBttn));
        announcementsPage.announcementBttn.click();

        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.addMore));
        announcementsPage.addMore.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.emailUser));
        announcementsPage.emailUser.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.employeesAndDept));
        announcementsPage.employeesAndDept.click();
        assertTrue(announcementsPage.cyberVetText.getText().contains("Cyber"));
        //TODO -> I need to specify, do I need to add the contacts
        // in the input box or should I verify that they are listed???
        assertEquals(announcementsPage.cyberVetText.getText(), "Cyber Vet");
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.recent));
        announcementsPage.recent.click();
        wait.until(ExpectedConditions.textToBePresentInElement(announcementsPage.peopleText, "People"));
        assertTrue(announcementsPage.peopleText.getText().contains("People"));
        assertTrue(announcementsPage.allEmployees.isDisplayed());
    }
    /**
     * 3. User should be able to attach link by clicking on the link icon.
     */
    @Test
    public void AC_3() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
        loginPage.login("helpdesk");
        wait.until(ExpectedConditions.titleContains("Portal"));
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.moreBttn));
        announcementsPage.moreBttn.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.announcementBttn));
        announcementsPage.announcementBttn.click();

        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.linkBttn));
        announcementsPage.linkBttn.click();
        // In same cases, it fails here because it cannot open download page. I used IMPLICIT AND EXPLICIT waits.
        // Thread sleep can be a solution, too.
        wait.until(ExpectedConditions.textToBePresentInElement(announcementsPage.linkText, "Link"));
        softAssert.assertEquals(announcementsPage.linkText.getText(), "Link", "Link text, did not match. Failed");
        announcementsPage.inputBoxLinkText.sendKeys("Apply to Cybertek! Join our Big Family! ''Batch 15'' <3");
        announcementsPage.inputBoxLinkUrl.sendKeys("https://cybertekschool.com/apply-now/");
        announcementsPage.submitBttn.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.sendBttn));
        announcementsPage.sendBttn.click();
    }
    /**
     * 4. User should be able to insert videos by clicking on the video icon and entering the video URL.
     */
    @Test
    public void AC_4() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
        loginPage.login("helpdesk");
        wait.until(ExpectedConditions.titleContains("Portal"));
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.moreBttn));
        announcementsPage.moreBttn.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.announcementBttn));
        announcementsPage.announcementBttn.click();

        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.insertVideo));
        announcementsPage.insertVideo.click();
        wait.until(ExpectedConditions.visibilityOf(announcementsPage.inputVideoBox));
        announcementsPage.inputVideoBox.click();

        /**
         * Need to find out with Marufjon. When I perform manual testing, providing URL it finds.
         * But when I automate, the video can not be found. Bitrix is showing error:
         *  - [SOCKET] Socket connection error.;
         *  - [FVID404] The video was not found;
         */
        announcementsPage.inputVideoBox.sendKeys("https://www.youtube.com/watch?v=fvCdLmxnkj0");
        // continue
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(announcementsPage.videoTitle));
        // Pay attention to below code
        announcementsPage.saveBttn.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.saveBttn));
        announcementsPage.saveBttn.click();
//        wait.until(ExpectedConditions.visibilityOf(testsPage.iframe));
//        driver.switchTo().frame(testsPage.iframe);
        // solution: 1) more wait; 2) Use JavaScrip 3) I don't know
    }

    /**
     * 5. User should be able to create a quote by clicking on the Comma icon.
     */
    @Test
    public void AC_5() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
        loginPage.login("helpdesk");
        wait.until(ExpectedConditions.titleContains("Portal"));
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.moreBttn));
        announcementsPage.moreBttn.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.announcementBttn));
        announcementsPage.announcementBttn.click();

        announcementsPage.quoteText.click();
        /*
        In the TestsPage, I have located element,
        now I need to switch the frames in order to sendKeys();
        To switch frames you can use Index and WebElement (of the frame)
        Ex: driver.switchTo().frame(0);
         */
        driver.switchTo().frame(announcementsPage.iFrame);
        announcementsPage.inputQuoteText.sendKeys("“A person who never made a mistake never tried anything new.” – Albert Einstein");
        driver.switchTo().defaultContent();
        announcementsPage.submitBttn5.click();
    }

    /**
     * 6. User should be able to add mention by clicking on the Add mention icon
     * and select contacts from the lists provided in dropdown
     */
    @Test
    public void AC_6() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
        loginPage.login("helpdesk");
        wait.until(ExpectedConditions.titleContains("Portal"));
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.moreBttn));
        announcementsPage.moreBttn.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.announcementBttn));
        announcementsPage.announcementBttn.click();

        announcementsPage.addMention.click();
        announcementsPage.contact11.click();
        announcementsPage.addMention.click();
        announcementsPage.contact77.click();
        announcementsPage.submitBttn6.click();
    }

    /**
     * 7. User should be able to click on Visual Editor
     * and see the editor text-bar displays on top of the message box.
     */
    @Test
    public void AC_7() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
        loginPage.login("helpdesk");
        wait.until(ExpectedConditions.titleContains("Portal"));
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.moreBttn));
        announcementsPage.moreBttn.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.announcementBttn));
        announcementsPage.announcementBttn.click();

        announcementsPage.visualEditor.click();
        driver.switchTo().frame(0);
        // TODO: Need to find an answer, on jow to select the text using Selenium WebDriver
        announcementsPage.body.sendKeys("Hello, Cybertek People!!!");
        announcementsPage.body.sendKeys(Keys.COMMAND + "a");
//        actions.doubleClick(testsPage.body).doubleClick().build().perform();
        Thread.sleep(5000);
    }

    /**
     * 8. User should be able to click on the Topic icon to see the announcement
     * Topic text box displays on top of the message box.
     */

    @Test
    public void AC_8() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
        loginPage.login("helpdesk");
        wait.until(ExpectedConditions.titleContains("Portal"));
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.moreBttn));
        announcementsPage.moreBttn.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.announcementBttn));
        announcementsPage.announcementBttn.click();

        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.topic));
        announcementsPage.topic.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.verifyTopic));
        announcementsPage.inputTopicBox.sendKeys("Yes, user is able to see Topics text box");
    }

    @Test
    public void AC_9() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
        loginPage.login("helpdesk");
        wait.until(ExpectedConditions.titleContains("Portal"));
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.moreBttn));
        announcementsPage.moreBttn.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.announcementBttn));
        announcementsPage.announcementBttn.click();

        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.recordVideo));
        announcementsPage.recordVideo.click();
        wait.until((ExpectedConditions.elementToBeClickable(announcementsPage.allow)));
        driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-blue'][.='Allow']")).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        System.out.println(driver.switchTo().alert().getText());
    }


}
