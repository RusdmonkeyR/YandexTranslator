package com.example.android.yandextranslator.activity.data;

import io.realm.RealmObject;

/**
 * Created by ruslan on 4/24/17.
 */

public class TranslatedWord extends RealmObject{
    private String word;
    private String lang;
    private boolean isFavorite;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
