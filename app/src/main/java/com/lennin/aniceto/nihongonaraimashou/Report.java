package com.lennin.aniceto.nihongonaraimashou;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by lenni on 09/09/2017.
 */

public class Report extends AppCompatActivity {
    Bundle bu;
    TextView t_uname, hira, kata, kanji, voca, part, inter;
    TextView voca1, part1, inter1;
    TextView voca2, part2, inter2;
    TextView voca3, part3, inter3;
    TextView voca4, part4, inter4;
    TextView voca5, part5, inter5;
    TextView voca6, part6, inter6;
    TextView voca7, part7, inter7;
    TextView voca8, part8, inter8;
    TextView voca9, part9, inter9;
    TextView voca10, part10, inter10;
    TextView voca11, part11, inter11;
    TextView voca12, part12, inter12;
    TextView voca13, part13, inter13;
    TextView voca14, part14, inter14;
    TextView voca15, part15, inter15;
    TextView voca1_per, part1_per, inter1_per;
    TextView voca2_per, part2_per, inter2_per;
    TextView voca3_per, part3_per, inter3_per;
    TextView voca4_per, part4_per, inter4_per;
    TextView voca5_per, part5_per, inter5_per;
    TextView voca6_per, part6_per, inter6_per;
    TextView voca7_per, part7_per, inter7_per;
    TextView voca8_per, part8_per, inter8_per;
    TextView voca9_per, part9_per, inter9_per;
    TextView voca10_per, part10_per, inter10_per;
    TextView voca11_per, part11_per, inter11_per;
    TextView voca12_per, part12_per, inter12_per;
    TextView voca13_per, part13_per, inter13_per;
    TextView voca14_per, part14_per, inter14_per;
    TextView voca15_per, part15_per, inter15_per;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Cursor cursor, cursor2;
    BarChart barChart;
    DecimalFormat df;

    int scrvoca = 0, totalvoca = 0, itemvoca =0, scrpart = 0, totalpart = 0, itempart = 0, scrinter = 0, totalinter = 0, iteminter = 0;
    float voca_, part_, inter_;
    int clrvoca, clrpart, clrinter;
    int chkhira = 0, chkkata = 0, chkkanji = 0, chkvoca = 0, chkinter = 0, chkpart = 0;

    int chkvoca1 = 0, chkinter1 = 0, chkpart1 = 0;
    int chkvoca2 = 0, chkinter2 = 0, chkpart2 = 0;
    int chkvoca3 = 0, chkinter3 = 0, chkpart3 = 0;
    int chkvoca4 = 0, chkinter4 = 0, chkpart4 = 0;
    int chkvoca5 = 0, chkinter5 = 0, chkpart5 = 0;
    int chkvoca6 = 0, chkinter6 = 0, chkpart6 = 0;
    int chkvoca7 = 0, chkinter7 = 0, chkpart7 = 0;
    int chkvoca8 = 0, chkinter8 = 0, chkpart8 = 0;
    int chkvoca9 = 0, chkinter9 = 0, chkpart9 = 0;
    int chkvoca10 = 0, chkinter10 = 0, chkpart10 = 0;
    int chkvoca11 = 0, chkinter11 = 0, chkpart11 = 0;
    int chkvoca12 = 0, chkinter12 = 0, chkpart12 = 0;
    int chkvoca13 = 0, chkinter13 = 0, chkpart13 = 0;
    int chkvoca14 = 0, chkinter14 = 0, chkpart14 = 0;
    int chkvoca15 = 0, chkinter15 = 0, chkpart15 = 0;

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

    int scrvoca15 = 0, totalvoca15 = 0, scrpart15 = 0, totalpart15 = 0, scrinter15 = 0, totalinter15 = 0;
    float voca15_, part15_, inter15_;

    String _hira, _kata, _kanji, _voca, _part, _inter, username, categ, score, lesson, totals;

    String _voca1, _part1, _inter1;
    String _voca2, _part2, _inter2;
    String _voca3, _part3, _inter3;
    String _voca4, _part4, _inter4;
    String _voca5, _part5, _inter5;
    String _voca6, _part6, _inter6;
    String _voca7, _part7, _inter7;
    String _voca8, _part8, _inter8;
    String _voca9, _part9, _inter9;
    String _voca10, _part10, _inter10;
    String _voca11, _part11, _inter11;
    String _voca12, _part12, _inter12;
    String _voca13, _part13, _inter13;
    String _voca14, _part14, _inter14;
    String _voca15, _part15, _inter15;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        BottomNavigationView bottomNavigationView=(BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);

        openHelper=new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();
        hira = (TextView) findViewById(R.id.hira_score);
        kata = (TextView) findViewById(R.id.kata_score);
        kanji = (TextView) findViewById(R.id.kanji_score);

