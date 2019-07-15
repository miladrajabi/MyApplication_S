package com.example.myapplication.Episodes;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.app.app;
import com.example.myapplication.app.db;
import com.example.myapplication.app.dbConnector;

public class SQliteUpdateActivity extends AppCompatActivity implements View.OnClickListener {

    TextView updateName, updateMessage;

    AppCompatImageView updateDelete, updateEdit, updateBack;
    int id = -1;
    dbConnector dbConnector;

    Boolean updateList = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_update);
        setTitle(this.getClass().getSimpleName());
        updateList = true;
        init();
    }

    private void init() {
        updateName = findViewById(R.id.updateName);
        updateMessage = findViewById(R.id.updateMessage);
        updateDelete = findViewById(R.id.updateDelete);
        updateEdit = findViewById(R.id.updateEdit);
        updateBack = findViewById(R.id.updateBack);

        updateBack.setOnClickListener(this);
        updateEdit.setOnClickListener(this);
        updateDelete.setOnClickListener(this);
        dbConnector = new dbConnector(this, app.main.DbName, null, app.main.DbVersion);

        readData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.updateBack: {
                finish();
                return;
            }
            case R.id.updateDelete: {
                delete(id);
                break;
            }
            case R.id.updateEdit: {
                Intent intent = new Intent(SQliteUpdateActivity.this, SQLiteInsertActivity.class);
                intent.putExtra(SQLiteInsertActivity.ACTION_KEY, SQLiteInsertActivity.ACTION_EDIT);
                intent.putExtra(db.tbNotes.ID, id);
                startActivity(intent);
                break;
            }
        }
    }

    private void delete(final int id) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Confirm");
        builder.setMessage("Are you sure?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dbConnector.get().delete(db.tables.tbNotes, db.tbNotes.ID + " = " + id, null);

                /*rawQuery("DELETE FROM " + db.tables.tbNotes + " Where " + db.tbNotes.ID + " = " + id, null);*/
                app.toas("Note Removed");
                finish();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void readData() {
        if (getIntent().hasExtra(db.tbNotes.ID)) {

            id = getIntent().getIntExtra(db.tbNotes.ID, 0);
            Cursor c = dbConnector.get().rawQuery("select * from " + db.tables.tbNotes + " Where " + db.tbNotes.ID + " = " + id, null);

            while (c.moveToNext()) {
                String fullName = c.getString(c.getColumnIndex(db.tbNotes.FirstName)) + " " + c.getString(c.getColumnIndex(db.tbNotes.LastName));

                updateName.setText(fullName);
                updateMessage.setText(c.getString(c.getColumnIndex(db.tbNotes.Message)));

            }
        }
    }

    @Override
    protected void onResume() {
        if (updateList) {
            readData();
        }

        super.onResume();
    }
}
