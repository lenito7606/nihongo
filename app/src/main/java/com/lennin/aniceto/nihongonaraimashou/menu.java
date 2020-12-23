package com.lennin.aniceto.nihongonaraimashou;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class menu extends AppCompatActivity {
    Bundle bu;
    TextView t_uname;
    Button logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        t_uname=(TextView) findViewById(R.id.wc);
        bu=getIntent().getExtras();
        t_uname.setText(bu.getString("uname"));
        logo = (Button) findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(menu.this);
                builder.setTitle("About Us");
                builder.setMessage("This application is a thesis project. We are 4th year college student talking Bachelor of Science in Information Technology. I would like to take this opportunity to say thank you to all been part of this project. My family, my friends, my advisers and most of all to God. This application aims to teach Japanese Language in terms of grammar and writing. The user of this application will learn how to read hiragana(all),Katakana(all) and 50 kanji characters. The user will also learn about grammar, how to construct Japanese sentence, particle usage(preposition) and interrogatives.  This applications have total of 15 lessons. The user need to have at least 80% of each exam in order to unlock the other lessons. If you find some errors and bugs please email us together with a screenshot and lastly don’t forget to rate us. (credits to the owner of the gif files I used in this application.)");
                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }


                });
                builder.setCancelable(false);
                builder.show();

            }
        });

    }
    public void onLessonsButtonClick (View v)
    {
        if (v.getId() == R.id.lessons)
        {
            Intent i = new Intent(menu.this, Lessons.class);
            i.putExtra("uname", t_uname.getText().toString());
            startActivity(i);
        }

    }
    public void onAccountButtonClick (View v)
    {
        if (v.getId() == R.id.account)
        {
            Intent i = new Intent(menu.this, Account.class);
            i.putExtra("uname", t_uname.getText().toString());
            startActivity(i);
        }
    }
    public void onExamButtonClick (View v)
    {
        if (v.getId() == R.id.exam)
        {
            Intent i = new Intent(menu.this,Exam.class);
            i.putExtra("uname", t_uname.getText().toString());
            startActivity(i);
        }
    }
    public void onReportButtonClick (View v)
    {
        if (v.getId() == R.id.report)
        {
            Intent i = new Intent(menu.this,Report.class);
            i.putExtra("uname", t_uname.getText().toString());
            startActivity(i);
        }
    }

}
