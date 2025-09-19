package pages.ui;

import java.util.ArrayList;
import java.util.List;

import base.utils.ScreenshotUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.astm.commonFunctions.IntegrationCommon;
import com.astm.commonFunctions.PublicCommon;

import base.utils.ReusableMethods;
import base.utils.WaitStatementUtils;

public class BulkOrder_Page extends BasePage {

	public BulkOrder_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub //getListOfTextFromListOfWebelements
		// //(//*[@class='astm-table-tr'])//td[1]
	}

	private By pageTitle = By.xpath("//*[@data-ui-id='page-title-wrapper']");

	private By dataColumnsRow = By.xpath("(//*[@class='astm-table-tr'])[1]");
	private By dataColumnsFields = By.xpath("(//*[@class='astm-table-tr'])[1]//th");

	private By dataProductNames = By.xpath("//div[@class='multiple-order-container']//tbody//a");
	private By dataComitteeNames = By.xpath("(//*[@class='astm-table-tr'])//td[2]");
	private By dataPrices = By.xpath("(//*[@class='astm-table-tr'])//td[3]");

	private By productLinks = By.xpath("(//*[@class='astm-table-tr'])//td[1]//a");
	private String productLinkXpath = "((//*[@class='astm-table-tr'])//td[1]//a[1])[anchorIndex]"; // "(//*[@class='astm-table-tr'])//td[1]//a[anchorIndex]";

	private By productCheckBoxes = By.xpath("(//*[@class='astm-table-tr'])//th[1]//label");

	public By addToCartButton = By.xpath("//button[contains(text(), 'Add to Cart')]");
	public By shoppingCartlink = By.linkText("shopping cart");
	private By successMessage = By
			.xpath("//*[@data-ui-id='message-success' and contains(.,'You added product(s) to your')]");
	public By extentsionChildPopup = By.xpath("//div[@id='ptp-bulk-extension-child-popup']/div//p");
	public By extentsionChildPopup_OKBTn = By.xpath("//div[@id='ptp-bulk-extension-child-popup']/div//a[2]");

	public By extensioinParentPopup = By.xpath("//div[contains(@id,'ptp-bulk-extension-parent-popup')]/div//p");
	public By extensioinParentPopup_OKBTN = By
			.xpath("//div[contains(@id,'ptp-bulk-extension-parent-popup')]/div//a[2]");

	public String getTextFromExtentionParentPopup() {

		return getElement(extensioinParentPopup).getText();

	}

	public By getCheckBoxByProductName(String productName){
		return By.xpath("//a[text()='"+productName+"']/../preceding-sibling::th//label");
	}

	public String getTextFromExtentionChildPopup() {

		return getElement(extentsionChildPopup).getText();

	}

	public boolean successMessageOnCartAddition() {

		try {
			return (getElements(successMessage).size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean shoppingCartLinkVisibility() {
		try {
			WaitStatementUtils.waitForElementToBeClickable(driver, getElement(shoppingCartlink), 5);
			return (getElements(shoppingCartlink).size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ASTMCartPage_Public clickOnShoppingCartLink() {
		try {
			getElement(shoppingCartlink).click();
			;
			return getInstance(ASTMCartPage_Public.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<WebElement> getWebElementsForProductNames() {
		try {
			return getElements(dataProductNames);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<WebElement> getWebElementsForComitteeNames() {
		try {
			return getElements(dataComitteeNames);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<WebElement> getWebElementsForPrices() {
		try {
			return getElements(dataPrices);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<WebElement> getWebElementsForProductLinks() {
		try {
			return getElements(productLinks);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public WebElement getWebElementsForProductLinks(int i) {
		try {
			return getElement(PublicCommon.createByOperatorXpath(productLinkXpath, "anchorIndex", String.valueOf(i)));
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<WebElement> getWebElementsForCheckBoxes() {
		try {
			return getElements(productCheckBoxes);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public WebElement getWebElementForCheckbox(String productName) {
		try {
			WebElement productname = getElement(By.xpath("//a[contains(@href,'"+productName+"')]/ancestor::tr//th//label"));

			/*
			 * WebElement productname = driver.findElement(By.xpath("(//*[@class='astm-table-tr'])//td[1]//a[text()='" + productName + "']/../preceding-sibling::th"));
			 * 
			 */
			ReusableMethods.scrollIntoView(productname, driver);
			return productname;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public WebElement getWebElementForCheckboxByText(String productName) {
		try {
			WebElement productname = getElement(By.xpath("//a[contains(text(),'"+productName+"')]/ancestor::tr//th//label"));

			/*
			 * WebElement productname = driver.findElement(By.xpath("(//*[@class='astm-table-tr'])//td[1]//a[text()='" + productName + "']/../preceding-sibling::th"));
			 *
			 */
			ReusableMethods.scrollIntoView(productname, driver);
			return productname;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public WebElement getWebElementForCheckboxEnable(String productName) {
		try {
			
			//a[contains(@href,'ptpmg2021.html')]/ancestor::tr//input
			WebElement productname = getElement(By.xpath("//a[contains(text(),'"+productName+"')]/ancestor::tr//input"));
			/*
			 * WebElement productname = driver.findElement(By.xpath("(//*[@class='astm-table-tr'])//td[1]//a[text()='" + productName +"']/../preceding-sibling::th//input"));
			 */

			ReusableMethods.scrollIntoView(productname, driver);
			return productname;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public By getLocatorForCheckbox(String productName) {
		try {
			By productname = By.xpath("(//*[@class='astm-table-tr'])//td[1]//a[text()='" + productName
					+ "']/../preceding-sibling::th//input");
			return productname;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean addToCartButtonVisible() {
		try {
			return (getElements(addToCartButton).size() > 0);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Step("Click on add  to cart button in bulk order page")
	public boolean clickAddToCartButton() {
		try {
			ReusableMethods.scrollIntoView(getElement(addToCartButton), driver);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			IntegrationCommon.clickonWebElement(driver, addToCartButton);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public String getPageTitle() {
		try {
			return getElement(pageTitle).getText();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<String> getHeaderColumnFields() {
		try {

			List<WebElement> bulkHeaderList = getElements(dataColumnsFields);
			System.out.println("size h: " + bulkHeaderList.size());
			List<String> tableHeaders = new ArrayList<String>(bulkHeaderList.size() - 1);

			for (int i = 0; i < bulkHeaderList.size(); i++) {

				// if(i==0) {
				// continue;
				// }
				// else {

				tableHeaders.add(i, bulkHeaderList.get(i).getText());
				System.out.println("header: " + i + " " + tableHeaders.get(i));
				System.out.println("size: " + tableHeaders.size());
				// }
			}

			return tableHeaders;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<WebElement> getHeaderColumnFieldElements() {
		try {
			return getElements(dataColumnsFields);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<WebElement> getElements(By locator) {
		List<WebElement> element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElements(locator);
		} catch (Exception e) {
			System.out.println("Some error occured while creating element" + locator.toString());
			e.getStackTrace();
		}
		return element;
	}

}
