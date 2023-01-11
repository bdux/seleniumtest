package de.congstar.pages;

import de.congstar.utils.PageUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@PageUrl(value = "https://www.congstar.de/checkout/warenkorb?cart[action]=add&cart[plan]=370&cart[options][]=2454")
public class CongstarWebShopPage extends BasePage{


    @Override
    public void assertPageAvailable() {
       waitForElementVisible(By.cssSelector("html.hydrated body div.container-fluid.wrapper div.app-content.theme--checkout checkout-root checkout-progress-bar-page checkout-cart div common-page-layout div.row div.col.col-12.col-lg-9"));
    }

    public void closeCookieHint() {

        WebElement shadowHost = driver.findElement(By.cssSelector("#usercentrics-root"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        shadowRoot.findElement(By.cssSelector("#uc-center-container > div.sc-cCjUiG.fKWGko > div > div > div > button:nth-child(2)")).click();

    }

    public void acceptAllConsents() {
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.jsReturnsValue("return window.UC_UI.isInitialized()==true;"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.UC_UI.acceptAllConsents();");
    }
}
