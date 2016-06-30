package com.example.anil.databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anil on 27/06/16.
 */
public class StudentDataBase extends SQLiteOpenHelper {
 private static final String DB_NAME = "StudentDB";
    private static  final  int DB_VERSION = 2;
    StudentDataBase(Context context){
         super(context,DB_NAME,null,DB_VERSION);

     }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student (_id integer primary key autoincrement, " + " rollno text, "
                + "name text, "
                + "address text, "
                + "subject text );"


        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    void insertIntoStudentDb(SQLiteDatabase db, String roll, String name, String address, String subject){
        ContentValues kk = new ContentValues();
        kk.put("rollno", roll );
        kk.put("name", name);
        kk.put("address", address);
        kk.put("subject", subject);

        db.insert("student", null, kk);
    }
    Cursor findDeatils(SQLiteDatabase db, String roll){
        Cursor kk = db.query("student",new String [] {"_id", "rollno","name","address",
                "subject"},"rollno = ?",
                new String[]{roll},null,null,null);
        System.out.println(kk.getCount());
        return kk;
    }
    Cursor alldata(SQLiteDatabase db){
        Cursor kk = db.query("student",new String [] {"_id", "rollno","name","address",
                        "subject"},null,
                null,null,null,null);
        System.out.println(kk.getCount());
        return kk;

    }


}
