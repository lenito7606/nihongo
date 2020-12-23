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


public class Exam6_Particles extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson6", examcategory = "Particle";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"わたし　は　きょう　ともだち___えき___あいます。","に／で"},
            {"あい　さん　は　どこ___この　しゃしん___とりました　か。","で／を"},
            {"きむら　さん___まいばん　どこ___ごはん___かいました　か。","は／で／を"},
            {"ひかり　さん　は　けさ　なに___しました　か。なに___しませんでした。","を／も"},
            {"ちい　さん　は　まいにち　うち___あさごはん___たべます　か。","で／を"},
            {"ほむら　さん　は　きのう　ばんごはん___ともだち___たべました　か。","を／と"},
            {"アルノード　さん　は　らいしゅう___げつようび　なに___します　か。","の／を"},
            {"わたし___やすみ___なに___しません。","の／は／も"},
            {"いのうえ　さん　は　こいびと___ともだち___あいます。","と／に"},
            {"レン　さん　は　きょう　ぱん___たまご___たべます。","と／を"},
            {"わたし　は　アメリカ___かばん___かいました。","で／を"},
            {"きむら　さん　は　らいしゅう　フィリピンじん___ともだち___あいます。","の／に"},
            {"わたし　は　ひとり___うち___にほんご___べんきょうします。","で／で／を"},
            {"アナ　さん　は　まいばん　なに___たべます　か。","を"},
            {"まつもと　さん　まいにち　どこ___たばこ___すいます　か。","で／を"},
            {"あなた　は　まいばん　しょくどう___ばんごはん___たべます　か。","で／を"},
            {"わたし　は　ひかり　さん___アニメ___みます。それから　ごはん___たべます。","と／を／を"},
            {"やまぐち　さん　は　まいばん　にほんご___ほん___よみます。","の／を"},
            {"たなか　さん　は　まいばん　ひとり___おさけ___のみます。","で／を"},
            {"わたし　は　てがみ___かきます。","を"},



    };


    public Exam6_Particles() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam6_particles, container, false);

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

        countLabel.setText("もんだい " + quizCount);

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
