package com.mhandharbeni.petugasperumda.utils.helper;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.provider.Settings;
import android.widget.Toast;

import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class GeneralHelper{
    public static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("HardwareIds")
    public static String getDeviceId(Context context){
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static boolean isMyServiceRunning(Context context, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (manager != null) {
            for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
                if (serviceClass.getName().equals(service.service.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }
    public static OneTimeWorkRequest buildRequest(Class<? extends ListenableWorker> worker, String tag){
        return new OneTimeWorkRequest.Builder(worker).addTag(tag).build();
    }

    public static void enqueueWorker(String tag, OneTimeWorkRequest workRequest){
        WorkManager.getInstance().enqueueUniqueWork(tag, ExistingWorkPolicy.REPLACE, workRequest);
    }
}
