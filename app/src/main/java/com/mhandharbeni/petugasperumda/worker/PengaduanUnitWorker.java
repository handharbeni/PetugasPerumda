package com.mhandharbeni.petugasperumda.worker;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.mhandharbeni.petugasperumda.network.Client;
import com.mhandharbeni.petugasperumda.network.InterfaceService;
import com.mhandharbeni.petugasperumda.preferences.AppPreferences;
import com.mhandharbeni.petugasperumda.room.db.AppDb;
import com.mhandharbeni.petugasperumda.room.entity.ResponseList;
import com.mhandharbeni.petugasperumda.room.entity.data.ListPengaduanUnit;
import com.mhandharbeni.petugasperumda.utils.ConstantSession;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PengaduanUnitWorker extends Worker {
    public PengaduanUnitWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        InterfaceService interfaceService = Client.getInstance(getApplicationContext(), InterfaceService.class);
        interfaceService.getListPengaduanUnit(
                AppPreferences.getInstance(getApplicationContext()).getPref(ConstantSession.SESSION_TOKEN, ""),
                AppPreferences.getInstance(getApplicationContext()).getPref(ConstantSession.SESSION_KDUNIT, "")
        ).enqueue(new Callback<ResponseList<ListPengaduanUnit>>() {
            @Override
            public void onResponse(Call<ResponseList<ListPengaduanUnit>> call, Response<ResponseList<ListPengaduanUnit>> response) {
                if (response.isSuccessful()){
                    if (response.body().getCode().equalsIgnoreCase("200")){
                        AppDb.getInstance(getApplicationContext()).pengaduanUnit().insertAll(response.body().getData());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseList<ListPengaduanUnit>> call, Throwable t) {

            }
        });
        return Result.success();
    }
}