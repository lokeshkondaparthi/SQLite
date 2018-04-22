package com.scienstechnologies.dbapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.scienstechnologies.dbapp.others.DBHelper;
import com.scienstechnologies.dbapp.utilities.SQLiteUtility;

public class SearchActivity extends AppCompatActivity {
    private EditText mETSearch;
    private TextView mTVResult;
    private DBHelper mDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initializeViews();
        initializeObject();
    }

    public void serachName(View view){
        String memberInfo = SQLiteUtility.getMemberInformation(getName(), mDbHelper.getSqliteObjectWithReadable());
        if (memberInfo != null) {
            mTVResult.setText(memberInfo);
        }else{
            mTVResult.setError("Member not found!");
        }
    }

    private void initializeViews() {
        mETSearch = findViewById(R.id.serch_et);
        mTVResult = findViewById(R.id.result_tv);
    }
    private void initializeObject() {
        mDbHelper = new DBHelper(this);
    }
    private String getName(){
        return mETSearch.getText().toString();
    }

}
