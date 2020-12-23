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


public class Exam11_Vocab extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson11", examcategory = "Vocabulary";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"こども　が　います","to have a child"},
            {"にほん　に　います","to stay in japan"},
            {"かかります","to take time"},
            {"ひとつ","one"},
            {"ふたつ","two"},
            {"みっつ","three"},
            {"よっつ","four"},
            {"いつつ","five"},
            {"むっつ","six"},
            {"ななつ","seven"},
            {"やっつ","eight"},
            {"ここのつ","nine"},
            {"とお","ten"},
            {"いくつ","how many"},
            {"ひとり","one person"},
            {"ふたり","two person"},
            {"ーにん","suffix for counting person"},
            {"ーだい","suffix for counting machines"},
            {"ーまい","suffix for counting flat and thin things"},
            {"ーかい","suffix for frequency"},
            {"ーこ","suffix for counting small things"},
            {"きょうだい","brothers and sisters"},
            {"きっぷ","ticket"},
            {"ふうとう","envelope"},
            {"きって","postage stamp"},
            {"エアメール","airmail"},
            {"にもつ","parcel"},
            {"いちにち","one day"},
            {"ーじかん","hour"},
            {"ーしゅうかん","week"},
            {"ーかげつ","month"},
            {"ーねん","year"},
            {"どのくらい","how long/how many"},
            {"ーぐらい","about"},
            {"ぜんぶで","in total"},
            {"ーだけ","only"},
            {"たぶん","probably"},
            {"きっと","surely"},
            {"to have a child","こども　が　います"},
            {"to stay in japan","にほん　に　います"},
            {"to take time","かかります"},
            {"one","ひとつ"},
            {"two","ふたつ"},
            {"three","みっつ"},
            {"four","よっつ"},
            {"five","いつつ"},
            {"six","むっつ"},
            {"seven","ななつ"},
            {"eight","やっつ"},
            {"nine","ここのつ"},
            {"ten","とお"},
            {"how many","いくつ"},
            {"one person","ひとり"},
            {"two person","ふたり"},
            {"suffix for counting person","にん"},
            {"suffix for counting machines","だい"},
            {"suffix for counting flat and thin things","まい"},
            {"suffix for frequency","かい"},
            {"suffix for counting small things","こ"},
            {"brothers and sisters","きょうだい"},
            {"ticket","きっぷ"},
            {"envelope","ふうとう"},
            {"postage stamp","きって"},
            {"airmail","エアメール"},
            {"parcel","にもつ"},
            {"one day","いちにち"},
            {"hour","じかん"},
            {"week","しゅうかん"},
            {"month","かげつ"},
            {"year","ねん"},
            {"how long/how many","どのくらい"},
            {"about","ぐらい"},
            {"in total","ぜんぶで"},
            {"only","だけ"},
            {"probably","たぶん"},
            {"surely","きっと"},





    };


    public Exam11_Vocab() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam11_vocab, container, false);

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

        countLabel.setText("問題 " + quizCount);

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
