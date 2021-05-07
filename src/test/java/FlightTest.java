import org.junit.Before;
import org.junit.Test;


import java.time.LocalDateTime;
import java.util.ArrayList;


import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Pilot pilot;
    CabinCrewMember crewMember1;
    CabinCrewMember crewMember2;
    ArrayList<CabinCrewMember> crewMembers;
    Plane plane;
    Passenger passenger;
    Bag bag;
    ArrayList<Bag> bags;
    LocalDateTime localDateTime;



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
        localDateTime = LocalDateTime.of(2017, 2, 13, 15, 56);

        flight = new Flight(
                pilot,
                crewMembers,
                plane,
                "LDN-EDI-123",
                "LDN",
                "EDI",
                localDateTime
        );
    }

    @Test
    public void hasPilot() {
        assertEquals(pilot, flight.getPilot());
    }

    @Test
    public void canChangePilot() {
        Pilot pilot2 = new Pilot("Teemo", Rank.FIRSTOFFICER, "Teemo123");
        flight.setPilot(pilot2);
        assertEquals(pilot2, flight.getPilot());
    }

    @Test
    public void hasCrewMembers() {
        assertEquals(2, flight.getCabinCrew().size());
    }

    @Test
    public void canAddCabinCrew() {
        CabinCrewMember crewMember3 = new CabinCrewMember("Mylo", Rank.FLIGHTATTENDANT);
        flight.addCrewMember(crewMember3);
        assertEquals(3, flight.getCabinCrew().size());
    }

    @Test
    public void canRemoveCabinCrew() {
        flight.removeCrewMember(crewMember2);
        assertEquals(1, flight.getCabinCrew().size());
    }

    @Test
    public void hasPlane() {
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void canChangePlane() {
        Plane plane2 = new Plane(PlaneType.BOEING747);
        flight.setPlane(plane2);
        assertEquals(plane2, flight.getPlane());
    }

    @Test
    public void hasFlightNumber() {
        assertEquals("LDN-EDI-123", flight.getFlightNumber());
    }

    @Test
    public void canChangeFlightNumber() {
        flight.setFlightNumber("EDI-LDN-123");
        assertEquals("EDI-LDN-123", flight.getFlightNumber());
    }

    @Test
    public void hasDestination() {
        assertEquals("LDN", flight.getDestination());
    }

    @Test
    public void canChangeDestination() {
        flight.setDestination("GLW");
        assertEquals("GLW", flight.getDestination());
    }

    @Test
    public void hasDepartureAirport() {
        assertEquals("EDI", flight.getDepartureAirport());
    }

    @Test
    public void canChangeDepartureAirport() {
        flight.setDepartureAirport("GLW");
        assertEquals("GLW", flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime() {
        assertEquals("2017-02-13T15:56", flight.getDepartureTime().toString());
    }

    @Test
    public void canChangeDepartureTime() {
        LocalDateTime newDepartureTime = LocalDateTime.of(2017, 2, 13, 15, 56);
        flight.setDepartureTime(newDepartureTime);
        assertEquals("2017-02-13T15:56", flight.getDepartureTime().toString());
    }

    @Test
    public void canReturnAvailableSeats() {
        assertEquals(400, flight.getNumberAvailableSeats());
    }

    @Test
    public void hasPassengers() {
        assertEquals(0, flight.getPassengers().size());
    }

    @Test
    public void canAddPassenger() {
        flight.bookPassenger(passenger);
        assertEquals(1, flight.getPassengers().size());
    }

    @Test
    public void canRemovePassenger() {
        flight.bookPassenger(passenger);
        flight.removePassenger(passenger);
        assertEquals(0, flight.getPassengers().size());
    }

    @Test
    public void bookingPassengerReducesAvailableSeats() {
        flight.bookPassenger(passenger);
        assertEquals(399, flight.getNumberAvailableSeats());
    }

    @Test
    public void removingPassengerIncreasesAvailableSeats() {
        flight.bookPassenger(passenger);
        flight.removePassenger(passenger);
        assertEquals(400, flight.getNumberAvailableSeats());
    }

    @Test
    public void pilotCanFLyPlane() {
        assertEquals("I'm flying the plane", flight.getPilot().flyPlane());
    }

    @Test
    public void canGetBaggageWeightPerPassenger() {
        assertEquals(5.00, flight.getPlane().getBaggageAllowance(), 0.01);
    }

    @Test
    public void canGetTotalBaggageWeightForAllPassengers() {
        Passenger passenger2 = new Passenger("Mrs. Passenger", bags);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger);
        assertEquals(40.00, flight.getTotalBaggageWeight(), 0.01);
    }

    @Test
    public void canGetRemainingWeightCapacity() {
        Passenger passenger2 = new Passenger("Mrs. Passenger", bags);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger);
        assertEquals(1960.00, flight.getRemainingWeightCapacity(), 0.01);
    }

    @Test
    public void passengerIsAssignedFlightOnBooking() {
        flight.bookPassenger(passenger);
        assertEquals(flight, passenger.getFlight());

    }

    @Test
    public void flightHasArrayOfRemainingSeats() {
        assertEquals(0, flight.getSeatsRemaining().size());
    }

    @Test
    public void passengerIsAssignedSeatNumberWhenBooked() {
        flight.bookPassenger(passenger);
        assertEquals(399 , flight.getSeatsRemaining().size());
        assertEquals(true, passenger.getSeatNumber() != null);
    }

    @Test
    public void PassengersAreNotAssignedASeatAlreadyTakenByAnotherPassengerThatWasBookedOntoTheFlightEarlierThatDay() {
        Plane privatePlane = new Plane(PlaneType.PRIVATEJET);
        Flight privateFlight = new Flight(pilot, crewMembers ,privatePlane,"PRV123","EDI","LDN",localDateTime);
        Passenger passenger1 = new Passenger("Simon1", bags);
        Passenger passenger2 = new Passenger("Simon2", bags);
        Passenger passenger3 = new Passenger("Simon3", bags);
        Passenger passenger4 = new Passenger("Simon4", bags);
        Passenger passenger5 = new Passenger("Simon5", bags);
        privateFlight.bookPassenger(passenger1);
        privateFlight.bookPassenger(passenger2);
        privateFlight.bookPassenger(passenger3);
        privateFlight.bookPassenger(passenger4);
        privateFlight.bookPassenger(passenger5);
        assertEquals(0, privateFlight.getSeatsRemaining().size());

    }
}