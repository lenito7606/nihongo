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


public class Exam8_Vocab extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson8", examcategory = "Vocabulary";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"きれい　「な」","beautiful/clean"},
            {"ハンサム　「な」","handsome"},
            {"しんせつ　「な」","kind"},
            {"ゆうめい　「な」","famous"},
            {"げんき　「な」","healthy"},
            {"しずか　「な」","quiet"},
            {"にぎやか　「な」","lively"},
            {"うるさい","noisy"},
            {"おおきい","big/large"},
            {"ちいさい","small/little"},
            {"あたらしい","new"},
            {"ふるい","old (refer to things)"},
            {"いい／よい","good"},
            {"わるい","bad"},
            {"あつい","hot"},
            {"さむい","cold (weather)"},
            {"つめたい","cold (temperature)"},
            {"むずかしい","difficult"},
            {"かんたん　「な」","easy"},
            {"たかい","expensive/high"},
            {"やすい","cheap"},
            {"ひくい","low"},
            {"おもしろい","interesting"},
            {"つまらない","boring"},
            {"おいしい","delicious"},
            {"まずい","bad taste"},
            {"とおい","far"},
            {"ちかい","near"},
            {"しろい","white"},
            {"くろい","black"},
            {"あかい","red"},
            {"あおい","blue"},
            {"きいろい","yellow"},
            {"みどり","green"},
            {"しけん","examination"},
            {"しゅくだい","homework"},
            {"たべもの","food"},
            {"さくら","cheery blossom"},
            {"はな","flower"},
            {"まち","town/city"},
            {"やま","mountain"},
            {"ふじさん","mt. fuji"},
            {"ところ","place"},
            {"どう","how"},
            {"どんな","what kind"},
            {"どれ","which one"},
            {"すずしい","cool"},
            {"あたたかい","warm"},
            {"おもい","heavy"},
            {"かるい","light"},
            {"あめ","rainy"},
            {"くもり","cloudy"},
            {"はれ","sunny"},
            {"ひろい","wide"},
            {"せまい","narrow"},
            {"たいへん","hard/tough"},
            {"そして","and"},
            {"あまり","not so"},
            {"とても","very"},
            {"beautiful/clean","きれい"},
            {"handsome","ハンサム"},
            {"kind","しんせつ"},
            {"famous","ゆうめい"},
            {"healthy","げんき"},
            {"quiet","しずか"},
            {"lively","にぎやか"},
            {"noisy","うるさい"},
            {"big/large","おおきい"},
            {"small/little","ちいさい"},
            {"new","あたらしい"},
            {"old (refer to things)","ふるい"},
            {"good","いい／よい"},
            {"bad","わるい"},
            {"hot","あつい"},
            {"cold (weather)","さむい"},
            {"cold (temperature)","つめたい"},
            {"difficult","むずかしい"},
            {"easy","かんたん"},
            {"expensive/high","たかい"},
            {"cheap","やすい"},
            {"low","ひくい"},
            {"interesting","おもしろい"},
            {"boring","つまらない"},
            {"delicious","おいしい"},
            {"bad taste","まずい"},
            {"far","とおい"},
            {"near","ちかい"},
            {"white","しろい"},
            {"black","くろい"},
            {"red","あかい"},
            {"blue","あおい"},
            {"yellow","きいろい"},
            {"green","みどり"},
            {"examination","しけん"},
            {"homework","しゅくだい"},
            {"food","たべもの"},
            {"cheery blossom","さくら"},
            {"flower","はな"},
            {"town/city","まち"},
            {"mountain","やま"},
            {"mt. fuji","ふじさん"},
            {"place","ところ"},
            {"how","どう"},
            {"what kind","どんな"},
            {"which one","どれ"},
            {"cool","すずしい"},
            {"warm","あたたかい"},
            {"heavy","おもい"},
            {"light","かるい"},
            {"rainy","あめ"},
            {"cloudy","くもり"},
            {"sunny","はれ"},
            {"wide","ひろい"},
            {"narrow","せまい"},
            {"hard/tough","たいへん"},
            {"and","そして"},
            {"not so","あまり"},
            {"very","とても"},





    };


    public Exam8_Vocab() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam8_vocab, container, false);

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