        voca = (TextView) findViewById(R.id.voca_score);
        part = (TextView) findViewById(R.id.part_score);
        inter = (TextView) findViewById(R.id.inter_score);

        voca1 = (TextView) findViewById(R.id.voca1_score);
        part1 = (TextView) findViewById(R.id.part1_score);
        inter1 = (TextView) findViewById(R.id.inter1_score);

        voca2 = (TextView) findViewById(R.id.voca2_score);
        part2 = (TextView) findViewById(R.id.part2_score);
        inter2 = (TextView) findViewById(R.id.inter2_score);

        voca3 = (TextView) findViewById(R.id.voca3_score);
        part3 = (TextView) findViewById(R.id.part3_score);
        inter3 = (TextView) findViewById(R.id.inter3_score);

        voca4 = (TextView) findViewById(R.id.voca4_score);
        part4 = (TextView) findViewById(R.id.part4_score);
        inter4 = (TextView) findViewById(R.id.inter4_score);

        voca5 = (TextView) findViewById(R.id.voca5_score);
        part5 = (TextView) findViewById(R.id.part5_score);
        inter5 = (TextView) findViewById(R.id.inter5_score);

        voca6 = (TextView) findViewById(R.id.voca6_score);
        part6 = (TextView) findViewById(R.id.part6_score);
        inter6 = (TextView) findViewById(R.id.inter6_score);

        voca7 = (TextView) findViewById(R.id.voca7_score);
        part7 = (TextView) findViewById(R.id.part7_score);
        inter7 = (TextView) findViewById(R.id.inter7_score);

        voca8 = (TextView) findViewById(R.id.voca8_score);
        part8 = (TextView) findViewById(R.id.part8_score);
        inter8 = (TextView) findViewById(R.id.inter8_score);

        voca9 = (TextView) findViewById(R.id.voca9_score);
        part9 = (TextView) findViewById(R.id.part9_score);
        inter9 = (TextView) findViewById(R.id.inter9_score);

        voca10 = (TextView) findViewById(R.id.voca10_score);
        part10 = (TextView) findViewById(R.id.part10_score);
        inter10 = (TextView) findViewById(R.id.inter10_score);

        voca11 = (TextView) findViewById(R.id.voca11_score);
        part11 = (TextView) findViewById(R.id.part11_score);
        inter11 = (TextView) findViewById(R.id.inter11_score);

        voca12 = (TextView) findViewById(R.id.voca12_score);
        part12 = (TextView) findViewById(R.id.part12_score);
        inter12 = (TextView) findViewById(R.id.inter12_score);

        voca13 = (TextView) findViewById(R.id.voca13_score);
        part13 = (TextView) findViewById(R.id.part13_score);
        inter13 = (TextView) findViewById(R.id.inter13_score);

        voca14 = (TextView) findViewById(R.id.voca14_score);
        part14 = (TextView) findViewById(R.id.part14_score);
        inter14 = (TextView) findViewById(R.id.inter14_score);

        voca15 = (TextView) findViewById(R.id.voca15_score);
        part15 = (TextView) findViewById(R.id.part15_score);
        inter15 = (TextView) findViewById(R.id.inter15_score);

        voca1_per = (TextView) findViewById(R.id.voca1_per);
        part1_per = (TextView) findViewById(R.id.part1_per);
        inter1_per = (TextView) findViewById(R.id.inter1_per);

        voca2_per = (TextView) findViewById(R.id.voca2_per);
        part2_per = (TextView) findViewById(R.id.part2_per);
        inter2_per = (TextView) findViewById(R.id.inter2_per);

        voca3_per = (TextView) findViewById(R.id.voca3_per);
        part3_per = (TextView) findViewById(R.id.part3_per);
        inter3_per = (TextView) findViewById(R.id.inter3_per);

        voca4_per = (TextView) findViewById(R.id.voca4_per);
        part4_per = (TextView) findViewById(R.id.part4_per);
        inter4_per = (TextView) findViewById(R.id.inter4_per);

        voca5_per = (TextView) findViewById(R.id.voca5_per);
        part5_per = (TextView) findViewById(R.id.part5_per);
        inter5_per = (TextView) findViewById(R.id.inter5_per);

        voca6_per = (TextView) findViewById(R.id.voca6_per);
        part6_per = (TextView) findViewById(R.id.part6_per);
        inter6_per = (TextView) findViewById(R.id.inter6_per);

        voca7_per = (TextView) findViewById(R.id.voca7_per);
        part7_per = (TextView) findViewById(R.id.part7_per);
        inter7_per = (TextView) findViewById(R.id.inter7_per);

        voca8_per = (TextView) findViewById(R.id.voca8_per);
        part8_per = (TextView) findViewById(R.id.part8_per);
        inter8_per = (TextView) findViewById(R.id.inter8_per);

