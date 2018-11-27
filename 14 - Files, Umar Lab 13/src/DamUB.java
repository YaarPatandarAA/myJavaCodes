/* 
 * Name:       Umar Bath
 *
 * Course:     CS-12, Fall 2015  
 * 
 * Date:       05/04/16
 * 
 * Filename:   DamUB.java
 * 
 * Purpose:    final creation of a DamUB class
 */

import java.text.DecimalFormat;
 
public class DamUB {
	DecimalFormat df = new DecimalFormat("#,###");
	DecimalFormat df2 = new DecimalFormat("#.#");
	
	// instance variables ------------
	private String name;
	private int year;
	private double storage, capacity, inflow, outflow;
	private CS12Date date;
	
	 // constants ---------------------
	private final double TOL = 0.0001;  // equals FP tolerance
	
	
// data above here
//=====================================================================================================
// methods below here
	
// constructors ------------------
    
    // default constructor
	public DamUB(){
		name = "<empty>";
		year = 1900;
		storage = 0.0;
		capacity = 0.0;
		inflow = 0.0;
		outflow = 0.0;
		date = new CS12Date(4, 17, 2016);
	}
	
	
	 // full constructor
	public DamUB(String name, int year, double storage, double capacity, double inflow, double outflow, CS12Date date){
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
	public DamUB(String name, double capacity){
		this();
		this.name = name;
		this.capacity = capacity;
	}
	
//=====================================================================================================
	
// display methods ---------------
    
    // string version of object data
	public String toString(){	
		return name + 
				" " + 
				year + 
				" " + 
				df.format(storage) + 
				" " + 
				df.format(capacity) + 
				" " + 
				df.format(inflow) + 
				" " + 
				df.format(outflow) + 
				" " + 
				date;
	}
	
	// formatted version of object data
	public void print(){
		System.out.println("Name:                    " + name);
		System.out.println("Year Opened:             " + year);
		System.out.println("Age [yrs]:               " + getAge());
		System.out.println("Date as of:              " + date);
		System.out.println("Storage [acre-ft]:       " + df.format(storage));
		System.out.println("Capacity [acre-ft]:      " + df.format(capacity));
		System.out.println("Inflow [cu-ft/s]:        " + df.format(inflow));
		System.out.println("Outflow [cu-ft/s]:       " + df.format(outflow));
		System.out.println("% full:                  " + df2.format(getPercentageFull()) + " %");
		System.out.println("Status:                  " + getStatus());
		System.out.println("Days until dam event:    " + getEventDays());
		System.out.println("Date of dam event:       " + getEventDate());
		System.out.println();
	}
	
	// overloaded version of print, accepts a label string
	public void print(String message){
		System.out.println("====================================");
		System.out.println(message);
		System.out.println("====================================");
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
		String data = UtilsUB.readString("Enter dam name: ", inputMode);
		setName(data);
	}
	
//---------------------------------------------------------------------------------------------
	
	// year accessor
	public int getYear() {
		return year;
    }
	
	// year mutator
	public void setYear(int year) {
		if(year < 1900){
			System.out.println("ERROR: year must be >= 1900, value unchanged");
		}
		else{
			this.year = year;
		}
	}
	
	// overloaded mutator version, prompts for data
	public void setYear(boolean inputMode) {
		int data = UtilsUB.readInt("Enter dam opening year: ", inputMode);
		setYear(data);
	}
	
//---------------------------------------------------------------------------------------------
	
	// storage accessor
	public double getStorage() {
		return storage;
    }
	
	// storage mutator
	public void setStorage(double storage) {
		if((storage < 0.0) | (storage >= capacity)){
			System.out.println("ERROR: storage must be >= 0 and <= capacity, value unchanged");
		}
		else{
			this.storage = storage;
		}
	}
	
	// overloaded mutator version, prompts for data
	public void setStorage(boolean inputMode) {
		double data = UtilsUB.readDouble("Enter current dam water storage [acre-ft]: ", inputMode);
		setStorage(data);
	}
	
//---------------------------------------------------------------------------------------------
	
	// capacity accessor
	public double getCapacity() {
		return capacity;
    }
	
	// capacity mutator
	public void setCapacity(double capacity) {
		if((capacity <= 0.0)){
			System.out.println("ERROR: capacity must be >= 0, value unchanged");
		}
		else{
			this.capacity = capacity;
		}
		
	}
	
	// overloaded mutator version, prompts for data
	public void setCapacity(boolean inputMode) {
		double data = UtilsUB.readDouble("Enter total dam water capacity [acre-ft]: ", inputMode);
		setCapacity(data);
	}
	
//---------------------------------------------------------------------------------------------
	
	// inflow accessor
	public double getInflow() {
		return inflow;
    }
	
	// inflow mutator
	public void setInflow(double inflow) {
		if((inflow <= 0.0)){
			System.out.println("ERROR: inflow must be >= 0, value unchanged");
		}
		else{
			this.inflow = inflow;
		}
		
	}
	
	// overloaded mutator version, prompts for data
	public void setInflow(boolean inputMode) {
		double data = UtilsUB.readDouble("Enter current water inflow rate [cu-ft/s]: ", inputMode);
		setInflow(data);
	}
	
//---------------------------------------------------------------------------------------------
	
	// outflow accessor
	public double getOutflow() {
		return outflow;
    }
	
	// outflow mutator
	public void setOutflow(double outflow) {
		if((outflow <= 0.0)){
			System.out.println("ERROR: outflow must be >= 0, value unchanged");
		}
		else{
			this.outflow = outflow;
		}
		
	}
	
	// overloaded mutator version, prompts for data
	public void setOutflow(boolean inputMode) {
		double data = UtilsUB.readDouble("Enter current water outflow rate [cu-ft/s]: ", inputMode);
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
		CS12Date data = new CS12Date(UtilsUB.readInt("Enter Month of Current Dam Data: ", false), 
									 UtilsUB.readInt("Enter Day of Current Dam Data: ", false), 
									 UtilsUB.readInt("Enter Year of Current Dam Data: ", false));
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
    // derived data accessors --------
    
    // compute age
    public int getAge(){
    	int age;
    	CS12Date dateTemp = new CS12Date(1,1,year);
    	
		age = UtilsUB.getAge(dateTemp);
		
		return age;
    	
    }
    
    // computer perentage of dam full
    public double getPercentageFull(){
		double percentage = 0;
		
		if(capacity <= 0){
			System.out.println("Capacity is Less Than or Equal to Zero");
		}
		else{
			percentage = (storage / capacity) * 100.0;
		}
		
		return percentage;
    	
    }
    
    // find out status of water in dam
    public String getStatus(){
    	String tempMessage = "<null>";
    	if( inflow > outflow){
    		tempMessage = "Filling";
    	}
    	else if ( inflow < outflow){
    		tempMessage = "Emptying";
    	}
    	else if ( inflow == outflow){
    		tempMessage = "Holding";
    	}
    	return tempMessage;
    }
    
    // computer number of days until event
    public int getEventDays(){
    	int time = 0;
    	
    	final double measureConv = 43560.0;
    	final double timeConv = 3600.0;
    	final double dayConv = 24.0;
    	
    	double valueC = measureConv / (timeConv * dayConv);
    	
    	if( inflow > outflow){
    		time = (int) (( (capacity - storage) / (inflow - outflow) ) * valueC);
    	}
    	else if ( inflow < outflow){
    		time = (int) (( (storage - 0) / (outflow - inflow) ) * valueC);
    	}
    	else if ( inflow == outflow){
    		time = -1;
    	}
    	
    	return time;
    }
    
    // computer date of event
    public CS12Date getEventDate(){
    	CS12Date dateTemp = date;
    	
    	CS12Date obj1 = new CS12Date(dateTemp.getMonth(), dateTemp.getDay(), dateTemp.getYear());
    	
    	obj1.laterDate(getEventDays());
    	
    	dateTemp = obj1;
    	
    	return dateTemp;
    }
    
//=====================================================================================================
    // utility methods ---------------
    
    // update the entire object from user prompts
    public void update(boolean mode){
    	setName(mode);
    	setYear(mode);
    	setCapacity(mode);
    	setStorage(mode);
    	setInflow(mode);
    	setOutflow(mode);
    	setDate(mode);
    }
    
    // add water to dam
    public void importWater(double acreFeet){
    	if(acreFeet <= 0.0){
    		System.out.println("Error import water negative");
    	}
    	else if( (storage + acreFeet > capacity) | (storage + acreFeet < 0) ){
    		System.out.println("Error overflow/underflow risk");
    	}
    	else{
    		setStorage(storage + acreFeet);
    	}
    }
    
    // take water out of dam
    public void releaseWater(double acreFeet){
    	if(acreFeet <= 0.0){
    		System.out.println("Error release water negative");
    	}
    	else if( (storage - acreFeet < 0) | (storage - acreFeet > capacity) ){
    		System.out.println("Error overflow/underflow risk");
    	}
    	else{
    		setStorage(storage - acreFeet);
    	}
    }
    
    // increase outflow stream amount
    public void increaseOutflow(double cuFtSec){
    	if(cuFtSec <= 0.0){
    		System.out.println("Error increase outflow negative");
    	}
    	else if( (outflow + cuFtSec < 0) ){
    		System.out.println("Error outflow");
    	}
    	else{
    		setOutflow(outflow + cuFtSec);
    	}
    }
    
    // lower outflow stream amount
    public void decreaseOutflow(double cuFtSec){
    	if(cuFtSec <= 0.0){
    		System.out.println("Error decrease outflow negative");
    	}
    	else if( (outflow - cuFtSec < 0) ){
    		System.out.println("Error outflow real low");
    	}
    	else{
    		setOutflow(outflow - cuFtSec);
    	}
    }
    
//=====================================================================================================
	
    // test driver for this class
	public static void main(String[] args) {
		
		/*
		//initialize objects of DamUB
        DamUB obj1 = new DamUB();
        DamUB obj2 = new DamUB("Dam 2", 1963, 500000.0, 1000000.0, 200.0, 100.0, new CS12Date(4, 23, 2016));
        DamUB obj3 = new DamUB("Dam 3", 1986);
        DamUB obj4 = new DamUB("Dam 4", 100000.0);
        
        // create and set temp for use in equality
        String temp1 = new String("tester");
        CS12Date temp2 = new CS12Date(4,23,2016);
        
        // basic test of 4 diffrent classes
        System.out.println(obj1.toString());
        obj1.print("Dam created from default constructor: make sure all defualts are OK");
        UtilsUB.pause();
        
        System.out.println(obj2.toString());
        obj2.print("Dam created from full constructor: make sure all values as Specified");
        UtilsUB.pause();
        
        System.out.println(obj3.toString());
        obj3.print("Dam created from name/year constructor: should show all defaults except name/year");
        UtilsUB.pause();
        
        System.out.println(obj4.toString());
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
        */
		
		DamUB obj1 = new DamUB("Folsom", 1956, 816425.0, 977000.0, 5228.0, 3038.0, new CS12Date(4, 24, 2016));
		DamUB obj2 = new DamUB("Oroville", 1968, 3362788, 3537577, 6977, 1409, new CS12Date(4, 24, 2016));
		DamUB obj3 = new DamUB("Shasta", 1945, 4206665, 4552000, 9619, 4781, new CS12Date(4, 24, 2016));
		DamUB obj4 = new DamUB("Nimbus", 1955, 7769, 9000, 2952, 3116, new CS12Date(4, 24, 2016));
        
        // basic test of 4 diffrent classes
        System.out.println(obj1.toString());
        obj1.print("Folsom actual data");
        UtilsUB.pause();
        
        System.out.println(obj2.toString());
        obj2.print("Oroville actual data");
        UtilsUB.pause();
        
        System.out.println(obj3.toString());
        obj3.print("Shasta actual data");
        UtilsUB.pause();
        
        System.out.println(obj4.toString());
        obj4.print("Nimbus actual data");
        UtilsUB.pause();
        
        obj4.decreaseOutflow(164);
        UtilsUB.pause();
        
        System.out.println(obj4.toString());
        obj4.print("Nimbus actual data");
        UtilsUB.pause();
        
        obj4.update(false);
        System.out.println(obj4.toString());
        obj4.print("Nimbus actual data");

    } // end main
    
} // end class
