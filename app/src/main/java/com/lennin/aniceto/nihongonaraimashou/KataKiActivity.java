package com.lennin.aniceto.nihongonaraimashou;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KataKiActivity extends AppCompatActivity {
    Button snd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kata_ki);
        snd=(Button) findViewById(R.id.katakana_ki);
        final MediaPlayer mp=MediaPlayer.create(this, R.raw.ki);
        snd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mp.start();
            }
        });
    }
}
