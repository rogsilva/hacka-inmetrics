package br.com.inoutcomes.service;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Like;
import facebook4j.Page;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;

public class FacebookService 
{
	private Facebook facebook;
	
	public FacebookService() throws Exception
	{
		String appId = "824209997698163";
		String appSecret = "b03fac2585296abf7ea02f5dd86f7cf7";
		this.facebook = new FacebookFactory().getInstance();
		this.facebook.setOAuthAppId(appId, appSecret);				
		this.facebook.setOAuthPermissions("public_profile, basic_info, read_stream, read_mailbox, read_page_mailboxes, rsvp_event, email, read_insights, manage_notifications, read_friendlists, manage_pages, publish_actions, user_birthday, user_religion_politics, user_relationships, user_relationship_details, user_hometown, user_location, user_likes, user_activities, user_interests, user_education_history, user_work_history, user_website, user_groups, user_events, user_photos, user_videos, user_friends, user_about_me, user_status, user_games_activity, user_tagged_places, user_actions.books, user_actions.music, user_actions.video, user_actions.news");
		//this.facebook.setOAuthPermissions("public_profile");
		
		this.facebook.setOAuthAccessToken(new AccessToken("CAALtnVgiFHMBAB8TnWNZAiDks1ZAZCkyp718NZBNEwk60OPT548L9A0RCVyvHnuamwy9PVeemcwAA2LWZBEfMtFRsoLlPJ7YZAKmWUUgWg0UYib6Db9YXiatz1TXE8Y0jN1b4Q4RAb1boW6U9sUZC0oZCUucrTgdL6bVWHcrNWxo8LI4IwdnR3CIQd5FgzaiJZBObgJJ2URo1ALceTLH20SYQ"));
	}
	
	public ResponseList<Post> getPost(String term) throws FacebookException
	{
		ResponseList<Post> results = facebook.getPosts(term, new Reading().fields("id,message,likes"));
		return results;
	}
	
	public ResponseList<User> getUsers(String name) throws FacebookException
	{
		ResponseList<User> results = facebook.searchUsers(name);
		return results;
	}
	
	public ResponseList<Page> getPages(String page) throws FacebookException
	{
		ResponseList<Page> results = facebook.searchPages(page, new Reading().fields("id,name,likes"));
		return results;
	}
	
	public ResponseList<Like> getLikes(String post) throws FacebookException
	{
		ResponseList<Like> results = facebook.getPostLikes(post, new Reading().summary().limit(250));
		return results;
	}
	
}
