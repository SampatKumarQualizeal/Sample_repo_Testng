package pages.ui;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.utils.ReusableMethods;
import io.qameta.allure.Step;

public class DigitalLibraryPage_Public extends BasePage{

	public DigitalLibraryPage_Public(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By digitalLibraryImage = By.xpath("//*[@class='card astm-card landing-header']//img[contains(@src,'compass_lead.png')]");
	private By digitalLibratryHeaderText = By.xpath("//*[@class='card astm-card landing-header']//*[@class='card-title astm-type-heading--h3']");





	public By digitalLibraryButtonsContactSales = By.xpath("//a[@class='btn astm-btn btn-primary mb-2' and contains(text(), 'Contact Sales')]");
	private By digitalLibraryButtonsOverview = By.xpath("//a[@class=\"btn astm-btn btn-light mb-2\" and contains(text(), 'Digital Library Overview')]");
	private By digitalLibraryButtonsUserResources = By.xpath("//a[@class=\"btn astm-btn btn-secondary mb-2\" and contains(text(), 'User Resources')]");

	private By digitalLibratryHeaderTextForCustomize = By.xpath("//h3[text()='Customize and Choose the Content You Need']");
	private By digitalLibratryHeaderTextFollowingContentArea = By.xpath("//*[@class='landing-page']//*[@class='astm-type-heading--h3' and contains(text(), 'Two popular subscription options include:')]");
	private By digitalLibratryContentText1FollowingContentArea = By.xpath("//li[contains(text(),'Institutional Multi-User, Single Campus Subscription')]");
	private By digitalLibratryContentText2FollowingContentArea = By.xpath("//li[contains(text(),'Institutional Multi-User, Multi Campus Subscription')]");
	private By digitalLibraryUpgradeText = By.xpath("//*[@class='astm-type-heading--h4' and contains(text(), 'To Create or Upgrade your ASTM Digital Library subscription')]");

	private By digitalLibraryButtonsContactSalesUpgrade = By.xpath("(//*[@class='button-access-links button-access-links__digital-library']//a//button[contains(text(), 'Contact Sales')])[2]");
	private By contactInfoForUpdrage = By.xpath("//*[@class='button-access-links button-access-links__digital-library']//span");

	private By contentArea = By.xpath("//h3[text()='Customize and Choose the Content You Need']");
	private By contentHeader = By.xpath("//h3[text()='Customize and Choose the Content You Need']//following::h6");
	private By contentDescription = By.xpath("//h3[text()='Customize and Choose the Content You Need']//following::h6//parent::a//child::p");
	
	@Step("Scroll to the Content Area Section of the Digital Library Page")
	public void scrollToContentAreaSectionOnPage() {
		try {
			//ReusableMethods.scrollIntoView(getElement(digitalLibratryHeaderText), driver);
			ReusableMethods.scrollIntoView(getElement(contentArea), driver);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Step("Checking the Image on Digital Library Page.")
	public boolean digitalLibraryImageValidation () {
		try {
			return getElement(digitalLibraryImage).isDisplayed();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Step("Checking the Header text on Digital Library Page.")
	public String digitalLibraryHeaderTextValidation () {
		try {
			return getElement(digitalLibratryHeaderText).getText();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Step("Checking the Header text after the Three buttons on Digital Library Page.")
	public String digitalLibraryHeaderTextAfterButtonsValidation () {
		try {
			return getElement(digitalLibratryHeaderTextForCustomize).getText();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Step("Checking the Header text after the areas of content on Digital Library Page.")
	public boolean digitalLibraryHeaderTextAfterAreasOfContentValidation () {
		try {
			return getElement(digitalLibratryHeaderTextFollowingContentArea).isDisplayed();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Checking the Content after the areas of content on Digital Library Page.")
	public boolean digitalLibraryContentTextAfterAreasOfContentValidation () {
		try {
			boolean content = false;
			content = getElement(digitalLibratryContentText1FollowingContentArea).isDisplayed();
			content = getElement(digitalLibratryContentText2FollowingContentArea).isDisplayed();
			return content;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Step("Checking the upgrade contact information after the areas of content on Digital Library Page.")
	public boolean digitalLibraryContentTextAfterAreasOfContentValidationUpgradeContacts () {
		try {;
		return getElement(digitalLibraryUpgradeText).isDisplayed();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}



	@Step("Checking Contact Button is available.")
	public boolean digitalLibraryUpgradeContactsButtons () {
		try {;
		return getElement(digitalLibraryButtonsContactSalesUpgrade).isDisplayed();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Step("Checking Contact number is available.")
	public String digitalLibraryUpgradeContactsDetails () {
		try {
			return getElement(contactInfoForUpdrage).getText();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Step("Checking the Contact Sales button below header section on the Digital Library Page.")
	public String checkDigitalLibraryButtonsContactSales () {
		try {
			return getElement(digitalLibraryButtonsContactSales).getText();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Step("Checking the Digital Library Overview button below header section on the Digital Library Page.")
	public String checkDigitalLibraryButtonsOverview () {
		try {
			return getElement(digitalLibraryButtonsOverview).getText();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Step("Checking the User Resources button below header section on the Digital Library Page.")
	public String checkDigitalLibraryButtonsUserResources () {
		try {
			return getElement(digitalLibraryButtonsUserResources).getText();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Step("Scrolling to the Buttons section under Header Image on the Digital Library Page.")
	public void scrollToDigitalLibraryPageButtons() {
		try {
			ReusableMethods.scrollIntoView(getElement(digitalLibraryButtonsUserResources), driver);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> retrieveContentsInAreasOfContent() {

		try {

			List<WebElement> actualContentsList =   getElements(contentHeader);  
			List<String> actualList = new ArrayList<String>();

			for(int i=0; i<actualContentsList.size(); i++) {
				actualList.add(actualContentsList.get(i).getText());
			}

			System.out.println("Actual List of Contents in Area of Contents: "+actualList);
			return actualList;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public List<String> retrieveContentDescriptionsInAreasOfContent() {

		try {

			List<WebElement> actualContentDescList =   getElements(contentDescription);  
			List<String> actualList = new ArrayList<String>();

			for(int i=0; i<actualContentDescList.size(); i++) {
				actualList.add(actualContentDescList.get(i).getText());
			}

			System.out.println("Actual List of Descriptions: "+actualList);
			return actualList;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	
	public List<WebElement> getElements(By locator) {
		List<WebElement> element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElements(locator);
		} catch (Exception e) {
			System.out.println("Some error occured while creating element" + locator.toString());
			e.getStackTrace();
		}
		return element;
	}

}

