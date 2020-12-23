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


public class Exam7_Vocab extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson7", examcategory = "Vocabulary";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"きります","to cut"},
            {"しゅうりします","to repair"},
            {"でんわをかけます","to make a phone call"},
            {"あげます","to give"},
            {"もらいます","to receive"},
            {"おしえます","to teach"},
            {"ならいます","to learn"},
            {"かします","to lend"},
            {"かります","to borrow"},
            {"おくります","to send"},
            {"はし","chopsticks"},
            {"て","hand"},
            {"ナイフ","knife"},
            {"フォーク","fork"},
            {"スプーン","spoon"},
            {"はさみ","scissors"},
            {"ドライバー","screwdriver"},
            {"スパナ","wrench"},
            {"ペンチ","cutting pliers"},
            {"おかね","money"},
            {"プレゼント","present"},
            {"レポート","report"},
            {"かぞく","family"},
            {"おとうさん","someone else father"},
            {"ちち","my father"},
            {"おかあさん","someone else mother"},
            {"はは","my mother"},
            {"おにいさん","someone else older brother"},
            {"あに","my older brother"},
            {"おねえさん","someone else older sister"},
            {"あね","my older sister"},
            {"おとうとさん","someone else younger brother"},
            {"おとうと","my younger brother"},
            {"いもうとさん","someone else younger sister"},
            {"いもうと","my younger sister"},
            {"おくさん","someone else wife"},
            {"かない","my wife"},
            {"しゅじん","my husband"},
            {"ごしゅじん","someone else husband"},
            {"こども","child/children"},
            {"えいご","english language"},
            {"～ご","suffix for language"},
            {"もう","already"},
            {"まだ-","not yet"},
            {"これから","soon/from now on"},
            {"to cut","きります"},
            {"to repair","しゅうりします"},
            {"to make a phone call","でんわをかけます"},
            {"to give","あげます"},
            {"to receivee","もらいます"},
            {"to teach","おしえます"},
            {"to learn","ならいます"},
            {"to lend","かします"},
            {"to borrow","かります"},
            {"to send","おくります"},
            {"chopsticks","はし"},
            {"hand","て"},
            {"knife","ナイフ"},
            {"fork","フォーク"},
            {"spoon","スプーン"},
            {"scissors","はさみ"},
            {"screwdriver","ドライバー"},
            {"wrench","スパナ"},
            {"cutting pliers","ペンチ"},
            {"money","おかね"},
            {"present","プレゼント"},
            {"report","レポート"},
            {"family","かぞく"},
            {"someone else father","おとうさん"},
            {"my father","ちち"},
            {"someone else mother","おかあさん"},
            {"my mother","はは"},
            {"someone else older brother","おにいさん"},
            {"my older brother","あに"},
            {"someone else older sister","おねえさん"},
            {"my older sister","あね"},
            {"someone else younger brother","おとうとさん"},
            {"my younger brother","おとうと"},
            {"someone else younger sister","いもうとさん"},
            {"my younger sister","いもうと"},
            {"someone else wife","おくさん"},
            {"my wife","かない"},
            {"my husband","しゅじん"},
            {"someone else husband","ごしゅじん"},
            {"child/children","こども"},
            {"english language","えいご"},
            {"suffix for language","ご"},
            {"already","もう"},
            {"not yet","まだ"},
            {"soon/from now on","これから"},






    };


    public Exam7_Vocab() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam7_vocab, container, false);

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
