package br.com.inoutcomes.service;

import org.instagram4j.DefaultInstagramClient;
import org.instagram4j.InstagramClient;
import org.instagram4j.InstagramException;
import org.instagram4j.Result;
import org.instagram4j.entity.Media;

public class InstaService 
{
	private InstagramClient insta;
	
	public InstaService()
	{	
		this.insta = new DefaultInstagramClient("33c4d402583149a0b9f231c3f50481b0", "e09a1c31fada4d6d92e1bb67d86089e9");				
	}
	
	public Result<Media[]> searchMediaByHashTag(String str) throws InstagramException 
	{
		Result<Media[]> res = this.insta.getRecentMediaForTag(str, null);
		
		return res;
	}
}
