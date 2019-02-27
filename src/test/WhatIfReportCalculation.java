package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.Browser;
import util.GeneralUtil;

public class WhatIfReportCalculation {

	public WebDriver driver;
	public int dynamicTimeOut;

	boolean btnFlag = false;
	public String strSensitivityReport;
	public String strPricing;
	public String strExposuresReport;
	public String strRegulatoryReport;
	public String strCellID;
	public String strTrade = "CC_BermudanSwap";
	public String strTradeID = "2";
	public String strWhatIfID;
	public String selectedMarketsDate;

	

	@BeforeClass
	public void beforeClass() throws Exception {
		
		GeneralUtil.configureLog4j("ExposuresReportCalculation");
		GeneralUtil.logger("ExposuresReportCalculation");

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
	public void exposuresReportCalculation_Create() throws Exception {
		try {
			GeneralUtil.logger("Add and Calculate Exposure report");
			// logger =
			// Logger.getLogger("Started verifying left corner of the window locate tabs");
			// Navigate to Calculations screen
			Reporter.log("Test Case: Add and Calculate Exposure report", 1, true);
			
			Reporter.log("Test Step: Click On Calculations Tab", 1, true);
			String strCalculationsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Calculations']";
			WebElement objCalculation = GeneralUtil.getElement(
					strCalculationsXpath, "xpath", dynamicTimeOut);
			objCalculation.click();
			Thread.sleep(5000);
			GeneralUtil.captureScreenshot();
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

			strExposuresReport = "AUTO" + timeStamp;
			Thread.sleep(1000);

			// Enter Task Name
			Reporter.log("Test Step: Send Value To Task Name in Sub Window", 1, true);
			WebElement objTaskName = GeneralUtil
					.getElement(
							"//div[contains(@class,'bodyContainer')]//div/div[1]/div/div[1]/div/div[2]/div/input",
							"xpath", dynamicTimeOut);
			objTaskName.clear();

			objTaskName.sendKeys(strExposuresReport);
			
			GeneralUtil.logger.info("Entered Task Name as "
					+ strExposuresReport);
			// Click on Calculation Type
						Reporter.log("Test Step: Get The Visible Value Of SelectedMarkets In Sub Window", 1, true);
						WebElement objSelectedMarkets = driver.findElement(By.xpath(".//*[@class='ReactTabs react-tabs']/div/div/div[2]/div/div/div[1]/div/div[2]/div/div/div/div/div/span[1]/div[1]/span[2]"));
						selectedMarketsDate=objSelectedMarkets.getText();
						selectedMarketsDate=selectedMarketsDate.substring(1, 11);
			
			
			//Get the date from Selected Markets
						Reporter.log("Test Step: Click On CalculationType Dropdown", 1, true);
			WebElement objCalculationType = GeneralUtil
					.getElement(
							"//div[contains(@class,'bodyContainer')]//div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/span[2]",
							"xpath", dynamicTimeOut);
			objCalculationType.click();

			

			// Select CalculationType item
			Reporter.log("Test Step: Select The Exposures From Dropdown Of Calculation Type", 1, true);
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Exposures", "Calculation Type");
			GeneralUtil.logger
					.info("Selected Calculation Type as Exposures Reports");
			
			
			/*driver.findElement(
					By.xpath(".//*[@class='ReactTabs react-tabs']/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/span[3]")).click();
			
			driver.findElement(
					By.xpath("//div[@class='Select-menu-outer']/div/div[1]/div/div/div[3]")).click();*/
			
			// Enter trade ids
			Reporter.log("Test Step: Enter 2,3 trade ids in Trade Selection", 1, true);
			WebElement objTradeSelection = GeneralUtil
					.getElement(
							"//div[contains(@class,'bodyContainer')]//div/div[1]/div/div[4]/div/div/div[2]/div[2]/div/div[1]/div/input",
							"xpath", dynamicTimeOut);
			objTradeSelection.sendKeys("2,3");
			GeneralUtil.logger.info("Entered 2,3 trade ids in Trade Selection");

			// Click on Calculate Risk Measures checkbox and verify Risk
			// Measures Set-Up tab is displayed or not
			Reporter.log("Test Step: Check Calculate Risk Measures check box", 1, true);
			WebElement objCheckbox = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Calculate Risk Measures']/following::label[1]",
							"xpath", dynamicTimeOut);
			objCheckbox.click();
			GeneralUtil.logger
					.info("Checked  Calculate Risk Measures check box.");
			GeneralUtil.captureScreenshot();

			// Click on Risk Measures Set-Up tab and enter details
			Reporter.log("Test Step: Click On RiskMeasuresSetUpTab", 1, true);
			WebElement objRiskMeasuresSetUpTab = GeneralUtil.getElement(
					"//label[contains(text(),'Risk Measures Set-Up')]",
					"xpath", dynamicTimeOut);
			objRiskMeasuresSetUpTab.click();
			GeneralUtil.logger.info("Selected Risk Measures Set-Up tab");

			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Check Calculate XVA Checkbox", 1, true);
			WebElement objCalculateXVA = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Calculate XVA']/following::label[1]",
							"xpath", dynamicTimeOut);
			objCalculateXVA.click();
			GeneralUtil.logger.info("Checked  Calculate XVA checkbox box.");

			Reporter.log("Test Step: Check Calculate PFE Checkbox", 1, true);
			WebElement objCalculatePFE = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Calculate PFE']/following::label[1]",
							"xpath", dynamicTimeOut);
			objCalculatePFE.click();
			GeneralUtil.logger.info("Checked  Calculate PFE checkbox box.");
			
