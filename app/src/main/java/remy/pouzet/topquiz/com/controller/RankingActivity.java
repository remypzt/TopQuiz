package remy.pouzet.topquiz.com.controller;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;


import remy.pouzet.topquiz.com.R;

public class RankingActivity extends AppCompatActivity
{
    private SharedPreferences mPreferences;

    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private TextView mTextView4;
    private TextView mTextView5;
    private Button mButton1;
    private Button mButton2;

    private String players;

    public static final String PREF_PLAYERS_LIST = "PREF_PLAYERS_LIST";

    public TextView getTextView1()
    {
        return mTextView1;
    }

    public void setTextView1(TextView textView1)
    {
        mTextView1 = textView1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        System.out.println("RankingActivity::onCreate()");

        mTextView1 = findViewById(R.id.textView);
        mTextView2 = findViewById(R.id.textView2);
        mTextView3 = findViewById(R.id.textView3);
        mTextView4 = findViewById(R.id.textView4);
        mTextView5 = findViewById(R.id.textView5);
        mButton1 = findViewById(R.id.button);
        mButton2 = findViewById(R.id.button2);

        mPreferences = getPreferences(MODE_PRIVATE);

        String jsonPlayersList = mPreferences.getString(PREF_PLAYERS_LIST, null);
        Gson gson = new Gson();
        ArrayList playersList = gson.fromJson(jsonPlayersList, ArrayList.class);

        /*String string1 = "Hello ";
        mTextView1.setText(string1);*/

        setContentView(R.layout.activity_ranking);

        System.out.println("MainActivity::onStart()");
    }
}







