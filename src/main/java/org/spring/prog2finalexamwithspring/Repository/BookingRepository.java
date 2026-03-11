package org.spring.prog2finalexamwithspring.Repository;

import org.spring.prog2finalexamwithspring.Config.DBConnection;
import org.spring.prog2finalexamwithspring.Model.Booking;
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
        String sql = """
                SELECT b.id , b.date, b.client_name, b.client_email , b.client_phone , b.room_number ,b.room_description
                from booking b
                order by b.id
                """;
        try(Connection con = dbConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
                ) {
            List<Booking> bookings = new ArrayList<>();
            while(rs.next()){
                Booking booking = new Booking();
                booking.setId(rs.getInt("id"));
                booking.setDate(rs.getDate("date"));
                booking.setClientName(rs.getString("client_name"));
                booking.setClientEmail(rs.getString("client_email"));
                booking.setClientPhone(rs.getString("client_phone"));
                booking.setRoomNumber(rs.getInt("room_number"));
                booking.setRoomDescription(rs.getString("room_description"));
                bookings.add(booking);
            }
            return bookings.isEmpty() ? new ArrayList<>() : bookings;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
