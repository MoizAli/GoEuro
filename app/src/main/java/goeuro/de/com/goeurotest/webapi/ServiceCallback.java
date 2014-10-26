package goeuro.de.com.goeurotest.webapi;

import android.content.Context;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Proper use requires it to be created when the webservice is executed.
 *
 * @param <T>
 */
public abstract class ServiceCallback<T> implements Callback<T> {

    private Context ctx;


    public ServiceCallback() {
        super();
        this.ctx = ctx;
    }

    @Override
    public void failure (RetrofitError arg0) {

			}
	
	@Override
	public void success( T arg0, Response arg1 ) {

	}
	
}
