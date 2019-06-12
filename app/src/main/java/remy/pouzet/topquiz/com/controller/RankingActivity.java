package remy.pouzet.topquiz.com.controller;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import remy.pouzet.topquiz.com.R;
import remy.pouzet.topquiz.com.model.Players;

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


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        System.out.println("RankingActivity::onCreate()");

        mPreferences = getPreferences(MODE_PRIVATE);

        String  jsonPlayersList = mPreferences.getString(PREF_PLAYERS_LIST, null);

        Gson gson = new Gson();
        ArrayList playersList = gson.fromJson(jsonPlayersList, Players.class);




        setContentView(R.layout.activity_ranking);

        mTextView1 = findViewById(R.id.textView);
        mTextView2 = findViewById(R.id.textView2);
        mTextView3 = findViewById(R.id.textView3);
        mTextView4 = findViewById(R.id.textView4);
        mTextView5 = findViewById(R.id.textView5);
        mButton1 = findViewById(R.id.button);
        mButton2 = findViewById(R.id.button2);

        System.out.println("MainActivity::onStart()");

    }

    private void displayRanking() {

}
}







