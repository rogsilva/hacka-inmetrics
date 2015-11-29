package br.com.inoutcomes.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.inoutcomes.beans.DataSource;
import br.com.inoutcomes.bo.FacebookBO;
import br.com.inoutcomes.bo.TwitterBO;

public class Step2 implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String facebookName1 = req.getParameter("facebookName1");
		String twitterName1 = req.getParameter("twitterName1");
		
		String facebookName2 = req.getParameter("facebookName2");
		String twitterName2 = req.getParameter("twitterName2");
		
		try{
			FacebookBO fbo = new FacebookBO();
			TwitterBO tbo = new TwitterBO();		
			
			DataSource facebook1 = fbo.process(facebookName1);
			DataSource twitter1 = tbo.process(twitterName1);
			
			//DataSource facebook2 = fbo.process(facebookName2);
			//DataSource twitter2 = tbo.process(twitterName2);
			
			req.setAttribute("facebook1", facebook1);
			req.setAttribute("twitter1", twitter1);
			//req.setAttribute("facebook2", facebook2);
			//req.setAttribute("twitter2", twitter2);
			
			req.setAttribute("facebookName1", facebookName1);
			req.setAttribute("twitterName1", twitterName1);
			req.setAttribute("facebookName2", facebookName2);
			req.setAttribute("twitterName2", twitterName2);
			
		}catch(Exception e){
			return e.getMessage();
		}
		
		return "resultado.jsp";
	}

}
