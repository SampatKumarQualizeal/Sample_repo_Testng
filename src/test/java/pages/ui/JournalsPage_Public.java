package pages.ui;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import io.qameta.allure.Step;

public class JournalsPage_Public extends BasePage {
	
	public JournalsPage_Public(WebDriver driver) {
		super(driver);
		
	}	
	public By IntroductionAndSummaryLink=By.xpath("//*[contains(text(),'Introduction')]");
	public By journalsHeader = By.xpath("//*[@class='card-body landing-intro']/*[text()='Journals']");
	public By issueLink1 = By.xpath("//a[@id='issues-tab']");
	public By volumeLink1 = By.xpath("//a[contains(text(),'Volume 5 Issue 2 Special Issue on Education and Cu')]");
	public By STPIndividualArticleDownloadLink=By.xpath("//*[contains(text(),'STP Individual Article Download')]");
	public By updatedSmartAndSustainableManufacturing=By.xpath("//*[contains(text(),'Smart and Sustainable Manufacturing Systems Individual Paper')]");
	public By AdvancesInCivilEngineering=By.xpath("//*[contains(text(),'Advances in Civil Engineering Materials Individual Paper')]");
	public By MaterialPerformanceAndCharacterization=By.xpath("//*[contains(text(),'Materials Performance and Characterization Individual Paper')]");
	public By JournalOfTestingAndEvaluationAuthorIndex=By.xpath("//*[contains(text(),'Journal of Testing and Evaluation Author Index to Volume 17 1989')]");
	public By GeotechnicalTestingJournalIndex=By.xpath("//*[contains(text(),'Geotechnical Testing Journal Index to Volume 8 1985')]");
	public By viewPdfSSMS=By.xpath("//button[text()='View PDF']");
	public  By JournalsLinksinJournalPage = By.cssSelector(".journals-blocks p a");

	private By journalsCardHeader = By.xpath("//*[@class='card astm-card landing-header']//*[@class='card-title astm-type-heading--h3']");
	private By journalsCardText = By.xpath("//*[@class='card astm-card landing-header']//*[@class='card-text']");
	private By journalsImage = By.xpath("//img[contains(@src,'womanLab.jpg')]");
	private By findAnAuthorButton = By.xpath("//a[contains(text(),'Find an author')]");
	public By openAccessPolicyButton = By.xpath("//a[contains(text(),'Open access policy')]");
	private By belowImageContent = By.xpath("//*[@class='landing-page']//*[contains(text(),'All journal papers are peer reviewed and are abstr')]");
	private By ssmsImage= By.xpath("//img[contains(@src ,'ssms-cover.png')]");
	
	private By ssmsLink  = By.linkText("Smart and Sustainable Manufacturing Systems (SSMS)");
			
	private By ssmsDesc =By.xpath("//*[contains(text(),'This journal fosters transdisciplinary research')]");
	private By acemImage = By.xpath("//img[contains(@src, 'acem-web.jpg')]");
	public By acemLink= By.linkText("Advances in Civil Engineering Materials (ACEM)");
	private By acemDesc =By.xpath("//*[contains(text(),\"ASTM's premier civil engineering journal, covering\")]");
	
