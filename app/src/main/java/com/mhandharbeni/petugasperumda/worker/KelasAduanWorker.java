package com.mhandharbeni.petugasperumda.worker;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.mhandharbeni.petugasperumda.network.Client;
import com.mhandharbeni.petugasperumda.network.InterfaceService;
import com.mhandharbeni.petugasperumda.room.db.AppDb;
import com.mhandharbeni.petugasperumda.room.entity.ResponseList;
import com.mhandharbeni.petugasperumda.room.entity.data.ListKelasAduan;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KelasAduanWorker extends Worker {
    public KelasAduanWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        InterfaceService interfaceService = Client.getInstance(getApplicationContext(), InterfaceService.class);
        interfaceService.getKelasAduan().enqueue(new Callback<ResponseList<ListKelasAduan>>() {
            @Override
            public void onResponse(Call<ResponseList<ListKelasAduan>> call, Response<ResponseList<ListKelasAduan>> response) {
                if (response.isSuccessful()){
                    if (response.body().getCode().equalsIgnoreCase("200")){
                        AppDb.getInstance(getApplicationContext()).kelasAduan().insertAll(response.body().getData());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseList<ListKelasAduan>> call, Throwable t) {

            }
        });
        return Result.success();
    }
}