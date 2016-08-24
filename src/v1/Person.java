package v1;
/*
 * OOPDA Spring 2016, Myers
 * University Lab
 * @author Meriel Stein
 * @version 2016.02.16
 */

//http://jackmyers.info/oopda/OOPDA%20Projects.pdf

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;

public class Person {
	
	protected String firstName;
	protected String middleName;
	protected String lastName;
	protected String email;
	protected String ssn;
	protected Integer age;
	protected Integer id;
	protected static final int minAge = 16;
	protected static final int maxAge = 123;	//oldest recorded age of a human being
	protected static int highestAge = 0;
	protected BufferedReader br;
	
	/*default constructor*/
	public Person(){
		firstName = "none given";
		lastName = "none given";
		email = "none given";
		ssn = "000-00-0000";
		age = null;
		id = 0;
	}
	
	/*two-argument constructor*/
	public Person(int id, String lastName){
		this.id = id;
		this.lastName = lastName;
	}
	
	/*parameterized constructor*/
	public Person(String firstName, String middleName, String lastName, String email, String ssn, Integer age, Integer id){
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.ssn = ssn;
		this.age = age;
		this.id = id;
		if (age > highestAge){
			highestAge = age;
		}
	}
	
	/*Getters and Setters*/
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public Integer getID(){
		return id;
	}
	public Integer getAge() {
		return age;
	}
	public String getSsn() {
		return ssn;
	}
	
	/* Setters that need validation */
	public void setEmail (String email) throws IOException {
		if(validateEmail(email)){
			this.email = email;
		}
		else{
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("This is not a valid email address.");
			System.out.println("Enter a valid email:");			
			setEmail(br.readLine());
		}
	} // end setEmail
	
	public void setSsn(String ssn) {
		if (validateSsn(ssn)){
			this.ssn = ssn;
		}
		else{
			System.out.println("This is not a valid social security number.");
			//setSsn(ssn);
		}
	} // end setSsn
	
	public void setAge(Integer age) {
		if (validateAge(age)){
			this.age = age;
		}
		else{
			System.out.println("This is not a valid age");
		}
	} // end setAge
	
	/*return the last 4 digits of the ssn*/
	public String getLast4SSN(){
		return ssn.substring(ssn.lastIndexOf("-")+1, ssn.length());
	} // end getLast4SSN
	
	/*returns the domain portion of an email (after the @), as in "gmail.com"*/
	public String getEmailDomain(){
		//substring begins at the specified beginIndex and extends to the character at index endIndex - 1
		return email.substring(email.indexOf("@")+1, email.length());
	} // end getEmailDomain
	
	/*validates email address parameter*/
	public static boolean validateEmail(String email){
		// String must contain a '@'
		if (email.contains("@")){
			//String must only contain one '@'
			if(email.indexOf("@") == email.lastIndexOf("@")){
				//A '.' must follow the '@'
				if(email.substring(email.indexOf("@"), email.length()).contains(".")){
					return true;
				}
			}
		}
		return false;
	} // end validateEmail
	
	/*validates age instance variable*/
	public static boolean validateAge(Integer age){
		// Must be an integer within age range
		if (age instanceof Integer){
			if (age > minAge && age <= maxAge){
				return true;
			}
		}
		return false;
	} // end validateAge
	
	/*validates ssn instance variable*/
	public static boolean validateSsn(String ssn){
		return Pattern.matches("\\d{3}-\\d{2}-\\d{4}", ssn);
	} // end validateSsn
	
	/* isOldest determines if person has the greatest age */
	public String isOldest(){
		if (age < highestAge){
			return "not oldest";
		}
		return "oldest";
	}
	
	/* display method displays name, type, email domain, last 4 of ssn, oldest/not oldest */
	public void display(){
		System.out.println(this +" ("+ getClass().getSimpleName()+")");
		System.out.println(getEmailDomain());
		System.out.println(getLast4SSN());
		System.out.println(isOldest());
	} // end display
	
	/*toString method*/
	@Override
	public String toString(){
		if(!middleName.equals("")){
			return firstName+" "+middleName+" "+lastName;
		}
		else{
			return firstName+" "+lastName;
		}	
	} // end toString
	
} // end Person class