	private By mpcImage = By.xpath("//img[contains(@src,'mpc-web.jpg')]");
	private By mpcLink = By.linkText("Materials Performance and Characterization (MPC)");
	private By mpcDesc =By.xpath("//*[contains(text(),\"ASTM's premier materials journal, covering theoret\")]");
	private By joteImage = By.xpath("//img[contains(@src,'jte-web.jpg')]");
	private By joteLink = By.linkText("Journal of Testing and Evaluation (JOTE)");
	private By joteDesc =By.xpath("//*[contains(text(),'Presents new information, derived from field and l')]");
	private By gtjImage = By.xpath("//img[contains(@src,'gtj-web.jpg')]");
	private By gtjLink = By.linkText("Geotechnical Testing Journal (GTJ)");
	private By gtjDesc = By.xpath("//*[contains(text(),'Addresses new developments in soil and rock testin')]");
	private By jaiImage = By.xpath("//img[contains(@src,'jai_cover.png')]");
	private By jaiLink = By.linkText("Journal of ASTM International (JAI) 2004-2012 Backfile");
	private By jaiDesc = By.xpath("//p[contains(text(),'Provides the results of original research and crit')]");
	private By jofsImage = By.xpath("//img[contains(@src,'jofs_cover.png')]");
	private By jofsLink = By.linkText("Journal of Forensic Sciences (JOFS) 1972-2005 Backfile");
	private By jofsDesc = By.xpath("//*[contains(text(),'Includes original investigations, observations, sc')]");
	private By ccaImage = By.xpath("//img[contains(@src,'cca_cover.png')]");
	public By ccaLink =  By.linkText("Cement, Concrete and Aggregates (CCA) 1979-2004 Backfile");
	private By ccaDesc =By.xpath("//p[contains(text(),'Discusses the properties of concrete and its const')]");
	private By jctrImage = By.xpath("//img[contains(@src,'jctr_cover.png')]");
	private By jctrLink = By.linkText("Journal of Composites, Technology & Research (JCTR) 1978-2003 Backfile");
	private By jctrDesc = By.xpath("//*[contains(text(),'Addresses composite materials and their response t')]");
	//Integration
	public By HeaderImage = By.xpath("//img[@alt='Advances in Civil Engineering Materials']");
	public By CCAHeaderImage = By.xpath("//img[@alt='Cement, Concrete and Aggregates 1979-2004 Backfile']");
	public By Header = By.xpath("//h3[@class='astm-type-heading--h3']");
	public By authorInstructionTab = By.id("author-instructions-tab");
	public By editorialBoardTab = By.id("editorial-board-tab");
	public By authorInstructionHeader = By.xpath("//h1[contains(text(), 'Author Instructions')]");
	public By editorialHeader = By.xpath("//h1[contains(text(), 'Editorial Board')]");
	public By coEditorsHeader = By.xpath("//h2[contains(text(), 'Co-Editors')]");
	public By editorialBoardMembers = By.xpath("//h2[contains(text(), 'Board Members')]");
	public By editorInChiefHeader = By.xpath("//h1[contains(text(), 'Editorial Board')]");
	public By relatedSubSectionHeader = By.xpath("//h6[contains(text(), 'Related')]");
	public By detailsSubSectionHeader = By.xpath("//h6[contains(text(), 'Details')]");
	public By indexedInSubSectionHeader = By.xpath("//h6[contains(text(), 'Indexed In')]");
	
	public By licenseAgreement = By.xpath("//a[contains(text(), 'ASTM License Agreement') and @class='mb-2']");
	public By journalsList = By.xpath("//div[contains(@class,'journals-block')]//p/a");
	public By JournalACEM = By.xpath("//div[contains(@class,'journals-block')]//p/a[contains(text(),'Advances in Civil Engineering Materials')]");
	public By authorInstructionsList = By.xpath("//div[@id='author-instructions']//a");
	public By authorHeader = By.xpath("//h1[contains(text(), 'Publish with ASTM')]");
	public By leftNavLinks = By.cssSelector("*[class*='astm-nav-tabs'] a");
	public By publishedOnlinelabel=By.xpath("//p/b[text()='Published Online']");
	public By viewAbstaractButton=By.xpath("//button[text()='View Abstract']");
	public By issueLink=By.xpath("//div[@class='mt-3']/a");
	public By pageCountlabels=By.xpath("//p/b[text()='Page Count']");
	public By publishOnlinelabel=By.xpath("//span[contains(text(),'Published Online')]");
	public By priceOnAttributePage=By.xpath("//*[@class=\"price\"]");
	public By FreePriceOnAttributePage=By.xpath("//*[@class=\"astm-type-body mb-3\"]");
	public By journalUpdatedHrfLink=By.xpath("//*[contains(text(),'UPDATED')]");
	public String JournalsLinks = "(//div[contains(@class,'journals-blocks')]//p/a)[INDEX]";

	public By getJournalsLink(int index){
		return By.xpath(JournalsLinks.replace("INDEX", Integer.toString(index)));
	}
	
	public By getPublishedLocatorByText(String value)
	{
		String path="//a[contains(text(),'"+value+"')]/../p/b[text()='Published Online']/..";
		return By.xpath(path);
	}
	
	public WebElement getIssueLink1() {
		return getElement(issueLink1);
	}
	public By getProductByText(String value)
	{
		String path="//a[contains(text(),'"+value+"')]/../following-sibling::div/button[text()='View Abstract']";
		return By.xpath(path);
	}

	public By getJournalByName(String value)
	{
		String path="//a[contains(text(),'"+value+"')]";
		return By.xpath(path);
	}

	public By getJournalAbstractBtn(String value){
		return By.xpath("//a[contains(text(),'"+value+"')]/../following-sibling::div[1]//*[contains(text(),'View Abstract')]");
	}

