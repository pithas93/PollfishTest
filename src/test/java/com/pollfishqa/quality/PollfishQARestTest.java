package com.pollfishqa.quality;

import com.persado.oss.quality.stevia.spring.SteviaTestBase;
import com.pollfishqa.quality.dataLoader.DataLoader;
import com.pollfishqa.quality.dtos.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;

public class PollfishQARestTest extends SteviaTestBase {

    protected Registration registration;
    protected String surveyName;

    @Autowired
    protected DataLoader dataLoader;


    @BeforeClass
    public void loadData() throws Exception{
        registration = dataLoader.loadRegistrationDto();
        surveyName= "TestSurvey";
    }

    @BeforeClass(dependsOnMethods = "loadData")
    public void createData() throws Exception{


    }
}
