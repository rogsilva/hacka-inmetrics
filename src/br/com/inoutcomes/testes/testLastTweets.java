package br.com.inoutcomes.testes;

import java.util.ArrayList;
import java.util.List;

import br.com.inoutcomes.service.TwitterService;
import twitter4j.Status;

public class testLastTweets {

	public static void main(String[] args) {

		TwitterService ts = new TwitterService();

		List<Status> lista = new ArrayList<Status>();
		lista = ts.getLastNStatuses("1eandro", 15);

		int count = 1;
		for (Status s : lista) {
			System.out.println("tweet: #" + count);
			System.out.println(s.getText());
			System.out.println(s.getCreatedAt());
			System.out.println();
			System.out.println();
			count++;
		}

	}

}
