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


public class Exam2_Vocab extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson2", examcategory = "Vocabulary";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"kore","this thing here"},
            {"sore","that thing near you"},
            {"are","that thing over there"},
            {"hon","book"},
            {"zasshi","magazine"},
            {"jisho","dictionary"},
            {"no-to","notebook"},
            {"kami","paper"},
            {"shinbun","newspaper"},
            {"tegami","letter"},
            {"enpitsu","pencil"},
            {"bo-rupen","ball pen"},
            {"sha-pu penshiru","mechanical pencil"},
            {"tabako","cigarette"},
            {"matchi","match"},
            {"raita-","lighter"},
            {"haizara","ashtray"},
            {"kagi","key"},
            {"tokei","watch/clock"},
            {"kaban","bag"},
            {"hako","box"},
            {"te-pu reko-da-","tape recorder"},
            {"denwa","telephone"},
            {"isu","chair"},
            {"tsukue","desk"},
            {"mado","window"},
            {"doa","door"},
            {"rajio","radio"},
            {"terebi","television"},
            {"kamera","camera"},
            {"namae","name"},
            {"shigoto","work"},
            {"nan/nani","what"},
            {"this thing here","kore"},
            {"that thing near you","sore"},
            {"that thing over there","are"},
            {"book","hon"},
            {"magazine","zasshi"},
            {"dictionary","jisho"},
            {"notebook","no-to"},
            {"paper","kami"},
            {"newspaper","shinbun"},
            {"letter","tegami"},
            {"pencil","enpitsu"},
            {"ball pen","bo-rupen"},
            {"mechanical pencil","sha-pu penshiru"},
            {"cigarette","tabako"},
            {"match","matchi"},
            {"lighter","raita-"},
            {"ashtray","haizara"},
            {"key","kagi"},
            {"watch/clock","tokei"},
            {"bag","kaban"},
            {"box","hako"},
            {"tape recorder","te-pu reko-da-"},
            {"telephone","denwa"},
            {"chair","isu"},
            {"desk","tsukue"},
            {"window","mado"},
            {"door","doa"},
            {"radio","rajio"},
            {"television","terebi"},
            {"camera","kamera"},
            {"name","namae"},
            {"work","shigoto"},
            {"what","nan/nani"},



    };


    public Exam2_Vocab() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam2_vocab, container, false);

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
