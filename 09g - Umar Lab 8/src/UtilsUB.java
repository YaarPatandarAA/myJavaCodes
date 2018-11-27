/*
 * Name:    Umar Bath   
 *
 * Course:    CS-12 
 *
 * Date:      4/8/2016 
 *
 * Filename:   UtilsUB.java
 *
 * Purpose:    Starter CS-12 utilities file.
 *             This class is a collection of useful utility methods
 *              which are called statically:    UtilsUB.method()
 *
 *             THIS FILE RELIES UPON CS12Date.java IN LOCAL DIRECTORY
 */

import java.util.Scanner;

import javax.swing.JOptionPane;

public class UtilsUB {

    //---------------------------------------------------------------------------
    // user input methods, by datatype
    //---------------------------------------------------------------------------
    
    // get an int value
    public static int readInt(String prompt, boolean guiMode) {
    
        // set up data and objects
        Scanner input = new Scanner(System.in);
        int data = 0;
        
        if(guiMode == false){
	        // prompt for an input int value
	        System.out.print(prompt);
	        data = input.nextInt();
        }
        else if(guiMode == true){
        	// prompt for an input int value in J Option Pane
        	String temp = JOptionPane.showInputDialog(prompt);
        	data = Integer.parseInt(temp);
        }
        else{
        	System.out.println("ERROR!!!");
        }
        
        return data;
    }
    
    //---------------------------------------------------------------------------
    // age-related methods
    //---------------------------------------------------------------------------
    
    // returns the age as of some REFERENCE date (2-input overloaded form, MODS NEEDED)
    public static int getAge(CS12Date dateBd, CS12Date dateRef) {
        int age = -1; // starter output
        
        // if-elseif-else statement to check what the year is 												//-----------------------------------------------------------------------
        if (dateBd.getYear() == dateRef.getYear()){ 														//	if year is same
        	// if-elseif-else statement to check what the month is 											//	|
            if (dateBd.getMonth() == dateRef.getMonth()){ 													//	|->	if month is the same
            	// if-elseif-else statement to check what the day is 										//	|	|
                if (dateBd.getDay() == dateRef.getDay()){ 													//	|	|->	if day is the same
                	age = dateRef.getYear() - dateBd.getYear();												//	|	|	|->	Calculates age
                }																							//	|	|
                else if(dateBd.getDay() > dateRef.getDay()){												//	|	|->	if day is bigger than reference day
                	System.out.println("ERROR: provided birthday " + dateBd + " is after current date");	//	|	|	|->	gives user the error
                	age = -1;																				//	|	|
                }																							//	|	|
                else if(dateBd.getDay() < dateRef.getDay()){												//	|	|->	if day is smaller than reference day
                	age = dateRef.getYear() - dateBd.getYear();												//	|		|->	Calculates age
                }																							//	|
            }																								//	|
            else if(dateBd.getMonth() > dateRef.getMonth()){												//	|->	if month is larger than reference month
            	System.out.println("ERROR: provided birthday " + dateBd + " is after current date");		//	|	|->	gives user the error
            	age = -1;																					//	|
            }																								//	|
            else if(dateBd.getMonth() < dateRef.getMonth()){												//	|->	if month is smaller than reference month
            	age = dateRef.getYear() - dateBd.getYear();													//		|->	calculates age
            }																								//
        }																									//-----------------------------------------------------------------------
        
        																									//-----------------------------------------------------------------------
        else if(dateBd.getYear() > dateRef.getYear()){ 														//	if birthday year is bigger than reference year
        	System.out.println("ERROR: provided birthday " + dateBd + " is after current date");			//	|->	gives user the error
        	age = -1;																						//
        }																									//-----------------------------------------------------------------------
        
        																									//-----------------------------------------------------------------------
        else if(dateBd.getYear() < dateRef.getYear()){ 														//	if birthday year is smaller than reference year
        	// if-elseif-else statement to check what the month is 											//	|
        	if (dateBd.getMonth() == dateRef.getMonth()){													//	|->	if month is the same
        		// if-elseif-else statement to check what the day is 										//	|	|
        		if (dateBd.getDay() == dateRef.getDay()){													//	|	|->	if day is the same
                	age = dateRef.getYear() - dateBd.getYear();												//	|	|	|->	Calculates age
                }																							//	|	|
                else if(dateBd.getDay() > dateRef.getDay()){												//	|	|->	if day is bigger than reference day
                	age = (dateRef.getYear() - dateBd.getYear()) - 1;										//	|	|	|->	Calculates age with correct deduction
                }																							//	|	|
                else if(dateBd.getDay() < dateRef.getDay()){												//	|	|->	if day is smaller than reference day
                	age = dateRef.getYear() - dateBd.getYear();												//	|		|->	Calculates age
                }																							//	|
            }																								//	|
            else if(dateBd.getMonth() > dateRef.getMonth()){												//	|->	if month is larger than reference month
            	age = (dateRef.getYear() - dateBd.getYear()) - 1;											//	|	|->	Calculates age with correct deduction
            }																								//	|
            else if(dateBd.getMonth() < dateRef.getMonth()){												//	|->	if month is smaller than reference month
            	age = dateRef.getYear() - dateBd.getYear();													//		|->	calculates age
            }																								//
        }																									//-----------------------------------------------------------------------
                                                                                                            
        																									//-----------------------------------------------------------------------
        else{ 																								//	// default else
        	System.out.println("ERROR: provided birthday " + dateBd + " is after current date");			//
        	age = -1;																						//
        }																									//-----------------------------------------------------------------------
        
        return age;																							// returns the age
        
    } // end 2-input overloaded version
    
    //---------------------------------------------------------------------------

    // returns the age as of TODAY'S date (1-input overloaded form, NO CHANGES NEEDED)
    public static int getAge(CS12Date dateBd) {
        int age;
        CS12Date dateToday = today();
        
        // calls overloaded version of same method (above), with TODAY as the reference date
        age = getAge(dateBd, dateToday);  
        return age;
        
    } // end 1-input overloaded version
    
    
    //---------------------------------------------------------------------------
    // date-related methods 
    //---------------------------------------------------------------------------
    
    // returns today's date as a CS12Date (NO CHANGES NEEDED)
    public static CS12Date today() {
    
        return new CS12Date();
        
    }
       
} // end class