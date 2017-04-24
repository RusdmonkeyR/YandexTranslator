package com.example.android.yandextranslator.activity.backend.backend;

import com.example.android.yandextranslator.activity.backend.backend.dto.WordNoDictionary;

;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ruslan on 4/24/17.
 */

public interface YandexTranslateApi {
    @GET("/api/v1.5/tr.json/translate")
    Observable<WordNoDictionary> getWordWithoutDictionary(
            @Query("lang")String lang,
            @Query("text")String text,
            @Query("key")String key);
}
