package Banking;


import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;


//Banking class to access user information 
public class Banking {
	//creates private user name and their balance 
	private String name; 
	private double currentBalance; 
	
	//Creates user 
	public Banking(String name, Double currentBalance) {
		this.name = name;
		this.currentBalance = currentBalance;
	}
	//greets user & name 
	public void greetings() {
		System.out.println("Welcome " + this.name); 
	}
	//returns user balance
	public double getBalance() {
		return this.currentBalance;
	}
	//calculates new balance after withdrawing
	public void withdraw(double withdraw) {

		this.currentBalance -= withdraw;	
	}
	//calculates new balance after deposit 
	public void deposit(double amount) {
		this.currentBalance += amount;
	}
	
}


class Access{
	public static void main(String[] args) {
		
		//creates scanner, random, and decimalFormat objects 
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		String pattern = "##,###.00";
		DecimalFormat form = new DecimalFormat(pattern);
		
		
		System.out.print("Enter your name: ");
		String name = scan.nextLine();
		
		double min = 0; 
		double max = 10000;	
		double balance = min +(max-min)*rand.nextDouble();
		
		Banking user = new Banking(name, balance);
		
		user.greetings();
		
		String answer="";
		
		while(!"n".equals(answer)) {
			do {
				System.out.print("Would you like to view your account (y/n): ");
				answer = scan.nextLine();
			}while(!answer.equalsIgnoreCase("y")&&!answer.equalsIgnoreCase("n"));
			
			
			if(answer.equalsIgnoreCase("n")) {
				break;
			}
			
			String choice;
			do {
				System.out.print("Would you like to Deposit(d), Withdraw(w) or view Balance(b)?: ");
				choice = scan.nextLine();
				
			}while(!choice.equalsIgnoreCase("d") && !choice.equalsIgnoreCase("w") && !choice.equalsIgnoreCase("b"));
			
			
			if(choice.equalsIgnoreCase("b")) {
				System.out.println("Balance: $" + form.format(user.getBalance()));
			}
			else if(choice.equalsIgnoreCase("d")) {
				System.out.print("Enter amount to deposit: $");
				double deposit = scan.nextDouble();
				user.deposit(deposit);
				System.out.println("Deposit amount: $" + form.format(deposit));
				scan.nextLine();
			}
			else if(choice.equalsIgnoreCase("w")) {
				double withdraw;
				do {
					System.out.print("Enter amount to withdraw: $");
					withdraw = scan.nextDouble();
				}while(withdraw > user.getBalance());
				user.withdraw(withdraw);
				System.out.println("Amount Withdrawn: $" + form.format(withdraw));
				scan.nextLine();
			}
			
		}
		System.out.println("Thank You, Session closed");
		
		scan.close();
		
		
	}
}
