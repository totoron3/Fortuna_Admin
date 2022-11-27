package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class UserInfoArrayBean implements Serializable{
	
	private ArrayList<UserInfoBean> userArray;
	
	public UserInfoArrayBean() {
		userArray = new ArrayList<UserInfoBean>();
	}
	
	public int getArraySize() {
		return userArray.size();
	}
	
	public ArrayList<UserInfoBean> getUserArray(){
		return userArray;
	}

	public void setUserArray(ArrayList<UserInfoBean> userArray) {
		this.userArray = userArray;
	}
	
	public void addUser(UserInfoBean obj) {
		userArray.add(obj);
	}
	
	
}
