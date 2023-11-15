package pl.javastart.task;

import java.util.Arrays;

public class Ticket {
    private String eventName;
    private String place;
    private String ticketType;
    private double basePrice;
    private double discount;
    private static int count = 0;
    private int id;
    private static String[] ticketTypeList = {"Online", "Standard", "Gift"};

    public Ticket(String eventName, String place, String ticketType, boolean discount) {
        this.eventName = eventName;
        this.place = place;
        if (!Arrays.asList(ticketTypeList).contains(ticketType)) {
            throw new IllegalStateException("Nie można utworzyć biletu o podanym typie, dopuszczalne: Online, Standard, Gift");
        } else {
            this.ticketType = ticketType;
        }
        this.basePrice = 100;
        if (discount) {
            this.discount = 0.05;
        } else {
            this.discount = 0;
        }
        setId(++count);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getPlace() {
        return place;
    }

    public String getTicketType() {
        return ticketType;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getDiscount() {
        return discount;
    }

    public int getId() {
        return id;
    }
}