import java.util.Stack;
public class stacks {
	public static void main(String[] args) {
		
		Stack mySTC = new Stack();
		
		for (int i = 1; i <= 10; i++)
        {
                mySTC.push(i);
                System.out.println(mySTC);
        }
		while ( !mySTC.empty() )
        {
			//mySTC.pop();
			System.out.println(mySTC.peek());
        }
		
		
	}

}
