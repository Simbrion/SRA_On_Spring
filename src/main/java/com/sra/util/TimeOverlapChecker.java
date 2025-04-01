package com.sra.util;

import com.sra.model.Reservation;
import com.sra.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;

@Component
public class TimeOverlapChecker {

    private final ReservationsRepository reservationsRepository;

    @Autowired
    public TimeOverlapChecker (ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }

    public boolean startTimeOverlaps(LocalDateTime startOfNewReservation, Reservation newReservation) {
        if (reservationsRepository.isEmpty()) return false;
        for (Reservation existingReservation : reservationsRepository.getData()) {
            if (!(existingReservation.getSpace().equals(newReservation.getSpace()))) continue;
            LocalDateTime startOfExistingReservation = LocalDateTime.of(existingReservation.getDate(), existingReservation.getStartTime());
            LocalDateTime endOfExistingReservation = LocalDateTime.of(existingReservation.getDate(), existingReservation.getEndTime());
            if (startOfNewReservation.isAfter(startOfExistingReservation) && startOfNewReservation.isBefore(endOfExistingReservation)) return true;
            if (startOfNewReservation.isEqual(startOfExistingReservation) || startOfNewReservation.isEqual(endOfExistingReservation)) return true;
        }
        return false;
    }

    public boolean endTimeOverlaps(LocalDateTime endOfNewReservation, Reservation newReservation) {
        if (reservationsRepository.isEmpty()) return false;
        for (Reservation existingReservation : reservationsRepository.getData()) {
            if (!(existingReservation.getSpace().equals(newReservation.getSpace()))) continue;
            LocalDateTime startOfExistingReservation = LocalDateTime.of(existingReservation.getDate(), existingReservation.getStartTime());
            LocalDateTime endOfExistingReservation = LocalDateTime.of(existingReservation.getDate(), existingReservation.getEndTime());
            LocalDateTime startOfNewReservation = LocalDateTime.of(newReservation.getDate(), newReservation.getStartTime());
            if ((startOfNewReservation.isBefore(endOfExistingReservation)) && endOfNewReservation.isAfter(startOfExistingReservation)) return true;
            if ((endOfNewReservation.isEqual(startOfExistingReservation)) || (endOfNewReservation).isEqual(endOfExistingReservation)) return true;
        }
        return false;

    }
}
