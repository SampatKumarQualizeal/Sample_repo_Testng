package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard_PublicAdmin extends BasePage{

	public Dashboard_PublicAdmin(WebDriver driver) {
		super(driver);
	}
	
	private By profileDropDown = By.cssSelector("a[title='My Account']");
	private By signoutButton = By.cssSelector("a.account-signout");
	private By accountSettings = By.cssSelector("a[title='Account Setting']");
	private By customerView = By.cssSelector("a[title='Customer View']");
	
	/**
	 * @return the profileDropDown
	 */
	public By getProfileDropDown() {
		return profileDropDown;
	}

	/**
	 * @return the signoutButton
	 */
	public By getSignoutButton() {
		return signoutButton;
	}

	/**
	 * @return the accountSettings
	 */
	public By getAccountSettings() {
		return accountSettings;
	}

	/**
	 * @return the customerView
	 */
	public By getCustomerView() {
		return customerView;
	}
}
