package com.magento.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.magento.util.BaseTest;


public class CreateOrderTest extends BaseTest {

    @Test(groups = {"Functional", "Integration"})
    public void CreateNewOrder() throws InterruptedException {
        homePageCommerce.goToLogin();
        loginPageCommerce.signIn();
        createOrderPageCommerce.chooseProduct();
        createOrderPageCommerce.makePurchase();
        assertEquals(createOrderPageCommerce.successfullyOrder(), "Thank you for your purchase!");
        System.out.println(createOrderPageCommerce.successfullyOrder());

    }


}