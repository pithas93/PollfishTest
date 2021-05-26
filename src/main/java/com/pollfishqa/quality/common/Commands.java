package com.pollfishqa.quality.common;

import com.persado.oss.quality.stevia.selenium.core.SteviaContext;
import com.persado.oss.quality.stevia.selenium.core.WebComponent;
import com.persado.oss.quality.stevia.selenium.core.controllers.WebDriverWebController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Commands extends WebComponent {

    public enum CommonLocators implements LocatorAccessor {
        BUTTON_BY_TEXT("css=button:contains(''{0}'')"),
        MODAL_CONTENT("css=div.ant-modal-content")
        ;

        private String myLocator;

        CommonLocators(String locator){
            myLocator = locator;
        }

        public String getLocator(){
            return myLocator;
        }
    }

    /**
     * Insert text in the input field specified by the locator param
     * @param locator
     * @param text
     */
    public void inputText(String locator,String text){
        controller().input(locator,text);
    }

    /**
     * Click at the given locator
     * @param locator
     */
    public void press(String locator){
        controller().press(locator);
    }

    /**
     * Press given locator and wait for modal to appear
     * @param locator
     */
    public void pressAndWaitForModal(String locator){
        pressAndWaitForElement(locator,CommonLocators.MODAL_CONTENT.get());
    }

    /**
     * Wait for a specific element
     * @param expectedElementLocator
     */
    public void waitForElement (String expectedElementLocator){
        controller().waitForElement(expectedElementLocator,Long.parseLong(SteviaContext.getParam("waitForElement.Timeout")));
    }


    /**
     * Press and wait for element
     * @param locator
     * @param expectedElementLocator
     */
    public void pressAndWaitForElement (String locator, String expectedElementLocator){
            press(locator);
            waitForElement(expectedElementLocator);
    }

    /**
     * Returns true in case of element is present
     * @param locator
     * @return
     */
    public Boolean isComponentPresent(String locator){
        return controller().isComponentPresent(locator);
    }

    public void mouseOver(String locator){
            controller().mouseOver(locator);
    }

    /**
     * Switch to frame using css selector
     * Note: Do not use css= (stevia type selectors)
     */
    public void switchToFrameBySelector(String cssSelector){
            WebElement element = ((WebDriverWebController) SteviaContext.getWebController()).getDriver().findElement(By.cssSelector(cssSelector));
            ((WebDriverWebController) SteviaContext.getWebController()).getDriver().switchTo().frame(element);
    }

    /**
     * Close frame and return back to main window
     */
    public void closeFrame(){
            ((WebDriverWebController) SteviaContext.getWebController()).getDriver().switchTo().defaultContent();
    }



}
