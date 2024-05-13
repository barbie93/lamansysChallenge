package tests;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EbayItemPage;
import pages.EbayPage;
import pages.EbaySearchResultsPage;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class TestEbay extends BaseTest {
    private static final String ERROR_MSG = "The price item was not obtained correctly";

    @Description("Test scenario to searh an item on Ebay and print price")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void searchItem(){
        String itemName = "Electric Guitar";
        String itemPrice = EMPTY;
        EbayPage ebayPage = new EbayPage(driver);
        ebayPage.openPage();
        ebayPage.searchItem(itemName);
        EbaySearchResultsPage ebaySearchResultsPage = new EbaySearchResultsPage(driver);
        ebaySearchResultsPage.clickFirstResultsElement();
        EbayItemPage ebayItemPage = new EbayItemPage(driver);
        itemPrice = ebayItemPage.getItemPrice();
        System.out.println("The item price is: " + itemPrice);
        Assert.assertTrue(!itemName.isEmpty(), ERROR_MSG);
    }
}