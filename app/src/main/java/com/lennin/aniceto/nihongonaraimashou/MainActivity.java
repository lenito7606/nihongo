package com.lennin.aniceto.nihongonaraimashou;

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

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Cursor cursor;
    Button btn_login, btn_create;
    EditText txt_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper=new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();
        txt_username=(EditText) findViewById(R.id.txt_username);
        btn_login=(Button) findViewById(R.id.btn_login);
        btn_create=(Button) findViewById(R.id.btn_create);
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txt_username.getText().toString();
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(getApplicationContext(), "Please enter username", Toast.LENGTH_LONG).show();
                }
                else{
                    cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " where " + DatabaseHelper.COL_UNAME + "=?", new String[]{username});
                    if (cursor != null) {
                        if (cursor.getCount() > 0) {
                            Toast.makeText(getApplicationContext(), "Username Already Exists", Toast.LENGTH_LONG).show();
                        } else {
                            Intent i = new Intent(MainActivity.this, RegistrationActivity.class);
                            i.putExtra("uname", username);
                            startActivity(i);
                        }
                    }
                }
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=txt_username.getText().toString();
                if(TextUtils.isEmpty(username)) {
                    Toast.makeText(getApplicationContext(), "Please enter username", Toast.LENGTH_LONG).show();
                }
                else{
                    cursor=db.rawQuery("SELECT * FROM "+ DatabaseHelper.TABLE_NAME+" where "+DatabaseHelper.COL_UNAME+"=?", new String[]{username});
                    if (cursor != null) {
                        if (cursor.getCount() > 0) {
                            Intent i = new Intent(MainActivity.this, menu.class);
                            i.putExtra("uname", username);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Username doesn't exist", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }
}