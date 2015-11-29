package br.com.inoutcomes.testes;

import br.com.inoutcomes.service.FacebookService;
import facebook4j.Page;
import facebook4j.Post;
import facebook4j.ResponseList;

public class FacebookServiceTest {
	
	Integer likesCount = 0;

	public static void main(String[] args) {

		try{
			FacebookService fs = new FacebookService();
			System.out.println("Instanciou!!");
			
			
			ResponseList<Page> pages = fs.getPages("Burguer King Brasil");
			
			
			for (Page page : pages){
				System.out.println("----------PAGE---------");
				System.out.println(page.getName());
				System.out.println(page.getLikes());
				System.out.println("----------POSTS---------");
				
				ResponseList<Post> posts = fs.getPost(page.getId().toString());
				for (Post post : posts){
					System.out.println(post.getName());
					fs.getTotalLikes(post.getId());
					System.out.println("\n");
				}
				System.out.println("-------------------");
				System.out.println("\n");
				break;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
