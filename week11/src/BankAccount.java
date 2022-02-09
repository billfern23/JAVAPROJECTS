
public class BankAccount {
	private int amount = 0;
	private String currency = "";
	

	public BankAccount(){}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	//deposit scychorized function
	public synchronized void Deposit(int amount, String currency) {
		//check if account has other currency, if it does then the account needs to be empty before it can filled in again
		while(!getCurrency().equals(currency) && getAmount() > 0) {
			try { 

				wait();
				notify();   //my attempt to get the other thread to respond, but i knew it wasnt going to work because its locked by the function.
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
		}
		//after waiting set currency and amount
		setCurrency(currency);
		if(amount >0) {
			//deposit one notify, other thread if waiting, but dint help either.
			notify();
			setAmount(getAmount() + 1);
		}
		//printing for traciblity purposes
		System.out.println(Thread.currentThread().getName() +" deposited " + amount + " " + getCurrency()+ " Account Balance: "+ getAmount()  +"\n"  );


	}

	//sychnronised for withdral
	public synchronized void Withdraw() {
		//while loop to keep it alive, if balance is 0, no withdrawal can be taken, i tried using a flag here, still gives me the same output.
		while(getAmount() == 0) {
			try { 


				wait();
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
		}

		//if amount is more than 0 withdraw, write the line
		if(getAmount() > 0) {
			setAmount(getAmount()-1);
			System.out.println( Thread.currentThread().getName() +
					" WithDrew " + 1 + " " + getCurrency());
		}
		
		notify();

	}


}
