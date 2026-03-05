package Composite.model;

public class Device extends Consumer {
    private double consumptionPerHour;  // consumo por hora en kWh
    private double estimatedHours;      // horas estimadas de uso

    public Device(double consumptionPerHour, double estimatedHours) {
        this.consumptionPerHour = consumptionPerHour;
        this.estimatedHours = estimatedHours;
    }

    @Override
    public double calcExpenses() {
        return consumptionPerHour * estimatedHours;
    }

    public double getConsumptionPerHour() {
        return consumptionPerHour;
    }

    public void setConsumptionPerHour(double consumptionPerHour) {
        this.consumptionPerHour = consumptionPerHour;
    }

    public double getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(double estimatedHours) {
        this.estimatedHours = estimatedHours;
    }
}