package remy.pouzet.topquiz.com.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;


import remy.pouzet.topquiz.com.R;
import remy.pouzet.topquiz.com.model.Players;
import remy.pouzet.topquiz.com.model.Question;
import remy.pouzet.topquiz.com.model.QuestionBank;


public class GameActivity extends AppCompatActivity implements View.OnClickListener
{

    private TextView mQuestionTextView;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    private int mScore;
    private int mNumberOfQuestions;

    private String mFirstname;

    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";
    public static final String BUNDLE_STATE_SCORE = "currentScore";
    public static final String BUNDLE_STATE_QUESTION = "currentQuestion";

    public static final String PREF_PLAYERS_LIST = "PREF_PLAYERS_LIST";

    private boolean mEnableTouchEvents;

    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        Intent intent = getIntent();
        mFirstname = intent.getStringExtra(MainActivity.FIRSTNAME_REQUEST_CODE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        System.out.println("GameActivity::onCreate()");

        mPreferences = getSharedPreferences(PREF_PLAYERS_LIST, MODE_PRIVATE);

        mQuestionBank = this.generateQuestions();


        if (savedInstanceState != null)
        {
            mScore = savedInstanceState.getInt(BUNDLE_STATE_SCORE);
            mNumberOfQuestions = savedInstanceState.getInt(BUNDLE_STATE_QUESTION);
        } else
        {
            mScore = 0;
            mNumberOfQuestions = 3;
        }

        mEnableTouchEvents = true;

        // Wire widgets
        mQuestionTextView = findViewById(R.id.activity_game_question_text);
        mAnswerButton1 = findViewById(R.id.activity_game_answer1_btn);
        mAnswerButton2 = findViewById(R.id.activity_game_answer2_btn);
        mAnswerButton3 = findViewById(R.id.activity_game_answer3_btn);
        mAnswerButton4 = findViewById(R.id.activity_game_answer4_btn);

        // Use the tag property to 'name' the buttons
        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton3.setTag(2);
        mAnswerButton4.setTag(3);

        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton4.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putInt(BUNDLE_STATE_SCORE, mScore);
        outState.putInt(BUNDLE_STATE_QUESTION, mNumberOfQuestions);

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v)
    {
        int responseIndex = (int) v.getTag();

        if (responseIndex == mCurrentQuestion.getAnswerIndex())
        {
            // Good answer
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            mScore++;
        } else
        {
            // Wrong answer
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
        }

        mEnableTouchEvents = false;

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                mEnableTouchEvents = true;

                // If this is the last question, ends the game.
                // Else, display the next question.
                if (--mNumberOfQuestions == 0)
                {
                    // End the game
                    endGame();
                } else
                {
                    mCurrentQuestion = mQuestionBank.getQuestion();
                    displayQuestion(mCurrentQuestion);
                }
            }
        }, 2000); // LENGTH_SHORT is usually 2 second long
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        return mEnableTouchEvents && super.dispatchTouchEvent(ev);
    }



    private void displayQuestion(final Question question)
    {
        mQuestionTextView.setText(question.getQuestion());
        mAnswerButton1.setText(question.getChoiceList().get(0));
        mAnswerButton2.setText(question.getChoiceList().get(1));
        mAnswerButton3.setText(question.getChoiceList().get(2));
        mAnswerButton4.setText(question.getChoiceList().get(3));
    }

    private QuestionBank generateQuestions()
    {
        Question question1 = new Question("What is the name of the current french president?",
                Arrays.asList("François Hollande", "Emmanuel Macron", "Jacques Chirac", "François Mitterand"),
                1);

        Question question2 = new Question("How many countries are there in the European Union?",
                Arrays.asList("15", "24", "28", "32"),
                2);

        Question question3 = new Question("Who is the creator of the Android operating system?",
                Arrays.asList("Andy Rubin", "Steve Wozniak", "Jake Wharton", "Paul Smith"),
                0);

        Question question4 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958", "1962", "1967", "1969"),
                3);

        Question question5 = new Question("What is the capital of Romania?",
                Arrays.asList("Bucarest", "Warsaw", "Budapest", "Berlin"),
                0);

        Question question6 = new Question("Who did the Mona Lisa paint?",
                Arrays.asList("Michelangelo", "Leonardo Da Vinci", "Raphael", "Carravagio"),
                1);

        Question question7 = new Question("In which city is the composer Frédéric Chopin buried?",
                Arrays.asList("Strasbourg", "Warsaw", "Paris", "Moscow"),
                2);

        Question question8 = new Question("What is the country top-level domain of Belgium?",
                Arrays.asList(".bg", ".bm", ".bl", ".be"),
                3);

        Question question9 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42", "101", "666", "742"),
                3);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9));
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        System.out.println("GameActivity::onStart()");
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        System.out.println("GameActivity::onResume()");
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        System.out.println("GameActivity::onPause()");
    }

    private void endGame()
    {

        Players players = new Players(mFirstname, mScore);

        mPreferences = getSharedPreferences(PREF_PLAYERS_LIST, MODE_PRIVATE);
        String fromJsonPlayersList = mPreferences.getString(PREF_PLAYERS_LIST, null);

        Gson gson = new Gson();
        ArrayList<Players> playersList2 = gson.fromJson(fromJsonPlayersList, new TypeToken<ArrayList<Players>>()
        {
        }.getType());


        if (null == fromJsonPlayersList)
        {
            ArrayList<Players> playersList = new ArrayList();
            playersList.add(players);

            Gson gson1 = new Gson();
            String jsonPlayersList = gson1.toJson(playersList);

            SharedPreferences.Editor editor = mPreferences.edit();
            editor.putString(PREF_PLAYERS_LIST, jsonPlayersList).apply();

        } else if (playersList2.size() != 5)
        {
            playersList2.add(players);

            Gson gson1 = new Gson();
            String PlayersList = gson1.toJson(playersList2);

            SharedPreferences.Editor editor = mPreferences.edit();
            editor.putString(PREF_PLAYERS_LIST, PlayersList).apply();

        } else
        {
            Players minScorePlayer = playersList2.get(0);
            for (Players player : playersList2)
            {
                if (player.getScore() < minScorePlayer.getScore())
                {
                    minScorePlayer = player;
                }
            }
            System.out.println(minScorePlayer);

            if (mScore >= minScorePlayer.getScore())
            {
                playersList2.remove(minScorePlayer);

                playersList2.add(players);

                Gson gson2 = new Gson();
                String PlayersList = gson2.toJson(playersList2);

                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putString(PREF_PLAYERS_LIST, PlayersList).apply();
            }
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done ! " + mFirstname)
                .setMessage("Your score is " + mScore)
                .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                // End the activity
                                Intent intent = new Intent();
                                intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                                setResult(RESULT_OK, intent);
                                finish();
                            }
                        }
                )
                .setCancelable(false)
                .create()
                .show();
    }

    @Override
    protected void onStop()
    {
        super.onStop();

        System.out.println("GameActivity::onStop()");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        System.out.println("GameActivity::onDestroy()");
    }
}