package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.utils.WaitStatementUtils;

public class MemberStudentPage_Public extends BasePage {

	public MemberStudentPage_Public(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public By pageHeader = By.xpath("//h1[text()='Become a Student Member']");

	public By breadcrumb = By.className("breadcrumb astm-breadcrumb");
	public By activeChildLeftNavigation = By.className("nav-link child active ");
	public By forLibrariansLink = By.xpath("//*[contains(@class,'astm-nav-tabs')]//*[text()='For Students']");
	public By activeForLibrariansLink = By
			.xpath("//*[text()='For Librarians']//parent::a[@class='nav-link child active ']");
	public By activeForStudentsLink = By
			.xpath("//*[text()='For Students']//parent::a[@class='nav-link child active ']");
	public By onlineApplicationLink = By.xpath("//a[contains(text(),'online')]");//linkText("online application");
	public By studentMembershipBrochureLink = By.linkText("Student Membership Brochure");

	// Step1 About yourself
	public By firstName = By.xpath("//input[@name='firstName']");
	public By middleName = By.xpath("//input[@name='middleInitial']");
	public By lastName = By.xpath("//input[@name='lastName']");
	public By address = By.xpath("//input[@name='address.addressLine1']");
	public By city = By.xpath("//input[@name='address.city']");
	public By zipcode = By.xpath("//input[@name='address.zipCode']");
	public By phoneNumber = By.xpath("//input[@name='phone']");
	public By email = By.xpath("//input[@name='email']");
	public By country = By.xpath("//select[@data-testid='select_countryCode']");
	public By nextBtn = By.xpath("//button[text()='Next']");
	public By previousBtn = By.xpath("//button[text()='Previous']");

	// Step2 College information
	public By universityName = By.xpath("//*[text()='Name of your College/University']/../div//input[@placeholder]");
	public By universityAddress = By.xpath("//*[text()='College/University Address Line 1']/../div//input[@placeholder]");
	public By universityCity = By.xpath("//input[@name='address.city']");
	public By universityZipCode = By.xpath("//input[@name='address.zipCode']");
	public By universityCountry = By.xpath("//option[text()='Please Select Country']/..");

	// Step3 About educational degree
	public By graduationYear = By.xpath("//option[text()='Year']/..");
	public By graduationMonth = By.xpath("//option[text()='Month']/..");
	public By degreeSought = By.xpath("//label[text()='Degree Sought']/../select");
	public By majorStudy = By.xpath("//input[@name='majorStudy']");
	public By MajorStudy = By.xpath("//input[@name='majorStudy']");
	public By submitApplication = By.xpath("//button[text()='Submit']");
	//public By createAccountHeader = By.xpath("//h1[contains(@class,'page-title ')]");
	public By createAccountHeader=By.xpath("//*[text()='Create an Account' and @class='base']");
	public By footerLink = By.xpath("//*[@class='footer-content bg-primary']");
	public By goBackBtn = By.xpath("//a[text()='Go Back']");
    public By moreLink=By.xpath("//h4[text()='Student Members']/..//a[text()='More']");
	
	public void clickOnBackBtn() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(goBackBtn));
			getElement(goBackBtn).click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public String getStudentMembershipBrochureLink() {
		return getElement(studentMembershipBrochureLink).getAttribute("href");
	}

	public String getBrochureInSpanishLink() {
		return getElement(brochureInSpanishLink).getAttribute("href");
	}
	
	public WebElement getPageHeader() {
		return getElement(pageHeader);
	}

	public By brochureInSpanishLink = By.linkText("Brochure in Spanish");
	public By contactTravisMurdockLink = By.linkText("contact Travis Murdock");

	public boolean pageHeaderIsVisible() {
		try {
			return getElement(pageHeader).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getActiveLink() {
		try {
			return getElement(activeChildLeftNavigation).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getPageUrl(String url) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.urlContains(url));

			return driver.getCurrentUrl();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}

	public boolean getInfoAboutYourself() {
		try {
			return true;
		}

		catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}
}
