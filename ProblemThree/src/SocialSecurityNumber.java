/**
 * This class extends the Number abstract class. It is used to format a social security number 
 * in the format of xxx-xx-xxxx. There are two abstract methods that this class inherits and those are 
 * the methods called format, which is specific to this class in formatting a social security number and
 * validNumber which is specific to checking the length and integrity of the social number entered.
 * @author Steven Orsini
 * @version 2/23/2021
 */
public class SocialSecurityNumber extends Number{

	/**
	 * This is a default constructor.
	 */
	public SocialSecurityNumber() {
		super();
	}
	
	/**
	 * This constructor allows setting the field number equal to something when instantiating 
	 * the object.
	 * @param social - the social security number
	 */
	public SocialSecurityNumber(String social) {
		super(social);
	}

	@Override
	/**
	 * {@inheritDocs}
	 */
	public boolean validNumber(String number) {
		if(number.matches("\\d+") && number.length() == 9) {
			return true;
		}
		throw new InvalidFormatException("Please enter a number with only digits, and maximum and minimum of 9 digits.");
	}

	@Override
	/**
	 * {@inheritDocs}
	 */
	public void format(String number) {
		String ssn = number.substring(0,3) + "-";
		ssn = ssn + number.substring(3,5) + "-";
		ssn = ssn + number.substring(5,9);
		this.setNumber(ssn);
	}
	
}
