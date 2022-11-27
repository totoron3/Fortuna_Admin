package token;

import java.util.UUID;

public class TokenIDGenerate {

	public String tokenID(){
		String tokenID = UUID.randomUUID().toString();
		return tokenID;
	}

}
