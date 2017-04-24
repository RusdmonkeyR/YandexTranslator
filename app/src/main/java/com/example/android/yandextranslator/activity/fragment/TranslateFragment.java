package com.example.android.yandextranslator.activity.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.android.yandextranslator.R;
import com.example.android.yandextranslator.activity.services.SaveLanguagesInterface;
import com.example.android.yandextranslator.activity.services.Service;
import com.google.inject.Inject;

import org.w3c.dom.Text;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by ruslan on 4/24/17.
 */

public class TranslateFragment extends RoboFragment {

    @Inject
    Service service;

    @InjectView(R.id.editText_word)
    EditText translateWord;

    @InjectView(R.id.text_translate)
    TextView textTranslate;

    @InjectView(R.id.button_translate)
    Button translateButton;

    @InjectView(R.id.imageButton)
    ImageButton saveFavorite;


    @Inject
    SaveLanguagesInterface saveLanguagesInterface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.translate_fragment,container,false);

    }

    @Override
    public void onResume() {
        super.onResume();
        translateButton.setOnClickListener(view -> {

            String word = translateWord.getText().toString().trim();
            service.getWordNoDictionary(saveLanguagesInterface.getFirstLanguage()+"-"+saveLanguagesInterface.getSecondLanguge(),word)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .unsubscribeOn(Schedulers.io())
                    .subscribe(wordNoDictionary -> {
                        textTranslate.setText(wordNoDictionary.getText().get(0));
                        saveFavorite.setVisibility(View.VISIBLE);
                    },throwable -> {
                        Log.e("TAG",throwable.getCause()+" "+throwable.getMessage()+" ");
                    });
        });


    }
}
