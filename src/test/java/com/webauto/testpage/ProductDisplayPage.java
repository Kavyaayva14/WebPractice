package com.webauto.testpage;

import com.webauto.common.BaseWebPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductDisplayPage extends BaseWebPage {

    public ProductDisplayPage(WebDriver driver)
    {
        super(driver);
    }

    //WebElements
    @FindBy(xpath = "//input[@name='q']") WebElement txt_sku;

    @FindBy(xpath = "(//*[@tabindex=\"0\"])[5]") WebElement btn_sth;
    @FindBy(xpath = "//*[@id=\"sth-qty\"]") WebElement drpdwn_sth;
    @FindBy(css = "button.default") WebElement btn_addToCart;

    @FindBy(xpath = "(//*[@type='button'])[104]") WebElement btn_viewCart;


    //ActionMethods
    public void addToCartSTH()
    {
        txt_sku.sendKeys("5066968", Keys.ENTER);
        btn_sth.click();
        Select qty = new Select(drpdwn_sth);
        qty.selectByValue("3");
        btn_addToCart.click();
        btn_viewCart.click();
    }
}
