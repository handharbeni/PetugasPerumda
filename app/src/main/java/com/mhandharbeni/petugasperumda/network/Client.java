package com.mhandharbeni.petugasperumda.network;

import android.content.Context;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.mhandharbeni.petugasperumda.utils.Constant;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static final String BASE_URL = Constant.BASE_URL;
    private static Context context;
    private static OkHttpClient builderOkHttp = new OkHttpClient.Builder()
            .addNetworkInterceptor(new StethoInterceptor())
            .addInterceptor(chain -> {
                Request request = chain.request()
                        .newBuilder()
                        .build();
                return chain.proceed(request);
            })
            .build();
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(builderOkHttp)
            .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = builder.build();
    private static volatile Object instances;
    public static <T> T getInstance(Context contexts, Class<T> type) {
        context = contexts;
        synchronized (Client.class){
            instances = retrofit.create(type);
        }
        return (T) Client.instances;
    }
}
