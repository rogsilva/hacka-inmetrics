package br.com.inoutcomes.service;

import java.util.ArrayList;
import java.util.List;

import br.com.inoutcomes.beans.DataSource;
import facebook4j.FacebookException;
import facebook4j.internal.org.json.JSONException;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterService implements ServiceInterface
{
	private Twitter twitter;

	public TwitterService() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey("pw5tcqigLlPz2L69FuArADWmh")
				.setOAuthConsumerSecret("ICF57zFW0o9bihqMmMOm1MZ8D9EOyUsJGMHfG20AehiY44JxmP")
				.setOAuthAccessToken("4237731921-ec0Z0HI0jxSAT5i35lSiWKu89blgSoj857WXk2w")
				.setOAuthAccessTokenSecret("8If2RKh28WXNVV1a5usn3DVTR0Orfb9LrzfhbejzbrZ9U");

		TwitterFactory tf = new TwitterFactory(cb.build());
		this.twitter = tf.getInstance();
	}

	public List<String> search(String str, int count) throws TwitterException {
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

	public Twitter getTwitterObject() {
		return this.twitter;
	}

	public List<Status> getLastNStatuses(String name, int qntStatus) {

		List<Status> allStatus = new ArrayList<>();

		try {

			// cria objeto Twitter
			TwitterService ts = new TwitterService();

			// cria o Paging
			Paging p = new Paging(1, 100);

			// calcula qnt de pages
			int pagesIndex = 0;
			if (qntStatus > 100) {
				pagesIndex = qntStatus / 100 + 1;
			} else {
				pagesIndex = 1;
				p.setCount(qntStatus);
			}

			// for que vai percorrer as pages e ir populando na lista
			for (int i = 1; i <= pagesIndex; i++) {

				if (i == pagesIndex && qntStatus != 100) {
					p.setCount(qntStatus % 100);
				}

				p.setPage(i);

				List<Status> statuses = ts.getTwitterObject().getUserTimeline(name, p);

				for (Status s : statuses) {
					allStatus.add(s);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return allStatus;
	}
	
	
	
	
	public int getFollowersCount(String name) {
		int count = 0;
		try {
			User user = new TwitterService().getTwitterObject().showUser(name);
			count = user.getFollowersCount();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	
	
	
	
	public int getHeartAmount(String name, int qntStatus) {
		int count = 0;
		List<Status> allStatus = getLastNStatuses(name, qntStatus);
		for (Status s : allStatus) {
			count += s.getFavoriteCount();
		}
		return count;
	}

	public DataSource getDataSource(String term) throws FacebookException, JSONException 
	{
		DataSource source = new DataSource();
		source.setName("Twitter");
		
		source.setLikesPage(this.getFollowersCount(term));
		source.setLikesPost(this.getHeartAmount(term, 100));
		
		return source;
	}
	
	
	

}
