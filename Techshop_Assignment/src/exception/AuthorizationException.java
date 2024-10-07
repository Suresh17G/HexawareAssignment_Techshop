package exception;

public class AuthorizationException  extends Exception{

	public AuthorizationException(){
		super("Incorrect credentials");
	}

	public String toString(){
		return "AuthorizationException: "+getMessage();
		
	}
}
