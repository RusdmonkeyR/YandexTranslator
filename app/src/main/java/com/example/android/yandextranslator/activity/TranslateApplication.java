package com.example.android.yandextranslator.activity;

import android.app.Application;

import com.example.android.yandextranslator.activity.module.ApiModule;
import com.example.android.yandextranslator.activity.module.ServiceModule;

import roboguice.RoboGuice;

/**
 * Created by ruslan on 4/23/17.
 */

public class TranslateApplication extends Application {
    private static final String TAG = TranslateApplication.class.getSimpleName();

    private static TranslateApplication instance = null;

    public static TranslateApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        RoboGuice.overrideApplicationInjector(this,
                RoboGuice.newDefaultRoboModule(this),
                new ServiceModule(), new ApiModule());
    }
}
