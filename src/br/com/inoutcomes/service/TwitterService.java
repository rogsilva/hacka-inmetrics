package br.com.inoutcomes.service;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterService 
{
	private Twitter twitter;
	
	public TwitterService()
	{
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey("pw5tcqigLlPz2L69FuArADWmh")
			.setOAuthConsumerSecret("ICF57zFW0o9bihqMmMOm1MZ8D9EOyUsJGMHfG20AehiY44JxmP")
			.setOAuthAccessToken("4237731921-ec0Z0HI0jxSAT5i35lSiWKu89blgSoj857WXk2w")
			.setOAuthAccessTokenSecret("8If2RKh28WXNVV1a5usn3DVTR0Orfb9LrzfhbejzbrZ9U");
		
		

		TwitterFactory tf = new TwitterFactory(cb.build());
		this.twitter = tf.getInstance();
	}
	
	
	public List<String> search(String str, int count) throws TwitterException
	{
		ArrayList<String> posts = new ArrayList<String>(); 
		Query query = new Query(str);		
		QueryResult result;

		query.setCount(count);
        result = twitter.search(query);
        
        List<Status> tweets = result.getTweets();
        for (Status tweet : tweets) {
            posts.add("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
        }
		
		return posts;		
	}
	
	
}
