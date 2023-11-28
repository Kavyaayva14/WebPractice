package com.webauto.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseWebPage {
    public WebDriver driver;

    public BaseWebPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
<<<<<<< HEAD
=======
        //
>>>>>>> eb010b5 (check)
    }
}