			/*Reporter.log("Test Step: Check Calculate Incremental Measures Checkbox", 1, true);
			WebElement objCalculateIncrementalMeasures = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Calculate Incremental Measures']/following::label[1]",
							"xpath", dynamicTimeOut);
			objCalculateIncrementalMeasures.click();
			GeneralUtil.logger
					.info("Checked  Calculate Incremental Measures checkbox box.");
			
			Reporter.log("Test Step: Check Calculate Pre-Margin Measures Checkbox", 1, true);
			WebElement objCalculatePreMarginMeasures = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Calculate Pre-Margin Measures']/following::label[1]",
							"xpath", dynamicTimeOut);
			objCalculatePreMarginMeasures.click();
			GeneralUtil.logger
					.info("Checked  Calculate Pre-Margin Measures checkbox box.");
			
			Reporter.log("Test Step: Check Calculate KVA For SA-CCR Checkbox", 1, true);
			WebElement objCalculateKVAforSACCR = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Calculate KVA for SA-CCR']/following::label[1]",
							"xpath", dynamicTimeOut);
			objCalculateKVAforSACCR.click();
			GeneralUtil.logger
					.info("Checked  Calculate KVA for SA-CCR checkbox box.");

			Reporter.log("Test Step: Check Standalone Trade Measures Checkbox", 1, true);
			WebElement objStandaloneTradeMeasures = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Standalone Trade Measures']/following::label[1]",
							"xpath", dynamicTimeOut);
			objStandaloneTradeMeasures.click();
			GeneralUtil.logger
					.info("Checked  Standalone Trade Measures checkbox box.");

			Reporter.log("Test Step: Check Calculate Marginal Checkbox", 1, true);
			WebElement objCalculateMarginal = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Calculate Marginal']/following::label[1]",
							"xpath", dynamicTimeOut);
			objCalculateMarginal.click();
			GeneralUtil.logger.info("Checked  Calculate Marginal checkbox box.");*/

			GeneralUtil.captureScreenshot();
			
		/*	// Click on Regulatory Capital Set-Up tab and enter details
						WebElement objRegulatoryCapitalSetUpTab = GeneralUtil.getElement(
								"//label[contains(text(),'Regulatory Capital Set-Up')]",
								"xpath", dynamicTimeOut);
						objRegulatoryCapitalSetUpTab.click();
						GeneralUtil.logger.info("Selected Regulatory Capital Set-Up");
						
						
			// Click on Run BASEL III CVA Calculations checkbox and verify Risk
						WebElement objRunBASELIIICVACalculationsCheckbox = GeneralUtil
									.getElement(
											"//div/span/label/span[text()='Run BASEL III CVA Calculations']/following::label[1]",
											"xpath", dynamicTimeOut);
						objRunBASELIIICVACalculationsCheckbox.click();*/
			
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
			// Click alarm notification if exists
			//TT 45574 - Application change in in build 4.6 
			//Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");

			// Get Grid column and row index and verify newly added calculation
			
			Thread.sleep(20000);
			// is conpleted in status column
			int intColNumber = Common.getColumnNumber("Task Name");
			int intIDColNumber = Common.getColumnNumber("ID");
			int intRowNumber = Common.getRowNumber(intColNumber,
					strExposuresReport);
			int intactionColNumber = Common.getColumnNumber("Jobs Progress");
			int count = 1;
			String txtStatus = "";
			WebElement objCellStatus;
			
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
			
