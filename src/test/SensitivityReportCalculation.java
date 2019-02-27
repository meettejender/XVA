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

public class SensitivityReportCalculation {

	public WebDriver driver;
	public int dynamicTimeOut;

	boolean btnFlag = false;
	public String strSensitivityReport;
	public String strPricing;
	public String strExposuresReport;
	public String strCellID;
	public String strTrade = "CC_BermudanSwap";
	public String strTradeID = "2";
	public String strWhatIfID;

	@BeforeClass
	public void beforeClass() throws Exception {
		
		GeneralUtil.configureLog4j("SensitivityReportCalculation");
		GeneralUtil.logger("SensitivityReportCalculation");

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
	
	//@Test (alwaysRun=true)
	public void trades_filterIRTrades() throws Exception {
		Reporter.log("Test Case: Filter IR Trades And Save", 1, true);
		
		Reporter.log("Test Step: Click Trades", 1, true);
		try {
			GeneralUtil.logger.info("Started add Trade");
			driver.findElement(By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Trades']"))
					.click();
			try{
				if(driver.findElement(By.xpath("//div[@class='notifications-wrapper']//h4//following-sibling::div[@class='notification-message']")).isDisplayed()==true) {
			Common.handleNotifications("Failed to get trades filter for user Administrator");
				}
			}
				catch(Exception e){
					
				}
			GeneralUtil.captureScreenshot();
			WebElement contextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
			// Clear the filter for trade columns
						Reporter.log("Test Step: Clear The Trade Filter Columns", 1, true);
						GeneralUtil.contextMenu(contextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(1000);

						// Search asset class with 'IR'
						Reporter.log("Test Step: Search Asset Class With 'IR'", 1, true);
						WebElement SearchElementAssetClass = driver
								.findElement(By
										.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
						SearchElementAssetClass.clear();
						SearchElementAssetClass.sendKeys("IR");
						Thread.sleep(1000);
						
						Reporter.log("Test Step: Click On Save Filter The Trade Filter Columns", 1, true);
						GeneralUtil.contextMenu(contextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
										"Save Filter");
						Thread.sleep(1000);
			
			GeneralUtil.logger.info("Filter IR Trades And Save successfully");
			Reporter.log("Test Case: Successfully Filtered IR Trades And Save", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	//@Test(dependsOnMethods ={ "trades_filterIRTrades"})
	@Test (alwaysRun=true)
	public void sensitivityReportCalculation_Create() throws Exception {
		try {
			GeneralUtil.logger("Add and Calculate Sensitivity Report");
			
			Reporter.log("Test Case: Add And Calculate Sensitivity Report", 1, true);
			// logger =
			// Logger.getLogger("Started verifying left corner of the window locate tabs");
			// Navigate to Calculations screen
			
			Reporter.log("Test Step: Click On Calculations Tab", 1, true);
			String strCalculationsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Calculations']";
			WebElement objCalculation = GeneralUtil.getElement(
					strCalculationsXpath, "xpath", dynamicTimeOut);
			objCalculation.click();
			Thread.sleep(5000);
			GeneralUtil.captureScreenshot();
			GeneralUtil.logger
					.info("Navigated to Calculations by selecting the Calculations treeview item.");

			// Click new Calculation button
			
			Reporter.log("Test Step: Click On Add New Calculation Button", 1, true);
			WebElement objNewCalculationBtn = GeneralUtil
					.getElement(
							"//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[4]/div/div[1]/div[1]/div/div[1]/button",
							"xpath", dynamicTimeOut);
			objNewCalculationBtn.click();
			Thread.sleep(5000);
			GeneralUtil.logger.info("Clicked on add new Calculation button.");
			GeneralUtil.captureScreenshot();

			// Enter details in Job Set-Up tab after click on Add new
			// Calculation button
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Date());

			strSensitivityReport = "AUTO" + timeStamp;
			Thread.sleep(1000);
			// Enter Task Name
			
			Reporter.log("Test Step: Send Value To Task Name in Sub Window", 1, true);
			WebElement objTaskName = GeneralUtil
					.getElement(
							"//div[contains(@class,'bodyContainer')]//div/div[1]/div/div[1]/div/div[2]/div/input",
							"xpath", dynamicTimeOut);
			objTaskName.clear();
			objTaskName.sendKeys(strSensitivityReport);
			GeneralUtil.logger.info("Entered Task Name as "
					+ strSensitivityReport);

			// Enter Calculation Type
			
			Reporter.log("Test Step: Click On CalculationType Dropdown", 1, true);
			WebElement objCalculationType = GeneralUtil
					.getElement(
							"//div[contains(@class,'bodyContainer')]//div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/span[2]",
							"xpath", dynamicTimeOut);
			objCalculationType.click();
			// Enter CalculationType item
			
			Reporter.log("Test Step: Select The Sensitivity Reports From Dropdown Of Calculation Type", 1, true);
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Sensitivity Reports", "Calculation Type");
			GeneralUtil.logger
					.info("Selected Calculation Type as Sensitivity Reports");

			// Enter Trade Selection-By Expression
			
			Reporter.log("Test Step: Enter 120 to 139 Trade Id In Trade Selection", 1, true);
			WebElement objTradeSelection = GeneralUtil
					.getElement(
							"//div[contains(@class,'bodyContainer')]//div/div[1]/div/div[4]/div/div/div[2]/div[2]/div/div[1]/div/input",
							"xpath", dynamicTimeOut);
			objTradeSelection.sendKeys("120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139");
			GeneralUtil.logger.info("Entered 120 to 139 trade ids in Trade Selection");
			GeneralUtil.captureScreenshot();

			// Click on Sensitivity Report Set-Up tab and enter details
			
			Reporter.log("Test Step: Click On Sensitivity Report Set-Up Tab", 1, true);
			WebElement objSensitivityReportSetUpTab = GeneralUtil.getElement(
					"//label[contains(text(),'Sensitivity Report Set-Up')]",
					"xpath", dynamicTimeOut);
			objSensitivityReportSetUpTab.click();
			GeneralUtil.logger.info("Selected Sensitivity Report Set-Up tab");

			// Click on Report Type
			
			Reporter.log("Test Step: Click On Report Type Dropdown", 1, true);
			WebElement objReportType = GeneralUtil
					.getElement(
							"//div[contains(@class,'bodyContainer')]//div[contains(@class,'settingGroup')]/div[1]//div/span[2]",
							"xpath", dynamicTimeOut);
			objReportType.click();

			// Enter Report Type item
			
			Reporter.log("Test Step: Select IRDELTAGAMMA From Report Type Dropdown ", 1, true);
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"IRDELTAGAMMA", "Report Type");
			GeneralUtil.logger.info("Selected Report type as IRDELTAGAMMA");
			// Click on Report Type
			
			Reporter.log("Test Step: Click On Report Name Dropdown", 1, true);
			WebElement objReportName = GeneralUtil
					.getElement(
							"//div[contains(@class,'bodyContainer')]//div[contains(@class,'settingGroup')]/div[2]//div/span[2]",
							"xpath", dynamicTimeOut);
			objReportName.click();

			// Enter Report Nameitem
			
			Reporter.log("Test Step: Select IRDeltaGammaByInstrument From Report Name Dropdown", 1, true);
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"IRDeltaGammaByInstrument", "Report Name");
			GeneralUtil.logger
					.info("Selected Report Name as IRDeltaGammaByInstrument");
			
			Reporter.log("Test Step: Check EQ Spot Scenarios Checkbox", 1, true);
			WebElement objEQSpotScenarios = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='EQ Spot Scenarios']/following::label[1]",
							"xpath", dynamicTimeOut);
			objEQSpotScenarios.click();
			GeneralUtil.logger.info("Checked  EQ Spot Scenarios checkbox box.");
			
			Reporter.log("Test Step: Check EQ Spot Vol Scenarios Checkbox", 1, true);
			WebElement objEQSpotVolScenarios = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='EQ Spot Vol Scenarios']/following::label[1]",
							"xpath", dynamicTimeOut);
			objEQSpotVolScenarios.click();
			GeneralUtil.logger.info("Checked  EQ Spot Vol Scenarios checkbox box.");
			
			Reporter.log("Test Step: Check FX Spot Scenarios Checkbox", 1, true);
			WebElement objFXSpotScenarios = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='FX Spot Scenarios']/following::label[1]",
							"xpath", dynamicTimeOut);
			objFXSpotScenarios.click();
			GeneralUtil.logger.info("Checked  FX Spot Scenarios checkbox box.");
			
