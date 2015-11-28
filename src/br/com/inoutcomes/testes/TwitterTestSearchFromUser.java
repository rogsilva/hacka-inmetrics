package br.com.inoutcomes.testes;

import java.util.List;

import br.com.inoutcomes.service.TwitterService;
import twitter4j.Paging;
import twitter4j.Status;

public class TwitterTestSearchFromUser {

	public static void main(String[] args) {
		try {

			TwitterService ts = new TwitterService();

			Paging p = new Paging(1, 100);

			// FUNFANDO

			for (int i = 1; i <= 60; i++) {

				p.setPage(i);

				List<Status> statuses2 = ts.getTwitterObject().getUserTimeline("BurgerKingBR", p);

				int count = 1;
				for (Status s : statuses2) {
					System.out.println("tweet n.: " + ((p.getPage() - 1) * 100 + count));
					System.out.println(s.getText());
					System.out.println(s.getId());
					System.out.println(s.getCreatedAt());
					System.out.println();
					count++;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
