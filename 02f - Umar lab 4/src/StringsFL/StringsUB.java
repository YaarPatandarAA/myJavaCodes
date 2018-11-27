package StringsFL;
import java.util.Scanner;

public class StringsUB {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String myStr, search, word1, word2;
		int index, index2, comma1,comma2,comma3;
		
		System.out.print("Enter desired String: ");
		myStr = input.nextLine();
		System.out.println(" 1) myStr is:  " + myStr + "\n");
		
		System.out.println(" 2) length of myStr is:                     " + myStr.length());
		System.out.println(" 3) first and last chars of myStr are:      " + myStr.charAt(0) 
		+ " and " + myStr.charAt(myStr.length() - 1) + "\n");
		
		System.out.println("4a) myStr as all caps: " + myStr.toUpperCase());
		System.out.println("4b) myStr as all caps: " + myStr);
		System.out.println("5a) myStr as all caps: " + myStr.toLowerCase());
		System.out.println("5b) myStr as all caps: " + myStr + "\n");
		
		System.out.print("Character at which index? ");
		index = input.nextInt();
		System.out.println(" 6) Char at index " + index + ":            " + myStr.charAt(index) + "\n");
		input.nextLine();
		
		System.out.print("Search String to locate? ");
		search = input.nextLine();
		index2 = myStr.indexOf(search);
		System.out.println(" 7) substring " + search + " is located at index:       " 
		+ index2);
		System.out.println(" 8) desired substring is:                  " + myStr.substring(index2) + "\n");
		
		comma1 = myStr.indexOf(',');
		comma2 = myStr.indexOf(',', comma1 + 1);
		comma3 = myStr.indexOf(',', comma2 + 1);
		System.out.println(" 9) first comma is at index: " + comma1);
		System.out.println("10) first comma is at index: " + comma2);
		System.out.println("11) first comma is at index: " + comma3 + "\n");
		
		word1 = myStr.substring(comma2 + 1, comma3);
		System.out.println("12) between commas 2 and 3 is: " + word1 
				+ " length = " + word1.length());
		word2 = word1.trim();
		System.out.println("13) between commas 2 and 3 is: " + word2 
				+ " length = " + word2.length());
		
	}

}
//       One, Two, Three, Four, can I have a little more?
//       Hot dogs, catsup, can of beans, buns