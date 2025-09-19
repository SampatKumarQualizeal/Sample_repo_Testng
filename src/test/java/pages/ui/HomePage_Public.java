package pages.ui;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static base.utils.ReusableMethods.mouseHover;
import static org.testng.AssertJUnit.assertEquals;

public class HomePage_Public extends BasePage {

	public HomePage_Public(WebDriver driver) {
		super(driver);
	}
	MIC_Helper_Public micHelperPublic;
	PublicSearchPage publicSearchPage;
	MembershipBecomeMemberPage newMembershipPage;
	CommonPage_Public commonPagePublic;
	private By loginButtonOnHomepage = By.xpath("//span[contains(text(),'Sign In')]");
	private By btnhomePageSignIn = By.xpath("//a[contains(text(), 'SIGN IN')]");
	private By loggedInMyASTMButton = By.xpath("//span[contains(text(),'My ASTM')]");
	private By cartLinkOnHomePage = By.xpath("//a[contains(@class,'headercart')]/span[contains(text(),'Cart')]");

	public By banner = By.className("banner-item");

	private By workBetterHeader = By.xpath("//h2[text()='Work Better']");
	private By ASTMCompassImage = By.xpath("//h3[text()='ASTM Compass']/..//img[@alt='computer monitor']");
	private By ASTMCompassHeader = By.xpath("//h3[text()='ASTM Compass']");
	private By astmProductDescription = By.xpath("//h3[text()='ASTM Compass']/following-sibling::p");
	private By astmCompassLearnMoreButton = By.xpath("//h3[text()='ASTM Compass']/..//button");

	private By learningProgramsImage = By.xpath("//h3[text()='Learning Programs']/..//img[@alt='graduation hat']");
	public By learningProgramsHeader = By.xpath("//h3[text()='Learning Programs']");
	private By learningProgramsDescription = By.xpath("//h3[text()='Learning Programs']/following-sibling::p");
	private By learningProgramsLearnMoreButton = By.xpath("//h3[text()='Learning Programs']/..//button");

	private By integratedServicesImage = By
			.xpath("//h3[text()='Integrated Services']/..//img[contains(@src,'integrated-services')]");
	public By integratedServicesHeader = By.xpath("//h3[text()='Integrated Services']");
	private By integratedServicesDescription = By.xpath("//h3[text()='Integrated Services']/following-sibling::p");
	private By integratedServicesLearnMoreButton = By.xpath("//h3[text()='Integrated Services']/..//button");

	private By proficiencyTestingProductImage = By
			.xpath("//h3[text()='Proficiency Testing Programs']/..//img[contains(@src,'test-tubes')]");
	public By proficiencyTestingHeader = By.xpath("//h3[text()='Proficiency Testing Programs']");
	public By proficiencyTestingHeader1 = By.xpath("//h2[contains(text(),'ASTM Proficiency Testing Programs (PTP)')]");

	private By proficiencyTestingDescription = By
			.xpath("//h3[text()='Proficiency Testing Programs']/following-sibling::p");
	private By proficiencyTestingLearnMoreButton = By.xpath("//h3[text()='Proficiency Testing Programs']/..//button");

	// The Latest Section
	private By theLatestHeader = By.xpath("//span[text()='The Latest']");
	private By latestNewsCount = By.cssSelector(".pagebuilder-column figure");
	private By latestSectionImages = By.cssSelector(".pagebuilder-column-group .pagebuilder-mobile-hidden");
	private By latestSectionArticleTitle = By.cssSelector(".pagebuilder-column-group h4 a");
	private By latestSectionArticleSummary = By
			.xpath("//div[@class='pagebuilder-column-group']//h4/following-sibling::p/span");
	private By latestSectionArticleType = By.cssSelector(".pagebuilder-column-group .card-text p span");

	// About
	private By aboutASTMSection = By.xpath("//*[text()='About ASTM International']");
	public By findOutMoreAboutASTMBtn = By.xpath("//*[contains(text(),'FIND OUT MORE ABOUT ASTM')]");

