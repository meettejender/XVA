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

public class ExposuresReportCalculation {

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
			Thread.sleep(5000);
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
			Thread.sleep(1000);
			
			//Get the date from Selected Markets
			Reporter.log("Test Step: Click On CalculationType Dropdown", 1, true);
			WebElement objSecondCalculationType = GeneralUtil
					.getElement(
				"//div[contains(@class,'bodyContainer')]//div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/span[3]",
				"xpath", dynamicTimeOut);
			objSecondCalculationType.click();
			
			// Select CalculationType item
						Reporter.log("Test Step: Select The Monte Carlo VaR From Dropdown Of Calculation Type", 1, true);
						GeneralUtil.dropDownItemvisible(
								"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
								"Monte Carlo VaR", "Calculation Type");
						GeneralUtil.logger
								.info("Selected Calculation Type as Monte Carlo VaR Reports");
						Thread.sleep(1000);
						
						//Get the date from Selected Markets
						Reporter.log("Test Step: Click On CalculationType Dropdown", 1, true);
						WebElement objthirdCalculationType = GeneralUtil
								.getElement(
							"//div[contains(@class,'bodyContainer')]//div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/span[4]",
							"xpath", dynamicTimeOut);
						objthirdCalculationType.click();
						
			// Select CalculationType item
						Reporter.log("Test Step: Select The Regulatory Capital From Dropdown Of Calculation Type", 1, true);
						GeneralUtil.dropDownItemvisible(
								"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
								"Regulatory Capital", "Calculation Type");
						GeneralUtil.logger
								.info("Selected Calculation Type as Regulatory Capital Reports");
						Thread.sleep(1000);
			/*driver.findElement(
					By.xpath(".//*[@class='ReactTabs react-tabs']/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/span[3]")).click();
			
			driver.findElement(
					By.xpath("//div[@class='Select-menu-outer']/div/div[1]/div/div/div[3]")).click();*/
			
			// Enter trade ids
			Reporter.log("Test Step: Enter id<=55 trade ids in Trade Selection", 1, true);
			WebElement objTradeSelection = GeneralUtil
					.getElement(
							"//div[contains(@class,'bodyContainer')]//div/div[1]/div/div[4]/div/div/div[2]/div[2]/div/div[1]/div/input",
							"xpath", dynamicTimeOut);
			objTradeSelection.sendKeys("id<=55");
			GeneralUtil.logger.info("Entered id<=55 trade ids in Trade Selection");

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
			
			
			// Click on Risk Simulation Set-Up tab and enter details
						Reporter.log("Test Step: Click On Simulation Set-Up", 1, true);
						WebElement objSimulationSetUpTab = GeneralUtil.getElement(
								"//label[contains(text(),'Simulation Set-Up')]",
								"xpath", dynamicTimeOut);
						objSimulationSetUpTab.click();
						GeneralUtil.logger.info("Selected Risk Simulation Set-Up");
				
			// Click on Use Rating Simulation checkbox and verify Risk
			Reporter.log("Test Step: Check Use Rating Simulation check box", 1, true);
			WebElement objUseRatingSimulationCheckbox = GeneralUtil.getElement(
										"//div/span/label/span[text()='Use Rating Simulation']/following::label[1]",
										"xpath", dynamicTimeOut);
			objUseRatingSimulationCheckbox.click();
			GeneralUtil.logger.info("Checked  Use Rating Simulation check box.");
			
			// Click on Calibration Parameters checkbox and verify Risk
						Reporter.log("Test Step: Check Calibration Parameters check box", 1, true);
						WebElement objCalibrationParametersCheckbox = GeneralUtil.getElement(
													"//div/span/label/span[text()='Calibration Parameters']/following::label[1]",
													"xpath", dynamicTimeOut);
						objCalibrationParametersCheckbox.click();
						GeneralUtil.logger.info("Checked  Calibration Parameters check box.");
			
			// Click on Calibration Report checkbox and verify Risk
			Reporter.log("Test Step: Check Calibration Report check box", 1, true);
			WebElement objCalibrationReportCheckbox = GeneralUtil.getElement(
													"//div/span/label/span[text()='Calibration Report']/following::label[1]",
													"xpath", dynamicTimeOut);
			objCalibrationReportCheckbox.click();
			GeneralUtil.logger.info("Checked  Calibration Report check box.");

			// Click on Align CSA Margin Call Dates To Observation Dates checkbox and verify Risk
						Reporter.log("Test Step: Check Align CSA Margin Call Dates To Observation Dates check box", 1, true);
						WebElement objAlignCSACheckbox = GeneralUtil.getElement(
																"//div/span/label/span[text()='Align CSA Margin Call Dates To Observation Dates']/following::label[1]",
																"xpath", dynamicTimeOut);
						objAlignCSACheckbox.click();
						GeneralUtil.logger.info("Checked  Align CSA Margin Call Dates To Observation Dates check box.");
						
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
			
