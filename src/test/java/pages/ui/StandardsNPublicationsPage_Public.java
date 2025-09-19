package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;

public class StandardsNPublicationsPage_Public extends BasePage {
	
	public StandardsNPublicationsPage_Public(WebDriver driver) {
		super(driver);
	
	}
	
	public By standardsAndPublicationHeader = By.xpath("//section[@class='landing-page']//h1[@class='astm-type-heading--h1'][contains(text(),'Standards & Publications')]"); 
    private By textUnderSAPHeader = By.xpath("//p[contains(text(),\"Search ASTM's 13,000+ Standards\")]");
    private By standardsAndProductsBoxTitle = By.xpath("//h3[contains(text(),' Standards Products')]");
    private By standardsAndProductsBoxLink = By.partialLinkText("Browse ASTM Standards, Adjuncts");
    private By standardsAndProductsBoxImage = By.xpath("//img[contains(@src,'book-icon.png')]");
    private By enterpriseSolutionsBoxTitle = By.xpath("//h3[contains(text(),' Enterprise Solutions')]");
    private By enterpriseSolutionsBoxImage = By.xpath("//img[contains(@src,'lab-wht-md.png')]");
    private By enterpriseSolutionsBoxLink  = By.partialLinkText("Customize your company's access");
    public By digitalLibraryBoxTitle = By.xpath("//h5[@class='astm-type-heading--h'][contains(text(),'Digital Library')]");
    private By digitalLibraryBoxLink  = By.partialLinkText("Discover the ASTM Digital Library.");
    public By symposiaPapersAndStpsBoxTitle = By.xpath("//h5[@class='astm-type-heading--h'][contains(text(),'Symposia Papers & STPs')]");
    private By symposiaPapersAndStpsBoxLink = By.partialLinkText("Discover the latest engineering research");
    public By manualMonographsAndDataSeriesBox= By.xpath("//h5[contains(text(),'Manuals, Monographs, & Data Series')]");
    private By manualMonographsAndDataSeriesLink = By.partialLinkText("Get practical, hands-on guidance, data");
    public By journalsBox = By.xpath("//h5[@class='astm-type-heading--h'][contains(text(),'Journals')]");
    private By journalsBoxLink = By.partialLinkText("Explore developments in testing and evaluation");
    private By journalsLink = By.linkText("Journals");
    public By addToCartLink=By.xpath("//button[@class='btn astm-btn astm-btn--small btn-primary btn-block']");
    public By shoppingCart=By.xpath("//a[contains(text(),'shopping cart')]");
    public By checkoutLink=By.xpath("//span[text()='Checkout']");
   
      public WebElement getstandardsAndProductsBoxTitle() {
		return getElement(standardsAndProductsBoxTitle);
	}
	
    
    
    /**
     * This method Checks header of 'Standards and Publication' page.
     * @return True/false based on visibility of header.
     */
    @Step("Check 'Standards&Publications' Header text")
    public String checkstandardsAndPublicationsHeader() {
    	
    	
    		try {
    			return getElement(standardsAndPublicationHeader).getText();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return null;// TODO: handle exception
    		}	
    }
    
    /**
     * This method checks text under header of Standards and Publication page.
     * @return True/false based on visibility of header.
     */
    @Step("Check text under 'Standards&Publications' Header")
    public String checkTextUnderstandardsNPublicationsHeader() {
    	
    		try {
    			return getElement(textUnderSAPHeader).getText();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return null;// TODO: handle exception
    		}	
    }
    /**
     * This method checks header of Standards Products box.
     * @return True/false based on visibility of header.
     */
    @Step("Check 'Standards Products' Header text")
    public String checkstandardsProductsHeader() {
    		try {
    			return getElement(standardsAndProductsBoxTitle).getText();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return null;// TODO: handle exception
    		}	
    		
    }
    
    /**
     * This method checks link text under header of Standards Products box.
     * @return True/false based on visibility of header.
     */
    @Step("Check text under 'Standards Products' Header text")
    public String checkTextUnderStandardsProductsHeader() {
    		try {
    		
    			return getElement(standardsAndProductsBoxLink).getText();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return null;// TODO: handle exception
    		}	
    }
    
    /**
     * This method checks image of  Standards Products box.
     * @return True/false based on visibility of header.
     */
    @Step("Check image of  'Standards Products' Box")
    public boolean checkImageOfStandardsProductsBox( ) {
    		try {
    			
    			return getElement(standardsAndProductsBoxImage).isDisplayed();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return false;// TODO: handle exception
    		}	
    }
    /**
     * This method checks header of Digital Library box.
     * @return True/false based on visibility of header.
     */
    @Step("Check 'Digital Library' Header text")
    public String checkDigitallibraryHeader() {
    		try {
    			return getElement(digitalLibraryBoxTitle).getText();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return null;// TODO: handle exception
    		}	
    		
    }
    
