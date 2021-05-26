package com.pollfishqa.quality;

import com.persado.oss.quality.stevia.selenium.core.SteviaContext;
import com.persado.oss.quality.stevia.spring.SteviaTestBase;
import com.pollfishqa.quality.businessObjects.DashboardBO;
import com.pollfishqa.quality.businessObjects.RegistrationBO;
import com.pollfishqa.quality.businessObjects.SurveyBO;
import com.pollfishqa.quality.dataLoader.DataLoader;
import com.pollfishqa.quality.dtos.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PollfishQATest extends SteviaTestBase {
    protected Registration registration;
    protected String surveyName;

    @Autowired
    protected DataLoader dataLoader;

    @Autowired
    protected RegistrationBO registrationBO;

    @Autowired
    protected DashboardBO dashboardBO;

    @Autowired
    protected SurveyBO surveyBO;

    @BeforeClass
    public void loadData() throws Exception{
        SteviaContext.getWebController().maximizeWindow();
        registration = dataLoader.loadRegistrationDto();
        surveyName= "TestSurvey";
    }

    @BeforeClass(dependsOnMethods = "loadData")
    public void createData() throws Exception{
        registrationBO.registerNewResearcher(registration);
        dashboardBO.createSurvey().withSurveyName(surveyName).backHome();
    }

    @Test(alwaysRun = true,description = "Verify survey creation after new researcher registration")
    public void testStep_1(){
        dashboardBO.verifySurveyCreation(surveyName);
    }

    @Test(alwaysRun = true,description = "Verify user has been succesfully logged out",dependsOnMethods = "testStep_1")
    public void testStep_2(){
        dashboardBO.logOut()
                .verifyLoggedOut();

    }
}
