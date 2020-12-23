package com.lennin.aniceto.nihongonaraimashou;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Exam9_Interrogatives extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson9", examcategory = "Interrogative";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"______かいしゃ　を　やすみました　か。ねつ　が　あります　から　かいしゃ　を　やすみました。","どうして"},
            {"______が　わかります　か。いいえ　にほんご　が　ぜんぜん　わかりません。","にほんご"},
            {"______たべもの　が　すき　です　か。　すし　が　すき　です。","どんな"},
            {"______りょうり　が　すき　です　か。　にほん　りょうり　が　すき　です。","どんな"},
            {"ちい　さん　は______あの　デパート　で　くつ　を　かいました　か。　やすい　です　から。","どうして"},
            {"______が　じょうず　です　か。はい　ダンス　が　じょうず　です。","ダンス"},
            {"アルノード　は______すき　です　か。　はい　テニス　が　すき　です。","テニスが"},
            {"______のみもの　が　すき　です　か。ビール　が　すき　です。","どんな"},
            {"______えいご　が　わかります　か。　えいご　を　べんきょう　しました　から。","どうして"},
            {"あなた　は______が　あります　か。はい　じしょ　が　あります。"," じしょ"},
            {"______が　わかります　か。　はい　かんじ　が　すこし　わかります。","かんじ"},
            {"あい　さん　は______スポーツ　が　すき　です　か。テニス　が　すき　です。","どんな"},
            {"やまだ　さん　は______が　へた　です　か。　はい　ダンス　が　とても　へた　です。","ダンス"},
            {"ほむら　さん　は______が　わかります　か。　いいえ　にほんご　が　ぜんぜん　わかりません。","にほんご"},
            {"ひかり　さん　は______あります　か。　はい　でんわ　が　あります。","でんわが"},
            {"レニン　さん　は______すき　です　か。　はい　チョコレート　が　とても　すき　です。","チョコレートが"},
            {"ヴィンセント　さん　は______あります　か。はい　じてんしゃ　が　あります。","じてんしゃ"},
            {"______アメリカ　へ　いきます　か。　えいご　を　べんきょう　します　から。","どうして"},
            {"ヴェン　さん　は　まいばん______アニメ　を　みます　か。　アニメ　が　すき　です　から。","どうして"},
            {"______カメラ　を　かいませんでした　か。おかね　が　ありませんでした　から。","どうして"},
            {"______カメラ　が　すき　です　か。　いい　です　そして　あたらしい　カメラ　が　すき　です。","どんな"},
            {"ちい　さん　は______あります　か。　はい　ほん　が　あります","ほんが"},
            {"______が　あります　か。　いいえ　えんぴつ　が　ありません。","えんぴつ"},
            {"レン　さんは______が　わかります　か。　はい　ひらがな　が　だいたい　わかります。", "ひらがな"},
            {"たなか　さん　は______が　わかります　か。　いいえ　えいご　が　ぜんぜん　わかりません。","えいご"}



    };


    public Exam9_Interrogatives() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam9_interrogatives, container, false);

        return view;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        countLabel = view.findViewById(R.id.countlabel);
        questionLabel = view.findViewById(R.id.questionlabel);
        ei = view.findViewById(R.id.ei);
        answertext = view.findViewById(R.id.answertext);
        answerBtn = view.findViewById(R.id.next);


        ei.setText(getActivity().getIntent().getStringExtra("uname"));


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

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(alertTitle);
                builder.setMessage("Answer : " + rightAnswer);
                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (quizCount == QUIZ_COUNT) {

                            Intent intent = new Intent(getActivity(), ResultActivity.class);
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

        countLabel.setText("もんだい " + quizCount);

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
