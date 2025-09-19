package pages.ui;

import com.astm.commonFunctions.PublicCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageCommitteesPage_Public extends BasePage{
    public ManageCommitteesPage_Public(WebDriver driver) {
        super(driver);
    }
    public By ManageCommitteesLink = By.xpath("//a[text()='Manage Committees']");
    public By ManageCommitteesHeader = By.xpath("//h1[text()='Manage Committees']");
    public By  JoinAnotherMainCommitteeBtn= By.xpath("//button[text()=' Join Another Main Committee']");
    public By  ConfirmationPopUp= By.xpath("//p[@data-testid='success-confirm-message']");

    public By  OkBtn = By.xpath("//button[text()='Ok']");

    public By submitBtn = By.xpath("//button[text()='Submit']");
    public By dropFromMainCommittePopUp = By.xpath("//p[contains(text(),'Are you sure you want to drop from Main Committee')]");
    public By YesIWantToDropBtn = By.xpath("//button[text()='Yes, I Want To Drop']");
    public By accountNumberFromMyCommitte = By.xpath("//section[@class='sideBarNav']/p[contains(text(),'Account#:')]");
    public By committeeSummaryColor=By.xpath("(//*[local-name()='svg']//*[local-name()='path' and @class='recharts-sector'])[4]");
    public By getDropfromMainCommittee(String CommitteName)
    {
        return By.xpath("//h5[text()='"+CommitteName+"']/../../div[2]//button[text()='Drop from Main Committee']");
    }
    public By getCommitteName(String CommitteName)
    {
        return By.xpath("//h5[text()='"+CommitteName+"']");
    }

    public String getcommitteeSummaryColor()
    {
        WebElement ChartColor=getElement(committeeSummaryColor);
        return ChartColor.getCssValue("color");
    }
    @Step("Get Account Number")
    public String checkAccountNumberOnMyCommitte(){
        String AccountNumberTrim=null;
        try {
            AccountNumberTrim =getElement(accountNumberFromMyCommitte).getText();
            AccountNumberTrim = AccountNumberTrim.split(":")[1].trim();
        } catch (Exception e) {
            e.printStackTrace();
            PublicCommon.reportFailAssert("Failed to verify to get account number", e);
        }
        return AccountNumberTrim;
    }

}
