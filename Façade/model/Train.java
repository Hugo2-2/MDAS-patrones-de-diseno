package Façade.model;

public class Train extends Transport {
    private String trainCompany;

    public Train(String origin, String destination, String StartDate, String EndDate, double price, String trainCompany) {
        super(origin, destination, StartDate, EndDate,  price);
        this.trainCompany = trainCompany;
    }

    @Override
    public String toString() {
        return "[TRAIN - " + trainCompany + "] " + super.toString();
    }
}
