package goeuro.de.com.goeurotest.webapi;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonFactory {

    public static final String DATE_FROMAT = "dd-MM-yyyy";
    public static final String DATE_FROMAT_2 = "dd/MM/yyyy";
    public static final String TIME_FROMAT = "HH:mm:ss";
    public static final String DATE_TIME_FROMAT = "yyyy-MM-dd HH:mm:ss";

    private static Gson configuredGson;
    private static Gson simpleGson;

    public static Gson getConfiguredGson() {

        if (configuredGson == null) {
            GsonBuilder builder = new GsonBuilder();
            configuredGson = builder.create();
        }

        return configuredGson;
    }
}