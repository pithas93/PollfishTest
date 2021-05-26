package com.pollfishqa.quality.pageObjects;

import com.pollfishqa.quality.common.Commands;
import com.pollfishqa.quality.common.LocatorAccessor;
import org.springframework.stereotype.Component;

@Component
public class HeaderMenuPO extends Commands {

    public enum HeaderMenuLocators implements LocatorAccessor {
        MENU_TRIGGER_BULLETS("css=button.ant-dropdown-trigger"),
        LOGOUT_OPTION("css=div.menu li>a[href*=logout]"),
        CHAT_IFRAME("iframe[title*=chat]"),
        CLOSE_CHAT_BTN("css=div.initial-message-bubble > button")
        ;

        private String myLocator;

        HeaderMenuLocators(String locator) {
            myLocator = locator;
        }

        public String getLocator() {
            return myLocator;
        }
    }

    /**
     * Mouse over bullets at the header bar to show the menu options
     */
    public void mouseOverMenuOptions() {
        mouseOver(HeaderMenuLocators.MENU_TRIGGER_BULLETS.getLocator());
    }

    /**
     * Press logout option
     */
    public void pressLogout(){
        pressAndWaitForElement(HeaderMenuLocators.LOGOUT_OPTION.get(),WebsitePO.WebSiteLocators.HEADER_ACTION_BTN.getWithParams("Register"));
    }

    /**
     * Close chat
     */
    public void closeChat(){
        switchToFrameBySelector(HeaderMenuLocators.CHAT_IFRAME.get());
        waitForElement(HeaderMenuLocators.CLOSE_CHAT_BTN.get());
        press(HeaderMenuLocators.CLOSE_CHAT_BTN.get());
        closeFrame();
    }


}
