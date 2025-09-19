package pages.ui;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage_PublicAdmin extends BasePage {
	public ProductPage_PublicAdmin(WebDriver driver) {
		super(driver);
	}
	public static By searchTxtAreaInProductsPage=By.xpath("(//label[@class='data-grid-search-label']//following-sibling::input)[1]");
	public static By organizationNameTextField = By.xpath("//label/span[text()='Organization Name']/../../div/input");
	
	public static By checkIncomingMSGPopUp = By.xpath("//*[@id='html-body']/div[3]/aside[1]/div[2]/header/button");
	public static By selectAttributeSet = By.xpath("//span[text()='Attribute Set']/../../div/select");
	public static By productTableFields = By.xpath("//*[@id='container']/div/div[4]/table//tr[1]//td");
	public static By catalogButton = By.xpath("//*[@id='menu-magento-catalog-catalog']");
	public static By marketingButton=By.xpath("//a/span[text()='Marketing']");
	public static By urlRewrites=By.xpath("//a/span[text()='URL Rewrites']");
	public static By requestPathInput=By.xpath("//td[@data-column='request_path']/input");
	public static By targetPathInput=By.xpath("//td[@data-column='target_path']/input");
	public static By productLink = By.linkText("Products");
	public static By selectproductType = By.xpath("//span[text()='Type']/../../div/select");
	public static By selectAttributeType = By.xpath("//span[text()='Attribute Set']/../../div/select");
	public static By selectVisibilityType = By.xpath("//span[text()='Visibility']/../../div/select");
	public static By selectPublicListingType = By.xpath("//span[text()='Public Listing']/../../div/select");
	public static By selectStatus = By.xpath("//span[text()='Status']/../../div/select");
	public static By codenTextField = By.xpath("//span[text()='Coden']/../../div/input");
	public static By selectAtributeSet = By.xpath("//*[@name='attribute_set_id']");
	public static By selectStoreView = By.xpath("//*[@name='store_id']");
	public static By deliveryMethodIdTextfield = By.xpath("//span[text()='Delivery Method ID']/../../div/input");
	public static By productSKUTextfield = By.xpath("//span[text()='SKU']/../../div/input");
	public static By orderIDTextField = By.xpath("//span[text()='ID']/../../div/input");
	public static By productUrlKeyTextfield = By.xpath("//span[text()='URL Key']/../../div/input");

	public static By productStoreViewDroopDown = By.xpath("//*[text()='Store View']/..//following-sibling::div/select");
	public static By SignInViaOKTAButton = By.xpath("//*[@id='sign-in-via-okta-form']/fieldset/div/div/button");
	public static By userName = By.id("userName");
	public static By password = By.id("encPass");
	public static By signInButton = By.xpath("//button[@type='submit']");
	public static By searchProductInput = By.xpath("//input[@placeholder='Search by keyword']");
	public static By skuFilter = By.xpath("//input[@name='sku']");
	public static By filter= By.xpath("//span[contains(text(),'Apply Filters')]");
	public static By codenunderFilter = By.xpath("//input[@name='coden']");
	public static By columnButton = By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div[1]/div[2]");
	public static By ebsSKUCheckbox = By.xpath("//*[@title='EBS_SKU']");
	public static By ebsSKU_AfterColumnSelectionCheckbox = By.xpath("//input[@name='ebs_sku']");
	public static By prodSKUTextField = By.xpath("//*[@name='sku']");
	public static By productNameField = By.xpath("//input[@name='name']");
	public static By productLineCodeAfterColumnSectionCheckbox = By.xpath("//input[@name='product_line_code']");
	public static By productClassificationAfterColumnSectionCheckbox = By
			.xpath("//input[@name='product_classification']");
	public static By productLineCodeCheckbox = By.xpath("//*[@title='Product Line Code']");
	public static By codenCheckbox = By.xpath("//*[@title='Coden']");
	public static By publicListingCheckbox = By.xpath("//*[@title='Public Listing']");
	public static By disablePublicOrderCheckbox = By.xpath("//*[@title='Disable Public Order']");
	public static By productClassificationCheckbox = By.xpath("//*[@title='Product Classification']");
	public static By resetButtonOfColumn = By.xpath("//button[text()='Reset']");
	public static By searchButton = By.xpath("//button[@type='submit' and class='action-submit']");
	public static By filterButton = By.xpath("//button[text()='Filters']");
	public static By ColumnsButton=By.xpath("//button[span='Columns']");
	public static By filterCount = By.xpath("//*[@id='container']/div/div[2]/div[1]/div[3]/div[2]/ul");
	public static By clearAllFilterLink = By.xpath("(//button[text()='Clear all'])[1]");
	public static By publicListingInFilter = By.xpath("//*[@name='public_listing']");
	public static By disableOrderInFilter = By.xpath("//*[@name='disable_public_order']");
	public static By selectSearchedProduct = By.xpath("//a[contains(.,'Edit')][1]");
	public static By deliveryMethodID = By.xpath("//*[@name='product[pim_delivery_method_id]']");
	public static By category_concat_segs = By.xpath("//*[@name='product[category_concat_segs]']");
	public static By contract_item_type_code = By.xpath("//*[@name='product[contractitemtypecode]']");
	public static By warehouse_code = By.xpath("//*[@name='product[warehouse_code]']");
	public static By inventoryStatusCode = By.xpath("//*[@name='product[inventory_item_status_code]']");
	public static By inventoryItemId = By.xpath("//*[@name='product[inventory_item_id]']");
	public static By organisationId = By.xpath("//*[@name='product[organization_id]']");
	public static By deliveryMethodCode = By.xpath("//*[@name='product[pim_delivery_method_code]']");
	public static By deliveryPlatformId = By.xpath("//*[@name='product[pim_delivery_platform_id]']");
	public static By deliveryPlatformCode = By.xpath("//*[@name='product[pim_delivery_platform_code]']");
	public static By productItemCode = By.xpath("//*[@name='product[pim_product_item_code]']");
	public static By productItemId = By.xpath("//*[@name='product[pim_product_item_id]']");
	public static By productLineCode = By.xpath("//*[@name='product[product_line_code]']");
	public static By segment = By.xpath("//*[@name='product[segment]']");
	public static By vertex1 = By.xpath("//*[@name='product[vertex1]']");
	public static By ebs_SKU = By.xpath("//*[@name='product[ebs_sku]']");
	public static By isbnISNN = By.xpath("//*[@name='product[isbn_isnn]']");
	public static By markettingCode = By.xpath("//*[@name='product[marketing_codes]']");
	public static By price = By.xpath("//*[@name='product[price]']");
	public static By publishDate = By.xpath("//*[@name='product[publish_date]']");
	public static By salesAccount = By.xpath("//*[@name='product[sales_account]']");
	public static By seperates = By
			.xpath("//div/label/span[contains(text(), 'Separates')]/../../following-sibling::div/div[@data-role]");
	public static By serveDate = By.xpath("//*[@name='product[serve_date]']");
	public static By shippableItemFlag = By.xpath(
			"//div/label/span[contains(text(), 'Shippable Item Flag')]/../../following-sibling::div/div[@data-role]");
	public static By productSKU = By.xpath("//*[@name='product[sku]']");
	public static By standardCategoryId = By.xpath("//*[@name='product[std_category_id]']");
	public static By urlKey = By.xpath("//*[@name='product[url_key]']");
	public static By disablePublicOrder = By.xpath(
			"//div/label/span[contains(text(), 'Disable Public Order')]/../../following-sibling::div/div[@data-role]");
	public static By productName = By.xpath("//*[@name='product[name]']");
	public static By publicListing = By
			.xpath("//div/label/span[contains(text(), 'Public Listing')]/../../following-sibling::div/div[@data-role]");
	public static By visibility = By.xpath("//*[@name='product[visibility]']");
	public static By lastUpdated = By.xpath("//*[@name='product[last_updated]']");
	public static By lastPaper = By.xpath("//*[@name='product[last_paper]']");
	public static By productname = By.xpath("//*[@name='product[name]']");
	public static By stdItemType = By.xpath("//*[@name='product[std_item_type]']");
	public static By productClassification = By.xpath("//*[@name='product[product_classification]']");
	public By descripionBtnProductPage = By.xpath("//button/span[text()='Edit with Page Builder']");
	public By descriptionText = By.xpath("//div[@class='placeholder-html-code']");
	public static By websiteName = By
			.xpath("//span[text()='Websites']/../../following-sibling::div/div/input[@value='1']/../label");

	public static By deliveryMethodID_ProductTable = By
			.xpath("//*[@id='container']/div/div[4]/table/tbody/tr[1]/td[14]");
	public static By productWebsiteSection = By.xpath("//*[text()='Product in Websites']");
	public static By checkBox_MainWesite = By.xpath("//*[text()='Main Website']/preceding-sibling::input");
	public static By productTable = By.xpath("//*[@id='container']/div/div[4]/table");
	public static By skuPath = By.xpath("//*[@id=\"container\"]/div/div[4]/table/tbody/tr[1]/td[8]");
	public static By selectProductType = By.xpath("//*[@name='type_id']");
	public static By enterDeliveryMethodID = By.xpath("//*[@name='pim_delivery_method_id']");
	public static By selectMainWebStore = By.xpath("//*[@name='store_id']");
	public static By applyFilterButton = By.xpath("//button[@class='action-secondary' and span='Apply Filters']");
	public static By totalrow = By.xpath("//tbody/tr[contains(@class,'data-row')]");
	public static By productCount = By.xpath("//*[@id='container']/div/div[2]/div[2]/div[2]/div/div[1]/div");
	public static By spinnerIcon = By.cssSelector("div[data-component*='product_listing'] div.spinner");
	public By spinnerIconAfterProductSearch = By
			.cssSelector("div[data-component*='catalogstaging_upcoming_grid'] div.spinner");
	public static By afterApplyFilterSpinerIcon = By
			.cssSelector("div[data-component=\"product_listing.product_listing.product_columns\"]");
	public By priceFieldProductPage = By.xpath("//*[@name='product[price]']");
	public By product_group_codeFieldProductPage = By.xpath("//*[@name='product[product_group_code]']");
	
	public static By productStatusEnabled = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='Enabled']");
	public static By productStatusDisabled = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='Disabled']");
	public By urlKeyFieldProductPage = By.xpath("//*[@name='product[url_key]']");
	public By childAssetsProductPage = By.xpath("//*[@name='product[child_assets]']");
	
	public  By assetStatus = By.xpath("//*[@name='product[asset_status]']");
	public By simpleProductType = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='Simple Product']");
	public By attributeSet = By.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='Default']");

	public static By searchedSimpleProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='VX0301']");
	public static By searchedGeoSimpleProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='VX0413']");
	public static By searchedPubPaperProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='MPC20190146']");
	public static By searchedStdAPIProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='E0243-18']");
	public static By searchedCGAProducts = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='E1680-16']");
	public static By searchedStdChildProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='A0003-87R95-PDF']");
	public static By searchedConfigurableProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='A0003-87R95']");
	public static By searchedConfiProductAttribue = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='E2315-16']");
	public static By searchedStandardChildProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SUB-F2180']");
	public static By searchedStandardChildAPIProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='A0003-87R95-PDF']");
	public static By searchedStandardChildCGAProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SUB-API_SPEC_12B-WL']");
	public static By searchedAdjunctProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADJD2096-E-PDF']");
	public static By searchedCompilationAWWAProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADDMFGCMP']");
	public static By searchedCompilationAPIProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SUB-API-ONLINE_ZH-WL']");
	public static By searchedJournalsProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SSMSCY']");
	public static By searchedMembershipProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='MEMSENIOR20']");
	public static By searchedMiscProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='TRACK10K']");
	public static By searchedPTPProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='PTPALUM2021']");
	public static By searchedConfiProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='RPS2-EB']");
	public static By searchedConfiSTDProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='UOP456-80']");
	public static By searchedTPTGRPProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM-TPT-577-COURSE']");
	public static By searchedTPTProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='TPTENV0220']");
	public static By searchedPubChildProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='STP673-EB']");
	public static By sortEBS_SKU = By.xpath("//*[@id='container']/div/div[4]/table/thead/tr/th[15]");
	public static By searchedComp2Product = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADDMFGCMP']");

	public static By searchComp3Product = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ENVCHARCMP']");
	public static By EBSInputField = By.xpath("//input[@name='product[ebs_sku]']");
	public static By saveAttributesButton = By.xpath("//button[@id='save-button' and span='Save']");
	public static By successMsg = By.xpath("//div[@data-ui-id='messages-message-success']");
	public static By searchedAdjunct2Product = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADJD4703']");
	public static By searchConfigurableProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='STP42160S']");
	public static By searchSimpleProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='VM0203']");
	public static By searchMembershipProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='MEMEXISUAE20']");
	public static By searchMiscellnousProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='RRSCOMBO']");
	public static By searchTPTProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SUB-TRAIN-#2DIESELFUEL']");

	public static By search3PCChildProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ACEM20190025']");
	public static By searchPubChildProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='STP1600']");

	public static By searchAdjunctProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADJD822118CS']");
	public static By searchedStdConfiProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='UOP46-85']");
	public static By searchedPubConfiProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='JAI103368']");
	public static By searchedVolumeProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM-BOS-15.10']");

	public static By searchedTPT1Product = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SUB-TRAIN-D5VIDEO-IP']");
	public static By searchePubPapProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM|MPC20190146|en-US|PDF']");
	public static By searchedAdjunctNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADJE182517CS']");
	public static By adjunctProduct1537 = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='RRE3168']");
	public static By searchedMembershipNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='MEMINDIVIDUAL21']");
	public static By searchedCompilationNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASBESTOSCMP']");
	public static By searchedMiscNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADVISORSVS']");
	public static By searchedPTPNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='PTPIGO2021']");
	public static By searchedPubChildNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='STP129']");
	public static By searchedPubConfigNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='Publications']");
	public static By searchedTPTNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM-TPT-4515']");
	public static By searchedStdChildNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SUB-A1092']");
	public static By searchedBOSNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SUB-VX0406']");
	public static By searchedSubPubChildProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SUB-API_RP_17Q_DATA']");
	public static By searchedStandChildNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='E1492-05-PDF']");
	public static By searchedMiscSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SUB-SPECBUILDER']");
	public static By searchedCompilationSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SUB-DLMAN']");
	public static By searchedJournalsNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='CCAGDP']");
	public static By searchedStandConfigNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='UOP1033-19']");
	public static By searchedStandardBOSSimpleNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='S090121']");
	public static By searchedBOS4Product = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM-BOS-4']");
	public static By searchedStandardBOSAllProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM-BOS-ALL']");
	public static By searchedStandardBOS2Product = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM-BOS-2']");
	public static By searchedEBS_SKUForAdjunctProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADJD822119-EA']");
	public static By searchedAdjunctEBS = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADJD822119-EA']");
	public static By searchedRoyaltyProductLineCode = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ROYALTY']");
	public static By searchedStandardProductClassification = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='STANDARDS']");
	public static By searchedEBS_SKUForCompProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='WELDING20']");
	public static By searchedEBS_SKUForRoyaltyProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='EDDPORTAL']");
	public static By searchedStandardChildProductForProductLineCode = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='C1006-07R13-PDF']");
	public static By searchedEBS_SKUForPTPProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='PTPBIOD2007']");
	public static By searchedProdClassificationForConfigProd = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='D7109-18']");
	public static By searchedEBS_SKUForTPTProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='train-G128O2AWARE']");
	public static By searchedSTandardSKU = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SUB-UOP-UOP0992_RUS']");
	public static By searchedProductLineCodeForRoyaltyProd = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ROYALTIES']");
	public static By searchedAdjunctNonSubProd = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADJC033501']");
	public static By searchedAnotherAdjunctNonSubProd = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADJC033501']");
	public static By searchedCompNonSubProd = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='APPAREL15']");
	public static By searchedComp2NonSubProd = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='MEDICALCMP']");
	public static By searchedMiscProdForProductLineCode = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='COLORFIGURE']");
	public static By searchedBOS2SimpleNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='VM1507']");
	public static By searchedTPT2NonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SUB-TRAIN-MOTORGAS']");
	public static By searchedBOSSimpleNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='S010821']");
	public static By searched2MiscNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='CUSTBOOKS']");
	public static By searchedPTP2NonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='PTPWAH2020']");
	public static By searchedProdClassificationForJournalsProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='MPCACD']");
	public static By searchedMemberShipNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='MEMINDIVIDUAL20']");
	public static By searchedPubPaperpNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM|CCA10312J|en-US|PDF']");
	public static By searchedPTP3NonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='PTPBO2007']");
	public static By searched2PubConfigNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='Journal']");
	public static By searched2PubChildNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='DS39B']");
	public static By searched3StandConfigNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='Configurable Product']");
	public static By searched3PubConfigNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='STP']");
	public static By searched2StandChildNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='A0917-05-PDF']");
	public static By searched2StandConfigNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='Standards']");
	public static By searchedAdjunctProductForProductLine = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADJUNCTS']");
	public static By searchedStandardChildNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='D0653-20-PDF']");
	public static By searchedCompProductForProductLine = By.xpath(
			"//div[contains(@class, 'data-grid-cell-content') and text()='Test Sieving Methods: Guidelines for Establishing Sieve Analysis Procedures; 5th Edition']");
	public static By searchProductCOMPILATIONS= By.xpath("//div[contains(text(),'COMPILATIONS')]");
	public static By searched3PubChildNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='DS60-EB-ONLINE']");
	public static By searchedPTPPrdouctLIne = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='PTPEAT2021']");
	public static By searchedPubPaperProductForProductLine = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM|CCA10504J|en-US|PDF']");
	public static By searchedproductLineFormembershipProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='MEMTEMPORARY23']");
	public static By searchedMiscellenousProductLine = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='STPCOLOR']");
	public static By searchedTPTGrpNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM-TPT-577']");
	public static By searchedPubPaperNonSubProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM|ACEM20130103|en-US|PDF']");
	public static By searchedRoyaltyProductLine = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='API-ROYALTIES']");
	public static By searchedPubChildProductLine = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM|STP47163S|en-US']");
	public static By searchedStandConfigProductLine = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='UOP879-87']");
	public static By searchedBOSSectionProductLine = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM-BOS-10']");
	public static By searchedBOSVolumeProductLine = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM-BOS-04.02']");
	public static By searchedBOSSimpleProductLine = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SUB-VX06CS']");
	public static By searchedStandardChildProductLine = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='UOP879-87-PDF']");
	public static By searchedMembershipProductFormapping = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='MEMINDIVIDUAL22']");
	public static By searchedTPTGroupProductLine = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM-TPT-591']");
	public static By searchedConfigurableProductLine = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='MPC1904-EB']");
	public static By searchedTPTProductLine = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SUB-TRAIN-C1064ML8-IP']");
	public static By searchedPubChapterProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='STPDL-PDF']");
	public static By searchedJournalsProductLine = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='SUB-DLJAI']");
	public static By searched2PubChapterProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM|STP47539S|en-US']");
	public static By searched2StandardProductClassification = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='E0738-00-PDF']");
	public static By searched2STPProductClassification = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='STP1108-EB']");
	public static By searchedSTPProductClassification = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='STP1366']");
	public static By searchedAdjunctProductForPublicListing = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADJD0714']");
	public static By searched3StandardProductClassification = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='UOP163-05']");
	public static By searchedAdjunctProductForPublicListingAndVisibility = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='RRE303001']");
	public static By searchedRoyaltyProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='WEBPERMISSIONS']");
	public static By searchedPriceForIndividiual = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='$259.00']");
	public static By searchedCompilationProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='PIPINGCMP']");
	public static By searchedPriceForInstitutional = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='$0.00']");
	public static By searchedBOSVolumeForWorkflow = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM-BOS-10.03']");
	public static By searchedAdjunctProductForProductClassification = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADJE152814-E-PDF']");
	public static By searchedAdjunctForAssetID = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADJE152814-E-PDF']");
	public static By searchedPublicationChildForWorkflow = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM|STP35917S|en-US']");
	public static By searchedStandardChildForStatus = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='G0034-01R18-RED-PDF']");
	public static By searchedPublicationConfigurableForAsset = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='STP763-EB']");
	public static By searchedStandardChildForWorkflow = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='D4919-PDF']");
	public static By searchedPubPaperForWorkflow = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM|GTJ20160044|en-US|PDF']");

	public static By searchedStandChildForStatus = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='F0449-02-PDF']");
	public static By searchedPubPaperForStatus = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM|MPC20200133|en-US|PDF']");
	public static By searchedStandardConfigurableForWorkflow = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='D1218-12R16']");
	public static By searchedAdjunctProductForVisibilityAttribute = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADJF0112']");
	public static By searchedBOSSectionForWorkflow = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ASTM-BOS-13']");
	public static By searchedBOSProduct = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='S010321']");
	public static By searchedAdjunctForWorkflow = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADJE2369']");
	public static By searchedAnotherPublicationConfigurableForAsset = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='STP635-EB']");
	public static By searchedStandardConfigForPublicListing = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='D7042-16E01']");
	public static By searchedAnotherAdjunctProductForPublicListing = By
			.xpath("//div[contains(@class, 'data-grid-cell-content') and text()='ADJD4255-E-PDF']");
	public static By sectionDropDown = By
			.xpath("//div[@class=\"fieldset-wrapper-title\"][@data-state-collapsible='closed']");

	public static By astmAttributes = By.xpath("//*[text()='ASTM Attributes']");
	public static By myAccount = By.xpath("//h3[text()='My Account']");
	public static By dynamicTableHeaderProductPage = By
			.xpath("//input[starts-with(@name, 'product[dynamic_description]')]");
	public static By dynamicTableDescriptionProductPage = By.xpath("//button[@class='action-default action']");
	public static By editDescriptionBtn = By
			.xpath("//div[@class='element-children content-type-container root-container-container ui-sortable']");
	public static By addProductBtn = By.cssSelector("button#add_new_product-button");
	public static By productrow = By.xpath("//table[@class='data-grid data-grid-draggable']/thead/tr");
	public static By visibilityOption = By.xpath("//select[@name='product[visibility]']");
	public static By descriptionPagetext = By
			.xpath("//div[@class='placeholder-html-code' or @class ='pagebuilder-content-type-wrapper']");
	public static By productListUnderConfiguration = By.xpath("//div[@data-index='sku_text']/div/div/span");
	public static By childProductTableSKU = By
			.xpath("//span[text()='Current Variations']/../../div/div/table/tbody/tr/td[3]");
	public By editLinkPrduct = By.xpath("//a[text()='Edit']");
	public By locationCityField = By.xpath("//*/input[@name=\"product[location_city]\"]");
	public By locationStateField = By.xpath("//*/input[@name=\"product[location_state]\"]");
	public static By astmSettings=By.xpath("//span[text()='Astm settings']");
	public static By mainPageStore=By.xpath("//a/span[text()='Stores']");
	public static By configuration=By.xpath("//li[@data-ui-id='menu-magento-config-system-config']/a/span");
	public static By selectenvironment=By.xpath("//select[@id='astm_general_environment']");
	public static By saveConfig=By.xpath("//span[text()='Save Config']");
	public static By warningModalHeader = By.xpath("//*[@class='modal-header']/h1[contains(text(),'Warning')]");
	public static By warningModalOkButton = By.xpath("//button[@class='action-primary action-accept']");
	public static By skuConfigTable = By.xpath("//table[@class='admin__dynamic-rows data-grid']/tbody/tr[2]/td[3]");
	public static By configurableProduct=By.xpath("//div[text()='Configurable Product']//parent::td");
	public static By searchButtonProduct=By.xpath("//span[text()='Search']//parent::button");
	
	public By getAttributeValuesByName(String attribute){
		return By.xpath("//*[contains(@name,'["+attribute+"]')]");
	}
	
	public static By getAttributeByName(String fieldText) {
		return By.xpath("//*[@name='product[" + fieldText + "]']");
	

	}
    public static By getFilter(){
		return  filter;
	}
	public static By getCompilation(){
		return searchProductCOMPILATIONS;
	}

	public By getChildProductElement(String fieldText){
		return By.xpath("//span[text() ='"+fieldText+"']/ancestor::tr//td[@data-index='name_container']");
	}

	public By getChildProductTableFieldValues(String childSKU, String fieldName){
		return By.xpath("//span[text() ='"+childSKU+"']/ancestor::tr//td[contains(@data-index,'"+fieldName+"')]");
	}

	public By getSectionHeader(String fieldText){
		return By.xpath("//span[text()='"+fieldText+"']");
	}

	public static By getCheckBoxStoreCode(String fieldText) {
		return By.xpath("//*[text()='" + fieldText + "']/preceding-sibling::input");
	}

	public static By getVisibilityLocator(String value) {
		String path = "(//select[@name='product[visibility]']/option)[" + value + "]";
		return By.xpath(path);
	}

	public static By setSearchAttribute(String value) {
		String path = "//div[contains(@class, 'data-grid-cell-content') and text()='value']".replace("value", value);
		return By.xpath(path);
	}

	public By getAttributeNames(String fieldText) {
		return By.xpath("//div/label/span[contains(text(), '" + fieldText + "')]/../../following-sibling::div/input");
	}

	public WebElement getAttributeNamesElement(String fieldText) {
		return getElement(getAttributeNames(fieldText));
	}

	public By getAttributeName(String fieldText) {
		return By.xpath("//div/label/span[text()= '" + fieldText + "']/../../following-sibling::div/input");
	}

	public WebElement getFormatDropDownValue(String fieldText, String text2) {
		return getElement(By.xpath("//div/label/span[contains(text(), '" + text2
				+ "')]/../../following-sibling::div/select/*[@value= '" + fieldText + "']"));
	}

	public static By setStoreViewValue(String value) {
		String path = "//*[text()='Store View']/..//following-sibling::div/select/option[contains(text(),'Default Store View')]"
				.replace("Default Store View", value);
		return By.xpath(path);
	}

	/**
	 * Get locator for Value from table
	 * 
	 * @param fieldText
	 * @return
	 */
	public By getTableAttributeValue(int fieldText) {
		return By.xpath("//*[@id='container']/div/div[4]/table//tr[1]//td[" + fieldText + "]");
	}

	/**
	 * Get element for Value from table
	 * 
	 * @param fieldText
	 * @return
	 */
	public WebElement getTableAttributeValueElement(int fieldText) {
		return getElement(getTableAttributeValue(fieldText));
	}

	/**
	 * Get locator for fieldName from table
	 * 
	 * @param fieldText
	 * @return
	 */
	public By getTableHeaderValue(int fieldText) {
		return By.xpath("//*[@id='container']/div/div[4]/table//tr[1]//th[" + fieldText + "]");
	}

	/**
	 * Get Element for fieldName from table
	 * 
	 * @param fieldText
	 * @return
	 */
	public WebElement getTableHeaderValueElement(int fieldText) {
		return getElement(getTableHeaderValue(fieldText));
	}

	public By getDropDownNames(String fieldText) {
		return By.xpath("//div/label/span[contains(text(), '" + fieldText + "')]/../../following-sibling::div/select");
	}

	public WebElement getDropDownNamesElement(String fieldText) {
		return getElement(getDropDownNames(fieldText));
	}

	public By getToggleNames(String fieldText) {
		return By.xpath("//div/label/span[contains(text(), '" + fieldText
				+ "')]/../../following-sibling::div/div[@data-role]/input");
	}

	public WebElement getToggleNamesElement(String fieldText) {
		return getElement(getToggleNames(fieldText));
	}

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
	public By getProductEditButtonElmentString(String fieldText) {
		return (By.xpath("//tr[1]/td/div[text()='"+fieldText+"']/../following-sibling::td[10]"));
	}

}
