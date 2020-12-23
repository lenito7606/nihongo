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


public class Exam3_Interrogatives extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson3", examcategory = "Interrogative";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"watashi tachi no kyoushitsu wa ______ desu ka... sangai desu.","nangai"},
            {"sumimasen, toire wa ______ desu ka... asoko desu.","doko"},
            {"kono kamera wa ______ desu ka... hassen sanbyaku go juu en desu.","ikura"},
            {"kore wa ______ jidousha desu ka... nihon no jidousha desu.","doko no"},
            {"kono kaban wa ______ no desu ka... amerika no kaban desu.","doko"},
            {"chii san no daigaku wa ______ desu ka... cavite state university desu.","dochira"},
            {"renin san no kaisha wa ______ desu ka... PALDC desu.","dochira"},
            {"kore wa ______ en desu ka... hai hyaku en desu.","hyaku"},
            {"ano hon wa ______ desu ka... iie chuugoku no hon dewa arimasen.","chuugoku no"},
            {"jovan san no kuni wa ______ desu ka... firipin desu.","dochira"},
            {"heya wa ______ desu ka... koko desu.","doko"},
            {"sore wa ______ no denwa desu ka... kankoku no denwa desu.","doko"},
            {"sore wa ______ desu ka... go hyaku en desu.","ikura"},
            {"are wa ______ jisho desu ka... hai nihon no jisho desu.","nihon no"},
            {"shokudou wa ______ desu ka... rokkai desu.","nan gai"},
            {"sono zasshi wa ______ desu ka... hai happyaku en desu.","happyaku en"},
            {"uketsuke wa ______ desu ka... hai achira desu.","achira"},
            {"robi- wa ______ desu ka... hakkai desu.","nan gai"},
            {"robi- wa ______ desu ka... iie koko ja arimasen. asoko desu.","koko"},
            {"kono no-to wa ______ en desu ka... hai sanbyaku en desu ka.","sanbyaku"},
            {"kent san no kuni wa ______ desu ka... hai doitsu desu.","doitsu"},
            {"kono bo-rupen wa ______ desu ka... firipin no bo-rupen desu.","doko no"},
            {"toire wa ______ desu ka... hai nikai desu.","nikai"},
            {"smith san no kuni wa ______ desu ka... hai amerika desu.","amerika"},
            {"koko wa ______ desu ka... iie kyoushitsu dewa arimasen. heya desu.","kyoushitsu"}



    };


    public Exam3_Interrogatives() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam3_interrogatives, container, false);

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
