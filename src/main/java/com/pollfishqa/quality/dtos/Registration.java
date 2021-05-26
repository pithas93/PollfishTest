package com.pollfishqa.quality.dtos;

import com.pollfishqa.quality.enums.AccountGoal;
import com.pollfishqa.quality.enums.ReferralSource;

public class Registration {
    String companyEmail;
    String password;

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public AccountGoal getAccountGoal() {
        return accountGoal;
    }

    public void setAccountGoal(AccountGoal accountGoal) {
        this.accountGoal = accountGoal;
    }

    public ReferralSource getReferralSource() {
        return referralSource;
    }

    public void setReferralSource(ReferralSource referralSource) {
        this.referralSource = referralSource;
    }

    String fullName;
    String companyName;
    AccountGoal accountGoal;
    ReferralSource referralSource;
}
