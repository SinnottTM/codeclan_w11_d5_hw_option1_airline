import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Flight {
    private Pilot pilot;
    private ArrayList<CabinCrewMember> cabinCrew;
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private LocalDateTime departureTime;
    private ArrayList<Integer> seatsRemaining;

    public Flight(Pilot pilot, ArrayList<CabinCrewMember> cabinCrew, Plane plane, String flightNumber, String destination, String departureAirport, LocalDateTime departureTime) {
        this.pilot = pilot;
        this.cabinCrew = cabinCrew;
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<Passenger>();
        this.seatsRemaining = new ArrayList<Integer>(this.plane.getCapacity());

    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public ArrayList<CabinCrewMember> getCabinCrew() {
        return cabinCrew;
    }

    public void setCabinCrew(ArrayList<CabinCrewMember> cabinCrew) {
        this.cabinCrew = cabinCrew;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public LocalDateTime getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void addCrewMember(CabinCrewMember crewMember) {
        this.cabinCrew.add(crewMember);
    }

    public void removeCrewMember(CabinCrewMember crewMember) {
        this.cabinCrew.remove(crewMember);
    }

    public int getNumberAvailableSeats() {
        return this.plane.getCapacity();
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void bookPassenger(Passenger passenger) {
        if (this.getNumberAvailableSeats() > 0){
            if (this.seatsRemaining.size() == 0){
                for (int i = 1; i <= this.plane.getCapacity(); i++){
                    this.seatsRemaining.add(i);
                }
            }
            Random rand = new Random();
            int randomSeat = rand.nextInt(this.seatsRemaining.size());
            passenger.setSeatNumber(this.seatsRemaining.remove(randomSeat));


            this.plane.reduceNumberOfAvailableSeats();
            this.passengers.add(passenger);
            passenger.setFlight(this);
        }

    }

    public void removePassenger(Passenger passenger) {
        this.passengers.remove(passenger);
        this.plane.increaseAvailableSeats();
        this.seatsRemaining.add(passenger.getSeatNumber());
    }

    public double getTotalBaggageWeight() {
        double totalWeight = 0;
        for (Passenger passenger : this.getPassengers()){
            totalWeight += passenger.getBaggageWeight();
        }
        return totalWeight;
    }

    public double getRemainingWeightCapacity() {
        double weightRemaining = this.plane.getWeightLimit();
        for (Passenger passenger : this.getPassengers()){
            weightRemaining -= passenger.getBaggageWeight();
        }
        return weightRemaining;

    }

    public ArrayList<Integer> getSeatsRemaining() {
        return this.seatsRemaining;
    }
}