/**
 * This class extends the Number abstract class. It is used to format a phone number in the 
 * format of (xxx)xxx-xxxx. There is one abstract method that the class inherits and that is the
 * method called format, which is specific to this class in formatting a phone number.
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
	 * {@inheritDocs}
	 */
	public void format(String number) {
		String formattedNumber = "(" + number.substring(0,3) + ")";
		formattedNumber = formattedNumber + number.substring(3,6) + "-";
		formattedNumber = formattedNumber + number.substring(6,10);
		this.setNumber(formattedNumber);
	}
}
