package org.spring.prog2finalexamwithspring.Service;


import org.spring.prog2finalexamwithspring.Model.Booking;
import org.spring.prog2finalexamwithspring.Repository.BookingRepository;
import org.springframework.stereotype.Service;

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

}
