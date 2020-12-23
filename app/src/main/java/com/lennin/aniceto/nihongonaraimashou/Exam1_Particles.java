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


public class Exam1_Particles extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson1", examcategory = "Particle";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"anata ___ nihongo ___ sensei desu ka.","wa/no"},
            {"watashi wa kankokugo ___ sensei desu. kim san ___ kankokugo ___ sensei desu.","no/mo/no"},
            {"inou san ___ ginkouin desu ___... iie ginkouin ja arimasen.","wa/ka"},
            {"erick san ___ UP ___ daigakusei desu.","wa/no"},
            {"ano kata ___ PAL ___ kaishain.","wa/no"},
            {"kimura san wa PALDC ___ kenshuusei desu. watashi ___ PALDC ___ kenshuusei desu.","no/mo/no"},
            {"anata ___ hatachi desu ___... hai hatachi desu.","wa/ka"},
            {"hikari san ___ cebu pacific ___ kaishain desu.","wa/no"},
            {"watashi ___ gakusei desu.","wa"},
            {"kimura san wa sensei desu. anata ___ sensei desu ka.","mo"},
            {"inoue san ___ nihonjin desu ___... hai inoue san ___ nihonjin desu.","wa/ka/wa"},
            {"watashi ___ firipinjin ___.","wa/desu"},
            {"arnold san ___ firipinjin desu ___...___ firipin jin dewa arimasen.","wa/ka/iie"},
            {"arnold san wa firipinjin desu ___...___ firipin jin desu.","ka/hai"},
            {"yamashita san ___ nihongo ___ sensei desu.","wa/no"},
            {"rizza san wa firipin ___ metrobank ___ ginkouin desu.","no/no"},
            {"euly san ___ gakusei desu. roanne san ___ gakusei desu.","wa/mo"},
            {"ano kata ___ ryan san desu ___... hai ryan san ___.","wa/ka/desu"},
            {"chii san ___ cavite state ___ daigakusei desu ka.","wa/no"},
            {"karol san wa cavite state ___ daigakusei desu. watashi ___ cavite state ___ daigakusei desu.","no/mo/no"},



    };


    public Exam1_Particles() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam1_particles, container, false);

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

        countLabel.setText("Mondai " + quizCount);

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
