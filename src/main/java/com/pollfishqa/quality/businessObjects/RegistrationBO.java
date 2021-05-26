package com.pollfishqa.quality.businessObjects;

import com.pollfishqa.quality.dtos.Registration;
import com.pollfishqa.quality.enums.AccountGoal;
import com.pollfishqa.quality.enums.ReferralSource;
import com.pollfishqa.quality.pageObjects.WebsitePO;
import com.pollfishqa.quality.pageObjects.RegistrationPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationBO extends BaseBo{
    @Autowired
    RegistrationPO registrationPO;

    @Autowired
    WebsitePO websitePO;

    public void clickRegister(){
        websitePO.pressRegister();
    }

    public RegistrationBO next(){registrationPO.pressNextBtn();return this;}

    public RegistrationBO register(){registrationPO.pressRegisterBtn();return this;}

    public RegistrationBO withCompanyEmail(String companyEmail){registrationPO.inputCompanyEmail(companyEmail);return this;}

    public RegistrationBO withPassword(String pwd){registrationPO.inputPassword(pwd);return this;}

    public RegistrationBO withFullName(String fullName){registrationPO.inputFullName(fullName);return this;}

    public RegistrationBO withCompanyName(String companyName){registrationPO.inputCompanyName(companyName);return this;}

    public RegistrationBO withAccountGoal(AccountGoal accountGoal){registrationPO.selectAccountGoal(accountGoal.getAccountGoal());return this;}

    public RegistrationBO withReferralSource(ReferralSource referralSource){registrationPO.selectReferralSource(referralSource.getReferralSource());return this;}

    public RegistrationBO acceptAgreement(){registrationPO.acceptAgreement();return this;}

    public RegistrationBO registerNewResearcher(Registration registrationDto){
        clickRegister();
        withCompanyEmail(registrationDto.getCompanyEmail()).register()
                .withPassword(registrationDto.getPassword()).next()
                .withFullName(registrationDto.getFullName()).next()
                .withCompanyName(registrationDto.getCompanyName()).next()
                .withAccountGoal(registrationDto.getAccountGoal()).next()
                .withReferralSource(registrationDto.getReferralSource()).next()
                .acceptAgreement();
        return this;
    }
}
