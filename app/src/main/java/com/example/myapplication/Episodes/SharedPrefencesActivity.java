package com.example.myapplication.Episodes;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class SharedPrefencesActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtName, txtLastName;
    Button btnSave;
    CheckBox chkStay;
    TextView tvClear;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefences);
        init();
    }

    private void init() {
        txtName = findViewById(R.id.txtName);
        txtLastName = findViewById(R.id.txtLastName);
        btnSave = findViewById(R.id.btnSave);
        chkStay = findViewById(R.id.chkStay);
        tvClear = findViewById(R.id.tvClear);

        btnSave.setOnClickListener(this);
        tvClear.setOnClickListener(this);

        sharedPreferences = getSharedPreferences("ShPr", MODE_PRIVATE);

        restoreData();
    }

    @Override
    public void onClick(View v) {

        if (v == btnSave) {
            sharedPreferences.edit().putString("FirstName", txtName.getText().toString()).apply();
            sharedPreferences.edit().putString("LastName", txtLastName.getText().toString()).apply();
            sharedPreferences.edit().putBoolean("stayLogin", chkStay.isChecked()).apply();
        } else {
            sharedPreferences.edit().clear().apply();
        }
    }

    private void restoreData() {

        txtName.setText(sharedPreferences.getString("FirstName", ""));
        txtLastName.setText(sharedPreferences.getString("LastName", ""));
        chkStay.setChecked(sharedPreferences.getBoolean("stayLogin", false));
    }
}
