package ca.ualberta.cs.lonelytwitter;

/**
 * Created by mayingnan on 2018/1/18.
 */
import java.util.ArrayList;
import java.util.Date;

public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;
    private ArrayList<Firstmood> firstmoods;



    public Tweet(String message){
        this.message = message;
        this.date = new Date();
        this.firstmoods=new ArrayList<Firstmood>();
    }

    public Tweet (String message, Date date ){
        this.message =message;
        this.date = date;
        this.firstmoods=new ArrayList<Firstmood>();
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date=date;
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
    }
    public abstract Boolean isImportant();



    public void addMood(Firstmood mood){
        this.firstmoods.add(mood);
    }
}
