package br.com.inoutcomes.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.inoutcomes.beans.DataSource;
import br.com.inoutcomes.service.FacebookService;
import br.com.inoutcomes.service.TwitterService;

public class StartHacka implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// -------------------------------------------------------
		// TWITTER SOURCES

		String termoTwitter = (String) req.getParameter("twitterName");
		System.out.println("termoTwitter em StartHacka eh: " + termoTwitter);

		// data source não seta nada
		DataSource dsTwitter = new DataSource();

		// twitter session vai buscar
		TwitterService ts = new TwitterService();

		try {
			dsTwitter = ts.getDataSource(termoTwitter);

			System.out.println(dsTwitter.getLikesPage());
			System.out.println(dsTwitter.getLikesPost());

			req.setAttribute("twitterLikesPage", dsTwitter.getLikesPage());
			req.setAttribute("twitterLikesPost", dsTwitter.getLikesPost());

		} catch (Exception e) {
			e.printStackTrace();
		}

		// -------------------------------------------------------
		// FACE SOURCES

		
		String termoFacebook = (String) req.getParameter("facebookName");
		System.out.println("termoFacebook em StartHacka eh: " + termoFacebook);

		// data source não seta nada
		DataSource dsFace = new DataSource();

		// twitter session vai buscar
		FacebookService fs = new FacebookService();

		try {
			dsFace = fs.getDataSource(termoFacebook);

			System.out.println(dsFace.getLikesPage());
			System.out.println(dsFace.getLikesPost());

			req.setAttribute("faceLikesPage", dsFace.getLikesPage());
			req.setAttribute("faceLikesPost", dsFace.getLikesPost());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//--------------------------------------------------------
		
		return "index2.jsp";
	}

}
