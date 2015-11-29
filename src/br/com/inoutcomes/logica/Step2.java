package br.com.inoutcomes.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.inoutcomes.beans.DataSource;
import br.com.inoutcomes.bo.FacebookBO;
import br.com.inoutcomes.bo.TwitterBO;

public class Step2 implements Logica {

	// count global que controla as threads
	private static int globalCountController = 0;

	// atributos dos DataSources
	private static DataSource facebook1;
	private static DataSource twitter1;
	private static DataSource facebook2;
	private static DataSource twitter2;

	// atributos estáticos da palavra pesquisada
	private static String facebookName1;
	private static String twitterName1;;
	private static String facebookName2;
	private static String twitterName2;

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		facebookName1 = req.getParameter("facebookName1");
		twitterName1 = req.getParameter("twitterName1");

		facebookName2 = req.getParameter("facebookName2");
		twitterName2 = req.getParameter("twitterName2");

		try {
			FacebookBO fbo = new FacebookBO();
			TwitterBO tbo = new TwitterBO();


			// Criando as Threads e passando os Runnables
			Thread t1 = new Thread(new FacebookSearchNode1(facebookName1));
			Thread t2 = new Thread(new TwitterSearchNode1(twitterName1));

			Thread t3 = new Thread(new FacebookSearchNode2(facebookName2));
			Thread t4 = new Thread(new TwitterSearchNode2(twitterName2));

			// Startando as Threads
			t1.start();
			t2.start();
			t3.start();
			t4.start();

			// Controle do final da Thread
			int waitingCount = 0;
			while (globalCountController < 4) {

				Thread.sleep(1000);
				System.out.println("Dormiu " + (++waitingCount) + " vez.");
				System.out.println("Count eh: " + globalCountController);
				System.out.println();
			}

		

			req.setAttribute("facebook1", facebook1);
			req.setAttribute("twitter1", twitter1);
			req.setAttribute("facebook2", facebook2);
			req.setAttribute("twitter2", twitter2);

			req.setAttribute("facebookName1", facebookName1);
			req.setAttribute("twitterName1", twitterName1);
			req.setAttribute("facebookName2", facebookName2);
			req.setAttribute("twitterName2", twitterName2);

		} catch (Exception e) {
			req.setAttribute("error", e.getMessage());
			return "social2.jsp";
		}

		return "resultado.jsp";
	}

	// CLASSES ESTATICAS

	static class FacebookSearchNode1 implements Runnable {

		String name;

		// Construtor
		public FacebookSearchNode1(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			try {
				facebook1 = new FacebookBO().process(name);
				globalCountController++;

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	static class FacebookSearchNode2 implements Runnable {

		String name;

		// Construtor
		public FacebookSearchNode2(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			try {
				facebook2 = new FacebookBO().process(name);
				globalCountController++;

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	static class TwitterSearchNode1 implements Runnable {

		String name;

		// Construtor
		public TwitterSearchNode1(String name) {
			this.name = name;
		}

		@Override
		public void run() {

			try {

				twitter1 = new TwitterBO().process(name);
				globalCountController++;

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	static class TwitterSearchNode2 implements Runnable {

		String name;

		// Construtor
		public TwitterSearchNode2(String name) {
			this.name = name;
		}

		@Override
		public void run() {

			try {

				twitter2 = new TwitterBO().process(name);
				globalCountController++;

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
