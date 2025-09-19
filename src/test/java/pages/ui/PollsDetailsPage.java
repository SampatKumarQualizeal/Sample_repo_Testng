package pages.ui;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import base.utils.RandomStringUtils;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicAdminCommons;
import com.astm.commonFunctions.SpecBuilderCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PollsDetailsPage extends BasePage{

	public PollsDetailsPage(WebDriver driver) {
		super(driver);
	}

	public By openPolls = By.xpath("//a[text()='Open Poll(s)'] | //a[text()='Open Ballot(s)']");
	public By allPollReports = By.xpath("//a[text()='Poll Reports'] | //a[text()='Ballot Reports']");
	public By createNewPollButton = By.xpath("//button[contains(.,'Create New ')]");
	public By openPollsHeader = By.xpath("//div[contains(text(),'Open ')]");
	public By itemTitle = By.xpath("//table//thead//tr//th[2]");
	public By noPollsMsg = By.xpath("//div[contains(text(),'You have no ')]");
	public By itemNumber = By.xpath("//th[text()='Item #']");
	public By issueDate = By.xpath("//th[text()='Issue Date']");
	public By closingDate = By.xpath("//th[text()='Closing Date']");
	public By currentVote = By.xpath("//th[text()='Current Vote']");
	public By voteStatus = By.xpath("//th[text()='Vote Status']");
	public By itemNumberValue = By.xpath("//table//tbody//tr");
	public By firstPollLink = By.xpath("//table//tbody//tr[1]//td[2]//span");
	public By pollTitleHeader = By.xpath("//div[@class='astm-layout layout-position']//child::div[@class='astm-type-heading--h5 ']");
	public By commentHeader = By.xpath("//div[text()='Comment']");
	public By commentSection = By.xpath("//div[@class='form-group astm-textarea-wrapper']//textarea");
	public By addVoteFile = By.xpath("//button[text()='Add Vote File']");
	public By addFileDesc = By.xpath("//div[text()='Add File Description(Optional)']");
	public By clickToOpen = By.xpath("//div[text()='Click to Open']");
	public By saveVote = By.xpath("//button[text()='Save Vote']");
	public By returnToOpenPolls = By.xpath("//button[text()='Return To Open Polls'] | //button[contains(text(),'Return to Open ')]");
	public By returnToOpenPoll = By.xpath("//button[text()='Return to Files & Folders'] | //button[contains(text(),'Return to Files ')]");
	public By abstain = By.xpath("//label[text()='Abstain']");
	public By affirmative = By.xpath("//label[text()='Affirmative']//preceding::input");
	public By negative = By.xpath("//label[text()='Negative w/ Comment']");
	public By abstainRadioOption = By.xpath("//label[text()='Abstain']//preceding::input[1]");
	public By affirmativeRadioOption = By.xpath("//label[text()='Affirmative']//preceding::input[1]");
	public By negativeRadioOption = By.xpath("//label[text()='Negative w/ Comment']//preceding::input[1]");
	public By pollTitle = By.xpath("//div[@class='ballot-list-page-wrapper']//div//div[@class='astm-type-heading--h4 ']");
	public By removeFile =  By.xpath("//label[text()='Remove Current Comment File']//preceding::input[1]");
	public By replaceFile = By.xpath("//label[text()='Replace Current Comment File']//preceding::input[1]");
	public By keepCurrent = By.xpath("//label[text()='Keep Current Comment File']//preceding::input[1]");
	public By successMsg = By.xpath("//div[text()='create poll successfully']|//div[text()='create ballot successfully']");
	public By closeMsg = By.xpath("//button[contains(.,'Save Vote')]");
	public By itemtitleValue = By.xpath("//div[@class='ballot-list-page-wrapper']//div//div[@class='astm-type-heading--h4 ']");
	public By removeFileButton = By.xpath("//button[text()='Remove Vote File']");
	public By itemTitleLink = By.xpath("//table//tbody//tr[1]//td[2]//span[1]");
	public By itemFilesTitle = By.xpath("//h5[text()='ITEM FILES']");
	public By fileNumberHeader = By.xpath("//table//thead//th[text()='File Number']");
	public By fileTitleHeader = By.xpath("//table//thead//th[text()='File Title']");
	public By uploadedFileLink = By.xpath("//table//thead//th[text()='File Number']//following::tbody//tr[1]//td[2]//span");
	public By pollToVote = By.xpath("//table//tbody//tr[1]//td[2]");
	public By tableInPollTab = By.xpath("//div[contains(text(),'Open ')]//following::table");
	public By pollUploadSuccess = By.xpath("//div[text()='Sample.txt']");
	
	public By Pollmax255 = By.xpath("//small[@class='form-text'][contains(.,'Max 255 characters (255 remaining)')]");
	
	//Verify that Vote Management sub-menu is visible under Ballots
	public By VoteManagement = By.xpath("//a[contains(text(),'Vote Management')]");
	
	
	public By AllVoteReports = By.xpath("//div[text()='You have no reports at this time.']");
	public By selectHeader = By.xpath("//div[contains(text(),'Select ')]");
	public By editSelectGroup =  By.xpath("//div[@class='form-group astm-dropdown2-wrapper']//select[@class='form-control']");
	public By affirmativeVoteValue = By.xpath("//table[@class='table astm-table rd-vote-table']//tbody//tr[2]//td[1]");
	public By abstainVoteValue = By.xpath("//table[@class='table astm-table rd-vote-table']//tbody//tr[2]//td[3]");
	public By exportCSV = By.xpath("//span[text()='Export CSV']");
	public By exportXLSX = By.xpath("//span[text()='Export XLSX']");
	public By ballotCount = By.xpath("//tbody//tr");
	public By viewAllReportHeader =  By.xpath("//div[@class='astm-layout layout-position']//child::div[@class='one-group'][1]//div[1]//child::div[contains(text(),'To view the vote reports, click on the')][1]");
	public By viewItemNumberHeader = By.xpath("//div[@class='astm-layout layout-position']//child::div[@class='one-group'][1]//div[3]//child::thead//span[text()='Item Number']");
	public By viewItemNameHeader = By.xpath("//div[@class='astm-layout layout-position']//child::div[@class='one-group'][1]//div[3]//child::thead//span[text()='Item Name']");
	public By viewReportHeader = By.xpath("//div[@class='astm-layout layout-position']//child::div[@class='one-group'][1]//div[3]//child::thead//span[text()='Vote Report']");
	public By viewIssueDateHeader = By.xpath("//div[@class='astm-layout layout-position']//child::div[@class='one-group'][1]//div[3]//child::thead//span[text()='Issue Date']");
	public By viewCloseDate = By.xpath("//div[@class='astm-layout layout-position']//child::div[@class='one-group'][1]//div[3]//child::thead//span[text()='Close Date']");
	//public By viewReportLink = By.xpath("//div[@class='astm-layout layout-position']//child::div[@class='one-group'][1]//div[3]//child::tbody//td[3]//a");
	public By viewReportLink = By.xpath("//span[@class='astm-link the-link'][contains(.,'View Report')]");
	public By ballotNumber = By.xpath("//th[contains(.,'Ballot Number')]");
	public By sentHeader = By.xpath("//th[text()='Sent']");
	public By percentageReturn = By.xpath("//th[text()='% Returned']");
	public By affirmativeHeader = By.xpath("//th[contains(.,'Ballot Number')]//following::div[1]//table[1]//th[text()='Affirmative']");
	public By negativeComment = By.xpath("//th[contains(.,'Ballot Number')]//following::div[1]//table[1]//th[text()='Negative w/ Comment']");
	public By abstainHeader = By.xpath("//th[contains(.,'Ballot Number')]//following::div[1]//table[1]//th[text()='Abstain']");
	public By voterHeader = By.xpath("//th[contains(.,'Ballot Number')]//following::div[1]//table[2]//th[text()='Voter']");
	public By roleHeader = By.xpath("//th[contains(.,'Ballot Number')]//following::div[1]//table[2]//th[text()='Role']");
	public By answerHeader = By.xpath("//th[contains(.,'Ballot Number')]//following::div[1]//table[2]//th[text()='Answer']");
	public By viewCommentHeader = By.xpath("//th[contains(.,'Ballot Number')]//following::div[1]//table[2]//th[text()='Comment']");
	public By fileHeader = By.xpath("//th[contains(.,'Ballot Number')]//following::div[1]//table[2]//th[text()='File']");
	public By votingNoteHeader = By.xpath("//th[contains(.,'Ballot Number')]//following::div[1]//table[2]//th[text()='Voting Note']");
	public By voteDateHeader = By.xpath("//th[contains(.,'Ballot Number')]//following::div[1]//table[2]//th[text()='Vote Date']");
	public By companyHeader = By.xpath("//th[contains(.,'Ballot Number')]//following::div[1]//table[2]//th[text()='Company']");
	public By ballotItemNumber = By.xpath("//table[@class='table astm-table']//tbody//tr[1]//td[1]");
	public By sent = By.xpath("//table[@class='table astm-table']//tbody//td[2]");
	public By openBallotsTab = By.xpath("//a[text()='Open Ballot(s)']|//a[text()='Open Poll(s)']");
	public By ballotNumberOnViewPage = By.xpath("//table[@class='table astm-table']//tbody//tr[1]//td[1]");
	public By returnPercentageOnViewPage = By.xpath("//table[@class='table astm-table']//tbody//tr[1]//td[3]");
	public By voteTable = By.xpath("//div[@class='astm-type-heading--h4' and contains(string(),'3878')]//following::table[1]");
	//text and data
	public By headerText = By.xpath("//div[@class='astm-type-heading--h4']");
	public By newBallotNameData = By.xpath("//input[@type='text' and contains(@placeholder,'Insert Poll')]");
	public By headerRecirculation = By.xpath("//div[contains(text(),'recirculation')]");
	public By FormCheckNo = By.cssSelector("div.radio-group > div:nth-child(1) > input");
	public By FormCheckYes = By.cssSelector("div.radio-group > div:nth-child(2) > input");
	public By TextSelectBallotToRecirculate = By.xpath("(//div[@class='astm-type-heading--h5'])[1]");
	public By newBallotNameHeader = By.xpath("//div[@class='astm-type-heading--h5' and contains(string(),'New Poll')]");
	public By selectColabGroupForBallot = By.xpath("//select[@class='form-control' and @aria-label='Select Value']");
	public By ballotDesc = By.xpath("//div[@class='astm-type-heading--h5'][3]");
	public By chooseBallotIssueDateHeader = By.xpath("//div[@class='astm-type-heading--h5'][4]");
	public By chooseBallotIssueDateText = By.xpath("//div[@class='astm-type-heading--h5'][4]//following-sibling::div[1]");
	public By chooseBallotClosingDateHeader = By.xpath("//div[@class='astm-type-heading--h5'][5]");
	public By chooseEmailNotificationHeader = By.xpath("//div[@class='astm-type-heading--h5'][6]");
	public By chooseEmailNotificationText = By.xpath("//div[@class='astm-type-heading--h5'][6]//following-sibling::div[1]");
	public By noteText = By.xpath("//div[@class='text-danger']");
	public By RemainderHeader = By.xpath("//label[text()='Reminder 1:']");
	public By ballotItemNameHeader = By.xpath("//div[@class='astm-type-heading--h5' and contains(text(),'Poll Item')]");
	public By selectBallotItemHeader = By.xpath("//div[@class='astm-type-heading--h5' and contains(string(),'Select Poll')]");
	public By requireCommentText = By.xpath("//div[@class='astm-type-heading--h5' and contains(string(),'Select Poll')]//following::div[1]//child::label[contains(string(),'Require')]");
	public By countAsVoteText = By.xpath("//div[@class='astm-type-heading--h5' and contains(string(),'Select Poll')]//following::div[1]//child::label[contains(string(),'Count')]");
	public By uploadBallotItemHeader = By.xpath("//div[@class='astm-type-heading--h5' and contains(string(),'Upload Poll')]");
	public By uploadBallotItemText = By.xpath("//div[@class='astm-type-heading--h5' and contains(string(),'Upload Poll')]//following::div[1]");
	public By pollIDFromTable = By.xpath("//table//tbody//tr[1]//td[1]");
	public By noPollsInGroup = By.xpath("//div[@class='form-group astm-dropdown2-wrapper']//following::div[contains(text(),'Select ')]//following::select//option[contains(text(),'No')]");
	public By selectpoll = By.xpath("//div[@class='form-group astm-dropdown2-wrapper']//following::div[contains(text(),'Select ')]//following::select");
	public By selectDisabled = By.xpath("//div[@class='form-group astm-dropdown2-wrapper']//following::select[@disabled]");
	public By headerBallotReports = By.xpath("//div[@class='astm-type-heading--h4' and contains(text(),'Closed')]");
	public By requireComment = By.xpath("//label[text()='Require Comment?']");
	public By additionalChoices = By.xpath("//a[text()='Add Additional Choices']");
	public By uploadPollItemAttachmentHeader = By.xpath("//div[@data-testid='add-button']//following-sibling::div[contains(@class,'astm-type')]");
	public By filesToUploadHeader_CreateBallot = By.xpath("//div[contains(@class,'files-to-upload')]");
	public By percentagesAffirmative=By.xpath("//div[contains(text(),'Percentage Affirmative')]//input");

	@Step("Click on additional choices")
	public void clickOnAdditionalChoices() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(additionalChoices),90);
			//PublicAdminCommons.scrollToElement(driver, additionalChoices);
			PublicAdminCommons.scrollToElement(driver, filesToUploadHeader_CreateBallot);
			getElement(additionalChoices).click();
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to click on Additional Choices button", e);
		}
	}

	@Step("Verify that user should be able to see {count} choices")
	public void verifyUserChoicesCount(int count) {
		try {
			Thread.sleep(10000);
             Assert.assertTrue(getElements(requireComment).size()==count,"user Choices should be matched");
		} catch (Exception e) {
			e.printStackTrace();
			SpecBuilderCommon.reportFailAssert("Failed to verify user choice1 choices", e);
		}
	}

	public boolean groupUnderList(String id) {
		try {
			WebElement element = driver.findElement(By.xpath("//div[@class='astm-type-heading--h4' and contains(string(),"+id+")]"));
			return element.isDisplayed();
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public void enterPercentagesAffirmative () {
		try {
			if(IntegrationCommon.isElementdisplayed(driver,getElement(percentagesAffirmative))) {
				PublicAdminCommons.scrollToElement(driver, getElement(percentagesAffirmative));
				getElement(percentagesAffirmative).click();
				getElement(percentagesAffirmative).clear();
				getElement(percentagesAffirmative).sendKeys(RandomStringUtils.getRandomNumbers(1));
				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public String getNoPollsText() {
		try {
			String value = getElement(noPollsInGroup).getText();
			return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getItemName() {
		try {
			String value = getElement(pollIDFromTable).getText();
			String id = value.substring(7);
			System.out.println(id);
			return id;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getItemNumber() {
		try {
			String value = getElement(itemNumberValue).getText();
			return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getReturnValue() {
		try {
			String value = getElement(returnPercentageOnViewPage).getText();
			return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public boolean getSentValue() {
		try {
			String value = getElement(sent).getText();
			int i = Integer.parseInt(value);
			if(i>=1)
				return true;
				else
			return false;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public String getBallotItemNumberOnViewBallotsPage() {
		try {
			String value = getElement(ballotNumberOnViewPage).getText();
			return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getBallotItemNumberOnOpenBallotsPage() {
		try {
			String value = getElement(ballotItemNumber).getText();
		//	String id = value.substring(7);
			String id = value.substring(5);
			return id;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public boolean getBallotCount() {
		try {
			List<WebElement> element = driver.findElements(ballotCount);
			int size =  element.size();
			for(int i=1; i<=size; i++) {
			WebElement closeDate = driver.findElement(By.xpath("//tbody//tr["+i+"]//td[3]"));
			String closingDate = closeDate.getText();
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 Date currentDate = new Date();
			 String date3 = sdf.format(currentDate);
		        Date date1 = sdf.parse(date3);
		        Date date2 = sdf.parse(closingDate);
		       
		        System.out.println("date1 : " + sdf.format(date1));
		        System.out.println("date2 : " + sdf.format(date2));

		        if (date1.compareTo(date2) > 0) {
		            System.out.println("closed ballot is available");
		            driver.findElement(By.xpath("//tbody//tr["+i+"]//td[3]")).click();
		         //   closeDate.click();
		            return true;
		        } 
		        else
		        	return false;
		        }
		}
		catch (Exception e) {
			e.getStackTrace();
		}
		return false;
	}
	
	
	
	public String getPollTitle() {
		try {
			String value = getElement(firstPollLink).getText();
			return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getPollTitleInDetailsPage() {
		try {
			String value = getElement(pollTitle).getText();
			System.out.println(value);
			return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getSuccessMsg() {
		try {
			String value = getElement(successMsg).getText();
			return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getVoteValue() {
		try {
			String value = getElement(affirmativeVoteValue).getText();
			return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public String getAbstainVoteValue() {
		try {
			String value = getElement(abstainVoteValue).getText();
			return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public boolean VerifyHeaderSelectBallotToRecirculateVisible(){
		try{
			getElement(TextSelectBallotToRecirculate).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return false;
	}
	
	public String getValue(String pollName) {
		try {
			String value = getElement(itemtitleValue).getText();
			int size = pollName.length();
			String itemValue = value.substring(size+2, value.lastIndexOf("Poll"));
			System.out.println(itemValue);
			return value;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
		
	}
	
	public String getVoteStatus() {
		try {
			List<WebElement> groupElements = driver.findElements(itemNumberValue);
			int value = groupElements.size();
		//	String valueText =	driver.findElement(By.xpath("//table//tbody//tr["+value+"]//td[7]//span")).getText();
			String valueText =	driver.findElement(By.xpath("//table//tbody//tr[2]//td[7]//span")).getText();
			return valueText;
		}
		catch (Exception e) {
			e.getStackTrace();
			return null;
		}
		
	}
	
	public boolean getLastSavedPoll() {
		try {
			List<WebElement> groupElements = driver.findElements(itemNumberValue);
			int value = groupElements.size();
			System.out.println(value);
			driver.findElement(By.xpath("//table//tbody//tr["+value+"]//td[2]")).click();
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
		
	}
	
	public boolean checkBallotsUnderGroup() {
		try {
			List<WebElement> groupElements = driver.findElements(itemNumberValue);
			int value = groupElements.size();
			System.out.println(value);
			if(value>=0)
			return true;
			else 
				return false;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
		
	}
	
	public boolean clickOnSecondPoll() {
		try {
			driver.findElement(By.xpath("//div[contains(text(),'Open ')]//following::table//tbody//tr[2]//td[2]")).click();
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
		
	}
	
	public boolean clickOnFirstPoll() {
		try {
			driver.findElement(By.xpath("//div[contains(text(),'Open ')]//following::table//tbody//tr[1]//td[2]")).click();
			return true;
		}
		catch (Exception e) {
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
			String message = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			if(message.contains(stringToValidate)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean enterComment() {
		try {
			getElement(commentSection).clear();
			getElement(commentSection).sendKeys("Automation comment");
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean createVote() {
		try {
			
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * @param 
	 * @return
	 */
	 @Step("ballotGroupIsVisible")
	public boolean ballotGroupIsVisible(String id) {
		try { //div[@class='spec-dashboard-header-wrapper']//div[2]//tbody//tr//td//b[text()='Software Subcommittee']
			WebElement element= driver.findElement(By.xpath("//div[@class='spec-dashboard-header-wrapper']//div[2]//tbody//tr//td//b[contains(text(),'"+id+"')]"));
			element.isDisplayed();
				return true;
			
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * @param 
	 * @return
	 */
	 @Step("clickOnBallotInShowAll")
	public boolean clickOnBallotInShowAll(String id) {
		try {
			WebElement element= driver.findElement(By.xpath("//div[@class='spec-dashboard-header-wrapper']//div[2]//tbody//tr//child::b[text()='"+id+"']"));
			element.isDisplayed();
			element.click();
				return true;
			
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * @param 
	 * @return
	 */
	public boolean groupGroupIsVisible(String id) {
		try {
			WebElement element= driver.findElement(By.xpath("//div[@class='spec-dashboard-header-wrapper']//div[2]//tbody//tr//child::td[text()='"+id+"']"));
			element.isDisplayed();
				return true;
			
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/**
	 * @param 
	 * @return
	 */
	public boolean groupGroupIsNotVisible(String id, String name) {
		try {
			WebElement element= driver.findElement(By.xpath("//div[@class='spec-dashboard-header-wrapper']//div[2]//tbody//tr//child::td[text()='"+id+"']//following::td[text()='"+name+"']"));
			element.isDisplayed();
				return true;
			
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	

	public Boolean ifFileExist(String fileName) {
		try {
			Thread.sleep(2000);
			String downloadFolderPath = System.getProperty("user.home") + "\\Downloads";
			String expectedFileName = "\\"+fileName;
			File file = new File(downloadFolderPath + expectedFileName);
			if (file.exists())
				file.delete();
			boolean flag = wait.until((ExpectedCondition<Boolean>) checkingFileExist -> file.exists());
			if (flag == true)
				Thread.sleep(3000);
			file.delete();
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	public boolean selectGroupToEditBallot(String id, String name) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(editSelectGroup));
			WebElement element = getElement(editSelectGroup);
			element.click();
			Select select = new Select(element);
			String value= id+" - "+name;
			select.selectByVisibleText(value);
		//	select.selectByValue(id);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public boolean selectBallotToEditBallot() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(selectpoll));
			WebElement element = getElement(selectpoll);
			element.click();
			Select select = new Select(element);
			select.selectByIndex(1);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
}