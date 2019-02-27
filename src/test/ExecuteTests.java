package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import util.Browser;
import util.ExcelUtil;
import util.ExcelUtilXSSF;
import util.GeneralUtil;
import util.SendEmailWithAttachments;


public class ExecuteTests {

	public static String targetServerURL;
	public static String buildType;
	
	public enum XVASelection {
		XVAFeature, Description, Execute
	}

	public static void main(String[] args) throws Exception {
		
		if (args.length > 0) {
			targetServerURL = args[0];
			buildType = args[1];
		}
		
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		
		//String packageName = ExecuteTests.class.getClass().getPackage().getName();
		
		ExcelUtil executeTestDataExcel = new ExcelUtilXSSF(
				System.getProperty("user.dir")
						+ "/TestData/RunSelective.xlsx");
		
		List<Row> filterDataCollection=executeTestDataExcel.getRowsCollection("RunSelective");
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		
		for(Row row:filterDataCollection){
			if(row.getCell(XVASelection.Execute.ordinal()).toString().equalsIgnoreCase("Y")){
				String className = row.getCell(XVASelection.XVAFeature.ordinal()).toString();
				XmlSuite suite = new XmlSuite();
		        suite.setName("Suite: " + className);
		        XmlTest test = new XmlTest(suite);
		        test.setName("Tests: " + className);
		        List<XmlClass> classes = new ArrayList<XmlClass>();
				classes.add(new XmlClass("test" + "." + className));
				test.setXmlClasses(classes);
				suites.add(suite);
			}
		}
		
		TestNG testng = new TestNG();
		testng.setOutputDirectory(GeneralUtil.testOutputDirectory);
        testng.setXmlSuites(suites);
        ITestNGListener listener = new util.ExtentReporterNG();
		testng.addListener(listener);
		testng.run();	
		Browser.quitBrowser();
		if (args.length > 1) {
			SendEmailWithAttachments email = new SendEmailWithAttachments(args);
			email.notifyResults();
		}
	}		
}
