package pages.ui;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import io.qameta.allure.Step;

import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicCommon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JournalsProductPage_Public extends BasePage {
	ASTMCartPage_Public astmCartPage = getInstance(ASTMCartPage_Public.class);

	public JournalsProductPage_Public(WebDriver driver) {
		super(driver);
	}


	public By authorInstructionsTab = By.id("author-instructions-tab");
	public By OnlinePaperSubmittalAILink = By.linkText("Online Paper Submittal");// in Author Instructions Tab

	public By journalHeader = By.xpath("//h3[text()='Journals']");
	public By subscriptionTab = By.xpath("//*[@id='tabs']//a[contains(text(),'Subscription')]");
	public By subscriptionInformationText = By.xpath("//div[@id='subscription']/p");
	public By contactSalesLink = By.xpath("//a[contains(text(),'contact Sales')][1]");
	public By licenceAgreementLink = By.xpath("//a[contains(text(),'Read ASTM License Agreement')]");
	public By indexedInHeader = By.xpath("//h6[text()='Indexed In']");
	public By detailsHeader = By.xpath("//h6[text()='Details']");
	public By relatedHeader = By.xpath("//h6[text()='Related']");
	public By subscriptionHeader = By.xpath("//h1[text()='Subscription Information']");
	public By individualSubHeader = By.xpath("//b[text()='Individual*']");
	public By institutionalSubHeader = By.xpath("//b[text()='Institutional**']");
	public By subscriptionPeriodSubHeader = By.xpath("//b[text()='Subscription Period']");
	public By addToCartBtn = By.xpath("//button[@title='Add to Cart']");
	public By subscriptionAddToCartBtn = By.xpath("//*[@id='subscription']//button[@title='Add to Cart']");
	public By cartLink = By.xpath("//span[@class='cart-title']");
	public By onlinePrice = By.xpath("//b[text()='Online only:']/parent::p");
	public By onlineOnlyPrice=By.xpath("//b[text()='Online only:']/..");

	private By ssmsJournalPageImage = By.xpath("//img[contains(@src ,'ssms-cover')]");
	private By mpcJournalPageImage = By.xpath("//img[contains(@src ,'mpc-web_1_1.jpg') or contains(@src ,'mpc-web_1_2.jpg')]");
	private By gtjJournalPageImage = By.xpath("//img[contains(@src ,'gtj-web_1_1.jpg') or contains(@src ,'gtj-web_1_2.jpg')]");
	private By acemJournalPageImage = By.xpath("//img[contains(@src ,'acem-web_1_1.jpg') or contains(@src ,'acem-web_1_2.jpg')]");
	private By joteJournalPageImage = By.xpath("//img[contains(@src ,'jte-web_1_1.jpg') or contains(@src ,'jte-web_1_2.jpg')]");

	private By jaibkfileJournalPageImage = By.xpath("//img[contains(@src ,'jai_cover_1_1.png') or contains(@src ,'jai_cover_1_2.png')]");
	private By jofsbkfileJournalPageImage = By.xpath("//img[contains(@src ,'jofs_cover_5.png') or contains(@src ,'jofs_cover_1_2.png')]");
	private By ccabkfileJournalPageImage = By.xpath("//img[contains(@src ,'cca_cover_1_1.png') or contains(@src ,'cca_cover_15.png')]");
	private By jctrbkfileJournalPageImage = By.xpath("//img[contains(@src ,'jctr_cover_1.png') or contains(@src ,'jctr_cover_1_1.png')]");

	private By journalPageTabs = By.xpath("//*[@id='tabs']//*[@class='nav-item']");
	public By aboutTab = By.id("about-tab");
	public By aboutTabHeader = By.xpath("//h1[text()='About this journal']");
	public By firstLookPapersTab = By.xpath("//*[@id='first-look-tab']");
	public By issuesTab = By.xpath("//*[@id='issues-tab']");
	private By editorialBoardTab = By.xpath("//*[@id='editorial-board-tab']");
	private By authrInstructionsTab = By.xpath("//*[@id='author-instructions-tab']");
	private By subsTab = By.xpath("//*[@id='subscription-tab']");
	public By issue_List=By.xpath("//div[@class='mb-3']/ul");
	public By publishedDate = By.xpath("//*[@class='m-0' and contains(., 'Published')]");
	private By indexedInSection = By.xpath(
			"//*[text()='Indexed In']");
	private By citationImage = By.xpath(
			"//img[contains(@src, 'emerging-sources.png')]");
	private By indexedInListing = By.xpath(
			"//*[text()='Indexed In']/..//p");

	private By relatedSection = By.xpath(
			"//*[@class='card astm-card astm-card--flat bg-light card-body mb-3 p-3' and contains(., 'Related')]");
	private By linksOnRelatedSection = By.xpath(
			"//*[@class='card astm-card astm-card--flat bg-light card-body mb-3 p-3' and contains(., 'Related')]//a");

	private By detailsSection = By.xpath(
			"//*[@class='card astm-card astm-card--flat bg-light card-body mb-3 p-3' and contains(., 'Details')]");
	private By dataInDetailsSection = By.xpath(
			"//*[@class='card astm-card astm-card--flat bg-light card-body mb-3 p-3' and contains(., 'Details')]//*[@class='astm-type-body mb-2']");

	private By breadcrumbs = By.xpath("//ul[contains(@class,'breadcrumb astm-breadcrumb')]"); // ("breadcrumb astm-breadcrumb");
																						// //By.xpath("//*[@class='breadcrumbs']");
	private By breadcrumbsSections = By.xpath("//ul[contains(@class,'breadcrumb astm-breadcrumb')]/li");

	private By breadcrumbsLinks = By.xpath("//*[@class='breadcrumbs']//ul//a");

	public By firstRecentIssue = By.xpath("//div[@id='issues']//ul[1]//li[1]//a");
	public By firstRecentArticle = By.xpath("//div[@class='mt-3'][1]//a");
	public By progressStament = By.xpath("//*[@class='astm-type-body--lead border-bottom pb-3']");
	public By firstBreadCrumbsHome = By.xpath("//ul[@class='breadcrumb astm-breadcrumb'][contains(.,'Home')]");
	private By shoppingCartLinkClose = By.xpath("//button[@aria-label='Close']");
	public By shoppingCartLink = By.xpath("//a[text()='shopping cart']");
	private By firstLookPaperNameList = By.xpath("//form//div[@class='mt-4']//a");
	private By firstLookPaperDetailsList = By.xpath("//form//div[@class='mt-4']//p");
	private By firstLookPaperViewAbstractList = By.xpath("//form//div[@class='mt-2']//a");
	private By firstLookPaperAbstractHeading = By.xpath("//h1[text()='Abstract']");
	private By firstLookPaperAddToCart = By.xpath("//button[@title='Add to Cart']");
	public By astmSiteHeader = By.xpath("//header[contains(@class,'page-header')]");
	public By progressStatus = By.xpath("//*[contains(text(),'THIS ISSUE IS IN PROGRESS')");
	public By completeStatus = By.xpath("//*[contains(text(),'THIS ISSUE IS COMPLETE')");
	public By sessionClearedLink = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/button/span");
	public By addToCartIndividual=By.xpath("//b[text()='Individual*']/../../form/button");
	List<WebElement> anchor;
	int anchorSize;

	public By getPriceLocator(String value)
	{
		String path="//b[text()='"+value+"']/../../p/b[contains(text(),'Online only:')]/..";
		return By.xpath(path);
	}

	/**
	 * Get view PDF button
	 * @param value
	 * @return
	 */
	public By getViewPDFButtonOfParticlarPDF(String value)
	{
		String path="//a[text()='"+value+"']/../following-sibling::div/button[text()='View PDF']";
		return By.xpath(path);
	}

	public By getSecondBreadCrumb(String breadCrumb) {
		return By.xpath("//ul[@class='breadcrumb astm-breadcrumb'][contains(.,'" + breadCrumb + "')]");
	}

	List<String> data;
	int loopSize = 10; // This loop size is used to Iterate in First look Papers

	public List<WebElement> getJournalTabs() {
		return getElements(journalPageTabs);
	}

	/**
	 * Click on Journal Link
	 * 
	 * @param journalLink - Give the link to click
	 * @return True/false
	 */
	public boolean clickOnJournal(String journalLink) {
		try {
			WebElement ele = driver.findElement(By.xpath("//a[contains(@href,'" + journalLink + "')]"));
			ReusableMethods.scrollIntoView(ele, driver);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public WebElement getShoppingCart() {
		return getElement(shoppingCartLink);
	}

	@Step("Click Shopping Cart")
	public boolean clickShoppingCartLink() {
		try {
			waitForElementPresent(shoppingCartLink);
			PublicCommon.JSClick(getElement(shoppingCartLink), driver);
			//getElement(shoppingCartLink).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
			// TODO: handle exception
		}
	}
	public List<WebElement> breadcrumbsSectionsWebElementList() {
		try {
			return driver.findElements(breadcrumbsSections);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public List<WebElement> breadcrumbsLinksWebElementList() {
		try {
			return driver.findElements(breadcrumbsLinks);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public String breadcrumbsText() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(breadcrumbs));
			return getElement(breadcrumbs).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public boolean indexedInSection() {
		try {
			ReusableMethods.scrollIntoView(getElement(indexedInSection), driver);
			return getElement(indexedInSection).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public List<WebElement> indexedInListingWebElementList() {
		try {
			return driver.findElements(indexedInListing);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public List<WebElement> relatedLinksWebElementList() {
		try {
			return driver.findElements(linksOnRelatedSection);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public List<WebElement> detailsDataWebElementList() {
		try {
			return driver.findElements(dataInDetailsSection);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public boolean relatedSection() {
		try {
			ReusableMethods.scrollIntoView(getElement(relatedSection), driver);
			return getElement(relatedSection).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean detailsSection() {
		try {
			ReusableMethods.scrollIntoView(getElement(detailsSection), driver);
			return getElement(detailsSection).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean citationImageSection() {
		try {
			ReusableMethods.scrollIntoView(getElement(citationImage), driver);
			return getElement(citationImage).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public By issueLinks = By.xpath("//div[@class='mb-3']//ul//a");
	public By firstJournalIssue=By.xpath("(//div[@class='mb-3']//ul//a)[1]");
	public By Volume1issue5Link = By.xpath("//a[text()='Volume 1 Issue 5 (1973)']");
	public By Volume12issue1Link = By.xpath("//a[text()='Volume 12 Issue 1 (2023)']");
	public By Volume6Issue1Link = By.xpath("//a[text()='Volume 6 Issue 1 (2022)']");
	public By Volume26issue1CCA=By.xpath("//a[text()='Volume 26 Issue 1 (2004)']");
	public By Volume9issue2JAI=By.xpath("//a[text()='Volume 9 Issue 2 (2012)']");
	public By Volume44issue2GTJ=By.xpath("//a[text()='Volume 44 Issue 2 Advances in Laboratory Experimentation for Unsaturated Soils']");
	public By Volume4Issue2SSMS=By.xpath("//a[text()='Volume 4 Issue 2 Special Issue on Technology Infrastructure for Enabling Smart Manufacturing']");
	public By Volume5Issue2ACEM=By.xpath("//a[text()='Volume 5 Issue 2 Freeze Thaw and Salt Attack on Cementitious Materials']");
	public By Volume3Issue2MPC=By.xpath("//a[text()='Volume 3 Issue 2 High Temperature Fatigue']");
	public By Volume17Issue6JOTE=By.xpath("//a[text()='Volume 17 Issue 6 (1989)']");
	public By Volume8Issue4GTJ= By.xpath("//a[text()='Volume 8 Issue 4 (1985)']");
	public By Volume9issue5MPC=By.xpath("//a[text()='Volume 9 Issue 5 Special Issue on Advances in Fatigue and Fracture Mechanics']");
	public By issueLinksHeader = By
			.xpath("//a[text()='< Back to Issues']/following-sibling::h1[contains(text(),'Volume')]");
	public By backIssueLink = By.xpath("//a[text()='< Back to Issues']");
	public By ArticleLinksIssueLink = By.cssSelector(".mt-3 a");
	public By authorsNameIssueLink = By.cssSelector("*[class='m-0 mt-2']");
	public By pageCountIssueLink = By.xpath("//*[text()='Page Count']/..");
	public By publishedIssueLink = By.xpath("//*[text()='Published Online']/..");
	public By paperIdIssueLink = By.xpath("//*[text()='Paper ID']/..");
	public By DOIIssueLink = By.xpath("//*[text()='DOI']/..");
	public By formatIssueLink = By.xpath("//*[text()='Format']/..");
	public By priceIssueLink = By.xpath("//*[text()='Price']/..");
	public By detailsIssueLink = By.cssSelector(".mt-3");
	public By viewAbstractButtonsIssueLink = By.xpath("//button[text()='View Abstract']");
	public By addToCartButtonLink = By.cssSelector("button[title='Add to Cart']");

	public List<WebElement> getIssueLinkList() {
		return getElements(issueLinks);
	}

	public List<WebElement> getArticleLinksIssueLinkElements() {
		return getElements(ArticleLinksIssueLink);
	}

	public List<WebElement> getAuthorsNameIssueLinkElements() {
		return getElements(authorsNameIssueLink);
	}

	public List<WebElement> getPageCountIssueLinkElements() {
		return getElements(pageCountIssueLink);
	}

	public List<WebElement> getPublishedIssueLinkElements() {
		return getElements(publishedIssueLink);
	}

	public List<WebElement> getPaperIdIssueLinkElements() {
		return getElements(paperIdIssueLink);
	}

	public List<WebElement> getDOIIssueLinkElements() {
		return getElements(DOIIssueLink);
	}

	public List<WebElement> getIssuesLinkElements() {
		return getElements(issueLinks);
	}

	public List<WebElement> getFormatIssueLinkElements() {
		return getElements(formatIssueLink);
	}

	public List<WebElement> getPriceIssueLinkElements() {
		return getElements(priceIssueLink);
	}

	public List<WebElement> getViewAbstractButtonsIssueLinkElements() {
		return getElements(viewAbstractButtonsIssueLink);
	}

	public List<WebElement> getAddToCartButtonLinkElements() {
		return getElements(addToCartButtonLink);
	}

	public By abstractViewBtn = By.xpath("//button[text()='View Abstract']");
	public By journalTabsHeader = By.xpath("//div[contains(@aria-labelledby,'tab')]/h1");
	public By issueTabHeader = By.xpath("//h1[text()='Issues']");
	// Articles
	public By listingArticles = By.xpath("//div[@class='mt-3']/a");
	public By articlesHeader = By.xpath("//h3[@class='astm-type-heading--h3']/b");
	public By yearsHeading = By.xpath("//div[@class='mb-3']//b");

	public By getJournalByName(String value)
	{
		String path="//a[contains(text(),'"+value+"')]";
		return By.xpath(path);
	}

	public WebElement getJournalHeader() {
		return getElement(journalHeader);
	}

	public WebElement getIssueLinksHeader() {
		return getElement(issueLinksHeader);
	}

	public boolean getTabsOnPage() {
		try {
			boolean tabs = false;
			int tabIndex = driver.findElements(journalPageTabs).size();
			tabs = (tabIndex == 6);

			if (tabs) {
				tabs = (getElement(aboutTab).isDisplayed() && getElement(firstLookPapersTab).isDisplayed()
						&& getElement(issuesTab).isDisplayed() && getElement(editorialBoardTab).isDisplayed()
						&& getElement(authrInstructionsTab).isDisplayed() && getElement(subsTab).isDisplayed());
			}

			return tabs;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean getTabsOnPageBkFile() {
		try {
			boolean tabs = false;
			int tabIndex = driver.findElements(journalPageTabs).size();
			tabs = (tabIndex == 5);

			if (tabs) {
				tabs = (getElement(aboutTab).isDisplayed()
						// && getElement(firstLookPapersTab).isDisplayed()
						&& getElement(issuesTab).isDisplayed() && getElement(editorialBoardTab).isDisplayed()
						&& getElement(authrInstructionsTab).isDisplayed() && getElement(subsTab).isDisplayed());
			}

			return tabs;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean defaultTab() {
		try {
			String defaultTab = getElement(aboutTab).getAttribute("class");
			System.out.println("default: " + defaultTab);
			boolean def = defaultTab.contains("active");
			System.out.println("about is default tab: " + defaultTab.contains("active"));

			return def;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public String getSubscriptionInformationText() {
		try {
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(subscriptionInformationText));
			return getElement(subscriptionInformationText).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public WebElement getHeader() {
		return getElement(authorInstructionsTab);
	}

	/*
	 * public List<WebElement> getCollaborationDescriptionsElements() { return
	 * getElements(collaborationDescriptions); }
	 */
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

	public boolean clickAddToCartBtn() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(addToCartBtn));
			getElement(addToCartBtn).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public WebElement getAddToCart()
	{
		return driver.findElement(addToCartBtn);
	}

	@Step("Click on Add to cart Button")
	public boolean clicksubscriptionAddToCartBtn() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(subscriptionAddToCartBtn),5);
			getElement(subscriptionAddToCartBtn).click();
			PublicCommon.waitForSec(5);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * This method is checking visibility of SSMS journal image on the SSMS page
	 * 
	 * @return True/false base on visibility of Image of SSMS
	 */
	public boolean ssmsPageImage() {

		try {
			return getElement(ssmsJournalPageImage).isDisplayed();
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * This method is checking visibility of SSMS journal image on the MPC page
	 * 
	 * @return True/false base on visibility of Image of MPC
	 */
	public boolean mpcPageImage() {

		try {
			return getElement(mpcJournalPageImage).isDisplayed();
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * This method is checking visibility of GTJ journal image on the MPC page
	 * 
	 * @return True/false base on visibility of Image of GTJ
	 */
	public boolean gtjPageImage() {

		try {
			return getElement(gtjJournalPageImage).isDisplayed();
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * This method is checking visibility of ACEM journal image on the MPC page
	 * 
	 * @return True/false base on visibility of Image of ACEM
	 */
	public boolean acemPageImage() {

		try {
			return getElement(acemJournalPageImage).isDisplayed();
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * This method is checking visibility of JoTE journal image on the MPC page
	 * 
	 * @return True/false base on visibility of Image of JoTE
	 */
	public boolean JoTEPageImage() {

		try {
			return getElement(joteJournalPageImage).isDisplayed();
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * This method is checking visibility of JAI journal image on the MPC page
	 * 
	 * @return True/false base on visibility of Image of JAI backfile
	 */
	public boolean jaiPageImage() {

		try {
			return getElement(jaibkfileJournalPageImage).isDisplayed();
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method is checking visibility of jofs journal image on the MPC page
	 * 
	 * @return True/false base on visibility of Image of jofs backfile
	 */
	public boolean jofsPageImage() {

		try {
			return getElement(jofsbkfileJournalPageImage).isDisplayed();
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method is checking visibility of cca journal image on the MPC page
	 * 
	 * @return True/false base on visibility of Image of cca backfile
	 */
	public boolean ccaPageImage() {

		try {
			return getElement(ccabkfileJournalPageImage).isDisplayed();
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method is checking visibility of jctr journal image on the MPC page
	 * 
	 * @return True/false base on visibility of Image of jctr backfile
	 */
	public boolean jctrPageImage() {

		try {
			return getElement(jctrbkfileJournalPageImage).isDisplayed();
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 */
	public Boolean matchFound(String patternValue, String value) {
		Pattern pattern = Pattern.compile(patternValue);
		Matcher matcher = pattern.matcher(value);
		return matcher.find();
	}

	public static List<Integer> getListOfTextFromListOfWebelements(List<WebElement> elementsList, WebDriver driver) {

		List<Integer> dropdownValue = new ArrayList<Integer>();
		for (WebElement item : elementsList) {
			if (item.getText().isEmpty() == false)
				dropdownValue.add(Integer.parseInt(item.getText()));
		}
		return dropdownValue;
	}

	public static boolean isYearSortedInDescending(List<Integer> list) {

		System.out.println(list.size());
		int i = 0;
		while (i < list.size() - 1) {
			if (list.get(i + 1) > list.get(i)) {
				return false;
			}
			i++;
		}
		return true;
	}

	/**
	 * This Method provides the Name & Details of 10 first Look Papers
	 * 
	 * @return
	 */
	public List<String> getFirstPapersData() {
		try {
			anchor = getElements(firstLookPaperNameList);
			List<WebElement> paragraph = getElements(firstLookPaperDetailsList);
			List<WebElement> viewAbstract = getElements(firstLookPaperViewAbstractList);
			List<String> data = new ArrayList<String>();

			if (anchor.isEmpty()) {
				System.out.println("There are no first look papers at this time.");
			} else {
				int count = 0;
				anchorSize = anchor.size();
				if (loopSize > anchorSize) {
					loopSize = anchorSize;
				}
				for (int i = 0; i < loopSize; i++)

				{
					ReusableMethods.scrollIntoView(anchor.get(i), driver);
					System.out.println(anchor.get(i).getText());
					data.add(anchor.get(i).getText());
					for (int j = count; j < count + (loopSize * 6) / loopSize; j++) {
						System.out.println(paragraph.get(j).getText());
						data.add(paragraph.get(j).getText());
					}
					// data.add(viewAbstract.get(i).getText());
					wait.until(ExpectedConditions.elementToBeClickable(viewAbstract.get(i)));
					viewAbstract.get(i).click();
					IntegrationCommon.isWebElementDisplayed(driver, firstLookPaperAbstractHeading);
					ScreenshotUtil.takeScreenshotForAllure(driver);
					driver.navigate().back();
					WebElement firstLookTab = getElement(firstLookPapersTab);
					/* wait.until(ExpectedConditions.) */
					Thread.sleep(600);
					ReusableMethods.scrollIntoView(firstLookTab, driver);
					firstLookTab.click();
					anchor = getElements(firstLookPaperNameList);
					paragraph = getElements(firstLookPaperDetailsList);
					viewAbstract = getElements(firstLookPaperViewAbstractList);
					count += 6;
				}
			}
			return data;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Adding the First look Papers in cart
	 * 
	 * @return True/false
	 */
	public boolean AddProductToCartAndVerifyOnCartPage() {
		try {
			List<WebElement> addToCart = getElements(firstLookPaperAddToCart);
			if (loopSize > anchorSize) {
				loopSize = anchorSize;
			}

			for (int i = 0; i < loopSize; i++)

			{
				ReusableMethods.scrollIntoView(anchor.get(i), driver);
				System.out.println(anchor.get(i).getText());
				wait.until(ExpectedConditions.elementToBeClickable(addToCart.get(i)));
				addToCart.get(i).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartLink));
				ReusableMethods.scrollIntoView(getShoppingCart(), driver);
				if (i < loopSize - 1) {
					getElement(shoppingCartLinkClose).click();
				}
			}
			getShoppingCart().click();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Creating list of All First look Paper Name
	 * 
	 * @return List
	 */
	public List<String> getFirsLookPaperName() {
		List<String> data = new ArrayList<String>();
		try {
			anchor = getElements(firstLookPaperNameList);

			if (loopSize > anchorSize) {
				loopSize = anchorSize;
			}
			for (int i = 0; i < loopSize; i++) {
				ReusableMethods.scrollIntoView(anchor.get(i), driver);
				System.out.println(anchor.get(i).getText());
				data.add(anchor.get(i).getText());
			}
			return data;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * This method get the List from Astm Cart Page
	 * 
	 * @return List of First look Papers
	 */
	public List<String> getFirstLookPaperProductListFromASTMCartPage() {
		try {
			List<String> data = new ArrayList<String>();

			if (loopSize > anchorSize) {
				loopSize = anchorSize;
			}
			for (int i = 0; i < loopSize; i++) {
				wait.until(ExpectedConditions.visibilityOf(astmCartPage.getWebElementsForCartItems().get(i)));
				System.out.println(astmCartPage.getWebElementsForCartItems().get(i).getText());
				data.add(astmCartPage.getWebElementsForCartItems().get(i).getText());
			}
			return data;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * This method is clicking on Issue tab on Journals page
	 * @return True/false base on click of link of issue tab
	 */
	public boolean clickIssueTab() {
		
		try {
			 ReusableMethods.scrollIntoView(getElement(issuesTab), driver);
			 ScreenshotUtil.takeScreenshotForAllure(driver);
			 getElement(issuesTab).click();
			 return true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	/**
	 * This method is clicking on Subscription tab on Journals page
	 * @return True/false base on click of link of Subscription tab
	 */
	
public boolean clickSubscriptionTab() {
		
		try {
			 ReusableMethods.scrollIntoView(getElement(subscriptionTab), driver);
			 ScreenshotUtil.takeScreenshotForAllure(driver);
			 WaitStatementUtils.waitForElementToBeClickable(driver,getElement(subscriptionTab),5);
			 getElement(subscriptionTab).click();
			 return true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	/**
	 * This method is clicking on issue link in Issue tab on Journals page
	 * @return True/false base on click of link of issue tab
	 */
	public boolean clickIssueLinkInIssueTab() {
		
		try {
			 ReusableMethods.scrollIntoView(getElement(issueLinks), driver);
			 ScreenshotUtil.takeScreenshotForAllure(driver);
			 getElement(issueLinks).click();
			 return true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	public boolean clickIssueLink(WebElement element) {

		try {
			ReusableMethods.scrollIntoView(element, driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			element.click();
			return true;
		}

		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}


	}

	@Step("Add Journal product to cart from Subscriptions tab")
	public void addAnyJournalProductToCartFromSubscriptionsTab(String JournalName) {
		try{
			openJournalProductPage(JournalName);
			switchToSubscriptionTabOfJournal();
			clicksubscriptionAddToCartBtn();
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Add Journal product to cart ", e);
		}
	}

	@Step("Add Journal product to cart from Issues tab")
	public String addAnyJournalProductToCartFromIssuesTab(String JournalName) {
		try{
			openJournalProductPage(JournalName);
			switchToIssueTabOfJournal();
			getElement(firstJournalIssue).click();
			PublicCommon.waitForSec(5);
			WebElement ele=driver.findElement(By.xpath("(//button[@title='Add to Cart'])[1]/ancestor::div[@class='mt-3 d-flex']/preceding-sibling::div[1]/a"));
			String selectedJournalDescription=ele.getText();
			clickAddToCartBtn();
			return selectedJournalDescription;
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Add Journal product to cart ", e);
			return "EMPTY";
		}
	}

	@Step("Open Journal '{productName}' page")
	public void openJournalProductPage(String productName) {
		try {
			ReusableMethods.scrollIntoView(getElement(getJournalByName(productName)), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(getJournalByName(productName)),5);
			clickOnMethod("Journal Link", getElement(getJournalByName(productName)));
		} catch (IOException e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to open journal", e);
		}
	}

	@Step("Switch to subscription tab of journal")
	public void switchToSubscriptionTabOfJournal() {
		Assert.assertTrue(clickSubscriptionTab(), "Clicked on Issue tab.");
	}

	@Step("Switch to issue tab of journal")
	public void switchToIssueTabOfJournal() {
		WaitStatementUtils.waitForElementToBeClickable(driver, getElement(issuesTab));
		clickIssueTab();
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("#issues"));
		Assert.assertTrue(driver.getCurrentUrl().contains("#issues"));
	}

	@Step("Click on given issue link in issue tab page  of journal")
	public void clickTheGivenIssueLinkOfIssueTab(Boolean click) {
		Assert.assertTrue(click, "Clicked on Issue link in Issue tab.");
	}




}