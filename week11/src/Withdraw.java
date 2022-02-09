
public class Withdraw extends Thread{
	private BankAccount accountHold;
	private int amount[];
	//constructor for thread, 
	public Withdraw(BankAccount bankAccount, int []amount) {

		this.accountHold = bankAccount;
		this.amount = amount;


	}
	//run method
		//for loop used so that the thread doesn't die. 
		// while looped used becase only 1  unit of currency is widthdrawed at a time.
	public void run() {
		for(int i =0; i < amount.length ; i++) {
			while (amount[i] > 0) {
				this.accountHold.Withdraw();
				amount[i]--;

			}
		}
	}



}

