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


public class Exam8_Interrogatives extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson8", examcategory = "Interrogative";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"フィリピンは______ところ　です　か。　あつい　くに　です。","どんな"},
            {"にほん　の　たべもの　は______です　か。　おいしい　です　が　たかい　です。","どう"},
            {"きょう　の　てんき　は______です　か。　きょう　は　くもり　です。","どう"},
            {"アメリカ　は______くに　です　か。　きれい　な　くに　です。","どんな"},
            {"この　ほん　は______です　か。　いいえ　あたらしくない　です。　ふるい　です。","あたらしい"},
            {"きょうと　は______です　か。　はい　しずか　です。","しずか"},
            {"しごと　は　きのう______です　か。　いいえ　あんまり　いそがしくなかった　です。","いそがしかった"},
            {"ちい　さん　は______ひと　です　か。　しんせつ　な　ひと　です。","どんな"},
            {"あなた　は______かばん　を　かいました　か。やすい　かばん　を　かいました。","どんな"},
            {"ふじさん　は______やま　です　か。　はい　たかい　やま　です。","たかい"},
            {"ジョヴァン　さん　は______です　か。　いいえ　ゆうめい　じゃ　ありません。","ゆうめい"},
            {"にほんご　は______です　か。　むずかしい　です　が。　おもしろい　です。","どう"},
            {"にほん　の　しんかんせん　は______です　か。　はやい　です　そして　きれい　です。","どう"},
            {"この　じてんしゃ　は______です　か。いいえ　ふるくない　です。","ふるい"},
            {"だいがく　は______です　か。まいにち　いそがしい　です。","どう"},
            {"ちい　さん　は______ひと　です　か。　きれい　です　そして　いい　ひと　です。","どんな"},
            {"イギリス　は______でした　か。　はい　とても　きれい　でした。","きれい"},
            {"きのう　の　てんき　は______です　か。　いいえ　あつくなかった　です。　すずしかった　です。","あつかった"},
            {"この　えいが　は______でした　か。　おもしろかった　です。","どう"},
            {"あい　さん　は______ひと　です　か。　しずか　な　ひと　です。","どんな"},
            {"あなた　の　かばん　は______です　か　その　あかい　かばん　です。","どれ"},
            {"きょう　は______です　か。　はい　さむい　です。","さむい"},
            {"エヴェレストさん　は______です　か。　はい　ゆうめい　です。","ゆうめい"},
            {"レン　さん　の　ノード　は______です　か。　あの　ちいさい　ノード　です。","どれ"},
            {"レニン　さん　の　くつ　は______です　か。　この　おおきい　くつ　です。","どれ"}



    };


    public Exam8_Interrogatives() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam8_interrogatives, container, false);

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
