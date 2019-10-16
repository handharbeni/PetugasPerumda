package com.mhandharbeni.petugasperumda.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.provider.Settings;

import com.facebook.stetho.Stetho;

public class CoreApplication extends Application {
    public static Context context;
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
//        Fabric.with(this, new Crashlytics());
        Stetho.initializeWithDefaults(this);
//        startWorker();
    }

    @SuppressLint("HardwareIds")
    public static String getDeviceId(){
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }


//    private void startWorker(){
//        PeriodicWorkRequest unitPeriodic = new PeriodicWorkRequest.Builder(UnitWorker.class, 20, TimeUnit.MINUTES).addTag("UnitWorker").build();
//        PeriodicWorkRequest loketPeriodic = new PeriodicWorkRequest.Builder(LoketWorker.class, 20, TimeUnit.MINUTES).addTag("LoketWorker").build();
//        WorkManager.getInstance()
//                .enqueueUniquePeriodicWork("UnitWorker", ExistingPeriodicWorkPolicy.KEEP, unitPeriodic);
//        WorkManager.getInstance()
//                .enqueueUniquePeriodicWork("LoketWorker", ExistingPeriodicWorkPolicy.KEEP, loketPeriodic);
//
//    }
}
