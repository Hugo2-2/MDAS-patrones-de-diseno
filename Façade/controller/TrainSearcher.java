package Façade.controller;

import Façade.model.Train;
import java.util.ArrayList;
import java.util.List;

public class TrainSearcher {
    private List<Train> availableTrains;

    public TrainSearcher() {
        this.availableTrains = new ArrayList<>();
        // Trenes de ejemplo
        availableTrains.add(new Train("Madrid", "Barcelona", "2026-05-10", "2026-05-15", 45.00, "Ouigo"));
        availableTrains.add(new Train("Madrid", "Rome", "2026-05-10", "2026-05-15", 250.00, "EuroMed Express"));
    }

    //Método que sera invocado por Façade
    public List<Train> searchTrains(String origin, String destination, String startDate, String endDate) {
        List<Train> results = new ArrayList<>();

        for (Train train : availableTrains) {
            if (train.getOrigin().equalsIgnoreCase(origin) &&
                    train.getDestination().equalsIgnoreCase(destination) &&
                    train.getStartDate().equals(startDate) &&
                    train.getEndDate().equals(endDate)) {

                results.add(train);
            }
        }
        return results;
    }
}
