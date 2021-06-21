package tdd.practice.parkinglot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {
    @Test
    public void parkingLotGetTest() {
        ParkingLot lot = new ParkingLot(20, 2, 20, 24);

        lot.park("ABC1234", "Red");

        int expected = 1;
        int actual = lot.getSlot("ABC1234");

        assertEquals("ParkingLot empty park should park car in slot 1", expected, actual);
    }

    @Test
    public void parkingLotLeaveTest() {
        ParkingLot lot = new ParkingLot(20, 2, 20, 24);

        String id = lot.park("ABC1234", "Red");
        lot.leave(id);

        int expected = -1;
        int actual = lot.getSlot("ABC1234");

        assertEquals("ParkingLot leave method should remove car", expected, actual);
    }

    @Test
    public void parkingLotGetPlatesOfColorTest() {
        ParkingLot lot = new ParkingLot(20, 2, 20, 24);

        lot.park("ABC1234", "Red");
        lot.park("QWERTY1", "Red");

        List<String> expected = new ArrayList<String>();
        expected.add("ABC1234");
        expected.add("QWERTY1");
        List<String> actual = lot.getPlates("Red");

        assertEquals("ParkingLot getPlates method should get all plates of a color", expected, actual);
    }

    @Test
    public void parkingLotGetSlotsOfColorTest() {
        ParkingLot lot = new ParkingLot(20, 2, 20, 24);

        lot.park("ABC1234", "Red");
        String id = lot.park("QWERTY1", "Red");
        lot.park("JAVAJVM", "BLUE");
        lot.park("APPLE23", "Red");
        lot.leave(id);

        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(4);
        List<Integer> actual = lot.getSlots("Red");

        assertEquals("ParkingLot getSlots method should get all slots of a color", expected, actual);
    }
}
