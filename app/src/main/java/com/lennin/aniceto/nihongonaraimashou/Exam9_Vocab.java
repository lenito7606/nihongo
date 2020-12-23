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


public class Exam9_Vocab extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson9", examcategory = "Vocabulary";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"わかります","to understand"},
            {"あります","to have"},
            {"すき　「な」","like"},
            {"きらい　「な」","dislike"},
            {"じょうず　「な」","good at"},
            {"へた　「な」","poor at"},
            {"ひらがな","hiragana script"},
            {"かたかな","katakana script"},
            {"ローマじ","roman alphabet"},
            {"かんじ","chinese characters"},
            {"りょうり","dish (cooked food)"},
            {"くだもの","fruit"},
            {"のみもの","drinks"},
            {"ぶたにく","pork meat"},
            {"とりにく","chicken meat"},
            {"きゅうにく","beef meat)"},
            {"みかん","orange"},
            {"バナナ","banana"},
            {"おんがく","music"},
            {"うた","song"},
            {"ダンス","dance"},
            {"キター","guitar"},
            {"スポーツ","sports"},
            {"サッカー","soccer"},
            {"テニス","tennis"},
            {"じかん","time"},
            {"たくさん","many"},
            {"すこし","a little/a few"},
            {"よく","well"},
            {"だいたい","almost"},
            {"ぜんぜん","not at all"},
            {"もちろん","of course"},
            {"どうして／なぜ","why"},
            {"から","because"},
            {"びょうき","illness/sickness"},
            {"くすり","medicine"},
            {"あたま","head"},
            {"おなか","stomach"},
            {"あたま　が　いたい","have a headache"},
            {"ねつ　が　あります","have a fever"},
            {"かぜ　を　ひきました","have caught a cold"},
            {"かいしゃ　を　やすみます","to take day off from company"},
            {"to understand","わかります"},
            {"to have","あります"},
            {"like","すき"},
            {"dislike","きらい"},
            {"good at","じょうず"},
            {"poor at","へた"},
            {"hiragana script","ひらがな"},
            {"katakana scrip","かたかな"},
            {"roman alphabet","ローマじ"},
            {"chinese characters","かんじ"},
            {"dish (cooked food)","りょうり"},
            {"fruit","くだもの"},
            {"drinks","のみもの"},
            {"pork meat","ぶたにく"},
            {"chicken meat","とりにく"},
            {"beef meat","きゅうにく"},
            {"orange","みかん"},
            {"banana","バナナ"},
            {"music","おんがく"},
            {"song","うた"},
            {"dance","ダンス"},
            {"guitar","キター"},
            {"sports","スポーツ"},
            {"soccer","サッカー"},
            {"tennis","テニス"},
            {"time","じかん"},
            {"many","たくさん"},
            {"a little/a few","すこし"},
            {"well","よく"},
            {"almost","だいたい"},
            {"not at all","ぜんぜん"},
            {"of course","もちろん"},
            {"why","どうして／なぜ"},
            {"because","から"},
            {"illness/sickness","びょうき"},
            {"medicine","くすり"},
            {"head","あたま"},
            {"stomach","おなか"},
            {"have a headache","あたま　が　いたい"},
            {"have a fever","ねつ　が　あります"},
            {"have caught a cold","かぜ　を　ひきました"},
            {"to take day off from company","かいしゃ　を　やすみます"},






    };


    public Exam9_Vocab() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam9_vocab, container, false);

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
