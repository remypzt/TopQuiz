package remy.pouzet.topquiz.com.model;


import java.util.Comparator;

/**
 * Created by Remy Pouzet on 05/06/2019.
 */

public class Players implements Comparable<Players>
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

    @Override
    //cette méthode affiche les informations de l'employé
    public String toString()
    {
        return mScore + mFirstName;
    }

    @Override
    public int compareTo(Players oPlayers)
    {
        return (mScore - oPlayers.mScore);
    }

    public static Comparator<Players> ComparatorScore = new Comparator<Players>()
    {

        @Override
        public int compare(Players e1, Players e2)
        {
            return (int) (e1.getScore() - e2.getScore());

        }
    };

    public static Comparator<Players> ComparatorFirstname = new Comparator<Players>()
    {

        @Override
        public int compare(Players e1, Players e2)
        {
            return e1.getFirstName().compareTo(e2.getFirstName());
        }
    };


}

