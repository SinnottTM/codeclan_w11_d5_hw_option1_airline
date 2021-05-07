public class FlightManager {
    private Flight flight;

    public FlightManager(Flight flight) {
        this.flight = flight;
    }

    public double getWeightAllowancePerPassenger() {
        return this.flight.getPlane().getBaggageAllowance();
    }

    public double getTotalLuggageWeight() {
        return this.flight.getTotalBaggageWeight();
    }

    public double getRemainingWeightCapacity() {
        return this.flight.getRemainingWeightCapacity();
    }
}