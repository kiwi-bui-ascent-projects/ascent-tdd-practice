package tdd.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {
    @Test
    public void parkingLotGetTest() {
        ParkingLot lot = new ParkingLot(20, 2, 20, 24);

        String id = lot.park("ABC1234", "Red");

        int expected = 1;
        int actual = lot.getSlot("ABC1234");

        assertEquals("ParkingLot empty park should park car in slot 1", expected, actual);
    }

    @Test
    public void parkingLotLeaveTest() {
        ParkingLot lot = new ParkingLot(20, 2, 20, 24);

        String id = lot.park("ABC1234", "Red");
        int fee = lot.leave(id);

        int expected = -1;
        int actual = lot.getSlot("ABC1234");

        assertEquals("ParkingLot leave method should remove car", expected, actual);
    }

    @Test
    public void parkingLotGetPlatesOfColorTest() {
        ParkingLot lot = new ParkingLot(20, 2, 20, 24);

        String id = lot.park("ABC1234", "Red");
        String idTwo = lot.park("QWERTY1", "Red");

        String expected = "{\"ABC1234\", \"QWERTY1\"}";
        String actual = lot.getPlates("Red");

        assertEquals("ParkingLot getPlates method should get all plates of a color", expected, actual);
    }

    @Test
    public void parkingLotGetSlotsOfColorTest() {
        ParkingLot lot = new ParkingLot(20, 2, 20, 24);

        String id = lot.park("ABC1234", "Red");
        String idTwo = lot.park("QWERTY1", "Red");
        String idThree = lot.park("JAVAJVM", "BLUE");
        String idFour = lot.park("APPLE23", "Red");
        int fee = lot.leave(idTwo);

        String expected = "{\"1\", \"4\"}";
        String actual = lot.getSlots("Red");

        assertEquals("ParkingLot getSlots method should get all slots of a color", expected, actual);
    }
}