	// Banners on Homepage
	private By homePageBanner = By.xpath("//*[@class='home-top-banner']");
	private By bannerImageMatch1 = By
			.xpath("//*[@class='home-top-banner']//div[contains(@data-background-images, 'hero-1.jpg')]");
	private By bannerImageMatch2 = By
			.xpath("//*[@class='home-top-banner']//div[contains(@data-background-images, 'hero-2.jpg')]");
	private By bannerImageMatch3 = By
			.xpath("//*[@class='home-top-banner']//div[contains(@data-background-images, 'hero-3.jpg')]");
	private String bannerImage = "//*[@class='home-top-banner']//div[contains(@data-background-images, 'hero-bannerIndex.jpg')]";

	private By bannerTitle = By.xpath("//*[@class='home-top-banner']//*[@class='pagebuilder-poster-content']//div//h3");
	private By bannerDescription = By
			.xpath("//*[@class='home-top-banner']//*[@class='pagebuilder-poster-content']//div//p");
	private By bannerButtonAndLink = By
			.xpath("//*[@class='home-top-banner']//*[@class='pagebuilder-poster-content']//a");
	// Twitter Section
	private By twitterSectionHeader = By.xpath("//h2[contains(text(),'Latest on Twitter')]");
	private By twitterBody = By.xpath(
			"//div[@class=\"timeline-Viewport\"]//ol[@class=\"timeline-TweetList\"]//li[@class=\"timeline-TweetList-tweet customisable-border\"]");
	private String twitterFrameId = "twitter-widget-0";

	public By invalidKey = By.xpath("//div[contains(text(),'Invalid Form Key.')]");
	public By favicon = By.cssSelector("*[type='image/x-icon'][rel='icon']");
	public By unauthorisedB2BAdminUserErrorMsg = By.xpath("//div[@class='prepare-message astm-alert-text']");
	public By PTPErrorMsg = By.xpath(
			"//div[@class='prepare-message astm-alert-text' and contains(text(),'We are sorry. This product conflicts with a product currently in your cart. To add this product, you must first clear your cart. Please ')]");
	public By PTPErrorMsg1 = By.xpath("//div[@class='prepare-message astm-alert-text']");
	public By contactUs = By.xpath("(//a[text()='contact us'])");
	public By contactUs1 = By.xpath("(//a[text()='contact us'])[2]");
	public By contactUsLink = By.linkText("Contact Us");
	public By contactHeader = By.xpath("//h2[contains(text(),'Contact ASTM')]");
	public By productsAndServicesNavigation = By.xpath("(//*[@id='productsDropdownMenuLink'])[1]");
	public By proficiencyTestingNavigation = By.xpath("(//a[contains(text(),'Proficiency Testing')])[1]");
	public By fullListOption = By.xpath("//button[contains(text(),'Full List')]");
	public By cementCommitteeLink= By.xpath("//button[contains(text(),'Committee C01 on Cement and C09 on Concrete and Aggregates')]"); 
	public By CommitteeD37Link= By.xpath("//button[contains(text(),'Committee D37 on Cannabis')]");
	public By CommitteeD20Link= By.xpath("//button[contains(text(),'Committee D20 on Plastics')]");
	public By D37HempFLowLink= By.xpath("//li[1]/a[contains(text(),'D37 Hemp Flow')]");
	public By D37HempFLow_FullListLink= By.xpath("//li[2]/a[contains(text(),'D37 Hemp Flow')]");
	public By cementConcrete = By.xpath("(//a[contains(text(),'Cement and Concrete')])[1]");
	public By committeeD13onTextiles = By.xpath("//button[contains(text(),'Committee D13 on Textiles')]");
	public By ptpProgramsText = By.xpath("//*[@id='committee-2']/div/p/strong");
	public By ptpProgramsText1 = By.xpath("//strong[contains(text(),'PTP Programs')]");
	public By cementCommiteeHeading = By.xpath("//h1[contains(text(),'Cement and Concrete Reference Laboratory')]");
	public By D37HempFLowHeading = By.xpath("//span[contains(text(),'D37 Hemp Flower')]");
	public By BaseOilLink = By.xpath("(//*[contains(text(),' Base Oil')])[1]");
	//span[contains(text(),'D37 Hemp Flower (US Participants Only)')]
	public By D37HempFlowerUSParticipantsLink = By.xpath("//span[contains(text(),'D37 Hemp Flower')]");
	public By CommitteeD02PetroleumLink = By.xpath("//button[contains(text(),'Committee D02 on Petroleum Products, Liquid Fuels,')]");

