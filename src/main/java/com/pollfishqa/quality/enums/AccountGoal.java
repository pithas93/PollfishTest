package com.pollfishqa.quality.enums;

public enum AccountGoal {
    BUY_SURVEY_RESPONSES("Buy survey responses from Pollfish audience"),
    SEND_SURVEY("Send a survey to my own list"),
    PAID_BY_SURVEY("Get paid to take surveys");

    private String myOption;

    AccountGoal(String option){
        myOption = option;
    }

    public String getAccountGoal()  {
        return myOption;
}
}
