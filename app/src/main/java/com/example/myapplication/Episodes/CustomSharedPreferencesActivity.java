package com.example.myapplication.Episodes;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.myapplication.R;
import com.example.myapplication.app.spRef;
import com.example.myapplication.app.app;
import com.madrapps.pikolo.HSLColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

public class CustomSharedPreferencesActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout parentLy;
    HSLColorPicker colorPicker;
    EditText txtFirstName, txtLstName;
    Button btnLogin;
    CheckBox chkStayLogin;
    int color = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_shared_preferences);
        init();
    }

    private void init() {
        parentLy = findViewById(R.id.parentLy);
        txtFirstName = findViewById(R.id.txtFirstName);
        txtLstName = findViewById(R.id.txtLstName);
        btnLogin = findViewById(R.id.btnLogin);
        chkStayLogin = findViewById(R.id.chkStayLogin);

        btnLogin.setOnClickListener(this);

        color = getResources().getColor(R.color.chatBG);

        colorPicker = findViewById(R.id.colorPicker);
        colorPicker.setColorSelectionListener(new SimpleColorSelectionListener() {
            @Override
            public void onColorSelected(int color) {
                CustomSharedPreferencesActivity.this.color = color;
                parentLy.setBackgroundColor(color);
            }
        });
    }

    @Override
    public void onClick(View v) {

        if (v == btnLogin) {
            spRef.getSharedPreferences(spRef.tagse.MyApp).edit()
                    .putString(spRef.Form.FIRSTNMAE, txtFirstName.getText().toString())
                    .putString(spRef.Form.lastName, txtLstName.getText().toString())
                    .putBoolean(spRef.Form.STAY_LOGIN, chkStayLogin.isChecked())
                    .putInt(spRef.Form.PAGE_BACKGROUND, color)
                    .apply();
            app.toas("Data Stored");

        } else {
            app.toas("Data not Stored");
        }
    }
}
