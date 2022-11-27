package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class FeedBackArrayBean implements Serializable{

	private ArrayList<FeedBackBean> feedBackArray;
	
	public FeedBackArrayBean() {
		feedBackArray = new ArrayList<FeedBackBean>();
	}
	
	public int getArraySize() {
		return feedBackArray.size();
	}

	public void setFeedBackArray(ArrayList<FeedBackBean> feedBackArray) {
		this.feedBackArray = feedBackArray;
	}
	
	public void addFeedBack(FeedBackBean obj) {
		feedBackArray.add(obj);
	}

	public ArrayList<FeedBackBean> getFeedBackArray() {
		return feedBackArray;
	}
	
	
}
