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

public class SensitivitiesMarketScenarios {
	
	public WebDriver driver;
	public int dynamicTimeOut;
	public String fileUploadPath = null;
	public String strNewSensitivitiesMarketScenarios = null;
	public String strEditSensitivitiesMarketScenarios = null;
	public String strCloneSensitivitiesMarketScenarios = null;
	public String timeStamp = null;

	
	public String strmenu = null;

	@BeforeClass
	public void beforeClass() throws Exception {
		
		GeneralUtil.configureLog4j("SensitivitiesMarketScenarios");
		GeneralUtil.logger("SensitivitiesMarketScenarios");

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
	public void SensitivitiesMarketScenarios_verifySensitivitiesMarketScenariosTabs() throws Exception {
		try {
			GeneralUtil.logger.info("Verify SensitivitiesMarketScenarios Items");
			Reporter.log("Test Case: Verify SensitivitiesMarketScenarios Items", 1, true);
			
			// Validating Policies Tab is expand or not and verify Policies
			// Data sub tabs
			if (driver
					.findElement(
							By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Market Reports']"))
					.isDisplayed()) {
				Reporter.log("Test Step: Verify Policies Item: Market Reports", 1, true);
				String strMarketReportsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Market Reports']";
				verifyElementPresent("Market Reports", strMarketReportsXpath, dynamicTimeOut);
				
							}
			// Expand Policies Tab and verify Policies sub tabs
			else {
				driver.findElement(
						By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div/Strong[text()='Sensitivities & Market Scenarios']"))
						.click();
				
				Reporter.log("Test Step: Verify Policies Item: Market Reports", 1, true);
				String strMarketReportsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Market Reports']";
				verifyElementPresent("Market Reports", strMarketReportsXpath, dynamicTimeOut);
				
				Reporter.log("Test Case: Successfully Verified Sensitivities & Market Scenarios Items", 1, true);
			}
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods ="SensitivitiesMarketScenarios_verifySensitivitiesMarketScenariosTabs", alwaysRun=true)
	public void SensitivitiesMarketScenarios_addMarketReports() throws Exception {
		try {
			GeneralUtil.logger.info("Add a Market Reports");
			Reporter.log("Test Case: Add Sensitivities & Market Scenarios Market Reports", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Market Reports']"))
					.click();
			GeneralUtil.captureScreenshot();
			Thread.sleep(4000);

			// Add the Market Reports
			Reporter.log("Test Step: Click Add On Sensitivities & Market Scenarios Market Reports From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Add");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Enter The Text On Name For Sensitivities & Market Scenarios Market Reports", 1, true);
			WebElement objMarketReports = GeneralUtil
					.getElement(
							"//div[@class='react-draggable']//span[text()='Name']/following::input[1]",
							"xpath", dynamicTimeOut);
			strNewSensitivitiesMarketScenarios = "Auto" + timeStamp;
			objMarketReports.sendKeys(strNewSensitivitiesMarketScenarios);
			
			Reporter.log("Test Step: Select The MARKETREPORT.STRESSTESTING On Template Dropdown Item", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'ReactModalPortal')]//div[starts-with(@class,'Select-control')]"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"MARKETREPORT.STRESSTESTING", "Template");
			
			Reporter.log("Test Step: Click On OK Button For Market Reports Add Page", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
									
			Reporter.log("Test Step: Click On Save Button For Sensitivities & Market Scenarios Market Reports Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click On OK Button For Sensitivities & Market Scenarios Market Reports Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Verify Notification Displayed Update Market Report", 1, true);
			Common.handleNotifications("Update Market Report");
			
			Reporter.log("Test Step: Click On Cancel Button For Sensitivities & Market Scenarios Market Reports Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Cancel']")).click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Search Added Sensitivities & Market Scenarios Market Reports", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(strNewSensitivitiesMarketScenarios);
			
			Reporter.log("Test Step: Verify Sensitivities & Market Scenarios Market Reports Added", 1, true);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			String marketPoliciesNametext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			
			
			if (marketPoliciesNametext.equalsIgnoreCase(strNewSensitivitiesMarketScenarios)) {
				GeneralUtil.logger.info("Market Reports Name " + strNewSensitivitiesMarketScenarios+ " is available in the Market Reports");
			} else {
				GeneralUtil.logger.info("Market Reports Name " + strNewSensitivitiesMarketScenarios+ " is not available in the Market Reports");
			}
			Reporter.log("Test Case: Successfully Added Sensitivities & Market Scenarios Market Reports", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Reports Added Successfully");
	}

	@Test(dependsOnMethods = { "SensitivitiesMarketScenarios_addMarketReports" })
	public void SensitivitiesMarketScenarios_editMarketReports() throws Exception {
		try {
			GeneralUtil.logger.info("Edit a Market Reports");
			Reporter.log("Test Case: Edit Sensitivities & Market Scenarios Market Reports", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Market Reports columns
					WebElement contextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Sensitivities & Market Scenarios Market Reports Filter Columns", 1, true);
						GeneralUtil.contextMenu(contextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(1000);
			
			// Search the added Market Reports
				Reporter.log("Test Step: Search Added Sensitivities & Market Scenarios Market Reports", 1, true);
				WebElement SearchElement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys(strNewSensitivitiesMarketScenarios);

			// Click on added Market Reports
			Reporter.log("Test Step: Clicked on Added Sensitivities & Market Scenarios Market Reports", 1, true);
			WebElement marketReportsElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			marketReportsElement.click();

					
			Reporter.log("Test Step: Select The MARKETREPORT.FXSPOTDELTAGAMMA On Template Dropdown Item", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-components-Dashboard-ReferenceData-MarketReport-MarketReport---detailsBorder')]//div[starts-with(@class,'Select-control')]"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"MARKETREPORT.FXSPOTDELTAGAMMA", "Template");
			
			/*Reporter.log("Test Step: Enter The Text On Name For Sensitivities & Market Scenarios Market Reports", 1, true);
			WebElement objMarketReports = GeneralUtil
					.getElement(
							"//div[starts-with(@class,'src-components-Dashboard-ReferenceData-MarketReport-MarketReport---detailsBorder')]//span[text()='NAME']/following::input[1]",
							"xpath", dynamicTimeOut);
			strEditSensitivitiesMarketScenarios = "Auto" + timeStamp;
			objMarketReports.sendKeys(strEditSensitivitiesMarketScenarios);*/
						
			Reporter.log("Test Step: Click On Save Button For Sensitivities & Market Scenarios Market Reports Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click On OK Button For Policies Sensitivities & Market Scenarios Reports Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Verify Notification Displayed Save Market Reports", 1, true);
			Common.handleNotifications("Update Market Report");
			
			Reporter.log("Test Step: Click On Cancel Button For Sensitivities & Market Scenarios Market Reports Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Cancel']")).click();
			Thread.sleep(1000);
			
			// Search the added Market Reports
			Reporter.log("Test Step: Search Edited Sensitivities & Market Scenarios Market Reports", 1, true);
			WebElement SearchEditElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchEditElement.clear();
			SearchEditElement.sendKeys(strNewSensitivitiesMarketScenarios);
			
			Reporter.log("Test Step: Verify Sensitivities & Market Scenarios Market Reports Edited", 1, true);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			String marketReportsNametext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			
			
			if (marketReportsNametext.equalsIgnoreCase(strNewSensitivitiesMarketScenarios)) {
				GeneralUtil.logger.info("Market Reports Name " + strNewSensitivitiesMarketScenarios+ " is available in the Market Reports");
			} else {
				GeneralUtil.logger.info("Market Reports Name " + strNewSensitivitiesMarketScenarios+ " is not available in the Market Reports");
			}
			Reporter.log("Test Case: Successfully Edited Policies Market Reports", 1, true);
			
			Reporter.log("Test Step: Click On Cancel Button For Sensitivities & Market Scenarios Market Reports Subwindow", 1, true);
		
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Reports Edited Successfully");

	}

	@Test(dependsOnMethods = { "SensitivitiesMarketScenarios_editMarketReports" })
	public void SensitivitiesMarketScenarios_cloneMarketReports() throws Exception {
		try {
			GeneralUtil.logger.info("Clone a Market Reports");
			Reporter.log("Test Case: Clone Sensitivities & Market Scenarios Market Reports", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Market Reports columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Policies Market Reports Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(1000);
			
			// Search the added Market Reports
				Reporter.log("Test Step: Search Edited Sensitivities & Market Scenarios Market Reports", 1, true);
				WebElement SearchElement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys(strNewSensitivitiesMarketScenarios);

				// Clone the Market Reports
				Reporter.log("Test Step: Click Clone On Sensitivities & Market Scenarios Market Reports From Context Menu", 1, true);
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
				
				Reporter.log("Test Step: Enter The Text On Name For Sensitivities & Market Scenarios Market Reports", 1, true);
				WebElement objMarketReports = GeneralUtil
						.getElement(
								"//div[@class='react-draggable']//span[text()='Name']/following::input[1]",
								"xpath", dynamicTimeOut);
				strCloneSensitivitiesMarketScenarios = "AutoClone" + timeStamp;
				objMarketReports.sendKeys(strCloneSensitivitiesMarketScenarios);
				
				Reporter.log("Test Step: Click On OK Button For Market Reports Clone Page", 1, true);
				driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
									
			Reporter.log("Test Step: Click On Save Button For Sensitivities & Market Scenarios Market Reports Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click On OK Button For Sensitivities & Market Scenarios Market Reports Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Verify Notification Displayed Update Market Policy", 1, true);
			Common.handleNotifications("Update Market Report");
			
			Reporter.log("Test Step: Click On Cancel Button For Sensitivities & Market Scenarios Market Reports Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Cancel']")).click();
			Thread.sleep(1000);
			
			// Search the added Market Reports
			Reporter.log("Test Step: Search Cloned Sensitivities & Market Scenarios Market Reports", 1, true);
			WebElement SearchEditElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchEditElement.clear();
			SearchEditElement.sendKeys(strCloneSensitivitiesMarketScenarios);
			
			Reporter.log("Test Step: Verify Sensitivities & Market Scenarios Market Reports Cloned", 1, true);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			String marketReportsNametext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			
			
			if (marketReportsNametext.equalsIgnoreCase(strCloneSensitivitiesMarketScenarios)) {
				GeneralUtil.logger.info("Market Reports Name " + strCloneSensitivitiesMarketScenarios+ " is available in the Market Reports");
			} else {
				GeneralUtil.logger.info("Market Reports Name " + strCloneSensitivitiesMarketScenarios+ " is not available in the Market Reports");
			}
			Reporter.log("Test Case: Successfully Cloned Sensitivities & Market Scenarios Market Reports", 1, true);
			
			
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Reports Cloned Successfully");

	}
	
	@Test(dependsOnMethods = { "SensitivitiesMarketScenarios_cloneMarketReports" })
	public void SensitivitiesMarketScenarios_deleteMarketReports() throws Exception {
		try {
			GeneralUtil.logger.info("Delete a Market Reports");
			Reporter.log("Test Case: Delete Sensitivities & Market Scenarios Market Reports", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Market Reports columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Sensitivities & Market Scenarios Market Reports Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
			
			// Search the added Market Reports
				Reporter.log("Test Step: Search Added Sensitivities & Market Scenarios Market Reports", 1, true);
				WebElement SearchElement = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys(strNewSensitivitiesMarketScenarios);
				Thread.sleep(1000);
				// Delete the Market Reports
				Reporter.log("Test Step: Click Delete On Sensitivities & Market Scenarios Market Reports From Context Menu", 1, true);
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
				
				Reporter.log("Test Step: Click On OK Button For Market Reports Clone Page", 1, true);
				driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			/*Reporter.log("Test Step: Verify Notification Displayed Deleted", 1, true);
			Common.handleNotifications("success");*/
			
				
		// Search the Cloned Market Reports
					Reporter.log("Test Step: Search Cloned Sensitivities & Market Scenarios Market Reports", 1, true);
					WebElement SearchCloneElement = driver
									.findElement(By
											.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
					SearchCloneElement.clear();
					SearchCloneElement.sendKeys(strCloneSensitivitiesMarketScenarios);
					Thread.sleep(1000);
					// Delete the Market Reports
					Reporter.log("Test Step: Click Delete On Sensitivities & Market Scenarios Market Reports From Context Menu", 1, true);
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
					
					Reporter.log("Test Step: Click On OK Button For Market Reports Clone Page", 1, true);
					driver.findElement(By.xpath("//div[text() = 'OK']")).click();
				
				/*Reporter.log("Test Step: Verify Notification Displayed Deleted", 1, true);
				Common.handleNotifications("success");*/
		
				Reporter.log("Test Case: Successfully Deleted Sensitivities & Market Scenarios Market Reports", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Reports Deleted Successfully");

	}

	@Test(dependsOnMethods ="SensitivitiesMarketScenarios_deleteMarketReports" , alwaysRun=true)
	public void SensitivitiesMarketScenarios_uploadMarketReports() throws Exception {
		try {
			GeneralUtil.logger.info("Upload a Market Reports");
			Reporter.log("Test Case: Upload Sensitivities & Market Scenarios Market Reports", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Market Reports columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Sensitivities & Market Scenarios Market Reports Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
			
				// Upload the Market Reports
				Reporter.log("Test Step: Click Delete On Sensitivities & Market Scenarios Market Reports From Context Menu", 1, true);
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
				
				Reporter.log("Test Step: Upload The 'CRRecoveryDeltaGamma.csv' File", 1, true);
				GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\Data\\MarketReports\\CRRecoveryDeltaGamma.csv");
				

				Thread.sleep(2000);
				GeneralUtil.logger.info("Market Reports uploaded successfully");
				Thread.sleep(1000);
				
				Reporter.log("Test Step: Search Uploaded Market Reports", 1, true);
				WebElement SearchElement = driver
						.findElement(By
								.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
				SearchElement.clear();
				SearchElement.sendKeys("CRRecoveryDeltaGamma");
				
				Thread.sleep(1000);
				GeneralUtil.captureScreenshot();

				// Validate the 'CRRecoveryDeltaGamma.csv' is uploaded or not
				Reporter.log("Test Step: Verify The 'CRRecoveryDeltaGamma.csv' Is Uploaded", 1, true);
				String marketReportsNametext = driver
						.findElement(
								By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
						.getText();

				if (marketReportsNametext.equalsIgnoreCase("CRRecoveryDeltaGamma")) {
					GeneralUtil.logger.info("Uploaded Market Reports " + marketReportsNametext
							+ " is available in the Sensitivities & Market Scenarios");
				} else {
					GeneralUtil.logger.error("Uploaded Market Reports " + marketReportsNametext
							+ " is not available in the Sensitivities & Market Scenarios");
				}
				
			
			/*Reporter.log("Test Step: Verify Notification Displayed Standard", 1, true);
			Common.handleNotifications("Standard");*/
			
			Reporter.log("Test Case: Successfully Uploaded Sensitivities & Market Scenarios Market Reports", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Reports Uploaded Successfully");

	}
	
	@Test(dependsOnMethods = "SensitivitiesMarketScenarios_uploadMarketReports" , alwaysRun=true)
	public void SensitivitiesMarketScenarios_downloadMarketReports() throws Exception {
		try {
			GeneralUtil.logger.info("Download a Market Reports");
			Reporter.log("Test Case: Download Sensitivities & Market Scenarios Market Reports", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Market Reports columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Sensitivities & Market Scenarios Market Reports Filter Columns", 1, true);
						GeneralUtil.contextMenu(clearContextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(2000);
			
						// Download the trade and Validate "Market Reports(.*).zip" file download
						// or not
						Reporter.log("Test Step: Download The Market Reports And Verify The File Download", 1, true);
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
										"MarketReports(.*).zip",
										".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
										".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			
			Reporter.log("Test Case: Successfully Downloaded Sensitivities & Market Scenarios Market Reports", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Reports Downloaded Successfully");

	}
	
	@Test(dependsOnMethods =  "SensitivitiesMarketScenarios_downloadMarketReports" , alwaysRun=true)
	public void SensitivitiesMarketScenarios_exportMarketReports() throws Exception {
		try {
			GeneralUtil.logger.info("Export a Market Reports");
			Reporter.log("Test Case: Export Sensitivities & Market Scenarios Market Reports", 1, true);
			Thread.sleep(1000);
			
			
			// Clear the filter for Market Reports columns
					WebElement clearContextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Sensitivities & Market Scenarios Market Reports Filter Columns", 1, true);
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
								.info("Market Reports CSV Exported successfully");
						
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
								.info("Market Reports Excel Exported successfully");
						
						
			
			Reporter.log("Test Case: Successfully Exported Sensitivities & Market Scenarios Market Reports", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Reports Exported Successfully");

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
