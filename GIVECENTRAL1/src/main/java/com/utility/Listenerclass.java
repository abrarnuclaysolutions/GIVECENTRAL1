package com.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ExtentManager.ExtentReport;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import GIVECENTRAL1.GIVECENTRAL1.BaseClass;

public class Listenerclass extends ExtentReport implements ITestListener {
	
	
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }
//
    public void onTestSuccess(ITestResult result) {
    	if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" - Test Case Passed", ExtentColor.GREEN));
		}    }
    
	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+ " - Test ", ExtentColor.RED));
			String pathsshot = BaseClass.screenshot(result.getName());
			test.addScreenCaptureFromPath("/Users/harendersingh/git/GIVECENTRAL1/GIVECENTRAL1/screenshotfolder/"+result.getName()+".png");
		}	
	}
//    public void onFinish(ITestContext context) {
//        extent.flush();
//    }
	
}
