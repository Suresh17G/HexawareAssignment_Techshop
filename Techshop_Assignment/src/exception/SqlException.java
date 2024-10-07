package exception;

public class SqlException extends Exception  {
	public SqlException() {
		super("Database Error: Check query and related Schema");
	}
	public String toString(){
		return "SqlException: "+getMessage();
		
	}

}
