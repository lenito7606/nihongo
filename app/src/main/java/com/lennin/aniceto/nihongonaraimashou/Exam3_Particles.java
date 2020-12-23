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


public class Exam3_Particles extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson3", examcategory = "Particle";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"koko ___ heya desu ka. soko ___ heya desu ka.","wa/mo"},
            {"kono kamera ___ nihon ___ desu ka.","wa/no"},
            {"toire ___ koko desu ka. hai soko ___.","wa/desu"},
            {"arnold san ___ kuni ___ firipin ___ manila desu.","no/wa/no"},
            {"asoko ___ kyoushitsu desu ___... hai kyoushitsu desu.","wa/ka"},
            {"chii san ___ daigaku wa asoko ___ ka... hai asoko desu.","no/desu"},
            {"kent san ___ daigaku ___ koko desu.","no/wa"},
            {"kaigishitsu ___ doko desu ___... achira desu.","wa/ka"},
            {"kono kaban ___ amerika ___ desu ka.","wa/no"},
            {"koko ___ toire desu ___... iie asoko desu.","wa/ka"},
            {"kyoushitsu ___ koko desu ka... iie koko dewa ___.","wa/arimasen"},
            {"kaban uriba ___ sangai desu ka... ___ sangai ja arimsen.","wa/iie"},
            {"shokudou wa achira desu ___... ___ achira desu.","ka/hai"},
            {"soko ___ toire desu. asoko ___ toire desu ka.","wa/mo"},
            {"smith san ___ kuni wa doko ___ ka.","no/desu"},
            {"kore ___ nihon ___ jidousha desu ka.","wa/no"},
            {"renin san ___ kaisha wa doko desu ___.","no/ka"},
            {"veen san ___ kaisha ___ koko desu.","no/wa"},
            {"kono enpitsu wa firipin ___ manila ___ desu.","no/no"},
            {"toire ___ hakkai desu ___ hai hakkai ___.","wa/ka/desu"},



    };


    public Exam3_Particles() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam3_particles, container, false);

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
