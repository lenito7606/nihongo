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


public class Exam7_Interrogatives extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson7", examcategory = "Interrogative";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"thank you 　は　にほんご　で______ です　か。ありがとう　です。","なん"},
            {"これ　は　えいご　で______です　か。　Paper　です。","なん"},
            {"にほんじん　は______ごはん　を　たべます　か。　はし　で　たべます。","なんで"},
            {"フィリピンじん　は______ごはん　を　たべます　か。　はい　ときどき　て　で　ごはん　を　たべます。","てで"},
            {"ほむら　さん　は　きのう　の　あさ______で　てがみ　を　かきました　か。　はい　えんぴつ　で　かきました。","えんぴつ"},
            {"レン　さん　は______この　しゃしん　を　とりました　か。　カメラ　で　とりました。","なんで"},
            {"ちい　さん　は　きょう　もう______を　おくりました　か。　はい　もう　レポート　を　おくりました。","レポート"},
            {"あなた　は______にく　を　きりました　か。ナイフ　で　きりました。","なんで"},
            {"あい　さん　は______で　かみ　を　きりました　か。いいえ　はさみ　で　きりませんでした。ナイフ　で　きりました。","はさみ"},
            {"アルノード　さん______にほんご　を　ならいました　か。レニン　せんせい　に　ならいました。","だれに"},
            {"ひかり　さん　は　おととい______に　ほん　を　かりました　か。ともだち　に　かりました。","だれ"},
            {"Good　morning　は　にほんご　で______です　か。はい　おはようございます　です。","おはようございます"},
            {"アナ　さん　は______えいご　を　おしえます　か。にほんじん　に　おしえます。","だれに"},
            {"ともだち　の　たんじょうび　に______あげました　か。　くつ　を　あげました。","なにを"},
            {"あなた　は　きょねん　の　たんじょうび　に______を　もらいました　か。おかね　を　もらいました。","なに"},
            {"やまだ　さん　は　おかあさん　に______を　あげました　か。　はい　かばん　を　あげました。","かばん"},
            {"ユリ　さん　は______コンピューター　を　しゅうりします　か。　ドライバー　で　しゅうりします。","なんで"},
            {"みやび　さん　は　ことし　の　クリスマス　に______もらいました　か。シャツ　を　もらいました。","なにを"},
            {"これ　は　えいご　で______です　か。　はい　shoes 　です。","shoes"},
            {"あなた　は______レポート　を　おくります　か。　いま　から　おくります。","いつ"},
            {"ヴィン　さん　は______でんわ　を　かけました　か。　かぞく　に　でんわ　を　かけました。","だれに"},
            {"ロアン　さん　は______に　てがみ　を　かきました　か。　こいびと　に　かきました。","だれ"},
            {"やまだ　さん　は______に　プレゼント　を　もらいました。　か。　はい　ともだち　に　プレゼント　を　もらいました。","ともだち"},
            {"あなた　は　ともだち　に______を　もらいました　か。シャツ　を　もらいました。","なに"},
            {"かばん　は　えいご　で______です　か。Bag 　です。","なん"}



    };


    public Exam7_Interrogatives() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam7_interrogatives, container, false);

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
