package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ma4 on 2/15/18.
 */

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet)
    {
        tweets.add(tweet);
    }

    public void addTweet(Tweet tweet) throws TweetTooLongException {
        if  (!this.hasTweet(tweet)){
            tweets.add(tweet);
        }else{
            throw new TweetTooLongException();
        }
    }

    public int getCount(){
        return tweets.size();
    }

    public ArrayList<Tweet> getTweets(){
        Collections.sort(tweets, new sortByDate());
        return tweets;
    }

    public boolean hasTweet(Tweet tweet)
    {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index)
    {
        return tweets.get(index);
    }

    public void deleat(Tweet tweet)
    {
        tweets.remove(tweet);
    }
}

class sortByDate implements Comparator<Tweet>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Tweet a, Tweet b)
    {
        if(a.getDate().before(b.getDate())){
            return 1;
        }else{
            return -1;
        }
    }
}
