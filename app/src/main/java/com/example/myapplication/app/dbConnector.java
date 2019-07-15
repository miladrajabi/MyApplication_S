package com.example.myapplication.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbConnector extends SQLiteOpenHelper {

    SQLiteDatabase database;

    public dbConnector(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, app.main.DbName, factory, app.main.DbVersion);
        this.createTables();
        app.log("db connector");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        app.log("on Create");
        this.database = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase get() {
        return this.getWritableDatabase();
    }

    private void createTables() {


        //this.get().execSQL("DROP TABLE IF EXISTS " + db.tables.tbNotes);

        String noteTable = " CREATE TABLE IF NOT EXISTS " +
                db.tables.tbNotes + " ( " +
                db.tbNotes.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                db.tbNotes.CreateDate + "  DATETIME  NOT NULL, " +
                db.tbNotes.Message + " VARCHAR (500), " +
                db.tbNotes.FirstName + "   VARCHAR (500) NOT NULL, " +
                db.tbNotes.LastName + "   VARCHAR (500) NOT NULL, " +
                db.tbNotes.SEEN + "  INTEGER DEFAULT(0)  " +
                ");";
        this.get().execSQL(noteTable);
    }
}
