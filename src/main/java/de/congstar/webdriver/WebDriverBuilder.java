package de.congstar.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class WebDriverBuilder {

    WebDriver driver;

    public WebDriver getDriver() {

       return WebDriverManager.chromedriver().create();

    }
}
