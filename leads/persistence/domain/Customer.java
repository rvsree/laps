package com.mortgage.leads.persistence.domain;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class Customer implements Serializable, Comparable<Customer> {
	
	public Customer() { }
	
	public Customer(String customerId, String firstName, String lastName, 
			Date dateOfBirth, int age, String gender,
			String maritalStatus, int customerType) {

		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.customerType = customerType;
	}

	private static final long serialVersionUID = 1L;
	
	private String customerId;
    private String firstName;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy", timezone="CST")
    //@JsonSerialize(using = JsonDateSerializer.class)
    private Date dateOfBirth;
	private int age;    
    private String gender;
    private String maritalStatus;
    private int customerType;
    private String loanType;
    private String description;
    
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getMaritalStatus() {
		return maritalStatus;
	}
	
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	public int getCustomerType() {
		return customerType;
	}
	
	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	@Override     
	  public int compareTo(Customer customer) {          
	    return (this.getAge() < customer.getAge() ? -1 : 
	            (this.getAge() == customer.getAge() ? 0 : 1));     
	  }    
	

	public static Comparator<Customer> ageComparator = new Comparator<Customer>() {
		@Override
		public int compare(Customer leadCustomer1, Customer leadCustomer2) {
			return (leadCustomer2.getAge() < leadCustomer1.getAge() ? -1
					: (leadCustomer2.getAge() == leadCustomer1.getAge() ? 0 : 1));
		}
	};

	public static Comparator<Customer> nameComparator = new Comparator<Customer>() {
		@Override
		public int compare(Customer leadCustomer1, Customer leadCustomer2) {
			return (int) (leadCustomer1.getFirstName().compareTo(leadCustomer2.getFirstName()));
		}
	};	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", age=" + age + ", gender=" + gender + ", maritalStatus="
				+ maritalStatus + ", customerType=" + customerType + ", loanType=" + loanType + ", description="
				+ description + "]";
	}
	
}