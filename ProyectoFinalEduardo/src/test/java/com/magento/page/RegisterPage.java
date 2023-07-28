package com.magento.page;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.magento.util.BasePage;

import java.util.Locale;

public class RegisterPage extends BasePage{


    By firstname = By.xpath("//input[@id='firstname']");
    By lastname = By.xpath("//input[@id='lastname']");
    By email = By.xpath("//input[@id='email_address']");
    By password = By.xpath("//input[@id='password']");
    By confirm = By.xpath("//input[@id='password-confirmation']");
    By register_button = By.xpath("//body/div[1]/main[1]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]");
    By verify_register = By.xpath("//div[contains(text(),'Thank you for registering with Main Website Store.')]");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    /*public RegisterPage(WebDriver driver2, int timeoutSec) {
        this(driver2);
        setTimeoutSec(timeoutSec);
    }*/

    public void createAccount() {
        type(firstname, "eduardo");
        type(lastname, "roman");
        type(email, "eduardoroman3@gmail.com");
        type(password, "JXh4jWr9H19rRRA");
        type(confirm, "JXh4jWr9H19rRRA");
        submit(register_button);

    }

    /*public void createAccountFake() {

        Faker faker = new Faker(new Locale("en-US"));
        String emailg = faker.internet().emailAddress();
        String passwordg = faker.internet().password(30,50,true,true,true);

        type(firstname, faker.name().firstName());
        type(lastname, faker.name().lastName());
        type(email, emailg);
        type(password, passwordg);
        type(confirm, passwordg);
        click(register_button);

        System.out.println("Email is: " + emailg +" " + "Password is: "+ passwordg);

    }*/
    public String verifyRegisterMessage() {
        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(verify_register));
        return message.getText();
    }


}
