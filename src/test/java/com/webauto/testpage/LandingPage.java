package com.webauto.testpage;

import com.webauto.common.BaseWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BaseWebPage {

    public LandingPage(WebDriver driver)

    {
        super(driver);
    }

    //WebElements
    @FindBy(xpath = "(//*[@alt='PetSmart'])[1]") WebElement img_logo;

    @FindBy(xpath = "(//*[@class='dp-nav-link'])[1]") WebElement href_shopByBrand;
    @FindBy(xpath = "//*[@id=\"a\"]") WebElement frm_shopByBrand;

    @FindBy(xpath = "(//*[@class='dp-nav-link'])[2]") WebElement href_shopByPet;
    @FindBy(xpath = "//*[@id=\"shop-by-pet\"]/ul") WebElement frm_shopByPet;

    @FindBy(xpath = "(//*[@class='_GN_Footer__link'])[5]") WebElement href_webAccess;
    @FindBy(xpath = "//*[@id=\"wrapper\"]") WebElement frm_webAccess;

    @FindBy(xpath="(//*[@class='_GN_Footer__link'])[2]") WebElement href_helpCentre;
    @FindBy(xpath = "//*[@class='content-asset'][1]") WebElement frm_helpCentre;


    //ActionMethods
    public boolean checkLogo()
    {
        img_logo.click();
        boolean status1 = img_logo.isDisplayed();
        return status1;
    }

    public boolean checkBrandHeader()
    {
        href_shopByBrand.click();
        boolean status2 = frm_shopByBrand.isDisplayed();
        return status2;
    }

    public boolean checkPetHeader()
    {
        href_shopByPet.click();
        boolean status3 = frm_shopByPet.isDisplayed();
        return status3;
    }

    public boolean checkWebAccessFooter()
    {
        href_webAccess.click();
        boolean status4 = frm_webAccess.isDisplayed();
        return status4;
    }

    public boolean checkHelpFooter()
    {
        href_helpCentre.click();
        boolean status5 = frm_helpCentre.isDisplayed();
        return status5;
    }
}