			Reporter.log("Test Step: Check Calculate XVA Standalone Checkbox", 1, true);
			WebElement objCalculateXVAStandalone = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Calculate XVA Standalone']/following::label[1]",
							"xpath", dynamicTimeOut);
			objCalculateXVAStandalone.click();
			GeneralUtil.logger
					.info("Checked Calculate XVA Standalone checkbox box.");
			
			Reporter.log("Test Step: Check Calculate XVA Marginal Checkbox", 1, true);
			WebElement objCalculateXVAMarginal = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Calculate XVA Marginal']/following::label[1]",
							"xpath", dynamicTimeOut);
			objCalculateXVAMarginal.click();
			GeneralUtil.logger
					.info("Checked Calculate XVA Marginal checkbox box.");
			
			Reporter.log("Test Step: Check Calculate XVA Incremental Checkbox", 1, true);
			WebElement objCalculateXVAIncremental = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Calculate XVA Incremental']/following::label[1]",
							"xpath", dynamicTimeOut);
			objCalculateXVAIncremental.click();
			GeneralUtil.logger
					.info("Checked Calculate XVA Incremental box.");

			Reporter.log("Test Step: Check Calculate XVA Pre-Margin Measures Checkbox", 1, true);
			WebElement objCalculateXVAPreMarginMeasures = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Calculate XVA Pre-Margin Measures']/following::label[1]",
							"xpath", dynamicTimeOut);
			objCalculateXVAPreMarginMeasures.click();
			GeneralUtil.logger
					.info("Checked Calculate XVA Pre-Margin Measures checkbox box.");

			Reporter.log("Test Step: Check XVA Increments Checkbox", 1, true);
			WebElement objXVAIncrements = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='XVA Increments']/following::label[1]",
							"xpath", dynamicTimeOut);
			objXVAIncrements.click();
			GeneralUtil.logger.info("Checked XVA Increments checkbox box.");
			
			Reporter.log("Test Step: Check Calculate PFE Pre-Margin Measures Checkbox", 1, true);
			WebElement objCalculatePFEPreMarginMeasures = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Calculate PFE Pre-Margin Measures']/following::label[1]",
							"xpath", dynamicTimeOut);
			objCalculatePFEPreMarginMeasures.click();
			GeneralUtil.logger.info("Checked Calculate PFE Pre-Margin Measures checkbox box.");
			
			Reporter.log("Test Step: Select The Use Negative Exposures On Dropdown Item", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='ReactTabs react-tabs']/div/div/div[3]/div/div/div[2]/div/div[2]/div/div/div/div/div/span[3]"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Use Negative Exposures", "Exposure Type");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Select The Use Positive Exposures On Dropdown Item", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='ReactTabs react-tabs']/div/div/div[3]/div/div/div[2]/div/div[2]/div/div/div/div/div/span[4]"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Use Positive Exposures", "Exposure Type");
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			// Click on Regulatory Capital Set-Up tab and enter details
						Reporter.log("Test Step: Click On Regulatory Capital Set-Up", 1, true);
						WebElement objRegulatoryCapitalSetUpTab = GeneralUtil.getElement(
								"//label[contains(text(),'Regulatory Capital Set-Up')]",
								"xpath", dynamicTimeOut);
						objRegulatoryCapitalSetUpTab.click();
						GeneralUtil.logger.info("Selected Regulatory Capital Set-Up");

						GeneralUtil.captureScreenshot();
						
						Reporter.log("Test Step: Check Run SA-CCR Calculations Checkbox", 1, true);
						WebElement objRunSACCRCalculations = GeneralUtil
								.getElement(
										"//div/span/label/span[text()='Run SA-CCR Calculations']/following::label[1]",
										"xpath", dynamicTimeOut);
						objRunSACCRCalculations.click();
						GeneralUtil.logger.info("Checked Run SA-CCR Calculations checkbox box.");
						
						Reporter.log("Test Step: Check Run BASEL III CVA Calculations Checkbox", 1, true);
						WebElement objRunBASELIIICVACalculations = GeneralUtil
								.getElement(
										"//div/span/label/span[text()='Run BASEL III CVA Calculations']/following::label[1]",
										"xpath", dynamicTimeOut);
						objRunBASELIIICVACalculations.click();
						GeneralUtil.logger.info("Checked Run BASEL III CVA Calculations checkbox box.");
						
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

			
			/* * String tradeIdtext = driver .findElement( By.xpath(String.format(
			 * "//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div/div/span"
			 * , intactionColNumber,intRowNumber) )) .getText();*/
			 

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
			
			GeneralUtil.captureScreenshot();
			if (txtStatus.equalsIgnoreCase("100%")) {
				GeneralUtil.logger.info(strExposuresReport
						+ " Exposures Report calculation status is completed");
				WebElement objCellID = driver
						.findElement(By.xpath(String
								.format("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[%d]/div[%d]/div",
										intRowNumber+1, intColNumber-1)));
				strCellID = objCellID.getText();

			} else {
				GeneralUtil.logger
						.error(strExposuresReport
								+ " Exposures Report calculation status is not completed.Displayed status is "
								+ txtStatus);
			}
			Thread.sleep(25000);
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
	public void exposuresReportCalculation_calculationsExposuresCapitalSACCRbyCounterparty() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Capital SA-CCR by Counterparty");
			
			Reporter.log("Test Case: Risk Bookmark Validation For Capital SA-CCR By Counterparty", 1, true);
			Thread.sleep(17000);
			
			Reporter.log("Test Step: Click On Risk", 1, true);
	driver.findElement(
			By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Risk']"))
			.click();
	Thread.sleep(22000);
	driver.switchTo()
			.frame(driver.findElement(By
					.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[2]/div/iframe")));
	Thread.sleep(1000);

	// Capital bookmark validation

	Reporter.log("Test Step: Click And Expand Counterparty Risk and Capital In Counterparty Risk", 1, true);
	if (driver.findElement(
			By.xpath("//div[@class='GOJU4GFOT']/table/tbody/tr/td[3]"))
			.isDisplayed()) {
		clickExpandCounterpartyRiskCapital("Counterparty Risk", "Capital");

	} else {
		driver.findElement(
				By.xpath("//div[@class='GOJU4GFFR']/div[2]/div/table/tbody/tr/td[1]"))
				.click();
		driver.findElement(
				By.xpath("//div[@class='gwt-MenuBar gwt-MenuBar-vertical']/table/tbody/tr/td"))
				.click();
		clickExpandCounterpartyRiskCapital("Counterparty Risk", "Capital");
	}
			// Capital SA-CCR by Counterparty bookmark validation

			/*driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);*/
	
			Reporter.log("Test Step: Click On Capital SA-CCR By Counterparty", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Capital SA-CCR by Counterparty']"))
					.click();
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"PFE",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber - 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Capital SA-CCR by Counterparty PFE value "
								+ strCellData
								+ " is displayed in the Risk Capital SA-CCR by Counterparty PFE page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Capital SA-CCR by Counterparty PFE value is not displayed in the Risk Capital SA-CCR by Counterparty PFE page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Capital SA-CCR By Counterparty", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Capital SA-CCR by Counterparty PFE verified successfully");
		} else {
			throw new Exception("Risk bookmark Capital SA-CCR by Counterparty PFE not verified");
		}
	}

	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresCapitalSACCRbyCounterparty",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresCapitalSACCRbyNettingSet() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Capital SA-CCR by Netting Set");

			Reporter.log("Test Case: Risk Bookmark Validation For Capital SA-CCR By Netting Set", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			// Capital SA-CCR by Netting Set bookmark validation

			Reporter.log("Test Step: Click On Capital SA-CCR By Netting Set", 1, true);
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Capital SA-CCR by Netting Set']"))
					.click();

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"PFE",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber - 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Capital SA-CCR by Netting Set PFE value "
								+ strCellData
								+ " is displayed in the Risk Capital SA-CCR by Netting Set PFE page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Capital SA-CCR by Netting Set PFE value is not displayed in the Risk Capital SA-CCR by Netting Set PFE page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Capital SA-CCR By Netting Set", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Capital SA-CCR by Netting Set PFE verified successfully");
		} else {
			throw new Exception("Risk bookmark Capital SA-CCR by Netting Set PFE not verified");
		}
	}

	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresCapitalSACCRbyNettingSet",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresNettingSetSACCR() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Netting Set SA-CCR");

			Reporter.log("Test Case: Risk Bookmark Validation For Netting Set SA-CCR", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			// Netting Set SA-CCR bookmark validation

			Reporter.log("Test Step: Click On Netting Set SA-CCR", 1, true);
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Netting Set SA-CCR']"))
					.click();

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"PFE",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber + 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Netting Set SA-CCR PFE value "
								+ strCellData
								+ " is displayed in the Risk Netting Set SA-CCR PFE page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Netting Set SA-CCR PFE value is not displayed in the Risk Netting Set SA-CCR PFE page and failed");
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
					.info("Risk bookmark Netting Set SA-CCR PFE verified successfully");
		} else {
			throw new Exception("Risk bookmark Netting Set SA-CCR PFE not verified");
		}
	}

	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresNettingSetSACCR",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresAveragePFE() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Average PFE EPE ENE EE by Counterparty");

			Reporter.log("Test Case: Risk Bookmark Validation For Average PFE EPE ENE EE By Counterparty", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			// PFE bookmark validation
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(3000);
			WebElement closeElement = driver
					.findElement(By
							.xpath("//div[@style='white-space: nowrap;']/div[3]/div/div[1]/table/tbody/tr/td[1]"));
			closeElement.click();
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//div[@class='gwt-Tree']/div[3]/div/div[3]/table/tbody/tr/td[1]"))
					.click();
			Thread.sleep(2000);
			WebElement expandElement = driver
					.findElement(By
							.xpath("//div[@class= 'gwt-TabPanelBottom']/div[2]/div/table/tbody/tr[2]/td/div[@class='gwt-Tree']/div[3]/table/tbody/tr/td[1]"));
			expandElement.click();
			Thread.sleep(2000);
			
			Reporter.log("Test Step: Click And Expand PFE From Counterparty Risk", 1, true);
			clickExpandCounterpartyRisk("Counterparty Risk", "PFE");

			// Average PFE EPE ENE EE by Counterparty bookmark validation

			Reporter.log("Test Step: Click On Average PFE/E-E By Counterparty", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Average PFE/E-E by Counterparty']"))
					.click();

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Pre-Margin Average PFE.RPT",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[3]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Average PFE EPE ENE EE by Counterparty PVs value "
								+ strCellData
								+ " is displayed in the Risk Average PFE/E-E by Counterparty PVs page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Average PFE/E-E by Counterparty PFE value is not displayed in the Risk Average PFE EPE ENE EE by Counterparty PFE page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Average PFE EPE ENE EE By Counterparty", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Average PFE/E-E by Counterparty PFE verified successfully");
		} else {
			throw new Exception("Risk bookmark Average PFE/E-E by Counterparty PFE not verified");
		}
	}

	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresAveragePFE",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresEffectivePFE() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Effective PFE EPE ENE EE by Counterparty");

			Reporter.log("Test Case: Risk Bookmark Validation For Effective PFE EPE ENE EE By Counterparty", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			
			
			// Effective PFE EPE ENE EE by Counterparty bookmark validation

			Reporter.log("Test Step: Click On Effective PFE/E-E By Counterparty", 1, true);
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Effective PFE/E-E by Counterparty']"))
					.click();

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Pre-Margin Effective PFE.RPT",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[3]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Effective PFE EPE ENE EE by Counterparty PFE value "
								+ strCellData
								+ " is displayed in the Risk Effective PFE EPE ENE EE by Counterparty PFE page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Effective PFE EPE ENE EE by Counterparty PFE value is not displayed in the Risk Effective PFE EPE ENE EE by Counterparty PFE page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Effective PFE EPE ENE EE By Counterparty", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Effective PFE EPE ENE EE by Counterparty PFE verified successfully");
		} else {
			throw new Exception("Risk bookmark Effective PFE EPE ENE EE by Counterparty PFE not verified");
		}
	}

	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresEffectivePFE",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresNegativePFE() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Negative PFE/ENE Time Profile by Counterparty");

			Reporter.log("Test Case: Risk Bookmark Validation For Negative PFE/ENE Time Profile by Counterparty", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;

			// Effective PFE EPE ENE EE by Counterparty bookmark validation

			Reporter.log("Test Step: Click On Negative PFE/ENE Time Profile by Counterparty", 1, true);
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Negative PFE/ENE Time Profile by Counterparty']"))
					.click();

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Post-Margin Negative ENE.RPT",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[3]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Negative PFE/ENE Time Profile by Counterparty value "
								+ strCellData
								+ " is displayed in the Risk Negative PFE/ENE Time Profile by Counterparty page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Negative PFE/ENE Time Profile by Counterparty value is not displayed in the Risk Negative PFE/ENE Time Profile by Counterparty page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Negative PFE/ENE Time Profile by Counterparty", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Negative PFE/ENE Time Profile by Counterparty verified successfully");
		} else {
			throw new Exception("Risk bookmark Negative PFE/ENE Time Profile by Counterparty not verified");
		}
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresNegativePFE",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresPositivePFE() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Positive PFE/ENE Time Profile by Counterparty");

			Reporter.log("Test Case: Risk Bookmark Validation For Positive PFE/ENE Time Profile by Counterparty", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;

			// Effective PFE EPE ENE EE by Counterparty bookmark validation

			Reporter.log("Test Step: Click On Positive PFE/EPE Time Profile by Counterparty", 1, true);
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Positive PFE/EPE Time Profile by Counterparty']"))
					.click();

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Post-Margin Positive PFE.RPT",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[3]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Positive PFE/ENE Time Profile by Counterparty value "
								+ strCellData
								+ " is displayed in the Risk Positive PFE/ENE Time Profile by Counterparty page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Positive PFE/ENE Time Profile by Counterparty value is not displayed in the Risk Positive PFE/ENE Time Profile by Counterparty page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Positive PFE/ENE Time Profile by Counterparty", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Positive PFE/ENE Time Profile by Counterparty verified successfully");
		} else {
			throw new Exception("Risk bookmark Positive PFE/ENE Time Profile by Counterparty not verified");
		}
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresPositivePFE",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresPostMarginIncrementalPFE() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Post-Margin Incremental PFE");

			Reporter.log("Test Case: Risk Bookmark Validation For Post-Margin Incremental PFE", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;

			// Effective PFE EPE ENE EE by Counterparty bookmark validation

			Reporter.log("Test Step: Click On Post-Margin Incremental PFE - Graph", 1, true);
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Post-Margin Incremental PFE - Graph']"))
					.click();

			if (driver.findElement(By.xpath("//canvas[@class='overlay']")).isEnabled()) {
				
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Post-Margin Incremental PFE - Graph value "
								+ strCellData
								+ " is displayed in the Risk Post-Margin Incremental PFE - Graph page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Post-Margin Incremental PFE value is not displayed in the Risk Post-Margin Incremental PFE - Graph page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Post-Margin Incremental PFE - Graph", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Post-Margin Incremental PFE - Graph verified successfully");
		} else {
			throw new Exception("Risk bookmark Post-Margin Incremental PFE - Graph not verified");
		}
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresPostMarginIncrementalPFE",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresPostMarginPFE() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Post-Margin Incremental PFE");

			Reporter.log("Test Case: Risk Bookmark Validation For Post-Margin Incremental PFE", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;

			// Post-Margin Incremental PFE bookmark validation

			Reporter.log("Test Step: Click On Pre-Margin PFE By Counterparty", 1, true);
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Pre-Margin PFE by Counterparty']"))
					.click();

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Pre-Margin EE.RPT",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[3]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber - 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Post-Margin Incremental PFE value "
								+ strCellData
								+ " is displayed in the Risk Post-Margin Incremental PFE page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Post-Margin Incremental PFE value is not displayed in the Risk Post-Margin Incremental PFE page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Post-Margin Incremental PFE", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Post-Margin Incremental PFE verified successfully");
		} else {
			throw new Exception("Risk bookmark Post-Margin Incremental PFE PFE not verified");
		}
	}

	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresPostMarginPFE",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresPostMarginCounterparty() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Post-Margin PFE by Counterparty");

			Reporter.log("Test Case: Risk Bookmark Validation For Post-Margin PFE By Counterparty", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;

			// Post-Margin PFE by Counterparty bookmark validation

			Reporter.log("Test Step: Click On Post-Margin PFE By Counterparty", 1, true);
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Post-Margin PFE by Counterparty']"))
					.click();
			
			
			

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Post-Margin PFE.RPT",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[3]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber + 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Post-Margin PFE by Counterparty PFE value "
								+ strCellData
								+ " is displayed in the Risk Post-Margin PFE by Counterparty PFE page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Post-Margin PFE by Counterparty PFE value is not displayed in the Risk Post-Margin PFE by Counterparty PFE page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Post-Margin PFE By Counterparty", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Post-Margin PFE by Counterparty PFE verified successfully");
		} else {
			throw new Exception("Risk bookmark Post-Margin PFE by Counterparty PFE PFE not verified");
		}
	}

	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresPostMarginCounterparty",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresPostMarginIncrementalXVA() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Post-Margin Incremental XVA");

			Reporter.log("Test Case: Risk Bookmark Validation For Post-Margin Incremental XVA", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			// XVA bookmark validation
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(3000);
			WebElement closeElement = driver
					.findElement(By
							.xpath("//div[@style='white-space: nowrap;']/div[3]/div/div[3]/table/tbody/tr/td[1]"));
			closeElement.click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Click And Expand Counterparty Risk And Expand XVA In Counterparty Risk", 1, true);
			driver.findElement(
					By.xpath("//div[@class='gwt-Tree']/div[3]/div/div[3]/table/tbody/tr/td[1]"))
					.click();
			WebElement expandElement = driver
					.findElement(By
							.xpath("//div[@class= 'gwt-TabPanelBottom']/div[2]/div/table/tbody/tr[2]/td/div[@class='gwt-Tree']/div[3]/table/tbody/tr/td[1]"));
			expandElement.click();
			Thread.sleep(1000);
			clickExpandCounterpartyRisk("Counterparty Risk", "XVA");

			// Post-Margin Incremental XVA bookmark validation

			Reporter.log("Test Step: Click On Post-Margin Incremental XVA", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Post-Margin Incremental XVA']"))
					.click();

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Post-Margin CVA Unilateral.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber - 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Post-Margin Incremental XVA PVs value "
								+ strCellData
								+ " is displayed in the Risk Post-Margin Incremental XVA PVs page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Post-Margin Incremental XVA PVs value is not displayed in the Risk Post-Margin Incremental XVA PVs page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Post-Margin Incremental XVA", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Post-Margin Incremental XVA PVs verified successfully");
		} else {
			throw new Exception("Risk bookmark Post-Margin Incremental XVA PVs not verified");
		}
	}

	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresPostMarginIncrementalXVA",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresPostMarginMarginalXVA() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Post-Margin Marginal XVA");

			Reporter.log("Test Case: Risk Bookmark Validation For Post-Margin Marginal XVA", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);

			// Post-Margin Marginal XVA bookmark validation
			
			Reporter.log("Test Step: Click On Post-Margin Marginal XVA", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Post-Margin Marginal XVA']"))
					.click();

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Post-Margin CVA Unilateral.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber - 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Post-Margin Marginal XVA PVs value "
								+ strCellData
								+ " is displayed in the Risk Post-Margin Marginal XVA PVs page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Post-Margin Marginal XVA PVs value is not displayed in the Risk Post-Margin Marginal XVA PVs page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Post-Margin Marginal XVA", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Post-Margin Marginal XVA PVs verified successfully");
		} else {
			throw new Exception("Risk bookmark Post-Margin Marginal XVA PVs not verified");
		}
	}

	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresPostMarginMarginalXVA",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresPostMarginXVA() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Post-Margin XVA");
			
			Reporter.log("Test Case: Risk Bookmark Validation For Post-Margin XVA", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);

			// Post-Margin XVA bookmark validation

			Reporter.log("Test Step: Click On Post-Margin XVA", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Post-Margin XVA']"))
					.click();

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Post-Margin CVA Unilateral.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber - 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Post-Margin XVA PVs value "
						+ strCellData
						+ " is displayed in the Risk Post-Margin XVA PVs page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Post-Margin XVA PVs value is not displayed in the Risk Post-Margin XVA PVs page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Post-Margin XVA", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Post-Margin XVA PVs verified successfully");
		} else {
			throw new Exception("Risk bookmark Post-Margin XVA PVs not verified");
		}
	}

	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresPostMarginXVA",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresPostMarginXVAIncrementbyCounterparty() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Post-Margin XVA Increment by Counterparty");

			Reporter.log("Test Case: Risk Bookmark Validation For Post-Margin XVA Increment By Counterparty", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);

			// Post-Margin XVA Increment by Counterparty bookmark validation

			Reporter.log("Test Step: Click On Post-Margin XVA Increment By Counterparty", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Post-Margin XVA Increment by Counterparty']"))
					.click();

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Post-Margin BCVA Bilateral.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[3]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber - 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Post-Margin XVA Increment by Counterparty PVs value "
								+ strCellData
								+ " is displayed in the Risk Post-Margin XVA Increment by Counterparty PVs page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Post-Margin XVA Increment by Counterparty PVs value is not displayed in the Risk Post-Margin XVA Increment by Counterparty PVs page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Post-Margin XVA Increment By Counterparty", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Post-Margin XVA Increment by Counterparty PVs verified successfully");
		} else {
			throw new Exception("Risk bookmark Post-Margin XVA Increment by Counterparty PVs not verified");
		}
	}

	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresPostMarginXVAIncrementbyCounterparty",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresPostMarginXVAPortfolio() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Post-Margin XVA Portfolio Trade Allocation");

			Reporter.log("Test Case: Risk Bookmark Validation For Post-Margin XVA Portfolio Trade Allocation", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;

			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);

			// Post-Margin XVA Portfolio Trade Allocation bookmark validation

			Reporter.log("Test Step: Click On Post-Margin XVA Portfolio Trade Allocation", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Post-Margin XVA Portfolio Trade Allocation ']"))
					.click();

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Total Post-Margin CVA Unilateral Marginal Allocated.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Post-Margin XVA Portfolio Trade Allocation PVs value "
								+ strCellData
								+ " is displayed in the Risk Post-Margin XVA Portfolio Trade Allocation PVs page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Post-Margin XVA Portfolio Trade Allocation PVs value is not displayed in the Risk Post-Margin XVA Portfolio Trade Allocation PVs page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Post-Margin XVA Portfolio Trade Allocation", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Post-Margin XVA Portfolio Trade Allocation PVs verified successfully");
		} else {
			throw new Exception("Risk bookmark Post-Margin XVA Portfolio Trade Allocation PVs not verified");
		}
	}

	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresPostMarginXVAPortfolio",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresPreMarginXVA() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Pre-Margin XVA");

			Reporter.log("Test Case: Risk Bookmark Validation For Pre-Margin XVA", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;

			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);

			
			// Pre-Margin XVA bookmark validation

			Reporter.log("Test Step: Click On Pre-Margin XVA", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Pre-Margin XVA']"))
					.click();

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Pre-Margin CVA Unilateral.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Pre-Margin XVA PVs value "
						+ strCellData
						+ " is displayed in the Risk Pre-Margin XVA PVs page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Pre-Margin XVA PVs value is not displayed in the Risk Pre-Margin XVA PVs page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Pre-Margin XVA", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger.info("Pre-Margin XVA PVs verified successfully");
		} else {
			throw new Exception("Risk bookmark Pre-Margin XVA PVs not verified");
		}
	}

	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresPreMarginXVA",alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresPreMarginXVAIncrement() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Pre-Margin XVA Increment by Counterparty");

			Reporter.log("Test Case: Risk Bookmark Validation For Pre-Margin XVA Increment By Counterparty", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;

			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);

			// Pre-Margin XVA Increment by Counterparty bookmark validation

			Reporter.log("Test Step: Click On Pre-Margin XVA Increment By Counterparty", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Pre-Margin XVA Increment by Counterparty']"))
					.click();

			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Pre-Margin CVA Unilateral.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[3]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("Pre-Margin XVA Increment by Counterparty PVs value "
								+ strCellData
								+ " is displayed in the Risk Pre-Margin XVA Increment by Counterparty PVs page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Pre-Margin XVA Increment by Counterparty PVs value is not displayed in the Risk Pre-Margin XVA Increment by Counterparty PVs page and failed");
			}
			
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Pre-Margin XVA Increment By Counterparty", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Pre-Margin XVA Increment by Counterparty PVs verified successfully");
		} else {
			throw new Exception("Risk bookmark Pre-Margin XVA Increment by Counterparty PVs not verified");
		}
	}

	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresPreMarginXVAIncrement", alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresCombinedRiskViewTradeHierarchy() throws Exception {
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
			WebElement closeElement = driver
					.findElement(By
							.xpath("//div[@style='white-space: nowrap;']/div[3]/div/div[6]/table/tbody/tr/td[1]"));
			closeElement.click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//div[@class='gwt-Tree']/div[3]/div/div[3]/table/tbody/tr/td[1]"))
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
										1, intActColNumber + 1)));
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
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresCombinedRiskViewTradeHierarchy", alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresCombinedRiskViewNettingSet() throws Exception {
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
										1, intActColNumber + 1)));
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
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresCombinedRiskViewNettingSet", alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresContentsSynchronizationStatistics() throws Exception {
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
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresContentsSynchronizationStatistics", alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresContentsSynchronizedTradeCounts() throws Exception {
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
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresContentsSynchronizedTradeCounts", alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresCollateral() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Collateral in Exposures");

			Reporter.log("Test Case: Risk Bookmark Validation For Collateral in Exposures", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//div[@class='gwt-Tree']/div[3]/div/div[2]/table/tbody/tr/td[1]"))
					.click();

			Thread.sleep(1000);
			WebElement expandElement = driver
					.findElement(By
							.xpath("//div[@class= 'gwt-TabPanelBottom']/div[2]/div/table/tbody/tr[2]/td/div[@class='gwt-Tree']/div[3]/table/tbody/tr/td[1]"));
			expandElement.click();
			Thread.sleep(1000);
			clickExpandCombinedRiskView("Exposures");
			
			Reporter.log("Test Step: Click On Collateral", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Cash Collateral']"))
					.click();
			Thread.sleep(2000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"1",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[3]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Collateral value " + strCellData
						+ " is displayed in the Risk Cash Collateral page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Collateral value is not displayed in the Risk Cash Collateral page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Cash Collateral", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Collateral Cash Collateral successfully");
		} else {
			throw new Exception("Risk bookmark Cash Collateral not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresCollateral", alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresCreditRatingTransition() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Credit Rating Transition in Exposures");

			Reporter.log("Test Case: Risk Bookmark Validation For Credit Rating Transition in Exposures", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
					
			Reporter.log("Test Step: Click On Credit Rating Transition", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Credit Rating Transition']"))
					.click();
			
			Reporter.log("Test Step: Click On XVA Scenarios: Counterparties: Bank Of America", 1, true);
			WebElement baseElement = driver.findElement(By.xpath(".//*[@title='XVA Scenarios: -']/div"));
			
			Actions clicker = new Actions(driver);
			clicker.moveToElement(baseElement).perform();
			Thread.sleep(1000);	
			//clicker.moveToElement(baseElement).click().perform();
			
			// Click on Report Types
						WebElement objReportTypes = GeneralUtil
								.getElement(
										"//div[@class='gwt-TabPanelBottom']//div[text()='Counterparties: Bank Of America']",
										"xpath", dynamicTimeOut);
						objReportTypes.click();
						Thread.sleep(1000);		
			// Click on ALL checkbox
			WebElement objAllCheckbox = GeneralUtil
			.getElement(
			"//div/span/label[text()='(All)']/preceding-sibling::input",
			"xpath", dynamicTimeOut);
			objAllCheckbox.click();
			GeneralUtil.logger
			.info("Checked All check box.");
			
			Thread.sleep(1000);		
			// Click on JP Morgan Chase checkbox
			WebElement objCheckbox = GeneralUtil
			.getElement(
			"//div/span/label[text()='JP Morgan Chase']/preceding-sibling::input",
			"xpath", dynamicTimeOut);
			objCheckbox.click();
			GeneralUtil.logger
			.info("Checked JP Morgan Chase check box.");
			
			driver.findElement(By.xpath("//a[text() = 'Ok']")).click();
			Thread.sleep(2000);	
			
			Thread.sleep(2000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"1",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[4]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Credit Rating Transition value " + strCellData
						+ " is displayed in the Risk Credit Rating Transition page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Credit Rating Transition value is not displayed in the Risk Credit Rating Transition page and failed");
			}

			
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Credit Rating Transition verified successfully");
		} else {
			throw new Exception("Risk bookmark Credit Rating Transition not verified");
		}
		//driver.switchTo().defaultContent();
		Reporter.log("Test Case: Successfully Risk Bookmark Validated For Credit Rating Transition", 1, true);
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresCreditRatingTransition", alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresDiscountFactors() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Discount Factors in Exposures");

			Reporter.log("Test Case: Risk Bookmark Validation For Discount Factors in Exposures", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
					
			Reporter.log("Test Step: Click On Discount Factors", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Discount Factors']"))
					.click();
			Thread.sleep(8000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"1",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[3]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Discount Factors value " + strCellData
						+ " is displayed in the Risk Discount Factors page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Discount Factors value is not displayed in the Risk Discount Factors page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Discount Factors", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Discount Factors verified successfully");
		} else {
			throw new Exception("Risk bookmark Discount Factors not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresDiscountFactors", alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresExposureGraph() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Exposure Graph in Exposures");

			Reporter.log("Test Case: Risk Bookmark Validation For Exposure Graph in Exposures", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
					
			Reporter.log("Test Step: Click On Exposure Graph", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Exposure Graph']"))
					.click();
			Thread.sleep(2000);
			
			if (driver.findElement(By.xpath("//canvas[@class='overlay']")).isEnabled()) {
				
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Exposure Graph value is displayed in the Risk Exposure Graph page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Exposure Graph value is not displayed in the Risk Exposure Graph page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Exposure Graph", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Exposure Graph verified successfully");
		} else {
			throw new Exception("Risk bookmark Exposure Graph not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresExposureGraph", alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresExposureMatrix() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Exposure Matrix in Exposures");

			Reporter.log("Test Case: Risk Bookmark Validation For Exposure Matrix in Exposures", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
					
			Reporter.log("Test Step: Click On Exposure Matrix", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Exposure Matrix - Margin Set']"))
					.click();
			Thread.sleep(2000);
			
			/*Reporter.log("Test Step: Click On Result Scenarios: JP Morgan Chase", 1, true);
			WebElement baseElement = driver.findElement(By.xpath("//div[@class='gwt-TabPanelBottom'] //div[text() = 'XVA Scenarios: -']"));
			
			Actions clicker = new Actions(driver);
			clicker.moveToElement(baseElement).perform();
			Thread.sleep(1000);
			//clicker.moveToElement(baseElement).click().perform();
			
			// Click on Report Types
						WebElement objReportTypes = GeneralUtil
								.getElement(starts-with(
										"Counterparties: [Counterparties].[Counterparties])",
										"xpath", dynamicTimeOut);
								WebElement objReportTypes = driver.findElement(By.xpath("//div[@class='gwt-TabPanelBottom']//div[contains(text(),\"Counterparties: [Counterparties].[Counterparties].[ALL].[AllMember].[Bank Of America].[Bank Of America US]\")]"));		
						
						objReportTypes.click();
						Thread.sleep(2000);		
			// Click on JP Morgan Chase checkbox
			WebElement objNomuraCheckbox = GeneralUtil
			.getElement(
			"//div/span/label[text()='JP Morgan Chase']/preceding-sibling::input",
			"xpath", dynamicTimeOut);
			objNomuraCheckbox.click();
			GeneralUtil.logger
			.info("Checked JP Morgan Chase check box.");
			
			driver.findElement(By.xpath("//a[text() = 'Ok']")).click();*/
			
			Thread.sleep(12000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"1",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[7]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Exposure Matrix value " + strCellData
						+ " is displayed in the Risk Exposure Matrix page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Exposure Matrix value is not displayed in the Risk Exposure Matrix page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Risk Exposure Matrix", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Exposure Matrix verified successfully");
		} else {
			throw new Exception("Risk bookmark Exposure Matrix not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresExposureMatrix", alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresFXDistribution() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for FX Distribution in Exposures");

			Reporter.log("Test Case: Risk Bookmark Validation For FX Distribution in Exposures", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
					
			Reporter.log("Test Step: Click On FX Distribution", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='FX Distribution']"))
					.click();
			Thread.sleep(2000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"1",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[4]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("FX Distribution value " + strCellData
						+ " is displayed in the Risk FX Distribution page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("FX Distribution value is not displayed in the Risk FX Distribution page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Risk FX Distribution", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark FX Distribution verified successfully");
		} else {
			throw new Exception("Risk bookmark FX Distribution not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresFXDistribution", alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresHazardRates() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Hazard Rates in Exposures");

			Reporter.log("Test Case: Risk Bookmark Validation For Hazard Rates in Exposures", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
					
			Reporter.log("Test Step: Click On Hazard Rates", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Hazard Rates']"))
					.click();
			Thread.sleep(2000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"1",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[4]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Hazard Rates value " + strCellData
						+ " is displayed in the Risk Hazard Rates page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Hazard Rates value is not displayed in the Risk Hazard Rates page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Risk Hazard Rates", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Hazard Rates verified successfully");
		} else {
			throw new Exception("Risk bookmark Hazard Rates not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresHazardRates", alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresSelfHazardRates() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Self Hazard Rates in Exposures");

			Reporter.log("Test Case: Risk Bookmark Validation For Self Hazard Rates in Exposures", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
					
			Reporter.log("Test Step: Click On Self Hazard Rates", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Self Hazard Rates']"))
					.click();
			Thread.sleep(2000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"1",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[3]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Self Hazard Rates value " + strCellData
						+ " is displayed in the Risk Self Hazard Rates page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Self Hazard Rates value is not displayed in the Risk Self Hazard Rates page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Risk Self Hazard Rates", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Self Hazard Rates verified successfully");
		} else {
			throw new Exception("Risk bookmark Self Hazard Rates not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	//@Test(dependsOnMethods = "exposuresReportCalculation_calculationsExposuresSelfHazardRates", alwaysRun=true)
	public void exposuresReportCalculation_calculationsExposuresClearResults() throws Exception {
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
