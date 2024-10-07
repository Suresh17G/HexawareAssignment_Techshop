package exception;

public class PaymentFailedException extends Exception {
	
	public String toString(){
		return "payment is declined.";
		
	}
}