    /**
     * This method checks link text under header of Digital Library box.
     * @return True/false based on visibility of header.
     */
    @Step("Checks text under 'Digital Library' Header")
    public String checkTextUnderDigitalLibraryHeader() {
    		try {
    			return getElement(digitalLibraryBoxLink).getText();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return null;// TODO: handle exception
    		}	
    }
    
    /**
     * This method checks image of  Enterprise Solutions box.
     * @return True/false based on visibility of header.
     */
    @Step("Check image of  Enterprise Solutions Box")
    public boolean checkImageOfEnterpriseSolutionsBox( ) {
    		try {
    			
    			return getElement(enterpriseSolutionsBoxImage).isDisplayed();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return false;// TODO: handle exception
    		}	
    }
    /**
     * This method checks header of Symposia, Papers & STPs box.
     * @return True/false based on visibility of header.
     */
    @Step("Check 'Symposia, Papers & STPs' Header text")
    public String checkSymposiaPapersnSTPsHeader() {
    		try {
    			return getElement(symposiaPapersAndStpsBoxTitle).getText();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return null;// TODO: handle exception
    		}	
    		
    }
    
    /**
     * This method checks link text under header of Symposia, Papers & STPs box.
     * @return True/false based on visibility of header.
     */
    @Step("Check text under 'Symposia, Papers & STPs' Header")
    public String checkTextUnderSymposiaPapersnSTPsHeader() {
    		try {
    			return getElement(symposiaPapersAndStpsBoxLink).getText();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return null;// TODO: handle exception
    		}	
    }
    
    /**
     * This method checks header of 'Manuals, Monographs & Data Series' box.
     * @return True/false based on visibility of header.
     */
    @Step("Check 'Manuals, Monographs & Data Series' Header text")
    public String checkManualsMonographsNDataSeriesHeader() {
    		try {
    			return getElement(manualMonographsAndDataSeriesBox).getText();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return null;// TODO: handle exception
    		}	
    		
    }
    
    /**
     * This method checks link text under header of Manuals, Monographs & Data Series box.
     * @return True/false based on visibility of header.
     */
    @Step("Check text under 'Manuals, Monographs & Data Series' Header")
    public String checkTextUnderManualsMonographsNDataSeriesHeader( ) {
    		try {
    			return getElement(manualMonographsAndDataSeriesLink).getText();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return null;// TODO: handle exception
    		}	
    }
    /**
     * This method checks header of 'Journals' box.
     * @return True/false based on visibility of header.
     */
    @Step("Check 'Journals' Header text")
    public String checkJournalsHeader() {
    		try {
    			return getElement(journalsBox).getText();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return null;// TODO: handle exception
    		}	
    		
    }
    
    /**
     * This method checks link text under header of 'Journals' box.
     * @return True/false based on visibility of header.
     */
    @Step("Check text under 'Journals' Header")
    public String checkTextUnderJournalsHeader( ) {
    		try {
    			return getElement(journalsBoxLink).getText();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return null;// TODO: handle exception
    		}	
    }
    /**
     * This method checks header of Enterprise Solutions box.
     * @return True/false based on visibility of header.
     */
    @Step("Check 'Enterprise Solutions' Header text")
    public String checkEnterpriseSolutionsHeader() {
    	
    	
    		try {
    			return getElement(enterpriseSolutionsBoxTitle).getText();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return null;// TODO: handle exception
    		}	
    		
    }
    
    /**
     * This method checks link text under header of Enterprise Solutions box.
     * @return True/false based on visibility of header.
     */
    @Step("Check text under 'Enterprise Solutions' Header")
    public String checkTextUnderEnterpriseSolutionsHeader( ) {
    		try {
    			if(getElement(enterpriseSolutionsBoxLink).isDisplayed()) {
    				
    		}
    			return getElement(enterpriseSolutionsBoxLink).getText();
    		}
    		catch (Exception e) {
    			e.getStackTrace();
    			return null;// TODO: handle exception
    		}
    }
    
    /**
     * This method is to click on left side  journals link
     * @return null
     */
    @Step("Click on left side journals link")
    public void clickOnLeftSideJournalsLink() {
    	getElement(journalsLink).click();
    }
   }
   
    






