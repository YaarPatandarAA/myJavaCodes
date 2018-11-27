import java.util.Scanner;
public class Arrays {
	public static void main(String[] args) {
		
		String[] nums = new String[5];
		
		Scanner myVar = new Scanner(System.in);
		
		nums[0] = myVar.nextLine();
		nums[1] = myVar.nextLine();
		nums[2] = myVar.nextLine();
		nums[3] = myVar.nextLine();
		nums[4] = myVar.nextLine();
		
		
		for(int x = 0; x < nums.length; x++){
			System.out.print(nums[x]);
		}//prints out in a line
		
		/*for(String x: nums){
			System.out.println(x);
		}*/		//prints out as a list
		
	}
}
