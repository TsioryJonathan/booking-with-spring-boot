package org.spring.prog2finalexamwithspring.Repository;

import org.spring.prog2finalexamwithspring.Config.DBConnection;
import org.spring.prog2finalexamwithspring.Model.Booking;
import org.spring.prog2finalexamwithspring.Model.Client;
import org.spring.prog2finalexamwithspring.Model.Room;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BookingRepository {
    private final DBConnection dbConnection;

    public BookingRepository(DBConnection dbConnection, DBConnection dBConnection) {
        this.dbConnection = dBConnection;
    }
    public List<Booking> findAll() {
        try(Connection con = dbConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM bookings");
            ResultSet rs = stmt.executeQuery()
                ) {
            List<Booking> bookings = new ArrayList<>();
            while(rs.next()){
                Client client= new Client();
                Room room = new Room();
                Booking booking = new Booking();
                booking.setClient(client);
                booking.setRoom(room);

                bookings.add(booking);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return null;
    }
}
