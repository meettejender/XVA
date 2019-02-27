package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.Browser;
import util.GeneralUtil;

public class Admin {

	public WebDriver driver;
	public int dynamicTimeOut;
	public String fileUploadPath = null;
	public String strNewCalender = null;
	public String serverSettingsName = null;
	public String userName = null;
	public String userRole = null;
	public String addDataTypeFilters = null;
	public String addRoles = null;
	public String addFilter = null;
	public String editDataTypeFilters = null;
	public String editRoles = null;
	public String editFilter = null;
	public String userPassword = null;
	public String addUserRole = null;
	public String editAuthorizationFunctions = null;
	public String nxtTemplateSettings = null;
	public String timeStamp = null;
	public String addAitionalFieldsName = null;
	public String addRetentionPoliciesName = null;
	public String editRetentionPoliciesName = null;
	public String cloneRetentionPoliciesName = null;

	@BeforeClass
	public void beforeClass() throws Exception {

		GeneralUtil.configureLog4j("Admin Authorizations");
		GeneralUtil.logger("Admin Authorizations");

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

		serverSettingsName = "AggregationThreadCount";
		userName = "User123";
		userRole = "Administrators";
		userPassword = "password";
		addUserRole = "role123";
		editAuthorizationFunctions = "addRoles";
		nxtTemplateSettings = "CALENDAR.AMSTERDAM";
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
				.format(new Date());
		;
		addAitionalFieldsName = "AdditionalFields_" + timeStamp;
		addRetentionPoliciesName = "RetentionPolicies_" + timeStamp;
		editRetentionPoliciesName = "RetentionPoliciesEdit_" + timeStamp;
		cloneRetentionPoliciesName = "RetentionPoliciesClone_" + timeStamp;
		
		addDataTypeFilters = "Fixings";
		addRoles = "system";
		addFilter = "id=2";
		editDataTypeFilters = "MarketEnvironment";
		editRoles = "readonly";
		editFilter = "id=3";
	}

