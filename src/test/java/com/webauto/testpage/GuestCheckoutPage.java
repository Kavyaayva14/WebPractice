package com.webauto.testpage;

import com.webauto.common.BaseWebPage;
import com.webauto.testdata.CreditCardInfo;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GuestCheckoutPage extends BaseWebPage {

    public String cardNumber;
    public String expiryDate;
    public String cvv;
    public String name;

    public GuestCheckoutPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "(//input[@name='email'])[2]") WebElement txt_useremail;
    @FindBy(xpath = "(//*[@class='sparky-c-button__text'])[3]")
    WebElement btn_continueAsGuest;

    @FindBy(xpath = "(//*[@type='text'])[1]") WebElement txt_shippingFullName;
    @FindBy(xpath = "(//*[@type='text'])[2]")
    WebElement txt_shippingStreetAddress;

    @FindBy(xpath = "(//div[@role='button'])[2]")
    WebElement btn_autoSuggestAddress;

    @FindBy(xpath = "//input[@name='postalCode']") WebElement txt_postalCode;
    @FindBy(xpath = "//select[@name='state']") WebElement drpdwn_state;
    @FindBy(xpath = "//input[@name='city']") WebElement txt_cityAddress;
    @FindBy(xpath = "//input[@type='tel']") WebElement txt_phoneNumber;

    @FindBy(xpath = "//main[@id='main-content']//section[1]//button[@type='submit']")
    WebElement btn_saveAndContinueShippingAddress;
    @FindBy(xpath = "//main[@id='main-content']//section[2]//button[@type='submit']")
    WebElement btn_saveAndContinueShippingOptions;
    @FindBy(xpath = "//main[@id='main-content']//section[4]//button[@type='submit']")
    WebElement btn_saveAndContinuePaymentMethod;
    @FindBy(xpath = "//span[text()='Place order']/parent::button[@type='submit']")
    WebElement btn_placeOrder;


    public void guestCheckoutLogin()
    {
        txt_useremail.sendKeys("abc@petsmart.com");
        btn_continueAsGuest.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(btn_continueAsGuest));
    }

    public void guestShippingAddress()
    {
        txt_shippingFullName.sendKeys("abc abc");
        txt_shippingStreetAddress.sendKeys("2901 W Agua Fria Fwy");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(btn_autoSuggestAddress));
            btn_autoSuggestAddress.click();
        }catch (Exception e)
        {
            //Exceptionhandling
        }
        txt_cityAddress.sendKeys("Phoenix");
        txt_postalCode.sendKeys("85027");
        Select qty = new Select(drpdwn_state);
        qty.selectByVisibleText("Arizona");
        txt_phoneNumber.sendKeys("4453456543");
        btn_saveAndContinueShippingAddress.click();

    }

    public void guestShippingOptions()
    {
        btn_saveAndContinueShippingOptions.click();
    }

    public void guestCreditCardDetails()
    {
        CreditCardInfo creditCardInfo = new CreditCardInfo(driver);
        creditCardInfo.enterCreditCardDetails(cardNumber, expiryDate, cvv, name);

        btn_saveAndContinuePaymentMethod.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(btn_saveAndContinuePaymentMethod));
    }

    public void placeOrder()
    {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",btn_placeOrder);
        btn_placeOrder.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(btn_placeOrder));
    }
}
