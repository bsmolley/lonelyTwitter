package ca.ualberta.cs.lonelytwitter.test;

import java.util.ArrayList;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.TweetListModel;

public class TweetListModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
	
	public TweetListModelTest(){
		super(LonelyTwitterActivity.class);
	}
	
	public void testFiveIsFive(){
		assertEquals(5,5);
	}
	
	public void testTweetListModel(){
		TweetListModel tlm = new TweetListModel();			
	}
	
	public void testAdd(){
		LonelyTweetModel t = new LonelyTweetModel("Hello");
		TweetListModel tlm = new TweetListModel();			
		tlm.add(t);
		assertTrue(tlm.hasTweet(t));
	}
	
	public void testAddTweet(){
		// Throw exception if tweet already exists
		LonelyTweetModel t = new LonelyTweetModel("Hello");
		TweetListModel tlm = new TweetListModel();
		tlm.add(t);
		tlm.addTweet(t);	
	}
	
	public void testGetTweets(){
		// return all tweets in chronological order
		LonelyTweetModel t0 = new LonelyTweetModel("Hello");
		LonelyTweetModel t1 = new LonelyTweetModel("Morning");
		LonelyTweetModel t2= new LonelyTweetModel("Evening");
		TweetListModel tlm = new TweetListModel();
		TweetListModel sorted = new TweetListModel();
		TweetListModel done = new TweetListModel();
		done.add(t2);
		done.add(t0);
		done.add(t1);
		tlm.add(t0);
		tlm.add(t1);
		tlm.add(t2);
		tlm.getTweets();
		assertEquals(tlm, done);
	}
	

	public void testHasTweet(){
		// return true if tweet is in the list that equals another tweet
		LonelyTweetModel t = new LonelyTweetModel("Hello");
		TweetListModel tlm = new TweetListModel();
		tlm.add(t);
		tlm.hasTweet(t);
	}
	
	public void testRemoveTweet(){
		// remove a tweet
		LonelyTweetModel t = new LonelyTweetModel("Hello");
		TweetListModel tlm = new TweetListModel();
		tlm.add(t);
		tlm.removeTweet(t);		
	}
	
	public void testGetCount(){
		// return size of tweet array
		LonelyTweetModel t = new LonelyTweetModel("Hello");
		TweetListModel tlm = new TweetListModel();
		tlm.add(t);
		tlm.getCount();
	}
	
	
}
