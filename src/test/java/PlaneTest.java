import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747);
    }

    @Test
    public void hasPlaneType() {
        assertEquals(PlaneType.BOEING747, plane.getPlaneType());
    }

    @Test
    public void canChangePlaneType() {
        plane.setPlaneType(PlaneType.AIRBUSA320);
        assertEquals(PlaneType.AIRBUSA320, plane.getPlaneType());
    }

}