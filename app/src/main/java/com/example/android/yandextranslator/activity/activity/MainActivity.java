package com.example.android.yandextranslator.activity.activity;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.android.yandextranslator.R;
import com.example.android.yandextranslator.activity.data.Constants;
import com.example.android.yandextranslator.activity.fragment.FavoritWordsFragment;
import com.example.android.yandextranslator.activity.fragment.DetailsFragment;
import com.example.android.yandextranslator.activity.fragment.TranslateFragment;
import com.example.android.yandextranslator.activity.services.SaveLanguagesInterface;
import com.google.inject.Inject;

import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActionBarActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Constants constants = new Constants();

    @Inject
    SaveLanguagesInterface saveLanguagesInterface;

    @InjectView(R.id.bottom_navigation)
    private BottomNavigationView bottomNavigation;

    @InjectView(R.id.text_first_language)
    private TextView textFirstLanguage;

    @InjectView(R.id.text_second_language)
    private TextView textSecondLanguage;
    private Fragment fragment = new TranslateFragment();
    private FragmentManager fragmentManager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragmentManager = getSupportFragmentManager();
        bottomNavigation.inflateMenu(R.menu.menu);
        bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            switch (id) {
                case R.id.action_translate:
                    fragment = new TranslateFragment();
                    break;
                case R.id.action_cart:
                    fragment = new FavoritWordsFragment();
                    break;
                case R.id.action_hot_deals:
                    fragment = new DetailsFragment();
                    break;
            }
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_container, fragment).commit();
            return true;
        });

        textFirstLanguage.setOnClickListener(view -> setFirstLanguage());
        textSecondLanguage.setOnClickListener(view -> setSecondLanguage());
    }



    public void setFirstLanguage(){
        new MaterialDialog.Builder(this)
                .title(R.string.title)
                .items(R.array.languages)
                .itemsCallbackSingleChoice(-1, (dialog, view, which, text) -> {
                    /**
                     * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                     * returning false here won't allow the newly selected radio button to actually be selected.
                     **/
                    saveLanguagesInterface.saveFirstLanguages(constants.getMap().get(text.toString()));
                    textFirstLanguage.setText(text.toString());
                    return true;
                })
                .positiveText(R.string.choose)
                .show();


    }

    private void setSecondLanguage(){
        new MaterialDialog.Builder(this)
                .title(R.string.title)
                .items(R.array.languages)
                .itemsCallbackSingleChoice(-1, (dialog, view, which, text) -> {
                    /**
                     * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                     * returning false here won't allow the newly selected radio button to actually be selected.
                     **/
                    saveLanguagesInterface.saveSecondLanguages(constants.getMap().get(text.toString()));
                    textSecondLanguage.setText(text.toString());
                    return true;
                })
                .positiveText(R.string.choose)
                .show();


    }
}