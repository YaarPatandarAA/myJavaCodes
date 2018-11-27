import java.util.Scanner;

public class BankMain {
	public static void main(String[] args) {
		String acctName;
		int acctNum, amt;
		double acctAmt;
		boolean test = false;
		char opt;
		
		Scanner input = new Scanner(System.in);
		Scanner inputString = new Scanner(System.in);
		System.out.print("How many account would you like to create: ");
		amt = input.nextInt();
		
		Accounts[] actObj = new Accounts[amt];
		for ( int i=0; i < actObj.length; i++) {
			
			System.out.print("What is the name for account " + (i+1) + ": ");
			acctName = inputString.nextLine();
			System.out.print("What is the Acount number for " + acctName + ": ");
			acctNum = input.nextInt();
			System.out.print("What is the Inital money in account for " + acctName + ": ");
			acctAmt = input.nextDouble();
			
			actObj[i]=new Accounts(acctName, acctNum, acctAmt);
		}
		
		do{
			System.out.println("Enter account number to manage: ");
			acctNum = input.nextInt();
			
			for ( int i=0; i < actObj.length; i++) {
				if (acctNum == actObj[i].getAcctNum()){
					System.out.println("1. View Account");
					System.out.println("2. Deposit");
					System.out.println("3. Withdraw");
					System.out.println("4. Quit");
					
					System.out.println("What would you like to do: ");
					opt = inputString.nextLine().charAt(0);
						
					switch (opt){
						case '1':
							System.out.println("AcctNumber -- Name -- Amount");
							System.out.println("   " + actObj[i].getAcctNum() + "        " + actObj[i].getAcctName() + "      $" + actObj[i].getAcctAmt());
							
							i = actObj.length + 1;
							
							test = false;
							break;
						case '2':
							System.out.println("AcctNumber -- Name -- Amount");
							System.out.println("   " + actObj[i].getAcctNum() + "        " + actObj[i].getAcctName() + "      $" + actObj[i].getAcctAmt());
							
							System.out.println("Enter amount to deposit: ");
							amt = input.nextInt();
							actObj[i].deposit(amt);
							System.out.println("New amount in account is: " + actObj[i].getAcctAmt());
		 
							i = actObj.length + 1;

							break;
						case '3':
							System.out.println("AcctNumber -- Name -- Amount");
							System.out.println("   " + actObj[i].getAcctNum() + "        " + actObj[i].getAcctName() + "      $" + actObj[i].getAcctAmt());
							
							System.out.println("Enter amount to deposit: ");
							amt = input.nextInt();
							actObj[i].withdraw(amt);
							System.out.println("New amount in account is: " + actObj[i].getAcctAmt());
		 
							i = actObj.length + 1;

							break;
						case '4':
							System.out.println("Quitting!!");
							test = true;
							break;
						default:
							System.out.println("Error");
							break;
					}
				}
			}
		}while(test == false);

		
		
		
		
		
		
		
		
		
		
		input.close();
		inputString.close();
	}
}
