package pages.ui;

import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.utils.ReusableMethods;

import java.util.HashMap;
import java.util.List;

/**
 * @author aditya.joshi
 *
 */
public class CreateGroupPage extends BasePage {

	public CreateGroupPage(WebDriver driver) {
		super(driver);
	}
	
	
	public By createGroupHeader =By.className("astm-type-heading--h1");
	public By manageBallotsTab=By.xpath("//a[text()='Manage Ballots'] | //a[text()='Manage Polls']");
	public By deleteBallotsTab=By.xpath("//a[text()='Delete Ballot'] |//a[text()='Delete Polls']");
	public By manageGroupsTab=By.xpath("//div[@class='top-nav-display']//child::ul[1]//li[1]");

	private By nameOfGroup = By.cssSelector("input[name='groupName']");
	public By collabAreaAdministratorDropDown = By.xpath("//label[contains(text(),'Collaboration')]//following::select[@aria-label='Select Value'][1]");
	public By groupAdminDropDown = By.xpath("(//label[contains(text(),'Group')]//following::select[@aria-label='Select Value'])[1]");

	public By secondGroupAdminDropDown = By.xpath("(//label[contains(text(),'Group')]//following::select[@aria-label='Select Value'])[2]");
	private By parentGroupDropDown = By.cssSelector("div.row:nth-child(4) select");
	public By groupDescriptionTextArea = By.cssSelector("div.row:nth-child(5) textarea");
	public By addCollabTextArea = By.cssSelector("div.row:nth-child(8) textarea");
	private By findMemeberTextField = By.cssSelector("input[name='searchMember']");
	private By addToGroupArrowButton = By.xpath("//button[@aria-label='Add member']");
	public By removeMemberForGroup = By.xpath("//button[@aria-label='Remove Member']");
	public By createGroupButton = By.xpath("//button[contains(text(), 'Create')]");
	public By groupCreatedSuccessMsg = By.xpath("//div[text()='Group created/updated successfully']");
	public By informationButton =By.xpath("//div[@class='astm-info-wrapper']//i");
	private By informationText =By.className("astm-info-txt");
	public By groupMembersSelect = By.xpath("//a[text()='Select All']//following::select[2]");
	public By CreateNewCollabHeading = By.xpath("//div[@class='astm-type-heading--h1']");
	public By CommitteeGrpRadioBtn = By.xpath("//div[@class='form-check']/input");
	public By SelectommitteeDropdown = By.xpath("//label[contains(text(),'Select Committee ')]//following::select[@aria-label='Select Value'][1]");

	public By groupMembersSelectS = By.xpath("//a[@class='footer_bottom_link'][contains(.,'Home')]");
	public By additionalMember = By.xpath("//textarea[@name='additionalMembers']");
	public By Groupdropdown = By.xpath("//div[@class='the-dropdown']//select[1]");
	public By addSecondAdmin = By.xpath("//div[text()='Add a second ']");
	public By selectSecondAdmin = By.xpath("//label[contains(text(),'Second')]//following::select[1]");
	public By quickSaveMemberBtn = By.xpath("//button[text()='Save Vote']");
	public By manageDraftTab=By.xpath("//a[text()='Manage Drafts']");
	public By deleteDraftTab=By.xpath("//a[text()='Delete Draft'] | //a[text()='Delete Drafts'] ");
	public  By deleteButton=By.xpath("//button[text()='Delete']");
	public By latestPollVoteStatus = By.xpath("//div[@class='dashboard-ballot-wrapper']//tbody//tr[1]//td[4]//span");
	public  By YesButton=By.xpath("//input[@name='uploadAllCan' and @value='Yes']");
	public  By NoButton=By.xpath("//input[@name='uploadAllCan' and @value='No']");
	public By emailDisplayName = By.xpath("//input[@name='groupEmailDisplayName']");

	public WebElement getGroupDescriptionTextArea() 
	{
	return	getElement(groupDescriptionTextArea);
		
	}

	public WebElement getCollabDescriptionTextArea()
	{
		return	getElement(addCollabTextArea);

	}
	
	
	

