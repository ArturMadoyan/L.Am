package listAmTests;

import initDriver.Init;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void initDriver() {
        Init initDriver = new Init();
        driver = initDriver.getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void quitDriver() {
        driver.close();
        driver.quit();
    }
}
