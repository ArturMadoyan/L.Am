package listAmTests;

import listAmPages.Constants;
import listAmPages.listAmPracticePage;
import org.junit.Assert;
import org.junit.Test;

public class listAmTest extends BaseTest {
    @Test
    public void listAm() throws InterruptedException {
        listAmPracticePage listam = new listAmPracticePage(driver);
        driver.get("https://www.list.am/");
        listam.closeCookie();
        String search = "bnakaran";
        listam.fillTheSearchField(search);
        Assert.assertTrue(driver.getCurrentUrl().contains(search));
        listam.select2ndRadioButton();
        Assert.assertTrue(listam.radioButton2.isSelected());
        listam.howerOnAllCategories_RealEstate_Garage();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.GARAGE_AND_PARKING_PAGE);
        listam.enterThePage5();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.PAGE_5_URL);
    }
}
