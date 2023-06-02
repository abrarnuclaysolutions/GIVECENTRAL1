package com.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

import GIVECENTRAL1.GIVECENTRAL1.BaseClass;

public class Listenerclass extends BaseClass implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		BaseClass.screenshot(result.getName());
	}
}
