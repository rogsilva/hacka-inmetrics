package br.com.inoutcomes.testes;

import java.util.List;

import br.com.inoutcomes.service.TwitterService;

public class TwitterServiceTest {

	public static void main(String[] args)
	{
		try{
			
			TwitterService ts = new TwitterService();
			System.out.println("Instanciou!");
			
			List<String> list = ts.search("Fiap", 100);
			for (String string : list) {
				System.out.println(string);
			}
			System.out.println("Acabou!");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
