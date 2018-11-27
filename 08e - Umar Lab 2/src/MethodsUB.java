/*
 * Name:       
 *
 * Course:     CS-12, Spring 2016
 *
 * Date:       
 *
 * Filename:   
 *
 * Purpose:    Starting template for HW05B
 */
import java.util.Scanner;
public class MethodsUB {
	
    // required main method of the class
    public static void main(String [] args) {
    	
    	double F, C;
    	
    	F = TEMP_F();
    	C = CONV_F(F);
    	SHOW_TEMP(F, C);
    
        // (A) TODO: Perform temperature conversion, 3 steps:
        //     prompt for temp F, using method 1
        //     convert temp F to temp C, using method 3
        //     display both temp F and temp C, using method 2
        
    	double USD1, X;
    	
    	USD1 = USD();
    	X = CONV_USD(USD1);
    	SHOW_EURO(USD1, X);
    	
        // (B) TODO: Perform currency conversion, 3 steps:
        //     prompt for USD, using method 1
        //     convert USD to Euros, using method 4
        //     display both USD and Euros, using method 2
   
                        
    } // end main
    
    //--------------------------------------------------------------
    
    // (1) TODO: write a method to obtain a GENERIC double value from user,
    //     using a provided prompt message(use Scanner)...
    static double TEMP_F(){
    	Scanner myVar = new Scanner(System.in);
    	System.out.println("What is the F temp: ");
    	double tempF = myVar.nextDouble();
		return tempF;
	}
    static double USD(){
    	Scanner myVar = new Scanner(System.in);
    	System.out.println("What is the USD: ");
    	double tempUSD = myVar.nextDouble();
		return tempUSD;
	}
    //--------------------------------------------------------------
    
    // (2) TODO: write a method to display a GENERIC input string inside a "box"...
    static double SHOW_TEMP(double numF, double numC){
    	System.out.println("F temp is : " + numF);
    	System.out.println("C temp is : " + numC);
    	System.out.println("===================================");
		return 0;
    }
    static double SHOW_EURO(double USD, double EURO){
    	System.out.println("USD is : " + USD);
    	System.out.println("EURO is : " + EURO);
		return 0;
    }
    //--------------------------------------------------------------
    
    // (3) TODO: write a method to convert degrees F to degrees C...
    static double CONV_F(double Tf){
    	double Tc;
    	double temp; 
    	final double temp2 = 0.56;
    	temp = Tf - 32;
    	Tc = (temp2) * (temp);
		return Tc;
    }

    //--------------------------------------------------------------
    
    // (4) TODO: write a method to convert $ to Euros...
    
    static double CONV_USD(double USD){
    	double EURO;
    	final double CNRT = 0.90706;
    	EURO = CNRT * USD;
		return EURO;
    }
    

} // end class