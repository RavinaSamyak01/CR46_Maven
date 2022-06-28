package CR46;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CR46 {
	static WebDriver driver;
	static StringBuilder msg = new StringBuilder();
	public static String A1, A2, A3, A4, A5, A6, A7, A8, A9;
	public static Properties storage = new Properties();

	@BeforeSuite
	public void startUp() throws IOException, InterruptedException {

		storage = new Properties();
		FileInputStream fi = new FileInputStream(".\\src\\main\\resources\\config.properties");
		storage.load(fi);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		options.addArguments("--incognito");
		options.addArguments("--test-type");
		options.addArguments("--no-proxy-server");
		options.addArguments("--proxy-bypass-list=*");
		options.addArguments("--disable-extensions");
		options.addArguments("--no-sandbox");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-site-isolation-trials");

		// options.addArguments("window-size=800x600");
		// options.addArguments("window-size=1366x788");
		capabilities.setPlatform(Platform.ANY);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
		// Default size
		Dimension currentDimension = driver.manage().window().getSize();
		int height = currentDimension.getHeight();
		int width = currentDimension.getWidth();
		System.out.println("Current height: " + height);
		System.out.println("Current width: " + width);
		System.out.println("window size==" + driver.manage().window().getSize());

		Thread.sleep(2000);

		// --Login

	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/Report/NA_Screenshot/" + screenshotName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@Test
	public static void cr46() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		for (int i = 0; i < 4; i++) {
			String Env = storage.getProperty("Env");
			String Password = null;
			String Password3 = null;
			System.out.println("ENV==" + Env);
			if (Env.equalsIgnoreCase("Pre-Prod")) {
				String baseUrl = storage.getProperty("PREPRODURL");
				driver.get(baseUrl);
				try {
					Password = storage.getProperty("PREPRODPassword");
					Password3 = Password;
				} catch (Exception e) {
					msg.append("URL is not working==FAIL");
					getScreenshot(driver, "LoginIssue");
					driver.quit();
					Env = storage.getProperty("Env");
					String File = ".//Screenshots//LoginIssue.png";
					String subject = "Selenium Automation Script: " + Env + " : CR46 Smoke Testing";
					try {
						// Email.sendMail("parth.doshi@samyak.com", subject, msg.toString(), "");

						Email.sendMail(
								"parth.doshi@samyak.com,asharma@samyak.com,ravina.prajapati@samyak.com,pgandhi@samyak.com,manthan.doshi@samyak.com,urvashi.Patel@samyak.com",
								subject, msg.toString(), File);

					} catch (Exception ex) {
						Logger.getLogger(CR46.class.getName()).log(Level.SEVERE, null, ex);
					}
				}

			} else if (Env.equalsIgnoreCase("STG")) {
				String baseUrl = storage.getProperty("STGURL");
				driver.get(baseUrl);
				try {
					Password = storage.getProperty("STGPassword");
					Password3 = Password;
				} catch (Exception e) {
					msg.append("URL is not working==FAIL");
					getScreenshot(driver, "LoginIssue");
					driver.quit();
					Env = storage.getProperty("Env");
					String File = ".//Screenshots//LoginIssue.png";
					String subject = "Selenium Automation Script: " + Env + " : CR46 Smoke Testing";
					try {
						// Email.sendMail("parth.doshi@samyak.com", subject, msg.toString(), "");

						Email.sendMail(
								"parth.doshi@samyak.com,asharma@samyak.com,ravina.prajapati@samyak.com,pgandhi@samyak.com,manthan.doshi@samyak.com,urvashi.Patel@samyak.com",
								subject, msg.toString(), File);

					} catch (Exception ex) {
						Logger.getLogger(CR46.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			} else if (Env.equalsIgnoreCase("DEV")) {
				String baseUrl = storage.getProperty("DEVURL");
				driver.get(baseUrl);
				try {
					Password = storage.getProperty("DEVPassword");
					Password3 = Password;
				} catch (Exception e) {
					msg.append("URL is not working==FAIL");
					getScreenshot(driver, "LoginIssue");
					driver.quit();
					Env = storage.getProperty("Env");
					String File = ".//Screenshots//LoginIssue.png";
					String subject = "Selenium Automation Script: " + Env + " : CR46 Smoke Testing";
					try {
						// Email.sendMail("parth.doshi@samyak.com", subject, msg.toString(), "");

						Email.sendMail(
								"parth.doshi@samyak.com,asharma@samyak.com,ravina.prajapati@samyak.com,pgandhi@samyak.com,manthan.doshi@samyak.com,urvashi.Patel@samyak.com",
								subject, msg.toString(), File);

					} catch (Exception ex) {
						Logger.getLogger(CR46.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			} else if (Env.equalsIgnoreCase("Prod")) {
				String baseUrl = storage.getProperty("PRODURL");
				driver.get(baseUrl);
				try {
					Password = storage.getProperty("ProdSPwd0To2");
					Password3 = storage.getProperty("ProdSPwd3");
				} catch (Exception e) {
					msg.append("URL is not working==FAIL");
					getScreenshot(driver, "LoginIssue");
					driver.quit();
					Env = storage.getProperty("Env");
					String File = ".//Screenshots//LoginIssue.png";
					String subject = "Selenium Automation Script: " + Env + " : CR46 Smoke Testing";
					try {
						// Email.sendMail("parth.doshi@samyak.com", subject, msg.toString(), "");

						Email.sendMail(
								"parth.doshi@samyak.com,asharma@samyak.com,ravina.prajapati@samyak.com,pgandhi@samyak.com,manthan.doshi@samyak.com,urvashi.Patel@samyak.com",
								subject, msg.toString(), File);

					} catch (Exception ex) {
						Logger.getLogger(CR46.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUserId")));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("txtUserId")));
			if (i == 0) {
				driver.findElement(By.id("txtUserId")).clear();
				driver.findElement(By.id("txtUserId")).sendKeys("support0");

				driver.findElement(By.id("txtPassword")).clear();
				driver.findElement(By.id("txtPassword")).sendKeys(Password);

				driver.findElement(By.id("rdbFedExLoginID")).click();

				driver.findElement(By.id("txtFedExLoginID")).clear();
				driver.findElement(By.id("txtFedExLoginID")).sendKeys("testsamyak6");

				driver.findElement(By.id("cmdLogin")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Fedextitle")));
				wait.until(ExpectedConditions.elementToBeClickable(By.className("Fedextitle")));

				Actions builder = new Actions(driver);
				WebElement ele = driver.findElement(By.linkText("Manage"));
				builder.moveToElement(ele).build().perform();
				Thread.sleep(2000);

				boolean manage = driver.getPageSource().contains("Manage My Account");

				if (manage == false) {
					A1 = "Manage My Account is not displayed with Login : support0";
					System.out.println(A1);
				} else {
					A1 = "Manage My Account is displayed with Login : support0";
					System.out.println(A1);
				}
				msg.append(A1 + "\n\n");
				Thread.sleep(2000);

				switchCustomerSession();

				Thread.sleep(3000);

				// driver.findElement(By.id("lnkbtnLogout1")).click();

				// Thread.sleep(2000);

			}

			else if (i == 1) {
				driver.findElement(By.id("txtUserId")).clear();
				driver.findElement(By.id("txtUserId")).sendKeys("support1");

				driver.findElement(By.id("txtPassword")).clear();
				driver.findElement(By.id("txtPassword")).sendKeys(Password);

				driver.findElement(By.id("rdbFedExLoginID")).click();

				driver.findElement(By.id("txtFedExLoginID")).clear();
				driver.findElement(By.id("txtFedExLoginID")).sendKeys("testsamyak6");

				driver.findElement(By.id("cmdLogin")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Fedextitle")));
				wait.until(ExpectedConditions.elementToBeClickable(By.className("Fedextitle")));

				boolean manage = driver.getPageSource().contains("Manage My Account");

				if (manage == true) {
					A2 = "Manage My Account is displayed with Login : support1";
					System.out.println(A2);
				} else {
					A2 = "Manage My Account is not displayed with Login : support1";
					System.out.println(A2);
				}
				Thread.sleep(3000);
				msg.append(A2 + "\n");

				switchCustomerSession();

				Thread.sleep(3000);
				boolean manage1 = driver.getPageSource().contains("Manage My Account");

				if (manage1 == false) {
					A3 = "After Switch to Customer Session Manage My Account is not displayed with Login : support1";
					System.out.println(A3);
				} else {
					A3 = "After Switch to Customer Session Manage My Account is displayed with Login : support1";
					System.out.println(A3);
				}
				Thread.sleep(3000);
				msg.append(A3 + "\n\n");

				// driver.findElement(By.id("lnkbtnLogout1")).click();

				// Thread.sleep(2000);

			}

			else if (i == 2) {
				driver.findElement(By.id("txtUserId")).clear();
				driver.findElement(By.id("txtUserId")).sendKeys("support2");

				driver.findElement(By.id("txtPassword")).clear();
				driver.findElement(By.id("txtPassword")).sendKeys(Password);

				driver.findElement(By.id("rdbFedExLoginID")).click();

				driver.findElement(By.id("txtFedExLoginID")).clear();
				driver.findElement(By.id("txtFedExLoginID")).sendKeys("testsamyak6");

				driver.findElement(By.id("cmdLogin")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Fedextitle")));
				wait.until(ExpectedConditions.elementToBeClickable(By.className("Fedextitle")));
				boolean manage = driver.getPageSource().contains("Manage My Account");

				if (manage == true) {
					A4 = "Manage My Account is displayed with Login : support2";
					System.out.println(A4);
				} else {
					A4 = "Manage My Account is not displayed with Login : support2";
					System.out.println(A4);
				}
				Thread.sleep(3000);
				msg.append(A4 + "\n");
				switchCustomerSession();

				Thread.sleep(3000);
				boolean manage1 = driver.getPageSource().contains("Manage My Account");

				if (manage1 == false) {
					A5 = "After Switch to Customer Session Manage My Account is not displayed with Login : support2";
					System.out.println(A5);
				} else {
					A5 = "After Switch to Customer Session Manage My Account is displayed with Login : support2";
					System.out.println(A5);
				}
				Thread.sleep(3000);
				msg.append(A5 + "\n\n");

				// driver.findElement(By.id("lnkbtnLogout1")).click();

				// Thread.sleep(2000);

			}

			else if (i == 3) {
				driver.findElement(By.id("txtUserId")).clear();
				driver.findElement(By.id("txtUserId")).sendKeys("support3");

				driver.findElement(By.id("txtPassword")).clear();
				driver.findElement(By.id("txtPassword")).sendKeys(Password3);
				// Production
				// driver.findElement(By.id("txtPassword")).sendKeys(PASSWORDS3);

				driver.findElement(By.id("rdbFedExLoginID")).click();

				driver.findElement(By.id("txtFedExLoginID")).clear();
				driver.findElement(By.id("txtFedExLoginID")).sendKeys("testsamyak6");

				driver.findElement(By.id("cmdLogin")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Fedextitle")));
				wait.until(ExpectedConditions.elementToBeClickable(By.className("Fedextitle")));
				boolean manage = driver.getPageSource().contains("Manage My Account");

				if (manage == true) {
					A6 = "Manage My Account is displayed with Login : support3";
					System.out.println(A6);
				} else {
					A6 = "Manage My Account is not displayed with Login : support3";
					System.out.println(A6);
				}
				Thread.sleep(3000);
				msg.append(A6 + "\n");

				switchCustomerSession();
				Thread.sleep(2000);

				boolean manage1 = driver.getPageSource().contains("Manage My Account");

				if (manage1 == false) {
					A7 = "After Switch to Customer Session Manage My Account is not displayed with Login : support3";
					System.out.println(A7);
				} else {
					A7 = "After Switch to Customer Session Manage My Account is displayed with Login : support3";
					System.out.println(A7);
				}
				Thread.sleep(3000);
				msg.append(A7 + "\n");

				Actions builder = new Actions(driver);
				WebElement ele = driver.findElement(By.linkText("Admin"));
				builder.moveToElement(ele).build().perform();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Admin")));
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Admin")));
				ele.click();
				Thread.sleep(5000);
				WebElement ele1 = driver.findElement(By.linkText("FCL Access"));
				builder.moveToElement(ele1).build().perform();

				boolean manage2 = driver.getPageSource().contains("Reset SameDay Password");
				boolean manage3 = driver.getPageSource().contains("Reset Migration Prompt");

				if (manage2 == true && manage3 == true) {
					A8 = "Reset SameDay Password link is displayed for : support3";
					System.out.println(A8);
					A9 = "Reset Migration Prompt link is displayed for : support3";
					System.out.println(A9);
				} else {
					A8 = "Reset SameDay Password link is not displayed for : support3";
					System.out.println(A8);
					A9 = "Reset Migration Prompt link is not displayed for : support3";
					System.out.println(A9);
				}

				msg.append(A8 + "\n");
				msg.append(A9 + "\n");

				// driver.findElement(By.id("lnkbtnLogout1")).click();
				// Thread.sleep(2000);

			}
		}

		// String subject = "DEV Automation : CR_46 Smoke Testing Result";
		// String subject = "Staging Automation : CR_46 Smoke Testing Result";
		// String subject = "Pre-Production Automation : CR_46 Smoke Testing Result";
		String Env = storage.getProperty("Env");
		String subject = "Selenium Automation Script: " + Env + " : CR46 Smoke Testing";
		try {
			// Email.sendMail("parth.doshi@samyak.com", subject, msg.toString(), "");

			Email.sendMail(
					"parth.doshi@samyak.com,asharma@samyak.com,ravina.prajapati@samyak.com,pgandhi@samyak.com,manthan.doshi@samyak.com,urvashi.Patel@samyak.com",
					subject, msg.toString(), "");

		} catch (Exception ex) {
			Logger.getLogger(CR46.class.getName()).log(Level.SEVERE, null, ex);
		}
		driver.quit();
	}

	public static void switchCustomerSession() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		Actions builder = new Actions(driver);
		WebElement ele = driver.findElement(By.linkText("Admin"));
		builder.moveToElement(ele).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Admin")));
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Admin")));
		ele.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("FCL Access")));
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("FCL Access")));
		WebElement ele1 = driver.findElement(By.linkText("FCL Access"));
		builder.moveToElement(ele1).build().perform();
		builder.moveToElement(ele1).build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Switch Customer Session")));
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Switch Customer Session")));

		driver.findElement(By.linkText("Switch Customer Session")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rdbCustomerCode")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("rdbCustomerCode")));

		driver.findElement(By.id("rdbCustomerCode")).click();

		driver.findElement(By.id("txtCustomercode")).sendKeys("777777777");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cmdLogin")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cmdLogin")));
		driver.findElement(By.id("cmdLogin")).click();
		Thread.sleep(3000);
	}

	@AfterSuite
	public void end() {
		driver.quit();
	}

}