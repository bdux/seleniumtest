package de.congstar.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public abstract class BasePage {
    public String url;
    WebDriver driver;

    public abstract void assertPageAvailable();

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public <T extends BasePage> T createPage(Class<T> clazz) {
        T page = PageFactory.initElements(driver, clazz);
        page.setDriver(driver);
        return page;
    }

    protected <T> T performWebDriverWait(ExpectedCondition<T> expectedCondition) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .ignoring(NotFoundException.class, StaleElementReferenceException.class)
                .until(expectedCondition);
    }

    public WebElement waitForElementVisible(WebElement element) {
        return performWebDriverWait(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementVisible(By locator) {
        return performWebDriverWait(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void closeCookieHint() {
        //WebElement shadowHost = waitForElementVisible(By.cssSelector("#shadow_host"));
        WebElement shadowHost = waitForElementVisible(By.cssSelector("#usercentrics-root"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        shadowRoot.findElement(By.cssSelector("#uc-center-container > div.sc-cCjUiG.fKWGko > div > div > div > button:nth-child(2)")).click();

    }
}
