package Banking;

import java.util.Scanner;
import java.util.Random;

public class Banking {
	private String name; 
	private double currentBalance; 
	
	public Banking(String name, Double currentBalance) {
		this.name = name;
		this.currentBalance = currentBalance;
	}
	
	public void greetings() {
		System.out.println("Welcome " + this.name); 
	}
	public double getBalance() {
		return this.currentBalance;
	}
	
	public void withdraw(double withdraw) {

		this.currentBalance -= withdraw;
		System.out.println("Amount withdrawn: $" + withdraw+ "\nCurrent Balance: $" + String.format("%.2f",this.currentBalance));
		
	}
	
	public void deposit(double amount) {
		this.currentBalance += amount;
		System.out.println("Current balance: $" + String.format("%.2f",this.currentBalance));
	}
	
}


class Access{
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("Enter your name: ");
		String name = scan.nextLine();
		
		double min = 0; 
		double max = 1000000;
		
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
				System.out.println("Balance: $" + String.format("%.2f",user.getBalance()));
			}
			else if(choice.equalsIgnoreCase("d")) {
				System.out.print("Enter amount to deposit: $");
				double deposit = scan.nextDouble();
				user.deposit(deposit);
				scan.nextLine();
			}
			else if(choice.equalsIgnoreCase("w")) {
				double withdraw;
				do {
					System.out.print("Enter amount to withdraw: $");
					withdraw = scan.nextDouble();
				}while(withdraw > user.getBalance());
				user.withdraw(withdraw);
				scan.nextLine();
			}
			
		}
		System.out.println("Thank You!");
		
		scan.close();
		
		
	}
}
