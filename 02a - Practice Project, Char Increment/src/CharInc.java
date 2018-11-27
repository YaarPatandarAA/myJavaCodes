import java.util.Scanner;

public class CharInc {
	public static void main(String[] args) {
		char letter;
		Scanner charIN = new Scanner(System.in);
		
		System.out.print("Give me a Char: ");
		letter = charIN.nextLine().charAt(0);
		letter++;
		System.out.println("The Next character is: " + letter);
		
		charIN.close();
	}

}
