package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.astm.commonFunctions.PublicCommon;

public class ProductAttribute_PublicAdmin extends BasePage {
	ProductPage_PublicAdmin adminProductPages=new ProductPage_PublicAdmin(driver);
	public ProductAttribute_PublicAdmin(WebDriver driver) {
		super(driver);
	}
	public static By astmAttribute = By.xpath("//span[text()='ASTM Attributes']");
	public static By deliveryPlatformCode = By.xpath("//span[contains(text(),'Delivery Platform Code')]");
	public static By textASTMCONTENTVIEWER = By.xpath("//fieldset/div[93]/div[@class='admin__field-control']/input");
	public static By InventoryItemStatusCode = By.xpath("//span[contains(text(),'Inventory Item Status Code')]");
	public static By productClassificationAttribute = By.xpath("//span[text()='Product Classification']");
	public static By productClassificationValue = By.xpath("//input[@name='product[product_classification]']");
	public static By lastUpdatedAttribute = By.xpath("//span[text()='Last Updated']");
	public static By backButtonOnAttPage = By.xpath("//span[text()='Back']");
	public static By spinnerIconSearchedProduct = By.cssSelector("div[data-component*='product_listing'] div.spinner");
	public static By spinnerIconProductAttribute = By
			.cssSelector("div[data-component*='catalogstaging_upcoming_grid'] div.spinner");
	public static By productFamilyAttribute = By.xpath("//span[text()='Family']");
	public static By productLineCodeAttribute = By.xpath("//span[text()='Product Line Code']");
	public static By productPublisherNameAttribute = By.xpath("//span[text()='Publisher Name']");
	public static By addOnTypeAttribute = By.xpath("//span[text()='Add-on Type']");
	public static By approvalDateAttribute = By.xpath("//span[text()='Approval Date']");
	public static By assetIDAttribute = By.xpath("//span[text()='Asset ID']");
	public static By ebsAttribute = By.xpath("//span[text()='EBS_SKU']");
	public static By ebsSKUUnderASTM = By.xpath("//input[@name='product[ebs_sku]']");
	public static By productLineUnderASTM = By.xpath("//input[@name='product[product_line_code]']");
	public static By categoryConcatAttribute = By.xpath("//span[text()='Category Concat Segs']");
	public static By categoryConcatAttributeValue = By.xpath("//input[@name='product[category_concat_segs]']");
	public static By productSKUAttribute = By.xpath("//input[@name='product[sku]']");
	public static By searchEngineOptAttribute = By.xpath("//span[text()='Search Engine Optimization']");
	public static By urlKeyAttribute = By.xpath("//input[@name='product[url_key]']");
	public static By displayDesignationAttribute = By.xpath("//input[@name='product[display_designation]']");
	public static By contentAttribute = By.xpath("//strong//span[text()='Content']");
	public static By sectionAttribute = By.xpath("//input[@name='product[section]']");
	public static By volumeAttribute = By.xpath("//input[@name='product[volume]']");
	public static By lastUpdatedAttributeValue = By.xpath("//input[@name='product[last_updated]']");
	public static By disablePublicOrderAttribute = By.xpath("//input[@name='product[disable_public_order]']");
	public static By publicListingAttribute = By.xpath("//input[@name='product[public_listing]']");
	public static By productVisibility = By.xpath("//*[@name='product[visibility]']");
	public static By inventoryIDAttribute = By.xpath("//input[@name='product[inventory_item_id]']");
	public static By marketingCodesAttribute = By.xpath("//input[@name='product[marketing_codes]']");
	public static By contractItemtypeAttribute = By.xpath("//input[@name='product[contractitemtypecode]']");
	public static By closeDescriptionPageIcon = By.xpath("//*[@title='Close Full Screen']");
	public static By workflowStatusAttribute = By.xpath("//input[@name='product[workflow_status]']");
	public static By itemAlertAttribute = By.xpath("//*[@name='product[new_item_alert]']");
	public static By linkAttribute = By.xpath("//*[@name='product[link]']");
	public static By inventoryitemStatusCodeAttribute = By.xpath("//input[@name='product[inventory_item_status_code]']");
	public static By productStatus = By.xpath("//input[@name='product[status]']");
	public static By AssetStatusAttribute = By.xpath("//input[@name='product[asset_status]']");
	public static By languageCodeAttribute = By.xpath("//input[@name='product[language_code]']");
	public static By mktAttribute = By.xpath("//*[@name='product[mktcode]']");
	public static By productPrice=By.xpath("//input[@name='product[price]']");
	public static By uuidAttribute = By.xpath("//input[@name='product[uuid]']");
	public static By warehouseCodeAttribute = By.xpath("//*[@name='product[warehouse_code]']");
	public static By codeAttribute = By.xpath("//input[@name='product[coden]']");
	public static By collectionAttribute= By.xpath("//input[@name='product[collection]']");
	public static By collectionDOIAttribute = By.xpath("//input[@name='product[collection_doi]']");
	public static By childAssetAttribute = By.name("product[child_assets]");
	public By productNameAttribute = By.xpath("//input[@name='product[name]']");
	public static By errorMessageCreateOrder = By.xpath("//*[@class='message message-notice']");
	public By productCodeAttribute = By.xpath("//input[@name='product[product_code]']");
	public By mainAssetAttribute = By.xpath("//*[@name='product[main_asset]']");
	public static By errorMessageCreateOrderDisable = By.xpath("//*[@class='message message-error']");
	public static By errorMessageCreateOrderDisable1 = By.xpath("//*[@class='message message-notice']");
	public By onlineTrainingAttribute = By.xpath("//input[@name='product[online_training]']");
	public By contentTypeAttribute = By.xpath("//input[@name='product[content_type]']");
	public By watermarkingAttribute = By.xpath("//input[@name='product[watermarking]']");
	public By assetGroupAttribute = By.xpath("//input[@name='product[asset_groups]']");
	public By previewLastPageAttribute = By.xpath("//input[@name='product[preview_last_page]']");
	public By previewFirstPageAttribute = By.xpath("//input[@name='product[preview_first_page]']");
	public By releaseDateAttribute = By.xpath("//input[@name='product[release_date]']");
	public By supplementAttribute = By.xpath("//*[@name='product[supplements]']");
	public By assetTypeAttribute = By.xpath("//input[@name='product[asset_type]']");
	public By doiAttribute = By.xpath("//input[@name='product[doi]']");
	public static By familyAttribute = By.xpath("//input[@name='product[family]']");
	public static By journalTitle = By.xpath("//input[@name='product[journal_title]']");
	public static By isbn13Attribute = By.xpath("//input[@name='product[isbn_13]']");
	public static By onlineIssueDateAttribute = By.xpath("//*[@name='product[online_issue_date]']");
	public static By orgnaisationIDAttribute = By.xpath("//*[@name='product[organization_id]']");
	public static By outOfPrintAttribute = By.xpath("//*[@name='product[out_of_print]']");
	public static By pageTitleAttribue = By.xpath("//input[@name='product[page_title]']");
	public static By printissueDateAttribute = By.xpath("//input[@name='product[print_issue_date]']");
	public static By publisherNameAttribute = By.xpath("//input[@name='product[publisher_name]']");
	public static By assetIdAttribute = By.xpath("//input[@name='product[asset_id]']");
	public static By committeIDAttribute = By.xpath("//input[@name='product[committee]']");
	public static By marketingCodeAttribute = By.xpath("//*[@name='product[marketing_codes]']");
	public static By hideAttribute = By.xpath("//*[@name='product[hide]']");
	public static By bundleWithStandardAttribute = By.xpath("//*[@name='product[bundle_with_standard]']");
	public static By pageCountAttribute = By.xpath("//input[@name='product[page_count]']");
	public static By pdfBundleAttribute = By.xpath("//*[@name='product[pdf_bundle]']");
	public static By collectionContribGroupAttribute = By.xpath("//*[@name='product[collection_contrib_group]']");
	public static By serveDateAttribute = By.xpath("//*[@name='product[serve_date]']");
	public static By shippableItemFlagAttribute = By.xpath("//*[@name='product[shippable_item_flag]']");
	public static By standardCategoryIDAttribute = By.xpath("//*[@name='product[std_category_id]']");
	public static By itemtypeAsFormatAttribute = By.xpath("//*[@name='product[std_item_type]']");
	public static By vertex1Attribute = By.xpath("//input[@name='product[vertex1]']");
	public static By isbnISNNAttribute = By.xpath("//*[@name='product[isbn_isnn]']");
	public static By deliveryMethodIDAttribute = By.xpath("//input[@name='product[pim_delivery_method_id]']");
	public static By deliveryMethodCodeAttribute = By.xpath("//input[@name='product[pim_delivery_method_code]']");
	public static By deliveryPlatformCodeAttribute = By.xpath("//*[@name='product[pim_delivery_platform_code]']");
	public static By deliveryPlatformIDAttribute = By.xpath("//*[@name='product[pim_delivery_platform_id]']");
	public static By productItemIDAttribute = By.xpath("//*[@name='product[pim_product_item_id]']");
	public static By productItemCodeAttribute = By.xpath("//*[@name='product[pim_product_item_code]']");
	public static By productFormatAttribute = By.xpath("//*[@name='product[format]']");
	public static By segmentAttribute = By.xpath("//*[@name='product[segment]']");
	public static By salesAccountAttribute = By.xpath("//input[@name='product[sales_account]']");
	public static By seperateAttribute = By.xpath("//*[@name='product[separates]']");
	public static By storeCodeAttribute = By.xpath("//*[@name='product[store_code]']");
	public static By courseFeeAttribute = By.xpath("//*[@name='product[tpt_course_fee]']");
	public static By attributeInConfiguration = By.xpath("//*[@class='admin__dynamic-rows data-grid']/tbody/tr/td[8]");
	public static By publishDateAttribute = By.xpath("//*[@name='product[publish_date]']");
	public static By kitBundleAttribute = By.xpath("//*[@name='product[kits_bundles]']");
	public static By productItemTypeAttribute = By.xpath("//*[@name='product[ptp_item_type]']");

	
	public void getProductLineCode(String productLineCode) {
		Assert.assertTrue(adminProductPages.clickPageElement(ProductAttribute_PublicAdmin.astmAttribute),"ASTM link not available");
		Assert.assertTrue(adminProductPages.getElement(ProductAttribute_PublicAdmin.productLineUnderASTM).getAttribute("value").equalsIgnoreCase(productLineCode), "Product line code did not matched");
	}
	
