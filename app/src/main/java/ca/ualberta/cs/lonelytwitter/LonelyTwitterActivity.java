
/*
 *  Copyright © 2018 Team X, CMPUT301, University of Alberta - All Rights Reserved.
 * You may use, distribute or modify this code under terms and conditions of Code of Student Behavior at
 * University of Alberta.
 * You can find a copy of the license in this project. Otherwise, please contact
 *   contact@abc.ca
 * /
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * Represents a LonelyTwitterActivity
 *
 * @author YingnanMa
 *
 * @version 1.0
 *
 */


public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "tweet_list.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
	@Override

	/**
	 * create in class activity
	 *
	 * @param savedInstanceState - the bundle
	 *
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("LifeCycle ---->", "onCreate is called");
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		Button clearButton = (Button) findViewById(R.id.clear);


		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

				saveInFile();


			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {

			/**
			 * Sets the onclick method
			 *
			 * @param v - the new message of the tweet
			 * @throws TweetTooLongException - is thrown when the message is over 140 characters
			 *
			 * @see ImportantTweet
			 * @see NormalTweet
			 */

			public void onClick(View v) {
				setResult(RESULT_OK);


				tweetList.clear();

				adapter.notifyDataSetChanged();

				saveInFile();


			}
		});
	}

	@Override
	/**
	 * Sets the onstart method
	 *
	 */
	protected void onStart() {

		// TODO Auto-generated method stub
		super.onStart();
		Log.i("LifeCycle --->", "onStart is called");
		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this ,R.layout.list_item, tweetList);



		oldTweetsList.setAdapter(adapter);




	}
	/**
	 * load information from the file
	 *
	 */

	private void loadFromFile() {

		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));


			Gson gson = new Gson();
			//
			//2018-01-25
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList= gson.fromJson(in,  listType);




		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();


		} catch (IOException e) {
			throw new RuntimeException();

		}


	}

	/**
	 * save the information in file
	 *
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter( new OutputStreamWriter(fos));
			Gson gson = new Gson();


			gson.toJson(tweetList , out);
			out.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("Lifecycle", "onDestroy is called");
	}
}