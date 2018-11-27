public class Accounts {
	
	private String acctName;
	private int acctNum;
	private double acctAmt;
	
	public double dAmt, wAmt;
	
	public Accounts(String a, int b, double c) {
		setAcctName(a);
		setAcctNum(b);
		setAcctAmt(c);
	}
	
	void deposit(double x){
		this.acctAmt += x;
	}
	
	void withdraw(double y){
		this.acctAmt -= y;
	}
		
	public int getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(int accttNum) {
		this.acctNum = accttNum;
	}
	public String getAcctName() {
		return acctName;
	}
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	public double getAcctAmt() {
		return acctAmt;
	}
	public void setAcctAmt(double acctAmt) {
		this.acctAmt = acctAmt;
	}

}
