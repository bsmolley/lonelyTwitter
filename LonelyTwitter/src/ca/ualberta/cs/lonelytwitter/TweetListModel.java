package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TweetListModel {
	
	private ArrayList<LonelyTweetModel> tweets;
	private ArrayList<LonelyTweetModel> sorted; 

	public TweetListModel() {
		super();
		this.tweets = new ArrayList<LonelyTweetModel>();
		this.sorted = new ArrayList<LonelyTweetModel>();
	}

	public void add(LonelyTweetModel t) {
		tweets.add(t);
	}

	public boolean hasTweet(LonelyTweetModel t) {
		return tweets.contains(t);
	}

	public void addTweet(LonelyTweetModel t) {
		if (hasTweet(t)){
			throw new IllegalArgumentException("Tweet already exists");
		}
	}

	public void removeTweet(LonelyTweetModel t) {
		tweets.remove(t);
		
	}

	public int getCount() {
		int size = tweets.size();
		return size;
	}

	public ArrayList<LonelyTweetModel> getTweets() {
		sorted = tweets;
		
		Collections.sort(sorted, new Comparator<LonelyTweetModel>(){
			public int compare(LonelyTweetModel lhs, LonelyTweetModel rhs) {
				return lhs.toString().compareTo(rhs.toString());
			}		
		});	
		return sorted;
	}




}
