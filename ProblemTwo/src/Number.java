/**
 * This is the number class and it is abstract. It has a default constructor in which nothing is 
 * set, and then a subsequent constructor in which the number field is set. It has one abstract 
 * method called format which is implemented for each specific class that extends this class. 
 * @author Steven Orsini
 * @version 2/23/2021
 */
public abstract class Number {

	private String number;
	
	/**
	 * This is a default constructor. 
	 */
	public Number() {
		
	}
	
	/**
	 * This constructor takes in the number given to it, and sets the field number equal to the 
	 * given parameter.
	 * @param number - the number 
	 */
	public Number(String number) {
		this.number = number;
	}
	
	/**
	 * This is a mutator method in which it takes the number field of the class and sets it equal
	 * to the parameter given.
	 * @param newNum - the new number 
	 */
	public void setNumber(String newNum) {
		this.number = newNum;
	}
	
	/**
	 * This is an accessor method in which it returns the number field of the corresponding class.
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Returns a string representation of the number that is part of the object.
	 * @return the number
	 */
	public String toString() {
		return getNumber();
	}
	
	/**
	 * This is an abstract method that will format the number the corresponds to the respective
	 * class. 
	 * @param number - the respective number related to class
	 */
	public abstract void format(String number);
	
}
