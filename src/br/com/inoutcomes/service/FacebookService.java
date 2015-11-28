package br.com.inoutcomes.service;

import java.util.Date;

import javax.sound.midi.MidiChannel;

import br.com.inoutcomes.beans.DataSource;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Like;
import facebook4j.Page;
import facebook4j.Post;
import facebook4j.RawAPIResponse;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;
import facebook4j.internal.org.json.JSONException;
import facebook4j.internal.org.json.JSONObject;

public class FacebookService implements ServiceInterface
{
	private Date data;
	private Facebook facebook;
	private String token = "CAALtnVgiFHMBAEmNpHxTlU7ZBVweJFf1XAaU86sfr6QdRpQQTEX76CoQiRvn4gFBCqp7Y1hoVuZCqTFtTHOZBBOpgkrZCYW0cSjbAg4djoJiwZC3eXu7JBqjyhaEWufb02VWfJjRhwroQCLEY5OTubvNBU3EWBxoeZAEdc3K6ZCxgJ6rnDyZCOStXyYmzDwOkU76ZBq5hfNp6rfPN1nxnvoF2";
	
	public FacebookService() throws Exception
	{
		data = new Date();
		String appId = "824209997698163";
		String appSecret = "b03fac2585296abf7ea02f5dd86f7cf7";
		this.facebook = new FacebookFactory().getInstance();
		this.facebook.setOAuthAppId(appId, appSecret);				
		this.facebook.setOAuthPermissions("public_profile, basic_info, read_stream, read_mailbox, read_page_mailboxes, rsvp_event, email, read_insights, manage_notifications, read_friendlists, manage_pages, publish_actions, user_birthday, user_religion_politics, user_relationships, user_relationship_details, user_hometown, user_location, user_likes, user_activities, user_interests, user_education_history, user_work_history, user_website, user_groups, user_events, user_photos, user_videos, user_friends, user_about_me, user_status, user_games_activity, user_tagged_places, user_actions.books, user_actions.music, user_actions.video, user_actions.news");
		//this.facebook.setOAuthPermissions("public_profile");
		
		this.facebook.setOAuthAccessToken(new AccessToken(this.token));
	}
	
	public ResponseList<Post> getPost(String term) throws FacebookException
	{
		ResponseList<Post> results = facebook.getPosts(term, new Reading().fields("id,name").limit(100));
		return results;
	}

	public ResponseList<Page> getPages(String page) throws FacebookException
	{
		ResponseList<Page> results = facebook.searchPages(page, new Reading().fields("id,name,likes"));
		return results;
	}
	public long getTotalLikes(String postId) throws FacebookException, JSONException
	{
		RawAPIResponse res = facebook.callGetAPI(postId+"/likes?summary=true&access_token="+this.token);
		JSONObject jsonObject = res.asJSONObject();
		String total = jsonObject.getString("summary");
		JSONObject jsonObj = new JSONObject(total);
		String result = jsonObj.getString("total_count");
		return Long.parseLong(result);
	}


	public DataSource getDataSource(String term) throws FacebookException, JSONException {

		DataSource source = new DataSource();
		source.setName("Facebook");
		String pageId = null;
		long countLikesPost = 0;
		
		ResponseList<Page> pages = this.getPages(term);
		for (Page page : pages){
			pageId = page.getId();
			source.setLikesPage(page.getLikes());
			
			ResponseList<Post> posts = this.getPost(page.getId());
			for (Post post : posts){
				countLikesPost += this.getTotalLikes(post.getId());
			}
			break;
		}		
		source.setLikesPost(countLikesPost);
		
		return source;
	}
	
}
