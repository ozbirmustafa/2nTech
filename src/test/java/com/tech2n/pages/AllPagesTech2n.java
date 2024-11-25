package com.tech2n.pages;

import org.openqa.selenium.support.PageFactory;

import static com.tech2n.stepDefinitions.Tech2nHooks.driver;

public class AllPagesTech2n {

    public AllPagesTech2n() {
        PageFactory.initElements(driver,this);
    }

    private PersonalInfoTab infoTab;
    private OtherInfoTab otherInfoTab;

    public PersonalInfoTab personalInfoTab(){
        if (infoTab == null){
            infoTab = new PersonalInfoTab();
        }
        return infoTab;
    }

    public OtherInfoTab otherInfoTab(){
        if (otherInfoTab == null){
            otherInfoTab = new OtherInfoTab();
        }
        return otherInfoTab;
    }

}
