package listAmPages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class listAmPracticePage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, 12);
    Actions action = new Actions(driver);
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    @FindBy(id = "idSearchBox")
    private WebElement searchFiled;
    @FindBy(css = "a[href='/am/']")
    private WebElement cookie;
    @FindBy(id = "ui-id-1")
    private WebElement searchSuggestion;
    @FindBy(id = "idtype1")
    public WebElement radioButton2;
    @FindBy(css = "[data-c='0']")
    private WebElement allCategories;
    @FindBy(xpath = "//div[1]/div/div/span[1]/a")
    private WebElement realEstate;
    @FindBy(xpath = "//span[1]/div/div/div[1]/a[5]")
    private WebElement garageAndParking;
    @FindBy(css = "a[href='/category/173/5']")
    private WebElement page5;

    public listAmPracticePage(WebDriver driver) {
        super(driver);
    }

    public void closeCookie() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/am/']")));
        cookie.click();
    }

    public void fillTheSearchField(String search) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSearchBox")));
        searchFiled.sendKeys(search);
        searchFiled.sendKeys(Keys.ENTER);
    }

    public void select2ndRadioButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idtype1")));
        radioButton2.click();
    }

    public void howerOnAllCategories_RealEstate_Garage() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeSelected(By.id("idtype1")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-c='0']")));
        action.moveToElement(allCategories).perform();
        Thread.sleep(1000); //for us
        action.moveToElement(realEstate).perform();
        action.moveToElement(garageAndParking).perform();
        garageAndParking.click();
        Thread.sleep(1000);
    }

    public void enterThePage5() throws InterruptedException {
        wait.until(ExpectedConditions.urlContains("https://www.list.am/category/173"));
        jse.executeScript("window.scrollTo(0,11500);");
        Thread.sleep(2000);
        page5.click();
    }

    public void selectSearchSuggestionLine(int line) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-1")));
        List<WebElement> list = driver.findElements(By.id("ui-id-1"));

        for (int i = 0; i < list.size(); i++) {
            if (i == line)
                list.get(i).click();
        }
    }
}

