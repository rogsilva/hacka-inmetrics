package br.com.inoutcomes.testes;

import java.util.List;

import br.com.inoutcomes.service.TwitterService;
import twitter4j.Status;

public class getHeartAmount {

	
	public static void main(String[] args) {
		
		
		TwitterService ts = new TwitterService();
		
		int num = ts.getHeartAmount("McDonalds_BR", 100);
		
		System.out.println(num);
		
		System.out.println(ts.getFollowersCount("McDonalds_BR"));
		
		
		
		
	}
}
