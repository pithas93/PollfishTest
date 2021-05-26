package com.pollfishqa.quality.businessObjects;

import com.persado.oss.quality.stevia.testng.Verify;
import com.pollfishqa.quality.pageObjects.HeaderMenuPO;
import com.pollfishqa.quality.pageObjects.WebsitePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseBo {

    @Autowired
    protected HeaderMenuPO headerMenuPO;

    protected Verify verify = new Verify();

    /**
     * Log out
     */
    public BaseBo logOut(){
        headerMenuPO.closeChat();
        headerMenuPO.mouseOverMenuOptions();
        headerMenuPO.pressLogout();
        return this;
    }

    /**
     * Verify that user is logged out if register btn is present
     */
    public void verifyLoggedOut(){
        verify.elementPresent(WebsitePO.WebSiteLocators.HEADER_ACTION_BTN.getWithParams("Register"));
    }

}