	public By getJournalAddToCartBtn(String value){
		return By.xpath("//a[contains(text(),'"+value+"')]/../following-sibling::div[1]//*[contains(text(),'Cart')]");
	}

	public By getJournalPDFBtn(String value){
		return By.xpath("//a[contains(text(),'"+value+"')]/../following-sibling::div[1]//*[contains(text(),'PDF')]");
	}

	public By getJournalPrice(String value){
		return By.xpath("//a[contains(text(),'"+value+"')]/../p/b[text()='Price']/..");
	}

	public By getProductAttributeLocatorByText(String product, String attribute)
	{
		String path="//a[contains(text(),'"+product+"')]/../p/b[text()='"+attribute+"']/..";
		return By.xpath(path);
	}

	public By getAuthorByText(String value)
	{
		String path="//a[contains(text(),'"+value+"')]/following-sibling::p[@class='m-0 mt-2']";
		return By.xpath(path);
	}

	public List<WebElement> getLeftNavLinks() { return
			  getElements(leftNavLinks); }
	
	public WebElement getLink(String partialLinkText ) {
		By link = By.partialLinkText(partialLinkText);
		return getElement(link);
	}
	
	
	public WebElement getbelowImageContent() {
		return getElement(belowImageContent);
	}
	
	
	public WebElement getfindAnAuthorButton() {
		return getElement(findAnAuthorButton);
	}
	
	public WebElement getopenAccessPolicyButton() {
		return getElement(openAccessPolicyButton);
	}
	
	public List<WebElement> getJournalsListElements() { return
			  getElements(journalsList); }

	public WebElement JournalACEM(){
		return getElement(JournalACEM);
	}
	
	
	
	public WebElement getjournalsCardHeader() {
		return getElement(journalsCardHeader);
	}
	
	public WebElement getjournalsCardContentElement() {
		return getElement(journalsCardText);
	}
	
	public WebElement getjournalsImage() {
		return getElement(journalsImage);
	}
	
	public List<WebElement> getList() {
		return getElements(authorInstructionsList);
	}
	
	/**
	 * this method is checking header content
	 * @return True/False based on header validation
	 */
	@Step("Validate navigation to the \\\"Journals\\\" from \\\"Homepage\\\".")
	public String checkHeaderTitleOnJournals() {
		
	      String Header_text= "";
	
		try {
		
		   Header_text = getjournalsCardHeader().getText();
		}
		   
		catch(Exception e) {
			e.printStackTrace();
		}
		
	return Header_text;
	}
	
	/**
	 * this method is checking header image is displayed or not
	 * @return True/false based on image validation
	 */
	
