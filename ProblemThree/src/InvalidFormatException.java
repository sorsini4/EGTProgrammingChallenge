/**
 * This is an exception used for when the user input is in an invalid form.
 * For this case, it is when the user enters an incorrectly formatted Phone or Social number.
 */
public class InvalidFormatException extends RuntimeException{
	public InvalidFormatException(String message) {
		super(message);
	}
}
