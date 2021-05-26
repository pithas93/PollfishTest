package com.pollfishqa.quality.dataLoader;

import com.pollfishqa.quality.dtos.Registration;
import com.pollfishqa.quality.enums.AccountGoal;
import com.pollfishqa.quality.enums.ReferralSource;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataLoader {

    public Registration loadRegistrationDto(){
        Registration registration=new Registration();
        String uniqueId= UUID.randomUUID().toString().substring(0,5);
        registration.setCompanyEmail("test@test"+uniqueId+".com");
        registration.setFullName("John Doe");
        registration.setPassword(uniqueId);
        registration.setCompanyName("Pollfish");
        registration.setAccountGoal(AccountGoal.BUY_SURVEY_RESPONSES);
        registration.setReferralSource(ReferralSource.GOOGLE);
        return registration;
    }
}
