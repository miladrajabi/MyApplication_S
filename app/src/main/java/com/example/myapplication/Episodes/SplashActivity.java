package com.example.myapplication.Episodes;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.myapplication.R;
import com.example.myapplication.adapter.MyDbAdapter;
import com.example.myapplication.app.app;
import com.example.myapplication.app.db;
import com.example.myapplication.app.dbConnector;
import com.example.myapplication.objects.MyDbObject;

import java.util.ArrayList;
import java.util.List;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    dbConnector dbConnector;
    FloatingActionButton fabAdd;
    RecyclerView rclViewMyDb;
    List<MyDbObject> objects;
    MyDbAdapter adapter;
    boolean updateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setTitle(this.getClass().getSimpleName());
        // SQLiteStudioService.instance().start(this);

        init();
    }

    private void init() {
        dbConnector = new dbConnector(this, app.main.DbName, null, app.main.DbVersion);

        fabAdd = findViewById(R.id.fabAdd);
        rclViewMyDb = findViewById(R.id.rclViewMyDb);
        rclViewMyDb.setLayoutManager(new LinearLayoutManager(this));
        rclViewMyDb.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)));

        objects = readData();
        adapter = new MyDbAdapter(this, objects, dbConnector);
        rclViewMyDb.setAdapter(adapter);
        updateList = true;
        fabAdd.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {

        SQLiteStudioService.instance().stop();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v == fabAdd) {
            Intent intent = new Intent(SplashActivity.this, SQLiteInsertActivity.class);
            intent.putExtra(SQLiteInsertActivity.ACTION_KEY, SQLiteInsertActivity.ACTION_INSERT);
            intent.putExtra(db.tbNotes.ID, -1);
            startActivity(intent);
        }
    }

    private List<MyDbObject> readData() {

        List<MyDbObject> myList = new ArrayList<>();
        Cursor c = dbConnector.get().rawQuery("Select * From " + db.tables.tbNotes, null);
        while (c.moveToNext()) {
            String fullName = c.getString(c.getColumnIndex(db.tbNotes.FirstName)) + " " + c.getString(c.getColumnIndex(db.tbNotes.LastName));

            int id = c.getInt(c.getColumnIndex(db.tbNotes.ID));
            String msg = c.getString(c.getColumnIndex(db.tbNotes.Message));
            int seen = c.getInt(c.getColumnIndex(db.tbNotes.SEEN));
            MyDbObject obj = new MyDbObject();
            obj.setMessage(msg);
            obj.setId(id);
            obj.setSeen(seen);
            obj.setName(fullName);

            myList.add(obj);
        }
        c.close();
        return myList;
    }

    @Override
    protected void onResume() {
        if (updateList) {
            objects.clear();
            objects.addAll(readData());
            adapter.notifyDataSetChanged();
        }
        super.onResume();

    }
}