	public void getEBS_SKU(String ebs_SKU) {
		Assert.assertTrue(adminProductPages.clickPageElement(ProductAttribute_PublicAdmin.astmAttribute),"ASTM link not available");
		Assert.assertTrue(adminProductPages.getElement(ProductAttribute_PublicAdmin.ebsSKUUnderASTM).getAttribute("value").equalsIgnoreCase(ebs_SKU), "EBS SKU did not matched");
	}
	
	public void getURL_KEY(String url_KEY) {
		Assert.assertTrue(adminProductPages.getElement(ProductAttribute_PublicAdmin.urlKeyAttribute).getAttribute("value").equalsIgnoreCase(url_KEY), "EBS SKU did not matched");
	}
	
	public void getLastUpdated(String lastUpdated) {
		Assert.assertTrue(adminProductPages.clickPageElement(ProductAttribute_PublicAdmin.astmAttribute),
				"ASTM link not available");
		String dateFromPIM = lastUpdated.substring(0, 10);
		String newModifyContentDateFromPim = dateFromPIM.replaceAll("-", "/");
		String lastUpdatedDate = adminProductPages.getElement(ProductAttribute_PublicAdmin.lastUpdatedAttributeValue)
				.getAttribute("value");
		Assert.assertTrue(newModifyContentDateFromPim.substring(6, 10).equals(lastUpdatedDate.substring(1, 5)),
				"Month and Day are not same");
		Assert.assertTrue(newModifyContentDateFromPim.substring(0, 4).equals(lastUpdatedDate.substring(6, 10)),
				"year is not same");
	}
	
