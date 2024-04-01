package org.jsp.ecommerce.dto;


public class ResponseStructure<T> {
	 private int statusCode;
	    private String message;
	    private T body;

	    // Constructors, getters, and setters

	    public int getStatusCode() {
	        return statusCode;
	    }

	    public void setStatusCode(int statusCode) {
	        this.statusCode = statusCode;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public T getBody() {
	        return body;
	    }

	    public void setBody(T body) {
	        this.body = body;
	    }
    
}
