package tests.ui.base;

import appium.util.DriverFactory;
import base.utils.*;
import com.astm.commonFunctions.PublicAdminLogin;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import pages.ui.AdminAreaPage;
import pages.ui.BasePage;
import pages.ui.Page;

import java.io.IOException;


public class BaseTest {

	public WebDriver driver;
	public Page page;
	public BasePage basePage;

	public  static  String Env;
	public  static  String browserName;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public Logger log = Logger.getLogger(BaseTest.class);
	public PublicAdminLogin publicAdminLoginDetails;
	DriverFactory df;
	public String environment;
	
	@BeforeClass(alwaysRun=true)
	@Parameters({"browser", "platform","env","updateJira","testExecutionId","cookie","sprintID"})
	public void setUpTest(@Optional("chrome") String browser,  @Optional("local") String platform, @Optional("QA") String env,@Optional("false") boolean updateJira,@Optional("0000") String testExecutionId,  @Optional("Reject") String cookie,@Optional("sprintID") String sprintID)
	{

		//Fetching Class name for Passing it to BrowserStack Execution.
		String className = this.getClass().getName();
		Env=env;
		browserName=browser;
		df = new DriverFactory();
		try {

			if(platform.equalsIgnoreCase("browserStack") || platform.equalsIgnoreCase("browserStackid"))
			{
				driver = df.generateDriverStack(platform, className, sprintID).initDriver(browser);
			}
			else
			{
				driver = df.generateDriver(platform).initDriver(browser);
			}
//		driver = df.generateDriver(platform).initDriver(browser);

			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener(log);
			e_driver.register(eventListener);
			driver = e_driver;
			page=new BasePage(driver);
			basePage=new BasePage(driver);
			//TestListener.setListenerDriver(driver); //Not used anywhere
			//Updating Xray flag for Jira update
			if(updateJira==true) {
				ConfigReader.setValue("updateTestStatus", "true");
				ConfigReader.setValue("TestExecutionID", testExecutionId);
			}
			//Setting Base URL based on Environments
			ConfigReader.setValue("BASE_URL_MAE", ConfigReader.getValue(env+"MAE"));
			
			String value=ConfigReader.getValue(env);
			if(env.equals("STG"))
				ConfigReader.setValue("BASE_URL_PUB_ASTM",value);
			else if(env.equals("DEV"))
				ConfigReader.setValue("BASE_URL_PUB_ASTM",value);
			else if(env.equals("QA"))
				ConfigReader.setValue("BASE_URL_PUB_ASTM",value);
			else if(env.equals("PROD"))
				ConfigReader.setValue("BASE_URL_PUB_ASTM",value);
			EnvironmentFileUtil.setUp(browser, platform,env);
			ConfigReader.setValue("BASE_URL_MAE", ConfigReader.getValue(env+"MAE"));
			// This class loads the admin credentials into POJO.
			publicAdminLoginDetails = new PublicAdminLogin(env);
			environment = env;
			ScreenRecorderUtil.startRecord(className);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun=true)
	public void Screenshot()
	{
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ScreenRecorderUtil.stopRecord();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterClass(alwaysRun=true)
	public void TearDown()
	{
		driver.quit();
	}

}
