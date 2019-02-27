package util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.validator.routines.UrlValidator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import test.ExecuteTests;

public class Browser {

	public static WebDriver driver;
	public static String strBrowserType;
	public static ThreadLocal<WebDriver> ThreadDriver = null;
	public static String baseUrl;
	public static String intMinWait;
	public static String intMidWait;
	public static long intMaxWait;
	public static long strPollingEvery;
	public static String browserHandle;
	public static String browserDownloadsPath;

	static{
		GeneralUtil.configureLog4j("Browser");
		GeneralUtil.logger("Browser");
	}	
	
	public static WebDriver IntilizeBrowser() throws Exception {
	
		DesiredCapabilities capabilities = null;
		try {
			// Thread local is the class which creates separate instance of
			// webdriver for every thread.
			ThreadDriver = new ThreadLocal<>();
			driver = ThreadDriver.get();
			browserDownloadsPath = GeneralUtil.downloadsDirectory;
			if (strBrowserType.equalsIgnoreCase("firefox")) {
				File file = new File(System.getProperty("user.dir") + "/Resources/geckodriver.exe");
				System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());

				DesiredCapabilities dc = DesiredCapabilities.firefox();
				// dc.merge(capabillities);
				FirefoxProfile profile = new FirefoxProfile();
				profile.setAcceptUntrustedCertificates(true);
				profile.setPreference("browser.download.folderList", 4);
				profile.setPreference("browser.download.dir", GeneralUtil.strDownload_Path);
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
						"application/msword, application/csv, application/ris, text/csv, data:image/png, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
				profile.setPreference("browser.download.manager.showWhenStarting", false);
				profile.setPreference("browser.helperApps.alwaysAsk.force", false);
				dc.setCapability(FirefoxDriver.PROFILE, profile);
				driver = new FirefoxDriver(dc);
				GeneralUtil.logger.info("Initiated " + strBrowserType + " browser instance");
				System.out.println("Initiated Firefox browser instance");

			} else if (strBrowserType.equalsIgnoreCase("IE") || strBrowserType.equalsIgnoreCase("internet explorer")) {
				File file = new File(System.getProperty("user.dir") + "/Resources/IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				driver = new InternetExplorerDriver();
				ThreadDriver.set(driver);
				capabilities = DesiredCapabilities.internetExplorer();
				// System.out.println("Initiated IE browser instance");
				GeneralUtil.logger.info("Initiated " + strBrowserType + " browser instance");
			} else if (strBrowserType.equalsIgnoreCase("Chrome")) {
				File file = new File(System.getProperty("user.dir") + "/Resources/chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_settings.popups", 0);
  	            prefs.put("download.default_directory",  browserDownloadsPath);
  	            prefs.put("profile.default_content_setting_values.notifications", 2);
  	            prefs.put("safebrowsing.enabled", "true");
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("chrome.switches");
				options.addArguments("--disable-extensions");
				//options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);
				ThreadDriver.set(driver);
				//capabilities = DesiredCapabilities.chrome();
				GeneralUtil.logger.info("Initiated " + strBrowserType + " browser instance");
				System.out.println("Initiated Chrome browser instance");
			}

			// Printing capabilities
			//if (capabilities != null) {
				// System.out.println(capabilities);
				// logger.info(capabilities);
			//}

			/*
			 * EventFiringWebDriver efw = new EventFiringWebDriver(driver);
			 * ScreenShotListener screenShotListener = new ScreenShotListener();
			 * efw.register(screenShotListener);
			 */
			driver.manage().window().maximize();
			driver.manage().timeouts().setScriptTimeout(Long.valueOf(GeneralUtil.scriptTimeOut), TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Long.valueOf(GeneralUtil.pageLoadTimeOut), TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Long.valueOf(GeneralUtil.implicitTimeOut), TimeUnit.SECONDS);

		} catch (Exception e) {
			GeneralUtil.logger.error(strBrowserType + " browser instance initiation is failed.");
			throw new Exception(e.getMessage());
		}
		return driver;
	}

	public static void setBrowserType(String browserType) {
		strBrowserType = browserType;
	}

	public static WebDriver getDriver() throws Exception {
		if (driver != null) {
			try {
				if (driver.getWindowHandles() != null || driver.getWindowHandles().isEmpty()) {
					return driver;
				}
			} catch (Exception e) {
				return IntilizeBrowser();
			}
			return driver;
		} else
			return IntilizeBrowser();
	}

	public static void NavigateToURL() {
		if (ExecuteTests.targetServerURL != null) {
			UrlValidator urlValidator = new UrlValidator();
			if (urlValidator.isValid(ExecuteTests.targetServerURL)) {
				GeneralUtil.logger.info(ExecuteTests.targetServerURL);
				driver.navigate().to(ExecuteTests.targetServerURL);
			}else
				GeneralUtil.logger.info("Server URL is not Valid");
		} else {
			String url = PropertyUtils.getConfigMessage("URL");
			GeneralUtil.logger.info(url);
			driver.navigate().to(url);
		}
		
/*		if (ExecuteTests.targetServerURL != null) 
		{
			UrlValidator urlValidator = new UrlValidator();
			if (ExecuteTests.targetServerURL.equalsIgnoreCase("Windows")) {
				GeneralUtil.logger.info("Windows Url");
				driver.navigate().to(PropertyUtils.getConfigMessage("WINDOWS_URL"));
				GeneralUtil.fileUploadPath = PropertyUtils.getConfigMessage("Windows_Upload_Path");
			} else if (ExecuteTests.targetServerURL.equalsIgnoreCase("Linux")) {
				GeneralUtil.logger.info("Linux Url");
				driver.navigate().to(PropertyUtils.getConfigMessage("LINUX_URL"));
				GeneralUtil.fileUploadPath = PropertyUtils.getConfigMessage("Linux_Upload_Path");
			} else if (urlValidator.isValid(ExecuteTests.targetServerURL)) {
				GeneralUtil.logger.info(ExecuteTests.targetServerURL);
				driver.navigate().to(ExecuteTests.targetServerURL);
			}
		} else {
			GeneralUtil.logger.info("Url");
			driver.navigate().to(PropertyUtils.getConfigMessage("URL"));
		}*/
		// driver.manage().window().maximize();
	}

	public static void quitBrowser()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
	
	public static String strGetWindowTitle() {
		return driver.getTitle();
	}

}
