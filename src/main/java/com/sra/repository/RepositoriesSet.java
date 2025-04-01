package com.sra.repository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class RepositoriesSet {


    private final CustomersDataRepository customersDataRepository;
    private final ReservationsRepository reservationsRepository;
    private final SpacesDataRepository spacesDataRepository;

    @Autowired
    public RepositoriesSet (CustomersDataRepository customersDataRepository,
                            ReservationsRepository reservationsRepository,
                            SpacesDataRepository spacesDataRepository) {
        this.customersDataRepository = customersDataRepository;
        this.reservationsRepository = reservationsRepository;
        this.spacesDataRepository = spacesDataRepository;
    }

    public CustomersDataRepository getCustomersDataRepository() {
        return customersDataRepository;
    }

    public ReservationsRepository getReservationsRepository() {
        return reservationsRepository;
    }

    public SpacesDataRepository getSpacesDataRepository() {
        return spacesDataRepository;
    }


}
