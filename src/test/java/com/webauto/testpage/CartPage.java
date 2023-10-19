package com.webauto.testpage;

import com.webauto.common.BaseWebPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BaseWebPage {

    public CartPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "(//*[@type=\"text\"])[6]") WebElement txt_charity;
    @FindBy(xpath = "(//*[@value=\"Apply\"])[1]") WebElement btn_charityApply;
    @FindBy(xpath = "(//*[@type=\"text\"])[7]") WebElement txt_promo;
    @FindBy(xpath = "(//*[@value=\"Apply\"])[2]") WebElement btn_promoApply;
    @FindBy(xpath = "//div[contains(@class,'checkout-button')]") WebElement btn_continueCheckout;

    public void applyCharity()
    {
        txt_charity.sendKeys("2");
        btn_charityApply.click();
    }

    public void applyPromo()
    {
        txt_promo.sendKeys("DigitalAuto10");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",btn_promoApply);
        btn_promoApply.click();
    }

    public void continueToCheckout()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(btn_continueCheckout));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",btn_continueCheckout);
        btn_continueCheckout.click();
    }
}
