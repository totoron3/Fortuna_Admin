package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class SpotsUpdateArrayBean implements Serializable{
	
	private ArrayList<SpotsUpdateBean> spotsUpdateArray;
	
	public SpotsUpdateArrayBean() {
		spotsUpdateArray = new ArrayList<SpotsUpdateBean>();
	}
	
	public int getArraySize() {
		return spotsUpdateArray.size();
	}
	
	public ArrayList<SpotsUpdateBean> getSpotsUpdateArray(){
		return spotsUpdateArray;
	}
	
	public void setSpotsUpdateArray(ArrayList<SpotsUpdateBean> spotsUpdateArray) {
		this.spotsUpdateArray = spotsUpdateArray;
	}
	
	public void addSpots(SpotsUpdateBean obj) {
		spotsUpdateArray.add(obj);
	}
}
