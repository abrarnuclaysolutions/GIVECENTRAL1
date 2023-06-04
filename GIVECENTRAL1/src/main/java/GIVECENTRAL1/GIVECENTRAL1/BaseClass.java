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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ExtentManager.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends ExtentReport {
	
	public static WebDriver driver;
	//Chrome Driver Setup
	@BeforeMethod
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
	
	@BeforeSuite
	public void BeforeSuite() {
		ExtentReport.setexent();
	}

	@AfterSuite
	public void AfterSuite() {
		ExtentReport.endreport();
	}
	@AfterMethod
	public void cb() {
		driver.close();
	}
}
