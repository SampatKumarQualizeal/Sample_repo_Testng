package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import java.util.List;

public class MembershipTypesPage_Public extends BasePage {
	String CostOfMembership;
	public MembershipTypesPage_Public(WebDriver driver) {
		super(driver);
	}

	public By participatingMembersMoreBtn = By.xpath("//div//h4[text()='Participating Members']//following-sibling::a");
	public By organizationalMoreBtn = By.xpath("//h4[contains(text(),'Organizational Members')]/following-sibling::a");
	public By informationalMoreBtn = By.xpath("//div//h4[text()='Informational Members']/following-sibling::a");
	public By studentMoreBtn = By.xpath("//div//h4[text()='Student Members']//following::a[contains(@href,'https://stage.astm.org/get-involved/students-and-professors/for-students/memstudent21.html')][1]");
	public By membershipTitle = By.xpath("//h1[text()='Membership']");
	// Participating membership section
	public By participatingMembersheading = By.xpath("//h4[text()='Participating Members']");
	// public By participatingMembershipCostDesc =
	// By.xpath("//div//h4[text()='Participating Members']//following::p[1]");
	public By participatingMembershipCost = By
			.xpath("//div//h4[text()='Participating Members']//following::p[1]//strong");
	public By benefitsOfParticipatingMembers = By
			.xpath("//div//h4[text()='Participating Members']//following::strong[text()='Benefits']");
	public By becomeParticipatingMemberBtn = By.xpath("//a[contains(@href,'participating') and contains(text(),'Learn')]");
	// Organizational membership section
	public By orgMemberHeading = By.xpath("//h4[text()='Organizational Members']");
	public By orgCost = By.xpath("//div//h4[text()='Organizational Members']//following::p[1]//strong");
	public By benefitsOfOrganizationalMembers = By
			.xpath("//div//h4[text()='Organizational Members']//following::strong[text()='Benefits']");
	public By becomeOrganizationalMemberBtn = By.xpath("//a[contains(@href,'organizational') and contains(text(),'Learn')]");
	// Informational membership section
	public By infoHeading = By.xpath("//h4[text()='Informational Members']");
	public By infoCost = By.xpath("//div//h4[text()='Informational Members']//following::p[1]//strong");
	public By benefitsOfInformationalMembers = By
			.xpath("//div//h4[text()='Informational Members']//following::strong[text()='Benefits']");
	public By learnMoreInformationalMemberBtn = By.xpath("//a[contains(@href,'memindividual') and contains(text(),'Learn')]");
	public By becomeInformationalMemberBtn = By.xpath("//a[contains(@href,'informational')]");
	public By membershipText = By.xpath("//span[text()='Membership']");
	// Student membership section
	public By stdHeading = By.xpath("//h4[text()='Student Members']");
	public By stdCost = By.xpath("//div//h4[text()='Student Members']//following::p[1]//strong");
	public By benefitsOfStudentsMembers = By
			.xpath("//div//h4[text()='Student Members']//following::strong[text()='Benefits']");
	public By becomeStudentMemberBtn = By.xpath("//a[contains(text(),'Student Member')]");
	public By studentMemberPrice=By.xpath("//h4[text()='Student Members']/../p");
	public By price=By.xpath("//b[text()='Price']/../span");
	public By pageHeader = By.xpath("//h1[text()='Membership']");
	public By onlineApplication=By.xpath("//p/a[contains(text(),'online')]");
	public By studentMemberButton = By.xpath("//*[text()='Become a Student Member']");
	public By joinNowBtn = By.xpath("//a[contains(text(),'Join Now ')]");
	public By text = By.xpath("//h1[text()='Benefits for ASTM Informational Members']");
	public By bookOfStandardVolumeLink = By.xpath("//a[text()='Book of Standards Volume']");
	public By annualBookHeader = By.xpath("//h1[text()='Annual Book of ASTM Standards']");
	public By renewMembershipButton = By.xpath("//*[contains(text(),'Renew Membership')]");
	public By renewMembershipButton1 = By.xpath("//*[@id=\"v-pills-tab-indented\"]/a[2]/span[contains(text(),'Membership')]");
	public By renewMembershipButton2 = By.xpath("//a[contains(text(),'Join Now - Explore the Benefits of Membership')]");
	public By MembershipCost = By.xpath("//div[@class='membership-block border-top mt-4 pt-4 astm-type-body--lead']/p");
	public By CartProductItem = By.xpath("//strong[@class='product-item-name']");

	public By CartSubTotal = By.xpath("//div[@class='subtotal-row']/p/span/span");
	public By MembershipCostCartPage = By.xpath("(//span[@class='price'])[2]");
	public By MembershipType = By.xpath("//span[@class='astm-type-body account-membership']");
	public By getPriceForMembershipProduct(String fieldText) {
		return By.xpath("//h4[text()='"+ fieldText + "']/../p");
	}

	//a[contains(text(),'Explore the Benefits')]


	public boolean pageHeaderIsVisible() {
		try {
			return getElement(pageHeader).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Gets current url of the page
	 * 
	 * @return
	 */
	public String getCurrentUrl() {
		try {
			String currentURL = driver.getCurrentUrl();
			return currentURL;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public WebElement costOfMemberValue() {

		return getElement(MembershipCost);
	}

	public WebElement costOfMemberValueCartPage() {

		return getElement(MembershipCostCartPage);

	}

	public WebElement CartProductItemValue() {

		return getElement(CartProductItem);
	}

	public String MembershipInitialProductName(){
		String MemTypeInformationalMemberBtn = getElement(becomeInformationalMemberBtn).getText();
		return MemTypeInformationalMemberBtn;
	}

	public String MembershipInitialCostValue(int index){
			String CostOfMembership =driver.findElement(By.xpath("(//div[contains(@class,'card-subtitle')]/div)["+index+"]")).getText();
			return CostOfMembership;
	}

	public void MembershipCartSubTotal() {
		String CostOfMembership = CartProductItemValue().getText();
	}


}





