package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.Browser;
import util.GeneralUtil;

public class Static {

	public WebDriver driver;
	public int dynamicTimeOut;
	public String fileUploadPath = null;

	
	public String strmenu = null;
	public String strNewCalender = null;
	public String strNewConventions = null;
	public String strNewCounterparties = null;
	public String strCurrency = null;
	public String strCurrencyPair = null;
	public String strTimeZone = null;
	public String strRiskScripts = null;
	public String strReferenceData = null;
	public String strCloneReferenceData = null;
	public String strSupervisoryParameter = null;
	public String strRiskWeights = null;
	public String strSACCRRiskWeights = null;
	public String strSACVARiskWeights = null;
	public String strSACCRGeneral = null;
	public String timeStamp = null;
	public String systemDate = null;

	@BeforeClass
	public void beforeClass() throws Exception {
		
		GeneralUtil.configureLog4j("Static");
		GeneralUtil.logger("Static");

		// Create driver object for browser
		try {
			driver = Browser.getDriver();
			Common.initializeDriver();
			GeneralUtil.initializeDriver();
			Common.NavigateToURL();
			Common.loginToXVA();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dynamicTimeOut = GeneralUtil.dynamicTimeOut;
		fileUploadPath = GeneralUtil.fileUploadPath;
		strSACCRGeneral = "SACCRK_Alpha";
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
		.format(new Date());
		strReferenceData = "AUTO" + timeStamp;
		strCloneReferenceData = "AUTO" + timeStamp;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		systemDate = dateFormat.format(date);
		strmenu = "//div[@class='ag-menu']//span[@class='ag-menu-option-text']";
	}

	@Test (alwaysRun=true)
	public void static_verifySubNodesForStaticNodeInTreeView() throws Exception {
		try{
			GeneralUtil.logger("Verify Sub Nodes For Static Node In TreeView");
			Reporter.log("Test Case: Verify Sub Nodes For Static Node In TreeView", 1, true);
			GeneralUtil.logger.info("Started Verify Sub Nodes For Static Node");
			
			// verify Static data type is exist
			Reporter.log("Test Step: Verify Static Data Type Is Exist", 1, true);
			String strStaticXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div/Strong[text()='Static']";
			verifyElementPresent("Static", strStaticXpath, dynamicTimeOut);
			
			// verify Calendars data type is exist
			Reporter.log("Test Step: Verify Calendars Data Type Is Exist", 1, true);
			String strCalendarsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Calendars']";
			verifyElementPresent("Calendars", strCalendarsXpath, dynamicTimeOut);
			
			// verify Conventions data type is exist
			Reporter.log("Test Step: Verify Conventions Data Type Is Exist", 1, true);
			String strConventionsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Conventions']";
			verifyElementPresent("Conventions", strConventionsXpath, dynamicTimeOut);
			
			// verify Counterparties data type is exist
			Reporter.log("Test Step: Verify Counterparties Data Type Is Exist", 1, true);
			String strCounterpartiesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Counterparties']";
			verifyElementPresent("Counterparties", strCounterpartiesXpath,
				dynamicTimeOut);
			
			// verify Currencies data type is exist
			Reporter.log("Test Step: Verify Currencies Data Type Is Exist", 1, true);
			String strCurrenciesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Currencies']";
			verifyElementPresent("Currencies", strCurrenciesXpath, dynamicTimeOut);
			
			// verify CurrencyPairs data type is exist
			Reporter.log("Test Step: Verify CurrencyPairs Data Type Is Exist", 1, true);
			String strCurrencyPairsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Currency Pairs']";
			verifyElementPresent("Currency Pairs", strCurrencyPairsXpath,
				dynamicTimeOut);
			
			// verify TimeZones data type is exist
			Reporter.log("Test Step: Verify TimeZones Data Type Is Exist", 1, true);
			String strTimeZonesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Timezones']";
			verifyElementPresent("TimeZones", strTimeZonesXpath, dynamicTimeOut);
			
			// verify Capital Parameters data type is exist
			Reporter.log("Test Step: Verify Capital Parameters Data Type Is Exist", 1, true);
			String strCapitalParametersXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Capital Parameters']";
			verifyElementPresent("Capital Parameters", strCapitalParametersXpath,
				dynamicTimeOut);
			
			// verify Risk Scripts data type is exist
			Reporter.log("Test Step: Verify Risk Scripts Data Type Is Exist", 1, true);
			String strRiskScriptsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Risk Scripts']";
			verifyElementPresent("Risk Scripts", strRiskScriptsXpath,
				dynamicTimeOut);
			
			// verify Hybrid Model Configuration data type is exist
						Reporter.log("Test Step: Verify Hybrid Model Configuration Data Type Is Exist", 1, true);
						String strHybridModelConfigurationXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Hybrid Model Configuration']";
						verifyElementPresent("Hybrid Model Configuration", strHybridModelConfigurationXpath,
							dynamicTimeOut);
			
			// verify Reference Data data type is exist
			Reporter.log("Test Step: Verify Reference Data Type Is Exist", 1, true);
			String strReferenceDataXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Reference Data']";
			verifyElementPresent("Reference Data", strReferenceDataXpath,
				dynamicTimeOut);
			
			Reporter.log("Test Case: Successfully Verified Sub Nodes For Static Node In TreeView", 1, true);
		} catch (Exception e) {

			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "static_verifySubNodesForStaticNodeInTreeView", alwaysRun=true)
	public void static_addCalendars() throws Exception {
		GeneralUtil.logger("Add new Calender");
		Reporter.log("Test Case: Add New Calender", 1, true);
		GeneralUtil.logger.info("Started add calender");
		try {
			// Navigate to Calculations screen
			Reporter.log("Test Step: Navigate To Calendars Screen", 1, true);
			String strCalendarsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Calendars']";
			WebElement objCalendars = GeneralUtil.getElement(strCalendarsXpath,
					"xpath", dynamicTimeOut);
			Reporter.log("Test Step: Click On Calendars Tab", 1, true);
			objCalendars.click();
			Thread.sleep(3000);
			WebDriverWait NDriver = new WebDriverWait(driver, 300);
			WebElement openConventions = NDriver.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div")));
			GeneralUtil.logger
					.info("Navigated to Calendars by Select the Calendars treeview item.");

			// Right click on element and select add context Menue item
			Reporter.log("Test Step: Right Click On The First Row And Select Add From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Add");
			GeneralUtil.captureScreenshot();

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());

			// Enter name and clicked on ok button
			Reporter.log("Test Step: Enter Name And Click On Ok Button", 1, true);
			WebElement objName = GeneralUtil
					.getElement(
							"//div/div/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input",
							"xpath", dynamicTimeOut);
			strNewCalender = "Auto" + timeStamp;
			objName.sendKeys(strNewCalender);
			Thread.sleep(1000);
			WebElement objOkButton = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div[2]/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton.click();

			GeneralUtil.logger.info("Entered name and clicked on ok button.");
			Reporter.log("Test Step: Entered Name And Clicked On Ok Button", 1, true);
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Calendar");

			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("Clicked on Save button.");

			// Clicked OK button on Save Confirmation window
			Reporter.log("Test Step: Click OK Button On Save Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			GeneralUtil.logger
					.info("Clicked OK button on Save Confirmation window.");

			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Calendar");
			Reporter.log("Test Step: Send The Value Of New Calendar Into Search Element", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(strNewCalender);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Step: Get Name Value For Filtered Calendar", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strNewCalender)) {
				GeneralUtil.logger.info("Added new Calender:" + strNewCalender
						+ " Successfully.");
			} else {
				GeneralUtil.logger.error("Unable to add new Calender:"
						+ strNewCalender);
			}
			Reporter.log("Test Case: Successfully Added New Calender", 1, true);
		} catch (Exception e) {
			GeneralUtil.logger.error("Unable to add Calendars.");
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "static_editCalender" })
	public void static_deleteCalender() throws Exception {
		try {
			GeneralUtil.logger("Delete new Calender");
			Reporter.log("Test Case: Delete New Calender", 1, true);
			GeneralUtil.logger.info("Stated");
			GeneralUtil.logger.info("Started Delete new Calender.");
			
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
							"xpath", dynamicTimeOut);
			
			// Right click on element and select Delete context Menu item
			Reporter.log("Test Step: Right Click On Element And Select Delete From Context Menu", 1, true);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Delete");
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Step: Click On Ok Button On Delete Confirmation PopUp", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Delete calendar");
			Reporter.log("Test Case: Successfully Deleted New Calender", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = { "static_addCalendars" })
	public void static_editCalender() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Edit Calender");
		Reporter.log("Test Case: Edit Calender", 1, true);
		GeneralUtil.logger.info("Stated");
		Reporter.log("Test Step: Send Calendar Name To Search Element Name", 1, true);
		WebElement SearchElement = driver
				.findElement(By
						.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
		SearchElement.clear();
		SearchElement.sendKeys(strNewCalender);

		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		Reporter.log("Test Step: Click The Filtered Row", 1, true);
		driver.findElement(
				By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"))
				.click();
		Thread.sleep(1000);
		

		// Right click on element and select add context Menue item
		Reporter.log("Test Step: Click Add In Sub Window From Context Menu", 1, true);
		WebElement contextMenuelement = GeneralUtil
				.getElement(
						"//*[contains(@class,'holidaysContainer')]//*[@ref='center']/div/div[4]/div[3]/div",
						"xpath", dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "Add");
		GeneralUtil.captureScreenshot();

		// Click on save button
		Reporter.log("Test Step: Click On Save Button", 1, true);
		WebElement objSaveButton = GeneralUtil.getElement(
				"//div[text()='Save']", "xpath", dynamicTimeOut);
		objSaveButton.click();
		Reporter.log("Test Step: Click On Ok Button", 1, true);
		WebElement objOkButton = GeneralUtil
				.getElement(
						"//div[text() = 'OK']",
						"xpath", dynamicTimeOut);
		objOkButton.click();
		
		// Verification for success notification
		Reporter.log("Test Step: Verification For Success Notification", 1, true);
		Common.handleNotifications("Save Calendar");
		Reporter.log("Test Case: Successfully Edited Calender", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "static_deleteCalender", alwaysRun=true)
	public void static_uploadCalender() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Upload Calender");
		Reporter.log("Test Case: Upload Calender", 1, true);
		GeneralUtil.logger.info("Stated");
		
		// Right click on element and select Clear all filters context Menue
		// item
		Reporter.log("Test Step: Click On Clear All Filters From Context Menu", 1, true);
		WebElement contextMenuelement1 = GeneralUtil.getElement(
				"//*[@ref='center']/div/div[4]/div[3]/div", "xpath",
				dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement1);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "Clear All Filters");
		GeneralUtil.captureScreenshot();
		WebElement SearchElement = driver
				.findElement(By
						.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));

		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		// Right click on element and select context Menue item
		Reporter.log("Test Step: Select NXT Upload From Context Menu", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "NXT Upload");
		Thread.sleep(1000);
		GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\Repository\\Calendar\\BEIJING.nxt");

		Thread.sleep(2000);
		
		// Verification for success notification
		Reporter.log("Test Step: Verification For Success Notification", 1, true);
		Common.handleNotifications("Upload calendar template");
		Reporter.log("Test Case: Successfully Uploaded Calender", 1, true);
	} catch (Exception e) {
		GeneralUtil.captureScreenshot();
		e.printStackTrace();
		GeneralUtil.logger.error(e);
		Reporter.log(e.toString(), 1, true);
		throw new Exception(e);
	}
	}

	@Test(dependsOnMethods = "static_uploadCalender", alwaysRun=true)
	public void static_downloadCalender() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Download Calender");
		Reporter.log("Test Case: Download Calender", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		Reporter.log("Test Step: Right Click on The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		Reporter.log("Test Step: Select DownloadAll From NXT Download From Context Menu", 1, true);
		Common.download("NXT Download", "Download All", "calendar(.*).zip",
				strmenu, strmenu);
		GeneralUtil.logger.info("Calender downloaded successfully");
		Reporter.log("Test Case: Successfully Downloaded Calender", 1, true);
	} catch (Exception e) {
		GeneralUtil.captureScreenshot();
		e.printStackTrace();
		GeneralUtil.logger.error(e);
		Reporter.log(e.toString(), 1, true);
		throw new Exception(e);
	}
	}

