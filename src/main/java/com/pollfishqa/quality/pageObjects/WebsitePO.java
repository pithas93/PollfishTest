package com.pollfishqa.quality.pageObjects;

import com.pollfishqa.quality.common.Commands;
import com.pollfishqa.quality.common.LocatorAccessor;
import org.springframework.stereotype.Component;

@Component
public class WebsitePO extends Commands {

    private RegistrationPO registrationPO;

    public enum WebSiteLocators implements LocatorAccessor {
        HEADER_ACTION_BTN("css=div.header__actions a:contains(''{0}'')");

        private String myLocator;

        WebSiteLocators(String locator){
            myLocator = locator;
        }

        public String getLocator(){
            return myLocator;
        }

    }

    public RegistrationPO pressRegister(){
        press(WebSiteLocators.HEADER_ACTION_BTN.getWithParams("Register"));
        return registrationPO;
    }
}
