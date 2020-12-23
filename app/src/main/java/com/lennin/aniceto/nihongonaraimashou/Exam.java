package com.lennin.aniceto.nihongonaraimashou;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Exam extends AppCompatActivity {
    Bundle bu;
    TextView t_uname;
    Button exles1;
    Button exles2;
    Button exles3;
    Button exles4;
    Button exles5;
    Button exles6;
    Button exles7;
    Button exles8;
    Button exles9;
    Button exles10;
    Button exles11;
    Button exles12;
    Button exles13;
    Button exles14;
    Button exles15;
    Button examhiragana, examkatakana;
    Button examkanji;

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
        setContentView(R.layout.activity_exam);
        BottomNavigationView bottomNavigationView=(BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        t_uname=(TextView) findViewById(R.id.wce);
        exles1=(Button) findViewById(R.id.examlesson1);
        exles2=(Button) findViewById(R.id.examlesson2);
        exles3=(Button) findViewById(R.id.examlesson3);
        exles4=(Button) findViewById(R.id.examlesson4);
        exles5=(Button) findViewById(R.id.examlesson5);
        exles6=(Button) findViewById(R.id.examlesson6);
        exles7=(Button) findViewById(R.id.examlesson7);
        exles8=(Button) findViewById(R.id.examlesson8);
        exles9=(Button) findViewById(R.id.examlesson9);
        exles10=(Button) findViewById(R.id.examlesson10);
        exles11=(Button) findViewById(R.id.examlesson11);
        exles12=(Button) findViewById(R.id.examlesson12);
        exles13=(Button) findViewById(R.id.examlesson13);
        exles14=(Button) findViewById(R.id.examlesson14);
        exles15=(Button) findViewById(R.id.examlesson15);
        examhiragana=(Button) findViewById(R.id.examhiragana);
        examkatakana=(Button) findViewById(R.id.examkatakana);
        examkanji=(Button) findViewById(R.id.examkanji);
        bu=getIntent().getExtras();
        t_uname.setText(bu.getString("uname"));


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

        // Button Lesson2
        if(voca1_<80){
            exles2.setEnabled(false);
        }
        if(part1_<80){
            exles2.setEnabled(false);
        }
        if(inter1_<80){
            exles2.setEnabled(false);
        }

        // Button Lesson3
        if(voca2_<80){
            exles3.setEnabled(false);
        }
        if(part2_<80){
            exles3.setEnabled(false);
        }
        if(inter2_<80){
            exles3.setEnabled(false);
        }

        // Button Lesson4
        if(voca3_<80){
            exles4.setEnabled(false);
        }
        if(part3_<80){
            exles4.setEnabled(false);
        }
        if(inter3_<80){
            exles4.setEnabled(false);
        }

        // Button Lesson5
        if(voca4_<80){
            exles5.setEnabled(false);
        }
        if(part4_<80){
            exles5.setEnabled(false);
        }
        if(inter4_<80){
            exles5.setEnabled(false);
        }

        // Button Lesson6
        if(voca5_<80){
            exles6.setEnabled(false);
        }
        if(part5_<80){
            exles6.setEnabled(false);
        }
        if(inter5_<80){
            exles6.setEnabled(false);
        }

        // Button Lesson7
        if(voca6_<80){
            exles7.setEnabled(false);
        }
        if(part6_<80){
            exles7.setEnabled(false);
        }
        if(inter6_<80){
            exles7.setEnabled(false);
        }

        // Button Lesson8
        if(voca7_<80){
            exles8.setEnabled(false);
        }
        if(part7_<80){
            exles8.setEnabled(false);
        }
        if(inter7_<80){
            exles8.setEnabled(false);
        }

        // Button Lesson9
        if(voca8_<80){
            exles9.setEnabled(false);
        }
        if(part8_<80){
            exles9.setEnabled(false);
        }
        if(inter8_<80){
            exles9.setEnabled(false);
        }

        // Button Lesson10
        if(voca9_<80){
            exles10.setEnabled(false);
        }
        if(part9_<80){
            exles10.setEnabled(false);
        }
        if(inter9_<80){
            exles10.setEnabled(false);
        }

        // Button Lesson11
        if(voca10_<80){
            exles11.setEnabled(false);
        }
        if(part10_<80){
            exles11.setEnabled(false);
        }
        if(inter10_<80){
            exles11.setEnabled(false);
        }

        // Button Lesson12
        if(voca11_<80){
            exles12.setEnabled(false);
        }
        if(part11_<80){
            exles12.setEnabled(false);
        }
        if(inter11_<80){
            exles12.setEnabled(false);
        }

        // Button Lesson13
        if(voca12_<80){
            exles13.setEnabled(false);
        }
        if(part12_<80){
            exles13.setEnabled(false);
        }
        if(inter12_<80){
            exles13.setEnabled(false);
        }

        // Button Lesson14
        if(voca13_<80){
            exles14.setEnabled(false);
        }
        if(part13_<80){
            exles14.setEnabled(false);
        }
        if(inter13_<80){
            exles14.setEnabled(false);
        }

        // Button Lesson15
        if(voca14_<80){
            exles15.setEnabled(false);
        }
        if(part14_<80){
            exles15.setEnabled(false);
        }
        if(inter14_<80){
            exles15.setEnabled(false);
        }


        exles1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam1.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        exles2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam2.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        exles3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam3.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        exles6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam6.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        examhiragana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam_Hiragana.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        examkatakana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam_Katakana.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        exles4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam4.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        exles5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam5.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        exles7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam7.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        exles8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam8.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        exles9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam9.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        exles10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam10.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        exles11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam11.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        exles12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam12.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        exles13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam13.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        exles14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam14.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        exles15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,Exam15.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });
        examkanji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exam.this,ExamKanji.class);
                i.putExtra("uname", t_uname.getText().toString());
                startActivity(i);
            }
        });



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent i = new Intent(Exam.this,menu.class);
                        i.putExtra("uname", t_uname.getText().toString());
                        startActivity(i);
                        break;
                    case R.id.navigation_account:
                        Intent i2 = new Intent(Exam.this,Account.class);
                        i2.putExtra("uname", t_uname.getText().toString());
                        startActivity(i2);
                        break;
                    case R.id.navigation_lesson:
                        Intent i3 = new Intent(Exam.this,Lessons.class);
                        i3.putExtra("uname", t_uname.getText().toString());
                        startActivity(i3);
                        break;
                    case R.id.navigation_report:
                        Intent i4 = new Intent(Exam.this,Report.class);
                        i4.putExtra("uname", t_uname.getText().toString());
                        startActivity(i4);
                        break;
                }
                return false;

            }
        });
    }
}
