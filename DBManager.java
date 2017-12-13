package com.example.liangminglin.mytab;

import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.*;
import android.util.Log;

import java.util.*;
/**
 * Created by liangminglin on 11/30/17.
 */

public class DBManager extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "myWaytor.db";

    private static final String TABLE_NAME = "tempData";

    private static final String KEY_NAME = "NAME";

    private static final String KEY_VALUE = "VALUE";

    private static final String KEY_NUM = "NUMBER";

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tempData (NAME text not null, VALUE text not null, NUMBER text not null)");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insert(order tes) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, tes.getFoodName());
        values.put(KEY_NUM, tes.getFoodPrice());
        values.put(KEY_VALUE, tes.getAmount());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public Cursor getAllData() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        if (res != null) {
            res.moveToFirst();
        }
        return res;
    }
}
