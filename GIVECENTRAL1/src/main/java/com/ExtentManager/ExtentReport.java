package com.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setexent() {
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
	public static void endreport() {
		extent.flush();
	}


}
