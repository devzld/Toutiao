package com.zld.library.net;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lingdong on 2017/4/8.
 */

public class RetrofitManager {
    private static final int CONNECT_TIMEOUT = 10; //sec
    private static final int READ_TIMEOUT = 15; //sec
    private static final int WRITE_TIMEOUT = 15; //sec

    private static RetrofitManager INSTANCE;
    private OkHttpClient mOkHttpClient;
    private Retrofit mRetrofit;

    public static RetrofitManager getInstance(Context context) {
        synchronized (RetrofitManager.class) {
            if (INSTANCE == null) {
                INSTANCE = new RetrofitManager(context);
            }
            return INSTANCE;
        }
    }

    private RetrofitManager(Context ctxt) {
        setupOKHttpClient(ctxt);
        setupRetrofit();
    }

    private void setupOKHttpClient(Context ctxt) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    private void setupRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <T> T createService(Class<T> clazzOfService) {
        return mRetrofit.create(clazzOfService);
    }

}
