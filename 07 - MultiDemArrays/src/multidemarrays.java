import java.util.Scanner;
public class multidemarrays {
	
	public static void main(String[] args){
		Scanner myVar = new Scanner(System.in);
		String[][] names = new String[3][2];
		
		for(int x = 0; x < names.length; x++){
				
			    System.out.println("Enter Student Last Name: ");
			    names[x][0] = myVar.nextLine();

			    System.out.println("Enter Student First Name: ");
			    names[x][1] = myVar.nextLine();
		}
		for(int j = 0; j < names.length; j++){	
     		for (int i = j + 1 ; i < names.length; i++){
         		if(names[i][0].compareTo(names[j][0])<0){
         			
		             String[] temp = names[j];
		             names[j]= names[i]; 
		             names[i]=temp;
         		}
     		}
		}
				
		for(int x1 = 0; x1 < names.length; x1++){
				System.out.println(names[x1][0] + ", " + names[x1][1]);
		}
	}
}















