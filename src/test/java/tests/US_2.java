package tests;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
    USER STORY
        2. As a user, I should be able to assign tasks by clicking on Task tab under Active Stream.
 */

public class US_2 extends TestBase {

    BrowserUtils browserUtils = new BrowserUtils();

    public void intro(){

        //1.Go to the login page of the website
        test.info("Go to the login page of the website");
        String url = ConfigurationReader.getProperty("url");
        String username = ConfigurationReader.getProperty("helpdesk_username");
        String password = ConfigurationReader.getProperty("helpdesk_password");
        driver.get(url);
        //2.Enter the User valid username and password
        //3.Click the "LOGIN" button
        test.info("Enter the User valid username and password and Click the LOGIN button");
        loginPage.login(username, password);
        //4. Verify that user on the homepage
        test.info("Verify that user on the homepage");
        String expectedTitle = "Portal";
        wait.until(ExpectedConditions.titleContains("Portal"));
        String actualTitle = driver.getTitle().substring(driver.getTitle().indexOf('P'));
        Assert.assertEquals(expectedTitle, actualTitle);
        //5. User can click the TASK functionality
        test.info("User can click the TASK functionality");
        taskTagPage.taskTab.click();
    }

    @Test(priority = 0, description = "User should be able to click on \"High Priority\" checkbox to set the current task to a top priority task.")
    public void ac_1() {
        test = report.createTest("AC-1 -> User, should be able to upload files");
        intro();
        //6. User can write message in the 'Things to do' textbox
        test.info("User can write message in the 'Things to do' textbox");
        wait.until(ExpectedConditions.visibilityOf(taskTagPage.thingToDoBox));
        taskTagPage.thingToDoBox.sendKeys("Java was fun from Muradil and Selenium is fun from Marufjon");
        //7. User can click the High Priority checkbox
        test.info("User can click the High Priority checkbox");
        taskTagPage.highPriCheckbox.click();
        //8. Verify user clicked  the High Priority checkbox
        test.info("Verify user clicked  the High Priority checkbox");
        String highPriIconStr = taskTagPage.highPriIcon.getAttribute("value");
        Assert.assertEquals(highPriIconStr, "2");
        //9. User can click the SEND button
        test.info("User can click the SEND button");
        taskTagPage.sendButton.click();
        //10. Verify user created that task
        test.info("Verify user created that task");
        String pop_upExpectedMessage = "Task has been created";
        String pop_upActualMessage = taskTagPage.taskcreatedMessage.getText();
        Assert.assertEquals(pop_upExpectedMessage, pop_upActualMessage);
        //11. User can click the VIEW TASK button
        test.info("User can click the VIEW TASK button");
        taskTagPage.viewTaskButton.click();
        //12. Verify user see the High Priority icon on the task after sent it
        test.info("Verify user see the High Priority icon on the task after sent it");
        wait.until(ExpectedConditions.visibilityOf(taskTagPage.IFrameIndex2));
        driver.switchTo().frame(taskTagPage.IFrameIndex2);
        wait.until(ExpectedConditions.visibilityOf(taskTagPage.highPriViewIcon));
        String highPriViewIconStr = taskTagPage.highPriViewIcon.getAttribute("data-priority");
        Assert.assertEquals(highPriViewIconStr, "2");
        test.pass("Bitrox24 2. User Story's 1. AC tested");
    }

    @Test(priority = 1, description = "User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.")
    public void ac_2() {
        test = report.createTest("AC-2 -> User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.");
        intro();
        //6. User can click on  the Visual Editor icon( A character )
        test.info("User can click on  the Visual Editor icon( A character )");
        taskTagPage.visualEditorIcon.click();
        //7. Verify the editor text-bar displays on top of the message box.
        test.info("Verify the editor text-bar displays on top of the message box.");
        String visualEditorActual = taskTagPage.visualEditor.getAttribute("style");
        String visualEditorExpected = "width: 100%; opacity: inherit;";
        Assert.assertEquals(visualEditorExpected, visualEditorActual);
        test.pass("Bitrix24 2. User Story's 2. AC tested");
    }

