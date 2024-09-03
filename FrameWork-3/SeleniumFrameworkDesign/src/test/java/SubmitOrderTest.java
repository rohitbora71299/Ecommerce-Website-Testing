import TestComponents.BaseTest;
import org.junit.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import java.io.IOException;

public class SubmitOrderTest extends BaseTest {
@Test
    public void submitOrder() throws InterruptedException, IOException {
//        LandingPage landingPage =
        ProductCatalogue prodCat = landingPage.loginApplication(email,password);
        System.out.println("Login Successful");
        prodCat.addToCart(prodName);
        CartPage cartPage = prodCat.goToCartPage();
        boolean match = cartPage.verifyProductDisplay(prodName);
        Assert.assertTrue(match);
        CheckoutPage pp = cartPage.goToCheckout();
        ConfirmationPage checkoutPage = pp.selectCountry(country);
        String expectedMsg = "Thankyou for the order.";
        String actualMsg = checkoutPage.getConfirmationPage();
        Assert.assertTrue(actualMsg.equalsIgnoreCase(expectedMsg));
    }
}
