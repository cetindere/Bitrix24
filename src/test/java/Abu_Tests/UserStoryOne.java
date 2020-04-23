package Abu_Tests;

import Utilities.BrowserUtils;
import Utilities.ConfigurationReader;
import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserStoryOne extends TestBase {

  @Test(description = "Login in, click on message then click upload files")
  public void test1() {
    test = report.createTest("Bitrix Message Upload Files Feature");

    getMessageBox();

    BrowserUtils.wait(1);
    test.info("Clicking Upload File Icon");
    messagePage.uploadFileIcon.click();

    BrowserUtils.wait(1);
    test.info("Verifying upload file & picture enabled");
    Assert.assertTrue(messagePage.dragAndDrop.isEnabled());

    BrowserUtils.wait(1);
    test.info("Verify if document text equal to expected text");
    Assert.assertEquals(messagePage.docBitx.getText(), "Select document from Bitrix24");
    test.info("Verify document element enabled");
    Assert.assertTrue(messagePage.docBitx.isEnabled());

    BrowserUtils.wait(1);
    test.info("Verify if element text equal to expected text");
    Assert.assertEquals(messagePage.externalDrive.getText(), "Download from external drive");
    test.info("Verify externalDriver element enabled");
    Assert.assertTrue(messagePage.externalDrive.isEnabled());

    BrowserUtils.wait(1);
    test.info("Verify if element text equal to expected text");
    Assert.assertEquals(messagePage.createDeskApp.getText(), "Create using Office 365");
    test.info("Verify CreateDeskApp element enabled");
    Assert.assertTrue(messagePage.createDeskApp.isEnabled());
    test.pass("Upload File Verified");
  }

  @Test(description = "add users from selecting contact from E-mail user, Employees and Departments and Recent contact lists.")
  public void test2() {
    test = report.createTest("Selecting Contact");
//    driver.get(ConfigurationReader.getProperty("url"));

    getMessageBox();

    BrowserUtils.wait(1);
    test.info("click in addMore icon");
    messagePage.addMore.click();

    BrowserUtils.wait(1);
    test.info("Select from Recent List");
    System.out.println(BrowserUtils.getElementsText(messagePage.recentList).get(1));

    BrowserUtils.wait(1);
    test.info("Select from E-mail user");
    messagePage.emailUser.click();

    BrowserUtils.wait(1);
    test.info("Select from Employees and Departments");
    messagePage.empAndDep.click();

    BrowserUtils.wait(1);
    test.info("Select from Employees and Departments List");
    System.out.println(BrowserUtils.getElementsText(messagePage.empEmailList).get(1));
    messagePage.empEmailList.get(2).click();
    test.pass("Add users selection is verified");

  }

  @Test(description = "User should be able to attach link by clicking on the link icon.")
  public void test3() {
    test = report.createTest("Attach link");

    getMessageBox();

    BrowserUtils.wait(1);
    test.info("click in Attach Link icon");
    messagePage.linkAttachIcon.click();

    messagePage.cancelUrlAttach.click();
    test.pass("Attach link icon verified");
  }

  @Test(description = "insert videos by clicking on the video icon and entering the video URL.")
  public void test5() {
    test = report.createTest("Insert Videos");

    getMessageBox();

    BrowserUtils.wait(1);
    test.info("click in Video icon");
    messagePage.videoAttachIcon.click();

    BrowserUtils.wait(1);
    test.info("Entering url");
    messagePage.videoUrl.sendKeys("https://www.youtube.com/watch?v=0QGdZM9YCSA");

    BrowserUtils.wait(2);
    test.pass("Insert Videos icon verified");
  }

  @Test(description = "User should be able to create a quote by clicking on the Comma icon.")
  public void test4() {
    test = report.createTest("Create a Quote");

    getMessageBox();

    BrowserUtils.wait(1);
    test.info("click in Quote icon");
    messagePage.quoteIcon.click();
    BrowserUtils.wait(1);
    test.pass("Quote icon verified");
  }

  @Test(description = "Add mention icon and select contacts from the lists provided in dropdown.")
  public void test6() {
    test = report.createTest("Add mention and select contacts from list");

    getMessageBox();

    test.info("click in Mention icon");
    messagePage.addMention.click();
    BrowserUtils.wait(1);

    test.info("Select Contact from list");
    messagePage.recentList.get(2).click();
    BrowserUtils.wait(1);
    test.pass("Mention icon verified");
  }

  @Test(description = "Visual Editor and see the editor text-bar displays on top of the message box.")
  public void test7() {
    test = report.createTest("Visual Editor display");
    getMessageBox();

    test.info("click in Visual editor icon");
    messagePage.visualEdIcon.click();
    BrowserUtils.wait(1);
    Assert.assertTrue(messagePage.testBarDisplay.isDisplayed());
    BrowserUtils.wait(1);
    test.pass("Visual editor verified");
  }

  @Test(description = "Topic icon to see the Message Topic text box displays on top of the message b")
  public void test8() {
    test = report.createTest("Topic Icon display");

    getMessageBox();

    test.info("click in Mention icon");
    messagePage.topic_text.click();
    BrowserUtils.wait(1);
    Assert.assertTrue(messagePage.msg_box.isDisplayed());
    BrowserUtils.wait(1);
    test.pass("Topic icon verified");
  }

  @Test(description = "Record Video tab to record a video and attach it with the message")
  public void test9() {
    test = report.createTest("Topic Icon display");

    getMessageBox();

    test.info("click Record video icon");
    messagePage.recordVideo.click();
    messagePage.allow.click();
    BrowserUtils.wait(1);

    test.info("video recording or access denied");
    wait.until(ExpectedConditions.visibilityOf(messagePage.cameraAccessDenied));
    if (messagePage.cameraAccessDenied.isDisplayed()) {
      System.out.println(messagePage.cameraAccessDenied.getText());
      messagePage.closeBttn.click();
    } else {
      messagePage.saveButton.click();
    }
    BrowserUtils.wait(1);
    test.pass("Record video verified");
  }

  //login method to message Box
  public void getMessageBox() {
    test.info("Login in as helpdesk");
    messagePage.login("helpdesk");
    BrowserUtils.waitForPageToLoad(2);

    test.info("clicking in message icon");
    messagePage.msgButton.click();
    BrowserUtils.wait(1);
  }
}
