package com.mortgage.maps.persistence.domain;

import java.io.Serializable;
import org.springframework.stereotype.Component;

@Component
public class Lead implements Serializable {

	private static final long serialVersionUID = 1L;

	private String customerId;
	private String firstName;
	private String lastName;
	private String applicationStatus;
	private String processingComments;

	public Lead() {
	}

	public Lead(String customerId, String applicationStatus, String processingComments) {
		super();
		this.customerId = customerId;
		this.applicationStatus = applicationStatus;
		this.processingComments = processingComments;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getProcessingComments() {
		return processingComments;
	}

	public void setProcessingComments(String processingComments) {
		this.processingComments = processingComments;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationStatus == null) ? 0 : applicationStatus.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((processingComments == null) ? 0 : processingComments.hashCode());
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
		Lead other = (Lead) obj;
		if (applicationStatus == null) {
			if (other.applicationStatus != null)
				return false;
		} else if (!applicationStatus.equals(other.applicationStatus))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (processingComments == null) {
			if (other.processingComments != null)
				return false;
		} else if (!processingComments.equals(other.processingComments))
			return false;
		return true;
	}

}
