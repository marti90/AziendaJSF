package utility;

import java.io.Serializable;

public class ErrorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String error;	
	
	public ErrorBean() {
		this.error="";
	}

	public ErrorBean(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
