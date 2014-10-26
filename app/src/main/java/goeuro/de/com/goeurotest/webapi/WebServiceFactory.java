package goeuro.de.com.goeurotest.webapi;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

import java.security.GeneralSecurityException;

import javax.net.ssl.SSLContext;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class WebServiceFactory {

	//private static ChatWebAPI chatService;
	private static GoEuroService registerService;

    public static GoEuroService getInstance() {
        if ( registerService == null ) {
            //OkHttpClient name = new OkHttpClient();
            //name.setReadTimeout( 15, TimeUnit.SECONDS );

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setClient( createClient() )
                    .setEndpoint( WebServicesConstants.SERVER_URL )
                    .setConverter( new retrofit.converter.GsonConverter( GsonFactory.getConfiguredGson() ) )
                    .setLog( new RestAdapter.Log() {
                        @Override
                        public void log (String msg) {
                            Log.i( "LOG MESSAGE", msg );
                        }
                    } )
                    .setLogLevel( RestAdapter.LogLevel.FULL ).build();

            registerService = restAdapter.create( GoEuroService.class );
        }

        return registerService;

    }

    public static OkClient createClient() {
        OkHttpClient client = new OkHttpClient();
        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("TLS"); //$NON-NLS-1$
            sslContext.init(null, null, null);
        } catch (GeneralSecurityException e) {
            throw new AssertionError(); // The system has no TLS. Just give up.
        }
        client.setSslSocketFactory(sslContext.getSocketFactory());
        return new OkClient(client);
    }

}