package com.example.android.yandextranslator.activity.services;



/**
 * Created by ruslan on 4/24/17.
 */

public interface SaveLanguagesInterface {
    void saveFirstLanguages(String first);

    void saveSecondLanguages(String second);

    void setDefaultLanguages();

    String  getFirstLanguage();

    String getSecondLanguge();

    void changeLanguages(String first, String second);

}
