/*
 * Name:    Umar Bath
 *
 * Course:    CS-12
 *
 * Date:      4/15/2016
 *
 * Filename:   HybridLogicFL.java
 *
 * Purpose: 	This is an exercise in multiple-level, nested program logic. 
 *				We will test a switch statement which will be indefinitely run
 *				until the while loop, in which it is wrapped in, is hit with the Quit.
 *				This will increment and decrement values upon checking for what the user wants in IF-ELSEIF loop.
 *				These values will be inc or dec by using a FOR loop.
 */

public class HybridLogicUB {

    public static void main(String [] args) {
    
        // declarations, initializations
    	int start, inc, end;	// initial data types for start, increment, and end
        char option;		// character data type to be used in case
        
        // initial menu prompt to be used
        String menu = "\nList of menu options:\n" +
                      "Start Value     [S]\n" +
                      "Increment Value [I]\n" +
                      "End Value       [E]\n" +
                      "For Looping     [F]\n" +
                      "Quit            [Q]\n" +
                      "Option > ";
        
        // set values for the 3 data types
        start = 0;
        inc = 0;
        end = 0;
                      
        // priming read
        option = UtilsUB.readChar(menu, false);
        
        // loop until terminating char(s) NOT encountered
        while ((option != 'Q') && (option != 'q')) {						// while loop condition for quit
        
            switch (option) {					// switch start using option data
                case 'S':		// S option case
                case 's':
                	start = UtilsUB.readInt("Enter loop start value: ", false);		// calls readInt for start value
                    break;
                    
                case 'I':		// I option case
                case 'i':
                	inc = UtilsUB.readInt("Enter loop increment vaule: ", false);	// calls readInt for inc value
                    break;
                
                case 'E':		// E option case
                case 'e':
                	end = UtilsUB.readInt("Enter loop end value: ", false);			// calls redInt for end value
                    break;
                
                case 'F':		// F option case
                case 'f':
                    if ( (inc >= +1) & (start < end) ){				// first if-elseif statement to check against the 3 data types
                    	for(int i = start; i <= end; i += inc){		// for loop to increment values
                    		System.out.print(i + " ");			// print the incremented values
                    	}
                    	System.out.println();	// added as a blank spaces for when menu shows up again
                    }
                    else if ( (inc <= -1) & (start > end) ){		// second if-elseif statement to check against the 3 data types
                    	for(int i = start; i >= end; i += inc){		// for loop to increment values
                    		System.out.print(i + " ");			// print the incremented values
                    	}
                    	System.out.println();	// added as a blank spaces for when menu shows up again
                    }
                    else{		// final default of the if-elseif loop
                    	System.out.println("Start: " + start + " End: " + end + " Inc: " + inc + " will not do any looping!"); // Displays as a error prompt to let user know that their input will not be incremented due to restrictions
                    }
                    break;
                    
                // no Q/q case needed, switch will not reach it!
                
                default:		// default case for unrecognized char inputs
                    System.out.println("Unrecognized option " + option + ", please try again\n"); 		// display message if default case is hit
                    break;
                    
            }
            
            // update read
            option = UtilsUB.readChar(menu, false);
            
        }
        
        // termination action(s)
        System.out.println("Exit upon user request");
            
    } // end main

} // end class
