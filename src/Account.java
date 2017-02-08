class Account {
	
	double balance;
	int accountNumber;
	
	Account(){
		
	}
	
	Account(double balance,int accountNumber){
		this.balance=balance;
		this.accountNumber=accountNumber;
	
	}
	public double getBalance(){
		return balance;
	}
    public void deposit(double sum) {
    	this.balance +=sum;
    	
    }

    public void withdraw(double sum) {
    	this.balance -=sum;
    	}
    	
    public int getAccountNumber(){
    	return accountNumber;
    }
}
