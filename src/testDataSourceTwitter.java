import br.com.inoutcomes.beans.DataSource;
import br.com.inoutcomes.service.TwitterService;
import facebook4j.FacebookException;
import facebook4j.internal.org.json.JSONException;

public class testDataSourceTwitter {
	
	
	public static void main(String[] args) {
		
		//data source não seta nada
		DataSource ds = new DataSource();
		
		
		//twitter session vai buscar
		TwitterService ts = new TwitterService();
		
		try {
			ds = ts.getDataSource("McDonalds_BR");
			
			System.out.println(ds.getLikesPage());
			System.out.println(ds.getLikesPost());
			
			
			
		} catch (FacebookException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
