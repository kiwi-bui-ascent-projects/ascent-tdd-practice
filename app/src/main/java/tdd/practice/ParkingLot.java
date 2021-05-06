package tdd.practice;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingLot {
    private boolean full;
    private Ticket[] slots;
    private int hourlyFee;
    private int dailyFee;
    private int dailyFeeHourLimit;

    public ParkingLot(int slots, int hourFee, int dailyFee, int dailyFeeHourLimit) {
        this.slots = new Ticket[slots];
        this.full = false;
        this.hourlyFee = hourFee;
        this.dailyFee = dailyFee;
        this.dailyFeeHourLimit = dailyFeeHourLimit;
    }

    public String park(String plate, String color) {
        if (this.full) {
            return "FULL";
        }

        boolean parked = false;
        String id = "";

        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i] == null) {
                this.slots[i] = new Ticket(LocalDateTime.now(), plate, color);
                parked = true;
                id = this.slots[i].getID();
                break;
            }
        }

        if (!parked) {
            this.full = true;
            return "FULL";
        } else {
            return id;
        }
    }

    public int getSlot(String plate) {
        int i;

        for (i = 0; i < this.slots.length; i++) {
            if (this.slots[i] != null && this.slots[i].getPlate() == plate) {
                return i + 1;
            }
        }

        return -1;
    }

    public int leave(String id) {
        int fee = 0;
        long hours = 0;

        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i] != null && this.slots[i].getID() == id) {
                hours = Duration.between(this.slots[i].getTime(), LocalDateTime.now()).toHours();
                this.slots[i] = null;
                break;
            }
        }

        System.out.println(hours);

        if (hours > 1) {
            if (hours >= this.dailyFeeHourLimit) {
                double days = Math.floor(hours / this.dailyFeeHourLimit);
                double hoursLeft = hours % this.dailyFeeHourLimit;
                fee += (days * this.dailyFee);
                fee += (hoursLeft + 1) * this.hourlyFee;
            } else {
                fee += (hours + 1) * this.hourlyFee;
            }
        }

        return fee;
    }
}
