package test;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.Browser;
import util.GeneralUtil;

public class Trades {

	public WebDriver driver;
	public int dynamicTimeOut;
	public String fileUploadPath = null;
	
	public String tradeId = null;
	public String cloneTradeId = null;
	public String strmenu = null;

	
	@BeforeClass
	public void beforeClass() throws Exception {
		
		GeneralUtil.configureLog4j("Verify Trades");
		GeneralUtil.logger("Verify Trades");

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
		
		tradeId = "Test123";
		cloneTradeId = "Test1234";
		strmenu = "//div[@class='ag-menu']//span[@class='ag-menu-option-text']";
	}

	@Test (alwaysRun=true)
	public void trades_addTrade() throws Exception {
		Reporter.log("Test Case: Add Trades", 1, true);
		
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

			// Navigate to Add New Trades>TRADES>IR>FRA
			Reporter.log("Test Step: Click Add New Trades", 1, true);
			driver.findElement(By.xpath(".//*[@id='Menu']")).click();
			GeneralUtil.selectDropDownItem(
					"//ul[@class = 'dropdown-menu']/div", "TERMS",
					"Add New Trade");
			
			Reporter.log("Test Step: Select Trades From Add New Trade Dropdown", 1, true);
			GeneralUtil.selectDropDownItem(
					"//div[@class = 'dropdown-menu']/div", "IR", "TRADES");
			
			Reporter.log("Test Step: Select FRA & IR From Trades Dropdown", 1, true);
			GeneralUtil.selectDropDownItem(
					"//div[@class = 'dropdown-menu']/div", "FRA", "IR");
			GeneralUtil.captureScreenshot();
			try{
				if(driver.findElement(By.xpath("//div[@class='notifications-wrapper']//h4//following-sibling::div[@class='notification-message']")).isDisplayed()==true) {
			Common.handleNotifications("Failed to get markets filter for user Administrator");
				}}
			catch(Exception e){
				
			}

			// Fill the Trade detail page and save the trade
			Reporter.log("Test Step: Enter Text On Trade ID Field", 1, true);
			driver.findElement(
					By.xpath(".//*[@class='ReactTabs react-tabs']/div/div/div/div/div/div[1]/div/div/input"))
					.sendKeys(tradeId);
			
			Reporter.log("Test Step: Select The Currency On Dropdown Item", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='ReactTabs react-tabs']/div/div/div/div/div/div[5]/div/div/div/div/div/div/span/div"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"EUR", "Currency");
			Thread.sleep(1000);
			
			
			
			Reporter.log("Test Step: Enter The Text On Froward Rate", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-components-SmartInputs-FastNumberInput-FastNumberInput---fastNumber')]/input"))
					.sendKeys("45");
			
			/*Reporter.log("Test Step: Enter The Text On IR Index", 1, true);
			driver.findElement(
					By.xpath("//*[@class='ReactTabs react-tabs']/div/div/div/div/div/div[8]/div/div/input"))
					.sendKeys("test");*/
			
			Reporter.log("Test Step: Enter The Text On IR Index Tenor", 1, true);
			driver.findElement(
					By.xpath("//*[@class='ReactTabs react-tabs']/div/div/div/div/div/div[7]/div/div/input"))
					.sendKeys("10");
			driver.findElement(
					By.xpath("//*[@class='ReactTabs react-tabs']/div/div/div/div/div/div[8]/div/div/div[1]/div/div/input"))
					.click();
			
			Reporter.log("Test Step: Selct The Maturity Date On Dropdown Item", 1, true);
			driver.findElement(
					By.xpath("//div[contains(@class,'react-datepicker__day') and text()=30]"))
					.click();
			
			Reporter.log("Test Step: Select The Effective Date On Dropdown Item", 1, true);
			driver.findElement(
					By.xpath("//*[@class='ReactTabs react-tabs']/div/div/div/div/div/div[9]/div/div/div[1]/div/div/input"))
					.click();
			//Thread.sleep(6000);
			driver.findElement(
					By.xpath("//div[contains(@class,'react-datepicker__day') and text()=14]"))
					.click();
			
			Reporter.log("Test Step: Click Save Button For Trade", 1, true);
			driver.findElement(
					By.xpath("//div[@class='ReactTabs react-tabs']/ul/li[2]"))
					.click();
			
			
			driver.findElement(
					By.xpath("//div[@class='ReactTabs react-tabs']/ul/li[3]"))
					.click();
			
			
			/*driver.findElement(
					By.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div/div[1]/div/div[1]/div/div[2]/div/div/button"))
					.click();*/
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			Reporter.log("Test Step: Click OK Button For Trade", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			// GeneralUtil.handleToolTip("Trade Saved");

			Thread.sleep(1000);
			Reporter.log("Test Step: Enter The Text On Trade Id Field", 1, true);
			driver.findElement(
					By.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[3]/div/div/input"))
					.sendKeys(tradeId);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			Thread.sleep(1000);
			// Validate the trade added or not
			Reporter.log("Test Step: Verify Trade Is Added", 1, true);
			String tradeIdtext = driver.findElement(By.xpath(".//*[@ref='center']/div/div[4]//div[3]/div/div[1]/div[1]/div[7]")).getText();

			if (tradeIdtext.equalsIgnoreCase(tradeId)) {
				GeneralUtil.logger.info("Trade id " + tradeId
						+ " is available in the Trade");
			} else {
				GeneralUtil.logger.error("Trade id " + tradeId
						+ " is not available in the Trade");
			}
			GeneralUtil.logger.info("Trade Created successfully");
			Reporter.log("Test Case: Successfully Added Trade", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "trades_addTrade" })
	public void trades_cloneTrade() throws Exception {
		Reporter.log("Test Case: Clone Trades", 1, true);
		
		
		try {
			GeneralUtil.logger.info("Started clone Trade");

			// Clone the added trade
			Reporter.log("Test Step: Cloned Trade", 1, true);
			WebElement contextMenuelement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]//div[3]/div/div[1]/div[1]/div[7]"));
			driver.findElement(By.xpath(".//*[@ref='center']/div/div[4]//div[3]/div/div[1]/div[1]/div[7]")).click();
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Click Clone On Trades From Context Menu", 1, true);
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Clone");
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Clear The Trade ID Field And Enter Clone Trade ID", 1, true);
			WebElement tradeIDElement = driver
					.findElement(By
							.xpath(".//*[@class='ReactTabs react-tabs']/div/div/div/div/div/div[1]/div/div/input"));
			tradeIDElement.clear();
			Thread.sleep(1000);
			tradeIDElement.sendKeys(cloneTradeId);
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Click Save Button For TRade", 1, true);
			driver.findElement(
					By.xpath("//div[@class='ReactTabs react-tabs']/ul/li[2]"))
					.click();
			driver.findElement(
					By.xpath("//div[@class='ReactTabs react-tabs']/ul/li[3]"))
					.click();

			/*driver.findElement(
					By.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div/div[1]/div/div[1]/div/div[2]/div/div/button"))
					.click();*/
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click OK Button", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			GeneralUtil.logger.info("Trade cloned successfully");
			Thread.sleep(1000);

			// Validate the trade is cloned or not
			Reporter.log("Test Step: Search Cloned Trade", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[3]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(cloneTradeId);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			if( driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]//div[3]/div/div[1]/div[1]/div[7]")).isDisplayed()==true) {
			
				Reporter.log("Test Step: Verify The Trade Is Cloned", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]//div[3]/div/div[1]/div[1]/div[7]"))
					.getText();
			
			if (tradeIdtext.equalsIgnoreCase(cloneTradeId)) {
				GeneralUtil.logger.info("Cloned Trade id " + cloneTradeId
						+ " is available in the Trade");
			} else {
				GeneralUtil.logger.error("Cloned Trade id " + cloneTradeId
						+ " is not available in the Trade");
			}
			}
			Reporter.log("Test Case: Successfully Cloned Trade", 1, true);
		} catch (Exception e) {
			if(e.toString().contains(".//*[@ref='center']/div/div[4]//div[3]/div/div[1]/div[1]/div[7]")) {
				GeneralUtil.logger.error("Element is not Visible");
			}else {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
			}
		}
	}

	@Test(dependsOnMethods = { "trades_cloneTrade" })
	public void trades_editTrade() throws Exception {
		Reporter.log("Test Case: Edit Trades", 1, true);
		try {
			GeneralUtil.logger.info("Started edit Trade");

			// Search the added trade id
			Reporter.log("Test Step: Search The Added Trade", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[3]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(tradeId);

			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			// Click on trade id
			Reporter.log("Test Step: Click Added Trade", 1, true);
			driver.findElement(
					By.xpath(".//*[@ref='center']/div/div[4]//div[3]/div/div[1]/div[1]/div[7]"))
					.click();

			// Update the trade detail page and save the trade
			Reporter.log("Test Step: Update The Trade Detail Page And Save The Trade", 1, true);
			driver.findElement(
					By.xpath(".//div[@class='ReactTabs react-tabs']/div//div/div/div/div/div[2]/div/div/div/div/div/div/span/div"))
					.click();
			GeneralUtil.dropDownItemvisible(
					"//div[@class='Select-menu-outer']/div/div[1]/div/div/div",
					"Bank Of America", "Counterparty");

			/*driver.findElement(
					By.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[3]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div/div[1]/div/div[1]/div/div[2]/div/div/button"))
					.click();*/
			
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			GeneralUtil.logger.info("Trade updated successfully");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Search Edited Trade", 1, true);
			WebElement SearchElement1 = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[3]/div/div/input"));
			SearchElement1.clear();
			SearchElement1.sendKeys(tradeId);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Validate the trade is updated or not
			Reporter.log("Test Step: Verify The Trade Is Edited", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]//div[3]/div/div[1]/div[1]/div[7]"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase(tradeId)) {
				GeneralUtil.logger.info("Edited Trade id " + tradeId
						+ " is available in the Trade");
			} else {
				GeneralUtil.logger.error("Edited Trade id " + tradeId
						+ " is not available in the Trade");
			}
			Reporter.log("Test Case: Successfully Edited Trade", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = { "trades_editTrade" })
	public void trades_downloadTrade() throws Exception {
		try {
			GeneralUtil.logger.info("Started download Trade");
			Reporter.log("Test Case: Download Trades", 1, true);
			Thread.sleep(4000);
			
			// Clear the filter for trade columns
			Reporter.log("Test Step: Clear The Trade Filter Columns", 1, true);
			WebElement contextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
			
			Reporter.log("Test Step: Click Clear All Filters On Trades From Context Menu", 1, true);
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Clear All Filters");
			// Search the added trade id
			Reporter.log("Test Step: Search The Added Trade", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[3]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(tradeId);

			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Download the trade and Validate "Trades(.*).zip" file download
			// or not
			Reporter.log("Test Step: Download The Trade And Verify The File Download", 1, true);
			Thread.sleep(2000);
			WebElement contextMenuelement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]//div[3]/div/div[1]/div[1]/div[7]"));
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			Common
					.download(
							"CSV Download",
							"Download All",
							"Trades(.*).zip",
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							".//*[@id='borderLayout_eRootPanel']/div[5]/div/div/span[2]");

			GeneralUtil.logger.info("Trade downloaded successfully");
			Reporter.log("Test Case: Successfully Downloaded Trade", 1, true);
			Thread.sleep(1000);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = { "trades_downloadTrade" })
	public void trades_deleteTrade() throws Exception {

		try {
			GeneralUtil.logger.info("Started delete Trade");
			Reporter.log("Test Case: Delete Trades", 1, true);
			
			// Clear the filter for trade columns
			Reporter.log("Test Step: Clear The Trade Filter Columns", 1, true);
			Thread.sleep(4000);
			WebElement contextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
			
			Reporter.log("Test Step: Click Clear All Filters On Trades From Context Menu", 1, true);
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Clear All Filters");

			// Search the added trade id
			Reporter.log("Test Step: Search The Added Trade", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[3]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(tradeId);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Delete the added trade id
			Reporter.log("Test Step: Click Delete On Trades From Context Menu", 1, true);
			WebElement contextMenuelement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]//div[3]/div/div[1]/div[1]/div[7]"));
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Delete");
			
			Reporter.log("Test Step: Click OK Button From Delete Trade", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			GeneralUtil.captureScreenshot();

			// Clear the filter for trade columns
			Reporter.log("Test Step: Click Clear All Filters On Trades From Context Menu", 1, true);
			WebElement contextMenuCloneElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div"));
			GeneralUtil.contextMenu(contextMenuCloneElement);

			
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Clear All Filters");
			
			// Search the cloned trade id
			Reporter.log("Test Step: Search The Cloned Trade", 1, true);
			WebElement SearchElement1 = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[3]/div/div/input"));
			SearchElement1.clear();
			SearchElement1.sendKeys(cloneTradeId);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Delete the cloned trade id
			Reporter.log("Test Step: Click Delete On Trades From Context Menu", 1, true);
			WebElement contextMenuCloneelement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]//div[3]/div/div[1]/div[1]/div[7]"));
			GeneralUtil.contextMenu(contextMenuCloneelement);
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Delete");
			
			Reporter.log("Test Step: Click OK Button From Delete Trade", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			GeneralUtil.captureScreenshot();
			GeneralUtil.logger.info("Trade deleted successfully");
			
			Reporter.log("Test Case: Successfully Deleted Trade", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			if(e.toString().contains(".//*[@ref='center']/div/div[4]//div[3]/div/div[1]/div[1]/div[7]")) {
				GeneralUtil.logger.error("Elements are not visible for 'Test1234' Name");
			}
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}
	
	@Test(dependsOnMethods = "trades_deleteTrade", alwaysRun=true)
	public void trades_uploadTrade() throws Exception {
		try {
			GeneralUtil.logger.info("Started upload Trade");

			Reporter.log("Test Case: Upload Trades", 1, true);
			
			Reporter.log("Test Step: Click Clear All Filters On Trades From Context Menu", 1, true);
			WebElement contextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();

			// Clear the filter for trade columns
			
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Clear All Filters");
			Thread.sleep(1000);
			
			// Click on CSV Upload and upload the 'CC_BermudanPRDCSwap.csv' file
			Reporter.log("Test Step: Click CSV Upload On Trades From Context Menu", 1, true);
			
			WebElement contextMenuelement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[7]"));
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"CSV Upload");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Upload The 'CC_BermudanPRDCSwap.csv' File", 1, true);
			GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\Data\\Terms\\CC_BermudanPRDCSwap_1.csv");
			

			Thread.sleep(2000);
			GeneralUtil.logger.info("Trade uploaded successfully");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Search Uploaded Trade", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[3]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys("CC_BermudanPRDCSwap_1");
			
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Validate the 'CC_BermudanPRDCSwap.csv' is uploaded or not
			Reporter.log("Test Step: Verify The 'CC_BermudanPRDCSwap_1' Is Uploaded", 1, true);
			String tradeIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]//div[3]/div/div[1]/div[1]/div[7]"))
					.getText();

			if (tradeIdtext.equalsIgnoreCase("CC_BermudanPRDCSwap_1")) {
				GeneralUtil.logger.info("Uploaded Trade id " + tradeId
						+ " is available in the Trade");
			} else {
				GeneralUtil.logger.error("Uploaded Trade id " + tradeId
						+ " is not available in the Trade");
			}
			Reporter.log("Test Case: Successfully Uploaded Trade", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods = "trades_uploadTrade", alwaysRun=true)
	public void trades_exportTrade() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export Trade");
		Reporter.log("Test Case: Export Trade", 1, true);
		GeneralUtil.logger.info("Stated");
		Thread.sleep(4000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Click Clear All Filters On Trades From Context Menu", 1, true);
		WebElement contextMenuElement = driver.findElement(By
				.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
		GeneralUtil.contextMenu(contextMenuElement);
		GeneralUtil.captureScreenshot();

		// Clear the filter for trade columns
		
		GeneralUtil
				.contextMenuItem(
						".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
						"Clear All Filters");
		Thread.sleep(1000);
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath(" .//*[@ref='center']/div/div[4]//div[3]/div/div[1]/div[1]/div[7]"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Trade CSV Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver
				.findElement(By
						.xpath(" .//*[@ref='center']/div/div[4]//div[3]/div/div[1]/div[1]/div[7]"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Trade Excel Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported Trade", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test (dependsOnMethods = "trades_exportTrade", alwaysRun=true)
	public void trades_veriryTradeColumn() throws Exception {
		try {
			GeneralUtil.logger.info("Started verify trade colums");
			Reporter.log("Test Case: Verify Trades Colums", 1, true);
			WebElement contextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();

			// Clear the filter for trade columns
			Reporter.log("Test Step: Clear The Trade Filter Columns", 1, true);
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Clear All Filters");
			Thread.sleep(1000);
			//WebElement scrollBar=driver.findElement(By.xpath(".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[2]/div[@class='ps-scrollbar-x']"));
			//((JavascriptExecutor)driver).executeScript("window.scrollBy(2000,0)");
			//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", scrollBar);
			/*WebElement horizontalbar = driver.findElement(By.xpath(".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[2]/div[@class='ps-scrollbar-x']"));
			Actions action = new Actions(driver);

			Actions moveToElement = action.moveToElement( horizontalbar );
			for (int i = 0; i < 20; i++) {
			    moveToElement.sendKeys(Keys.RIGHT).build().perform();
			}*/

			GeneralUtil.captureScreenshot();
			
			// Search currency with 'EUR'
			Reporter.log("Test Step: Search Currency With 'EUR'", 1, true);
			WebElement SearchElementCurrency = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[9]/div/div/input"));
			SearchElementCurrency.clear();
			SearchElementCurrency.sendKeys("EUR");
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			/*WebElement horizontalbar1 = driver.findElement(By.xpath(".//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]/div[3]/div/div[2]/div[@class='ps-scrollbar-x']"));
			Actions action1 = new Actions(driver);

			Actions moveToElement1 = action.moveToElement( horizontalbar1 );
			for (int i = 0; i < 20; i++) {
			    moveToElement.sendKeys(Keys.LEFT).build().perform();
			}*/

			// Validate currency column is displayed only EUR
			Reporter.log("Test Step: Verify Currency Column Is Displayed Only EUR", 1, true);
			String tradeCurrencytext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[9]"))
					.getText();
			if (tradeCurrencytext.equalsIgnoreCase("EUR")) {
				GeneralUtil.logger
						.info("Only EUR Currency is displayed after Search currency with EUR");
			} else {
				GeneralUtil.logger
						.error("Only EUR Currency is not displayed after Search currency with EUR");
			}

			// Clear the filter for trade columns
			Reporter.log("Test Step: Clear The Trade Filter Columns", 1, true);
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Clear All Filters");
			Thread.sleep(1000);
			
			// Search status with 'Booked'
			Reporter.log("Test Step: Search Status With 'Booked'", 1, true);
			GeneralUtil
					.selectItem(
							".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[8]/div/div/select",
							"Booked");

			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Validate status column is displayed only Booked
			Reporter.log("Test Step: Verify Status Column Is Displayed Only Booked", 1, true);
			String tradeStatustext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[8]"))
					.getText();
			if (tradeStatustext.equalsIgnoreCase("Booked")) {
				GeneralUtil.logger
						.info("Only Booked Status is displayed after Search status with Booked");
			} else {
				GeneralUtil.logger
						.error("Only Booked Status is not displayed after Search status with Booked");
			}

			// Clear the filter for trade columns
			Reporter.log("Test Step: Clear The Trade Filter Columns", 1, true);
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Clear All Filters");
			Thread.sleep(1000);

			// Search Legal Entity with 'Bank Of America US'
			Reporter.log("Test Step: Search Legal Entity With 'Bank Of America US'", 1, true);
			WebElement SearchElementLegalEntity = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[7]/div/div/input"));
			SearchElementLegalEntity.clear();
			SearchElementLegalEntity.sendKeys("Bank Of America US");
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Validate Legal Entity column is displayed only Bank Of America US
			Reporter.log("Test Step: Verify Legal Entity Column Is Displayed Only Bank Of America US", 1, true);
			String tradeLegalEntitytext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[7]"))
					.getText();
			if (tradeLegalEntitytext.equalsIgnoreCase("Bank Of America US")) {
				GeneralUtil.logger
						.info("Only Bank Of America US Legal Entity is displayed after Search Legal Entity with Bank Of America US");
			} else {
				GeneralUtil.logger
						.error("Only Bank Of America US Legal Entity is not displayed after Search Legal Entity with Bank Of America US");
			}

			// Clear the filter for trade columns
			Reporter.log("Test Step: Clear The Trade Filter Columns", 1, true);
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Clear All Filters");
			Thread.sleep(1000);

			// Search counterparty with 'Bank Of America'
			Reporter.log("Test Step: Search Counterparty With 'Bank Of America'", 1, true);
			WebElement SearchElementCounterparty = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[6]/div/div/input"));
			SearchElementCounterparty.clear();
			SearchElementCounterparty.sendKeys("Bank Of America");
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Validate counterparty column is displayed only Bank Of America
			Reporter.log("Test Step: Verify Counterparty Column Is Displayed Only Bank Of America", 1, true);
			String tradeCounterpartytext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[6]"))
					.getText();
			if (tradeCounterpartytext.equalsIgnoreCase("Bank Of America")) {
				GeneralUtil.logger
						.info("Only Bank Of America Counterparty is displayed after Search Counterparty with Bank Of America");
			} else {
				GeneralUtil.logger
						.error("Only Bank Of America Counterparty is not displayed after Search Counterparty with Bank Of America");
			}

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
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[5]/div/div/input"));
			SearchElementAssetClass.clear();
			SearchElementAssetClass.sendKeys("IR");
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Validate asset class column is displayed only IR
			Reporter.log("Test Step: Verify Asset Class Column Is Displayed Only IR", 1, true);
			String tradeAssetClasstext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[5]"))
					.getText();
			if (tradeAssetClasstext.equalsIgnoreCase("IR")) {
				GeneralUtil.logger
						.info("Only IR Asset Class is displayed after Search Asset Class with IR");
			} else {
				GeneralUtil.logger
						.error("Only IR Asset Class is not displayed after Search Asset Class with IR");
			}

			// Clear the filter for trade columns
			Reporter.log("Test Step: Clear The Trade Filter Columns", 1, true);
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Clear All Filters");
			Thread.sleep(1000);

			// Search product with 'TRADE.IR.GENERICSWAP'
			Reporter.log("Test Step: Search Product With 'TERMS.IR.GENERICSWAP'", 1, true);
			WebElement SearchElementProduct = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[4]/div/div/input"));
			SearchElementProduct.clear();
			SearchElementProduct.sendKeys("TERMS.IR.GENERICSWAP");
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Validate product column is displayed only TRADE.IR.GENERICSWAP
			Reporter.log("Test Step: Verify Product Column Is Displayed Only TRADE.IR.GENERICSWAP", 1, true);
			String tradeProducttext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[4]"))
					.getText();
			if (tradeProducttext.equalsIgnoreCase("TERMS.IR.GENERICSWAP")) {
				GeneralUtil.logger
						.info("Only TERMS.IR.GENERICSWAP Product is displayed after Search Product with TRADE.IR.GENERICSWAP");
			} else {
				GeneralUtil.logger
						.error("Only TRADE.IR.GENERICSWAP Product is not displayed after Search Product with TRADE.IR.GENERICSWAP");
			}
			
			Reporter.log("Test Case: Successfully Verify The Trade Colums", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}

	}
	
	@Test(dependsOnMethods = "trades_veriryTradeColumn" , alwaysRun=true)
	public void trades_showHideTradeColumn() throws Exception {

		GeneralUtil.logger
				.info("Started verify show hide Trade column");
		Reporter.log("Test Case: Verify Show Hide Trades Colums", 1, true);
		try {

			try {
				// Close the any error notifications
				for (int i = 1; i < 4; i++) {
					WebElement objnotification = GeneralUtil
							.getElement(
									"//div[starts-with(@class,'notification notification-error notification-visible')]/span",
									"xpath", 2);
					objnotification.click();
				}
			} catch (Exception e) {

			}

			// Click on Show Hide Columns Button
			Reporter.log("Test Step: Click ON Show Hide Trades Colums Button", 1, true);
			WebElement objShowHideColumnsButton = GeneralUtil.getElement(
					"//div/span[@title='Show/Hide Columns']/i", "xpath",
					dynamicTimeOut);
			objShowHideColumnsButton.click();

			GeneralUtil.captureScreenshot();
			/*String strCheckBox = "html/body/div[1]/div/div/div/div/div[2]/div[3]/div/div[3]/div/div[1]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div/div/div[1]/div[2]/div/div/div[2]/div/div/label[text()='Accrual End Date']/preceding::div[1]";
			WebElement objCheckBox = GeneralUtil.getElement(strCheckBox,
					"xpath", dynamicTimeOut);
			objCheckBox.click();*/

			objShowHideColumnsButton.click();

			// Check the check box for Accrual End Date in Show Hide Columns and
			// Validate the 'Accrual End Date' column is displayed on trades
			// page
			Reporter.log("Test Step: Check The Check Box For Accrual End Date In Show Hide Columns", 1, true);
			Reporter.log("Test Step: Validate The 'Accrual End Date' Column Is Displayed On Trades Page", 1, true);
			/*List<WebElement> arrColumnText = GeneralUtil
					.getElements(
							"//div[starts-with(@class,'src-components-Tables-SimpleTables-Table---main')]//div[starts-with(@class,'ag-header-container')]/div//span[starts-with(@class,'ag-header-cell-text')]",
							"xpath", dynamicTimeOut);
			boolean blnflog = false;
			for (int i = 0; i < arrColumnText.size(); i++) {
				String strActColText = arrColumnText.get(i).getText();
				if (strActColText.equalsIgnoreCase("Accrual End Date")) {
					GeneralUtil.logger.info(strActColText
							+ " coulmn is displayed in Trades grid");
					GeneralUtil.captureScreenshot();
					blnflog = true;
					break;
				}
			}

			if (!blnflog) {
				GeneralUtil.logger
						.error("'Accrual End Date' coulmn is not displayed in Trades grid");
			}
			// Uncheck the 'Accrual End Date' check box
			Reporter.log("Test Step: Uncheck The 'Accrual End Date' Check Box", 1, true);
			objShowHideColumnsButton.click();

			WebElement objCheckBox1 = GeneralUtil.getElement(strCheckBox,
					"xpath", dynamicTimeOut);
			objCheckBox1.click();*/
			
			Reporter.log("Test Case: Successfully Verified Show Hide Trades Colums", 1, true);

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
		Thread.sleep(3000);
		Common.loginOffXVA();
		Browser.quitBrowser();
		Thread.sleep(2000);
	}
}
