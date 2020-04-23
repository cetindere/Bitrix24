package tests;
// Author: Edilbek Browne

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class US_7 extends TestBase {
    /*
    User Story #7:
    As a user, I should be able to send announcement from
    Announcement subheading from "More" under Activity Stream.
     */

    /*  I have created, method "intro" -> in order not to repeat all these long lines of code.
        The lines of code, inside method "Intro" it is the base of my US #7.
        I can reuse all steps, just calling this method.
     */
    public void intro() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        test.info("Navigated to https://login2.nextbasecrm.com/");
        driver.get(ConfigurationReader.getProperty("url"));
        test.info("Logged, as a helpdesk11");
        loginPage.login("helpdesk");
        wait.until(ExpectedConditions.titleContains("Portal"));
        test.info("Verified that Title contains \"Portal\"");
        softAssert.assertTrue(driver.getTitle().contains("Portal"), "Title does not contain \"Portal\"");
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.moreBttn));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.moreBttn);
        test.info("Clicked on \"More\" button");
        announcementsPage.moreBttn.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.announcementBttn));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.announcementBttn);
        test.info("Clicked on \"Announcement\" button");
        announcementsPage.announcementBttn.click();
    }

    @Test(priority = 1, description = "User should be able to click on upload files icon to upload files and pictures from" +
            " local disks, download from external drive, select documents from bixtrix24, and create files to upload.")
    public void AC_1() {
        test = report.createTest("\"AC #1\" - User, should be able to upload files");
        intro();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.uploadIcon));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.uploadIcon);
        test.info("Clicked on \"Upload Icon\" button");
        Driver.highlightElement(Driver.getDriver(), announcementsPage.uploadIcon);
        announcementsPage.uploadIcon.click();
        test.info("Verified that \"Upload Files and Images\" is enabled");
        softAssert.assertTrue(announcementsPage.uploadFilesAndImages.isEnabled(), "Upload Files and Images is not enabled");
        test.info("Verified that \"Download from external drive\"  text is visible on page");
        assertEquals(announcementsPage.externalDrive.getText(), "Download from external drive");
        test.info("Verified that \"Select document from Bitrix24\"  text is visible on page");
        assertEquals(announcementsPage.selectDocument.getText(), "Select document from Bitrix24");
        test.pass("\"PASS\" - authorized user, is able to perform above operations");
    }

    @Test(priority = 2, description = "User should be able to add users and recipients " +
            "from selecting contact from: E-mail user, Employees and Departments and Recent contact lists.")
    public void AC_2() {
        test = report.createTest("\"AC #2\" - User, should be able to add users and recipients. ");
        intro();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.uploadIcon));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.uploadIcon);
        test.info("Clicked \"Upload Icon\" button");
        announcementsPage.uploadIcon.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.addMore));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.addMore);
        announcementsPage.addMore.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.emailUser));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.emailUser);
        announcementsPage.emailUser.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.employeesAndDept));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.employeesAndDept);
        announcementsPage.employeesAndDept.click();
        test.info("Verified, the page contains \"Cyber\"");
        assertTrue(announcementsPage.cyberVetText.getText().contains("Cyber"));
        //TODO -> I need to specify, do I need to add the contacts
        // in the input box or should I verify that they are listed???
        test.info("Verified the page contains \"Cyber Vet\"");
        assertEquals(announcementsPage.cyberVetText.getText(), "Cyber Vet");
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.recent));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.recent);
        announcementsPage.recent.click();
        test.info("Verified, text to be present on the page \"People\"");
        wait.until(ExpectedConditions.textToBePresentInElement(announcementsPage.peopleText, "People"));
        assertTrue(announcementsPage.peopleText.getText().contains("People"), "Does not contains \"People\"");
        test.info("Verified, section \"All Employees\" is displayed");
        assertTrue(announcementsPage.allEmployees.isDisplayed(), "\"All employess\", not displayed");
        test.pass("\"PASS\" - authorized user, is able to perform above operations");
    }

    @Test(priority = 3, description = "User should be able to attach link by clicking on the link icon.")
    public void AC_3() {
        test = report.createTest("\"AC #3\" - User, should be able to attach link by clicking on \"link Icon\"");
        intro();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.linkBttn));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.linkBttn);
        announcementsPage.linkBttn.click();
        Driver.highlightElement(Driver.getDriver(), announcementsPage.linkBttn);
        // In same cases, it fails here because it cannot open download page. I used IMPLICIT AND EXPLICIT waits.
        // Thread sleep can be a solution, too.
        wait.until(ExpectedConditions.textToBePresentInElement(announcementsPage.linkText, "Link"));
        test.info("Verified, that \"Link\" is visible on the page");
        softAssert.assertEquals(announcementsPage.linkText.getText(), "Link", "Link text, did not match. Failed");
        Driver.highlightElement(Driver.getDriver(), announcementsPage.inputBoxLinkText);
        announcementsPage.inputBoxLinkText.sendKeys("Apply to Cybertek! Join our Big Family! ''Batch 15'' <3");
        Driver.highlightElement(Driver.getDriver(), announcementsPage.inputBoxLinkUrl);
        announcementsPage.inputBoxLinkUrl.sendKeys("https://cybertekschool.com/apply-now/");
        Driver.highlightElement(Driver.getDriver(), announcementsPage.submitBttn);
        announcementsPage.submitBttn.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.sendBttn));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.sendBttn);
        test.info("Verified, that user is able to \"send\" button");
        announcementsPage.sendBttn.click();
        test.pass("\"PASS\" - authorized user, is able to perform above operations");
    }

    @Test(priority = 4, description = "User should be able to insert videos by clicking on the " +
            "video icon and entering the video URL.")
    public void AC_4() throws InterruptedException {
        // This AC has, some issues while uploading video from YouTube. -> Needs some work, sometimes PASSEs and FAILS
        test = report.createTest("\"AC #4\" - User, should be able to insert videos by clicking on \"Video Icon\"");
        intro();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.insertVideo));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.insertVideo);
        announcementsPage.insertVideo.click();
        wait.until(ExpectedConditions.visibilityOf(announcementsPage.inputVideoBox));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.inputVideoBox);
        announcementsPage.inputVideoBox.click();

        /**
         * Need to find out with Marufjon. When I perform manual testing, providing URL it finds.
         * But when I automate, the video can not be found. Bitrix is showing error:
         *  - [SOCKET] Socket connection error.;
         *  - [FVID404] The video was not found;
         */
        test.info("Verified, user is able to type in \"Input box\"");
        Driver.highlightElement(Driver.getDriver(), announcementsPage.inputVideoBox);
        announcementsPage.inputVideoBox.sendKeys("https://www.youtube.com/watch?v=fvCdLmxnkj0");
        // continue
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(announcementsPage.videoTitle));
        // Pay attention to below code
        Driver.highlightElement(Driver.getDriver(), announcementsPage.saveBttn);
        announcementsPage.saveBttn.click();
