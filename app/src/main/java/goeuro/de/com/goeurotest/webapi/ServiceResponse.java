package goeuro.de.com.goeurotest.webapi;
public class ServiceResponse<T> {
	
	public String Response;
	public String Message;
	private int noOfResults;
	public T Result;
	
	public boolean isSuccess() {
		return Response.contentEquals( "Success" );
	}
	
	public String getResponse() {
		return Response;
	}
	
	public void setResponse( String response ) {
		Response = response;
	}
	
	public T getResult() {
		return Result;
	}
	
	public void setResult( T result ) {
		Result = result;
	}
	
	public String getMessage() {
		return Message;
	}
	
	public void setMessage( String message ) {
		Message = message;
	}
	
	/**
	 * @return the noOfResults
	 */
	public int getNoOfResults() {
		return noOfResults;
	}
	
	/**
	 * @param noOfResults
	 *            the noOfResults to set
	 */
	public void setNoOfResults( int noOfResults ) {
		this.noOfResults = noOfResults;
	}
	
}