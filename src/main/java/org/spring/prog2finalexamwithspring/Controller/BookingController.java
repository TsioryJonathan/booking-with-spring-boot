package org.spring.prog2finalexamwithspring.Controller;

import org.spring.prog2finalexamwithspring.Model.Booking;
import org.spring.prog2finalexamwithspring.Service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBooking(){
        return ResponseEntity.ok(bookingService.getAll());
    }

    @PostMapping
    public ResponseEntity<List<Booking>> createBookings(@RequestBody List<Booking> newBookings){
        return ResponseEntity.ok(bookingService.saveBooking(newBookings));
    }
}
