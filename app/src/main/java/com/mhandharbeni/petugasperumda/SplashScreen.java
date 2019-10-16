package com.mhandharbeni.petugasperumda;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mhandharbeni.petugasperumda.network.Client;
import com.mhandharbeni.petugasperumda.network.InterfaceService;
import com.mhandharbeni.petugasperumda.preferences.AppPreferences;
import com.mhandharbeni.petugasperumda.room.entity.ResponseData;
import com.mhandharbeni.petugasperumda.room.entity.data.DataToken;
import com.mhandharbeni.petugasperumda.utils.ConstantSession;
import com.mhandharbeni.petugasperumda.utils.helper.GeneralHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {
    InterfaceService interfaceService;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        interfaceService = Client.getInstance(getApplicationContext(), InterfaceService.class);
        setContentView(R.layout.splash_screen);

        getSupportActionBar().hide();

        if (AppPreferences.getInstance(getApplicationContext()).getPref(ConstantSession.SESSION_TOKEN, "").equalsIgnoreCase("")){
            initToken();
        }else{
            nextActivity();
        }
    }

    private void initToken(){
        interfaceService.cToken(GeneralHelper.getDeviceId(getApplicationContext()))
                .enqueue(new Callback<ResponseData<DataToken>>() {
                    @Override
                    public void onResponse(Call<ResponseData<DataToken>> call, Response<ResponseData<DataToken>> response) {
                        if (response.isSuccessful()){
                            if (response.body().getCode().equalsIgnoreCase("200")){
                                AppPreferences.getInstance(getApplicationContext()).setPref(ConstantSession.SESSION_TOKEN, response.body().getData().getToken());
                                AppPreferences.getInstance(getApplicationContext()).setPref(ConstantSession.SESSION_DEVICEID, response.body().getData().getDeviceId());
                            }
                        }
                        nextActivity();
                    }

                    @Override
                    public void onFailure(Call<ResponseData<DataToken>> call, Throwable t) {
                        nextActivity();
                    }
                });
    }

    private void nextActivity(){
        new Handler().postDelayed(() -> {
            if (AppPreferences.getInstance(getApplicationContext()).getPref(ConstantSession.IS_LOGIN, false)){
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }else{
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        }, 2000);
    }
}
