package com.seleniumtestframework.base;
import com.seleniumtestframework.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class TestBase {

    private WebDriver driver;
    private static Properties prop;
    protected BasePage basePage;

    /***
     * Load the property file
     */
    public TestBase(){
        prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/seleniumtestframework/config/config.properties");
            try{
                prop.load(fis);
            }catch (IOException e){
                e.printStackTrace();
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        }

    /***
     * Initialize the browser and navigate to the base url
     */
    @BeforeClass
    public void setUp(){
        browserInitialization(prop.getProperty("browser"));
        openBaseURL(prop.getProperty("baseURL"));
    }

    /***
     * After all the test methods close all the browser sessions
     */
    @AfterClass
    public void tearDown(){
        driver.quit();

    }

    /***
     * Selects the browser to launch based on the 'browser' parameter value and then maximize the browser
     * @param browser
     */
    private void browserInitialization(String browser){
        switch (browser.toLowerCase(Locale.ROOT)) {
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    /***
     * Navigate to the base url
     * @param url - base url from the property file
     */
    public void openBaseURL(String url){
        driver.get(url);
        basePage = new BasePage(driver);
    }
}
