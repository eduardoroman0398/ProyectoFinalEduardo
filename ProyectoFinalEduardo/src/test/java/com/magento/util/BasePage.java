package com.magento.util;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    int timeoutSec = 20;
    Actions action;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
    }

    public void mouseOver(By element){
       action.moveToElement(find(element)).perform();
    }

    public void setTimeoutSec(int timeoutSec) {
        this.timeoutSec = timeoutSec;
    }

    public void loadUrl(String url) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutSec));
        driver.get(url);
    }

    public WebElement find(By element) {
        return driver.findElement(element);
    }

    public void click(By element) {
        find(element).click();
    }

    public void submit(By element) {
        find(element).submit();
    }

    public void type(By element, String text) {
        find(element).clear();
        find(element).sendKeys(text);
    }

    public void selected(By element, String M){

    }
    public String text(By element) {
        return find(element).getText();
    }

    public boolean isDisplayed(By element) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}