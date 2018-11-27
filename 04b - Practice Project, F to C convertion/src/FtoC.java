import java.util.Scanner;

public class FtoC{
	public static void main(String[] args) {
		char option;
		double tempInput;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("What is the current temperature type (F/C): ");
		option = input.nextLine().charAt(0);
		
		switch(option){
			case 'F':
			case 'f':
				System.out.print("What is the temperature in Fahrenheit: ");
				tempInput = input.nextDouble();
				System.out.println("Fahrenheit(" + tempInput + "°) to Celsius is: " + (((tempInput - 32) * 5) / 9) + "\n");
				break;
			case 'C':
			case 'c':
				System.out.print("What is the temperature in Celsius: ");
				tempInput = input.nextDouble();
				System.out.println("Celsius(" + tempInput + "°) to Fahrenheit is: " + (((tempInput * 9) / 5) + 32) + "\n");
				break;
			case 'Q':
			case 'q':
				break;
			default:
				System.out.println("ERROR!!!!!!!!!!");
		}
		
		input.close();
		
	}
}