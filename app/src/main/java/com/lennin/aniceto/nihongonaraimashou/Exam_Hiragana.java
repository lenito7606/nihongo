package com.lennin.aniceto.nihongonaraimashou;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Exam_Hiragana extends AppCompatActivity {

    private TextView countLabel, questionLabel, eh;
    private Button answerBtn1, answerBtn2, answerBtn3;

    private String rightAnswer, lessonnum = "Writings", examcategory = "Hiragana";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 15;


    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer", "Choice1", "Choice2"}
            {"あ","a", "u", "e"},
            {"い","i", "e", "o"},
            {"う","u", "e", "o"},
            {"え","e", "o", "a"},
            {"お","o", "a", "i"},
            {"か","ka", "ko", "ku"},
            {"き","ki", "ke", "ko"},
            {"く","ku", "ka", "ko"},
            {"け","ke", "ka", "ki"},
            {"こ","ko", "ka", "ki"},
            {"さ","sa", "su", "shi"},
            {"し","shi", "se", "so"},
            {"す","su", "se", "so"},
            {"せ","se", "shi", "so"},
            {"そ","so", "su", "sa"},
            {"た","ta", "to", "chi"},
            {"ち","chi", "tsu", "te"},
            {"つ","tsu", "to", "te"},
            {"て","te", "tsu", "chi"},
            {"と","to", "ta", "tsu"},
            {"な","na", "no", "nu"},
            {"に","ni", "ne", "nu"},
            {"ぬ","nu", "no", "na"},
            {"ね","ne", "ni", "nu"},
            {"の","no", "ne", "nu"},
            {"は","ha", "fu", "ho"},
            {"ひ","hi", "ha", "he"},
            {"ふ","fu", "he", "hi"},
            {"へ","he", "ho", "ha"},
            {"ほ","ho", "ha", "fu"},
            {"ま","ma", "mu", "mo"},
            {"み","mi", "me", "ma"},
            {"む","mu", "ma", "mo"},
            {"め","me", "mi", "mu"},
            {"も","mo", "mu", "mi"},
            {"や","ya", "yo", "yu"},
            {"ゆ","yu", "ya", "yo"},
            {"よ","yo", "ya", "yu"},
            {"ら","ra", "ro", "ri"},
            {"り","ri", "ru", "re"},
            {"る","ru", "ra", "re"},
            {"れ","re", "ro", "ra"},
            {"ろ","ro", "ri", "re"},
            {"わ","wa", "wo", "n"},
            {"を","wo", "wa", "n"},
            {"ん","n", "wo", "wa"},
            {"が","ga", "ge", "gi"},
            {"ぎ","gi", "gu", "ge"},
            {"ぐ","gu", "ga", "gi"},
            {"げ","ge", "gu", "go"},
            {"ご","go", "gu", "gi"},
            {"ざ","za", "ze", "zo"},
            {"じ","ji", "zu", "za"},
            {"ず","zu", "ze", "za"},
            {"ぜ","ze", "za", "zo"},
            {"ぞ","zo", "zu", "ze"},
            {"だ","da", "ji", "do"},
            {"ぢ","ji", "de", "zu"},
            {"づ","zu", "da", "do"},
            {"で","de", "da", "zu"},
            {"ど","do", "ji", "da"},
            {"ば","ba", "be", "bu"},
            {"び","bi", "be", "bu"},
            {"ぶ","bu", "bi", "ba"},
            {"べ","be", "ba", "bo"},
            {"ぼ","bo", "bu", "bi"},
            {"ぱ","pa", "pe", "pu"},
            {"ぴ","pi", "pu", "po"},
            {"ぷ","pu", "po", "pe"},
            {"ぺ","pe", "pi", "pa"},
            {"ぽ","po", "pe", "pu"},
            {"きゃ","kya", "kyo", "kyu"},
            {"きゅ","kyu", "kya", "kyo"},
            {"きょ","kyo", "kya", "kyu"},
            {"しゃ","sha", "shu", "sho"},
            {"しゅ","shu", "sho", "sha"},
            {"しょ","sho", "sha", "shu"},
            {"ちゃ","cha", "cho", "chu"},
            {"ちゅ","chu", "cha", "cho"},
            {"ちょ","cho", "cha", "chu"},
            {"にゃ","nya", "nyo", "nyu"},
            {"にゅ","nyu", "nya", "nyo"},
            {"にょ","nyo", "nyu", "nya"},
            {"ひゃ","hya", "hyu", "hyo"},
            {"ひゅ","hyu", "hya", "hyo"},
            {"ひょ","hyo", "hyu", "hya"},
            {"みゃ","mya", "myo", "myu"},
            {"みゅ","myu", "mya", "myo"},
            {"みょ","myo", "mya", "myu"},
            {"りゃ","rya", "ryo", "ryu"},
            {"りゅ","ryu", "rya", "ryo"},
            {"りょ","ryo", "ryu", "rya"},
            {"ぎゃ","gya", "gyu", "gyo"},
            {"ぎゅ","gyu", "gyo", "gya"},
            {"ぎょ","gyo", "gyu", "gya"},
            {"じゃ","ja", "ju", "jo"},
            {"じゅ","ju", "jo", "ja"},
            {"じょ","jo", "ju", "ja"},
            {"びゃ","bya", "byo", "byu"},
            {"びゅ","byu", "bya", "byo"},
            {"びょ","byo", "byu", "bya"},
            {"ぴゃ","pya", "pyo", "pyu"},
            {"ぴゅ","pyu", "pya", "pyo"},
            {"ぴょ","pyo", "pya", "pyu"},


    };






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam__hiragana);

        countLabel = (TextView)findViewById(R.id.countlabel);
        questionLabel = (TextView)findViewById(R.id.questionlabel);
        eh = (TextView) findViewById(R.id.eh);
        answerBtn1 = (Button) findViewById(R.id.answerBtn1);
        answerBtn2 = (Button) findViewById(R.id.answerBtn2);
        answerBtn3 = (Button) findViewById(R.id.answerBtn3);


        eh.setText(getIntent().getStringExtra("uname"));

        for(int i = 0; i<quizData.length; i++) {

            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);

            quizArray.add(tmpArray);

        }

        showNextQuiz();
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

        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));

        quizArray.remove(randomNum);


    }


    public void checkAnswer (View view) {

        Button answerBtn = (Button)findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if(btnText.equals(rightAnswer)) {

            alertTitle = "Correct";
            rightAnswerCount ++;

        } else {

            alertTitle = "Wrong";

        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer : " + rightAnswer);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (quizCount == QUIZ_COUNT) {

                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    intent.putExtra("QUIZ_COUNT", QUIZ_COUNT);
                    intent.putExtra("lessonnum", lessonnum);
                    intent.putExtra("examcategory", examcategory);
                    intent.putExtra("uname", eh.getText().toString());
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

}
