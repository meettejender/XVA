package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.Browser;
import util.GeneralUtil;

public class Policies {
	
	public WebDriver driver;
	public int dynamicTimeOut;
	public String fileUploadPath = null;
	public String strNewPolicies = null;
	public String strEditPolicies = null;
	public String strClonePolicies = null;
	public String timeStamp = null;

	
	public String strmenu = null;

	@BeforeClass
	public void beforeClass() throws Exception {
		
		GeneralUtil.configureLog4j("Policies");
		GeneralUtil.logger("Policies");

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
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());;
		
		strmenu = "//div[@class='ag-menu']//span[@class='ag-menu-option-text']";
	}

	@Test(alwaysRun=true)
	public void policies_verifyPoliciesTabs() throws Exception {
		try {
			GeneralUtil.logger.info("Verify Policies Items");
			Reporter.log("Test Case: Verify Policies Items", 1, true);
			
			// Validating Policies Tab is expand or not and verify Policies
			// Data sub tabs
			if (driver
					.findElement(
							By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Market Policies']"))
					.isDisplayed()) {
				Reporter.log("Test Step: Verify Policies Item: Market Policies", 1, true);
				String strMarketPoliciesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Market Policies']";
				verifyElementPresent("Market Policies", strMarketPoliciesXpath, dynamicTimeOut);
				
				Reporter.log("Test Step: Verify Policies Item: Pricing Policies", 1, true);
				String strPricingPoliciesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Pricing Policies']";
				verifyElementPresent("Pricing Policies", strPricingPoliciesXpath, dynamicTimeOut);
				
				Reporter.log("Test Step: Verify Policies Item: Additional Policies", 1, true);
				String strAdditionalPoliciesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Additional Policies']";
				verifyElementPresent("Additional Policies",
						strAdditionalPoliciesXpath, dynamicTimeOut);
			}
			// Expand Policies Tab and verify Policies sub tabs
			else {
				driver.findElement(
						By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div/Strong[text()='Policies']"))
						.click();
				
				Reporter.log("Test Step: Verify Policies Item: Market Policies", 1, true);
				String strMarketPoliciesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Market Policies']";
				verifyElementPresent("Market Policies", strMarketPoliciesXpath, dynamicTimeOut);
				
				Reporter.log("Test Step: Verify Policies Item: Pricing Policies", 1, true);
				String strPricingPoliciesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Pricing Policies']";
				verifyElementPresent("Pricing Policies", strPricingPoliciesXpath, dynamicTimeOut);
				
				Reporter.log("Test Step: Verify Policies Item: Additional Policies", 1, true);
				String strAdditionalPoliciesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Additional Policies']";
				verifyElementPresent("Additional Policies",
						strAdditionalPoliciesXpath, dynamicTimeOut);
				
				Reporter.log("Test Case: Successfully Verified Policies Items", 1, true);
			}
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods ="policies_verifyPoliciesTabs", alwaysRun=true)
	public void policies_addMarketPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Add a Market Policies");
			Reporter.log("Test Case: Add Policies Market Policies", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Market Policies']"))
					.click();
			GeneralUtil.captureScreenshot();
			Thread.sleep(4000);

			// Add the Market Policies
			Reporter.log("Test Step: Click Add On Policies Market Policies From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Add");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Enter The Text On Name For Policies Market Policies", 1, true);
			WebElement objMarketPolicies = GeneralUtil
					.getElement(
							"//div[@class='react-draggable']//span[text()='Name']/following::input[1]",
							"xpath", dynamicTimeOut);
			strNewPolicies = "Auto" + timeStamp;
			objMarketPolicies.sendKeys(strNewPolicies);
			
			Reporter.log("Test Step: Select The MARKETPOLICY.DEFAULT On Template ID Dropdown Item", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'ReactModalPortal')]//div[starts-with(@class,'Select-control')]"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"MARKETPOLICY.DEFAULT", "Template ID");
			
			Reporter.log("Test Step: Click On OK Button For Market Policies Add Page", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			
			Reporter.log("Test Step: Select The Standard On Base Policy Dropdown Item", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'ReactTabs__TabPanel ReactTabs__TabPanel--selected')]/div/div[3]//div[starts-with(@class,'Select-control')]"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Standard", "Base Policy");
						
			Reporter.log("Test Step: Click On Save Button For Policies Market Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click On OK Button For Policies Market Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Verify Notification Displayed Update Market Policy", 1, true);
			Common.handleNotifications("Update Market Policy");
			
			Reporter.log("Test Step: Search Added Policies Market Policies", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(strNewPolicies);
			
			Reporter.log("Test Step: Verify Policies Market Policies Added", 1, true);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			String marketPoliciesNametext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			
			
			if (marketPoliciesNametext.equalsIgnoreCase(strNewPolicies)) {
				GeneralUtil.logger.info("Market Policies Name " + strNewPolicies+ " is available in the Market Policies");
			} else {
				GeneralUtil.logger.info("Market Policies Name " + strNewPolicies+ " is not available in the Market Policies");
			}
			Reporter.log("Test Case: Successfully Added Policies Market Policies", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Policies Added Successfully");
	}

	@Test(dependsOnMethods = { "policies_addMarketPolicies" })
	public void policies_editMarketPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Edit a Market Policies");
			Reporter.log("Test Case: Edit Policies Market Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Market Policies columns
					WebElement contextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Market Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(contextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(1000);
			
			// Search the added Market Policies
				Reporter.log("Test Step: Search Added Policies Market Policies", 1, true);
				WebElement SearchElement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys(strNewPolicies);

			// Click on added Market Policies
			Reporter.log("Test Step: Clicked on Added Policies Market Policies", 1, true);
			WebElement marketPoliciesElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			marketPoliciesElement.click();

			// Update the Market Policies name 
			Reporter.log("Test Step: Update The Added Policies Market Policies", 1, true);
			WebElement nameTextElement = driver
					.findElement(By
							.xpath("//div[@class='ReactTabs__TabPanel ReactTabs__TabPanel--selected']/div/div/div[2]/div/input"));
			nameTextElement.clear();
			strEditPolicies = "AutoEdit" + timeStamp;
			nameTextElement.sendKeys(strEditPolicies);
			
			
			Reporter.log("Test Step: Select The Standard On Base Policy Dropdown Item", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'ReactTabs__TabPanel ReactTabs__TabPanel--selected')]/div/div[3]//div[starts-with(@class,'Select-control')]"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Standard_NoIM", "Base Policy");
						
			Reporter.log("Test Step: Click On Save Button For Policies Market Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click On OK Button For Policies Market Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Verify Notification Displayed Save Market Policies", 1, true);
			Common.handleNotifications("Update Market Policy");
			
			// Search the added Market Policies
			Reporter.log("Test Step: Search Added Policies Market Policies", 1, true);
			WebElement SearchEditElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchEditElement.clear();
			SearchEditElement.sendKeys(strEditPolicies);
			
			Reporter.log("Test Step: Verify Policies Market Policies Edited", 1, true);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			String marketPoliciesNametext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			
			
			if (marketPoliciesNametext.equalsIgnoreCase(strEditPolicies)) {
				GeneralUtil.logger.info("Market Policies Name " + strEditPolicies+ " is available in the Market Policies");
			} else {
				GeneralUtil.logger.info("Market Policies Name " + strEditPolicies+ " is not available in the Market Policies");
			}
			Reporter.log("Test Case: Successfully Edited Policies Market Policies", 1, true);
			
			Reporter.log("Test Step: Click On Cancel Button For Policies Market Policies Subwindow", 1, true);
			//driver.findElement(By.xpath("//div[text() = 'Cancel']")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Policies Edited Successfully");

	}

	@Test(dependsOnMethods = { "policies_editMarketPolicies" })
	public void policies_cloneMarketPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Clone a Market Policies");
			Reporter.log("Test Case: Clone Policies Market Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Market Policies columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Market Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(1000);
			
			// Search the added Market Policies
				Reporter.log("Test Step: Search Edited Policies Market Policies", 1, true);
				WebElement SearchElement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys(strEditPolicies);

				// Clone the Market Policies
				Reporter.log("Test Step: Click Clone On Policies Market Policies From Context Menu", 1, true);
				WebElement contextMenuElement = driver
						.findElement(By
								.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
				GeneralUtil.contextMenu(contextMenuElement);
				GeneralUtil.captureScreenshot();
				GeneralUtil
						.contextMenuItem(
								".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
								"Clone");
				Thread.sleep(1000);
				
				Reporter.log("Test Step: Enter The Text On Name For Policies Market Policies", 1, true);
				WebElement objMarketPolicies = GeneralUtil
						.getElement(
								"//div[@class='react-draggable']//span[text()='Name']/following::input[1]",
								"xpath", dynamicTimeOut);
				strClonePolicies = "AutoClone" + timeStamp;
				objMarketPolicies.sendKeys(strClonePolicies);
				
				Reporter.log("Test Step: Click On OK Button For Market Policies Clone Page", 1, true);
				driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			
			Reporter.log("Test Step: Select The Standard On Base Policy Dropdown Item", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'ReactTabs__TabPanel ReactTabs__TabPanel--selected')]/div/div[3]//div[starts-with(@class,'Select-control')]"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Standard", "Base Policy");
						
			Reporter.log("Test Step: Click On Save Button For Policies Market Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click On OK Button For Policies Market Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Verify Notification Displayed Update Market Policy", 1, true);
			Common.handleNotifications("Update Market Policy");
			
			// Search the added Market Policies
			Reporter.log("Test Step: Search Cloned Policies Market Policies", 1, true);
			WebElement SearchEditElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchEditElement.clear();
			SearchEditElement.sendKeys(strClonePolicies);
			
			Reporter.log("Test Step: Verify Policies Market Policies Cloned", 1, true);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			String marketPoliciesNametext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			
			
			if (marketPoliciesNametext.equalsIgnoreCase(strClonePolicies)) {
				GeneralUtil.logger.info("Market Policies Name " + strClonePolicies+ " is available in the Market Policies");
			} else {
				GeneralUtil.logger.info("Market Policies Name " + strClonePolicies+ " is not available in the Market Policies");
			}
			Reporter.log("Test Case: Successfully Cloned Policies Market Policies", 1, true);
			
			Reporter.log("Test Step: Click On Cancel Button For Policies Market Policies Subwindow", 1, true);
			//driver.findElement(By.xpath("//div[text() = 'Cancel']")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Policies Cloned Successfully");

	}
	
	@Test(dependsOnMethods = { "policies_cloneMarketPolicies" })
	public void policies_deleteMarketPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Delete a Market Policies");
			Reporter.log("Test Case: Delete Policies Market Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Market Policies columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Market Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
			
			// Search the added Market Policies
				Reporter.log("Test Step: Search Added Policies Market Policies", 1, true);
				WebElement SearchElement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys(strNewPolicies);
				Thread.sleep(1000);
				// Delete the Market Policies
				Reporter.log("Test Step: Click Delete On Policies Market Policies From Context Menu", 1, true);
				WebElement contextMenuElement = driver
						.findElement(By
								.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
				GeneralUtil.contextMenu(contextMenuElement);
				GeneralUtil.captureScreenshot();
				GeneralUtil
						.contextMenuItem(
								".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
								"Delete");
				Thread.sleep(1000);
				
				Reporter.log("Test Step: Click On OK Button For Market Policies Clone Page", 1, true);
				driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			/*Reporter.log("Test Step: Verify Notification Displayed Deleted", 1, true);
			Common.handleNotifications("success");*/
			
			// Search the Edited Market Policies
			Reporter.log("Test Step: Search Edited Policies Market Policies", 1, true);
			WebElement SearchEditElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchEditElement.clear();
			SearchEditElement.sendKeys(strEditPolicies);
			Thread.sleep(1000);
			// Delete the Market Policies
			Reporter.log("Test Step: Click Delete On Policies Market Policies From Context Menu", 1, true);
			WebElement contextMenuEditElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuEditElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Delete");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Click On OK Button For Market Policies Clone Page", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
		
		/*Reporter.log("Test Step: Verify Notification Displayed Deleted", 1, true);
		Common.handleNotifications("success");*/
		
		// Search the Cloned Market Policies
					Reporter.log("Test Step: Search Cloned Policies Market Policies", 1, true);
					WebElement SearchCloneElement = driver
									.findElement(By
											.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
					SearchCloneElement.clear();
					SearchCloneElement.sendKeys(strClonePolicies);
					Thread.sleep(1000);
					// Delete the Market Policies
					Reporter.log("Test Step: Click Delete On Policies Market Policies From Context Menu", 1, true);
					WebElement contextMenuCloneElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
					GeneralUtil.contextMenu(contextMenuCloneElement);
					GeneralUtil.captureScreenshot();
					GeneralUtil
							.contextMenuItem(
									".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
									"Delete");
					Thread.sleep(1000);
					
					Reporter.log("Test Step: Click On OK Button For Market Policies Clone Page", 1, true);
					driver.findElement(By.xpath("//div[text() = 'OK']")).click();
				
				/*Reporter.log("Test Step: Verify Notification Displayed Deleted", 1, true);
				Common.handleNotifications("success");*/
		
				Reporter.log("Test Case: Successfully Deleted Policies Market Policies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Policies Deleted Successfully");

	}

	@Test(dependsOnMethods ="policies_deleteMarketPolicies" , alwaysRun=true)
	public void policies_uploadMarketPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Upload a Market Policies");
			Reporter.log("Test Case: Upload Policies Market Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Market Policies columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Market Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
			
				// Upload the Market Policies
				Reporter.log("Test Step: Click Delete On Policies Market Policies From Context Menu", 1, true);
				WebElement contextMenuElement = driver
						.findElement(By
								.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
				GeneralUtil.contextMenu(contextMenuElement);
				GeneralUtil.captureScreenshot();
				GeneralUtil
						.contextMenuItem(
								".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
								"CSV Upload");
				Thread.sleep(1000);
				
				Reporter.log("Test Step: Upload The 'Standard.csv' File", 1, true);
				GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\Data\\MarketPolicies\\Standard.csv");
				

				Thread.sleep(2000);
				Common.handleNotifications("Standard");
				GeneralUtil.logger.info("Market Policies uploaded successfully");
				Thread.sleep(1000);
				
				Reporter.log("Test Step: Search Uploaded Market Policies", 1, true);
				WebElement SearchElement = driver
						.findElement(By
								.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys("Standard");
				
				Thread.sleep(1000);
				GeneralUtil.captureScreenshot();

				// Validate the 'Standard.csv' is uploaded or not
				Reporter.log("Test Step: Verify The 'Standard.csv' Is Uploaded", 1, true);
				String marketPoliciesNametext = driver
						.findElement(
								By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
						.getText();

				if (marketPoliciesNametext.equalsIgnoreCase("Standard")) {
					GeneralUtil.logger.info("Uploaded Market Policies " + marketPoliciesNametext
							+ " is available in the Trade");
				} else {
					GeneralUtil.logger.error("Uploaded Market Policies " + marketPoliciesNametext
							+ " is not available in the Trade");
				}
				
			
			Reporter.log("Test Step: Verify Notification Displayed Standard", 1, true);
			
			
			Reporter.log("Test Case: Successfully Uploaded Policies Market Policies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Policies Uploaded Successfully");

	}
	
	@Test(dependsOnMethods = "policies_uploadMarketPolicies" , alwaysRun=true)
	public void policies_downloadMarketPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Download a Market Policies");
			Reporter.log("Test Case: Download Policies Market Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Market Policies columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Market Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
			
						// Download the trade and Validate "Market Policies(.*).zip" file download
						// or not
						Reporter.log("Test Step: Download The Market Policies And Verify The File Download", 1, true);
						Thread.sleep(2000);
						WebElement contextMenuelement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
						GeneralUtil.contextMenu(contextMenuelement);
						GeneralUtil.captureScreenshot();
						Common
								.download(
										"CSV Download",
										"Download All",
										"MarketPolicies(.*).zip",
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			
			Reporter.log("Test Case: Successfully Downloaded Policies Market Policies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Policies Downloaded Successfully");

	}
	
	@Test(dependsOnMethods =  "policies_downloadMarketPolicies" , alwaysRun=true)
	public void policies_exportMarketPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Export a Market Policies");
			Reporter.log("Test Case: Export Policies Market Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Market Policies columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Market Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
			
						
						Reporter.log("Test Step: Right Click On The Element", 1, true);
						WebElement contextMenuelement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
						GeneralUtil.contextMenu(contextMenuelement);
						GeneralUtil.captureScreenshot();
						
						Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
						Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
								strmenu);
						GeneralUtil.logger
								.info("Market Policies CSV Exported successfully");
						
						Thread.sleep(1000);
						GeneralUtil.captureScreenshot();
						
						Reporter.log("Test Step: Right Click On The Element", 1, true);
						WebElement contextMenuExcelelement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
						GeneralUtil.contextMenu(contextMenuExcelelement);
						GeneralUtil.captureScreenshot();
						Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
						Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
								strmenu);
						GeneralUtil.logger
								.info("Market Policies Excel Exported successfully");
						
						
			
			Reporter.log("Test Case: Successfully Exported Policies Market Policies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Policies Exported Successfully");

	}
	
	@Test(dependsOnMethods ="policies_exportMarketPolicies", alwaysRun=true)
	public void policies_addPricingPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Add a Pricing Policies");
			Reporter.log("Test Case: Add Policies Pricing Policies", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Pricing Policies']"))
					.click();
			GeneralUtil.captureScreenshot();
			Thread.sleep(4000);

			// Add the Pricing Policies
			Reporter.log("Test Step: Click Add On Policies Pricing Policies From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Add");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Enter The Text On Name For Policies Pricing Policies", 1, true);
			WebElement objpricingPolicies = GeneralUtil
					.getElement(
							"//div[@class='react-draggable']//span[text()='Name']/following::input[1]",
							"xpath", dynamicTimeOut);
			strNewPolicies = "Auto" + timeStamp;
			objpricingPolicies.sendKeys(strNewPolicies);
			
			Reporter.log("Test Step: Select The PRICINGPOLICY.DEFAULT On Template ID Dropdown Item", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'ReactModalPortal')]//div[starts-with(@class,'Select-control')]"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"PRICINGPOLICY.DEFAULT", "Template ID");
			
			Reporter.log("Test Step: Click On OK Button For Pricing Policies Add Page", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			
			Reporter.log("Test Step: Select The Standard On Base Policy Dropdown Item", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'ReactTabs__TabPanel ReactTabs__TabPanel--selected')]/div/div[3]//div[starts-with(@class,'Select-control')]"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Standard", "Base Policy");
						
			Reporter.log("Test Step: Click On Save Button For Policies Pricing Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click On OK Button For Policies Pricing Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			
			
			Reporter.log("Test Step: Verify Notification Displayed Update Pricing Policy", 1, true);
			Common.handleNotifications("Update Pricing Policy");
			
			Reporter.log("Test Step: Search Added Policies Pricing Policies", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(strNewPolicies);
			
			Reporter.log("Test Step: Verify Policies Pricing Policies Added", 1, true);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			String pricingPoliciesNametext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			
			
			if (pricingPoliciesNametext.equalsIgnoreCase(strNewPolicies)) {
				GeneralUtil.logger.info("Pricing Policies Name " + strNewPolicies+ " is available in the Pricing Policies");
			} else {
				GeneralUtil.logger.info("Pricing Policies Name " + strNewPolicies+ " is not available in the Pricing Policies");
			}
			Reporter.log("Test Case: Successfully Added Policies Pricing Policies", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Pricing Policies Added Successfully");
	}
	
	@Test(dependsOnMethods = { "policies_addPricingPolicies" })
	public void policies_editPricingPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Edit a Pricing Policies");
			Reporter.log("Test Case: Edit Policies Pricing Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Pricing Policies columns
					WebElement contextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Pricing Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(contextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(1000);
			
			// Search the added Pricing Policies
				Reporter.log("Test Step: Search Added Policies Pricing Policies", 1, true);
				WebElement SearchElement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys(strNewPolicies);

			// Click on added Pricing Policies
			Reporter.log("Test Step: Clicked on Added Policies Pricing Policies", 1, true);
			WebElement pricingPoliciesElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			pricingPoliciesElement.click();

			// Update the Pricing Policies name 
			Reporter.log("Test Step: Update The Added Policies Pricing Policies", 1, true);
			WebElement nameTextElement = driver
					.findElement(By
							.xpath("//div[@class='ReactTabs__TabPanel ReactTabs__TabPanel--selected']/div/div/div[2]/div/input"));
			nameTextElement.clear();
			strEditPolicies = "AutoEdit" + timeStamp;
			nameTextElement.sendKeys(strEditPolicies);
			
			
			Reporter.log("Test Step: Select The Standard On Base Policy Dropdown Item", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'ReactTabs__TabPanel ReactTabs__TabPanel--selected')]/div/div[3]//div[starts-with(@class,'Select-control')]"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Exposure", "Base Policy");
						
			Reporter.log("Test Step: Click On Save Button For Policies Pricing Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click On OK Button For Policies Pricing Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Verify Notification Displayed Save Pricing Policies", 1, true);
			Common.handleNotifications("Update Pricing Policy");
			
			// Search the added Pricing Policies
			Reporter.log("Test Step: Search Added Policies Pricing Policies", 1, true);
			WebElement SearchEditElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchEditElement.clear();
			SearchEditElement.sendKeys(strEditPolicies);
			
			Reporter.log("Test Step: Verify Policies Pricing Policies Edited", 1, true);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			String pricingPoliciesNametext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			
			
			if (pricingPoliciesNametext.equalsIgnoreCase(strEditPolicies)) {
				GeneralUtil.logger.info("Pricing Policies Name " + strEditPolicies+ " is available in the Pricing Policies");
			} else {
				GeneralUtil.logger.info("Pricing Policies Name " + strEditPolicies+ " is not available in the Pricing Policies");
			}
			Reporter.log("Test Case: Successfully Edited Policies Pricing Policies", 1, true);
			
			Reporter.log("Test Step: Click On Cancel Button For Policies Pricing Policies Subwindow", 1, true);
			//driver.findElement(By.xpath("//div[text() = 'Cancel']")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Pricing Policies Edited Successfully");

	}
	
	@Test(dependsOnMethods = { "policies_editPricingPolicies" })
	public void policies_clonePricingPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Clone a Pricing Policies");
			Reporter.log("Test Case: Clone Policies Pricing Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Pricing Policies columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Pricing Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(1000);
			
			// Search the added Pricing Policies
				Reporter.log("Test Step: Search Edited Policies Pricing Policies", 1, true);
				WebElement SearchElement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys(strEditPolicies);

				// Clone the Pricing Policies
				Reporter.log("Test Step: Click Clone On Policies Pricing Policies From Context Menu", 1, true);
				WebElement contextMenuElement = driver
						.findElement(By
								.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
				GeneralUtil.contextMenu(contextMenuElement);
				GeneralUtil.captureScreenshot();
				GeneralUtil
						.contextMenuItem(
								".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
								"Clone");
				Thread.sleep(1000);
				
				Reporter.log("Test Step: Enter The Text On Name For Policies Pricing Policies", 1, true);
				WebElement objpricingPolicies = GeneralUtil
						.getElement(
								"//div[@class='react-draggable']//span[text()='Name']/following::input[1]",
								"xpath", dynamicTimeOut);
				strClonePolicies = "AutoClone" + timeStamp;
				objpricingPolicies.sendKeys(strClonePolicies);
				
				Reporter.log("Test Step: Click On OK Button For Pricing Policies Clone Page", 1, true);
				driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			
			Reporter.log("Test Step: Select The Standard On Base Policy Dropdown Item", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'ReactTabs__TabPanel ReactTabs__TabPanel--selected')]/div/div[3]//div[starts-with(@class,'Select-control')]"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Standard", "Base Policy");
						
			Reporter.log("Test Step: Click On Save Button For Policies Pricing Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click On OK Button For Policies Pricing Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			
			
			Reporter.log("Test Step: Verify Notification Displayed Update Pricing Policy", 1, true);
			Common.handleNotifications("Update Pricing Policy");
			
			// Search the added Pricing Policies
			Reporter.log("Test Step: Search Cloned Policies Pricing Policies", 1, true);
			WebElement SearchEditElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchEditElement.clear();
			SearchEditElement.sendKeys(strClonePolicies);
			
			Reporter.log("Test Step: Verify Policies Pricing Policies Cloned", 1, true);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			String pricingPoliciesNametext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			
			
			if (pricingPoliciesNametext.equalsIgnoreCase(strClonePolicies)) {
				GeneralUtil.logger.info("Pricing Policies Name " + strClonePolicies+ " is available in the Pricing Policies");
			} else {
				GeneralUtil.logger.info("Pricing Policies Name " + strClonePolicies+ " is not available in the Pricing Policies");
			}
			Reporter.log("Test Case: Successfully Cloned Policies Pricing Policies", 1, true);
			
			Reporter.log("Test Step: Click On Cancel Button For Policies Pricing Policies Subwindow", 1, true);
			//driver.findElement(By.xpath("//div[text() = 'Cancel']")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Pricing Policies Cloned Successfully");

	}
	
	@Test(dependsOnMethods = { "policies_clonePricingPolicies" })
	public void policies_deletePricingPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Delete a Pricing Policies");
			Reporter.log("Test Case: Delete Policies Pricing Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Pricing Policies columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Pricing Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
			
			// Search the added Pricing Policies
				Reporter.log("Test Step: Search Added Policies Pricing Policies", 1, true);
				WebElement SearchElement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys(strNewPolicies);
				Thread.sleep(1000);
				// Delete the Pricing Policies
				Reporter.log("Test Step: Click Delete On Policies Pricing Policies From Context Menu", 1, true);
				WebElement contextMenuElement = driver
						.findElement(By
								.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
				GeneralUtil.contextMenu(contextMenuElement);
				GeneralUtil.captureScreenshot();
				GeneralUtil
						.contextMenuItem(
								".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
								"Delete");
				Thread.sleep(1000);
				
				Reporter.log("Test Step: Click On OK Button For Pricing Policies Clone Page", 1, true);
				driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			/*Reporter.log("Test Step: Verify Notification Displayed Deleted", 1, true);
			Common.handleNotifications("success");*/
			
			// Search the Edited Pricing Policies
			Reporter.log("Test Step: Search Edited Policies Pricing Policies", 1, true);
			WebElement SearchEditElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchEditElement.clear();
			SearchEditElement.sendKeys(strEditPolicies);
			Thread.sleep(1000);
			// Delete the Pricing Policies
			Reporter.log("Test Step: Click Delete On Policies Pricing Policies From Context Menu", 1, true);
			WebElement contextMenuEditElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuEditElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Delete");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Click On OK Button For Pricing Policies Clone Page", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
		
		/*Reporter.log("Test Step: Verify Notification Displayed Deleted", 1, true);
		Common.handleNotifications("success");*/
		
		// Search the Cloned Pricing Policies
					Reporter.log("Test Step: Search Cloned Policies Pricing Policies", 1, true);
					WebElement SearchCloneElement = driver
									.findElement(By
											.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
					SearchCloneElement.clear();
					SearchCloneElement.sendKeys(strClonePolicies);
					Thread.sleep(1000);
					// Delete the pricing Policies
					Reporter.log("Test Step: Click Delete On Policies Pricing Policies From Context Menu", 1, true);
					WebElement contextMenuCloneElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
					GeneralUtil.contextMenu(contextMenuCloneElement);
					GeneralUtil.captureScreenshot();
					GeneralUtil
							.contextMenuItem(
									".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
									"Delete");
					Thread.sleep(1000);
					
					Reporter.log("Test Step: Click On OK Button For Pricing Policies Clone Page", 1, true);
					driver.findElement(By.xpath("//div[text() = 'OK']")).click();
				
				/*Reporter.log("Test Step: Verify Notification Displayed Deleted", 1, true);
				Common.handleNotifications("success");*/
		
				Reporter.log("Test Case: Successfully Deleted Policies Pricing Policies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Pricing Policies Deleted Successfully");

	}
	
	@Test(dependsOnMethods ="policies_deletePricingPolicies" , alwaysRun=true)
	public void policies_uploadPricingPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Upload a Pricing Policies");
			Reporter.log("Test Case: Upload Policies Pricing Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Pricing Policies columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Pricing Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
			
				// Upload the Pricing Policies
				Reporter.log("Test Step: Click Delete On Policies Pricing Policies From Context Menu", 1, true);
				WebElement contextMenuElement = driver
						.findElement(By
								.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
				GeneralUtil.contextMenu(contextMenuElement);
				GeneralUtil.captureScreenshot();
				GeneralUtil
						.contextMenuItem(
								".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
								"CSV Upload");
				Thread.sleep(1000);
				
				Reporter.log("Test Step: Upload The 'Standard.csv' File", 1, true);
				GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\Data\\PricingPolicies\\Standard.csv");
				

				Thread.sleep(2000);
				Common.handleNotifications("Standard");
				GeneralUtil.logger.info("Pricing Policies uploaded successfully");
				Thread.sleep(1000);
				
				Reporter.log("Test Step: Search Uploaded Pricing Policies", 1, true);
				WebElement SearchElement = driver
						.findElement(By
								.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys("Standard");
				
				Thread.sleep(1000);
				GeneralUtil.captureScreenshot();

				// Validate the 'Standard.csv' is uploaded or not
				Reporter.log("Test Step: Verify The 'Standard.csv' Is Uploaded", 1, true);
				String pricingPoliciesNametext = driver
						.findElement(
								By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
						.getText();

				if (pricingPoliciesNametext.equalsIgnoreCase("Standard")) {
					GeneralUtil.logger.info("Uploaded Pricing Policies " + pricingPoliciesNametext
							+ " is available in the Trade");
				} else {
					GeneralUtil.logger.error("Uploaded Pricing Policies " + pricingPoliciesNametext
							+ " is not available in the Trade");
				}
				
			
			Reporter.log("Test Step: Verify Notification Displayed Standard", 1, true);
			
			
			Reporter.log("Test Case: Successfully Uploaded Policies Pricing Policies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Pricing Policies Uploaded Successfully");

	}
	
	@Test(dependsOnMethods =  "policies_uploadPricingPolicies" , alwaysRun=true)
	public void policies_downloadPricingPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Download a Pricing Policies");
			Reporter.log("Test Case: Download Policies Pricing Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Pricing Policies columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Pricing Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
			
						// Download the trade and Validate "Pricing Policies(.*).zip" file download
						// or not
						Reporter.log("Test Step: Download The Pricing Policies And Verify The File Download", 1, true);
						Thread.sleep(2000);
						WebElement contextMenuelement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
						GeneralUtil.contextMenu(contextMenuelement);
						GeneralUtil.captureScreenshot();
						Common
								.download(
										"CSV Download",
										"Download All",
										"PricingPolicies(.*).zip",
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			
			Reporter.log("Test Case: Successfully Downloaded Policies Pricing Policies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Pricing Policies Downloaded Successfully");

	}
	
	@Test(dependsOnMethods = "policies_downloadPricingPolicies" , alwaysRun=true)
	public void policies_exportPricingPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Export a Pricing Policies");
			Reporter.log("Test Case: Export Policies Pricing Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Pricing Policies columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Pricing Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
			
						
						Reporter.log("Test Step: Right Click On The Element", 1, true);
						WebElement contextMenuelement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
						GeneralUtil.contextMenu(contextMenuelement);
						GeneralUtil.captureScreenshot();
						
						Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
						Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
								strmenu);
						GeneralUtil.logger
								.info("Pricing Policies CSV Exported successfully");
						
						Thread.sleep(1000);
						GeneralUtil.captureScreenshot();
						
						Reporter.log("Test Step: Right Click On The Element", 1, true);
						WebElement contextMenuExcelelement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
						GeneralUtil.contextMenu(contextMenuExcelelement);
						GeneralUtil.captureScreenshot();
						Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
						Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
								strmenu);
						GeneralUtil.logger
								.info("Pricing Policies Excel Exported successfully");
						
						
			
			Reporter.log("Test Case: Successfully Exported Policies Pricing Policies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Pricing Policies Exported Successfully");

	}
	
	@Test(dependsOnMethods ="policies_exportPricingPolicies", alwaysRun=true)
	public void policies_addAdditionalPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Add a Additional Policies");
			Reporter.log("Test Case: Add Additional Pricing Policies", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Additional Policies']"))
					.click();
			GeneralUtil.captureScreenshot();
			Thread.sleep(4000);

			// Add the Additional Policies
			Reporter.log("Test Step: Click Add On Policies Additional Policies From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Add");
			Thread.sleep(3000);
			
			Reporter.log("Test Step: Enter The Text On Name For Policies Additional Policies", 1, true);
			WebElement objadditionalPolicies = GeneralUtil
					.getElement(
							"//div[@class='react-draggable']//span[text()='Name']/following::input[1]",
							"xpath", dynamicTimeOut);
			strNewPolicies = "Auto" + timeStamp;
			objadditionalPolicies.sendKeys(strNewPolicies);
			
			Reporter.log("Test Step: Select The POLICY.REGULATORYPOLICY.DEFAULT On Template ID Dropdown Item", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'ReactModalPortal')]//div[starts-with(@class,'Select-control')]"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"POLICY.REGULATORYPOLICY.DEFAULT", "Template ID");
			
			Reporter.log("Test Step: Click On OK Button For Additional Policies Add Page", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			
			Reporter.log("Test Step: Click On Save Button For Policies Additional Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click On OK Button For Policies Additional Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			
			
			Reporter.log("Test Step: Verify Notification Displayed Update Additional Policy", 1, true);
			Common.handleNotifications("Update Additional Policy");
			
			Reporter.log("Test Step: Search Added Policies Additional Policies", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(strNewPolicies);
			
			Reporter.log("Test Step: Verify Policies Additional Policies Added", 1, true);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			String additionalPoliciesNametext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			
			
			if (additionalPoliciesNametext.equalsIgnoreCase(strNewPolicies)) {
				GeneralUtil.logger.info("Additional Policies Name " + strNewPolicies+ " is available in the Additional Policies");
			} else {
				GeneralUtil.logger.info("Additional Policies Name " + strNewPolicies+ " is not available in the Additional Policies");
			}
			Reporter.log("Test Case: Successfully Added Policies Additional Policies", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Additional Policies Added Successfully");
	}
	
	@Test(dependsOnMethods = { "policies_addAdditionalPolicies" })
	public void policies_editAdditionalPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Edit a Additional Policies");
			Reporter.log("Test Case: Edit Additional Pricing Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Additional Policies columns
					WebElement contextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Additional Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(contextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(1000);
			
			// Search the added Additional Policies
				Reporter.log("Test Step: Search Added Policies Additional Policies", 1, true);
				WebElement SearchElement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys(strNewPolicies);

			// Click on added Additional Policies
			Reporter.log("Test Step: Clicked on Added Policies Additional Policies", 1, true);
			WebElement pricingPoliciesElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			pricingPoliciesElement.click();

			// Update the Additional Policies name 
			Reporter.log("Test Step: Update The Added Policies Additional Policies", 1, true);
			WebElement nameTextElement = driver
					.findElement(By
							.xpath("//div[@class='ReactTabs__TabPanel ReactTabs__TabPanel--selected']/div/div/div[2]/div/input"));
			nameTextElement.clear();
			strEditPolicies = "AutoEdit" + timeStamp;
			nameTextElement.sendKeys(strEditPolicies);
									
			Reporter.log("Test Step: Click On Save Button For Policies Additional Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click On OK Button For Policies Additional Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Verify Notification Displayed Save Additional Policies", 1, true);
			Common.handleNotifications("Update Additional Policy");
			
			// Search the added Additional Policies
			Reporter.log("Test Step: Search Added Policies Additional Policies", 1, true);
			WebElement SearchEditElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchEditElement.clear();
			SearchEditElement.sendKeys(strEditPolicies);
			
			Reporter.log("Test Step: Verify Policies Additional Policies Edited", 1, true);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			String additionalPoliciesNametext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			
			
			if (additionalPoliciesNametext.equalsIgnoreCase(strEditPolicies)) {
				GeneralUtil.logger.info("Additional Policies Name " + strEditPolicies+ " is available in the Additional Policies");
			} else {
				GeneralUtil.logger.info("Additional Policies Name " + strEditPolicies+ " is not available in the Additional Policies");
			}
			Reporter.log("Test Case: Successfully Edited Policies Additional Policies", 1, true);
			
			Reporter.log("Test Step: Click On Cancel Button For Policies Additional Policies Subwindow", 1, true);
			//driver.findElement(By.xpath("//div[text() = 'Cancel']")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Additional Policies Edited Successfully");

	}
	
	@Test(dependsOnMethods = { "policies_editAdditionalPolicies" })
	public void policies_cloneAdditionalPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Clone a Additional Policies");
			Reporter.log("Test Case: Clone Policies Additional Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Additional Policies columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Additional Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(1000);
			
			// Search the added Additional Policies
				Reporter.log("Test Step: Search Edited Policies Additional Policies", 1, true);
				WebElement SearchElement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys(strEditPolicies);

				// Clone the Additional Policies
				Reporter.log("Test Step: Click Clone On Policies Additional Policies From Context Menu", 1, true);
				WebElement contextMenuElement = driver
						.findElement(By
								.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
				GeneralUtil.contextMenu(contextMenuElement);
				GeneralUtil.captureScreenshot();
				GeneralUtil
						.contextMenuItem(
								".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
								"Clone");
				Thread.sleep(1000);
				
				Reporter.log("Test Step: Enter The Text On Name For Policies Additional Policies", 1, true);
				WebElement objMarketPolicies = GeneralUtil
						.getElement(
								"//div[@class='react-draggable']//span[text()='Name']/following::input[1]",
								"xpath", dynamicTimeOut);
				strClonePolicies = "AutoClone" + timeStamp;
				objMarketPolicies.sendKeys(strClonePolicies);
				
				Reporter.log("Test Step: Click On OK Button For Additional Policies Clone Page", 1, true);
				driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			
			Reporter.log("Test Step: Click On Save Button For Policies Additional Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click On OK Button For Policies Additional Policies Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			
			
			Reporter.log("Test Step: Verify Notification Displayed Update Additional Policy", 1, true);
			Common.handleNotifications("Update Additional Policy");
			
			// Search the added Additional Policies
			Reporter.log("Test Step: Search Cloned Policies Additional Policies", 1, true);
			WebElement SearchEditElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchEditElement.clear();
			SearchEditElement.sendKeys(strClonePolicies);
			
			Reporter.log("Test Step: Verify Policies Additional Policies Cloned", 1, true);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			String additionalPoliciesNametext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			
			
			if (additionalPoliciesNametext.equalsIgnoreCase(strClonePolicies)) {
				GeneralUtil.logger.info("Additional Policies Name " + strClonePolicies+ " is available in the Additional Policies");
			} else {
				GeneralUtil.logger.info("Additional Policies Name " + strClonePolicies+ " is not available in the Additional Policies");
			}
			Reporter.log("Test Case: Successfully Cloned Policies Additional Policies", 1, true);
			
			Reporter.log("Test Step: Click On Cancel Button For Policies Additional Policies Subwindow", 1, true);
			//driver.findElement(By.xpath("//div[text() = 'Cancel']")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Additional Policies Cloned Successfully");

	}
	
	@Test(dependsOnMethods = { "policies_cloneAdditionalPolicies" })
	public void policies_deleteAdditionalPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Delete a Additional Policies");
			Reporter.log("Test Case: Delete Policies dditional Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Additional Policies columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Additional Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
			
			// Search the added Additional Policies
				Reporter.log("Test Step: Search Added Policies Additional Policies", 1, true);
				WebElement SearchElement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys(strNewPolicies);
				Thread.sleep(1000);
				// Delete the Additional Policies
				Reporter.log("Test Step: Click Delete On Policies Additional Policies From Context Menu", 1, true);
				WebElement contextMenuElement = driver
						.findElement(By
								.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
				GeneralUtil.contextMenu(contextMenuElement);
				GeneralUtil.captureScreenshot();
				GeneralUtil
						.contextMenuItem(
								".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
								"Delete");
				Thread.sleep(1000);
				
				Reporter.log("Test Step: Click On OK Button For Additional Policies Clone Page", 1, true);
				driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			/*Reporter.log("Test Step: Verify Notification Displayed Deleted", 1, true);
			Common.handleNotifications("success");*/
			
			// Search the Edited Additional Policies
			Reporter.log("Test Step: Search Edited Policies Additional Policies", 1, true);
			WebElement SearchEditElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchEditElement.clear();
			SearchEditElement.sendKeys(strEditPolicies);
			Thread.sleep(1000);
			// Delete the Additional Policies
			Reporter.log("Test Step: Click Delete On Policies Additional Policies From Context Menu", 1, true);
			WebElement contextMenuEditElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuEditElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Delete");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Click On OK Button For Additional Policies Clone Page", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
		
		/*Reporter.log("Test Step: Verify Notification Displayed Deleted", 1, true);
		Common.handleNotifications("success");*/
		
		// Search the Cloned Additional Policies
					Reporter.log("Test Step: Search Cloned Policies Additional Policies", 1, true);
					WebElement SearchCloneElement = driver
									.findElement(By
											.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
					SearchCloneElement.clear();
					SearchCloneElement.sendKeys(strClonePolicies);
					Thread.sleep(1000);
					// Delete the Additional Policies
					Reporter.log("Test Step: Click Delete On Policies Additional Policies From Context Menu", 1, true);
					WebElement contextMenuCloneElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
					GeneralUtil.contextMenu(contextMenuCloneElement);
					GeneralUtil.captureScreenshot();
					GeneralUtil
							.contextMenuItem(
									".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
									"Delete");
					Thread.sleep(1000);
					
					Reporter.log("Test Step: Click On OK Button For Additional Policies Clone Page", 1, true);
					driver.findElement(By.xpath("//div[text() = 'OK']")).click();
				
				/*Reporter.log("Test Step: Verify Notification Displayed Deleted", 1, true);
				Common.handleNotifications("success");*/
		
				Reporter.log("Test Case: Successfully Deleted Additional Pricing Policies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Additional Policies Deleted Successfully");

	}
	
	@Test(dependsOnMethods = "policies_deleteAdditionalPolicies" , alwaysRun=true)
	public void policies_uploadAdditionalPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Upload a Additional Policies");
			Reporter.log("Test Case: Upload Policies Additional Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Additional Policies columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Additional Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
			
				// Upload the Additional Policies
				Reporter.log("Test Step: Click Upload On Policies Additional Policies From Context Menu", 1, true);
				WebElement contextMenuElement = driver
						.findElement(By
								.xpath(".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div"));
				GeneralUtil.contextMenu(contextMenuElement);
				GeneralUtil.captureScreenshot();
				GeneralUtil
						.contextMenuItem(
								".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
								"CSV Upload");
				Thread.sleep(1000);
				
				Reporter.log("Test Step: Upload The 'StandardRegulatoryPolicy.csv' File", 1, true);
				GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\Data\\Policies\\StandardRegulatoryPolicy.csv");
				

				Thread.sleep(2000);
				GeneralUtil.logger.info("Additional Policies uploaded successfully");
				Thread.sleep(1000);
				
				Reporter.log("Test Step: Search Uploaded Additional Policies", 1, true);
				WebElement SearchElement = driver
						.findElement(By
								.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys("StandardRegulatoryPolicy");
				
				Thread.sleep(1000);
				GeneralUtil.captureScreenshot();

				
				Reporter.log("Test Step: Verify The 'StandardRegulatoryPolicy.csv' Is Uploaded", 1, true);
				String additionalPoliciesNametext = driver
						.findElement(
								By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
						.getText();

				if (additionalPoliciesNametext.equalsIgnoreCase("StandardRegulatoryPolicy")) {
					GeneralUtil.logger.info("Uploaded Additional Policies " + additionalPoliciesNametext
							+ " is available in the Trade");
				} else {
					GeneralUtil.logger.error("Uploaded Additional Policies " + additionalPoliciesNametext
							+ " is not available in the Trade");
				}
				
			
			Reporter.log("Test Step: Verify Notification Displayed Standard", 1, true);
			//Common.handleNotifications("1");
			
			Reporter.log("Test Case: Successfully Uploaded Policies Additional Policies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Additional Policies Uploaded Successfully");

	}
	
	@Test(dependsOnMethods = "policies_uploadAdditionalPolicies" , alwaysRun=true)
	public void policies_downloadAdditionalPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Download a Additional Policies");
			Reporter.log("Test Case: Download Policies Additional Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Additional Policies columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Additional Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
			
						// Download the trade and Validate "StandardRegulatoryPolicy.csv" file download
						// or not
						Reporter.log("Test Step: Download The Additional Policies And Verify The File Download", 1, true);
						Thread.sleep(2000);
						WebElement contextMenuelement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
						GeneralUtil.contextMenu(contextMenuelement);
						GeneralUtil.captureScreenshot();
						Common
								.download(
										"CSV Download",
										"Download All",
										"StandardRegulatoryPolicy(.*).csv",
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			
			Reporter.log("Test Case: Successfully Downloaded Policies Additional Policies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Additional Policies Downloaded Successfully");

	}
	
	@Test(dependsOnMethods = "policies_downloadAdditionalPolicies" , alwaysRun=true)
	public void policies_exportAdditionalPolicies() throws Exception {
		try {
			GeneralUtil.logger.info("Export a Pricing Policies");
			Reporter.log("Test Case: Export Policies Pricing Policies", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Additional Policies columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Additional Policies Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
			
						
						Reporter.log("Test Step: Right Click On The Element", 1, true);
						WebElement contextMenuelement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
						GeneralUtil.contextMenu(contextMenuelement);
						GeneralUtil.captureScreenshot();
						
						Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
						Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
								strmenu);
						GeneralUtil.logger
								.info("Additional Policies CSV Exported successfully");
						
						Thread.sleep(1000);
						GeneralUtil.captureScreenshot();
						
						Reporter.log("Test Step: Right Click On The Element", 1, true);
						WebElement contextMenuExcelelement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
						GeneralUtil.contextMenu(contextMenuExcelelement);
						GeneralUtil.captureScreenshot();
						Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
						Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
								strmenu);
						GeneralUtil.logger
								.info("Additional Policies Excel Exported successfully");
						
						
			
			Reporter.log("Test Case: Successfully Exported Policies Additional Policies", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Additional Policies Exported Successfully");

	}
		
	@AfterClass
	public void afterClass() throws Exception {
		Thread.sleep(3000);
		Common.loginOffXVA();
		Browser.quitBrowser();
		Thread.sleep(2000);
	}

	public void verifyElementPresent(String strTrade, String strXpath,
			int timeOut) {
		try {
			boolean blnFind = GeneralUtil.waitUntilExists(strXpath, "xpath",
					timeOut);
			if (blnFind)
				GeneralUtil.logger.info(strTrade
						+ " Policies item is displayed with given xpath: "
						+ strXpath);
			else
				GeneralUtil.logger
						.error(strTrade
								+ " Policies item is not displayed with given xpath: "
								+ strXpath);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			GeneralUtil.logger
					.error("Element is not displayed.Detailes are Locator:"
							+ strXpath + " LocatorType:xpath WaitTime:"
							+ timeOut);
		}
	}
	
	public boolean waitUntilExists(String object, String accessBy,
			int timeOut) throws InterruptedException {
		boolean result = false;
		//Mode accessBy = Mode.valueOf(mode);
		int count = 1;
		while (count < timeOut) {
				if (driver.findElement(By.xpath(object)) != null) {
					result = true;
					count = 200;
				}
			count++;
		}
		return result;
	}
	
	public boolean handleNotifications(String expMessage)
			throws Exception {
		
		boolean blnFind = waitUntilExists("//div[@class='notifications-wrapper']//h4//following-sibling::div[@class='notification-message']",
				"xpath", 3000);
		
		WebElement objNotificationsTest = GeneralUtil
				.getElement(
						"//div[@class='notifications-wrapper']//h4//following-sibling::div[@class='notification-message']",
						"xpath", 3000);
		String strnotifications = objNotificationsTest.getText();
		WebElement objNotificationsH4 = GeneralUtil.getElement(
				"//div[@class='notifications-wrapper']//h4", "xpath",
				30);
		strnotifications = objNotificationsH4.getText() + ":"
				+ strnotifications;
		if (strnotifications.contains(expMessage)) {

			GeneralUtil.logger.info("Displayed notifications is :"
					+ strnotifications);
			GeneralUtil.captureScreenshot();
			// Thread.sleep(1000);
			try {

				WebElement notificationCloseButton = driver.findElement(By
								.xpath("//div[@class='notifications-wrapper']//h4//following-sibling::span[@class='notification-dismiss']"));
				System.out.println("Start");
				if (notificationCloseButton.isDisplayed()) {
					notificationCloseButton.click();

				}
			} catch (Exception e) {

				return true;
			}
			return true;
		} else {
			GeneralUtil.logger.info(expMessage
					+ " is not displayed in notification");
			return false;
		}
	}
		
	public String addDaysToTodayDate(int days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		

		String formatted = format1.format(cal.getTime());
		return formatted;
		
	}
}
