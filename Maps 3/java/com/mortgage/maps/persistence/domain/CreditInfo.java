package com.mortgage.maps.persistence.domain;

import java.io.Serializable;

public class CreditInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int creditInfoId;
    private String customerId;
	private double salary;
    private int creditScore;
    private double loanAmount;
    
	public CreditInfo(int creditInfoId, String customerId, double salary, int creditScore, int mortgageType,
			double loanAmount, double interestRate) {
		super();
		this.creditInfoId = creditInfoId;
		this.customerId = customerId;
		this.salary = salary;
		this.creditScore = creditScore;
		this.loanAmount = loanAmount;
	}

	public int getCreditInfoId() {
		return creditInfoId;
	}

	public void setCreditInfoId(int creditInfoId) {
		this.creditInfoId = creditInfoId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + creditInfoId;
		result = prime * result + creditScore;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(loanAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditInfo other = (CreditInfo) obj;
		if (creditInfoId != other.creditInfoId)
			return false;
		if (creditScore != other.creditScore)
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (Double.doubleToLongBits(loanAmount) != Double.doubleToLongBits(other.loanAmount))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

}