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


public class Exam6_Interrogatives extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson6", examcategory = "Interrogative";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"この　しゃしん　は______とりました　か。　おおさか　で　とりました。","どこで"},
            {"あい　さん　は　けさ______たべました　か。　ぱん　と　たまご　を　たべました。","なにを"},
            {"ちい　さん　は　きょう______します　か。　なに　も　しません。","なにを"},
            {"ケント　さん　は　きのう______で　ひるごはん　を　たべました　か。うち　で　たべました。","どこ"},
            {"その　かばん　は______かいました　か。　アメリカ　で　かいました。","どこで"},
            {"ほむら　さん　は　あした______あいます　か。　こいびと　に　あいます。","だれに"},
            {"アルノード　さん　は______を　すいます　か。　いいえ　たばこ　を　すいません。","たばこ"},
            {"ヴィン　さん　は　まいにち______のみます　か。　はい　まいにち　ぎゅうにゅう　を　のみます。","ぎゅうにゅうを"},
            {"ひかり　さん　は　まいばん______を　みます　か。　アニメ　を　みます。","なに"},
            {"いのうえ　さん　は______　たべました　か。　いいえ　さかな　を　たべません。","さかなを"},
            {"あなた　は　きのう　の　ばん______を　たべました　か。______も　たべませんでした。","なに／なに"},
            {"きむら　さん　は　まいにち_____を　よみます　か。　はい　しんぶん　を　よみます。","しんぶん"},
            {"あなた　は　まいばん______よみまます　か。にほんご　の　ほん　を　よみます。","なにを"},
            {"ユリさん　は　あした______に　あいますか。　はい　ともだち　に　あいます。","ともだち"},
            {"ライン　さん　は　あさって______ともだち　に　あいます　か。ごぜん　くじ　に　あいます。","なんじに"},
            {"レニン　さん　は　らいしゅう　の　きんようび______します　か。　スーパー　で　くつ　を　かいます。","なにを"},
            {"わかやま　さん　は　まいにち______りんご　を　かいます　か。　スーパー　で　かいます。","どこで"},
            {"あなた　は______を　たべます　か。　はい　すし　を　たべます。","すし"},
            {"レニン　さん　は______を　のみます　か。　いいえ　おさけ　を　のみません。","おさけ"},
            {"にや　さん　は　あした______ばんごはん　を　たべます　か。こいびと　と　たべます。","だれと"},
            {"ケヴィン　さん　は　きのう______を　しました　か。　はい　テニス　を　しました。","テニス"},
            {"みついし　さん　は　まいあさ______を　食べます　か。　いいえ　まいあさ　ごはん　を　たべません。","ごはん"},
            {"レニン　さん　は______べんきょうします　か。　にほんご　を　べんきょうします。","なにを"},
            {"アナ　さん　は　せんしゅう　の　どようび______あいました　か。　はい　ともだち　に　あいました。","ともだちに"},
            {"レン　さん　は　まいあさ______を　かいます　か。　はい　まいあさ　にく　を　かいます。","にく"}



    };


    public Exam6_Interrogatives() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam6_interrogatives, container, false);

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
