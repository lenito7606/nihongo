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


public class Exam1_Interrogatives extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum="Lesson1", examcategory ="Interrogative";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"anata wa ______ desu ka... watashi wa donna desu.","dare"},
            {"erika san wa ______ desu ka... watashi wa hatachi desu.","nansai"},
            {"yamaguchi san wa ______ desu ka... hai sensei desu.","sensei"},
            {"ano hito  wa ______ desu ka... yamada san desu.","dare"},
            {"ano kata wa ______ desu ka... yamamoto san desu.","donata"},
            {"______ desu ka... 9 sai desu.","oikutsu"},
            {"anata wa ______ desu ka... iie jovan dewa arimasen. suzuki san desu.","jovan"},
            {"yamada san wa _____ desu ka... nihonjin desu.","nanjin"},
            {"kimura san wa ______ desu ka... hai nihonjin desu.","nihonjin"},
            {"wakayama san wa ______ desu ka... iie kaishain ja arimasen.","kaishain"},
            {"inou san wa ______ desu ka... iie gakusei ja arimasen.","gakusei"},
            {"anata wa ______ desu ka... hai watashi wa daigakusei desu.","daigakusei"},
            {"teresa san wa ______ desu ka... juu issai desu.","nansai"},
            {"inoue san wa ______ desu ka... hai nihongo no sensei desu.","nihongo no sensei"},
            {"homura san wa ______ desu ka... hai hatachi desu.","hatachi"},
            {"matsunaga san wa ______ desu ka... iie daigakusei ja arimasen. ginkouin desu.","daigakusei"},
            {"anata wa ______ desu ka... iie ni juu go sai desu. hatachi desu.","ni juu go sai"},
            {"ano kata wa ______ desu ka... hai jovan san desu.","jovan"},
            {"chii san wa ______ desu ka... hai firipin jin desu.","firipin jin"},
            {"smith san wa ______ desu ka... amerikajin desu.","nanjin"},
            {"adam san mo ______ desu ka... iie amerikajin ja arimasen. nihonjin desu.","amerikajin"},
            {"anata wa ______ desu ka... hai donna desu.","donna"},
            {"ely san wa ______ desu ka... hai sensei desu.","sensei"},
            {"homura san wa ______ desu ka... hatachi desu.","nansai"},
            {"teresa san wa ______ desu ka... hai juu issai desu.","juu issai"}


    };


    public Exam1_Interrogatives() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam1_interrogatives, container, false);

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