			Reporter.log("Test Step: Check IR Scenarios Checkbox", 1, true);
			WebElement objIRScenarios = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='IR Scenarios']/following::label[1]",
							"xpath", dynamicTimeOut);
			objIRScenarios.click();
			GeneralUtil.logger.info("Checked  IR Scenarios checkbox box.");
			
			Reporter.log("Test Step: Check Scenarios Checkbox", 1, true);
			WebElement objScenarios = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Scenarios']/following::label[1]",
							"xpath", dynamicTimeOut);
			objScenarios.click();
			GeneralUtil.logger.info("Checked  Scenarios checkbox box.");
			
			Reporter.log("Test Step: Check Scenarios On Scenarios Checkbox", 1, true);
			WebElement objScenariosOnScenarios = GeneralUtil
					.getElement(
							"//div/span/label/span[text()='Scenarios On Scenarios']/following::label[1]",
							"xpath", dynamicTimeOut);
			objScenariosOnScenarios.click();
			GeneralUtil.logger.info("Checked  Scenarios On Scenarios checkbox box.");
			
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
			// Click Calculate button
			
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
			Thread.sleep(5000);
			
			int intColNumber = Common.getColumnNumber("Task Name");
			int intRowNumber = Common.getRowNumber(intColNumber,
					strSensitivityReport);
			int intactionColNumber = Common.getColumnNumber("Jobs Progress");
			Thread.sleep(2000);
			String txtStatus = "";
			WebElement objCellStatus;
			int count = 1;

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
						.info(strSensitivityReport
								+ " Sensitivity Report calculation status is completed");
			} else {
				GeneralUtil.logger
						.error(strSensitivityReport
								+ " Sensitivity Report calculation status is not completed.Displayed status is "
								+ txtStatus);
			}

			Reporter.log("Test Case: Successfully Added And Calculated Sensitivity Report", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = "sensitivityReportCalculation_calculationsSensitivitiesTopdownRisk", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesBucketbyInstrument() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for IR Delta/Gamma by Bucket by Instrument - View by Trade by Risk Factor");
			
			Reporter.log("Test Case: Risk Bookmark Validation For IR Delta/Gamma By Bucket By Instrument - View By Trade By Risk Factor", 1, true);
			/*Thread.sleep(8000);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Risk']"))
					.click();
			Thread.sleep(14000);
			driver.switchTo()
					.frame(driver.findElement(By
							.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[2]/div/iframe")));*/
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			
			driver.findElement(
					By.xpath("//div[@style='white-space: nowrap;']/div[3]/div/div[1]/table/tbody/tr/td[1]"))
					.click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//div[@style='white-space: nowrap;']/div[5]/div/div[3]/table/tbody/tr/td[1]"))
					.click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//div[@class='gwt-Tree']/div[3]/div/div[5]/table/tbody/tr/td[1]"))
					.click();
			
			Thread.sleep(1000);
			WebElement expandElement = driver
					.findElement(By
							.xpath("//div[@class= 'gwt-TabPanelBottom']/div[2]/div/table/tbody/tr[2]/td/div[@class='gwt-Tree']/div[3]/table/tbody/tr/td[1]"));
			expandElement.click();
			// Navigate to Market Risk>Sensitivities>By Report Type
			
			Reporter.log("Test Step: Click And Expand ByReportType From Sensitivities From MarketRisk", 1, true);
			if (driver.findElement(
					By.xpath("//div[@class='GOJU4GFOT']/table/tbody/tr/td[3]"))
					.isDisplayed()) {
				clickExpandMarketRisk("Market Risk", "Sensitivities",
						"By Report Type");

			} else {
				driver.findElement(
						By.xpath("//div[@class='GOJU4GFFR']/div[2]/div/table/tbody/tr/td[1]"))
						.click();
				driver.findElement(
						By.xpath("//div[@class='gwt-MenuBar gwt-MenuBar-vertical']/table/tbody/tr/td"))
						.click();
				clickExpandMarketRisk("Market Risk", "Sensitivities",
						"By Report Type");
			}

			// IR Delta/Gamma by Bucket by Instrument - View by Trade by Risk
			// Factor bookmark validation
			
			Reporter.log("Test Step: Click On IR Delta/Gamma By Bucket By Instrument - View By Trade By Risk Factor", 1, true);
			WebElement ele=driver.findElement(By.xpath("//div[@class='gwt-HTML']/span[text()='IR Delta/Gamma by Bucket by Instrument - View by Trade by Risk Factor']"));
			/*Actions action = new Actions(driver).doubleClick(ele);
			action.build().perform();*/
			ele.click();
			ele.click();
			
			Reporter.log("Test Step: Click On Result Scenarios: IRDELTAGAMMABYINSTRUMENTANDBUCKET", 1, true);
			WebElement baseElement = driver.findElement(By.xpath(".//*[@title='Result Scenarios: Base']/div"));
			
			Actions clicker = new Actions(driver);
			clicker.moveToElement(baseElement).perform();
			Thread.sleep(1000);	
			//clicker.moveToElement(baseElement).click().perform();
			
			// Click on Report Types
						WebElement objReportTypes = GeneralUtil
								.getElement(
										".//div[@class='gwt-TabPanelBottom']//div[text()='Report Types: [Reports].[Report Types].[ALL].[AllMember].[IRDELTAGAMMABYINSTRUMENTANDBUCKET]']",
										"xpath", dynamicTimeOut);
						objReportTypes.click();
						Thread.sleep(1000);		
			// Click on All Calculations checkbox
			WebElement objCheckbox = GeneralUtil
			.getElement(
			"//div/span/label[text()='(All)']/preceding-sibling::input",
			"xpath", dynamicTimeOut);
			
			/*WebElement objCheckbox = GeneralUtil
					.getElement(
					"//div/span/label[text()='All Calculations']/preceding-sibling::input",
					"xpath", dynamicTimeOut);*/
			
			objCheckbox.click();
			Thread.sleep(1000);
			objCheckbox.click();
			GeneralUtil.logger
			.info("Checked All Calculations check box.");
			
			driver.findElement(By.xpath("//a[text() = 'Ok']")).click();
			Thread.sleep(2000);		
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"IR Delta",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[3]/th");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber + 1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger
						.info("IR Delta/Gamma by Bucket by Instrument - View by Trade by Risk Factor PVs value "
								+ strCellData
								+ " is displayed in the Risk IR Delta/Gamma by Bucket by Instrument - View by Trade by Risk Factor PVs page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("IR Delta/Gamma by Bucket by Instrument - View by Trade by Risk Factor PVs value is not displayed in the Risk IR Delta/Gamma by Bucket by Instrument - View by Trade by Risk Factor PVs page and failed");
			}
		
			Reporter.log("Test Case: Successfully Risk Bookmark Validated For IR Delta/Gamma By Bucket By Instrument - View By Trade By Risk Factor", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark IR Delta/Gamma by Bucket by Instrument - View by Trade by Risk Factor PVs verified successfully");
		} else {
			/*GeneralUtil.logger
					.error("Risk bookmark IR Delta/Gamma by Bucket by Instrument - View by Trade by Risk Factor PVs not verified");*/
			throw new Exception("Risk bookmark IR Delta/Gamma by Bucket by Instrument - View by Trade by Risk Factor PVs not verified");
			
		}
	}

	@Test(dependsOnMethods = "sensitivityReportCalculation_calculationsSensitivitiesperTradebyRiskFactorList", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesTopdownRisk() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Top-down Risk");
			
			Reporter.log("Test Case: Risk Bookmark Validation For Top-Down Risk", 1, true);
			String strCellData = null;
			int intActColNumber = 0;
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			Thread.sleep(2000);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Top-down Risk']"))
					.click();
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Top-down Risk']"))
					.click();
			Thread.sleep(4000);
			// Risk Top-down Risk bookmark validation
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Grand Total",
								"//*[@id='SPGtable']/tbody/tr[3]/td[1]/div/div/div[@class='gwt-HTML']/table//thead/tr[2]/th[2]");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[1]/div/div/div[@class='gwt-HTML']/table//tbody/tr[%d]/td[%d]",
										2, intActColNumber+1)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Top-down Risk PVs value "
						+ strCellData
						+ " is displayed in the Risk Top-down Risk PVs page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Top-down Risk PVs value is not displayed in the Risk Top-down Risk PVs page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Top-Down Risk", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Top-down Risk PVs verified successfully");
		} else {
			throw new Exception("Risk bookmark Top-down Risk PVs not verified");
		}
	}
	
	@Test(dependsOnMethods = "sensitivityReportCalculation_Create", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesCombinedRiskViewTradeHierarchy() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for VaR, Sensitivities, Allocated XVA by Trade Hierarchy in Combined Risk View");

			Reporter.log("Test Case: Risk Bookmark Validation For VaR, Sensitivities, Allocated XVA by Trade Hierarchy in Combined Risk View", 1, true);
			String strCellData;
			int intActColNumber = 0;
			
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div[text()='Risk']"))
					.click();
			Thread.sleep(14000);
			driver.switchTo()
					.frame(driver.findElement(By
							.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[2]/div/iframe")));
			Thread.sleep(2000);

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			
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
	
	@Test(dependsOnMethods = "sensitivityReportCalculation_calculationsSensitivitiesCombinedRiskViewTradeHierarchy", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesCombinedRiskViewNettingSet() throws Exception {
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
	
	@Test(dependsOnMethods = "sensitivityReportCalculation_calculationsSensitivitiesCombinedRiskViewNettingSet", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesContentsSynchronizationStatistics() throws Exception {
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
			clickExpandContents("Contents");
			
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
	
	@Test(dependsOnMethods = "sensitivityReportCalculation_calculationsSensitivitiesContentsSynchronizationStatistics", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesContentsSynchronizedTradeCounts() throws Exception {
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
	
	@Test(dependsOnMethods = "sensitivityReportCalculation_calculationsSensitivitiesContentsSynchronizedTradeCounts", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesperRiskFactorbyBucketinByBucketType() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Sensitivities per Risk Factor by Bucket in By Bucket Type");

			Reporter.log("Test Case: Risk Bookmark Validation For Sensitivities per Risk Factor by Bucket in By Bucket Type", 1, true);
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
			clickExpandMarketRiskByBucketType("Market Risk", "Sensitivities",
					"By Bucket Type");
			
			Reporter.log("Test Step: Click On Sensitivities per Risk Factor by Bucket", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Sensitivities per Risk Factor by Bucket']"))
					.click();
			Thread.sleep(2000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Total PV.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th[2]");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Sensitivities per Risk Factor by Bucket value " + strCellData
						+ " is displayed in the Risk Sensitivities per Risk Factor by Bucket page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Sensitivities per Risk Factor by Bucket value is not displayed in the Risk Sensitivities per Risk Factor by Bucket page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Sensitivities per Risk Factor by Bucket", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Sensitivities per Risk Factor by Bucket verified successfully");
		} else {
			throw new Exception("Risk bookmark Sensitivities per Risk Factor by Bucket not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "sensitivityReportCalculation_calculationsSensitivitiesperRiskFactorbyBucketinByBucketType", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesperRiskFactorbyInstrument() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Sensitivities per Risk Factor by Instrument in By Bucket Type");

			Reporter.log("Test Case: Risk Bookmark Validation For Sensitivities per Risk Factor by Instrument in By Bucket Type", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
			
			
			Reporter.log("Test Step: Click On Sensitivities per Risk Factor by Instrument", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Sensitivities per Risk Factor by Instrument']"))
					.click();
			Thread.sleep(2000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Total PV.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th[2]");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Sensitivities per Risk Factor by Instrument value " + strCellData
						+ " is displayed in the Risk Sensitivities per Risk Factor by Instrument page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Sensitivities per Risk Factor by Instrument value is not displayed in the Risk Sensitivities per Risk Factor by Instrument page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Sensitivities per Risk Factor by Instrument", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Sensitivities per Risk Factor by Instrument verified successfully");
		} else {
			throw new Exception("Risk bookmark Sensitivities per Risk Factor by Instrument not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "sensitivityReportCalculation_calculationsSensitivitiesperRiskFactorbyInstrument", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesperRiskFactorbyRiskFactor() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Sensitivities per Risk Factor by Risk Factor in By Bucket Type");

			Reporter.log("Test Case: Risk Bookmark Validation For Sensitivities per Risk Factor by Risk Factor in By Bucket Type", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
			
			
			Reporter.log("Test Step: Click On Sensitivities per Risk Factor by Risk Factor", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Sensitivities per Risk Factor by Risk Factor']"))
					.click();
			Thread.sleep(2000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Total PV.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th[2]");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Sensitivities per Risk Factor by Risk Factor value " + strCellData
						+ " is displayed in the Risk Sensitivities per Risk Factor by Risk Factor page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Sensitivities per Risk Factor by Risk Factor value is not displayed in the Risk Sensitivities per Risk Factor by Risk Factor page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Sensitivities per Risk Factor by Risk Factor", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Sensitivities per Risk Factor by Risk Factor verified successfully");
		} else {
			throw new Exception("Risk bookmark Sensitivities per Risk Factor by Risk Factor not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "sensitivityReportCalculation_calculationsSensitivitiesperRiskFactorbyRiskFactor", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesperTradebyBucket() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Sensitivities per Trade by Bucket in By Bucket Type");

			Reporter.log("Test Case: Risk Bookmark Validation For Sensitivities per Trade by Bucket in By Bucket Type", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
			
			
			Reporter.log("Test Step: Click On Sensitivities per Trade by Bucket", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Sensitivities per Trade by Bucket']"))
					.click();
			Thread.sleep(2000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Total PV.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th[2]");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Sensitivities per Trade by Bucket value " + strCellData
						+ " is displayed in the Risk Sensitivities per Trade by Bucket page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Sensitivities per Trade by Bucket value is not displayed in the Risk Sensitivities per Trade by Bucket page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Sensitivities per Trade by Bucket", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Sensitivities per Trade by Bucket verified successfully");
		} else {
			throw new Exception("Risk bookmark Sensitivities per Trade by Bucket not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "sensitivityReportCalculation_calculationsSensitivitiesperTradebyBucket", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesperTradebyBucketList() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Sensitivities per Trade by Bucket - List in By Bucket Type");

			Reporter.log("Test Case: Risk Bookmark Validation For Sensitivities per Trade by Bucket - List in By Bucket Type", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
			
			
			Reporter.log("Test Step: Click On Sensitivities per Trade by Bucket - List", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Sensitivities per Trade by Bucket - List']"))
					.click();
			Thread.sleep(2000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"PV.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th[2]");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Sensitivities per Trade by Bucket - List value " + strCellData
						+ " is displayed in the Risk Sensitivities per Trade by Bucket - List page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Sensitivities per Trade by Bucket - List value is not displayed in the Risk Sensitivities per Trade by Bucket - List page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Sensitivities per Trade by Bucket - List", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Sensitivities per Trade by Bucket - List verified successfully");
		} else {
			throw new Exception("Risk bookmark Sensitivities per Trade by Bucket - List not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "sensitivityReportCalculation_calculationsSensitivitiesperTradebyBucketList", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesperTradebyInstrument() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Sensitivities per Trade by Instrument in By Bucket Type");

			Reporter.log("Test Case: Risk Bookmark Validation For Sensitivities per Trade by Instrument in By Bucket Type", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
			
			
			Reporter.log("Test Step: Click On Sensitivities per Trade by Instrument", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Sensitivities per Trade by Instrument']"))
					.click();
			Thread.sleep(2000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Total PV.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th[2]");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Sensitivities per Trade by Instrument value " + strCellData
						+ " is displayed in the Risk Sensitivities per Trade by Instrument page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Sensitivities per Trade by Instrument value is not displayed in the Risk Sensitivities per Trade by Instrument page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Sensitivities per Trade by Instrument", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Sensitivities per Trade by Instrument verified successfully");
		} else {
			throw new Exception("Risk bookmark Sensitivities per Trade by Instrument not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "sensitivityReportCalculation_calculationsSensitivitiesperTradebyInstrument", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesperTradebyInstrumentList() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Sensitivities per Trade by Instrument - List in By Bucket Type");

			Reporter.log("Test Case: Risk Bookmark Validation For Sensitivities per Trade by Instrument - List in By Bucket Type", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
			
			
			Reporter.log("Test Step: Click On Sensitivities per Trade by Instrument - List", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Sensitivities per Trade by Instrument - List']"))
					.click();
			Thread.sleep(2000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"PV.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th[2]");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Sensitivities per Trade by Instrument - List value " + strCellData
						+ " is displayed in the Risk Sensitivities per Trade by Instrument - List page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Sensitivities per Trade by Instrument - List value is not displayed in the Risk Sensitivities per Trade by Instrument - List page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Sensitivities per Trade by Instrument - List", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Sensitivities per Trade by Instrument - List verified successfully");
		} else {
			throw new Exception("Risk bookmark Sensitivities per Trade by Instrument - List not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "sensitivityReportCalculation_calculationsSensitivitiesperTradebyInstrumentList", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesperTradebyRiskFactor() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Sensitivities per Trade by Risk Factor in By Bucket Type");

			Reporter.log("Test Case: Risk Bookmark Validation For Sensitivities per Trade by Risk Factor in By Bucket Type", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
			
			
			Reporter.log("Test Step: Click On Sensitivities per Trade by Risk Factor", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Sensitivities per Trade by Risk Factor']"))
					.click();
			Thread.sleep(2000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"Total PV.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th[2]");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Sensitivities per Trade by Risk Factor value " + strCellData
						+ " is displayed in the Risk Sensitivities per Trade by Instrument - List page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Sensitivities per Trade by Risk Factor value is not displayed in the Risk Sensitivities per Trade by Risk Factor page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Sensitivities per Trade by Risk Factor", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Sensitivities per Trade by Risk Factor verified successfully");
		} else {
			throw new Exception("Risk bookmark Sensitivities per Trade by Risk Factor not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods = "sensitivityReportCalculation_calculationsSensitivitiesperTradebyRiskFactor", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesperTradebyRiskFactorList() throws Exception {
		try {
			btnFlag = false;
			GeneralUtil
					.logger("Risk bookmark validation for Sensitivities per Trade by Risk Factor - List in By Bucket Type");

			Reporter.log("Test Case: Risk Bookmark Validation For Sensitivities per Trade by Risk Factor - List in By Bucket Type", 1, true);
			String strCellData;
			int intActColNumber = 0;

			// Pricing Portfolio PVs bookmark validation
			WebElement strCellElement;
			driver.findElement(
					By.xpath("//table[@class='gwt-TabBar']/tbody/tr/td[2]/div/div/div[2]"))
					.click();
			
			Thread.sleep(2000);
			
			
			Reporter.log("Test Step: Click On Sensitivities per Trade by Risk Factor - List", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='gwt-HTML']/span[text()='Sensitivities per Trade by Risk Factor - List']"))
					.click();
			Thread.sleep(2000);
			if (verifyTable()) {
				intActColNumber = Common
						.getTableColumnNumber(
								"PV.CCY",
								"//*[@id='SPGtable']/tbody/tr[2]/td[2]/div/div/div[@class='gwt-HTML']/table/thead/tr[2]/th[2]");
				strCellElement = driver
						.findElement(By.xpath(String
								.format("//*[@id='SPGtable']/tbody/tr[3]/td[2]/div/div/div[@class='gwt-HTML']/table/tbody/tr[%d]/td[%d]",
										1, intActColNumber)));
				strCellData = strCellElement.getText();
				GeneralUtil.captureScreenshot();
				GeneralUtil.logger.info("Sensitivities per Trade by Risk Factor - List value " + strCellData
						+ " is displayed in the Risk Sensitivities per Trade by Risk Factor - List page");
				btnFlag = true;
			} else {
				GeneralUtil.logger
						.error("Sensitivities per Trade by Risk Factor - List value is not displayed in the Risk Sensitivities per Trade by Risk Factor - List page and failed");
			}

			Reporter.log("Test Case: Successfully Risk Bookmark Validated For Sensitivities per Trade by Risk Factor - List", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		if (btnFlag) {
			GeneralUtil.logger
					.info("Risk bookmark Sensitivities per Trade by Risk Factor - List verified successfully");
		} else {
			throw new Exception("Risk bookmark Sensitivities per Trade by Risk Factor - List not verified");
		}
		//driver.switchTo().defaultContent();
	}
	
	//@Test(dependsOnMethods = "sensitivityReportCalculation_calculationsSensitivitiesBucketbyInstrument", alwaysRun=true)
	public void sensitivityReportCalculation_calculationsSensitivitiesClearResults() throws Exception {
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

	public void verifyElementPresent(String strTrade, String strXpath,
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

	public void clickExpandMarketRiskByBucketType(String expValue, String subExpValue,
			String innerSubExpValue) {
		WebElement expandElement = driver.findElement(By
				.xpath("//table[@class='live-TabPanel live-tabFont']//div[@class='gwt-Tree']/div[3]/table/tbody/tr/td[1]"));
		expandElement.click();
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

		List<WebElement> txtInnerSubElement = driver
				.findElements(By.xpath(String
						.format("//div[@class='gwt-Tree']/div[3]/div/div[%d]/div/div[%d]/div/div",
								i, j + 1)));
		for (int k = 0; k <= txtInnerSubElement.size(); k++) {
			String subInnerText = txtInnerSubElement.get(k).getText();

			if (subInnerText.contains(innerSubExpValue)) {
				WebElement subCMarketRiskExpand = driver
						.findElement(By.xpath(String
								.format("//div[@style='white-space: nowrap;']/div[%d]/div/div[%d]/div/div[%d]/table/tbody/tr/td[1]",
										i, j + 1, k + 1)));
				subCMarketRiskExpand.click();
				break;

			}
		}
	}
	
	public void clickExpandMarketRisk(String expValue, String subExpValue,
			String innerSubExpValue) {
		WebElement expandElement = driver.findElement(By
				.xpath("//table[@class='live-TabPanel live-tabFont']//div[@class='gwt-Tree']/div[3]/table/tbody/tr/td[1]"));
		expandElement.click();
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

		List<WebElement> txtInnerSubElement = driver
				.findElements(By.xpath(String
						.format("//div[@class='gwt-Tree']/div[3]/div/div[%d]/div/div[%d]/div/div",
								i, j + 1)));
		for (int k = 0; k <= txtInnerSubElement.size(); k++) {
			String subInnerText = txtInnerSubElement.get(k).getText();

			if (subInnerText.contains(innerSubExpValue)) {
				WebElement subCMarketRiskExpand = driver
						.findElement(By.xpath(String
								.format("//div[@style='white-space: nowrap;']/div[%d]/div/div[%d]/div/div[%d]/table/tbody/tr/td[1]",
										i, j + 1, k + 1)));
				subCMarketRiskExpand.click();
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
										i+1)));
				subPublicCollapse.click();
				break;
			}
		}
	}

	public void clickExpandContents(String expValue) {
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

		if (hederNumbers >= 1) {
			return true;
		}
		return false;

	}

}
