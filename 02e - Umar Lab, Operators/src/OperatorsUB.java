/*
 * Name: Umar Bath
 *
 * Course: CS-12, Spring 2016
 *
 * Date: 2/17/2016
 *
 * Filename: OperatorsUB.java
 *
 * Purpose: new Operators file for CS-12
 */
import java.util.Scanner;
public class OperatorsUB{
	
   public static void main(String[] args){
   
      // data declaration and intialization
	  Scanner myVar = new Scanner(System.in);
	   
      double LunchPrice;
      double chips, soda, sandwich;
      
      int valueeggs; 
      int eggs;
      final int dozen = 12;
      
      double salestax = 0.075;
      double item;
      double salestaxonitem;
      
      double area;
      double  r;
      
      int hits;
      int atbats;
      double avg;
      
      int widget1;
      int widget2;
      int deliver;

      // calculations
      
      System.out.println("Enter Chips Price: ");
      chips = myVar.nextDouble();
      System.out.println("Enter Soda Price: ");
      soda = myVar.nextDouble();
      System.out.println("Enter Sandwich Price: ");
      sandwich = myVar.nextDouble();
      System.out.println("Enter number of eggs: ");
      eggs = myVar.nextInt();
      System.out.println("Enter retail price of item: ");
      item = myVar.nextDouble();
      System.out.println("Enter circle radius: ");
      r = myVar.nextDouble();
      System.out.println("Enter Number of hits: ");
      hits = myVar.nextInt();
      System.out.println("Enter Number of atbats: ");
      atbats = myVar.nextInt();
      System.out.println("Enter starting widget 1 quantity: ");
      widget1 = myVar.nextInt();
      System.out.println("Enter starting widget 2 quantity: ");
      widget2 = myVar.nextInt();
      System.out.println("Enter Widget 2 delivery quantity: ");
      deliver = myVar.nextInt();
      
      LunchPrice = chips + soda + sandwich;
      
      valueeggs = eggs/dozen;
      eggs = eggs%dozen;
      
      salestaxonitem = item*salestax;
      
      area = Math.PI * (Math.pow(r, 2));
      
      avg = (double)hits / (double)atbats;
      
      // output prints
      System.out.println("1.) Lunch Price is:                   $" + LunchPrice);
      System.out.println("2.) 872 eggs fills                    " + valueeggs + " cartons");
      System.out.println("3.) 872 eggs leaves                   " + eggs + " eggs");
      System.out.println("4.) Tax on $329.49 is                 $" + salestaxonitem);
      System.out.println("5.) circle area is                    " + area);
      System.out.println("6.) batting average is                " + avg);
      System.out.println("7a.) Widget 1 inventory before:       " + widget1);
      
      widget1 = --widget1;
      
      System.out.println("7b.) Widget 1 inventory after:        " + widget1);
      System.out.println("8a.) Widget 2 inventory before:       " + widget2);
      
      widget2 = widget2 + deliver;
      
      System.out.println("8b.) Widget 1 inventory after:        " + widget2);
      // end main
   
   }

}
