import java.util.ArrayList;

public class Passenger extends Person {
    private ArrayList<Bag> bags;
    private Flight flight;
    private Integer seatNumber;

    public Passenger(String name, ArrayList<Bag> bags) {
        super(name);
        this.bags = bags;
        this.flight = null;
        this.seatNumber = null;

    }

    public ArrayList<Bag> getBags() {
        return bags;
    }
    public double getBaggageWeight(){
        double totalWeight = 0.0;
        for (Bag bag : this.bags){
            totalWeight += bag.getWeight();
        }
        return totalWeight;
    }

    public void setBags(ArrayList<Bag> bags) {
        this.bags = bags;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }
}