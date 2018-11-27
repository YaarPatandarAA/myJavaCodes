import java.util.Scanner;  // to set up a file read
import java.io.File;
import java.io.IOException;


public class DamReportUB {

    public static void main(String [] args) throws IOException {
    
    	DamUB [] dams = new DamUB [50];
    	
        // declarations, initializations
    	int count = 0;
        char option;		// character data type to be used in case
        
        // initial menu prompt to be used
        String menu = "\nDAM OPTIONS:\n" +
                      "Read data from file     [R]\n" +
                      "Print dam summaries     [S]\n" +
                      "Print dam details       [D]\n" +
                      "Overall water status    [W]\n" +
                      "Quit                    [Q]\n" +
                      "Option > ";
                      
        // priming read
        option = UtilsUB.readChar(menu, false);
        
        // loop until terminating char(s) NOT encountered
        while ((option != 'Q') && (option != 'q')) {						// while loop condition for quit
        
            switch (option) {					// switch start using option data
                case 'R':		// S option case
                case 'r':
                	count = readDataFromFile(dams);
                    break;
                    
                case 'S':		// I option case
                case 's':
                	printDamSummaries(dams, count);
                    break;
                
                case 'D':		// E option case
                case 'd':
                	printDamDetails(dams, count);
                    break;
                
                case 'W':		// F option case
                case 'w':
                	showWaterStatus(dams, count);
                    break;
                    
                // no Q/q case needed, switch will not reach it!
                
                default:		// default case for unrecognized char inputs
                    System.out.println("ERROR: Unrecognized option " + option + ", please try again\n"); 		// display message if default case is hit
                    break;
                    
            }
            
            // update read
            option = UtilsUB.readChar(menu, false);
            
        }
        
        // termination action(s)
        System.out.println("Exit upon user request");
            
    } // end main
    
    // operations to turn an input string into a Person object
    public static DamUB ConvertString2Dam(String data) {
    
        // declarations for the eventual data
    	String name;
    	int year;
    	double storage, capacity, inflow, outflow;
    	CS12Date date;

        // split the original line
        String [] tokens1 = data.split(",");
        for (int i=0; i < tokens1.length; i++) {
            // clean up any leading/trailing whitespace
            tokens1[i] = tokens1[i].trim();
        }
        
        // do a secondary split on the date token
        String [] tokens2 = tokens1[6].split("/");
        for (int i=0; i < tokens2.length; i++) {
            // clean up any leading/trailing whitespace
            tokens2[i] = tokens2[i].trim();
        }
        
        // extract scalar values and assemble object
        name = tokens1[0];
        year = Integer.parseInt(tokens1[1]);
        storage = Double.parseDouble(tokens1[2]);
        capacity = Double.parseDouble(tokens1[3]);
        inflow = Double.parseDouble(tokens1[4]);
        outflow = Double.parseDouble(tokens1[5]);
        
        date = new CS12Date(Integer.parseInt(tokens2[0]),
                            Integer.parseInt(tokens2[1]),
                            Integer.parseInt(tokens2[2]));
                            
        // use all data to create a new Person object
        return new DamUB(name, year, storage, capacity, inflow, outflow, date);
    }
    
    public static int readDataFromFile(DamUB [] dams) throws IOException {
        
        // declarations
        String filename, text;
        int numLines = 0;
        
        // first read an input filename using utils
        filename = UtilsUB.readString("Enter text file name: ", false);
        
        // set up a second Scanner to read from that file
        File infile = new File(filename);
        Scanner fileInput = new Scanner(infile);
        
        // read and echo each line of the file
        //System.out.println("Reading from local file: " + filename + "\n");
        while (fileInput.hasNext()) {
            text = fileInput.nextLine();
            dams[numLines] = ConvertString2Dam(text);
            //dams[numLines].print("new Person:");
            numLines++;
        }
        System.out.println("\n" + numLines + " dams read from file: " + filename);
        
		return numLines;
        
    }
    
    public static void printDamSummaries(DamUB [ ] dams, int count){
    	
    	if(dams[0] == null){	//safety loop if dams is empty
    		System.out.println("ERROR: no Dams currently exist! Must import from file.");
    	}
    	
    	else{
	    	System.out.println("\nName       Year   Storage  Capacity   Inflow   Outflow        Date");	// header for the table format
	    	for (int i=0; i < count; i++) {      // loop for table format of the dams
	            System.out.printf("%-8s %6d %9.0f %9.0f %8.0f %9.0f %11s", dams[i].getName(), dams[i].getYear(), dams[i].getStorage(), dams[i].getCapacity(), dams[i].getInflow(), dams[i].getOutflow(), dams[i].getDate());
	            System.out.println();
	        }
    	}
    }
    
    public static void printDamDetails(DamUB [ ] dams, int count){
    	
    	if(dams[0] == null){	// safety for empty dam
    		System.out.println("ERROR: no Dams currently exist! Must import from file.");
    	}
    	
    	else{
	    	for (int i=0; i < count; i++){	// loop for regular print() method
	    		dams[i].print(dams[i].getName());
	    		System.out.println();
	    	}
    	}
    }
    
    public static void showWaterStatus(DamUB [ ] dams, int count){
    	
    	if(dams[0] == null){		// safety for empty dam
    		System.out.println("ERROR: no Dams currently exist! Must import from file.");
    	}
    	
    	else{
	    	double storageTmp = 0, capacityTmp = 0, inflowTmp = 0, outflowTmp = 0;	// temp vaules to be stored
	    	for (int i=0; i < count; i++){	// loop takes values from dams and adds up then stores in temp datatypes
	    		storageTmp += dams[i].getStorage();
	    		capacityTmp += dams[i].getCapacity();
	    		inflowTmp += dams[i].getInflow();
	    		outflowTmp += dams[i].getOutflow();
	    	}
	    	System.out.println();	// blank space
	    	
	    	// new dam object declarization and initilization
	    	DamUB superDam = new DamUB("Overall Water Health", UtilsUB.today().getYear(), storageTmp, capacityTmp, inflowTmp, outflowTmp, dams[0].getDate());
	    	
	    	superDam.print();	// use of print() method to show new dam method.
	    }
    }

} // end class