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


public class Exam5_Interrogatives extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson5", examcategory = "Interrogative";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"jovan san wa ______ nihon e kimashita ka… kyonen no ichi gatsu kimashita.","itsu"},
            {"veen san no tanjoubi  wa ______ ______ desu ka… juu ni gatsu ni juu ni nichi desu.","nan gatsu/nan nichi"},
            {"otanjoubi wa ______ desu ka… ichi gatsu itsuka desu.","itsu"},
            {"valentine wa ______ ______ desu ka… ni gatsu juu yokka desu.","nan gatsu/nan nichi"},
            {"anata wa kesa ______ ikimashita ka... su-pa- e ikimashita.","doko e"},
            {"karol san wa mainichi ______ daigaku e ikimasu ka… hitori de ikimasu.","dare to"},
            {"arnold san wa ______ honya e ikimashita ka… jitensha de ikimashita.","nan de"},
            {"renin san wa raishuu no kinyoubi ______ ikimasu ka… nihon e ikimasu.","doko e"},
            {"anata wa senshuu no getsuyoubi ni ______ to jimusho e kimashita ka… kaisha no hito to kimashita.","dare"},
            {"kyou wa ______ desu ka… hatsuka desu.","nan nichi"},
            {"kinou wa ______ deshita ka… juu yokka deshita.","nan nichi"},
            {"raishuu wa ______ desu ka… go gatsu desu.","nan gatsu"},
            {"sengetsu wa ______ deshita ka… hai ni gatsu deshita.","ni gatsu"},
            {"homura san wa kinou no ban ______ e ikimashita ka… honya e ikimashita.","doko"},
            {"ashita wa ______ desu ka… hai itsuka desu.","itsuka"},
            {"hikari san wa rainen no ichi gatsu ______ e ikimasu ka… uchi e kaerimasu ka.","doko"},
            {"anata wa ______ firipin e kaerimasu ka… raishuu kaerimasu.","itsu"},
            {"renin san wa ashita no asa ______ e ikimasu ka… hai su-pa- e ikimasu.","doko"},
            {"yamada san wa ______ amerika e ikimashita ka… tomodachi to ikimashita.","dare to"},
            {"inoue san wa ______ Hiroshima e ikimashita ka… shinkansen de ikimashita.","nan de"},
            {"anata wa ______ byouin e ikimashita ka… aruite ikimashita.","nan de"},
            {"ai san wa kyou ______e kaerimasu ka… iie kyou ryou e kaerimasen.","ryou"},
            {"asatte wa ______ desu ka… hai hatsuka desu.","hatsuka"},
            {"kent san wa ______ to doitsu e ikimashita ka… hitori de ikimashita.","dare"},
            {"kyou wa ______ desu ka… iie tsuitachi ja arimasen. futsuka desu.","tsuitachi"}



    };


    public Exam5_Interrogatives() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam5_interrogatives, container, false);

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