			/*Thread.sleep(1000);
			int intColNumber = Common.getColumnNumber("Task Name");
			int intRowNumber = Common.getRowNumber(intColNumber,
					strExposuresReport);
			int intactionColNumber = Common.getColumnNumber("Status");

			int count = 1;
			WebElement objCellStatus = driver
					.findElement(By.xpath(String
							.format("//div[contains(@class,'src-components-Dashboard-Calculation-CalculationBrowser-TasksView')]//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div//span",
									intRowNumber, intColNumber)));

			while (count < dynamicTimeOut) {
				 objCellStatus = driver
						.findElement(By.xpath(String
								.format("//div[contains(@class,'src-components-Dashboard-Calculation-CalculationBrowser-TasksView')]//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div//span",
										intRowNumber, intactionColNumber)));
				String txtStatus = objCellStatus.getText();
				System.out.println(count + ";" + txtStatus);
				Thread.sleep(2000);
				if (txtStatus.equals("Completed")) {
					break;
				}
				Thread.sleep(2000);
				Common
						.clickNotification("//i[@class='fa fa-bell-o fa-fw']");
				Thread.sleep(2000);
				count++;
			}
			String txtStatus = objCellStatus.getText();*/
			GeneralUtil.captureScreenshot();
			
			
			if (txtStatus.equalsIgnoreCase("100%")) {
				GeneralUtil.logger.info(strExposuresReport
						+ " Exposures Report calculation status is completed");
				WebElement objCellID = driver
						.findElement(By.xpath(String
								.format("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div",
										intRowNumber, intColNumber-1)));
				strCellID = objCellID.getText();

			} else {
				GeneralUtil.logger
						.error(strExposuresReport
								+ " Exposures Report calculation status is not completed.Displayed status is "
								+ txtStatus);
			}

