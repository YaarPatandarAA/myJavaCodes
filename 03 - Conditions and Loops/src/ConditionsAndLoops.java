import java.util.Scanner;
class ConditionsAndLoops {
	
	public static void main(String[] args) {
			
			Scanner myVar = new Scanner(System.in);
			
			double num1, num2;
			System.out.println("What is the First Number: "); num1 = myVar.nextDouble();
			System.out.println("What is the Second Number: "); num2 = myVar.nextDouble();
			
			char calc;
			System.out.println("Would you like to + - * /"); 
			calc = myVar.next(".").charAt(0);
			
			if(calc == '+'){
				System.out.println("add");
				double num3;
				num3 = num1 + num2;
				System.out.println(num3);

			}
			else if(calc == '-'){
				System.out.println("sub");
				double num3;
				num3 = num1 - num2;
				System.out.println(num3);


			}
			else if(calc == '*'){
				System.out.println("mul");
				double num3;
				num3 = num1 * num2;
				System.out.println(num3);

			}
			else if(calc == '/'){
				System.out.println("div");
				double num3;
				double num4, num5, num6;
				num3 = num1 / num2;
				num4 = (num5 = num1) / (num6 = num2);
				System.out.println(num3);
				System.out.println(num4);
				
			}
			else{
				System.out.println("FAILED!!!!");
			}
	}
	
}
