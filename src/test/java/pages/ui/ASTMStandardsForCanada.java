package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ASTMStandardsForCanada extends BasePage{

	public ASTMStandardsForCanada(WebDriver driver) {
		super(driver);
	}

	public By SSCPublicReview=By.xpath("//a[contains(text(),'SCC Public')]");
	public By SCCHeader=By.xpath("//h3[text()='ASTM Standards for Canada']");
	public By SCCSubHeader=By.xpath("//p[contains(text(),'The ASTM Work Program is published by ASTM two times a year.')]");
	public By LinkUnderSCCSubHeader=By.xpath("//p[contains(text(),'The ASTM Work Program is published by ASTM two times a year.')]/a");
	public By downloadWorkProgramButton=By.xpath("//a[text()='Download Work Program']");
	public By NSCHeader=By.xpath("//h4[text()='Public Review of National Standards of Canada (NSC)']");
	public By NSCCommentHeader=By.xpath("//h4[text()='NSC Documents Open for Comment']");
	public By textUnderNSCDocs=By.xpath("//span[contains(text(),'ASTM F3429/F3429M -20 Standard')]");
	
	public By NSCAbstract=By.xpath("//p[contains(text(),'The item(s) listed are currently open for public')]");
	public By YourName=By.xpath("//p[text()='Your Name']");
	public By yourCoAssociation=By.xpath("//p[text()='Your Company or Association']");
	public By yourEmailAddress=By.xpath("//p[text()='Your Email Address']");
	public By yourTeleNumber=By.xpath("//p[text()='Your Telephone Number']");
	public By WorkItemAssociation=By.xpath("//p[text()='The Work Item associated with the new standard or revision']");
	public By version=By.xpath("//p[text()='The version (French or English)']");
	public By NSCStatementTwo=By.xpath("//p[contains(text(),'All written statements received prior')]");
	
}
