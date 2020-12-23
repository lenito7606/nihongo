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


public class Exam5_Vocab extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson5", examcategory = "Vocabulary";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"ikimasu","to go"},
            {"kimasu","to come"},
            {"kaerimasu","to go home/to return"},
            {"koujou","factory"},
            {"eki","railway station"},
            {"byouin","hospital"},
            {"depa-to","department store"},
            {"su-pa-","supermarket"},
            {"honya","bookshop"},
            {"ryou","dormitory"},
            {"gatsu","suffix for month"},
            {"nan gatsu","what month"},
            {"tsuitachi","first of the month"},
            {"futsuka","second/two days"},
            {"mikka","third/three days"},
            {"yokka","fourth/four days"},
            {"itsuka","fifth/five days"},
            {"muika","sixth/six days"},
            {"nanoka","seventh/seven days"},
            {"youka","eighth/eight days"},
            {"kokonoka","ninth/nine days"},
            {"tooka","tenth/ten days"},
            {"juuyokka","fourteenth/fourteen days"},
            {"hatsuka","twentieth/twenty days"},
            {"nijuu yokka","twenty fourth/twenty four days"},
            {"nichi","day of the month/days"},
            {"nan nichi","which day of the month/how many days"},
            {"itsu","when"},
            {"senshuu","last week"},
            {"konshuu","this week"},
            {"raishuu","next week"},
            {"sengetsu","last month"},
            {"kongetsu","this month"},
            {"raigetsu","next month"},
            {"kyonen","last year"},
            {"kotoshi","this year"},
            {"rainen","next year"},
            {"tanjoubi","birthday"},
            {"jitensha","bicycle"},
            {"hikouki","airplane"},
            {"fune","ship"},
            {"densha","electric train"},
            {"busu","bus"},
            {"takushi-","taxi"},
            {"chikatetsu","subway"},
            {"shinkansen","bullet train"},
            {"aruite","by foot"},
            {"tomodachi","friend"},
            {"koibito","sweetheart"},
            {"hitori de","alone"},
            {"to go","ikimasu"},
            {"to come","kimasu"},
            {"to go home/to return","kaerimasu"},
            {"factory","koujou"},
            {"railway station","eki"},
            {"hospital","byouin"},
            {"department store","depa-to"},
            {"supermarket","su-pa-"},
            {"bookshop","honya"},
            {"dormitory","ryou"},
            {"suffix for month","gatsu"},
            {"what month","nan gatsu"},
            {"first of the month","tsuitachi"},
            {"second/two days","futsuka"},
            {"third/three days","mikka"},
            {"fourth/four days","yokka"},
            {"fifth/five days","itsuka"},
            {"sixth/six days","muika"},
            {"seventh/seven days","nanoka"},
            {"eighth/eight days","youka"},
            {"ninth/nine days","kokonoka"},
            {"tenth/ten days","tooka"},
            {"fourteenth/fourteen days","juuyokka"},
            {"twentieth/twenty days","hatsuka"},
            {"twenty fourth/twenty four days","nijuu yokka"},
            {"day of the month/days","nichi"},
            {"which day of the month/how many days","nan nichi"},
            {"when","itsu"},
            {"last week","senshuu"},
            {"this week","konshuu"},
            {"next week","raishuu"},
            {"last month","sengetsu"},
            {"this month","kongetsu"},
            {"next month","raigetsu"},
            {"last year","kyonen"},
            {"this year","kotoshi"},
            {"next year","rainen"},
            {"birthday","tanjoubi"},
            {"bicycle","jitensha"},
            {"airplane","hikouki"},
            {"ship","fune"},
            {"electric train","densha"},
            {"bus","busu"},
            {"taxi","rakushi-"},
            {"subway","chikatetsu"},
            {"bullet train","shinkansen"},
            {"by foot","aruite"},
            {"friend","tomodachi"},
            {"sweetheart","koibito"},
            {"alone","hitori de"},





    };


    public Exam5_Vocab() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam5_vocab, container, false);

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
