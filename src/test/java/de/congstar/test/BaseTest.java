package de.congstar.test;

import de.congstar.pages.BasePage;
import de.congstar.utils.PageUrl;
import de.congstar.utils.PageUrlSupport;
import de.congstar.webdriver.WebDriverBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;
import java.time.Duration;

public abstract class BaseTest {

    static WebDriver driver;
    @BeforeAll
    public static void setup() {
        driver = new WebDriverBuilder().getDriver();
    }

    public <T extends BasePage> T navigateToPage(Class<T> pageObject){
        driver.get(PageUrlSupport.getUrlFor(pageObject));

        T pageInstance = PageFactory.initElements(driver, pageObject);
        pageInstance.setDriver(driver);
        pageInstance.assertPageAvailable();
        return pageInstance;

    }

    public void sleep(Duration duration){

        try {
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @AfterAll
    public static void tearDown(){
        driver.close();
    }

}
