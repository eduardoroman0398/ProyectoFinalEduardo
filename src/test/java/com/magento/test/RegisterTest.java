package com.magento.test;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;


import com.magento.util.BaseTest;

public class RegisterTest extends BaseTest {


    @Test (priority = 0, groups = "Functional")
    public void doRegister() {
        homePageCommerce.goToRegister();
        registerPageCommerce.createAccount();
        assertEquals(registerPageCommerce.verifyRegisterMessage(),"Thank you for registering with Main Website Store.");
        System.out.println(registerPageCommerce.verifyRegisterMessage());
    }

}