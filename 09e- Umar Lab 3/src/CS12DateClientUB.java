import java.util.Scanner;
public class CS12DateClientUB {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		CS12Date today = new CS12Date(3,6,2016);
		CS12Date myBday = new CS12Date(11,1);
		CS12Date halloween = new CS12Date(10,31,2016);
		CS12Date christams = new CS12Date(12,25,2015);
		
		int month, day, year;
		
		boolean result;
		
		System.out.println("1a) myDate1 exlicitly with toString() = " + today.toString());
		System.out.println("1b) myDate1 implicitly = " + today + "\n");
		
		System.out.println("===========================================");
		System.out.println("2) This is today's date");
		System.out.println("===========================================");
		today.print();
		
		System.out.println("===========================================");
		System.out.println("3) This is some later imaginary birthday");
		System.out.println("===========================================");
		myBday.print();
		System.out.println("===========================================\n");
		
		myBday.nextDate();
		myBday.nextDate();
		myBday.nextDate();
		System.out.println("4a) 3 Days later using nextDate(): " + myBday);
		myBday.laterDate(7);
		System.out.println("4b) 1 Week later using laterDate(): " + myBday + "\n");
		
		System.out.println("===========================================");
		System.out.println("5) Halloween using m-d-y constructor");
		System.out.println("===========================================");
		halloween.print();
		
		System.out.println("===========================================\n");
		christams.setDate(12,25,2016);
		System.out.println("6) Christmas using setDate(): " + christams + "\n\n");
		
		System.out.print("This years's birthday month? > ");
		month = input.nextInt();
		System.out.print("This year's birthday day? > ");
		day = input.nextInt();
		System.out.print("This year's birthday year? > ");
		year = input.nextInt();
		myBday.setDate(month,day,year);
		System.out.println("===========================================");
		System.out.println("7) My next birthday is:");
		System.out.println("===========================================");
		myBday.print();
		System.out.println("===========================================\n");
		
		System.out.println("8) My next birthday " + myBday + " is day #: " 
		+ myBday.getDateNum() + "\n");
		
		result = today.equals(myBday);
		System.out.println("9) Is today " + today + " my birthday " + myBday + "? "
				+ result + "\n");
		
		month = 0;
		day = 0;
		year = 0;
		
		month = myBday.getMonth();
		day = myBday.getDay();
		year = myBday.getYear();
		
		System.out.println("10) My next birthday is still: " + month + "-" + day + "-" + year);
	}
}
