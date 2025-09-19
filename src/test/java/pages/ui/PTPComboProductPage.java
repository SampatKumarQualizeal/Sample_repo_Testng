package pages.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.astm.commonFunctions.PublicCommon;

import base.utils.WaitStatementUtils;

public class PTPComboProductPage extends BasePage {

	public PTPComboProductPage(WebDriver driver) {
		super(driver);
	}
	public By cartButton=By.xpath("//span[text()='Cart']");
	private By PTPProductHeader = By.className("page-title");
	public By registerProgramBtn = By.xpath("//a[contains(text(),'Register for a Program')]");
	
	private By registerForProgramButton = By.id("product-addtocart-button");
	public By registerForMultipleProgramsButton = By.xpath("//*[@title='Register for Multiple Programs']");
	public By shoppingCartLink = By.xpath("//a[text()='shopping cart']");

	public By scheduleTimeError = By.id("schedule_name-error");
	public By scheduleNameDropDwn = By
			.xpath("//*[text()='Choose a Program Schedule']/..//following-sibling::div/select");
	public By scheduleQuartersList = By.xpath("//li[contains(text(),'Schedule')]/..//li");
	public By reducedPrice = By.id("reduced-price");
	public By toolTipText = By.id("reduced-price-notice");
	public By quatersHeading = By.xpath("//*[contains(@class,'astm-type-body--lead font-weight-bold')]");
	public By primary_expansion_header = By.xpath("//*[contains(@class,'astm-type-body')]/strong");
	public By pmry_expansion_schedules = By.xpath("//div[@id='reduced-price']//preceding-sibling::div//ul");
	public By infoIndicator = By.xpath("//i[@id=\"reduced-price-notice\"]");
	public By addToCartButton1 = By.xpath("//button[contains(text(), 'Add to Cart')]");
	public By schedule = By.xpath("//div[@id='reduced-price']//preceding-sibling::div[@class='astm-type-body--lead font-weight-bold']");
	public By addToCartButton = By.xpath("//*[contains(text(),'Add to Cart')]");    
	public By NewPrice =By.xpath("//span[@class=\"price-container price-final_price tax weee\"]");
	public By multiplasticProduct = By.xpath("(//a[contains(text(),'Multiplastics Mechanical Properties')])[2]");
	public By method1ComboProduct = By.xpath("//span[text()='ASTM Method']");
	public By method2ComboProduct = By.xpath("//span[text()='ISO Method']");
	public By method3ComboProduct = By.xpath("//span[text()='Both']");
	public By polyPropyleneProduct = By.xpath("(//a[contains(text(),'Polypropylene Testing')])[2]");
	public By multiplasticMechnicalProduct = By.xpath("(//a[contains(text(),'Multiplastics Mechanical Properties')])[2]");
	public By polypropyleneTesting = By.xpath("(//a[contains(text(),'Polypropylene Testing')])[2]");
	public By oneMethod = By.xpath("//div[contains(text(),'One Method')]");          
	public By annualquaterMayNovMultiPlastic = By.xpath("(//*[contains(text(),'May, November')])[2]");   
	public By annualquaterAprilOctPolypropylene = By.xpath("(//*[contains(text(),'April, October')])[2]");
	public By otherProgramAndServices=By.xpath("//h4[contains(text(),'Other Programs and Services')]");
	public By emergingProfessionalsProgram=By.xpath("//a[contains(text(),'Emerging Professionals Program')]");
	public By technicalCommitteesLink=By.xpath("//span[contains(text(),'Technical Committees')]");
	public By  emergingProfessionalsProgramHeader=By.xpath("//h4[contains(text(),\"Empowering Tomorrow's Standards Leaders\")]");
	public By chemicalAnalysisProduct = By.xpath("(//a[contains(text(),' Chemical Analysis Plain Carbon/Low Steel Alloy (4 qtrs.)')])[2]");
	public By mechanicalProduct = By.xpath("(//a[contains(text(),'Multiplastics Mechanical Properties ')])[2]");
	public By propyleneProduct = By.xpath("(//a[contains(text(),'Polypropylene Testing')])[2]");
	public By chemicalAnalysisProductHeader = By.xpath("//span[contains(text(),'Chemical Analysis Plain Carbon/Low Steel Alloy (4 qtrs.)')]");
	public By committeeMechanicalProduct = By.xpath("//a[contains(text(),'Multiplastics Mechanical Properties ')][1]");
	public By SampleAmount = By.xpath("//strong[text()=\"Sample amount distributed each test cycle\"]");
	public By committeePolypropyleneProduct = By.xpath("//a[contains(text(),'Polypropylene Testing')][1]");
	public By forMoreInfo = By.xpath("//h4[contains(text(),'For More Information')]");
	public By studentMembershipLink = By.xpath("//a[contains(text(),'Student membership')]");
	
	//*[text()='kkoperna@astm.org']//ancestor::p[text()='Questions? Contact Katerina Koperna at +1.610.832.9728 or email ']   
	public By getForMoreInfo(String mail) {
		return By.xpath("//*[text()='"+mail+"']//ancestor::p[text()='Questions? Contact Katerina Koperna at +1.610.832.9728 or email ']");
	}
	    public WebElement getAddToCartButton() {
	    	return getElement(addToCartButton); }    
	public String getTooltipText() {
		return getElement(toolTipText).getAttribute("data-original-title").trim();
	}
	public WebElement getRegisterProgramBtn() {

		return getElement(registerProgramBtn);
	}

	public WebElement getPrimaryExplansionSchedules() {

		return getElement(pmry_expansion_schedules);
	}
	
	public WebElement getScheduleNameDropdownElement() {

		return getElement(scheduleNameDropDwn);
	}

	public List<WebElement> getPrimaryExplansionHeadingOnProduct() {

		return getElements(primary_expansion_header);
	}
	public boolean clickRegisterForProgramButton1() 
	{
		try {
			getElement(polyPropyleneProduct).click();
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;

		}	
	}

	public String getQuartersHeading() {

		return getElement(quatersHeading).getText();
	}

	public List<WebElement> getScheduleQuaters() {

		return getElements(scheduleQuartersList);
	}

	public boolean clickShoppingCartLink() 
	{
		try {
			getElement(shoppingCartLink).click();
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
			// TODO: handle exception
		}	
	}
    public String getinfoIndicatorText() {
		try {
			return getElement(infoIndicator).getText();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getscheduleText() {
		try {
			return getElement(schedule).getText();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

    
    public boolean scheduleNameDropdownVisible() {

		try {
			getElement(scheduleNameDropDwn).isDisplayed();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;

		}
	}

	public boolean clickRegisterForProgramButton() {
		try {
			getElement(registerForProgramButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;

		}
	}

	public BulkOrder_Page clickRegisterForMultipleProgramButton() {
		try {
			getElement(registerForMultipleProgramsButton).click();
			return getInstance(BulkOrder_Page.class);
		} catch (Exception e) {
			e.getStackTrace();
			return null;

		}
	}
	public boolean clickOnShoppingCartLink() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(shoppingCartLink));
			PublicCommon.JSClick(getElement(shoppingCartLink), driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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

	public String getPTPProductHeader() {
		try {
			return getElement(PTPProductHeader).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public String getScheduleTimErrorMsg() {
		try {
			return getElement(scheduleTimeError).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

}
