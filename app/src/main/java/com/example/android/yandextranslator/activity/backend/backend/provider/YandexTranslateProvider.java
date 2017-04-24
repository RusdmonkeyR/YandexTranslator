package com.example.android.yandextranslator.activity.backend.backend.provider;

import com.example.android.yandextranslator.activity.backend.backend.YandexTranslateApi;

import com.example.android.yandextranslator.activity.services.Settings;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ruslan on 4/23/17.
 */

@Singleton
public class YandexTranslateProvider implements Provider<YandexTranslateApi> {
    public static final int TIMEOUT = 1;
    public static boolean inTestMode = false;

    private static final String CONFIG_FILE = "application.properties";
    private static final String TEST_API_URL = "test.api.url";
    private static final String API_URL = "api.url";
    private static final String APP_SECRET = "app.secret";

    @Inject
    private Settings settings;
    @Override
    public YandexTranslateApi get() {
        OkHttpClient client = new OkHttpClient();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getEndpoint())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit.create(YandexTranslateApi.class);
    }

    private String getEndpoint() {
        if (inTestMode) {
            String testEndpoint = settings.getProperty(TEST_API_URL);
            if (!testEndpoint.isEmpty()) {
                return testEndpoint;
            }
        }

        String endpoint = settings.getProperty(API_URL);
        if (endpoint.isEmpty()) {
            throw new IllegalArgumentException(API_URL + " is empty or not defined in " + CONFIG_FILE);
        }

        return endpoint;
    }



}