    @Test(priority = 2, description = "User should be able to click on upload files icon to upload files and pictures from local disks," +
            " download from external drive, select documents from bitrix24, and create files to upload.")
    public void ac_3() {
        test = report.createTest("AC-3 -> User should be able to click on upload files icon to upload files and pictures from local disks,\n" +
                "download from external drive, select documents from bitrix24, and create files to upload.");
        intro();
        //6. User can click the upload files icon
        test.info("User can click the upload files icon");
        taskTagPage.uploadFilesIcon.click();
        //7. Verify user can see the Upload files
        test.info("Verify user can see the Upload files");
        String uploadFilesWindowExpected = "display: block; opacity: 1;";
        BrowserUtils.wait(1);
        String uploadFilesWindowsActual = taskTagPage.uploadFilesWindow.getAttribute("style");
        Assert.assertEquals(uploadFilesWindowExpected, uploadFilesWindowsActual);
        //8. Verify user uploaded files and images from Local driver(Computer)
        test.info("Verify user uploaded files and images from Local driver(Computer)");
        String filePathAll = "C:/Users/rojhat/Desktop/bitrix24Demo.txt";
        taskTagPage.uploadFromLocalFile.sendKeys(filePathAll);
        String[] filePath = filePathAll.split("/");
        String expectedLocalFileName = filePath[filePath.length - 1].substring(0, 12);
        boolean found = false;
        for (int i = 0; i < taskTagPage.verifyLocalFiles.size(); i++) {
            BrowserUtils.wait(1);
            if (taskTagPage.verifyLocalFiles.get(i).getText().contains(expectedLocalFileName)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
        // FOR ADD INSIDE TEXT BOX
        BrowserUtils.wait(2);
        if (taskTagPage.allInsertInTextButton.size() > 0) {
            for (int i = 0; i < taskTagPage.allInsertInTextButton.size(); i++) {
                if (taskTagPage.allInsertInTextButton.get(i).getText().contains("Insert in text")) {
                    taskTagPage.allInsertInTextButton.get(i).click();
                }
            }
        }
        //FOR In TEXT BOX VERIFY
        driver.switchTo().frame(taskTagPage.taskTextboxFrame);
        found = false;
        for (WebElement fileName : taskTagPage.textBox) {
            if (fileName.getText().contains(expectedLocalFileName)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
        driver.switchTo().defaultContent();
        //User can click the Select document from Bitrix24
        taskTagPage.uploadFromBitrix24.click();
        //User can see the Select one or more documents pop-up
        String expectedSelectDocPopUpTitle = "Select one or more documents";
        String actualSelectDocPopUpTitle = taskTagPage.selectDocumentBitrix24.getText();
        Assert.assertEquals(expectedSelectDocPopUpTitle, actualSelectDocPopUpTitle);
        //User can select any file in the Recent items
        String fileNameClickedResentItems = "";
        if (taskTagPage.recentItemsFiles.size() > 0) {
            fileNameClickedResentItems = taskTagPage.recentItemsFiles.get(1).getText();
            taskTagPage.recentItemsFiles.get(1).click();
        } else {
            System.out.println("There are not any files in the Recent items");
        }
        //Verify user can see the SELECT button color is green after selected the file
        String selectButtonGreen = taskTagPage.selectButton.getAttribute("class");
        Assert.assertTrue(selectButtonGreen.contains("accept"));
        //User can click the SELECT DOCUMENT button
        taskTagPage.selectButton.click();
        //Verify user can see the file or image in the Attached files and images page
        found = false;
        for (int i = 0; i < taskTagPage.verifyLocalFiles.size(); i++) {
            if (taskTagPage.verifyLocalFiles.get(i).getText().contains(fileNameClickedResentItems)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
        //User can click the Insert in text button on the Attached files and images page
        BrowserUtils.wait(2);
        if (taskTagPage.allInsertInTextButton.size() > 0) {
            for (int i = 0; i < taskTagPage.allInsertInTextButton.size(); i++) {
                if (taskTagPage.allInsertInTextButton.get(i).getText().contains("Insert in text")) {
                    taskTagPage.allInsertInTextButton.get(i).click();
                }
            }
        }
        //Verify user can see the file or image in the message box.
        //FOR In TEXT BOX VERIFY
        driver.switchTo().frame(taskTagPage.taskTextboxFrame);
        found = false;
        for (WebElement fileName : taskTagPage.textBox) {
            if (fileName.getText().contains(expectedLocalFileName)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
        driver.switchTo().defaultContent();
        //9. User can click the Select document from Bitrix24
        test.info("User can click the Select document from Bitrix24");
        taskTagPage.uploadFromBitrix24.click();
        //User can see the Select one or more documents pop-up
        expectedSelectDocPopUpTitle = "Select one or more documents";
        actualSelectDocPopUpTitle = taskTagPage.selectDocumentBitrix24.getText();
        Assert.assertEquals(expectedSelectDocPopUpTitle, actualSelectDocPopUpTitle);
        //User can select any file in the My Drive
        taskTagPage.myDriveButton.click();
        taskTagPage.myDriveUploadFiles.click();
        String fileNameClickedMyDrive = "";
        if (taskTagPage.myDriveFiles.size() > 0) {
            BrowserUtils.wait(1);
            taskTagPage.myDriveFiles.get(2).click();
            fileNameClickedMyDrive = taskTagPage.myDriveFiles.get(2).getText();
        } else {
            System.out.println("There are not any files in the Recent items");
        }
        //Verify user can see the SELECT button color is green after selected the file
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.selectButton));
        String selectButtonGreenMyDrive = taskTagPage.selectButton.getAttribute("class");
        Assert.assertTrue(selectButtonGreenMyDrive.contains("accept"));
        //User can click the SELECT DOCUMENT button
        taskTagPage.selectButton.click();
        //Verify user can see the file or image in the Attached files and images page
        found = false;
        for (int i = 0; i < taskTagPage.verifyLocalFiles.size(); i++) {
            if (taskTagPage.verifyLocalFiles.get(i).getText().contains(fileNameClickedMyDrive)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
        //User can click the Insert in text button on the Attached files and images page
        BrowserUtils.wait(2);
        if (taskTagPage.allInsertInTextButton.size() > 0) {
            for (int i = 0; i < taskTagPage.allInsertInTextButton.size(); i++) {
                if (taskTagPage.allInsertInTextButton.get(i).getText().contains("Insert in text")) {
                    taskTagPage.allInsertInTextButton.get(i).click();
                }
            }
        }
        //Verify user can see the file or image in the message box.
        driver.switchTo().frame(taskTagPage.taskTextboxFrame);
        found = false;
        for (WebElement fileName : taskTagPage.textBox) {
            if (fileName.getText().contains(fileNameClickedMyDrive)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
        driver.switchTo().defaultContent();
        //User can click the Select document from Bitrix24
        taskTagPage.uploadFromBitrix24.click();
        //User can see the Select one or more documents pop-up
        expectedSelectDocPopUpTitle = "Select one or more documents";
        actualSelectDocPopUpTitle = taskTagPage.selectDocumentBitrix24.getText();
        Assert.assertEquals(expectedSelectDocPopUpTitle, actualSelectDocPopUpTitle);
        //User can select any file in the Sales ans marketing
        taskTagPage.salesAndMarketingButton.click();
        taskTagPage.marketingAndAdvertisingLink.click();
        String fileNameClickedMarketing = "";
        if (taskTagPage.marketingAndAdvertisingFiles.size() > 0) {
            BrowserUtils.wait(1);
            taskTagPage.marketingAndAdvertisingFiles.get(0).click();
            fileNameClickedMarketing = taskTagPage.marketingAndAdvertisingFiles.get(0).getText();
        } else {
            System.out.println("There are not any files in the Recent items");
        }
        //Verify user can see the SELECT button color is green after selected the file
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.selectButton));
        String selectButtonGreenMarketing = taskTagPage.selectButton.getAttribute("class");
        Assert.assertTrue(selectButtonGreenMarketing.contains("accept"));
        //User can click the SELECT DOCUMENT button
        taskTagPage.selectButton.click();
        //Verify user can see the file or image in the Attached files and images page
        found = false;
        for (int i = 0; i < taskTagPage.verifyLocalFiles.size(); i++) {
            if (taskTagPage.verifyLocalFiles.get(i).getText().contains(fileNameClickedMarketing)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
        //User can click the Insert in text button on the Attached files and images page
        BrowserUtils.wait(2);
        if (taskTagPage.allInsertInTextButton.size() > 0) {
            for (int i = 0; i < taskTagPage.allInsertInTextButton.size(); i++) {
                if (taskTagPage.allInsertInTextButton.get(i).getText().contains("Insert in text")) {
                    taskTagPage.allInsertInTextButton.get(i).click();
                }
            }
        }
        //Verify user can see the file or image in the message box.
        driver.switchTo().frame(taskTagPage.taskTextboxFrame);
        found = false;
        for (WebElement fileName : taskTagPage.textBox) {
            if (fileName.getText().contains(fileNameClickedMarketing)) {
                found = true;
                break;
            }
        }
        softAssert.assertTrue(found);
        driver.switchTo().defaultContent();
        //User can click the Select document from Bitrix24
        taskTagPage.uploadFromBitrix24.click();
        //User can see the Select one or more documents pop-up
        expectedSelectDocPopUpTitle = "Select one or more documents";
        actualSelectDocPopUpTitle = taskTagPage.selectDocumentBitrix24.getText();
        Assert.assertEquals(expectedSelectDocPopUpTitle, actualSelectDocPopUpTitle);
        //User can select any file in the Sales ans marketing
        taskTagPage.salesAndMarketingButton.click();
        taskTagPage.quotesLink.click();
        String fileNameClickedQuotes = "";
        if (taskTagPage.quotesFiles.size() > 0) {
            BrowserUtils.wait(1);
            taskTagPage.quotesFiles.get(0).click();
            fileNameClickedQuotes = taskTagPage.quotesFiles.get(0).getText();
        } else {
            System.out.println("There are not any files in the Recent items");
        }
        //Verify user can see the SELECT button color is green after selected the file
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.selectButton));
        String selectButtonGreenQuotes = taskTagPage.selectButton.getAttribute("class");
        Assert.assertTrue(selectButtonGreenQuotes.contains("accept"));
        //User can click the SELECT DOCUMENT button
        taskTagPage.selectButton.click();
        //Verify user can see the file or image in the Attached files and images page
        found = false;
        for (int i = 0; i < taskTagPage.verifyLocalFiles.size(); i++) {
            if (taskTagPage.verifyLocalFiles.get(i).getText().contains(fileNameClickedQuotes)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
        //User can click the Insert in text button on the Attached files and images page
        BrowserUtils.wait(2);
        if (taskTagPage.allInsertInTextButton.size() > 0) {
            for (int i = 0; i < taskTagPage.allInsertInTextButton.size(); i++) {
                if (taskTagPage.allInsertInTextButton.get(i).getText().contains("Insert in text")) {
                    taskTagPage.allInsertInTextButton.get(i).click();
                }
            }
        }
        //Verify user can see the file or image in the message box.
        driver.switchTo().frame(taskTagPage.taskTextboxFrame);
        found = false;
        for (WebElement fileName : taskTagPage.textBox) {
            if (fileName.getText().contains(fileNameClickedQuotes)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
        driver.switchTo().defaultContent();
        //10.Verify user upload files or image from external drive
        test.info("Verify user upload files or image from external drive");
        //User can click the Select document from Download from external drive
        String messagePopUpExpected = "The social networking service Google Docs is not configured. Please contact your Bitrix24 administrator.";
        taskTagPage.uploadFromExternalDrive.click();
        //User can see the Select one or more documents pop-up
        wait.until((ExpectedConditions.visibilityOf(taskTagPage.popUpMessage)));
        String messagePopUpActual = taskTagPage.popUpMessage.getText();
        expectedSelectDocPopUpTitle = "Select one or more documents";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='popup-window-titlebar-DiskFileDialog']/span")));
        actualSelectDocPopUpTitle = taskTagPage.selectDocumentBitrix24.getText();
        Assert.assertEquals(expectedSelectDocPopUpTitle, actualSelectDocPopUpTitle);
        //User can see ERROR
        Assert.assertEquals(messagePopUpActual, messagePopUpExpected);
        ///// BOX /////
        taskTagPage.boxExternalDrive.click();
        //// DROPBOX /////
        taskTagPage.dropboxExternalDrive.click();
        ////  GOOGLE DRIVE //////
        taskTagPage.googleDriveExternalDrive.click();
        //// OFFICE 365 ////////
        taskTagPage.office365ExternalDrive.click();
        //// ONEDRIVE ///////
        taskTagPage.oneDriveExternalDrive.click();
        ///// YANDEX.DISK //////
        taskTagPage.yandexDiskExternalDrive.click();
        //11.Verify user upload the created using files or image (Office 365)
        test.pass("Bitrix24 2. User Story's 3. AC tested");

    }

    @Test(priority = 3, description = "User should be able to create a quote by clicking on the Comma icon.")
    public void ac_4() {
        test = report.createTest("AC-4 -> User should be able to create a quote by clicking on the Comma icon.");
        intro();
        //6. User can click the Double Quote icon(quote text)
        test.info("User can click the Double Quote icon(quote text)");
        taskTagPage.doubleQuoteIcon.click();
        //7. Verify user can see the Quote text box
        test.info("Verify user can see the Quote text box");
        driver.switchTo().frame(taskTagPage.taskTextboxFrame);
        Assert.assertTrue(taskTagPage.quoteTextBox.isEnabled());
        //8. User can write some quote
        test.info("User can write some quote");
        String sentQuoteBox = "Coding is important";
        taskTagPage.quoteTextBox.sendKeys(sentQuoteBox);
        Assert.assertTrue(taskTagPage.quoteTextBox.getText().trim().contains("Coding is important"));
        driver.switchTo().defaultContent();
        // for we can SEND it we have to write some thing in the Things to do
        //9. User can click the SEND button
        test.info("User can click the SEND button");
        taskTagPage.thingToDoBox.sendKeys("Selenium and Java ");
        taskTagPage.sendButton.click();
        //10. Verify user can see that  quote in the Message box
        test.info("Verify user can see that  quote in the Message box");
        taskTagPage.viewTaskButton.click();
        BrowserUtils.wait(1);
        driver.switchTo().frame(taskTagPage.iframeTwoForQuotes);
        System.out.println("taskTagPage.verifyQuoteBox.getText() = " + taskTagPage.verifyQuoteBox.getText());
        System.out.println(sentQuoteBox);
        Assert.assertEquals(sentQuoteBox, taskTagPage.verifyQuoteBox.getText());
        test.pass("Bitrix24 2. User Story's 4. AC tested");
    }

    @Test(priority = 4, description = "User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.")
    public void ac_5() {
        test = report.createTest("AC-5 -> User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.");
        intro();
        //6.User can click the Add Mention ( Like to a person icon)
        test.info("User can click the Add Mention ( Like to a person icon)");
        taskTagPage.addMentionIcon.click();
        //7.User can select any email address in the Recent tag
        test.info("User can select any email address in the Recent tag");
        taskTagPage.addMentionRecent.click();
        String emailClicked = "";
        if (taskTagPage.emailListInRecent.size() > 0) {
            emailClicked = taskTagPage.emailListInRecent.get(0).getText();
            taskTagPage.emailListInRecent.get(0).click();
        } else {
            System.out.println("There is not any email address");
        }
        //8.Verify user added the email address in the message box
        test.info("Verify user added the email address in the message box");
        //FOR In TEXT BOX VERIFY
        driver.switchTo().frame(taskTagPage.taskTextboxFrame);
        boolean found = false;
        for (WebElement fileName : taskTagPage.textBox) {
            if (fileName.getText().contains(emailClicked)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
        driver.switchTo().defaultContent();
        //9.User can click the Add Mention ( Like to a person icon)
        test.info("User can click the Add Mention ( Like to a person icon)");
        taskTagPage.addMentionIcon.click();
        //10.User can click the Employees and departments
        test.info("User can click the Employees and departments");
        taskTagPage.addMentionEmpAndDep.click();
        //11.User can select any name or email address in the Employees and departments tag
        test.info("User can select any name or email address in the Employees and departments tag");
        emailClicked = "";
        if (taskTagPage.cyberVetEmailList.size() > 0) {
            emailClicked = taskTagPage.cyberVetEmailList.get(0).getText().trim();
            taskTagPage.cyberVetEmailList.get(0).click();
        } else {
            System.out.println("There is not any email address");
        }
        //12.Verify user can see that name or email address in the the message box
        test.info("Verify user can see that name or email address in the the message box");
        driver.switchTo().frame(taskTagPage.taskTextboxFrame);
        found = false;
        int number = emailClicked.indexOf("@");
        List<String> textBoxListStr = BrowserUtils.getElementsText(taskTagPage.textBox);
        System.out.println("emailClicked = " + emailClicked);
        for (String fileName : textBoxListStr) {
            if (fileName.contains(emailClicked)) {
                found = true;
            }

        }
        Assert.assertTrue(found);
        driver.switchTo().defaultContent();
        test.pass("Bitrix24 2. User Story's 5. AC tested");
    }

    @Test(priority = 5, description = "User should be able to attach link by clicking on the link icon.")
    public void ac_6() {
        test = report.createTest("AC-6 -> User should be able to attach link by clicking on the link icon.");
        intro();
        //6.User can click the Link icon
        test.info("User can click the Link icon");
        taskTagPage.linkIcon.click();
        //7.Verify user can see Link pop-up
        test.info("Verify user can see Link pop-up");
        Assert.assertEquals(taskTagPage.linkPopUpTitle.getText(), "Link");
        //8.User can fill out Link pop-up
        test.info("User can fill out Link pop-up");
        String sendNameOfUrl = "Berkadem";
        taskTagPage.textInLink.sendKeys(sendNameOfUrl);
        taskTagPage.urlInLink.sendKeys("www.berkadem.com");
        //9.User can click the Save button on the Link pop-up
        test.info("User can click the Save button on the Link pop-up");
        taskTagPage.saveInLink.click();
        //10.Verify user can see that link text in the message box
        test.info("Verify user can see that link text in the message box");
        //FOR In TEXT BOX VERIFY All Link
        driver.switchTo().frame(taskTagPage.taskTextboxFrame);
        boolean found = false;
        for (WebElement fileName : taskTagPage.messageBoxAllLink) {
            if (fileName.getText().contains(sendNameOfUrl)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
        driver.switchTo().defaultContent();
        test.pass("Bitrix24 2. User Story's 6. AC tested");
    }

    @Test(priority = 6, description = "User should be able to click on Checklist to create checklists items(Things to do)." +
            "User can add a checklist item by clicking on add button or check mark." +
            "User can add separator lines between checklist items." +
            "User can delete a checklist item by clicking on x mark.")
    public void ac_7() {
        test = report.createTest("AC-1 -> User, should be able to upload files");
        intro();
        //6. User can click the Checklist icon
        test.info("ser can click the Checklist icon");
        taskTagPage.checkListIcon.click();
        //7. Verify user can see the textbox under the Checklist on the TASK page
        test.info("Verify user can see the textbox under the Checklist on the TASK page");
        Assert.assertEquals(taskTagPage.checkListTitle.getText(), "Checklist");
        //8. User can write anything in the textbox
        test.info("User can write anything in the textbox");
        String sentThingsToDo = "Java is fun";
        taskTagPage.checkListThingsToDo.sendKeys(sentThingsToDo);
        //9. User can click the add button
        test.info("User can click the add button");
        taskTagPage.checkListAddLink.click();
        //10. Verify user can see that word or sentence  under the Checklist on the TASK page
        test.info("Verify user can see that word or sentence  under the Checklist on the TASK page");
        boolean found = false;
        if (taskTagPage.checkListAllList.size() > 0) {
            for (WebElement each : taskTagPage.checkListAllList) {
                if (each.getText().trim().equals(sentThingsToDo.trim())) {
                    found = true;
                    break;
                }
            }
        }
        Assert.assertTrue(found);
        //11. User can write anything in the textbox
        test.info("User can write anything in the textbox");
        sentThingsToDo = "Selenium is fun";
        taskTagPage.checkListThingsToDo.sendKeys(sentThingsToDo);
        //12. User can click the check mark button
        test.info("User can click the check mark button");
        taskTagPage.checkListAddIcon.click();
        sentThingsToDo = "Cucumber is Fun";
        taskTagPage.checkListThingsToDo.sendKeys(sentThingsToDo);
        taskTagPage.checkListAddIcon.click();
        //13. Verify user can see that word or sentence
        test.info("Verify user can see that word or sentence");
        found = false;
        if (taskTagPage.checkListAllList.size() > 0) {
            for (WebElement each : taskTagPage.checkListAllList) {
                if (each.getText().trim().equals(sentThingsToDo.trim())) {
                    found = true;
                    break;
                }
            }
        }
        Assert.assertTrue(found);
        //14. User can click the separator button
        test.info("User can click the separator button");
        taskTagPage.checkListSeparator.click();
        //15.Verify user can see the separator line on the page
        test.info("Verify user can see the separator line on the page");
        found = false;
        if (taskTagPage.verifySeparator.size() > 0) {
            for (WebElement each : taskTagPage.verifySeparator) {
                if (each.getAttribute("class").trim().contains("separator")) {
                    found = true;
                    break;
                }
            }
            Assert.assertTrue(found);
        }
        //16.User can click x mark on same line the checklist for can delete the item
        test.info("User can click x mark on same line the checklist for can delete the item");
        if (taskTagPage.checkListAllList.size() > 0) {
            String beforeDeleteName = taskTagPage.checkListAllList.get(0).getText();
            taskTagPage.checkListXIcon.click();
            //18. Verify user deleted the checklist item
            if (taskTagPage.checkListAllList.size() > 0) {
                BrowserUtils.wait(1);
                for (WebElement each : taskTagPage.checkListAllList) {
                    found = false;
                    if (!(each.getText().trim().equals(beforeDeleteName.trim()))) {
                        found = true;
                    }
                }
            }
            Assert.assertTrue(found);
            test.pass("Bitrix24 2. User Story's 7. AC tested");
        }
    }
    @Test(priority = 7,description = "User can assign the tasks to employees by clicking on Add More and selecting contact from E-mail user, " +
            "Employees and Departments and Recent contact lists." +
            "Employees can be added in different assignment categories: Created By, Participants and Observer.")
    public void ac_8(){
        test = report.createTest("AC-8 -> User can assign the tasks to employees by clicking on Add More and selecting contact from E-mail user\n" +
                "Employees and Departments and Recent contact lists.\n " +
                "Employees can be added in different assignment categories: Created By, Participants and Observer.");
        intro();
        //6. User can click the Add more in the Responsible person box and add new person's email
        test.info("User can click the Add more in the Responsible person box and add new person's email");
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.addMoreLink));
        taskTagPage.addMoreLink.click();
        //User can click the Recent functionality
        taskTagPage.addMoreRecent.click();
        //User can select any name or email address in the Recent
        String clickedEmail = "";
        if (taskTagPage.addMoreRecentEmailList.size()>0){
            clickedEmail = taskTagPage.addMoreRecentEmailList.get(0).getText();
            taskTagPage.addMoreRecentEmailList.get(0).click();
            //User can click x mark for close the list pop-up
            taskTagPage.addMoreRecentXIcon.click();
        }else{
            System.out.println("There are not any E-mail address!!!");
        }
        //Verify user added it in the Responsible person box
        boolean found=false;
        for (WebElement each : taskTagPage.addMoreResponsiblePerList){
            if(each.getText().contains(clickedEmail)){
                found=true;
                break;
            }
        }
        Assert.assertTrue(found);
        //User can click the Add more in the Responsible person box
        taskTagPage.addMoreLink.click();
        //User can click the Employees and departments functionality
        taskTagPage.addMoreEmploAndDep.click();
        //User can select any name or email address in the Employees and departments
        clickedEmail = "";
        String listStr="";
        for (WebElement each:taskTagPage.addMoreResponsiblePerList){
            listStr+=each.getText()+" ";
        }
        for (int i=0;i<taskTagPage.addMoreEmpAllEmailList.size();i++){
            if (!(listStr.contains(taskTagPage.addMoreEmpAllEmailList.get(i).getText().trim()))){
                clickedEmail = taskTagPage.addMoreEmpAllEmailList.get(i).getText();
                taskTagPage.addMoreEmpAllEmailList.get(i).click();
                break;
            }
        }
        //User can click x mark for close the list pop-up
        taskTagPage.addMoreRecentXIcon.click();
        //Verify user added it in the Responsible person box
        found=false;
        for (WebElement each : taskTagPage.addMoreResponsiblePerList){
            if(clickedEmail.contains(each.getText())){
                found=true;
                break;
            }
        }
        Assert.assertTrue(found);
        //User can click the Add more in the Responsible person box
        taskTagPage.addMoreLink.click();
        //User can click the E-mail users functionality
        taskTagPage.addMoreEmailUser.click();
        //User can click x mark for close the list windows
        taskTagPage.addMoreRecentXIcon.click();
        //7.User can be added in different assignment categories with Created By link
        test.info("User can be added in different assignment categories with Created By link");
        if (taskTagPage.cancelSelections.size()>1) {
            for (int k = 1; k < taskTagPage.cancelSelections.size() - 1; k++) {
                BrowserUtils.wait(1);
                taskTagPage.cancelSelections.get(k).click();
                k--;
            }
        }else {
            //User can click the Create by link
            taskTagPage.createdByLink.click();
        }
        //User can select any name or email address in the Recent
        clickedEmail = "";
        for (int i=0;i<taskTagPage.addMoreRecentEmailList.size();i++){
            if (!(taskTagPage.addMoreResponsiblePerList.get(0).getText().equals(taskTagPage.addMoreRecentEmailList.get(i).getText().trim()))){
                clickedEmail = taskTagPage.addMoreRecentEmailList.get(i).getText();
                taskTagPage.addMoreRecentEmailList.get(i).click();
                break;
            }
        }
        found=false;
        if(clickedEmail.equals(taskTagPage.createByTextBoxWebElement.getText())){
            found=true;
        }
        Assert.assertTrue(found);
        if (taskTagPage.addMoreResponsiblePerList.size()>1) {
            for (int k = 1; k < taskTagPage.cancelSelections.size() - 1; k++) {
                BrowserUtils.wait(1);
                taskTagPage.cancelSelections.get(k).click();
                k--;
            }
        }else {
            //user can click the Change
            wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.createByChangeLink));
            taskTagPage.createByChangeLink.click();
        }
        //User can select any name or email address in the Employees and departments
        BrowserUtils.wait(2);
        taskTagPage.addMoreEmploAndDep.click();
        clickedEmail = "";
        for (int i=0;i<taskTagPage.addMoreEmpAllEmailList.size();i++){
            if (!((taskTagPage.addMoreResponsiblePerList.get(0).getText().equals(taskTagPage.addMoreEmpAllEmailList.get(i).getText().trim())))){
                clickedEmail = taskTagPage.addMoreEmpAllEmailList.get(i).getText();
                taskTagPage.addMoreEmpAllEmailList.get(i).click();
                break;
            }
        }
        found=false;
        wait.until(ExpectedConditions.visibilityOf(taskTagPage.createByTextBoxWebElement));
        if(clickedEmail.trim().equals(taskTagPage.createByTextBoxWebElement.getText().trim())){
            found=true;
        }
        Assert.assertTrue(found);
        //8. User can click the Participants button and add Email
        test.info("User can click the Participants button and add Email");
        taskTagPage.participantsLink.click();
        // verify user can see  the participants tab
        String actualName="pinable-block task-openable-block";
        wait.until(ExpectedConditions.visibilityOf(taskTagPage.verifyParticipantsLink));
        String expectedName=taskTagPage.verifyParticipantsLink.getAttribute("class");
        Assert.assertEquals(expectedName,actualName);
        // user can click the Add more link
        taskTagPage.participantsAddLink.click();
        // User can click the Recent Link
        taskTagPage.addMoreRecent.click();
        //User can select any name or email address in the Recent
        clickedEmail = "";
        if (taskTagPage.addMoreRecentEmailList.size()>0){
            clickedEmail = taskTagPage.addMoreRecentEmailList.get(0).getText();
            taskTagPage.addMoreRecentEmailList.get(0).click();
            //User can click x mark for close the list pop-up
            taskTagPage.addMoreRecentXIcon.click();
        }else{
            System.out.println("There are not any E-mail address!!!");
        }
        //Verify user added it in the Responsible person box
        found=false;
        for (WebElement each : taskTagPage.participantsList){
            if(each.getText().contains(clickedEmail)){
                found=true;
                break;
            }
        }
        Assert.assertTrue(found);
        //User can click the Add more in the Responsible person box
        taskTagPage.participantsAddMoreLink.click();
        //User can click the Employees and departments functionality
        taskTagPage.addMoreEmploAndDep.click();
        //User can select any name or email address in the Employees and departments
        clickedEmail = "";
        listStr="";

        for (WebElement each:taskTagPage.participantsList){
            listStr+=each.getText()+" ";
        }
        for (int i=0;i<taskTagPage.addMoreEmpAllEmailList.size();i++){
            if (!(listStr.contains(taskTagPage.addMoreEmpAllEmailList.get(i).getText().trim()))){
                clickedEmail = taskTagPage.addMoreEmpAllEmailList.get(i).getText();
                taskTagPage.addMoreEmpAllEmailList.get(i).click();
                break;
            }
        }
        //User can click x mark for close the list pop-up
        taskTagPage.addMoreRecentXIcon.click();
        //Verify user added it in the Responsible person box
        found=false;
        for (WebElement each : taskTagPage.participantsList){
            if(clickedEmail.contains(each.getText())){
                found=true;
                break;
            }
        }
        Assert.assertTrue(found);
        //User can click the Add more in the Responsible person box
        taskTagPage.participantsAddMoreLink.click();
        //User can click the E-mail users functionality
        taskTagPage.addMoreEmailUser.click();
        //User can select any name or email address in the  E-mail users
        // ---> Add some code for ERROR
        //User can click x mark for close the list windows
        taskTagPage.addMoreRecentXIcon.click();
        //Verify user added it in the Responsible person box
        //9. User can click the Observers button and add E-mail
        test.info("User can click the Observers button and add E-mail");
        taskTagPage.observersLink.click();
        // verify user can see  the participants tab
        actualName="pinable-block task-openable-block";
        wait.until(ExpectedConditions.visibilityOf(taskTagPage.verifyObserversLink));
        expectedName=taskTagPage.verifyObserversLink.getAttribute("class");
        Assert.assertEquals(expectedName,actualName);
        // user can click the Add more link
        taskTagPage.observersAddLink.click();
        // User can click the Recent Link
        taskTagPage.addMoreRecent.click();
        //User can select any name or email address in the Recent
        clickedEmail = "";
        if (taskTagPage.addMoreRecentEmailList.size()>0){
            clickedEmail = taskTagPage.addMoreRecentEmailList.get(0).getText();
            taskTagPage.addMoreRecentEmailList.get(0).click();
            //User can click x mark for close the list pop-up
            taskTagPage.addMoreRecentXIcon.click();
        }else{
            System.out.println("There are not any E-mail address!!!");
        }
        //Verify user added it in the Responsible person box
        found=false;
        for (WebElement each : taskTagPage.observersList){
            if(each.getText().contains(clickedEmail)){
                found=true;
                break;
            }
        }
        Assert.assertTrue(found);
        //User can click the Add more in the Responsible person box
        wait.until(ExpectedConditions.elementToBeClickable( taskTagPage.observersAddMoreLink));
        taskTagPage.observersAddMoreLink.click();
        //User can click the Employees and departments functionality
        wait.until(ExpectedConditions.elementToBeClickable( taskTagPage.addMoreEmploAndDep));
        taskTagPage.addMoreEmploAndDep.click();
        //User can select any name or email address in the Employees and departments
        clickedEmail = "";
        listStr="";

        for (WebElement each:taskTagPage.observersList){
            listStr+=each.getText()+" ";
        }
        for (int i=0;i<taskTagPage.addMoreEmpAllEmailList.size();i++){
            if (!(listStr.contains(taskTagPage.addMoreEmpAllEmailList.get(i).getText().trim()))){
                clickedEmail = taskTagPage.addMoreEmpAllEmailList.get(i).getText();
                taskTagPage.addMoreEmpAllEmailList.get(i).click();
                break;
            }
        }
        //User can click x mark for close the list pop-up
        taskTagPage.addMoreRecentXIcon.click();
        //Verify user added it in the Responsible person box
        found=false;
        for (WebElement each : taskTagPage.observersList){
            if(clickedEmail.contains(each.getText())){
                found=true;
                break;
            }
        }
        Assert.assertTrue(found);
        //User can click the Add more in the Responsible person box
        taskTagPage.observersAddMoreLink.click();
        //User can click the E-mail users functionality
        taskTagPage.addMoreEmailUser.click();
        //User can select any name or email address in the  E-mail users
        // ---> Add some code for ERROR
        //User can click x mark for close the list windows
        taskTagPage.addMoreRecentXIcon.click();
        //Verify user added it in the Responsible person box
        test.pass("Bitrix24 2. User Story's 8. AC tested");
    }

    @Test(priority = 8,description ="User can add Deadline, Time Planning by using date pickers.")
    public void ac_9(){
        test = report.createTest("AC-9 -> User can add Deadline, Time Planning by using date pickers.");
        intro();
        //6.User can add the Deadline
        test.info("User can add the Deadline");
        //User can click the Deadline input box
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.deadlineBox));
        taskTagPage.deadlineBox.click();
        //7.Verify user can see the time table
        test.info("Verify user can see the time table");
        Assert.assertTrue(taskTagPage.verifyDateTable.getAttribute("style").contains("block"));
        //User can select the year
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.yearClick));
        taskTagPage.yearClick.click();
        String year = taskTagPage.yearSelect.get(1).getText();
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.yearSelect.get(1)));
        taskTagPage.yearSelect.get(1).click();
        //User can select the month
        int monthNum = 1;
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.monthClick));
        taskTagPage.monthClick.click();
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.monthSelect.get(monthNum)));
        taskTagPage.monthSelect.get(monthNum).click();
        monthNum++;
        String month = "";
        if(monthNum>0&&monthNum<10){
            month = "0"+monthNum;
        }
        //User can select the day
        int day = 4;
        wait.until(ExpectedConditions.invisibilityOf(taskTagPage.daySelect.get(day)));
        if (taskTagPage.daySelect.get(day).getAttribute("class").contains("bx-calendar-weekend")){
            day++;
        }
        wait.until(ExpectedConditions.visibilityOf(taskTagPage.daySelect.get(day)));
        if (taskTagPage.daySelect.get(day).getAttribute("class").contains("bx-calendar-weekend")){
            day++;
        }
        String dayStr = String.valueOf(day);
        if (!(taskTagPage.activeDay.getText().equals(String.valueOf(day+1)))){
            BrowserUtils.wait(1);
            taskTagPage.daySelect.get(day).click();
        }
        day++;
        if (day>0&&day<10){
            dayStr = "0"+day;
        }
        //User can select the hour
        taskTagPage.hourSend.clear();
        String hour = "08";
        taskTagPage.hourSend.sendKeys(hour);
        //User can select the minute
        taskTagPage.minuteSend.clear();
        String minute = "25";
        taskTagPage.minuteSend.sendKeys(minute);
        //User can select the time AM-PM
        String timeAmPm = "PM";
        if (!(taskTagPage.timeAmPmClick.getText().equals(timeAmPm))){
            taskTagPage.timeAmPmClick.click();
        }
        String date = month+"/"+dayStr+"/"+year+" "+hour+":"+minute+":00 "+timeAmPm.toLowerCase();
        //User can click the Select button
        taskTagPage.dateSelectButton.click();
        //Verify user can see the date and time
        Assert.assertEquals(date,taskTagPage.dateVerify.getAttribute("value"));
        //8.User can use the Time planning
        test.info("User can use the Time planning");
        //User can click the Time planning link
        taskTagPage.timePlanning.click();
        //Verify user can see the Time planning tab
        wait.until(ExpectedConditions.visibilityOf(taskTagPage.verifyTimePlanning));
        Assert.assertEquals(taskTagPage.verifyTimePlanning.getAttribute("class"),"pinable-block task-openable-block");
        //User can click the Start task on's inputbox
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.startTaskOn));
        taskTagPage.startTaskOn.click();
        //Verify user can see the time table
        Assert.assertTrue(taskTagPage.verifyDateTable.getAttribute("style").contains("block"));
        //User can select the year
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.yearClick));
        taskTagPage.yearClick.click();
        year = taskTagPage.yearSelect.get(1).getText();
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.yearSelect.get(1)));
        taskTagPage.yearSelect.get(1).click();
        //User can select the month
        monthNum = 3;
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.monthClick));
        taskTagPage.monthClick.click();
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.monthSelect.get(monthNum)));
        taskTagPage.monthSelect.get(monthNum).click();
        monthNum++;
        month = String.valueOf(monthNum);
        if(monthNum>0&&monthNum<10){
            month = "0"+month;
        }
        //User can select the day
        day = 4;
        wait.until(ExpectedConditions.invisibilityOf(taskTagPage.daySelect.get(day)));
        if (taskTagPage.daySelect.get(day).getAttribute("class").contains("bx-calendar-weekend")){
            day++;
        }
        BrowserUtils.wait(1);
        if (taskTagPage.daySelect.get(day).getAttribute("class").contains("bx-calendar-weekend")){
            day++;
        }
        dayStr = String.valueOf(day);
        BrowserUtils.wait(1);
        if (!(taskTagPage.activeDay.getText().equals(String.valueOf(day+1)))){
            BrowserUtils.wait(2);
            taskTagPage.daySelect.get(day).click();
        }
        day++;
        if (day>0&&day<10){
            dayStr = "0"+day;
        }
        //User can select the hour
        taskTagPage.hourSend.clear();
        hour = "08";
        taskTagPage.hourSend.sendKeys(hour);
        //User can select the minute
        taskTagPage.minuteSend.clear();
        minute = "25";
        taskTagPage.minuteSend.sendKeys(minute);
        //User can select the time AM-PM
        timeAmPm = "PM";
        if (!(taskTagPage.timeAmPmClick.getText().equals(timeAmPm))){
            taskTagPage.timeAmPmClick.click();
        }
        date = month+"/"+dayStr+"/"+year+" "+hour+":"+minute+":00 "+timeAmPm.toLowerCase();
        //User can click the Select button
        taskTagPage.dateSelectButton.click();
        //Verify user can see the date and time
        Assert.assertEquals(date,taskTagPage.verifyStartTaskDate.getAttribute("value"));
        //9.User can add date and time in the Finish Text Box
        test.info("User can add date and time in the Finish Text Box");
        //User can click the Finish Text Box
        taskTagPage.timeFinish.click();
        //Verify user can see the time table
        Assert.assertTrue(taskTagPage.verifyDateTable.getAttribute("style").contains("block"));
        //User can select the year
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.yearClick));
        taskTagPage.yearClick.click();
        year = taskTagPage.yearSelect.get(1).getText();
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.yearSelect.get(1)));
        taskTagPage.yearSelect.get(1).click();
        //User can select the month
        monthNum = 3;
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.monthClick));
        BrowserUtils.wait(3);
        taskTagPage.monthClick.click();
        wait.until(ExpectedConditions.elementToBeClickable(taskTagPage.monthSelect.get(monthNum)));
        BrowserUtils.wait(3);
        taskTagPage.monthSelect.get(monthNum).click();
        monthNum++;
        month = String.valueOf(monthNum);
        if(monthNum>0&&monthNum<10){
            month = "0"+month;
        }
        //User can select the day
        day = 4;
        wait.until(ExpectedConditions.invisibilityOf(taskTagPage.daySelect.get(day)));
        if (taskTagPage.daySelect.get(day).getAttribute("class").contains("bx-calendar-weekend")){
            day++;
        }
        wait.until(ExpectedConditions.visibilityOf(taskTagPage.daySelect.get(day)));
        if (taskTagPage.daySelect.get(day).getAttribute("class").contains("bx-calendar-weekend")){
            day++;
        }
        dayStr = String.valueOf(day);
        if (!(taskTagPage.activeDay.getText().equals(String.valueOf(day+1)))){
            BrowserUtils.wait(1);
            taskTagPage.daySelect.get(day).click();
        }
        day++;
        if (day>0&&day<10){
            dayStr = "0"+day;
        }
        //User can select the hour
        taskTagPage.hourSend.clear();
        hour = "08";
        taskTagPage.hourSend.sendKeys(hour);
        //User can select the minute
        taskTagPage.minuteSend.clear();
        minute = "25";
        taskTagPage.minuteSend.sendKeys(minute);
        //User can select the time AM-PM
        timeAmPm = "PM";
        if (!(taskTagPage.timeAmPmClick.getText().equals(timeAmPm))){
            taskTagPage.timeAmPmClick.click();
        }
        date = month+"/"+dayStr+"/"+year+" "+hour+":"+minute+":00 "+timeAmPm.toLowerCase();
        //User can click the Select button
        taskTagPage.dateSelectButton.click();
        //Verify user can see the date and time
        Assert.assertEquals(date,taskTagPage.verifyFinishDate.getAttribute("value"));
        test.pass("Bitrix24 2. User Story's 9. AC tested");
    }

    @Test(priority = 10,description ="User can click on More to specify the task details.")
    public void ac_10(){
        test = report.createTest("AC-10 -> User can click on More to specify the task details.");
        intro();
        //6. User can click the More above the SEND button
        test.info("User can click the More above the SEND button");
        taskTagPage.moreLink.click();
        //7. Verify user can see the More page
        test.info("Verify user can see the More page");
        Assert.assertEquals(taskTagPage.moreLink.getAttribute("class"),"task-additional-alt opened");
        test.pass("Bitrix24 2. User Story's 10. AC tested");
    }
}
