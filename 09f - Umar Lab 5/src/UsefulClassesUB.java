import java.util.Scanner;
import java.util.Random;

public class UsefulClassesUB {
	//Method for getting the maximum value
	public static int getMax(int[] inputArray){
		int maxValue = inputArray[0];
		for(int i=1;i < inputArray.length;i++){
			if(inputArray[i] > maxValue){
				maxValue = inputArray[i];
			}
		}
		return maxValue;
	}
	// Method for getting the minimum value
	public static int getMin(int[] inputArray){
		int minValue = inputArray[0];
		for(int i=1;i<inputArray.length;i++){
			if(inputArray[i] < minValue){
				minValue = inputArray[i];
			}
		}
		return minValue;
	} 
	// Main Method
	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		
		// initialization
		int num1, num2, max1, max2, min1, min2, h2;
		float a, b, h1, V;
		float r = 1.5f;
		double frac = (4d / 3d);
		
		// create array
		int arrSize = 4;
		int[] num3 = new int[arrSize];
		
		Random rnd = new Random();
		
		System.out.print("Enter minimum random number: ");
		num1 = myScan.nextInt();
		System.out.print("Enter maximum random number: ");
		num2 = myScan.nextInt();
		System.out.println();
		
		for(int j = 0; j < arrSize; j++){
			num3[j] = rnd.nextInt((num2 - num1) + 1) + num1;
		}
		
		System.out.print(" 1) Range: " + num1 + "-" + num2 + " random #'s: ");
		for(int j = 0; j < arrSize; j++){
			System.out.print(num3[j] + " ");
		}
		System.out.println("\n");
		max1 = getMax(num3);		//call method
		min1 = getMin(num3);		//call method
		
		System.out.println(" 2a) Smallest random number: " + min1 + " (using methods)");
		System.out.println(" 2b) Largest random number: " + max1 + " (using methods)");
		
		min2 = Math.min(num3[0], num3[1]);													
		min2 = Math.min(min2, num3[2]);
		min2 = Math.min(min2, num3[3]);
		System.out.println(" 2a) Smallest random number: " + min2 + " (using math.min)");
		
		max2 = Math.max(num3[0], num3[1]);
		max2 = Math.max(max2, num3[2]);
		max2 = Math.max(max2, num3[3]);
		System.out.println(" 2b) Largest random number: " + max2 + " (using math.max)");
		System.out.println();
		
		System.out.print("Enter side a: ");
		a = myScan.nextFloat();
		System.out.print("Enter side b: ");
		b = myScan.nextFloat();
		System.out.println();
		
		System.out.println(" 3) Sides: a = " + a + "   b = " + b);
		h1 = (float) Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));					//Hypotenuse
		System.out.println("    Hyp    h = " + h1 + " (exact)");
		h2 = Math.round(h1);														//Round up
		System.out.println("           h = " + h2 + " (rounded) \n");
		
		V = (float) (frac * Math.PI * Math.pow(r, 3));								//Volume
		System.out.println(" 4) Sphere r = " + r + "        Sphere V = " + V);
		
		
		myScan.close();
	}
}


