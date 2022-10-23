package de.marshal.tickets;

public class Ticket {
    private Route route;
    private MyDateTime time;
    private double price;

    public Ticket(Route route, MyDateTime time, double price) {
        this.route = route;
        this.time = time;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public Route getRoute() {
        return route;
    }

    public void setTime(MyDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "route=" + route +
                ", time=" + time +
                ", price=" + price +
                '}';
    }
}
