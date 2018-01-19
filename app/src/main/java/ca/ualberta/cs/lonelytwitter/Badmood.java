package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

import static java.lang.Boolean.FALSE;

/**
 * Created by mayingnan on 2018/1/18.
 */

public class Badmood extends Firstmood {

    public Badmood(){
        super();
    }
    public Badmood(Date date){
        super(date);
    }
    @Override
    public String IsGood() {
        return "no, bad mood";
    }

}
