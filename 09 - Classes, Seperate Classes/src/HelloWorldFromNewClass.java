public class HelloWorldFromNewClass {
	
	private int num1;
	private String name;
	private String other;
//==========================================================================
	HelloWorldFromNewClass(){
		this.setOther("sucess");
	}
	
	HelloWorldFromNewClass(String c){
		other = c;
	}
	
	HelloWorldFromNewClass(int num){
		
	}
//==========================================================================	
	public void wow(){
		
		System.out.println(other);
		
	}
//==========================================================================	
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum1() {
		return num1;
	}
	public String getOther() {
		return other;
	}
	public String getName() {
		return name;
	}
	public void setOther(String other) {
		this.other = other;
	}

}