	public String getChildAssetValule() {
		String value=adminProductPages.getElement(ProductAttribute_PublicAdmin.childAssetAttribute).getAttribute("value");
		return value;
	}
	
	public void verifyCodenAttribute(String expectedValue) {
		System.out.println(PublicCommon.getText(driver, ProductAttribute_PublicAdmin.codeAttribute));
		Assert.assertTrue(expectedValue.equalsIgnoreCase(PublicCommon.getText(driver, ProductAttribute_PublicAdmin.codeAttribute)), "Coden attribute not found");
	}
	
	public void verifyCodenAttributeValue(String expectedValue) {
		String actualValue=adminProductPages.getElement(ProductAttribute_PublicAdmin.codeAttribute).getAttribute("value");
		Assert.assertTrue(actualValue.contains(expectedValue), "coden value not matched");
	}
	
	public String verifyCodenAttributeValue() {
		try {
			String codenvalue=adminProductPages.getElement(ProductAttribute_PublicAdmin.codeAttribute).getAttribute("value");
			return codenvalue;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String verifyCollectionAttributeValue() {
		try {
			String collectionvalue=adminProductPages.getElement(ProductAttribute_PublicAdmin.collectionAttribute).getAttribute("value");
			return collectionvalue;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String verifyCollectionDOIAttributeValue() {
		try {
			String collectionDOIvalue=adminProductPages.getElement(ProductAttribute_PublicAdmin.collectionDOIAttribute).getAttribute("value");
			return collectionDOIvalue;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String verifyVolumeAttributeValue() {
		try {
			String volumeValue=adminProductPages.getElement(ProductAttribute_PublicAdmin.volumeAttribute).getAttribute("value");
			return volumeValue;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String verifyProductEnableOrNot(By xpath) {
		try {
			String productStatus=adminProductPages.getElement(xpath).getText();
			return productStatus;
		}
		catch (Exception e) {
			e.printStackTrace();
			PublicCommon.reportFailAssert("Failed to verify status", e);
			return "";
		}
	}
	

}
