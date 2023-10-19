package com.webauto.testdata;

import com.webauto.common.BaseWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditCardInfo extends BaseWebPage {

    public CreditCardInfo(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "iframe#first-data-payment-field-name")
    WebElement frm_nameOnCC;
    @FindBy(css = "input#name") WebElement txt_nameonCC;

    @FindBy(css = "iframe#first-data-payment-field-card") WebElement frm_creditCardNumber;
    @FindBy(css = "input#card") WebElement txt_creditCardNumber;

    @FindBy(css = "iframe#first-data-payment-field-exp") WebElement frm_creditCardExpiry;
    @FindBy(css = "input#exp") WebElement txt_creditCardExpiry;

    @FindBy(css = "iframe#first-data-payment-field-cvv") WebElement frm_creditCardCvv;
    @FindBy(css = "input#cvv") WebElement txt_creditCardCvv;

    public void enterCreditCardNumber (String cardNumber)
    {
        driver.switchTo().frame(frm_creditCardNumber);
        txt_creditCardNumber.click();
        txt_creditCardNumber.sendKeys("5500000000000004");
        try{
            Thread.sleep(2000);
        }catch (Exception e)
        {
            //Exceptionhandling
        }
        driver.switchTo().parentFrame();
    }

    public void enterCreditCardExpiry(String expiryDate)
    {
        driver.switchTo().frame(frm_creditCardExpiry);
        txt_creditCardExpiry.click();
        txt_creditCardExpiry.sendKeys("12/29");
        driver.switchTo().parentFrame();
    }

    public void enterCreditCardCvv(String cvv)
    {
        driver.switchTo().frame(frm_creditCardCvv);
        txt_creditCardCvv.click();
        txt_creditCardCvv.sendKeys("111");
        driver.switchTo().parentFrame();
    }

    public void enterNameOnCC(String name)
    {
        driver.switchTo().frame(frm_nameOnCC);
        txt_nameonCC.click();
        txt_nameonCC.sendKeys("kk");
        driver.switchTo().defaultContent();
    }

    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv, String name)
    {
        enterCreditCardNumber(cardNumber);
        enterCreditCardExpiry(expiryDate);
        enterCreditCardCvv(cvv);
        enterNameOnCC(name);
    }
}
