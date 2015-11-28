package br.com.inoutcomes.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.inoutcomes.beans.DataSource;
import br.com.inoutcomes.service.FacebookService;

public class FrameworkBO 
{
	public FrameworkBO(){
		
	}
	
	public List<DataSource> process(String pageName) throws Exception
	{
		if(pageName.equals("") || pageName.isEmpty()){
			throw new IllegalArgumentException("Obrigatório o nome da página");
		}	
		
		List<DataSource> list = new ArrayList<DataSource>();
		
		FacebookService face = new FacebookService();
		list.add(face.getDataSource(pageName));
		
		
		return list;
	}
	
}