	@Test(alwaysRun = true)
	public void admin_verifyAdminTabs() throws Exception {
		try {
			GeneralUtil.logger.info("Verify Admin Items");
			Reporter.log("Test Case: Verify Admin Items", 1, true);

			// Validating Admin Tab is expand or not and verify Admin sub tabs
			if (driver
					.findElement(
							By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Server Monitor']"))
					.isDisplayed()) {

				Reporter.log("Test Step: Verify Admin Items: Server Monitor", 1, true);
				String strServerMonitorXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Server Monitor']";
				VerifyElementPresent("Server Monitor", strServerMonitorXpath,
						dynamicTimeOut);

				Reporter.log("Test Step: Verify Admin Items: Authorizations", 1, true);
				String strAuthorizationsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']";
				VerifyElementPresent("Authorizations", strAuthorizationsXpath,
						dynamicTimeOut);

				Reporter.log("Test Step: Verify Admin Items: Template Settings", 1,
						true);
				String strTemplateSettingsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Template Settings']";
				VerifyElementPresent("Template Settings",
						strTemplateSettingsXpath, dynamicTimeOut);

				Reporter.log("Test Step: Verify Admin Items: Additional Fields", 1,
						true);
				String strAdditionalFieldsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[4]/div/div/div[text() ='Additional Fields']";
				VerifyElementPresent("Additional Fields",
						strAdditionalFieldsXpath, dynamicTimeOut);

				Reporter.log("Test Step: Verify Admin Items: Retention Policies", 1,
						true);
				String strRetentionPoliciesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[5]/div/div/div[text() ='Retention Policies']";
				VerifyElementPresent("Retention Policies",
						strRetentionPoliciesXpath, dynamicTimeOut);
			}
			// Expand Admin Tab and verify Admin sub tabs
			else {
				Reporter.log("Test Step: Click Admin Tab", 1, true);
				WebElement adminElememt = driver
						.findElement(By
								.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div/Strong[text()='Admin']"));
				// Create instance of Javascript executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				// Identify the WebElement which will appear after scrolling
				// down
				// WebElement element = driver.findElement(By.tagName("...."));
				// now execute query which actually will scroll until that
				// element is not appeared on page.
				je.executeScript("arguments[0].scrollIntoView(true);",
						adminElememt);
				je.executeScript("arguments[0].click();", adminElememt);
				Thread.sleep(1000);
				adminElememt.click();
				Thread.sleep(1000);

				Reporter.log("Test Step: Verify Admin Items: Server Monitor", 1, true);
				String strServerMonitorXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Server Monitor']";
				VerifyElementPresent("Server Monitor", strServerMonitorXpath,
						dynamicTimeOut);

				Reporter.log("Test Step: Verify Admin Items: Authorizations", 1, true);
				String strAuthorizationsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']";
				VerifyElementPresent("Authorizations", strAuthorizationsXpath,
						dynamicTimeOut);

				Reporter.log("Test Step: Verify Admin Items: Template Settings", 1,
						true);
				String strTemplateSettingsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Template Settings']";
				VerifyElementPresent("Template Settings",
						strTemplateSettingsXpath, dynamicTimeOut);

				Reporter.log("Test Step: Verify Admin Items: Additional Fields", 1,
						true);
				String strAdditionalFieldsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[4]/div/div/div[text() ='Additional Fields']";
				VerifyElementPresent("Additional Fields",
						strAdditionalFieldsXpath, dynamicTimeOut);

				Reporter.log("Test Step: Verify Admin Items: Retention Policies", 1,
						true);
				String strRetentionPoliciesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[5]/div/div/div[text() ='Retention Policies']";
				VerifyElementPresent("Retention Policies",
						strRetentionPoliciesXpath, dynamicTimeOut);
			}
			Reporter.log("Test Case: Successfully Verified Admin Items", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);

		}

	}

	@Test(dependsOnMethods = "admin_verifyAdminTabs", alwaysRun = true)
	public void admin_verifyserverMonitorServerSettings() throws Exception {
		try {
			GeneralUtil.logger("Verify Sub Nodes For Server Monitor in Admin");
			Reporter.log("Test Case: Verify Sub Nodes For Server Monitor in Admin", 1, true);
			GeneralUtil.logger.info("Started Verify Sub Nodes For Server Monitor in Admin");
			
					
			WebElement serverMonitorServerSettingsElements = driver
					.findElement(By
							.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Server Monitor']"));

			// Create instance of Javascript executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			// Identify the WebElement which will appear after scrolling
			// down
			// WebElement element = driver.findElement(By.tagName("...."));
			// now execute query which actually will scroll until that
			// element is not appeared on page.
			je.executeScript("arguments[0].scrollIntoView(true);",
					serverMonitorServerSettingsElements);
			je.executeScript("arguments[0].click();", serverMonitorServerSettingsElements);
			Thread.sleep(2000);
			
			// Validating Server Monitor tabs(Server Settings,Audit Log,Server
			// Process Monitor & Server Logs
			Reporter.log("Test Step: Verify Admin Server Monitor Items: Server Settings", 1,
					true);
			String strServerSettingsXpath = "//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Server Settings']";
			VerifyElementPresent("Server Settings", strServerSettingsXpath,
					dynamicTimeOut);

			Reporter.log("Test Step: Verify Admin Server Monitor Items: Audit Log", 1,
					true);
			String strAuditLogXpath = "//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Audit Log']";
			VerifyElementPresent("Audit Log", strAuditLogXpath, dynamicTimeOut);

			Reporter.log(
					"Verify Admin Server Monitor Items: Server Process Monitor",
					1, true);
			String strServerProcessMonitorXpath = "//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Server Process Monitor']";
			VerifyElementPresent("Server Process Monitor",
					strServerProcessMonitorXpath, dynamicTimeOut);

			Reporter.log("Test Step: Verify Admin Server Monitor Items: Server Logs",
					1, true);
			String strServerLogsXpath = "//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Server Logs']";
			VerifyElementPresent("Server Logs", strServerLogsXpath,
					dynamicTimeOut);
			
			Reporter.log("Test Case: Successfully Verified Sub Nodes For Server Monitor in Admin", 1, true);
			
		} catch (Exception e) {

			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "admin_verifyserverMonitorServerSettings", alwaysRun = true)
	public void admin_exportServerMonitorServerSettings() throws Exception {
		try {
			GeneralUtil.logger("Export Server Monitor In Server Settings");
			Reporter.log("Test Case: Export Server Monitor In Server Settings", 1, true);
			GeneralUtil.logger.info("Started Export Server Monitor In Server Settings");
			
			// Perform Server Settings action(export CSV or Excel)file
			Reporter.log("Test Step: Search +serverSettingsName+ Admin Server Monitor",
					1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(serverSettingsName);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			Reporter.log(
					"Click Export & CSV Export On Admin Server Monitor From Context Menu",
					1, true);
			WebElement contextMenuelement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/div/div"));
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			Common.download(
					"Export",
					"CSV Export",
					"export(.*).csv",
					".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			GeneralUtil.captureScreenshot();
			
			Reporter.log(
					"Click Export & Excel Export On Admin Server Monitor From Context Menu",
					1, true);
			
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			Common.download(
					"Export",
					"Excel Export",
					"export(.*).xls",
					".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Case: Successfully Exported Server Monitor In Server Settings", 1, true);
			
		} catch (Exception e) {

			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "admin_exportServerMonitorServerSettings", alwaysRun = true)
	public void admin_exportAndVerifyServerMonitorAuditLog() throws Exception {
		try {
			
			GeneralUtil.logger("Export And Verify Server Monitor In Audit Log");
			Reporter.log("Test Case: Export And Verify Server Monitor In Audit Log", 1, true);
			GeneralUtil.logger.info("Started Export And Verify Server Monitor In Audit Log");
			
			// Perform Audit Log action(open log file)
			Reporter.log("Test Step: Click Audit Log On Admin Server Monitor", 1, true);
			driver.findElement(
					By.xpath("//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Audit Log']"))
					.click();
			GeneralUtil.logger
					.info("Audit Log implementation is pending due to TT-46398");

			// Perform Server Process Monitor action(export CSV or Excel)file
			Reporter.log(
					"Click Server Process Monitor On Admin Server Monitor",
					1, true);
			driver.findElement(
					By.xpath("//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Server Process Monitor']"))
					.click();
			Thread.sleep(1000);

			Reporter.log(
					"Click Export & CSV Export On Admin Server Monitor For Server Process Monitor From Context Menu",
					1, true);
			WebElement contextMenuSecondelement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/div/div"));
			GeneralUtil.contextMenu(contextMenuSecondelement);
			GeneralUtil.captureScreenshot();
			Common.download(
					"Export",
					"CSV Export",
					"export(.*).csv",
					".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			GeneralUtil.captureScreenshot();
			
			Thread.sleep(1000);

			Reporter.log(
					"Click Export & Excel Export On Admin Server Monitor For Server Process Monitor From Context Menu",
					1, true);
			GeneralUtil.contextMenu(contextMenuSecondelement);
			GeneralUtil.captureScreenshot();
			Common.download(
					"Export",
					"Excel Export",
					"export(.*).xls",
					".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Case: Successfully Exported And Verify Server Monitor In Audit Log", 1, true);
			
		} catch (Exception e) {

			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "admin_exportAndVerifyServerMonitorAuditLog", alwaysRun = true)
	public void admin_exportAndVerifyServerMonitorServerLogs() throws Exception {
		try {
			
			GeneralUtil.logger("Export And Verify Server Monitor In Server Logs");
			Reporter.log("Test Case: Export And Verify Server Monitor In Server Logs", 1, true);
			GeneralUtil.logger.info("Started Export And Verify Server Monitor In Server Logs");
			
			// Perform Server Logs action(log screen open)
			Reporter.log("Test Step: Click Server Logs On Admin Server Monitor", 1, true);
			driver.findElement(
					By.xpath("//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Server Logs']"))
					.click();
			
			Reporter.log("Test Step: Verify Server Logs On Admin Server Monitor", 1, true);
			WebElement serverLogsElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/div/div/span"));
			String serverLogsText = serverLogsElement.getText();

			String today = getToday("E MMM dd yyyy");
			if (serverLogsText.contains(today)) {
				GeneralUtil.logger.info("Server Log " + serverLogsText
						+ " is available in the Server Log page");
			} else {
				GeneralUtil.logger.error("Server Log " + serverLogsText
						+ " is not available in the Server Log page");
			}
		
			Thread.sleep(1000);

			Reporter.log(
					"Click Export & CSV Export On Admin Server Monitor For Server Logs From Context Menu",
					1, true);
			WebElement contextMenuSecondelement = driver
					.findElement(By
							.xpath(".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div"));
			GeneralUtil.contextMenu(contextMenuSecondelement);
			GeneralUtil.captureScreenshot();
			Common.download(
					"Export",
					"CSV Export",
					"export(.*).csv",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[5]/div/div/span[2]");
			GeneralUtil.captureScreenshot();
			
			Thread.sleep(1000);

			Reporter.log(
					"Click Export & Excel Export On Admin Server Monitor For Server Logs From Context Menu",
					1, true);
			GeneralUtil.contextMenu(contextMenuSecondelement);
			GeneralUtil.captureScreenshot();
			Common.download(
					"Export",
					"Excel Export",
					"export(.*).xls",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[5]/div/div/span[2]");
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Case: Successfully Export And Verify Server Monitor In Server Logs", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = "admin_exportAndVerifyServerMonitorServerLogs", alwaysRun = true)
	public void admin_verifyAuthorizationsTabs() throws Exception {
		try {
			GeneralUtil.logger.info("Verify Authorizations Tabs");
			Reporter.log("Test Case: Verify Admin Authorizations Items",1, true);
			
			Reporter.log("Test Step: Click Admin Authorizations",1, true);
			WebElement authorizationsElements = driver
					.findElement(By
							.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']"));

			// Create instance of Javascript executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			// Identify the WebElement which will appear after scrolling
			// down
			// WebElement element = driver.findElement(By.tagName("...."));
			// now execute query which actually will scroll until that
			// element is not appeared on page.
			je.executeScript("arguments[0].scrollIntoView(true);",
					authorizationsElements);
			je.executeScript("arguments[0].click();", authorizationsElements);
			Thread.sleep(2000);

			// Validating Authorizations tabs(Users,Roles & Authorization
			// Functions
			Reporter.log("Test Step: Verify Admin Authorizations Items: Users", 1, true);
			String strUsersXpath = "//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Users']";
			VerifyElementPresent("Users", strUsersXpath, dynamicTimeOut);
			Thread.sleep(2000);
			
			Reporter.log("Test Step: Verify Admin Authorizations Items: Roles", 1, true);
			String strRolesXpath = "//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Roles']";
			VerifyElementPresent("Roles", strRolesXpath, dynamicTimeOut);
			
			Reporter.log("Test Step: Verify Admin Authorizations Items: Authorization Functions", 1, true);
			String strAuthorizationFunctionsXpath = "//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Authorization Functions']";
			VerifyElementPresent("Authorization Functions",
					strAuthorizationFunctionsXpath, dynamicTimeOut);
			
			Reporter.log("Test Step: Successfully Verified Admin Authorizations Items", 1, true);
			
			
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);

		}
		GeneralUtil.logger.info("Verified Admin Authorizations Items successfully");
	}
	
	@Test(dependsOnMethods = "admin_verifyAuthorizationsTabs", alwaysRun = true)
	public void admin_addAuthorizationsTabs() throws Exception {
		try {
			GeneralUtil.logger.info("Add Admin Authorizations Users");
			Reporter.log("Test Step: Add Admin Authorizations Users",1, true);
			
			Reporter.log("Test Step: Click Admin Authorizations",1, true);
			WebElement authorizationsElements = driver
					.findElement(By
							.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']"));

			// Create instance of Javascript executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			// Identify the WebElement which will appear after scrolling
			// down
			// WebElement element = driver.findElement(By.tagName("...."));
			// now execute query which actually will scroll until that
			// element is not appeared on page.
			je.executeScript("arguments[0].scrollIntoView(true);",
					authorizationsElements);
			je.executeScript("arguments[0].click();", authorizationsElements);
			Thread.sleep(2000);

					
			
			// Add user in Authorizations tabs
			Reporter.log("Test Step: Click Add On Admin Authorizations Users From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Add");
			
			Reporter.log("Test Step: Enter Text On User Name Field For Admin Authorizations Users", 1, true);
			WebElement userNameElement = driver
					.findElement(By
							.xpath("html/body/div[4]/div/div/div/div/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div/input"));
			userNameElement.clear();
			userNameElement.sendKeys(userName);
			
			Reporter.log("Test Step: Select Roles Field For Admin Authorizations Users", 1, true);
			driver.findElement(
					By.xpath("html/body/div[4]/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div/div/div/div/span[2]"))
					.click();
			GeneralUtil.selectDropDownItem(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					userRole, "Roles");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Enter Text On Password Field For Admin Authorizations Users", 1, true);
			WebElement userPasswordElement = driver
					.findElement(By
							.xpath("//div[@class='react-draggable']/div/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div/input"));
			userPasswordElement.clear();
			userPasswordElement.sendKeys(userPassword);
			
			
			Reporter.log("Test Step: Click OK Button For Admin Authorizations Users", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();

			// Validating user added or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Update User");
			
			Reporter.log("Test Step: Search Added Admin Authorizations Users", 1, true);
			driver.findElement(
					By.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"))
					.sendKeys(userName);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Verify Admin Authorizations Users Is Added", 1, true);
			String authorizationUsername = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			if (authorizationUsername.contains(userName)) {
				GeneralUtil.logger.info("Authorization user name "
						+ authorizationUsername
						+ " is available in the Authorization user page");
			} else {
				GeneralUtil.logger.error("Authorization user name "
						+ authorizationUsername
						+ " is not available in the Authorization user page");
			}
			Reporter.log("Test Case: Successfully Added Admin Authorizations Users", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);

		}
		GeneralUtil.logger.info("Authorization user created successfully");
	}
	
	@Test(dependsOnMethods = { "admin_addAuthorizationsTabs" })
	public void admin_editUserAuthorizations() throws Exception {
		try {
			GeneralUtil.logger.info("Edit a User Authorizations");
			Reporter.log("Test Case: Edit Admin Authorizations Users",1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']"))
					.click();
			
			// Search user in search text field
			Reporter.log("Test Step: Search Added Admin Authorizations Users", 1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(userName);

			// Update user in Authorizations tabs
			Reporter.log("Test Step: Click Added Admin Authorizations Users", 1, true);
			driver.findElement(
					By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.click();
			
			
			Reporter.log("Test Step: Click Roles For Admin Authorizations Users In Sub Window", 1, true);
			driver.findElement(
					By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.click();
			
			Reporter.log("Test Step: Clear Roles For Admin Authorizations Users In Sub Window", 1, true);
			driver.findElement(By.xpath("//span[@class='Select-clear-zone']"))
					.click();
			
			Reporter.log("Test Step: Select System Role On Admin Authorizations Users In Sub Window Dropdown", 1, true);
			driver.findElement(
					By.xpath("//div[@class='Select-control']/span/div[1]"))
					.click();
			GeneralUtil.selectDropDownItem(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"system", "Roles");
			
			Reporter.log("Test Step: Click Save Button For Admin Authorizations Users In Sub Window", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click OK Button For Admin Authorizations Users In Sub Window", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();

			// Validating user updated or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Update User");
			
			Reporter.log("Test Step: Search Edited Admin Authorizations Users", 1, true);
			WebElement searchSecondElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchSecondElement.clear();
			searchSecondElement.sendKeys(userName);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Verify Admin Authorizations Users Is Edited", 1, true);
			String authorizationUsername = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			if (authorizationUsername.contains(userName)) {
				GeneralUtil.logger.info("Authorization edited user name "
						+ authorizationUsername
						+ " is available in the Authorization user page");
			} else {
				GeneralUtil.logger.error("Authorization edited user name "
						+ authorizationUsername
						+ " is not available in the Authorization user page");
			}
			Reporter.log("Test Case: Successfully Edited Admin Authorizations Users", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Authorization user edited successfully");
	}

	@Test(dependsOnMethods = { "admin_editUserAuthorizations" })
	public void admin_exportUserAuthorizations() throws Exception {
		try {
			GeneralUtil.logger.info("Export a User Authorizations");
			Reporter.log("Test Case: Export Admin Authorizations Users",1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']"))
					.click();
			
			// Search user in search text field
			Reporter.log("Test Step: Search Added Admin Authorizations Users", 1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(userName);

			// Export user in Authorizations tabs
			Reporter.log("Test Step: Click Export & CSV Export On Admin Authorizations Users From Context Menu",1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			Common.download(
					"Export",
					"CSV Export",
					"export(.*).csv",
					".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			
			Thread.sleep(2000);
			// Export user in Authorizations tabs
			WebElement contextMenuExcelElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			Reporter.log("Test Step: Click Export & Excel Export On Admin Authorizations Users From Context Menu",1, true);
			GeneralUtil.contextMenu(contextMenuExcelElement);
			GeneralUtil.captureScreenshot();
			Common.download(
					"Export",
					"Excel Export",
					"export(.*).xls",
					".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Authorization user exported successfully");
		Reporter.log("Test Case: Successfully Exported Admin Authorizations Users", 1, true);
	}

	@Test(dependsOnMethods = { "admin_exportUserAuthorizations" })
	public void admin_deleteUserAuthorizations() throws Exception {
		try {
			GeneralUtil.logger.info("delete a User Authorizations");
			Reporter.log("Test Case: Delete Admin Authorizations Users",1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']"))
					.click();
			
			// Search user in search text field
			Reporter.log("Test Step: Search Added Admin Authorizations Users", 1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(userName);

			// Perform Delete user
			Reporter.log("Test Step: Click Delete On Admin Authorizations Users From Context Menu",1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Delete");
			
			Reporter.log("Test Step: Click OK Button For Admin Authorizations Users Popup", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Delete User");

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Authorization user deleted successfully");
		Reporter.log("Test Case: Successfully Deleted Admin Authorizations Users", 1, true);
	}

	@Test(dependsOnMethods = "admin_deleteUserAuthorizations", alwaysRun = true)
	public void admin_addRole() throws Exception {
		try {
			GeneralUtil.logger.info("Add Role Authorizations");
			Reporter.log("Test Case: Add Admin Authorizations Roles",1, true);
			
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']"))
					.click();
			
			Reporter.log("Test Step: Click Roles Button Admin Authorizations Roles",1, true);
			driver.findElement(
					By.xpath("//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Roles']"))
					.click();
			
			Reporter.log("Test Step: Search +userRole+ Admin Authorizations Roles",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(userRole);
			Thread.sleep(2000);
			
			// Add Role in Authorizations tab
			Reporter.log("Test Step: Click Add On Admin Authorizations Roles From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Add");
			
			Reporter.log("Test Step: Enter Text On Role Field For Admin Authorizations Roles", 1, true);
			WebElement roleElement = driver
					.findElement(By
							.xpath("html/body/div[4]/div/div/div/div/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div/input"));
			roleElement.clear();
			roleElement.sendKeys(addUserRole);
			
			Reporter.log("Test Step: Check Check Box On Administrator Field For Admin Authorizations Roles", 1, true);
			WebElement chkAdministratorElement = driver.findElement(By
					.xpath(".//*[@id='checkbox']/div/label"));
			chkAdministratorElement.click();
			
			Reporter.log("Test Step: Click OK Button For Admin Authorizations Roles", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();

			// Validating Role is added or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Update Role");
			
			Reporter.log("Test Step: Search Added Admin Authorizations Roles", 1, true);
			WebElement searchSecondElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchSecondElement.clear();
			searchElement.sendKeys(addUserRole);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Verify Admin Authorizations Roles Is Added", 1, true);
			String authorizationRolename = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			if (authorizationRolename.contains(addUserRole)) {
				GeneralUtil.logger.info("Authorization role name "
						+ authorizationRolename
						+ " is available in the Authorization role page");
			} else {
				GeneralUtil.logger.error("Authorization role name "
						+ authorizationRolename
						+ " is not available in the Authorization role page");
			}

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Authorization Role created successfully");
		Reporter.log("Test Case: Successfully Added Admin Authorizations Roles", 1, true);
	}

	@Test(dependsOnMethods = { "admin_addRole" })
	public void admin_editRole() throws Exception {
		try {
			GeneralUtil.logger.info("Edit Role Authorizations");
			Reporter.log("Test Case: Edit Admin Authorizations Roles",1, true);
			
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']"))
					.click();
			
			Reporter.log("Test Step: Click Roles Button On Admin Authorizations Roles",1, true);
			driver.findElement(
					By.xpath("//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Roles']"))
					.click();
			
			
			// Search the added role
			Reporter.log("Test Step: Search Added Role On Admin Authorizations Roles",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(addUserRole);

			// Update the role
			Reporter.log("Test Step: Click Added Role On Admin Authorizations Roles",1, true);
			driver.findElement(
					By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.click();
			driver.findElement(
					By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.click();
			
			Reporter.log("Test Step: Check Check Box On Administrator Field On Admin Authorizations Roles In Sub Window",1, true);
			WebElement chkAdministratorElement = driver.findElement(By
					.xpath("//*[@id='checkbox']/div/label"));
			chkAdministratorElement.click();
			
			Reporter.log("Test Step: Click Save Button For Admin Authorizations Roles In Sub Window", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click OK Button For Admin Authorizations Roles In Sub Window", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();

			// validating role updated or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Update Role");
			
			Reporter.log("Test Step: Search Edited Admin Authorizations Roles", 1, true);
			WebElement searchSecondElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchSecondElement.clear();
			searchElement.sendKeys(addUserRole);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Verify Admin Authorizations Roles Is Edited", 1, true);
			String authorizationRolename = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			if (authorizationRolename.contains(addUserRole)) {
				GeneralUtil.logger.info("Authorization role name "
						+ authorizationRolename
						+ " is available in the Authorization role page");
			} else {
				GeneralUtil.logger.error("Authorization role name "
						+ authorizationRolename
						+ " is not available in the Authorization role page");
			}

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Authorization Role edited successfully");
		Reporter.log("Test Case: Successfully Edited Admin Authorizations Roles", 1, true);
	}

	@Test(dependsOnMethods = { "admin_editRole" })
	public void admin_exportRole() throws Exception {
		try {
			GeneralUtil.logger.info("Export Role Authorizations");
			Reporter.log("Test Case: Export Admin Authorizations Roles",1, true);
			
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']"))
					.click();
			
			Reporter.log("Test Step: Click Roles Button On Admin Authorizations Roles",1, true);
			driver.findElement(
					By.xpath("//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Roles']"))
					.click();
			
			// search the added role
			Reporter.log("Test Step: Search Added Role On Admin Authorizations Roles",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(addUserRole);

			// Export the role
			Reporter.log("Test Step: Click Export & CSV Export On Admin Authorizations Roles From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			Common.download(
					"Export",
					"CSV Export",
					"export(.*).csv",
					".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			
			Thread.sleep(2000);
			// Export the role
			WebElement contextMenuExcelElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
						Reporter.log("Test Step: Click Export & Excel Export On Admin Authorizations Roles From Context Menu", 1, true);
						GeneralUtil.contextMenu(contextMenuExcelElement);
						GeneralUtil.captureScreenshot();
						Common.download(
								"Export",
								"Excel Export",
								"export(.*).xls",
								".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
								".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Authorization Role exported successfully");
		Reporter.log("Test Case: Successfully Exported Admin Authorizations Roles", 1, true);
	}

	@Test(dependsOnMethods = { "admin_exportRole" })
	public void admin_deleteRole() throws Exception {
		try {
			GeneralUtil.logger.info("Delete Role Authorizations");
			Reporter.log("Test Case: Delete Admin Authorizations Roles",1, true);
			
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']"))
					.click();
			
			Reporter.log("Test Step: Click Roles Button On Admin Authorizations Roles",1, true);
			driver.findElement(
					By.xpath("//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Roles']"))
					.click();
			
			// search the updated the role
			Reporter.log("Test Step: Search Added Role On Admin Authorizations Roles",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(addUserRole);

			// Delete the role
			Reporter.log("Test Step: Click Delete On Admin Authorizations Roles From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Delete");
			
			Reporter.log("Test Step: Click OK Button For Admin Authorizations Roles", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Delete Role");

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Authorization Role deleted successfully");
		Reporter.log("Test Case: Successfully Deleted Admin Authorizations Roles", 1, true);
	}

	@Test(dependsOnMethods = "admin_deleteRole", alwaysRun = true)
	public void admin_editAuthorizationFunctions() throws Exception {
		try {
			GeneralUtil.logger.info("Edit Authorization Functions");
			Reporter.log("Test Case: Edit Admin Authorizations Functions",1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']"))
					.click();
			
			Reporter.log("Test Step: Click Authorization Functions Button On Admin Authorizations Functions",1, true);
			driver.findElement(
					By.xpath("//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Authorization Functions']"))
					.click();
			
			Reporter.log("Test Step: Search +editAuthorizationFunctions+ Admin Authorizations Functions",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(editAuthorizationFunctions);
			Thread.sleep(2000);
			
			// update the Authorization Functions
			Reporter.log("Test Step: Click Authorization Functions On Admin Authorizations Functions",1, true);
			driver.findElement(
					By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.click();
			driver.findElement(
					By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.click();
			
			Reporter.log("Test Step: Check Check Box On Allow All Field For Admin Authorizations Functions In Sub Window", 1, true);
			WebElement chkAdministratorElement = driver.findElement(By
					.xpath(".//*[@id='checkbox']/div/label"));
			chkAdministratorElement.click();
			
			Reporter.log("Test Step: Click Save Button For Admin Authorizations Functions In Sub Window", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click OK Button For Admin Authorizations Functions In Sub Window", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();

			// Validating Authorization Functions update or not
			// Common.handleNotifications("Update Auth Function");
			Reporter.log("Test Step: Search Edited Admin Authorizations Functions", 1, true);
			WebElement searchSecondElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchSecondElement.clear();
			searchElement.sendKeys(editAuthorizationFunctions);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Verify Admin Authorizations Functions Is Edited", 1, true);
			String authorizationFunctionsname = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/span/span[2]"))
					.getText();
			if (authorizationFunctionsname.contains(addUserRole)) {
				GeneralUtil.logger.info("Authorization role name "
						+ authorizationFunctionsname
						+ " is available in the Authorization role page");
			} else {
				GeneralUtil.logger.error("Authorization role name "
						+ authorizationFunctionsname
						+ " is not available in the Authorization role page");
			}

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Authorization Functions edited successfully");
		Reporter.log("Test Case: Successfully Edited Admin Authorizations Functions", 1, true);
	}

	@Test(dependsOnMethods = { "admin_editAuthorizationFunctions" })
	public void admin_exportAuthorizationFunctions() throws Exception {
		try {
			GeneralUtil.logger.info("Export Authorization Functions");
			Reporter.log("Test Case: Export Admin Authorizations Functions",1, true);
			
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']"))
					.click();
			
			Reporter.log("Test Step: Click Authorization Functions Button On Admin Authorizations Functions",1, true);
			driver.findElement(
					By.xpath("//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Authorization Functions']"))
					.click();
			
			// Search the Authorization Functions
			Reporter.log("Test Step: Search Edited Admin Authorizations Functions",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(editAuthorizationFunctions);
			Thread.sleep(1000);
			
			// Export Authorization Functions
			Reporter.log("Test Step: Click Export & CSV Export On Admin Authorizations Functions From Context Menu",1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			Common.download(
					"Export",
					"CSV Export",
					"export(.*).csv",
					".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			
			Thread.sleep(1000);
			
			// Export Authorization Functions
			Reporter.log("Test Step: Click Export & Excel Export On Admin Authorizations Functions From Context Menu",1, true);
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			Common.download(
					"Export",
					"Excel Export",
					"export(.*).xls",
					".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger
				.info("Authorization Functions exported successfully");
		Reporter.log("Test Case: Successfully Exported Admin Authorizations Functions", 1, true);
	}
	
	@Test(dependsOnMethods = "admin_exportAuthorizationFunctions", alwaysRun = true)
	public void admin_addDataFilters() throws Exception {
		try {
			GeneralUtil.logger.info("Add Data Filters Authorizations");
			Reporter.log("Test Case: Add Admin Authorizations Data Filters",1, true);
			
			WebElement authorizationsElements = driver
					.findElement(By
							.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Authorizations']"));

			// Create instance of Javascript executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			// Identify the WebElement which will appear after scrolling
			// down
			// WebElement element = driver.findElement(By.tagName("...."));
			// now execute query which actually will scroll until that
			// element is not appeared on page.
			je.executeScript("arguments[0].scrollIntoView(true);",
					authorizationsElements);
			je.executeScript("arguments[0].click();", authorizationsElements);

			Thread.sleep(3000);
			Reporter.log("Test Step: Click Data Filters Button Admin Authorizations Data Filters",1, true);
			driver.findElement(
					By.xpath("//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div/ul/li/label[text()='Data Filters']"))
					.click();
			Thread.sleep(1000);
						
			// Add Role in Authorizations tab
			Reporter.log("Test Step: Click Add On Admin Authorizations Data Filters From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Add");
			
			Reporter.log("Test Step: Select Data Types Field For Admin Authorizations Data Filters", 1, true);
			driver.findElement(
					By.xpath(" //div[starts-with(@class,'Select Select--single is-searchable')]/div/span[2]"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					addDataTypeFilters, "Data Type");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Select Roles Field For Admin Authorizations Data Filters", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'Select Select--multi is-clearable is-searchable')]/div/span[2]"))
					.click();
			Thread.sleep(1000);
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					addRoles, "Roles");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Enter Text On Data Filters Field For Admin Authorizations Data Filters", 1, true);
			WebElement dataFilterElement = driver
					.findElement(By
							.xpath("//div[@class='react-draggable']//span[text()='Filter']/following::input[1]"));
			dataFilterElement.clear();
			dataFilterElement.sendKeys(addFilter);
			Thread.sleep(1000);		
			Reporter.log("Test Step: Click OK Button For Admin Authorizations Data Filters", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();

			// Validating Role is added or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("1 Data Filters added/updated.");
			
			Reporter.log("Test Step: Search Added Admin Authorizations Data Filters", 1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(addDataTypeFilters);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Verify Admin Authorizations Data Filters Is Added", 1, true);
			String authorizationDataFiltername = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			if (authorizationDataFiltername.contains(addDataTypeFilters)) {
				GeneralUtil.logger.info("Authorization Data Filters name "
						+ authorizationDataFiltername
						+ " is available in the Authorization Data Filters page");
			} else {
				GeneralUtil.logger.error("Authorization Data Filters name "
						+ authorizationDataFiltername
						+ " is not available in the Authorization Data Filters page");
			}

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Authorization Data Filters created successfully");
		Reporter.log("Test Case: Successfully Added Admin Authorizations Data Filters", 1, true);
	}

	@Test(dependsOnMethods = { "admin_addDataFilters" })
	public void admin_editDataFilters() throws Exception {
		try {
			GeneralUtil.logger.info("Edit Data Filters Authorizations");
			Reporter.log("Test Case: Edit Admin Authorizations Data Filters",1, true);
			
			Thread.sleep(1000);
			// Search the added role
			Reporter.log("Test Step: Search Added Data Filters On Admin Authorizations Data Filters",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(addDataTypeFilters);
			Thread.sleep(1000);
			// Update the Data Filter
			Reporter.log("Test Step: Click Added Data Filters On Admin Authorizations Data Filters",1, true);
			driver.findElement(
					By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Select Data Types Field For Admin Authorizations Data Filters", 1, true);
			driver.findElement(
					By.xpath(" //div[starts-with(@class,'Select Select--single is-searchable')]/div/span[2]"))
					.click();
			Thread.sleep(1000);
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					editDataTypeFilters, "Data Type");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Select Roles Field For Admin Authorizations Data Filters", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'Select Select--multi is-clearable is-searchable')]/div/span[3]"))
					.click();
			Thread.sleep(1000);
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					editRoles, "Roles");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Enter Text On Data Filters Field For Admin Authorizations Data Filters", 1, true);
			WebElement dataFilterElement = driver
					.findElement(By
							.xpath("//label/span[text()='Filter']/following::input[1]"));
			dataFilterElement.clear();
			dataFilterElement.sendKeys(editFilter);
			Thread.sleep(1000);
			Reporter.log("Test Step: Click Save Button For Admin Authorizations Data Filters In Sub Window", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click OK Button For Admin Authorizations Data Filters In Sub Window", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();

			// validating role updated or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("1 Data Filters added/updated.");
			
			Reporter.log("Test Step: Search Edited Admin Authorizations Data Filters", 1, true);
			WebElement searchSecondElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchSecondElement.clear();
			searchElement.sendKeys(editDataTypeFilters);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Verify Admin Authorizations Data Filters Is Edited", 1, true);
			String authorizationDataFiltername = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			if (authorizationDataFiltername.contains(editDataTypeFilters)) {
				GeneralUtil.logger.info("Authorization Data Filters name "
						+ authorizationDataFiltername
						+ " is available in the Authorization Data Filters page");
			} else {
				GeneralUtil.logger.error("Authorization Data Filters name "
						+ authorizationDataFiltername
						+ " is not available in the Authorization Data Filters page");
			}
			Reporter.log("Test Step: Click Cancel Button For Admin Authorizations Data Filters In Sub Window", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Cancel']")).click();

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Authorization Data Filters edited successfully");
		Reporter.log("Test Case: Successfully Edited Admin Authorizations Data Filters", 1, true);
	}

	@Test(dependsOnMethods = { "admin_editDataFilters" })
	public void admin_exportDataFilters() throws Exception {
		try {
			GeneralUtil.logger.info("Export Data Filters Authorizations");
			Reporter.log("Test Case: Export Admin Authorizations Data Filters",1, true);
			Thread.sleep(1000);
			
			// search the added role
			Reporter.log("Test Step: Search Added Role On Admin Authorizations Data Filters",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(addDataTypeFilters);
			Thread.sleep(1000);
			// Export the role
			Reporter.log("Test Step: Click Export & CSV Export On Admin Authorizations Data Filters From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			Common.download(
					"Export",
					"CSV Export",
					"export(.*).csv",
					".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			
			Thread.sleep(2000);
			// Export the role
			WebElement contextMenuExcelElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
						Reporter.log("Test Step: Click Export & Excel Export On Admin Authorizations Roles From Context Menu", 1, true);
						GeneralUtil.contextMenu(contextMenuExcelElement);
						GeneralUtil.captureScreenshot();
						Common.download(
								"Export",
								"Excel Export",
								"export(.*).xls",
								".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
								".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Authorization Data Filters exported successfully");
		Reporter.log("Test Case: Successfully Exported Admin Authorizations Data Filters", 1, true);
	}

	@Test(dependsOnMethods = { "admin_exportDataFilters" })
	public void admin_deleteDataFilters() throws Exception {
		try {
			GeneralUtil.logger.info("Delete Data Filters Authorizations");
			Reporter.log("Test Case: Delete Admin Authorizations Data Filters",1, true);
			Thread.sleep(1000);
			
			// search the updated the role
			Reporter.log("Test Step: Search Added Role On Admin Authorizations Data Filters",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(addDataTypeFilters);
			Thread.sleep(1000);
			// Delete the role
			Reporter.log("Test Step: Click Delete On Admin Authorizations Data Filters From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Delete");
			
			Reporter.log("Test Step: Click OK Button For Admin Authorizations Data Filters", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("1 Data Filters removed.");

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Authorization Data Filters deleted successfully");
		Reporter.log("Test Case: Successfully Deleted Admin Authorizations Data Filters", 1, true);
	}

	@Test(dependsOnMethods = "admin_deleteDataFilters", alwaysRun = true)
	public void admin_uploladTemplateSettings() throws Exception {
		try {
			GeneralUtil.logger.info("Upload Template Settings");
			Reporter.log("Test Case: Upload Admin Template Settings",1, true);
			
			Reporter.log("Test Step: Click Admin Template Settings",1, true);
			WebElement templateSettingsElements = driver
					.findElement(By
							.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Template Settings']"));

			// Create instance of Javascript executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			// Identify the WebElement which will appear after scrolling
			// down
			// WebElement element = driver.findElement(By.tagName("...."));
			// now execute query which actually will scroll until that
			// element is not appeared on page.
			je.executeScript("arguments[0].scrollIntoView(true);",
					templateSettingsElements);
			je.executeScript("arguments[0].click();", templateSettingsElements);

			Thread.sleep(10000);
			templateSettingUpload("AMSTERDAM.nxt","Template Upload","\\cas\\data\\Content\\Repository\\Calendar\\AMSTERDAM.nxt","CALENDAR.AMSTERDAM");
			Thread.sleep(1000);
			templateSettingUpload("lookups1.csv","Lookuprules Upload","\\cas\\data\\Content\\Data\\LookupRules\\lookups1.csv","Lookups");
			Thread.sleep(1000);
			templateSettingUpload("ModelDates.csv","Hybridsetup Upload","\\cas\\data\\Content\\Data\\HybridModels\\ModelDates.csv","HybridSetup");
			Thread.sleep(1000);
			templateSettingUpload("DEFAULT.xml","Hybridmodelbuilder Upload","\\cas\\data\\Content\\Repository\\Model\\HYBRIDMODELBUILDER\\DEFAULT.xml","MODEL.HYBRIDMODELBUILDER.DEFAULT");
			Thread.sleep(1000);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Template Settings upload successfully");
		Reporter.log("Test Case: Successfully Uploaded Admin Template Settings", 1, true);
	}
	
	@Test(dependsOnMethods = { "admin_uploladTemplateSettings" })
	public void admin_downloadTemplateSettings() throws Exception {
		try {
			GeneralUtil.logger("Download Template Settings");
			Reporter.log("Test Case: Download Admin Template Settings",1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Template Settings']"))
					.click();
			Thread.sleep(2000);
			Reporter.log("Test Step: Click Clear All Filters On Trades From Context Menu", 1, true);
			WebElement clearcontextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
			GeneralUtil.contextMenu(clearcontextMenuElement);
			GeneralUtil.captureScreenshot();
			Thread.sleep(1000);
			// Clear the filter for trade columns
			
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Clear All Filters");
			Thread.sleep(1000);
			
			// Search the upload 'ASX.nxt' file
			Reporter.log("Test Step: Search Uploaded Admin Template Settings",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(nxtTemplateSettings);
			Thread.sleep(1000);
			// Download "Templates(.*).zip" file in Template Settings
			Reporter.log("Test Step: Click Download & Download On Admin Template Settings From Context Menu",1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			Common.download(
					"Download",
					"Download",
					"CALENDAR(.*).xml",
					".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			GeneralUtil.captureScreenshot();

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Template Settings download successfully");
		Reporter.log("Test Case: Successfully Downloaded Admin Template Settings", 1, true);
	}

	@Test(dependsOnMethods = { "admin_downloadTemplateSettings" })
	public void admin_exportTemplateSettings() throws Exception {
		try {
			GeneralUtil.logger("Export Template Settings");
			Reporter.log("Test Case: Download Admin Template Settings",1, true);
			Thread.sleep(2000);
			Reporter.log("Test Step: Click Clear All Filters On Trades From Context Menu", 1, true);
			WebElement clearcontextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
			GeneralUtil.contextMenu(clearcontextMenuElement);
			GeneralUtil.captureScreenshot();

			// Clear the filter for trade columns
			
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Clear All Filters");
			Thread.sleep(1000);
			
			// Search the upload 'ASX.nxt' file
			Reporter.log("Test Step: Search Uploaded Admin Template Settings",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(nxtTemplateSettings);
			Thread.sleep(1000);
			// Export the "export(.*).csv" file
			Reporter.log("Test Step: Click Export & CSV Export On Admin Template Settings From Context Menu",1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			Common.download(
					"Export",
					"CSV Export",
					"export(.*).csv",
					".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			GeneralUtil.captureScreenshot();
			
			Thread.sleep(2000);
			// Export the "export(.*).xls" file
			WebElement contextMenuExcelElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
						Reporter.log("Test Step: Click Export & Excel Export On Admin Template Settings From Context Menu",1, true);
						GeneralUtil.contextMenu(contextMenuExcelElement);
						GeneralUtil.captureScreenshot();
						Common.download(
								"Export",
								"Excel Export",
								"export(.*).xls",
								".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
								".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
						GeneralUtil.captureScreenshot();

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Template Settings export successfully");
		Reporter.log("Test Case: Successfully Exported Admin Template Settings", 1, true);
	}

	@Test(dependsOnMethods = { "admin_exportTemplateSettings" })
	public void admin_deleteTemplateSettings() throws Exception {
		try {
			GeneralUtil.logger("Delete Template Settings");
			Reporter.log("Test Case: Delete Admin Template Settings",1, true);
			Thread.sleep(2000);
			Reporter.log("Test Step: Click Clear All Filters On Trades From Context Menu", 1, true);
			WebElement clearcontextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
			GeneralUtil.contextMenu(clearcontextMenuElement);
			GeneralUtil.captureScreenshot();

			// Clear the filter for trade columns
			
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Clear All Filters");
			Thread.sleep(1000);
			
			// Search the upload 'ASX.nxt' file
			Reporter.log("Test Step: Search Uploaded Admin Template Settings",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(nxtTemplateSettings);
			Thread.sleep(1000);
			// Delete the 'ASX.nxt' file
			Reporter.log("Test Step: Click Delete On Admin Template Settings From Context Menu",1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Delete");
			
			Reporter.log("Test Step: Click OK Button For Admin Template Settings", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Success");
			// Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Template Settings delete successfully");
		Reporter.log("Test Case: Successfully Deleted Admin Template Settings", 1, true);
	}

	@Test(dependsOnMethods = "admin_deleteTemplateSettings", alwaysRun = true)
	public void admin_addAdditionalFields() throws Exception {
		try {
			GeneralUtil.logger("Add Additional Fields");
			GeneralUtil.logger.info("Add Additional Fields");
			Reporter.log("Test Case: Add Admin Additional Fields",1, true);
			
			Reporter.log("Test Step: Click Admin Additional Fields",1, true);
			WebElement additionalFieldsElements = driver
					.findElement(By
							.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[4]/div/div/div[text() ='Additional Fields']"));

			// Create instance of Javascript executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			// Identify the WebElement which will appear after scrolling
			// down
			// WebElement element = driver.findElement(By.tagName("...."));
			// now execute query which actually will scroll until that
			// element is not appeared on page.
			je.executeScript("arguments[0].scrollIntoView(true);",
					additionalFieldsElements);
			je.executeScript("arguments[0].click();", additionalFieldsElements);

			Thread.sleep(8000);

			// Add Additional Fields
			Reporter.log("Test Step: Click Add On Admin Additional Fields From Context Menu",1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Add");
			
			Reporter.log("Test Step: Enter Text on Name Field On Admin Additional Fields",1, true);
			driver.findElement(
					By.xpath("//div[@class='react-draggable']/div/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div/input"))
					.sendKeys(addAitionalFieldsName);
			Thread.sleep(1000);
			// Enter values in add page in Additional Fields
			Reporter.log("Test Step: Select Log on Type Field On Admin Additional Fields In Dropdown",1, true);
			driver.findElement(
					By.xpath("//div[@class='react-draggable']/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div/div/div/div/span/div[1]"))
					.click();
			Thread.sleep(1000);
			GeneralUtil.contextMenuItem(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Long");
			
			Reporter.log("Test Step: Select Calculation Output on Type Field On Admin Additional Fields In Dropdown",1, true);
			driver.findElement(
					By.xpath("//div[@class='react-draggable']/div/div/div/div[2]/div/div[1]/div[3]/div/div[2]/div/div/div/div/div/span/div[1]"))
					.click();
			Thread.sleep(1000);
			GeneralUtil.contextMenuItem(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Calculation Output");

			
			Reporter.log("Test Step: Click OK Button For Add Admin Additional Fields", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			if (driver.findElement(By.xpath("//div[text() = 'Save']"))
					.isDisplayed() == true) {
				Reporter.log("Test Step: Click Save Button For Add Admin Additional Fields In Sub Window", 1, true);
				driver.findElement(By.xpath("//div[text() = 'Save']")).click();
				
				Reporter.log("Test Step: Click OK Button For Add Admin Additional Fields In Sub Window", 1, true);
				driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			}
			
				// search the added Additional Fields in name context menu
				Reporter.log("Test Step: Search Added Admin Additional Fields",1, true);
				WebElement searchFilterElement = driver
								.findElement(By
										.xpath("//div[@class='ag-pinned-left-header']/div[2]/div/div/div/input[@id='float-asset']"));
				searchFilterElement.clear();
				searchFilterElement.sendKeys(addAitionalFieldsName);
						
				Thread.sleep(1000);
				// Validate the Admin Additional Fields added or not
				Reporter.log("Test Step: Verify Admin Additional Fields Is Added", 1, true);
				String tradeIdtext = driver.findElement(By.xpath(".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[1]/div/div[1]/div/div/div/div")).getText();

				if (tradeIdtext.equalsIgnoreCase(addAitionalFieldsName)) {
				GeneralUtil.logger.info("Admin Additional Fields Name " + addAitionalFieldsName
							+ " is available in the Admin Additional Fields");
				} else {
					GeneralUtil.logger.info("Admin Additional Fields Name " + addAitionalFieldsName
							+ " is not available in the Admin Additional Fields");
				}

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			if (e.toString().contains("//div[text() = 'Save']")) {
				GeneralUtil.logger.error("Save Element not visible");
			} else {
				e.printStackTrace();
				GeneralUtil.logger.error(e);
				Reporter.log(e.toString(), 1, true);
				throw new Exception(e);
			}
		}
		GeneralUtil.logger.info("Additional Fields added successfully");
		Reporter.log("Test Case: Successfully Added Admin Additional Fields", 1, true);
	}
	
	@Test(dependsOnMethods = { "admin_addAdditionalFields" })
	public void admin_editAdditionalFields() throws Exception {
		try {
			GeneralUtil.logger.info("Edit Additional Fields");
			Reporter.log("Test Case: Edit Admin Additional Fields",1, true);
			/*driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[4]/div/div/div[text() ='Additional Fields']"))
					.click();*/
			Thread.sleep(3000);

			// search the added Additional Fields in name context menu
			Reporter.log("Test Step: Search Added Admin Additional Fields",1, true);
			WebElement searchFilterElement = driver
					.findElement(By
							.xpath("//div[@class='ag-pinned-left-header']/div[2]/div/div/div/input[@id='float-asset']"));
			searchFilterElement.clear();
			searchFilterElement.sendKeys(addAitionalFieldsName);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			// performed Edit on added Additional Fields
			Reporter.log("Test Step: Click On Added Admin Additional Fields For Edit",1, true);
			WebElement clickAddedAdtionalFieldElement = driver
					.findElement(By.xpath(".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[1]/div/div[1]/div/div/div/div"));
			clickAddedAdtionalFieldElement.click();
			Thread.sleep(1000);
			Reporter.log("Test Step: Select The Long On Type Dropdown Item", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-components-Dashboard-Admin-ServerSettings-AdditionalFields---viewContainer')]/div[2]//div[starts-with(@class,'Select-control')]"))
					.click();
			Thread.sleep(1000);
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Long", "Type");
			
			Reporter.log("Test Step: Enter The Text On Result Key Mask For Admin Additional Fields", 1, true);
			WebElement objResultKeyMask = GeneralUtil
					.getElement(
							"//span[text()='Result Key Mask']/following::input[1]",
							"xpath", dynamicTimeOut);
			strNewCalender = "Auto" + timeStamp;
			objResultKeyMask.sendKeys(strNewCalender);
			
			Reporter.log("Test Step: Enter The Text On Description For Admin Additional Fields", 1, true);
			WebElement objDescription = GeneralUtil
					.getElement(
							"//span[text()='Description']/following::input[1]",
							"xpath", dynamicTimeOut);
			strNewCalender = "Auto" + timeStamp;
			objDescription.sendKeys(strNewCalender);
			
			Reporter.log("Test Step: Enter The Text On Grouping For Admin Additional Fields", 1, true);
			WebElement objGrouping = GeneralUtil
					.getElement(
							"//span[text()='Grouping']/following::input[1]",
							"xpath", dynamicTimeOut);
			strNewCalender = "Auto" + timeStamp;
			objGrouping.sendKeys(strNewCalender);
			Thread.sleep(1000);
			Reporter.log("Test Step: Enter The Text On Format For Admin Additional Fields", 1, true);
			WebElement objFormat = GeneralUtil
					.getElement(
							"//span[text()='Format']/following::input[1]",
							"xpath", dynamicTimeOut);
			strNewCalender = "Auto" + timeStamp;
			objFormat.sendKeys(strNewCalender);
			Thread.sleep(1000);
			Reporter.log("Test Step: Check Nullable Check Box For Admin Additional Fields", 1, true);
			WebElement objNullableCheckbox = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Nullable']/following::label[1]",
							"xpath", dynamicTimeOut);
			objNullableCheckbox.click();
			GeneralUtil.logger
					.info("Checked Nullable Check Box For Admin Additional Fields.");
			
			Reporter.log("Test Step: Enter The Text On Default For Admin Additional Fields", 1, true);
			WebElement objDefault = GeneralUtil
					.getElement(
							"//span[text()='Default']/following::input[1]",
							"xpath", dynamicTimeOut);
			
			objDefault.sendKeys("45");
			
			Reporter.log("Test Step: Check Currency Check Box For Admin Additional Fields", 1, true);
			WebElement objCurrencyCheckbox = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Currency']/following::label[1]",
							"xpath", dynamicTimeOut);
			objCurrencyCheckbox.click();
			GeneralUtil.logger
					.info("Checked Currency Check Box For Admin Additional Fields.");
			
			Reporter.log("Test Step: Check Requires Break Clause Check Box For Admin Additional Fields", 1, true);
			WebElement objRequiresBreakClauseCheckbox = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Requires Break Clause']/following::label[1]",
							"xpath", dynamicTimeOut);
			objRequiresBreakClauseCheckbox.click();
			GeneralUtil.logger
					.info("Checked Requires Break Clause Check Box For Admin Additional Fields.");
			
			GeneralUtil.captureScreenshot();
			
			if (driver.findElement(By.xpath("//div[text() = 'Save']"))
					.isDisplayed() == true) {
				Reporter.log("Test Step: Click Save Button For Add Admin Additional Fields In Sub Window", 1, true);
				driver.findElement(By.xpath("//div[text() = 'Save']")).click();
				
				Reporter.log("Test Step: Click OK Button For Add Admin Additional Fields In Sub Window", 1, true);
				driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			}
			
			// search the added Additional Fields in name context menu
			Reporter.log("Test Step: Search Added Admin Additional Fields",1, true);
			WebElement searchEditFilterElement = driver
							.findElement(By
									.xpath("//div[@class='ag-pinned-left-header']/div[2]/div/div/div/input[@id='float-asset']"));
			searchEditFilterElement.clear();
			searchEditFilterElement.sendKeys(addAitionalFieldsName);
					
			Thread.sleep(1000);
			// Validate the Admin Additional Fields Edited or not
			Reporter.log("Test Step: Verify Admin Additional Fields Is Edited", 1, true);
			String tradeIdtext = driver.findElement(By.xpath(".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[1]/div/div[1]/div/div/div/div")).getText();

			if (tradeIdtext.equalsIgnoreCase(addAitionalFieldsName)) {
			GeneralUtil.logger.info("Admin Additional Fields Name " + addAitionalFieldsName
						+ " is available in the Admin Additional Fields");
			} else {
				GeneralUtil.logger.info("Admin Additional Fields Name " + addAitionalFieldsName
						+ " is not available in the Admin Additional Fields");
			}
			GeneralUtil.captureScreenshot();
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Additional Fields edited successfully");
		Reporter.log("Test Case: Successfully Edited Admin Additional Fields", 1, true);
	}

	@Test(dependsOnMethods = { "admin_editAdditionalFields" })
	public void admin_exportAdditionalFields() throws Exception {
		try {
			GeneralUtil.logger.info("Export Additional Fields");
			Reporter.log("Test Case: Export Admin Additional Fields",1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[4]/div/div/div[text() ='Additional Fields']"))
					.click();
			Thread.sleep(1000);

			// search the added Additional Fields in name context menu
			Reporter.log("Test Step: Search Added Admin Additional Fields",1, true);
			WebElement searchFilterElement = driver
					.findElement(By
							.xpath("//div[@class='ag-pinned-left-header']/div[2]/div/div/div/input[@id='float-asset']"));
			searchFilterElement.clear();
			searchFilterElement.sendKeys(addAitionalFieldsName);
			

			// performed export on added Additional Fields
			Thread.sleep(1000);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Click Export & Excel Export On Admin Additional Fields From Context Menu",1, true);
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			Thread.sleep(1000);
			Common.download(
					"Export",
					"Excel Export",
					"export(.*).xls",
					".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			GeneralUtil.captureScreenshot();
			
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Click Export & CSV Export On Admin Additional Fields From Context Menu",1, true);
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			Thread.sleep(1000);
			Common.download(
					"Export",
					"CSV Export",
					"export(.*).csv",
					".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			GeneralUtil.captureScreenshot();

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Additional Fields export successfully");
		Reporter.log("Test Case: Successfully Exported Admin Additional Fields", 1, true);
	}

	@Test(dependsOnMethods = { "admin_exportAdditionalFields" })
	public void admin_deleteAdditionalFields() throws Exception {
		try {
			GeneralUtil.logger.info("Delete Additional Fields");
			Reporter.log("Test Case: Delete Admin Additional Fields",1, true);

			Thread.sleep(2000);
			

			// performed delete on added Additional Fields
			Reporter.log("Test Step: Click Delete On Admin Additional Fields From Context Menu",1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Delete");
			
			Reporter.log("Test Step: Click OK Button For Admin Additional Fields", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Save Additional Fields");
			// Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Additional Fields delete successfully");
		Reporter.log("Test Case: Successfully Deleted Admin Additional Fields", 1, true);
	}

	@Test(dependsOnMethods = "admin_deleteAdditionalFields", alwaysRun = true)
	public void admin_addRetentionPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Add Retention Policies");
			Reporter.log("Test Case: Add Admin Retention Policies",1, true);
			Thread.sleep(1000);
			Reporter.log("Test Step: Click Admin Retention Policies",1, true);
			WebElement retentionPoliciesElement = driver
					.findElement(By
							.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[5]/div/div/div[text() ='Retention Policies']"));

			// Create instance of Javascript executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			// Identify the WebElement which will appear after scrolling
			// down
			// WebElement element = driver.findElement(By.tagName("...."));
			// now execute query which actually will scroll until that
			// element is not appeared on page.
			je.executeScript("arguments[0].scrollIntoView(true);",
					retentionPoliciesElement);
			je.executeScript("arguments[0].click();", retentionPoliciesElement);
			Thread.sleep(5000);

			// Add Retention Policies
			Reporter.log("Test Step: Click Add On Admin Retention Policies From Context Menu",1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Add");
			
			Reporter.log("Test Step: Enter Text Policy Name Field On Admin Retention Policies For Add",1, true);
			driver.findElement(
					By.xpath("html/body/div[4]/div/div/div/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input"))
					.sendKeys(addRetentionPoliciesName);
			
			Reporter.log("Test Step: Click OK Button For Add Admin Retention Policies For Add", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			if (driver.findElement(By.xpath("//div[text() = 'Save']"))
					.isDisplayed() == true) {
				
				Reporter.log("Test Step: Click Save Button For Add Admin Retention Policies In Sub Window", 1, true);
				driver.findElement(By.xpath("//div[text() = 'Save']")).click();
				
				Reporter.log("Test Step: Click OK Button For Add Admin Retention Policies In Sub Window", 1, true);
				driver.findElement(By.xpath("//div[text() = 'OK']")).click();

				// Validating Retention Policies added or not
				Reporter.log("Test Step: Verify Success Notification", 1, true);
				Common.handleNotifications("Save Retention Policy");
				GeneralUtil.captureScreenshot();
				// TT 45574 - Application change in in build 4.6
				// Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");
				// driver.findElement(By.xpath("//div[text() = 'Cancel']")).click();
			}
			Reporter.log("Test Step: Search Added Admin Retention Policies",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(addRetentionPoliciesName);
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Verify Admin Retention Policies Is Added",1, true);
			String retentionPoliciesName = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]"))
					.getText();
			if (retentionPoliciesName.contains(addRetentionPoliciesName)) {
				GeneralUtil.logger.info("Retention Policies name "
						+ retentionPoliciesName
						+ " is available in the Retention Policies page");
			} else {
				GeneralUtil.logger.error("Retention Policies name "
						+ retentionPoliciesName
						+ " is not available in the Retention Policies page");
			}

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			if (e.toString().contains("//div[text() = 'Save']")) {
				GeneralUtil.logger.error("Save Element not visible");
			} else {
				e.printStackTrace();
				GeneralUtil.logger.error(e);
				Reporter.log(e.toString(), 1, true);
				throw new Exception(e);
			}
		}
		GeneralUtil.logger.info("Retention Policies added successfully");
		Reporter.log("Test Case: Successfully Added Admin Retention Policies", 1, true);
	}

	@Test(dependsOnMethods = { "admin_addRetentionPolicies" })
	public void admin_editRetentionPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Edit Retention Policies");
			Reporter.log("Test Case: Edit Admin Retention Policies",1, true);
			/*driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[5]/div/div/div[text() ='Retention Policies']"))
					.click();*/
			Thread.sleep(3000);
			
					
			// Updating Retention Policies
			Reporter.log("Test Step: Search Added Admin Retention Policies",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(addRetentionPoliciesName);
			Thread.sleep(1000);
			
			driver.findElement(
					By.xpath(".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[1]/div/div[1]/span/span[1]/span[2]"))
					.click();
			Thread.sleep(1000);
			Reporter.log("Test Step: Click Added Admin Retention Policies",1, true);
			driver.findElement(
					By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]"))
					.click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]"))
					.click();
			Thread.sleep(1000);
			Reporter.log("Test Step: Enter Text On Policy Name Field For Admin Retention Policies In Sub Window",1, true);
			WebElement policyNameElement = driver
					.findElement(By
							.xpath("//div[@class='ReactTabs react-tabs']/div/div/div[1]/div[2]/div[2]/div/div[2]/div/div[1]/div/div[5]/div/div/div/input"));
			policyNameElement.clear();
			policyNameElement.sendKeys(editRetentionPoliciesName);
			Thread.sleep(1000);
			Reporter.log("Test Step: Click Save Button For Admin Retention Policies In Sub Window", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click OK Button For Admin Retention Policies In Sub Window", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();

			// Validating Retention Policies edited or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Save Retention Policy");
			GeneralUtil.captureScreenshot();
			// TT 45574 - Application change in in build 4.6
			// Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");
			// driver.findElement(By.xpath("//div[text() = 'Cancel']")).click();
			Reporter.log("Test Step: Search Edited Admin Retention Policies",1, true);
			WebElement searchSecondElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			searchSecondElement.clear();
			searchSecondElement.sendKeys(editRetentionPoliciesName);
			
			Reporter.log("Test Step: Verify Admin Retention Policies Is Edited",1, true);
			String retentionPoliciesName = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]"))
					.getText();
			if (retentionPoliciesName.contains(editRetentionPoliciesName)) {
				GeneralUtil.logger.info("Retention Policies name "
						+ retentionPoliciesName
						+ " is available in the Retention Policies page");
			} else {
				GeneralUtil.logger.error("Retention Policies name "
						+ retentionPoliciesName
						+ " is not available in the Retention Policies page");
			}

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Retention Policies edited successfully");
		Reporter.log("Test Case: Successfully Edited Admin Retention Policies", 1, true);
	}

	@Test(dependsOnMethods = { "admin_editRetentionPolicies" })
	public void admin_cloneRetentionPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Clone Retention Policies");
			Reporter.log("Test Case: Clone Admin Retention Policies",1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[5]/div/div/div[text() ='Retention Policies']"))
					.click();
			Thread.sleep(3000);
		
			
			// Search the added Retention Policies
			Reporter.log("Test Step: Search Added Admin Retention Policies",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(editRetentionPoliciesName);
			Thread.sleep(1000);
			// Cloned the Retention Policies
			Reporter.log("Test Step: Click Clone On Admin Retention Policies From Context Menu",1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Clone");
			
			Reporter.log("Test Step: Enter Text Policy Name Field On Admin Retention Policies For Clone",1, true);
			driver.findElement(
					By.xpath("html/body/div[4]/div/div/div/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input"))
					.sendKeys(cloneRetentionPoliciesName);
			Thread.sleep(1000);
			Reporter.log("Test Step: Click OK Button For Add Admin Retention Policies For Clone", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			Reporter.log("Test Step: Click Save Button For Add Admin Retention Policies In Sub Window", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click OK Button For Add Admin Retention Policies In Sub Window", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();

			// Validating the Retention Policies cloned or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Save Retention Policy");
			GeneralUtil.captureScreenshot();
			// TT 45574 - Application change in in build 4.6
			// Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");
			// driver.findElement(By.xpath("//div[text() = 'Cancel']")).click();
			Reporter.log("Test Step: Search Cloned Admin Retention Policies",1, true);
			WebElement searchSecondElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			searchSecondElement.clear();
			searchSecondElement.sendKeys(cloneRetentionPoliciesName);
			Thread.sleep(1000);
			Reporter.log("Test Step: Verify Admin Retention Policies Is Cloned",1, true);
			String retentionPoliciesName = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]"))
					.getText();
			if (retentionPoliciesName.contains(cloneRetentionPoliciesName)) {
				GeneralUtil.logger.info("Retention Policies name "
						+ retentionPoliciesName
						+ " is available in the Retention Policies page");
			} else {
				GeneralUtil.logger.error("Retention Policies name "
						+ retentionPoliciesName
						+ " is not available in the Retention Policies page");
			}

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Retention Policies cloned successfully");
		Reporter.log("Test Case: Successfully Cloned Admin Retention Policies", 1, true);
	}

	@Test(dependsOnMethods =  "admin_cloneRetentionPolicies", alwaysRun = true)
	public void admin_exportRetentionPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Export Retention Policies");
			Reporter.log("Test Case: Export Admin Retention Policies",1, true);
			/*driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[5]/div/div/div[text() ='Retention Policies']"))
					.click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Click Clear All Filters On Retention Policies From Context Menu", 1, true);
			WebElement clearcontextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
			GeneralUtil.contextMenu(clearcontextMenuElement);
			GeneralUtil.captureScreenshot();

			// Clear the filter for trade columns
			
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Clear All Filters");
			Thread.sleep(1000);*/
			
			// Search the added Retention Policies
			Reporter.log("Test Step: Search Added Admin Retention Policies",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(editRetentionPoliciesName);
			Thread.sleep(1000);
			driver.findElement(
					By.xpath(".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[1]/div/div[1]/span/span[1]/span[2]"))
					.click();
			Thread.sleep(1000);
			// Export the Retention Policies
			Reporter.log("Test Step: Click Export & CSV Export On Admin Retention Policies From Context Menu",1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			Common.download(
					"Export",
					"CSV Export",
					"export(.*).csv",
					".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
					".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			GeneralUtil.captureScreenshot();
			
			Thread.sleep(1000);
			// Export the Retention Policies
			WebElement contextMenuExcelElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]"));
						Reporter.log("Test Step: Click Export & Excel Export On Admin Retention Policies From Context Menu",1, true);
						GeneralUtil.contextMenu(contextMenuExcelElement);
						GeneralUtil.captureScreenshot();
						Common.download(
								"Export",
								"Excel Export",
								"export(.*).xls",
								".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
								".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
						GeneralUtil.captureScreenshot();

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Retention Policies export successfully");
		Reporter.log("Test Case: Successfully Exported Admin Retention Policies", 1, true);
	}

	@Test(dependsOnMethods =  "admin_exportRetentionPolicies", alwaysRun = true)
	public void admin_deleteRetentionPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Delete Retention Policies");
			Reporter.log("Test Case: Delete Admin Retention Policies",1, true);
			/*driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[5]/div/div/div[text() ='Retention Policies']"))
					.click();*/
			Thread.sleep(3000);
			
			Reporter.log("Test Step: Click Clear All Filters On Retention Policies From Context Menu", 1, true);
			WebElement clearcontextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
			GeneralUtil.contextMenu(clearcontextMenuElement);
			GeneralUtil.captureScreenshot();

			// Clear the filter for trade columns
			
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Clear All Filters");
			Thread.sleep(1000);
			/*// Search the added Retention Policies
			Reporter.log("Test Step: Search Added Admin Retention Policies",1, true);
			WebElement searchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			searchElement.clear();
			searchElement.sendKeys(addRetentionPoliciesName);
			Thread.sleep(1000);
			
			// driver.findElement(By.xpath(".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[1]/div/div[1]/span/span[1]/span[1]")).click();
			// Delete the added Retention Policies
			Reporter.log("Test Step: Click Delete On Admin Retention Policies From Context Menu",1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();

			// Changed By SESHA PHANI From "Delete" to "Delete Checked Items"
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Delete Checked Items");

			WebElement confirmationElement = driver
					.findElement(By
							.xpath("html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div[1]/button"));
			confirmationElement.click();
			Thread.sleep(1000);
			
			// Validating the Retention Policies deleted or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Delete Retention Policy");
			// TT 45574 - Application change in in build 4.6
			// Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");
*/
			// Search the edited Retention Policies
			WebElement searchEditElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			searchEditElement.clear();
			searchEditElement.sendKeys(editRetentionPoliciesName);
			Thread.sleep(1000);
			// driver.findElement(By.xpath(".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[1]/div/div[1]/span/span[1]/span[1]")).click();
			// Delete the updated Retention Policies
			Reporter.log("Test Step: Click Delete On Admin Retention Policies From Context Menu For Edited",1, true);
			WebElement contextMenuEditElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]"));
			GeneralUtil.contextMenu(contextMenuEditElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Delete");

			// Validating the Retention Policies deleted or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Delete Retention Policy");
			// Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");

			/*
			 * // Search the cloned Retention Policies //COMMENTED BY SESHA
			 * PHANI WebElement searchCloneElement = driver .findElement(By
			 * .xpath(
			 * ".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"
			 * )); searchCloneElement.clear();
			 * searchCloneElement.sendKeys(cloneRetentionPoliciesName);
			 * Thread.sleep(1000);
			 * 
			 * // Delete the cloned Retention Policies WebElement
			 * contextMenuCloneElement = driver .findElement(By .xpath(
			 * ".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"
			 * )); GeneralUtil.contextMenu(contextMenuCloneElement);
			 * GeneralUtil.captureScreenshot(); GeneralUtil .contextMenuItem(
			 * ".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
			 * "Delete");
			 * 
			 * // Validating the Retention Policies deleted or not
			 * Common.handleNotifications("Delete Retention Policy");
			 * //Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");
			 */
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Retention Policies delete successfully");
		Reporter.log("Test Case: Successfully Deleted Admin Retention Policies", 1, true);
	}

	@AfterClass
	public void afterClass() throws Exception {
		Thread.sleep(3000);
		Common.loginOffXVA();
		Browser.quitBrowser();
		Thread.sleep(2000);
	}

	public void VerifyElementPresent(String strTrade, String strXpath,
			int timeOut) {
		try {
			boolean blnFind = GeneralUtil.waitUntilExists(strXpath, "xpath",
					timeOut);
			if (blnFind)
				GeneralUtil.logger.info(strTrade
						+ " MarketData item is displayed with given xpath: "
						+ strXpath);
			else
				GeneralUtil.logger
						.error(strTrade
								+ " MarketData item is not displayed with given xpath: "
								+ strXpath);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			GeneralUtil.logger
					.error("Element is not displayed.Detailes are Locator:"
							+ strXpath + " LocatorType:xpath WaitTime:"
							+ timeOut);
		}
	}
	
	public void templateSettingUpload(String uploadFile, String uploadAction,String path,String uploadedfile) throws Exception{
					
		Reporter.log("Test Step: Click Clear All Filters On Trades From Context Menu", 1, true);
		WebElement clearcontextMenuElement = driver.findElement(By
				.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
		GeneralUtil.contextMenu(clearcontextMenuElement);
		GeneralUtil.captureScreenshot();

		// Clear the filter for trade columns
		
		GeneralUtil
				.contextMenuItem(
						".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
						"Clear All Filters");
		Thread.sleep(1000);
		// Upload 'ASX.nxt' file in Template Settings
					Reporter.log("Test Step: Click Upload On Admin Authorizations Functions From Context Menu",1, true);
					WebElement contextMenuElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
					GeneralUtil.contextMenu(contextMenuElement);
					GeneralUtil.captureScreenshot();
					GeneralUtil
							.contextMenuItem(
									".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
									"Upload");
					Thread.sleep(1000);
					
					Reporter.log("Test Step: Click Template Upload On Admin Authorizations Functions From Context Menu",1, true);
					GeneralUtil
							.contextMenuItem(
									".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
									uploadAction);
					Thread.sleep(1000);
					
					Reporter.log("Test Step: Upload .csv File From Executed Machine", 1, true);
					GeneralUtil.uploadFile(fileUploadPath
							+ path);
					Thread.sleep(20000);

					// Common.handleNotifications("Upload template");

					// Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");
					Reporter.log("Test Step: Search Uploaded Admin Template Settings",1, true);
					WebElement searchElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
					searchElement.clear();
					searchElement.sendKeys(uploadedfile);
					Thread.sleep(1000);

					// Validating 'ASX.nxt' file is uploaded or not
					Reporter.log("Test Step: Verify Admin Template Settings Is Uploaded", 1, true);
					GeneralUtil.captureScreenshot();
					String templateSettingsname = driver
							.findElement(
									By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/span/span[2]"))
							.getText();
					if (templateSettingsname.contains(uploadedfile)) {
						GeneralUtil.logger.info("Template Settings name "
								+ templateSettingsname
								+ " is available in the Template Settings page");
					} else {
						GeneralUtil.logger.error("Template Settings name "
								+ templateSettingsname
								+ " is not available in the Template Settings page");
					}
	}

 	public String getToday(String format) {
		Date date = new Date();
		return new SimpleDateFormat(format).format(date);
	}

}
