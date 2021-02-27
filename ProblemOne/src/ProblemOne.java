import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Iterator;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * The intention of this class is to prompt the user for how many names they would like to enter 
 * into the MongoDB database. The database is stored with three keys, (name, occurence, and nameID).
 * These three keys are rather self explanatory. The name is the 3 character substring of the user
 * entered name, occurence is how many times it is in the database, and the nameID is the substring
 * name with the ID following it. These are all stored within the database "IDS", and the collection
 * "employees". After the user enters the amount of names they were prompted for, the collection
 * employees is then iterated over and the nameID field is printed out to the user, the same way
 * that it was entered.
 * @author Steven Orsini
 * @version 2/22/2021
 */
public class ProblemOne {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static MongoCollection<Document> col;
	static MongoClient client = MongoClients.create();
	
	public static void main(String[] args) {
		setUpDB();
		
		int amtOfNames = 0;
		
		System.out.print("How many names would you like to input?\n> ");
		try {
			amtOfNames = Integer.parseInt(input.readLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Please enter an integer amount to clarify the number of names you would like to enter.");
		}
		catch(IOException e1) {
			e1.printStackTrace();
		}
		
		populateDatabaseWithIDs(amtOfNames);
		printIDs();
		
		client.close();
		
		System.out.println("Database has been closed.\nGoodbye!");
		System.exit(0);
	}
	
	/**
	 * This function is used to set the warning level for the logger, and set up the database. It
	 * checks to make sure the static variable MongoClient is not equal to null, ensuring a proper
	 * connection, and then it connects to the proper database and collection, IDS, and employees
	 * respectively. It then logs in the console that the database has been properly configured. 
	 */
	public static void setUpDB() {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
		
		if(!client.equals(null)) {
			System.out.println("Connected!");
		}
		else {
			System.out.println("Failed to connect to database.");
		}
		
		MongoDatabase db = client.getDatabase("IDS");
		col = db.getCollection("employees");
		
		System.out.println("Database has been set up.\n");	
	}
	
	/**
	 * This function will prompt the user to enter the amount of names that they asked for.
	 * The name is valid if it only includes letters in the alphabet. After checking this, it will
	 * get the substring of the first three letters of the name. After this, it will check the
	 * database for the current occurences of the 3 letter name. It adds one to the amount of 
	 * occurences, in anticipation of this document being added to the collection. After this, 
	 * it inserts the parameters name, the occurences of the name, and then the name concatenated
	 * with the occurences multiplied by five. The latter parameter creates the three number ID
	 * that is attached to the end of the name.
	 * @param amtOfNames - the amount of names the user would like to enter 
	 */
	public static void populateDatabaseWithIDs(int amtOfNames){
		int i = 0;
		String name;
		
		while(i < amtOfNames) {
			System.out.println("Name " + (i + 1) + " of " + amtOfNames + ".\n" + (amtOfNames - (i)) + " left to insert.");
			System.out.print("Insert a name\n> ");
			
			try {
				name = input.readLine().toUpperCase();
				if(name.matches("[A-Z]+")) {
					
					name = name.substring(0,3);	
					long occurencesOfName = col.countDocuments(new Document("name", name)) + 1;
					
					col.insertOne(new Document("name", name).append("occurence", occurencesOfName)
							.append("nameID", name + String.format("%03d", (occurencesOfName * 5))));
					
					System.out.println("Name correctly added to the database!\n");
					i++;
				}
				else {
					throw new InputMismatchException();
				}
			}
			catch(InputMismatchException e) {
				System.out.println("When entering a name, please only use letters [A-Z], upper and or lowercase is allowed.\n");
			}
			catch(IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * This function will iterate over the collection that has been assigned to the FindIterable
	 * object. While there is still another document in the collection, the iterator will go into
	 * the while loop and print out the nameID of the next document. 
	 */
	public static void printIDs() {
		FindIterable<Document> iterableDoc = col.find();
		Iterator<Document> myIt = iterableDoc.iterator();
		Document currentDoc;
		while(myIt.hasNext()) {
			currentDoc = myIt.next();
			System.out.println(currentDoc.get("nameID"));
		}
		System.out.println();
	}
}