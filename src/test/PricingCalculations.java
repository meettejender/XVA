package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.Browser;
import util.GeneralUtil;

public class PricingCalculations {

	public WebDriver driver;
	public int dynamicTimeOut;
	
	public boolean btnFlag = false;
	public String strSensitivityReport;
	public String strPricing;
	public String strCellID;

	@BeforeClass
	public void beforeClass() throws Exception {
		
		GeneralUtil.configureLog4j("PricingCalculations");
		GeneralUtil.logger("PricingCalculations");

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
	}
	
	@Test (alwaysRun=true)
	public void pricing_pricingCalculation() throws Exception {
		try {
			GeneralUtil.logger("Add and Calculate Pricing Report");
			
			Reporter.log("Test Case: Add And Calculate Pricing Report", 1, true);
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
			Thread.sleep(3000);
			GeneralUtil.logger.info("Clicked on add new Calculation button.");

			// Enter details in Job Set-Up tab after click on Add new
			// Calculation button
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());

			strPricing = "AUTO" + timeStamp;
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
			
			Reporter.log("Test Step: Enter 2,3 Trade Ids In Trade Selection", 1, true);
			WebElement objTradeSelection = GeneralUtil
					.getElement(
							"//div[contains(@class,'bodyContainer')]//div/div[1]/div/div[4]/div/div/div[2]/div[2]/div/div[1]/div/input",
							"xpath", dynamicTimeOut);
			objTradeSelection.sendKeys("2,3");
			GeneralUtil.logger.info("Entered 2,3 trade ids in Trade Selection");
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
			int intRowNumber = Common.getRowNumber(intColNumber, strPricing);
			int intactionColNumber = Common.getColumnNumber("Jobs Progress");

			String txtStatus = "";
			WebElement objCellStatus;
			int count = 1;
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Get The Jobs Progress Of Newly Created Calculation", 1, true);
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
								+ " Pricing Report calculation status is completed");
				Thread.sleep(3000);
			} else {
				GeneralUtil.logger
						.error(strPricing
								+ " Pricing Report calculation status is not completed.Displayed status is "
								+ txtStatus);
			}

			Reporter.log("Test Case: Successfully Added And Calculated Pricing Report", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}
	
	@Test(dependsOnMethods = "pricing_pricingCalculation")
	public void pricing_calculationsPricingTradePVs() throws Exception {

		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Trade PVs");
			
			Reporter.log("Test Case: Risk Bookmark Validation For Trade PVs", 1, true);
			
			Reporter.log("Test Step: Click On Risk Tab", 1, true);
			Thread.sleep(6000);
			
			Reporter.log("Test Step: Click On Risk Tab", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Risk']"))
					.click();
			Thread.sleep(5000);
			driver.switchTo()
					.frame(driver.findElement(By
							.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[2]/div/iframe")));
			Thread.sleep(1000);

			// Pricing bookmark validation
			
			Reporter.log("Test Step: Click And Expand Pricing", 1, true);
			if (driver.findElement(
					By.xpath("//div[@class='GOJU4GFOT']/table/tbody/tr/td[3]"))
					.isDisplayed()) {
				clickExpandPricing("Pricing");

			} else {
				driver.findElement(
						By.xpath("//div[@class='GOJU4GFFR']/div[2]/div/table/tbody/tr/td[1]"))
						.click();
				driver.findElement(
						By.xpath("//div[@class='gwt-MenuBar gwt-MenuBar-vertical']/table/tbody/tr/td"))
						.click();
				clickExpandPricing("Pricing");
			}
			//clickExpandPricing("Pricing");
			// Pricing Trade PVs bookmark validation
			
			Reporter.log("Test Step: Click On Trade PVs", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Trade PVs']"))
					.click();
			int intUniqueColNumber = 0;
			String strCellData;
			int intActColNumber = 0;
			int intRowNumber = 0;
			WebElement strCellElement;

			if (verifyTable()) {
				intUniqueColNumber = Common
						.getTableColumnNumber(
								"Trade ID",
								"//*[@id='SPGtable']/tbody/tr[2]/td[1]/div/div/table/tbody/tr/th/table/tbody/tr/th");
				intRowNumber = Common
						.getTableRowNumber(
								"//*[@id='SPGtable']/tbody/tr[3]/td[1]/div/div/div[@class='gwt-HTML']/table/tbody/tr",
								"th[%d]", intUniqueColNumber, "2");

				intActColNumber = Common
						.getTableColumnNumber(
								"PV.RPT",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										intRowNumber, intActColNumber - 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Trade PVs value " + strCellData
						+ " is displayed in the Risk Trade PVs page");
			} else {
				GeneralUtil.logger
						.error("Trade PVs value is not displayed in the Risk Trade PVs page and failed");
			}

			intRowNumber = Common
					.getTableRowNumber(
							"//*[@id='SPGtable']/tbody/tr[3]/td[1]/div/div/div[@class='gwt-HTML']/table/tbody/tr",
							"th[%d]", intUniqueColNumber, "3");

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"PV.RPT",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										intRowNumber, intActColNumber - 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.logger.info("Trade PVs value " + strCellData
						+ " is displayed in the Risk Trade PVs page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Trade PVs value is not displayed in the Risk Trade PVs page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Trade PVs", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Trade PVs verified successfully");
		} else {
			throw new Exception("Risk bookmark Trade PVs not verified");
		}
	}
	
	@Test(dependsOnMethods = "pricing_calculationsPricingTradePVs", alwaysRun=true)
	public void pricing_calculationsPricingPortfolioPVs() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Portfolio PVs");

			Reporter.log("Test Case: Risk Bookmark Validation For Portfolio PVs", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();

			Thread.sleep(2000);
			
			Reporter.log("Test Step: Click On Portfolio PVs", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Portfolio PVs']"))
					.click();
			Thread.sleep(5000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"PV.RPT",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber - 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Portfolio PVs value " + strCellData
						+ " is displayed in the Risk Portfolio PVs page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Portfolio PVs value is not displayed in the Risk Portfolio PVs page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Portfolio PVs", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Portfolio PVs verified successfully");
		} else {
			throw new Exception("Risk bookmark Portfolio PVs not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "pricing_calculationsPricingPortfolioPVs", alwaysRun=true)
	public void pricing_calculationsPricingCombinedRiskViewTradeHierarchy() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for VaR, Sensitivities, Allocated XVA by Trade Hierarchy in Combined Risk View");

			Reporter.log("Test Case: Risk Bookmark Validation For VaR, Sensitivities, Allocated XVA by Trade Hierarchy in Combined Risk View", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//div[@class='gwt-Tree']/div[3]/div/div[6]/table/tbody/tr/td[1]"))
					.click();

			Thread.sleep(1000);
			WebElement expandElement = driver
					.findElement(By
							.xpath("//div[@class= 'gwt-TabPanelBottom']/div[2]/div/table/tbody/tr[2]/td/div[@class='gwt-Tree']/div[3]/table/tbody/tr/td[1]"));
			expandElement.click();
			Thread.sleep(1000);
			clickExpandCombinedRiskView("Combined Risk View");
			
			Reporter.log("Test Step: Click On VaR, Sensitivities, Allocated XVA by Trade Hierarchy", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='VaR, Sensitivities, Allocated XVA by Trade Hierarchy']"))
					.click();
			Thread.sleep(2000);
			Common.closeFailedtoexecutequeryMessage();
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Total PV.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[4]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("VaR, Sensitivities, Allocated XVA by Trade Hierarchy value " + strCellData
						+ " is displayed in the Risk VaR, Sensitivities, Allocated XVA by Trade Hierarchy page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("VaR, Sensitivities, Allocated XVA by Trade Hierarchy value is not displayed in the Risk VaR, Sensitivities, Allocated XVA by Trade Hierarchy page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For VaR, Sensitivities, Allocated XVA By Trade Hierarchy", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark VaR, Sensitivities, Allocated XVA by Trade Hierarchy verified successfully");
		} else {
			throw new Exception("Risk bookmark VaR, Sensitivities, Allocated XVA by Trade Hierarchy not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "pricing_calculationsPricingCombinedRiskViewTradeHierarchy", alwaysRun=true)
	public void pricing_calculationsPricingCombinedRiskViewNettingSet() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for XVA, VaR, Sensitivities by Netting Set in Combined Risk View");

			Reporter.log("Test Case: Risk Bookmark Validation For XVA, VaR, Sensitivities by Netting Set in Combined Risk View", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
			/*driver.findElement(
					By.xpath("//div[@class='gwt-Tree']/div[3]/div/div[6]/table/tbody/tr/td[1]"))
					.click();

			Thread.sleep(2000);
			WebElement expandElement = driver
					.findElement(By
							.xpath("//div[@class= 'gwt-TabPanelBottom']/div[2]/div/table/tbody/tr[2]/td/div[@class='gwt-Tree']/div[3]/table/tbody/tr/td[1]"));
			expandElement.click();
			Thread.sleep(2000);
			clickExpandPricing("Combined Risk View");*/
			
			Reporter.log("Test Step: Click On XVA, VaR, Sensitivities by Netting Set", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='XVA, VaR, Sensitivities by Netting Set']"))
					.click();
			Thread.sleep(5000);
			Common.closeFailedtoexecutequeryMessage();
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Total PV.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[4]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("XVA, VaR, Sensitivities by Netting Set value " + strCellData
						+ " is displayed in the Risk XVA, VaR, Sensitivities by Netting Set page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("XVA, VaR, Sensitivities by Netting Set value is not displayed in the Risk XVA, VaR, Sensitivities by Netting Set page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For XVA, VaR, Sensitivities by Netting Set", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark XVA, VaR, Sensitivities by Netting Set verified successfully");
		} else {
			throw new Exception("Risk bookmark XVA, VaR, Sensitivities by Netting Set not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "pricing_calculationsPricingCombinedRiskViewNettingSet", alwaysRun=true)
	public void pricing_calculationsPricingContentsSynchronizationStatistics() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Synchronization Statistics in Contents");

			Reporter.log("Test Case: Risk Bookmark Validation For Synchronization Statistics in Contents", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//div[@class='gwt-Tree']/div[3]/div/div[1]/table/tbody/tr/td[1]"))
					.click();

			Thread.sleep(1000);
			WebElement expandElement = driver
					.findElement(By
							.xpath("//div[@class= 'gwt-TabPanelBottom']/div[2]/div/table/tbody/tr[2]/td/div[@class='gwt-Tree']/div[3]/table/tbody/tr/td[1]"));
			expandElement.click();
			Thread.sleep(1000);
			clickExpandCombinedRiskView("Contents");
			
			Reporter.log("Test Step: Click On Synchronization Statistics", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Synchronization Statistics']"))
					.click();
			Thread.sleep(2000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Count",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber + 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Synchronization Statistics value " + strCellData
						+ " is displayed in the Risk Synchronization Statistics page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Synchronization Statistics value is not displayed in the Risk Synchronization Statistics page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Synchronization Statistics", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Synchronization Statistics verified successfully");
		} else {
			throw new Exception("Risk bookmark Synchronization Statistics not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "pricing_calculationsPricingContentsSynchronizationStatistics", alwaysRun=true)
	public void pricing_calculationsPricingContentsSynchronizedTradeCounts() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Synchronized Trade Counts in Contents");

			Reporter.log("Test Case: Risk Bookmark Validation For Synchronized Trade Counts in Contents", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
			/*driver.findElement(
					By.xpath("//div[@class='gwt-Tree']/div[3]/div/div[1]/table/tbody/tr/td[1]"))
					.click();

			Thread.sleep(2000);
			WebElement expandElement = driver
					.findElement(By
							.xpath("//div[@class= 'gwt-TabPanelBottom']/div[2]/div/table/tbody/tr[2]/td/div[@class='gwt-Tree']/div[3]/table/tbody/tr/td[1]"));
			expandElement.click();
			Thread.sleep(2000);
			clickExpandCombinedRiskView("Contents");*/
			
			Reporter.log("Test Step: Click On Synchronized Trade Counts", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Synchronized Trade Counts']"))
					.click();
			Thread.sleep(5000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Total MARKET_RISK",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber + 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Synchronized Trade Counts value " + strCellData
						+ " is displayed in the Risk Synchronized Trade Counts page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Synchronized Trade Counts value is not displayed in the Risk Synchronized Trade Counts page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Synchronized Trade Counts", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Synchronized Trade Counts verified successfully");
		} else {
			throw new Exception("Risk bookmark Synchronized Trade Counts not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	//@Test(dependsOnMethods = "pricing_calculationsPricingContentsSynchronizedTradeCounts", alwaysRun=true)
	public void pricing_calculationsPricingClearResults() throws Exception {
		try {
			
			GeneralUtil
					.logger("Clear Calculation Results In Database");

			Reporter.log("Test Case: Clear Calculation Results In Database", 1, true);
					
			Thread.sleep(2000);
			Reporter.log("Test Case: Navigate From Frame to Default Window", 1, true);
			driver.switchTo().defaultContent();
			
			Reporter.log("Test Step: Click On Calculations Tab", 1, true);
			String strCalculationsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Calculations']";
			WebElement objCalculation = GeneralUtil.getElement(
					strCalculationsXpath, "xpath", dynamicTimeOut);
			objCalculation.click();
			Thread.sleep(3000);
			
			Reporter.log("Test Step: Click On Clear Results Button", 1, true);
			WebElement objClearResults = GeneralUtil
					.getElement(
							"//div[text()='Clear Results']",
							"xpath", dynamicTimeOut);
			objClearResults.click();
			
			Reporter.log("Test Step: Check Main:Base check box", 1, true);
			WebElement objMainBaseCheckbox = GeneralUtil
					.getElement(
							"//div/span/span[text()='Main:Base']/preceding-sibling::span",
							"xpath", dynamicTimeOut);
			objMainBaseCheckbox.click();
			GeneralUtil.logger
					.info("Checked  Main:Base check box.");
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Click OK Button For Calculation", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Ok']")).click();

			Reporter.log("Test Case: Successfully Cleared Calculation Results In Database", 1, true);
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

	public void clickExpandPricing(String expValue) {
		WebElement expandElement = driver.findElement(By
				.xpath("//table[@class='live-TabPanel live-tabFont']//div[@class='gwt-Tree']/div[3]/table/tbody/tr/td[1]/img"));
		expandElement.click();
		List<WebElement> txtPublicElement = driver.findElements(By
				.xpath("//div[@class='gwt-Tree']/div[3]/div/div"));
		for (int i = 0; i < txtPublicElement.size(); i++) {
			String publicText = txtPublicElement.get(i).getText();

			if (publicText.contains(expValue)) {
				WebElement subPublicCollapse = driver
						.findElement(By.xpath(String
								.format("//div[@class='gwt-Tree']/div[3]/div/div[%d]/table/tbody/tr/td[1]",
										i + 1)));
				subPublicCollapse.click();
				break;
			}
		}
	}
	
	public void clickExpandCombinedRiskView(String expValue) {
		WebElement expandElement = driver.findElement(By
				.xpath("//table[@class='live-TabPanel live-tabFont']//div[@class='gwt-Tree']/div[3]/table/tbody/tr/td[1]/img"));
		expandElement.click();
		List<WebElement> txtPublicElement = driver.findElements(By
				.xpath("//div[@class='gwt-Tree']/div[3]/div/div"));
		for (int i = 0; i < txtPublicElement.size(); i++) {
			String publicText = txtPublicElement.get(i).getText();

			if (publicText.contains(expValue)) {
				WebElement subPublicCollapse = driver
						.findElement(By.xpath(String
								.format("//div[@class='gwt-Tree']/div[3]/div/div[%d]/table/tbody/tr/td[1]",
										i)));
				subPublicCollapse.click();
				break;
			}
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
