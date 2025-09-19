package pages.ui;

import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.utils.ReusableMethods;

public class PTPTermsPage_Public extends BasePage{

	
	public PTPTermsPage_Public(WebDriver driver) {
	super(driver);
}
	public By acceptTermsButton = By.linkText("Accept Terms");
	private By goBackButton = By.linkText("Go Back");
	
	
	public String getTermsPageUrl() 
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.urlContains("/ptp-terms"));

			return driver.getCurrentUrl();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	/**
	 * This method is used to click on Accept Terms
	 * @return True/False
	 */
	public boolean clickAcceptTermsButton() 
	{
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(acceptTermsButton),10);
			ReusableMethods.scrollIntoView(getElement(acceptTermsButton), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(acceptTermsButton).click();
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}	
	}
	
	public boolean clickGoBackButton() 
	{
		try {
			getElement(goBackButton).click();
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}	
	}
	
}
