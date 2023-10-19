package com.webauto.testpage;

import com.webauto.common.BaseWebPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ThankyouPage extends BaseWebPage {
    public ThankyouPage(WebDriver driver)
    {
        super(driver);
    }

    public void captureScreenshot()
    {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File trg = new File("C:\\Users\\2174220\\IdeaProjects\\PetSmartWebPractice\\src\\main\\resources\\screenshots\\thankyou.png");
            FileHandler.copy(src, trg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
