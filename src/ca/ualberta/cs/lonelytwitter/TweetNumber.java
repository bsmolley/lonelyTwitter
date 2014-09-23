package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class TweetNumber extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tweet_number);
		int size = grabNumberOfTweets();
		EditText sizeText = (EditText) findViewById(R.id.check);
		sizeText.setText(size);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tweet_number, menu);
		return true;
	}
	
	public static int grabNumberOfTweets(){
		int number = LonelyTwitterActivity.returnTweets().size();
		return number;
	}
	
}
