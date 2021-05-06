package tdd.practice.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
            // Can't use "==" for string comparison use getPlate().equals(plate)
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
            // Can't use "==" for string comparison use getPlate().equals(plate)
            if (this.slots[i] != null && this.slots[i].getID() == id) {
                hours = Duration.between(this.slots[i].getTime(), LocalDateTime.now()).toHours();
                this.slots[i] = null;
                break;
            }
        }

        // Remove your printlns before committing your code.  Consider using logging like sl4j if you want to preserve the info.
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

        // When someone leaves the lot, you should consider re-setting the "full" variable to false.
        // Alternatively, you could make full into a method call, that would check to see if you have any
        // open slots left.

        return fee;
    }

    public String getPlates(String color) {
        String result = "{";
        boolean hasResult = false;

        // You are trying to build your output string from within your processing logic.  I would
        // recomend that you just add the plates to a list, and then format the output at the end with a simple
        // foreach, or map operation

        // You could simplify this logic by using the enhanced for loop, which would look something like this.
        // It looks much cleaner this way.
//        for (int i = 0; i < this.slots.length; i++) {
                // getColor() == color won't work.  Strings must be compared with .equals, ie: ticket.getColor().equals(color)
//            if (this.slots[i] != null && this.slots[i].getColor() == color) {
//                result += "\"" + this.slots[i].getPlate() + "\", ";
//                hasResult = true;
//            }
//        }
        // Consider this way...
        //Processing Logic
        List<Ticket> oneColor = new ArrayList<>();
        for(Ticket ticket : slots ){
            if (ticket != null && ticket.getColor().equals(color)){
                oneColor.add(ticket);
            }
        }
        //Presentation logic - Method should probably just return either the java.util.List, or an array and leave the presentation to another module.
        StringBuilder sb = new StringBuilder("{");
        for (Ticket ticket : oneColor){
            if (sb.length()>2){
                // I would remove the requirement of the space after the comma
                sb.append(", ");
            }
            sb.append(String.format("\"%s\"", ticket.getPlate()));
        }
        sb.append("}");

        return sb.toString();
        // This could be done inside the for loop, and then just exit out of the loop using the break keyword
//        if (hasResult) {
//            result = result.substring(0, result.length() - 2);
//        }
//
//        result += "}";

//        return result;
    }

    public String getSlots(String color) {
        String result = "{";
        boolean hasResult = false;

        for (int i = 0; i < this.slots.length; i++) {
            // Can't use "==" for string comparison use getPlate().equals(plate)
            if (this.slots[i] != null && this.slots[i].getColor() == color) {
                // This is inefficient, use StringBuilder instead
                result += "\"" + (i + 1) + "\", ";
                hasResult = true;
            }
        }

        if (hasResult) {
            result = result.substring(0, result.length() - 2);

        }

        result += "}";

        return result;
    }
}
