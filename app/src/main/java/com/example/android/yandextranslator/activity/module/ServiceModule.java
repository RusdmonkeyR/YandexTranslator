package com.example.android.yandextranslator.activity.module;

import com.example.android.yandextranslator.activity.services.SaveLanguagesInterface;
import com.example.android.yandextranslator.activity.services.Service;
import com.example.android.yandextranslator.activity.services.implementation.SaveLanguagesImplemenation;
import com.example.android.yandextranslator.activity.services.implementation.ServiceImplementation;
import com.google.inject.AbstractModule;

/**
 * Created by ruslan on 4/24/17.
 */

public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Service.class).to(ServiceImplementation.class);
        bind(SaveLanguagesInterface.class).to(SaveLanguagesImplemenation.class);
    }
}
