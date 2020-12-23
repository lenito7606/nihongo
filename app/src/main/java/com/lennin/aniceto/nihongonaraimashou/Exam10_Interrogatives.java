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


public class Exam10_Interrogatives extends Fragment {

    private TextView countLabel, questionLabel, ei;
    private EditText answertext;
    private Button answerBtn;

    private String rightAnswer, lessonnum = "Lesson10", examcategory = "Interrogative";
    private int rightAnswerCount = 0, quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray =  new ArrayList<>();

    String quizData [][] = {

            //{"Question", "Answer"}
            {"きょうしつの なか に______が あります か。 ほん や いす など が あります。","なに"},
            {"ぎんこう は ______ の まえ に あります か。 はい スーパー の まえ に あります。","スーパー"},
            {"へやに______が いますか。ともだち が います。","だれ"},
            {"トイレ の なか に______いますか。 だれ も いません。","だれが"},
            {"ベッド の した に______あります か。　なに も ありません","なにが"},
            {"とうきょう は______に あります か。にほん に あります。","どこ"},
            {"ぎんこう の まえ に くるま が あります か。 はい くるま が あります。","くるま"},
            {"ぎんこう は______ありますか 。 えき の となり に あります。","どこに"},
            {"やまださん は______の なか に いますか。　いいえ へや の なか に だれ も いません。","へや"},
            {"ねこ は______います か。 はこ の なか に います。","どこに"},
            {"いぬ は______の ぞと に います か。はい うち の そと に います。","うち"},
            {"アルノードさん は______に います か。 はい アメリカ に います。","アメリカ"},
            {"おとこ の ひと は ______います か。 こうえん に います。","どこに"},
            {"き の うえ に______が います か。ねこ が います。","なに"},
            {"じむしょう の なか に______います か。やまぐちさん と たなかさん が います。","だれが"},
            {"ゆうびんきょく の まえ に______あります か。レストラン が あります。","なにが"},
            {"ぎんこう は______に あります か。スーパー の となり に あります。","どこ"},
            {"ほむらさん は______に います か。はい じむしょう に います","じむしょう"},
            {"だいがくせい は______に います か。へや の なか に います","どこ"},
            {"きょうしつ の なか に______あります か。はい ほん が あります。","ほんが"},
            {"わたし の  けしゴム は______あります か。 つくえ の うえ に あります。","どこに"},
            {"かばん の なか に______が あります か。なに も ありません。","なに"},
            {"しゃしん は______に あります か。ほん の した に あります。","どこ"},
            {"わたしの ほん は______に あります か。 かばん の なか に あります。","どこに"},
            {"へや の そと に______が います か。だれ も いません。","だれ"}



    };


    public Exam10_Interrogatives() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam10_interrogatives, container, false);

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
