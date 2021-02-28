/**
 * This class extends the Number abstract class. It is used to format a social security number 
 * in the format of xxx-xx-xxxx. There is one abstract method that the class inherits and that is 
 * the method called format, which is specific to this class in formatting a social security number.
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
	public void format(String number) {
		String ssn = number.substring(0,3) + "-";
		ssn = ssn + number.substring(3,5) + "-";
		ssn = ssn + number.substring(5,9);
		this.setNumber(ssn);
	}
}