        voca9_per = (TextView) findViewById(R.id.voca9_per);
        part9_per = (TextView) findViewById(R.id.part9_per);
        inter9_per = (TextView) findViewById(R.id.inter9_per);

        voca10_per = (TextView) findViewById(R.id.voca10_per);
        part10_per = (TextView) findViewById(R.id.part10_per);
        inter10_per = (TextView) findViewById(R.id.inter10_per);

        voca11_per = (TextView) findViewById(R.id.voca11_per);
        part11_per = (TextView) findViewById(R.id.part11_per);
        inter11_per = (TextView) findViewById(R.id.inter11_per);

        voca12_per = (TextView) findViewById(R.id.voca12_per);
        part12_per = (TextView) findViewById(R.id.part12_per);
        inter12_per = (TextView) findViewById(R.id.inter12_per);

        voca13_per = (TextView) findViewById(R.id.voca13_per);
        part13_per = (TextView) findViewById(R.id.part13_per);
        inter13_per = (TextView) findViewById(R.id.inter13_per);

        voca14_per = (TextView) findViewById(R.id.voca14_per);
        part14_per = (TextView) findViewById(R.id.part14_per);
        inter14_per = (TextView) findViewById(R.id.inter14_per);

        voca15_per = (TextView) findViewById(R.id.voca15_per);
        part15_per = (TextView) findViewById(R.id.part15_per);
        inter15_per = (TextView) findViewById(R.id.inter15_per);


        t_uname=(TextView) findViewById(R.id.wcr);
        bu=getIntent().getExtras();
        t_uname.setText(bu.getString("uname"));

        df = new DecimalFormat("##.##");


