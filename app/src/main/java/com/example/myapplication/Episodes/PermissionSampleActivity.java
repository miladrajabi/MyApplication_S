package com.example.myapplication.Episodes;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.app.app;

public class PermissionSampleActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPermission;
    TextView txtState;
    public static final int REQUEST_CODE = 115;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_sample);
        init();
        init();
    }

    private void init() {
        txtState = findViewById(R.id.txtState);
        btnPermission = findViewById(R.id.btnPermission);

        btnPermission.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnPermission) {
            if (checkPermission()) {
                myAction();
            }

        }
    }

    private void myAction() {
        txtState.setText(getString(R.string.Clicked));
    }

    private Boolean checkPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {

            int res = ContextCompat.checkSelfPermission(this, Manifest.permission.BROADCAST_SMS);
            if (res == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BROADCAST_SMS, Manifest.permission.READ_CONTACTS}, REQUEST_CODE);
            }
        } else {
            return true;
        }


        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    myAction();
                } else {
                    txtState.setText("Permission denied");

                }
                break;
            }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }
}
