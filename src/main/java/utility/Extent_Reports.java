package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class Extent_Reports extends TestBase
{
	static ExtentReports report;
	public static ExtentReports getreportInstance()
	{
		if(report==null)
		{
			String reportName=new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
			ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter("C:\\Users\\nisha\\eclipse-workspace\\July4th_Framework\\Extent Report"+reportName+".html");
			report=new ExtentReports();
			report.attachReporter(htmlreporter);
			report.setSystemInfo("OS","Windows");
			report.setSystemInfo("Environment","SIT");
			report.setSystemInfo("Build","102.02.02.1234");
			report.setSystemInfo("Browser","Chrome");
			htmlreporter.config().setDocumentTitle("UI Testing Documents");
			htmlreporter.config().setReportName("UI Test Report");
		}
		return report;
	}

}
