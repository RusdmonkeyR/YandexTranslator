package com.example.android.yandextranslator.activity.module;

import com.example.android.yandextranslator.activity.backend.backend.YandexTranslateApi;
import com.example.android.yandextranslator.activity.backend.backend.provider.YandexTranslateProvider;
import com.google.inject.AbstractModule;

/**
 * Created by ruslan on 4/24/17.
 */

public class ApiModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(YandexTranslateApi.class).toProvider(YandexTranslateProvider.class);
    }
}
