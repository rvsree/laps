package com.mortgage.leads.utils.exception;

public class LeadsException extends Exception {

	private static final long serialVersionUID = 1L;

	public LeadsException(String message, Throwable cause) {
        super(message, cause);
    }

    public LeadsException(String message) {
        super(message);
    }
}
