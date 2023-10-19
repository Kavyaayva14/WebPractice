package com.webauto.test;

import com.webauto.common.BaseWebTest;
import com.webauto.testpage.ProductDisplayPage;
import com.webauto.testpage.CartPage;
import com.webauto.testpage.GuestCheckoutPage;
import com.webauto.testpage.ThankyouPage;
import org.testng.annotations.Test;

public class TC_CheckoutSTH_CC_Promo_Charity_Guest extends BaseWebTest {

    @Test()
    public void STH_CC_Promo_Charity_Guest()
    {
        ProductDisplayPage addToCart = new ProductDisplayPage(driver);
        addToCart.addToCartSTH();

        CartPage cartPage = new CartPage(driver);
        cartPage.applyCharity();
        cartPage.applyPromo();
        cartPage.continueToCheckout();

        GuestCheckoutPage guestCheckoutPageSth = new GuestCheckoutPage(driver);
        guestCheckoutPageSth.guestCheckoutLogin();
        guestCheckoutPageSth.guestShippingAddress();
        guestCheckoutPageSth.guestShippingOptions();
        guestCheckoutPageSth.guestCreditCardDetails();
        guestCheckoutPageSth.placeOrder();

        ThankyouPage thankYouPage = new ThankyouPage(driver);
        thankYouPage.captureScreenshot();
    }

}
