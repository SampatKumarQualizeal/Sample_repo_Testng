/**
 * 
 */
package testobjects;

import base.utils.RandomStringUtils;
import org.apache.log4j.Logger;
import pages.ui.BasePage;

/**
 * @author aditya.joshi
 *
 */
public class Contact_PublicAdmin {

	static Logger log = Logger.getLogger(BasePage.class.getName());

	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String jobTitle;
	private String phoneNumber;
	private boolean billTo;
	private boolean shipTo;
	private boolean delieverTo;
	private boolean tptLearner;
	private boolean active;
	private String startDate;
	private String endDate;

	public Contact_PublicAdmin(String firstName, String middleName, String lastName, String email, String jobTitle,
			String phoneNumber) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phoneNumber = phoneNumber;
	}

	public boolean isBillTo() {
		return billTo;
	}

	public boolean isShipTo() {
		return shipTo;
	}

	public boolean isDelieverTo() {
		return delieverTo;
	}

	public boolean isTptLearner() {
		return tptLearner;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Contact_PublicAdmin() {
		this.active = true;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the billTo
	 */
	public boolean getBillTo() {
		return billTo;
	}

	/**
	 * @param billTo the billTo to set
	 */
	public void setBillTo(boolean billTo) {
		this.billTo = billTo;
	}

	/**
	 * @return the shipTo
	 */
	public boolean getShipTo() {
		return shipTo;
	}

	/**
	 * @param shipTo the shipTo to set
	 */
	public void setShipTo(boolean shipTo) {
		this.shipTo = shipTo;
	}

	/**
	 * @return the delieverTo
	 */
	public boolean getDelieverTo() {
		return delieverTo;
	}

	/**
	 * @param delieverTo the delieverTo to set
	 */
	public void setDelieverTo(boolean delieverTo) {
		this.delieverTo = delieverTo;
	}

	/**
	 * @return the tptLearner
	 */
	public boolean getTptLearner() {
		return tptLearner;
	}

	/**
	 * @param tptLearner the tptLearner to set
	 */
	public void setTptLearner(boolean tptLearner) {
		this.tptLearner = tptLearner;
	}

	public String returnContactInFomratAsSameInContactDropDown() {
		String email = null;
		if (this.email == null)
			email = "(no email)";
		else
			email = this.email;
		String contact = "Contact: " + this.firstName + " " + this.lastName + ", " + email;
		return contact;
	}

	public String returnContactInFomratAsSameInContactsDropDown() {
		String email = null;
		if (this.email == null) {
			email = "(no email)";
			String contact = this.firstName + " " + this.lastName + " " + email;
			return contact;
		} else {
			email = this.email;
			String contact = this.firstName + " " + this.lastName + ", " + email;
			return contact;
		}
	}

	public void setAttributeFromContactDropDown(String dropDownValue) {
		String[] spilitDropDownValue = dropDownValue.split(", ");
		String[] nameSplit = spilitDropDownValue[0].split(" ");
		setFirstName(nameSplit[0]);
		setLastName(nameSplit[1]);
		if (spilitDropDownValue.length == 2)
			setEmail(spilitDropDownValue[1]);
		else
			setEmail("(no email)");
	}

	public static Contact_PublicAdmin createTptLearnerContactWithSampleTestData() {
		Contact_PublicAdmin tptContact = new Contact_PublicAdmin();
		tptContact.setFirstName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
		tptContact.setLastName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
		tptContact.setEmail(RandomStringUtils.getRandomString(7) + "@testdata.iooo");
		tptContact.setTptLearner(true);
		return tptContact;
	}

	public static Contact_PublicAdmin createCompleteTptLearnerContactWithSampleTestData() {
		Contact_PublicAdmin tptContact = new Contact_PublicAdmin();
		tptContact.setFirstName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
		tptContact.setMiddleName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
		tptContact.setLastName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
		tptContact.setEmail(RandomStringUtils.getRandomString(7) + "@testdata.iooo");
		tptContact.setTptLearner(true);
		tptContact.setJobTitle("QA");
		tptContact.setPhoneNumber(RandomStringUtils.getRandomNumbers(10));
		return tptContact;
	}

	public static Contact_PublicAdmin createRequiredBillToContactWithSampleTestData() {
		Contact_PublicAdmin contact = new Contact_PublicAdmin();
		contact.setFirstName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
		contact.setLastName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
		contact.setEmail(RandomStringUtils.getRandomString(7) + "@testdata.iooo");
		contact.setBillTo(true);
		return contact;
	}

	public static Contact_PublicAdmin createRequiredShipToContactWithSampleTestData() {
		Contact_PublicAdmin contact = new Contact_PublicAdmin();
		contact.setFirstName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
		contact.setLastName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
		contact.setEmail(RandomStringUtils.getRandomString(7) + "@testdata.iooo");
		contact.setShipTo(true);
		return contact;
	}

	public static Contact_PublicAdmin createRequiredDeliverToContactWithSampleTestData() {
		Contact_PublicAdmin contact = new Contact_PublicAdmin();
		contact.setFirstName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
		contact.setLastName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
		contact.setEmail(RandomStringUtils.getRandomString(7) + "@testdata.iooo");
		contact.setDelieverTo(true);
		return contact;
	}

	public static Contact_PublicAdmin createRequiredBillShipDeliverToContactWithSampleTestData() {
		Contact_PublicAdmin contact = new Contact_PublicAdmin();
		contact.setFirstName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
		contact.setLastName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
		contact.setEmail(RandomStringUtils.getRandomString(7) + "@testdata.iooo");
		contact.setBillTo(true);
		contact.setShipTo(true);
		contact.setDelieverTo(true);
		return contact;
	}

	public static Contact_PublicAdmin createRequiredTptBillShipDeliverToContactWithSampleTestData() {
		Contact_PublicAdmin contact = new Contact_PublicAdmin();
		contact.setFirstName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
		contact.setLastName("TAutoContactTPT" + RandomStringUtils.getRandomString(4));
		contact.setEmail(RandomStringUtils.getRandomString(7) + "@testdata.iooo");
		contact.setTptLearner(true);
		contact.setBillTo(true);
		contact.setShipTo(true);
		contact.setDelieverTo(true);
		return contact;
	}

	public String returnValueInFromatOfContactPresentInContactDropDownUnderAddress() {
		if (this.email == null) {
			String contact = this.firstName + " " + this.lastName + " (no email)";
			log.info("DropDown Value: " + contact);
			return contact;
		} else {
			String contact = this.firstName + " " + this.lastName + ", " + this.email;
			log.info("DropDown Value: " + contact);
			return contact;
		}
	}

	public static Contact_PublicAdmin createContactWithAllValues() {
		Contact_PublicAdmin contact = new Contact_PublicAdmin();
		contact.setFirstName("ContactFirstName" + RandomStringUtils.getRandomString(4));
		contact.setMiddleName("ContactMiddleName" + RandomStringUtils.getRandomString(4));
		contact.setLastName("ContactLastName" + RandomStringUtils.getRandomString(4));
		contact.setEmail(RandomStringUtils.getRandomString(7) + "@testdata.iooo");
		contact.setJobTitle("QA");
		contact.setPhoneNumber(RandomStringUtils.getRandomNumbers(10));
		contact.setTptLearner(true);
		contact.setBillTo(true);
		contact.setShipTo(true);
		contact.setDelieverTo(true);
		return contact;
	}
}
