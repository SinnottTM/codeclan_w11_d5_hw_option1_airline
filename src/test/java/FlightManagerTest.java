import org.junit.Before;
import org.junit.Test;


import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    FlightManager flightManager;
    Flight flight;
    Pilot pilot;
    CabinCrewMember crewMember1;
    CabinCrewMember crewMember2;
    ArrayList<CabinCrewMember> crewMembers;
    Plane plane;
    Passenger passenger;
    Bag bag;
    ArrayList<Bag> bags;
    LocalDateTime departureTime;



    @Before
    public void before(){
        pilot = new Pilot("Simon", Rank.CAPTAIN, "Simon259");
        plane = new Plane(PlaneType.BOEING747);
        crewMember1 = new CabinCrewMember("Laura", Rank.FLIGHTATTENDANT);
        crewMember2 = new CabinCrewMember("Teemo", Rank.FLIGHTATTENDANT);
        crewMembers = new ArrayList<CabinCrewMember>();
        crewMembers.add(crewMember1);
        crewMembers.add(crewMember2);
        bag = new Bag(20.00);
        bags = new ArrayList<Bag>();
        bags.add(bag);
        passenger = new Passenger("Mr. Passenger", bags);
        departureTime = LocalDateTime.of(2017, 2, 13, 15, 56);

        flight = new Flight(
                pilot,
                crewMembers,
                plane,
                "LDN-EDI-123",
                "LDN",
                "EDI",
                departureTime);
        flightManager = new FlightManager(flight);
    }

    @Test
    public void canCalculateWeightLimitPerPassenger() {
        assertEquals(5.0, flightManager.getWeightAllowancePerPassenger(), 0.01);
    }

    @Test
    public void canGetTotalBaggageWeightForAllPassengers() {
        Passenger passenger2 = new Passenger("Mylo", bags);
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger2);
        assertEquals(40.00, flightManager.getTotalLuggageWeight(), 0.01);
    }

    @Test
    public void canReturnRemainingWeightCapacity() {
        Passenger passenger2 = new Passenger("Mylo", bags);
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger2);
        assertEquals(1960, flightManager.getRemainingWeightCapacity(), 0.01);

    }
}