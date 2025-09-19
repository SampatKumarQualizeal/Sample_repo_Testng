package pages.ui;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class CompassAPITenant_Page extends BasePage {
    ASTMCartPage_Public astmCartPage;
    //LoginPage_Subscription login = getInstance(LoginPage_Subscription.class);
    HomePage_Subscripiton home = getInstance(HomePage_Subscripiton.class);
    Page page = new BasePage(driver);
    Homepage homePage = page.getInstance(Homepage.class);

    public CompassAPITenant_Page(WebDriver driver) {
        super(driver);
    }

    public By SubscriptionTab = By.xpath("//p[@class='tab astm-type-heading--h6']/span/span[text()='Subscriptions']");
    private By SignoutDropdown = By.xpath("//div[@class='collapse navbar-collapse']/ul/li[3]/a[2]");

    public By cookieRejectBtn = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    public By  cookiesBanner = By.xpath("//div[@id='onetrust-banner-sdk']");
    public By cookieSettings = By.xpath("//button[text()='Cookies Settings']");
    public By cookieRejectAll = By.xpath("//button[text()='Cookies Settings']//following-sibling::button[text()='Reject All']");
    public By cookieAcceptAll = By.xpath("//button[text()='Accept All Cookies']");
    public By cookiesCloseIcon = By.xpath("//button[contains(@class,'onetrust-close-btn-handler') and @aria-label]");
    public By mainLogo=By.xpath("//a[@class='user-logo']");
    public By recentlyAccessed = By.xpath("//span[text()='Recently Accessed']");
    public By noGroupsMsg1=By.xpath("//h1[text()='You have no Groups.']");
    public By noGroupsMsg=By.xpath("//div[contains(@class,'no-groups')]/h1");
    public By tenantTile(String tenant) {
        return By.xpath("//p[text()='"+tenant+"']//ancestor::div[@class='my-subscription row']");
    }
    public By noGroupsMsgTranslatedTxt(){
        return By.xpath("//h1[contains(@class,'no-groups')]");
    }
    public By recentlyAccessed_Active = By.xpath("//span[text()='Recently Accessed']//ancestor::p//ancestor::p[contains(@class,'active')]");

    public By tracker = By.xpath("//span[text()='Tracker']");
    public By tracker_Active = By.xpath("//span[text()='Tracker']//ancestor::p//ancestor::p[contains(@class,'active')]");
    public By favorites = By.xpath("//span[text()='Favorites']");
    public By favorites_Active = By.xpath("//span[text()='Favorites']//ancestor::p//ancestor::p[contains(@class,'active')]");
    public By subscriptions = By.xpath("//span[text()='Favorites']//ancestor::p//following-sibling::p//span[text()='Subscriptions']");
    public By subscriptions_Active = By.xpath("//span[text()='Favorites']//ancestor::p//following-sibling::p//span[text()='Subscriptions']//ancestor::p[contains(@class,'active')]");
    public By documents = By.xpath("//div[@class='card-content row']//div[contains(@class,'col')]//div[@class='card-title']");
    public By documentsOne = By.xpath("(//div[@class='card-content row']//div[contains(@class,'col')]//span[contains(@class,'designation')])[1]");
    public By mainMenu = By.cssSelector(".brand-logo");
    public By astmLogo=By.xpath("//a[@class='user-logo']");
    public By MainMenu_Groups = By.cssSelector("a[data-testid='sider-/groups']");
    public By MyGroups_PageTitle = By.cssSelector(".groups-content-heading span");
    public By CreateGroupbutton = By.cssSelector("button[data-testid='create-group-button']");
    public By GroupName_InputField = By.cssSelector("#edit-group-name");
    public By GroupDescription_InputField = By.cssSelector("#edit-group-description");
    public By editGroupMember = By.xpath("//span[@id='edit-group-member']");
    public By addDocuments_Button = By.xpath("//span[@id='add-documents-button']");
    public By CreateGroup_Step1NextButton = By.cssSelector("button[data-testid='step1-next-button']");
    public By CreateGroup_SearchGroupMember_InputField = By.cssSelector("#search_input_compass_members");
    public String SelectGroupMember_Checkbox_var = "//label[contains(@title,'[GROUP_MEMBER_EMAIL]')]//preceding-sibling::input";
    public By getSelectGroupMember_Checkbox(String GroupMemberEmail){
        return By.xpath(SelectGroupMember_Checkbox_var.replace("[GROUP_MEMBER_EMAIL]", GroupMemberEmail));
    }
    public By CircleRight_button = By.cssSelector(".circle-right");
    public By CreateGroup_Step2NextButton = By.cssSelector("button[data-testid='step2-next-button']");
    public By Update_GroupMember = By.xpath("//button[text() = 'Update']");
    public By SearchCompassDocument_Input = By.cssSelector("#search_input_compass_documents");
    public By SearchCompassDocument_Icon = By.xpath("//button[@data-testid='search-compass-document']");
    public By FirstDocument_Checkbox = By.xpath("(//label[@class='custom-control-label']//span)[1]");
    public By AddButton = By.xpath("//button[text()='Add']");
    public String SelectDocument_Checkbox_var = "//label[contains(@title,'[DOCUMENT_NAME]')]//preceding-sibling::input";
    public By getSelectDocument_Checkbox(String DocumentName){
        return By.xpath(SelectDocument_Checkbox_var.replace("[DOCUMENT_NAME]", DocumentName));
    }
    public By CreateGroup_Step3CreateButton = By.cssSelector("button[data-testid='step3-confirm-button']");
    public By GroupPage_GroupTitle = By.cssSelector(".group-detail-header span:nth-of-type(1)");
    public By GroupCards_title = By.cssSelector(".groups-card .astm-type-heading--h5-bold");
    public By GroupCard_Ellipsis = By.cssSelector("a[data-testid='dropdown-toggle']");
    public By GroupCardEllipsis_Delete = By.cssSelector("div[aria-hidden='false'] a[data-testid='Delete']");
    public By DeleteGroupModal_DeleteGroupButton = By.cssSelector("button[data-testid='delete-group']");
    public By Successful_notification = By.cssSelector(".app-notification");
    public By moreLinkShareDocSucessMsg=By.xpath("//div[contains(@class,'bg-success--light') and text()='Share Confirmation Message']");
    public By sendMeACopyChkbox=By.xpath("//label[@for='email-copy']/preceding-sibling::input[@id='email-copy']");

    public By GroupDetailsPage_EmailGroup = By.cssSelector("#email-group-button");
    public By EmailGroup_Subject_inputField = By.cssSelector("#email-subject");
    public By EmailGroup_EmailMessage_inputField = By.cssSelector("#email-message");
    public By SendEmailButton =By.cssSelector("button[data-testid='button2']");// By.xpath("//button[text()='Send Email']");
    public By CompassHomePage_tabs = By.xpath("//p[contains(@data-testid,'tabClick-tab')]/span/span");
    public String Subscriptions_Card_var = "//div[@class='my-subscription row']//p[text()='[TENANT]']";
    public By getSubscriptions_Card(String Tenant){
        return By.xpath(Subscriptions_Card_var.replace("[TENANT]", Tenant));
    }
    public By searchBarAPIHomePage = By.xpath("//input[@id='search_input_mainpage']");
    public By searchButtonAPIHomePage = By.xpath("//button[@class='search-btn astm-btn btn-primary']");
    public By Subscriptions_SearchInputField = By.cssSelector("#search_input_header");
    public By serpPageFirstDocToSelect=By.xpath("(//div[@class='search-result']//a[@class='astm-link'])[1]");
    public By serpPageSecondDocToSelect=By.xpath("(//div[@class='search-result']//a[@class='astm-link'])[2]");
    public By serpPageFifthDocToSelect=By.xpath("(//div[@class='search-result']//a[@class='astm-link'])[5]");
    public By version_firstdoc = By.xpath("(//a[text()='Versions'])[1]");
    public By moduk_issue4 = By.xpath("//a[text()='MODUK DS91-090 ISSUE 4']");
    public By moduk_issue18 = By.xpath("//a[text()='MODUK DS91-091 ISSUE 18']");
    public By version_seconddoc = By.xpath("(//a[text()='Versions'])[2]");
    public String Subscriptions_SearchResultsLink_var = "//div[@class='search-result']//span[contains(text(),'[DOCUMENT]')]//parent::a";
    public By getSubscriptions_SearchResultsLink(String Document){
        return By.xpath(Subscriptions_SearchResultsLink_var.replace("[DOCUMENT]", Document));
    }
    public By DocumentTitle = By.cssSelector(".document-title");
    public By TrackDocument = By.xpath("//span[contains(text(),'Track Document')]");
    public By DownloadDocument = By.xpath("//span[contains(text(),'Download')]");
    public By selectLanguageFromLangDrpdwn(String language){
        return By.xpath("//button[@value='"+language+"']");
    }
    public By DocumentPage_MoreEllipsis = By.cssSelector(".more");
    public By moreLink=By.xpath("//div[@class='document-activity']//span[text()='More']");
    public By DocumentPage_Share = By.cssSelector(".dropdown-item a[title='Share']");
    public By ShareDocument_SearchGroup_inputField = By.cssSelector(".modal-dialog .search-input");
    public String ShareDocument_AddButton_var = "//p[text()='[GROUPNAME]']//ancestor::div[contains(@class,'group-item')]//button[text()='add']";
    public By getShareDocument_AddButton(String GroupName){
        return By.xpath(ShareDocument_AddButton_var.replace("[GROUPNAME]", GroupName));
    }
    public By ShareDocument_ModalFooter_ShareButton = By.cssSelector(".modal-footer button.share-dialog-button");
    public By homeLink = By.xpath("//div[@class='major-menu-item']//a[text()='Home']");
    public By compareVersion = By.xpath("//div[@class='tips-tricks-head']//following-sibling::div//span[text()='Compare Version']");
    public By recentlyAccessedUpdated = By.xpath("//div[@class='tips-tricks-head']//following-sibling::div//h1[text()='Recently Updated & Recently Accessed']");
    public By ASTMAddress = By.xpath("//p[text()='American Petroleum Institute 1220 L Street, NW, Washington, DC 20005-4070 USA']");
    public By copyRight  = By.xpath("//p[text()=' ASTM. All Rights Reserved. ASTM International, 100 Barr Harbor Drive, PO Box C700, West Conshohocken, PA, 19428-2959 USA']");
    public By homeLink_FooterSection = By.xpath("//div[@class='footer page-content bg-primary']//a");
    public By languageDropdown = By.xpath("//li[@id='language-menu']");
    public By language_DE = By.xpath("//span[text()='(DE) Deutsch']");
    private By languageSelection(String language){
        return By.xpath("tr.data-row td:nth-of-type("+language+")");
    }

    public By subscriptionsTab = By.xpath("//p[@class='tab astm-type-heading--h6']/..//span[text()='Subscriptions']");

    public By APITenantLink = By.xpath("//a[@class='noUnderScore']/..//p[text()='American Petroleum Institute']");

    public By documentsLink = By.xpath("//span[text()='Packers and Bridge Plugs; Third Edition; ISO 14310:2008']");

    public By compassPointBtn = By.xpath("(//button[text()='Compass Points'])[1]");

    public By aenorBtn = By.xpath("//span[text()='AENOR']/..//button");
    public By customCollectionsHeader=By.xpath("//h2[contains(@class,'custom-collections-header')]");
    public By customCollectionsTableEle=By.xpath("//table[contains(@class,'astm-table')]");
    public By customCollectionsTableRecordsEle=By.xpath("//table[contains(@class,'astm-table')]/tbody/tr");
    public By customCollectionsTableDocsTitle(int i,String tenantName){
       return By.xpath("//tbody/tr["+String.valueOf(i)+"]/td[3]/div[text()='"+tenantName+"']/parent::td/preceding-sibling::td/a[@data-testid='onDocVerification']");
    }
    public By DesignationColumn = By.cssSelector(".desc-column");
    public By DesignationColumnSort = By.cssSelector(".desc-column .icon");
    public By CustomeCollections_Designations = By.cssSelector(".astm-table-tr td:nth-of-type(1) div") ;
    public By CustomeCollections_Title = By.cssSelector(".astm-table-tr td:nth-of-type(2) a");
    public By CustomeCollections_Publisher = By.cssSelector(".astm-table-tr td:nth-of-type(3)");
    public By CustomeCollections_Download = By.cssSelector(".astm-table-tr td:nth-of-type(4)");
    public By DocumentDownloadButton = By.xpath("//div[@class='document-activity']//span[text()='Download']");
    public By Downloadicon_CustomCollectionsPage = By.xpath("//i[@data-testid='onDownloadBtn']");
    public By DocumentDesignation = By.xpath("//a[@data-testid='onDocVerification']//parent::td//preceding-sibling::td/div");

    public By ASTM_Publisher = By.xpath("//div[@class='my-subscription row']//p[text()='ASTM']");
    public By clearAll = By.xpath("//span[text()='Clear All']");
    public By UsernameDropDown = By.cssSelector("#account_menu_ipad .header-dropdown .user_name");
    public By DocumentsSharedWithMe = By.xpath("(//span[@class='dropdown-item-link astm-type-body'])[3]");
    public By MySharedDocuments = By.xpath("//tr[@class='astm-table-tr']//th[text()='Document']");
    public By UsernameDropDown_SignOut = By.cssSelector("#account_menu_ipad_logout");
    public By CompassHomePage_SelectButton = By.cssSelector(".accounts-content button");
    public By sUserMenu_SharedwithMe =By.cssSelector("#account_menu_ipad_shared-with-me");
    public By notpartofLicensemodal=By.xpath("//span[contains(text(),'This resource is not part of your license')]");
    public By Share_Magnifyglass_Modal = By.xpath("(//button[@class='search-btn astm-btn btn-primary'])[2]");


    public By getSubscriptionTab()
    {
        return SubscriptionTab;
    }

    public WebElement getRecentlyAccessed(){
        return getElement(recentlyAccessed);
    }
    public WebElement getRecentlyAccessed_Active(){
        return getElement(recentlyAccessed_Active);
    }



    @Step("Click on Subscription Tab select any publisher")
    public void ClickOnSubscriptionTab(){
        try{
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(subscriptions));
            getElement(subscriptions).click();
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(ASTM_Publisher));
            getElement(ASTM_Publisher).click();

        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Click on Subscription Tab", e);
        }
    }

    @Step("Verify Documents access and maximum documents records")
    public void verifyDocuments(){
        try{
            int records = getElements(documents).size();
           if(records<=6){
             getElement(documentsOne).click();
           }else{
               Assert.fail("Documents max records not matching");
           }

        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to access the documents/Maximum Records", e);
        }
    }
    public void navigateToHomePge_MainMenu(){
      getElement(mainMenu).click();
      getElement(homeLink).click();
    }
    @Step("Verify that on the Tips and Tricks Section, user is able to see the Compare Version Tile,  Recently accessed & recently updated tiles")
    public void VerifyTipsAndTricksSection(){
        try{
           verifyVisibility("Compare Version Tile",getElement(compareVersion),"User able to see Compare Version Tile under Tips and Tricks section");
            verifyVisibility("CRecently accessed & recently updated tiles",getElement(recentlyAccessedUpdated),"User able to see Recently accessed & recently updated tiles under Tips and Tricks section");
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to see the Compare Version Tile,  Recently accessed & recently updated tiles", e);
        }
    }
    @Step("Verify footer details and links")
    public void VerifyFooterDetails(){
        try{
            verifyVisibility("ASTM address",getElement(ASTMAddress),"User able to see ASTM address under Footer section");
            verifyVisibility("CopyRight",getElement(copyRight),"User able to see CopyRight under Footer section");
            verifyVisibility("Home Link",getElement(homeLink_FooterSection),"User able to see Home link under Footer section");
            int linksUnderFooterSection = getElements(homeLink_FooterSection).size();
            Assert.assertTrue(linksUnderFooterSection==1,"Only one link(Home Link) is available in footer section");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to see the Compare Version Tile,  Recently accessed & recently updated tiles", e);
        }
    }
    @Step("Verify that on the Home page, user is able to access the features of the application")
    public void verifyAllTabsAndFeatures(){
        try{
            clickOnRecentlyAccessedTabAndVerify("Recently Accessed Tab",getElement(recentlyAccessed),getElement(recentlyAccessed_Active));
            clickOnTrackerTabAndVerify("Tracker Tab",getElement(tracker),getElement(tracker_Active));
            clickOnFavoritesTabAndVerify("Favorites Tab",getElement(favorites),getElement(favorites_Active));
            clickOnSubscriptionsTabAndVerify("Subscriptions Tab",getElement(subscriptions),getElement(subscriptions_Active));
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Navigate all the Tabs", e);
        }
    }
    @Step("Click on Recently Accessed Tab and Verify")
    public void clickOnRecentlyAccessedTabAndVerify(String element, WebElement tab, WebElement tabExists){
       tab.click();
        verifyVisibility(element,tabExists,"User Should able to see all the screens in "+element);
    }
    @Step("Click on Tracker Tab and Verify")
    public void clickOnTrackerTabAndVerify(String element, WebElement tab, WebElement tabExists){
       tab.click();
        verifyVisibility(element,tabExists,"User Should able to see all the screens in "+element);
    } @Step("Click on Favorites Tab and Verify")
    public void clickOnFavoritesTabAndVerify(String element,WebElement tab,WebElement tabExists){
        tab.click();
        verifyVisibility(element,tabExists,"User Should able to see all the screens in "+element);
    } @Step("Click on Subscriptions Tab and Verify")
    public void clickOnSubscriptionsTabAndVerify(String element,WebElement tab,WebElement tabExists){
        tab.click();
        verifyVisibility(element,tabExists,"User Should able to see all the screens in "+element);
    }



    @Step("Verify cookie consent banner at the bottom of the page")
    public void verifyCookiesBanner(){
        try{
            verifyVisibility("cookie consent banner",getElement(cookiesBanner),"User should be able to see Cookies Banner at bottom of the page");
            verifyVisibility("Cookies Settings button",getElement(cookieSettings),"User should be able to see Settings button on the cookie consent banner at the bottom of the page");
            verifyVisibility("Cookies Reject All button",getElement(cookieRejectAll),"User should be able to see Reject All button on the cookie consent banner at the bottom of the page");
            verifyVisibility("Cookies Accept All Button",getElement(cookieAcceptAll),"User should be able to see Accept All button on the cookie consent banner at the bottom of the page");
            verifyVisibility("Cookies Cross(cancel) icon",getElement(cookiesCloseIcon),"User should be able to see cross icon on the cookie consent banner at the bottom of the page");

        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to signin Compass", e);
        }
    }
    @Step("Verify API Compass User is not able to see the Cookie Consent Banner again by clicking on the {element} Cookies button")
    public void verifyCookiesBannerInvisibility(By element){
        try{
            getElement(element).click();
            verifyInVisibility(getElement(cookiesBanner));
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to verify API Compass User is not able to see the Cookie Consent Banner", e);
        }
    }
    @Step("Verify API Compass User is not able to see the Cookie Consent Banner again by clicking on the Reject All Cookies button")
    public void verifyCookiesBann(){
        try{
            getElement(cookieRejectAll).click();
            verifyInVisibility(getElement(cookiesBanner));
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to verify API Compass User is not able to see the Cookie Consent Banner", e);
        }
    }
    @Step("Verify API Compass User is not able to see the Cookie Consent Banner again by clicking on the Cross icon")
    public void verifyCookiesBan(){
        try{
            getElement(cookiesCloseIcon).click();
            verifyInVisibility(getElement(cookiesBanner));
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to verify API Compass User is not able to see the Cookie Consent Banner", e);
        }
    }

    @Step("Verify the InVisibility of {Element}")
    public boolean verifyInVisibility( WebElement locator)
    {
        boolean flag = false;
        try {
            if(!(home.isWebElementDisplayed(locator))){
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            IntegrationCommon.reportFailAssert("Failed to verify the visibility of element", e);
        }
        return flag;
    }
    @Step("Verify the Visibility of {Element}")
    public boolean verifyVisibility(String Element, WebElement locator, String message)
    {
        boolean flag = false;
        try {
            Assert.assertTrue(home.isWebElementDisplayed(locator),message);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            IntegrationCommon.reportFailAssert("Failed to verify the visibility of element", e);
        }
        return flag;
    }
    @Step("Signout of Compass")
    public void ClickSignoutDropdown() {
        try {
            getElement(SignoutDropdown).click();
        } catch (Exception e) {
            System.out.println("Signout Dropdown Not Clickable");
        }
    }
    public By userManagementDropdown = By.xpath("//li[@id='account_menu_ipad']");
    public By userManagementOptionsSize = By.xpath("//li[@id='account_menu_ipad']//div[contains(@class,'dropdown-menu')]//a");
    public By userManagementOptions(int value) {
        return By.xpath("(//li[@id='account_menu_ipad']//div[contains(@class,'dropdown-menu')]//a//span[not(@class)])["+value+"]");
    }
    public By userManagementRole = By.xpath("//span[text()='User Management']");
    public By deniedMessage = By.xpath("//div[@class='alert alert-danger']//p");

    @Step("Verify user management option is displayed under user dropdown menu")
    public void userManagementAvailability(boolean userManagementAccess) {
        boolean flag = false;
        try {
            clickOnUserManagement();
            int options = getElements(userManagementOptionsSize).size();
            for (int i = 1; i <= options; i++) {
                String option = getElement(userManagementOptions(i)).getText();
                if (option.contains("User Management")) {
                    flag = true;
                    ScreenshotUtil.takeScreenshotForAllure(driver);
                    getElement(userManagementOptions(i)).click();
                    break;
                }
            }
            if(!flag){
               Assert.fail("There is no user management option under user dropdown");
            }

        } catch (Exception e) {
            System.out.println("Failed to Verify user management option is displayed under user dropdown menu");
            IntegrationCommon.reportFailAssert("Failed to verify user management option is displayed under user dropdown menu", e);

        }
    }
    @Step("Verify User should be navigated to MAE application")
    public void verifyNavigateToMAE() throws IOException {
        PublicCommon.switchTabs(driver,1);
        PublicCommon.waitForSec(30);
        ScreenshotUtil.takeScreenshotForAllure(driver);
        PublicCommon.waitForSec(10);
        Assert.assertTrue(getElement(userManagementRole).isDisplayed(),"Not able to Navigate MAE application");
        ScreenshotUtil.takeScreenshotForAllure(driver);
        //driver.close();
    }
    @Step("Verify Access denied message should be displayed")
    public void verifyAccessDenied() throws IOException {
        PublicCommon.switchTabs(driver,1);
        PublicCommon.waitForSec(30);
        ScreenshotUtil.takeScreenshotForAllure(driver);
        PublicCommon.waitForSec(10);
        Assert.assertTrue(getElement(deniedMessage).isDisplayed(),"Not able to see the denied Message");
        ScreenshotUtil.takeScreenshotForAllure(driver);
        //driver.close();
    }


    @Step("Verify user management option is not displayed under user dropdown menu")
    public void userManagementNotAvailability(){
        boolean flag = false;
        try {
            clickOnUserManagement();
            int options = getElements(userManagementOptionsSize).size();
            for (int i = 1; i <= options; i++) {
                String option = getElement(userManagementOptions(i)).getText();
                if (option.contains("User Management")) {
                    flag = true;
                    getElement(userManagementOptions(i)).click();
                    break;
                }
            }
            ScreenshotUtil.takeScreenshotForAllure(driver);
            if(flag){
                Assert.fail("There is user management option available under user dropdown");
            }

        } catch (Exception e) {
            System.out.println("Failed to Verify user management option is not displayed under user dropdown menu");
        }
    }
    @Step("Click on user management dropdown")
    public void clickOnUserManagement(){
        PublicCommon.waitForSec(10);
        WaitStatementUtils.explicitWaitForVisibility(driver,getElement(userManagementDropdown));
        getElement(userManagementDropdown).click();
    }





    @Step("Sign out of compass")
    public void signOutOfCompass(){
        try {
            WaitStatementUtils.waitForElementToBeClickable(driver, page.getElement(UsernameDropDown),10);
            PublicCommon.JSClick(page.getElement(UsernameDropDown),driver);
            PublicCommon.waitForSec(2);
            WaitStatementUtils.waitForElementToBeClickable(driver, page.getElement(UsernameDropDown_SignOut));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            page.getElement(UsernameDropDown_SignOut).click();
            PublicCommon.waitForSec(2);
        }catch (Exception e){
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Sign Out of compass", e);
        }
    }
}
