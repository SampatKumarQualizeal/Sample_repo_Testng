package pages.ui;

import java.time.Duration;
import java.util.List;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicCommon;
import com.astm.commonFunctions.SpecBuilderCommon;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.utils.WaitStatementUtils;
import org.testng.Assert;
import tests.ui.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class BasePage extends Page {
	public Logger log = Logger.getLogger(BaseTest.class);

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}
	
	
	@Override
	public WebElement getElement(By locator) {
		WebElement element=null;
		try
		{
			waitForElementPresent(locator);
			element=driver.findElement(locator);
		}
		catch(Exception e)
		{
			System.out.println("Some error occured while creating element"+locator.toString());
			e.getStackTrace();
		}
		return element;
	}

	public boolean clickonWebElement(By locator, String assertionMessage) {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(locator));
			WebElement elm = getElement(locator);
			if(elm.isDisplayed()==true)
				elm.click();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert(assertionMessage, e);
		}
		return false;


	}

	@Override
	public void waitForElementPresent(By locator) {
		
		try
		{
			WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(locator), 20);

		}
		catch(Exception e)
		{
			System.out.println("Some exception occured while waiting for the element"+ locator.toString());
			System.out.println(e.getStackTrace());
		}

	}
	public boolean checkElementPresent(By locator) {
		boolean elementPresent= false;
		try {
			//elementPresent = driver.findElement(locator).isDisplayed();
			elementPresent = driver.findElements(locator).size() > 0;
		} catch (Exception e) {
			System.out.println("Some exception occured while waiting for the element" + locator.toString());
			System.out.println(e.getStackTrace());
		}
		return elementPresent;
	}

	@Override
	public void waitForPageTitle(String title) {
		try
		{
		wait.until(ExpectedConditions.titleContains(title));
		}
		catch(Exception e)
		{
			System.out.println("Some exception occured while waiting for the title"+ title);
			System.out.println(e.getStackTrace());
		}
		
	}

	public List<WebElement> getElements(By locator) {
		try
		{
			waitForElementPresent(locator);
			return driver.findElements(locator);
		}
		catch(Exception e)
		{
			System.out.println("Some error occured while getting list of elements"+locator.toString());
			e.getStackTrace();
			return null;
		}
	}
	public WebElement getElementNew(By locater) {
		new WebDriverWait(driver, 30).pollingEvery(Duration.ofMillis(500))
				.until(ExpectedConditions.visibilityOfElementLocated(locater));
		return driver.findElement(locater);
	}

	public List<WebElement> getElementsNew(By locater) {
		WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(locater), 30);
		return driver.findElements(locater);
	}

	public WebElement getElementWithoutWait(By locater) {
		return driver.findElement(locater);
	}

	public void clickOnMethod(String message, WebElement element) {
		try {
			ReusableMethods.scrollIntoView(element, driver);
			PublicCommon.clickonWebElement(driver, element);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
		}
	}

	@Step("Click on {elementName}")
	public void clickonmethod(String elementName, By locator, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.clickonWebElement(driver, locator), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on " + elementName, e);
		}
	}

	@Step("Verify Visibility of Element '{elementName}'")
	public void verifyVisibility(String elementName, By locator, String assertionMessage) {
		try {
			Assert.assertTrue(IntegrationCommon.isWebElementDisplayed(driver, locator), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to verify visibility of element", e);
		}
	}

	@Override
	public void enterCreditCardDetailsAndSubmit() {
		// TODO Auto-generated method stub
		
	}
	}
