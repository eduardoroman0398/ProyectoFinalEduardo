package com.magento.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.magento.util.BasePage;

public class LoginPage extends BasePage {


    By email = By.id("email");
    By password = By.id("pass");
    By login = By.id("send2");


    By verify_login = By.linkText("Log out");
    By error = By.xpath("//div[contains (text(), 'Login was unsuccessful. Please correct the errors and try again.')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage(WebDriver driver, int timeoutSec) {
        this(driver);
        setTimeoutSec(timeoutSec);
    }

    public void signIn() {
        type(email, "eduardoroman3@gmail.com");
        type(password, "JXh4jWr9H19rRRA");
        click(login);
    }

    public String verifyLogout() {
        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(verify_login));
        return message.getText();
    }


    public String verifyLogoutLogin() {

        if (isDisplayed(error)) {
            return text(error);
        }
        return null;
    }

}
