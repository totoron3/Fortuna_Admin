package filter;

public class Sanitizing {

	public String getEncodingString(String str) {
		str = str.replaceAll("&", "");
		str = str.replaceAll("<", "");
		str = str.replaceAll(">", "");
		str = str.replaceAll("\"", "");
		str = str.replaceAll("\'", "");
		return str;
	}

}
