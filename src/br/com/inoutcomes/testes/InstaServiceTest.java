package br.com.inoutcomes.testes;

import br.com.inoutcomes.service.InstaService;

public class InstaServiceTest {

	public static void main(String[] args) 
	{
		try{
			InstaService insta = new InstaService();
			System.out.println("instância criada!");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
