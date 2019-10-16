package com.mhandharbeni.petugasperumda.worker;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.mhandharbeni.petugasperumda.network.Client;
import com.mhandharbeni.petugasperumda.network.InterfaceService;
import com.mhandharbeni.petugasperumda.preferences.AppPreferences;
import com.mhandharbeni.petugasperumda.room.entity.ResponseData;
import com.mhandharbeni.petugasperumda.room.entity.data.DataPegawai;
import com.mhandharbeni.petugasperumda.utils.ConstantSession;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataPegawaiWorker extends Worker {
    public DataPegawaiWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        InterfaceService interfaceService = Client.getInstance(getApplicationContext(), InterfaceService.class);
        interfaceService.getDataPegawai(
                AppPreferences.getInstance(getApplicationContext()).getPref(ConstantSession.SESSION_TOKEN, ""),
                AppPreferences.getInstance(getApplicationContext()).getPref(ConstantSession.SESSION_NP, "")
//                "9a3b2ebe5d48ff0916927a34a1d734e4661894ec6edb4cdd6d9dd3d5b1e5915bee642b9aba2432d907ee9141f29c124efc350b5f504d08cd4cd04ed9079be8fawC%2FyQxZtUvEL5NuC2ytVzuyJP%2B1a1vR8o5AqrSl%2BPN8%3D",
//                "8719825"
        ).enqueue(new Callback<ResponseData<DataPegawai>>() {
            @Override
            public void onResponse(Call<ResponseData<DataPegawai>> call, Response<ResponseData<DataPegawai>> response) {
                if (response.isSuccessful()){
                    if (response.body().getCode().equalsIgnoreCase("200")){
                        AppPreferences.getInstance(getApplicationContext()).setPref(ConstantSession.SESSION_NP, response.body().getData().getNp());
                        AppPreferences.getInstance(getApplicationContext()).setPref(ConstantSession.SESSION_NAMA, response.body().getData().getNama());
                        AppPreferences.getInstance(getApplicationContext()).setPref(ConstantSession.SESSION_ALAMAT, response.body().getData().getAlamat());
                        AppPreferences.getInstance(getApplicationContext()).setPref(ConstantSession.SESSION_TGLLAHIR, response.body().getData().getTgllahir());
                        AppPreferences.getInstance(getApplicationContext()).setPref(ConstantSession.SESSION_KDUNIT, response.body().getData().getKdunit());
                        AppPreferences.getInstance(getApplicationContext()).setPref(ConstantSession.SESSION_UNIT, response.body().getData().getUnit());
                        AppPreferences.getInstance(getApplicationContext()).setPref(ConstantSession.SESSION_KDBAGIAN, response.body().getData().getKdbagian());
                        AppPreferences.getInstance(getApplicationContext()).setPref(ConstantSession.SESSION_KDJABATAN, response.body().getData().getKdjabatan());
                        AppPreferences.getInstance(getApplicationContext()).setPref(ConstantSession.SESSION_JABATAN, response.body().getData().getJabatan());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseData<DataPegawai>> call, Throwable t) {
            }
        });
        return Result.success();
    }
}
