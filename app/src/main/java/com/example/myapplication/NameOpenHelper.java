package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class NameOpenHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "NameDB";
    private static int DATABASE_VERSION = 1;

    public NameOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE name (_id INTEGER PRIMARY KEY,vorname VARCHAR(255), nachname " +
                           "VARCHAR(255));");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d(NameOpenHelper.class.getSimpleName(), "Upgrades werden nicht unterstützt");

    }

    public void insert(String vorname, String nachname) {

        ContentValues values = new ContentValues();
        values.put("vorname", String.valueOf(vorname));
        values.put("nachname", String.valueOf(nachname));
        long rowId = getWritableDatabase().insert("name", null, values);
        Log.d(NameOpenHelper.class.getSimpleName(), "insert: " + rowId);

    }


    public int selectTheSumOfEntries() {

        int amount;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select count(_id) from name ;", null);
        if (cursor.moveToFirst())
            amount = cursor.getInt(0);
        else
            amount = -1;
        cursor.close();

        return amount;
    }


    public Cursor selectAll() {

        return getWritableDatabase().query("name", null, null, null, null, null, null);
    }

}
