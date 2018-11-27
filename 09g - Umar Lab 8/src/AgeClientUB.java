/*
 * Name: Umar Bath
 *
 * Course: CS-12, Spring 2016
 *
 * Date: 4/8/2016
 *
 * Filename: AgeClientUB.java
 
 * Purpose: Main file to test the UtilsUB file, using user inputs.
 */
 
public class AgeClientUB {
	public static void main(String[] args) {

		int month, day, year;																		// create variables
		
		month = UtilsUB.readInt("Birth month: ", false);											// initialize variables with call to UtilsUB class and scanner
		day = UtilsUB.readInt("Birth day: ", false);
		year = UtilsUB.readInt("Birth year: ", false);
		
		CS12Date obj = new CS12Date(month, day, year);												// send variables into CS12Date
		
		System.out.println("Birthday: " + obj + "\t Age = " + UtilsUB.getAge(obj)); 				// display the date that was entered and call getAge while also displaying
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		month = UtilsUB.readInt("Birth month: ", true);												// initialize variables with call to UtilsUB class and scanner
		day = UtilsUB.readInt("Birth day: ", true);
		year = UtilsUB.readInt("Birth year: ", true);
		
		CS12Date obj2 = new CS12Date(month, day, year);												// send variables into CS12Date
		
		System.out.println("Birthday: " + obj2 + "\t Age = " + UtilsUB.getAge(obj2)); 				// display the date that was entered and call getAge while also displaying
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		CS12Date birthDate = new CS12Date(9, 12, 1991);												// birth date object hard wired
		CS12Date futureDate = new CS12Date(9, 12, 2041);											// future date object hard wired
		
		System.out.println("\nBirthday: " + birthDate + "\t Age = " + UtilsUB.getAge(birthDate, futureDate) + "\t as of " + futureDate); // display the birth date, call getAge while also displaying and display the future date
				 
	}
}
