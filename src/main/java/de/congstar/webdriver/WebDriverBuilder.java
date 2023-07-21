package de.congstar.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBuilder {

    WebDriver driver;

    public static void setup(){
        WebDriverManager.chromedriver().setup();
    }
    public WebDriver getDriver() {
        driver = new ChromeDriver();
        return driver;
    }
}
