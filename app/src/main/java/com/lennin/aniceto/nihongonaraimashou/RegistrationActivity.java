package com.lennin.aniceto.nihongonaraimashou;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Cursor cursor;
    EditText u_name, f_name, l_name, e_mail;
    Button btn_register;
    Bundle bu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        openHelper=new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();
        u_name=(EditText) findViewById(R.id.u_name);
        f_name=(EditText) findViewById(R.id.f_name);
        l_name=(EditText) findViewById(R.id.l_name);
        e_mail=(EditText) findViewById(R.id.e_mail);
        btn_register=(Button) findViewById(R.id.btn_register);
        bu=getIntent().getExtras();
        u_name.setText(bu.getString("uname"));
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String _uname=u_name.getText().toString();
                String _fname=f_name.getText().toString();
                String _lname=l_name.getText().toString();
                String _email=e_mail.getText().toString();
                if (TextUtils.isEmpty(_fname)) {
                    Toast.makeText(getApplicationContext(), "Please fill up the form", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(_lname)) {
                    Toast.makeText(getApplicationContext(), "Please fill up the form", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(_email)) {
                    Toast.makeText(getApplicationContext(), "Please fill up the form", Toast.LENGTH_LONG).show();
                }
                else{
                    insertData(_uname, _fname, _lname, _email);
                    Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(RegistrationActivity.this, menu.class);
                    i.putExtra("uname", u_name.getText().toString());
                    startActivity(i);
                }
            }
        });

    }
    public void insertData(String _uname, String _fname, String _lname, String _email) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_UNAME, _uname);
        contentValues.put(DatabaseHelper.COL_FNAME, _fname);
        contentValues.put(DatabaseHelper.COL_LNAME, _lname);
        contentValues.put(DatabaseHelper.COL_EMAIL, _email);
        long _id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }
}
