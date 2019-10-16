package com.mhandharbeni.petugasperumda;

import android.os.Bundle;

import com.mhandharbeni.petugasperumda.utils.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestPermission();
        hideActionBar();
        setContentView(R.layout.activity_main);
    }
}
