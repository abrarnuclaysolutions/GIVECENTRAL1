package GIVECENTRAL1.GIVECENTRAL1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	@BeforeSuite
	public void setexent() {
		htmlReporter = new ExtentSparkReporter("/Users/harendersingh/git/GIVECENTRAL1/GIVECENTRAL1/test-output/ExtentReport/Givecentral.html");
		htmlReporter.config().setDocumentTitle("Givecentral Report");
		htmlReporter.config().setReportName("Givecentral Test Automation Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("ProjectName", "GIVECENTRAL");
		extent.setSystemInfo("Tester", "Abrar Khan and Kaif Aslam");
		extent.setSystemInfo("Browser", "Chrome");

	}
	@AfterSuite
	public void endreport() {
		extent.flush();
	}
	
	public static WebDriver driver;
	//Chrome Driver Setup
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		
	}
	//ScreenShot Methods
	public static String screenshot(String filename ) {
		// TODO Auto-generated method stub
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File("/Users/harendersingh/git/GIVECENTRAL1/GIVECENTRAL1/screenshotfolder/"+filename+".png");
		String gap = destinationfile.getAbsolutePath();
		try {
			FileUtils.copyFile(source, destinationfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gap;
	}
	@AfterMethod
	public void ccb(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+ " - Test ", ExtentColor.RED));
			String pathsshot = BaseClass.screenshot(result.getName());
			test.addScreenCaptureFromPath("/Users/harendersingh/git/GIVECENTRAL1/GIVECENTRAL1/screenshotfolder/"+result.getName()+".png");
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" - Test Case Skip", ExtentColor.YELLOW));
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" - Test Case Passed", ExtentColor.GREEN));
		}
		driver.close();
	}
}
