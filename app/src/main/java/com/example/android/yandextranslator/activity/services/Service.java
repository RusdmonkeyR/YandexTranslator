package com.example.android.yandextranslator.activity.services;

import com.example.android.yandextranslator.activity.backend.backend.dto.WordNoDictionary;

import rx.Observable;

/**
 * Created by ruslan on 4/24/17.
 */

public interface Service {
    Observable<WordNoDictionary> getWordNoDictionary(String lang,String text);
}
