/* Name:       Umar Bath
 *
 * Course:     CS-12, Fall 2015  
 * 
 * Date:       04/23/16
 * 
 * Filename:   DamUB.java
 * 
 * Purpose:    Step-by-step creation of a DamUB class
 */

public class DamUB {
	
	// instance variables ------------
	private String name;
	private int year;
	private Double storage, capacity, inflow, outflow;
	private CS12Date date;
	
	 // constants ---------------------
	private final double TOL = 0.0001;  // equals FP tolerance
	
	
// data above here
//=====================================================================================================
// methods below here
	
// constructors ------------------
    
    // default constructor
	public DamUB(){
		name = null;
		year = 1900;
		storage = 0.0;
		capacity = 0.0;
		inflow = 0.0;
		outflow = 0.0;
		date = new CS12Date(4, 17, 2016);
	}
	
	
	 // full constructor
	public DamUB(String name, int year, Double storage, Double capacity, Double inflow, Double outflow, CS12Date date){
		this.name = name;
		this.year = year;
		this.storage = storage;
		this.capacity = capacity;
		this.inflow = inflow;
		this.outflow = outflow;
		this.date = date;
	}
	
	
	// alternate constructor: names and year only
	public DamUB(String name, int year){
		this();
		this.name = name;
		this.year = year;
	}

	
	// alternate constructor: names and capacity only
	public DamUB(String name, Double capacity){
		this();
		this.name = name;
		this.capacity = capacity;
	}
	
//=====================================================================================================
	
// display methods ---------------
    
    // string version of object data
	public String toSring(){	
		return name + ", " + year + ", " + storage + ", " + capacity + ", " + inflow + ", " + outflow + ", " + date;
	}
	
	// formatted version of object data
	public void print(){
		System.out.println("Name:\t" + name);
		System.out.println("Year Opened:\t" + year);
		System.out.println("Date as of:\t" + date);
		System.out.println("Storage [acre-ft]:\t" + storage);
		System.out.println("Capacity [acre-ft]:\t" + capacity);
		System.out.println("inflow [cu-ft/s]:\t" + inflow);
		System.out.println("outflow [cu-ft/s]:\t" + outflow);
		System.out.println();
	}
	
	// overloaded version of print, accepts a label string
	public void print(String message){
		System.out.println("===============================================================================");
		System.out.println(message);
		System.out.println("===============================================================================");
		print();
	}
	
//=====================================================================================================
	
// accessors, mutators -----------
	
	// name accessor
	public String getName() {
		return name;
    }
	
	// name mutator
	public void setName(String name) {
		this.name = name;
	}
	
	// overloaded mutator version, prompts for data
	public void setName(boolean inputMode) {
		String data = UtilsUB.readString("Enter dam name:\t", inputMode);
		setName(data);
	}
	
//---------------------------------------------------------------------------------------------
	
	// year accessor
	public int getYear() {
		return year;
    }
	
	// year mutator
	public void setYear(int year) {
		this.year = year;
	}
	
	// overloaded mutator version, prompts for data
	public void setYear(boolean inputMode) {
		int data = UtilsUB.readInt("Enter dam opening year:\t", inputMode);
		setYear(data);
	}
	
//---------------------------------------------------------------------------------------------
	
	// storage accessor
	public double getStorage() {
		return storage;
    }
	
	// storage mutator
	public void setStorage(double storage) {
		this.storage = storage;
	}
	
	// overloaded mutator version, prompts for data
	public void setStorage(boolean inputMode) {
		double data = UtilsUB.readDouble("Enter current dam water storage [acre-ft]:\t", inputMode);
		setStorage(data);
	}
	
//---------------------------------------------------------------------------------------------
	
	// capacity accessor
	public double getCapacity() {
		return capacity;
    }
	
	// capacity mutator
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
	// overloaded mutator version, prompts for data
	public void setCapacity(boolean inputMode) {
		double data = UtilsUB.readDouble("Enter total dam water capacity [acre-ft]:\t", inputMode);
		setCapacity(data);
	}
	
//---------------------------------------------------------------------------------------------
	
	// inflow accessor
	public double getInflow() {
		return inflow;
    }
	
	// inflow mutator
	public void setInflow(double inflow) {
		this.inflow = inflow;
	}
	
	// overloaded mutator version, prompts for data
	public void setInflow(boolean inputMode) {
		double data = UtilsUB.readDouble("Enter current water inflow rate [cu-ft/s]:\t", inputMode);
		setInflow(data);
	}
	
//---------------------------------------------------------------------------------------------
	
