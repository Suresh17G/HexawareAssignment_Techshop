package exception;

public class IncompleteOrderException extends Exception {
	public IncompleteOrderException() {
		super("Order detail lacks a product reference.");
	}
	
	@Override
	public String toString(){
		return "IncompleteOrderException: "+getMessage();
		
	}
	
}
