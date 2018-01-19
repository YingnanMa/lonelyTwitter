package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by mayingnan on 2018/1/18.
 */

public class Goodmood extends Firstmood {
    public Goodmood(){
        super();
    }
    public Goodmood(Date date){
        super(date);
    }
    @Override
    public String IsGood() {
        return "yes, good mood";
    }


}
