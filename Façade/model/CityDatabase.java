package Façade.model;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CityDatabase {
    private Map<String, CityInfo> cities;
    
    public CityDatabase() {
        cities = new HashMap<>();
        loadCityData();
    }
    
    private void loadCityData() {
        // España
        cities.put("Madrid", new CityInfo("Madrid", true, true, true, "España"));
        cities.put("Barcelona", new CityInfo("Barcelona", true, true, true, "España"));
        cities.put("Sevilla", new CityInfo("Sevilla", true, true, true, "España"));
        cities.put("Valencia", new CityInfo("Valencia", true, true, true, "España"));
        cities.put("Granada", new CityInfo("Granada", false, true, true, "España"));
        cities.put("Toledo", new CityInfo("Toledo", false, false, true, "España"));
        cities.put("Córdoba", new CityInfo("Córdoba", false, true, true, "España"));
        cities.put("Salamanca", new CityInfo("Salamanca", false, false, true, "España"));
        cities.put("Málaga", new CityInfo("Málaga", true, true, true, "España"));
        
        // Italia
        cities.put("Rome", new CityInfo("Rome", true, true, true, "Italia"));
        cities.put("Milan", new CityInfo("Milan", true, true, true, "Italia"));
        cities.put("Venice", new CityInfo("Venice", true, true, false, "Italia"));
        cities.put("Florence", new CityInfo("Florence", true, true, true, "Italia"));
        cities.put("Naples", new CityInfo("Naples", true, true, true, "Italia"));
        cities.put("Bologna", new CityInfo("Bologna", false, true, true, "Italia"));
        
        // Francia
        cities.put("Paris", new CityInfo("Paris", true, true, true, "Francia"));
        cities.put("Lyon", new CityInfo("Lyon", true, true, true, "Francia"));
        cities.put("Marseille", new CityInfo("Marseille", true, true, true, "Francia"));
        cities.put("Bordeaux", new CityInfo("Bordeaux", true, true, true, "Francia"));
        cities.put("Nice", new CityInfo("Nice", true, true, false, "Francia"));
        
        // Reino Unido
        cities.put("London", new CityInfo("London", true, true, true, "Reino Unido"));
        cities.put("Manchester", new CityInfo("Manchester", true, true, true, "Reino Unido"));
        cities.put("Edinburgh", new CityInfo("Edinburgh", true, true, true, "Reino Unido"));
        
        // Ciudades pequeñas sin aeropuerto
        cities.put("Cuenca", new CityInfo("Cuenca", false, false, true, "España"));
        cities.put("Ávila", new CityInfo("Ávila", false, false, true, "España"));
        cities.put("Segovia", new CityInfo("Segovia", false, false, true, "España"));
    }
    
    public boolean hasAirport(String city) {
        CityInfo info = cities.get(city);
        return info != null && info.hasAirport();
    }
    
    public boolean hasTrainStation(String city) {
        CityInfo info = cities.get(city);
        return info != null && info.hasTrainStation();
    }
    
    public boolean hasBusStation(String city) {
        CityInfo info = cities.get(city);
        return info != null && info.hasBusStation();
    }
    
    public CityInfo getCityInfo(String city) {
        return cities.get(city);
    }
    
    public boolean cityExists(String city) {
        return cities.containsKey(city);
    }
    
    public List<String> getAvailableTransportTypes(String city) {
        CityInfo info = cities.get(city);
        return info != null ? info.getAvailableTransportTypes() : new ArrayList<>();
    }
}