package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.BaseTest;

public class SuitListener extends BaseTest implements ITestListener, IAnnotationTransformer{
/*
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String filename = System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+result.getMethod().getMethodName();
		File file = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(filename+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ITestListener.super.onTestFailure(result);
	}
	
	*/
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	  String ss = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.BASE64);
	  logger.fail("Failure Screenshot: Please click 'Base64 img' link present below", MediaEntityBuilder.createScreenCaptureFromBase64String(ss).build());
	
		ITestListener.super.onTestFailure(result);
	}
	
	@Override
    public void onTestSuccess(ITestResult result) {
		String ss = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.BASE64);
		logger.pass("Passed Screenshot: Please click 'Base64 img' link present below", MediaEntityBuilder.createScreenCaptureFromBase64String(ss).build());
    }
	

	public void transform(ITestAnnotation annotation, Class testclass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
