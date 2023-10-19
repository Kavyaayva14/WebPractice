package com.webauto.common;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class BaseWebPage {
    public WebDriver driver;

    public BaseWebPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}


