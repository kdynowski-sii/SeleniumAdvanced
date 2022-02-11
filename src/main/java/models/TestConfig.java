package models;

import enums.Browser;

import java.util.Random;

public class TestConfig {
    private Browser browser;

    public String getUrl() {
        return url;
    }

    private String url;

    public Browser getBrowser() {
        return browser;
    }

    public void switchBrowser(){
        int browserID = new Random().nextInt(3);
        switch (browserID){
            case 0:
                browser = Browser.CHROME;
                break;
            case 1:
                browser = Browser.EDGE;
                break;
            case 2:
                browser = Browser.FIREFOX;
        }
    }
}
