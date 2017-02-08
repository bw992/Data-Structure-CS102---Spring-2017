/**
 * Created by fred on 1/28/2017.
 */
class CheckingAccount extends Account {
	double overdraftLimit;
	
	CheckingAccount(double balance, double overdraftLimit,int accountNumber){
		super(balance,accountNumber);
		this.overdraftLimit= overdraftLimit;
		
	}
	
	public double getOverdraftLimit(){
		return overdraftLimit;
	}
	
	public void withdraw(double actual_withdraw){
		if(actual_withdraw<overdraftLimit){
			this.balance -= actual_withdraw;
			System.out.println("draft allowed.");
		}
		else{
			
			System.out.println("draft denied.");
		
		}
	
			
	}
}
