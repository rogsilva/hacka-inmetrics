package br.com.inoutcomes.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.inoutcomes.beans.DataSource;
import br.com.inoutcomes.service.TwitterService;

public class TwitterBO 
{
	public TwitterBO(){
		
	}
	
	public DataSource process(String pageNameT) throws Exception
	{
		if(pageNameT.equals("") || pageNameT.isEmpty()){
			throw new IllegalArgumentException("Obrigatório o nome da página do Twitter");
		}
		
		TwitterService twitter = new TwitterService();
		
		return twitter.getDataSource(pageNameT);
	}
	
}
