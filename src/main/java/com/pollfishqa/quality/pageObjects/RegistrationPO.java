package com.pollfishqa.quality.pageObjects;

import com.pollfishqa.quality.common.Commands;
import com.pollfishqa.quality.common.LocatorAccessor;
import org.springframework.stereotype.Component;

@Component
public class RegistrationPO extends Commands {

    public enum RegistrationLocators implements LocatorAccessor {
        ONBOARD_CONTENT("css=div.onboard-content"),
        COMPANY_EMAIL_INPUT("css=label:contains('Company Email') ~ input"),
        REGISTER_BTN("css=button[type='submit']:contains('Register')"),
        TEXT_INPUT("css=input[name=''{0}'']"),
        COMPANY_NAME_INPUT("css=input[class*='textfield']"),
        COMPANY_NAME_AUTOCOMPLETE_OPTION("css=div.autocomplete_item span"),
        ACCOUNT_GOAL_OPTION("css=input:has(~span:contains(''{0}''))"),
        REFERRAL_SELECT_ARROW("css=#referral-select svg"),
        REFERRAL_SELECT_MENU("css=#referral-select div[class*=menu]"),
        REFERRAL_SELECT_OPTION("css=#referral-select div[class*=option]:contains(''{0}'')"),
        AGREEMENT_CHECKBOX("css=form span.checkbox__label");
        private String myLocator;

        RegistrationLocators(String locator){
            myLocator = locator;
        }

        public String getLocator(){
            return myLocator;
        }
    }

    public void inputCompanyEmail(String email){
        inputText(RegistrationLocators.COMPANY_EMAIL_INPUT.get(),email);
    }

    public void pressRegisterBtn(){
        press(RegistrationLocators.REGISTER_BTN.get());
    }

    public void pressNextBtn(){
        press(CommonLocators.BUTTON_BY_TEXT.getWithParams("Next"));
    }

    public void inputPassword(String password){
        inputText(RegistrationLocators.TEXT_INPUT.getWithParams("password"), password);
    }

    public void inputFullName(String fullName){
        inputText(RegistrationLocators.TEXT_INPUT.getWithParams("fullName"), fullName);
    }

    public void inputCompanyName(String companyName){
        inputText(RegistrationLocators.COMPANY_NAME_INPUT.get(), companyName);
        waitForElement(RegistrationLocators.COMPANY_NAME_AUTOCOMPLETE_OPTION.get());
        press(RegistrationLocators.COMPANY_NAME_AUTOCOMPLETE_OPTION.get());
        press(RegistrationLocators.ONBOARD_CONTENT.get());
    }

    public void selectAccountGoal(String goal){
        press(RegistrationLocators.ACCOUNT_GOAL_OPTION.getWithParams(goal));
    }

    public void selectReferralSource(String referral){
        if (!isComponentPresent(RegistrationLocators.REFERRAL_SELECT_MENU.get())){
            pressAndWaitForElement(RegistrationLocators.REFERRAL_SELECT_ARROW.get(), RegistrationLocators.REFERRAL_SELECT_MENU.get());
        }
       press(RegistrationLocators.REFERRAL_SELECT_OPTION.getWithParams(referral));
    }

    public void acceptAgreement(){
        press(RegistrationLocators.AGREEMENT_CHECKBOX.get());
        press(CommonLocators.BUTTON_BY_TEXT.getWithParams("I accept"));
    }

}