	private By PublicPage_SearchInputTextBox = By.xpath("//input[@id='search']");
	private By PublicPage_SearchButton = By.xpath("//input[@id='search']//following-sibling::div/button");

	public By LaboratoryServices = By.xpath("(//div[@class='dropdown-submenu-content'])[4]/a");
	public By PTPRegisterforProgramBtn=By.xpath("//div[contains(@class,'d-flex mb')]/a");
	public By PTPTableFirstElement=By.xpath("//div[@class='multiple-order-container']/descendant::tbody/tr[1]/td[1]/a");
	public By dropdowncheck=By.xpath("//span[contains(text(),'Choose a Program')]");
	public String getPTPRenewalErrorMsg() {
		System.out.println("error mg" + "=========");
		return getElement(PTPErrorMsg1).getText();
	}

	public WebElement getPublicPage_SearchTextBox(){
		return getElement(PublicPage_SearchInputTextBox);
	}
	public WebElement getPublicPage_SearchButton(){
		return getElement(PublicPage_SearchButton);
	}

	/*
	 * (//a[contains(text(),'contact us')])[2] Description: Checking the Banner
	 * Option visible on the Homepage
	 * 
	 * @author: Swapnil
	 */
	@Step("Retrieving current Banner Option visible on Homepage - showing one of total possible {bannersOnHomePage} banners.")
	public int[] bannerOptionVisibleOnHomePage(int bannersOnHomePage) {

		try {
			boolean bannerDetected = false;
			int detectedBanner = -1;
			int[] bannerTest = new int[bannersOnHomePage];

			// Waiting for Banner to appear on Homepage.
			int pollingTime = 5000; // in milliseconds
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(homePageBanner), pollingTime);

			for (int i = 0; i < bannerTest.length; i++) {
				bannerTest[i] = 0;
			}

			for (int i = 0; i < bannerTest.length; i++) {

				try {
					if (getElements(By.xpath(bannerImage.replace("bannerIndex", String.valueOf(i + 1)))).size() > 0) {
						bannerTest[i] = 1;
						bannerDetected = true;
						detectedBanner = (i + 1);
						System.out.println("CURRENT ITERATION WILL TEST Banner - " + detectedBanner);
						break;
					}
				} catch (NoSuchElementException ex) {
					System.out.println("Managed Ecxeption and continue element look up.");
					continue;
				}
			}

			if (bannerDetected)
				return bannerTest;
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			;
			return null;
		}
	}

	public List<WebElement> getLatestNewsCountList() {
		return getElements(latestNewsCount);
	}

	public WebElement getAboutASTMSection() {
		return getElement(aboutASTMSection);
	}
	public WebElement getptpProgramsText() {
		return getElement(ptpProgramsText);
	}
	public WebElement getptpProgramsTextNew() {
		return getElement(ptpProgramsText1);
	}
	public WebElement getFullListOption() {
		return getElement(fullListOption);
	}
	public String getproficiencyTestingHeader1() {
		return getElement(proficiencyTestingHeader1).getText();
	}

	public List<WebElement> getLatestSectionImagesList() {
		return getElements(latestSectionImages);
	}

	public List<WebElement> getLatestSectionArticleTitleList() {
		return getElements(latestSectionArticleTitle);
	}

	public List<WebElement> getLatestSectionArticleSummaryList() {
		return getElements(latestSectionArticleSummary);
	}

	public List<WebElement> getLatestSectionArticleTypeList() {
		return getElements(latestSectionArticleType);
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

	public static boolean verifyAllTheElementsInTheListAreVisible(List<WebElement> list) {
		try {
			boolean flag = false;
			for (int i = 0; i < list.size(); i++) {
				flag = list.get(i).isDisplayed();
				System.out.println("Visiblity Result::::" + flag);
				if (flag = false) {
					System.out.println("Found false");
					return flag;
				}
			}
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;

		}
	}

	@Step("Check 'The Latest' section contains atmost 6 recent news articles.")
	public boolean verifyTheLatestNewsArticlesCount() {
		try {
			if (getLatestNewsCountList().size() < 7 && !getLatestNewsCountList().isEmpty())
				return true;
			else
				return false;
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'The Latest' Header text is present.")
	public boolean verifyTheLatestHeaderText(String expectedHeader) {
		try {
			return getElement(theLatestHeader).getText().equals(expectedHeader);
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check Images are visible in 'The Latest' section.")
	public boolean verifyImagesAreVisibleInTheLatestSection() {
		try {
			return verifyAllTheElementsInTheListAreVisible(getLatestSectionImagesList());
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check Article Titles are visible in 'The Latest' section.")
	public boolean verifyArticleTitlesAreVisibleInTheLatestSection() {
		try {
			return verifyAllTheElementsInTheListAreVisible(getLatestSectionArticleTitleList());
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check Article Summaries are visible in 'The Latest' section.")
	public boolean verifyArticleSummariesAreVisibleInTheLatestSection() {
		try {
			return verifyAllTheElementsInTheListAreVisible(getLatestSectionArticleSummaryList());
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check Article Types are visible in 'The Latest' section.")
	public boolean verifyArticleTypesAreVisibleInTheLatestSection() {
		try {
			return verifyAllTheElementsInTheListAreVisible(getLatestSectionArticleTypeList());
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Scroll to View 'The Latest' Header on the page.")
	public void scrollToLatestNewsHeader() {
		try {
			ReusableMethods.scrollIntoView(getElement(theLatestHeader), driver);
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
	}

	@Step("Scroll to View 'Work Better' Header on the page.")
	public void scrollToWorkBetterHeader() {
		try {
			ReusableMethods.scrollIntoView(getElement(workBetterHeader), driver);
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
	}

	@Step("Check 'Work Better' Header text is present.")
	public boolean verifyWorkBetterHeaderText(String expectedHeader) {
		try {
			return getElement(workBetterHeader).getText().equals(expectedHeader);
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'ASTM Compass' Image is visible.")
	public boolean verifyASTMCompassImageIsVisible() {
		try {
			return getElement(ASTMCompassImage).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'ASTM Compass' Header text.")
	public boolean verifyASTMCompassHeaderText(String expectedHeader) {
		try {
			return getElement(ASTMCompassHeader).getText().equals(expectedHeader);
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'ASTM Compass' Description text.")
	public boolean verifyASTMProductDescriptionText(String expectedDescription) {
		try {
			return getElement(astmProductDescription).getText().equals(expectedDescription);
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'ASTM Compass' Learn button is clickable and text on button is correct.")
	public boolean verifyASTMProductLearnButtonText(String expectedText) {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(astmCompassLearnMoreButton));
			return getElement(astmCompassLearnMoreButton).getText().equals(expectedText);
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'Learning Programs' Image is visible.")
	public boolean verifyLearningProgramsImageIsVisible() {
		try {
			return getElement(learningProgramsImage).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'Learning Programs' Header text is visible.")
	public boolean verifyLearningProgramsHeaderText(String expectedHeader) {
		try {
			return getElement(learningProgramsHeader).getText().equals(expectedHeader);
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'Learning Programs' Description text is visible.")
	public boolean verifyLearningProgramsDescriptionText(String expectedDescription) {
		try {
			return getElement(learningProgramsDescription).getText().equals(expectedDescription);
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'Learning Programs' Learn button is clickable and text on button is correct.")
	public boolean verifyLearningProgramsLearnButtonText(String expectedText) {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(learningProgramsLearnMoreButton));
			return getElement(learningProgramsLearnMoreButton).getText().equals(expectedText);
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'Integrated Services' Image is visible.")
	public boolean verifyIntegratedServicesImageIsVisible() {
		try {
			return getElement(integratedServicesImage).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'Integrated Services' Header text.")
	public boolean verifyIntegratedServicesHeaderText(String expectedHeader) {
		try {
			return getElement(integratedServicesHeader).getText().equals(expectedHeader);
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'Integrated Services' Description text.")
	public boolean verifyIntegratedServicesDescriptionText(String expectedDescription) {
		try {
			return getElement(integratedServicesDescription).getText().equals(expectedDescription);
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'Integrated Services' Learn button is clickable and text on button is correct.")
	public boolean verifyIntegratedServicesLearnButtonText(String expectedText) {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(integratedServicesLearnMoreButton));
			return getElement(integratedServicesLearnMoreButton).getText().equals(expectedText);
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'ProficiencyTesting' Image is visible.")
	public boolean verifyProficiencyTestingImageIsVisible() {
		try {
			return getElement(proficiencyTestingProductImage).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'Proficiency Testing' Header text.")
	public boolean verifyProficiencyTestingHeaderText(String expectedHeader) {
		try {
			return getElement(proficiencyTestingHeader).getText().equals(expectedHeader);
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'Proficiency Testing' Description text.")
	public boolean verifyProficiencyTestingDescriptionText(String expectedDescription) {
		try {
			return getElement(proficiencyTestingDescription).getText().equals(expectedDescription);
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	@Step("Check 'Proficiency Testing' Learn button is clickable and text on button is correct.")
	public boolean verifyProficiencyTestingLearnButtonText(String expectedText) {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(proficiencyTestingLearnMoreButton));
			return getElement(proficiencyTestingLearnMoreButton).getText().equals(expectedText);
		} catch (Exception e) {
			e.getStackTrace();
			return false;// TODO: handle exception
		}
	}

	/*
	 * Description: Function retrieves the details of the banner on Homepage
	 * 
	 * @author: Swapnil
	 */
	@Step("Retrieving current banner details.")
	public HashMap<String, String> getCurrentBannerDetails() {
		try {
			HashMap<String, String> mapper = new HashMap<String, String>();

			mapper.put("MainBannerImageTitle", getElement(bannerTitle).getText());
			mapper.put("MainBannerImageDescription", getElement(bannerDescription).getText());
			mapper.put("MainBannerActionButtonTitle", getElement(bannerButtonAndLink).getText());
			mapper.put("MainBannerActionButtonLink", getElement(bannerButtonAndLink).getAttribute("href"));

			return mapper;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/*
	 * This method verifies if 3 latest tiles are displayed in Twitter Section
	 */
	public boolean verifyLatestTwitterIsDisplayed() {
		ReusableMethods.scrollIntoView(getElement(twitterSectionHeader), driver);
		driver.switchTo().frame(twitterFrameId);
		List<WebElement> elementList = driver.findElements(twitterBody);
		if (elementList.size() == 3) {
			driver.switchTo().defaultContent();
			return true;

		} else {
			driver.switchTo().defaultContent();
			return false;
		}
	}

	//
	// @Step("Click on SIGN IN on the Homepage.")
	public CustomerLogin_Public goToLoginPage() {
		try {
			getElement(loginButtonOnHomepage).click();
			return getInstance(CustomerLogin_Public.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			// getElement(btnhomePageSignIn).click();
			return null;
		}
	}

	public boolean goToCart() {
		try {
			PublicCommon.waitForSec(15);
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(cartLinkOnHomePage), 30);
			(new Actions(driver)).moveToElement(getElement(cartLinkOnHomePage)).click().build().perform();
			new WebDriverWait(driver, 30).until(ExpectedConditions.urlContains("/checkout/cart/"));
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on Cart", ex);
		}
		return false;
	}

	@Step("Validate navigation to All Trainings Page from homepage")
	public void verifyNavigationToAllTrainingCourses() {
		try {
			newMembershipPage = getInstance(MembershipBecomeMemberPage.class);
			commonPagePublic = getInstance(CommonPage_Public.class);
			newMembershipPage.handleOneTrustCookie();
			clickonmethod("ASTM Logo", commonPagePublic.astmLogo, "Failed to click on ASTM Logo");
			WaitStatementUtils.explicitWaitForVisibility(driver, commonPagePublic.getElement(commonPagePublic.productsAndServicesNavigation), 20);
			WaitStatementUtils.waitForElementToBeClickable(driver, commonPagePublic.getElement(commonPagePublic.productsAndServicesNavigation), 20);

			ReusableMethods.scrollIntoView(commonPagePublic.getProductsAndServicesNavigation(), driver);
			mouseHover(driver, commonPagePublic.getProductsAndServicesNavigation(), getElement(commonPagePublic.trainingCoursesOptions));
			PublicCommon.waitForSec(3);
			ReusableMethods.mouseHoverAndClickWithAction(driver, commonPagePublic.getAllTrainingCourses(), "All Training Courses");

			ScreenshotUtil.takeScreenshotForAllure(driver);
			assertEquals(commonPagePublic.getElement(commonPagePublic.AllTrainingsHeader).getText(),"ASTM Training and eLearning");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Select All Training courses from Products and Services", e);
		}
	}

	//NavigateToProductPage("Training Courses.All Training Courses")
	@Step("Navigate to Product Page {PagePath}")
	public void NavigateToProductPage(String PagePath){

		commonPagePublic = getInstance(CommonPage_Public.class);
		newMembershipPage = getInstance(MembershipBecomeMemberPage.class);
		newMembershipPage.handleOneTrustCookie();
		clickonmethod("ASTM Logo", commonPagePublic.astmLogo, "Failed to click on ASTM Logo");
		WaitStatementUtils.explicitWaitForVisibility(driver, commonPagePublic.getElement(commonPagePublic.productsAndServicesNavigation));
		PublicAdminCommons.scrollToOffSet(driver, "0", "150");
		try {
			int length = PagePath.split("\\.").length;
			String[] split = PagePath.split("\\.");
			Boolean dot = PagePath.contains(".");
			if(PagePath.contains(".")){
				String ProductSubMenuItem = PagePath.split("\\.")[0].trim();
				String Product = PagePath.split("\\.")[1].trim();
				WaitStatementUtils.explicitWaitForVisibility(driver, commonPagePublic.getElement(commonPagePublic.getProductsMenuOption(ProductSubMenuItem)), 20);
				WaitStatementUtils.waitForElementToBeClickable(driver, commonPagePublic.getElement(commonPagePublic.productsAndServicesNavigation), 20);
				mouseHover(driver, commonPagePublic.getProductsAndServicesNavigation(), getElement(commonPagePublic.getProductsMenuOption(ProductSubMenuItem)));
				ReusableMethods.mouseHoverAndClickWithAction(driver, getElement(commonPagePublic.getProductsMenuOption(Product)), Product);
				PublicCommon.JSClick(getElement(commonPagePublic.getProductsMenuOption(Product)), driver);
			}
			else {
				WaitStatementUtils.explicitWaitForVisibility(driver, commonPagePublic.getProductsAndServicesNavigation(), 20);
				WaitStatementUtils.waitForElementStaleness(driver, commonPagePublic.getProductsAndServicesNavigation(), 20);
				WaitStatementUtils.waitForElementToBeClickable(driver, commonPagePublic.getProductsAndServicesNavigation(), 20);
				mouseHover(driver, commonPagePublic.getProductsAndServicesNavigation(), "Products & Services");

				WaitStatementUtils.explicitWaitForVisibility(driver, getElement(commonPagePublic.getProductsMenuOption(PagePath)));
				WaitStatementUtils.waitForElementStaleness(driver, getElement(commonPagePublic.getProductsMenuOption(PagePath)));
				WaitStatementUtils.waitForElementToBeClickable(driver, getElement(commonPagePublic.getProductsMenuOption(PagePath)));
				getElement(commonPagePublic.getProductsMenuOption(PagePath)).click();
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);


		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Select " + PagePath + " from Products and Services", e);
		}
	}

	@Step("Click on Menu {mainMenu} and Navigate to {link} Link")
	public void navigateToHomeLink(String mainMenu,String link,int index1,int index2)
	{
		try {
			newMembershipPage = getInstance(MembershipBecomeMemberPage.class);
			newMembershipPage.handleOneTrustCookie();
			By menu;
		    if(PublicAdminCommons.isElementDisplayed(driver.findElement(By.xpath("(//button[contains(text(),'"+mainMenu+"')])["+index1+"]")))) {
				menu=By.xpath("(//button[contains(text(),'"+mainMenu+"')])["+index1+"]");
				WaitStatementUtils.waitForElementToBeClickable(driver,getElement(menu),30);
				PublicAdminCommons.clickElementByJavaScript(driver,menu);
			}
			WebElement subMenuLink= driver.findElement(By.xpath("(//a[contains(text(),'"+link+"')])["+index2+"]"));
			ReusableMethods.scrollIntoView(subMenuLink,driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,subMenuLink,30);
			subMenuLink.click();
			PublicAdminCommons.closeOriginalAndswitchToNewOpenedTab(driver);
			PublicCommon.waitForSec(5);
		}catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Navigate to"+link+"link", e);

		}
	}

	@Step("Click on Menu {mainMenu} and Navigate to {link} Link")
	public void navigateToHomeLink(String mainMenu,String link)
	{
		try {
			newMembershipPage = getInstance(MembershipBecomeMemberPage.class);
			newMembershipPage.handleOneTrustCookie();
			WebElement menu;
			if(PublicAdminCommons.isElementDisplayed(driver.findElement(By.xpath("(//button[contains(text(),'" + mainMenu + "')])[2]")))) {
				menu=driver.findElement(By.xpath("(//button[contains(text(),'" + mainMenu + "')])[2]"));
				WaitStatementUtils.waitForElementToBeClickable(driver,menu,30);
				menu.click();
			}
			else if(PublicAdminCommons.isElementDisplayed(driver.findElement(By.xpath("(//button[contains(text(),'" + mainMenu + "')])")))) {
				menu=driver.findElement(By.xpath("(//button[contains(text(),'" + mainMenu + "')])"));
				WaitStatementUtils.waitForElementToBeClickable(driver,menu,30);
				menu.click();
			}
			WebElement subMenuLink= driver.findElement(By.xpath("(//a[contains(text(),'" + link + "')])[4]"));
			ReusableMethods.scrollIntoView(subMenuLink,driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,subMenuLink,30);
			subMenuLink.click();
			PublicAdminCommons.closeOriginalAndswitchToNewOpenedTab(driver);
		}catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Navigate to"+link+"link", e);

		}
	}


	public void NavigateToStandardsProductPage()
	{
		newMembershipPage = getInstance(MembershipBecomeMemberPage.class);
		commonPagePublic = getInstance(CommonPage_Public.class);

		driver.navigate().back();
		PublicCommon.waitForSec(10);
		//newMembershipPage.handleOneTrustCookie();
		navigateToHomeLink("Standards & Solutions","Standards Products",2,4);

	}

	public void NavigateToJournalsPage()
	{
		newMembershipPage = getInstance(MembershipBecomeMemberPage.class);
		commonPagePublic = getInstance(CommonPage_Public.class);
		commonPagePublic.navigateToJournals();
	}



	@Step("Validate navigation to {ASTM Proficiency Testing Programs} from homepage")
	public void verifyNavigationToASTMProficiencyTestingPrograms() {
		try {
			commonPagePublic = getInstance(CommonPage_Public.class);
			micHelperPublic = getInstance(MIC_Helper_Public.class);
			newMembershipPage.handleOneTrustCookie();
			clickonmethod("ASTM Logo", commonPagePublic.astmLogo, "Failed to click on ASTM Logo");
			micHelperPublic.mouseHover("Products & Services option", commonPagePublic.getProductsAndServicesNavigation());
			micHelperPublic.mouseHover("Laboratory Services options", commonPagePublic.getLaboratoryServicesOptions());
			commonPagePublic.getElement(commonPagePublic.ProficiencyTesting).click();
			ScreenshotUtil.takeScreenshotForAllure(driver);
			assertEquals(commonPagePublic.getElement(commonPagePublic.PTPheader).getText(),"ASTM Proficiency Testing Programs (PTP)");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify search of standard products", e);
		}
	}

	@Step("Validate navigation to Symposia Papers & STPs from homepage")
		public void verifyNavigationToManualsMonographsAndDataSeries() {
		try {
			commonPagePublic = getInstance(CommonPage_Public.class);
			navigateToHomeLink("Standards & Solutions","Manuals, Monographs & Data Series",1,1);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			PublicCommon.waitForSec(5);
			assertEquals(commonPagePublic.getElement(commonPagePublic.HeaderCardTitle).getText(),"Manuals, Monographs, & Data Series");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify Symposia Papers & STPs page navigation", e);
		}
	}

	@Step("Search given topic on Public HomePage")
	public void searchTopicOnHomePage(String SearchTopic){
		try {
			publicSearchPage = getInstance(PublicSearchPage.class);
			WaitStatementUtils.waitForElementStaleness(driver, getPublicPage_SearchTextBox(),5);
			WaitStatementUtils.waitForElementToBeClickable(driver, getPublicPage_SearchTextBox());
			clickonmethod("Public Page Search", PublicPage_SearchInputTextBox, "Failed to click on Public Page Search");
			IntegrationCommon.clearTxtFieldsendKeys(driver, PublicPage_SearchInputTextBox, SearchTopic);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementStaleness(driver, getPublicPage_SearchButton());
			WaitStatementUtils.waitForElementToBeClickable(driver, getPublicPage_SearchButton());
			clickonmethod("PublicPage_SearchButton", PublicPage_SearchButton, "Failed to click on Search button on public home page");
			new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("catalogsearch/result"));
			WaitStatementUtils.waitForElementStaleness(driver, getElement(publicSearchPage.refinementTab));
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(publicSearchPage.refinementTab));
			ScreenshotUtil.takeScreenshotForAllure(driver);
			Assert.assertTrue(publicSearchPage.verifyRefinementTab(), "Refinement Tab not visible");
		}
		catch (Exception e){
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to search for '" + SearchTopic + "' in Public home page", e);
		}
	}

	@Step("Validate navigation to All Standards and Punlications from homepage")
	public void NavigateToAllStandardsAndPublications() {
		try {
			commonPagePublic = getInstance(CommonPage_Public.class);
			newMembershipPage=getInstance(MembershipBecomeMemberPage.class);
			driver.get(ConfigReader.getValue("BASE_URL_PUB_ASTM_NEW"));
			PublicCommon.waitForSec(10);
			newMembershipPage.handleOneTrustCookie();
			navigateToHomeLink("Standards & Solutions","Standards & Publications",2,4);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			assertEquals(commonPagePublic.getElement(commonPagePublic.allStandardsHeader).getText(),"Standards & Publications");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify All Standards and Punlications page navigation", e);
		}
	}
}


