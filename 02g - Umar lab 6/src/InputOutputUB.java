/*
 * Name: Umar Bath
 *
 * Course: CS-12, Spring 2016
 *
 * Date: 3/20/2016
 *
 * Filename: InputOutputUB.java
 
 * Purpose: To learn about input and output methods offered in java
 */

import java.util.Scanner;
import javax.swing.JOptionPane;

public class InputOutputUB {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		String name;
		int hits, atbats;
		float avg;
		
		System.out.print("Enter player name: ");
		name = input.nextLine();
		System.out.print("Enter number of hits: ");
		hits = input.nextInt();
		System.out.print("Enter number of at-bats: ");
		atbats = input.nextInt();
		
		input.close();
		
		avg = (float) hits/ (float) atbats;
		
		System.out.printf("Batting Average for %s: %.3f", name, avg);

		String received = JOptionPane.showInputDialog("Enter Votes Received:");
		String cast = JOptionPane.showInputDialog("Enter Votes Cast:");
		
		int v1 = Integer.parseInt(received);
		int v2 = Integer.parseInt(cast);
		double percentage;
		
		percentage = ((double) v1 / (double) v2) * 100;
		
		JOptionPane.showMessageDialog(null, String.format("Votes received: %d %n"
				+ "Votes cast: %d %n"
				+ "Percentage of support: %.2f%%", 
				v1, v2, percentage));
	}
}