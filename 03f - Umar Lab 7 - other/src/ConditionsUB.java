/*
 * Name: Umar Bath
 *
 * Course: CS-12, Spring 2016
 *
 * Date: 4/3/2016
 *
 * Filename: Conditions.java
 
 * Purpose: Learn and apply how conditions work in java
 */

import java.util.Scanner;
public class ConditionsUB {
	
	public static void main(String[] args) {
		
		Scanner myVar = new Scanner(System.in); 												// create scanner
		
		int age, dayNum; 																		// internal int values
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

		System.out.print("  What day is it today (1-7): "); 									// ask user for day
		dayNum = myVar.nextInt();																// take input as integer

		System.out.print("  What time of the day is it, afternoon(false) or evening(true): "); 	// as user if it is afternoon or evening
		timeOfDay = myVar.nextBoolean();														// take input as boolean
		
		System.out.print("  What is age of viewer: ");					 						// asks user for age
		age = myVar.nextInt();																	// take input as integer

		System.out.println("==============================================================");
		System.out.println();
		
		// if else-if else loop to finally set values of rates
		if ( (dayNum == 2) && (timeOfDay == true) ) { 											// if day is tuesday and evening
			rate3 = true; 																		// changes rate3 to true while others are still false
		}
		else if ( (dayNum == 4) && (timeOfDay == false) ) { 									// if day is thursday and afternoon
			rate3 = true;
		}
		else{ 																					// if day is not tuesday, thursday & coresponding time of day is not true
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
			else if ( (age <= 59) && (age >= 13) ){ 											// next age group
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
		
		myVar.close(); 																			// cloase scanner
	}
}