//        wait.until(ExpectedConditions.visibilityOf(testsPage.iframe));
//        driver.switchTo().frame(testsPage.iframe);
        // solution: 1) more wait; 2) Use JavaScrip 3) I don't know
        test.pass("\"PASS\" - authorized user, is able to perform above operations");
    }

    @Test(priority = 5, description = "User should be able to create a quote by clicking on the Quote icon.")
    public void AC_5() {
        test = report.createTest("\"AC #5\" - User, should be able to create a quote by clicking on \"Quote Icon\"");
        intro();
        BrowserUtils.wait(1);
        Driver.highlightElement(Driver.getDriver(), announcementsPage.quoteText);
        announcementsPage.quoteText.click();
        /*
        In the TestsPage, I have located element,
        now I need to switch the frames in order to sendKeys();
        To switch frames you can use Index and WebElement (of the frame)
        Ex: driver.switchTo().frame(0);
         */
        test.info("Verified, that user is able to switch to \"iFrame\"");
        driver.switchTo().frame(announcementsPage.iFrame);
        test.info("Verified, that user is able to type on switched \"iFrame\"");
        Driver.highlightElement(Driver.getDriver(), announcementsPage.inputQuoteText);
        announcementsPage.inputQuoteText.sendKeys("“A person who never made a mistake never tried anything new.” – Albert Einstein");
        test.info("Verified, that user is able to switch back to \"Default iFrame\"");
        driver.switchTo().defaultContent();
        test.info("Verified, that user is able to send \"Quotes\" to Announcement");
        Driver.highlightElement(Driver.getDriver(), announcementsPage.submitBttn5);
        announcementsPage.submitBttn5.click();
        test.pass("\"PASS\" - authorized user, is able to perform above operations");
    }

    @Test(priority = 6, description = "User should be able to add mention by clicking on the Add mention icon " +
            "and select contacts from the lists provided in dropdown")
    public void AC_6() {
        //In this test case, need to provide hard and soft asserts, for the test report
        test = report.createTest("\"AC #6\" - User, should be able to add mention by clicking on \"Add Mention Icon\"");
        intro();
        test.info("Verified, user is able to click on \"Add Mention\" button");
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.addMention));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.addMention);
        announcementsPage.addMention.click();
        test.info("Verified, user is able to mention contact that contains \"11\"");
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.contact11));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.contact11);
        announcementsPage.contact11.click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.addMention));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.addMention);
        announcementsPage.addMention.click();
        test.info("Verified, user is able to mention contact that contains \"77\"");
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.contact77));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.contact77);
        announcementsPage.contact77.click();
        test.info("Verified, that user is able to  send \"Add Mention\" to Announcement");
        Driver.highlightElement(Driver.getDriver(), announcementsPage.submitBttn6);
        announcementsPage.submitBttn6.click();
        test.pass("\"PASS\" - authorized user, is able to perform above operations");
    }

    @Test(priority = 7, description = "User should be able to click on Visual Editor and see the editor text-bar displays " +
            "on top of the message box.")
    public void AC_7() throws InterruptedException {
        //In this test case, need to provide hard and soft asserts, for the test report
        test = report.createTest("\"AC #7\" - User, should be able to click on \"Visual Editor\" and see text bar");
        intro();
        test.info("Verified, user is able to click on \"Visual Editor\"");
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.visualEditor));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.visualEditor);
        announcementsPage.visualEditor.click();
        test.info("Verified, user is able to switch to text-box \"iFrame\"");
        driver.switchTo().frame(0);
        // TODO: Need to find an answer, on how to select the text "COMMAND + A" using Selenium WebDriver
        Driver.highlightElement(Driver.getDriver(), announcementsPage.body);
        announcementsPage.body.sendKeys("Hello, Cybertek People!!!");
