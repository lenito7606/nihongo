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

public class Exam_Katakana extends AppCompatActivity {

    private TextView countLabel, questionLabel, eh;
    private Button answerBtn1, answerBtn2, answerBtn3;

    private String rightAnswer, lessonnum = "Writings", examcategory = "Katakana";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 15;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer", "Choice1", "Choice2"}
            {"ア","a", "u", "e"},
            {"イ","i", "e", "o"},
            {"ウ","u", "e", "o"},
            {"エ","e", "o", "a"},
            {"オ","o", "a", "i"},
            {"カ","ka", "ko", "ku"},
            {"キ","ki", "ke", "ko"},
            {"ク","ku", "ka", "ko"},
            {"ケ","ke", "ka", "ki"},
            {"コ","ko", "ka", "ki"},
            {"サ","sa", "su", "shi"},
            {"シ","shi", "se", "so"},
            {"ス","su", "se", "so"},
            {"セ","se", "shi", "so"},
            {"ソ","so", "su", "sa"},
            {"タ","ta", "to", "chi"},
            {"チ","chi", "tsu", "te"},
            {"ツ","tsu", "to", "te"},
            {"テ","te", "tsu", "chi"},
            {"ト","to", "ta", "tsu"},
            {"ナ","na", "no", "nu"},
            {"ニ","ni", "ne", "nu"},
            {"ヌ","nu", "no", "na"},
            {"ネ","ne", "ni", "nu"},
            {"ノ","no", "ne", "nu"},
            {"ハ","ha", "fu", "ho"},
            {"ヒ","hi", "ha", "he"},
            {"フ","fu", "he", "hi"},
            {"ヘ","he", "ho", "ha"},
            {"ホ","ho", "ha", "fu"},
            {"マ","ma", "mu", "mo"},
            {"ミ","mi", "me", "ma"},
            {"ム","mu", "ma", "mo"},
            {"メ","me", "mi", "mu"},
            {"モ","mo", "mu", "mi"},
            {"ヤ","ya", "yo", "yu"},
            {"ユ","yu", "ya", "yo"},
            {"ヨ","yo", "ya", "yu"},
            {"ラ","ra", "ro", "ri"},
            {"リ","ri", "ru", "re"},
            {"ル","ru", "ra", "re"},
            {"レ","re", "ro", "ra"},
            {"ロ","ro", "ri", "re"},
            {"ワ","wa", "wo", "n"},
            {"ヲ","wo", "wa", "n"},
            {"ン","n", "wo", "wa"},
            {"ガ","ga", "ge", "gi"},
            {"ギ","gi", "gu", "ge"},
            {"グ","gu", "ga", "gi"},
            {"ゲ","ge", "gu", "go"},
            {"ゴ","go", "gu", "gi"},
            {"ザ","za", "ze", "zo"},
            {"ジ","ji", "zu", "za"},
            {"ズ","zu", "ze", "za"},
            {"ゼ","ze", "za", "zo"},
            {"ゾ","zo", "zu", "ze"},
            {"ダ","da", "ji", "do"},
            {"ヂ","ji", "de", "zu"},
            {"ヅ","zu", "da", "do"},
            {"デ","de", "da", "zu"},
            {"ド","do", "ji", "da"},
            {"バ","ba", "be", "bu"},
            {"ビ","bi", "be", "bu"},
            {"ブ","bu", "bi", "ba"},
            {"ベ","be", "ba", "bo"},
            {"ボ","bo", "bu", "bi"},
            {"パ","pa", "pe", "pu"},
            {"ピ","pi", "pu", "po"},
            {"プ","pu", "po", "pe"},
            {"ペ","pe", "pi", "pa"},
            {"ポ","po", "pe", "pu"},
            {"キャ","kya", "kyo", "kyu"},
            {"キュ","kyu", "kya", "kyo"},
            {"キョ","kyo", "kya", "kyu"},
            {"シャ","sha", "shu", "sho"},
            {"シュ","shu", "sho", "sha"},
            {"ショ","sho", "sha", "shu"},
            {"チャ","cha", "cho", "chu"},
            {"チュ","chu", "cha", "cho"},
            {"チョ","cho", "cha", "chu"},
            {"ニャ","nya", "nyo", "nyu"},
            {"ニュ","nyu", "nya", "nyo"},
            {"ニョ","nyo", "nyu", "nya"},
            {"ヒャ","hya", "hyu", "hyo"},
            {"ヒュ","hyu", "hya", "hyo"},
            {"ヒョ","hyo", "hyu", "hya"},
            {"ミャ","mya", "myo", "myu"},
            {"ミュ","myu", "mya", "myo"},
            {"ミョ","myo", "mya", "myu"},
            {"リャ","rya", "ryo", "ryu"},
            {"リュ","ryu", "rya", "ryo"},
            {"リョ","ryo", "ryu", "rya"},
            {"ギャ","gya", "gyu", "gyo"},
            {"ギュ","gyu", "gyo", "gya"},
            {"ギョ","gyo", "gyu", "gya"},
            {"ジャ","ja", "ju", "jo"},
            {"ジュ","ju", "jo", "ja"},
            {"ジョ","jo", "ju", "ja"},
            {"ビャ","bya", "byo", "byu"},
            {"ビュ","byu", "bya", "byo"},
            {"ビョ","byo", "byu", "bya"},
            {"ピャ","pya", "pyo", "pyu"},
            {"ピュ","pyu", "pya", "pyo"},
            {"ピョ","pyo", "pya", "pyu"},


    };






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam__katakana);

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
