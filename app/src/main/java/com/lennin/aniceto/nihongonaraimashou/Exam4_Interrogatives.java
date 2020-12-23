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


public class Exam4_Interrogatives extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson4", examcategory = "Interrogative";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"ima ______ desu ka... ima kuji han desu.","nanji"},
            {"ashita ______ desu ka... ashita doyoubi desu.","nanyoubi"},
            {"shigoto wa ______ kara ______ made desu ka... kuji kara hachi made desu.","nanji/nanji"},
            {"chiie san wa mainichi ______ ni okimasu ka... yoji han ni okimasu.","nanji"},
            {"arnold san no daigaku wa ______ kara ______ made desu. getsuyoubi kara kinyoubi made desu.","nanyoubi/nanyoubi"},
            {"anata wa mainichi ______ ni okimasu ka... hachiji ni okimasu.","nanji"},
            {"shigoto no yasumi wa ______ to ______ desu ka... hai doyoubi to nichiyoubi desu.","doyoubi/nichiyoubi"},
            {"jovan san wa kesa ______ okimashita ka. juu ichiji han ni okimashita.","nanji ni"},
            {"ima ______ desu ka... iie shichiji ja arimasen. hachiji desu.","shichiji"},
            {"jovan san wa maiban ______ ka... iie benkyoushimasen.","benkyoushimasu"},
            {"kyou wa ______ desu ka... getsuyoubi desu.","nanyoubi"},
            {"ototoi wa ______ deshita ka... hai mokuyoubi deshita.","mokuyoubi"},
            {"kinou wa ______ deshita ka... iie nichiyoubi ja arimasen. kayoubi desu.","nichiyoubi"},
            {"amerika wa ima ______ desu ka... hai kuji nijuu go fun desu.","kuji nijuu go fun"},
            {"anata wa maiasa ______ kara ______ made hatarakimasu ka... kayoubi kara doyoubi made hatarakimasu.","nanyoubi/nanyoubi"},
            {"kaisha wa ______ made desu ka... doyoubi made desu.","nanyoubi"},
            {"daigaku wa ______ kara desu ka... getsuyoubi kara desu.","nanyoubi"},
            {"kaigi wa ______ made desu ka... juu ji han made desu.","nanji"},
            {"anata wa asatte ______ made hatarakimasu ka... hai sanji made hatarakimasu.","sanji"},
            {"chii san wa ashita ______shimasu ka... hai benkyou shimasu.","benkyou"},
            {"kent san wa kinou ______ ka... iie hatarakimasendeshita.","hatarakimashita"},
            {"anata wa maiban ______ ka... hai maiban benkyou shimasu.","benkyou shimasu"},
            {"daigaku no yasumi wa ______ desu ka... doyoubi to nichiyoubi desu.","nanyoubi"},
            {"veen san wa kinou ______ ka... iie yasumimasendeshita.","yasumimashita"},
            {"wynn san wa ashita ______ ka... hai yasumimasu.","yasumimasu"}



    };


    public Exam4_Interrogatives() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam4_interrogatives, container, false);

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
