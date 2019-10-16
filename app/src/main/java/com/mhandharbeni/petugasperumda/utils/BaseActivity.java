package com.mhandharbeni.petugasperumda.utils;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.mhandharbeni.petugasperumda.service.MainService;
import com.mhandharbeni.petugasperumda.utils.helper.GeneralHelper;

import java.util.List;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startServices();
    }

    private void startServices(){
        Intent i = new Intent(getApplicationContext(), MainService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            i.setAction(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
        }
        if (!GeneralHelper.isMyServiceRunning(getApplicationContext(), MainService.class)){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                ContextCompat.startForegroundService(getApplicationContext(), i);
            }else{
                startService(i);
            }
        }
    }

    public boolean requestPermission(){
        final boolean[] isAllowed = {false};
        Dexter.withActivity(this)
                .withPermissions(Constant.listPermission)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()){
                            isAllowed[0] = true;
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                        isAllowed[0] = false;
                    }
                })
                .onSameThread()
                .check();
        return isAllowed[0];
    }

    public void hideActionBar(){
        getSupportActionBar().hide();
    }
}
