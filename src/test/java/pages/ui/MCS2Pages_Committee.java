package pages.ui;

import base.utils.RandomStringUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Key;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class MCS2Pages_Committee extends BasePage{
    public MCS2Pages_Committee(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    MC2Pages_Membership membershipData=getInstance(MC2Pages_Membership.class);
    Mcs2Application_Page MCS2Application=getInstance(Mcs2Application_Page.class);
    public By committeeTab = By.xpath("//a[text()='Committee']");
    public By eventNamesVisible  = By.xpath("//div[@class='results transition visible']");
    public By addCommitteeBtn = By.xpath("//button[text()='Add Committee']");
    public By selectCommitteeType = By.cssSelector("#CommitteeType");
    public By selectCommitteeHierarchy = By.name("CommitteeHierarchy");
    public By oKBtn = By.xpath("//button[text()='Ok']");
    public By committeeDesignationField = By.name("Code");
    public By classificationField = By.name("Classification");
    public By BosVolume = By.cssSelector("#BosVolume");
    public By BosVolume_Options = By.cssSelector("#BosVolume div[role='option']");
    public By TitleField = By.name("Title");
    public By CreateBtn = By.xpath("//button[text()='Create']");
    public By DesignationAlreadyExistsMsg = By.xpath("//span[@class='errorMessage']");
    public By CommitteeDetailsTab = By.xpath("//a[text()='Committee Details']");
    public By CommitteeRosterTab = By.xpath("//a[text()='Committee Roster']");
    public By AddMemberToCommitteeBtn = By.xpath("//button[text()='Add Member to Committee']");
    public By searchMember = By.name("searchMember");
    public By primaryActivityOfMemberField = By.name("primaryActivityOfMember");
    public By UpdateReasonField = By.id("UpdateReason");
    public By VoteYesRedioBtn = By.xpath("//label[text()='Yes']");
    public By saveBtn = By.xpath("//button[text()='Save']");
    public By natureOfInterestField = By.id("natureOfInterest");
    public By statusField = By.name("Status");
    public By committeeEditBtn = By.xpath("//section[@class='subCommInfo']//a[@title='Edit']");
    public By committeeInactiveRadioBtn = By.xpath("//div[@data-testid='inactive']");
    public By InactiveReasonField = By.id("InactiveReason");
    public By ReasonForUpdateField = By.xpath("//textarea[@placeholder='Please enter reason for update']");
    public By updateBtn = By.xpath("//*[contains(@class,'updateBtn')]");
    public By arrowLeftIcon = By.xpath("//i[@class='arrow left icon']");
    public By updateBtnInCommitteeRosterTab = By.xpath("//a[@data-testid='updateBtn']/i");
    public By threeDotsIcon = By.xpath("//div[@class='comDetailsAction']");
    public By CopyMembers = By.xpath("//button[text()='Copy Members']");

    public By toCommitteeField = By.xpath("//div[@data-testid='toCommittee']/div/input");
    public By copyBtn = By.xpath("//button[text()='Copy']");
    public By itemsPerPageHeader = By.xpath("//span[text()='items per page']");
    public By SuppressCommitteeFromPublicWebCheckBox = By.xpath("//label[contains(text(),'Suppress committee from public web')]");
    public By SuppressCommitteeFromPublicWebCheckBoxChecked = By.xpath("//div[@class='ui checked checkbox']/input");
    public By EnableStudentMemberCheckBoxChecked = By.xpath("//div[@data-testid=\"Enable student member program\"]");
    public By NewOrExistingMemberJoinCheckBox = By.xpath("//label[contains(text(),'new or existing Member to join')]");
    public By NewOrExistingMemberJoinCheckBoxChecked = By.xpath("//div[@class='ui checked checkbox']//label[contains(text(),'new or existing Member to join')]");
    public By EditingWorkItemOrSubmittingBallotItemCheckBox = By.xpath("//label[contains(text(),'editing a work item or submitting a ballot item')]");
    public By EditingWorkItemOrSubmittingBallotItemCheckBoxChecked = By.xpath("//div[@class='ui checked checkbox']/label[contains(text(),'editing a work item or submitting a ballot item')]");
    public By YESBtn = By.xpath("//button[text()='YES']");
    public By settings = By.xpath("//*[text()='Settings']");
    public By CommitteeOverview = By.xpath("(//div[@class='DraftEditor-editorContainer'])[1]/div");
    public By committeeScope = By.xpath("(//div[@class='DraftEditor-editorContainer'])[2]/div");
    public By showOfficersOnlyBtn = By.xpath("//*[text()='Show Officers Only']");
    public By excelBtn = By.xpath("//button[text()='Excel']");
    public By statisticalInformationHdr = By.xpath("//*[text()='Statistical Information']");
    public By totalMembersCount = By.xpath("//*[@class='count']");
    public By committeeOverview = By.xpath("//span[text()='Overview']");
    public void getSelectCommitteeType(String CommitteeType) {
        driver.findElement(By.xpath("//span[text()='"+CommitteeType+"']")).click();
    }
    public String SettingsEdit = "(//h5[text()='Settings']//following::span[@title='Edit'])[[INDEX]]/i";
    public By getSettingsEditButton(int index){
        return By.xpath(SettingsEdit.replace("[INDEX]", Integer.toString(index)));
    }
    public void clickSettingsEdit(int index) {
        driver.findElement(By.xpath(SettingsEdit.replace("[INDEX]", Integer.toString(index)))).click();
    }
    public void getSelectCommitteeHierarchy(String CommitteeHierarchy) {
        driver.findElement(By.xpath("//span[text()='"+CommitteeHierarchy+"']")).click();
    }
    public void getClassification() {
        driver.findElement(By.xpath("//span[text()='Classified']")).click();
    }
    public void getPrimaryActivityOfMember(String ActivityOfMember) {
        driver.findElement(By.xpath("//div[@activityname='"+ActivityOfMember+"']")).click();
    }
    public String getSelectCommitte(String committe) {
        driver.findElement(By.xpath("//a[text()='"+committe+"']")).click();
        return committe;
    }
    public void getInactiveReason(String Reason) {
        driver.findElement(By.xpath("//span[text()='"+Reason+"']")).click();
    }
    public void getSelectStatus(String status) {
        driver.findElement(By.xpath("//div[@name='Status']//span[text()='"+status+"']")).click();
    }
    public void getSelectAccount(String accountNum) {
        driver.findElement(By.xpath("//div[@accountnumber='"+accountNum+"']")).click();
    }
    public By getAccount(String accountNum) {
        return By.xpath("//a[text()='"+accountNum+"']");
    }
    public void getSelectCommittee(String Committee) {
        driver.findElement(By.xpath("//div[@committeedesignation='"+Committee+"']")).click();
    }
    public WebElement getAccountStatus(String account) {
        return getElement(By.xpath("//a[text()='"+account+"']/../..//td/p[contains(@class,'CommitteeStatus')]"));
    }
    public String getCommitteeRosterMemberName(int index) {
        return getElement(By.xpath("(//p[contains(@class,'MemberDetail_FullName')])["+index+"]")).getText().replaceAll(" ","");
    }
    public String getCommitteeRosterOfficerTitle(int index) {
        return getElement(By.xpath("(//p[contains(@class,'OfficerTitleName')])["+index+"]")).getText().replaceAll(" ","");
    }
    public List<WebElement> getCommitteeRosterCustomGridCount() {
        return  getElements(By.xpath("//*[@id='customGrid']//tr"));
    }
    public List<WebElement> getOverviewOfCommittee() {
        return  getElements(By.xpath("//span[text()='Overview']/..//a"));
    }
    public By topMessage_Close = By.cssSelector(".top-message .close");
    public By AddCommittee_SelectMainCommittee_Input = By.cssSelector(".prompt");
    public By AddCommittee_SubmitButton = By.cssSelector("button[data-testid='submitOK']");
    public void selectFiledFromDropDown(String field) {
        WebElement filedName=getElement(By.xpath("//span[@class='rdw-suggestion-option' and text()='"+field+"']"));
        PublicAdminCommons.scrollToElement(driver,filedName);
        filedName.click();
    }
    public void selectFiledFromDropDown_1(String field) {
        WebElement filedName=getElement(By.xpath("//span[@class='rdw-suggestion-option' and text()='"+field+"']"));
        PublicAdminCommons.scrollToElement(driver,filedName);
        filedName.click();
        filedName.click();
    }
    @Step("Add new committee")
    public String addNewCommittee(String CommitteName,String CommitteeHierarchy,String Title) {
        try {
            getElement(committeeTab).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            PublicCommon.waitForSec(3);
            getElement(addCommitteeBtn).click();
            getElement(selectCommitteeType).click();
            getSelectCommitteeType(CommitteName);
            getElement(selectCommitteeHierarchy).click();
            getSelectCommitteeHierarchy(CommitteeHierarchy);
            getElement(oKBtn).click();
            String committee=generateRandomSubCommittee();
            getElement(TitleField).sendKeys(Title);
            ReusableMethods.scrollIntoView(getElement(CreateBtn),driver);
            getElement(CreateBtn).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            if(driver.findElements(topMessage_Close).size() > 0){
                try {
                    getElement(topMessage_Close).click();
                }
                catch (Exception e){

                }
            }
            PublicCommon.waitForSec(3);
            return  committee;
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Exception in adding new committee", e);
        }
        return null;
    }
    @Step("Generate random Committee Designation")
    public String generateRandomSubCommittee() {

        String CommitteeDesignation=null;
        try {
            Thread.sleep(3000);
            for(int i=0;i<5;i++) {
                /*CommitteeDesignation = getRandomAlphaNumericString(2).toUpperCase();*/
                CommitteeDesignation=getRandomString(1).concat(RandomStringUtils.getRandomNumbers(2));
                getElement(committeeDesignationField).click();
                getElement(committeeDesignationField).clear();
                getElement(committeeDesignationField).sendKeys(CommitteeDesignation);
                getElement(classificationField).click();
                getClassification();
                Thread.sleep(2000);
                getElement(BosVolume).click();
                getElement(BosVolume_Options).click();
               if(!PublicCommon.isWebElementDisplayed(driver,DesignationAlreadyExistsMsg))
               {
                   break;
               }
            }
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Exception in genetating random committee", e);
        }
        return CommitteeDesignation;
    }

    @Step("Generate random Sub Committee for a given Committee")
    public String generateRandomSubCommitteeForGivenCommittee(String Committee, String Title){
        String SubCommitteeName = "";
        try {
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(committeeTab).click();
            WaitStatementUtils.waitForElementToBeClickable(driver, getElement(addCommitteeBtn));
            Thread.sleep(3000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(addCommitteeBtn).click();
            Thread.sleep(2000);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(selectCommitteeType).click();
            getSelectCommitteeType("Technical Committee");
            getElement(selectCommitteeHierarchy).click();
            getSelectCommitteeHierarchy("Sub Committee");
            getElement(AddCommittee_SelectMainCommittee_Input).sendKeys(Committee);
            getElement(eventNamesVisible).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            getElement(AddCommittee_SubmitButton).click();
            SubCommitteeName = generateRandomSubCommittee();

            getElement(TitleField).sendKeys(Title);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            ReusableMethods.scrollIntoView(getElement(CreateBtn),driver);
            getElement(CreateBtn).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            if(driver.findElements(topMessage_Close).size() > 0){
                try {
                    getElement(topMessage_Close).click();
                }
                catch (Exception e){

                }
            }

        }catch (Exception e){
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to Create SubCommittee", e);
        }
        return SubCommitteeName;
    }

    @Step("Generate random Committee Designation")
    public String generateRandomCommittee1() {
        String CommitteeDesignation=null;
        try {
            for(int i=0;i<5;i++) {

                CommitteeDesignation = PublicAdminCommons.getCurrentDateWithFormat("dd/MM/yyyy");
                String c=PublicAdminCommons.getYesterdayDate("dd/MM/yyyy");
                String a=CommitteeDesignation.replaceAll("/","");
                String b=a.substring(0,3);
                getElement(committeeDesignationField).click();
                getElement(committeeDesignationField).clear();
                getElement(committeeDesignationField).sendKeys(CommitteeDesignation);
                getElement(classificationField).click();
                getClassification();
                if(!PublicCommon.isWebElementDisplayed(driver,DesignationAlreadyExistsMsg))
                {
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Exception in genetating random committee", e);
        }
        return CommitteeDesignation;
    }
    public static String getRandomString(int inputCharCount)
    {
        try {
            RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('A', 'Z').build();
            String randomLetters = generator.generate(inputCharCount);
            return randomLetters;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static String getRandomNumber(int numDigits)
    {
        try {
            if (numDigits <= 0) {
                System.out.println("Number of digits should be greater than zero.");
                return null;
            }

            Random random = new Random();
            int minBound = (int) Math.pow(10, numDigits - 1); // Minimum bound for the number of digits
            int maxBound = (int) Math.pow(10, numDigits) - 1; // Maximum bound for the number of digits
            int randomNumber = random.nextInt(maxBound - minBound + 1) + minBound;
            return String.valueOf(randomNumber);
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Unable to generate Random Number",e);
        }
        return null;
    }

    public static String getRandomAlphaNumericString(int CharCount)
    {
        try {
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

            StringBuilder sb = new StringBuilder(CharCount);

            for (int i = 0; i < CharCount; i++) {

                int index = (int)(AlphaNumericString.length() * Math.random());

                sb.append(AlphaNumericString.charAt(index));
            }

            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Step("Change member status Active to Inactive")
    public void changeMemberStatusActiveToInactive(List<String> accountsList) {
        try {
            for(String account : accountsList) {
                membershipData.getSelectNum(account);
                waitForLoadingScreenToDisappear(MCS2Application.mcs2PageLoader);
                getElement(committeeEditBtn).click();
                ScreenshotUtil.takeScreenshotForAllure(driver);
                waitForLoadingScreenToDisappear(MCS2Application.mcs2PageLoader);
                getElement(committeeInactiveRadioBtn).click();
                getElement(InactiveReasonField).click();
                getInactiveReason("COMMITTEE REMOVED");
                getElement(ReasonForUpdateField).sendKeys("Test");
                getElement(updateBtn).click();
                waitForLoadingScreenToDisappear(MCS2Application.mcs2PageLoader);
                PublicCommon.waitForSec(5);
                ScreenshotUtil.takeScreenshotForAllure(driver);
                getElement(arrowLeftIcon).click();
                waitForLoadingScreenToDisappear(MCS2Application.mcs2PageLoader);
            }
            getElement(statusField).click();
            getSelectStatus("All");
            ReusableMethods.scrollIntoView(getElement(itemsPerPageHeader),driver);
            getElement(updateBtnInCommitteeRosterTab).click();
            ReusableMethods.scrollIntoView(getElement(itemsPerPageHeader),driver);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert(" unable to Change member status Active to Inactive", e);
        }
    }
    @Step("Admin/ISS Agent waits for loading screen to disappear")
    public void waitForLoadingScreenToDisappear(By locator) {
        try {
            Assert.assertTrue(PublicAdminCommons.handleSpinnerIconOnMagento(driver, locator),
                    "Loading screen did not disapeear.");
        } catch (Exception e) {
            e.printStackTrace();
            PublicAdminCommons.reportFailAssert("Loading screen did not disapeear.", e);
        }
    }
    @Step("Add members to the committee")
    public void addMembersToCommittee(List<String> accountsList) {
        try {
            for(String account : accountsList) {
                getElement(CommitteeRosterTab).click();
                getElement(AddMemberToCommitteeBtn).click();
                waitForLoadingScreenToDisappear(MCS2Application.mcs2PageLoader);
                getElement(searchMember).sendKeys(account);
                PublicCommon.waitForSec(2);
                getSelectAccount(account);
                getElement(VoteYesRedioBtn).click();
                ReusableMethods.scrollIntoView(getElement(primaryActivityOfMemberField),driver);
                getElement(primaryActivityOfMemberField).click();
                getPrimaryActivityOfMember("Academia");
                getElement(natureOfInterestField).sendKeys("Test");
                getElement(UpdateReasonField).sendKeys("Test");
                getElement(saveBtn).click();
                waitForLoadingScreenToDisappear(MCS2Application.mcs2PageLoader);
                ScreenshotUtil.takeScreenshotForAllure(driver);
                PublicCommon.waitForSec(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert(" unable to Add members to the committee", e);
        }
    }
    @Step("search committee in search box ")
    public void searchCommitteeInIAApplication(String committee) {
        try {
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(committeeTab), 10);
            getElement(committeeTab).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            PublicCommon.waitForSec(3);
            WaitStatementUtils.waitForElementToBeClickable(driver,getElement(membershipData.searchBox), 5);
            getElement(membershipData.searchBox).sendKeys(committee);
            getElement(membershipData.searchButton).click();
            ScreenshotUtil.takeScreenshotForAllure(driver);
            PublicCommon.waitForSec(3);
            getSelectCommitte(committee);
            PublicCommon.waitForSec(10);
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("search committee in search box ", e);
        }
    }
}
