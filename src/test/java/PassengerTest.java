import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;
    Bag bag;
    Bag bag2;
    ArrayList<Bag> bags;

    @Before

    public void before(){
        bag = new Bag(20.00);
        bag2 = new Bag(10.00);
        bags = new ArrayList<Bag>();
        bags.add(bag);
        passenger = new Passenger("Simon", bags);
    }

    @Test
    public void hasName() {
        assertEquals("Simon", passenger.getName());
    }

    @Test
    public void canChangeName() {
        passenger.setName("Teemo");
        assertEquals("Teemo", passenger.getName());
    }

    @Test
    public void hasBags() {
        assertEquals(1, passenger.getBags().size());
    }

    @Test
    public void getBaggageWeight() {
        bags.add(bag2);
        assertEquals(30.00, passenger.getBaggageWeight(), 0.01);

    }
}