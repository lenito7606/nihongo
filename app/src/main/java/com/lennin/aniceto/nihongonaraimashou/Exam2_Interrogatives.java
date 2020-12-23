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


public class Exam2_Interrogatives extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson2", examcategory = "Interrogative";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"kore wa ______ desu ka... sore hon desu.","nan"},
            {"are wa ______ desu ka... hai zasshi desu.","zasshi"},
            {"onamae wa ______ desu ka... watashi wa renin desu.","nan"},
            {"onamae  wa ______ desu ka... watashi no namae wa ai desu.","nan"},
            {"kore wa ______ kaban desu ka... watashi no kaban desu.","dare no"},
            {"are wa ______ desu ka... are wa shinbun desu.","nan"},
            {"kore wa ______ desu ka... hai watashi no desu.","anata no"},
            {"kono hako wa ______ desu ka... ai san no desu.","dare no"},
            {"sono tsukue wa ______ desu ka... iie arnold san no ja arimasen. watashi no desu.","arnold san no"},
            {"kore wa ______ kaban desu ka... jansport no kaban desu.","nan no"},
            {"kono tokei wa ______ no desu ka... g-shock no tokei desu.","nan"},
            {"sono tokei wa ______ no desu ka... jovan san no tokei desu.","dare"},
            {"kore wa ______ desu ka... hai anata no desu.","watashi no"},
            {"are wa ______ desu ka... are wa kagi desu.","nan"},
            {"kono hon wa ______ desu ka... nihongo no hon desu.","nan no"},
            {"sore wa ______ desu ka... iie zasshi dewa arimasen.","zasshi"},
            {"kore wa ______ kamera desu ka... nikon no kamera desu.","nan no"},
            {"kono kamera wa ______ desu ka... renin san no desu.","dare no"},
            {"sono kamera wa ______ no desu ka... renin san no desu.","dare"},
            {"sore wa ______ no hon desu ka. nihongo no hon desu.","nan"},
            {"ano hon wa ______ no desu ka... hai chii san no desu.","chii san"},
            {"sore wa ______ desu ka... haizara desu.","nan"},
            {"are wa ______ desu ka... hai hon desu.","hon"},
            {"kore wa ______ jidousha desu ka... toyota no dijousha desu.","nan no"},
            {"kono denwa wa ______ no desu ka... iie darwynn san no ja arimasen. darveen san no desu.","darwynn san"}



    };


    public Exam2_Interrogatives() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam2_interrogatives, container, false);

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
