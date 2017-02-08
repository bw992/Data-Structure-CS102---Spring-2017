/**
 * Created by fred on 1/28/2017.
 */
class SavingsAccount extends Account {
	double interest;
	
	SavingsAccount(double balance,double interest,int accountNumber){
		super(balance,accountNumber);
		this.interest = interest; 
	}
		
	
	
	public void addsinterest(){
		this.balance+=(1+interest)*balance;
	}
}
