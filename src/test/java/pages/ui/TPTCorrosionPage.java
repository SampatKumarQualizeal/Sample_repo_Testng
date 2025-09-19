package pages.ui;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.astm.commonFunctions.PublicCommon;

import base.utils.ReusableMethods;
import base.utils.WaitStatementUtils;

public class TPTCorrosionPage extends BasePage {

	/**
	 * Parameterized constructor
	 * 
	 * @param driver
	 */
	public TPTCorrosionPage(WebDriver driver) {
		super(driver);
	}

	private By TPTProductHeader = By.className("page-title");
	public By addToCartButton = By.xpath("//button[@type='submit' and text()='Add to Cart']");
	private By registerOnline = By.xpath("//div[@class='register-online mb-3']//p");
	private By webinarDate = By.xpath("//div[@class='tpt-products']//p");
	private By productLogo = By.cssSelector("img[src*='Alpine_TptProduct/images/iacet.png']");
	private By productPriceLabel = By.cssSelector("span[id*='product-price']");
	private By contentsHeading = By.cssSelector(".astm-type-heading--h5-bold");
	private By stockNumber = By.xpath("//div[@class='mb-4'][9]/div");
	private By shoppingCartLink = By.xpath("//a[text()='shopping cart']");
	private By accessHyperLink = By.xpath("//div[@class='mb-4'][7]//a");
	private By technologyRequirementsHyperLink = By.xpath("//div[@class='mb-4'][8]//a");
	private By faqButton = By.xpath("//div[@class='actions pt-4']//a[contains(text(),'FAQ')]");
	private By errorMessage = By.cssSelector("h1.page-title .base");
	public By firstName = By.name("attendees[0][first-name]");
	public By intial = By.name("attendees[0][initial]");
	public By lastName = By.name("attendees[0][last-name]");
	public By phoneNumber = By.name("attendees[0][phone]");
	public By email = By.name("attendees[0][email]");
	public By firstNameErrorMsg = By.id("attendees[0][first-name]-error");
	public By lastNameErrorMsg = By.id("attendees[0][last-name]-error");
	public By phoneFieldErrorMsg = By.id("attendees[0][phone]-error");
	public By emailErrorMsg = By.id("attendees[0][email]-error");
	public By webinarCount = By.xpath("//p//strong[text()='Webinar:']");
	public By addAttendeesBtnCount = By.xpath("//span[text()='Add Attendees']");
	private By returnToCourseListing = By.xpath("//a[contains(text(),'Return to Course Listing')]");
	private By inputNumberOfAttendees = By.xpath("//div[@class='tpt-products']//div[1]//form[1]//div[1]//input");
	public By addAttendeesBtn = By
			.xpath("//div[@class='tpt-products']//div[1]//form[1]//div[2]//button[@type='submit']");
	private By addAttendeesModelLabel = By.id("AddAttendeesLabel");
	private By attendeesRows = By.xpath("//form[@id='add-attendees']//table//tbody//tr");
	public By closeBtn = By.xpath("//button[text()='Close']");
	public By attendee_addToCartButton = By.xpath("//div[@class='modal-footer']/button[text()='Add to Cart']");
	public By chooseAccountPopup = By.xpath("//div[@id='choose-account-popup']//div[@class='modal-content']");
	public By choosePersonalBtn = By.xpath("//label[@class='custom-control-label'][contains(text(),'Personal')]");
	public By chooseAccountSubmitBtn = By.xpath("//div[@id='choose-account-popup']//div//button[@type='submit']");
	public  By firstname=By.xpath("//input[@placeholder='First name']");
	public  By middleName=By.xpath("//input[@placeholder='Middle name']");
	public  By lastname=By.xpath("//input[@placeholder='Last name']");
	public By phone_number=By.xpath("//input[@placeholder='Phone number']");
	public By cartButton=By.xpath("//span[text()='Cart']");
	public By addToCart=By.xpath("//button[text()='Add to Cart']");
	public By addToCart1=By.xpath("//*[@title='Add to Cart']");
	public By shoppingCartlink = By.linkText("shopping cart");
	public By labelPersonal=By.xpath("//label[contains(text(),'Personal')]");
	public By submitButton=By.xpath("//button[contains(text(),'Submit')]");




