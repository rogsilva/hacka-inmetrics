package br.com.inoutcomes.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.inoutcomes.beans.DataSource;
import br.com.inoutcomes.service.FacebookService;

public class FacebookBO 
{
	public FacebookBO(){
		
	}
	
	public DataSource process(String pageNameF) throws Exception
	{
		if(pageNameF.equals("") || pageNameF.isEmpty()){
			throw new IllegalArgumentException("Obrigat�rio o nome da p�gina do Facebook");
		}	

		FacebookService facebook = new FacebookService();
		
		return facebook.getDataSource(pageNameF);
	}
	
}
