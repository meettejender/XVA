package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.Browser;
import util.GeneralUtil;

public class ProceduresToReplicateTheMarketPolicyIssue {

	public WebDriver driver;
	public int dynamicTimeOut;
	
	public boolean btnFlag = false;
	public String strPricing;
	public String timeStamp = null;
	

	@BeforeClass
	public void beforeClass() throws Exception {
		
		GeneralUtil.configureLog4j("ProceduresToReplicateTheMarketPolicyIssue");
		GeneralUtil.logger("ProceduresToReplicateTheMarketPolicyIssue");

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
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());;
	}
	
	@Test (alwaysRun=true)
	public void marketPolicy_pricingCalculation() throws Exception {
		try {
			GeneralUtil.logger("Add and Calculate Pricing Report For Market Policy");
			
			Reporter.log("Test Case: Add And Calculate Pricing Report For Market Policy", 1, true);
			// logger =
			// Logger.getLogger("Started verifying left corner of the window locate tabs");
			// Navigate to Calculations screen
			
			Reporter.log("Test Step: Click On Calculations Tab", 1, true);
			String strCalculationsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Calculations']";
			WebElement objCalculation = GeneralUtil.getElement(
					strCalculationsXpath, "xpath", dynamicTimeOut);
			objCalculation.click();
			Thread.sleep(3000);
			GeneralUtil.logger
					.info("Navigated to Calculations by Select the Calculations treeview item.");

			// Click new Calculation button
			
			Reporter.log("Test Step: Click On Add New Calculation Button", 1, true);
			WebElement objNewCalculationBtn = GeneralUtil
					.getElement(
							"//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[4]/div/div[1]/div[1]/div/div[1]/button",
							"xpath", dynamicTimeOut);
			objNewCalculationBtn.click();
			Thread.sleep(5000);
			GeneralUtil.logger.info("Clicked on add new Calculation button.");

			// Enter details in Job Set-Up tab after click on Add new
			// Calculation button
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());

			strPricing = "AUTOMarketPolicy" + timeStamp;
			Thread.sleep(1000);
			// Enter Task Name
			
			Reporter.log("Test Step: Send Value To Task Name in Sub Window", 1, true);
			WebElement objTaskName = GeneralUtil
					.getElement(
							"//div[contains(@class,'bodyContainer')]//div/div[1]/div/div[1]/div/div[2]/div/input",
							"xpath", dynamicTimeOut);
			objTaskName.clear();
			objTaskName.sendKeys(strPricing);

			GeneralUtil.logger.info("Entered Task Name as " + strPricing);

			// Click on Calculation Type
			
			Reporter.log("Test Step: Click On CalculationType Dropdown", 1, true);
			WebElement objCalculationType = GeneralUtil
					.getElement(
							"//div[contains(@class,'bodyContainer')]//div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/span[2]",
							"xpath", dynamicTimeOut);
			objCalculationType.click();

			// Select CalculationType item
			
			Reporter.log("Test Step: Select The Pricing From Dropdown Of Calculation Type", 1, true);
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Pricing", "Calculation Type");
			GeneralUtil.logger
					.info("Selected Calculation Type as Pricing calculation type");
			// Enter Trade id
			
			Reporter.log("Test Step: Enter 221 Trade Ids In Trade Selection", 1, true);
			WebElement objTradeSelection = GeneralUtil
					.getElement(
							"//div[contains(@class,'bodyContainer')]//div/div[1]/div/div[4]/div/div/div[2]/div[2]/div/div[1]/div/input",
							"xpath", dynamicTimeOut);
			objTradeSelection.sendKeys("35");
			GeneralUtil.logger.info("Entered 35 trade ids in Trade Selection");
			GeneralUtil.captureScreenshot();

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

			// Click on Calculate button
			
			Reporter.log("Test Step: Click On Calculate Button", 1, true);
			WebElement objCalculate = GeneralUtil
					.getElement(
							"//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[4]/div/div[1]/div[2]/div[2]/div/div/div[1]/div[1]/button",
							"xpath", dynamicTimeOut);
			objCalculate.click();
			GeneralUtil.logger.info("Clicked on calculate button");

			// Verification for success notification
			Common.handleNotifications("Calculation Submitted");
			Thread.sleep(1000);
			// Click alarm notification if exists
			//TT 45574 - Application change in in build 4.6 
			//Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");

			// Get Grid column and row index and verify newly added calculation
			// is conpleted in status column
			int intColNumber = Common.getColumnNumber("Task Name");
			int intRowNumber = Common
					.getRowNumber(intColNumber, strPricing);
			int intactionColNumber = Common.getColumnNumber("Jobs Progress");

			String txtStatus = "";
			int count = 1;
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Get The Jobs Progress Of Newly Created Calculation", 1, true);
			WebElement objCellStatus = driver
					.findElement(By.xpath(String
							.format(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div",
									intRowNumber, intactionColNumber)));

			while (count < dynamicTimeOut) {
				objCellStatus = driver
						.findElement(By.xpath(String
								.format(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div",
										intRowNumber, intactionColNumber)));
				txtStatus = objCellStatus.getText();
				System.out.println(count + ";" + txtStatus);
				Thread.sleep(2000);
				if (txtStatus.equals("100%")) {
					break;
				}
				Thread.sleep(2000);
				
				count++;
			}
			txtStatus = objCellStatus.getText();

			if (txtStatus.equalsIgnoreCase("100%")) {
				GeneralUtil.logger
						.info(strPricing
								+ " Pricing Report calculation status is completed");
				Thread.sleep(3000);
			} else {
				GeneralUtil.logger
						.error(strPricing
								+ " Pricing Report calculation status is not completed.Displayed status is "
								+ txtStatus);
			}

			Reporter.log("Test Case: Successfully Added And Calculated Pricing Report For Market Policy", 1, true);
			afterClass();
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}
	
	@Test(dependsOnMethods ={"marketPolicy_pricingCalculation"})
	public void marketPolicy_marketPoliciesIDResolutionRules() throws Exception {
		try {
			
			beforeClass();
			GeneralUtil.logger.info("Update Market Policies ID Resolution Rules");
			Reporter.log("Test Case: Update Market Policies ID Resolution Rules", 1, true);
			WebElement marketPoliciesTabElement = driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Market Policies']"));
			marketPoliciesTabElement.click();
			Thread.sleep(4000);
			
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
				
			// Search the Market Policies
			Reporter.log("Test Step: Search Policies Market Policies", 1, true);
			WebElement SearchElement = driver
							.findElement(By
									.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys("Standard");
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
		// Click on Market Policies
		Reporter.log("Test Step: Clicked on Policies Market Policies", 1, true);
		WebElement marketPoliciesElement = driver
				.findElement(By
						.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
		marketPoliciesElement.click();
		
		Reporter.log("Test Step: Click On Rules Button For Policies Market Policies Subwindow", 1, true);
		driver.findElement(By.xpath("//label[text() = 'Rules']")).click();
		Thread.sleep(1000);
		
		Reporter.log("Test Step: Click On General Button For Policies Market Policies Subwindow", 1, true);
		driver.findElement(By.xpath("//div[text() = 'General']")).click();
		Thread.sleep(1000);
		
		Reporter.log("Test Step: Click On ID Resolution Rules Button For Policies Market Policies Subwindow", 1, true);
		driver.findElement(By.xpath("//div[text() = 'ID Resolution Rules']")).click();
		Thread.sleep(1000);
		
		Reporter.log("Test Step: Click On ID Resolution Rules Name Field For Policies Market Policies Subwindow", 1, true);
		driver.findElement(By.xpath(".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/div/div/div")).click();
		Thread.sleep(1000);
		
		// Update the Market Policies name 
			Reporter.log("Test Step: Update The Added Policies Market Policies", 1, true);
			WebElement nameTextElement = driver
					.findElement(By
									.xpath(".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/div/div/input"));
			nameTextElement.clear();
			String strEditPolicies = "AutoEdit" + timeStamp;
			nameTextElement.sendKeys(strEditPolicies);
		
		Reporter.log("Test Step: Click On Save Button For Policies Market Policies Subwindow", 1, true);
		driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
		Reporter.log("Test Step: Click On OK Button For Policies Market Policies Subwindow", 1, true);
		driver.findElement(By.xpath("//div[text() = 'OK']")).click();
		Thread.sleep(1000);
			
		Reporter.log("Test Case: Successfully Updated Market Policies ID Resolution Rules", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Policies ID Resolution Rules Updated Successfully");
	}
	
	@Test(dependsOnMethods ={"marketPolicy_marketPoliciesIDResolutionRules"})
	public void marketPolicy_runPricingCalculation() throws Exception {
		try {
			GeneralUtil.logger("Run Pricing Calculate Report For Market Policy");
			btnFlag = false;
			Reporter.log("Test Case: Run Pricing Calculate Report For Market Policy", 1, true);
			// logger =
			// Logger.getLogger("Started verifying left corner of the window locate tabs");
			// Navigate to Calculations screen
			
			Reporter.log("Test Step: Click On Calculations Tab", 1, true);
			String strCalculationsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Calculations']";
			WebElement objCalculation = GeneralUtil.getElement(
					strCalculationsXpath, "xpath", dynamicTimeOut);
			objCalculation.click();
			Thread.sleep(3000);
			GeneralUtil.logger
					.info("Navigated to Calculations by Select the Calculations treeview item.");

			Reporter.log("Test Step: Send strPricing Into Search Element", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath("//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			 SearchElement.click();
			 SearchElement.clear();
			SearchElement.sendKeys(strPricing);
			//SearchElement.sendKeys("AUTOMarketPolicy2018.05.30.05.57.47");
			Thread.sleep(2000);

			GeneralUtil.logger.info("Entered Task Name as " + strPricing);
			
			Reporter.log("Test Step: Click on strPricing Calculation", 1, true);
			WebElement objClickCalculation = driver
					.findElement(By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]"));
			objClickCalculation.click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Click on Actions in Calculation Page", 1, true);
			WebElement objClickActions = driver
					.findElement(By.xpath("//button[text()='Actions']"));
			objClickActions.click();
			Thread.sleep(1000);
			
			// Select Re Run Pricing
			
			Reporter.log("Test Step: Select The Re Run Pricing From Dropdown Of Actions", 1, true);
			GeneralUtil.dropDownItemvisible(
					"//div[@class='dropdown open btn-group']/ul/div",
					"Re-run Pricing", "Actions");
			GeneralUtil.logger
					.info("Selected Re Run Pricing From Dropdown Of Actions");
			Thread.sleep(1000);
			// Click on Calculate button
			
			Reporter.log("Test Step: Click On Calculate Button", 1, true);
			WebElement objCalculate = GeneralUtil
					.getElement(
							"//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[4]/div/div[1]/div[2]/div[2]/div/div/div[1]/div[1]/button",
							"xpath", dynamicTimeOut);
			objCalculate.click();
			GeneralUtil.logger.info("Clicked on calculate button");
			Thread.sleep(1000);
			// Verification for success notification
			Common.handleNotifications("Calculation Submitted");
			Thread.sleep(1000);
			
			// Clear the filter for Market Policies columns
						WebElement contextMenuElement = driver.findElement(By
						.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						
							Reporter.log("Test Step: Clear The Policies Market Policies Filter Columns", 1, true);
							GeneralUtil.contextMenu(contextMenuElement);
							GeneralUtil
									.contextMenuItem(
											".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
											"Clear All Filters");
							Thread.sleep(1000);
							
			int intColNumber = Common.getColumnNumber("Task Name");
			int intRowNumber = Common
					.getRowNumber(intColNumber, strPricing);
			int intactionColNumber = Common.getColumnNumber("Jobs Progress");

			String txtStatus = "";
			WebElement objCellStatus;
			int count = 1;
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Get The Jobs Progress Of Re-Run Pricing Calculation", 1, true);
			try {
				objCellStatus = driver
						.findElement(By.xpath(String
								.format(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div",
										intRowNumber, intactionColNumber)));

				while (count < dynamicTimeOut) {
					objCellStatus = driver
							.findElement(By.xpath(String
									.format(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div",
											intRowNumber, intactionColNumber)));
					txtStatus = objCellStatus.getText();
					System.out.println(count + ";" + txtStatus);
					Thread.sleep(2000);
					if (txtStatus.equals("100%")) {
						break;
					}
					Thread.sleep(2000);
					count++;
				}
				}catch(Exception e) {
					objCellStatus = driver
							.findElement(By.xpath(String
									.format(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div",
											intRowNumber+1, intactionColNumber)));

					while (count < dynamicTimeOut) {
						objCellStatus = driver
								.findElement(By.xpath(String
										.format(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div",
												intRowNumber+1, intactionColNumber)));
						txtStatus = objCellStatus.getText();
						System.out.println(count + ";" + txtStatus);
						Thread.sleep(2000);
						if (txtStatus.equals("100%")) {
							break;
						}
						Thread.sleep(2000);
						count++;
					}
					
				}
			txtStatus = objCellStatus.getText();

			if (txtStatus.equalsIgnoreCase("100%")) {
				GeneralUtil.logger
						.info(strPricing
								+ " Re-Run Pricing Report calculation status is completed");
				Thread.sleep(3000);
			} else {
				GeneralUtil.logger
						.error(strPricing
								+ " Re-Run Pricing Report calculation status is not completed.Displayed status is "
								+ txtStatus);
			}
			
			Reporter.log("Test Step: Send strPricing Into Search Element", 1, true);
			WebElement searchElementReRunPricing = driver
					.findElement(By
							.xpath("//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			 searchElementReRunPricing.click();
			searchElementReRunPricing.sendKeys(strPricing);
			Thread.sleep(2000);

			GeneralUtil.logger.info("Entered Task Name as " + strPricing);
			
			Reporter.log("Test Step: Click on strPricing Calculation", 1, true);
			WebElement objClickReRunPricingCalculation = driver
					.findElement(By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]"));
			objClickReRunPricingCalculation.click();
			Thread.sleep(1000);
			
			String exeMessage = "Success";
			WebElement successElement = driver
					.findElement(By.xpath("//span[text() ='Success']"));
			
			String actMessage = successElement.getText();
			if (exeMessage.equalsIgnoreCase(actMessage)) {
				GeneralUtil.logger.info("Re-Run Pricing Report calculation status is + actMessage + is displayed");
				btnFlag = true;
				
			} else {
				GeneralUtil.logger
						.error("Re-Run Pricing Report calculation status is + actMessage + Is Displayed and It Failed");
			}
			
			if (btnFlag) {
				GeneralUtil.logger
						.info("Re-Run Pricing Report calculation status verified successfully");
			} else {
				throw new Exception("Re-Run Pricing Report calculation status PVs not verified");
			}
			
			Reporter.log("Test Case: Successfully Re-Run Pricing Calculation Report For Market Policy", 1, true);
			
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
		driver.switchTo().defaultContent();
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
							+ timeOut);
			Reporter.log(e.toString(), 1, true);
		}
	}

	public boolean verifyTable() throws Exception {

		int hederNumbers = Common
				.getTableColumnNumbers("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr/th");

		if (hederNumbers > 1) {
			return true;
		}
		return false;

	}
}
