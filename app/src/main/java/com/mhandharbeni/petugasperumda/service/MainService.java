package com.mhandharbeni.petugasperumda.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.mhandharbeni.petugasperumda.MainActivity;
import com.mhandharbeni.petugasperumda.R;
import com.mhandharbeni.petugasperumda.preferences.AppPreferences;
import com.mhandharbeni.petugasperumda.utils.Constant;
import com.mhandharbeni.petugasperumda.utils.ConstantSession;
import com.mhandharbeni.petugasperumda.utils.helper.GeneralHelper;
import com.mhandharbeni.petugasperumda.utils.helper.NotificationHelper;
import com.mhandharbeni.petugasperumda.worker.DataPegawaiWorker;
import com.mhandharbeni.petugasperumda.worker.JenisAduanWorker;
import com.mhandharbeni.petugasperumda.worker.KelasAduanWorker;
import com.mhandharbeni.petugasperumda.worker.PegawaiUnitWorker;
import com.mhandharbeni.petugasperumda.worker.PengaduanUnitWorker;
import com.mhandharbeni.petugasperumda.worker.WOPetugasWorker;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MainService extends Service {
    private static NotificationCompat.Builder notifBuilder;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Log.d(TAG, "onStartCommand: MainService");
        loopingWorker();
        AppPreferences preferences = AppPreferences.getInstance(getApplicationContext());
        if (preferences.getPref(ConstantSession.IS_LOGIN, false)){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                notifBuilder =  NotificationHelper.createNotifications(getApplicationContext(), String.valueOf(Constant.NOTIF_MAINSERVICE), getString(R.string.app_name), "Network Is Connected", MainActivity.class, NotificationManager.IMPORTANCE_LOW);
            }else{
                notifBuilder =  NotificationHelper.createNotifications(getApplicationContext(), String.valueOf(Constant.NOTIF_MAINSERVICE), getString(R.string.app_name), "Network Is Connected", MainActivity.class);
            }
            startForeground(Constant.NOTIF_MAINSERVICE, notifBuilder.build());
        }else{
            NotificationHelper.removeAllNotification();
        }
        return START_STICKY;
    }

    private void loopingWorker(){
        Observable.timer(Constant.TIMER, Constant.TIMER_UNIT)
                .doOnEach(longNotification -> QueuWorkManager())
                .subscribeOn(Schedulers.newThread())
                .doOnCompleted(this::loopingWorker)
                .doOnError(throwable -> {})
                .subscribe();
    }

    public void QueuWorkManager(){
        for (Map.Entry<String, Class<? extends ListenableWorker>> data : Constant.mapWorker.entrySet()){
            GeneralHelper.enqueueWorker(data.getKey(), GeneralHelper.buildRequest(data.getValue(), data.getKey()));
        }
    }
}
