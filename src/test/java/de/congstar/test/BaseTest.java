package de.congstar.test;

import de.congstar.pages.BasePage;
import de.congstar.utils.PageUrlSupport;
import de.congstar.webdriver.WebDriverBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

@Execution(ExecutionMode.CONCURRENT)
public abstract class BaseTest {

    WebDriver driver;
    @BeforeAll
    public static void setupAll() {
        WebDriverBuilder.setup();
    }

    @BeforeEach
    void setup(){
        driver = new WebDriverBuilder().getDriver();
    }

    @AfterEach
    public void tearDown(){
        if (driver != null)
            driver.quit();
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


}
