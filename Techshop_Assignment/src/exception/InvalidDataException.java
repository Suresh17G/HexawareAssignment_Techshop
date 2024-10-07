package exception;

public class InvalidDataException extends Exception {
	public InvalidDataException() {
		super("Invalid data: Please enter valid data");
	}
	
	@Override
	public String toString(){
		return "InvalidDataException: "+getMessage();
		
	}
}
