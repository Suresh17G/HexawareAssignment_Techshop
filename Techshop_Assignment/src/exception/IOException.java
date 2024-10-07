package exception;

public class IOException extends Exception {
    public IOException() {
        super("There is something wrong with the provided data!");
    }


    @Override
    public String toString() {
        return "IOException: " + getMessage();
    }
}
