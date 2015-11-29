package br.com.inoutcomes.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.inoutcomes.beans.DataSource;
import br.com.inoutcomes.service.FacebookService;
import br.com.inoutcomes.service.TwitterService;

public class GraficoPlot implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		
		// ######___TWITTER
		// twitter service
		TwitterService ts = new TwitterService();

		// name1
		DataSource twitterDSName1 = new DataSource();
//		twitterDSName1 = ts.getDataSource("McDonalds_BR");
		twitterDSName1.setLikesPage(340114);
		twitterDSName1.setLikesPost(2618);
		twitterDSName1.setName("Twitter");

		// name2
		DataSource twitterDSName2 = new DataSource();
//		twitterDSName2 = ts.getDataSource("BurgerKingBR");
		twitterDSName2.setLikesPage(119971);
		twitterDSName2.setLikesPost(104);
		twitterDSName2.setName("Twitter");
		
		
		
		// ######___FACEBOOK
		FacebookService fs = new FacebookService();
		
		//name1
		DataSource facebookDSName1 = new DataSource();
//		facebookDSName1 = fs.getDataSource("McDonalds");
		facebookDSName1.setLikesPage(60804998);
		facebookDSName1.setLikesPost(4864399);
		facebookDSName1.setName("Facebook");
		
		
		//name2
		DataSource facebookDSName2 = new DataSource();
//		facebookDSName2 = fs.getDataSource("Burger King");
		facebookDSName2.setLikesPage(67280);
		facebookDSName2.setLikesPost(750);
		facebookDSName2.setName("Facebook");
		
		
		req.setAttribute("facebook1", facebookDSName1);
		req.setAttribute("twitter1", twitterDSName1);
		req.setAttribute("facebook2", facebookDSName2);
		req.setAttribute("twitter2", twitterDSName2);
		
		
		
		
		
		return "resultadoTesteGrafico.jsp";
	}

}
