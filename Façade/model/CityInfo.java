package Façade.model;

import java.util.ArrayList;
import java.util.List;

public class CityInfo {
    private String name;
    private boolean hasAirport;
    private boolean hasTrainStation;
    private boolean hasBusStation;
    private String country;
    
    public CityInfo(String name, boolean hasAirport, boolean hasTrainStation, boolean hasBusStation, String country) {
        this.name = name;
        this.hasAirport = hasAirport;
        this.hasTrainStation = hasTrainStation;
        this.hasBusStation = hasBusStation;
        this.country = country;
    }
    
    public String getName() { return name; }
    public boolean hasAirport() { return hasAirport; }
    public boolean hasTrainStation() { return hasTrainStation; }
    public boolean hasBusStation() { return hasBusStation; }
    public String getCountry() { return country; }
    
    public List<String> getAvailableTransportTypes() {
        List<String> types = new ArrayList<>();
        if (hasAirport) types.add("FLIGHT");
        if (hasTrainStation) types.add("TRAIN");
        if (hasBusStation) types.add("BUS");
        return types;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%s) | FLIGHT:%s TRAIN:%s BUS:%s", 
            name, country, 
            hasAirport ? "Yes" : "No",
            hasTrainStation ? "Yes" : "No",
            hasBusStation ? "Yes" : "No");
    }
}