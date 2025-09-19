package pages.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class ContactSalesForcePage_Public extends BasePage {
	
	
	public ContactSalesForcePage_Public(WebDriver driver) {
		super(driver);		
		} 
	
	
	public By pageHeader = By.xpath("//h1[text()='Contact ASTM']");
	public By fieldNames = By.cssSelector(".category-view label");
	public By requiredFieldNames = By.xpath("//*[@class='category-view']//*[contains(@data-validate,'required:')]/../label");
	public By firstNameTextbox = By.id("first_name");
	public By lastNameTextbox = By.id("last_name");
	public By companyTextbox = By.id("company");
	public By phoneTextbox = By.id("phone");
	public By emailTextbox = By.id("email");
	public By countryDropdown = By.id("country_code");
	public By cityTextbox = By.id("city");
	public By stateDropdown = By.id("state_code");
	public By zipTextbox = By.id("zip");
	public By descriptionTextbox = By.id("description");
	public By productTypeDropdown = By.xpath("//*[text()='Product Type']/../../select");//TODO: Change, when id is available
	public By productTypeDropdownOptions = By.xpath("//*[text()='Product Type']/../..//option[not(@disabled)]");//TODO: Change, when id is available
	
	public By industrySectorDropdown = By.id("industry");
	public By industrySectorDropdownOptions = By.cssSelector("#industry option:enabled");
	public By submitButton = By.xpath("//*[text()='Submit Message']");
	
	public By errorMessage = By.cssSelector("div[class='mage-error']");
	
	
	public WebElement getPageHeaderElement() { return
			  getElement(pageHeader); }
	
	public List<WebElement> getRequiredFieldNamesElements() { return
			  getElements(requiredFieldNames); }
	public List<WebElement> getProductTypeDropdownOptionsElements() { return
			  getElements(productTypeDropdownOptions); }
	public List<WebElement> getIndustrySectorDropdownOptionsElements() { return
			  getElements(industrySectorDropdownOptions); }
	public List<WebElement> getErrorMessageElements() { return
			  getElements(errorMessage); }
	public List<WebElement> getFieldNamesElements() { return
			  getElements(fieldNames); }
	
	/**
	 * Get 'Contact Sales' page url.
	 * 
	 * @return
	 */
	@Step("Get 'Contact Sales' page url.")
	public String getContactSalesPageUrl() 
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.urlContains("/salesforce"));
			
			return driver.getCurrentUrl();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	/**
	 * Get page header
	 * 
	 * @return
	 */
	public String getPageHeader() {
		try {
			return getElement(pageHeader).getText();
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}	
	}
	
	
}
