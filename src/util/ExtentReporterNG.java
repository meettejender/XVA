package util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.IExecutionListener;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 
public class ExtentReporterNG implements IReporter, ITestListener, IExecutionListener  {
    private ExtentReports extent;
    private long startTime;
    private long endTime;

 
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        extent = new ExtentReports(outputDirectory + File.separator + "ExtentReportsTestNG.html", true);
        int pass = 0;
        int fail = 0;
        int skip = 0;
        
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
 
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
 
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
                pass += context.getPassedTests().size();
                fail += context.getFailedTests().size();
                skip += context.getSkippedTests().size();       
            }
        }
        System.out.println("Tests Passed: " + String.valueOf(pass));
        System.out.println("Tests Failed: " + String.valueOf(fail));
        System.out.println("Tests Skipped: " + String.valueOf(skip));
        
        System.setProperty("TestsPassed", String.valueOf(pass));
        System.setProperty("TestsFailed", String.valueOf(fail));
        System.setProperty("TestsSkipped", String.valueOf(skip));
        System.setProperty("TotalTests", String.valueOf(pass+fail+skip));   
 
        extent.flush();
        extent.close();
        generateJSONNode(suites);
    }
	
	public void generateJSONNode(List<ISuite> suites)
	{
		int pass = 0;
        int fail = 0;
        int skip = 0;
        int total = 0;
        
        ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode = mapper.createObjectNode();
		ObjectNode resultSummary = objectNode.putObject("Test Results Summary");
		resultSummary.put("Total Tests", System.getProperty("TotalTests"));
		resultSummary.put("Tests Passed", System.getProperty("TestsPassed"));
		resultSummary.put("Tests Failed", System.getProperty("TestsFailed"));
		resultSummary.put("Tests Skipped", System.getProperty("TestsSkipped"));
		ObjectNode resultDetail = objectNode.putObject("Test Results Detail");
		ObjectNode suitesResults = resultDetail.putObject("Suites");
		
		ObjectNode suiteResults;
		ObjectNode suiteSummary;
		ObjectNode suiteDetails;
		ArrayNode suitePassed;
		ArrayNode suiteFailed;
		ArrayNode suiteSkipped;
		Collection<ITestNGMethod> passedMethods;
		Collection<ITestNGMethod> failedMethods;
		Collection<ITestNGMethod> skippedMethods;
		Iterator<ITestNGMethod> iterator;
		
        for (ISuite suite : suites) {
        	pass = 0;
            fail = 0;
            skip = 0;
            total = 0;

    		suiteResults = suitesResults.putObject(String.format("%s", suite.getName()));
            System.out.println(suite.getName());
            Map<String, ISuiteResult> result = suite.getResults();
             for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
 
                pass = context.getPassedTests().size();
                fail = context.getFailedTests().size();
                skip = context.getSkippedTests().size();
                total = pass+fail+skip;
                
                System.out.println("Tests Passed: " + String.valueOf(pass));
                System.out.println("Tests Failed: " + String.valueOf(fail));
                System.out.println("Tests Skipped: " + String.valueOf(skip));
                System.out.println("Tests Skipped: " + String.valueOf(total));
                
                suiteSummary = suiteResults.putObject("Summary");
        		suiteSummary.put("Total Tests", Integer.toString(total));
        		suiteSummary.put("Tests Passed", Integer.toString(pass));
        		suiteSummary.put("Tests Failed", Integer.toString(fail));
        		suiteSummary.put("Tests Skipped", Integer.toString(skip));
        		
        		suiteDetails = suiteResults.putObject("Details");  		

        		suitePassed = suiteDetails.putArray("Passed");
                System.out.println("Passed Tests...");              
                passedMethods = context.getPassedTests().getAllMethods();  
                
                iterator = passedMethods.iterator();
                while (iterator.hasNext()) {
                	String methodName = iterator.next().getMethodName();
                	suitePassed.add(methodName);
					System.out.println(methodName);
                }
                
				/*methods.forEach((temp) -> {
					suitePassed.add(temp.getMethodName());
					System.out.println(temp.getMethodName());
				});*/

				suiteFailed = suiteDetails.putArray("Failed");
				System.out.println("Failed Tests...");
				failedMethods = context.getFailedTests().getAllMethods();
                iterator = failedMethods.iterator();
                while (iterator.hasNext()) {
                	String methodName = iterator.next().getMethodName();
                	suiteFailed.add(methodName);
					System.out.println(methodName);
                }

				suiteSkipped = suiteDetails.putArray("Skipped");
				System.out.println("Skipped Tests...");
				skippedMethods = context.getSkippedTests().getAllMethods();
                iterator = skippedMethods.iterator();
                while (iterator.hasNext()) {
                	String methodName = iterator.next().getMethodName();
                	suiteSkipped.add(methodName);
					System.out.println(methodName);
                }        
            }
        }
        try {
        	String strObjectNode = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);
        	System.setProperty("TestResults", strObjectNode);
			//System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;
 
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.startTest(result.getMethod().getMethodName());
 
                test.getTest().setStartedTime(getTime(result.getStartMillis()));
                test.getTest().setEndedTime(getTime(result.getEndMillis()));
 
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
 
                String message = "Test " + status.toString().toLowerCase() + "ed";
 
                if (result.getThrowable() != null)
                    message = result.getThrowable().getMessage();
                test.log(status, message);
 
                extent.endTest(test);
            }
        }
    }
 
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();        
    }
    
 // This belongs to ITestListener and will execute only when the test is pass

 	public void onTestSuccess(ITestResult arg0) {

 		// This is calling the printTestResults method

 		printTestResults(arg0);

 	}

 	// This belongs to ITestListener and will execute only on the event of fail test

 	public void onTestFailure(ITestResult arg0) {

 		// This is calling the printTestResults method

 		printTestResults(arg0);

 	}

 	// This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped

 	public void onTestSkipped(ITestResult arg0) {

 		printTestResults(arg0);

 	}

 	private void printTestResults(ITestResult result) {

 		String status = null;
 		switch (result.getStatus()) {

 		case ITestResult.SUCCESS:

 			status = "Pass";

 			break;

 		case ITestResult.FAILURE:

 			status = "Failed";

 			break;

 		case ITestResult.SKIP:

 			status = "Skipped";

 		}

 		Reporter.log("Test Status: " + status, true);

 	}

 	@Override
 	public void onFinish(ITestContext arg0) {
 		// TODO Auto-generated method stub
 		
 	}

 	@Override
 	public void onStart(ITestContext arg0) {
 		// TODO Auto-generated method stub
 		
 	}

 	@Override
 	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
 		// TODO Auto-generated method stub
 		
 	}

 	@Override
 	public void onTestStart(ITestResult arg0) {
 		// TODO Auto-generated method stub
 		
 	}

	@Override
	public void onExecutionFinish() {
		// TODO Auto-generated method stub
        System.out.println("TestNG Execution is finished"); 
		endTime = Math.abs(System.currentTimeMillis());
		
		Date endDate = new Date(endTime);
		System.out.println("current Date: " + endDate);
		DateFormat df = new SimpleDateFormat("dd:MM:yyyy:HH:mm:ss");
		System.out.println("Milliseconds to Date: " + df.format(endDate));
		System.setProperty("EndTime", df.format(endDate));
		
		System.out.println("startTime: " + startTime); 
		System.out.println("endTime: " + endTime); 
        long totalTime = endTime-startTime;
        System.out.println("totalTime: " + totalTime);
        Duration d = Duration.ofMillis(totalTime) ;
        long minutesPart = d.toMinutes(); 
        long secondsPart = d.minusMinutes( minutesPart ).getSeconds() ;
        System.setProperty("TotalTime", String.format("%2d:%2d", minutesPart, secondsPart));
	}

	@Override
	public void onExecutionStart() {
		// TODO Auto-generated method stub
		System.out.println("TestNG is going to start");
		startTime = Math.abs(System.currentTimeMillis());
		Date StartDate = new Date(startTime);
		System.out.println("current Date: " + StartDate);
		DateFormat df = new SimpleDateFormat("dd:MM:yyyy:HH:mm:ss");
		System.out.println("Milliseconds to Date: " + df.format(StartDate));
		System.setProperty("StartTime", df.format(StartDate));
	}
}