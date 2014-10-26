package goeuro.de.com.goeurotest.webapi;


import retrofit.Callback;
import retrofit.RetrofitError;
import android.content.Context;
import android.util.Log;


public abstract class RetrofitNetworkHandling<T> implements Callback<T>{

	private Context context;

	public RetrofitNetworkHandling() {
		this.context = context;
		
	}
		
	@Override
	public void failure(RetrofitError arg0) {
		Log.e("Retrofit Connection Error ",arg0.getMessage()+"");
	}


}
