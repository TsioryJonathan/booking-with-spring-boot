package org.spring.prog2finalexamwithspring.Repository;

import org.spring.prog2finalexamwithspring.Config.DBConnection;
import org.spring.prog2finalexamwithspring.Model.Booking;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
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
                booking.setDate(rs.getDate("date").toLocalDate());
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

    /* Check if room is available at Date d */
    public boolean isRoomAvailable(int roomNumber, LocalDate date) {
        String sql = """
                SELECT COUNT(id) AS count
                FROM booking
                WHERE room_number = ? AND date = ?
                """;
        try (Connection con = dbConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, roomNumber);
            stmt.setDate(2, date != null ? Date.valueOf(date) : null);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count == 0;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /* Save Booking*/
    public List<Booking> saveBooking(List<Booking> newList){
        String sql = """
                INSERT INTO booking (date, client_name, client_email, client_phone, room_number, room_description)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        try(Connection con = dbConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)
        ) {
            for (Booking booking : newList) {
                stmt.setDate(1, Date.valueOf(booking.getDate()));
                stmt.setString(2, booking.getClientName());
                stmt.setString(3, booking.getClientEmail());
                stmt.setString(4, booking.getClientPhone());
                stmt.setInt(5, booking.getRoomNumber());
                stmt.setString(6, booking.getRoomDescription());
                stmt.addBatch();
            }
            stmt.executeBatch();
            return newList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
