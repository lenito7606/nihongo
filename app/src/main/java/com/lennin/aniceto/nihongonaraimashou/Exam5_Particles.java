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


public class Exam5_Particles extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson5", examcategory = "Particle";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"renin san ___ tanjoubi ___ itsu desu ka.","no/wa"},
            {"chii san wa kesa doko ___ ikimashita ka… doko ___ ikimasendeshita.","e/mo"},
            {"jovan san wa mainichi tomodachi ___ densha ___ kaisha ___ ikimasu.","to/de/e"},
            {"renin san wa kinou ___ ban ginkou ___ hitori ___ ikimashita.","no/e/de"},
            {"anata wa itsu nihon ___ ikimasu ka.","e"},
            {"karol san wa mainichi daigaku ___ hitori ___ densha ___ kimasu.","e/de/de"},
            {"veen san wa raishuu ___ kinyoubi ___ honya ___ ikimasu.","no/ni/e"},
            {"watashi ___ yasumi ___ doko ___ ikimasen.","no/wa/mo"},
            {"kent san wa raishuu ___ kayoubi ___ doko ___ ikimasu ka.","no/ni/e"},
            {"hikari san ___ mainichi aruite koujou ___ ikimasu.","wa/e"},
            {"anna san wa mainichi jitensha ___ densha ___ ginkou ___ kimasu.","to/de/e"},
            {"anata wa maiban nanji ___ kaisha ___ ikimasu ka.","ni/e"},
            {"ai san ___ kimura san ___ raihuu okayama ___ ikimasu.","to/wa/e"},
            {"ichigo san wa koibito ___ tomodachi ___ amerika ___ ikimasu.","to/to/e"},
            {"raishuu ___ kayoubi ___ watashi ___ tanjobu desu.","no/ni/no"},
            {"yuri san ___ tanjoubi ___ itsu desu ___.","no/wa/ka"},
            {"karen san wa ototoi doko ___ ikimasendeshita.","mo"},
            {"watashi wa senshuu ___ getsuyoubi ___su-pa- ___ ikimashita.","no/ni/e"},
            {"anata wa maiasa doko ___ ikimasu ka… daigaku ___ ikimasu.","e/e"},
            {"yun san ___ tomodachi ___ kankoku ___ kaerimashita.","wa/to/e"},



    };


    public Exam5_Particles() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam5_particles, container, false);

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
