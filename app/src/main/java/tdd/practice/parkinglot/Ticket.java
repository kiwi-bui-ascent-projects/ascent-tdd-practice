package tdd.practice.parkinglot;

import java.time.LocalDateTime;

public class Ticket {

    private LocalDateTime time;
    private String plate;
    private String color;
    private String ID;

    public Ticket(LocalDateTime time, String plate, String color) {
        this.time = time;
        this.plate = plate;
        this.color = color;
        this.ID = RandomString.get();
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    public String getPlate() {
        return this.plate;
    }

    public String getColor() {
        return this.color;
    }

    public String getID() {
        return this.ID;
    }
}
