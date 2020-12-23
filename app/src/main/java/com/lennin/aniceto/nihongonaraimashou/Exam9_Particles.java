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


public class Exam9_Particles extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson9", examcategory = "Particle";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"どんな　たべもの___すき　です___。　にほんりょうり___すき　です。","が／か／が"},
            {"ちい　さん___うた___へた　です。","は／が"},
            {"レン　さん___かんじ___ぜんぜん　わかりません。","は／が"},
            {"アルノード　さん　は　えいご___わかります___。　はい　だいたい　わかります。","が／か"},
            {"どうして　きのう___ばん　やすみました。　ねつ___あります___。","の／が／から"},
            {"どんな　たべも___きらい　です___。　やさい　が　きらい　です。","が／か"},
            {"レン　さん___にほん___すき　です。","は／が"},
            {"どうして　にほんご___えいが___みません　か。　にほんご　が　わかりません___。","の／を／から"},
            {"わたし___にほんご___ぜんぜん　わかりません。","は／が"},
            {"あなた___おかね___あります___。　はい　すこし　あります。","は／が／か"},
            {"ほむら　さん　は　ダンス___じょうず　です　か。　___とても　じょうず　です。","が／はい"},
            {"はは___りょうり___あまり　じょうず　じゃ　ありません。","は／が"},
            {"どうして　にほんご___べんきょう　します___。　にほん___いきます　から。","を／か／へ"},
            {"おかね___ありません___なに___かいませんでした。","が／から／も"},
            {"わたし　は　くるま___じてんしゃ___あります。","と／が"},
            {"きむら　さん　は　どうして　かんこくご___ほん___かいました　か。","mo"},
            {"どんな　スポーツ___すき　です___。　テニス___すき　です","が／か／が"},
            {"みやび　さん___どんな　えいが___きらい　です　か。","は／が"},
            {"どうして　にほんご___わかりません___。　ぜんぜん　べんきょう　しません___","が／か／から"},
            {"わたし___うた___ダンス___あまり　じょうず　じゃ　ありません。","は／と／が"},



    };


    public Exam9_Particles() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam9_particles, container, false);

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
