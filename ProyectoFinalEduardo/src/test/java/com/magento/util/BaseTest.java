package com.magento.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.magento.page.CreateOrderPage;
import com.magento.page.HomePage;
import com.magento.page.LoginPage;
import com.magento.page.RegisterPage;

public class BaseTest {

    protected WebDriver driver;
    private String BASE_URL;
    private FileReader reader;
    private Properties props;
    protected HomePage homePageCommerce;
    protected RegisterPage registerPageCommerce;
    protected LoginPage loginPageCommerce;
    protected CreateOrderPage createOrderPageCommerce;

    @BeforeTest
    public void loadSettings() throws IOException {
        reader = new FileReader(System.getProperty("user.dir")+"/src/test/resources/config.properties");
        props = new Properties();
        props.load(reader);
        BASE_URL = props.getProperty("url");
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver(); // inicia cromedriver
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        homePageCommerce = new HomePage(driver);
        registerPageCommerce = new RegisterPage(driver);
        loginPageCommerce = new LoginPage(driver);
        createOrderPageCommerce = new CreateOrderPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