	@Test(dependsOnMethods = "static_downloadCalender", alwaysRun=true)
	public void static_exportCalender() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export Calender");
		Reporter.log("Test Case: Export Calender", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(4000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Calender CSV Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Calender Excel Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported Calender", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "static_exportCalender", alwaysRun=true)
	public void static_addConventions() throws Exception {
		GeneralUtil.logger("Add new conventions");
		Reporter.log("Test Case: Add New Conventions", 1, true);
		GeneralUtil.logger.info("Started Add new convention");

		// Close notifications if any exist
		try {

			for (int i = 1; i < 4; i++) {
				WebElement objnotification = GeneralUtil
						.getElement(
								"//div[starts-with(@class,'notification notification-error notification-visible')]/span",
								"xpath", 2);
				objnotification.click();
			}
		} catch (Exception e) {

		}
		Thread.sleep(2000);
		try {
			Reporter.log("Test Step: Navigate To Conventions Screen", 1, true);
			String strCalendarsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Conventions']";
			WebElement objCalendars = GeneralUtil.getElement(strCalendarsXpath,
					"xpath", dynamicTimeOut);
			objCalendars.click();
			Thread.sleep(5000);
			
			WebDriverWait NDriver = new WebDriverWait(driver, 300);
			WebElement openConventions = NDriver.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div")));
			
			GeneralUtil.logger
					.info("Navigated to Conventions by Select the Conventions treeview item.");

			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Add From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Add");
			GeneralUtil.captureScreenshot();

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());
			Reporter.log("Test Step: Enter Name And Click On Ok Button", 1, true);
			WebElement objName = GeneralUtil
					.getElement(
							"//div/div/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input",
							"xpath", dynamicTimeOut);
			String strConventions = "Auto" + timeStamp;
			objName.sendKeys(strConventions);
			Thread.sleep(1000);
			WebElement objOkButton = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div[2]/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton.click();

			GeneralUtil.logger.info("Entered name and clicked on ok button.");
			Reporter.log("Test Step: Entered Name And Clicked On Ok Button", 1, true);
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Convention");

			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();
			GeneralUtil.logger.info("Clicked on save button.");
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();
			GeneralUtil.logger
					.info("Clicked OK button on save confirmation window.");
			Reporter.log("Test Step: Clicked On OK Button On Save Confirmation Window", 1, true);
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Convention");

			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			SearchElement.clear();
			Reporter.log("Test Step: Send The Value Of New Convention Into Search Element", 1, true);
			SearchElement.sendKeys(strConventions);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Step: Get Name Value For Filtered Convention", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"))
					.getText();
			strNewConventions = "CONV." + strConventions;
			if (tradeIdtext.equalsIgnoreCase("CONV." + strConventions)) {
				GeneralUtil.logger.info("Added new Calender:" + strConventions
						+ " Successfully.");

			} else {
				GeneralUtil.logger.error("Unable to add new Calender:"
						+ strConventions);
			}
			Reporter.log("Test Case: Successfully Added New Conventions", 1, true);
		} catch (Exception e) {
			GeneralUtil.logger.error("Unable to add Calendars.");
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = { "static_addConventions" })
	public void static_editConventions() throws Exception {
		GeneralUtil.logger("Edit conventions");
		Reporter.log("Test Case: Edit Conventions", 1, true);
		GeneralUtil.logger.info("Started Edit convention");
		try {

			clearAllFilters();
			Reporter.log("Test Step: Send Convention Name To Search Element Name", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(strNewConventions);

			Thread.sleep(1000);

			GeneralUtil.captureScreenshot();
			Reporter.log("Test Step: Click The Filtered Row", 1, true);
			driver.findElement(
					By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"))
					.click();
			GeneralUtil.logger.info("Searched with " + strNewConventions
					+ " and Clicked on the convention " + strNewConventions);

			// Right click on element and select context Menue item
			Reporter.log("Test Step: Click Add In Sub Window From Context Menu", 1, true);
			WebElement contextMenuelement1 = GeneralUtil
					.getElement(
							"//*[contains(@class,'src-components-Dashboard-ReferenceData-Convention-Convention---detailTableContainer')]//*[@ref='center']/div/div[4]/div[3]/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement1);
			GeneralUtil.contextMenuItem(strmenu, "Add");
			GeneralUtil.captureScreenshot();

			GeneralUtil.logger
					.info("Added new row in parament table by Select the contextmentItem add.");
			Reporter.log("Test Step: Added New Row In Parament Table By Select The ContextmentItem Add", 1, true);
			WebElement objName1 = GeneralUtil
					.getElement(
							"//*[contains(@class,'src-components-Dashboard-ReferenceData-Convention-Convention---detailTableContainer')]//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/div",
							"xpath", dynamicTimeOut);
			Reporter.log("Test Step: Click Name TextBox", 1, true);
			objName1.click();

			WebElement objInput = GeneralUtil
					.getElement(
							"//*[contains(@class,'src-components-Dashboard-ReferenceData-Convention-Convention---detailTableContainer')]//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/div/input",
							"xpath", dynamicTimeOut);
			String StrInput = "AUTOPARA1";
			Reporter.log("Test Step: Send Name Input", 1, true);
			objInput.sendKeys(StrInput);

			WebElement objValue = GeneralUtil
					.getElement(
							"//*[contains(@class,'src-components-Dashboard-ReferenceData-Convention-Convention---detailTableContainer')]//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div",
							"xpath", dynamicTimeOut);
			Reporter.log("Test Step: Click Value TextBox", 1, true);
			objValue.click();

			WebElement objValueInput = GeneralUtil
					.getElement(
							"//*[contains(@class,'src-components-Dashboard-ReferenceData-Convention-Convention---detailTableContainer')]//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/input",
							"xpath", dynamicTimeOut);
			Reporter.log("Test Step: Send Value Input", 1, true);
			// String objValueInput = "1";
			objValueInput.sendKeys("1");

			GeneralUtil.logger.info("Entered name as: " + StrInput
					+ " and value as:1");
			Reporter.log("Test Step: Entered Name As: " + StrInput+ " And Value As:1", 1, true);
			GeneralUtil.captureScreenshot();
			
			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton1 = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton1.click();

			GeneralUtil.logger.info("Clicked on save button.");

			GeneralUtil.captureScreenshot();
			Reporter.log("Test Step: Click On OK Button On Save Convention Confirmation Window", 1, true);
			WebElement objOkButton3 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton3.click();

			GeneralUtil.logger
					.info("Clicked OK buttion on Confirmation window.");
			Reporter.log("Test Step: Clicked On OK Button On Save Convention Confirmation Window", 1, true);
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Convention");

			clearAllFilters();

			WebElement SearchElement1 = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			SearchElement1.clear();
			Reporter.log("Test Step: Send Convention Name To Search Element Name", 1, true);
			SearchElement1.sendKeys(strNewConventions);
			Thread.sleep(1000);
			Reporter.log("Test Step: Click The Filtered Row", 1, true);
			driver.findElement(
					By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"))
					.click();

			GeneralUtil.logger.info("Searched with " + strNewConventions
					+ " and Clicked on the convention " + strNewConventions);
			Reporter.log("Test Step: Searched With " + strNewConventions+ " And Clicked On The Convention " + strNewConventions, 1, true);
			GeneralUtil.captureScreenshot();
			Thread.sleep(1000);
			Reporter.log("Test Step: Get Name Value For Filtered Convention", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[contains(@class,'src-components-Dashboard-ReferenceData-Convention-Convention---detailTableContainer')]//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/div/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(StrInput)) {
				GeneralUtil.logger.info("Parameter " + StrInput
						+ " is added successfully to " + strNewConventions
						+ " convention while editing it");

			} else {
				GeneralUtil.logger
						.error("Unable edit convention "
								+ strNewConventions
								+ " Parameter "
								+ StrInput
								+ " is not added displayed in convention. displayed paramer is :"
								+ tradeIdtext);
			}
			Reporter.log("Test Case: Successfully Edited Conventions", 1, true);
		} catch (Exception e) {
			GeneralUtil.logger.error("Unable to edit Convention."
					+ e.getMessage());
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = { "static_editConventions" })
	public void static_deleteConventions() throws Exception {
		try {
			GeneralUtil.logger("Delete new Conventions");
			Reporter.log("Test Case: Delete New Conventions", 1, true);
			GeneralUtil.logger.info("Started Delete new Conventions.");
			
			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Delete From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Delete");
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Step: Click On Ok Button On Delete Confirmation PopUp", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();
			GeneralUtil.logger
					.info("Clicked OK buttion on delete Confirmation window.");
			Reporter.log("Test Step: Clicked OK Button On Delete Confirmation Window", 1, true);
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Delete convention");
			Reporter.log("Test Case: Successfully Deleted New Conventions", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "static_deleteConventions", alwaysRun=true)
	public void static_uploadConventions() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Upload Conventions");
		Reporter.log("Test Case: Upload Conventions", 1, true);
		GeneralUtil.logger.info("Stated");
		Reporter.log("Test Step: Click On Conventions", 1, true);
		String strConventionsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Conventions']";
		WebElement objConventions = GeneralUtil.getElement(strConventionsXpath,
				"xpath", dynamicTimeOut);
		objConventions.click();
		
		// Right click on element and select context Menue item
		Reporter.log("Test Step: Click On Clear All Filters From Context Menu", 1, true);
		WebElement contextMenuelement1 = GeneralUtil.getElement(
				"//*[@ref='center']/div/div[4]/div[3]/div", "xpath",
				dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement1);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "Clear All Filters");
		GeneralUtil.captureScreenshot();

		WebElement SearchElement = driver
				.findElement(By
						.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
		SearchElement.clear();
		SearchElement.sendKeys("");

		// Right click on element and select context Menue item
		Reporter.log("Test Step: Select NXT Upload From Context Menu", 1, true);
		WebElement contextMenuelement = GeneralUtil
				.getElement(
						"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
						"xpath", dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "NXT Upload");
		
		Thread.sleep(1000);
		GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\Repository\\Convention\\CMDTY\\USD-COMEX-GCA.nxt");

		Thread.sleep(2000);
		
		// Verification for success notification
		Reporter.log("Test Step: Verification For Success Notification", 1, true);
		Common.handleNotifications("Upload Conventions template");
		Reporter.log("Test Case: Successfully Uploaded Conventions", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "static_uploadConventions", alwaysRun=true)
	public void static_downloadConventions() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Download Conventions");
		Reporter.log("Test Case: Download Conventions", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		Reporter.log("Test Step: Right Click on The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		Reporter.log("Test Step: Select DownloadAll From NXT Download From Context Menu", 1, true);
		Common.download("NXT Download", "Download All",
				"convention(.*).zip", strmenu, strmenu);
		GeneralUtil.logger.info("Conventions downloaded successfully");
		Reporter.log("Test Case: Successfully Downloaded Conventions", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "static_downloadConventions", alwaysRun=true)
	public void static_exportConventions() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export Conventions");
		Reporter.log("Test Case: Export Conventions", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(2000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Conventions CSV Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Conventions Excel Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported Conventions", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "static_exportConventions", alwaysRun=true)
	public void static_addCounterparties() throws Exception {

		GeneralUtil.logger = Logger.getLogger("Add Counterparties");
		Reporter.log("Test Case: Add Counterparties", 1, true);
		Thread.sleep(2000);
		GeneralUtil.logger.info("Stated");
		try {
			Reporter.log("Test Step: Navigate To Counterparties Screen", 1, true);
			String strCalendarsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Counterparties']";
			WebElement objCalendars = GeneralUtil.getElement(strCalendarsXpath,
					"xpath", dynamicTimeOut);
			Reporter.log("Test Step: Click On Counterparties Tab", 1, true);
			objCalendars.click();
			Thread.sleep(2000);
			GeneralUtil.captureScreenshot();

			GeneralUtil.logger
					.info("Navigated to Counterparties by Select the Counterparties treeview item.");

			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On The First Row And Select Add From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Add");
			Thread.sleep(2000);
			GeneralUtil.captureScreenshot();

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());
			String creditTextBoxValue="test"+timeStamp;
			String ratingTextBoxValue="rating"+timeStamp;
			Reporter.log("Test Step: Enter Name And Click On Ok Button", 1, true);
			WebElement objName = GeneralUtil
					.getElement(
							"//div/div/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input",
							"xpath", dynamicTimeOut);
			strNewCounterparties = "Auto" + timeStamp;
			objName.sendKeys(strNewCounterparties);

			WebElement objOkButton = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div[2]/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton.click();
			Thread.sleep(3000);
			GeneralUtil.logger.info("Entered name and clicked on ok button.");
			Reporter.log("Test Step: Entered Name And Clicked On Ok Button", 1, true);
			Thread.sleep(1000);
			Reporter.log("Test Step: Click On SubWindow", 1, true);
			WebElement subWindow = GeneralUtil.getElement(
					"//div[starts-with(@class,'src-components-Dashboard-ReferenceData-Counterparty-DetailView---bodyContainer')]/div/div[3]/div/div[2]/div",
					"xpath", dynamicTimeOut);
			subWindow.click();
			Thread.sleep(1000);
			WebElement creditKeyTextBox = GeneralUtil.getElement(
					".//*[@class='ReactTabs__TabPanel ReactTabs__TabPanel--selected']/div/div/div[3]/div/div[2]/div/input",
					"xpath", dynamicTimeOut);
			Reporter.log("Test Step: Click On CreditKeyTextBox", 1, true);
			creditKeyTextBox.click();
			Reporter.log("Test Step: Send Value To CreditKeyTextBox", 1, true);
			creditKeyTextBox.sendKeys(creditTextBoxValue);
			WebElement capitalInfoLabel = GeneralUtil.getElement(
					"//ul[@class='ReactTabs__TabList']//label[text()='Capital Info']",
					"xpath", dynamicTimeOut);
			Reporter.log("Test Step: Click On CapitalInfoLabel", 1, true);
			capitalInfoLabel.click();
			WebElement ratingTextBox = GeneralUtil.getElement(
					"//div[@class='ReactTabs__TabPanel ReactTabs__TabPanel--selected']/div/div/div[1]/div/div[2]/div/input",
					"xpath", dynamicTimeOut);
			Reporter.log("Test Step: Send Value To RatingTextBoxValue", 1, true);
			ratingTextBox.sendKeys(ratingTextBoxValue);

			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("Clicked save button.");
			Reporter.log("Test Step: Click On Ok Button", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			GeneralUtil.logger
					.info("Clicked ok button on confirmation window.");
			Reporter.log("Test Step: Clicked Ok Button On Confirmation Window", 1, true);
			Thread.sleep(3000);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			Reporter.log("Test Step: Send Value Of Counterparty Into Search Element", 1, true);
			SearchElement.sendKeys(strNewCounterparties);

			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Get Name Value For Filtered Counterparty", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//div[@id='counterParty']//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strNewCounterparties)) {
				GeneralUtil.logger.info("Added new Counterparties:"
						+ tradeIdtext + " Successfully.");
			} else {
				GeneralUtil.logger.error("Unable to add new Counterparties:"
						+ strNewCounterparties);
			}
			Reporter.log("Test Case: Successfully Added Counterparties", 1, true);
		} catch (Exception e) {
			GeneralUtil.logger.error("Unable to add Counterparties.");
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "static_addCounterparties" })
	public void static_editCounterparties() throws Exception {

		GeneralUtil.logger = Logger.getLogger("Edit Counterparties");
		Reporter.log("Test Case: Edit Counterparties", 1, true);
		Thread.sleep(2000);
		GeneralUtil.logger.info("Stated");
		try {
			//TT 45574 - Application change in in build 4.6
			WebElement tradeIdElement = driver.findElement(By.xpath("//div[@id='counterParty']//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/div/div"));
			tradeIdElement.click();
			Thread.sleep(1000);
			Reporter.log("Test Step: Click On General Label Of Sub Window", 1, true);
			WebElement generalLabel = GeneralUtil.getElement(
					"//ul[@class='ReactTabs__TabList']//label[text()='General']",
					"xpath", dynamicTimeOut);
			generalLabel.click();
			Reporter.log("Test Step: Edit Name From Counterparty To Time In Sub Window", 1, true);
			WebElement objNameCounterparty = GeneralUtil
					.getElement(
							"//div[contains(@class,'bodyContainer')]//div/div[1]/div/div[2]/div/input",
							"xpath", dynamicTimeOut);

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());
			objNameCounterparty.clear();
			strNewCounterparties = "AUTO" + timeStamp;
			objNameCounterparty.sendKeys(strNewCounterparties);
			GeneralUtil.logger.info("Edited name from " + strNewCounterparties
					+ " to " + "AUTO" + timeStamp + ".");

			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("Clicked save button.");
			Reporter.log("Test Step: Click On Ok Button On Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();
			GeneralUtil.logger
					.info("Clicked ok button on confirmation window.");
			Reporter.log("Test Step: Clicked On Ok Button On Confirmation Window", 1, true);
			Thread.sleep(3000);
			Reporter.log("Test Step: Send Changed Counterparty Name To search Element Name", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(strNewCounterparties);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Step: Get Name Value For Filtered Counterparty", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//div[@id='counterParty']//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase("AUTO" + timeStamp)) {
				GeneralUtil.logger.info("Added new Counterparties:"
						+ tradeIdtext + " Successfully.");
				strNewCounterparties = "AUTO" + timeStamp;
			} else {
				GeneralUtil.logger.error("Unable to eidt Counterparties:"
						+ "AUTO" + timeStamp);
			}
			Reporter.log("Test Case: Successfully Edited Counterparties", 1, true);
		} catch (Exception e) {
			GeneralUtil.logger.error("Unable to add Counterparties.");
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "static_editCounterparties", alwaysRun=true)
	public void static_cloneCounterparties() throws Exception {

		GeneralUtil.logger = Logger.getLogger("Clone Counterparties");
		Reporter.log("Test Case: Clone Counterparties", 1, true);
		Thread.sleep(2000);
		GeneralUtil.logger.info("Stated");
		try {
			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On The First Row And Select Clone From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Clone");
			Thread.sleep(2000);
			GeneralUtil.captureScreenshot();

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());
			String creditTextBoxValue="testClone"+timeStamp;
			String ratingTextBoxValue="ratingClone"+timeStamp;
			Reporter.log("Test Step: Enter Name And Click On Ok Button", 1, true);
			WebElement objName = GeneralUtil
					.getElement(
							"//div/div/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input",
							"xpath", dynamicTimeOut);
			strNewCounterparties = "AutoClone" + timeStamp;
			objName.clear();
			objName.sendKeys(strNewCounterparties);

			WebElement objOkButton = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div[2]/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton.click();
			Thread.sleep(3000);
			GeneralUtil.logger.info("Entered name and clicked on ok button.");
			Reporter.log("Test Step: Entered Name And Clicked On Ok Button", 1, true);
			Thread.sleep(1000);
			Reporter.log("Test Step: Click On SubWindow", 1, true);
			WebElement subWindow = GeneralUtil.getElement(
					"//div[starts-with(@class,'src-components-Dashboard-ReferenceData-Counterparty-DetailView---bodyContainer')]/div/div[3]/div/div[2]/div",
					"xpath", dynamicTimeOut);
			subWindow.click();
			Thread.sleep(1000);
			WebElement creditKeyTextBox = GeneralUtil.getElement(
					".//*[@class='ReactTabs__TabPanel ReactTabs__TabPanel--selected']/div/div/div[3]/div/div[2]/div/input",
					"xpath", dynamicTimeOut);
			Reporter.log("Test Step: Click On CreditKeyTextBox", 1, true);
			creditKeyTextBox.click();
			Reporter.log("Test Step: Send Value To CreditKeyTextBox", 1, true);
			creditKeyTextBox.clear();
			creditKeyTextBox.sendKeys(creditTextBoxValue);
			WebElement capitalInfoLabel = GeneralUtil.getElement(
					"//ul[@class='ReactTabs__TabList']//label[text()='Capital Info']",
					"xpath", dynamicTimeOut);
			Reporter.log("Test Step: Click On CapitalInfoLabel", 1, true);
			capitalInfoLabel.click();
			WebElement ratingTextBox = GeneralUtil.getElement(
					"//div[@class='ReactTabs__TabPanel ReactTabs__TabPanel--selected']/div/div/div[1]/div/div[2]/div/input",
					"xpath", dynamicTimeOut);
			Reporter.log("Test Step: Send Value To RatingTextBoxValue", 1, true);
			ratingTextBox.clear();
			ratingTextBox.sendKeys(ratingTextBoxValue);

			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("Clicked save button.");
			Reporter.log("Test Step: Click On Ok Button", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			GeneralUtil.logger
					.info("Clicked ok button on confirmation window.");
			Reporter.log("Test Step: Clicked Ok Button On Confirmation Window", 1, true);
			Thread.sleep(3000);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			Reporter.log("Test Step: Send Value Of Counterparty Into Search Element", 1, true);
			SearchElement.sendKeys(strNewCounterparties);

			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Get Name Value For Filtered Counterparty", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//div[@id='counterParty']//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strNewCounterparties)) {
				GeneralUtil.logger.info("Cloned new Counterparties:"
						+ tradeIdtext + " Successfully.");
			} else {
				GeneralUtil.logger.error("Unable to clone new Counterparties:"
						+ strNewCounterparties);
			}
			Reporter.log("Test Case: Successfully Cloned Counterparties", 1, true);
		} catch (Exception e) {
			GeneralUtil.logger.error("Unable to clone Counterparties.");
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "static_cloneCounterparties" })
	public void static_deleteCounterparties() throws Exception {
		try {
			GeneralUtil.logger("Delete new Counterparties");
			Reporter.log("Test Case: Delete New Counterparties", 1, true);
			Thread.sleep(1000);
			GeneralUtil.logger.info("Stated");
			
			// Clear the filter for Counterparties columns
			WebElement clearContextMenuElement = driver.findElement(By
			.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
				Reporter.log("Test Step: Clear The Static Counterparties Filter Columns", 1, true);
				GeneralUtil.contextMenu(clearContextMenuElement);
				GeneralUtil
						.contextMenuItem(
								".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
								"Clear All Filters");
				Thread.sleep(2000);
	
			// Search the added Market Policies
		Reporter.log("Test Step: Search Added Counterparties Static", 1, true);
		WebElement SearchElement = driver
						.findElement(By
								.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
		SearchElement.clear();
		SearchElement.sendKeys(strNewCounterparties);
		Thread.sleep(3000);
			
			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Delete From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Delete");
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Step: Click On Ok Button On Delete Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			GeneralUtil.logger
					.info("Clicked ok button on delete confirmation window.");
			Reporter.log("Test Step: Clicked On Ok Button On Delete Confirmation Window", 1, true);
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Delete Counterparties");
			Reporter.log("Test Case: Successfully Deleted New Counterparties", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = "static_deleteCounterparties", alwaysRun=true)
	public void static_uploadCounterparties() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Upload Counterparties");
		Reporter.log("Test Case: Upload Counterparties", 1, true);
		GeneralUtil.logger.info("Stated");
		Reporter.log("Test Step: Click On Counterparties", 1, true);
		String strCounterpartiesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Counterparties']";
		WebElement objCounterparties = GeneralUtil.getElement(
				strCounterpartiesXpath, "xpath", dynamicTimeOut);
		objCounterparties.click();
		
		// Right click on element and select context Menue item
		Reporter.log("Test Step: Click On Clear All Filters From Context Menu", 1, true);
		WebElement contextMenuelement1 = GeneralUtil.getElement(
				"//*[@ref='center']/div/div[4]/div[3]/div", "xpath",
				dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement1);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "Clear All Filters");
		GeneralUtil.captureScreenshot();
		Reporter.log("Test Step: Send Value To Search Element Name", 1, true);
		WebElement SearchElement = driver
				.findElement(By
						.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
		SearchElement.clear();
		SearchElement.sendKeys("Citigroup");
		
		// Right click on element and select context Menue item
		Reporter.log("Test Step: Click On CSV Upload From Context Menu", 1, true);
		WebElement contextMenuelement = GeneralUtil
				.getElement(
						"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
						"xpath", dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "CSV Upload");
	
		Thread.sleep(1000);
		GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\data\\Counterparties\\Citigroup.csv");

		Thread.sleep(2000);
		
		// Verification for success notification
		Reporter.log("Test Step: Verification For Success Notification", 1, true);
		Common.handleNotifications("Upload Counterparties template");
		Reporter.log("Test Case: Successfully Uploaded Counterparties", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "static_uploadCounterparties", alwaysRun=true)
	public void static_downloadCounterparties() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Download Counterparties");
		Reporter.log("Test Case: Download Counterparties", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		// Clear the filter for Counterparties columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Static Counterparties Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
		Reporter.log("Test Step: Right Click on The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		Reporter.log("Test Step: Select DownloadAll From CSV Download From Context Menu", 1, true);
		Common.download("CSV Download", "Download All",
				"Counterparties(.*).zip", strmenu, strmenu);
		GeneralUtil.logger.info("Counterparties downloaded successfully");
		Reporter.log("Test Case: Successfully Downloaded Counterparties", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "static_downloadCounterparties", alwaysRun=true)
	public void static_exportCounterparties() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export Counterparties");
		Reporter.log("Test Case: Export Counterparties", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(4000);
		GeneralUtil.captureScreenshot();
		
		// Clear the filter for Counterparties columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Static Counterparties Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(5000);
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Counterparties CSV Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Counterparties Excel Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported Counterparties", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "static_exportCounterparties", alwaysRun=true)
	public void static_addCurrencies() throws Exception {
		try {

			GeneralUtil.logger("Add Currencies");
			Reporter.log("Test Case: Add Counterparties", 1, true);
			GeneralUtil.logger.info("Stated");
			Reporter.log("Test Step: Navigate To Currencies Screen", 1, true);
			String strCurrencysXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Currencies']";
			WebElement objCalendars = GeneralUtil.getElement(strCurrencysXpath,
					"xpath", dynamicTimeOut);
			objCalendars.click();
			Thread.sleep(4000);
			GeneralUtil.logger
					.info("Navigated to Currencies by Select the Currencies treeview item.");

			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Add From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Add");
			GeneralUtil.captureScreenshot();

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());
			Reporter.log("Test Step: Enter Key Value In Sub Window", 1, true);
			WebElement objName = GeneralUtil
					.getElement(
							"//div/div/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input",
							"xpath", dynamicTimeOut);
			strCurrency = "Auto" + timeStamp;
			objName.sendKeys(strCurrency);
			Reporter.log("Test Step: Enter Rank Value In Sub Window", 1, true);
			WebElement objRank = GeneralUtil
					.getElement(
							"//div/div/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/input",
							"xpath", dynamicTimeOut);

			objRank.sendKeys("100");
			Reporter.log("Test Step: Click On Ok Button In Sub Window", 1, true);
			WebElement objOkButton = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div[2]/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton.click();

			GeneralUtil.logger.info("Entered name as: " + strCurrency
					+ " and Rank as: 100.");
			Reporter.log("Test Step: Entered Name As: " + strCurrency+ " And Rank As: 100.", 1, true);
			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();
			GeneralUtil.logger.info("Clicked on Save button");
			Reporter.log("Test Step: Click On Ok Button In Save Currency Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			GeneralUtil.logger.info("Clicked OK button on confirmation window");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Currency");
			Reporter.log("Test Step: Send The Value Of New Currency Into Search Element", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(strCurrency);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Step: Get Name Value For Filtered Convention", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strCurrency)) {
				GeneralUtil.logger.info("Added new Currency:" + strCurrency
						+ " Successfully.");
			} else {
				GeneralUtil.logger.error("Unable to add new Currency:"
						+ strCurrency);
			}
			Reporter.log("Test Case: Successfully Added Counterparties", 1, true);
		} catch (Exception e) {
			GeneralUtil.logger.error("Unable to add Currency.");
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "static_addCurrencies" })
	public void static_editCurrencies() throws Exception {
		try {
			GeneralUtil.logger("Edit Currencies");
			Reporter.log("Test Case: Edit Currencies", 1, true);
			Thread.sleep(4000);
			GeneralUtil.logger.info("Stated");
			int intColNumber = Common.getColumnNumber("Name");
			int intRowNumber = Common.getRowNumber(intColNumber,
					strCurrency);

			intColNumber = Common.getColumnNumber("IR Index");
			gridSendKeys(
					String.format(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div/div",
							intRowNumber, intColNumber), "BBSW");
			GeneralUtil.logger
					.info("Entered BBSW value in as IR Index for currency "
							+ strCurrency);
			Reporter.log("Test Step: Entered BBSW Value In As IR Index For Currency "+ strCurrency, 1, true);
			intColNumber = Common.getColumnNumber("IR Index Tenor");
			gridSendKeys(
					String.format(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div/div",
							intRowNumber, intColNumber), "6M");
			GeneralUtil.logger
					.info("Entered 6M value in as IR Index Tenor for currency "
							+ strCurrency);
			Reporter.log("Test Step: Entered 6M value in as IR Index Tenor for currency "+ strCurrency, 1, true);
			
			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();
			GeneralUtil.logger.info("Clicked on Save button");
			
			Reporter.log("Test Step: Click OK Button On Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			GeneralUtil.logger.info("Clicked OK button on confirmation window");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Currency");

			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			Reporter.log("Test Step: Send Value Of Currency", 1, true);
			SearchElement.sendKeys(strCurrency);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Step: Get Name Value For Filtered Currency", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strCurrency)) {
				GeneralUtil.logger.info("Successfully edited the currency:"
						+ strCurrency + ".");
			} else {
				GeneralUtil.logger.error("Unable to edit Currency:"
						+ strCurrency);
			}
			Reporter.log("Test Case: Successfully Edited Currencies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	public void gridSendKeys(String strXpath, String strTestData) {

		WebElement objName;
		try {
			objName = GeneralUtil.getElement(strXpath, "xpath", dynamicTimeOut);
			objName.click();

			WebElement objInput = GeneralUtil.getElement(strXpath + "/input",
					"xpath", dynamicTimeOut);
			// objInput.clear();
			objInput.sendKeys(strTestData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Reporter.log(e.toString(), 1, true);
		}
	}

	public void gridSendKeysJS(String strXpath, String strTestData) {

		try {

			WebElement objInput1 = GeneralUtil.getElement(strXpath + "/span",
					"xpath", dynamicTimeOut);

			objInput1.click();

			WebElement objInput = GeneralUtil.getElement(strXpath
					+ "/div/input", "xpath", dynamicTimeOut);

			// driver.execute_script("document.getElementById('q').value='value here'")

			// JavascriptExecutor js = (JavascriptExecutor)driver;

			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].setAttribute('value', '"+strTestData+"')",
			// objInput);

			objInput.click();
			objInput.sendKeys(strTestData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Reporter.log(e.toString(), 1, true);
		}
	}

	@Test(dependsOnMethods = { "static_editCurrencies" })
	public void static_deleteCurrencies() throws Exception {
		try {
			GeneralUtil.logger("Delete new Currencies");
			Reporter.log("Test Case: Delete New Currencies", 1, true);
			GeneralUtil.logger.info("Stated");
			Thread.sleep(4000);
			
			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Delete From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Delete");
			GeneralUtil.captureScreenshot();

			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();
			GeneralUtil.logger.info("Clicked on Save button");
			
			Reporter.log("Test Step: Click On Ok Button On Delete Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();
			GeneralUtil.logger
					.info("Clicked OK buttion on delete Confirmation window.");
			Reporter.log("Test Step: Clicked OK Button On Delete Confirmation Window", 1, true);
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Currency");
			Reporter.log("Test Case: Successfully Deleted New Currencies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = "static_deleteCurrencies", alwaysRun=true)
	public void static_uploadCurrencies() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Upload Currencies");
		Reporter.log("Test Case: Upload Currencies", 1, true);
		GeneralUtil.logger.info("Stated");
		Reporter.log("Test Step: Click On Currencies", 1, true);
		String strCounterpartiesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Currencies']";
		WebElement objCounterparties = GeneralUtil.getElement(
				strCounterpartiesXpath, "xpath", dynamicTimeOut);
		objCounterparties.click();
		
		// Right click on element and select context Menue item
		Reporter.log("Test Step: Click On Clear All Filters From Context Menu", 1, true);
		WebElement contextMenuelement1 = GeneralUtil.getElement(
				"//*[@ref='center']/div/div[4]/div[3]/div", "xpath",
				dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement1);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "Clear All Filters");
		GeneralUtil.captureScreenshot();
		Reporter.log("Test Step: Send Value To Search Element Name", 1, true);
		WebElement SearchElement = driver
				.findElement(By
						.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
		SearchElement.clear();
		SearchElement.sendKeys("USD");

		// Right click on element and select context Menue item
		Reporter.log("Test Step: Click On NXT Upload From Context Menu", 1, true);
		WebElement contextMenuelement = GeneralUtil
				.getElement(
						"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/div/div",
						"xpath", dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "NXT Upload");
		
		Thread.sleep(1000);
		GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\Repository\\Settings\\Currency.nxt");

		Thread.sleep(2000);
		
		// Verification for success notification
		Reporter.log("Test Step: Verification For Success Notification", 1, true);
		Common.handleNotifications("Upload Currencies template");
		Reporter.log("Test Case: Successfully Uploaded Currencies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "static_uploadCurrencies", alwaysRun=true)
	public void static_downloadCurrencies() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Download Currencies");
		Reporter.log("Test Case: Download Currencies", 1, true);
		GeneralUtil.logger.info("Stated");
		
		// Right click on element and select context Menue item
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		GeneralUtil.captureScreenshot();
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		Reporter.log("Test Step: Select DownloadAll From NXT Download From Context Menu", 1, true);
		Common.download("NXT Download", "Download",
				"SETTINGS.CURRENCY(.*).xml", strmenu, strmenu);
		GeneralUtil.logger.info("Currencies downloaded successfully");
		Reporter.log("Test Case: Successfully Downloaded Currencies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "static_downloadCurrencies", alwaysRun=true)
	public void static_exportCurrencies() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export Currencies");
		Reporter.log("Test Case: Export Currencies", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(2000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[3]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Currencies CSV Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[3]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Currencies Excel Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported Currencies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "static_exportCurrencies", alwaysRun=true)
	public void static_addCurrencyPair() throws Exception {
		try {

			GeneralUtil.logger("Add CurrencyPair");
			Reporter.log("Test Case: Add CurrencyPair", 1, true);
			GeneralUtil.logger.info("Stated");
			Reporter.log("Test Step: Click On Currency Pairs", 1, true);
			String strCurrencyPairXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Currency Pairs']";
			WebElement objCurrencyPair = GeneralUtil.getElement(
					strCurrencyPairXpath, "xpath", dynamicTimeOut);
			objCurrencyPair.click();
			Thread.sleep(5000);
			GeneralUtil.logger
					.info("Navigated to Currencies by Select the CurrencyPair treeview item.");

			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Add From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Add");
			GeneralUtil.captureScreenshot();

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());
			Reporter.log("Test Step: Enter Key Value In Sub Window", 1, true);
			WebElement objName = GeneralUtil
					.getElement(
							"//div/div/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input",
							"xpath", dynamicTimeOut);
			strCurrencyPair = "AUTOUSD" + timeStamp;
			objName.sendKeys(strCurrencyPair);
			Reporter.log("Test Step: Enter Base Currency Value In Sub Window", 1, true);
			WebElement objRank = GeneralUtil
					.getElement(
							"//div/div/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/input",
							"xpath", dynamicTimeOut);
			Reporter.log("Test Step: Send Value Of Base Currency", 1, true);
			objRank.sendKeys("100");

			GeneralUtil.logger.info("Entered name as: " + strCurrencyPair
					+ " and Rank as: 100.");
			Reporter.log("Test Step: Click On Ok Button", 1, true);
			WebElement objOkButton = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div[2]/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton.click();
			GeneralUtil.logger.info("Clicked OK button on confirmation window");

			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();
			GeneralUtil.logger.info("Clicked on Save button");
			
			Reporter.log("Test Step: Click On Ok Button On Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Currencypair");

			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			Reporter.log("Test Step: Send Value Of CurrencyPair", 1, true);
			SearchElement.sendKeys(strCurrencyPair);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Get Name Value For Filtered CurrencyPair", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strCurrencyPair)) {
				GeneralUtil.logger.info("Added new CurrencyPair:"
						+ strCurrencyPair + " Successfully.");
			} else {
				GeneralUtil.logger.error("Unable to add new CurrencyPair:"
						+ strCurrencyPair);
			}
			Reporter.log("Test Case: Successfully Added CurrencyPair", 1, true);
		} catch (Exception e) {
			GeneralUtil.logger.error("Unable to add CurrencyPair.");
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "static_addCurrencyPair" })
	public void static_editCurrencyPair() throws Exception {
		try {
			GeneralUtil.logger("Edit CurrencyPair");
			Reporter.log("Test Case: Edit CurrencyPair", 1, true);
			GeneralUtil.logger.info("Stated");
			int intColNumber = Common.getColumnNumber("Name");
			int intRowNumber = Common.getRowNumber(intColNumber,
					strCurrencyPair);

			intColNumber = Common.getColumnNumber("Base Currency");
			gridSendKeys(
					String.format(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div/div",
							intRowNumber, intColNumber), "USD");
			GeneralUtil.logger
					.info("Entered USD value in as Term Currency for CurrencyPair "
							+ strCurrencyPair);

			intColNumber = Common.getColumnNumber("Term Currency");
			gridSendKeys(
					String.format(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div/div",
							intRowNumber, intColNumber), "MXN");
			GeneralUtil.logger
					.info("Entered MXN value in as Term Currency for CurrencyPair "
							+ strCurrencyPair);
			Reporter.log("Test Step: Entered MXN Value In As Term Currency For CurrencyPair "+ strCurrencyPair, 1, true);
			GeneralUtil.logger
					.info("Edited : "
							+ strCurrencyPair
							+ "by Enter the Base Currency as: USD, Term Currency as:MXN");

			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("Clicked on Save button");
			Reporter.log("Test Step: Click OK Button On Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			GeneralUtil.logger.info("Clicked OK button on confirmation window");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Currencypair");

			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			Reporter.log("Test Step: Send Value Of CurrencyPair", 1, true);
			SearchElement.sendKeys(strCurrencyPair);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Get Name Value For Filtered CurrencyPair", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strCurrencyPair)) {
				GeneralUtil.logger.info("Successfully edited the CurrencyPair:"
						+ strCurrencyPair + ".");
			} else {
				GeneralUtil.logger.error("Unable to edit CurrencyPair:"
						+ strCurrencyPair);
			}
			Reporter.log("Test Case: Successfully Edited CurrencyPair", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "static_editCurrencyPair" })
	public void static_deleteCurrencyPair() throws Exception {
		try {
			GeneralUtil.logger("Delete new CurrencyPair");
			Reporter.log("Test Case: Delete New CurrencyPair", 1, true);
			GeneralUtil.logger.info("Stated");
			
			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Delete From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Delete");
			GeneralUtil.captureScreenshot();

			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();
			GeneralUtil.logger.info("Clicked on Save button");
			
			Reporter.log("Test Step: Click OK Button On Delete Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();
			GeneralUtil.logger
					.info("Clicked OK buttion on delete Confirmation window.");
			Reporter.log("Test Step: Clicked OK Button On Delete Confirmation Window", 1, true);
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Currencypair");
			Reporter.log("Test Case: Successfully Deleted New CurrencyPair", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = "static_deleteCurrencyPair", alwaysRun=true)
	public void static_uploadCurrencyPair() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Upload CurrencyPair");
		Reporter.log("Test Case: Upload CurrencyPair", 1, true);
		GeneralUtil.logger.info("Stated");
		Reporter.log("Test Step: Click On Currency Pairs", 1, true);
		String strCurrencyPairXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Currency Pairs']";
		WebElement objCurrencyPair = GeneralUtil.getElement(
				strCurrencyPairXpath, "xpath", dynamicTimeOut);
		objCurrencyPair.click();

		GeneralUtil.logger
				.info("Navigated to Currencies by Select the CurrencyPair treeview item.");
		
		// Right click on element and select context Menue item
		Reporter.log("Test Step: Click On Clear All Filters From Context Menu", 1, true);
		WebElement contextMenuelement1 = GeneralUtil.getElement(
				"//*[@ref='center']/div/div[4]/div[3]/div", "xpath",
				dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement1);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "Clear All Filters");
		GeneralUtil.captureScreenshot();
		Reporter.log("Test Step: Send Value To Search Element Name", 1, true);
		WebElement SearchElement = driver
				.findElement(By
						.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
		SearchElement.clear();
		SearchElement.sendKeys("USD");
		
		// Right click on element and select context Menue item
		Reporter.log("Test Step: Click On NXT Upload From Context Menu", 1, true);
		WebElement contextMenuelement = GeneralUtil
				.getElement(
						"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
						"xpath", dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "NXT Upload");
		
		Thread.sleep(1000);
		GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\Repository\\Settings\\CurrencyPair.nxt");

		Thread.sleep(2000);
		
		// Verification for success notification
		Reporter.log("Test Step: Verification For Success Notification", 1, true);
		Common.handleNotifications("Upload CurrencyPair template");
		Reporter.log("Test Case: Successfully Uploaded CurrencyPair", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "static_uploadCurrencyPair", alwaysRun=true)
	public void static_downloadCurrencyPair() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Download CurrencyPair");
		Reporter.log("Test Case: Download CurrencyPair", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		Reporter.log("Test Step: Select DownloadAll From NXT Download From Context Menu", 1, true);
		Common.download("NXT Download", "Download",
				"SETTINGS.CURRENCY(.*).xml", strmenu, strmenu);
		GeneralUtil.logger.info("CurrencyPair downloaded successfully");
		Reporter.log("Test Case: Successfully Downloaded CurrencyPair", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "static_downloadCurrencyPair", alwaysRun=true)
	public void static_exportCurrencyPair() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export CurrencyPair");
		Reporter.log("Test Case: Export CurrencyPair", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("CurrencyPair CSV Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("CurrencyPair Excel Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported CurrencyPair", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "static_exportCurrencyPair", alwaysRun=true)
	public void static_addTimeZone() throws Exception {
		try {

			GeneralUtil.logger("Add TimeZone");
			Reporter.log("Test Case: Add TimeZone", 1, true);
			GeneralUtil.logger.info("Stated");
			
			Reporter.log("Test Step: Click On Timezones", 1, true);
			String strTimeZoneXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Timezones']";
			WebElement objTimeZone = GeneralUtil.getElement(strTimeZoneXpath,
					"xpath", dynamicTimeOut);
			// Create instance of Javascript executor
			Reporter.log("Test Step: Create Instance Of Javascript Executor", 1, true);
						JavascriptExecutor je = (JavascriptExecutor) driver;
						// Identify the WebElement which will appear after scrolling
						// down
						// WebElement element = driver.findElement(By.tagName("...."));
						// now execute query which actually will scroll until that
						// element is not appeared on page.
						je.executeScript("arguments[0].scrollIntoView(true);",
								objTimeZone);
						je.executeScript("arguments[0].click();", objTimeZone);
			
			Thread.sleep(4000);
			//objTimeZone.click();
			
			GeneralUtil.logger
					.info("Navigated to Currencies by Select the TimeZone treeview item.");

			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Add From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Add");
			GeneralUtil.captureScreenshot();

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());
			
			Reporter.log("Test Step: Enter Name Value In Sub Window", 1, true);
			WebElement objName = GeneralUtil
					.getElement(
							"//div/div/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input",
							"xpath", dynamicTimeOut);
			strTimeZone = "AUTOUSD" + timeStamp;
			objName.sendKeys(strTimeZone);

			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Click On Ok Button", 1, true);
			WebElement objOkButton = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div[2]/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton.click();

			GeneralUtil.logger.info("Entered name as: " + strTimeZone
					+ " and clicked on ok button");
			Reporter.log("Test Step: Entered Name As: " + strTimeZone+ " And Clicked On Ok Button", 1, true);
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Timezone TIMEZONE");

			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			SearchElement.clear();
			Reporter.log("Test Step: Send Value Of TimeZone", 1, true);
			SearchElement.sendKeys(strTimeZone);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Step: Get Name Value For Filtered TimeZone", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']//div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strTimeZone)) {
				GeneralUtil.logger.info("Added new TimeZone:" + strTimeZone
						+ " Successfully.");
			} else {
				GeneralUtil.logger.error("Unable to add new TimeZone:"
						+ strTimeZone);
			}
			Reporter.log("Test Case: Successfully Added TimeZone", 1, true);
		} catch (Exception e) {
			GeneralUtil.logger.error("Unable to add TimeZone.");
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "static_addTimeZone" })
	public void static_editTimeZone() throws Exception {
		try {

			GeneralUtil.logger("Edit TimeZone");
			Reporter.log("Test Case: Edit TimeZone", 1, true);
			GeneralUtil.logger.info("Stated");
			
			Reporter.log("Test Step: Send Value To Name", 1, true);
			WebElement objName = GeneralUtil
					.getElement(
							"//div[contains(@class,'detailsBorder')]//div/div[2]/div/div/div/div[1]/div/div[2]/div/input",
							"xpath", dynamicTimeOut);

			objName.sendKeys("StandardOffset");
			
			Reporter.log("Test Step: Send Value To StandardOffset", 1, true);
			WebElement objStandardOffset = GeneralUtil
					.getElement(
							"//div[contains(@class,'detailsBorder')]//div/div[2]/div/div/div/div[1]/div/div[2]/div/input",
							"xpath", dynamicTimeOut);

			objStandardOffset.sendKeys("UTC+1");
			
			Reporter.log("Test Step: Send Value To DSTOffset", 1, true);
			WebElement objDSTOffset = GeneralUtil
					.getElement(
							"//div[contains(@class,'detailsBorder')]//div/div[2]/div/div/div/div[3]/div/div[2]/div/input",
							"xpath", dynamicTimeOut);

			objDSTOffset.sendKeys("UTC+2");
			Reporter.log("Test Step: Send Value To ChangeTime", 1, true);
			WebElement objChangeTime = GeneralUtil
					.getElement(
							"//div[contains(@class,'detailsBorder')]//div/div[2]/div/div/div/div[4]/div/div[2]/div/input",
							"xpath", dynamicTimeOut);
			objChangeTime.sendKeys("2:00");

			GeneralUtil.logger
					.info("Entered StandardOffset as: UTC+1, DSTOffset as:UTC+2, ChangeTime as:2:00");
			GeneralUtil.captureScreenshot();

			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("clicked on Save button");
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Step: Click OK Button On Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			GeneralUtil.logger
					.info("clicked OK button on confirmation window.");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Timezone TIMEZONE");

			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			SearchElement.clear();
			
			Reporter.log("Test Step: Send Value Of TimeZone To Search Element Name", 1, true);
			SearchElement.sendKeys(strTimeZone);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Get Name Value For Filtered TimeZone", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']//div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strTimeZone)) {
				GeneralUtil.logger.info("edited TimeZone:" + strTimeZone
						+ " Successfully.");
			} else {
				GeneralUtil.logger.error("Unable to edit TimeZone:"
						+ strTimeZone);
			}
			Reporter.log("Test Case: Successfully Edited TimeZone", 1, true);
		} catch (Exception e) {
			GeneralUtil.logger.error("Unable to edit TimeZone.");
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "static_editTimeZone" })
	public void static_deleteTimeZone() throws Exception {
		try {
			GeneralUtil.logger("Delete new TimeZone");
			Reporter.log("Test Case: Delete New TimeZone", 1, true);
			GeneralUtil.logger.info("Stated");
			
			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Delete From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Delete");
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Click OK Button On Delete Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();
			GeneralUtil.logger
					.info("Clicked OK buttion on delete Confirmation window.");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Delete timezone TIMEZONE");
			Reporter.log("Test Case: Successfully Deleted New TimeZone", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = "static_deleteTimeZone", alwaysRun=true)
	public void static_uploadTimeZone() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Upload TimeZone");
		Reporter.log("Test Case: Upload TimeZone", 1, true);
		GeneralUtil.logger.info("Stated");
		
		Reporter.log("Test Step: Click On Timezones", 1, true);
		String strTimeZoneXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Timezones']";
		WebElement objTimeZone = GeneralUtil.getElement(strTimeZoneXpath,
				"xpath", dynamicTimeOut);
		objTimeZone.click();
		GeneralUtil.logger
				.info("Navigated to Currencies by Select the TimeZone treeview item.");

		// Right click on element and select context Menue item
		Reporter.log("Test Step: Click On Clear All Filters From Context Menu", 1, true);
		WebElement contextMenuelement1 = GeneralUtil.getElement(
				"//*[@ref='center']/div/div[4]/div[3]/div", "xpath",
				dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement1);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "Clear All Filters");
		GeneralUtil.captureScreenshot();

		Reporter.log("Test Step: Send Value To Search Element Name", 1, true);
		WebElement SearchElement = driver
				.findElement(By
						.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
		SearchElement.clear();
		SearchElement.sendKeys("DUBLIN");
		
		// Right click on element and select context Menue item
		Reporter.log("Test Step: Click On NXT Upload From Context Menu", 1, true);
		WebElement contextMenuelement = GeneralUtil
				.getElement(
						"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
						"xpath", dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "NXT Upload");
		
		Thread.sleep(1000);
		GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\Repository\\TimeZone\\DUBLIN.nxt");

		Thread.sleep(2000);
		
		// Verification for success notification

		Reporter.log("Test Step: Verification For Success Notification", 1, true);
		Common.handleNotifications("Upload timezone template");
		Reporter.log("Test Case: Successfully Uploaded TimeZone", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "static_uploadTimeZone", alwaysRun=true)
	public void static_downloadTimeZone() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Download TimeZone");
		Reporter.log("Test Case: Download TimeZone", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select DownloadAll From NXT Download From Context Menu", 1, true);
		Common.download("NXT Download", "Download All", "timezone(.*).zip",
				strmenu, strmenu);

		GeneralUtil.logger.info("TimeZone downloaded successfully");
		Reporter.log("Test Case: Successfully Downloaded TimeZone", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "static_downloadTimeZone", alwaysRun=true)
	public void static_exportTimeZone() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export TimeZone");
		Reporter.log("Test Case: Export TimeZone", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("TimeZone CSV Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("TimeZone Excel Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported TimeZone", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "static_exportTimeZone", alwaysRun=true)
	public void static_addRiskScripts() throws Exception {
		try {

			GeneralUtil.logger("Add RiskScripts");
			Reporter.log("Test Case: Add RiskScripts", 1, true);
			GeneralUtil.logger.info("Stated");
			Reporter.log("Test Step: Click On Risk Scripts", 1, true);
			String strRiskScriptsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Risk Scripts']";
			WebElement objRiskScripts = GeneralUtil.getElement(
					strRiskScriptsXpath, "xpath", dynamicTimeOut);
			
			// Create instance of Javascript executor
						Reporter.log("Test Step: Create Instance Of Javascript Executor", 1, true);
									JavascriptExecutor je = (JavascriptExecutor) driver;
									// Identify the WebElement which will appear after scrolling
									// down
									// WebElement element = driver.findElement(By.tagName("...."));
									// now execute query which actually will scroll until that
									// element is not appeared on page.
									je.executeScript("arguments[0].scrollIntoView(true);",
											objRiskScripts);
									je.executeScript("arguments[0].click();", objRiskScripts);
						//objReferenceData.click();
						Thread.sleep(4000);
			//objRiskScripts.click();

			GeneralUtil.logger
					.info("Navigated to Currencies by Select the Risk Scripts treeview item.");
			
			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Add From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Add");
			GeneralUtil.captureScreenshot();

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());
			
			Reporter.log("Test Step: Enter Name Value In Sub Window", 1, true);
			WebElement objName = GeneralUtil
					.getElement(
							"//div/div/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input",
							"xpath", dynamicTimeOut);
			String strRiskScripts = "AUTOUSD" + timeStamp;
			objName.sendKeys(strRiskScripts);
			
			Reporter.log("Test Step: Click On Ok Button", 1, true);
			WebElement objOkButton = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div[2]/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton.click();

			GeneralUtil.logger.info("Entered name as: " + strRiskScripts
					+ " and clicked on ok button");
			Reporter.log("Test Step: Entered Name As: "+ strRiskScripts +" And Clicked On OK Button", 1, true);
			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("clicked on Save button");
			
			Reporter.log("Test Step: Click On OK Button On Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();
			Reporter.log("Test Step: Clicked On OK Button On Confirmation Window", 1, true);
			GeneralUtil.logger
					.info("clicked OK button on confirmation window.");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Script");

			//Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");
			Reporter.log("Test Step: Send Value Of RiskScripts", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(strRiskScripts);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Step: Get Name Value For Filtered RiskScripts", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']//div/div[4]/div[3]/div/div[1]/div[1]/div[1]/span/span[2]"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strRiskScripts)) {
				GeneralUtil.logger.info("Added new RiskScripts:"
						+ strRiskScripts + " Successfully.");
			} else {
				GeneralUtil.logger.error("Unable to add new RiskScripts:"
						+ strRiskScripts);
			}
			Reporter.log("Test Case: Successfully Added RiskScripts", 1, true);
		} catch (Exception e) {
			GeneralUtil.logger.error("Unable to add RiskScripts.");
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "static_addRiskScripts" })
	public void static_editRiskScripts() throws Exception {
		try {

			GeneralUtil.logger("Edit RiskScripts");
			Reporter.log("Test Case: Edit RiskScripts", 1, true);
			GeneralUtil.logger.info("Stated");
			
			Reporter.log("Test Step: Edit Value Of Name", 1, true);
			
			WebElement objNameElement = GeneralUtil
					.getElement(
							".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[1]/div/div[1]",
							"xpath", dynamicTimeOut);
			objNameElement.click();
			Thread.sleep(1000);
			WebElement objName = GeneralUtil
					.getElement(
							"//div[contains(@class,'detailsContainer')]//div/div[2]/div/div[1]/div/div[2]/div/input",
							"xpath", dynamicTimeOut);

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());
			String strEditRiskScripts = "AUTOUSD" + timeStamp;
			objName.clear();
			objName.sendKeys(strEditRiskScripts);

			GeneralUtil.logger.info("edited " + strRiskScripts + " name form "
					+ strRiskScripts + " to " + strEditRiskScripts);
			Reporter.log("Test Step: Edited " + strRiskScripts + " Name From "+ strRiskScripts + " To " + strEditRiskScripts, 1, true);
			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("clicked on Save button");
			
			Reporter.log("Test Step: Click OK Button On Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			GeneralUtil.logger
					.info("clicked OK button on confirmation window.");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Script");
			
			//TT 45574 - Application change in in build 4.6
			//Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");

			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			Reporter.log("Test Step: Send Value To Search Element Name", 1, true);
			SearchElement.sendKeys(strEditRiskScripts);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Get Name Value For Filtered RiskScripts", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']//div/div[4]/div[3]/div/div[1]/div[1]/div[1]/span/span[2]"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strEditRiskScripts)) {
				GeneralUtil.logger.info("Edited RiskScripts:" + strRiskScripts
						+ " Successfully.");
				strRiskScripts = strEditRiskScripts;
			} else {
				GeneralUtil.logger.error("Unable to edit RiskScripts:"
						+ strEditRiskScripts);
			}
			Reporter.log("Test Case: Successfully Edited RiskScripts", 1, true);
		} catch (Exception e) {
			GeneralUtil.logger.error("Unable to edit RiskScripts.");
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "static_editRiskScripts" })
	public void static_deleteRiskScripts() throws Exception {
		try {
			GeneralUtil.logger("Delete new RiskScripts");
			Reporter.log("Test Case: Delete New RiskScripts", 1, true);
			GeneralUtil.logger.info("Stated");
			Thread.sleep(1000);
			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Delete From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Delete");
			GeneralUtil.captureScreenshot();
			Thread.sleep(1000);
			Reporter.log("Test Step: Click OK Button On Delete Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();
			Thread.sleep(1000);
			GeneralUtil.logger
					.info("Clicked OK buttion on delete Confirmation window.");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			//Common.handleNotifications("Save RiskScripts");
			Reporter.log("Test Case: Successfully Deleted New RiskScripts", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = "static_deleteRiskScripts", alwaysRun=true)
	public void static_uploadRiskScripts() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Upload Risk Scripts");
		Reporter.log("Test Case: Upload Risk Scripts", 1, true);
		GeneralUtil.logger.info("Stated");
		
		Reporter.log("Test Step: Click On Risk Scripts", 1, true);
		String strRiskScriptsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Risk Scripts']";
		WebElement objRiskScripts = GeneralUtil.getElement(strRiskScriptsXpath,
				"xpath", dynamicTimeOut);
		objRiskScripts.click();
		
		// Right click on element and select context Menue item
		Reporter.log("Test Step: Click On Clear All Filters From Context Menu", 1, true);
		WebElement contextMenuelement1 = GeneralUtil.getElement(
				"//*[@ref='center']/div/div[4]/div[3]/div", "xpath",
				dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement1);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "Clear All Filters");
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Send Value Of RiskScript To Search Element Name", 1, true);
		WebElement SearchElement = driver
				.findElement(By
						.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
		SearchElement.clear();
		SearchElement.sendKeys("COLLATERALSCRIPT");
		
		// Right click on element and select context Menue item
		Reporter.log("Test Step: Click On TXT Upload From Context Menu", 1, true);
		WebElement contextMenuelement = GeneralUtil
				.getElement(
						"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
						"xpath", dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "TXT Upload");
		
		Thread.sleep(1000);
		GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\Data\\Scripts\\COLLATERALSCRIPT.txt");

		Thread.sleep(2000);
		
		// Verification for success notification
		Reporter.log("Test Step: Verification For Success Notification", 1, true);
		Common.handleNotifications("Upload risk script");
		Reporter.log("Test Case: Successfully Uploaded Risk Scripts", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "static_uploadRiskScripts", alwaysRun=true)
	public void static_downloadRiskScripts() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Download Risk Scripts");
		Reporter.log("Test Case: Download Risk Scripts", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();

		Reporter.log("Test Step: Select DownloadAll From TXT Download From Context Menu", 1, true);
		Common.download("TXT Download", "Download All",
				"RiskCalculationScript(.*).zip", strmenu, strmenu);
		GeneralUtil.logger.info("Risk Scripts downloaded successfully");
		Reporter.log("Test Case: Successfully Downloaded Risk Scripts", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "static_downloadRiskScripts", alwaysRun=true)
	public void static_exportRiskScripts() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export RiskScripts");
		Reporter.log("Test Case: Export RiskScripts", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("RiskScripts CSV Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("RiskScripts Excel Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported RiskScripts", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "static_exportRiskScripts", alwaysRun=true)
	public void static_addReferenceData() throws Exception {
		try {

			GeneralUtil.logger("Add ReferenceData");
			Reporter.log("Test Case: Add ReferenceData", 1, true);
			GeneralUtil.logger.info("Stated");
			
			Reporter.log("Test Step: Click On Reference Data", 1, true);
			String strReferenceDataXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Reference Data']";
			WebElement objReferenceData = GeneralUtil.getElement(
					strReferenceDataXpath, "xpath", dynamicTimeOut);
			
			// Create instance of Javascript executor
			Reporter.log("Test Step: Create Instance Of Javascript Executor", 1, true);
						JavascriptExecutor je = (JavascriptExecutor) driver;
						// Identify the WebElement which will appear after scrolling
						// down
						// WebElement element = driver.findElement(By.tagName("...."));
						// now execute query which actually will scroll until that
						// element is not appeared on page.
						je.executeScript("arguments[0].scrollIntoView(true);",
								objReferenceData);
						je.executeScript("arguments[0].click();", objReferenceData);
			//objReferenceData.click();
			Thread.sleep(4000);
			
			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Add From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Add");
			GeneralUtil.captureScreenshot();
			Thread.sleep(1000);
			

			Reporter.log("Test Step: Enter Name Value In Sub Window", 1, true);
			WebElement objName = GeneralUtil
					.getElement(
							"//div/div/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input",
							"xpath", dynamicTimeOut);
			
			objName.sendKeys(strReferenceData);
			objName.sendKeys(Keys.TAB);
			Thread.sleep(2000);
		
			
			// Enter values in add page in AobjReference Data Type
			Reporter.log("Test Step: Enter Reference Data Type Value In Sub Window", 1, true);
						driver.findElement(
								By.xpath("//div[@class='react-draggable']/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div/div/div/div/span/div[1]"))
								.click();
						GeneralUtil.contextMenuItem(
								"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
								"REFERENCEDATA.IR.CURVEOPTIONS");

						Reporter.log("Test Step: Click On Ok Button", 1, true);
			WebElement objOkButton = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div[2]/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton.click();

			
			Reporter.log("Test Step: Send Value To ReferenceDataPara", 1, true);
			WebElement objReferenceDataPara = GeneralUtil
					.getElement(
							".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div/div/div[2]/div/div/div[1]/div[2]/div/input",
							"xpath", dynamicTimeOut);
			objReferenceDataPara.sendKeys("AUTOPARA");

			Reporter.log("Test Step: Send Value To ReferenceDataDate", 1, true);
			WebElement objReferenceDataDate = GeneralUtil
					.getElement(
							".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/div/span/i",
							"xpath", dynamicTimeOut);
			objReferenceDataDate.click();

			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Add From Context Menu In Sub Window", 1, true);
			WebElement contextMenuelement3 = GeneralUtil
					.getElement(
							"//div[@class='react-draggable']/div/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div[2]/div[2]",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement3);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Add");
			GeneralUtil.captureScreenshot();
			Thread.sleep(1000);
			
			
			
			Reporter.log("Test Step: Click On Credit Event Date Field", 1, true);
			WebElement objDateElement = GeneralUtil
					.getElement(
							"html/body/div[7]/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div[2]/div[2]/div/div[1]/div/div[4]/div[3]/div/div[1]/div/div/div",
							"xpath", dynamicTimeOut);
			objDateElement.click();;
			
			Reporter.log("Test Step: Send Value To Credit Event Date Field", 1, true);
			WebElement objDateTextElement = GeneralUtil
					.getElement(
							"html/body/div[7]/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div[2]/div[2]/div/div[1]/div/div[4]/div[3]/div/div[1]/div/div/div/div/input",
							"xpath", dynamicTimeOut);
			objDateTextElement.sendKeys(systemDate);
			
			Reporter.log("Test Step: Click On Save In Credit Event Dialogue Box", 1, true);
			WebElement objSaveDiolog = GeneralUtil
					.getElement(
							"html/body/div[7]/div/div/div/div/div[1]/div/div[2]/div/div[1]/div[1]/div[1]/button[1]",
							"xpath", dynamicTimeOut);
			objSaveDiolog.click();

			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			Reporter.log("Test Step: Click On Ok Button In Save Button Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			//Common.handleNotifications("Save Reference Data");

			/*Reporter.log("Test Step: Click On Cancel Button", 1, true);
			WebElement objCancelButton = GeneralUtil.getElement(
					"//div[text()='Cancel']", "xpath", dynamicTimeOut);
			objCancelButton.click();*/

			//TT 45574 - Application change in in build 4.6
			//Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");

			Reporter.log("Test Step: Send Value Of ReferenceData To Search Element Name", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(strReferenceData);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Get Name Value For Filtered ReferenceData", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/span/span[2]"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strReferenceData)) {
				GeneralUtil.logger.info("Added new ReferenceData:"
						+ strReferenceData + " Successfully.");
			} else {
				GeneralUtil.logger.error("Unable to add new ReferenceData:"
						+ strReferenceData);
			}
			Reporter.log("Test Case: Successfully Added ReferenceData", 1, true);
		} catch (Exception e) {
			GeneralUtil.logger.error("Unable to add ReferenceData.");
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "static_addReferenceData" })
	public void static_editReferenceData() throws Exception {
		try {

			GeneralUtil.logger("Edit ReferenceData");
			Reporter.log("Test Case: Edit ReferenceData", 1, true);
			GeneralUtil.logger.info("Stated");
			
			Reporter.log("Test Step: Click On Required ReferenceData", 1, true);
			driver.findElement(
					By.xpath("/.//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/span/span[2]"))
					.click();

			Reporter.log("Test Step: Clear And Edit Value Of Name", 1, true);
			WebElement objReferenceDataPara = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input",
							"xpath", dynamicTimeOut);

			objReferenceDataPara.clear();
			objReferenceDataPara.sendKeys("AUTOEditPARA");
			
			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			Reporter.log("Test Step: Click On Ok Button In Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Reference Data");

			/*Reporter.log("Test Step: Click On Cancel Button", 1, true);
			WebElement objCancelButton = GeneralUtil.getElement(
					"//div[text()='Cancel']", "xpath", dynamicTimeOut);
			objCancelButton.click();*/

			////TT 45574 - Application change in in build 4.6
			//Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");

			Reporter.log("Test Step: Send ReferenceData Value To Search Element Name", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(strReferenceData);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Get Name Value For Filtered ReferenceData", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/span/span[2]"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strReferenceData)) {
				GeneralUtil.logger.info("Edited ReferenceData:"
						+ strReferenceData + " Successfully.");
			} else {
				GeneralUtil.logger.error("Unable to edit ReferenceData:"
						+ strReferenceData);
			}
			Reporter.log("Test Case: Successfully Edited ReferenceData", 1, true);
		} catch (Exception e) {
			GeneralUtil.logger.error("Unable to edit ReferenceData.");
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = { "static_editReferenceData" })
	public void static_cloneReferenceData() throws Exception {
		try {

			GeneralUtil.logger("Clone Reference Data");
			Reporter.log("Test Case: Clone ReferenceData", 1, true);
			GeneralUtil.logger.info("Stated");
			
			Reporter.log("Test Step: Click On Reference", 1, true);
			driver.findElement(
					By.xpath("/.//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/span/span[2]"))
					.click();

			Reporter.log("Test Step: Search The Reference Data Name", 1, true);
			WebElement objReferenceDataPara = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input",
							"xpath", dynamicTimeOut);

			objReferenceDataPara.clear();
			objReferenceDataPara.sendKeys(strReferenceData);
			Thread.sleep(1000);
			// Right click on element and select context Menue item
						Reporter.log("Test Step: Right Click On Element And Select Clone From Context Menu", 1, true);
						WebElement contextMenuelement = GeneralUtil
								.getElement(
										"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
										"xpath", dynamicTimeOut);
						GeneralUtil.contextMenu(contextMenuelement);
						GeneralUtil.captureScreenshot();
						GeneralUtil.contextMenuItem(strmenu, "Clone");
						GeneralUtil.captureScreenshot();
						Thread.sleep(1000);
						
			// Enter Reference Data Name text Field For Clone
			Reporter.log("Test Step: Enter Reference Data Name text Field For Clone", 1, true);
			WebElement objNameText = GeneralUtil.getElement(
						".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div/div/div[2]/div/div/div[1]/div[2]/div/input", "xpath", dynamicTimeOut);
			objNameText.clear();
			objNameText.sendKeys(strCloneReferenceData);		
						
						
						
			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			Reporter.log("Test Step: Click On Ok Button In Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Reference Data");

			/*Reporter.log("Test Step: Click On Cancel Button", 1, true);
			WebElement objCancelButton = GeneralUtil.getElement(
					"//div[text()='Cancel']", "xpath", dynamicTimeOut);
			objCancelButton.click();*/

			////TT 45574 - Application change in in build 4.6
			//Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");

			Reporter.log("Test Step: Send ReferenceData Value To Search Element Name", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(strCloneReferenceData);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Get Name Value For Filtered ReferenceData", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/span/span[2]"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strCloneReferenceData)) {
				GeneralUtil.logger.info("Cloned ReferenceData:"
						+ strCloneReferenceData + " Successfully.");
			} else {
				GeneralUtil.logger.error("Unable to clone ReferenceData:"
						+ strCloneReferenceData);
			}
			Reporter.log("Test Case: Successfully Cloned ReferenceData", 1, true);
		} catch (Exception e) {
			GeneralUtil.logger.error("Unable to clone ReferenceData.");
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "static_cloneReferenceData" })
	public void static_deleteReferenceData() throws Exception {
		try {
			GeneralUtil.logger("Delete new ReferenceData");
			Reporter.log("Test Case: Delete New ReferenceData", 1, true);
			GeneralUtil.logger.info("Stated");
			deleteReferenceData(strReferenceData);
			Thread.sleep(1000);
			deleteReferenceData(strCloneReferenceData);
			
			Reporter.log("Test Case: Successfully Deleted New ReferenceData", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = "static_deleteReferenceData", alwaysRun=true)
	public void static_uploadReferenceData() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Upload Reference Data");
		Reporter.log("Test Case: Upload Reference Data", 1, true);
		GeneralUtil.logger.info("Stated");
		
		Reporter.log("Test Step: Click On Reference Data", 1, true);
		String strReferenceDataXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Reference Data']";
		WebElement objReferenceData = GeneralUtil.getElement(
				strReferenceDataXpath, "xpath", dynamicTimeOut);
		objReferenceData.click();
		
		// Right click on element and select context Menue item
		Reporter.log("Test Step: Click On Clear All Filters From Context Menu", 1, true);
		WebElement contextMenuelement1 = GeneralUtil.getElement(
				"//*[@ref='center']/div/div[4]/div[3]/div", "xpath",
				dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement1);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "Clear All Filters");
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Send Value Of ReferenceData To Search Element Name", 1, true);
		WebElement SearchElement = driver
				.findElement(By
						.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
		SearchElement.clear();
		SearchElement.sendKeys("CDXPROTOTYPE");
		
		// Right click on element and select context Menue item
		Reporter.log("Test Step: Click On CSV Upload From Context Menu", 1, true);
		WebElement contextMenuelement = GeneralUtil
				.getElement(
						"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
						"xpath", dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "CSV Upload");
		
		Thread.sleep(1000);
		GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\Data\\ReferenceData\\CDXPROTOTYPE.csv");

		Thread.sleep(2000);
		
		// Verification for success notification
		Reporter.log("Test Step: Verification For Success Notification", 1, true);
		Common.handleNotifications("Upload Reference Data");
		Reporter.log("Test Case: Successfully Uploaded Reference Data", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "static_uploadReferenceData", alwaysRun=true)
	public void static_downloadReferenceData() throws Exception {
		try{
		GeneralUtil.logger = Logger.getLogger("Download Reference Data");
		Reporter.log("Test Case: Download Reference Data", 1, true);
		GeneralUtil.logger.info("Stated");
		
		// Right click on element and select context Menue item
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		Reporter.log("Test Step: Select DownloadAll From CSV Download From Context Menu", 1, true);
		Common.download("CSV Download", "Download All",
				"ReferenceData(.*).zip", strmenu, strmenu);
		GeneralUtil.logger.info("ReferenceData downloaded successfully");
		Reporter.log("Test Case: Successfully Downloaded Reference Data", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "static_downloadReferenceData", alwaysRun=true)
	public void static_exportReferenceData() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export ReferenceData");
		Reporter.log("Test Case: Export ReferenceData", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("ReferenceData CSV Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("ReferenceData Excel Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported ReferenceData", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "static_exportReferenceData", alwaysRun=true)
	public void static_addCapitalSupervisoryParameter() throws Exception {
		try {

			GeneralUtil
					.logger("CapitalParameter- Add SupervisoryParameter");
			Reporter.log("Test Case: CapitalParameter- Add SupervisoryParameter", 1, true);
			GeneralUtil.logger.info("Stated");
			
			Reporter.log("Test Step: Click On Capital Parameters", 1, true);
			String strReferenceDataXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Capital Parameters']";
			WebElement objReferenceData = GeneralUtil.getElement(
					strReferenceDataXpath, "xpath", dynamicTimeOut);
			objReferenceData.click();
			Thread.sleep(3000);
			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Add From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Add");
			GeneralUtil.captureScreenshot();

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());

			strSupervisoryParameter = "AUTO" + timeStamp;

			Integer intColNumber = Common.getColumnNumber("Asset Class");
			
			Reporter.log("Test Step: Enter Asset Class Value As IR For SupervisoryParameter "+ strSupervisoryParameter, 1, true);
			gridSendKeys(
					String.format(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div/div",
							2, intColNumber), strSupervisoryParameter);
			GeneralUtil.logger
					.info("Entered Asset Class value as IR for SupervisoryParameter "
							+ strSupervisoryParameter);

			intColNumber = Common.getColumnNumber("Sub Class");
			
			Reporter.log("Test Step: Enter Sub Class Value As IR For SupervisoryParameter "+ strSupervisoryParameter, 1, true);
			gridSendKeys(
					String.format(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div/div",
							2, intColNumber), "Auto");
			GeneralUtil.logger
					.info("Entered Asset Class value as IR for SupervisoryParameter "
							+ strSupervisoryParameter);

			intColNumber = Common.getColumnNumber("Supervisory Factor");
			
			Reporter.log("Test Step: Enter Supervisory Factor Value As IR For SupervisoryParameter "+ strSupervisoryParameter, 1, true);
			gridSendKeysJS(
					String.format(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div/div",
							2, intColNumber), "0.0025");
			GeneralUtil.logger
					.info("Entered Supervisory Factor value as 0.0025 for Supervisory Parameter "
							+ strSupervisoryParameter);
			
			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("clicked on Save button");
			GeneralUtil.captureScreenshot();

			Reporter.log("Test Step: Click On Ok Button On Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			GeneralUtil.logger
					.info("clicked OK button on confirmation window.");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Capital Parameters");

			Reporter.log("Test Step: Send Value Of SupervisoryParameter To Search Element", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(strSupervisoryParameter);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			Reporter.log("Test Step: Get SupervisoryParameter Value For Filtered Capital Parameters", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/div/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strSupervisoryParameter)) {
				GeneralUtil.logger.info("added Supervisory Parameter:"
						+ strSupervisoryParameter + " Successfully.");
			} else {
				GeneralUtil.logger.error("Unable to add Supervisory Parameter:"
						+ strSupervisoryParameter);
			}
			Reporter.log("Test Case: Successfully CapitalParameter- Added SupervisoryParameter", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = { "static_addCapitalSupervisoryParameter" })
	public void static_editCapitalSupervisoryParameter() throws Exception {
		try {
			GeneralUtil
					.logger("CapitalParameter- Edit SupervisoryParameter");
			Reporter.log("Test Case: CapitalParameter- Edit SupervisoryParameter", 1, true);
			GeneralUtil.logger.info("Stated");
			clearAllFilters();

			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			Reporter.log("Test Step: Send CapitalSupervisoryParameter Value To SearchElement", 1, true);
			SearchElement.sendKeys(strSupervisoryParameter);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			int intColNumber = Common.getColumnNumber("Asset Class");
			int intRowNumber = Common.getRowNumber(intColNumber,
					strSupervisoryParameter);

			intColNumber = Common
					.getColumnNumber("Supervisory Correlation");
			
			Reporter.log("Test Step: Enter Supervisory Correlation As 0.5 For SupervisoryParameter "+ strSupervisoryParameter, 1, true);
			gridSendKeys(
					String.format(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div/div",
							intRowNumber, intColNumber), "0.5");
			GeneralUtil.logger
					.info("Entered Supervisory Correlation as 0.5 for SupervisoryParameter "
							+ strSupervisoryParameter);

			intColNumber = Common
					.getColumnNumber("Supervisory Option Volatility");
			
			Reporter.log("Test Step: Entered Supervisory Option Volatility Value As 1 For SupervisoryParameter "+ strSupervisoryParameter, 1, true);
			gridSendKeysJS(
					String.format(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div/div",
							intRowNumber, intColNumber), "1");
			GeneralUtil.logger
					.info("Entered Supervisory Option Volatility value as 1 for SupervisoryParameter "
							+ strSupervisoryParameter);

			GeneralUtil.captureScreenshot();
			
			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("clicked on Save button");
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Click OK Button On Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			GeneralUtil.logger
					.info("clicked OK button on confirmation window.");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Capital Parameters");

			WebElement SearchElement1 = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement1.clear();
			Reporter.log("Test Step: Send Value Of SupervisoryParameter To Search Element", 1, true);
			SearchElement1.sendKeys(strSupervisoryParameter);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Get SupervisoryParameter Value For Filtered CapitalParameter", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/div/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strSupervisoryParameter)) {
				GeneralUtil.logger.info("Edited Supervisory Parameter:"
						+ strSupervisoryParameter + " Successfully.");
			} else {
				GeneralUtil.logger
						.error("Unable to Edit Supervisory Parameter:"
								+ strSupervisoryParameter);
			}
			Reporter.log("Test Case: Successfully CapitalParameter- Edited SupervisoryParameter", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = { "static_editCapitalSupervisoryParameter" })
	public void static_exportCapitalSupervisoryParameter() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export Capital -SupervisoryParameter");
		Reporter.log("Test Case: Export Capital -SupervisoryParameter", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("CapitalSupervisoryParameter Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver
				.findElement(By
						.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("CapitalSupervisoryParameter Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported Capital -SupervisoryParameter", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "static_exportCapitalSupervisoryParameter" })
	public void static_deleteCapitalSupervisoryParameter() throws Exception {
		try {
			GeneralUtil
					.logger("Delete CapitalParameter- Supervisor Parameter");
			Reporter.log("Test Case: Delete CapitalParameter- Supervisor Parameter", 1, true);
			GeneralUtil.logger.info("Stated");
			
			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Delete From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil
					.getElement(
							"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div",
							"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Delete");
			GeneralUtil.captureScreenshot();
			
			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("clicked on Save button");
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Click OK button On Delete Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();
			GeneralUtil.logger
					.info("Clicked OK buttion on delete Confirmation window.");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Capital Parameters");
			Reporter.log("Test Case: Successfully Deleted CapitalParameter- Supervisor Parameter", 1, true);
			
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = "static_deleteCapitalSupervisoryParameter", alwaysRun=true)
	public void static_addCapitalSACCRRiskWeightsParameter() throws Exception {
		try {

			GeneralUtil
					.logger("CapitalParameter- Add SACCRRiskWeights");
			Reporter.log("Test Case: CapitalParameter- Add SACCRRiskWeights", 1, true);
			GeneralUtil.logger.info("Stated");
			
			Reporter.log("Test Step: Click On Capital Parameters", 1, true);
			String strReferenceDataXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Capital Parameters']";
			WebElement objReferenceData = GeneralUtil.getElement(
					strReferenceDataXpath, "xpath", dynamicTimeOut);
			objReferenceData.click();
			Thread.sleep(3000);
			GeneralUtil.logger
					.info("Navigated to Capital Parameters by Select the Capital Parameters treeview item.");

			Thread.sleep(1000);
			
			Reporter.log("Test Step: Click On SACCR Risk Weights", 1, true);
			WebElement objLabelTab = GeneralUtil.getElement(
					"//label[text()='SACCR Risk Weights']", "xpath",
					dynamicTimeOut);
			objLabelTab.click();
			Thread.sleep(1000);
			GeneralUtil.logger
					.info("selected SACCR Risk Weights tab and navigated to SACCR Risk Weights screen.");
			
			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Add From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil.getElement(
					"//*[@ref='center']/div/div[4]/div[3]//div/div[2]/div",
					"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Add");
			GeneralUtil.captureScreenshot();

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());

			strSACCRRiskWeights = "AUTO" + timeStamp;

			Integer intColNumber = Common.getColumnNumber("Rating");
			
			Reporter.log("Test Step: Enter Asset Class Value As IR For SACCRRiskWeightsParameter "+ strSACCRRiskWeights, 1, true);
			gridSendKeys(
					"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[2]/div[1]/div/div",
					strSACCRRiskWeights);
			GeneralUtil.logger
					.info("Entered Asset Class value as IR for SACCRRiskWeightsParameter "
							+ strSACCRRiskWeights);

			intColNumber = Common.getColumnNumber("Sub Risk Weight Class");
			
			Reporter.log("Test Step: Enter Sub Risk Weight Class Value As 0.007 For SACCRRiskWeightsParameter "+ strSACCRRiskWeights, 1, true);
			gridSendKeysJS(
					".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[2]/div[2]/div/div",
					"0.007");
			GeneralUtil.logger
					.info("Entered Sub Risk Weight Class value as 0.007 for SACCRRiskWeightsParameter "
							+ strSACCRRiskWeights);
			
			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("clicked on Save button");
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Click OK Button On Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			GeneralUtil.logger
					.info("clicked OK button on confirmation window.");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Capital Parameters");

			Reporter.log("Test Step: Send Value Of SACCRRiskWeights", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(strSACCRRiskWeights);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Get SACCRRiskWeights Value For Filtered SACCRRiskWeights", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/div/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strSACCRRiskWeights)) {
				GeneralUtil.logger.info("added SACCRRiskWeights Parameter:"
						+ strSACCRRiskWeights + " Successfully.");
			} else {
				GeneralUtil.logger
						.error("Unable to add SACCRRiskWeights Parameter:"
								+ strSACCRRiskWeights);
			}
			Reporter.log("Test Case: Successfully CapitalParameter- Added SACCRRiskWeights", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = { "static_addCapitalSACCRRiskWeightsParameter" })
	public void static_editCapitalSACCRRiskWeightsParameter() throws Exception {
		try {
			GeneralUtil
					.logger("CapitalParameter- Edit SACCRRiskWeights");
			Reporter.log("Test Case: CapitalParameter- Edit SACCRRiskWeights", 1, true);
			GeneralUtil.logger.info("Stated");
			clearAllFilters();

			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			Reporter.log("Test Step: Send Value Of SACCRRiskWeights To Search Element", 1, true);
			SearchElement.sendKeys(strSACCRRiskWeights);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			Reporter.log("Test Step: Enter Sub Risk Weight Class Value As 0.078 For SACCRRiskWeightsParameter "+ strSACCRRiskWeights, 1, true);
			gridSendKeysJS(
					".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]/div/div",
					"0.078");
			GeneralUtil.logger
					.info("Entered Sub Risk Weight Class value as 0.078 for SACCRRiskWeightsParameter "
							+ strSACCRRiskWeights);

			GeneralUtil.captureScreenshot();
			
			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("clicked on Save button");
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Click On Ok Button On Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			GeneralUtil.logger
					.info("clicked OK button on confirmation window.");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Capital Parameters");

			WebElement SearchElement1 = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement1.clear();
			Reporter.log("Test Step: Send Value Of SACCRRiskWeights To Search Element", 1, true);
			SearchElement1.sendKeys(strSACCRRiskWeights);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Get SACCRRiskWeights Value For Filtered Row", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/div/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strSACCRRiskWeights)) {
				GeneralUtil.logger.info("Edited SACCR Risk Weights Parameter:"
						+ strSACCRRiskWeights + " Successfully.");
			} else {
				GeneralUtil.logger
						.error("Unable to Edit SACCR Risk Weights Parameter:"
								+ strSACCRRiskWeights);
			}
			Reporter.log("Test Case:  Successfully CapitalParameter- Edited SACCRRiskWeights", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = { "static_editCapitalSACCRRiskWeightsParameter" })
	public void static_exportCapitalSACCRRiskWeightsParameter() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export Capital -SACCRRiskWeightsParameter");
		Reporter.log("Test Case: Export Capital -SACCRRiskWeightsParameter", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver.findElement(By
				.xpath("//*[@ref='center']/div/div[4]/div[3]//div/div[2]/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Capital SACCR Risk Weights Parameter Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver.findElement(By
				.xpath("//*[@ref='center']/div/div[4]/div[3]//div/div[2]/div"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Capital SACCR Risk Weights Parameter Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported Capital -SACCRRiskWeightsParameter", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "static_exportCapitalSACCRRiskWeightsParameter" })
	public void static_deleteCapitalSACCRRiskWeightsParameter() throws Exception {
		try {
			GeneralUtil
					.logger("Delete CapitalParameter- SACCRRiskWeights");
			Reporter.log("Test Case: Delete CapitalParameter- SACCRRiskWeights", 1, true);
			GeneralUtil.logger.info("Stated");
			
			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Delete From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil.getElement(
					"//*[@ref='center']/div/div[4]/div[3]//div/div[2]/div",
					"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Delete");
			GeneralUtil.captureScreenshot();

			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("clicked on Save button");
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Click On Ok Button On Delete Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();
			GeneralUtil.logger
					.info("Clicked OK buttion on delete Confirmation window.");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Capital Parameters");
			Reporter.log("Test Case: Successfully Deleted CapitalParameter- SACCRRiskWeights", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = "static_deleteCapitalSACCRRiskWeightsParameter", alwaysRun=true)
	public void static_addCapitalSACVARiskWeightsParameter() throws Exception {
		try {

			GeneralUtil
					.logger("CapitalParameter- Add SACVARiskWeights");
			Reporter.log("Test Case: CapitalParameter- Add SACVARiskWeights", 1, true);
			GeneralUtil.logger.info("Stated");
			
			Reporter.log("Test Step: Click On Capital Parameters", 1, true);
			String strReferenceDataXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Capital Parameters']";
			WebElement objReferenceData = GeneralUtil.getElement(
					strReferenceDataXpath, "xpath", dynamicTimeOut);
			objReferenceData.click();
			Thread.sleep(3000);
			GeneralUtil.logger
					.info("Navigated to Capital Parameters by Select the Capital Parameters treeview item.");

			Thread.sleep(1000);
			
			Reporter.log("Test Step: Click On SACVA Risk Weights", 1, true);
			WebElement objLabelTab = GeneralUtil.getElement(
					"//label[text()='SACVA Risk Weights']", "xpath",
					dynamicTimeOut);
			objLabelTab.click();
			Thread.sleep(1000);
			GeneralUtil.logger
					.info("selected SACVA Risk Weights tab and navigated to SACVA Risk Weights screen.");
			
			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Add From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil.getElement(
					"//*[@ref='center']/div/div[4]/div[3]//div/div[2]/div",
					"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Add");
			GeneralUtil.captureScreenshot();

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());

			strSACVARiskWeights = "AUTO" + timeStamp;

			Integer intColNumber = Common.getColumnNumber("Rating");
			
			Reporter.log("Test Step: Enter Asset Class Value As IR For SACVARiskWeightsParameter "+ strSACVARiskWeights, 1, true);
			gridSendKeys(
					"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[2]/div[1]/div/div",
					strSACVARiskWeights);
			GeneralUtil.logger
					.info("Entered Asset Class value as IR for SACVARiskWeightsParameter "
							+ strSACVARiskWeights);

			intColNumber = Common.getColumnNumber("Sub Risk Weight Class");
			
			Reporter.log("Test Step: Enter Sub Risk Weight Class Value As 0.007 For SACVARiskWeightsParameter "+ strSACVARiskWeights, 1, true);
			gridSendKeysJS(
					".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[2]/div[2]/div/div",
					"0.007");
			GeneralUtil.logger
					.info("Entered Sub Risk Weight Class value as 0.007 for SACVARiskWeightsParameter "
							+ strSACVARiskWeights);

			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("clicked on Save button");
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Step: Click On Ok Button On Confirmation Window", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			GeneralUtil.logger
					.info("clicked OK button on confirmation window.");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Capital Parameters");
			
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			Reporter.log("Test Step: Send Value Of SACVARiskWeights To Search Element", 1, true);
			SearchElement.sendKeys(strSACVARiskWeights);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Get SACVARiskWeights Value For Filtered SACVARiskWeights", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/div/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strSACVARiskWeights)) {
				GeneralUtil.logger.info("added SACVARiskWeights Parameter:"
						+ strSACVARiskWeights + " Successfully.");
			} else {
				GeneralUtil.logger
						.error("Unable to add SACVARiskWeights Parameter:"
								+ strSACVARiskWeights);
			}
			Reporter.log("Test Case: Successfully CapitalParameter- Added SACVARiskWeights", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = { "static_addCapitalSACVARiskWeightsParameter" })
	public void static_editCapitalSACVARiskWeightsParameter() throws Exception {
		try {
			GeneralUtil
					.logger("CapitalParameter- Edit SACVARiskWeights");
			Reporter.log("Test Case: CapitalParameter- Edit SACVARiskWeights", 1, true);
			GeneralUtil.logger.info("Stated");
			clearAllFilters();

			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			
			Reporter.log("Test Step: Send Value Of SACVARiskWeights To Search Element", 1, true);
			
			SearchElement.sendKeys(strSACVARiskWeights);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// intColNumber =
			// CommonTest.getColumnNumber("Sub Risk Weight Class");
			
			Reporter.log("Test Step: Enter Sub Risk Weight Class Value As 0.078 For SACVARiskWeightsParameter "+ strSACVARiskWeights, 1, true);
			gridSendKeysJS(
					".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]/div/div",
					"0.078");
			GeneralUtil.logger
					.info("Entered Sub Risk Weight Class value as 0.078 for SACVARiskWeightsParameter "
							+ strSACVARiskWeights);

			GeneralUtil.captureScreenshot();
			
			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("clicked on Save button");
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Click On Ok Button", 1, true);
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();

			GeneralUtil.logger
					.info("clicked OK button on confirmation window.");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Capital Parameters");

			WebElement SearchElement1 = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement1.clear();
			Reporter.log("Test Step: Send Value Of SACVARiskWeights To Search Element", 1, true);
			SearchElement1.sendKeys(strSACVARiskWeights);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Get SACVARiskWeights Value For Filtered Row", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/div/div/span"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(strSACVARiskWeights)) {
				GeneralUtil.logger.info("Edited SACVA Risk Weights Parameter:"
						+ strSACVARiskWeights + " Successfully.");
			} else {
				GeneralUtil.logger
						.error("Unable to Edit SACVA Risk Weights Parameter:"
								+ strSACVARiskWeights);
			}
			Reporter.log("Test Case: Successfully CapitalParameter- Edited SACVARiskWeights", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = { "static_editCapitalSACVARiskWeightsParameter" })
	public void static_exportCapitalSACVARiskWeightsParameter() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export Capital -SACVARiskWeightsParameter");
		Reporter.log("Test Case: Export Capital -SACVARiskWeightsParameter", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver.findElement(By
				.xpath("//*[@ref='center']/div/div[4]/div[3]//div/div[2]/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Capital SACVA Risk Weights Parameter Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver.findElement(By
				.xpath("//*[@ref='center']/div/div[4]/div[3]//div/div[2]/div"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Capital SACVA Risk Weights Parameter Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported Capital -SACVARiskWeightsParameter", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "static_exportCapitalSACVARiskWeightsParameter" })
	public void static_deleteCapitalSACVARiskWeightsParameter() throws Exception {
		try {
			GeneralUtil
					.logger("Delete CapitalParameter- SACVARiskWeights");
			Reporter.log("Test Case: Delete CapitalParameter- SACVARiskWeights", 1, true);
			GeneralUtil.logger.info("Stated");
			
			// Right click on element and select context Menue item
			Reporter.log("Test Step: Right Click On Element And Select Delete From Context Menu", 1, true);
			WebElement contextMenuelement = GeneralUtil.getElement(
					"//*[@ref='center']/div/div[4]/div[3]//div/div[2]/div",
					"xpath", dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Delete");
			GeneralUtil.captureScreenshot();

			// Click on save button
			Reporter.log("Test Step: Click On Save Button", 1, true);
			WebElement objSaveButton = GeneralUtil.getElement(
					"//div[text()='Save']", "xpath", dynamicTimeOut);
			objSaveButton.click();

			GeneralUtil.logger.info("clicked on Save button");
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Click On Ok Button On Delete Confirmation Window", 1, true);
			
			WebElement objOkButton2 = GeneralUtil.getElement(
					"//div/div/div/div/div/div[2]/div/div/div[1]/button",
					"xpath", dynamicTimeOut);
			objOkButton2.click();
			GeneralUtil.logger
					.info("Clicked OK buttion on delete Confirmation window.");
			
			// Verification for success notification
			Reporter.log("Test Step: Verification For Success Notification", 1, true);
			Common.handleNotifications("Save Capital Parameters");
			Reporter.log("Test Case: Successfully Deleted CapitalParameter- SACVARiskWeights", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = "static_deleteCapitalSACVARiskWeightsParameter", alwaysRun=true)
	public void static_exportCapitalSACCRGeneralParameter() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export Capital -SACCRGeneralParameter");
		Reporter.log("Test Case: Export Capital -SACCRGeneralParameter", 1, true);
		GeneralUtil.logger.info("Stated");
		
		Reporter.log("Test Step: Click On Capital Parameters", 1, true);
		String strReferenceDataXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Capital Parameters']";
		WebElement objReferenceData = GeneralUtil.getElement(
				strReferenceDataXpath, "xpath", dynamicTimeOut);
		objReferenceData.click();

		GeneralUtil.logger
				.info("Navigated to Capital Parameters by Select the Capital Parameters treeview item.");

		Thread.sleep(1000);
		
		Reporter.log("Test Step: Click On SACCR General Parameters", 1, true);
		WebElement objLabelTab = GeneralUtil.getElement(
				"//label[text()='SACCR General Parameters']", "xpath",
				dynamicTimeOut);
		objLabelTab.click();
		Thread.sleep(1000);
		GeneralUtil.logger
				.info("selected SACCR Generak Parameter tab and navigated to SACCR Generak Parameter screen.");
		
		Reporter.log("Test Step: Selected SACCR General Parameter Tab And Navigated To SACCR General Parameter Screen.", 1, true);
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuElement = driver.findElement(By
				.xpath("//*[@ref='center']/div/div[4]/div[3]//div/div[2]/div"));
		GeneralUtil.contextMenu(contextMenuElement);
		GeneralUtil.captureScreenshot();

		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Capital SACCR Generak Parameter Parameter Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver.findElement(By
				.xpath("//*[@ref='center']/div/div[4]/div[3]//div/div[2]/div"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();

		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Capital SACCR Generak Parameter Parameter Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported Capital -SACCRGeneralParameter", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "static_exportCapitalSACCRGeneralParameter", alwaysRun=true)
	public void static_editCapitalSACCRGeneralParameter() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Edit Capital -SACCRGeneralParameter");
		Reporter.log("Test Case: Edit Capital -SACCRGeneralParameter", 1, true);
		GeneralUtil.logger.info("Stated");
		
		Reporter.log("Test Step: Click On Capital Parameters", 1, true);
		String strReferenceDataXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Capital Parameters']";
		WebElement objReferenceData = GeneralUtil.getElement(
				strReferenceDataXpath, "xpath", dynamicTimeOut);
		objReferenceData.click();

		GeneralUtil.logger
				.info("Navigated to Capital Parameters by Select the Capital Parameters treeview item.");

		Thread.sleep(1000);
		
		Reporter.log("Test Step: Click On SACCR General Parameters", 1, true);
		WebElement objLabelTab = GeneralUtil.getElement(
				"//label[text()='SACCR General Parameters']", "xpath",
				dynamicTimeOut);
		objLabelTab.click();
		Thread.sleep(1000);
		GeneralUtil.logger
				.info("selected SACCR Generak Parameter tab and navigated to SACCR Generak Parameter screen.");
		
		Reporter.log("Test Step: Selected SACCR General Parameter Tab And Navigated To SACCR General Parameter Screen.", 1, true);
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		WebElement SearchElement = driver
				.findElement(By
						.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
		SearchElement.clear();
		
		Reporter.log("Test Step: Send Value Of strSACCRGeneral To Search Element", 1, true);
		
		SearchElement.sendKeys(strSACCRGeneral);
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();

		// intColNumber =
		// CommonTest.getColumnNumber("Sub Risk Weight Class");
		
		Reporter.log("Test Step: Enter Value As 0.078 For strSACCRGeneral "+ strSACCRGeneral, 1, true);
		gridSendKeysJS(
				".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]/div/div",
				"0.078");
		GeneralUtil.logger
				.info("Entered value as 0.078 for strSACCRGeneral "
						+ strSACCRGeneral);

		GeneralUtil.captureScreenshot();
		
		// Click on save button
		Reporter.log("Test Step: Click On Save Button", 1, true);
		WebElement objSaveButton = GeneralUtil.getElement(
				"//div[text()='Save']", "xpath", dynamicTimeOut);
		objSaveButton.click();

		GeneralUtil.logger.info("clicked on Save button");
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Click On Ok Button", 1, true);
		WebElement objOkButton2 = GeneralUtil.getElement(
				"//div/div/div/div/div/div[2]/div/div/div[1]/button",
				"xpath", dynamicTimeOut);
		objOkButton2.click();

		GeneralUtil.logger
				.info("clicked OK button on confirmation window.");
		
		// Verification for success notification
		Reporter.log("Test Step: Verification For Success Notification", 1, true);
		Common.handleNotifications("Save Capital Parameters");

		WebElement SearchElement1 = driver
				.findElement(By
						.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
		SearchElement1.clear();
		Reporter.log("Test Step: Send Value Of strSACCRGeneral To Search Element", 1, true);
		SearchElement1.sendKeys(strSACCRGeneral);
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Get strSACCRGeneral Value For Filtered Row", 1, true);
		String tradeIdtext = driver
				.findElement(
						By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/div/div/span"))
				.getText();

		if (tradeIdtext.equalsIgnoreCase(strSACCRGeneral)) {
			GeneralUtil.logger.info("Edited SACCR General Parameters Parameter:"
					+ strSACCRGeneral + " Successfully.");
		} else {
			GeneralUtil.logger
					.error("Unable to SACCR General Parameters Parameter:"
							+ strSACCRGeneral);
		}
		Reporter.log("Test Case: Successfully CapitalParameter- Edited strSACCRGeneral", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	public void verifyElementPresent(String strTrade, String strXpath,
			int timeOut) {
		try {
			boolean blnFind = GeneralUtil.waitUntilExists(strXpath, "xpath",
					timeOut);
			if (blnFind)
				GeneralUtil.logger.info(strTrade
						+ " treeview item is displayed.");
			else
				GeneralUtil.logger.error(strTrade
						+ " treeview item is not displayed with given xpath: "
						+ strXpath);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			GeneralUtil.logger
					.error("Element is not displayed.Detailes are Locator:"
							+ strXpath + " LocatorType:xpath WaitTime:"
							+ timeOut);
			Reporter.log(e.toString(), 1, true);
		}
	}

	public void clearAllFilters() throws Exception {
		
		// Right click on element and select context Menue item
		Reporter.log("Test Step: Right Click On Element And Select Context Menu Item", 1, true);
		WebElement contextMenuelement1 = GeneralUtil.getElement(
				"//*[@ref='center']/div/div[4]/div[3]/div", "xpath",
				dynamicTimeOut);
		GeneralUtil.contextMenu(contextMenuelement1);
		GeneralUtil.captureScreenshot();
		GeneralUtil.contextMenuItem(strmenu, "Clear All Filters");
		GeneralUtil.captureScreenshot();
		Thread.sleep(1000);
	}

	@AfterClass
	public void afterClass() throws Exception {
		Thread.sleep(3000);
		Common.loginOffXVA();
		Browser.quitBrowser();
		Thread.sleep(2000);
	}
	
	public void deleteReferenceData(String deleteReferenceData) throws Exception{
		// Clear the filter for Reference Data
					WebElement contextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Reference Data Filter Columns", 1, true);
						GeneralUtil.contextMenu(contextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(1000);
						
						Reporter.log("Test Step: Send ReferenceData Value To Search Element Name", 1, true);
						WebElement SearchElement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
						SearchElement.clear();
						SearchElement.sendKeys(deleteReferenceData);
						Thread.sleep(1000);	
						
					// Right click on element and select context Menue item
					Reporter.log("Test Step: Right Click On Element And Select Delete From Context Menu", 1, true);
					WebElement contextMenuelement = GeneralUtil
							.getElement(
									"//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div",
									"xpath", dynamicTimeOut);
					GeneralUtil.contextMenu(contextMenuelement);
					GeneralUtil.captureScreenshot();
					GeneralUtil.contextMenuItem(strmenu, "Delete");
					GeneralUtil.captureScreenshot();

					Reporter.log("Test Step: Click OK Button On Delete Confirmation Window", 1, true);
					WebElement objOkButton2 = GeneralUtil.getElement(
							"//div/div/div/div/div/div[2]/div/div/div[1]/button",
							"xpath", dynamicTimeOut);
					objOkButton2.click();
					GeneralUtil.logger
							.info("Clicked OK buttion on delete Confirmation window.");
					Reporter.log("Test Step: Clicked OK Button On Delete Confirmation Window", 1, true);
					
					Reporter.log("Test Step: Get Data From Delete Notification", 1, true);
					WebElement objNotificationsH4 = GeneralUtil.getElement(
							"//div[starts-with(@class,'notification')]/h4", "xpath",
							GeneralUtil.scriptTimeOut);
					String strnotificationsh4 = objNotificationsH4.getText();
					if (strnotificationsh4.contains("Delete Reference Data")) {

						GeneralUtil.logger.info("Displayed notifications is :"
								+ strnotificationsh4);
						GeneralUtil.captureScreenshot();
					} else
						GeneralUtil.logger.info("Delete Reference Data"
								+ " is not displayed in notification");
	}
}
