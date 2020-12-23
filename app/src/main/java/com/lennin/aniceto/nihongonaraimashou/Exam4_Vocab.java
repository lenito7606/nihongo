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


public class Exam4_Vocab extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson4", examcategory = "Vocabulary";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"okimasu","to wake up"},
            {"nemasu","to sleep"},
            {"hatarakimasu","to work"},
            {"yasumimasu","to take a rest"},
            {"benkyou shimasu","to study"},
            {"kyuukei shimasu","to take a break"},
            {"owarimasu","to finish"},
            {"ima","now"},
            {"ji","suffix for time"},
            {"fun/pun","suffix for minutes"},
            {"nanji","what time"},
            {"nanpun","how many minutes"},
            {"gozen","am"},
            {"gogo","pm"},
            {"asa","morning"},
            {"hiru","noon"},
            {"ban/yoru","night/evening"},
            {"ototoi","the day before yesterday"},
            {"kinou","yesterday"},
            {"kyou","today"},
            {"ashita","tomorrow"},
            {"asatte","the day after tomorrow"},
            {"kesa","this morning"},
            {"konban","tonight"},
            {"maiasa","every morning"},
            {"maiban","every night"},
            {"mainichi","every day"},
            {"eigo","english language"},
            {"benykou","study"},
            {"yasumi","day off"},
            {"kougi","lecture"},
            {"kengaku","visit for study"},
            {"kara","from"},
            {"made","up to/until"},
            {"nichiyoubi","sunday"},
            {"getsuyoubi","monday"},
            {"kayoubi","tuesday"},
            {"suiyoubi","wednesday"},
            {"mokuyoubi","thursday"},
            {"kinyoubi","friday"},
            {"doyoubi","saturday"},
            {"nanyoubi","what day of the week"},
            {"to wake up","okimasu"},
            {"to sleep","nemasu"},
            {"to work","hatarakimasu"},
            {"to take a rest","yasumimasu"},
            {"to study","benkyou shimasu"},
            {"to take a break","kyuukei shimasu"},
            {"to finish","owarimasu"},
            {"now","ima"},
            {"suffix for time","ji"},
            {"suffix for minutes","fun/pun"},
            {"what time","nanji"},
            {"how many minutes","nanpun"},
            {"am","gozen"},
            {"pm","gogo"},
            {"morning","asa"},
            {"noon","hiru"},
            {"night/evening","ban/yoru"},
            {"the day before yesterday","ototoi"},
            {"yesterday","kinou"},
            {"today","kyou"},
            {"tomorrow","ashita"},
            {"the day after tomorrow","asatte"},
            {"this morning","kesa"},
            {"tonight","konban"},
            {"every morning","maiasa"},
            {"every night","maiban"},
            {"every day","mainichi"},
            {"english language","eigo"},
            {"study","benykou"},
            {"day off","yasumi"},
            {"lecture","kougi"},
            {"visit for study","kengaku"},
            {"from","kara"},
            {"up to/until","made"},
            {"sunday","nichiyoubi"},
            {"monday","getsuyoubi"},
            {"tuesday","kayoubi"},
            {"wednesday","suiyoubi"},
            {"thursday","mokuyoubi"},
            {"friday","kinyoubi"},
            {"saturday","doyoubi"},
            {"what day of the week","nanyoubi"},





    };


    public Exam4_Vocab() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam4_vocab, container, false);

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