	/**
	 * Visibility of FAQ
	 * 
	 * @return
	 */
	public boolean clickFAQ() {
		try {
			getElement(faqButton).isDisplayed();
			getElement(faqButton).click();

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * Visibility of Return to Course Listing
	 * 
	 * @return
	 */
	public boolean clickReturnToCourseListing() {
		try {
			getElement(returnToCourseListing).isDisplayed();
			getElement(returnToCourseListing).click();

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * Enter The value of Attendees
	 * 
	 * @return
	 */
	public boolean enterAttendees(String value) {
		try {
			getElement(inputNumberOfAttendees).isDisplayed();
			getElement(inputNumberOfAttendees).sendKeys(value);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * get values of add attendees field error messages
	 * 
	 * @return
	 */
	public String getErrorMsg(By locator) {
		try {
			String value = getElement(locator).getText();
			return value;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Enter The value of add attendees
	 * 
	 * @return
	 */
	public boolean getAttendeesRowCount(String value) {
		try {
			getElement(addAttendeesBtn).click();
			int size = getElements(attendeesRows).size();
			System.out.println("size of rows" + size);
			int count = Integer.parseInt(value);
			if (count == size)
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * Enter The value of add attendees
	 * 
	 * @return
	 */
	public boolean addAttendee(String value) {
		try {
			getElement(inputNumberOfAttendees).clear();
			getElement(inputNumberOfAttendees).sendKeys(value);
			getElement(addAttendeesBtn).click();
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * Enter The value of add attendees
	 * 
	 * @return
	 */
	public boolean addAttendeeDetails(String fName, String intialValue, String LName, String Phone, String Email,
			String value) {
		try {
			getElement(inputNumberOfAttendees).clear();
			getElement(inputNumberOfAttendees).sendKeys(value);
			// waitForElementPresent(addAttendeesBtn);
			// WaitStatementUtils.waitForElementToBeClickable(driver,
			// getElement(addAttendeesBtn),10);
			wait.until(ExpectedConditions.elementToBeClickable(addAttendeesBtn));
			getElement(addAttendeesBtn).click();
			WebElement fname = getElement(firstName);
			WebElement lname = getElement(lastName);
			WebElement intialElement = getElement(intial);
			WebElement phn = getElement(phoneNumber);
			WebElement emailElement = getElement(email);
			WaitStatementUtils.waitForElementToBeClickable(driver, fname);
			fname.sendKeys(fName);
			WaitStatementUtils.waitForElementToBeClickable(driver, intialElement);
			intialElement.sendKeys(intialValue);
			WaitStatementUtils.waitForElementToBeClickable(driver, lname);
			lname.sendKeys(LName);
			WaitStatementUtils.waitForElementToBeClickable(driver, phn);
			phn.sendKeys(Phone);
			WaitStatementUtils.waitForElementToBeClickable(driver, emailElement);
			emailElement.sendKeys(Email);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * check no of add attendees buttons and webinars count
	 * 
	 * @return
	 */
	public boolean checkAddAttendeesBtnForDiffWebinar() {
		try {
			if (getElements(webinarCount).size() == getElements(addAttendeesBtnCount).size())
				return true;
			else
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * Get Page header
	 * 
	 * @return
	 */
	public String getTPTProductHeader() {
		try {
			return getElement(TPTProductHeader).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	/**
	 * Get Register Online Veribage
	 * 
	 * @return S
	 */
	public String getRegisterOnlineVeribage() {
		try {
			return getElement(registerOnline).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	/**
	 * Get Webinar Date
	 * 
	 * @return S
	 */
	public String getWebinarDate() {
		try {
			return getElement(webinarDate).getText().substring(9);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	/**
	 * Get product price from page
	 * 
	 * @return
	 */
	public String getProductPrice() {
		try {
			return getElement(productPriceLabel).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Clicks on Add Cart Button
	 * 
	 * @return
	 */
	public boolean clickAddToCartutton() {
		try {
			getElement(addToCartButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;

		}
	}

	/**
	 * Clicks FAQ Button
	 * 
	 * @return
	 */
	public boolean clickFaqButton() {
		try {
			getElement(faqButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;

		}
	}

	/**
	 * Gets the error message on page
	 * 
	 * @return
	 */
	public String getErrorMessage() {
		try {
			return getElement(errorMessage).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This method is used to click on ShoppingCart Link.
	 * 
	 * @return True/False
	 */
	public boolean clickShoppingCartLink() {
		try {
			getElement(shoppingCartLink).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

}
