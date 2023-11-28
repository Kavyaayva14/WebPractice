package com.webauto.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class BaseWebTest {
    public WebDriver driver;

    @BeforeClass
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://development.pilot.petsmart.com/");
    }

    /*@AfterClass
    void tearDown()
    {
        driver.quit();
    }*/

}
