package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class NewsArrayBean implements Serializable{

	private ArrayList<NewsBean> newsArray;

	public NewsArrayBean() {
		newsArray = new ArrayList<NewsBean>();
	}
	
	public int getArraySize() {
		return newsArray.size();
	}
	
	public ArrayList<NewsBean> getNewsArray() {
		return newsArray;
	}

	public void setNewsArray(ArrayList<NewsBean> newsArray) {
		this.newsArray = newsArray;
	}
	
	public void addNews(NewsBean obj) {
		newsArray.add(obj);
	}
}
