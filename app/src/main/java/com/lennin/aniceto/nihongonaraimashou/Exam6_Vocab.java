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


public class Exam6_Vocab extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson6", examcategory = "Vocabulary";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"たべます","to eat"},
            {"のみます","to drink"},
            {"たばこをすいます","to smoke a cigarette"},
            {"かきます","to write/draw/paint"},
            {"よみます","to read"},
            {"ききます","to listen"},
            {"みます","to see/look at/to watch"},
            {"かいます","to buy"},
            {"しゃしんをとります","to take a picture"},
            {"じっしゅうします","to do practical training"},
            {"テニスをします","to play tennis"},
            {"します","to do"},
            {"ともだちにあいます","to meet a friend"},
            {"ごはん","a meal/cooked rice"},
            {"あさごはん","breakfast"},
            {"ひるごはん","lunch"},
            {"ばんごはん","dinner"},
            {"パン","bread"},
            {"たまご","egg"},
            {"にく","meat"},
            {"さかな","fish"},
            {"やさい","vegetable"},
            {"りんご","apple"},
            {"ぎゅうにゅう/ミルク","milk"},
            {"おちゃ","green tea"},
            {"コーヒー","coffee"},
            {"こうちゃ","black tea"},
            {"ジュース","juice"},
            {"ビール","beer"},
            {"おさけ","japanese rice wine"},
            {"みず","water"},
            {"ネクタイ","necktie"},
            {"シャツ","shirt"},
            {"くつ","shoes"},
            {"カセットテープ","cassette tape"},
            {"フィルム","film"},
            {"しゃしん","picture"},
            {"えいが","movie"},
            {"いっしょに","together/with me"},
            {"それから","after that/and then"},
            {"to eat","たべます"},
            {"to drink","のみます"},
            {"to smoke a cigarette","たばこをすいます"},
            {"to write/draw/paint","かきます"},
            {"to read","よみます"},
            {"to listen","ききます"},
            {"to see/look at/to watch","みます"},
            {"to buy","かいます"},
            {"to take a picture","しゃしんをとります"},
            {"to do practical training","じっしゅうします"},
            {"to play tennis","テニスをします"},
            {"to do","します"},
            {"to meet a friend","ともだちにあいます"},
            {"a meal/cooked rice","ごはん"},
            {"breakfast","あさごはん"},
            {"lunch","ひるごはん"},
            {"dinner","ばんごはん"},
            {"bread","パン"},
            {"egg","たまご"},
            {"meat","にく"},
            {"fish","さかな"},
            {"vegetable","やさい"},
            {"apple","りんご"},
            {"milk","ぎゅうにゅう/ミルク"},
            {"green tea","おちゃ"},
            {"coffee","コーヒー"},
            {"black tea","こうちゃ"},
            {"juice","ジュース"},
            {"beer","ビール"},
            {"japanese rice wine","さけ"},
            {"water","みず"},
            {"necktie","ネクタイ"},
            {"shirt","シャツ"},
            {"shoes","くつ"},
            {"cassette tape","カセットテープ"},
            {"film","フィルム"},
            {"picture","しゃしん"},
            {"movie","えいが"},
            {"together/with me","いっしょに"},
            {"after that/and then","それから"},






    };


    public Exam6_Vocab() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam6_vocab, container, false);

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
