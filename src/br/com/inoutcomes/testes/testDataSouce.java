package br.com.inoutcomes.testes;

import br.com.inoutcomes.beans.DataSource;
import br.com.inoutcomes.service.FacebookService;
import br.com.inoutcomes.service.TwitterService;

public class testDataSouce {

	public static void main(String[] args) throws Exception {

		// FACEBOOK

		FacebookService fs = new FacebookService();

		DataSource ds = fs.getDataSource("McDonaldsBrasil");

		System.out.println("##" + ds.getName());
		System.out.println("likesPosts: " + ds.getLikesPost());
		System.out.println("likesPage: " + ds.getLikesPage());

		// TWITTER

//		TwitterService ts = new TwitterService();
//
//		DataSource tds = ts.getDataSource("BurgerKingBR");
//
//		System.out.println("\n\n##" + tds.getName());
//		System.out.println("likesPosts: " + tds.getLikesPost());
//		System.out.println("likesPage: " + tds.getLikesPage());

	}

}
