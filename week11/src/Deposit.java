
public class Deposit extends Thread {

	private BankAccount accountHold;
	private int amount[];
	private String currency[];
	//constructor for thread, 
	public Deposit(BankAccount bankAccount, int []amount, String []currency) {
		this.accountHold = bankAccount;
		this.amount = amount;
		this.currency = currency;

	}
	
	//run method
	//for loop used so that the thread doesn't die. inner loop is to take care if the currency is greater then one, as
	//only 1  unit of currency is deposited at a time.

	public void run() {
		
		for(int i =0; i < amount.length ; ++i) {

		

			for(int x= 0; x < amount[i] ; x++) {


				this.accountHold.Deposit(1, currency[i]);

			}

		}
	}

}
