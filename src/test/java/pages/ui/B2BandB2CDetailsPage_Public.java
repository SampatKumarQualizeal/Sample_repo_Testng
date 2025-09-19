package pages.ui;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicCommon;
import com.astm.commonFunctions.SpecBuilderCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class B2BandB2CDetailsPage_Public extends BasePage {


    public B2BandB2CDetailsPage_Public(WebDriver driver) {
        super(driver);
    }
    LoginPage_PublicAdmin loginPagePublicAdmin;
    BillingAddressPage_Public billingAddress=getInstance(BillingAddressPage_Public.class);

    public By CreateAccountHeader = By.xpath("//h1/span[text()='Create an Account']");
    public By OrgFieldErrorMsg=By.cssSelector("#additional_organization-error");
    public By FirstNameField = By.id("firstname");
    public By LastNameField = By.id("lastname");
    public By OrganizationName = By.id("additional_organization");
    public By EmailField = By.id("email_address");
    public By PasswordField = By.id("password");
    public By ConfirmPasswordField = By.id("password-confirmation");
    public By CreateAccountBtn = By.xpath("//button[@title='Create Account']");
    public By captcha=By.xpath("//div[@class='rc-imageselect-payload']");
    public By WelcomeHeader = By.xpath("//h3[text()='My Account']/../p");
    public By verifyUsername = By.xpath("//div[@class='border-top mt-4 pt-4']/p[contains(text(),'Account#:')]/parent::div/p[2]");
    public By verifyEmail = By.xpath("//div[@class='border-top mt-4 pt-4']/p[contains(text(),'Account#:')]/parent::div/p[3]");
    public By verifyOrg = By.xpath("//div[@class='border-top mt-4 pt-4']/p[contains(text(),'Account#:')]/parent::div/p[4]");
    public By SignOut = By.xpath("//a[contains(@href,'logout')]");
    public By SignOutBtn = By.xpath("(//a[contains(@href,'logout')])[2]");

    public By SignInDropdown= By.xpath("//button[contains(@class,'sign-in-btn')]");//cssSelector(".sign-in-btn");
    public By SignInsso = By.xpath("//div[contains(@class,'websso')]/a[text()='Sign In']");
    private By userNameTxt = By.id("userName");
    private By passwordTxt = By.id("encPass");
    private By SignInButton = By.xpath("//button[text()='Sign In']");
    public By CustomerLoginCreateAct = By.xpath("//a[@class='btn astm-btn btn-secondary w-100']//span[text()='Create an Account']");
    public By captchaImg=By.xpath("//div[contains(@class,'rc-anchor-logo-img rc-anchor-logo-img-large')]");


    public WebElement CreateAccountHeader(){
        return getElement(CreateAccountHeader);
    }

    public WebElement getFirstName(){
        return getElement(FirstNameField);
    }

    public WebElement getLastName(){
        return getElement(LastNameField);
    }

    public WebElement getOrganizationName(){
        return getElement(OrganizationName);
    }

    public WebElement getEmail(){
        return getElement(EmailField);
    }

    public WebElement getPassword(){
        return getElement(PasswordField);
    }

    public WebElement getConfirmPassword(){
        return getElement(ConfirmPasswordField);
    }

    public WebElement CreateAccountBtn(){
        return getElement(CreateAccountBtn);
    }

    public WebElement WelcomeHeader(){
        return getElement(WelcomeHeader);
    }

    public WebElement verifyUsername(){
        return getElement(verifyUsername);
    }

    public WebElement verifyEmail(){
        return getElement(verifyEmail);
    }

    public WebElement verifyOrg(){
        return getElement(verifyOrg);
    }

    public WebElement doSignout(){
        return getElement(SignOut);
    }

    public WebElement SigninSSO(){
        return getElement(SignInsso);
    }

    public WebElement InputUsername(){
        return getElement(userNameTxt);
    }

    public WebElement InputPassword(){
        return getElement(passwordTxt);
    }

    public WebElement SigninBtn(){
        return getElement(SignInButton);
    }

    public void clickOnOptionsFromUserNameDropDown(String choice){
        getElement(SignInDropdown).click();
        PublicCommon.waitForSec(1);
        driver.findElement(By.xpath("//a[@class='dropdown-item' and contains(text(),'"+choice+"')]")).click();
    }

    @Step("Enter Mandatory details and click on Create now Button")
    public void CreateB2BandB2Caccount(String Firstname,String Lastname, String Organization,String Password, String ConfirmPassword, String email){
        try{
            WaitStatementUtils.explicitWaitForVisibility(driver, getFirstName());
            WaitStatementUtils.waitForElementToBeClickable(driver, getFirstName(),20);
            getFirstName().sendKeys(Firstname);
            getLastName().sendKeys(Lastname);
            getOrganizationName().sendKeys(Organization);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getPassword().sendKeys(Password);
            getConfirmPassword().sendKeys(ConfirmPassword);
            getEmail().sendKeys(email);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, CreateAccountBtn(),5);
            ReusableMethods.scrollIntoView(CreateAccountBtn(),driver);
            clickonmethod("Click on Create Account Button",  CreateAccountBtn , "Unable to Click on Create Account Button");
            PublicCommon.waitForSec(10);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to create B2B and B2C account", e);
        }
    }

    @Step("Enter Mandatory details and click on Create now Button")
    public void CreateB2BandB2CaccountwithCaptchaVerification(String Firstname,String Lastname, String Organization,String Password, String ConfirmPassword, String email){
        try{
            WaitStatementUtils.explicitWaitForVisibility(driver, getFirstName());
            WaitStatementUtils.waitForElementToBeClickable(driver, getFirstName(),20);
            getFirstName().sendKeys(Firstname);
            getLastName().sendKeys(Lastname);
            getOrganizationName().sendKeys(Organization);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getPassword().sendKeys(Password);
            getConfirmPassword().sendKeys(ConfirmPassword);
            getEmail().sendKeys(email);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, CreateAccountBtn(),5);
            clickonmethod("Click on Create Account Button",  CreateAccountBtn , "Unable to Click on Create Account Button");
            PublicCommon.waitForSec(2);
            billingAddress.isElementDisplayed(getElement(captcha));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to create B2B and B2C account", e);
        }
    }

    @Step("Enter Mandatory details and click on Create now Button")
    public void CreateB2BandB2CAccount(String Firstname,String Lastname, String Organization,String Password, String ConfirmPassword, String email){
        try{
            WaitStatementUtils.explicitWaitForVisibility(driver, getFirstName());
            WaitStatementUtils.waitForElementToBeClickable(driver, getFirstName(),20);
            getFirstName().sendKeys(Firstname);
            getLastName().sendKeys(Lastname);
            getOrganizationName().sendKeys(Organization);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getPassword().sendKeys(Password);
            getConfirmPassword().sendKeys(ConfirmPassword);
            getEmail().sendKeys(email);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, CreateAccountBtn(),5);
            clickonmethod("Click on Create Account Button",  CreateAccountBtn , "Unable to Click on Create Account Button");
            PublicCommon.waitForSec(2);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to create B2B and B2C account", e);
        }
    }

    @Step("Enter Mandatory details and click on Create now Button")
    public void CreateB2CAccount(String Firstname,String Lastname,String Password, String ConfirmPassword, String email){
        try{
            WaitStatementUtils.explicitWaitForVisibility(driver, getFirstName());
            WaitStatementUtils.waitForElementToBeClickable(driver, getFirstName(),20);
            getFirstName().sendKeys(Firstname);
            getLastName().sendKeys(Lastname);
            getPassword().sendKeys(Password);
            getConfirmPassword().sendKeys(ConfirmPassword);
            getEmail().sendKeys(email);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.waitForElementToBeClickable(driver, CreateAccountBtn(),10);
            clickonmethod("Click on Create Account Button",  CreateAccountBtn , "Unable to Click on Download Button");
            PublicCommon.waitForSec(60);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to create B2B and B2C account", e);
        }
    }

    @Step("Verify after login if it's B2B account or not")
    public void VerifyB2Baccount(String username, String email, String Org){
        try{
            ReusableMethods.scrollIntoView(getElement(SignOutBtn),driver);
            verifyUsername().getText().contains(username);
            verifyEmail().getText().equals(email);
            verifyOrg().getText().equals(Org);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to verify created B2B account", e);
        }
    }

    @Step("Signout of Member app")
    public void SignoutMemberapp(){
        try{
            loginPagePublicAdmin = getInstance(LoginPage_PublicAdmin.class);
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(SignInDropdown),10);
            getElement(SignInDropdown).click();
            Assert.assertTrue(getElement(SignOut).isDisplayed(), "Failed to click on Sign in dropdown. So failed to locate Sign out button");
//            doSignout().click();
            PublicCommon.JSClick(getElement(SignOut),driver);
            PublicCommon.waitForSec(5);
            //WaitStatementUtils.waitForElementToBeClickable(driver, getElement(loginPagePublicAdmin.getSignInViaOktaButton()));
            new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("customer/account/login"));
            Assert.assertTrue(driver.getCurrentUrl().contains("customer/account/login"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Signout of Member app", e);
        }
    }

    @Step("Signin to Member application")
    public void SignInMember(String email,String password){
        try{
            InputUsername().sendKeys(email);
            InputPassword().sendKeys(password);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            SigninBtn().click();
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Signin to Member app", e);
        }
    }

    @Step("Verify after login if it's B2C account or not")
    public void VerifyB2Caccount(String username, String email, String Org){
        try{
            WaitStatementUtils.waitForElementToBeClickable(driver, WelcomeHeader(),15);
            getElement(WelcomeHeader).getText().contains("Welcome");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ReusableMethods.scrollIntoView(getElement(SignOutBtn),driver);
            verifyUsername().getText().contains(username);
            verifyEmail().getText().equals(email);
            verifyOrg().getText().equalsIgnoreCase(Org);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to verify created B2C account", e);
        }
    }









}
