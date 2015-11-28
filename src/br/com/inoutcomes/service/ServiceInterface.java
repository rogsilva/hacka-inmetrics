package br.com.inoutcomes.service;

import br.com.inoutcomes.beans.DataSource;
import facebook4j.FacebookException;
import facebook4j.internal.org.json.JSONException;

public interface ServiceInterface 
{
	public DataSource getDataSource(String term) throws FacebookException, JSONException;
}
