package remy.pouzet.topquiz.com.model;


/**
 * Created by Remy Pouzet on 05/06/2019.
 */

public class Players
{
    private String mFirstName;
    private int mScore;

    public Players (String firstName, int score)
    {
        mFirstName = firstName;
        mScore = score;
    }

    public int getScore()
    {
        return mScore;
    }

    public void setScore(int score)
    {
        mScore = score;
    }

    public String getFirstName()
    {
        return mFirstName;
    }

    public void setFirstName(String firstName)
    {
        mFirstName = firstName;
    }
}

