package com.example.kamrul.studentlistproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kamrul on 3/17/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    static final int DATABASE_VERTION=1;
    static final String DATABASE_NAME="studentListManager";
    static final String COL_ID="id";
    static final String COL_NAME="name";
    static final String COL_EMAIL="email";
    static final String COL_PHONE="phone";
    static final String COL_ADDRESS="address";
    static final String COL_PASSWORD="password";
    static final String COL_IMGID="imageId";
    static final String TABLE_NAME="student_information";
    String CREATE_TABLE_STUDENT=" CREATE TABLE "+TABLE_NAME+
            " ( "+COL_ID+" INTEGER PRIMARY KEY,"+COL_NAME+" TEXT,"+
            COL_EMAIL+" TEXT,"+COL_PHONE+" TEXT,"+COL_ADDRESS+" TEXT,"+
            COL_PASSWORD+" TEXT,"+
            COL_IMGID+" INTEGER )";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERTION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
