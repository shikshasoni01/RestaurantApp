package com.restaurant.exception;

public class RestaurantException extends RuntimeException{

	    private final int errCode;

	    public RestaurantException() {
	        super();
	        this.errCode = 500;
	    }

	    public RestaurantException(String message) {
	        super(message);
	        this.errCode = 500;
	    }

	    public RestaurantException(String message, int errCode) {
	        super(message);
	        this.errCode = errCode;
	    }

	    public RestaurantException(Throwable arg0) {
	        super(arg0);
	        this.errCode = 500;
	    }

	    public RestaurantException(String arg0, Throwable arg1) {
	        super(arg0, arg1);
	        this.errCode = 500;
	    }

	    public RestaurantException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
	        super(arg0, arg1, arg2, arg3);
	        this.errCode = 500;
	    }

	    /**
	     * @return the errCode
	     */
	    public int getErrCode() {
	        return errCode;
	    }
	

}