			Reporter.log("Test Case: Added and Calculated Exposure report", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = "exposuresReportCalculation_Create",alwaysRun=true)
	public void exposuresReportCalculation_submitWhatIfAtTradesScreen() throws Exception {
		try {
			GeneralUtil.logger("Submit What-If At Trades Screen");
			
			Reporter.log("Test Case: Submit What-If At Trades Screen", 1, true);
			// logger =
			// Logger.getLogger("Started verifying left corner of the window locate tabs");
			// Navigate to Trades screen
			
			Reporter.log("Test Step: Click On Trade Tab", 1, true);
			String strTradesXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li[1]/div/div/div[text()='Trades']";
			WebElement objCalculation = GeneralUtil.getElement(strTradesXpath,
					"xpath", dynamicTimeOut);
			objCalculation.click();
			Thread.sleep(4000);
			GeneralUtil.captureScreenshot();
			GeneralUtil.logger
					.info("Navigated to trade by Select the Trades treeview item.");
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

			// Open what-if grid by Click on what-if button
			
			Reporter.log("Test Step: Click On What-If Radio Button", 1, true);
			WebElement objWhatIfBtn = GeneralUtil
					.getElement(
							"//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[3]/div/div[1]/div[1]/div/div[2]/div/div[2]/div[2]/div/div",
							"xpath", dynamicTimeOut);
			objWhatIfBtn.click();
			Thread.sleep(4000);
			GeneralUtil.logger.info("Clicked on What-If button.");

			// Select Exposures
			
			Reporter.log("Test Step: Click On Exposures Dropdown", 1, true);
			WebElement objExposures = GeneralUtil
					.getElement(
							".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[3]/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div/span[2]/span",
							"xpath", dynamicTimeOut);
			objExposures.click();
			Thread.sleep(1000);
			System.out.println("Exposures: " + strCellID + " - " + strExposuresReport+", Main, "+selectedMarketsDate);
			Reporter.log("Test Step: Select Exposures: "+ strCellID + " - " + strExposuresReport+", Main, "+selectedMarketsDate, 1, true);
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Exposures: " + strCellID + " - " + strExposuresReport+", Main, "+selectedMarketsDate,
					"Exposures");
			
			GeneralUtil.logger.info("Selected Exposures as  Exposures: "
					+ strCellID + " - " + strExposuresReport);


			Thread.sleep(1000);
			Reporter.log("Test Step: Select The First Counterparty", 1, true);
			WebElement objMainCounterparties = GeneralUtil
					.getElement(
							"//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/span/span[2]/i",
							"xpath", dynamicTimeOut);
			objMainCounterparties.click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Check The First Sub Counterparty CheckBox Of The Selected Main Counterparty", 1, true);
			WebElement objCounterparties = GeneralUtil
					.getElement(
							"//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[1]/div[2]/div[2]/span/span[1]",
							"xpath", dynamicTimeOut);
			objCounterparties.click();
			Thread.sleep(1000);
			// Search in trade grid at first column
			
			Reporter.log("Test Step: Send Trade Id Into Search Element Id", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[4]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(strTradeID);
			Thread.sleep(1000);
			
			
			GeneralUtil.captureScreenshot();
			// Click on check box at trade id column cell
			
			Reporter.log("Test Step: Check The Filtered Row CheckBox", 1, true);
			WebElement objTradeidCheckBox = GeneralUtil
					.getElement(
							".//*[@ref='center']/div/div[4]/div[1]/div/div[1]/div/span/span[1]/span[2]",
							"xpath", dynamicTimeOut);
			objTradeidCheckBox.click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Send Trade Id Into Search Element Id", 1, true);
			WebElement tradeElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[4]"));
			tradeElement.click();
			Thread.sleep(1000);
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
			GeneralUtil.captureScreenshot();
			// Click Submit what-if button
			
			Reporter.log("Test Step: Click On SubmitWhatIf Button", 1, true);
			WebElement objSubmitWhatIf = GeneralUtil
					.getElement(
							"//div[text()='Submit What-If']//parent::div/parent::button",
							"xpath", dynamicTimeOut);
			objSubmitWhatIf.click();
			GeneralUtil.logger.info("Clicked on Submit what-if button.");

			Thread.sleep(1000);

			String strnotifications1 = "";

			try {
				
				Reporter.log("Test Step: Get The Text From Notification", 1, true);
				WebElement objNotificationsTest = GeneralUtil
						.getElement(
								"//div[@class='notifications-wrapper']//h4[text()='Calculation Submitted']//following-sibling::div[@class='notification-message']",
								"xpath", 200);
				strnotifications1 = objNotificationsTest.getText();
				System.out.println(strnotifications1);
				WebElement objNotificationsH4 = GeneralUtil
						.getElement(
								"//div[@class='notifications-wrapper']//h4[text()='Calculation Submitted']",
								"xpath", GeneralUtil.scriptTimeOut);
				String strnotifications = objNotificationsH4.getText() + ":"
						+ strnotifications1;
				if (strnotifications.contains("Calculation Submitted")) {

					GeneralUtil.logger.info("Displayed notifications is :"
							+ strnotifications);
					GeneralUtil.captureScreenshot();

					for (int i = strnotifications1.length(); i > 0; i--) {
						if (strnotifications1.charAt(i - 1) == ' ') {
							strnotifications1.substring(i + 1,
									strnotifications1.length());
							System.out.println(strnotifications1.substring(i,
									strnotifications1.length() - 2));
							strWhatIfID = strnotifications1.substring(i,
									strnotifications1.length() - 2);
							System.out.println(strWhatIfID);
							break;
						}
					}
				} else {
					GeneralUtil.logger
							.info("Calculation Submitted"
									+ " is not displayed in notification.Displayed message is : "
									+ strnotifications);
					// return false;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch blockF
				e.printStackTrace();

			}
			afterClass();
			Thread.sleep(2000);
			beforeClass();
			Thread.sleep(5000);
			//Common.clickNotification("//i[@class='fa fa-bell-o fa-fw']");
			// Navigate to Calculations screen
			
			Reporter.log("Test Step: Click On Calculations Tab", 1, true);
			String strTradesXpath1 = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Calculations']";
			WebElement objCalculation1 = GeneralUtil.getElement(
					strTradesXpath1, "xpath", dynamicTimeOut);
			objCalculation1.click();
			Thread.sleep(5000);
			GeneralUtil.captureScreenshot();
			GeneralUtil.logger
					.info("Navigated to Calculations by Select the Calculations treeview item.");
			
			
			Reporter.log("Test Step: Send WhatIfId Into Search Element", 1, true);
			WebElement SearchElement1 = driver
					.findElement(By
							.xpath("//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			 SearchElement1.click();
			SearchElement1.sendKeys(strWhatIfID);
			Thread.sleep(2000);
			GeneralUtil.captureScreenshot();
			
			int intColNumber = Common.getColumnNumber("Task Name");
			//int intIDColNumber = Common.getColumnNumber("ID");
			int intRowNumber = Common.getRowNumber(intColNumber,
					strWhatIfID);
			
			int intactionColNumber = Common.getColumnNumberForJobProgress("Jobs Progress");
			
			Thread.sleep(1000);
			String txtStatus = "";
			WebElement objCellStatus;
			int count = 1;
			
			
			Reporter.log("Test Step: Get The Status Of The Filtered Row", 1, true);
			
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

			if (txtStatus.equalsIgnoreCase("100%")) {
				GeneralUtil.logger.info("WhatIf-Dashboard_Trade_" + strWhatIfID
						+ " calculation status is completed");
			} else {
				GeneralUtil.logger
						.error("WhatIf-Dashboard_Trade_"
								+ strWhatIfID
								+ " calculation status is not completed.Displayed status is "
								+ txtStatus);
			}

			Reporter.log("Test Case: Submitted What-If At Trades Screen", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);

		}

	}

	@Test(dependsOnMethods = "exposuresReportCalculation_submitWhatIfAtTradesScreen",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresPVforWhatIfTrades() throws Exception {
		try {
			
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for PV for What-If Trades");

			Reporter.log("Test Case: Risk Bookmark Validation For PV For What-If Trades", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			
			Reporter.log("Test Step: Click On Risk", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Risk']"))
					.click();
			Thread.sleep(5000);
			driver.switchTo()
					.frame(driver.findElement(By
							.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[2]/div/iframe")));
			Thread.sleep(2000);
			
			Reporter.log("Test Step: Click And Expand Counterparty Risk And Expand What-If", 1, true);
			//clickExpandCounterpartyRisk("Counterparty Risk", "What-If");
			clickExpandCounterpartyRiskCapital("Counterparty Risk", "What-If");
			Thread.sleep(1000);
			// PV for What-If Trades bookmark validation

			Reporter.log("Test Step: Click On PV For What-If Trades", 1, true);
			WebElement WhatIfTradesElement = driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[text()='PV for What-If Trades']"));
			WhatIfTradesElement.click();
			
			Reporter.log("Test Step: Click On XVA Scenarios: - PV for What-If Trades", 1, true);
			WebElement basePVElement = driver.findElement(By.xpath(".//*[@title='XVA Scenarios: -']/div"));
			
			Actions click = new Actions(driver);
			click.moveToElement(basePVElement).perform();
			Thread.sleep(1000);	
			//clicker.moveToElement(baseElement).click().perform();
			
			// Click on Report Types
						WebElement objReportPVTypes = GeneralUtil
								.getElement(
										".//div[@class='gwt-TabPanelBottom']//div[starts-with(text(),'Trade Status:')]",
										"xpath", dynamicTimeOut);
						objReportPVTypes.click();
						Thread.sleep(2000);		
			// Click on All Booked checkbox
			WebElement objBookedPVCheckbox = GeneralUtil
			.getElement(
			"//div/span/label[text()='Booked']/preceding-sibling::input",
			"xpath", dynamicTimeOut);
			objBookedPVCheckbox.click();
			GeneralUtil.logger
			.info("Checked Booked check box.");
			
			driver.findElement(By.xpath("//a[text() = 'Ok']")).click();
			Thread.sleep(3000);
			
			Reporter.log("Test Step: Click On XVA Scenarios: - PV for What-If Trades", 1, true);
			WebElement baseElement = driver.findElement(By.xpath(".//*[@title='XVA Scenarios: -']/div"));
			
			Actions clicker = new Actions(driver);
			clicker.moveToElement(baseElement).perform();
			Thread.sleep(1000);	
			//clicker.moveToElement(baseElement).click().perform();
			
			// Click on Report Types
						WebElement objReportTypes = GeneralUtil
								.getElement(
										".//div[@class='gwt-TabPanelBottom']//div[starts-with(text(),'Result Scenario Types:')]",
										"xpath", dynamicTimeOut);
						objReportTypes.click();
						Thread.sleep(2000);		
			// Click on All Base checkbox
			WebElement objBaseCheckbox = GeneralUtil
			.getElement(
			"//div/span/label[text()='Base']/preceding-sibling::input",
			"xpath", dynamicTimeOut);
			objBaseCheckbox.click();
			GeneralUtil.logger
			.info("Checked Base check box.");
			
			driver.findElement(By.xpath("//a[text() = 'Ok']")).click();
			Thread.sleep(3000);
			
			Thread.sleep(1000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Exposure PV.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber+1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("PV for What-If Trades PVs value "
								+ strCellData
								+ " is displayed in the Risk PV for What-If Trades PVs page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("PV for What-If Trades PVs value is not displayed in the Risk PV for What-If Trades PVs page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For PV For What-If Trades", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark PV for What-If Trades PVs verified successfully");
		} else {
			throw new Exception("Risk bookmark PV for What-If Trades PVs not verified");
		}
	}

	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresPVforWhatIfTrades",alwaysRun=true)
	public void exposuresReportCalculation_calculationsWhatIfCapitalSACCRbyCounterparty() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Capital SA-CCR by Counterparty");

			Reporter.log("Test Case: Risk Bookmark Validation For Capital SA-CCR by Counterparty", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			// What-If Post-Margin Incremental CVA bookmark validation
			
			Reporter.log("Test Step: Click On Capital SA-CCR By Counterparty", 1, true);
			//driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[text()='Capital SA-CCR by Counterparty']")).click();
			
			WebElement capitalSACCRbyCounterpartyElement = driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[contains(text(),'Capital SA-CCR by Counterparty')]"));
			capitalSACCRbyCounterpartyElement.click();
			
			

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Capital SA-CCR",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th[3]");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber + 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Capital SA-CCR by Counterparty value "
								+ strCellData
								+ " is displayed in the Risk Capital SA-CCR by Counterpartys page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Capital SA-CCR by Counterparty value is not displayed in the Risk Capital SA-CCR by Counterparty page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Capital SA-CCR by Counterparty", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Capital SA-CCR by Counterparty verified successfully");
		} else {
			GeneralUtil.logger
					.error("Risk bookmark Capital SA-CCR by Counterparty not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsWhatIfCapitalSACCRbyCounterparty",alwaysRun=true)
	public void exposuresReportCalculation_calculationsWhatIfCapitalSACCRbyNettingSet() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Capital SA-CCR by Netting Set");

			Reporter.log("Test Case: Risk Bookmark Validation For Capital SA-CCR by Netting Set", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			// What-If Post-Margin Incremental CVA bookmark validation
			
			Reporter.log("Test Step: Click On Capital SA-CCR by Netting Set", 1, true);
			//driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[text()='Capital SA-CCR by Counterparty']")).click();
			
			WebElement capitalSACCRbyCounterpartyElement = driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[contains(text(),'Capital SA-CCR by Netting Set')]"));
			capitalSACCRbyCounterpartyElement.click();
			
			

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Capital SA-CCR",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th[3]");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber + 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Capital SA-CCR by Netting Set value "
								+ strCellData
								+ " is displayed in the Risk Capital SA-CCR by Netting Set page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Capital SA-CCR by Netting Set value is not displayed in the Risk Capital SA-CCR by Netting Set page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Capital SA-CCR by Netting Set", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Capital SA-CCR by Netting Set verified successfully");
		} else {
			GeneralUtil.logger
					.error("Risk bookmark Capital SA-CCR by Netting Set not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsWhatIfCapitalSACCRbyNettingSet",alwaysRun=true)
	public void exposuresReportCalculation_calculationsWhatIfNettingSetSACCR() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Netting Set SA-CCR");

			Reporter.log("Test Case: Risk Bookmark Validation For Netting Set SA-CCR", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			// What-If Post-Margin Incremental CVA bookmark validation
			
			Reporter.log("Test Step: Click On Netting Set SA-CCR", 1, true);
			//driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[text()='Capital SA-CCR by Counterparty']")).click();
			
			WebElement capitalSACCRbyCounterpartyElement = driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[contains(text(),'Netting Set SA-CCR')]"));
			capitalSACCRbyCounterpartyElement.click();
			
			

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"SA-CCR Netting Set",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th[2]");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Netting Set SA-CCR value "
								+ strCellData
								+ " is displayed in the Risk Netting Set SA-CCR page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Netting Set SA-CCR value is not displayed in the Risk Netting Set SA-CCR page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Netting Set SA-CCR", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Netting Set SA-CCR verified successfully");
		} else {
			GeneralUtil.logger
					.error("Risk bookmark Netting Set SA-CCR not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsWhatIfNettingSetSACCR",alwaysRun=true)
	public void exposuresReportCalculation_calculationsWhatIfPFEEEComparison() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for PFE/E-E Comparison");

			Reporter.log("Test Case: Risk Bookmark Validation For PFE/E-E Comparison", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			// What-If Post-Margin Incremental CVA bookmark validation
			
			Reporter.log("Test Step: Click On PFE/E-E Comparison", 1, true);
			//driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[text()='Capital SA-CCR by Counterparty']")).click();
			
			WebElement capitalSACCRbyCounterpartyElement = driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[contains(text(),'PFE/E-E Comparison')]"));
			capitalSACCRbyCounterpartyElement.click();
			
			

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"EPE",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[7]/th[2]");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber + 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("PFE/E-E Comparison value "
								+ strCellData
								+ " is displayed in the Risk PFE/E-E Comparison page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("PFE/E-E Comparison value is not displayed in the Risk PFE/E-E Comparison page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For PFE/E-E Comparison", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark PFE/E-E Comparison verified successfully");
		} else {
			GeneralUtil.logger
					.error("Risk bookmark PFE/E-E Comparison not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsWhatIfPFEEEComparison",alwaysRun=true)
	public void exposuresReportCalculation_calculationsWhatIfPFEEEComparisonFull() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for PFE/E-E Full Comparison");

			Reporter.log("Test Case: Risk Bookmark Validation For PFE/E-E Full Comparison", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			// What-If Post-Margin Incremental CVA bookmark validation
			
			Reporter.log("Test Step: Click On PFE/E-E Full Comparison", 1, true);
			//driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[text()='Capital SA-CCR by Counterparty']")).click();
			
			WebElement capitalSACCRbyCounterpartyElement = driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[contains(text(),'PFE/E-E Full Comparison')]"));
			capitalSACCRbyCounterpartyElement.click();
			
			

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"EPE",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[8]/th[2]");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber + 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("PFE/E-E Full Comparison value "
								+ strCellData
								+ " is displayed in the Risk PFE/E-E Full Comparison page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("PFE/E-E Full Comparison value is not displayed in the Risk PFE/E-E Full Comparison page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For PFE/E-E Full Comparison", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark PFE/E-E Full Comparison verified successfully");
		} else {
			GeneralUtil.logger
					.error("Risk bookmark PFE/E-E Full Comparison not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsWhatIfPFEEEComparisonFull",alwaysRun=true)
	public void exposuresReportCalculation_calculationsWhatIfPFEEEGraph() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for PFE/E-E Graph");

			Reporter.log("Test Case: Risk Bookmark Validation For PFE/E-E Graph", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			// What-If Post-Margin Incremental CVA bookmark validation
			
			Reporter.log("Test Step: Click On PFE/E-E Graph", 1, true);
			//driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[text()='Capital SA-CCR by Counterparty']")).click();
			
			WebElement capitalSACCRbyCounterpartyElement = driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[contains(text(),'PFE/E-E Graph')]"));
			capitalSACCRbyCounterpartyElement.click();
			
			

			if (driver.findElement(By.xpath("//canvas[@class='overlay']")).isEnabled()) {
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("PFE/E-E Graph value "
								+ strCellData
								+ " is displayed in the Risk PFE/E-E Graph page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("PFE/E-E Graph value is not displayed in the Risk PFE/E-E Graph page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For PFE/E-E Graph", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark PFE/E-E Graph verified successfully");
		} else {
			GeneralUtil.logger
					.error("Risk bookmark PFE/E-E Graph not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsWhatIfPFEEEGraph",alwaysRun=true)
	public void exposuresReportCalculation_calculationsWhatIfXVAComparison() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for XVA Comparison");

			Reporter.log("Test Case: Risk Bookmark Validation For XVA Comparison", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			// What-If Post-Margin Incremental CVA bookmark validation
			
			Reporter.log("Test Step: Click On XVA Comparison", 1, true);
			//driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[text()='Capital SA-CCR by Counterparty']")).click();
			
			WebElement capitalSACCRbyCounterpartyElement = driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[contains(text(),'XVA Comparison')]"));
			capitalSACCRbyCounterpartyElement.click();
			
			Reporter.log("Test Step: Click On Result Scenarios: XVA Comparison", 1, true);
			WebElement baseElement = driver.findElement(By.xpath(".//*[@title='Result Scenarios: Base']/div"));
			
			Actions clicker = new Actions(driver);
			clicker.moveToElement(baseElement).perform();
			Thread.sleep(1000);	
			//clicker.moveToElement(baseElement).click().perform();
			
			// Click on Report Types
						WebElement objReportTypes = GeneralUtil
								.getElement(
										".//div[@class='gwt-TabPanelBottom']//div[starts-with(text(),'Trade Status:')]",
										"xpath", dynamicTimeOut);
						objReportTypes.click();
						Thread.sleep(1000);		
			// Click on All Booked checkbox
			WebElement objBookedCheckbox = GeneralUtil
			.getElement(
			"//div/span/label[text()='Booked']/preceding-sibling::input",
			"xpath", dynamicTimeOut);
			objBookedCheckbox.click();
			GeneralUtil.logger
			.info("Checked Booked check box.");
			
			driver.findElement(By.xpath("//a[text() = 'Ok']")).click();
			Thread.sleep(2000);	
			

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Base",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[4]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("XVA Comparison value "
								+ strCellData
								+ " is displayed in the Risk XVA Comparison page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("XVA Comparison value is not displayed in the Risk XVA Comparison page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For XVA Comparison", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark XVA Comparison verified successfully");
		} else {
			GeneralUtil.logger
					.error("Risk bookmark XVA Comparison not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsWhatIfXVAComparison",alwaysRun=true)
	public void exposuresReportCalculation_calculationsWhatIfXVAImpactChart() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for XVA Impact Chart");

			Reporter.log("Test Case: Risk Bookmark Validation For XVA Impact Chart", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			// What-If Post-Margin Incremental CVA bookmark validation
			
			Reporter.log("Test Step: Click On XVA Impact Chart", 1, true);
			//driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[text()='Capital SA-CCR by Counterparty']")).click();
			
			WebElement capitalSACCRbyCounterpartyElement = driver.findElement(By.xpath(".//div[@class='gwt-HTML']/span[contains(text(),'XVA Impact Chart')]"));
			capitalSACCRbyCounterpartyElement.click();
			
			Reporter.log("Test Step: Click On Result Scenarios: XVA Impact Chart", 1, true);
			WebElement baseElement = driver.findElement(By.xpath(".//*[@title='Result Scenarios: Base']/div"));
			
			Actions clicker = new Actions(driver);
			clicker.moveToElement(baseElement).perform();
			Thread.sleep(1000);	
			//clicker.moveToElement(baseElement).click().perform();
			
			// Click on Report Types
						WebElement objReportTypes = GeneralUtil
								.getElement(
										".//div[@class='gwt-TabPanelBottom']//div[starts-with(text(),'Trade Status:')]",
										"xpath", dynamicTimeOut);
						objReportTypes.click();
						Thread.sleep(2000);		
			// Click on All Booked checkbox
			WebElement objBookedCheckbox = GeneralUtil
			.getElement(
			"//div/span/label[text()='Booked']/preceding-sibling::input",
			"xpath", dynamicTimeOut);
			objBookedCheckbox.click();
			GeneralUtil.logger
			.info("Checked Booked check box.");
			
			driver.findElement(By.xpath("//a[text() = 'Ok']")).click();
			Thread.sleep(3000);	
			

			if (driver.findElement(By.xpath("//canvas[@class='overlay']")).isEnabled()) {
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("XVA Impact Chart value "
								+ strCellData
								+ " is displayed in the Risk XVA Impact Chart page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("XVA Impact Chart value is not displayed in the Risk XVA Impact Chart page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For XVA Impact Chart", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark XVA Impact Chart verified successfully");
		} else {
			GeneralUtil.logger
					.error("Risk bookmark XVA Impact Chart not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@AfterClass
	public void afterClass() throws Exception {
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		Common.loginOffXVA();
		Browser.quitBrowser();
		Thread.sleep(2000);
		}

	public void clickExpandCounterpartyRiskCapital(String expValue, String subExpValue) throws InterruptedException {
		WebElement expandElement = driver.findElement(By
				.xpath("//div[@class= 'gwt-TabPanelBottom']/div[2]/div/table/tbody/tr[2]/td/div[@class='gwt-Tree']/div[3]/table/tbody/tr/td[1]"));
		expandElement.click();
		Thread.sleep(1000);
		List<WebElement> txtPublicElement = driver.findElements(By
				.xpath("//div[@class='gwt-Tree']/div[3]/div/div"));
		int i = 0;
		for (i = 0; i <= txtPublicElement.size(); i++) {
			String publicText = txtPublicElement.get(i).getText();

			if (publicText.contains(expValue)) {
				WebElement subPublicExpand = driver
						.findElement(By.xpath(String
								.format("//div[@class='gwt-Tree']/div[3]/div/div[%d]/table/tbody/tr/td[1]",
										i + 1)));
				subPublicExpand.click();
				break;

			}
		}
		Thread.sleep(1000);
		List<WebElement> txtSubElement = driver.findElements(By.xpath(String
				.format("//div[@class='gwt-Tree']/div[3]/div/div[%d]/div/div",
						i + 1)));
		int j = 0;
		for (j = 0; j <= txtSubElement.size(); j++) {
			String subText = txtSubElement.get(j).getText();

			if (subText.contains(subExpValue)) {
				WebElement subCounterpartyRiskExpand = driver
						.findElement(By.xpath(String
								.format("//div[@style='white-space: nowrap;']/div[%d]/div/div[%d]/table/tbody/tr/td[1]",
										i + 1, j + 1)));
				subCounterpartyRiskExpand.click();
				break;

			}
		}
	}
	
	public void clickExpandCounterpartyRisk(String expValue, String subExpValue) throws InterruptedException {
		WebElement expandElement = driver.findElement(By
				.xpath("//div[@class= 'gwt-TabPanelBottom']/div[2]/div/table/tbody/tr[2]/td/div[@class='gwt-Tree']/div[3]/table/tbody/tr/td[1]"));
		expandElement.click();
		Thread.sleep(1000);
		List<WebElement> txtPublicElement = driver.findElements(By
				.xpath("//div[@class='gwt-Tree']/div[3]/div/div"));
		int i = 0;
		for (i = 0; i <= txtPublicElement.size(); i++) {
			String publicText = txtPublicElement.get(i).getText();

			if (publicText.contains(expValue)) {
				WebElement subPublicExpand = driver
						.findElement(By.xpath(String
								.format("//div[@class='gwt-Tree']/div[3]/div/div[%d]/table/tbody/tr/td[1]",
										i)));
				subPublicExpand.click();
				break;

			}
		}
		Thread.sleep(1000);
		List<WebElement> txtSubElement = driver.findElements(By.xpath(String
				.format("//div[@class='gwt-Tree']/div[3]/div/div[%d]/div/div",
						i)));
		int j = 0;
		for (j = 0; j <= txtSubElement.size(); j++) {
			String subText = txtSubElement.get(j).getText();

			if (subText.contains(subExpValue)) {
				WebElement subCounterpartyRiskExpand = driver
						.findElement(By.xpath(String
								.format("//div[@style='white-space: nowrap;']/div[%d]/div/div[%d]/table/tbody/tr/td[1]",
										i, j + 1)));
				subCounterpartyRiskExpand.click();
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

	public String getToday(String format) {
		Date date = new Date();
		return new SimpleDateFormat(format).format(date);
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
