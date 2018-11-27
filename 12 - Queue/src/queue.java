import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
public class queue {
	public static void main(String[] args) {
		
		int num;
		Queue<Integer> myCSH = new LinkedList<Integer>();
		
		for(int i = 1; i <= 10; i++){
			
			myCSH.add(i);	//Inserts 1 upto 10 into the Queue
			
		}
		System.out.println(myCSH); // prints [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		//myCSH.peek();
		myCSH.poll();	
		System.out.println(myCSH);	//prints [2, 4, 3, 8, 5, 6, 7, 10, 9]
		System.out.println(myCSH.poll());	//prints 2
		System.out.println(myCSH);	//prints [3, 4, 6, 8, 5, 9, 7, 10]
		System.out.println(myCSH.peek());	//prints 3
		System.out.println(myCSH.poll());	//prints 3
		System.out.println(myCSH);	//prints [4, 5, 6, 8, 10, 9, 7]
		num = myCSH.peek();
		System.out.println("Your Peeked number is : " + num);
		num--;
		System.out.println("Your Peeked number is : " + num);

	}
}
