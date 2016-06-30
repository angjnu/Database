package com.example.anil.databse;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class nextActivity extends AppCompatActivity {
ListView list1;
    String []roll;
    String []name;
    String []address;
    String []subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        list1 = (ListView)findViewById(R.id.list1);
        StudentDataBase studentkk = new StudentDataBase(nextActivity.this);

        SQLiteDatabase db = studentkk.getReadableDatabase();
        roll = new String[studentkk.alldata(db).getCount()];
        name = new String[studentkk.alldata(db).getCount()];
        address = new String[studentkk.alldata(db).getCount()];
        subject= new String[studentkk.alldata(db).getCount()];
        int l= 0;
        Cursor kk =studentkk.alldata(db);
        while (kk.moveToNext() ){
            roll[l] = kk.getString(1);
            name[l] = kk.getString(2);
            address[l] =kk.getString(3);
            subject [l] = kk.getString(4);
           l++;
        }
        ArrayAdapter<String> ll = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,name);
        list1.setAdapter(ll);


    }
}
