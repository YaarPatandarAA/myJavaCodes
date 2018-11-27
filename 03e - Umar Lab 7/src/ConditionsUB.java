/*
 * Name: Umar Bath
 *
 * Course: CS-12, Spring 2016
 *
 * Date: 4/3/2016
 *
 * Filename: Conditions.java
 
 * Purpose: Learn and apply how conditions work in java, with error catching
 */

import java.util.Scanner;
public class ConditionsUB {
	
	public static void main(String[] args) {
		
		Scanner myVar = new Scanner(System.in); 												// create scanner
		
		String temp; 																			// temporary string for user input
		
		int age, dayNum, n; 																	// internal int values
		boolean timeOfDay; 																		// internal boolean value
		boolean rate0, rate1, rate2, rate3, rate4; 												// boolean values for rate 0 - 4
		 
		rate0 = false; 																			// initialy set all rates to false,
		rate1 = false; 																			// due to the fact that only
		rate2 = false; 																			// one rate will change to true
		rate3 = false;
		rate4 = false;

		System.out.println("=============================================================="); 	// simple header for nice output
		System.out.println("                         Movie Rates                          ");
		System.out.println("==============================================================");
		
		// do while loop for possible error of day 
		do{
			dayNum = 0; 																		// initaly set number of the day to zero, will be changed accordingly below
			System.out.print("   What day is it today: "); 										// ask user for day
			temp = myVar.nextLine(); 															// take in day as string
			temp = temp.toUpperCase(); 															// change string to all upper case for easy compare with following case statements
			
			// checks user inputed string against following seven cases
			switch (temp){
			case "MONDAY":
				dayNum = 1; 																	// number of day changes depending on which day user entered as a string
				break;
			case "TUESDAY":
				dayNum = 2;
				break;
			case "WEDNESDAY":
				dayNum = 3;
				break;
			case "THURSDAY":
				dayNum = 4;
				break;
			case "FRIDAY":
				dayNum = 5;
				break;
			case "SATURDAY":
				dayNum = 6;
				break;
			case "SUNDAY":
				dayNum = 7;
				break;
			default:
				System.out.println("Incorrect Input"); 											// if user enters incorrect word or mis-types
				System.out.println();
			}
			
		}while (dayNum == 0);
		
		// do while loop for possible error of time of day
		do{
			n = 0; 																				// temporary int value for do-while loop, because it do-while can not be tested against time of day as it is only two values
			timeOfDay = false; 																	// initial set of time of day (boolean)
			System.out.print("   What time of the day is it, afternoon or evening: "); 			// as user if it is afternoon or evening
			temp = myVar.nextLine(); 															// take in answer as string
			temp = temp.toUpperCase(); 															// change string to all upper case for easy compare with following case statements
			
			// checks user inputed string against following cases
			switch (temp){
			case "AFTERNOON":
				n = 1; 																			// values is set to 1 so do-while loop ends
				timeOfDay = false; 																// Officially sets value of time of day as a boolean
				break;
			case "EVENING":
				n = 1;
				timeOfDay = true;
				break;
			default:
				System.out.println("Incorrect Input"); 											// if user enters incorrect word or mis-types
				System.out.println();
			}
			
		}while (n == 0);
		
		age = 0;																				// must initialize if going to use try catch
		// try catch if user inputs string rather than int
		try{
			// do while loop for possibility of entering a negative age
			do{
				System.out.print("   What is age of viewer: ");					 				// asks user for age
				age = myVar.nextInt();															// takes age as a int value
				if (age < 0){ 																	// checks if age is below 0
					System.out.println("Age is a negative number, try again.");
					System.out.println();
				}
			}while (age < 0);																	// do-while ends if age is above 0
		}catch(Exception e){
			System.out.println("ERROR!!! PROGRAM CRASHED");
			System.exit(0); 																	// exits the program
		}

		System.out.println("==============================================================");
		System.out.println();
		
		// if else-if else loop to finally set values of rates
		if ( (dayNum == 2) && (timeOfDay == true) ) { 											// if day is tuesday and evening
			rate3 = true; 																		// changes rate3 to true while others are still false
		}
		else if ( (dayNum == 4) && (timeOfDay == false) ) { 									// if day is thursday and afternoon
			rate3 = true;
		}
		else{ 																					//if day is not tuesday, thursday & coresponding time of day is not true
			if ( (age <= 4) && (age >= 0) ){ 													// checks for age group 
				if ( (dayNum == 6) || (dayNum == 7) ){ 											// because age group of 0-4 has kids rate on saturday and sunday
					rate1 = true; 																// Changes rate to true while others stay false
				}
				else{
					rate0 = true; 																// Changes rate to true while others stay false
				}
			}
			else if ( (age <= 12) && (age >= 5) ){ 												// next age group
				rate1 = true; 																	// Changes rate to true while others stay false
			}
			else if ( (age <= 59) && (age >= 13) ){ 											//next age group
				rate4 = true; 																	// Changes rate to true while others stay false
			}
			else{ 																				// senior group
				rate2 = true; 																	// Changes rate to true while others stay false
			}

		}
		
		System.out.println("Rate 0 (no charge):        " + rate0); 								// simple looking output for which rate is true and which rate is false
		System.out.println("Rate 1 (kids rate):        " + rate1);
		System.out.println("Rate 2 (senior rate):      " + rate2);
		System.out.println("Rate 3 (discount shows):   " + rate3);
		System.out.println("Rate 4 (full price):       " + rate4);
		
		myVar.close(); 																			// closes scanner
	}
}
