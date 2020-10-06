package com.romilpant.listallapps;

import android.graphics.drawable.Drawable;

public class AppList {
    Drawable appIcon;
    private String appName;
    private String appPackage;

    public AppList(Drawable appIcon, String appName, String appPackage) {
        this.appIcon = appIcon;
        this.appName = appName;
        this.appPackage = appPackage;
    }

    public Drawable getAppIcon(){
        return appIcon;
    }

    public String getAppName(){
        return appName;
    }

    public String getAppPackage() {
        return appPackage;
    }
}
