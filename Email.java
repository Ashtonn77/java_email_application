package emailapp;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private int defaultPasswordLength = 10;
	private String department;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	
	// constructor for first and last name
	public Email(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		
		// set department
		this.department = setDepartment();
		
		//set password - randomly generated
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Password: " + this.password);
		
		this.email = this.firstName.toLowerCase() + this.lastName.toLowerCase() + "@" + this.department + "." + companySuffix;

	}
	
	// ask for department
	private String setDepartment()
	{
		System.out.println("DEPARTMENT CODES\n1. Sales\n2. Development\n3. Accounting\n0. None\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int departmentChoice = in.nextInt();
		
		switch(departmentChoice)
		{
			case 1:
				return "sales";
			case 2:
				return "development";
			case 3:
				return "accounting";
			default:
				return "";
		}		
		
	}
	
	// generate random password
	private String randomPassword(int length)
	{
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
		char[] password = new char[length];
		
		for(int i = 0; i < length; i++)
		{
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
		
	}
	
	// set mailbox capacity
	public void setMailboxCapacity(int capacity)
	{
		this.mailboxCapacity = capacity;
	}
	
	// set alternate email
	public void setAlternateEmail(String email)
	{
		this.alternateEmail = email;
	}
	
	// change password
	public void changePassword(String password)
	{
		this.password = password;
	}
	
	public int getMailboxCapacity() { return this.mailboxCapacity; }
	public String getAlternateEmail() { return this.alternateEmail; }	
	
	public String showInfo()
	{
		return "Display name: " + this.firstName + " " + this.lastName
				+ "\nCompany email: " + this.email
				+ "\nMailbox capacity: " + this.mailboxCapacity + "mb";
	}
	
}





















