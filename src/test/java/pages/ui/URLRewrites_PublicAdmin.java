package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class URLRewrites_PublicAdmin extends BasePage {
	public URLRewrites_PublicAdmin(WebDriver driver) {
		super(driver);
	}

	public static By marketingButton = By.xpath("//*[@id='menu-magento-backend-marketing']");
	public static By url_RewritesLink = By.linkText("URL Rewrites");

	public static By targetPathField = By.xpath("//td[@class=' col-target_path']/input");
	public static By requestPathField = By.xpath("//td[@class=' col-request_path']/input");
	public static By searchButton = By.xpath("//button[@data-action='grid-filter-apply']");
	public static By resetFilters = By.xpath("//button[@data-action='grid-filter-reset']");
	public static By tableTargetPathData = By.xpath("//table[@id='urlrewriteGrid_table']//tbody//td[@class=' col-target_path  ']");

	public boolean clickPageElement(By locator) {
		try {
			driver.findElement(locator).click();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean enterTestData(By locator, String value) {
		try {
			driver.findElement(locator).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			e.getStackTrace();
			return element;
		}
	}

	public List getElementList(By locator) {
		List<WebElement> element = null;
		try {
			element = driver.findElements(locator);
			return element;
		} catch (Exception e) {
			e.getStackTrace();
			return element;
		}
	}

	public boolean waitForVisible(WebDriver driver, By locator, int sec) {
		try {
			new WebDriverWait(driver, sec).until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
			return false;
		}
	}

	public boolean handleSpinnerIconOnMagento(WebDriver driver, By locator) {
		try {
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			boolean found = waitForVisible(driver, locator, 3);
			if (found) {
//					new WebDriverWait(driver, 40).until(ExpectedConditions.invisibilityOfElementLocated(locator));
				new WebDriverWait(driver, 60).pollingEvery(Duration.ofMillis(500))
						.until(ExpectedConditions.invisibilityOf(driver.findElement(locator)));
				return true;
			}
			return true;
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
	}

	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void refreshBrowser() {
		driver.navigate().refresh();
	}

	public void submitWithKeysMethod(By locator) {
		driver.findElement(locator).sendKeys(Keys.ENTER);

	}

}
