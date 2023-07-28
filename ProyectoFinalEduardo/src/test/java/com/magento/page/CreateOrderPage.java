package com.magento.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.magento.util.BasePage;

public class CreateOrderPage extends BasePage {

    By optionGear_link = By.xpath("//a[@id='ui-id-6']");
    By optionBags_link = By.xpath("//a[@id='ui-id-25']");
    By bag2 = By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[2]");
    By addBag2 = By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]");

    By messageProductAddedtoShoppingCart = By.xpath("//body/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]");

    By shoppingCart = By.xpath("//header/div[2]/div[1]/a[1]");
    By chaeckout_button = By.xpath("//button[@id='top-cart-btn-checkout']");

    By firsName = By.xpath("//input[@class='input-text' and @name='firstname']");
    By lastName = By.xpath("//input[@class='input-text' and @name='lastname']");
    By company = By.xpath("//input[@class='input-text' and @name='company']");
    By country = By.xpath("//select[@class='select' and @name='country_id']");
    By state = By.xpath("//select[@class='select' and @name='region_id']");
    By city = By.xpath("//input[@class='input-text' and @name='city']");
    By address1 = By.xpath("//input[@class='input-text' and @name='street[0]']");
    By address2 = By.xpath("//input[@class='input-text' and @name='street[1]']");
    By address3 = By.xpath("//input[@class='input-text' and @name='street[2]']");
    By zip = By.xpath("//input[@class='input-text' and @name='postcode']");
    By phone = By.xpath("//input[@class='input-text' and @name='telephone']");
    By shippingMethod = By.xpath("//input[@class='radio' and @name='ko_unique_3']");
    By acceptPlaceOrder = By.xpath("//button[@class='action primary checkout'][contains(.,'Place Order')]");
    By orderFinish = By.xpath("//span[@class='base'][contains(.,'Thank you for your purchase!')]");


    By Next = By.xpath("//body/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[2]/div[1]/div[3]/form[1]/div[3]/div[1]/button[1]");


    public CreateOrderPage(WebDriver driver2) {
        super(driver2);
    }

    public CreateOrderPage(WebDriver driver2, int timeoutSec) {
        this(driver2);
        setTimeoutSec(timeoutSec);
    }

    public void chooseProduct() throws InterruptedException {
        mouseOver(optionGear_link);
        click(optionBags_link);
        mouseOver(bag2);
        Thread.sleep(2000);
        click(addBag2);
        Thread.sleep(2000);
        isDisplayed(messageProductAddedtoShoppingCart);
    }

    public void makePurchase() throws InterruptedException {
        Thread.sleep(2000);
        isDisplayed(shoppingCart);
        click(shoppingCart);
        click(chaeckout_button);
        isDisplayed(firsName);
        type(firsName, "eduardo");
        type(lastName, "roman");
        type(company, "sa");
        type(address1, "av peru");
        type(address2, "san martin de porres");
        type(address3, "lima");
        type(city, "Lima");
        Select sel_state = new Select(find(state));
        sel_state.selectByValue("5");
        type(zip, "+51");
        Select sel_country = new Select(find(country));
        sel_country.selectByValue("PE");
        type(phone, "987654321");
        click(shippingMethod);
        click(Next);
        Thread.sleep(6000);
        isDisplayed(acceptPlaceOrder);
        click(acceptPlaceOrder);
    }

    public String successfullyOrder() {
        WebElement message = find(orderFinish);
        return message.getText();
    }


}
