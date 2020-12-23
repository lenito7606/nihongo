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


public class Exam4_Particles extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson4", examcategory = "Particle";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"kent san ___ mainichi kuji han ___ okimasu ka... hai kuji han ni okimasu.","wa/ni"},
            {"daigaku ___ yasumi wa doyoubi ___ nichiyoubi desu.","no/to"},
            {"chii san ___ kinou ___ ban benkyou shimasu.","wa/no"},
            {"anata ___ daigaku ___ nanyoubi desu ka… suiyoubi desu.","no/wa"},
            {"shigoto wa getsuyoubi ___ suiyoubi ___ kinyoubi desu.","to/to"},
            {"veen san ___ ashita nanji ___ okimasu ka.","wa/ni"},
            {"arnold san ___ kinou ___ asa benkyou shimashita ka. ___ benkyoshimasendeshita.","wa/no/iie"},
            {"karol san wa kesa kuji han ___ okimashita ka.","ni"},
            {"renin san ___ kaisha wa nanyoubi ___ nanyoubi ___ desu ka.","no/kara/made"},
            {"anata wa maiban benkyoshimasu ___... ___ maiban benkyoushimasen.","ka/iie"},
            {"chii san ___ daigaku wa nanji ___ owarimasu ka.","no/ni"},
            {"anata ___ kinou nanji ___ hatarakimashita ka… kuji made ni hatarakimashita.","wa/made"},
            {"anata wa kyou nanji  ___ benkyoushimasu ka… asa kuji kara benkyoshimashita.","kara"},
            {"watashi ___ ashita ___ asa hatarakimasu.","wa/no"},
            {"anata ___ kyou benkyoushimasu ___... iie benkyoushimasen.","wa/ka"},
            {"watashi ___ maiasa kuji ___ okimasu.","wa/ni"},
            {"homura san ___ kinou ___ ban nanji ___ nemashita ka.","wa/no/ni"},
            {"hikari san wa ototoi nanji ___ nemashita ka... juuji san juu go fun ___ nemashita.","ni/ni"},
            {"anata wa ashita benkyou shimasu ___... ___ benkyou shimasen.","ka/iie"},
            {"ashita ___ kayoubi desu ___... hai kayoubi desu.","wa/ka"},



    };


    public Exam4_Particles() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam4_particles, container, false);

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
