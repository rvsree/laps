package com.mortgage.leads.utils.exception;

import java.sql.SQLException;

public class DAOException extends SQLException {

	private static final long serialVersionUID = 1L;

	public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(String message) {
        super(message);
    }
}
