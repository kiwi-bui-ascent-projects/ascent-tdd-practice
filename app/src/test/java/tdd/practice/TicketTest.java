package tdd.practice;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TicketTest {
    @Test
    public void ticketGetTimeTest() {
        LocalDateTime time = LocalDateTime.now();

        Ticket ticket = new Ticket(time, "ABC1234", "Red");

        LocalDateTime actual = ticket.getTime();

        assertEquals("Ticket getTime should return time", time, actual);

    }

    @Test
    public void ticketGetPlateTest() {
        Ticket ticket = new Ticket(LocalDateTime.now(), "ABC1234", "Red");

        String expected = "ABC1234";
        String actual = ticket.getPlate();

        assertEquals("Ticket getPlate should return plate", expected, actual);

    }

    @Test
    public void ticketGetColorTest() {
        Ticket ticket = new Ticket(LocalDateTime.now(), "ABC1234", "Red");

        String expected = "Red";
        String actual = ticket.getColor();

        assertEquals("Ticket getColor should return color", expected, actual);

    }

    @Test
    public void ticketGetIDTest() {
        Ticket ticket = new Ticket(LocalDateTime.now(), "ABC1234", "Red");

        String actual = ticket.getID();

        assertNotNull("Ticket getID should return ID", actual);

    }
}
