package br.com.inoutcomes.testes;

import br.com.inoutcomes.service.FacebookService;
import facebook4j.Like;
import facebook4j.PagableList;
import facebook4j.Page;
import facebook4j.Post;
import facebook4j.ResponseList;

public class FacebookServiceTest {

	public static void main(String[] args) {

		try{
			FacebookService fs = new FacebookService();
			System.out.println("Instanciou!!");
			
			//ResponseList<User> users = fs.getUsers("Burguer King Brasil");
		//	for (User user : users){
			//	System.out.println(user.getName());
			//}
			
			
			//ResponseList<Post> posts = fs.getPost("BurguerKing");
			//for (Post post : posts){
			//	System.out.println(post.getId());
			//}
			
			
			ResponseList<Page> pages = fs.getPages("Burguer King Brasil");
			for (Page page : pages){
				
				//System.out.println();
				System.out.println(page.getName());
				System.out.println(page.getLikes());
				System.out.println("-------------------");
				
				ResponseList<Post> posts = fs.getPost(page.getId().toString());
				for (Post post : posts){
					System.out.println(post.getName());
					PagableList<Like> likes = fs.getLikes(post.getId());
					System.out.println(likes.size());
					System.out.println("\n");
				}
				
				System.out.println("-------------------");
				System.out.println("\n");
			}
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
