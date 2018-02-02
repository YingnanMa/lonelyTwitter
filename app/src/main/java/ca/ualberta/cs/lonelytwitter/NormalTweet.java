
/*
 *  Copyright © 2018 Team X, CMPUT301, University of Alberta - All Rights Reserved.
 * You may use, distribute or modify this code under terms and conditions of Code of Student Behavior at
 * University of Alberta.
 * You can find a copy of the license in this project. Otherwise, please contact
 *   contact@abc.ca
 * /
 */

package ca.ualberta.cs.lonelytwitter;

/**
 * Created by dezfuli on 1/16/18.
 */
import java.util.Date;


/**
 * Represents a normaltweet
 *
 * @author YingnanMa
 *
 * @version 1.0
 *
 */
public class NormalTweet extends Tweet {
    NormalTweet(String message){
        super(message);
    }

    NormalTweet(String message, Date date){
        super(message, date);
    }

    @Override

    /**
     * check the condition
     */
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
