package pages.ui;

import com.astm.commonFunctions.PublicAdminCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;
import java.util.List;

public class AddUpdateContact_PublicAdmin extends BasePage {

	public AddUpdateContact_PublicAdmin(WebDriver driver) {
		super(driver);
	}

	private By firstNameTextField = By.cssSelector("div.modal-content input[name='first_name']");
	private By middleNamTextField = By.cssSelector("div.modal-content input[name='middle_name']");
	private By lastNameTextField = By.cssSelector("div.modal-content input[name='last_name']");
	private By emailTextField = By.cssSelector("div.modal-content input[name='email']");
	private By jobTitleTextField = By.cssSelector("div.modal-content input[name='job_title']");
	private By phoneTextField = By.cssSelector("div.modal-content input[name='phone']");
//	private By saveButton = By.cssSelector("div.modal-inner-wrap button#save");
	private By saveButton = By.cssSelector("aside.customer_form_areas_contact_contact_customer_contact_update_modal._show button#save");
	private By emailForamtError = By
			.xpath("//label[contains(text(),'Please enter a valid email address (Ex: johndoe@domain.com).')]");
	private By tptLearnerToggleButton = By.cssSelector("input[name='is_tpt_learner'] + label");
	private By billTooggleButton = By.cssSelector("input[name='is_bill_to'] + label");
	private By shipToToggleButton = By.cssSelector("input[name='is_ship_to'] + label");
	private By delieverToToggleButton = By.cssSelector("input[name='is_deliver_to'] + label");
	private By billToInputTag = By.cssSelector("input[name='is_bill_to']");
	private By shipToInputTag = By.cssSelector("input[name='is_ship_to']");
	private By delieverToInputTag = By.cssSelector("input[name='is_deliver_to']");
	private By tptLearnerInputTag = By.cssSelector("input[name='is_tpt_learner']");
	private By requiredErrorMessageFirstName = By.cssSelector(
			".customer_form_areas_contact_contact_customer_contact_update_modal input[name='first_name'] + label.admin__field-error");
	private By requiredErrorMessageLastName = By.cssSelector(
			".customer_form_areas_contact_contact_customer_contact_update_modal input[name='last_name'] + label.admin__field-error");
	private By requiredErrorMessageStartDate = By.cssSelector(
			".customer_form_areas_contact_contact_customer_contact_update_modal input[name='start_date'] + button + label.admin__field-error");
	private By startDateField = By
			.cssSelector(".customer_form_areas_contact_contact_customer_contact_update_modal input[name='start_date']");
	private By endDateField = By
			.cssSelector(".customer_form_areas_contact_contact_customer_contact_update_modal input[name='end_date']");
	private By closeButton = By
			.cssSelector(".customer_form_areas_contact_contact_customer_contact_update_modal button.action-close");
	private By activeToggleButton = By.cssSelector("input[name='is_active'] + label");
	private By spinnnerIcon = By.cssSelector("div[data-component='customer_contact_form.customer_contact_form'] .spinner");
	private By activeToggleInputTag = By.cssSelector("input[name='is_active']");
	private By monthDropDown = By.cssSelector("select[data-handler='selectMonth']");
	private By yearDropDown = By.cssSelector("select[data-handler='selectYear']");
	private By activeDateLabel = By.cssSelector("td[data-handler='selectDay'] a");
	private By startDateCalenderIcon = By.cssSelector("input[name='start_date'] + button");
	private By endDateCalenderIcon = By.cssSelector("input[name='end_date'] + button");

	/**
	* @return endDateCalenderIcon
	*/
	public By getEndDateCalenderIcon(){
	    return endDateCalenderIcon;
	}

	/**
	* @return startDateCalenderIcon
	*/
	public By getStartDateCalenderIcon(){
	    return startDateCalenderIcon;
	}

	/**
	* @return activeToggleInputTag
	*/
	public By getactiveToggleInputTag(){
	    return activeToggleInputTag;
	}

	/**
	* @return spinnnerIcon
	*/
	public By getSpinnnerIcon(){
	    return spinnnerIcon;
	}

