package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

public class VerifyTabs {

	public WebDriver driver;
	
	@BeforeClass
	public void beforeClass() throws Exception {

		GeneralUtil.configureLog4j("VerifyTabs");
		GeneralUtil.logger("VerifyTabs");

		// Create driver object for browser
		try {
			driver = Browser.getDriver();
			Common.NavigateToURL();
			Common.loginToXVA();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Verify tabs in the left corner of the window locate tabs: Risk,Trades,
	// Market Data,
	// Static,Calculations,sensitives & Markets,scenarios,Admin,custom layout .
	@Test(alwaysRun=true)
	public void dashboard_verifyTabs() throws Exception {
		try {
			GeneralUtil.logger.info("Verify Treeview Items");
			Thread.sleep(3000);
			
			Reporter.log("Test Case: Verify Treeview Items", 1, true);
			//Verify existence of Trade
			Reporter.log("Test Step: Verify Treeview Item: Trades", 1, true);
			String xPpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li[1]/div/div/div[text()='Trades']";
			verifyElementPresent("Trades", xPpath);
			
			//Verify existence of PDC
			Reporter.log("Test Step: Verify Treeview Item: PDC", 1, true);
			xPpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div/Strong[text()='PDC']";
			verifyElementPresent("PDC", xPpath);
			
			//Verify existence of Policies
			Reporter.log("Test Step: Verify Treeview Item: Policies", 1, true);
			xPpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div/Strong[text()='Policies']";
			verifyElementPresent("Policies", xPpath);
			
			// verify Market Data data type is exist
			Reporter.log("Test Step: Verify Treeview Item: Market Data", 1, true);
			xPpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div/Strong[text()='Market Data']";
			verifyElementPresent("Market Data", xPpath);

			//verify Risk data type is exist
			Reporter.log("Test Step: Verify Treeview Item: Risk", 1, true);
			xPpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Risk']";
			verifyElementPresent("Risk", xPpath);

			// verify Static data type is exist
			Reporter.log("Test Step: Verify Treeview Item: Static", 1, true);
			xPpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div/Strong[text()='Static']";
			verifyElementPresent("Static", xPpath);

			// verify Calculations data type is exist
			Reporter.log("Test Step: Verify Treeview Item: Calculations", 1, true);
			xPpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Calculations']";
			verifyElementPresent("Calculations", xPpath);

			// verify Scenarios data type is exist
			Reporter.log("Test Step: Verify Treeview Item: Sensitivities & Market Scenarios", 1, true);
			xPpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div/Strong[text()='Sensitivities & Market Scenarios']";
			verifyElementPresent("Sensitivities & Market Scenarios", xPpath);

			// verify Admin data type is exist
			Reporter.log("Test Step: Verify Treeview Item: Admin", 1, true);
			xPpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div/Strong[text()='Admin']";
			verifyElementPresent("Admin", xPpath);

			// verify Custom Layout data type is exist
			Reporter.log("Test Step: Verify Treeview Item: Custom Layout", 1, true);
			xPpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Custom Layout']";
			verifyElementPresent("Custom Layout", xPpath);
			
			Reporter.log("Test Case: Successfully Verified Treeview Items", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	// verify in the upper right corner of the screen there is current user's
	// name (Administrator) and current date and time.
	@Test(dependsOnMethods = "dashboard_verifyTabs",alwaysRun=true)
	public void dashboard_verifyUserNameandDateTime() throws Exception {
		try {
			GeneralUtil.logger("Verify User Name and Date Time");
			
			Reporter.log("Test Case: Verify User Name Date Time", 1, true);
			
			// Get displayed date and time from application about window
			Reporter.log("Test Step: Get The User Name and Date & Time From Application", 1, true);
			WebElement objDateAndTime = GeneralUtil
					.getElement(
							"//div[starts-with(@class,'src-routes-Home-components-MainPage-layouts-Header-Header---dateContainer')]",
							"xpath", GeneralUtil.dynamicTimeOut);
			String strdateTime = objDateAndTime.getText();
			String today = getToday("yyyy-mm-dd, hh:mm:ss a");
			
			// verified displayed date is equal to today date and time
			Reporter.log("Test Step: Compare Server Date & Time With Machine Today Date And Time", 1, true);
			isExpire(strdateTime, today);
			
			Reporter.log("Test Case: Successfully Verified User Name Date Time", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	// Click on Administrator and verify that Opens a drop-down menu giving
	// users access to Global
	// Settings, Reset password,About and the option to Logout.
	@Test(dependsOnMethods =  "dashboard_verifyUserNameandDateTime",alwaysRun=true)
	public void dashboard_verifyAdministratorDropDownItems() throws Exception {
		GeneralUtil.logger.info("Verify Administrator DropDown Items");

		try {
			// define expected drop down items
			String[] values = { "Global Settings", "Reset Password", "About",
					"Log Off" };

			// Close notifications
			try {
				WebElement objnotification = GeneralUtil
						.getElement(
								"//div[starts-with(@class,'notification notification-error notification-visible')]/span",
								"xpath", 1);
				objnotification.click();
			} catch (Exception e) {

			}
			Reporter.log("Test Case: Verify Administrator DropDown Items", 1, true);
			
			// Click on administrator dropdown
			Reporter.log("Test Step: Click On Administrator DropDown Items", 1, true);
			String strAdministratorXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-layouts-Header-UserStatus---userInfo')]/div[text()='Administrator']/span";
			WebElement objAdministrator = GeneralUtil.getElement(
					strAdministratorXpath, "xpath", GeneralUtil.dynamicTimeOut);
			objAdministrator.click();

			// Verify for each dropdown item is displayed as expected
			
			List<WebElement> arrDropDownItems = GeneralUtil
					.getElements(
							"//div[starts-with(@class,'src-routes-Home-components-MainPage-layouts-Header-UserStatus---userInfo')]/ul/li",
							"xpath", GeneralUtil.dynamicTimeOut);
			for (int j = 0; j < values.length; j++) {
				boolean blnflog = false;
				for (int i = 0; i < arrDropDownItems.size(); i++) {
					String strActItemText = arrDropDownItems.get(i).getText();
					if (strActItemText.equalsIgnoreCase(values[j])) {
						GeneralUtil.logger.info(values[j]
								+ " is displayed in Administration drop down");
						Reporter.log(String.format("Test Step: Verify %s Administrator DropDown Items List", strActItemText), 1, true);
						blnflog = true;
						break;
					}
				}

				if (!blnflog) {
					GeneralUtil.logger.error(values[j]
							+ " is not displayed in Administration drop down");
				}

			}

			objAdministrator.click();
			
			Reporter.log("Test Case: Successfully Verified Administrator DropDown Items", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	// Click on Settings . Check the Server date if it matches the date of
	// server started.
	@Test(dependsOnMethods = "dashboard_verifyAdministratorDropDownItems",alwaysRun=true)
	public void dashboard_verifyGlobalSttingsWindow() throws Exception {
		try {
			GeneralUtil
					.logger.info("Validate Server time in Global Sttings");
			
			Reporter.log("Test Case: Verify Server Time In Global Sttings", 1, true);
			// Close notifications
			try {
				WebElement objnotification = GeneralUtil
						.getElement(
								"//div[starts-with(@class,'notification notification-error notification-visible')]/span",
								"xpath", 1);
				objnotification.click();
			} catch (Exception e) {

			}
			// Click on Administrator
			Reporter.log("Test Step: Click On Administrator", 1, true);
			String strAdministratorXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-layouts-Header-UserStatus---userInfo')]/div[text()='Administrator']/span";
			WebElement objAdministrator = GeneralUtil.getElement(
					strAdministratorXpath, "xpath", GeneralUtil.dynamicTimeOut);
			objAdministrator.click();
			
			// Select GlobalSettings
			Reporter.log("Test Step: Select GlobalSettings On Administrator DropDown Item", 1, true);
			WebElement objGlobalSettings = GeneralUtil
					.getElement(
							"//div[starts-with(@class,'src-routes-Home-components-MainPage-layouts-Header-UserStatus---userInfo')]/ul/li[text()='Global Settings']",
							"xpath", GeneralUtil.dynamicTimeOut);
			objGlobalSettings.click();
			
			// Get serverdate from applicatrion field
			Reporter.log("Test Step: Get Server Date & Time On Global Settings", 1, true);
			WebElement objserverDate = GeneralUtil
					.getElement(
							"html/body/div[2]/div/div/div/div/div/div/div[2]/div/div/div[1]/div[starts-with(@class,'src-components-Dashboard-UserSettings-GlobalSettings-GlobalSettings---serverDate')]/div/div/span",
							"xpath", GeneralUtil.dynamicTimeOut);

			String strServerDate = objserverDate.getText();
			String strServerDate1 = strServerDate;
			// Get today date and format it to EEE MMM dd yyyy HH:mm format
			Reporter.log("Test Step: Get Todays Date And Time From Machine", 1, true);
			Date date = new Date();
			String today = new SimpleDateFormat("EEE MMM dd yyyy HH:mm")
					.format(date);

			strServerDate = strServerDate.replace(
					" GMT+0530 (India Standard Time)", "");

			strServerDate = strServerDate.substring(0,
					(strServerDate.length() - 3));

			// Compare serverdate frome application and today date
			Reporter.log("Test Step: Compare Server Date & Time With Machine Todays Date & Time", 1, true);
			if (today.equalsIgnoreCase(strServerDate)) {
				GeneralUtil.logger
						.info("Server date is mathed the server standerd. "
								+ strServerDate1);
			} else
				GeneralUtil.logger
						.info("Server date is not mathed the server standerd. "
								+ strServerDate1);
			
			// close GlobalSttingsWindow
			Reporter.log("Test Step: Close Global Setting Window", 1, true);
			WebElement objAoutClose = GeneralUtil
					.getElement(
							"html/body/div[2]/div/div/div/div/div/div/div[1]/div/span[2]/i",
							"xpath", GeneralUtil.dynamicTimeOut);
			objAoutClose.click();
			try {
				WebElement objnotification = GeneralUtil
						.getElement(
								"//div[starts-with(@class,'notification notification-error notification-visible')]/span",
								"xpath", 1);
				objnotification.click();
			} catch (Exception e) {

			}
			Reporter.log("Test Case: Successfully Verified Global Settings", 1, true);
		} catch (Exception e) {

			GeneralUtil.logger
					.error("Unable to validate Server date in Global Settings window. Exception is :"
							+ e.getMessage());
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	// Click on about and verify About window is opened. Check Version and
	// Copyright on the screen.
	 @Test(dependsOnMethods = "dashboard_verifyGlobalSttingsWindow",alwaysRun=true)
	public void dashboard_verifyAboutWindow() throws Exception {
		 Reporter.log("Test Case: Verify About Window on Administrator Dropdown Item", 1, true);
		 try {
			if(driver.findElement(By.xpath("//div[@class='notifications-wrapper']//h4//following-sibling::div[@class='notification-message']")).isDisplayed()==true) {
			Common.handleNotifications("Failed to get global setting for user Administrator");
			}
			}catch(Exception e){
				if(e.toString().contains("//div[@class='notifications-wrapper']//h4//following-sibling::div[@class='notification-message']")){
					GeneralUtil.logger.error("Notification Not found");
				}
			}
		try{
			Thread.sleep(1000);
			GeneralUtil.logger.info("Step11:Verify About Window");
			// Close notifications
			try {
				WebElement objnotification = GeneralUtil
						.getElement(
								"//div[starts-with(@class,'notification notification-error notification-visible')]/span",
								"xpath", 1);
				objnotification.click();
			} catch (Exception e) {

			}
			// Close notifications
			try {
				WebElement objnotification = GeneralUtil
						.getElement(
								"//div[starts-with(@class,'notification notification-error notification-visible')]/span",
								"xpath", 1);
				objnotification.click();
			} catch (Exception e) {

			}
			// Close notifications
			try {
				WebElement objnotification = GeneralUtil
						.getElement(
								"//div[starts-with(@class,'notification notification-error notification-visible')]/span",
								"xpath", 1);
				objnotification.click();
			} catch (Exception e) {

			}
			
			// Click on Administrator
			Reporter.log("Test Step: Click On Administrator", 1, true);
			String strAdministratorXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-layouts-Header-UserStatus---userInfo')]/div[text()='Administrator']/span";
			WebElement objAdministrator = GeneralUtil.getElement(
					strAdministratorXpath, "xpath", GeneralUtil.dynamicTimeOut);
			objAdministrator.click();
			
			// Select about drop down
			Reporter.log("Test Step: Select About Item On Administrator Dropdown Item", 1, true);
			WebElement objAbout = GeneralUtil
					.getElement(
							"//div[starts-with(@class,'src-routes-Home-components-MainPage-layouts-Header-UserStatus---userInfo')]/ul/li[text()='About']",
							"xpath", GeneralUtil.dynamicTimeOut);
			objAbout.click();
			
			// Get text from AboutCopyright field
			Reporter.log("Test Step: Get Text From AboutCopyright Field", 1, true);
			WebElement objAboutCopyright = GeneralUtil
					.getElement(
							"html/body/div[2]/div/div/div/div/div/div/div[2]/div/div/div[7]/span/parent::div",
							"xpath", GeneralUtil.dynamicTimeOut);
			String strCopyright = objAboutCopyright.getText();
			strCopyright = strCopyright.replace("\n", "");
			
			// Check match with given text
			Reporter.log("Test Step: Verify AboutCopyright Text Is Same", 1, true);
			String strExpCopyRight = "Copyright (C) 2017 Numerix LLC. All rights reserved.Visit www.numerix.com for more information";
			if (strExpCopyRight.equalsIgnoreCase(strCopyright))
				GeneralUtil.logger.info(strCopyright
						+ " is displayed in About window");
			else
				GeneralUtil.logger.error(strCopyright
						+ " is not displayed in About window");
			
			Reporter.log("Test Step: Close The About Window", 1, true);
			WebElement objAoutClose = GeneralUtil
					.getElement(
							"html/body/div[2]/div/div/div/div/div/div/div[1]/div/span[2]/i",
							"xpath", GeneralUtil.dynamicTimeOut);
			objAoutClose.click();
			
			Reporter.log("Test Case: Successfully Verified About Window", 1, true);

		} catch (Exception e) {

			GeneralUtil.logger
					.error("Unable to validate copy rights text in About window. Exception is :"
							+ e.getMessage());
			
			
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
			
		}

	}

	// Verify Trades screen has an additional icon which allows users to
	// customize the columns
	// that will appear on the screen. These columns will be used to filter
	// trades.
	@Test(dependsOnMethods = "dashboard_verifyAboutWindow",alwaysRun=true)
	public void dashboard_verifyColumnsFilter() throws Exception {

		GeneralUtil.logger.info("Verify Columns Filter");
		Reporter.log("Test Case: Verify Trades Column Filter", 1, true);
		
		Reporter.log("Test Step: Click On Trade", 1, true);
		String strTradeXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li[1]/div/div/div[text()='Trades']";
		try {
			WebElement objTradeTreeviewItem = GeneralUtil.getElement(
					strTradeXpath, "xpath", GeneralUtil.dynamicTimeOut);
			objTradeTreeviewItem.click();
			Thread.sleep(6000);
			try{
			if(driver.findElement(By.xpath("//div[@class='notifications-wrapper']//h4//following-sibling::div[@class='notification-message']")).isDisplayed()==true) {
			Common.handleNotifications("Failed to get trades filter for user Administrator");
			}
			} catch (Exception e) {

			}
			
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

			Reporter.log("Test Step: Get The Trade Column Text", 1, true);
			String strActColText = "";
			List<WebElement> arrColumnText = GeneralUtil
					.getElements(
							"//div[starts-with(@class,'src-components-Grid-RealtimeGrid---tableContainer')]//div[starts-with(@class,'ag-header-container')]/div//span[starts-with(@class,'ag-header-cell-text')]",
							"xpath", GeneralUtil.dynamicTimeOut);
			

			for (int i = 0; i < arrColumnText.size()-1; i++) {
				try {
					WebElement objnotification = GeneralUtil
							.getElement(
									"//div[starts-with(@class,'notification notification-error notification-visible')]/span",
									"xpath", 1);
					objnotification.click();
				} catch (Exception e) {

				}
				
				strActColText = arrColumnText.get(i).getText();
				
				Reporter.log(String.format("Test Step: Verify %s on Show Hide Column List", strActColText), 1, true);
				WebElement objShowHideColumnsButton = GeneralUtil.getElement(
						"//div/span[@title='Show/Hide Columns']/i", "xpath",
						GeneralUtil.dynamicTimeOut);
				objShowHideColumnsButton.click();
				/*boolean blnChecked = false;
				JavascriptExecutor js = (JavascriptExecutor) driver;

				String TitleName = js.executeScript("return document.title;")
						.toString();
				System.out.println("Title of the page = " + TitleName);

				WebElement lstElement = driver
						.findElement(By.xpath(String
								.format("//label[text()='Asset Class']/preceding-sibling::div",
										strActColText)));
				
				WebElement lstElement = driver
						.findElement(By.xpath("//label[text()='Asset Class']"));
				String name = lstElement.getText();
				
				js.executeScript("arguments[0].scrollIntoView(true);",
						name);

				blnChecked = (boolean) (js.executeScript(
						"return arguments[0].control.checked; ", name));
				if (blnChecked)
					GeneralUtil.logger.info(name
							+ " checkbox is chached");
				else
					GeneralUtil.logger.error(name
							+ " checkbox is not chached");
				objShowHideColumnsButton.click();
				i++;*/
				objShowHideColumnsButton.click();
			}

			
			Reporter.log("Test Case: Successfully Verified Trades Column Filter", 1, true);
			

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@AfterClass
	public void afterClass() throws Exception {
		Common.loginOffXVA();
		Browser.quitBrowser();
		Thread.sleep(5000);
	}

	public void verifyElementPresent(String strTrade, String strXpath) {
		try {
			boolean blnFind = GeneralUtil.waitUntilExists(strXpath, "xpath",
					GeneralUtil.dynamicTimeOut);
			if (blnFind)
				GeneralUtil.logger.info(strTrade
						+ " treeview item is displayed with given xpath: "
						+ strXpath);
			else
				GeneralUtil.logger.error(strTrade
						+ " treeview item is not displayed with given xpath: "
						+ strXpath);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			GeneralUtil.logger
					.error("Element is not displayed.Detailes are Locator:"
							+ strXpath + " LocatorType:xpath WaitTime:"
							+ GeneralUtil.dynamicTimeOut);
		}
	}

	public void isExpire(String expdate, String today) throws Exception {
		if (expdate.isEmpty() || expdate.trim().equals("")) {
			GeneralUtil.logger
					.error("Expected data and time variable is Emplty.");
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-mm-dd, hh:mm:ss a"); // Jan-20-2015 1:30:55 PM
			Date d = null;
			Date d1 = null;

			// String date = new
			// SimpleDateFormat("yyyy-mm-dd, hh:mm:ss a").format(expdate.toUpperCase());

			try {
				// System.out.println("expdate>> "+date);
				// System.out.println("today>> "+today+"\n\n");
				d = sdf.parse(expdate);
				d1 = sdf.parse(today);
				if (d1.compareTo(d) < 0) {// not expired
					GeneralUtil.logger.error("Displayed date and time:" + d
							+ " is not equal to system current time:" + d1);
				} else if (d.compareTo(d1) == 0) {// both date are same

				}
				if (d.getTime() == d1.getTime()) {// expired
					GeneralUtil.logger
							.info("Displayed date and time is equal to system current time");
				} else if (d.getTime() < d1.getTime()) {// not expired
					GeneralUtil.logger.info("Displayed date and time:" + d
							+ " is not equal to system current time:" + d1);
				} else {// expired
					GeneralUtil.logger.info("Displayed date and time:" + d
							+ " is greater then to system current time:" + d1);
				}
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
	}

	public String getToday(String format) {
		Date date = new Date();
		return new SimpleDateFormat(format).format(date);
	}

}
