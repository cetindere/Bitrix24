package base;

import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.AnnouncementsPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public abstract class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;
    protected ExtentReports report;
    private ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;
    protected LoginPage loginPage;
    protected AnnouncementsPage announcementsPage;
    protected Actions actions;


    @BeforeSuite
    public void setUpSuite() {
        report = new ExtentReports();
        String path = System.getProperty("user.dir") + "/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(path);
        htmlReporter.config().setReportName("Bitrix24 Automated Tests");
        report.attachReporter(htmlReporter);
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
    }

    @AfterSuite
    public void tearDownSuite() {
        report.flush();
    }

    @Parameters("url")
    @BeforeMethod
    public void setUpMethod(@Optional String url) {
        loginPage = new LoginPage();
        announcementsPage = new AnnouncementsPage();
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
        softAssert = new SoftAssert();
        if (url == null) {
            driver.get(ConfigurationReader.getProperty("url"));
        } else {
            driver.get(url);
        }
        driver.get(ConfigurationReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDownMethod(ITestResult iTestResult) throws InterruptedException, IOException {
        // ITestResult gives information about current test: name, status
        // check if the test failed
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            // tell extent report that the test failed
            test.fail(iTestResult.getName());
            // take screen shot of the screen and save location
            String screenshot = BrowserUtils.getScreenshot(iTestResult.getName());
            // show path to screenshot
            test.addScreenCaptureFromPath(screenshot);
        }
        Thread.sleep(3000);
        Driver.closeDriver();
        softAssert.assertAll();
    }

}
