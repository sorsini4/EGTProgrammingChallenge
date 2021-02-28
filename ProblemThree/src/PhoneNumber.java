/**
 * This class extends the Number abstract class. It is used to format a phone number in the 
 * format of (xxx)xxx-xxxx. There are two abstract methods that the class inherits and those are the
 * methods called format, which is specific to this class in formatting a phone number and validNumber
 * which is specific to checking the length and integrity of the phone number entered.
 * @author Steven Orsini
 * @version 2/23/2021
 */
public class PhoneNumber extends Number {
	
	/**
	 * This is a default constructor.
	 */
	public PhoneNumber() {
		super();
	}
	
	/**
	 * This constructor allows setting the field number equal to something when instantiating 
	 * the object.
	 * @param phoneNumber - the phone number 
	 */
	public PhoneNumber(String phoneNumber) {
		super(phoneNumber);
	}

	@Override
	/**
	 * {@inheritDocs
	 */
	public boolean validNumber(String number) throws InvalidFormatException {
		if(number.matches("\\d+") && number.length() == 10) {
			return true;
		}
		throw new InvalidFormatException("Please enter a number with only digits, and maximum and minimum of 10 digits.");
	}

	@Override
	/**
	 * {@inheritDocs}
	 */
	public void format(String number) {
		String formattedNumber = "(" + number.substring(0,3) + ")";
		formattedNumber = formattedNumber + number.substring(3,6) + "-";
		formattedNumber = formattedNumber + number.substring(6,10);
		this.setNumber(formattedNumber);
	}
	
}
