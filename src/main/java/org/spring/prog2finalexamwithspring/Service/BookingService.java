package org.spring.prog2finalexamwithspring.Service;


import org.spring.prog2finalexamwithspring.Exception.RoomAlreadyBookedException;
import org.spring.prog2finalexamwithspring.Exception.RoomNumberNotValidException;
import org.spring.prog2finalexamwithspring.Model.Booking;
import org.spring.prog2finalexamwithspring.Repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAll(){
        return bookingRepository.findAll();
    }
    public List<Booking> saveBooking(List<Booking> bookings) throws SQLException {
        for(Booking booking : bookings){
            if(booking.getRoomNumber() > 9 || booking.getRoomNumber() < 1){
                throw new RoomNumberNotValidException("Room number must be between 1 and 9");
            }
            if(!bookingRepository.isRoomAvailable((Integer) booking.getRoomNumber(), booking.getDate())){
                throw new RoomAlreadyBookedException("Room " + booking.getRoomNumber() + " is already booked for date " + booking.getDate());
            }
        }
        return bookingRepository.saveBooking(bookings);
    }
}
