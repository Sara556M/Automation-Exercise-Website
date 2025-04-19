package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class UtilsTests {

    WebDriver driver;
    static ExtentReports extent;
    ExtentTest test;

    public UtilsTests(WebDriver driver)
    {
        this.driver = driver ;
    }

    public void takeScreenShot(Method method) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("report/"+method.getName()+".png"));

    }

    public void createReport()
    {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("report/report.html");
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("My Report");
    }

    public void setStatus(Method method, ITestResult result) {
        test = extent.createTest(method.getName());
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Pass");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test Fail");
        }
        addAttachment(method);
    }

    public void addAttachment(Method method) {
        test.addScreenCaptureFromPath(method.getName() + ".png");
        test.log(Status.INFO, "<a href='" + method.getName() + ".avi'> Download Video</a>");
    }

    public void flushReport()
    {
        extent.flush();
    }
}
