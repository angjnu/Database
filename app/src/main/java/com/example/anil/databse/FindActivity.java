package com.example.anil.databse;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FindActivity extends AppCompatActivity {
    EditText roll, name, address, subject;
    Button submit, find;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        roll = (EditText)findViewById(R.id.extRoll1);
        name=(EditText)findViewById(R.id.extName1);
        address=(EditText)findViewById(R.id.extAddress1);
        subject=(EditText)findViewById(R.id.extSuject1);

        find = (Button)findViewById(R.id.findrollnu);

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roll1 = roll.getText().toString();
                StudentDataBase studentkk = new StudentDataBase(FindActivity.this);

                SQLiteDatabase db = studentkk.getReadableDatabase();
               Cursor nn =  studentkk.findDeatils(db, roll1);

                 if(nn.moveToFirst()){
                     roll.setText(nn.getString(1).toString());
                     name.setText(nn.getString(2).toString());
                     address.setText(nn.getString(3).toString());
                     subject.setText(nn.getString(4).toString());

                     System.out.println("Count value" + nn.getCount());
                 }else{

                     Toast.makeText(FindActivity.this,"No data at this roll",Toast.LENGTH_LONG).show();
                 }



            }
        });

    }
}
