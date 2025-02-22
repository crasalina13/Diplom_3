package com.diplom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserFactory {
    private static final Logger logger = LoggerFactory.getLogger(BrowserFactory.class);

    public static WebDriver getDriver(BrowserType browser) {
        Properties properties = new Properties();
        WebDriver driver = null;

        try {
            properties.load(new FileInputStream("config.properties"));

            String webdriverPath = properties.getProperty("webdriver.path." + browser.name().toLowerCase());

            System.setProperty("webdriver.chrome.driver", webdriverPath);

            driver = new ChromeDriver();
        } catch (IOException e) {
            logger.error("Error loading properties file or initializing WebDriver", e);
        }

        return driver;
    }

    public enum BrowserType {
        CHROME,
        YANDEX
    }
}
