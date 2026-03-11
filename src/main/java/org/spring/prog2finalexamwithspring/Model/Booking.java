package org.spring.prog2finalexamwithspring.Model;

import java.util.Date;
import java.util.Objects;

public class Booking {
    private Client client;
    private Room room;
    private Date date;

    public Booking(Client client, Room room, Date date) {
        this.client = client;
        this.room = room;
        this.date = date;
    }

    public Booking() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(client, booking.client) && Objects.equals(room, booking.room) && Objects.equals(date, booking.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, room, date);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "client=" + client +
                ", room=" + room +
                ", date=" + date +
                '}';
    }
}
