package br.com.inoutcomes.testes;

import java.util.List;

import br.com.inoutcomes.service.TwitterService;
import twitter4j.Status;

public class getHeartAmount {

	
	public static void main(String[] args) {
		
		
		TwitterService ts = new TwitterService();
		
		int num = ts.getHeartAmount("BurgerKingBR", 4);
		System.out.println("hearAmount: "+num);

		
		
		List<Status> listaStatusTwitter = ts.getLastNStatuses("BurgerKingBR", 4);
		
		for(Status s: listaStatusTwitter){
			System.out.println(s.getText());
			System.out.println(s.getFavoriteCount());
			System.out.println(s.getId());
			System.out.println("");
		}
		
		
		
		
		
		
		
		
	}
}
