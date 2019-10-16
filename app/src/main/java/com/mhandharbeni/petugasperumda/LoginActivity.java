package com.mhandharbeni.petugasperumda;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.mhandharbeni.petugasperumda.network.Client;
import com.mhandharbeni.petugasperumda.network.InterfaceService;
import com.mhandharbeni.petugasperumda.preferences.AppPreferences;
import com.mhandharbeni.petugasperumda.room.entity.ResponseData;
import com.mhandharbeni.petugasperumda.utils.BaseActivity;
import com.mhandharbeni.petugasperumda.utils.ConstantSession;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {
    InterfaceService interfaceService;

    @BindView(R.id.np)
    EditText np;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.btn_login)
    AppCompatButton btn_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestPermission();
        interfaceService = Client.getInstance(getApplicationContext(), InterfaceService.class);
        hideActionBar();
        setContentView(R.layout.login_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void click(){
        Call<ResponseData> login = interfaceService.login(np.getText().toString(), password.getText().toString());
        login.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if (response.isSuccessful()){
                    if (response.body().getCode().equalsIgnoreCase("200")){
                        AppPreferences.getInstance(getApplicationContext()).setPref(ConstantSession.IS_LOGIN, true);
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "Username / Password Salah", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Username / Password Salah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Username / Password Salah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
