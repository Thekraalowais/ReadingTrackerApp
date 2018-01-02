package com.example.thekra.readingtrackerapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.thekra.readingtrackerapp.Contract.ReadingEntry;


public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Reading.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = "CREATE TABLE " + ReadingEntry.TABLE_NAME + " ("
                + ReadingEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ReadingEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + ReadingEntry.COLUMN_PAGE + " INTEGER NOT NULL, "
                + ReadingEntry.COLUMN_RATING + " INTEGER NOT NULL );";
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
