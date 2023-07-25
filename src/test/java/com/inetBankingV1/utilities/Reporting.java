package com.inetBankingV1.utilities;
//import com.aventstack.extentreports.reporter.ex;
//listener class used to generate extent reports.
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
public ExtentSparkReporter htmlReporter;
public ExtentReports extent;
public ExtentTest  logger;

public void onStart(ITestContext testContext)
{
	Object timeStamp = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());
	String repName = "Test-Report-"+timeStamp+".html";
	htmlReporter=new ExtentSparkReporter(System.getProperty("user-dir")+"/test-output/"+repName);
	try {
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	extent=new ExtentReports();
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("Host name", "localhost");
	extent.setSystemInfo("Enviornment", "QA");
	extent.setSystemInfo("user", "pavan");
	
	htmlReporter.config().setDocumentTitle("InetBanking Test Project");
	htmlReporter.config().setReportName("Functional test automation report");
	htmlReporter.config().setTheme(Theme.DARK);
	
}
public void onTestSuccess(ITestResult tr)
{
	logger=extent.createTest(tr.getName());
	logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	
}
public void onTestFailure(ITestResult tr)
{
	logger=extent.createTest(tr.getName());
	logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
	File f=new File(screenshotpath);
	if(f.exists())
	{
		logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(screenshotpath));
	}
			
}
public void onTestSkipped(ITestResult tr)
{
	System.out.println("test skipped");
}
public void onFinish(ITestResult tr)
{
	System.out.println("test finished");
}

}
