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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.Browser;
import util.GeneralUtil;

public class MarketData {
	
	public WebDriver driver;
	public int dynamicTimeOut;
	public String fileUploadPath = null;

	public String marketId = null;
	public String editMarketId = null;
	public String cloneMarketId = null;
	public String timeStamp = null;
	public String fixingId = null;
	public String fixingValue = null;
	public String secondFixingValue = null;
	public String fixingDate = null;
	public String fixingEditDate = null;
	public String fixingEditValue = null;
	public String editFixingsId = null;
	public String cloneFixingsId = null;
	public String marketDescriptorsId = null;
	public String editMarketDescriptorsId = null;
	public String cloneMarketDescriptorsId = null;
	public String strmenu = null;

	@BeforeClass
	public void beforeClass() throws Exception {
		
		GeneralUtil.configureLog4j("Markets Data");
		GeneralUtil.logger("Markets Data");

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
		marketId = "Demo_EOD_FXSPOT";
		editMarketId = "Demo_EOD_FXSPOTEdit";
		cloneMarketId = "Demo_EOD_FXSPOTClone";
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());;
		fixingId = "AUD-BB"+timeStamp;
		fixingValue = "0.123";
		secondFixingValue = "0.111";
		fixingEditValue= "0.321";
		editFixingsId = "AUD-BB"+timeStamp;
		cloneFixingsId = "AUD-BB"+timeStamp+"_Clone";
		marketDescriptorsId = "EQ_MarketDescriptor_"+timeStamp;
		editMarketDescriptorsId = "EQ_MarketDescriptor_"+timeStamp+"_Edit";
		cloneMarketDescriptorsId = "EQ_MarketDescriptor_"+timeStamp+"_Clone";
		strmenu = "//div[@class='ag-menu']//span[@class='ag-menu-option-text']";
	}

	@Test(alwaysRun=true)
	public void marketData_verifyMarketDataTabs() throws Exception {
		try {
			GeneralUtil.logger.info("Verify Market Data Items");
			Reporter.log("Test Case: Verify Market Data Items", 1, true);
			
			// Validating Market Data Tab is expand or not and verify Market
			// Data sub tabs
			if (driver
					.findElement(
							By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Markets']"))
					.isDisplayed()) {
				Reporter.log("Test Step: Verify Market Data Item: Markets", 1, true);
				String strMarketXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Markets']";
				verifyElementPresent("Markets", strMarketXpath, dynamicTimeOut);
				
				Reporter.log("Test Step: Verify Market Data Item: Fixings", 1, true);
				String strFixingsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Fixings']";
				verifyElementPresent("Fixings", strFixingsXpath, dynamicTimeOut);
				
				Reporter.log("Test Step: Verify Market Data Item: Market Descriptors", 1, true);
				String strMarketDescriptorsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Market Descriptors']";
				verifyElementPresent("Market Descriptors",
						strMarketDescriptorsXpath, dynamicTimeOut);
			}
			// Expand Market Data Tab and verify Market Data sub tabs
			else {
				driver.findElement(
						By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/div/div/div/Strong[text()='Market Data']"))
						.click();
				
				Reporter.log("Test Step: Verify Market Data Item: Markets", 1, true);
				String strMarketXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Markets']";
				verifyElementPresent("Markets", strMarketXpath, dynamicTimeOut);
				
				Reporter.log("Test Step: Verify Market Data Item: Fixings", 1, true);
				String strFixingsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Fixings']";
				verifyElementPresent("Fixings", strFixingsXpath, dynamicTimeOut);
				
				Reporter.log("Test Step: Verify Market Data Item: Market Descriptors", 1, true);
				String strMarketDescriptorsXpath = "//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Market Descriptors']";
				verifyElementPresent("Market Descriptors",
						strMarketDescriptorsXpath, dynamicTimeOut);
				
				Reporter.log("Test Case: Successfully Verified Market Data Items", 1, true);
			}
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "marketData_exportMarketDescriptors", alwaysRun=true)
	public void marketData_uploadMarket() throws Exception {
		try {
			GeneralUtil.logger.info("Upload a Markets");
			Reporter.log("Test Case: Upload Market Data Markets", 1, true);

			// Click on Markets
			Reporter.log("Test Step: Click Market Data Markets", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Markets']"))
					.click();

			// Upload the "CVADemo_2014-01-06_FXSPOT.csv" file
			Reporter.log("Test Step: Click CSV Upload On Market Data Markets From Context Menu", 1, true);
			WebElement contextMenuelement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]"));
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			Thread.sleep(1000);
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"CSV Upload");
			
			Thread.sleep(2000);
			Reporter.log("Test Step: Upload The CVADemo_2014-01-06_FXSPOT.csv File", 1, true);
			GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\Data\\Markets\\CVADemo_2014-01-06_EOD_FXSPOT.csv");

			Thread.sleep(4000);
			Reporter.log("Test Step: Search Uploaded Market Data Markets", 1, true);
			WebElement uploadSearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			uploadSearchElement.clear();
			uploadSearchElement.sendKeys(marketId);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Validating the uploaded the "CVADemo_2014-01-06_FXSPOT.csv" file
			// or not
			Reporter.log("Test Step: Verify The CVADemo_2014-01-06_FXSPOT.csv File Is Uploaded", 1, true);
			String marketIdtext = driver
					.findElement(
							By.xpath("//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]"))
					.getText();
			

			if (marketIdtext.equalsIgnoreCase(marketId)) {
				GeneralUtil.logger.info("Markets id " + marketId
						+ " is available in the Markets");
			} else {
				GeneralUtil.logger.error("Markets id " + marketId
						+ " is not available in the Markets");
			}
			GeneralUtil.logger.info("Market uploaded successfully");
			Thread.sleep(1000);
			Reporter.log("Test Case: Successfully Verified Market Data Markets Uploaded", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
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
	
	@Test(dependsOnMethods = { "marketData_uploadMarket" })
	public void marketData_editMarket() throws Exception {
		try {
			GeneralUtil.logger.info("Edit a Markets");
			Reporter.log("Test Case: Edit Market Data Markets", 1, true);
			Thread.sleep(4000);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Markets']"))
					.click();

			// Search the upload market id
			Reporter.log("Test Step: Search The Uploaded Market Data Markets", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(marketId);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Edit the uploaded market id
			Reporter.log("Test Step: Click Uploaded Market Data Markets", 1, true);
			WebElement marketNameElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]"));
			marketNameElement.click();
			
			WebDriverWait NDriver = new WebDriverWait(driver, 40);
			WebElement saveButton = NDriver.until(ExpectedConditions
					.visibilityOfElementLocated(By
							.xpath("//div[text() = 'Save']")));
			
			Reporter.log("Test Step: Enter Text On Name Field For Market Data Markets", 1, true);
			WebElement nameTextElement = driver
					.findElement(By
							.xpath(".//div[@class='ReactTabs react-tabs']/div/div/div/div[2]/div/div[2]/div/input"));
			nameTextElement.clear();
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
			.format(new Date());
			editMarketId = editMarketId + timeStamp;
			nameTextElement.sendKeys(editMarketId);
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Click On Save Button For Edit Market Data Markets", 1, true);
			saveButton.click();
		
			
			Reporter.log("Test Step: Click On OK Button For Edit Market Data Markets", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			Reporter.log("Test Step: Click On Close Button For Edit Market Data Markets", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Go to Markets']")).click();
			
			//handleNotifications("Success");

			Thread.sleep(3000);

					
			Reporter.log("Test Step: Search The Edited Market Data Markets", 1, true);			
			WebElement SearchElement1 = driver
					.findElement(By
							.xpath("//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			SearchElement1.clear();
			SearchElement1.sendKeys(editMarketId);	
			
			Thread.sleep(3000);
			/*int count = 1;
			while (count < dynamicTimeOut) {
				WebElement SearchElement2 = driver
						.findElement(By
								.xpath("//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
				SearchElement2.clear();
				SearchElement2.sendKeys(editMarketId);				
				List<WebElement> rows =  driver.findElements(By.xpath("//div[contains(@class,'ag-body-container')]/div[contains(@class,'ag-row')]"));
				if (rows.size()>=1) {
						break;
				}
				Thread.sleep(2000);
				count++;
			}*/
			
			// Validating the market id is edited or not
			Reporter.log("Test Step: Verify Market Data Markets Is Edited", 1, true);
			String marketIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]"))
					.getText();
			if (marketIdtext.equalsIgnoreCase(editMarketId)) {
				GeneralUtil.logger.info("Markets id " + editMarketId
						+ " is available in the Markets");

			} else {
				GeneralUtil.logger.info("Markets id " + editMarketId
						+ " is not available in the Markets");
			}

			GeneralUtil.captureScreenshot();
			Reporter.log("Test Case: Successfully Verified Market Data Markets Edited", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market edited successfully");

	}

	@Test(dependsOnMethods = { "marketData_editMarket" })
	public void marketData_cloneMarket() throws Exception {
		try {
			GeneralUtil.logger.info("Clone a Market");
			Reporter.log("Test Case: Clone Market Data Markets", 1, true);
			Thread.sleep(4000);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Markets']"))
					.click();
			
			// Search the edit market id
			Reporter.log("Test Step: Search The Edited Market Data Markets", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(editMarketId);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Clone the market id
			Reporter.log("Test Step: Click Clone On Market Data Markets From Context Menu", 1, true);
			WebElement contextMenuelement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]"));
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Clone");
			WebDriverWait NDriver = new WebDriverWait(driver, 40);
			WebElement saveButton = NDriver.until(ExpectedConditions
					.visibilityOfElementLocated(By
							.xpath("//div[text() = 'Save']")));
			
			Reporter.log("Test Step: Enter Text On Name Field For Market Data Markets", 1, true);
			WebElement nameTextElement = driver
					.findElement(By
							.xpath(".//div[@class='ReactTabs react-tabs']/div/div/div/div[2]/div/div[2]/div/input"));
			nameTextElement.clear();
			
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
			.format(new Date());
			cloneMarketId = cloneMarketId + timeStamp;
			nameTextElement.sendKeys(cloneMarketId);
			
			Reporter.log("Test Step: Click On Save Button For Clone Market Data Markets", 1, true);
			saveButton.click();
			
			
			Reporter.log("Test Step: Click On OK Button For Clone Market Data Markets", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			Reporter.log("Test Step: Click On Close Button For Clone Market Data Markets", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Go to Markets']")).click();
			GeneralUtil.captureScreenshot();

			

			Thread.sleep(2000);
			
			Reporter.log("Test Step: Search The Cloned Market Data Markets", 1, true);
			WebElement SearchElement1 = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			SearchElement1.clear();
			SearchElement1.sendKeys(cloneMarketId);	
			Thread.sleep(3000);
			int count = 1;
			/*while (count < dynamicTimeOut) {
				SearchElement1.clear();
				SearchElement1.sendKeys(cloneMarketId);				
				List<WebElement> rows =  driver.findElements(By.xpath("//div[contains(@class,'ag-body-container')]/div[contains(@class,'ag-row')]"));
				if (rows.size()>=1) {
						break;
				}
				Thread.sleep(2000);
				count++;
			}*/

			// Validating the market id is cloned or not
			Reporter.log("Test Step: Verify Market Data Markets Cloned", 1, true);
			String marketIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]"))
					.getText();
			if (marketIdtext.equalsIgnoreCase(cloneMarketId)) {
				GeneralUtil.logger.info("Markets id " + cloneMarketId
						+ " is available in the Markets");

			} else {
				GeneralUtil.logger.info("Markets id " + cloneMarketId
						+ " is not available in the Markets");
			}

			GeneralUtil.captureScreenshot();
			Reporter.log("Test Case: Successfully Verified Market Data Markets Cloned", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Markets clone successfully");

	}

	@Test(dependsOnMethods = { "marketData_editMarket" })
	public void marketData_downloadMarket() throws Exception {
		try {
			GeneralUtil.logger.info("Download a Market");
			Reporter.log("Test Case: Download Market Data Markets", 1, true);
			Thread.sleep(4000);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[1]/div/div/div[text() ='Markets']"))
					.click();
			Thread.sleep(2000);
			
			// Search the edit market id
			Reporter.log("Test Step: Click Clear All Filters On Market Data Markets From Context Menu", 1, true);		
			WebElement contextMenuelement1 = GeneralUtil.getElement(
					"//*[@ref='center']/div/div[4]/div[3]/div", "xpath",
					dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement1);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Clear All Filters");
			GeneralUtil.captureScreenshot();

			// Download market id and Validating the market id is download or
			// not
			Reporter.log("Test Step: Click CSV Download & Download All On Market Data Markets From Context Menu", 1, true);
			WebElement contextMenuelement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]"));
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			Common
					.download(
							"CSV Download",
							"Download All",
							"Markets(.*).zip",
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							".//*[@id='borderLayout_eRootPanel']/div[5]/div/div/span[2]");
			Reporter.log("Test Step: Verify The Market Data Markets Is Download", 1, true);
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Case: Successfully Downloaded Market Data Markets", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Markets download successfully");

	}

	@Test(dependsOnMethods = { "marketData_downloadMarket" })
	public void marketData_deleteMarket() throws Exception {
		try {
			GeneralUtil.logger.info("Delete a Market");
			Reporter.log("Test Case: Delete Market Data Markets", 1, true);
			Thread.sleep(8000);
		
			Reporter.log("Test Step: Click Clear All Filters On Market Data Markets From Context Menu", 1, true);
			WebElement contextMenuelement1 = GeneralUtil.getElement(
					"//*[@ref='center']/div/div[4]/div[3]/div", "xpath",
					dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement1);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Clear All Filters");
			GeneralUtil.captureScreenshot();

			// Search the edit market id
			Reporter.log("Test Step: Search Edited Market Data Markets", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(editMarketId);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			

			// Delete the added market id and validating
			Reporter.log("Test Step: Click Delete On Market Data Markets From Context Menu", 1, true);
			WebElement contextMenuelement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]"));
			GeneralUtil.contextMenu(contextMenuelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Delete");
			
			Reporter.log("Test Step: Click OK Button For Delete Market Data Markets", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Click Clear All Filters On Market Data Markets From Context Menu", 1, true);
			WebElement contextMenuelement2 = GeneralUtil.getElement(
					"//*[@ref='center']/div/div[4]/div[3]/div", "xpath",
					dynamicTimeOut);
			GeneralUtil.contextMenu(contextMenuelement2);
			GeneralUtil.captureScreenshot();
			GeneralUtil.contextMenuItem(strmenu, "Clear All Filters");
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Search The Cloned Market Data Markets", 1, true);
			WebElement SearchElement1 = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
			// Search the clone market id
			SearchElement1.clear();
			SearchElement1.sendKeys(cloneMarketId);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Delete the cloned market id and validating
			Reporter.log("Test Step: Click Delete On Market Data Markets From Context Menu", 1, true);
			WebElement contextMenuSecondelement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]"));
			GeneralUtil.contextMenu(contextMenuSecondelement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Delete");
			
			Reporter.log("Test Step: Click OK Button For Delete Market Data Markets", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Case: Successfully Deleted Market Data Markets", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		//GeneralUtil.logger.info("Market deleted successfully");

	}
	
	@Test(dependsOnMethods = "marketData_deleteMarket", alwaysRun=true)
	public void marketData_exportMarket() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export Market");
		Reporter.log("Test Case: Export Market", 1, true);
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
						.xpath(" //*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Market CSV Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver
				.findElement(By
						.xpath(" //*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Market Excel Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported Market", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	@Test(dependsOnMethods ="marketData_verifyMarketDataTabs", alwaysRun=true)
	public void marketData_addFixings() throws Exception {
		try {
			GeneralUtil.logger.info("Add a Fixings");
			Reporter.log("Test Case: Add Market Data Fixings", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Fixings']"))
					.click();
			GeneralUtil.captureScreenshot();
			Thread.sleep(1000);

			// Add the Fixings
			Reporter.log("Test Step: Click Add On Market Data Fixings From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Add");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Enter Text On ID Field For Fixings", 1, true);
			driver.findElement(
					By.xpath("//div[@class='react-draggable']/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input"))
					.sendKeys(fixingId);
			
			Reporter.log("Test Step: Click On OK Button For Fixings Add Page", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			// Add the Fixings name and save
						Reporter.log("Test Step: Update The Added Market Data Fixings", 1, true);
						WebElement nameTextElement = driver
								.findElement(By
										.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div/div[2]/div[2]/div/input"));
						nameTextElement.clear();
						nameTextElement.sendKeys(fixingId);
						Thread.sleep(1000);
			
			fixingDate = addDaysToTodayDate(30);
			
			// Add the Fixings End Date and save
						Reporter.log("Test Step: Add The Market Data Fixings End Date", 1, true);
						WebElement endDateTextElement = driver
								.findElement(By
										.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div/div[4]/div[2]/div/div/input"));
						endDateTextElement.clear();
						endDateTextElement.sendKeys(fixingDate);
			
			Reporter.log("Test Step: Click Add On Market Data Fixings Subwindow From Context Menu", 1, true);
			WebElement contextMenuRightElement = driver
					.findElement(By
							.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div[4]/div[3]/div"));
			GeneralUtil.contextMenu(contextMenuRightElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							" //div[starts-with(@class,'src-components-Dashboard-MarketData-Fixings-Fixing---detailContainer')]//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Add");
			
			/*// Click on Fixing Date field 
			Reporter.log("Test Step: Click On Fixing Date in Sub Window", 1, true);
			WebElement objFixingDate = GeneralUtil
							.getElement(
							".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]/div/span",
							"xpath", dynamicTimeOut);
			objFixingDate.click();*/
									
			// Enter on Fixing value field	
			Reporter.log("Test Step: Send Value To Fixing Date in Sub Window", 1, true);
			WebElement objFixingTextDate = GeneralUtil
							.getElement(
							"//div[@class='react-draggable']//div[@class='react-datepicker__input-container']/input",
							"xpath", dynamicTimeOut);
			//objFixingTextDate.click();
			objFixingTextDate.clear();
			objFixingTextDate.sendKeys(fixingDate);
						
			/*// Click on Fixing Value field 
			Reporter.log("Test Step: Click On Fixing Value in Sub Window", 1, true);
			WebElement objFixingValue = GeneralUtil
						.getElement(
						".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[2]/div/div/span",
						"xpath", dynamicTimeOut);
			objFixingValue.click();*/
						
			// Enter on Fixing value field	
			Reporter.log("Test Step: Send Value To Fixing Value in Sub Window", 1, true);
			WebElement objFixingTextValue = GeneralUtil
						.getElement(
						"//div[@class='react-draggable']//div[starts-with(@class,'src-components-SmartInputs-FastNumberInput-FastNumberInput')]/input",
						"xpath", dynamicTimeOut);
			//objFixingTextValue.click();
			objFixingTextValue.clear();
			objFixingTextValue.sendKeys(fixingValue);
			
			Reporter.log("Test Step: Click On OK Button For Market Data Fixings Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
						
			Reporter.log("Test Step: Click On Save Button For Market Data Fixings Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click On OK Button For Market Data Fixings Subwindow", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			
			//TT 45574 - Application change in in build 4.6
			// Validating the Fixings added or not
			Reporter.log("Test Step: Verify Notification Displayed Save Fixings", 1, true);
			Common.handleNotifications("Save Fixings");
			
			Reporter.log("Test Step: Search Added Market Data Fixings ID", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(fixingId);
			
			Reporter.log("Test Step: Search Added Market Data Fixings Date", 1, true);
			WebElement SearchFixingDateElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[4]/div/div/input"));
			SearchFixingDateElement.clear();
			SearchFixingDateElement.sendKeys(fixingDate);
			
			Reporter.log("Test Step: Search Added Market Data Fixings value", 1, true);
			WebElement SearchFixingValueElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[7]/div/div/input"));
			SearchFixingValueElement.clear();
			SearchFixingValueElement.sendKeys(fixingValue);
			
			Reporter.log("Test Step: Verify Market Data Fixings Added", 1, true);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			String fixingsIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			
			String fixingsValuetext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[7]"))
					.getText();
			
			String fixingsDatetext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[4]"))
					.getText();

			if (fixingsIdtext.equalsIgnoreCase(fixingId) && fixingsValuetext.equalsIgnoreCase(fixingValue) && fixingsDatetext.equalsIgnoreCase(fixingDate)) {
				GeneralUtil.logger.info("Fixings id " + fixingId+ " Fixing Value " + fixingValue+ " Fixing Date " +fixingDate+ " is available in the Fixings");
			} else {
				GeneralUtil.logger.info("Fixings id " + fixingId+ " Fixing Value " + fixingValue+ " Fixing Date " +fixingDate+ " is not available in the Fixings");
			}
			Reporter.log("Test Case: Successfully Added Market Data Fixings", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Fixings created successfully");
	}

	@Test(dependsOnMethods = { "marketData_addFixings" })
	public void marketData_editFixings() throws Exception {
		try {
			GeneralUtil.logger.info("Edit a Fixings");
			Reporter.log("Test Case: Edit Market Data Fixings", 1, true);
			Thread.sleep(4000);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Fixings']"))
					.click();
			
			
			// Clear the filter for Fixing columns
					WebElement contextMenuElement = driver.findElement(By
					.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
						Reporter.log("Test Step: Clear The Market Data Fixings Filter Columns", 1, true);
						GeneralUtil.contextMenu(contextMenuElement);
						GeneralUtil
								.contextMenuItem(
										".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
										"Clear All Filters");
						Thread.sleep(1000);
			
			// Search the added Fixings
			Reporter.log("Test Step: Search Added Market Data Fixings", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(fixingId);
			Thread.sleep(1000);

			// Click on added Fixings
			Reporter.log("Test Step: Clicked on Added Market Data Fixings", 1, true);
			WebElement fixingIdElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			fixingIdElement.click();
			Thread.sleep(1000);
			
			// Update the Fixings name and save
			Reporter.log("Test Step: Update The Added Market Data Fixings", 1, true);
			WebElement nameTextElement = driver
					.findElement(By
							.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div/div[2]/div[2]/div/input"));
			nameTextElement.clear();
			nameTextElement.sendKeys(editFixingsId);
			Thread.sleep(1000);
			fixingEditDate = addDaysToTodayDate(60);
			
			// Update the Fixings End Date and save
			Reporter.log("Test Step: Update The Market Data Fixings End Date", 1, true);
			WebElement endDateTextElement = driver
					.findElement(By
							.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div/div[4]/div[2]/div/div/input"));
			endDateTextElement.clear();
			endDateTextElement.sendKeys(fixingEditDate);
			Thread.sleep(1000);
			
			// Click on Fixing Date field 
			Reporter.log("Test Step: Click On Fixing Date in Sub Window", 1, true);
			WebElement objFixingDate = GeneralUtil
							.getElement(
							".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/span",
							"xpath", dynamicTimeOut);
			objFixingDate.click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Click Edit On Market Data Fixings Subwindow From Context Menu", 1, true);
			WebElement contextMenuRightElement = driver
					.findElement(By
							.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/span"));
			GeneralUtil.contextMenu(contextMenuRightElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							"//div[starts-with(@class,'src-components-Dashboard-MarketData-Fixings-Fixing---detailContainer')]//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Edit");
			Thread.sleep(1000);
			
		/*	// Enter on Fixing Date field	
			Reporter.log("Test Step: Send Value To Fixing Date in Sub Window", 1, true);
			WebElement objFixingTextDate = GeneralUtil
							.getElement(
							".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[1]/div/div/input",
							"xpath", dynamicTimeOut);
			objFixingTextDate.click();
			objFixingTextDate.clear();
			objFixingTextDate.sendKeys(fixingEditDate);
			Thread.sleep(1000);*/
			
			/*// Click on Fixing value field 
			Reporter.log("Test Step: Click On Fixing Value in Sub Window", 1, true);
			Actions action = new Actions(driver);
			WebElement objFixingValue = GeneralUtil
					.getElement(
							".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/span",
							"xpath", dynamicTimeOut);
			objFixingValue.click();
			Thread.sleep(1000);*/
			
			// Enter on Fixing value field	
			Reporter.log("Test Step: Send Value To Fixing Value in Sub Window", 1, true);
			WebElement objFixing1Value = GeneralUtil
					.getElement(
							"//div[@class='react-draggable']//div[starts-with(@class,'src-components-SmartInputs-FastNumberInput-FastNumberInput')]/input",
							"xpath", dynamicTimeOut);
			//objFixing1Value.click();
			objFixing1Value.clear();
			objFixing1Value.sendKeys(fixingEditValue);
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Click OK Button For Added Market Data Fixings", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Click Save Button For Added Market Data Fixings", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click OK Button For Added Market Data Fixings", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();

			// Validating the Fixings edited or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Save Fixings");

			Thread.sleep(1000);
			Reporter.log("Test Step: Search Edited Market Data Fixings ID", 1, true);
			WebElement SearchElement1 = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement1.clear();
			SearchElement1.sendKeys(editFixingsId);
			Thread.sleep(1000);
			
			/*Reporter.log("Test Step: Search Edited Market Data Fixings Date", 1, true);
			WebElement SearchFixingDateElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[4]/div/div/input"));
			SearchFixingDateElement.clear();
			SearchFixingDateElement.sendKeys(fixingEditDate);
			Thread.sleep(1000);*/
			
			Reporter.log("Test Step: Search Edited Market Data Fixings value", 1, true);
			WebElement SearchFixingValueElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[7]/div/div/input"));
			SearchFixingValueElement.clear();
			SearchFixingValueElement.sendKeys(fixingEditValue);
			Thread.sleep(1000);
			Reporter.log("Test Step: Verify Market Data Fixings Edited", 1, true);
			String fixingsIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();
			
			String fixingsEditValuetext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[7]"))
					.getText();
			
			String fixingsEditDatetext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[4]"))
					.getText();

			if (fixingsIdtext.equalsIgnoreCase(editFixingsId) && fixingsEditValuetext.equalsIgnoreCase(editFixingsId) && fixingsEditDatetext.equalsIgnoreCase(fixingEditDate)) {
				GeneralUtil.logger.info("Fixings id " + editFixingsId
						+ " Fixing Edit Value"+ editFixingsId+ " Fixing Edit Date " + fixingEditDate+ "is available in the Fixings");
			} else {
				GeneralUtil.logger.info("Fixings id " + editFixingsId
						+ " Fixing Edit Value"+ editFixingsId+ " Fixing Edit Date " + fixingEditDate+ "is not available in the Fixings");
			}

			GeneralUtil.captureScreenshot();
			Reporter.log("Test Case: Successfully Edited Market Data Fixings", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Fixings edited successfully");

	}

	@Test(dependsOnMethods = { "marketData_editFixings" })
	public void marketData_cloneFixings() throws Exception {
		try {
			GeneralUtil.logger.info("Clone a Fixings");
			Reporter.log("Test Case: Clone Market Data Fixings", 1, true);
			Thread.sleep(4000);
			
			// Clear the filter for Fixing columns
			WebElement contextMenuClearFilterElement = driver.findElement(By
			.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
				Reporter.log("Test Step: Clear The Trade Filter Columns", 1, true);
				GeneralUtil.contextMenu(contextMenuClearFilterElement);
				GeneralUtil
						.contextMenuItem(
								".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
								"Clear All Filters");
				Thread.sleep(1000);
			
			// Search the edit Fixings
			Reporter.log("Test Step: Search Edited Market Data Fixings", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			Thread.sleep(1000);
			SearchElement.sendKeys(editFixingsId);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Click Clone On Market Data Market Fixings", 1, true);
			WebElement clickElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			clickElement.click();
			Thread.sleep(1000);
			// Clone the edited fixings
			Reporter.log("Test Step: Click Clone On Market Data Market Fixings From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Clone");

			// Update the Fixings name and save the fixings
			Reporter.log("Test Step: Update The Fixings Name", 1, true);
			WebElement nameTextElement = driver
					.findElement(By
							.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div/div[2]/div[2]/div/input"));
			nameTextElement.clear();
			nameTextElement.sendKeys(cloneFixingsId);
			
			Reporter.log("Test Step: Click On Save Button For Update The Fixings", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click On OK Button For Update The Fixings", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();

			// Validating the Fixings cloned or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Save Fixings");

			Thread.sleep(1000);
			
			Reporter.log("Test Step: Search Cloned Market Data Fixings", 1, true);
			WebElement SearchElement1 = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement1.clear();
			SearchElement1.sendKeys(cloneFixingsId);
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Verify Market Data Fixings Is Cloned", 1, true);
			String fixingsIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();

			if (fixingsIdtext.equalsIgnoreCase(cloneFixingsId)) {
				GeneralUtil.logger.info("Fixings id " + cloneFixingsId
						+ " is available in the Fixings");
			} else {
				GeneralUtil.logger.error("Fixings id " + cloneFixingsId
						+ " is not available in the Fixings");
			}

			GeneralUtil.captureScreenshot();
			Reporter.log("Test Case: Successfully Cloned Market Data Fixings", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Fixings cloned successfully");

	}

	@Test(dependsOnMethods = { "marketData_cloneFixings" })
	public void marketData_uploadFixings() throws Exception {
		try {
			GeneralUtil.logger.info("Upload a Fixings");
			Reporter.log("Test Case: Upload Market Data Fixings", 1, true);
			Thread.sleep(4000);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Fixings']"))
					.click();
			// Clear the filter for Fixing columns
						WebElement contextMenuClearFilterElement = driver.findElement(By
						.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
							Reporter.log("Test Step: Clear The Trade Filter Columns", 1, true);
							GeneralUtil.contextMenu(contextMenuClearFilterElement);
							GeneralUtil
									.contextMenuItem(
											".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
											"Clear All Filters");
							Thread.sleep(1000);
			
			// Search the edit Fixings
			Reporter.log("Test Step: Search Edited Market Data Fixings", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(editFixingsId);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Upload the 'AUD-BB-6M.csv' the CSV Upload
			Reporter.log("Test Step: Click CSV Upload On Fixings From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"CSV Upload");
			Thread.sleep(1000);
			Reporter.log("Test Step: Upload AUD-BB-6M.csv File", 1, true);
			GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\Data\\Fixings\\AUD-BB-6M.csv");
			Thread.sleep(2000);
			// Validating the 'AUD-BB-6M' file uploaded or not
			//Common.handleNotifications("Upload fixing");

			Thread.sleep(1000);
			
			Reporter.log("Test Step: Search Uploaded Market Data Fixings", 1, true);
			 WebElement SearchElement1 = driver
					 .findElement(By
				.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement1.clear();
			SearchElement1.sendKeys("AUD-BB-6M");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Verify Market Data Fixings Is Uploaded", 1, true);
			String fixingsIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();

			if (fixingsIdtext.equalsIgnoreCase("AUD-BB-6M")) {
				GeneralUtil.logger
						.info("Fixings id AUD-BB-6M is available in the Fixings");
			} else {
				GeneralUtil.logger
						.error("Fixings id AUD-BB-6M is not available in the Fixings");
			}

			GeneralUtil.captureScreenshot();
			Reporter.log("Test Case: Successfully Uploaded Market Data Fixings", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Fixings uploaded successfully");

	}

	@Test(dependsOnMethods = { "marketData_uploadFixings" })
	public void marketData_downloadFixings() throws Exception {
		try {
			GeneralUtil.logger.info("Download a Fixings");
			Reporter.log("Test Case: Download Market Data Fixings", 1, true);
			Thread.sleep(4000);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Fixings']"))
					.click();
			Thread.sleep(2000);
			
			// Clear the filter for Fixing columns
						WebElement contextMenuClearFilterElement = driver.findElement(By
						.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
							Reporter.log("Test Step: Clear The Trade Filter Columns", 1, true);
							GeneralUtil.contextMenu(contextMenuClearFilterElement);
							GeneralUtil
									.contextMenuItem(
											".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
											"Clear All Filters");
							Thread.sleep(1000);
						
			// Search the edit Fixings
			Reporter.log("Test Step: Search Edited Market Data Fixings", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(editFixingsId);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Download the fixings and validating "Fixings(.*).zip" file
			// download or not
			Reporter.log("Test Step: Download The Market Data Fixings And Verify The File Download", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			Thread.sleep(1000);
			Common
					.download(
							"CSV Download",
							"Download All",
							"Fixings(.*).zip",
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							".//*[@id='borderLayout_eRootPanel']/div[5]/div/div/span[2]");
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Case: Successfully Downloaded Market Data Fixings", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Fixings downloaded successfully");

	}

	@Test(dependsOnMethods = { "marketData_downloadFixings" })
	public void marketData_deleteFixings() throws Exception {
		try {
			GeneralUtil.logger.info("Delete a Fixings");
			Reporter.log("Test Case: Delete Market Data Fixings", 1, true);
			Thread.sleep(4000);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[2]/div/div/div[text() ='Fixings']"))
					.click();
			// Clear the filter for Fixing columns
						WebElement contextMenuClearFilterElement = driver.findElement(By
						.xpath(".//*[@ref='center']/div/div[4]/div[3]/div"));
							Reporter.log("Test Step: Clear The Trade Filter Columns", 1, true);
							GeneralUtil.contextMenu(contextMenuClearFilterElement);
							GeneralUtil
									.contextMenuItem(
											".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
											"Clear All Filters");
							Thread.sleep(1000);
			
			// Search the edit Fixings
			Reporter.log("Test Step: Search Edited Market Data Fixings", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(editFixingsId);
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Delete the added fixings
			Reporter.log("Test Step: Click Delete On Market Data Fixings From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Delete");
			
			Reporter.log("Test Step: Click OK Button For Delete Market Data Fixings", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			// Validating the added fixings deleted or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Delete Fixings");
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Search Uploaded Market Data Fixings", 1, true);
			WebElement SearchElement1 = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement1.clear();
			SearchElement1.sendKeys("AUD-BB-6M");
			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();

			// Delete the clone fixings
			Reporter.log("Test Step: Click Delete On Market Data Fixings From Context Menu", 1, true);
			WebElement contextMenuSecondElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuSecondElement);
			GeneralUtil.captureScreenshot();
			Thread.sleep(1000);
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]",
							"Delete");
			
			Reporter.log("Test Step: Click OK Button For Delete Market Data Fixings", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			// Validating the cloned fixings deleted or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Delete Fixings");
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Case: Successfully Deleted Market Data Fixings", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Fixings deleted successfully");

	}
	
	@Test(dependsOnMethods = "marketData_deleteFixings", alwaysRun=true)
	public void marketData_exportFixings() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export Fixings");
		Reporter.log("Test Case: Export Fixings", 1, true);
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
						.xpath(" //*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Fixings CSV Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver
				.findElement(By
						.xpath(" //*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("Fixings Excel Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported Fixings", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
		
	@Test(dependsOnMethods = "marketData_exportFixings", alwaysRun=true)
	public void marketData_addMarketDescriptors() throws Exception {
		try {

			GeneralUtil.logger.info("Add a Market Descriptors");
			Reporter.log("Test Case: Add Market Data Market Descriptors", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Market Descriptors']"))
					.click();
			GeneralUtil.captureScreenshot();
			Thread.sleep(1000);
			
			// Add the Market Descriptors
			Reporter.log("Test Step: Click Add On Market Data Market Descriptors From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			//Thread.sleep(2000);
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Add");
			Thread.sleep(1000);
			
			// fill the add page on Market Descriptors and click on ok button
			Reporter.log("Test Step: Enter Text On Market Descriptors Name Field", 1, true);
			driver.findElement(
					By.xpath("html/body/div[4]/div/div/div/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input"))
					.sendKeys(marketDescriptorsId);
			
			Reporter.log("Test Step: Click OK Button For Add Market Data Market Descriptors", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();

			// Create the Insert column page
			Reporter.log("Test Step: Create The Insert Key Column For Add Market Data Market Descriptors", 1, true);
			addMarketDescriptorContextMenu("KEY");
			
			Reporter.log("Test Step: Create The Insert Company Description Column For Add Market Data Market Descriptors", 1, true);
			addMarketDescriptorContextMenu("Company Description");
			
			Reporter.log("Test Step: Create The Insert Sector Name Column For Add Market Data Market Descriptors", 1, true);
			addMarketDescriptorContextMenu("Sector Name");
			
			Reporter.log("Test Step: Create The Insert Industry Name ColumnFor Add Market Data Market Descriptors", 1, true);
			addMarketDescriptorContextMenu("Industry Name");

			// Fill the inserted column and save the Market Descriptor
			Reporter.log("Test Step: Enter Text on Insert Key Column For Add Market Data Market Descriptors", 1, true);
			driver.findElement(
					By.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div/div/div/div[3]/div/div[2]/div[1]/div/div/input"))
					.sendKeys("EQ.USD-US-AXP.SPOT.MID");
			
			Reporter.log("Test Step: Enter Text on Insert Company Description Column For Add Market Data Market Descriptors", 1, true);
			driver.findElement(
					By.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div/div/div/div[3]/div/div[2]/div[2]/div/div/input"))
					.sendKeys(
							"American Express Company is a global payment and travel company. The Company's principal products and services are charge and credit payment card products and travel-related services offered to consumers and businesses around the world.");
			
			Reporter.log("Test Step: Enter Text on Insert Sector Name Column For Add Market Data Market Descriptors", 1, true);
			driver.findElement(
					By.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div/div/div/div[3]/div/div[2]/div[3]/div/div/input"))
					.sendKeys("Financials");
			
			Reporter.log("Test Step: Enter Text on Insert Industry Name Column For Add Market Data Market Descriptors", 1, true);
			driver.findElement(
					By.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div/div/div/div[3]/div/div[2]/div[4]/div/div/input"))
					.sendKeys("Consumer Finance");
			
			Reporter.log("Test Step: Click Save Button For Add Market Data Market Descriptors In Sub Window", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click OK Button For Add Market Data Market Descriptors In Sub Window", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();

			// Validating the Market Descriptor is added or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Save Market Descriptor");
			
			Reporter.log("Test Step: Search Added Market Data Market Descriptors", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(marketDescriptorsId);

			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Verify Market Data Market Descriptors Added", 1, true);
			String fixingsIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();

			if (fixingsIdtext.equalsIgnoreCase(marketDescriptorsId)) {
				GeneralUtil.logger.info("Market Descriptors id "
						+ marketDescriptorsId
						+ " is available in the Market Descriptors");
			} else {
				GeneralUtil.logger.error("Market Descriptors id "
						+ marketDescriptorsId
						+ " is not available in the Market Descriptors");
			}
			Reporter.log("Test Case: Successfully Added Market Data Market Descriptors", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Descriptors created successfully");
	}

	@Test(dependsOnMethods = { "marketData_addMarketDescriptors" })
	public void marketData_editMarketDescriptors() throws Exception {
		try {
			GeneralUtil.logger.info("Edit a Market Descriptors");
			Reporter.log("Test Case: Edit Market Data Market Descriptors", 1, true);
			Thread.sleep(4000);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Market Descriptors']"))
					.click();

			// Search the added Market Descriptor
			Reporter.log("Test Step: Search Added Market Data Market Descriptors", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(marketDescriptorsId);

			// Click on added Market Descriptors
			Reporter.log("Test Step: Click Added Market Data Market Descriptors", 1, true);
			driver.findElement(
					By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.click();

			// Fill the edit Market Descriptors column and save
			Reporter.log("Test Step: Enter Text on Insert Key Column For Add Market Data Market Descriptors", 1, true);
			driver.findElement(
					By.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div/div/div/div[3]/div/div[2]/div[1]/div/div/input"))
					.sendKeys("EQ.USD-US-AXP.SPOT.MID");
			
			Reporter.log("Test Step: Enter Text on Insert Company Description Column For Add Market Data Market Descriptors", 1, true);
			driver.findElement(
					By.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div/div/div/div[3]/div/div[2]/div[2]/div/div/input"))
					.sendKeys(
							"American Express Company is a global payment and travel company. The Company's principal products and services are charge and credit payment card products and travel-related services offered to consumers and businesses around the world.");
			
			Reporter.log("Test Step: Enter Text on Insert Sector Name Column For Add Market Data Market Descriptors", 1, true);
			driver.findElement(
					By.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div/div/div/div[3]/div/div[2]/div[3]/div/div/input"))
					.sendKeys("Financials");
			
			Reporter.log("Test Step: Enter Text on Insert Industry Name Column For Add Market Data Market Descriptors", 1, true);
			driver.findElement(
					By.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div/div/div/div[3]/div/div[2]/div[4]/div/div/input"))
					.sendKeys("Consumer Finance");
			
			Reporter.log("Test Step: Click Save Button For Add Market Data Market Descriptors", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click OK Button For Add Market Data Market Descriptors", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();

			// Validating the Market Descriptor is added or not
			Reporter.log("Test Step: Verify Success Notification For Add Market Data Market Descriptors", 1, true);
			Common.handleNotifications("Save Market Descriptor");
			
			Reporter.log("Test Step: Search Edited Market Data Market Descriptors", 1, true);
			WebElement SearchSecondElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchSecondElement.clear();
			SearchSecondElement.sendKeys(marketDescriptorsId);

			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Verify Market Data Market Descriptors Edited", 1, true);
			String fixingsIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();

			if (fixingsIdtext.equalsIgnoreCase(editMarketDescriptorsId)) {
				GeneralUtil.logger.info("Market Descriptors id "
						+ marketDescriptorsId
						+ " is available in the Market Descriptors");
			} else {
				GeneralUtil.logger.error("Market Descriptors id "
						+ marketDescriptorsId
						+ " is not available in the Market Descriptors");
			}
			Reporter.log("Test Case: Successfully Edited Market Data Market Descriptors", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Descriptors edited successfully");
	}

	@Test(dependsOnMethods = { "marketData_editMarketDescriptors" })
	public void marketData_cloneMarketDescriptors() throws Exception {
		try {

			GeneralUtil.logger.info("Clone a Market Descriptors");
			Reporter.log("Test Case: Clone Market Data Market Descriptors", 1, true);
			Thread.sleep(4000);
			
			Reporter.log("Test Step: Click Market Data Market Descriptors", 1, true);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Market Descriptors']"))
					.click();
			
			// Search the added Market Descriptor
			Reporter.log("Test Step: Search Added Market Data Market Descriptors", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(marketDescriptorsId);
			
			Reporter.log("Test Step: Click Clone Market Data Market Descriptors From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Clone");
			
			// Fill the cloned column and save the Market Descriptor
			Reporter.log("Test Step: Enter Text On Market Descriptors Name Field", 1, true);
			driver.findElement(
					By.xpath("html/body/div[4]/div/div/div/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input"))
					.sendKeys(cloneMarketDescriptorsId);
			
			Reporter.log("Test Step: Click OK Button For Market Descriptor Name Page", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			
			Reporter.log("Test Step: Enter Text on Insert Key Column For Add Market Data Market Descriptors", 1, true);
			driver.findElement(
					By.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div/div/div/div[3]/div/div[2]/div[1]/div/div/input"))
					.sendKeys("EQ.USD-US-AXP.SPOT.MID");
			
			Reporter.log("Test Step: Enter Text on Insert Company Description Column For Add Market Data Market Descriptors", 1, true);
			driver.findElement(
					By.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div/div/div/div[3]/div/div[2]/div[2]/div/div/input"))
					.sendKeys(
							"American Express Company is a global payment and travel company. The Company's principal products and services are charge and credit payment card products and travel-related services offered to consumers and businesses around the world.");
			
			Reporter.log("Test Step: Enter Text on Insert Sector Name Column For Add Market Data Market Descriptors", 1, true);
			driver.findElement(
					By.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div/div/div/div[3]/div/div[2]/div[3]/div/div/input"))
					.sendKeys("Financials");
			
			Reporter.log("Test Step: Enter Text on Insert Industry Name Column For Add Market Data Market Descriptors", 1, true);
			driver.findElement(
					By.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div/div/div/div[3]/div/div[2]/div[4]/div/div/input"))
					.sendKeys("Consumer Finance");
			
			Reporter.log("Test Step: Click Save Button For Add Market Data Market Descriptors", 1, true);
			driver.findElement(By.xpath("//div[text() = 'Save']")).click();
			
			Reporter.log("Test Step: Click OK Button For Add Market Data Market Descriptors", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();

			// Validating the Market Descriptor is added or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Save Market Descriptor");
			
			Thread.sleep(1000);
			Reporter.log("Test Step: Search Cloned Market Data Market Descriptors", 1, true);
			WebElement SearchSecondElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchSecondElement.clear();
			Thread.sleep(1000);
			SearchSecondElement.sendKeys(cloneMarketDescriptorsId);

			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Verify Market Data Market Descriptors Cloned", 1, true);
			String fixingsIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();

			if (fixingsIdtext.equalsIgnoreCase(cloneMarketDescriptorsId)) {
				GeneralUtil.logger.info("Market Descriptors id "
						+ cloneMarketDescriptorsId
						+ " is available in the Market Descriptors");
			} else {
				GeneralUtil.logger.error("Market Descriptors id "
						+ cloneMarketDescriptorsId
						+ " is not available in the Market Descriptors");
			}
			Reporter.log("Test Case: Successfully Cloned Market Data Market Descriptors", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Descriptors cloned successfully");
	}

	@Test(dependsOnMethods = { "marketData_downloadMarketDescriptors" })
	public void marketData_uploadMarketDescriptors() throws Exception {
		try {

			GeneralUtil.logger.info("Upload a Market Descriptors");
			Reporter.log("Test Case: Upload Market Data Market Descriptors", 1, true);
			Thread.sleep(4000);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Market Descriptors']"))
					.click();
			
			// Search the added Market Descriptor
			Reporter.log("Test Step: Search Added Market Data Market Descriptors", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(marketDescriptorsId);
			
			Reporter.log("Test Step: Click CSV Upload On Market Data Market Descriptors From Context Menu", 1, true);
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
			
			Reporter.log("Test Step: Upload .csv File From Executed Machine", 1, true);
			GeneralUtil.uploadFile(fileUploadPath + "\\cas\\data\\Content\\Data\\MarketDescriptors\\EQ_MarketDescriptor_Default.csv");
			Thread.sleep(1000);
			
			// Validating the Market Descriptor is uploaded or not
			Reporter.log("Test Step: Verify Success Notification", 1, true);
			Common.handleNotifications("Upload market descriptor");
			Thread.sleep(1000);
			
			Reporter.log("Test Step: Search Uploaded Market Data Market Descriptors", 1, true);
			Thread.sleep(1000);
			WebElement SearchSecondElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchSecondElement.clear();
			Thread.sleep(1000);
			SearchSecondElement.sendKeys("EQ_MarketDescriptor_Default");

			Thread.sleep(1000);
			GeneralUtil.captureScreenshot();
			
			Reporter.log("Test Step: Verify Market Data Market Descriptors Cloned Or Not", 1, true);
			String fixingsIdtext = driver
					.findElement(
							By.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"))
					.getText();

			if (fixingsIdtext.equalsIgnoreCase("EQ_MarketDescriptor_Default")) {
				GeneralUtil.logger
						.info("Market Descriptors id EQ_MarketDescriptor_Default is available in the Market Descriptors");
			} else {
				GeneralUtil.logger
						.error("Market Descriptors id EQ_MarketDescriptor_Default is not available in the Market Descriptors");
			}
			Reporter.log("Test Case: Successfully Uploaded Market Data Market Descriptors", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Descriptors Uploaded successfully");
	}

	@Test(dependsOnMethods = { "marketData_cloneMarketDescriptors" })
	public void marketData_downloadMarketDescriptors() throws Exception {
		try {

			GeneralUtil.logger.info("Download a Market Descriptors");
			Reporter.log("Test Case: Download Market Data Market Descriptors", 1, true);
			Thread.sleep(4000);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Market Descriptors']"))
					.click();
			
			// Search the added Market Descriptor and "MarketDescriptor(.*).zip"
			// file download or not
			
			Reporter.log("Test Step: Search Added Market Data Market Descriptors", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(marketDescriptorsId);

			// Download the Market Descriptors and
			Reporter.log("Test Step: Click CSV Download & Download All On Market Data Market Descriptors From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			Common
					.download(
							"CSV Download",
							"Download All",
							"MarketDescriptor(.*).zip",
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							".//*[@id='borderLayout_eRootPanel']/div[4]/div/div/span[2]");
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Case: Successfully Downloaded Market Data Market Descriptors", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Descriptors Download successfully");
	}

	@Test(dependsOnMethods = { "marketData_uploadMarketDescriptors" })
	public void marketData_deleteMarketDescriptors() throws Exception {
		try {

			GeneralUtil.logger.info("Delete a Market Descriptors");
			Reporter.log("Test Case: Delete Market Data Market Descriptors", 1, true);
			Thread.sleep(4000);
			driver.findElement(
					By.xpath("//div[starts-with(@class,'src-routes-Home-components-MainPage-SidebarContent')]/div/div/div[starts-with(@class,'src-components-BetterTreeView-TreeView-TreeView')]//ul/li/span/ul/li[3]/div/div/div[text() ='Market Descriptors']"))
					.click();
			// Search the added Market Descriptor
			Reporter.log("Test Step: Search Added Market Data Market Descriptors", 1, true);
			WebElement SearchElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchElement.clear();
			SearchElement.sendKeys(marketDescriptorsId);
			
			Reporter.log("Test Step: Click Delete On Market Data Market Descriptors From Context Menu", 1, true);
			WebElement contextMenuElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuElement);
			GeneralUtil.captureScreenshot();

			// Delete the added Market Descriptors
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Delete");
			
			Reporter.log("Test Step: Click OK Button For Delete Market Data Market Descriptors", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			// CommonTest.handleNotifications("Delete Market Descriptor");

			Thread.sleep(1000);
			//TT 45574 - Application change in in build 4.6
			/*WebDriverWait NDriver = new WebDriverWait(driver, 300);
			WebElement launchToolTip = NDriver.until(ExpectedConditions
					.visibilityOfElementLocated(By
							.xpath("//i[@class='fa fa-bell-o fa-fw']")));
			WebElement refreshScreenElement = driver.findElement(By
					.xpath("//i[@class='fa fa-bell-o fa-fw']"));
			refreshScreenElement.click();
			Thread.sleep(1000);*/

			// Search the cloned Market Descriptor
			Reporter.log("Test Step: Search Cloned Market Data Market Descriptors", 1, true);
			WebElement SearchSecondElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
			SearchSecondElement.clear();
			SearchSecondElement.sendKeys(cloneMarketDescriptorsId);
			
			Reporter.log("Test Step: Click Delete On Market Data Market Descriptors From Context Menu", 1, true);
			WebElement contextMenuSecondElement = driver
					.findElement(By
							.xpath(".//*[@ref='center']/div/div[4]/div[3]/div/div[1]/div[1]/div[1]"));
			GeneralUtil.contextMenu(contextMenuSecondElement);
			GeneralUtil.captureScreenshot();

			// Delete the cloned Market Descriptors
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Delete");
			
			Reporter.log("Test Step: Click OK Button For Delete Market Data Market Descriptors", 1, true);
			driver.findElement(By.xpath("//div[text() = 'OK']")).click();
			// CommonTest.handleNotifications("Delete Market Descriptor");
			GeneralUtil.captureScreenshot();
			Reporter.log("Test Case: Successfully Deleted Market Data Market Descriptors", 1, true);

		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
		GeneralUtil.logger.info("Market Descriptors delete successfully");
	}
	
	@Test(dependsOnMethods = "marketData_deleteMarketDescriptors", alwaysRun=true)
	public void marketData_exportMarketDescriptors() throws Exception {
		try{
		GeneralUtil.logger = Logger
				.getLogger("Export MarketDescriptors");
		Reporter.log("Test Case: Export MarketDescriptors", 1, true);
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
						".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
						"Clear All Filters");
		Thread.sleep(1000);
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuelement = driver
				.findElement(By
						.xpath(" //*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuelement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select CSV Export From Export From Context Menu", 1, true);
		Common.download("Export", "CSV Export", "export(.*).csv", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("MarketDescriptors CSV Exported successfully");
		
		Thread.sleep(1000);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Right Click On The Element", 1, true);
		WebElement contextMenuExcelElement = driver
				.findElement(By
						.xpath(" //*[@ref='center']/div/div[4]/div[3]/div/div[1]/div/div[2]/div/div/div"));
		GeneralUtil.contextMenu(contextMenuExcelElement);
		GeneralUtil.captureScreenshot();
		
		Reporter.log("Test Step: Select Excel Export From Export From Context Menu", 1, true);
		Common.download("Export", "Excel Export", "export(.*).xls", strmenu,
				strmenu);
		GeneralUtil.logger
				.info("MarketDescriptors Excel Exported successfully");
		
		Reporter.log("Test Case: Successfully Exported MarketDescriptors", 1, true);
		} catch (Exception e) {
			GeneralUtil.captureScreenshot();
			e.printStackTrace();
			GeneralUtil.logger.error(e);
			Reporter.log(e.toString(), 1, true);
			throw new Exception(e);
		}
	}
	
	public void addMarketDescriptorContextMenu(String ColumnTitle)
			throws Exception {
		try {
			WebElement contextMenuRightElement = driver
					.findElement(By
							.xpath(".//*[@id='root']/div/div/div/div/div[2]/div[3]/div/div[6]/div[1]/div/div[2]/div//*[@ref='center']/div/div[4]/div[3]/div"));
			GeneralUtil.contextMenu(contextMenuRightElement);
			GeneralUtil.captureScreenshot();
			GeneralUtil
					.contextMenuItem(
							".//*[@id='borderLayout_eRootPanel']/div[3]/div/div/span[2]",
							"Insert Column");
			driver.findElement(
					By.xpath("//input[@placeholder = 'Insert Column']"))
					.sendKeys(ColumnTitle);

			driver.findElement(
					By.xpath("//div[3]/div/button/div/div[text() = 'Save']"))
					.click();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			GeneralUtil.logger.error("Element is not displayed");
		}
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
	
	public String addDaysToTodayDate(int days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		

		String formatted = format1.format(cal.getTime());
		return formatted;
		
	}
}
