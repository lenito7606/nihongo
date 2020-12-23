package com.lennin.aniceto.nihongonaraimashou;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class Exam1 extends AppCompatActivity {
    private static final String TAG = "Exam";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    TextView t_uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1);

        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        t_uname = (TextView) findViewById(R.id.e1);
        t_uname.setText(getIntent().getStringExtra("uname"));
    }
    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new Exam1_Vocab(), "Vocabulary");
        adapter.addFragment(new Exam1_Particles(), "Particle");
        adapter.addFragment(new Exam1_Interrogatives(), "Interrogative");



        viewPager.setAdapter(adapter);
    }


}
