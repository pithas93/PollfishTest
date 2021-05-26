package com.pollfishqa.quality.businessObjects;

import com.persado.oss.quality.stevia.testng.Verify;
import com.pollfishqa.quality.pageObjects.DashboardPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DashboardBO extends BaseBo{

    @Autowired
    protected DashboardPO dashboardPO;

    @Autowired
    protected SurveyBO surveyBO;

    protected Verify verify = new Verify();

    public DashboardBO createSurvey(){
        dashboardPO.pressCreateNewSurvey();
        return this;
    }

    public SurveyBO withSurveyName(String surveyName){
        dashboardPO.inputSurveyName(surveyName);
        dashboardPO.submitSurveyName();
        surveyBO.waitForSurvey(surveyName);
        return surveyBO;
    }

    public void verifySurveyCreation(String surveyName){
        verify.text(DashboardPO.DashboardLocators.SUVRVEY_LIST_ELEMENT.getWithParams("0"), surveyName );
    }
}
