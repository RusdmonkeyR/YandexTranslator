package com.example.android.yandextranslator.activity.services.implementation;

import com.example.android.yandextranslator.activity.backend.backend.YandexTranslateApi;
import com.example.android.yandextranslator.activity.backend.backend.dto.WordNoDictionary;
import com.example.android.yandextranslator.activity.services.Service;
import com.google.inject.Inject;

import rx.Observable;

/**
 * Created by ruslan on 4/23/17.
 */

public class ServiceImplementation implements Service{

    @Inject
    YandexTranslateApi yandexTranslateApi;

    private final String key = "trnsl.1.1.20170423T125303Z.0c107a2e31232662.ef926177db74cc148f4dc3878aa6ecda211e509b";

    @Override
    public Observable<WordNoDictionary> getWordNoDictionary(String lang, String text) {
        return yandexTranslateApi.getWordWithoutDictionary(lang,text,key);
    }
}
