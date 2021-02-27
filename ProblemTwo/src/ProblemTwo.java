import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

/**
 * The intention of this class is to read in a CSVFile, and parse it accordingly. This program will
 * print each value (seperated by a comma, obviously), on a new line. It will ignore all commas 
 * within the quotation marks. The file path is found via the program, retrieving the working
 * directory, and then the user is tasked with entering the correct file name, case sensitive.
 * @author Steven Orsini
 * @version 2/22/2021
 */
public class ProblemTwo {
	public static void main(String[] args) {
					
		try {
			System.out.println("Please ensure that the file which you would like to parse is located within the working directory.");
			
			CSVReader csvReader = new CSVReader(new FileReader(System.getProperty("user.dir") + "/src/CsvExample.csv"));
			System.out.println("File found!");
			
			//this is done because in the sample output the ID,Name,Address was all omitted from the output
			String[] firstLine = csvReader.readNext();
			
			String[] nextLine;
			
			while((nextLine = csvReader.readNext()) != null) {
				for(String token: nextLine) {
					System.out.println(token);
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("The file with the path " + System.getProperty("user.dir") + "/src/CsvExample.csv" + " was not found.");
		}
		catch(CsvValidationException e1) {
			e1.printStackTrace();
		}
		catch(IOException e2) {
			System.out.println("Failed and or interrupted I/O operation. Please try again.\n");
			e2.printStackTrace();
		}
	}
}
