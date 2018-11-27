import java.util.Scanner;
import classes.add;
import classes.div;
import classes.mul;
import classes.sub;
public class Main {
	public static void main(String[] args) {
		
		double[] nums = new double[2];
		double[] x = new double[4];
		char math, ans;
		Scanner myVar = new Scanner(System.in);
		
		add obj = new add();
		sub obj2 = new sub();
		mul obj3 = new mul();
		div obj4 = new div();
		
		
		do{
			System.out.println("What is the First Number: "); nums[0] = myVar.nextDouble();
			System.out.println("What is the Second Number: "); nums[1] = myVar.nextDouble();
			System.out.println("Would you like to + - * /"); 
			
			math = myVar.next().charAt(0);
		
			switch (math){
			case '+':
				x[0] = obj.addition(nums[0], nums[1]);
				System.out.println(x[0]);
				System.out.println("Would you like to try again: "); 
				ans = myVar.next().charAt(0);
				break;
			case '-':
				x[1] = obj2.subtraction(nums[0], nums[1]);
				System.out.println(x[1]);
				System.out.println("Would you like to try again: "); 
				ans = myVar.next().charAt(0);
				break;
			case '*':
				x[2] = obj3.multiplication(nums[0], nums[1]);
				System.out.println(x[2]);
				System.out.println("Would you like to try again: "); 
				ans = myVar.next().charAt(0);
				break;
			case '/':
				x[3] = obj4.division(nums[0], nums[1]);
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
