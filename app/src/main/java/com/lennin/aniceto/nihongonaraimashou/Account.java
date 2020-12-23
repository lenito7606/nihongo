package com.lennin.aniceto.nihongonaraimashou;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Account extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Cursor cursor;
    TextView t_id;
    EditText t_uname, t_fname, t_lname, t_email;
    Button btn_logout, btn_update;
    Bundle bu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        BottomNavigationView bottomNavigationView=(BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        openHelper=new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();
        t_id=(TextView) findViewById(R.id.t_id);
        t_uname=(EditText) findViewById(R.id.t_uname);
        t_fname=(EditText) findViewById(R.id.t_fname);
        t_lname=(EditText) findViewById(R.id.t_lname);
        t_email=(EditText) findViewById(R.id.t_email);
        btn_logout=(Button) findViewById(R.id.btn_logout);
        btn_update=(Button) findViewById(R.id.btn_update);
        bu=getIntent().getExtras();
        t_uname.setText(bu.getString("uname"));
        t_uname.setFocusable(false);
        String username = t_uname.getText().toString();
        cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " where " + DatabaseHelper.COL_UNAME + "=?", new String[]{username});
        while(cursor.moveToNext()) {
            String id = cursor.getString(0);
            t_id.setText(id);
            String fname = cursor.getString(2);
            t_fname.setText(fname);
            String lname = cursor.getString(3);
            t_lname.setText(lname);
            String email = cursor.getString(4);
            t_email.setText(email);
        }
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Logout Success", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Account.this,MainActivity.class);
                startActivity(i);

            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id=Long.parseLong(t_id.getText().toString());
                String fname=t_fname.getText().toString();
                String lname=t_lname.getText().toString();
                String email=t_email.getText().toString();
                if (TextUtils.isEmpty(fname)) {
                    Toast.makeText(getApplicationContext(), "Please fill up the form", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(lname)) {
                    Toast.makeText(getApplicationContext(), "Please fill up the form", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Please fill up the form", Toast.LENGTH_LONG).show();
                }
                else {
                    updateData(id, fname, lname, email);
                    Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_LONG).show();
                    Intent i = getIntent();
                    finish();
                    startActivity(i);
                }
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent i = new Intent(Account.this,menu.class);
                        i.putExtra("uname", t_uname.getText().toString());
                        startActivity(i);
                        break;
                    case R.id.navigation_lesson:
                        Intent i2 = new Intent(Account.this,Lessons.class);
                        i2.putExtra("uname", t_uname.getText().toString());
                        startActivity(i2);
                        break;
                    case R.id.navigation_exam:
                        Intent i3 = new Intent(Account.this,Exam.class);
                        i3.putExtra("uname", t_uname.getText().toString());
                        startActivity(i3);
                        break;
                    case R.id.navigation_report:
                        Intent i4 = new Intent(Account.this,Report.class);
                        i4.putExtra("uname", t_uname.getText().toString());
                        startActivity(i4);
                        break;
                }
                return false;

            }
        });
    }
    public void updateData(long id, String fname, String lname, String email) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_FNAME, fname);
        contentValues.put(DatabaseHelper.COL_LNAME, lname);
        contentValues.put(DatabaseHelper.COL_EMAIL, email);
        this.db.update(DatabaseHelper.TABLE_NAME, contentValues, "ID= "+id, null);
    }
}
