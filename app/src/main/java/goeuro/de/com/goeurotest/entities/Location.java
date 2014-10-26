package goeuro.de.com.goeurotest.entities;

public class Location  {
private double _id=0 ;
private String key;
private String name;
private String fullName;
private String iata_airport_code;
private String type;
private String country;
private double locationId=0 ;
private boolean inEurope=false ;
private String countryCode;
private boolean coreCountry=false ;
private String distance;
private LocGeoPosition geo_position;

public double get_id() {
    return this._id;
}
public void set_id(double _id)  {
    this._id=_id;
}

public String getKey() {
    return this.key;
}
public void setKey(String key)  {
    this.key=key;
}

public String getName() {
    return this.name;
}
public void setName(String name)  {
    this.name=name;
}

public String getFullName() {
    return this.fullName;
}
public void setFullName(String fullName)  {
    this.fullName=fullName;
}

public String getIata_airport_code() {
    return this.iata_airport_code;
}
public void setIata_airport_code(String iata_airport_code)  {
    this.iata_airport_code=iata_airport_code;
}

public String getType() {
    return this.type;
}
public void setType(String type)  {
    this.type=type;
}

public String getCountry() {
    return this.country;
}
public void setCountry(String country)  {
    this.country=country;
}

public double getLocationId() {
    return this.locationId;
}
public void setLocationId(double locationId)  {
    this.locationId=locationId;
}

public boolean getInEurope() {
    return this.inEurope;
}
public void setInEurope(boolean inEurope)  {
    this.inEurope=inEurope;
}

public String getCountryCode() {
    return this.countryCode;
}
public void setCountryCode(String countryCode)  {
    this.countryCode=countryCode;
}

public boolean getCoreCountry() {
    return this.coreCountry;
}
public void setCoreCountry(boolean coreCountry)  {
    this.coreCountry=coreCountry;
}

public String getDistance() {
    return this.distance;
}
public void setDistance(String distance)  {
    this.distance=distance;
}


    public LocGeoPosition getGeo_position() {
        return geo_position;
    }

    public void setGeo_position(LocGeoPosition geo_position) {
        this.geo_position = geo_position;
    }
}
// End of Locati