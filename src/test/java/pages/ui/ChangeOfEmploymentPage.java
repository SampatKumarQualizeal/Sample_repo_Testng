package pages.ui;

import base.utils.JsonFileReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class ChangeOfEmploymentPage extends BasePage{
    public ChangeOfEmploymentPage(WebDriver driver) {
        super(driver);
    }
    CommonPage_Public commonPage=getInstance(CommonPage_Public.class);
    JsonFileReader jsonFileReader = new JsonFileReader();
    MembershipBecomeMemberPage newMembershipPage=getInstance(MembershipBecomeMemberPage.class);
    YopMail yopMailPage=getInstance(YopMail.class);
    WebDriver yomailSession=driver;
    public By ChangeOfEmployment = By.xpath("//a[text()='Change Of Employment']");
    public By ChangeOfEmploymentHeader = By.xpath("//h1[text()='Change Of Employment']");
    public By currentOrganization = By.xpath("//p[@data-testid='account-address-org']");
    public By editBtn = By.xpath("//button[text()='Edit']");
    public By firstRadioBtn = By.xpath("//label[contains(text(),'I have changed employment or my organization')]/../input");
    public By secondRadioBtn = By.xpath("//label[contains(text(),'Edit organization name due to misspelling')]/../input");
    public By continueBtn = By.xpath("//button[text()='Continue']");
    public By cooperativeAgreementHeader = By.xpath("//h3[text()='Cooperative Agreement Representative']");
    public By nextBtn = By.xpath("//button[text()='Next']");
    public By appropriateOption = By.xpath("//label[text()='Please select the appropriate option below:']/../div[1]");
    public By newOrganizationName = By.xpath("//label[@data-testid='label_organizationDetails-orgName-input']/../div//input[1]");
    public By selectCity = By.xpath("//label[@data-testid='label_organizationDetails-city-input']/../input");
    public By  zipCode= By.xpath("//label[@for='zipCode']/../input");
    public By  selectOrganizationAddress= By.xpath("//label[text()='Organization Address Line 1']/..//div/input[1]");
    public By  ReviewYourCommittee= By.xpath("//h4[text()='Review Your Committee(s)']");
    public By  YesBtn= By.xpath("//button[text()='Yes']");
    public By  selectCategories= By.xpath("//select[@data-testid='select-review-committee-0']");
    public By  textFiled= By.xpath("//textarea[@type='text']");
    public By  submitBtn= By.xpath("//button[text()='Submit']");
    public By  thankYouMsg= By.xpath("//h4[text()='Thank You!']");
    public By  correctedOrganizationField = By.name("companyName");
    public By  changeofEmploymentHeader= By.xpath("//div[text()='Change of Employment form submitted']");
    public By changeCompanyNameHeader = By.xpath("//div[contains(text(),'Request to change the Company')]");
    public By  newOrganizationNameFromMail= By.xpath("//strong[text()='New Organization Name:']/..");
    public By  accountNumFromMail= By.xpath("//strong[text()='Account Number:']/..");
    public By  newOrganizationNameFromMail1= By.xpath("//table/tbody/tr/td/*[text()='New Organization Name: ']/..");
    public By  newAccountNumFromMail1= By.xpath("//table/tbody/tr/td/*[text()='Member Account Number: ']/..");
    public By  confirmationPopUp= By.xpath("//p[contains(text(),'changes may take 1-3 business days to process')]");
    public By  okButton= By.xpath("//button[text()='Ok']");
    public By  goToMYASTM= By.xpath("//button[text()='Go To MyASTM']");

    public void getSelectOrganizationAddress(String address)
    {
        getElement(selectOrganizationAddress).sendKeys(address);

    }
    public void getselectCountry(String CountyName)
    {
         driver.findElement(By.xpath("//label[@for='address.countryCode']/..//select/option[text()='"+CountyName+"']")).click();

    }
    public void getselectState(String State)
    {
        driver.findElement(By.xpath("//label[@for='address.stateCode']/..//select/option[text()='"+State+"']")).click();

    }
    public void getSelectCity(String city)
    {
        getElement(selectCity).sendKeys(city);
    }
    public void getSelectZipCode(String zipcode)
    {
        getElement(zipCode).sendKeys(zipcode);
    }
    public String getnewOrganizationNameFromMail()
    {
        return getElement(newOrganizationNameFromMail).getText();

    }
    public String getAccountNumFromMail()
    {
        return getElement(accountNumFromMail).getText();

    }
    public String getChangeofEmploymentHeader()
    {
         return getElement(changeofEmploymentHeader).getText();

    }
    public String getChangeCompanyNameHeader()
    {
        return getElement(changeCompanyNameHeader).getText();

    }
    public String getnewOrganizationNameFromMail1()
    {
        return getElement(newOrganizationNameFromMail1).getText();

    }
    public String getAcoountNumFromMail1()
    {
        return getElement(newAccountNumFromMail1).getText();

    }
    @Step("Validate navigation to Change Of Employment")
    public void verifyNavigationToChangeOfEmployment() {
        try {
            getElement(ChangeOfEmployment).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            assertEquals(getElement(ChangeOfEmploymentHeader).getText(), "Change Of Employment");
            newMembershipPage.handleOneTrustCookie();
            getElement(editBtn).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to navigate Change Of Employment", e);
        }
    }
    @Step("Select First radio button")
    public void selectFirstRadioButton(String NewOrganizationName) {
        try {
            PublicCommon.JSClick(getElement(firstRadioBtn), driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            commonPage.getElement(continueBtn).click();
            commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            commonPage.getElement(appropriateOption).click();
            commonPage.getElement(newOrganizationName).sendKeys(NewOrganizationName);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getSelectOrganizationAddress(jsonFileReader.getJsonString("AddressMap","US Address", "Address"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
            getselectCountry(jsonFileReader.getJsonString("AddressMap","US Address", "Country"));
            commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
            getSelectCity(jsonFileReader.getJsonString("AddressMap","US Address", "City"));
            getselectState(jsonFileReader.getJsonString("AddressMap","US Address", "State"));
            getSelectZipCode(jsonFileReader.getJsonString("AddressMap","US Address", "ZipCode"));
            commonPage.getElement(nextBtn).click();
            commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
            commonPage.getElement(YesBtn).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            if(PublicCommon.isWebElementDisplayed(driver,ReviewYourCommittee)) {
            PublicCommon.selectValueInDropdownbyIndex(getElement(selectCategories),7);
            commonPage.getElement(textFiled).sendKeys("Test");
            commonPage.getElement(nextBtn).click();
            }
            PublicAdminCommons.scrollToElement(driver,submitBtn);
            commonPage.getElement(submitBtn).click();
            commonPage.handleSpinnerIcon(driver,commonPage.spinnerIcon);
            assertEquals(getElement(thankYouMsg).getText(),
                    "Thank You!");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Select First radio button", e);
        }
    }
    @Step("Select Second radio button")
    public void selectSecondRadioButton(String NewOrganizationName) {
        try {
            PublicAdminCommons.switchToTabByIndex(driver,0);
            commonPage.getElement(goToMYASTM).click();
            commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
            verifyNavigationToChangeOfEmployment();
            PublicCommon.JSClick(getElement(secondRadioBtn), driver);
            commonPage.getElement(correctedOrganizationField).clear();
            commonPage.getElement(correctedOrganizationField).sendKeys(NewOrganizationName);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            commonPage.getElement(submitBtn).click();
            commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
            PublicCommon.isWebElementDisplayed(driver,confirmationPopUp);
            commonPage.getElement(okButton).click();
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Select Second radio button", e);
        }
    }
    @Step("Navigate to Yop mail and open Inbox.")
    public void navigateToYOPmailAndVerifyChanges(String email,String newOrganizationName,String accountNumber) {
        try {
            assertTrue(yopMailPage.openInbox(email, driver));
            yomailSession.switchTo().frame(yopMailPage.mailBodyFrame);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            if(PublicCommon.isWebElementDisplayed(driver,changeofEmploymentHeader)){
                assertEquals(getChangeofEmploymentHeader(),
                        "Change of Employment form submitted");
                PublicAdminCommons.scrollToElement(driver,newOrganizationNameFromMail);
                assertTrue(getAccountNumFromMail().contains(accountNumber),"Both account numbers are not same");
                ScreenshotUtil.takeScreenshotForAllure(driver);
                String newOrganizationName1=getnewOrganizationNameFromMail();
                assertTrue(newOrganizationName1.contains(newOrganizationName),"Both New Organization Names are not same");
            }
            else {
                PublicCommon.waitForSec(10);
                assertEquals(getChangeCompanyNameHeader(),
                        "Request to change the Company Name (Misspelling or Change in CompanyName)");
                PublicAdminCommons.scrollToElement(driver,newOrganizationNameFromMail1);
                assertTrue(getAcoountNumFromMail1().contains(accountNumber),"Both account numbers are not same");
                ScreenshotUtil.takeScreenshotForAllure(driver);
                String newOrganizationName1=getnewOrganizationNameFromMail1();
                assertTrue(newOrganizationName1.contains(newOrganizationName),"Both New Organization Names are not same");
            }
            PublicAdminCommons.closeTab(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Navigate to Yop mail and open Inbox.", e);
        }
    }
}
