package com.lennin.aniceto.nihongonaraimashou;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Cursor cursor, cursor2, cursor3;
    DecimalFormat df;

    String _score, _username, _lessonnum, _examcategory, _items, _vocab, _part, _inter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        openHelper=new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();

        df = new DecimalFormat("#.##");

        final TextView resultLabel = (TextView)findViewById(R.id.resultLabel);
        final TextView username = (TextView)findViewById(R.id.rauname);
        Button returnBtn = (Button)findViewById(R.id.returnBtn);

        String uname = getIntent().getStringExtra("uname");
        String lessonnum = getIntent().getStringExtra("lessonnum");
        String examcategory = getIntent().getStringExtra("examcategory");
        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        int totalquiz = getIntent().getIntExtra("QUIZ_COUNT", 0);

        username.setText(uname);
        resultLabel.setText(score + " / "+ totalquiz);



        db=openHelper.getWritableDatabase();
        _score = Integer.toString(score);
        _items = Integer.toString(totalquiz);
        _lessonnum = lessonnum;
        _examcategory = examcategory;
        _username = username.getText().toString();
        insertData(_score, _username, _lessonnum, _examcategory, _items);


        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(ResultActivity.this, Exam.class);
                i.putExtra("uname", username.getText().toString());
                startActivity(i);

            }
        });

    }

    public void insertData(String _score, String _username, String _lessonnum, String _examcategory, String _items) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_SCORE, _score);
        contentValues.put(DatabaseHelper.COL_UNAME, _username);
        contentValues.put(DatabaseHelper.COL_LESSONNUM, _lessonnum);
        contentValues.put(DatabaseHelper.COL_CATEGORY, _examcategory);
        contentValues.put(DatabaseHelper.COL_ITEMS, _items);
        long _id = db.insert(DatabaseHelper.TABLE_SCORES, null, contentValues);

    }


}
