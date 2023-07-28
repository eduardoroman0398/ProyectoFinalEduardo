package com.magento.test;

import org.testng.annotations.Test;
import com.magento.util.BaseTest;


public class LoginTest extends BaseTest {

    @Test (priority = 1, groups = "Functional")
    public void doLogin() {
        homePageCommerce.goToLogin();
        loginPageCommerce.signIn();

    }


}