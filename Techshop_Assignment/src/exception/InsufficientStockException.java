package exception;

public class InsufficientStockException extends Exception {
	public InsufficientStockException() {
		super("stock not available ");
	}
	
	@Override
	public String toString(){
		return "InsufficientStockException: "+getMessage();
		
	}
}
