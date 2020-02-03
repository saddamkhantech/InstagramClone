package com.example.instagramclone;

import android.app.Application;
import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("mzg8NSPrfbLCDxnw3if1WUWGPQbeFr7CcjSmkgbI")
                // if defined
                .clientKey("RVamt8PkqHh3q3vv3e39mKegNISTV5Sif3Y4E5cO")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
