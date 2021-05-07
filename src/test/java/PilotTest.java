import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotTest {

    Pilot pilot;

    @Before
    public void before(){
        pilot = new Pilot("Simon", Rank.CAPTAIN, "Simon259");
    }

    @Test
    public void hasName() {
        assertEquals("Simon", pilot.getName());
    }

    @Test
    public void canChangeName() {
        pilot.setName("Teemo");
        assertEquals("Teemo", pilot.getName());
    }

    @Test
    public void hasRank() {
        assertEquals(Rank.CAPTAIN, pilot.getRank());
    }

    @Test
    public void canChangeRank() {
        pilot.setRank(Rank.FIRSTOFFICER);
        assertEquals(Rank.FIRSTOFFICER, pilot.getRank());
    }

    @Test
    public void hasLicenceNumber() {
        assertEquals("Simon259", pilot.getLicenceNumber());
    }

    @Test
    public void canChangeLicenceNumber() {
        pilot.setLicenceNumber("Teemo2345");
        assertEquals("Teemo2345", pilot.getLicenceNumber());
    }

    @Test
    public void pilotCanFlyPlane() {
        assertEquals("I'm flying the plane", pilot.flyPlane());
    }
}