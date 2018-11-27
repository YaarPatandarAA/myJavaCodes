import java.util.Scanner;

class UsrInpt {
	public static void main(String[] args) {
		
		Scanner myVar = new Scanner(System.in);
		//Scanner myVar2 = new Scanner(System.in);

		String a,b,c;
		
		System.out.println("Please tell me your first name: "); a = myVar.nextLine();
		
		System.out.println("Please tell me your last name: "); b = myVar.nextLine();
		//c = a + b;
		
		System.out.println("Hello, my name is " + a + " " + b + ". This is a succesfull test.");
		
		
	}

}