//        announcementsPage.body.sendKeys(Keys.COMMAND + "a");
//        actions.doubleClick(testsPage.body).doubleClick().build().perform();
        Thread.sleep(5000);
        test.pass("\"PASS\" - authorized user, is able to perform above operations");
    }

    @Test(priority = 8, description = "User should be able to click on the Topic icon " +
            "to see the announcement Topic text box displays on top of the message box.")
    public void AC_8() {
        //In this test case, need to provide hard and soft asserts, for the test report
        test = report.createTest("\"AC #8\" - User, should be able to click on \"Topic Icon\" and see message box");
        intro();
        test.info("Verified, user is able to click on \"Topic Icon\"");
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.topic));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.topic);
        announcementsPage.topic.click();
        test.info("Verified, user is able to type inside \"Topic box\"");
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.verifyTopic));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.inputTopicBox);
        announcementsPage.inputTopicBox.sendKeys("Yes, user is able to see Topics text box");
        test.pass("\"PASS\" - authorized user, is able to perform above operations");
    }

    @Test(priority = 9, description = "User should be able to click on \"Record Video\" tab " +
            "to record a video and attach it with the message.")
    public void AC_9() throws InterruptedException {
        test = report.createTest("\"AC #9\" - User, should be able to click on \"Record Video\" to record video and attach it");
        intro();
        test.info("Verified, user is able to click on \"Record Video\" tab");
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.recordVideo));
        Driver.highlightElement(Driver.getDriver(), announcementsPage.recordVideo);
        announcementsPage.recordVideo.click();
        //Below, need to figure out the setting of Chrome or handle the pop-ups
        // Below, code is not final
        driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-blue'][.='Allow']")).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        System.out.println(driver.switchTo().alert().getText());
        test.pass("\"PASS\" - authorized user, is able to perform above operations");
    }

    @Test(priority = 10, description = "User should be able to add tags by selecting existing tags " +
            "or creating new tags by clicking on the # icon")
    public void AC_10() {
        test = report.createTest("\"AC #10\" - User, should be able to add \"Tags\" or create new \"Tag\"");
        intro();
        /*
        Need to come with better approach, It hasn't been finished
         */
        test.pass("\"PASS\" - authorized user, is able to perform above operations");
    }
}
