package pages.ui;

import base.utils.*;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import com.astm.commonFunctions.SpecBuilderCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage_SpecBuilder extends BasePage{
	EncryptionUtil encryptionUtil;
	public LoginPage_SpecBuilder(WebDriver driver) {
		super(driver);
	}
	private By userName = By.cssSelector("#userName");
	private By password = By.cssSelector("#encPass");
	private By signUpBtn = By.xpath("//button[@type='submit']");
	public By SigninBtn = By.xpath("//button[@type='submit']");
	public By cookieRejectBtn = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	public By selectSecondaccount = By.xpath("//div[@class='account-list']//div[@class='card astm-card'][2]//child::button");
	public  By firstAccount =  By.xpath("//div[@class='account-list']//div[@class='card astm-card'][1]//child::button");
	public By thirdAccount = By.xpath("//div[@class='account-list']//div[@class='card astm-card'][3]//child::button");
	public By fourthAccount = By.xpath("//div[@class='account-list']//div[@class='card astm-card'][4]//child::button");
	public By signInHeader = By.xpath("//h3[text()='Sign In']");
	public By selectAccountHeader = By.xpath("//p[text()='Select an Account']");
	//migrated data
//	public By qaAccount = By.xpath("//span[text()='NATIONAL FENESTRATION RATING COUNCIL']//following::button[1]");
	public By StCollab = By.xpath("//span[text()='ASTM International Collaboration Area']//following::button[1]");
	public By StCollabb = By.xpath("//span[text()='ASTM International Collaboration Area']//following::button[1]");
	
	public By stgCollab = By.xpath("//span[text()='ASTM MEMBER']//following::button[1]");
	public By qaCollab = By.xpath("//span[text()='ASTM MEMBER']//following::button[1]");
	public By QACollab = By.xpath("//span[text()='ASTM International Collaboration Area']//following::button[1]");
	//public By stgAccount = By.xpath("//span[text()='ArcelorMittal Dofasco']//following::button[1]");
	public By qaAstmStaff = By.xpath("//span[text()='ASTM STAFF - QA']//following::button[1]");
	public By QAAccount = By.xpath("//div[text()='ASTM International Collaboration Area']//following::button[1]");
	public By QAAccount1 = By.xpath("//span[text()='ASTM International Collaboration Area']/following-sibling::button");
	public By plasticPipe = By.xpath("//span[text()='Plastics Pipe Institute']//following::button[1]");

	public By qaAccount = By.xpath("//span[text()='SPB_QA_Account_1']//following::button[1]");
	public By qaAccount01 = By.xpath("//span[text()='SPB_QA_Account_2']//following::button[1]");
	public By qaAccount1 = By.xpath("//span[text()='NATIONAL FENESTRATION RATING COUNCIL']//following::button[1]");
	public By stgAccount1 = By.xpath("//span[text()='ASTM MEMBER']//following::button[1]");
	public By stgAccount = By.xpath("//span[text()='NATIONAL FENESTRATION RATING COUNCIL']//following::button[1]");
	//public By stgDiffAccount = By.xpath("//span[text()='US Metals']//following::button[1]");
	public By stgDiffAccount = By.xpath("//span[text()='Plastics Pipe Institute']//following::button[1]");
	public By QADiffAccount = By.xpath("//span[text()='Plastics Pipe Institute']//following::button[1]");
	public By usMetalsAccount = By.xpath("//span[text()='US Metals']//following::button[1]");
	public By cookieCloseButton = By.xpath("//div[@role='alert']//button[@class='close']//span");
	public By cookiCloseButton = By.xpath("//button[contains(.,'Accept All Cookies')]");
	public By closeCookie = By.xpath("//div[@id='onetrust-close-btn-container']/button[contains(@class,'onetrust-close-btn')]");

	public By groupName = By.xpath("//div[@class='dashboard-group-wrapper']//tbody/tr[1]//td[1]//span");
	public By agreeAndCont = By.xpath("//button[contains(text(),'Agree and Continue')]");
	public By SPBcloseCookie = By.xpath("//button[@aria-label='Close']");
	public By AccountDropdown = By.xpath("//li[@id='account-menu']/a");
	public By SignoutBtn = By.xpath("//button[text()='Sign out']");
	public WebElement getUserName(){
		return getElement(userName);
	}
	public WebElement getPassword() {
		return getElement(password);
	}
	public WebElement getSignInButton(){
		return getElement(SigninBtn);
	}
    public By userMenu = By.xpath("//li[@id='account-menu']//a");
	public By logOut = By.xpath("//button[text()='Sign out']");
	public By member = By.xpath("//a[text()='Members']");
	public By emailMembers = By.xpath("//button[text()='Email Members']");
    public By emailType = By.xpath("//select[@id='emailType']");
	public By adminCheckBox = By.xpath("(//tbody)[1]//tr[1]//td[6]//input");
	public By secondAdminCheckBox = By.xpath("(//tbody)[1]//tr[2]//td[6]//input");
	public By send = By.xpath("//button[text()='Send']");
	public By ccMail = By.xpath("//h4[text()='CC:']//following-sibling::input");
		public By group(String name) {
		return By.xpath("//span[text()='"+name+"']");
	}
   public By msgBody = By.xpath("//textarea[@placeholder='Type Email Body Here']");
		public By email = By.xpath("//input[@type='email']");
		public By passwordGmail = By.xpath("//input[@type='password']");
		public By next = By.xpath("//span[text()='Next']");
		public By notNow = By.xpath("//span[text()='Not now']");
		public By firstMail = By.xpath("//div[@class='UI']//table//tr[1]//td[4]//div[2]//span[@class='yP']");
		public By emailDisplayName = By.xpath("//input[@name='groupEmailDisplayName']");
	public By spbLoader=By.xpath("//div[@class='astm-spinner spinner-border']");



	//driver.findElement(By.xpath("//div[text()='Cc']//following-sibling::div//span[@class='jsReciID'][1]")).getAttribute("data-eid");

	public By signIn = By.xpath("//div[@class='header']//a[text()='SIGN IN']");
	public By emailAddress = By.xpath("//input[@id='login_id']");
		public By nextButton = By.xpath("//button[@id='nextbtn']");
		public By password1 = By.xpath("//input[@id='password']");
		public By signInButton = By.xpath("//button//span[text()='Sign in']");
		public By firstMail1 = By.xpath("//div[@class='SC_mclst zmLClassic']//div[@data-ty][1]");
		public By expandButtonForCC = By.xpath("//i[@aria-label='Expand Header']");
		public By SpecBuilder_DashboardPage_HomeIcon = By.xpath("//span[contains(text(),'Home')]");
		public By SpecBuilder_Spinner_Loading=By.cssSelector("#div.astm-spinner.spinner-border");

	@Step("Email members Validations")
	public void getZohoMailCC()
	{
		try {
			driver.get("https://mail.zoho.in/");
			WaitStatementUtils.explicitWait(driver,getElement(signIn));
			getElement(signIn).click();

			WaitStatementUtils.explicitWait(driver,getElement(emailAddress));
			getElement(emailAddress).sendKeys("stgautomationstglast@zohomail.in");
			getElement(nextButton).click();
			WaitStatementUtils.explicitWait(driver,getElement(password1));
			getElement(password1).sendKeys("service@act23");
			getElement(signInButton).click();

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to validated Email members", e);

		}
	}

	public void loginOutSpecBuilder()
	{
		try {
			PublicCommon.waitForSec(10);
			getElement(userMenu).click();
			getElement(logOut).click();

		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Logout failed", e);

		}
	}

	public void clickOnGroup(String name)
	{
		try {
			getElement(group(name)).click();
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Logout failed", e);

		}
	}

	public boolean loginAndSelectASTMStaffAccountSTG(String uname,String pswd)
	{
		try {
			encryptionUtil=new EncryptionUtil();
			getElement(userName).sendKeys(uname);
			//getPassword().sendKeys(encryptionUtil.decrypt(pswd));
			getElement(password).sendKeys(pswd);
			getElement(signUpBtn).click();
			WebElement stageAccount=getElement(stgAccount);
			WebElement agreeAndContinue=getElement(agreeAndCont);
			WebElement cookieCButton=getElement(cookieCloseButton);
			try {
				
				if(agreeAndContinue.isDisplayed()) {
					if (WaitStatementUtils.waitForElementToBeClickable(driver, agreeAndContinue)) ;
					agreeAndContinue.click();
				}
				else
					return false;
				
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(stageAccount.isDisplayed()) {
					if (WaitStatementUtils.waitForElementToBeClickable(driver, stageAccount)) ;
					stageAccount.click();
				}
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(groupName)));
			try {
				if(cookieCButton.isDisplayed())
					cookieCButton.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean loginAndSelectASTMStaffAccountQA(String uname,String pswd)
	{
		try {
			encryptionUtil=new EncryptionUtil();
			getElement(userName).sendKeys(uname);
			//getPassword().sendKeys(encryptionUtil.decrypt(pswd));
			getElement(password).sendKeys(pswd);
			getElement(signUpBtn).click();
			WebElement stageAccount=getElement(qaAstmStaff);
			WebElement agreeAndContinue=getElement(agreeAndCont);
			WebElement cookieCButton=getElement(cookieCloseButton);
			try {
				if(getElement(qaAstmStaff).isDisplayed()) {
					if (WaitStatementUtils.waitForElementToBeClickable(driver, stageAccount, 20)) ;
					getElement(qaAstmStaff).click();
				}
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(agreeAndContinue.isDisplayed()) {
					if (WaitStatementUtils.waitForElementToBeClickable(driver, agreeAndContinue, 10)) ;
					agreeAndContinue.click();
				}
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(groupName),10));
			try {
				if(getElement(cookieCloseButton).isDisplayed())
					getElement(cookieCloseButton).click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void handleOneTrustCookie() {
		try {
			IntegrationCommon.clickonWebElement(driver, cookieRejectBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public boolean loginAndSelectCorrectAccountSTGG(String uname,String pswd)
	{
		try {
			encryptionUtil=new EncryptionUtil();
			getElement(userName).sendKeys(uname);
			//getPassword().sendKeys(encryptionUtil.decrypt(pswd));
			getElement(password).sendKeys(pswd);
			getElement(signUpBtn).click();
			WebElement stageAccount=getElement(stgAccount);
			WebElement agreeAndContinue=getElement(agreeAndCont);
			WebElement cookieCButton=getElement(cookieCloseButton);
			try {
				
				if(agreeAndContinue.isDisplayed()) {
					if (WaitStatementUtils.waitForElementToBeClickable(driver, agreeAndContinue)) ;
					agreeAndContinue.click();
				}
				else
					return false;
				
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(stageAccount.isDisplayed()) {
					if (WaitStatementUtils.waitForElementToBeClickable(driver, stageAccount)) ;
					stageAccount.click();
				}
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(groupName)));
			try {
				if(cookieCButton.isDisplayed())
					cookieCButton.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean loginAndSelectCorrectAccountSTG(String uname,String pswd)
	{
		try {
			WebElement closeCookiebutton = getElement(closeCookie);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,closeCookiebutton));
			try {
				if(closeCookiebutton.isDisplayed())
					closeCookiebutton.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			getElement(userName).sendKeys(uname);
			getElement(password).sendKeys(pswd);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(signUpBtn),30);
			getElement(signUpBtn).click();
			WebElement StgAccount=getElement(stgAccount);
			WebElement agreeAndContinue=getElement(agreeAndCont);

			try {
				if(StgAccount.isDisplayed()) {
					if (WaitStatementUtils.waitForElementToBeClickable(driver, StgAccount, 5)) ;
					StgAccount.click();
				}
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return true;
	}

	public boolean loginAndSelectCorrectAccountSTG4432(String uname,String pswd)
	{
		try {
			WebElement closeCookiebutton = getElement(closeCookie);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,closeCookiebutton));
			try {
				if(closeCookiebutton.isDisplayed())
					closeCookiebutton.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			getElement(userName).sendKeys(uname);
			getElement(password).sendKeys(pswd);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(signUpBtn),30);
			getElement(signUpBtn).click();
			WebElement StgAccount=getElement(stgAccount);
			WebElement agreeAndContinue=getElement(agreeAndCont);

			/*try {
				if(StgAccount.isDisplayed()) {
					if (WaitStatementUtils.waitForElementToBeClickable(driver, StgAccount, 5)) ;
					StgAccount.click();
				}
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}





	public boolean cookieclose(){
		try{
			WebElement closeCookiebutton = getElement(SPBcloseCookie);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,closeCookiebutton));
			try {
				if(closeCookiebutton.isDisplayed())
					closeCookiebutton.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}



	public boolean loginToSpecBuilder_PlasticPipeInstitute(String uname,String pswd)
	{
		try {
			WebElement cookieCButton=getElement(cookiCloseButton);
			encryptionUtil=new EncryptionUtil();
			getElement(userName).sendKeys(uname);
			getElement(password).sendKeys(pswd);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,cookieCButton));
			try {
				if(cookieCButton.isDisplayed())
					cookieCButton.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			getElement(signUpBtn).click();
			WebElement QaAccount=getElement(plasticPipe);
			WebElement agreeAndContinue=getElement(agreeAndCont);

			try {
				if(getElement(plasticPipe).isDisplayed()) {
					if (WaitStatementUtils.waitForElementToBeClickable(driver, QaAccount, 5)) ;
					getElement(plasticPipe).click();
				}
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(agreeAndContinue.isDisplayed()) {
					if (WaitStatementUtils.waitForElementToBeClickable(driver, agreeAndContinue, 5)) ;
					agreeAndContinue.click();
				}
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(groupName),5));
			try {
				if(getElement(cookieCloseButton).isDisplayed())
					getElement(cookieCloseButton).click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean loginAndSelectCorrectAccountQA(String uname,String pswd)
	{
		try {
			WebElement cookieCButton=getElement(cookiCloseButton);
			encryptionUtil=new EncryptionUtil();
			getElement(userName).sendKeys(uname);
			//getPassword().sendKeys(encryptionUtil.decrypt(pswd));
			getElement(password).sendKeys(pswd);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,cookieCButton));
			try {
				if(cookieCButton.isDisplayed())
					cookieCButton.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			getElement(signUpBtn).click();
			WebElement QaAccount=getElement(QAAccount1);
			WebElement agreeAndContinue=getElement(agreeAndCont);
			
			try {
				if(getElement(QAAccount1).isDisplayed()) {
					if (WaitStatementUtils.waitForElementToBeClickable(driver, QaAccount, 5)) ;
					getElement(QAAccount1).click();
				}
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			PublicAdminCommons.handleSpinnerIcon(driver,spbLoader);
			try {
				if(agreeAndContinue.isDisplayed()) {
					if (WaitStatementUtils.waitForElementToBeClickable(driver, agreeAndContinue, 5)) ;
					agreeAndContinue.click();
				}
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(groupName),5));
			try {
				if(getElement(cookieCloseButton).isDisplayed())
					getElement(cookieCloseButton).click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean loginAndSelectCorrectAccountQAA(String uname,String pswd)
	{
		try {
			WebElement cookieCButton=getElement(cookiCloseButton);
			encryptionUtil=new EncryptionUtil();
			getElement(userName).sendKeys(uname);
			//getPassword().sendKeys(encryptionUtil.decrypt(pswd));
			getElement(password).sendKeys(pswd);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,cookieCButton));
			try {
				if(cookieCButton.isDisplayed())
					cookieCButton.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			getElement(signUpBtn).click();
			WebElement QaAccount=getElement(qaAccount);
			WebElement agreeAndContinue=getElement(agreeAndCont);
			
			try {
				if(getElement(qaAccount).isDisplayed()) {
					if (WaitStatementUtils.waitForElementToBeClickable(driver, QaAccount, 20)) ;
					getElement(qaAccount).click();
				}
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(groupName),10));
			try {
				if(getElement(cookieCloseButton).isDisplayed())
					getElement(cookieCloseButton).click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean loginAndSelectCorrectAccountSTGWithoutClosingPrivy(String uname,String pswd)
	{
		try {
			encryptionUtil=new EncryptionUtil();
			getElement(userName).sendKeys(uname);
			//getPassword().sendKeys(encryptionUtil.decrypt(pswd));
			getElement(password).sendKeys(pswd);
			getElement(signUpBtn).click();
			WebElement stageAccount=getElement(stgAccount);
			WebElement agreeAndContinue=getElement(agreeAndCont);
			WebElement cookieCButton=getElement(cookieCloseButton);
			try {
				if(WaitStatementUtils.waitForElementToBeClickable(driver,stageAccount,20));
				if(stageAccount.isDisplayed()) {
					stageAccount.click();
					return true;}
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean loginAndSelectCorrectAccountQAWithoutClosingPrivy(String uname,String pswd)
	{
		try {
			encryptionUtil=new EncryptionUtil();
			getElement(userName).sendKeys(uname);
			//getPassword().sendKeys(encryptionUtil.decrypt(pswd));
			getElement(password).sendKeys(pswd);
			getElement(signUpBtn).click();
			try {
				if(getElement(qaAccount).isDisplayed())
					getElement(qaAccount).click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	public boolean loginAndSelectCorrectDiffAccountSTG(String uname,String pswd)
	{
		try {
			WebElement cookieCButton=getElement(cookiCloseButton);
			encryptionUtil=new EncryptionUtil();
			getElement(userName).sendKeys(uname);
			//getPassword().sendKeys(encryptionUtil.decrypt(pswd));
			getElement(password).sendKeys(pswd);
			if(WaitStatementUtils.waitForElementToBeClickable(driver,cookieCButton));
			try {
				if(cookieCButton.isDisplayed())
					cookieCButton.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			getElement(signUpBtn).click();
			WebElement stageDiffAccount=getElement(stgDiffAccount);
			WebElement agreeAndContinue=getElement(agreeAndCont);
			
			try {
				if(WaitStatementUtils.waitForElementToBeClickable(driver,stageDiffAccount));
				if(stageDiffAccount.isDisplayed())
					stageDiffAccount.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(WaitStatementUtils.waitForElementToBeClickable(driver,agreeAndContinue));
				if(agreeAndContinue.isDisplayed())
					agreeAndContinue.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			if(WaitStatementUtils.waitForElementToBeClickable(driver,cookieCButton));
			try {
				if(cookieCButton.isDisplayed())
					cookieCButton.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean loginAndSelectCorrectDiffAccountQA(String uname,String pswd)
	{
		try {
			encryptionUtil=new EncryptionUtil();
			getElement(userName).sendKeys(uname);
			//getPassword().sendKeys(encryptionUtil.decrypt(pswd));
			getElement(password).sendKeys(pswd);
			getElement(signUpBtn).click();
			try {
				if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(QADiffAccount),30));
				if(getElement(QADiffAccount).isDisplayed())
					getElement(QADiffAccount).click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(agreeAndCont),20));
				if(getElement(agreeAndCont).isDisplayed())
					getElement(agreeAndCont).click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(groupName),20));
			try {
				if(getElement(cookieCloseButton).isDisplayed())
					getElement(cookieCloseButton).click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean stgLoginForCollabArea(String uname,String pswd)
	{
		try {
			WebElement cookieCButton=getElement(cookiCloseButton);
			encryptionUtil=new EncryptionUtil();
			getElement(userName).sendKeys(uname);
			//getPassword().sendKeys(encryptionUtil.decrypt(pswd));
			getElement(password).sendKeys(pswd);
			
			if(WaitStatementUtils.waitForElementToBeClickable(driver,cookieCButton));
			try {
				if(cookieCButton.isDisplayed())
					cookieCButton.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
			getElement(signUpBtn).click();
			Thread.sleep(2000);
			WebElement stageCollab=getElement(QAAccount);
			WebElement agreeAndContinue=getElement(agreeAndCont);
			//WebElement cookieCButton=getElement(cookieCloseButton);
			
			try {
				if(WaitStatementUtils.waitForElementToBeClickable(driver,stageCollab));
				if(stageCollab.isDisplayed())
					stageCollab.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			if(WaitStatementUtils.waitForElementToBeClickable(driver,cookieCButton));
			try {
				if(cookieCButton.isDisplayed())
					cookieCButton.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean qaLoginForCollabArea(String uname,String pswd)
	{
		try {
			encryptionUtil=new EncryptionUtil();
			getElement(userName).sendKeys(uname);
			//getPassword().sendKeys(encryptionUtil.decrypt(pswd));
			getElement(password).sendKeys(pswd);
			getElement(signUpBtn).click();
			try {
				if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(QACollab),10));
				if(getElement(QACollab).isDisplayed())
					getElement(QACollab).click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
			try {
				if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(agreeAndCont),20));
				if(getElement(agreeAndCont).isDisplayed())
					getElement(agreeAndCont).click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(groupName),20));
			try {
				if(getElement(cookieCloseButton).isDisplayed())
					getElement(cookieCloseButton).click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean doLoginNow(String uname,String pswd)
	{
		try {
			
			WebElement cookieCButton=getElement(cookiCloseButton);
			encryptionUtil=new EncryptionUtil();
			getElement(userName).sendKeys(uname);
			//getPassword().sendKeys(encryptionUtil.decrypt(pswd));
			getElement(password).sendKeys(pswd);
			
			if(WaitStatementUtils.waitForElementToBeClickable(driver,cookieCButton));
			try {
				if(cookieCButton.isDisplayed())
					cookieCButton.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
			getElement(signUpBtn).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	public boolean selectQAAccount() {
		try {
			getElement(qaAccount).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean selectSTGAccount() {
		try {
			getElement(stgAccount1).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean selectSecondAccount() {
		try {
			getElement(selectSecondaccount).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean selectThirdAccount() {
		try {
			getElement(thirdAccount).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean selectFourthAccount() {
		try {
			getElement(fourthAccount).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean selectFirstAccount() {
		try {
			getElement(stgAccount).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	

	public boolean loginAndSelectCorrectAccount(String uname,String pswd)
	{
		try {
			encryptionUtil=new EncryptionUtil();
			getElement(userName).sendKeys(uname);
			//getPassword().sendKeys(encryptionUtil.decrypt(pswd));
			getElement(password).sendKeys(pswd);
			getElement(signUpBtn).click();
			try {

				if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(usMetalsAccount),10));
				if(getElement(usMetalsAccount).isDisplayed())
						getElement(usMetalsAccount).click();
					else
						return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public void LicenseAgreement(){
		try {
			if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(agreeAndCont),20));
			if(getElement(agreeAndCont).isDisplayed())
				getElement(agreeAndCont).click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ClickSignoutDropdown() {
		try {
			getElement(AccountDropdown).click();
		} catch (Exception e) {
			System.out.println("Signout Dropdown Not Clickable");
		}
	}

	public By getSignoutBtn(){
		return SignoutBtn;
	}

	@Step("Login to Specbuilder and enter username & password")
	public boolean loginSpecBuilder(String uname,String pswd)
	{
		try {
			getElement(userName).sendKeys(uname);
			getElement(password).sendKeys(pswd);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			getElement(SigninBtn).click();
			WebElement cookieCButton=getElement(cookieCloseButton);

			//if(WaitStatementUtils.waitForElementToBeClickable(driver,getElement(groupName)));
			try {
				if(getElements(cookieCloseButton).size() >0)
					cookieCButton.click();
				else
					return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}





}