	/**
	 * @return the activeToggleButton
	 */
	public By getActiveToggleButton() {
		return activeToggleButton;
	}

	/**
	 * @return the closeButton
	 */
	public By getCloseButton() {
		return closeButton;
	}

	/**
	 * @return the requiredErrorMessageFirstName
	 */
	public By getRequiredErrorMessageFirstName() {
		return requiredErrorMessageFirstName;
	}

	/**
	 * @return the requiredErrorMessageLastName
	 */
	public By getRequiredErrorMessageLastName() {
		return requiredErrorMessageLastName;
	}

	/**
	 * @return the requiredErrorMessageStartDate
	 */
	public By getRequiredErrorMessageStartDate() {
		return requiredErrorMessageStartDate;
	}

	/**
	 * @return the startDateField
	 */
	public By getStartDateField() {
		return startDateField;
	}

	/**
	 * @return the endDateField
	 */
	public By getEndDateField() {
		return endDateField;
	}

	/**
	 * @return the tptLearnerInputTag
	 */
	public By getTptLearnerInputTag() {
		return tptLearnerInputTag;
	}

	/**
	 * @return the billToInputTag
	 */
	public By getBillToInputTag() {
		return billToInputTag;
	}

	/**
	 * @return the shipToInputTag
	 */
	public By getShipToInputTag() {
		return shipToInputTag;
	}

	/**
	 * @return the delieverToInputTag
	 */
	public By getDelieverToInputTag() {
		return delieverToInputTag;
	}

	/**
	 * @return the tptLearnerToggleButton
	 */
	public By getTptLearnerToggleButton() {
		return tptLearnerToggleButton;
	}

	/**
	 * @return the billTooggleButton
	 */
	public By getBillTooggleButton() {
		return billTooggleButton;
	}

	/**
	 * @return the shipToToggleButton
	 */
	public By getShipToToggleButton() {
		return shipToToggleButton;
	}

	/**
	 * @return the delieverToToggleButton
	 */
	public By getDelieverToToggleButton() {
		return delieverToToggleButton;
	}

	/**
	 * @return the jobTitleTextField
	 */
	public By getJobTitleTextField() {
		return jobTitleTextField;
	}

	/**
	 * @return the phoneTextField
	 */
	public By getPhoneTextField() {
		return phoneTextField;
	}

	/**
	 * @return the emailForamtError
	 */
	public By getEmailForamtError() {
		return emailForamtError;
	}

	/**
	 * @return the saveButton
	 */
	public By getSaveButton() {
		return saveButton;
	}

	/**
	 * @return the firstNameTextField
	 */
	public By getFirstNameTextField() {
		return firstNameTextField;
	}

	/**
	 * @return the middleNamTextField
	 */
	public By getMiddleNamTextField() {
		return middleNamTextField;
	}

	/**
	 * @return the lastNameTextField
	 */
	public By getLastNameTextField() {
		return lastNameTextField;
	}

	/**
	 * @return the emailTextField
	 */
	public By getEmailTextField() {
		return emailTextField;
	}

	/**
	 * Pick date from calender
	 * Example : 3 Jan 2021
	 *
	 * @param date
	 * @return
	 */
	public boolean pickDateFromCalender(String date){
		try {
			String dateConverted =
					PublicAdminCommons.convertDateFromOneFormatToAnother(date,"MM/dd/yyyy","d MMM yyyy");
			String[] dateArray = dateConverted.split(" ");
			PublicAdminCommons.selectValueInDropdown(getElementNew(yearDropDown), dateArray[2]);
			PublicAdminCommons.selectValueInDropdown(getElementNew(monthDropDown), dateArray[1]);
			List<String> dates = PublicAdminCommons.getTextOfWebElements(driver, activeDateLabel);
			List<WebElement> datesElement = getElementsNew(activeDateLabel);
			int index = dates.indexOf(dateArray[0]);
			datesElement.get(index).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e);
			return false;
		}
	}

}
