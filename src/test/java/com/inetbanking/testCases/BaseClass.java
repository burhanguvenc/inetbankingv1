package com.inetbanking.testCases;

import java.io.File;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static ChromeOptions chromeopt;
	public static FirefoxOptions firefoxopt;
	public static EdgeOptions edgeopt;
	public static JavascriptExecutor js;

	/*
	 * @BeforeTest public static ExtentReports getReportObject() { String path =
	 * System.getProperty("user.dir")+"\\reports\\index.html"; ExtentSparkReporter
	 * reporter = new ExtentSparkReporter(path);
	 * reporter.config().setReportName("Web Automation Results");
	 * reporter.config().setDocumentTitle("Test Results");
	 *
	 * ExtentReports extent = new ExtentReports(); extent.attachReporter(reporter);
	 * extent.setSystemInfo("Tester", "Burhan Guvenc"); extent.createTest(path);
	 * return extent; }
	 * js = (JavascriptExecutor) driver;
		js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
	 */

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		if(br.equals("chrome")) {
			chromeopt = new ChromeOptions();
			chromeopt.addArguments("--disable-popup-blocking");
			chromeopt.addExtensions(new File("./Drivers/Adblock.crx"));
			driver = new ChromeDriver(chromeopt);
		}
		else if(br.equals("firefox")) {
			firefoxopt = new FirefoxOptions();
			firefoxopt.addArguments("--disable-popup-blocking");
			driver= new FirefoxDriver(firefoxopt);
		}
		else if(br.equals("edge")) {
			edgeopt = new EdgeOptions();
			edgeopt.addArguments("--disable-popup-blocking");
			driver= new EdgeDriver(edgeopt);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(baseURL);


	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	/*
	 * public String getScreenshot(String testCaseName, WebDriver driver) throws
	 * IOException { TakesScreenshot ts = (TakesScreenshot) driver; File source =
	 * ts.getScreenshotAs(OutputType.FILE); File file = new
	 * File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");
	 * FileUtils.copyFile(source, file); return System.getProperty("user.dir") +
	 * "\\reports\\" + testCaseName + ".png"; }
	 */

	public void explicitWaitAlerts() {
		try{
		    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		    wait.until(ExpectedConditions.alertIsPresent()).dismiss();
		}
		catch (Exception e){
		}
	}

	public String randomString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(7);
		return generatedstring;
	}

	public String randomNum() {
		String generatednumber = RandomStringUtils.randomNumeric(6);
		return generatednumber;
	}

}
