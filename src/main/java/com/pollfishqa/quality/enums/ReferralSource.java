package com.pollfishqa.quality.enums;

public enum ReferralSource {
    VIDEO("Video"),
    CONFERENCE("Conference"),
    GOOGLE("Google"),
    FRIEND("Friend / Colleague"),
    LINKEDIN("LinkedIn"),
    AD("Advertisement"),
    OTHER("Other")
    ;
    private String myOption;

    ReferralSource(String option){
        myOption = option;
    }

    public String getReferralSource()  {
        return myOption;
    }
}
