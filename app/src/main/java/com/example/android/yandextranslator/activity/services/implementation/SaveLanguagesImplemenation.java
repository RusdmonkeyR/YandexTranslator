package com.example.android.yandextranslator.activity.services.implementation;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.android.yandextranslator.activity.TranslateApplication;
import com.example.android.yandextranslator.activity.services.SaveLanguagesInterface;

/**
 * Created by ruslan on 4/24/17.
 */

public class SaveLanguagesImplemenation implements SaveLanguagesInterface {

    SharedPreferences preferences = PreferenceManager
            .getDefaultSharedPreferences(TranslateApplication.getInstance());
    private final String firstKey = "first_key";
    private final String secondKey = "second_key";

    @Override
    public void saveFirstLanguages(String first) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(firstKey,first);
        editor.apply();

    }

    @Override
    public void saveSecondLanguages(String second) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(secondKey,second);
        editor.apply();

    }

    @Override
    public void setDefaultLanguages() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(firstKey,"en");
        editor.putString(secondKey,"ru");
        editor.apply();

    }

    @Override
    public String getFirstLanguage() {
        return preferences.getString(firstKey,"en");
    }

    @Override
    public String getSecondLanguge() {
        return preferences.getString(secondKey,"ru");
    }

    @Override
    public void changeLanguages(String first, String second) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(firstKey,second);
        editor.putString(secondKey,second);
        editor.apply();
    }
}
