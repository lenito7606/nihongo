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

public class Menu_Lesson6to10 extends AppCompatActivity {

    Button lesson6, lesson7, lesson8, lesson9, lesson10;

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    DecimalFormat df;
    String username, categ, lesson, score, totals;
    Cursor cursor;

    int scrvoca5 = 0, totalvoca5=0, scrpart5 = 0, totalpart5 =0, scrinter5=0, totalinter5=0;
    float voca5_, part5_, inter5_;

    int scrvoca6 = 0, totalvoca6=0, scrpart6 = 0, totalpart6 =0, scrinter6=0, totalinter6=0;
    float voca6_, part6_, inter6_;

    int scrvoca7 = 0, totalvoca7=0, scrpart7 = 0, totalpart7 =0, scrinter7=0, totalinter7=0;
    float voca7_, part7_, inter7_;

    int scrvoca8 = 0, totalvoca8=0, scrpart8 = 0, totalpart8 =0, scrinter8=0, totalinter8=0;
    float voca8_, part8_, inter8_;

    int scrvoca9 = 0, totalvoca9=0, scrpart9 = 0, totalpart9 =0, scrinter9=0, totalinter9=0;
    float voca9_, part9_, inter9_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__lesson6to10);

        lesson6 = (Button) findViewById(R.id.lesson6);
        lesson7 = (Button) findViewById(R.id.lesson7);
        lesson8 = (Button) findViewById(R.id.lesson8);
        lesson9 = (Button) findViewById(R.id.lesson9);
        lesson10 = (Button) findViewById(R.id.lesson10);


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


                // Lesson5
                if (lesson.equals("Lesson5")) {
                    if (categ.equals("Vocabulary")) {

                        scrvoca5 += scores;
                        totalvoca5 += totalitem;
                        voca5_ = Float.valueOf(df.format(((float) scrvoca5 / totalvoca5) * 100));
                    }

                    if (categ.equals("Particle")) {

                        scrpart5 += scores;
                        totalpart5 += totalitem;
                        part5_ = Float.valueOf(df.format(((float) scrpart5 / totalpart5) * 100));
                    }

                    if (categ.equals("Interrogative")) {

                        scrinter5 += scores;
                        totalinter5 += totalitem;
                        inter5_ = Float.valueOf(df.format(((float) scrinter5 / totalinter5) * 100));
                    }
                }

                // Lesson6
                if (lesson.equals("Lesson6")) {
                    if (categ.equals("Vocabulary")) {

                        scrvoca6 += scores;
                        totalvoca6 += totalitem;
                        voca6_ = Float.valueOf(df.format(((float) scrvoca6 / totalvoca6) * 100));
                    }

                    if (categ.equals("Particle")) {

                        scrpart6 += scores;
                        totalpart6 += totalitem;
                        part6_ = Float.valueOf(df.format(((float) scrpart6 / totalpart6) * 100));
                    }

                    if (categ.equals("Interrogative")) {

                        scrinter6 += scores;
                        totalinter6 += totalitem;
                        inter6_ = Float.valueOf(df.format(((float) scrinter6 / totalinter6) * 100));
                    }
                }

                // Lesson7
                if (lesson.equals("Lesson7")) {
                    if (categ.equals("Vocabulary")) {

                        scrvoca7 += scores;
                        totalvoca7 += totalitem;
                        voca7_ = Float.valueOf(df.format(((float) scrvoca7 / totalvoca7) * 100));
                    }

                    if (categ.equals("Particle")) {

                        scrpart7 += scores;
                        totalpart7 += totalitem;
                        part7_ = Float.valueOf(df.format(((float) scrpart7 / totalpart7) * 100));
                    }

                    if (categ.equals("Interrogative")) {

                        scrinter7 += scores;
                        totalinter7 += totalitem;
                        inter7_ = Float.valueOf(df.format(((float) scrinter7 / totalinter7) * 100));
                    }
                }

                // Lesson8
                if (lesson.equals("Lesson8")) {
                    if (categ.equals("Vocabulary")) {

                        scrvoca8 += scores;
                        totalvoca8 += totalitem;
                        voca8_ = Float.valueOf(df.format(((float) scrvoca8 / totalvoca8) * 100));
                    }

                    if (categ.equals("Particle")) {

                        scrpart8 += scores;
                        totalpart8 += totalitem;
                        part8_ = Float.valueOf(df.format(((float) scrpart8 / totalpart8) * 100));
                    }

                    if (categ.equals("Interrogative")) {

                        scrinter8 += scores;
                        totalinter8 += totalitem;
                        inter8_ = Float.valueOf(df.format(((float) scrinter8 / totalinter8) * 100));
                    }
                }
                // Lesson9
                if (lesson.equals("Lesson9")) {
                    if (categ.equals("Vocabulary")) {

                        scrvoca9 += scores;
                        totalvoca9 += totalitem;
                        voca9_ = Float.valueOf(df.format(((float) scrvoca9 / totalvoca9) * 100));
                    }

                    if (categ.equals("Particle")) {

                        scrpart9 += scores;
                        totalpart9 += totalitem;
                        part9_ = Float.valueOf(df.format(((float) scrpart9 / totalpart9) * 100));
                    }

                    if (categ.equals("Interrogative")) {

                        scrinter9 += scores;
                        totalinter9 += totalitem;
                        inter9_ = Float.valueOf(df.format(((float) scrinter9 / totalinter9) * 100));
                    }
                }




            }
        }





        lesson6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent i = new Intent(Menu_Lesson6to10.this,Lesson6.class);
                    startActivity(i);
            }
        });

        lesson7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(voca6_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 6", Toast.LENGTH_SHORT).show();
                }
                else if(part6_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 6", Toast.LENGTH_SHORT).show();
                }
                else if(inter6_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 6", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(Menu_Lesson6to10.this,Lesson7.class);
                    startActivity(i);
                }
            }
        });

        lesson8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(voca7_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 7", Toast.LENGTH_SHORT).show();
                }
                else if(part7_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 7", Toast.LENGTH_SHORT).show();
                }
                else if(inter7_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 7", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(Menu_Lesson6to10.this,Lesson8.class);
                    startActivity(i);
                }
            }
        });

        lesson9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(voca8_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 8", Toast.LENGTH_SHORT).show();
                }
                else if(part8_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 8", Toast.LENGTH_SHORT).show();
                }
                else if(inter8_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 8", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(Menu_Lesson6to10.this,Lesson9.class);
                    startActivity(i);
                }
            }
        });

        lesson10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(voca9_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 9", Toast.LENGTH_SHORT).show();
                }
                else if(part9_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 9", Toast.LENGTH_SHORT).show();
                }
                else if(inter9_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 9", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(Menu_Lesson6to10.this,Lesson10.class);
                    startActivity(i);
                }
            }
        });



    }
}