	// outflow accessor
	public double getOutflow() {
		return outflow;
    }
	
	// outflow mutator
	public void setOutflow(double outflow) {
		this.outflow = outflow;
	}
	
	// overloaded mutator version, prompts for data
	public void setOutflow(boolean inputMode) {
		double data = UtilsUB.readDouble("Enter current water outflow rate [cu-ft/s]:\t", inputMode);
		setOutflow(data);
	}
	
//---------------------------------------------------------------------------------------------
	
	// date accessor
	public CS12Date getDate() {
		return date;
    }
	
	// date mutator
	public void setDate(CS12Date date) {
		this.date = date;
	}
	
	// overloaded mutator version, prompts for data
	public void setDate(boolean inputMode) {
		CS12Date data = new CS12Date(UtilsUB.readInt("Enter Month of Current Dam Data:\t", false), 
									 UtilsUB.readInt("Enter Day of Current Dam Data:\t", false), 
									 UtilsUB.readInt("Enter Year of Current Dam Data:\t", false));
		setDate(data);
	}
	
//=====================================================================================================
	
	// this is the standard interface for equals()
    public boolean equals(Object obj) {
    
        // first, check whether objects of same type
        if (!(obj instanceof DamUB)) {
            // stop, we aren't comparing apples to apples
            return false;
        }
        
        else {
            // typecast into the intended object types
            DamUB p = (DamUB) obj;
            
            // check field-by-field on ALL fields
            if ( (p.getName().equals(this.name)) && 
            		(Math.abs(p.getCapacity()-this.capacity) <= TOL) && 
            		(p.getDate().equals(this.date)) && 
            		(Math.abs(p.getInflow()-this.inflow) <= TOL) && 
            		(Math.abs(p.getOutflow()-this.outflow) <= TOL) && 
            		(Math.abs(p.getStorage()-this.storage) <= TOL) && 
            		(p.getYear() == this.year) ) {
                return true;
           }
            else {
                return false;
            }
        } 
        
    } // end equals
    
    
//=====================================================================================================
	
    // test driver for this class
	public static void main(String[] args) {
		
		//initialize objects of DamUB
        DamUB obj1 = new DamUB();
        DamUB obj2 = new DamUB("Dam 2", 1963, 500000.0, 1000000.0, 200.0, 100.0, new CS12Date(4, 23, 2016));
        DamUB obj3 = new DamUB("Dam 3", 1986);
        DamUB obj4 = new DamUB("Dam 4", 100000.0);
        
        // create and set temp for use in equality
        String temp1 = new String("tester");
        CS12Date temp2 = new CS12Date(4,23,2016);
        
        // basic test of 4 diffrent classes
        System.out.println(obj1.toSring());
        obj1.print("Dam created from default constructor: make sure all defualts are OK");
        UtilsUB.pause();
        
        System.out.println(obj2.toSring());
        obj2.print("Dam created from full constructor: make sure all values as Specified");
        UtilsUB.pause();
        
        System.out.println(obj3.toSring());
        obj3.print("Dam created from name/year constructor: should show all defaults except name/year");
        UtilsUB.pause();
        
        System.out.println(obj4.toSring());
        obj4.print("Dam created from name/capacity constructor: should show all defaults except name/capacity");
        UtilsUB.pause();
        
        
        // test accessors
        obj1.print("Starting point in a new default DamUB ");
        UtilsUB.pause();
        
        obj1.setName(false);
        System.out.println("name should be set to        " + obj1.getName());
        
        obj1.setYear(false);
        System.out.println("year should be set to        " + obj1.getYear());
        
        obj1.setDate(false);
        System.out.println("date should be set to        " + obj1.getDate());
        
        obj1.setCapacity(false);
        System.out.println("capacity should be set to    " + obj1.getCapacity());
        
        obj1.setStorage(false);
        System.out.println("storage should be set to     " + obj1.getStorage());
        
        obj1.setInflow(false);
        System.out.println("inflow should be set to      " + obj1.getInflow());
        
        obj1.setOutflow(false);
        System.out.println("outflow should be set to     " + obj1.getOutflow());

        
        obj1.print("Updated dam state is: ");
        UtilsUB.pause();
        
        // test equality
        System.out.println("Any Dam should equal itself:                  " + obj1.equals(obj1));
        System.out.println("Any two DIFFRENT Dams should not be equal:    " + obj1.equals(obj2));
        System.out.println("A Dam and a String should NOT be equal:       " + obj1.equals(temp1));
        System.out.println("A Dam and a CS12Date should NOT be equal:     " + obj1.equals(temp2));
    } // end main
    
} // end class
