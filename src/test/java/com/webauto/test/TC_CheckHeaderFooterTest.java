package com.webauto.test;

import com.webauto.common.BaseWebTest;
import com.webauto.testpage.LandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_CheckHeaderFooterTest extends BaseWebTest {

    @Test
    public void checkLogoPresence()
    {
        LandingPage homepage = new LandingPage(driver);
        homepage.checkLogo();
        Assert.assertTrue(homepage.checkLogo());
    }

    @Test
    public void checkHeader()
    {
        LandingPage homepage = new LandingPage(driver);
        homepage.checkBrandHeader();
        Assert.assertTrue(homepage.checkBrandHeader());

        homepage.checkPetHeader();
        Assert.assertTrue(homepage.checkPetHeader());
    }

    @Test
    public void checkFooter()
    {
        LandingPage homepage = new LandingPage(driver);
        homepage.checkWebAccessFooter();
        Assert.assertTrue(homepage.checkWebAccessFooter());

        homepage.checkHelpFooter();
        Assert.assertTrue(homepage.checkHelpFooter());
    }
}
