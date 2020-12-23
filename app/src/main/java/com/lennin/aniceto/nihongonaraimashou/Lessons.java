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
import android.widget.Toast;

import java.text.DecimalFormat;

public class Lessons extends AppCompatActivity {
    Bundle bu;
    TextView t_uname;
    Button lesson1to5, lesson6to10, lesson11to15;

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    DecimalFormat df;
    String username, categ, lesson, score, totals;
    Cursor cursor;


    int scrvoca5 = 0, totalvoca5=0, scrpart5 = 0, totalpart5 =0, scrinter5=0, totalinter5=0;
    float voca5_, part5_, inter5_;

    int scrvoca10 = 0, totalvoca10 = 0, scrpart10 = 0, totalpart10 = 0, scrinter10 = 0, totalinter10 = 0;
    float voca10_, part10_, inter10_;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessons);
        BottomNavigationView bottomNavigationView=(BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        t_uname=(TextView) findViewById(R.id.wcl);
        bu=getIntent().getExtras();
        t_uname.setText(bu.getString("uname"));

        lesson1to5 = (Button) findViewById(R.id.lesson1to5);
        lesson6to10 = (Button) findViewById(R.id.lesson6to10);
        lesson11to15 = (Button) findViewById(R.id.lesson11to15);



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

            }
        }



        lesson1to5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i = new Intent(Lessons.this, Menu_Lesson1to5.class);
                    i.putExtra("uname", t_uname.getText().toString());
                    startActivity(i);
                }
        });

        lesson6to10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(voca5_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 5", Toast.LENGTH_SHORT).show();
                }
                else if(part5_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 5", Toast.LENGTH_SHORT).show();
                }
                else if(inter5_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 5", Toast.LENGTH_SHORT).show();
                }
                else {

                    Intent i = new Intent(Lessons.this, Menu_Lesson6to10.class);
                    i.putExtra("uname", t_uname.getText().toString());
                    startActivity(i);
                }

            }
        });

        lesson11to15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(voca10_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 10", Toast.LENGTH_SHORT).show();
                }
                else if(part10_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 10", Toast.LENGTH_SHORT).show();
                }
                else if(inter10_<80){
                    Toast.makeText(getApplicationContext(), "Finish Lesson 10", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(Lessons.this, Menu_Lesson11to15.class);
                    i.putExtra("uname", t_uname.getText().toString());
                    startActivity(i);
                }

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            Intent i = new Intent(Lessons.this,menu.class);
                            i.putExtra("uname", t_uname.getText().toString());
                            startActivity(i);
                            break;
                        case R.id.navigation_account:
                            Intent i2 = new Intent(Lessons.this,Account.class);
                            i2.putExtra("uname", t_uname.getText().toString());
                            startActivity(i2);
                            break;
                        case R.id.navigation_exam:
                            Intent i3 = new Intent(Lessons.this,Exam.class);
                            i3.putExtra("uname", t_uname.getText().toString());
                            startActivity(i3);
                            break;
                        case R.id.navigation_report:
                            Intent i4 = new Intent(Lessons.this,Report.class);
                            i4.putExtra("uname", t_uname.getText().toString());
                            startActivity(i4);
                            break;
                    }
                    return false;

                }
        });
    }
    public void onWritingButtonclick (View v)
    {
        if (v.getId() == R.id.writing)
        {
            Intent i = new Intent(Lessons.this,WritingActivity.class);
            startActivity(i);
        }

    }
    public void onIntroButtonclick (View v)
    {
        if (v.getId() == R.id.intro)
        {
            Intent i = new Intent(Lessons.this,Intro.class);
            startActivity(i);
        }

    }
}
