package tests;

import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class US_4 extends TestBase {

    //1. User should be able to click on upload files icon to upload files and pictures from local disks, download from external drive, select documents from bixtrix24, and create files to upload.
    @Test
    public void AC_1(){
//        loginPage.login("helpdesk11@cybertekschool.com","UserUser");
        loginPage.login("helpdesk");
        wait.until(ExpectedConditions.elementToBeClickable(pollPage.poll));
        pollPage.poll.click();
        //click upload file
        wait.until(ExpectedConditions.elementToBeClickable(pollPage.uploadFile));
        pollPage.uploadFile.click();


    }


}
