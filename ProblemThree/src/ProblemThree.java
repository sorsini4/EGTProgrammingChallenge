import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * The intention of this class is to format user entered numbers. There are two formats that are going
 * to be done, phone number and social security number. These formats are (xxx)xxx-xxxx and xxx-xx-xxxx
 * respectively. There is an abstract class Number in which PhoneNumber and SocialSecurityNumber objects
 * both extend, and inherit the format method from which does all the formatting from within the objects
 * respective number field.
 * @author Steven Orsini
 * @version 2/28/2021
 */
public class ProblemThree {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    

    public static void main(String[] args) {
        String userAnswer = "";
        boolean done = false;
        
        System.out.println("This program will format social security and phone numbers. Please enter the corresponsing number.\n" + 
            "Here are your options: \n" +
            "\t1. Format a ten digit phone number (ex: (xxx)xxx-xxxx)\n\t2. Format a nine digit social security number (ex: xxx-xx-xxxx)\n" +
            "\tPress \"Q\" to quit the program.");

        while(!done) {
        	System.out.print("You know the options.\n> ");

        	try {
        		userAnswer = input.readLine();
        	}           
        	catch(IOException e) {
        		e.printStackTrace();
        	}

        	if(userAnswer.equals("1")) {
        		System.out.print("Please enter a phone number to be formatted\n> ");
        		PhoneNumber phone = new PhoneNumber();
        		try {
        			userAnswer = input.readLine();
        			if(userAnswer.matches("\\d+") && userAnswer.length() == 10) {
        				System.out.println("Valid phone number! Formatting...");
        				phone.format(userAnswer);
        				System.out.println(phone.toString());
        			}
        			else {
        				throw new InvalidFormatException("Please enter a number with only digits, and maximum and minimum of 10 digits.");
        			}
        		}
        		catch(InvalidFormatException e) {
        			System.out.println(e.getMessage());
        		}
        		catch(IOException e1) {
        			e1.printStackTrace();
        		}
        	}
        	else if(userAnswer.equals("2")) {
        		SocialSecurityNumber social = new SocialSecurityNumber();
        		System.out.println("Please enter a social security number to be formatted\n> ");
        		try {
        			userAnswer = input.readLine();
        			if(userAnswer.matches("\\d+") && userAnswer.length() == 9) {
        				System.out.println("Valid social security number! Formatting...");
        				social.format(userAnswer);
        				System.out.println(social.toString());
        			}
        			else {
        				throw new InvalidFormatException("Please enter a number with only digits, and maximum and minimum of 9 digits.");
        			}
        		}
        		catch(InvalidFormatException e) {
        			System.out.println(e.getMessage());
        		}
        		catch(IOException e1) {
        			e1.printStackTrace();
        		}
        	}
        	else if(userAnswer.equals("Q")) {
        		done = true;
        	}
        	else {
        		System.out.println(userAnswer + " is not a valid choice.");
        	}
        }
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
