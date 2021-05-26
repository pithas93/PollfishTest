package com.pollfishqa.quality.businessObjects;

import com.pollfishqa.quality.pageObjects.SurveyPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SurveyBO extends BaseBo{

    @Autowired
    protected SurveyPO surveyPO;

    @Autowired
    protected DashboardBO dashboardBO;

    public void waitForSurvey(String surveyName){
        surveyPO.waitForSurveyToLoad(surveyName);
    }

    public DashboardBO backHome(){
        surveyPO.pressBackHome();
        return dashboardBO;
    }
}
