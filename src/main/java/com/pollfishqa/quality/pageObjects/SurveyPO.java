package com.pollfishqa.quality.pageObjects;

import com.pollfishqa.quality.common.Commands;
import com.pollfishqa.quality.common.LocatorAccessor;
import org.springframework.stereotype.Component;

@Component
public class SurveyPO extends Commands {

    public enum SurveyLocators implements LocatorAccessor {
        SURVEY_NAME_LABEL("css=div.ant-row #name[value=''{0}'']"),
        HOME_BTN("css=span.icon-home")
        ;

        private String myLocator;

        SurveyLocators(String locator){
            myLocator = locator;
        }

        public String getLocator(){
            return myLocator;
        }
    }

    /**
     * Wait for specific given survey to load
     * @param surveyName
     */
    public void waitForSurveyToLoad(String surveyName){
        waitForElement(SurveyLocators.SURVEY_NAME_LABEL.getWithParams(surveyName));
    }

    /**
     * Press back home button
     */
    public void pressBackHome(){
        press(SurveyLocators.HOME_BTN.get());
    }
}
