package goeuro.de.com.goeurotest.webapi;


import java.util.ArrayList;
import java.util.List;

import goeuro.de.com.goeurotest.entities.Location;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface GoEuroService {

    @GET("/position/suggest/{locale}/{term}")
    public void getCatagories(
            @Path("locale") String locale,
            @Path("term") String term ,
            Callback<List<Location>> locationResponse);

    @GET("/position/suggest/{locale}/{term}")
    public ArrayList<Location> getCatagories(
            @Path("locale") String locale,
            @Path("term") String term );

}
