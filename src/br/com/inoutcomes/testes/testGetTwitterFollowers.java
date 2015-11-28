package br.com.inoutcomes.testes;

import br.com.inoutcomes.service.TwitterService;

public class testGetTwitterFollowers {


	public static void main(String[] args) {
		
		try {
			
			
			TwitterService ts = new TwitterService();
			
			System.out.println(ts.getFollowersCount("McDonalds_BR"));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}