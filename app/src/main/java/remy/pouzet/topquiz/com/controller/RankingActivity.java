package remy.pouzet.topquiz.com.controller;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

    public TextView getTextView1()
    {
        return mTextView1;
    }

    public void setTextView1(TextView textView1)
    {
        mTextView1 = textView1;
    }

    public TextView getTextView2()
    {
        return mTextView2;
    }

    public void setTextView2(TextView textView2)
    {
        mTextView2 = textView2;
    }

    public TextView getTextView3()
    {
        return mTextView3;
    }

    public void setTextView3(TextView textView3)
    {
        mTextView3 = textView3;
    }

    public TextView getTextView4()
    {
        return mTextView4;
    }

    public void setTextView4(TextView textView4)
    {
        mTextView4 = textView4;
    }

    public TextView getTextView5()
    {
        return mTextView5;
    }

    public void setTextView5(TextView textView5)
    {
        mTextView5 = textView5;
    }

    public Button getButton1()
    {
        return mButton1;
    }

    public void setButton1(Button button1)
    {
        mButton1 = button1;
    }

    public Button getButton2()
    {
        return mButton2;
    }

    public void setButton2(Button button2)
    {
        mButton2 = button2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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

        mPreferences = getSharedPreferences(PREF_PLAYERS_LIST, MODE_PRIVATE);

        String jsonPlayersList2 = mPreferences.getString(PREF_PLAYERS_LIST, null);
        Gson gson4 = new Gson();
        ArrayList<Players> playersList2 = gson4.fromJson(jsonPlayersList2, new TypeToken<ArrayList<Players>>() {}.getType());

        mTextView1.setText(playersList2.get(0).getFirstName()+(" ")+(playersList2.get(0).getScore()));
        mTextView2.setText(playersList2.get(1).getFirstName()+(" ")+(playersList2.get(1).getScore()));
        mTextView3.setText(playersList2.get(2).getFirstName()+(" ")+(playersList2.get(2).getScore()));
        mTextView4.setText(playersList2.get(3).getFirstName()+(" ")+(playersList2.get(3).getScore()));
        mTextView5.setText(playersList2.get(4).getFirstName()+(" ")+(playersList2.get(4).getScore()));

        System.out.println("MainActivity::onStart()");
    }
}







