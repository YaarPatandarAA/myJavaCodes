import java.util.*;
class CLK {
	public static void main(String[] args) {
		Random rnd = new Random();
		int someNUM = 1;
		/*int amt = rnd.nextInt(10) + 1;
		
		for(int count = 1; count <= 10; count++){
			System.out.println(count + "\n");
			if (count == amt){
				System.out.println("Counter equals = " + count);
				break;
			}
		}*/
		for(int custNUM = 1; custNUM <= 10; custNUM++){
			int amt = rnd.nextInt(10) + 1; // will generate a random number between 1-10 that will be used in the next for loop
			
			//the following for loop will loop max 10 times
			for(int count = 1; count <= 10; count++){
				
				// the if loop will work only when the counter variable matches the random number then will fill the customer number and items
				if (count == amt){
					
					int amtITEMS = rnd.nextInt(100) + 1; // will generate a random number between 1-100 that will be used as customer items
					//arr.insert(custNUM, amtITEMS); // customer number will be inserted and random amount of items will be inserted.
					
					System.out.println(someNUM + ".) Counter equals = " + count); // shows what position the counter is at 
					someNUM++;
					}
				}
			}
		}
	}