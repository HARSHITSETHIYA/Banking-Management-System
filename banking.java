package Banking;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class banking {
String name;
String date_of_birth;
String phone_no;
String email_add;
String AdharCard;
int choice=-1;
int  Deposit_1,Deposit, New_Deposit=-1,Withdraw,total_amount,total_bal,balance=0,count=0;
	Scanner sc=new Scanner(System.in);
	
	public void Account_creation() throws IOException{
	
		System.out.println("Enter the following details to create an account");
		System.out.println("Enter your name");
		  name=sc.next();
		  if(name.matches("[A-Za-z]+")) {
				 System.out.println(" Name Accepted ");	 
			 }
		  else
			 {
				 System.out.println("Invalid Name");
				throw new IOException("Numbers not allowed");
			 }
		  sc.nextLine();
		System.out.println("Enter your date of birth format should be year-month-date");
		 date_of_birth=sc.next();
		 if(date_of_birth.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")){
				 System.out.println("Date of birth accepted");  
		 }
		 else {
			 System.out.println("Invalid DOB");
				//throw new IOException("Numbers not allowed");
		 }
		System.out.println("Enter your phone number");
		phone_no=sc.next();
		if(phone_no.matches("^\\d{10}$")) {
			System.out.println("Phone number accepted"); 
		}
		else {
			 System.out.println("Invalid phone_num");
				throw new IOException("Only ten numbers are allowed");
		 }
		
		System.out.println("Enter your email address");
		 email_add=sc.next();
		 if(email_add.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\\\.[a-zA-Z0-9-.]+$")) {
				System.out.println("email_address accepted"); 
			}
		 else {
			 System.out.println("Email address not accepted"); 
			 throw new IOException("Invalid email address");
		 }
		System.out.println("Enter your AdharCard number");
		 AdharCard=sc.next();
		 System.out.println("Congratulations your account is created");
		 	
	}
 public void Deposit() {
 
	 System.out.println("Enter the amount you want to deposit");
	   Deposit=sc.nextInt();//20000,t.a=30000
	   balance=balance+Deposit;
	   System.out.println("The available balance is "+balance);//20000
	   New_Deposit++;

 }
	 public void Withdraw() { 
		
	 System.out.println("Enter the amount you want to withdraw from your account");
	   Withdraw=sc.nextInt();
	   if( Withdraw>balance) {
		   System.out.println(" Sorry Insufficient Balance");
		   }else {
	   count++;
	  // System.out.println("Value of count"+count);
	   System.out.println("The withdrawn amount is"+ Withdraw);
		   }
	   if(count>=1){
			// System.out.println("The value of count is"+count);	
			// System.out.println("The deposited amount is"+balance);	 
			 balance = balance- Withdraw; 
			 System.out.println("The available balance is"+balance);
		 }
		 
	 }
	/* public void current_bal_after_withdrawl() {
		   total_amount=balance;
		 if(count==0) {
			 System.out.println("The total bal is"+total_amount);  
	  }
	
	  // System.out.println("Value of total amt"+total_amount); 
		 
			/*if(New_Deposit>=0) {
				
				 System.out.println("The current amount is"+balance);		
			}
			 if(count>=1){
			 System.out.println("The value of count is"+count);	
			// System.out.println("The deposited amount is"+balance);	 
			 balance = balance- Withdraw; 
			 System.out.println("The available balance is"+balance);
		 }
		 
		
		 //System.out.println("The current bal amount is"+total_bal);
	   
	  
	 
	
	 }	*/ 


 

public void choice() throws IOException {
	
do {
System.out.println("Press 1 to create account");
System.out.println("Press 2 to deposit money");
System.out.println("Press 3 to withdraw money");
//System.out.println("Press 4 to current balance after withdrawl");

System.out.println("Enter your choice");

choice=sc.nextInt();

switch(choice) {
case 1:
	Account_creation();
	break;
case 2:	
	Deposit();
	break;
case 3:
	Withdraw();
	break;

case 0:
break;
default:
  System.out.println("Invalid Choice");	
  
	break;
	
  }

 }while(choice!=0);
}



public static void main(String[] args) throws IOException {
		
			
		banking obj =new banking();
		//obj.Account_creation();
		//obj.validation()
		//obj.Deposit();
		obj.choice();
	}

}
