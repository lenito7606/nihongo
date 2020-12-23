package com.lennin.aniceto.nihongonaraimashou;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Menu_Lesson1to5 extends AppCompatActivity {

    Button lesson1, lesson2, lesson3, lesson4, lesson5;

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    DecimalFormat df;
    String username, categ, lesson, score, totals;
    Cursor cursor;


    int scrvoca1 = 0, totalvoca1=0, scrpart1 = 0, totalpart1 =0, scrinter1=0, totalinter1=0;
    float voca1_, part1_, inter1_;

    int scrvoca2 = 0, totalvoca2=0, scrpart2 = 0, totalpart2 =0, scrinter2=0, totalinter2=0;
    float voca2_, part2_, inter2_;

    int scrvoca3 = 0, totalvoca3=0, scrpart3 = 0, totalpart3 =0, scrinter3=0, totalinter3=0;
    float voca3_, part3_, inter3_;

    int scrvoca4 = 0, totalvoca4=0, scrpart4 = 0, totalpart4 =0, scrinter4=0, totalinter4=0;
    float voca4_, part4_, inter4_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__lesson1to5);

        lesson1 = (Button) findViewById(R.id.lesson1);
        lesson2 = (Button) findViewById(R.id.lesson2);
        lesson3 = (Button) findViewById(R.id.lesson3);
        lesson4 = (Button) findViewById(R.id.lesson4);
        lesson5 = (Button) findViewById(R.id.lesson5);


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


                // Lesson1
                if (lesson.equals("Lesson1")) {
                    if (categ.equals("Vocabulary")) {

                        scrvoca1 += scores;
                        totalvoca1 += totalitem;
                        voca1_ = Float.valueOf(df.format(((float) scrvoca1 / totalvoca1) * 100));
                    }

                    if (categ.equals("Particle")) {

                        scrpart1 += scores;
                        totalpart1 += totalitem;
                        part1_ = Float.valueOf(df.format(((float) scrpart1 / totalpart1) * 100));
                    }

                    if (categ.equals("Interrogative")) {

                        scrinter1 += scores;
                        totalinter1 += totalitem;
                        inter1_ = Float.valueOf(df.format(((float) scrinter1 / totalinter1) * 100));
                    }
                }

                // Lesson2
                if (lesson.equals("Lesson2")) {
                    if (categ.equals("Vocabulary")) {

                        scrvoca2 += scores;
                        totalvoca2 += totalitem;
                        voca2_ = Float.valueOf(df.format(((float) scrvoca2 / totalvoca2) * 100));
                    }

                    if (categ.equals("Particle")) {

                        scrpart2 += scores;
                        totalpart2 += totalitem;
                        part2_ = Float.valueOf(df.format(((float) scrpart2 / totalpart2) * 100));
                    }

                    if (categ.equals("Interrogative")) {

                        scrinter2 += scores;
                        totalinter2 += totalitem;
                        inter2_ = Float.valueOf(df.format(((float) scrinter2 / totalinter2) * 100));
                    }
                }

                // Lesson3
                if (lesson.equals("Lesson3")) {
                    if (categ.equals("Vocabulary")) {

                        scrvoca3 += scores;
                        totalvoca3 += totalitem;
                        voca3_ = Float.valueOf(df.format(((float) scrvoca3 / totalvoca3) * 100));
                    }

                    if (categ.equals("Particle")) {

                        scrpart3 += scores;
                        totalpart3 += totalitem;
                        part3_ = Float.valueOf(df.format(((float) scrpart3 / totalpart3) * 100));
                    }

                    if (categ.equals("Interrogative")) {

                        scrinter3 += scores;
                        totalinter3 += totalitem;
                        inter3_ = Float.valueOf(df.format(((float) scrinter3 / totalinter3) * 100));
                    }
                }

                // Lesson4
                if (lesson.equals("Lesson4")) {
                    if (categ.equals("Vocabulary")) {

                        scrvoca4 += scores;
                        totalvoca4 += totalitem;
                        voca4_ = Float.valueOf(df.format(((float) scrvoca4 / totalvoca4) * 100));
                    }

                    if (categ.equals("Particle")) {

                        scrpart4 += scores;
                        totalpart4 += totalitem;
                        part4_ = Float.valueOf(df.format(((float) scrpart4 / totalpart4) * 100));
                    }

                    if (categ.equals("Interrogative")) {

                        scrinter4 += scores;
                        totalinter4 += totalitem;
                        inter4_ = Float.valueOf(df.format(((float) scrinter4 / totalinter4) * 100));
                    }
                }




            }
        }



        lesson1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu_Lesson1to5.this,Lesson1.class);
                startActivity(i);

            }
        });

        lesson2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(voca1_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 1", Toast.LENGTH_SHORT).show();
                }
                else if(part1_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 1", Toast.LENGTH_SHORT).show();
                }
                else if(inter1_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 1", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(Menu_Lesson1to5.this,Lesson2.class);
                    startActivity(i);
                }


            }
        });

        lesson3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(voca2_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 2", Toast.LENGTH_SHORT).show();
                }
                else if(part2_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 2", Toast.LENGTH_SHORT).show();
                }
                else if(inter2_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 2", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(Menu_Lesson1to5.this,Lesson3.class);
                    startActivity(i);
                }
            }
        });

        lesson4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(voca3_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 3", Toast.LENGTH_SHORT).show();
                }
                else if(part3_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 3", Toast.LENGTH_SHORT).show();
                }
                else if(inter3_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 3", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(Menu_Lesson1to5.this,Lesson4.class);
                    startActivity(i);
                }
            }
        });

        lesson5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(voca4_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 4", Toast.LENGTH_SHORT).show();
                }
                else if(part4_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 4", Toast.LENGTH_SHORT).show();
            }
                else if(inter4_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 4", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(Menu_Lesson1to5.this,Lesson5.class);
                    startActivity(i);
                }
            }
        });

    }
}

