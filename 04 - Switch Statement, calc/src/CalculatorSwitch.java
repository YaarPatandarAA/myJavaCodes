import java.util.Scanner;
class CalculatorSwitch {
	public static void main(String[] args) {
		
		Scanner myVar = new Scanner(System.in);
		
		char ans;
		long num1, num2, num3;
		char calc;		
		
		do{
			System.out.println("What is the First Number: "); num1 = myVar.nextLong();
			System.out.println("What is the Second Number: "); num2 = myVar.nextLong();
			System.out.println("Would you like to + - * /"); 
			
			calc = myVar.next().charAt(0);
		
			switch (calc){
			case '+':
				System.out.println("add");
				num3 = num1 + num2;
				System.out.println(num3);
				System.out.println("Would you like to try again: "); 
				ans = myVar.next().charAt(0);
				break;
			case '-':
				System.out.println("sub");
				num3 = num1 - num2;
				System.out.println(num3);
				System.out.println("Would you like to try again: "); 
				ans = myVar.next().charAt(0);
				break;
			case '*':
				System.out.println("mul");
				num3 = num1 * num2;
				System.out.println(num3);
				System.out.println("Would you like to try again: "); 
				ans = myVar.next().charAt(0);
				break;
			case '/':
				System.out.println("div");
				double num4, num5, num6;
				num3 = num1 / num2;
				num4 = (num5 = num1) / (num6 = num2);
				System.out.println(num3);
				System.out.println(num4);
				System.out.println("Would you like to try again: "); 
				ans = myVar.next().charAt(0);
				break;
			default:
				System.out.println("Penchoda case ni chaliya");
				System.out.println("Would you like to try again: "); 
				ans = myVar.next().charAt(0);
			}
		}while((ans == 'y') || (ans == 'Y'));
	}
}
