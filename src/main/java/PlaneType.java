public enum PlaneType {

    BOEING747(400, 2000),
    BOEING737(200, 1000),
    AIRBUSA330(300, 1500),
    AIRBUSA320(200, 1000),
    PRIVATEJET(5, 20);


    private final int capacity;
    private final int weightLimit;

    PlaneType(int capacity, int weightLimit) {
        this.capacity = capacity;
        this.weightLimit = weightLimit;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWeightLimit() {
        return weightLimit;
    }
}