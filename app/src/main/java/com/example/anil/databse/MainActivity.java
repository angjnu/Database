package com.example.anil.databse;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText roll, name, address, subject;
    Button submit, find;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   roll = (EditText)findViewById(R.id.extRoll);
        name=(EditText)findViewById(R.id.extName);
        address=(EditText)findViewById(R.id.extAddress);
        subject=(EditText)findViewById(R.id.extSuject);
        submit = (Button)findViewById(R.id.submitBt);
        find = (Button)findViewById(R.id.findBt);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString();
                String roll1 = roll.getText().toString();
                String address1 = address.getText().toString();
                String  subject1 = subject.getText().toString();
            // insertion in database
                StudentDataBase studentkk = new StudentDataBase(MainActivity.this);

                SQLiteDatabase db = studentkk.getReadableDatabase();
               studentkk.insertIntoStudentDb(db, roll1, name1, address1, subject1);
                name.setText("");
                roll.setText("");
                address.setText("");
                subject.setText("");

                // System.out.println(name1 + " " + roll1 + " " + address1 + " " + subject1);
            }
        });

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FindActivity.class);
                startActivity(i);
            }
        });
    }

    void nextList(View v){

        Intent i = new Intent(MainActivity.this, nextActivity.class);
        startActivity(i);

    }

}