	@Step("Verify  Header Image of the \"Journals\" landing page.")
	public boolean checkHeaderimageOnJournals() {
	
		try {
		  return getjournalsImage().isDisplayed() ;
		
		}			
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	 * this method is checking header Text on Journals page
	 * @return True/false based on image validation
	 */
	
	@Step("Verify Header text of the \"Journals\" landing page.")
	public String checkHeaderTextOnJournals() {
		
		String Header_Content="";
		try {

		Header_Content= getjournalsCardContentElement().getText();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return Header_Content;
	}
	/**
	 * This method is  FindAnAuthorButton is visible or not 
	 * @return True/False based on visibility of button
	 *	
	 */
	
	@Step("Validate the \"FIND AN AUTHOR\" button is present")
	public boolean checkFindAnAuthorButtonIsVisible() {    
		try {
			
			WaitStatementUtils.explicitWaitForVisibility(driver, getfindAnAuthorButton());
			return getfindAnAuthorButton().isDisplayed();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		
		/**
		 * This method is getting  below image text
		 * @return True/False based on visibility of text
		 *	
		 */
		
		@Step("Validate the text under the Header Image of the Journals landing page.")
		public String getBelowImageText() {

			try {
				
				 return getbelowImageContent().getText();  	
			}
			catch(Exception e) {
				e.printStackTrace();
				return null ;
				
			}
			
	}
		
	
	/**
	 * This method is checking  open Access Policy button  is visible or not 
	 * @return True/False based on visibility of button
	 *	
	 */
	
	@Step("Validate the \"OPEN ACCESS POLICIES\" button is present ")
	public boolean checkopenAccessPolicyButtonIsVisible() {    
		try {
			
			WaitStatementUtils.explicitWaitForVisibility(driver, getopenAccessPolicyButton());
			return getopenAccessPolicyButton().isDisplayed();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	/**
	 * This method is checking visibility of Image ACEM journal
	 * @return True/false base on visibility of Image of ACEM
	 */
	@Step("Validate the image of the ACEM Journal. ")
	public boolean checkVisibilityOfImageOfAcem() {
		
		try {
			 return getElement(acemImage).isDisplayed();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	/**
	 * This method is clicking on the ACEM title on Journals Home page
	 * @return True/false base on click of link of ACEM
	 */
	public boolean clickACEM() {
		
		try {
			 ReusableMethods.scrollIntoView(getElement(acemLink), driver);
			 ScreenshotUtil.takeScreenshotForAllure(driver);
			 getElement(acemLink).click();
			 return true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	/**
	 * This method is checking visibility of link text of ACEM title
	 * @return True/false base on visibility of link of ACEM title
	 */
	@Step("Validate the link text of  ACEM journal ")
	public boolean checkVisibilityOfLinkTextOfAcem() {
		
		try {
			 return getElement(acemLink).isDisplayed();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	/**
	 * This method is getting text of  description of ACEM title
	 * 
	 */
	@Step("Validate description of ACEM journal")
	public String checkDescriptionOfAcem() {
		
		String text ="";
		try {
			 text = getElement(acemDesc).getText();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return text ;
		
		
	}
	
	/**
	 * This method is checking visibility of Image MPC title
	 * @return True/false base on visibility of Image of MPC title
	 */
	@Step("Validate Image of MPC journal ")
	public boolean checkVisibilityOfImageOfMpc() {
		
		try {
			 return getElement(mpcImage).isDisplayed();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	/**
	 * This method is clicking on the MPC title on Journals Home page
	 * @return True/false base on click of link of MPC
	 */
	public boolean clickMPC() {
		
		try {
			 ReusableMethods.scrollIntoView(getElement(mpcLink), driver);
			 ScreenshotUtil.takeScreenshotForAllure(driver);
			 getElement(mpcLink).click();
			 return true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	/**
	 * This method is checking visibility of link text of MPC title
	 * @return True/false base on visibility of link of MPC title
	 */
	@Step("Validate link text of MPC journal ")
	public boolean checkVisibilityOfLinkTextOfMpc() {
		
		try {
			 return getElement(mpcLink).isDisplayed();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	/**
	 * This method is getting text of  description of MPC title
	 * 
	 */
	@Step("Validate description of MPC journal ")
	public String checkDescriptionOfMpc() {
		
		String text ="";
		try {
			 text = getElement(mpcDesc).getText();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return text ;
		
		
	}
	
	/**
	 * This method is checking visibility of Image SSMS title
	 * @return True/false base on visibility of Image of SSMS
	 */
	@Step("Validate Image of SSMS Journals ")
	public boolean checkVisibilityOfImageOfSsms() {
		
		try {
			 return getElement(ssmsImage).isDisplayed();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	
	
	/**
	 * This method is clicking on the SSMS title on Journals Home page
	 * @return True/false base on click of link of SSMS
	 */
	public boolean clickSSMS() {
		
		try {
			 ReusableMethods.scrollIntoView(getElement(ssmsLink), driver);
			 ScreenshotUtil.takeScreenshotForAllure(driver);
			 getElement(ssmsLink).click();
			 return true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	/**
	 * This method is checking visibility of link text of SSMS title
	 * @return True/false base on visibility of link of SSMS
	 */
	@Step("Validate link text of SSMS Journal ")
	public boolean checkVisibilityOfLinkTextOfSsms() {
		
		try {
			 return getElement(ssmsLink).isDisplayed();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	/**
	 * This method is checking text of  description of SSMS Journal
	 * 
	 */
	@Step("Validate description of SSM journal  ")
	public String checkDescriptionOfSsms() {
		
		String text ="";
		try {
			 text = getElement(ssmsDesc).getText();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return text ;
		
		
	}
	
	/**
	 * This method is checking visibility of Image JOTE Journal
	 * @return True/false base on visibility of Image of JOTE Journal
	 */
	@Step("Validate Image of JOTE Journal ")
	public boolean checkVisibilityOfImageOfJOTE() {
		
		try {
			 return getElement(joteImage).isDisplayed();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	/**
	 * This method is checking link text of JOTE title
	 * @return True/false base on visibility of link of JOTE
	 */
	@Step("Validate link text of JOTE Journal ")
	public boolean checkVisibilityOfLinkTextOfJOTE() {
		
		try {
			 return getElement(joteLink).isDisplayed();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	/**
	 * This method is clicking on the JOTE title on Journals Home page
	 * @return True/false base on click of link of JOTE
	 */
	public boolean clickJOTE() {
		
		try {
			 ReusableMethods.scrollIntoView(getElement(joteLink), driver);
			 ScreenshotUtil.takeScreenshotForAllure(driver);
			 getElement(joteLink).click();
			 return true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	
	
	/**
	 * This method is checking  description of JOTE title
	 * 
	 */
	@Step("Validate description of JOTE journal  ")
	public String checkDescriptionOfJOTE() {
		
		String text ="";
		try {
			 text = getElement(joteDesc).getText();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return text ;
			
	}

	/**
	 * This method is checking visibility of Image JAI Journal
	 * @return True/false base on visibility of Image of JAI Journal
	 */
	@Step("Validate Image of JAI Journal ")
	public boolean checkVisibilityOfImageOfJAI() {
		
		try {
			 return getElement(jaiImage).isDisplayed();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	/**
	 * This method is clicking on the JAI title on Journals Home page
	 * @return True/false base on click of link of JAI Backfile
	 */
	public boolean clickJAI() {
		
		try {
			 ReusableMethods.scrollIntoView(getElement(jaiLink), driver);
			 ScreenshotUtil.takeScreenshotForAllure(driver);
			 getElement(jaiLink).click();
			 return true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	
	/**
	 * This method is checking link text of JAI title
	 * @return True/false base on visibility of link of JAI
	 */
	@Step("Validate link text of JAI Journal ")
	public boolean checkVisibilityOfLinkTextOfJAI() {
		
		try {
			 return getElement(jaiLink).isDisplayed();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}
	
	/**
	 * This method is checking  description of JAI title
	 * 
	 */
	@Step("Validate description of JAI journal  ")
	public String checkDescriptionOfJAI() {
		
		String text ="";
		try {
			 text = getElement(jaiDesc).getText();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return text ;
	}
	
	
	
/**
 * This method is checking visibility of Image JOFS Journal
 * @return True/false base on visibility of Image of JOFS Journal
 */
@Step("Validate Image of JOFS Journal ")
public boolean checkVisibilityOfImageOfJOFS() {
	
	try {
		 return getElement(jofsImage).isDisplayed();
	}
	
	catch(Exception e) {
		e.printStackTrace();
		return false ;
	}
	
	
}

/**
 * This method is clicking on the JOFS title on Journals Home page
 * @return True/false base on click of link of JOFS
 */
public boolean clickJOFS() {
	
	try {
		 ReusableMethods.scrollIntoView(getElement(jofsLink), driver);
		 ScreenshotUtil.takeScreenshotForAllure(driver);
		 getElement(jofsLink).click();
		 return true;
	}
	
	catch(Exception e) {
		e.printStackTrace();
		return false ;
	}
	
	
}

/**
 * This method is checking link text of JOFS title
 * @return True/false base on visibility of link of JOFS
 */
@Step("Validate link text of JOFS Journal ")
public boolean checkVisibilityOfLinkTextOfJOFS() {
	
	try {
		 return getElement(jofsLink).isDisplayed();
	}
	
	catch(Exception e) {
		e.printStackTrace();
		return false ;
	}
	
	
}

/**
 * This method is checking  description of JOFS title
 * 
 */
@Step("Validate description of JOFS journal  ")
public String checkDescriptionOfJOFS() {
	
	String text ="";
	try {
		 text = getElement(jofsDesc).getText();
	}
	
	catch(Exception e) {
		e.printStackTrace();
		
	}
	return text ;
		
}
/**
 * This method is checking visibility of Image CCA Journal
 * @return True/false base on visibility of Image of CCA Journal
 */
@Step("Validate Image of CCA Journal ")
public boolean checkVisibilityOfImageOfCCA() {
	
	try {
		 return getElement(ccaImage).isDisplayed();
	}
	
	catch(Exception e) {
		e.printStackTrace();
		return false ;
	}
	
	
}


/**
 * This method is clicking on the CCA title on Journals Home page
 * @return True/false base on click of link of CCA Backfile
 */
public boolean clickCCA() {
	
	try {
		 ReusableMethods.scrollIntoView(getElement(ccaLink), driver);
		 ScreenshotUtil.takeScreenshotForAllure(driver);
		 getElement(ccaLink).click();
		 return true;
	}
	
	catch(Exception e) {
		e.printStackTrace();
		return false ;
	}
	
	
}

/**
 * This method is checking link text of CCA title
 * @return True/false base on visibility of link of CCA
 */
@Step("Validate link text of CCa Journal ")
public boolean checkVisibilityOfLinkTextOfCCA() {
	
	try {
		 return getElement(ccaLink).isDisplayed();
	}
	
	catch(Exception e) {
		e.printStackTrace();
		return false ;
	}
	
	
}

/**
 * This method is checking  description of CCA title
 * 
 */
@Step("Validate description of CCA journal")
public String checkDescriptionOfCCA() {
	
	String text ="";
	try {
		 text = getElement(ccaDesc).getText();
	}
	
	catch(Exception e) {
		e.printStackTrace();
		
	}
	return text ;
	
}
/**
 * This method is checking visibility of Image GTJ Journal
 * @return True/false base on visibility of Image of GTJ Journal
 */
@Step("Validate Image of Gtj Journal ")
public boolean checkVisibilityOfImageOfGtj() {
	
	try {
		 return getElement(gtjImage).isDisplayed();
	}
	
	catch(Exception e) {
		e.printStackTrace();
		return false ;
	}
	
	
}

/**
 * This method is checking link text of GTJ title
 * @return True/false base on visibility of link of GTJ
 */
@Step("Validate link text of GTJ Journal ")
public boolean checkVisibilityOfLinkTextOfGtj() {
	
	try {
		 return getElement(gtjLink).isDisplayed();
	}
	
	catch(Exception e) {
		e.printStackTrace();
		return false ;
	}
	
	
}

/**
 * This method is clicking on the GTJ title on Journals Home page
 * @return True/false base on click of link of GTJ
 */
public boolean clickGTJ() {
	
	try {
		 ReusableMethods.scrollIntoView(getElement(gtjLink), driver);
		 ScreenshotUtil.takeScreenshotForAllure(driver);
		 getElement(gtjLink).click();
		 return true;
	}
	
	catch(Exception e) {
		e.printStackTrace();
		return false ;
	}
	
	
}

/**
 * This method is checking  description of GTJ title
 * 
 */
@Step("Validate description of GTJ journal  ")
public String checkDescriptionOfGtj() {
	
	String text ="";
	try {
		 text = getElement(gtjDesc).getText();
	}
	
	catch(Exception e) {
		e.printStackTrace();
		
	}
	return text ;
	
}
/**
 * This method is checking visibility of Image JCTR Journal
 * @return True/false base on visibility of Image of JCTR Journal
 */
@Step("Validate Image of JCTR Journal ")
public boolean checkVisibilityOfImageOfJCTR() {
	
	try {
		 return getElement(jctrImage).isDisplayed();
	}
	
	catch(Exception e) {
		e.printStackTrace();
		return false ;
	}
	
	
}

/**
 * This method is clicking on the JCTR title on Journals Home page
 * @return True/false base on click of link of JCTR Backfile
 */
public boolean clickJCTR() {
	
	try {
		 ReusableMethods.scrollIntoView(getElement(jctrLink), driver);
		 ScreenshotUtil.takeScreenshotForAllure(driver);
		 getElement(jctrLink).click();
		 return true;
	}
	
	catch(Exception e) {
		e.printStackTrace();
		return false ;
	}
	
	
}

/**
 * This method is checking link text of JCTR title
 * @return True/false base on visibility of link of JCTR
 */
@Step("Validate link text of JCTR Journal ")
public boolean checkVisibilityOfLinkTextOfJCTR() {
	
	try {
		 return getElement(jctrLink).isDisplayed();
	}
	
	catch(Exception e) {
		e.printStackTrace();
		return false ;
	}
	
	
}

/**
 * This method is checking  description of JCTR title
 * 
 */
@Step("Validate description of JCTR journal  ")
public String checkDescriptionOfJCTR() {
	
	String text ="";
	try {
		 text = getElement(jctrDesc).getText();
	}
	
	catch(Exception e) {
		e.printStackTrace();
		
	}
	return text ;
	
}

/**
 * This method is checking  description of JOTE title
 * 
 */
public String checkHeaderText() {
	
	String text ="";
	try {
		 text = getElement(Header).getText();
	}
	
	catch(Exception e) {
		e.printStackTrace();
		
	}
	return text ;
		
}
}
	


