package remy.pouzet.topquiz.com.controller;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import remy.pouzet.topquiz.com.R;

public class RankingActivity extends AppCompatActivity
{
    public static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME";
    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";

    private SharedPreferences mPreferences;

    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private TextView mTextView4;
    private TextView mTextView5;
    private Button mButton1;
    private Button mButton2;

    private String players;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        mPreferences = getPreferences(MODE_PRIVATE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        System.out.println("RankingActivity::onCreate()");

        mTextView1 = findViewById(R.id.textView);
        mTextView2 = findViewById(R.id.textView2);
        mTextView3 = findViewById(R.id.textView3);
        mTextView4 = findViewById(R.id.textView4);
        mTextView5 = findViewById(R.id.textView5);
        mButton1 = findViewById(R.id.button);
        mButton2 = findViewById(R.id.button2);


    }
}







