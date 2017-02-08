import java.util.ArrayList;
import java.util.List;

/**
 * Created by fredf on 1/31/2017.
 */
public class Bank {
	String bank_name;
	ArrayList<Account> accounts = new ArrayList<Account>(); 
	
	
	Bank(){
		
	}
	
	Bank(String bank_name,ArrayList<Account> accounts){
		this.bank_name= bank_name;
		this.accounts = accounts; 
	}
	
	

    public Account openAccount() {
    	//System.out.println(accounts.size());
    	int accountNumber = accounts.size()+10000;
    	Account newAccount = new Account(0,accountNumber);
    	accounts.add(newAccount);
    	return newAccount;}
       
  

    public  CheckingAccount openChecking(double balance,double limit) {
       int AccountNumber = accounts.size()+10000;
       CheckingAccount newAccount = new CheckingAccount(balance, limit,AccountNumber);
       accounts.add(newAccount);
       return newAccount;
    	
    }

    public  SavingsAccount openSavings (double balance, double interest)  {
    	int AccountNumber = accounts.size()+10000;
    	SavingsAccount newAccount = new SavingsAccount(balance, interest,AccountNumber);
    	accounts.add(newAccount);
        return newAccount;
        }
       
    
    public void updateAll() {
    	for (Account x:accounts){
    		if( x instanceof SavingsAccount){
    			SavingsAccount temp= new SavingsAccount(0,0,0);
    			temp =(SavingsAccount)x;
    			temp.addsinterest();
    		}
    			
    		if( x instanceof CheckingAccount){
    			if(x.getBalance()<0){
    				System.out.println("over the limit");
    			}
    		}
    	}
    	
    }
    
    
    public Account getAccount(int accountNumber) {
    	Account x = new Account(0,0);
    	for (int a =0; a <accounts.size();a++){
    		if (accounts.get(a).getAccountNumber() == accountNumber){
    			x = accounts.get(a);
    		}
    	}
    	return x;
    	
    }
}