	/**
	 * This method checks information Button text
	 * 
	 * @return Text as String
	 */
	public String getInformationTxt() {
		try {
			return getElement(informationText).getText();
		} catch (Exception e) {
			e.getStackTrace();
			return null;// TODO: handle exception
		}
	}
	
	
	public By getNewGroupNotiXpath(String option) {
		return By.xpath("//input[@name='notifyNewGroup' and @value='"+option+"']");
	}

	public By getEditGroupNotiXpath(String option) {
		return By.xpath("//input[@name='notifyEditGroup' and @value='"+option+"']");
	}

	public By getNewBallotNotiXpath(String option) {
		return By.xpath("//input[@name='notifyNewBallot' and @value='"+option+"']");
	}

	public By getVotingNotiXpath(String option) {
		return By.xpath("//input[@name='notifyVotingReminder' and @value='"+option+"']");
	}

	public By getNewDiscussionNotiXpath(String option) {
		return By.xpath("//input[@name='notifyNewDiscussion' and @value='"+option+"']");
	}

	public By getNewDiscussionReplyNotiXpath(String option) {
		return By.xpath("//input[@name='notifyDiscussionReply' and @value='"+option+"']");
	}

	public By getNewDraftNotiXpath(String option) {
		return By.xpath("//input[@name='notifyNewDraft' and @value='"+option+"']");
	}

	public By getNewFileNotiXpath(String option) {
		return By.xpath("//input[@name='notifyNewFile' and @value='"+option+"']");
	}

	public By getAllUploadRadioButtonXpath(String option) {
		return By.xpath("//input[@name='uploadAllCan' and @value='"+option+"']");
	}

	public By getInitialDraftXpath(String option) {
		return By.xpath("//input[@name='isUploadNow' and @value='"+option+"']");
	}
	
	public By getAllFilesXpath(String option) {
		return By.xpath("//input[@name='uploadAllSupportCan' and @value='"+option+"']");
	}
	
	public By homeBtn = By.xpath("//span[text()='Home']");
	public By QuickSave = By.xpath("//button[contains(@aria-label,'Quick Save')]");
	public By memberSelector = By.xpath("//a[text()='Select All']//following::select[1]");

	/**
	 * Enter text in group name
	 * 
	 * @param value
	 * @return
	 */
	
	
	
