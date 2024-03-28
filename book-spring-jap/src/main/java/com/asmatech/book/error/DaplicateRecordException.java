package com.asmatech.book.error;

public class DaplicateRecordException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaplicateRecordException() {
		super();
	}

	public DaplicateRecordException(String message) {
		super(message);
	}

}
