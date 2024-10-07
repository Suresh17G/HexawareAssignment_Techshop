package exception;

public class ConcurrencyException extends Exception  {
	public ConcurrencyException() {
		super("multiple users simultaneously attempt to update the same order");
	}
	
	@Override
	public String toString(){
		return "ConcurrencyException: "+getMessage();
		
	}

}
