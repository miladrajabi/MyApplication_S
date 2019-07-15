package com.example.myapplication.Episodes;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.app.app;
import com.example.myapplication.app.db;
import com.example.myapplication.app.dbConnector;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SQLiteInsertActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView imgBtnBack, imgBtnAdd;
    dbConnector database;
    EditText etFirstName, etLastName, etMessage;

    public static final int ACTION_INSERT = 1;
    public static final int ACTION_EDIT = 2;
    public static final String ACTION_KEY = "ACTION_KEY";

    private int action;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_insert);
        setTitle(this.getClass().getSimpleName());
        init();

    }

    private void init() {
        imgBtnBack = findViewById(R.id.imgBtnBack);
        imgBtnAdd = findViewById(R.id.imgBtnAdd);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etMessage = findViewById(R.id.etMessage);

        database = new dbConnector(this, null, null, 1);
        imgBtnBack.setOnClickListener(this);
        imgBtnAdd.setOnClickListener(this);
        if (getIntent().hasExtra(ACTION_KEY)) {
            int act = getIntent().getIntExtra(ACTION_KEY, 1);
            switch (act) {
                case ACTION_INSERT: {
                    action = act;
                    break;
                }
                case ACTION_EDIT: {
                    id = getIntent().getIntExtra(db.tbNotes.ID, -1);
                    prepareData();
                    action = act;
                    break;
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v == imgBtnBack) {
            finish();
        } else if (v == imgBtnAdd) {
            if (action == ACTION_INSERT) {
                insertData();
            } else if (action == ACTION_EDIT) {
                editData(id);

            }
        }

    }

    private void editData(int id) {
        if (TextUtils.isEmpty(etFirstName.getText().toString())) {
            app.toas("etFirstName is Null");
            return;
        }
        if (TextUtils.isEmpty(etLastName.getText().toString())) {
            app.toas("etLastName is Null");
            return;
        }
        if (TextUtils.isEmpty(etMessage.getText().toString())) {
            app.toas("etMessage is Null");
            return;
        }


        ContentValues values = new ContentValues();

        values.put(db.tbNotes.FirstName, etFirstName.getText().toString());
        values.put(db.tbNotes.LastName, etLastName.getText().toString());
        values.put(db.tbNotes.Message, etMessage.getText().toString());
        values.put(db.tbNotes.CreateDate, getDateTime());

        try {
            String where = db.tbNotes.ID + " = " + id;
            long updateId = database.get().update(db.tables.tbNotes, values, where, null);;
            app.toas("data inserted " + id);
            finish();
        } catch (SQLiteException e) {
            app.toas("Errod " + e.getMessage().toString());
        }

    }

    private void prepareData() {
        Cursor c = database.get().rawQuery("select * from " + db.tables.tbNotes + " Where " + db.tbNotes.ID + " = " + id, null);
        while (c.moveToNext()) {

            etFirstName.setText(c.getString(c.getColumnIndex(db.tbNotes.FirstName)));
            etLastName.setText(c.getString(c.getColumnIndex(db.tbNotes.LastName)));
            etMessage.setText(c.getString(c.getColumnIndex(db.tbNotes.Message)));
        }
        c.close();
    }

    private void insertData() {

        if (TextUtils.isEmpty(etFirstName.getText().toString())) {
            app.toas("etFirstName is Null");
            return;
        }
        if (TextUtils.isEmpty(etLastName.getText().toString())) {
            app.toas("etLastName is Null");
            return;
        }
        if (TextUtils.isEmpty(etMessage.getText().toString())) {
            app.toas("etMessage is Null");
            return;
        }


        ContentValues values = new ContentValues();

        values.put(db.tbNotes.FirstName, etFirstName.getText().toString());
        values.put(db.tbNotes.LastName, etLastName.getText().toString());
        values.put(db.tbNotes.Message, etMessage.getText().toString());
        values.put(db.tbNotes.CreateDate, getDateTime());

        try {
            long id = database.get().insert(db.tables.tbNotes, null, values);
            app.toas("data inserted " + id);
            finish();
        } catch (SQLiteException e) {
            app.toas("Errod " + e.getMessage().toString());
        }

    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
