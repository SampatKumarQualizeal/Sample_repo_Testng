package pages.ui;

import base.utils.*;
import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class CommonBillingShippingThirdPartyTestHelper_Public extends BasePage {

	public CommonBillingShippingThirdPartyTestHelper_Public(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	BillingAddressPage_Public billingAddressPage = getInstance(BillingAddressPage_Public.class);
	ShippingAddressPage_Public shippingAddressPage = getInstance(ShippingAddressPage_Public.class);
	PTPThirdPartyShippingPage_Public TPShippingPage = getInstance(PTPThirdPartyShippingPage_Public.class);
	ContactPersonAddressPage_Public contactPersonPage = getInstance(ContactPersonAddressPage_Public.class);
	PaymentDetailsPage_Public paymentPage = getInstance(PaymentDetailsPage_Public.class);
	MyAccountPage_Public myAccountPage_public = getInstance(MyAccountPage_Public.class);
	MenuNavigationPage_PublicAdmin adminMenuNavigation = getInstance(MenuNavigationPage_PublicAdmin.class);
	CommonPage_Public  commonPage = getInstance(CommonPage_Public.class);

	JsonFileReader jsonFileReader=new JsonFileReader();


	@Step("Navigate to 'Billing Address'")
	public void verifyBillingAddressHeaderIsVisible() {
		try {
			// If loader is not found then handling the exception
			// and executing the normal functioning of the program
			try {
				//commonPage.closeCookieMessage();
				//wait.until(ExpectedConditions.invisibilityOf(getElement(billingAddressPage.loader)));
				WaitStatementUtils.waitForLoaderToBeInvisible(driver);
			} catch (Exception e) {
				e.printStackTrace();
			}
			WaitStatementUtils.explicitWaitForVisibility(driver, getElement(billingAddressPage.billingAddressHeader), 60);
			verifyVisibility("Billing Address", billingAddressPage.billingAddressHeader,
					"Billing Address should be visible");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify Billing Address header is visible", e);
		}
	}


	public void enterBillingAddressWithoutCompanyName(String shipTO,String sheetName, String WebdataSheetName) {
		try {
			HashMap<String, String> dataMapBilling = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName), sheetName);
			//new Actions(driver).click(getElement(billingAddressPage.firstNameTextbox)).sendKeys(getElement(billingAddressPage.firstNameTextbox),dataMapBilling.get("firstName")).build().perform();
			enterText("First Name", billingAddressPage.firstNameTextbox, dataMapBilling.get("firstName"), "Enter First Name in TextBox");
			enterText("Middle Name", billingAddressPage.middleNameTextbox, dataMapBilling.get("middleName"), "Enter Middle Name in TextBox");
			enterText("Last Name", billingAddressPage.lastNameTextbox, dataMapBilling.get("lastName"), "Enter Last Name in TextBox");
			enterText("Street Address in Line 1", billingAddressPage.billingAddress1Textbox, dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", billingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", billingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"), "Enter Postal Code in TextBox");
			selectValue("Country", billingAddressPage.countryDropdown, dataMapBilling.get("country"), "Select Country from Drop down");
			selectValue("State", billingAddressPage.stateDropdown, dataMapBilling.get("state"), "Select State from Drop down");
			enterText("Phone", billingAddressPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			// Select the Shipping Address
			assertTrue(billingAddressPage.selectShippingOption(shipTO), "Failed to select Shipping Option");
			clickONMethod("Continue Button ", billingAddressPage.billingAddressContinueButton, "Continue button should be clickable");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if(dataMapBilling.get("country").contains("United States")) {
				Assert.assertTrue(AddressValidationHeader(),"Unable to validate Address Validation Header");
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
		}
	}

	public void enterandValidateBillingAddress(String shipTO,String filename,String JsonPrimeElement) {
		try {
			enterText("First Name", billingAddressPage.firstNameTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"firstName"), "Enter First Name in TextBox");
			enterText("Middle Name", billingAddressPage.middleNameTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"middleName"), "Enter Middle Name in TextBox");
			enterText("Last Name", billingAddressPage.lastNameTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"lastName"), "Enter Last Name in TextBox");
			enterText("Street Address in Line 1", billingAddressPage.billingAddress1Textbox,  jsonFileReader.getJsonString(filename,JsonPrimeElement,"addressLine1"), "Enter Street Address in Line 1 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", billingAddressPage.cityTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", billingAddressPage.postalCodeTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"postalCode"), "Enter Postal Code in TextBox");
			selectValue("Country", billingAddressPage.countryDropdown, jsonFileReader.getJsonString(filename,JsonPrimeElement,"country"), "Select Country from Drop down");
			selectValue("State", billingAddressPage.stateDropdown, jsonFileReader.getJsonString(filename,JsonPrimeElement,"state"), "Select State from Drop down");
			enterText("Phone", billingAddressPage.phoneTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"phone"), "Enter phone in TextBox");
			// Select the Shipping Address
			assertTrue(billingAddressPage.selectShippingOption(shipTO), "Failed to select Shipping Option");
			clickONMethod("Continue Button ", billingAddressPage.billingAddressContinueButton, "Continue button should be clickable");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if(jsonFileReader.getJsonString(filename,JsonPrimeElement,"country").contains("United States")) {
				Assert.assertTrue(AddressValidationHeader(),"Unable to validate Address Validation Header");
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
		}
	}



	/**
	 * Enter Billing Address
	 * 
	 * @param shipTO
	 * @param sheetName (BillingAddress, BillingAddress_US)
	 */
	@Step("Entering Billing Information")
	public void enterBillingAddress(String shipTO, String sheetName) {
		try {
			HashMap<String, String> dataMapBilling = ExcelDataConfig
					.getMapData(ConfigReader.getValue("IntegrationExcelPath"), sheetName);

			enterText("First Name", billingAddressPage.firstNameTextbox, dataMapBilling.get("firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", billingAddressPage.middleNameTextbox, dataMapBilling.get("middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", billingAddressPage.lastNameTextbox, dataMapBilling.get("lastName"),
					"Enter Last Name in TextBox");
//			enterText("Company Name", billingAddressPage.companyTextbox, dataMapBilling.get("companyName"),
//					"Enter Company Name in TextBox");
			enterText("Street Address in Line 1", billingAddressPage.billingAddress1Textbox,
					dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
			enterText("Street Address in Line 2", billingAddressPage.billingAddress2Textbox,
					dataMapBilling.get("addressLine2"), "Enter Street Address in Line 2 in TextBox");
			enterText("Street Address in Line 3", billingAddressPage.billingAddress3Textbox,
					dataMapBilling.get("addressLine3"), "Enter Street Address in Line 3 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", billingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", billingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", billingAddressPage.countryDropdown, dataMapBilling.get("country"),
					"Select Country from Drop down");
			selectValue("State", billingAddressPage.stateDropdown, dataMapBilling.get("state"),
					"Select State from Drop down");
			enterText("Phone", billingAddressPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			// Select the Shipping Address
			assertTrue(billingAddressPage.selectShippingOption(shipTO), "Failed to select Shipping Option");
			clickONMethod("Continue Button ", billingAddressPage.billingAddressContinueButton,
					"Continue button should be clickable");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
		}
	}

	/**
	 * Enter Billing Address
	 * 
	 * @param sheetName        (BillingAddress, BillingAddress_US)
	 * @param WebdataSheetName
	 */
	@Step("Entering Billing Information")
	public void enterBillingAddressForSTDProduct(String sheetName, String WebdataSheetName) {
		try {
			HashMap<String, String> dataMapBilling = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName),
					sheetName);
			//PublicCommon.JSClick(billingAddressPage.getElement(billingAddressPage.companyAffiliation), driver);
			// clickONMethod("Company Affiliation checkbox
			// ",billingAddressPage.companyAffiliation,"Company affiliation check box should
			// be clickable");
			enterText("First Name", billingAddressPage.firstNameTextbox, dataMapBilling.get("firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", billingAddressPage.middleNameTextbox, dataMapBilling.get("middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", billingAddressPage.lastNameTextbox, dataMapBilling.get("lastName"),
					"Enter Last Name in TextBox");
			/*enterText("Company Name", billingAddressPage.companyTextbox, dataMapBilling.get("companyName"),
					"Enter Company Name in TextBox");
			*/enterText("Street Address in Line 1", billingAddressPage.billingAddress1Textbox,
					dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
			enterText("Street Address in Line 2", billingAddressPage.billingAddress2Textbox,
					dataMapBilling.get("addressLine2"), "Enter Street Address in Line 2 in TextBox");
			enterText("Street Address in Line 3", billingAddressPage.billingAddress3Textbox,
					dataMapBilling.get("addressLine3"), "Enter Street Address in Line 3 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", billingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", billingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", billingAddressPage.countryDropdown, dataMapBilling.get("country"),
					"Select Country from Drop down");
			selectValue("State", billingAddressPage.stateDropdown, dataMapBilling.get("state"),
					"Select State from Drop down");
			enterText("Phone", billingAddressPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			// Select the Shipping Address
			ReusableMethods.scrollIntoView(
					billingAddressPage.getElement(billingAddressPage.billingAddressContinueButton), driver);
			clickONMethod("Continue Button ", billingAddressPage.billingAddressContinueButton,
					"Continue button should be clickable");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
		}
	}

	/**
	 * Enter Billing Address
	 * 
	 * @param sheetName        (BillingAddress, BillingAddress_US)
	 * @param WebdataSheetName
	 */
	@Step("Entering Billing Information")
	public void enterBillingAddressForTPTProduct(String sheetName, String WebdataSheetName) {
		try {
			HashMap<String, String> dataMapBilling = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName),
					sheetName);
			PublicCommon.JSClick(billingAddressPage.getElement(billingAddressPage.companyAffiliation), driver);
			// clickONMethod("Company Affiliation checkbox
			// ",billingAddressPage.companyAffiliation,"Company affiliation check box should
			// be clickable");
			enterText("First Name", billingAddressPage.firstNameTextbox, dataMapBilling.get("firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", billingAddressPage.middleNameTextbox, dataMapBilling.get("middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", billingAddressPage.lastNameTextbox, dataMapBilling.get("lastName"),
					"Enter Last Name in TextBox");
//			enterText("Company Name", billingAddressPage.companyTextbox, dataMapBilling.get("companyName"),
//					"Enter Company Name in TextBox");
			enterText("Street Address in Line 1", billingAddressPage.billingAddress1Textbox,
					dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
			enterText("Street Address in Line 2", billingAddressPage.billingAddress2Textbox,
					dataMapBilling.get("addressLine2"), "Enter Street Address in Line 2 in TextBox");
			enterText("Street Address in Line 3", billingAddressPage.billingAddress3Textbox,
					dataMapBilling.get("addressLine3"), "Enter Street Address in Line 3 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", billingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", billingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", billingAddressPage.countryDropdown, dataMapBilling.get("country"),
					"Select Country from Drop down");
			selectValue("State", billingAddressPage.stateDropdown, dataMapBilling.get("state"),
					"Select State from Drop down");
			enterText("Phone", billingAddressPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			// Select the Shipping Address
			ReusableMethods.scrollIntoView(
					billingAddressPage.getElement(billingAddressPage.billingAddressContinueButton), driver);
			clickONMethod("Continue Button ", billingAddressPage.billingAddressContinueButton,
					"Continue button should be clickable");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
		}
	}

	/**
	 * Enter Billing Address
	 * 
	 * @param sheetName        (BillingAddress, BillingAddress_US)
	 * @param WebdataSheetName
	 */
	@Step("Entering Billing Information")
	public void enterBillingAddressSTDFormat(String sheetName, String WebdataSheetName) {
		try {
			HashMap<String, String> dataMapBilling = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName),
					sheetName);
			Thread.sleep(2000);
			clickONMethod("Company Affiliation checkbox ", billingAddressPage.companyAffiliation,
					"Company affiliation check box should be clickable");
			enterText("First Name", billingAddressPage.firstNameTextbox, dataMapBilling.get("firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", billingAddressPage.middleNameTextbox, dataMapBilling.get("middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", billingAddressPage.lastNameTextbox, dataMapBilling.get("lastName"),
					"Enter Last Name in TextBox");
			enterText("Company Name", billingAddressPage.companyTextbox, dataMapBilling.get("companyName"),
					"Enter Company Name in TextBox");
			enterText("Street Address in Line 1", billingAddressPage.billingAddress1Textbox,
					dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
			enterText("Street Address in Line 2", billingAddressPage.billingAddress2Textbox,
					dataMapBilling.get("addressLine2"), "Enter Street Address in Line 2 in TextBox");
			enterText("Street Address in Line 3", billingAddressPage.billingAddress3Textbox,
					dataMapBilling.get("addressLine3"), "Enter Street Address in Line 3 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", billingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", billingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", billingAddressPage.countryDropdown, dataMapBilling.get("country"),
					"Select Country from Drop down");
			selectValue("State", billingAddressPage.stateDropdown, dataMapBilling.get("state"),
					"Select State from Drop down");
			enterText("Phone", billingAddressPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");

		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
		}
	}

	/**
	 * Enter Billing Address
	 * 
	 * @param shipTO
	 * @param sheetName (BillingAddress, BillingAddress_US)
	 */
	@Step("Entering Billing Information")
	public void enterBillingAddress(String shipTO, String sheetName, String WebdataSheetName) {
		try {
			HashMap<String, String> dataMapBilling = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName),
					sheetName);
			if (billingAddressPage.getElement(billingAddressPage.companyAffiliation).isDisplayed()) {
				clickONMethod("Company Affiliation checkbox ", billingAddressPage.companyAffiliation,
						"Company affiliation check box should be clickable");

			}
			enterText("First Name", billingAddressPage.firstNameTextbox, dataMapBilling.get("firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", billingAddressPage.middleNameTextbox, dataMapBilling.get("middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", billingAddressPage.lastNameTextbox, dataMapBilling.get("lastName"),
					"Enter Last Name in TextBox");
			enterText("Company Name", billingAddressPage.companyTextbox, dataMapBilling.get("companyName"),
					"Enter Company Name in TextBox");
			enterText("Street Address in Line 1", billingAddressPage.billingAddress1Textbox,
					dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
			enterText("Street Address in Line 2", billingAddressPage.billingAddress2Textbox,
					dataMapBilling.get("addressLine2"), "Enter Street Address in Line 2 in TextBox");
			enterText("Street Address in Line 3", billingAddressPage.billingAddress3Textbox,
					dataMapBilling.get("addressLine3"), "Enter Street Address in Line 3 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", billingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", billingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", billingAddressPage.countryDropdown, dataMapBilling.get("country"),
					"Select Country from Drop down");
			selectValue("State", billingAddressPage.stateDropdown, dataMapBilling.get("state"),
					"Select State from Drop down");
			enterText("Phone", billingAddressPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			// Select the Shipping Address
			assertTrue(billingAddressPage.selectShippingOption(shipTO), "Failed to select Shipping Option");
			clickONMethod("Continue Button ", billingAddressPage.billingAddressContinueButton,
					"Continue button should be clickable");
			if(billingAddressPage.isElementDisplayed(getElement(billingAddressPage.AddmodelBoxText)))
			{
				if(((getElement(billingAddressPage.getModelBoxTitle()).getText().equals("Address Validation"))))
				{
					clickONMethod("Address Validation Continue Button", billingAddressPage.getContinueBtn(),
							"Address Validation Continue Button should be clickable");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
		}
	}

	@Step("Entering Billing Information")
	public void enterBillingAddressWithoutChechbox(String sheetName, String WebdataSheetName) {
		try {
			HashMap<String, String> dataMapBilling = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName),
					sheetName);
			enterText("First Name", billingAddressPage.firstNameTextbox, dataMapBilling.get("firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", billingAddressPage.middleNameTextbox, dataMapBilling.get("middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", billingAddressPage.lastNameTextbox, dataMapBilling.get("lastName"),
					"Enter Last Name in TextBox");
			enterText("Company Name", billingAddressPage.companyTextbox, dataMapBilling.get("companyName"),
					"Enter Company Name in TextBox");
			enterText("Street Address in Line 1", billingAddressPage.billingAddress1Textbox,
					dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
			enterText("Street Address in Line 2", billingAddressPage.billingAddress2Textbox,
					dataMapBilling.get("addressLine2"), "Enter Street Address in Line 2 in TextBox");
			enterText("Street Address in Line 3", billingAddressPage.billingAddress3Textbox,
					dataMapBilling.get("addressLine3"), "Enter Street Address in Line 3 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", billingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", billingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", billingAddressPage.countryDropdown, dataMapBilling.get("country"),
					"Select Country from Drop down");
			selectValue("State", billingAddressPage.stateDropdown, dataMapBilling.get("state"),
					"Select State from Drop down");
			enterText("Phone", billingAddressPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			// Select the Shipping Address
			clickONMethod("Continue Button ", billingAddressPage.billingAddressContinueButton,
					"Continue button should be clickable");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
		}
	}
	@Step("Entering Billing Information")
	public void enterBillingAddressforPTP(String shipTO, String sheetName, String WebdataSheetName,String org_Name) {
		try {
			HashMap<String, String> dataMapBilling = PublicCommon.getMapperData(ConfigReader.getValue(WebdataSheetName),
					sheetName);
			enterText("First Name", billingAddressPage.firstNameTextbox, dataMapBilling.get("firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", billingAddressPage.middleNameTextbox, dataMapBilling.get("middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", billingAddressPage.lastNameTextbox, dataMapBilling.get("lastName"),
					"Enter Last Name in TextBox");
			try {
				if(getElement(billingAddressPage.companyTextbox).getAttribute("disabled").equalsIgnoreCase("true")) {
					System.out.println("Company affilation box is disabled");
				}
				else
				{
					enterText("Company Name", billingAddressPage.companyTextbox, org_Name,
							"Enter Company Name in TextBox");

				}
			}
			catch(Exception e)
			{
				System.out.println(e.getStackTrace());
			}
			enterText("Street Address in Line 1", billingAddressPage.billingAddress1Textbox,
					dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
			 ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", billingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", billingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", billingAddressPage.countryDropdown, dataMapBilling.get("country"),
					"Select Country from Drop down");
			selectValue("State", billingAddressPage.stateDropdown, dataMapBilling.get("state"),
					"Select State from Drop down");
			enterText("Phone", billingAddressPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			// Select the Shipping Address
			assertTrue(billingAddressPage.selectShippingOption(shipTO), "Failed to select Shipping Option");
			clickONMethod("Continue Button ", billingAddressPage.billingAddressContinueButton,
					"Continue button should be clickable");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
		}
	}

	@Step("Entering Billing Information")
	public void enterBillingAddressforPTP(String shipTO, String sheetName, String WebdataSheetName) {
		try {
			HashMap<String, String> dataMapBilling = PublicCommon.getMapperData(ConfigReader.getValue(WebdataSheetName),
					sheetName);
			enterText("First Name", billingAddressPage.firstNameTextbox, dataMapBilling.get("firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", billingAddressPage.middleNameTextbox, dataMapBilling.get("middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", billingAddressPage.lastNameTextbox, dataMapBilling.get("lastName"),
					"Enter Last Name in TextBox");
			System.out.println(getElement(billingAddressPage.companyTextbox).getAttribute("disabled"));;
			try{
				if(getElement(billingAddressPage.companyTextbox).getAttribute("disabled")==null) {
					enterText("Company Name", billingAddressPage.companyTextbox, dataMapBilling.get("companyName"),
							"Enter Company Name in TextBox");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			enterText("Street Address in Line 1", billingAddressPage.billingAddress1Textbox,
					dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
			/*
			 * enterText("Street Address in Line 2",
			 * billingAddressPage.billingAddress2Textbox,
			 * dataMapBilling.get("addressLine2"),
			 * "Enter Street Address in Line 2 in TextBox");
			 * enterText("Street Address in Line 3",
			 * billingAddressPage.billingAddress3Textbox,
			 * dataMapBilling.get("addressLine3"),
			 * "Enter Street Address in Line 3 in TextBox");
			 */ ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", billingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", billingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", billingAddressPage.countryDropdown, dataMapBilling.get("country"),
					"Select Country from Drop down");
			selectValue("State", billingAddressPage.stateDropdown, dataMapBilling.get("state"),
					"Select State from Drop down");
			System.out.println("mobile value------"+dataMapBilling.get("phone"));
			enterText("Phone", billingAddressPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			// Select the Shipping Address
			assertTrue(billingAddressPage.selectShippingOption(shipTO), "Failed to select Shipping Option");
			PublicCommon.waitForSec(5);
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.billingAddressContinueButton),driver);
			PublicCommon.waitForSec(5);
            clickONMethod("Continue Button ", billingAddressPage.billingAddressContinueButton,
					"Continue button should be clickable");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
		}
	}

	/**
	 * Enter Billing Address
	 * 
	 * @param shipTO
	 * @param sheetName (BillingAddress, BillingAddress_US)
	 */
	@Step("Entering Billing Information")
	public void enterBillingAddressForPTP(String shipTO, String sheetName) {
		try {
			HashMap<String, String> dataMapBilling = ExcelDataConfig
					.getMapData(ConfigReader.getValue("IntegrationExcelPath"), sheetName);
			// if(!billingAddressPage.getElement(billingAddressPage.companyTextbox).isEnabled())
			// {
			// PublicCommon.JSClick(billingAddressPage.getCompanyAffilationCheckbox(),
			// driver);
			// }

			enterText("First Name", billingAddressPage.firstNameTextbox, dataMapBilling.get("firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", billingAddressPage.middleNameTextbox, dataMapBilling.get("middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", billingAddressPage.lastNameTextbox, dataMapBilling.get("lastName"),
					"Enter Last Name in TextBox");
			enterText("Street Address in Line 1", billingAddressPage.billingAddress1Textbox,
					dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
			enterText("Street Address in Line 2", billingAddressPage.billingAddress2Textbox,
					dataMapBilling.get("addressLine2"), "Enter Street Address in Line 2 in TextBox");
			enterText("Street Address in Line 3", billingAddressPage.billingAddress3Textbox,
					dataMapBilling.get("addressLine3"), "Enter Street Address in Line 3 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", billingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", billingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", billingAddressPage.countryDropdown, dataMapBilling.get("country"),
					"Select Country from Drop down");
			selectValue("State", billingAddressPage.stateDropdown, dataMapBilling.get("state"),
					"Select State from Drop down");
			enterText("Phone", billingAddressPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			// Select the Shipping Address
			assertTrue(billingAddressPage.selectShippingOption(shipTO), "Failed to select Shipping Option");
			clickONMethod("Continue Button ", billingAddressPage.billingAddressContinueButton,
					"Continue button should be clickable");
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
		}
	}

	@Step("Navigate to 'Shipping Address'")
	public void verifyShippingAddressHeaderIsVisible() {
		try {
			ReusableMethods.scrollIntoView(getElement(shippingAddressPage.shippingAddressHeader), driver);
			verifyVisibility("Shipping Address", shippingAddressPage.shippingAddressHeader,
					"Shipping Address Header should be visible");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify Shipping Address header is visible", e);
		}
	}

	@Step("Entering Shipping Address Information")
	public void enterShippingAddressWithoutOrg(String sheetName, String WebdataSheetName) {
		try {
			HashMap<String, String> dataMapBilling = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName), sheetName);
			enterText("First Name", shippingAddressPage.firstNameTextbox, dataMapBilling.get("firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", shippingAddressPage.middleNameTextbox, dataMapBilling.get("middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", shippingAddressPage.lastNameTextbox, dataMapBilling.get("lastName"),
					"Enter Last Name in TextBox");
			enterText("Street Address in Line 1", shippingAddressPage.shippingAddress1Textbox,
					dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", shippingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(shippingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", shippingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", shippingAddressPage.countryDropdown, dataMapBilling.get("country"),
					"Select Country from Drop down");
			WebElement stateAttribute = getElement(shippingAddressPage.stateTextbox);
			if(stateAttribute.isDisplayed()) {
				enterText("State", shippingAddressPage.stateTextbox, dataMapBilling.get("postalCode"),
						"Enter Postal Code in TextBox");
			} else {
				selectValue("State", shippingAddressPage.stateDropdown, dataMapBilling.get("state"), "Select State from Drop down");
			}
			if(billingAddressPage.isElementDisplayed(getElement(shippingAddressPage.phoneTextbox))) {
				enterText("Phone", shippingAddressPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			}
			PublicCommon.waitForSec(5);
			clickONMethod("Continue Button ", shippingAddressPage.shippingAddressContinueButton,
					"Continue button should be clickable");
			Thread.sleep(5000);
			if(dataMapBilling.get("country").contains("United States")) {
				Assert.assertTrue(AddressValidationHeader(),"Unable to validate Address Validation Header");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Entering Shipping Address Information")
	public void enterandvalidateShippingAddress(String filename,String JsonPrimeElement) {
		try {
			enterText("First Name", shippingAddressPage.firstNameTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", shippingAddressPage.middleNameTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", shippingAddressPage.lastNameTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"lastName"),
					"Enter Last Name in TextBox");
			enterText("Street Address in Line 1", shippingAddressPage.shippingAddress1Textbox,
					jsonFileReader.getJsonString(filename,JsonPrimeElement,"addressLine1"), "Enter Street Address in Line 1 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", shippingAddressPage.cityTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(shippingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", shippingAddressPage.postalCodeTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", shippingAddressPage.countryDropdown, jsonFileReader.getJsonString(filename,JsonPrimeElement,"country"),
					"Select Country from Drop down");
			WebElement stateAttribute = getElement(shippingAddressPage.stateTextbox);
			if(stateAttribute.isDisplayed()) {
				enterText("State", shippingAddressPage.stateTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"postalCode"),
						"Enter Postal Code in TextBox");
			} else {
				selectValue("State", shippingAddressPage.stateDropdown, jsonFileReader.getJsonString(filename,JsonPrimeElement,"state"), "Select State from Drop down");
			}
			if(billingAddressPage.isElementDisplayed(getElement(shippingAddressPage.phoneTextbox))) {
				enterText("Phone", shippingAddressPage.phoneTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"phone"), "Enter phone in TextBox");
			}
			PublicCommon.waitForSec(10);
			clickONMethod("Continue Button ", shippingAddressPage.shippingAddressContinueButton,
					"Continue button should be clickable");
			Thread.sleep(15000);
			if(jsonFileReader.getJsonString(filename,JsonPrimeElement,"country").contains("United States")) {
				Assert.assertTrue(AddressValidationHeader(),"Unable to validate Address Validation Header");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Entering Shipping Address Information")
	public void enterShippingAddress(String sheetName) {
		try {
			HashMap<String, String> dataMapBilling = ExcelDataConfig.getMapData(ConfigReader.getValue("IntegrationExcelPath"), sheetName);

			enterText("First Name", shippingAddressPage.firstNameTextbox, dataMapBilling.get("firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", shippingAddressPage.middleNameTextbox, dataMapBilling.get("middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", shippingAddressPage.lastNameTextbox, dataMapBilling.get("lastName"),
					"Enter Last Name in TextBox");
			enterText("Phone", shippingAddressPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			enterText("Street Address in Line 1", shippingAddressPage.shippingAddress1Textbox,
					dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
			/*enterText("Street Address in Line 2", shippingAddressPage.shippingAddress2Textbox,
					dataMapBilling.get("addressLine2"), "Enter Street Address in Line 2 in TextBox");
			enterText("Street Address in Line 3", shippingAddressPage.shippingAddress3Textbox,
					dataMapBilling.get("addressLine3"), "Enter Street Address in Line 3 in TextBox");*/
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", shippingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(shippingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", shippingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", shippingAddressPage.countryDropdown, dataMapBilling.get("country"),
					"Select Country from Drop down");
			selectValue("State", shippingAddressPage.stateDropdown, dataMapBilling.get("state"),
					"Select State from Drop down");
			clickONMethod("Continue Button ", shippingAddressPage.shippingAddressContinueButton,
					"Continue button should be clickable");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Step("Entering Shipping Address Information")
	public void enterShippingAddress(String sheetName,String orgName) {
		try {
			HashMap<String, String> dataMapBilling = ExcelDataConfig
					.getMapData(ConfigReader.getValue("IntegrationExcelPath"), sheetName);
			enterText("First Name", shippingAddressPage.firstNameTextbox, dataMapBilling.get("firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", shippingAddressPage.middleNameTextbox, dataMapBilling.get("middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", shippingAddressPage.lastNameTextbox, dataMapBilling.get("lastName"),
					"Enter Last Name in TextBox");
			enterText("Phone", shippingAddressPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			try {
				if(getElement(billingAddressPage.companyTextbox).getAttribute("disabled").equalsIgnoreCase("true")) {
					System.out.println("Company affilation box is disabled");
				}
				else
				{
					enterText("Company Name", billingAddressPage.companyTextbox, orgName,
							"Enter Company Name in TextBox");

				}
			}
			catch(Exception e)
			{
				System.out.println(e.getStackTrace());
			}

			//enterText("Organisation Name",shippingAddressPage.shippingCompanyName,orgName,"Failed to enter Organisation name");
			enterText("Street Address in Line 1", shippingAddressPage.shippingAddress1Textbox,
					dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
			enterText("Street Address in Line 2", shippingAddressPage.shippingAddress2Textbox,
					dataMapBilling.get("addressLine2"), "Enter Street Address in Line 2 in TextBox");
			enterText("Street Address in Line 3", shippingAddressPage.shippingAddress3Textbox,
					dataMapBilling.get("addressLine3"), "Enter Street Address in Line 3 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", shippingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(shippingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", shippingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", shippingAddressPage.countryDropdown, dataMapBilling.get("country"),
					"Select Country from Drop down");
			selectValue("State", shippingAddressPage.stateDropdown, dataMapBilling.get("state"),
					"Select State from Drop down");
			clickONMethod("Continue Button ", shippingAddressPage.shippingAddressContinueButton,
					"Continue button should be clickable");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Step("Entering Shipping Address Information")
	public void enterShippingAddressSTDFormat(String sheetName, String WebdataSheetName) {
		try {
			HashMap<String, String> dataMapBilling = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName),
					sheetName);
			enterText("First Name", shippingAddressPage.firstNameTextbox, dataMapBilling.get("firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", shippingAddressPage.middleNameTextbox, dataMapBilling.get("middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", shippingAddressPage.lastNameTextbox, dataMapBilling.get("lastName"),
					"Enter Last Name in TextBox");
			enterText("Street Address in Line 1", shippingAddressPage.shippingAddress1Textbox,
					dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
			enterText("Street Address in Line 2", shippingAddressPage.shippingAddress2Textbox,
					dataMapBilling.get("addressLine2"), "Enter Street Address in Line 2 in TextBox");
			enterText("Street Address in Line 3", shippingAddressPage.shippingAddress3Textbox,
					dataMapBilling.get("addressLine3"), "Enter Street Address in Line 3 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", shippingAddressPage.cityTextbox, dataMapBilling.get("city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(shippingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", shippingAddressPage.postalCodeTextbox, dataMapBilling.get("postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", shippingAddressPage.countryDropdown, dataMapBilling.get("country"),
					"Select Country from Drop down");
			selectValue("State", shippingAddressPage.stateDropdown, dataMapBilling.get("state"),
					"Select State from Drop down");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Entering Admin Address Information")
	public void enterAdminAddressFormat(String sheetName, String WebdataSheetName) {
		try {
			HashMap<String, String> dataMapBilling = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName),
					sheetName);
			ReusableMethods.scrollIntoView(getElement(adminMenuNavigation.custmrstreetAddress), driver);
			enterText("Street Address in Line 1", adminMenuNavigation.custmrstreetAddress,
					dataMapBilling.get("addressLine1"), "Enter Street Address in Line 1 in TextBox");
//			enterText("Street Address in Line 2", shippingAddressPage.shippingAddress2Textbox,
//					dataMapBilling.get("addressLine2"), "Enter Street Address in Line 2 in TextBox");
//			enterText("Street Address in Line 3", shippingAddressPage.shippingAddress3Textbox,
//					dataMapBilling.get("addressLine3"), "Enter Street Address in Line 3 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", adminMenuNavigation.custmrCity, dataMapBilling.get("city"), "Enter City in TextBox");
			Thread.sleep(2000);
			System.out.println(dataMapBilling.get("country"));
			selectValueFromDropdown("select Country", adminMenuNavigation.getCountryDropdown(),"Canada");
			Thread.sleep(1000);
			selectValueFromDropdown("select Country", adminMenuNavigation.getstateDropdown(), dataMapBilling.get("state"));
			ReusableMethods.scrollIntoView(getElement(adminMenuNavigation.custmrZipCode), driver);
			enterText("Postal Code", adminMenuNavigation.custmrZipCode, dataMapBilling.get("postalCode"),
					"Enter Postal Code in TextBox");
			enterText("Phone", adminMenuNavigation.custmrPhone, dataMapBilling.get("phone"),
					"Enter Phone No in TextBox");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Step("Select Value: {2} in {0} dropdown.")
	public void selectValueFromDropdown(String message, WebElement element, String value) throws Exception {
		ReusableMethods.scrollIntoView(element, driver);
		Select select = new Select(element);
		select.selectByVisibleText(value);
		ScreenshotUtil.takeScreenshotForAllure(driver);
	}

	

	@Step("Navigate to 'Contact Person'")
	public void verifyContactPersonHeaderIsVisible() {
		try {
			PublicCommon.waitForSec(15);
			ReusableMethods.scrollIntoView(getElement(contactPersonPage.contactPersonHeader), driver);
			verifyVisibility("Contact Person", contactPersonPage.contactPersonHeader,
					"Contact Person Header should be visible");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify Contact Person header is visible", e);
		}
	}

	@Step("Entering Contact Person Information")
	public void enterContactPerson() {
		try {
			HashMap<String, String> dataMapBilling = ExcelDataConfig.getMapData(ConfigReader.getValue("IntegrationExcelPath"), "ContactPerson");
			enterText("First Name", contactPersonPage.firstNameTextbox, dataMapBilling.get("firstName"), "Enter First Name in TextBox");
			enterText("Last Name", contactPersonPage.lastNameTextbox, dataMapBilling.get("lastName"), "Enter Last Name in TextBox");
			enterText("Phone", contactPersonPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			clickONMethod("Continue Button ", contactPersonPage.continueButton, "Continue button should be clickable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Entering Contact Person Information")
	public void enterShippingContactPerson(String sheetName, String WebdataSheetName) {
		try {
			PublicCommon.waitForSec(10);
			HashMap<String, String> dataMapBilling = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName), sheetName);
			//HashMap<String, String> dataMapBilling = ExcelDataConfig.getMapData(ConfigReader.getValue("IntegrationExcelPath"), "ContactPerson");
			enterText("First Name", contactPersonPage.firstNameTextbox, dataMapBilling.get("firstName"), "Enter First Name in TextBox");
			enterText("Last Name", contactPersonPage.lastNameTextbox, dataMapBilling.get("lastName"), "Enter Last Name in TextBox");
			enterText("Phone", contactPersonPage.phoneTextbox, dataMapBilling.get("phone"), "Enter phone in TextBox");
			clickONMethod("Continue Button ", contactPersonPage.continueButton, "Continue button should be clickable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * This method is used to change the Contact Person from PaymentPage.
	 * 
	 * @param firstName
	 * @return
	 */
	public boolean changeContactPerson(String firstName) {
		try {
			getElement(paymentPage.changeBtnContactPersonAddress).click();
			enterText("First Name", contactPersonPage.firstNameTextbox, firstName, "Enter First Name in TextBox");
			clickONMethod("Continue Button ", contactPersonPage.continueButton, "Continue button should be clickable");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Step("Verify 'Third Party Shipping' Header is Visible.")
	public void verifyThirdPartyShippingHeaderIsVisible() {
		try {
			Assert.assertTrue(TPShippingPage.verifyThirdPartyShippingHeaderIsVisible(),
					"'Third Party Shipping Address' Header is not Visible.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Third party page header validation - Exception.", e);
		}
	}

	/**
	 * Pass String ='Courier' to Insert only Courier Details. <Br>
	 * String ='Both' to Insert Freight and Courier Details <Br>
	 * String ='Freight' to Insert Only Freight Details.
	 * 
	 * @param enterCourier
	 */
	@Step("Entering Third Party Shipping Information")
	public void enterThirdPartyInformation(String enterCourier) {
		try {
			//HashMap<String, String> dataThridParty = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName), sheetName);
			HashMap<String, String> dataThridParty = PublicCommon.getMapperData(ConfigReader.getValue("WebDataExcelPath"), "Third Party Shipping");
			if (enterCourier.equalsIgnoreCase("Courier")) {
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);
				selectValue("Company", TPShippingPage.companyDropdown, dataThridParty.get("CompanyTP"), "Select State from Drop down");
				enterText("Account Number", TPShippingPage.accountNumberTextbox, dataThridParty.get("Account NumberTP"), "Enter Account Number in TextBox");
			}
			else if(enterCourier.equalsIgnoreCase("Both")){
				enterText("Organization name", TPShippingPage.companyTextbox, dataThridParty.get("Organisation NameTP"), "Enter Organization Name in TextBox");
				enterText("First Name", TPShippingPage.firstNameTextbox, dataThridParty.get("First NameTP"), "Enter First Name in TextBox");
				enterText("Last Name", TPShippingPage.lastNameTextbox, dataThridParty.get("Last NameTP"), "Enter Last Name in TextBox");
				enterText("Email Address", TPShippingPage.emailTextbox, dataThridParty.get("emailTP"), "Enter Email in TextBox");
				enterText("Phone Number", TPShippingPage.phoneTextbox, dataThridParty.get("TelephoneTP"), "Enter phone in TextBox");
				enterText("Street Address Line 1", TPShippingPage.shippingAddress1Textbox, dataThridParty.get("Add1TP"), "Enter Street Address in Line 1 in TextBox");
//
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);

				// TPShippingPage.setCountryValue("United States");
				// TPShippingPage.setCountryValue("India");
				enterText("City", TPShippingPage.cityTextbox, dataThridParty.get("CityTP"), "Enter City in TextBox");

				selectValue("State", TPShippingPage.stateDropdown, dataThridParty.get("StateTP"), "Select State from Drop down");
				enterText("Postal Code", TPShippingPage.postalCodeTextbox, dataThridParty.get("Postal CodeTP"), "Enter Postal Code in TextBox");
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);
				selectValue("Company", TPShippingPage.companyDropdown, dataThridParty.get("CompanyTP"), "Select State from Drop down");
				WaitStatementUtils.waitForElementToBeClickable(driver, commonPage.getElement(TPShippingPage.accountNumberTextbox));
				enterText("Account Number", TPShippingPage.accountNumberTextbox, dataThridParty.get("Account NumberTP"), "Enter Account Number in TextBox");
			}
			else{
				enterText("Organization name", TPShippingPage.companyTextbox, dataThridParty.get("Organisation NameTP"),
						"Enter Organization Name in TextBox");
				enterText("First Name", TPShippingPage.firstNameTextbox, dataThridParty.get("First NameTP"),
						"Enter First Name in TextBox");
				enterText("Last Name", TPShippingPage.lastNameTextbox, dataThridParty.get("Last NameTP"),
						"Enter Last Name in TextBox");
				enterText("Email Address", TPShippingPage.emailTextbox, dataThridParty.get("emailTP"),
						"Enter Email in TextBox");
				enterText("Phone Number", TPShippingPage.phoneTextbox, dataThridParty.get("TelephoneTP"),
						"Enter phone in TextBox");
				enterText("Street Address Line 1", TPShippingPage.shippingAddress1Textbox, dataThridParty.get("Add1TP"),
						"Enter Street Address in Line 1 in TextBox");
				enterText("Street Address Line 2", TPShippingPage.shippingAddress2Textbox, dataThridParty.get("Add2TP"),
						"Enter Street Address in Line 2 in TextBox");
				enterText("Street Address Line 3", TPShippingPage.shippingAddress3Textbox, dataThridParty.get("Add3TP"),
						"Enter Street Address in Line 3 in TextBox");
//				enterText("Street Address Line 4", TPShippingPage.shippingAddress4Textbox, dataThridParty.get("Add4TP"),
//						"Enter Street Address in Line 4 in TextBox");
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);

				// TPShippingPage.setCountryValue("United States");
				// TPShippingPage.setCountryValue("India");
				enterText("City", TPShippingPage.cityTextbox, dataThridParty.get("CityTP"), "Enter City in TextBox");

				selectValue("State", TPShippingPage.stateDropdown, dataThridParty.get("StateTP"),
						"Select State from Drop down");
				enterText("Postal Code", TPShippingPage.postalCodeTextbox, dataThridParty.get("Postal CodeTP"),
						"Enter Postal Code in TextBox");
				if (enterCourier.equalsIgnoreCase("Both")) {
					selectValue("Company", TPShippingPage.companyDropdown, dataThridParty.get("CompanyTP"),
							"Select State from Drop down");
					/*enterText("Account Number", TPShippingPage.accountNumberTextbox,
							dataThridParty.get("Account NumberTP"), "Enter Account Number in TextBox");
			*/	}
			}

			Thread.sleep(2000);
			// TPShippingPage.clickContinueButton();
			clickONMethod("Continue Button", TPShippingPage.thirdPartyContinueButton,
					"Continue button should be clickable");
			Thread.sleep(2000);
			// TPShippingPage.clickContinueButton();

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Third Party Shipping Address", e);
		}
	}

	@Step("Entering Third Party Shipping Information")
	public void enterThirdPartyShippingInformation(String enterCourier,String sheetName, String WebdataSheetName,String email) {
		try {
			PublicCommon.waitForSec(20);
			HashMap<String, String> dataThridParty = ExcelDataConfig.getMapData(ConfigReader.getValue(WebdataSheetName), sheetName);
			if (enterCourier.equalsIgnoreCase("Courier")) {
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);
				selectValue("Company", TPShippingPage.companyDropdown, dataThridParty.get("CompanyTP"), "Select State from Drop down");
				enterText("Account Number", TPShippingPage.accountNumberTextbox, dataThridParty.get("Account NumberTP"), "Enter Account Number in TextBox");
			}
			else if(enterCourier.equalsIgnoreCase("Both")){
				enterText("Organization name", TPShippingPage.companyTextbox, dataThridParty.get("Organisation NameTP"), "Enter Organization Name in TextBox");
				enterText("First Name", TPShippingPage.firstNameTextbox, dataThridParty.get("First NameTP"), "Enter First Name in TextBox");
				enterText("Last Name", TPShippingPage.lastNameTextbox, dataThridParty.get("Last NameTP"), "Enter Last Name in TextBox");
				enterText("Email Address", TPShippingPage.emailTextbox, email, "Enter Email in TextBox");
				enterText("Phone Number", TPShippingPage.phoneTextbox, dataThridParty.get("TelephoneTP"), "Enter phone in TextBox");
				enterText("Street Address Line 1", TPShippingPage.shippingAddress1Textbox, dataThridParty.get("Add1TP"), "Enter Street Address in Line 1 in TextBox");
//
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);

				// TPShippingPage.setCountryValue("United States");
				// TPShippingPage.setCountryValue("India");
				enterText("City", TPShippingPage.cityTextbox, dataThridParty.get("CityTP"), "Enter City in TextBox");

				selectValue("State", TPShippingPage.stateDropdown, dataThridParty.get("StateTP"), "Select State from Drop down");
				enterText("Postal Code", TPShippingPage.postalCodeTextbox, dataThridParty.get("Postal CodeTP"), "Enter Postal Code in TextBox");

				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);
				if(!billingAddressPage.isElementDisplayed(getElement(TPShippingPage.onlyFillPTPLink)))
				{
				if((getElement(TPShippingPage.companyDropdown).isEnabled()&& getElement(TPShippingPage.accountNumberTextbox).isEnabled())) {
					WaitStatementUtils.waitForElementToBeClickable(driver, getElement(TPShippingPage.companyDropdown));
					selectValue("Company", TPShippingPage.companyDropdown, dataThridParty.get("CompanyTP"), "Select Company from Drop down");
					Assert.assertTrue(IntegrationCommon.getSelectedValuefromDropDown(getElement(TPShippingPage.companyDropdown)).contains(dataThridParty.get("CompanyTP")));

					WaitStatementUtils.waitForElementToBeClickable(driver, commonPage.getElement(TPShippingPage.accountNumberTextbox));
					ReusableMethods.scrollIntoView(getElement(TPShippingPage.accountNumberTextbox), driver);
					enterText("Account Number", TPShippingPage.accountNumberTextbox, dataThridParty.get("Account NumberTP"), "Enter Account Number in TextBox");
				}
				}
			}
			else{
				enterText("Organization name", TPShippingPage.companyTextbox, dataThridParty.get("Organisation NameTP"),
						"Enter Organization Name in TextBox");
				enterText("First Name", TPShippingPage.firstNameTextbox, dataThridParty.get("First NameTP"),
						"Enter First Name in TextBox");
				enterText("Last Name", TPShippingPage.lastNameTextbox, dataThridParty.get("Last NameTP"),
						"Enter Last Name in TextBox");
				enterText("Email Address", TPShippingPage.emailTextbox, dataThridParty.get("emailTP"),
						"Enter Email in TextBox");
				enterText("Phone Number", TPShippingPage.phoneTextbox, dataThridParty.get("TelephoneTP"),
						"Enter phone in TextBox");
				enterText("Street Address Line 1", TPShippingPage.shippingAddress1Textbox, dataThridParty.get("Add1TP"),
						"Enter Street Address in Line 1 in TextBox");
				enterText("Street Address Line 2", TPShippingPage.shippingAddress2Textbox, dataThridParty.get("Add2TP"),
						"Enter Street Address in Line 2 in TextBox");
				enterText("Street Address Line 3", TPShippingPage.shippingAddress3Textbox, dataThridParty.get("Add3TP"),
						"Enter Street Address in Line 3 in TextBox");
//				enterText("Street Address Line 4", TPShippingPage.shippingAddress4Textbox, dataThridParty.get("Add4TP"),
//						"Enter Street Address in Line 4 in TextBox");
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);

				// TPShippingPage.setCountryValue("United States");
				// TPShippingPage.setCountryValue("India");
				enterText("City", TPShippingPage.cityTextbox, dataThridParty.get("CityTP"), "Enter City in TextBox");

				selectValue("State", TPShippingPage.stateDropdown, dataThridParty.get("StateTP"),
						"Select State from Drop down");
				enterText("Postal Code", TPShippingPage.postalCodeTextbox, dataThridParty.get("Postal CodeTP"),
						"Enter Postal Code in TextBox");
				if (enterCourier.equalsIgnoreCase("Both")) {
					selectValue("Company", TPShippingPage.companyDropdown, dataThridParty.get("CompanyTP"),
							"Select State from Drop down");
					/*enterText("Account Number", TPShippingPage.accountNumberTextbox,
							dataThridParty.get("Account NumberTP"), "Enter Account Number in TextBox");
			*/	}
			}

			Thread.sleep(2000);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			// TPShippingPage.clickContinueButton();
			clickONMethod("Continue Button", TPShippingPage.thirdPartyContinueButton,
					"Continue button should be clickable");
			Thread.sleep(2000);
			// TPShippingPage.clickContinueButton();
			if(dataThridParty.get("CountryTP").contains("United States")) {
				Assert.assertTrue(AddressValidationHeader(),"Unable to validate Address Validation Header");
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Third Party Shipping Address", e);
		}
	}


	@Step("Entering Third Party Shipping Information")
	public void enterandVerifyThirdPartyShippingInformation(String enterCourier,String filename,String JsonPrimeElement,String email) {
		try {
			if (enterCourier.equalsIgnoreCase("Courier")) {
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);
				selectValue("Company", TPShippingPage.companyDropdown, jsonFileReader.getJsonString(filename,JsonPrimeElement,"CompanyTP"), "Select State from Drop down");
				enterText("Account Number", TPShippingPage.accountNumberTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"AccountNumberTP"), "Enter Account Number in TextBox");
			}
			else if(enterCourier.equalsIgnoreCase("Both")){
				enterText("Organization name", TPShippingPage.companyTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"OrganisationNameTP"), "Enter Organization Name in TextBox");
				enterText("First Name", TPShippingPage.firstNameTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"FirstNameTP"), "Enter First Name in TextBox");
				enterText("Last Name", TPShippingPage.lastNameTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"LastNameTP"), "Enter Last Name in TextBox");
				enterText("Email Address", TPShippingPage.emailTextbox, email, "Enter Email in TextBox");
				enterText("Phone Number", TPShippingPage.phoneTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"TelephoneTP"), "Enter phone in TextBox");
				enterText("Street Address Line 1", TPShippingPage.shippingAddress1Textbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"Add1TP"), "Enter Street Address in Line 1 in TextBox");
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);
				enterText("City", TPShippingPage.cityTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"CityTP"), "Enter City in TextBox");
				selectValue("State", TPShippingPage.stateDropdown, jsonFileReader.getJsonString(filename,JsonPrimeElement,"StateTP"), "Select State from Drop down");
				enterText("Postal Code", TPShippingPage.postalCodeTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"PostalCodeTP"), "Enter Postal Code in TextBox");

				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);
				if(!billingAddressPage.isElementDisplayed(getElement(TPShippingPage.onlyFillPTPLink)))
				{
					if((getElement(TPShippingPage.companyDropdown).isEnabled()&& getElement(TPShippingPage.accountNumberTextbox).isEnabled())) {
						WaitStatementUtils.waitForElementToBeClickable(driver, getElement(TPShippingPage.companyDropdown));
						selectValue("Company", TPShippingPage.companyDropdown, jsonFileReader.getJsonString(filename,JsonPrimeElement,"CompanyTP"), "Select Company from Drop down");
						Assert.assertTrue(IntegrationCommon.getSelectedValuefromDropDown(getElement(TPShippingPage.companyDropdown)).contains(jsonFileReader.getJsonString(filename,JsonPrimeElement,"CompanyTP")));

						WaitStatementUtils.waitForElementToBeClickable(driver, commonPage.getElement(TPShippingPage.accountNumberTextbox));
						ReusableMethods.scrollIntoView(getElement(TPShippingPage.accountNumberTextbox), driver);
						enterText("Account Number", TPShippingPage.accountNumberTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"AccountNumberTP"), "Enter Account Number in TextBox");
					}
				}
			}
			else{
				enterText("Organization name", TPShippingPage.companyTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"OrganisationNameTP"),
						"Enter Organization Name in TextBox");
				enterText("First Name", TPShippingPage.firstNameTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"FirstNameTP"),
						"Enter First Name in TextBox");
				enterText("Last Name", TPShippingPage.lastNameTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"LastNameTP"),
						"Enter Last Name in TextBox");
				enterText("Email Address", TPShippingPage.emailTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"emailTP"),
						"Enter Email in TextBox");
				enterText("Phone Number", TPShippingPage.phoneTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"TelephoneTP"),
						"Enter phone in TextBox");
				enterText("Street Address Line 1", TPShippingPage.shippingAddress1Textbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"Add1TP"),
						"Enter Street Address in Line 1 in TextBox");
				enterText("Street Address Line 2", TPShippingPage.shippingAddress2Textbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"Add2TP"),
						"Enter Street Address in Line 2 in TextBox");
				enterText("Street Address Line 3", TPShippingPage.shippingAddress3Textbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"AddTP"),
						"Enter Street Address in Line 3 in TextBox");
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);
				enterText("City", TPShippingPage.cityTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"CityTP"), "Enter City in TextBox");

				selectValue("State", TPShippingPage.stateDropdown, jsonFileReader.getJsonString(filename,JsonPrimeElement,"StateTP"),
						"Select State from Drop down");
				enterText("Postal Code", TPShippingPage.postalCodeTextbox, jsonFileReader.getJsonString(filename,JsonPrimeElement,"PostalCodeTP"),
						"Enter Postal Code in TextBox");
				if (enterCourier.equalsIgnoreCase("Both")) {
					selectValue("Company", TPShippingPage.companyDropdown, jsonFileReader.getJsonString(filename,JsonPrimeElement,"CompanyTP"),
							"Select State from Drop down");
				}
			}
			Thread.sleep(2000);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			clickONMethod("Continue Button", TPShippingPage.thirdPartyContinueButton,
					"Continue button should be clickable");
			Thread.sleep(2000);
			if(jsonFileReader.getJsonString(filename,JsonPrimeElement,"CountryTP").contains("United States")) {
				Assert.assertTrue(AddressValidationHeader(),"Unable to validate Address Validation Header");
			}
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Third Party Shipping Address", e);
		}
	}

	/*public void AddressValidationHeader(){
		WaitStatementUtils.waitForElementToBeClickable(driver, TPShippingPage.getElement(TPShippingPage.AddressValContinueBtn), 5);
		if(TPShippingPage.getElement(TPShippingPage.AddressValidationHeader).isDisplayed()) {
			TPShippingPage.getElement(TPShippingPage.AddressValContinueBtn).click();
		} else {
			return;
		}
	}*/

	@Step("Verify Address validation Pop up")
	public boolean AddressValidationHeader(){
		boolean value=false;
		try {
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if (driver.findElements(TPShippingPage.AddressValidationHeader).size() > 0) {
				ScreenshotUtil.takeScreenshotForAllure(driver);
				getElement(TPShippingPage.AddressValContinueBtn).click();
				value=true;
			}
			else if (driver.findElements(TPShippingPage.SuggestedAddressHeader).size() > 0) {
				ScreenshotUtil.takeScreenshotForAllure(driver);
				getElement(TPShippingPage.SuggestedAddressContinueBtn).click();
				value=true;
			}
			else {
				ScreenshotUtil.takeScreenshotForAllure(driver);
				value=true;
			}
		} catch (Exception e) {
			value=false;
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to validate address validation header", e);
		}
		return value;
	}

	/**
	 * Pass String ='Courier' to Insert only Courier Details. <Br>
	 * String ='Both' to Insert Freight and Courier Details <Br>
	 * String ='Freight' to Insert Only Freight Details.
	 * 
	 * @param enterCourier
	 */
	@Step("Entering Third Party Shipping Information")
	public void enterThirdPartyInformation(String enterCourier, String webdataSheetName) {
		try {
			HashMap<String, String> dataThridParty = PublicCommon
					.getMapperData(ConfigReader.getValue("WebDataExcelPath"), webdataSheetName);
			System.out.println("::::::::" + dataThridParty);
			if (enterCourier.equalsIgnoreCase("Courier")) {
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);
				selectValue("Company", TPShippingPage.companyDropdown, dataThridParty.get("CompanyTP"),
						"Select State from Drop down");
				enterText("Account Number", TPShippingPage.accountNumberTextbox, dataThridParty.get("Account NumberTP"),
						"Enter Account Number in TextBox");
			} else {
				enterText("Organization name", TPShippingPage.companyTextbox, dataThridParty.get("Organisation NameTP"),
						"Enter Organization Name in TextBox");
				enterText("First Name", TPShippingPage.firstNameTextbox, dataThridParty.get("First NameTP"),
						"Enter First Name in TextBox");
				enterText("Last Name", TPShippingPage.lastNameTextbox, dataThridParty.get("Last NameTP"),
						"Enter Last Name in TextBox");
				enterText("Email Address", TPShippingPage.emailTextbox, dataThridParty.get("emailTP"),
						"Enter Email in TextBox");
				enterText("Phone Number", TPShippingPage.phoneTextbox, dataThridParty.get("TelephoneTP"),
						"Enter phone in TextBox");
				enterText("Street Address Line 1", TPShippingPage.shippingAddress1Textbox, dataThridParty.get("Add1TP"),
						"Enter Street Address in Line 1 in TextBox");
				enterText("Street Address Line 2", TPShippingPage.shippingAddress2Textbox, dataThridParty.get("Add2TP"),
						"Enter Street Address in Line 2 in TextBox");
				enterText("Street Address Line 3", TPShippingPage.shippingAddress3Textbox, dataThridParty.get("Add3TP"),
						"Enter Street Address in Line 3 in TextBox");

				  enterText("Street Address Line 4", TPShippingPage.shippingAddress4Textbox,
				 dataThridParty.get("Add4TP"), "Enter Street Address in Line 4 in TextBox");
				 //*ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);

				TPShippingPage.setCountryValue("United States");
				// TPShippingPage.setCountryValue("India");
				enterText("City", TPShippingPage.cityTextbox, dataThridParty.get("CityTP"), "Enter City in TextBox");

				selectValue("State", TPShippingPage.stateDropdown, dataThridParty.get("StateTP"),
						"Select State from Drop down");
				enterText("Postal Code", TPShippingPage.postalCodeTextbox, dataThridParty.get("Postal CodeTP"),
						"Enter Postal Code in TextBox");
				if (enterCourier.equalsIgnoreCase("Both")) {
					selectValue("Company", TPShippingPage.companyDropdown, dataThridParty.get("CompanyTP"),
							"Select State from Drop down");
					enterText("Account Number", TPShippingPage.accountNumberTextbox,
							dataThridParty.get("Account NumberTP"), "Enter Account Number in TextBox");
				}
			}

			Thread.sleep(2000);
			// TPShippingPage.clickContinueButton();
			clickONMethod("Continue Button", TPShippingPage.thirdPartyContinueButton,
					"Continue button should be clickable");
			Thread.sleep(2000);
			// TPShippingPage.clickContinueButton();

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Third Party Shipping Address", e);
		}
	}

	@Step("Entering Third Party Shipping Information")
	public void enterThirdPartyInformation(String enterCourier, String webdataSheetName, String orgName) {
		try {

			HashMap<String, String> dataThridParty = PublicCommon
					.getMapperData(ConfigReader.getValue("WebDataExcelPath"), webdataSheetName);
			System.out.println("::::::::" + dataThridParty);
			if (enterCourier.equalsIgnoreCase("Courier")) {
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);
				selectValue("Company", TPShippingPage.companyDropdown, dataThridParty.get("CompanyTP"),
						"Select State from Drop down");
				enterText("Account Number", TPShippingPage.accountNumberTextbox, dataThridParty.get("Account NumberTP"),
						"Enter Account Number in TextBox");
			} else {
				enterText("Organization name", TPShippingPage.companyTextbox, orgName,
						"Enter Organization Name in TextBox");
				enterText("First Name", TPShippingPage.firstNameTextbox, dataThridParty.get("First NameTP"),
						"Enter First Name in TextBox");
				enterText("Last Name", TPShippingPage.lastNameTextbox, dataThridParty.get("Last NameTP"),
						"Enter Last Name in TextBox");
				enterText("Email Address", TPShippingPage.emailTextbox, dataThridParty.get("emailTP"),
						"Enter Email in TextBox");
				enterText("Phone Number", TPShippingPage.phoneTextbox, dataThridParty.get("TelephoneTP"),
						"Enter phone in TextBox");
				enterText("Street Address Line 1", TPShippingPage.shippingAddress1Textbox, dataThridParty.get("Add1TP"),
						"Enter Street Address in Line 1 in TextBox");
				enterText("Street Address Line 2", TPShippingPage.shippingAddress2Textbox, dataThridParty.get("Add2TP"),
						"Enter Street Address in Line 2 in TextBox");
				enterText("Street Address Line 3", TPShippingPage.shippingAddress3Textbox, dataThridParty.get("Add3TP"),
						"Enter Street Address in Line 3 in TextBox");
				//*
				  enterText("Street Address Line 4", TPShippingPage.shippingAddress4Textbox,
				  dataThridParty.get("Add4TP"), "Enter Street Address in Line 4 in TextBox");
				 //*ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);

				TPShippingPage.setCountryValue("United States");
				// TPShippingPage.setCountryValue("India");
				enterText("City", TPShippingPage.cityTextbox, dataThridParty.get("CityTP"), "Enter City in TextBox");

				selectValue("State", TPShippingPage.stateDropdown, dataThridParty.get("StateTP"),
						"Select State from Drop down");
				enterText("Postal Code", TPShippingPage.postalCodeTextbox, dataThridParty.get("Postal CodeTP"),
						"Enter Postal Code in TextBox");
				if (enterCourier.equalsIgnoreCase("Both")) {
					selectValue("Company", TPShippingPage.companyDropdown, dataThridParty.get("CompanyTP"),
							"Select State from Drop down");
					enterText("Account Number", TPShippingPage.accountNumberTextbox,
							dataThridParty.get("Account NumberTP"), "Enter Account Number in TextBox");
				}
			}

			Thread.sleep(2000);
			// TPShippingPage.clickContinueButton();
			clickONMethod("Continue Button", TPShippingPage.thirdPartyContinueButton,
					"Continue button should be clickable");
			Thread.sleep(2000);
			// TPShippingPage.clickContinueButton();

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Third Party Shipping Address", e);
		}
	}

	@Step("Entering Third Party Shipping Information")
	public void enterThirdPartyInformationFreight(String enterCourier, String webdataSheetName) {
		try {
			HashMap<String, String> dataThridParty = PublicCommon
					.getMapperData(ConfigReader.getValue("WebDataExcelPath"), webdataSheetName);
			System.out.println("::::::::" + dataThridParty);
			if (enterCourier.equalsIgnoreCase("Courier")) {
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);
				selectValue("Company", TPShippingPage.companyDropdown, dataThridParty.get("CompanyTP"),
						"Select State from Drop down");
				enterText("Account Number", TPShippingPage.accountNumberTextbox, dataThridParty.get("Account NumberTP"),
						"Enter Account Number in TextBox");
			} else {
				enterText("Organization name", TPShippingPage.companyTextbox, dataThridParty.get("Organisation NameTP"),
						"Enter Organization Name in TextBox");
				enterText("First Name", TPShippingPage.firstNameTextbox, dataThridParty.get("First NameTP"),
						"Enter First Name in TextBox");
				enterText("Last Name", TPShippingPage.lastNameTextbox, dataThridParty.get("Last NameTP"),
						"Enter Last Name in TextBox");
				enterText("Email Address", TPShippingPage.emailTextbox, dataThridParty.get("emailTP"),
						"Enter Email in TextBox");
				enterText("Phone Number", TPShippingPage.phoneTextbox, dataThridParty.get("TelephoneTP"),
						"Enter phone in TextBox");
				enterText("Street Address Line 1", TPShippingPage.shippingAddress1Textbox, dataThridParty.get("Add1TP"),
						"Enter Street Address in Line 1 in TextBox");
				enterText("Street Address Line 2", TPShippingPage.shippingAddress2Textbox, dataThridParty.get("Add2TP"),
						"Enter Street Address in Line 2 in TextBox");
				enterText("Street Address Line 3", TPShippingPage.shippingAddress3Textbox, dataThridParty.get("Add3TP"),
						"Enter Street Address in Line 3 in TextBox");
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);
				TPShippingPage.setCountryValue("United States");
				// TPShippingPage.setCountryValue("India");
				enterText("City", TPShippingPage.cityTextbox, dataThridParty.get("CityTP"), "Enter City in TextBox");

				selectValue("State", TPShippingPage.stateDropdown, dataThridParty.get("StateTP"),
						"Select State from Drop down");
				enterText("Postal Code", TPShippingPage.postalCodeTextbox, dataThridParty.get("Postal CodeTP"),
						"Enter Postal Code in TextBox");
				if (enterCourier.equalsIgnoreCase("Both")) {
					selectValue("Company", TPShippingPage.companyDropdown, dataThridParty.get("CompanyTP"),
							"Select State from Drop down");
					enterText("Account Number", TPShippingPage.accountNumberTextbox,
							dataThridParty.get("Account NumberTP"), "Enter Account Number in TextBox");
				}
			}


			 TPShippingPage.clickContinueButton();
//			clickONMethod("Continue Button", TPShippingPage.thirdPartyContinueButton,
//					"Continue button should be clickable");
//			Thread.sleep(2000);
			// TPShippingPage.clickContinueButton();

			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Third Party Shipping Address", e);
		}
	}

	@Step("Click Continue Button on Third Party Shipping Page.")
	public void clickContinueButtonOnThirdPartyShippingPage() {
		try {
			// ReusableMethods.scrollIntoView(getElement(TPShippingPage.thirdPartyContinueButton),
			// driver);
			assertTrue(TPShippingPage.clickContinueButton(), "Click Continue Button.");
			ScreenshotUtil.takeScreenshotForAllure(driver);
		} catch (Exception e) {
			e.printStackTrace();
			// log.info(e.toString());
			PublicCommon.reportFailAssert("Third Party Page - Exception.", e);
		}
	}

	/**
	 * This method is used to Change the FreightForwader and Shipping courier
	 * Service Address.
	 * 
	 * @param streetAddress
	 * @param courierCompany
	 * @return
	 */
	public boolean changeFrightForwarderAndShippingCourierService(String streetAddress, String courierCompany,
			String tpsService) {
		try {
			if (tpsService.equalsIgnoreCase("FF")) {
				getElement(TPShippingPage.changeBtnFrightForwarder).click();
				enterText("Street Address Line 4", TPShippingPage.shippingAddress3Textbox, streetAddress,
						"Enter Street Address in Line 4 in TextBox");
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);

			} else {
				ReusableMethods.scrollIntoView(getElement(TPShippingPage.companyDropdown), driver);
				selectValue("Company", TPShippingPage.companyDropdown, courierCompany, "Select State from Drop down");

				ScreenshotUtil.takeScreenshotForAllure(driver);
			}
			clickONMethod("Continue Button ", TPShippingPage.thirdPartyContinueButton,
					"Continue button should be clickable");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Step("Click on Continue Button on Third Party Information")
	public void clickOnContinue() {
		try {
			ReusableMethods.scrollIntoView(getElement(TPShippingPage.thirdPartyContinueButton), driver);
			clickONMethod("Continue Button ", TPShippingPage.thirdPartyContinueButton,
					"Continue button should be clickable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Enter {elementName} :'{keys}' in TextBox.")
	public void enterText(String elementName, By locator, String keys, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.clearTxtFieldsendKeys(driver, locator, keys), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Enter data in Text box", e);
		}
	}

	@Step("Select {elementName}: '{keys}'in DropDown")
	public void selectValue(String elementName, By locator, String keys, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.selectValueInDropdown(getElement(locator), keys), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Select value from dropdown.", e);
		}
	}

	@Step("Click on {elementName}")
	private void clickONMethod(String elementName, By locator, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.clickonWebElement(driver, locator), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to Click on element", e);
		}
	}

	@Step("Verify Visibility of Element {elementName}")
	public void verifyVisibility(String elementName, By locator, String assertionMessage) {
		try {
			assertTrue(IntegrationCommon.isWebElementDisplayed(driver, locator), assertionMessage);
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify visibility of element", e);
		}
	}

	/**
	 * This Method will click on file Link and verify it's getting download or not
	 * in Downloads folder.
	 * 
	 * @param
	 * @param
	 * @return True/False
	 */
	public Boolean ifFileExist(String fileName, WebElement element) {
		try {
			String downloadFolderPath = System.getProperty("user.home") + "\\Downloads";
			String expectedFileName = "\\" + fileName;
			File file = new File(downloadFolderPath + expectedFileName);
			if (file.exists())
				file.delete();
			ReusableMethods.scrollIntoView(element, driver);
			element.click();
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

	@Step("Sign out.")
	public void signOutfromDropDownIfMYASTMloadingLate() {
		try {
			try {
				WebElement MyAstm = getElement(myAccountPage_public.astmButton);
				new WebDriverWait(driver, 45).until(ExpectedConditions.visibilityOf(MyAstm));
				ReusableMethods.scrollIntoView(MyAstm, driver);
				if (MyAstm.isDisplayed() == false) {
					driver.navigate().refresh();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			clickONMethod("'MY ASTM' button", myAccountPage_public.astmButton, "Couldn't click on MY ASTM button");
			clickONMethod("Sign out button", myAccountPage_public.signOutBtn, "Couldn't click on Sign out button");
		} catch (Exception e) {
			e.getStackTrace();
			PublicCommon.reportFailAssert("Failed to logout", e);
		}
	}

	@Step("Sign out.")
	public void signOutfromDropDown() {
		try {
			try {
				WebElement MyAstm = getElement(myAccountPage_public.astmButton);
				new WebDriverWait(driver, 45).until(ExpectedConditions.visibilityOf(MyAstm));
				ReusableMethods.scrollIntoView(MyAstm, driver);
			} catch (Exception e) {
				e.printStackTrace();
			}
			clickONMethod("'MY ASTM' button", myAccountPage_public.astmButton, "Couldn't click on MY ASTM button");
			clickONMethod("Sign out button", myAccountPage_public.signOutBtn, "Couldn't click on Sign out button");
			PublicCommon.waitForSec(5);
		} catch (Exception e) {
			e.getStackTrace();
			PublicCommon.reportFailAssert("Failed to logout", e);
		}
	}

	@Step("Sign out.")
	public void signOutfromLeftNavigation() {
		try {
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				ReusableMethods.scrollIntoView(getElement(myAccountPage_public.pageHeaderText), driver);
			} catch (Exception e) {
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			clickONMethod("Sign out button", myAccountPage_public.signOutBtnLeftNav,
					"Couldn't click on Sign out button");
		} catch (Exception e) {
			e.getStackTrace();
			PublicCommon.reportFailAssert("Failed to logout", e);
		}
	}

	public void enterCourrierDetails(){
		try {
			HashMap<String, String> dataThridParty = PublicCommon
					.getMapperData(ConfigReader.getValue("WebDataExcelPath"), "Third Party Shipping");
			ReusableMethods.scrollIntoView(getElement(TPShippingPage.cityTextbox), driver);
			selectValue("Company", TPShippingPage.companyDropdown, dataThridParty.get("CompanyTP"),
					"Select State from Drop down");
			enterText("Account Number", TPShippingPage.accountNumberTextbox, dataThridParty.get("Account NumberTP"),
					"Enter Account Number in TextBox");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Courrier fields disabled");
		}
	}


	@Step("Entering Billing Information")
	public void changeBillingAddress(String JsonfileName, String JsonPrimeElement) {
		try {
			PublicCommon.waitForSec(10);
			ReusableMethods.scrollIntoView(getElement(paymentPage.changeBtnBillingAddress),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(paymentPage.changeBtnBillingAddress),5);
			getElement(paymentPage.changeBtnBillingAddress).click();

			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("Street Address in Line 1", billingAddressPage.billingAddress1Textbox,
					jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"addressLine1"), "Enter Street Address in Line 1 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", billingAddressPage.cityTextbox, jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", billingAddressPage.postalCodeTextbox, jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", billingAddressPage.countryDropdown, jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"country"),
					"Select Country from Drop down");
			selectValue("State", billingAddressPage.stateDropdown, jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"state"),
					"Select State from Drop down");
			if(jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"shipTO").equals("Different Address"))
			{
				billingAddressPage.unCheckShippingAddressCheckbox();
			}
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.billingAddressContinueButton),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(billingAddressPage.billingAddressContinueButton),5);
			clickONMethod("Continue Button ", billingAddressPage.billingAddressContinueButton,
					"Continue button should be clickable");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if(billingAddressPage.isElementDisplayed(getElement(billingAddressPage.AddmodelBoxText)))
			{
				if(((getElement(billingAddressPage.getModelBoxTitle()).getText().equals("Address Validation"))))
				{
					clickONMethod("Address Validation Continue Button", billingAddressPage.getContinueBtn(),
							"Address Validation Continue Button should be clickable");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Billing Address", e);
		}
	}

	@Step("Entering Shipping Information")
	public void changeShippingAddress(String JsonfileName, String JsonPrimeElement) {
		try {
			PublicCommon.waitForSec(10);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("First Name", shippingAddressPage.firstNameTextbox, jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"firstName"),
					"Enter First Name in TextBox");
			enterText("Middle Name", shippingAddressPage.middleNameTextbox, jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"middleName"),
					"Enter Middle Name in TextBox");
			enterText("Last Name", shippingAddressPage.lastNameTextbox, jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"lastName"),
					"Enter Last Name in TextBox");
			enterText("Street Address in Line 1", shippingAddressPage.shippingAddress1Textbox,
					jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"addressLine1"), "Enter Street Address in Line 1 in TextBox");
			enterText("Street Address in Line 2", shippingAddressPage.shippingAddress2Textbox,
					jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"addressLine2"), "Enter Street Address in Line 2 in TextBox");
			enterText("Street Address in Line 3", shippingAddressPage.shippingAddress3Textbox,
					jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"addressLine3"), "Enter Street Address in Line 3 in TextBox");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			enterText("City", shippingAddressPage.cityTextbox, jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"city"), "Enter City in TextBox");
			ReusableMethods.scrollIntoView(getElement(shippingAddressPage.postCodeLabel), driver);
			enterText("Postal Code", shippingAddressPage.postalCodeTextbox, jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"postalCode"),
					"Enter Postal Code in TextBox");
			selectValue("Country", shippingAddressPage.countryDropdown, jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"country"),
					"Select Country from Drop down");
			selectValue("State", shippingAddressPage.stateDropdown, jsonFileReader.getJsonString(JsonfileName,JsonPrimeElement,"state"),
					"Select State from Drop down");
			ReusableMethods.scrollIntoView(getElement(shippingAddressPage.shippingAddressContinueButton),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(shippingAddressPage.shippingAddressContinueButton),5);
			clickONMethod("Continue Button ", shippingAddressPage.shippingAddressContinueButton,
					"Continue button should be clickable");
			ScreenshotUtil.takeScreenshotForAllure(driver);
			if(billingAddressPage.isElementDisplayed(getElement(billingAddressPage.UseSelAddText)))
			{
				if(((getElement(billingAddressPage.getModelBoxTitle()).getText().equals("Confirm Address"))))
				{
					clickONMethod("Use Selected Address Continue Button", billingAddressPage.getUseSelectedAddressBTN(),
							"Use Selected Address Continue Button should be clickable");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to enter Shipping Address", e);
		}
	}

	@Step("Verify address gets validated for Correct address scenario")
	public void VerifyCorrectAddressScenarioPTP(String email){
		try{
			PublicCommon.waitForSec(5);
			commonPage.handleSpinnerIcon(driver, commonPage.spinnerIcon);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(billingAddressPage.billingAddressContinueButton),30);
			enterandValidateBillingAddress("Different Address","BillingAddresses","Correct_Billing_Address_US");
			PublicCommon.waitForSec(5);
			enterandvalidateShippingAddress("NonUsAddress","Canada Address1");
			PublicCommon.waitForSec(5);
			enterandVerifyThirdPartyShippingInformation("Courier","ThirdPartyShippingAddresses","Correct_Third_Party_Shipping_US",email);
			PublicCommon.waitForSec(5);
		} catch (Exception e) {
			PublicCommon.exceptionHandlingBlock(e, log, "Failed to Verify Billing Address Validation Scenario");
		}
	}

	@Step("Verify address gets validated for Wrong address scenario")
	public void VerifyWrongAddressScenarioPTP(String email){
		try{
			PublicCommon.waitForSec(5);
			enterandValidateBillingAddress("Different Address","BillingAddresses","Wrong_Billing_Address_US");
			PublicCommon.waitForSec(5);
			enterandvalidateShippingAddress("ShippingAddresses","Wrong_Shipping_Address_US");
			PublicCommon.waitForSec(10);
			ReusableMethods.scrollIntoView(getElement(paymentPage.goBackButton),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(paymentPage.goBackButton),30);
			clickONMethod("Go Back button", paymentPage.goBackButton, "Couldn't click on Go Back button");
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.billingAddressContinueButton),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(billingAddressPage.billingAddressContinueButton),30);
			clickONMethod("Billing Address Continue button", billingAddressPage.billingAddressContinueButton, "Couldn't click on Go Billing Address Continue Button");
			Assert.assertTrue(AddressValidationHeader(),"Unable to validate Address Validation Header");
			PublicCommon.waitForSec(5);
			enterandvalidateShippingAddress("NonUsAddress","Canada Address");
			PublicCommon.waitForSec(5);
			enterandVerifyThirdPartyShippingInformation("Both","ThirdPartyShippingAddresses","Wrong_Third_Party_Shippiing_US",email);
			PublicCommon.waitForSec(5);
		} catch (Exception e) {
			PublicCommon.exceptionHandlingBlock(e, log, "Failed to Verify Correct Address Scenario");
		}
	}

	@Step("Verify address gets validated for Diverted address scenario")
	public void VerifyDivertedAddressScenarioPTP(String email){
		try{
			PublicCommon.waitForSec(5);
			enterandValidateBillingAddress("Different Address","BillingAddresses","Diverted_Billing_Address_US");
			PublicCommon.waitForSec(5);
			enterandvalidateShippingAddress("ShippingAddresses","Diverted_Shipping_Address_US");
			PublicCommon.waitForSec(10);
			ReusableMethods.scrollIntoView(getElement(paymentPage.goBackButton),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(paymentPage.goBackButton),30);
			clickONMethod("Go Back button", paymentPage.goBackButton, "Couldn't click on Go Back button");
			ReusableMethods.scrollIntoView(getElement(billingAddressPage.billingAddressContinueButton),driver);
			WaitStatementUtils.waitForElementToBeClickable(driver,getElement(billingAddressPage.billingAddressContinueButton),30);
			clickONMethod("Billing Address Continue button", billingAddressPage.billingAddressContinueButton, "Couldn't click on Go Billing Address Continue Button");
			Assert.assertTrue(AddressValidationHeader(),"Unable to validate Address Validation Header");
			PublicCommon.waitForSec(5);
			enterandvalidateShippingAddress("NonUsAddress","Canada Address");
			PublicCommon.waitForSec(5);
			enterandVerifyThirdPartyShippingInformation("Both","ThirdPartyShippingAddresses","Diverted_Third_Party_Shippiing_US",email);
			PublicCommon.waitForSec(5);
		} catch (Exception e) {
		}
	}

	@Step("Verify address gets validated for Correct address scenario")
	public void VerifyCorrectAddressScenarioStandard(String email){
		try{
			enterandValidateBillingAddress("Different Address","BillingAddresses","Correct_Billing_Address_US");
			PublicCommon.waitForSec(2);
			enterandvalidateShippingAddress("ShippingAddresses","Correct_Shipping_Address_US");
		} catch (Exception e) {
			PublicCommon.exceptionHandlingBlock(e, log, "Failed to Verify Billing Address Validation Scenario");
		}
	}

	@Step("Verify address gets validated for Wrong address scenario")
	public void VerifyWrongAddressScenarioStandard(String email){
		try{
			PublicCommon.waitForSec(10);
			enterandValidateBillingAddress("Different Address","BillingAddresses","Wrong_Billing_Address_US");
			PublicCommon.waitForSec(2);
			enterandvalidateShippingAddress("ShippingAddresses","Wrong_Shipping_Address_US");
		} catch (Exception e) {
			PublicCommon.exceptionHandlingBlock(e, log, "Failed to Verify Correct Address Scenario");
		}
	}

	@Step("Verify address gets validated for Diverted address scenario")
	public void VerifyDivertedAddressScenarioStandard(String email){
		try{
			PublicCommon.waitForSec(10);
			enterandValidateBillingAddress("Different Address","BillingAddresses","Diverted_Billing_Address_US");
			PublicCommon.waitForSec(2);
			enterandvalidateShippingAddress("ShippingAddresses","Diverted_Shipping_Address_US");
		} catch (Exception e) {
		}
	}
}
