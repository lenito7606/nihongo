package com.lennin.aniceto.nihongonaraimashou;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lenni on 15/09/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="nihongo.db";
    public static final String TABLE_NAME="users";
    public static final String TABLE_SCORES="scores";
    public static final String COL_ID="ID";
    public static final String COL_UNAME="username";
    public static final String COL_FNAME="fname";
    public static final String COL_LNAME="lname";
    public static final String COL_EMAIL="email";
    public static final String COL_SCORE="score";
    public static final String COL_LESSONNUM="lessonnum";
    public static final String COL_CATEGORY="examcategory";
    public static final String COL_ITEMS="items";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID integer primary key autoincrement, username text, fname text, lname text, email text)");
        db.execSQL("create table " + TABLE_SCORES + "(ID integer primary key autoincrement, username text, lessonnum text, examcategory text, score text, items text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_SCORES);
        onCreate(db);

    }
}
