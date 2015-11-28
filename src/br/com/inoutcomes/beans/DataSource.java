package br.com.inoutcomes.beans;

public class DataSource
{
	private String name;
	private int likesPage;
	private long likesPost;
	
	public DataSource(String name, int likesPage, long likesPost) {
		super();
		this.name = name;
		this.likesPage = likesPage;
		this.likesPost = likesPost;
	}
	
	public DataSource()
	{
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLikesPage() {
		return likesPage;
	}

	public void setLikesPage(int likesPage) {
		this.likesPage = likesPage;
	}

	public long getLikesPost() {
		return likesPost;
	}

	public void setLikesPost(long likesPost) {
		this.likesPost = likesPost;
	}
	
	
	

}
