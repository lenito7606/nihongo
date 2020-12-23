package com.lennin.aniceto.nihongonaraimashou;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ExamKanji extends AppCompatActivity {
    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Writings", examcategory = "Kanji";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 15;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"名前","なまえ"},
            {"一","いち"},
            {"二","に"},
            {"三","さん"},
            {"四","よん／し"},
            {"五","ご"},
            {"六","ろく"},
            {"七","なな／しち"},
            {"八","はち"},
            {"九","きゅう／く"},
            {"十","じゅう"},
            {"月","つき"},
            {"一月","いちがつ"},
            {"二月","にがつ"},
            {"三月","さんがつ"},
            {"四月","しがつ"},
            {"五月","ごがつ"},
            {"六月","ろくがつ"},
            {"七月","しちがつ"},
            {"八月","はちがつ"},
            {"九月","くがつ"},
            {"十月","じゅうがつ"},
            {"十一月","じゅういちがつ"},
            {"十二月","じゅうにがつ"},
            {"大学","だいがく"},
            {"大きい","おおきい"},
            {"会います","あいます"},
            {"行きます","いきます"},
            {"来ます","きます"},
            {"今","いま"},
            {"国","くに"},
            {"中国","ちゅうごく"},
            {"人","ひと"},
            {"本","ほん"},
            {"日本","にほん"},
            {"今日","きょう"},
            {"日本人","にほんじん"},
            {"日本語","にほんご"},
            {"今年","ことし"},
            {"来年","らいねん"},
            {"今月","こんげつ"},
            {"来月","らいげつ"},
            {"車","くるま"},
            {"見ます","みます"},
            {"友だち","ともだち"},
            {"百円","ひゃくえん"},
            {"三千","さんぜん"},
            {"八千","はっせん"},
            {"三百","さんびゃく"},
            {"六百","ろっぴゃく"},
            {"八百","はっぴゃく"},
            {"何人","なんにん"},
            {"何日","なんにち"},
            {"何月","なんがつ"},
            {"上","うえ"},
            {"下","した"},
            {"左","ひだり"},
            {"右","みぎ"},
            {"中","なか"},
            {"一分","いっぷん"},
            {"二分","にふん"},
            {"三分","さんぷん"},
            {"四分","よんぷん"},
            {"五分","ごふん"},
            {"六分","ろっぷん"},
            {"七分","ななふん"},
            {"八分","はっぷん"},
            {"九分","きゅうふん"},
            {"十分","じゅっぷん"},
            {"午前","ごぜん"},
            {"月曜日","げつようび"},
            {"火曜日","かようび"},
            {"水曜日","すいようび"},
            {"木曜日","もくようび"},
            {"金曜日","きんようび"},
            {"土曜日","どようび"},
            {"日曜日","にちようび"},
            {"四時","よじ"},
            {"九時","くじ"},
            {"七時","しちじ"},





    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_kanji);
        countLabel = (TextView)findViewById(R.id.countlabel);
        questionLabel = (TextView)findViewById(R.id.questionlabel);
        ei = (TextView)findViewById(R.id.ei);
        answertext = (EditText)findViewById(R.id.answertext);
        answerBtn = (Button)findViewById(R.id.next);


        ei.setText(getIntent().getStringExtra("uname"));


        for(int i = 0; i<quizData.length; i++) {

            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);

            quizArray.add(tmpArray);

        }

        showNextQuiz();

        answerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = answertext.getText().toString().toLowerCase();

                String alertTitle;

                if(answer.equals(rightAnswer)) {

                    alertTitle = "Correct";
                    rightAnswerCount ++;
                    answertext.setText("");

                } else {

                    alertTitle = "Wrong";
                    answertext.setText("");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(ExamKanji.this);
                builder.setTitle(alertTitle);
                builder.setMessage("Answer : " + rightAnswer);
                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (quizCount == QUIZ_COUNT) {

                            Intent intent = new Intent(ExamKanji.this, ResultActivity.class);
                            intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                            intent.putExtra("QUIZ_COUNT", QUIZ_COUNT);
                            intent.putExtra("lessonnum", lessonnum);
                            intent.putExtra("examcategory", examcategory);
                            intent.putExtra("uname", ei.getText().toString());
                            startActivity(intent);

                        } else {

                            quizCount++;
                            showNextQuiz();

                        }
                    }
                });

                builder.setCancelable(false);
                builder.show();

            }
        });

    }

    public void showNextQuiz() {

        countLabel.setText("問題 " + quizCount);

        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomNum);

        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);


        quiz.remove(0);
        Collections.shuffle(quiz);



        quizArray.remove(randomNum);


    }

}
