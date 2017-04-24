package com.example.android.yandextranslator.activity.backend.backend.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ruslan on 4/23/17.
 */

public class WordNoDictionary {
    @SerializedName("text")
    private ArrayList<String> text;


    public ArrayList<String> getText() {
        return text;
    }

    public void setText(ArrayList<String> text) {
        this.text = text;
    }
}
