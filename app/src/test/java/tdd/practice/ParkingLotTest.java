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
}
