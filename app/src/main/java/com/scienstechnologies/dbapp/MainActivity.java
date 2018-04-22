package com.scienstechnologies.dbapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.scienstechnologies.dbapp.others.DBHelper;
import com.scienstechnologies.dbapp.utilities.SQLiteUtility;

public class MainActivity extends AppCompatActivity {
    private EditText mETName, mETMobile, mETMail, mETPassword;
    private DBHelper mDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        intiializeObjects();
    }

    private void intiializeObjects() {
        mDbHelper = new DBHelper(this);
    }

    /**
     * When click on Register button , it saves information into db.
     * @param view Register Button
     *
     */
    public void insertRecord(View view){
       long result =  SQLiteUtility.insertRows(getName(),getMobile(), getMail(), getPassword(),
                mDbHelper.getSQLiteObjectWithWritable());
       if(result > 0 ){
           showToast("Registration successful!");
           startActivity(new Intent(this, SearchActivity.class));
           finish();
       }else{
           showToast("Registration not successful!!");
       }
    }

    private void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private void initializeViews() {
        mETName = findViewById(R.id.name_et);
        mETMobile = findViewById(R.id.mobile_et);
        mETMail = findViewById(R.id.mail_et);
        mETPassword = findViewById(R.id.password_et);
    }
    private String getName(){
        return mETName.getText().toString();
    }
    private String getMobile(){
        return mETMobile.getText().toString();
    }
    private String getMail(){
        return mETMail.getText().toString();
    }
    private String getPassword(){
        return mETPassword.getText().toString();
    }
}
