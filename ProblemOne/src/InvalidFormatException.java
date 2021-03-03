/**
 * This is an exception class used for when the user enters
 * an invalid formatted exception. In this case it is for when
 * the user enters something that is not a valid name, this exception
 * is thrown.
 */
public class InvalidFormatException extends RuntimeException{
	public InvalidFormatException(String message) {
		super(message);
	}
}
