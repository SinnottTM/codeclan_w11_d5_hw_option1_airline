public class Plane {

    private PlaneType planeType;
    private int capacity;
    private int weightLimit;

    public Plane(PlaneType planeType) {
        this.planeType = planeType;
        this.capacity = planeType.getCapacity();
        this.weightLimit = planeType.getWeightLimit();
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public void setPlaneType(PlaneType planeType) {
        this.planeType = planeType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(int weightLimit) {
        this.weightLimit = weightLimit;
    }
    public void reduceNumberOfAvailableSeats(){
        this.capacity -= 1;
    }
    public void increaseAvailableSeats(){
        this.capacity += 1;
    }


    public double getBaggageAllowance() {
        return this.weightLimit / this.capacity;
    }
}