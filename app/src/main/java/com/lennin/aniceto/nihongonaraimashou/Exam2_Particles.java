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


public class Exam2_Particles extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson2", examcategory = "Particle";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"kore ___ nihongo ___ hon desu.","wa/no"},
            {"kono zasshi ___ dare ___ desu ka.","wa/no"},
            {"are wa watashi ___ kaban desu. kore ___ watashi no desu.","no/mo"},
            {"watashi ___ namae ___ renin desu.","no/wa"},
            {"anata ___ namae ___ nan desu ka.","no/wa"},
            {"sore wa arnold san ___ kankoku go ___ hon desu.","no/no"},
            {"ano zasshi wa anata ___ desu ___... hai watashi ___ desu.","no/ka/no"},
            {"kore wa darveen san ___ firipin go ___ hon desu ka.","no/no"},
            {"kore ___ hon desu ka.","wa"},
            {"sore ___ nan ___ jidousha desu ka.","wa/no"},
            {"ano kamera wa watashi ___ nikon ___ kamera desu.","no/no"},
            {"sore wa anata ___ tokei desu ka... iie watashi ___ ja arimasen. ai san ___ desu.","no/no/no"},
            {"kono kagi ___ arnold san ___ desu ___... iie arnold san no dewa arimasen.","wa/no/ka"},
            {"ano jidousha wa kimura san ___ desu ___... hai kimura san no ___.","no/ka/desu"},
            {"kore wa nan ___ jidousha desu ka... honda ___ jidousha desu.","no/no"},
            {"are wa chii san ___ chuugoku ___ zasshi desu.","no/no"},
            {"are wa watashi ___ desu ka... hai anata no ___.","no/desu"},
            {"kono kaban ___ nan ___ kaban desu ka.","wa/no"},
            {"kore ___ nan ___ jisho desu ___... oxford ___ jishou desu.","wa/no/ka/no"},
            {"kore ___ anata ___ desu ka. hai watashi no desu.","wa/no"},



    };


    public Exam2_Particles() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam2_particles, container, false);

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
