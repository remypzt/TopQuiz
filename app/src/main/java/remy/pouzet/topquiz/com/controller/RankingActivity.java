package remy.pouzet.topquiz.com.controller;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;

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


    public static final String PREF_PLAYERS_LIST = "PREF_PLAYERS_LIST";
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
        final ArrayList<Players> playersList2 = gson4.fromJson(jsonPlayersList2, new TypeToken<ArrayList<Players>>()
        {
        }.getType());

        mButton1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Collections.sort(playersList2);
                Collections.reverse(playersList2);
                if (playersList2.size() >= 1)
                {
                    mTextView1.setText(playersList2.get(0).getFirstName() + (" ") + (playersList2.get(0).getScore()));
                    if (playersList2.size() >= 2)
                    {
                        mTextView2.setText(playersList2.get(1).getFirstName() + (" ") + (playersList2.get(1).getScore()));
                        if (playersList2.size() >= 3)
                        {
                            mTextView3.setText(playersList2.get(2).getFirstName() + (" ") + (playersList2.get(2).getScore()));
                            if (playersList2.size() >= 4)
                            {
                                mTextView4.setText(playersList2.get(3).getFirstName() + (" ") + (playersList2.get(3).getScore()));
                                if (playersList2.size() >= 5)
                                {
                                    mTextView5.setText(playersList2.get(4).getFirstName() + (" ") + (playersList2.get(4).getScore()));
                                }
                            }
                        }
                    }
                }
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Collections.sort(playersList2, Players.ComparatorFirstname);
                if (playersList2.size() >= 1)
                {
                    mTextView1.setText(playersList2.get(0).getFirstName() + (" ") + (playersList2.get(0).getScore()));
                    if (playersList2.size() >= 2)
                    {
                        mTextView2.setText(playersList2.get(1).getFirstName() + (" ") + (playersList2.get(1).getScore()));
                        if (playersList2.size() >= 3)
                        {
                            mTextView3.setText(playersList2.get(2).getFirstName() + (" ") + (playersList2.get(2).getScore()));
                            if (playersList2.size() >= 4)
                            {
                                mTextView4.setText(playersList2.get(3).getFirstName() + (" ") + (playersList2.get(3).getScore()));
                                if (playersList2.size() >= 5)
                                {
                                    mTextView5.setText(playersList2.get(4).getFirstName() + (" ") + (playersList2.get(4).getScore()));
                                }
                            }
                        }
                    }
                }
            }
        });

        if (playersList2.size() >= 1)
        {
            mTextView1.setText(playersList2.get(0).getFirstName() + (" ") + (playersList2.get(0).getScore()));
            if (playersList2.size() >= 2)
            {
                mTextView2.setText(playersList2.get(1).getFirstName() + (" ") + (playersList2.get(1).getScore()));
                if (playersList2.size() >= 3)
                {
                    mTextView3.setText(playersList2.get(2).getFirstName() + (" ") + (playersList2.get(2).getScore()));
                    if (playersList2.size() >= 4)
                    {
                        mTextView4.setText(playersList2.get(3).getFirstName() + (" ") + (playersList2.get(3).getScore()));
                        if (playersList2.size() >= 5)
                        {
                            mTextView5.setText(playersList2.get(4).getFirstName() + (" ") + (playersList2.get(4).getScore()));
                        }
                    }
                }
            }
        }

        System.out.println("MainActivity::onStart()");
    }

}








