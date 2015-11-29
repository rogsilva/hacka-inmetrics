package br.com.inoutcomes.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.inoutcomes.beans.DataSource;
import br.com.inoutcomes.service.FacebookService;
import br.com.inoutcomes.service.TwitterService;

public class FrameworkBO 
{
	public FrameworkBO(){
		
	}
	
	public List<DataSource> process(String pageNameF, String pageNameT) throws Exception
	{
		if(pageNameF.equals("") || pageNameF.isEmpty()){
			throw new IllegalArgumentException("Obrigatório o nome da página do Facebook");
		}	
		
		if(pageNameT.equals("") || pageNameT.isEmpty()){
			throw new IllegalArgumentException("Obrigatório o nome da página do Twitter");
		}
		
		List<DataSource> list = new ArrayList<DataSource>();
		
		FacebookService facebook = new FacebookService();
		list.add(facebook.getDataSource(pageNameF));
		
		TwitterService twitter = new TwitterService();
		list.add(twitter.getDataSource(pageNameT));
		
		return list;
	}
	
}
