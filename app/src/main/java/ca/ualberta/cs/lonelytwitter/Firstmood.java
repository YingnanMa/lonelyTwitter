package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by mayingnan on 2018/1/18.
 */

public abstract class Firstmood {

    private Date date;

    public Firstmood(){

        this.date = new Date();
    }

    public Firstmood (Date date ){

        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date=date;
    }
    public abstract String IsGood();





}
