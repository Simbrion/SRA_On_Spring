package com.sra.controller.customermenu;

import com.sra.config.Config;
import com.sra.controller.LoggenInCommand;
import com.sra.model.Customer;
import com.sra.util.listviewers.ReservationsListViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ShowMyReservationsCommand implements LoggenInCommand {

    private final ReservationsListViewer reservationsListViewer;

    @Autowired
    ShowMyReservationsCommand(ReservationsListViewer reservationsListViewer) {
        this.reservationsListViewer = reservationsListViewer;
    }

    @Override
    public void execute() throws UnsupportedOperationException {
        System.out.println(Config.RED_COLOUR + "Execute method in " + this.getClass() + " class invoked without logged in Customer passed as a parameter!" + Config.RESET_COLOUR);
        throw new UnsupportedOperationException();
    }

    @Override
    public void execute(Customer customer) throws IOException {
        reservationsListViewer.printCustomerReservationsList(customer);
    }

    @Override
    public boolean returnToMenuAfterExecution() {
        return true;
    }


}