        username = t_uname.getText().toString();
        cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_SCORES + " where " + DatabaseHelper.COL_UNAME + "=?", new String[]{username});
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                categ = cursor.getString(3);
                lesson = cursor.getString(2);
                score = cursor.getString(4);
                totals = cursor.getString(5);
                int scores = Integer.parseInt(score);
                int totalitem = Integer.parseInt(totals);


                // Lesson 1
                if(lesson.equals("Lesson1")){

                    if(categ.equals("Vocabulary")) {

                        while (chkvoca1 < scores) {
                            chkvoca1 = scores;

                        }

                        _voca1 = Integer.toString(chkvoca1);
                        voca1.setText(_voca1);

                        scrvoca1 += scores;
                        totalvoca1 += totalitem;
                        voca1_ = Float.valueOf(df.format(((float) scrvoca1 / totalvoca1) * 100));

                        voca1_per.setText(Float.toString(voca1_)+" %");

                    }

                    if(categ.equals("Particle")) {

                        while (chkpart1 < scores) {
                            chkpart1 = scores;

                        }

                        _part1 = Integer.toString(chkpart1);
                        part1.setText(_part1);

                        scrpart1 += scores;
                        totalpart1 += totalitem;
                        part1_ = Float.valueOf(df.format(((float) scrpart1 / totalpart1) * 100));

                        part1_per.setText(Float.toString(part1_)+" %");

                    }

                    if(categ.equals("Interrogative")) {

                        while (chkinter1 < scores) {
                            chkinter1 = scores;

                        }

                        _inter1 = Integer.toString(chkinter1);
                        inter1.setText(_inter1);

                        scrinter1 += scores;
                        totalinter1 += totalitem;
                        inter1_ = Float.valueOf(df.format(((float) scrinter1 / totalinter1) * 100));

                        inter1_per.setText(Float.toString(inter1_)+" %");

                    }


                }

                // Lesson 2
                if(lesson.equals("Lesson2")) {


                    if (categ.equals("Vocabulary")) {

                        while (chkvoca2 < scores) {
                            chkvoca2 = scores;

                        }

                        _voca2 = Integer.toString(chkvoca2);
                        voca2.setText(_voca2);

                        scrvoca2 += scores;
                        totalvoca2 += totalitem;
                        voca2_ = Float.valueOf(df.format(((float) scrvoca2 / totalvoca2) * 100));

                        voca2_per.setText(Float.toString(voca2_)+" %");

                    }

                    if (categ.equals("Particle")) {


                        while (chkpart2 < scores) {
                            chkpart2 = scores;

                        }

                        _part2 = Integer.toString(chkpart2);
                        part2.setText(_part2);

                        scrpart2 += scores;
                        totalpart2 += totalitem;
                        part2_ = Float.valueOf(df.format(((float) scrpart2 / totalpart2) * 100));

                        part2_per.setText(Float.toString(part2_)+" %");

                    }

                    if (categ.equals("Interrogative")) {


                        while (chkinter2 < scores) {
                            chkinter2 = scores;

                        }

                        _inter2 = Integer.toString(chkinter2);
                        inter2.setText(_inter2);

                        scrinter2 += scores;
                        totalinter2 += totalitem;
                        inter2_ = Float.valueOf(df.format(((float) scrinter2 / totalinter2) * 100));

                        inter2_per.setText(Float.toString(inter2_)+" %");

                    }
                }


                    // Lesson 3
                    if(lesson.equals("Lesson3")) {


                        if (categ.equals("Vocabulary")) {


                            while (chkvoca3 < scores) {
                                chkvoca3 = scores;

                            }

                            _voca3 = Integer.toString(chkvoca3);
                            voca3.setText(_voca3);

                            scrvoca3 += scores;
                            totalvoca3 += totalitem;
                            voca3_ = Float.valueOf(df.format(((float) scrvoca3 / totalvoca3) * 100));

                            voca3_per.setText(Float.toString(voca3_)+" %");

                        }

                        if (categ.equals("Particle")) {


                            while (chkpart3 < scores) {
                                chkpart3 = scores;

                            }

                            _part3 = Integer.toString(chkpart3);
                            part3.setText(_part3);

                            scrpart3 += scores;
                            totalpart3 += totalitem;
                            part3_ = Float.valueOf(df.format(((float) scrpart3 / totalpart3) * 100));

                            part3_per.setText(Float.toString(part3_)+" %");

                        }

                        if (categ.equals("Interrogative")) {


                            while (chkinter3 < scores) {
                                chkinter3 = scores;

                            }

                            _inter3 = Integer.toString(chkinter3);
                            inter3.setText(_inter3);

                            scrinter3 += scores;
                            totalinter3 += totalitem;
                            inter3_ = Float.valueOf(df.format(((float) scrinter3 / totalinter3) * 100));

                            inter3_per.setText(Float.toString(inter3_)+" %");

                        }
                    }

                        // Lesson 4
                        if(lesson.equals("Lesson4")) {


                            if (categ.equals("Vocabulary")) {


                                while (chkvoca4 < scores) {
                                    chkvoca4 = scores;

                                }

                                _voca4 = Integer.toString(chkvoca4);
                                voca4.setText(_voca4);

                                scrvoca4 += scores;
                                totalvoca4 += totalitem;
                                voca4_ = Float.valueOf(df.format(((float) scrvoca4 / totalvoca4) * 100));

                                voca4_per.setText(Float.toString(voca4_)+" %");

                            }

                            if (categ.equals("Particle")) {


                                while (chkpart4 < scores) {
                                    chkpart4 = scores;

                                }

                                _part4 = Integer.toString(chkpart4);
                                part4.setText(_part4);

                                scrpart4 += scores;
                                totalpart4 += totalitem;
                                part4_ = Float.valueOf(df.format(((float) scrpart4 / totalpart4) * 100));

                                part4_per.setText(Float.toString(part4_)+" %");

                            }

                            if (categ.equals("Interrogative")) {


                                while (chkinter4 < scores) {
                                    chkinter4 = scores;

                                }

                                _inter4 = Integer.toString(chkinter4);
                                inter4.setText(_inter4);

                                scrinter4 += scores;
                                totalinter4 += totalitem;
                                inter4_ = Float.valueOf(df.format(((float) scrinter4 / totalinter4) * 100));

                                inter4_per.setText(Float.toString(inter4_)+" %");

                            }
                        }

                            // Lesson 5
                        if(lesson.equals("Lesson5")){


                            if(categ.equals("Vocabulary")) {


                                while (chkvoca5 < scores) {
                                    chkvoca5 = scores;

                                }

                                _voca5 = Integer.toString(chkvoca5);
                                voca5.setText(_voca5);

                                scrvoca5 += scores;
                                totalvoca5 += totalitem;
                                voca5_ = Float.valueOf(df.format(((float) scrvoca5 / totalvoca5) * 100));

                                voca5_per.setText(Float.toString(voca5_)+" %");

                            }

                            if(categ.equals("Particle")) {


                                while (chkpart5 < scores) {
                                    chkpart5 = scores;

                                }

                                _part5 = Integer.toString(chkpart5);
                                part5.setText(_part5);

                                scrpart5 += scores;
                                totalpart5 += totalitem;
                                part5_ = Float.valueOf(df.format(((float) scrpart5 / totalpart5) * 100));

                                part5_per.setText(Float.toString(part5_)+" %");

                            }

                            if(categ.equals("Interrogative")) {


                                while (chkinter5 < scores) {
                                    chkinter5 = scores;

                                }

                                _inter5 = Integer.toString(chkinter5);
                                inter5.setText(_inter5);

                                scrinter5 += scores;
                                totalinter5 += totalitem;
                                inter5_ = Float.valueOf(df.format(((float) scrinter5 / totalinter5) * 100));

                                inter5_per.setText(Float.toString(inter5_)+" %");

                            }

                        }

                // Lesson 6
                if(lesson.equals("Lesson6")){

                    if(categ.equals("Vocabulary")) {


                        while (chkvoca6 < scores) {
                            chkvoca6 = scores;

                        }

                        _voca6 = Integer.toString(chkvoca6);
                        voca6.setText(_voca6);

                        scrvoca6 += scores;
                        totalvoca6 += totalitem;
                        voca6_ = Float.valueOf(df.format(((float) scrvoca6 / totalvoca6) * 100));

                        voca6_per.setText(Float.toString(voca6_)+" %");

                    }

                    if(categ.equals("Particle")) {

                        while (chkpart6 < scores) {
                            chkpart6 = scores;

                        }

                        _part6 = Integer.toString(chkpart6);
                        part6.setText(_part6);

                        scrpart6 += scores;
                        totalpart6 += totalitem;
                        part6_ = Float.valueOf(df.format(((float) scrpart6 / totalpart6) * 100));

                        part6_per.setText(Float.toString(part6_)+" %");

                    }

                    if(categ.equals("Interrogative")) {


                        while (chkinter6 < scores) {
                            chkinter6 = scores;

                        }

                        _inter6 = Integer.toString(chkinter6);
                        inter6.setText(_inter6);

                        scrinter6 += scores;
                        totalinter6 += totalitem;
                        inter6_ = Float.valueOf(df.format(((float) scrinter6 / totalinter6) * 100));

                        inter6_per.setText(Float.toString(inter6_)+" %");

                    }


                }

                // Lesson 7
                if(lesson.equals("Lesson7")) {


                    if (categ.equals("Vocabulary")) {


                        while (chkvoca7 < scores) {
                            chkvoca7 = scores;

                        }

                        _voca7 = Integer.toString(chkvoca7);
                        voca7.setText(_voca7);

                        scrvoca7 += scores;
                        totalvoca7 += totalitem;
                        voca7_ = Float.valueOf(df.format(((float) scrvoca7 / totalvoca7) * 100));

                        voca7_per.setText(Float.toString(voca7_)+" %");

                    }

                    if (categ.equals("Particle")) {


                        while (chkpart7 < scores) {
                            chkpart7 = scores;

                        }

                        _part7 = Integer.toString(chkpart7);
                        part7.setText(_part7);

                        scrpart7 += scores;
                        totalpart7 += totalitem;
                        part7_ = Float.valueOf(df.format(((float) scrpart7 / totalpart7) * 100));

                        part7_per.setText(Float.toString(part7_)+" %");

                    }

                    if (categ.equals("Interrogative")) {


                        while (chkinter7 < scores) {
                            chkinter7 = scores;

                        }

                        _inter7 = Integer.toString(chkinter7);
                        inter7.setText(_inter7);

                        scrinter7 += scores;
                        totalinter7 += totalitem;
                        inter7_ = Float.valueOf(df.format(((float) scrinter7 / totalinter7) * 100));

                        inter7_per.setText(Float.toString(inter7_)+" %");

                    }
                }


                // Lesson 8
                if(lesson.equals("Lesson8")) {


                    if (categ.equals("Vocabulary")) {

                        while (chkvoca8 < scores) {
                            chkvoca8 = scores;

                        }

                        _voca8 = Integer.toString(chkvoca8);
                        voca8.setText(_voca8);

                        scrvoca8 += scores;
                        totalvoca8 += totalitem;
                        voca8_ = Float.valueOf(df.format(((float) scrvoca8 / totalvoca8) * 100));

                        voca8_per.setText(Float.toString(voca8_)+" %");

                    }

                    if (categ.equals("Particle")) {


                        while (chkpart8 < scores) {
                            chkpart8 = scores;

                        }

                        _part8 = Integer.toString(chkpart8);
                        part8.setText(_part8);

                        scrpart8 += scores;
                        totalpart8 += totalitem;
                        part8_ = Float.valueOf(df.format(((float) scrpart8 / totalpart8) * 100));

                        part8_per.setText(Float.toString(part8_)+" %");

                    }

                    if (categ.equals("Interrogative")) {


                        while (chkinter8 < scores) {
                            chkinter8 = scores;

                        }

                        _inter8 = Integer.toString(chkinter8);
                        inter8.setText(_inter8);

                        scrinter8 += scores;
                        totalinter8 += totalitem;
                        inter8_ = Float.valueOf(df.format(((float) scrinter8 / totalinter8) * 100));

                        inter8_per.setText(Float.toString(inter8_)+" %");

                    }
                }

                // Lesson 9
                if(lesson.equals("Lesson9")) {


                    if (categ.equals("Vocabulary")) {

                        while (chkvoca9 < scores) {
                            chkvoca9 = scores;

                        }

                        _voca9 = Integer.toString(chkvoca9);
                        voca9.setText(_voca9);

                        scrvoca9 += scores;
                        totalvoca9 += totalitem;
                        voca9_ = Float.valueOf(df.format(((float) scrvoca9 / totalvoca9) * 100));

                        voca9_per.setText(Float.toString(voca9_)+" %");

                    }

                    if (categ.equals("Particle")) {


                        while (chkpart9 < scores) {
                            chkpart9 = scores;

                        }

                        _part9 = Integer.toString(chkpart9);
                        part9.setText(_part9);

                        scrpart9 += scores;
                        totalpart9 += totalitem;
                        part9_ = Float.valueOf(df.format(((float) scrpart9 / totalpart9) * 100));

                        part9_per.setText(Float.toString(part9_)+" %");

                    }

                    if (categ.equals("Interrogative")) {


                        while (chkinter9 < scores) {
                            chkinter9 = scores;

                        }

                        _inter9 = Integer.toString(chkinter9);
                        inter9.setText(_inter9);

                        scrinter9 += scores;
                        totalinter9 += totalitem;
                        inter9_ = Float.valueOf(df.format(((float) scrinter9 / totalinter9) * 100));

                        inter9_per.setText(Float.toString(inter9_)+" %");

                    }
                }

                // Lesson 10
                if(lesson.equals("Lesson10")){


                    if(categ.equals("Vocabulary")) {


                        while (chkvoca10 < scores) {
                            chkvoca10 = scores;

                        }

                        _voca10 = Integer.toString(chkvoca10);
                        voca10.setText(_voca10);

                        scrvoca10 += scores;
                        totalvoca10 += totalitem;
                        voca10_ = Float.valueOf(df.format(((float) scrvoca10 / totalvoca10) * 100));

                        voca10_per.setText(Float.toString(voca10_)+" %");

                    }

                    if(categ.equals("Particle")) {


                        while (chkpart10 < scores) {
                            chkpart10 = scores;

                        }

                        _part10 = Integer.toString(chkpart10);
                        part10.setText(_part10);

                        scrpart10 += scores;
                        totalpart10 += totalitem;
                        part10_ = Float.valueOf(df.format(((float) scrpart10 / totalpart10) * 100));

                        part10_per.setText(Float.toString(part10_)+" %");

                    }

                    if(categ.equals("Interrogative")) {


                        while (chkinter10 < scores) {
                            chkinter10 = scores;

                        }

                        _inter10 = Integer.toString(chkinter10);
                        inter10.setText(_inter10);

                        scrinter10 += scores;
                        totalinter10 += totalitem;
                        inter10_ = Float.valueOf(df.format(((float) scrinter10 / totalinter10) * 100));

                        inter10_per.setText(Float.toString(inter10_)+" %");

                    }

                }

                // Lesson 11
                if(lesson.equals("Lesson11")){

                    if(categ.equals("Vocabulary")) {


                        while (chkvoca11 < scores) {
                            chkvoca11 = scores;

                        }

                        _voca11 = Integer.toString(chkvoca11);
                        voca11.setText(_voca11);

                        scrvoca11 += scores;
                        totalvoca11 += totalitem;
                        voca11_ = Float.valueOf(df.format(((float) scrvoca11 / totalvoca11) * 100));

                        voca11_per.setText(Float.toString(voca11_)+" %");

                    }

                    if(categ.equals("Particle")) {


                        while (chkpart11 < scores) {
                            chkpart11 = scores;

                        }

                        _part11 = Integer.toString(chkpart11);
                        part11.setText(_part11);

                        scrpart11 += scores;
                        totalpart11 += totalitem;
                        part11_ = Float.valueOf(df.format(((float) scrpart11 / totalpart11) * 100));

                        part11_per.setText(Float.toString(part11_)+" %");

                    }

                    if(categ.equals("Interrogative")) {


                        while (chkinter11 < scores) {
                            chkinter11 = scores;

                        }

                        _inter11 = Integer.toString(chkinter11);
                        inter11.setText(_inter11);

                        scrinter11 += scores;
                        totalinter11 += totalitem;
                        inter11_ = Float.valueOf(df.format(((float) scrinter11 / totalinter11) * 100));

                        inter11_per.setText(Float.toString(inter11_)+" %");

                    }


                }

                // Lesson 12
                if(lesson.equals("Lesson12")) {


                    if (categ.equals("Vocabulary")) {


                        while (chkvoca12 < scores) {
                            chkvoca12 = scores;

                        }

                        _voca12 = Integer.toString(chkvoca12);
                        voca12.setText(_voca12);

                        scrvoca12 += scores;
                        totalvoca12 += totalitem;
                        voca12_ = Float.valueOf(df.format(((float) scrvoca12 / totalvoca12) * 100));

                        voca12_per.setText(Float.toString(voca12_)+" %");

                    }

                    if (categ.equals("Particle")) {


                        while (chkpart12 < scores) {
                            chkpart12 = scores;

                        }

                        _part12 = Integer.toString(chkpart12);
                        part12.setText(_part12);

                        scrpart12 += scores;
                        totalpart12 += totalitem;
                        part12_ = Float.valueOf(df.format(((float) scrpart12 / totalpart12) * 100));

                        part12_per.setText(Float.toString(part12_)+" %");

                    }

                    if (categ.equals("Interrogative")) {


                        while (chkinter12 < scores) {
                            chkinter12 = scores;

                        }

                        _inter12 = Integer.toString(chkinter12);
                        inter12.setText(_inter12);

                        scrinter12 += scores;
                        totalinter12 += totalitem;
                        inter12_ = Float.valueOf(df.format(((float) scrinter12 / totalinter12) * 100));

                        inter12_per.setText(Float.toString(inter12_)+" %");

                    }
                }


                // Lesson 13
                if(lesson.equals("Lesson13")) {


                    if (categ.equals("Vocabulary")) {


                        while (chkvoca13 < scores) {
                            chkvoca13 = scores;

                        }

                        _voca13 = Integer.toString(chkvoca13);
                        voca13.setText(_voca13);

                        scrvoca13 += scores;
                        totalvoca13 += totalitem;
                        voca13_ = Float.valueOf(df.format(((float) scrvoca13 / totalvoca13) * 100));

                        voca13_per.setText(Float.toString(voca13_)+" %");

                    }

                    if (categ.equals("Particle")) {


                        while (chkpart13 < scores) {
                            chkpart13 = scores;

                        }

                        _part13 = Integer.toString(chkpart13);
                        part13.setText(_part13);

                        scrpart13 += scores;
                        totalpart13 += totalitem;
                        part13_ = Float.valueOf(df.format(((float) scrpart13 / totalpart13) * 100));

                        part13_per.setText(Float.toString(part13_)+" %");

                    }

                    if (categ.equals("Interrogative")) {


                        while (chkinter13 < scores) {
                            chkinter13 = scores;

                        }

                        _inter13 = Integer.toString(chkinter13);
                        inter13.setText(_inter13);

                        scrinter13 += scores;
                        totalinter13 += totalitem;
                        inter13_ = Float.valueOf(df.format(((float) scrinter13 / totalinter13) * 100));

                        inter13_per.setText(Float.toString(inter13_)+" %");

                    }
                }

                // Lesson 14
                if(lesson.equals("Lesson14")) {


                    if (categ.equals("Vocabulary")) {


                        while (chkvoca14 < scores) {
                            chkvoca14 = scores;

                        }

                        _voca14 = Integer.toString(chkvoca14);
                        voca14.setText(_voca14);

                        scrvoca14 += scores;
                        totalvoca14 += totalitem;
                        voca14_ = Float.valueOf(df.format(((float) scrvoca14 / totalvoca14) * 100));

                        voca14_per.setText(Float.toString(voca14_)+" %");

                    }

                    if (categ.equals("Particle")) {

                        while (chkpart14 < scores) {
                            chkpart14 = scores;

                        }

                        _part14 = Integer.toString(chkpart14);
                        part14.setText(_part14);

                        scrpart14 += scores;
                        totalpart14 += totalitem;
                        part14_ = Float.valueOf(df.format(((float) scrpart14 / totalpart14) * 100));

                        part14_per.setText(Float.toString(part14_)+" %");

                    }

                    if (categ.equals("Interrogative")) {


                        while (chkinter14 < scores) {
                            chkinter14 = scores;

                        }

                        _inter14 = Integer.toString(chkinter14);
                        inter14.setText(_inter14);

                        scrinter14 += scores;
                        totalinter14 += totalitem;
                        inter14_ = Float.valueOf(df.format(((float) scrinter14 / totalinter14) * 100));

                        inter14_per.setText(Float.toString(inter14_)+" %");

                    }
                }

                // Lesson 15
                if(lesson.equals("Lesson15")){


                    if(categ.equals("Vocabulary")) {


                        while (chkvoca15 < scores) {
                            chkvoca15 = scores;

                        }

                        _voca15 = Integer.toString(chkvoca15);
                        voca15.setText(_voca15);

                        scrvoca15 += scores;
                        totalvoca15 += totalitem;
                        voca15_ = Float.valueOf(df.format(((float) scrvoca15 / totalvoca15) * 100));

                        voca15_per.setText(Float.toString(voca15_)+" %");

                    }

                    if(categ.equals("Particle")) {


                        while (chkpart15 < scores) {
                            chkpart15 = scores;

                        }

                        _part15 = Integer.toString(chkpart15);
                        part15.setText(_part15);

                        scrpart15 += scores;
                        totalpart15 += totalitem;
                        part15_ = Float.valueOf(df.format(((float) scrpart15 / totalpart15) * 100));

                        part15_per.setText(Float.toString(part15_)+" %");

                    }

                    if(categ.equals("Interrogative")) {


                        while (chkinter15 < scores) {
                            chkinter15 = scores;

                        }

                        _inter15 = Integer.toString(chkinter15);
                        inter15.setText(_inter15);

                        scrinter15 += scores;
                        totalinter15 += totalitem;
                        inter15_ = Float.valueOf(df.format(((float) scrinter15 / totalinter15) * 100));

                        inter15_per.setText(Float.toString(inter15_)+" %");

                    }

                }

                // Highest Scores(all lessons)
                // Hiragana
                if(categ.equals("Hiragana")) {


                    while (chkhira < scores) {
                        chkhira = scores;

                    }

                    _hira = Integer.toString(chkhira);
                    hira.setText(_hira);

                }

                // Katakana
                if(categ.equals("Katakana")) {


                    while (chkkata < scores) {
                        chkkata = scores;

                    }

                    _kata = Integer.toString(chkkata);
                    kata.setText(_kata);

                }

                // Kanji
                if(categ.equals("Kanji")) {


                    while (chkkanji < scores) {
                        chkkanji = scores;

                    }

                    _kanji = Integer.toString(chkkanji);
                    kanji.setText(_kanji);

                }

                // With Percentage
                // Vocabulary
                if(categ.equals("Vocabulary")) {

                    scrvoca += scores;
                    totalvoca += totalitem;
                    voca_ = Float.valueOf(df.format(((float)scrvoca / totalvoca)*100));

                    if(voca_>=80){
                        clrvoca = Color.GREEN;
                    } else {
                        clrvoca = Color.RED;
                    }


                    while (chkvoca < scores) {
                        chkvoca = scores;

                    }

                    _voca = Integer.toString(chkvoca);
                    voca.setText(_voca);

                }

                //Particle
                if(categ.equals("Particle")) {

                    scrpart += scores;
                    totalpart += totalitem;
                    part_ = Float.valueOf(df.format(((float)scrpart / totalpart)*100));

                    if(part_>=80){
                        clrpart = Color.GREEN;
                    } else {
                        clrpart = Color.RED;
                    }

                    while (chkpart < scores) {
                        chkpart = scores;

                    }

                    _part = Integer.toString(chkpart);
                    part.setText(_part);

                }

                // Interrogative
                if(categ.equals("Interrogative")) {

                    scrinter += scores;
                    totalinter += totalitem;
                    inter_ = Float.valueOf(df.format(((float)scrinter / totalinter)*100));

                    if(inter_>=80){
                        clrinter = Color.GREEN;
                    } else {
                        clrinter = Color.RED;
                    }

                    while (chkinter < scores) {
                        chkinter = scores;

                    }

                    _inter = Integer.toString(chkinter);
                    inter.setText(_inter);

                }

            }
        }


        // Bar Graph

        barChart = (BarChart) findViewById(R.id.BarGraph);


        ArrayList<BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(voca_, 0));
        barEntries.add(new BarEntry(part_, 1));
        barEntries.add(new BarEntry(inter_, 2));
        BarDataSet barDataSet = new BarDataSet(barEntries, "Percentage");
        barDataSet.setColors(new int[]{clrvoca, clrpart, clrinter});

        ArrayList<String> prog = new ArrayList<>();
        prog.add("Vocabulary");
        prog.add("Particle");
        prog.add("Interrogative");

        BarData percentage = new BarData(prog, barDataSet);
        barChart.setData(percentage);

        barChart.setTouchEnabled(false);
        barChart.setDragEnabled(false);
        barChart.setScaleEnabled(false);


       

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent i = new Intent(Report.this,menu.class);
                        i.putExtra("uname", t_uname.getText().toString());
                        startActivity(i);
                        break;
                    case R.id.navigation_account:
                        Intent i2 = new Intent(Report.this,Account.class);
                        i2.putExtra("uname", t_uname.getText().toString());
                        startActivity(i2);
                        break;
                    case R.id.navigation_lesson:
                        Intent i3 = new Intent(Report.this,Lessons.class);
                        i3.putExtra("uname", t_uname.getText().toString());
                        startActivity(i3);
                        break;
                    case R.id.navigation_exam:
                        Intent i4 = new Intent(Report.this,Exam.class);
                        i4.putExtra("uname", t_uname.getText().toString());
                        startActivity(i4);
                        break;
                }
                return false;

            }
        });
    }
}