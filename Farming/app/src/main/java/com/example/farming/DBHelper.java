package com.example.farming;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String table_name = "INFO";
    public static final String column_fullname = "FULLNAME";
    public static final String column_username = "USERNAME";
    public static final String column_email = "EMAIL";
    public static final String column_phone = "PHONE";
    public static final String column_password = "PASSWORD";

    public DBHelper(@Nullable Context context) {
        super(context, "users.db", null, 1);
    }

    // this is called first time a database is created
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+table_name+" ("+column_fullname+" TEXT, "+column_username+" TEXT, "+column_email+
                " TEXT, "+column_phone+" TEXT PRIMARY KEY, "+column_password+" TEXT)";
        db.execSQL(createTable);
    }

    // this is called if the database version number changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(db);
    }

    public boolean addUser(String fullname, String username, String email, String phone, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(column_fullname, fullname);
        cv.put(column_username, username);
        cv.put(column_email, email);
        cv.put(column_phone, phone);
        cv.put(column_password, password);
        long insert = db.insert(table_name, null, cv);
        db.close();
        if(insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean checkUser(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+table_name+" where "+column_username+" =?",new String[]{username});
        if(cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean checkPhone(String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+table_name+" where "+column_phone+" =?",new String[]{phone});
        if(cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+table_name+" where "+column_phone+" =?",new String[]{email});
        if(cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkUserPassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+table_name+" where "+column_username+" =? and "+column_password+" =?",new String[]{username,password});
        if(cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkeEmailAndPhone(String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+table_name+" where "+column_email+" =? and "+column_phone+" =?",new String[]{email,phone});
        if(cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean resetPassword(String password, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("update "+table_name+" set "+column_password+" =? where "+column_email+" =? and "+column_phone+" =?",new String[]{password,email,phone});
        if(cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}