package com.lennin.aniceto.nihongonaraimashou;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Menu_Lesson11to15 extends AppCompatActivity {

    Button lesson11, lesson12, lesson13, lesson14, lesson15;

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    DecimalFormat df;
    String username, categ, lesson, score, totals;
    Cursor cursor;

    int scrvoca10 = 0, totalvoca10 = 0, scrpart10 = 0, totalpart10 = 0, scrinter10 = 0, totalinter10 = 0;
    float voca10_, part10_, inter10_;

    int scrvoca11 = 0, totalvoca11 = 0, scrpart11 = 0, totalpart11 = 0, scrinter11 = 0, totalinter11 = 0;
    float voca11_, part11_, inter11_;

    int scrvoca12 = 0, totalvoca12 = 0, scrpart12 = 0, totalpart12 = 0, scrinter12 = 0, totalinter12 = 0;
    float voca12_, part12_, inter12_;

    int scrvoca13 = 0, totalvoca13 = 0, scrpart13 = 0, totalpart13 = 0, scrinter13 = 0, totalinter13 = 0;
    float voca13_, part13_, inter13_;

    int scrvoca14 = 0, totalvoca14 = 0, scrpart14 = 0, totalpart14 = 0, scrinter14 = 0, totalinter14 = 0;
    float voca14_, part14_, inter14_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__lesson11to15);


        lesson11 = (Button) findViewById(R.id.lesson11);
        lesson12 = (Button) findViewById(R.id.lesson12);
        lesson13 = (Button) findViewById(R.id.lesson13);
        lesson14 = (Button) findViewById(R.id.lesson14);
        lesson15 = (Button) findViewById(R.id.lesson15);


        openHelper=new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();

        df = new DecimalFormat("##.##");


        username = getIntent().getStringExtra("uname");
        cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_SCORES + " where " + DatabaseHelper.COL_UNAME + "=?", new String[]{username});
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                categ = cursor.getString(3);
                lesson = cursor.getString(2);
                score = cursor.getString(4);
                totals = cursor.getString(5);
                int scores = Integer.parseInt(score);
                int totalitem = Integer.parseInt(totals);


                // Lesson10
                if (lesson.equals("Lesson10")) {
                    if (categ.equals("Vocabulary")) {

                        scrvoca10 += scores;
                        totalvoca10 += totalitem;
                        voca10_ = Float.valueOf(df.format(((float) scrvoca10 / totalvoca10) * 100));
                    }

                    if (categ.equals("Particle")) {

                        scrpart10 += scores;
                        totalpart10 += totalitem;
                        part10_ = Float.valueOf(df.format(((float) scrpart10 / totalpart10) * 100));
                    }

                    if (categ.equals("Interrogative")) {

                        scrinter10 += scores;
                        totalinter10 += totalitem;
                        inter10_ = Float.valueOf(df.format(((float) scrinter10 / totalinter10) * 100));
                    }
                }

                // Lesson11
                if (lesson.equals("Lesson11")) {
                    if (categ.equals("Vocabulary")) {

                        scrvoca11 += scores;
                        totalvoca11 += totalitem;
                        voca11_ = Float.valueOf(df.format(((float) scrvoca11 / totalvoca11) * 100));
                    }

                    if (categ.equals("Particle")) {

                        scrpart11 += scores;
                        totalpart11 += totalitem;
                        part11_ = Float.valueOf(df.format(((float) scrpart11 / totalpart11) * 100));
                    }

                    if (categ.equals("Interrogative")) {

                        scrinter11 += scores;
                        totalinter11 += totalitem;
                        inter11_ = Float.valueOf(df.format(((float) scrinter11 / totalinter11) * 100));
                    }
                }

                // Lesson12
                if (lesson.equals("Lesson12")) {
                    if (categ.equals("Vocabulary")) {

                        scrvoca12 += scores;
                        totalvoca12 += totalitem;
                        voca12_ = Float.valueOf(df.format(((float) scrvoca12 / totalvoca12) * 100));
                    }

                    if (categ.equals("Particle")) {

                        scrpart12 += scores;
                        totalpart12 += totalitem;
                        part12_ = Float.valueOf(df.format(((float) scrpart12 / totalpart12) * 100));
                    }

                    if (categ.equals("Interrogative")) {

                        scrinter12 += scores;
                        totalinter12 += totalitem;
                        inter12_ = Float.valueOf(df.format(((float) scrinter12 / totalinter12) * 100));
                    }
                }

                // Lesson13
                if (lesson.equals("Lesson13")) {
                    if (categ.equals("Vocabulary")) {

                        scrvoca13 += scores;
                        totalvoca13 += totalitem;
                        voca13_ = Float.valueOf(df.format(((float) scrvoca13 / totalvoca13) * 100));
                    }

                    if (categ.equals("Particle")) {

                        scrpart13 += scores;
                        totalpart13 += totalitem;
                        part13_ = Float.valueOf(df.format(((float) scrpart13 / totalpart13) * 100));
                    }

                    if (categ.equals("Interrogative")) {

                        scrinter13 += scores;
                        totalinter13 += totalitem;
                        inter13_ = Float.valueOf(df.format(((float) scrinter13 / totalinter13) * 100));
                    }
                }
                // Lesson14
                if (lesson.equals("Lesson14")) {
                    if (categ.equals("Vocabulary")) {

                        scrvoca14 += scores;
                        totalvoca14 += totalitem;
                        voca14_ = Float.valueOf(df.format(((float) scrvoca14 / totalvoca14) * 100));
                    }

                    if (categ.equals("Particle")) {

                        scrpart14 += scores;
                        totalpart14 += totalitem;
                        part14_ = Float.valueOf(df.format(((float) scrpart14 / totalpart14) * 100));
                    }

                    if (categ.equals("Interrogative")) {

                        scrinter14 += scores;
                        totalinter14 += totalitem;
                        inter14_ = Float.valueOf(df.format(((float) scrinter14 / totalinter14) * 100));
                    }
                }




            }
        }





        lesson11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i = new Intent(Menu_Lesson11to15.this,Lesson11.class);
                    startActivity(i);
            }
        });

        lesson12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(voca11_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 11", Toast.LENGTH_SHORT).show();
                }
                else if(part11_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 11", Toast.LENGTH_SHORT).show();
                }
                else if(inter11_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 11", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(Menu_Lesson11to15.this,Lesson12.class);
                    startActivity(i);
                }
            }
        });

        lesson13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(voca12_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 12", Toast.LENGTH_SHORT).show();
                }
                else if(part12_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 12", Toast.LENGTH_SHORT).show();
                }
                else if(inter12_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 12", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(Menu_Lesson11to15.this,Lesson13.class);
                    startActivity(i);
                }
            }
        });

        lesson14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(voca13_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 13", Toast.LENGTH_SHORT).show();
                }
                else if(part13_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 13", Toast.LENGTH_SHORT).show();
                }
                else if(inter13_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 13", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(Menu_Lesson11to15.this,Lesson14.class);
                    startActivity(i);
                }
            }
        });

        lesson15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(voca14_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 14", Toast.LENGTH_SHORT).show();
                }
                else if(part14_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 14", Toast.LENGTH_SHORT).show();
                }
                else if(inter14_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 14", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(Menu_Lesson11to15.this,Lesson15.class);
                    startActivity(i);
                }
            }
        });



    }
}