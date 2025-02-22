package com.diplom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class BrowserFactory {
    private static final Logger logger = LoggerFactory.getLogger(BrowserFactory.class);
    private static final String CONFIG_PATH = "config.properties";
    private static final String DRIVERS_DIR = "src/test/resources/";

    public static WebDriver getDriver() {
        Properties config = loadConfig();
        String browser = getBrowserName(config);
        String driverPath = getDriverPath(browser);

        System.setProperty("webdriver.chrome.driver", driverPath);
        return createWebDriver(browser);
    }

    private static Properties loadConfig() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_PATH)) {
            props.load(fis);
            logger.info("Configuration loaded successfully");
        } catch (IOException e) {
            logger.warn("Configuration file not found, using defaults");
        }
        return props;
    }

    private static String getBrowserName(Properties config) {
        return config.getProperty("browser").trim().toLowerCase();
    }

    private static String getDriverPath(String browser) {
        String driverFileName = String.format("%sdriver", browser);
        return Paths.get(DRIVERS_DIR, driverFileName).toString();
    }

    private static WebDriver createWebDriver(String browser) {
        switch (browser) {
            case "chrome":
            case "yandex":
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}