package com.pollfishqa.quality.pageObjects;

import com.pollfishqa.quality.common.Commands;
import com.pollfishqa.quality.common.LocatorAccessor;
import org.springframework.stereotype.Component;

@Component
public class DashboardPO extends Commands {

    public enum DashboardLocators implements LocatorAccessor {
        ONBOARD_CONTENT("css=div.onboard-content"),
        SURVEY_NAME_INPUT("css=div.ant-modal-content input"),
        SUBMIT_SURVEY_BTN("css=div.ant-modal-content button:contains('Submit')"),
        SUVRVEY_LIST_ELEMENT("css=main div.ant-col a[href]:nth(''{0}'')")
        ;

        private String myLocator;

        DashboardLocators(String locator){
            myLocator = locator;
        }

        public String getLocator(){
            return myLocator;
        }
    }

    /**
     * Press the create new survey button
     */
    public void pressCreateNewSurvey(){
        waitForElement(DashboardLocators.ONBOARD_CONTENT.get());
        pressAndWaitForModal(CommonLocators.BUTTON_BY_TEXT.getWithParams("Create New Survey"));
    }

    /**
     * Input new survey name
     * @param surveyName
     */
    public void inputSurveyName(String surveyName){
        inputText(DashboardLocators.SURVEY_NAME_INPUT.get(),surveyName);
    }

    /**
     * Press submit survey name on modal
     */
    public void submitSurveyName(){
        press(DashboardLocators.SUBMIT_SURVEY_BTN.get());
    }
}
