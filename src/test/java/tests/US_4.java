package tests;

import Utilities.BrowserUtils;
import Utilities.Driver;
import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PollPage;

import static org.testng.AssertJUnit.*;

public class US_4 extends TestBase {
    public void log(){
        loginPage.login("helpdesk");
        wait.until(ExpectedConditions.elementToBeClickable(pollPage.poll));
        test.info("user able to click on poll button");
        pollPage.poll.click();

    }

    //(DataProvider="upload")?
    @Test(priority = 1,description = "1. User should be able to click on upload files icon to upload files and pictures from local disks, download from external drive, select documents from bixtrix24, and create files to upload.")
    public void AC_1(){
        test=report.createTest("AC_1_iclal");
        test.info("user is logging as a helpdesk");

//      loginPage.login("helpdesk11@cybertekschool.com","UserUser");
        loginPage.login("helpdesk");
        wait.until(ExpectedConditions.elementToBeClickable(pollPage.poll));
        test.info("user able to click on poll button");
        pollPage.poll.click();
        //click upload file
        wait.until(ExpectedConditions.elementToBeClickable(pollPage.uploadFile));
        BrowserUtils.wait(3);


        pollPage.uploadFile.click();
        test.info("Upload file button is clickable");
        assertTrue(pollPage.uploadFile.isEnabled());
        pollPage.uploadFilesAndImages.sendKeys("/Users/Journalist/Desktop/summary.txt");
        BrowserUtils.wait(5);
        test.pass("Test passed and user is able to perform all above actions");

        /*
        **click select document from bitrix
        pollPage.SelectDocBitrix.click();
        **click create doc
        pollPage.createDoc.click();

        * *click externalDrive
        pollPage.externalDrive.click();
        * wait.until(ExpectedConditions.elementToBeClickable(pollPage.SelectDocBitrix));
        pollPage.SelectDocBitrix.click();

         */


    }

    @Test(description = "2. User should be able to add users from selecting contact from E-mail user, Employees and Departments and Recent contact lists.")
    public void AC_2(){
        test=report.createTest("AC2_iclal");
        log();
        test.info("click add more to add more contacts");
        wait.until(ExpectedConditions.elementToBeClickable(pollPage.addMore));
        pollPage.addMore.click();
        BrowserUtils.wait(3);

        wait.until(ExpectedConditions.elementToBeClickable(pollPage.employeesAndDepartments));
        pollPage.employeesAndDepartments.click();
        assertTrue(pollPage.cyberVet.getText().contains("Cyber"));
        assertEquals(pollPage.cyberVet.getText(),"Cyber Vet");

        //test.info("click email users");

        wait.until(ExpectedConditions.elementToBeClickable(pollPage.emailUser));
        pollPage.emailUser.click();

        test.info("verify page contains \"cyber\"");


        //test.info("click recent user");
        wait.until(ExpectedConditions.elementToBeClickable(pollPage.recentUser));
        pollPage.recentUser.click();

        test.info("\"People\" is present on the page");
        wait.until(ExpectedConditions.textToBePresentInElement(pollPage.people,"People"));
        assertTrue(pollPage.people.getText().contains("People"));
        test.info("Verified, section \"All Employees\" is displayed");

        assertTrue(pollPage.allEmployees.isDisplayed());
        test.pass("\"PASS\" - authorized user, is able to perform above operations");




    }


}
