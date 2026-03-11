package org.spring.prog2finalexamwithspring.Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Booking {
    private Integer id;
    private LocalDate date;
    private String clientName;
    private String clientEmail;
    private String clientPhone;
    private Integer roomNumber;
    private String roomDescription;

    public Booking() {
    }

    public Booking(Integer id, LocalDate date, String clientName, String clientEmail, String clientPhone, Integer roomNumber, String roomDescription) {
        this.id = id;
        this.date = date;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
        this.roomNumber = roomNumber;
        this.roomDescription = roomDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(roomNumber, booking.roomNumber) && Objects.equals(date, booking.date) && Objects.equals(clientName, booking.clientName) && Objects.equals(clientEmail, booking.clientEmail) && Objects.equals(clientPhone, booking.clientPhone) && Objects.equals(roomDescription, booking.roomDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, clientName, clientEmail, clientPhone, roomNumber, roomDescription);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", date=" + date +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", clientPhone='" + clientPhone + '\'' +
                ", roomNumber=" + roomNumber +
                ", roomDescription='" + roomDescription + '\'' +
                '}';
    }
}
