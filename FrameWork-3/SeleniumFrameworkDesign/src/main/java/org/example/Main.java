package org.example;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.*;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try{
            String prodName = "ZARA COAT 3";
            String email = "unknown@gmail.com", password = "Unknown@123";
            LandingPage lp = new LandingPage(driver);
            lp.goTo();
            lp.loginApplication(email,password);
            System.out.println("Login Successful");
            ProductCatalogue prodCat = new ProductCatalogue(driver);
            prodCat.addToCart(prodName);
            CartPage cartPage = prodCat.goToCartPage();
            boolean match = cartPage.verifyProductDisplay(prodName);
            Assert.assertTrue(match);
            cartPage.goToCheckout();
            String country = "India";
            CheckoutPage pp = new CheckoutPage(driver);
            pp.selectCountry(country);
            ConfirmationPage checkoutPage = new ConfirmationPage(driver);
            String expectedMsg = "Thankyou for the order.";
            String actualMsg = checkoutPage.getConfirmationPage();
            Assert.assertTrue(actualMsg.equalsIgnoreCase(expectedMsg));
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            driver.quit();
        }
    }
}