	public boolean enterTextInNameOfGroup(String value) {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(nameOfGroup));
			getElement(nameOfGroup).clear();
			getElement(nameOfGroup).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects group admin
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionIncollabAreaAdministratorDropDown(String value) {
		try {
			WebElement element = getElement(collabAreaAdministratorDropDown);
			ReusableMethods.scrollIntoView(element,driver);
			Select select = new Select(element);
			select.selectByValue(value);
			element.click();
			return true;

				} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean selectOptionInGroupAdminDropDown(String value) {
		try {
			WebElement element = getElement(groupAdminDropDown);
			ReusableMethods.scrollIntoView(element,driver);
			Select select = new Select(element);
			select.selectByValue(value);
			element.click();
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean selectOptionInSecondGroupAdminDropDown(String value) {
		try {
			WebElement element = getElement(secondGroupAdminDropDown);
			ReusableMethods.scrollIntoView(element,driver);
			Select select = new Select(element);
			select.selectByValue(value);
			element.click();
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}



	@Step("Select Committee Sponsoring the Administrative Work Item:")
	public boolean selectCommittee(String value) {
		try {
			WebElement element = getElement(SelectommitteeDropdown);
			ReusableMethods.scrollIntoView(element,driver);
			Select select = new Select(element);
			select.selectByValue(value);
			element.click();
			PublicCommon.waitForSec(15);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	
	
	/**
	 * Selects group admin
	 * 
	 * @param value
	 * @return
	 * 
	 * 
	 * 
	 */
	
	
	
	
	public boolean selectSecondaryGroupAdmin(String value) {
		try {
			WebElement element = getElement(selectSecondAdmin);
			Select select = new Select(element);
			select.selectByValue(value);
			element.click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * Selects group admin
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectParentGroup(String value) {
		try {
			WebElement element = getElement(parentGroupDropDown);
			Select select = new Select(element);
			select.selectByValue(value);
			element.click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean editPrimaryAdmin(String value) {
		try {
			WebElement element = getElement(groupAdminDropDown);
			Select select = new Select(element);
			select.selectByValue(value);
			element.click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public String getPrimaryAdmin(String value) {
		try {
			WebElement element = getElement(groupAdminDropDown);
			Select select = new Select(element);
			select.selectByValue(value);
			element.click();
			WebElement text = select.getFirstSelectedOption();
			String admin = text.getText();
			System.out.println(admin);
			return admin;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getSecondaryAdmin(String value) {
		try {
		WebElement element = getElement(selectSecondAdmin);
			Select select = new Select(element);
//			select.selectByValue(value);
		//	element.click();
			WebElement text = select.getFirstSelectedOption();
			String admin = text.getText();
			System.out.println(admin);
			return admin;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	/**
	 * Selects group admin
	 * 
	 * @param value
	 * @return
	 */
	public boolean selectOptionInGroupAdminForDraftDropDown(String value) {
		try {
			WebElement element = getElement(groupAdminDropDown);
			Select select = new Select(element);
			select.selectByValue(value);
			element.click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects parent group
	 * 
	 * @param index
	 * @return
	 */
	public boolean selectOptionInParentGroupDropDown(int index) {
		try {
			WebElement element = getElement(parentGroupDropDown);
			Select select = new Select(element);
			select.selectByIndex(index - 1);
			element.click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Enter text in group description
	 * 
	 * @param value
	 * @return
	 */
	public boolean enterTextInCollabDescriptionTextArea(String value) {
		try {
			getCollabDescriptionTextArea().sendKeys(value);
			Thread.sleep(2000);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean enterTextInGroupDescriptionTextArea(String value) {
		try {
			getGroupDescriptionTextArea().sendKeys(value);
			Thread.sleep(2000);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Enter text in find member field
	 * 
	 * @param value
	 * @return
	 */
	public boolean enterTextInFindMemeberTextField(String value) {
		try {
			getElement(findMemeberTextField).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Click Add to Group Right button
	 * 
	 * @return
	 */
	public boolean clickAddToGroupArrowButton() {
		try {
			getElement(addToGroupArrowButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * Click remove to Group left button
	 * 
	 * @return
	 */
	public boolean clickRemoveToGroupArrowButton() {
		try {
			getElement(removeMemberForGroup).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Click create group button
	 * 
	 * @return
	 */
	public boolean clickCreateGroupButton() {
		try {
			PublicCommon.waitForSec(15);
			WebElement element = getElement(createGroupButton);
			//getElement(createGroupButton).click();
			ReusableMethods.scrollIntoView(element, driver);
			element.click();
			PublicCommon.waitForSec(5);
			//element.click();
			/*if(WaitStatementUtils.waitForElementToBeClickable(driver,element,5)){
				element.click();
			}*/
			//WaitStatementUtils.explicitWait(driver,getElement(groupCreatedSuccessMsg));
			//ScreenshotUtil.takeScreenshotForAllure(driver);
			ScreenshotUtil.takeFullPageScreenshot();

			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean clickCreateGroupButtonErrValidation() {
		try {
			PublicCommon.waitForSec(15);
			WebElement element = getElement(createGroupButton);
			WaitStatementUtils.waitForElementToBeClickable(driver, element);
			ReusableMethods.scrollIntoView(element, driver);
			element.click();
			ScreenshotUtil.takeFullPageScreenshot();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	
	public boolean clickGroupButton() {
		try {
			getElement(groupAdminDropDown).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * Click second admin
	 * 
	 * @return
	 */
	public boolean clickAddSecondAdminLink() {
		try {
			getElement(addSecondAdmin).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean emailDisplayName(String name) {
		try {
			getElement(emailDisplayName).sendKeys(name);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	/**
	 * Selects New Group Notification
	 * 
	 * @param option
	 * @return
	 */
	public boolean selectOptionFromNewGroupNotificationRadioButton(String option) {
		try {
			ReusableMethods.SCrollIntoView(driver);
			getElement(getNewGroupNotiXpath(option)).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects Edit Group Notification
	 * 
	 * @param option
	 * @return
	 */
	public boolean selectOptionFromEditCollaborationNotificationRadioButton(String option) {
		try {
			WebElement ele = getElement(getEditGroupNotiXpath(option));
			ReusableMethods.scrollIntoView(ele,driver);
			ele.click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects New Ballot Notification
	 * 
	 * @param option
	 * @return
	 */
	public boolean selectOptionFromNewBallotNotificationRadioButton(String option) {
		try {
			getElement(getNewBallotNotiXpath(option)).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects Voting Reminder Notification
	 * 
	 * @param option
	 * @return
	 */
	public boolean selectOptionFromVotingReminderNotificationRadioButton(String option) {
		try {
			getElement(getVotingNotiXpath(option)).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects New Discussion Notification
	 * 
	 * @param option
	 * @return
	 */
	public boolean selectOptionFromNewDiscussionNotificationRadioButton(String option) {
		try {
			getElement(getNewDiscussionNotiXpath(option)).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects New Discussion Reply Notification
	 * 
	 * @param option
	 * @return
	 */
	public boolean selectOptionFromNewDiscussionReplyNotificationRadioButton(String option) {
		try {
			getElement(getNewDiscussionReplyNotiXpath(option)).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects New Draft Notification
	 * 
	 * @param option
	 * @return
	 */
	public boolean selectOptionFromNewDraftNotificationRadioButton(String option) {
		try {
			getElement(getNewDraftNotiXpath(option)).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects New File Notification
	 * 
	 * @param option
	 * @return
	 */
	public boolean selectOptionFromNewFileNotificationRadioButton(String option) {
		try {
			getElement(getNewFileNotiXpath(option)).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects File Upload for All User Radio Button
	 * 
	 * @param option
	 * @return
	 */
	public boolean selectOptionFromAllUserUploadRadioButton(String option) {
		try {
			
			
			WebElement element = getElement(YesButton);
			ReusableMethods.scrollIntoView(element, driver);
			element.click();
			//getElement(createGroupButton).click();
			//ReusableMethods.scrollIntoView(element, driver);
			//getElement(getAllUploadRadioButtonXpath(option)).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * Selects Upload Initial Draft Notification
	 * 
	 * @param option
	 * @return
	 */
	public boolean selectOptionFromUploadInitialDraftRadioButton(String option) {
		try {
			getElement(getInitialDraftXpath(option)).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * Select Files Notification
	 * 
	 * @param option
	 * @return
	 */
	public boolean selectOptionFromAllSupportFilesRadioButton(String option) {
		try {
			getElement(getAllFilesXpath(option)).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/** 
	 * Clicks on Home Button
	 * 
	 * **/
	/**
	 * @return
	 */
	public boolean clickHomeButton() {
		try {
			WebElement ele = getElement(homeBtn);
			WaitStatementUtils.waitForElementToBeClickable(driver,  ele); // added by Poli
;			ReusableMethods.scrollIntoView(ele, driver);;
           ele.click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean clickQuickSaveButton() {
		try {
			getElement(QuickSave).click();
		//	Thread.sleep(3000);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean clickPoll() {
		try {
			getElement(latestPollVoteStatus).click();
		//	Thread.sleep(3000);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * Selects first person in list to add in the group
	 * 
	 * **/
	/**
	 * @return
	 */
	public boolean selectUsersInListToAddToGroup() {
		try {
			WebElement element = getElement(memberSelector);
			Select select = new Select(element);
			select.selectByValue("368");
			getElement(addToGroupArrowButton).click();
			select.selectByValue("369");
			getElement(addToGroupArrowButton).click();
			select.selectByValue("370");
			getElement(addToGroupArrowButton).click();
			select.selectByValue("359");
			getElement(addToGroupArrowButton).click();
			select.selectByValue("360");
			getElement(addToGroupArrowButton).click();
			select.selectByValue("361");
			getElement(addToGroupArrowButton).click();
			element.click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	public boolean selectUsersInListToAdd(String value) {
		try {
			WebElement element = getElement(memberSelector);
			Select select = new Select(element);
			select.selectByValue(value);
			getElement(addToGroupArrowButton).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	/**
	 * Selects  person in list to add in the group
	 * 
	 * **/
	/**
	 * @return
	 */
	public boolean selectFirstPersonInListToAddToGroup() {
		try {
			WebElement element = getElement(memberSelector);
			Select select = new Select(element);
			select.selectByIndex(2);
			element.click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * Selects Members to add in the group
	 * 
	 * **/
	/**
	 * @return
	 */
	public boolean selectMembersToRemovefromGroup(String memberValue) {
		try {
			Thread.sleep(7000);
			WebElement element = getElement(groupMembersSelect);
			Select select = new Select(element);
	//		select.selectByValue(memberValue);
			select.selectByIndex(1);
			element.click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * Selects Members to add in the group
	 * 
	 * **/
	/**
	 * @return
	 */
	public boolean selectMembersToAddToGroup(String memberValue) {
		try {
	//		String value = driver.findElement(By.xpath("//a[text()='Select All']//following::select[1]//option[text()='"+memberValue+"']")).getAttribute("value");
		//	WebElement element = getElement(memberSelector);
		//	System.out.println(value);
//			Select select = new Select(getElement(memberSelector));
//			select.deselectByVisibleText(memberValue);
		//	select.selectByValue(value);
		//	select.getFirstSelectedOption().click();
		//	element.click();
			driver.findElement(By.xpath("//a[text()='Select All']//following::select[1]//option[text()='"+memberValue+"']")).click();
			clickAddToGroupArrowButton();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * Selects Members to add in the group
	 * 
	 * **/
	/**
	 * @return
	 */
	public boolean selectMembersToAddTwoMembersToGroup(String memberValue, String memberValue1) {
			try {
				WebElement element = getElement(memberSelector);
				Select select = new Select(element);
				select.selectByValue(memberValue);
				element.click();
				
				select.selectByValue(memberValue1);
				element.click();
				return true;
			} catch (Exception e) {
				e.getStackTrace();
				return false;
			}
	}
	
	public boolean enterAdditionalMember(String memberValue1) {
		try {
			getElement(additionalMember).clear();
			getElement(additionalMember).sendKeys(memberValue1);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
}
	
	
	/** 
	 * Validates the error message for required fields
	 * 
	 * **/
	/**
	 * @param stringToValidate
	 * @return
	 */
	public boolean validateRequiredFieldErrorPopup(String stringToValidate) {
		try {
			Thread.sleep(5000);  //remove this
			String message = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			if(message.contains(stringToValidate)) {
				return true;
			}
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	
	
	/**
	 * Selects parent group
	 * 
	 * @param index
	 * @return
	 */
	public String getParentGroupDropDown(int index) {
		try {
			WebElement element = getElement(parentGroupDropDown);
			Select select = new Select(element);
			select.selectByIndex(index - 1);
			WebElement text = select.getFirstSelectedOption();
			String value = text.getText();
			System.out.println(value);
			return value;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public boolean createGroup(String name, String value, String Desc,String newGrpNtf, String EditColb, String newBallot, String voting, String newDiscuss, String newDiscReply, String newDraft, String newFile, String userUpload, String initialDraft, String supportFile) {
		try {
			enterTextInNameOfGroup(name);
			ReusableMethods.SCrollIntoView(driver);
			selectOptionInGroupAdminDropDown(value);
			enterTextInGroupDescriptionTextArea(Desc);
			selectOptionFromNewGroupNotificationRadioButton(newGrpNtf);
			selectOptionFromEditCollaborationNotificationRadioButton(EditColb);
			selectOptionFromNewBallotNotificationRadioButton(newBallot);
			selectOptionFromVotingReminderNotificationRadioButton(voting);
			selectOptionFromNewDiscussionNotificationRadioButton(newDiscuss);
			selectOptionFromNewDiscussionReplyNotificationRadioButton(newDiscReply);
			selectOptionFromNewDraftNotificationRadioButton(newDraft);
			selectOptionFromNewFileNotificationRadioButton(newFile);
			Thread.sleep(3000);
			ReusableMethods.SCrollIntoView(driver);
			selectOptionFromAllUserUploadRadioButton(userUpload);
		//	ReusableMethods.SCrollIntoView(driver);
			selectOptionFromUploadInitialDraftRadioButton(initialDraft);
			selectOptionFromAllSupportFilesRadioButton(supportFile);
			//selectOptionFromAllUserUploadRadioButton(userUpload);
			ReusableMethods.SCrollIntoView(driver);
			Thread.sleep(10000);
			clickCreateGroupButton();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean createGroupwithAdditionalMembers(String name, String value, String Desc, String memberValue1,String memberValue2, String newGrpNtf, String EditColb, String newBallot, String voting, String newDiscuss, String newDiscReply, String newDraft, String newFile, String userUpload, String initialDraft, String supportFile) {
		try {
			enterTextInNameOfGroup(name);
			selectOptionInGroupAdminDropDown(value);
			enterTextInGroupDescriptionTextArea(Desc);
			if(!memberValue1.equals("")) {
				selectMembersToAddToGroup(memberValue1);
			}
			if(!memberValue2.equals("")) {
				selectMembersToAddToGroup(memberValue2);
			}
			//enterAdditionalMember(memberValue);
			Thread.sleep(5000);
			selectOptionFromNewGroupNotificationRadioButton(newGrpNtf);
			selectOptionFromEditCollaborationNotificationRadioButton(EditColb);
			selectOptionFromNewBallotNotificationRadioButton(newBallot);
			selectOptionFromVotingReminderNotificationRadioButton(voting);
			selectOptionFromNewDiscussionNotificationRadioButton(newDiscuss);
			selectOptionFromNewDiscussionReplyNotificationRadioButton(newDiscReply);
			selectOptionFromNewDraftNotificationRadioButton(newDraft);
			selectOptionFromNewFileNotificationRadioButton(newFile);
			selectOptionFromAllUserUploadRadioButton(userUpload);
			selectOptionFromUploadInitialDraftRadioButton(initialDraft);
			selectOptionFromAllSupportFilesRadioButton(supportFile);
			clickCreateGroupButton();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean createGroupWithOutAddingMember(String name, String value, String Desc, String newGrpNtf, String EditColb, String newBallot, String voting, String newDiscuss, String newDiscReply, String newDraft, String newFile, String userUpload, String initialDraft, String supportFile) {
		try {
			enterTextInNameOfGroup(name);
			ReusableMethods.SCrollIntoView(driver);
			selectOptionInGroupAdminDropDown(value);
			enterTextInGroupDescriptionTextArea(Desc);
			//selectMembersToAddToGroup(memberValue);
			selectOptionFromNewGroupNotificationRadioButton(newGrpNtf);
			selectOptionFromEditCollaborationNotificationRadioButton(EditColb);
			selectOptionFromNewBallotNotificationRadioButton(newBallot);
			selectOptionFromVotingReminderNotificationRadioButton(voting);
			selectOptionFromNewDiscussionNotificationRadioButton(newDiscuss);
			selectOptionFromNewDiscussionReplyNotificationRadioButton(newDiscReply);
			selectOptionFromNewDraftNotificationRadioButton(newDraft);
			selectOptionFromNewFileNotificationRadioButton(newFile);
			Thread.sleep(3000);
			ReusableMethods.SCrollIntoView(driver);
			selectOptionFromAllUserUploadRadioButton(userUpload);
			selectOptionFromUploadInitialDraftRadioButton(initialDraft);
			selectOptionFromAllSupportFilesRadioButton(supportFile);
			ReusableMethods.SCrollIntoView(driver);
			clickCreateGroupButton();
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean createGroupWithSecondaryGroupAdmin(String name, String value, String admin2, String Desc, String newGrpNtf, String EditColb, String newBallot, String voting, String newDiscuss, String newDiscReply, String newDraft, String newFile, String userUpload, String initialDraft, String supportFile) {
		try {
			enterTextInNameOfGroup(name);
			selectOptionInGroupAdminDropDown(value);
			clickAddSecondAdminLink();
			selectSecondaryGroupAdmin(admin2);
			enterTextInGroupDescriptionTextArea(Desc);
			//selectMembersToAddToGroup(memberValue);
			selectOptionFromNewGroupNotificationRadioButton(newGrpNtf);
			selectOptionFromEditCollaborationNotificationRadioButton(EditColb);
			selectOptionFromNewBallotNotificationRadioButton(newBallot);
			selectOptionFromVotingReminderNotificationRadioButton(voting);
			selectOptionFromNewDiscussionNotificationRadioButton(newDiscuss);
			selectOptionFromNewDiscussionReplyNotificationRadioButton(newDiscReply);
			selectOptionFromNewDraftNotificationRadioButton(newDraft);
			selectOptionFromNewFileNotificationRadioButton(newFile);
			selectOptionFromAllUserUploadRadioButton(userUpload);
			selectOptionFromUploadInitialDraftRadioButton(initialDraft);
			selectOptionFromAllSupportFilesRadioButton(supportFile);
			clickCreateGroupButton();
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	

	/**
	 * Get primary Member 
	 * 
	 * @param
	 * @return
	 */
	public boolean verifyMemberIsPresentInMemberBox (String adminValue) {
		try {
			WebElement element = getElement(groupMembersSelect);
			Select select = new Select(element);
			 List<WebElement> options = select.getOptions();
			 int size = options.size();
			 for (WebElement option : options) {
				 for (int i = 0; i < size; i++) {
			            if (option.getText().trim().equals(adminValue.trim())) {
			             return true;
			            }
			        }
			 }
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
		return false;
	}
	
	/**
	 * Get primary Member 
	 * 
	 * @param
	 * @return
	 */
	public String verifySecodMemberIsPresentInMemberBox () {
		try {
			WebElement element = getElement(groupMembersSelect);
			Select select = new Select(element);
			select.selectByIndex(2);
			WebElement text = select.getFirstSelectedOption();
			String value = text.getText();
			System.out.println(value);
			return value;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	/**
	 * Get primary Member 
	 * 
	 * @param
	 * @return
	 */
	public String verifyMemberIsPresentInMemberBox () {
		try {
			WebElement element = getElement(groupMembersSelect);
			Select select = new Select(element);
			select.selectByIndex(1);
			WebElement text = select.getFirstSelectedOption();
			String value = text.getText();
			System.out.println(value);
			return value;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	public boolean createGroupforDataCreation(HashMap<String,String> inputData,HashMap<String,String> inputData2) {
		try {
			enterTextInNameOfGroup(inputData.get("name"));
			selectOptionInGroupAdminDropDown(inputData2.get("GroupAdministrator"));
			clickAddSecondAdminLink();
			selectSecondaryGroupAdmin(inputData2.get("Second Group Administrator"));
			enterTextInGroupDescriptionTextArea(inputData.get("GroupDesc"));
			//selectMembersToAddToGroup(memberValue);
			enterAdditionalMember(inputData.get("Member"));
			selectOptionFromNewGroupNotificationRadioButton(inputData.get("Noti_NewGroup"));
			selectOptionFromEditCollaborationNotificationRadioButton(inputData.get("Noti_EditGroup"));
			selectOptionFromNewBallotNotificationRadioButton(inputData.get("Noti_NewBallot"));
			selectOptionFromVotingReminderNotificationRadioButton(inputData.get("Noti_VoteRemind"));
			selectOptionFromNewDiscussionNotificationRadioButton(inputData.get("Noti_NewDiscussion"));
			selectOptionFromNewDiscussionReplyNotificationRadioButton(inputData.get("Noti_NewDiscussionReply"));
			selectOptionFromNewDraftNotificationRadioButton(inputData.get("Noti_NewDraft"));
			selectOptionFromNewFileNotificationRadioButton(inputData.get("Noti_NewFile"));
			selectOptionFromAllUserUploadRadioButton(inputData.get("Upload_Permission"));
			selectOptionFromUploadInitialDraftRadioButton(inputData.get("Upload_Initial_Draft"));
			selectOptionFromAllSupportFilesRadioButton(inputData.get("supportFile"));
			clickCreateGroupButton();
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	
}
