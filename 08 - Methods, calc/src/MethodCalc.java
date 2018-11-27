import java.util.Scanner;
public class MethodCalc {
	static double add(double num1, double num2){
		return (num1 + num2);
	}
	static double sub(double num1, double num2){
		return (num1 - num2);
	}
	static double mul(double num1, double num2){
		return (num1 * num2);
	}
	static double div(double num1, double num2){
		return (num1 / num2);
	}
	public static void main(String[] args){
		double[] nums = new double[2];
		double[] x = new double[4];
		char math, ans;
		Scanner myVar = new Scanner(System.in);
		
		do{
			System.out.println("What is the First Number: "); nums[0] = myVar.nextDouble();
			System.out.println("What is the Second Number: "); nums[1] = myVar.nextDouble();
			System.out.println("Would you like to + - * /"); 
			
			math = myVar.next().charAt(0);
		
			switch (math){
			case '+':
				x[0] = add(nums[0],nums[1]);
				System.out.println(x[0]);
				System.out.println("Would you like to try again: "); 
				ans = myVar.next().charAt(0);
				break;
			case '-':
				x[1] = sub(nums[0],nums[1]);
				System.out.println(x[1]);
				System.out.println("Would you like to try again: "); 
				ans = myVar.next().charAt(0);
				break;
			case '*':
				x[2] = mul(nums[0],nums[1]);
				System.out.println(x[2]);
				System.out.println("Would you like to try again: "); 
				ans = myVar.next().charAt(0);
				break;
			case '/':
				x[3] = div(nums[0],nums[1]);
				System.out.println(x[3]);
				System.out.println("Would you like to try again: "); 
				ans = myVar.next().charAt(0);
				break;
			default:
				System.out.println("NO WORK!!!!!!!!!!!!!!!!!!!");
				System.out.println("Would you like to try again: "); 
				ans = myVar.next().charAt(0);
			}
		}while((ans == 'y') || (ans == 'Y'));
	}	
}
