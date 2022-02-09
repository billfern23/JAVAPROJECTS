
public class Main {

	public static void main(String[] args) {
		// create an array for currency
		String currency[] = new String[] {"Dollars", "Euros", "Pounds"};
		//create an array for the ammount
		int[] amount = new int[] {1,2,3};
		//create new bankAcount object
		BankAccount bankAccount = new BankAccount();
		//create thread for depositor
		Deposit deposit = new Deposit(bankAccount,amount, currency);
		//thread for withdrwaer
		Withdraw withdraw = new Withdraw(bankAccount,amount);
		// set thread-0 name to depositor and start
		deposit.setName("Depositor");
		deposit.start();
		// set thread-1 name to depositor and start
		withdraw.setName("Friend");
		withdraw.start();
		

	}
}



