package com.sra.controller.customermenu;

import com.sra.config.Config;
import com.sra.controller.Command;
import com.sra.controller.LoggedInMenuButton;
import com.sra.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CancelReservationButton implements LoggedInMenuButton {

    private final CancelReservationCommand cancelReservationCommand;

    @Autowired
    public CancelReservationButton(CancelReservationCommand cancelReservationCommand) {
        this.cancelReservationCommand = cancelReservationCommand;
    }

    @Override
    public void onPush(Customer customer) throws IOException {
        cancelReservationCommand.execute(customer);
    }

    @Override
    public void onPush() throws UnsupportedOperationException {
        System.out.println(Config.RED_COLOUR + "OnPush method in " + this.getClass() + " class invoked without logged in Customer passed as a parameter!" + Config.RESET_COLOUR);
        throw new UnsupportedOperationException();
    }

    @Override
    public void show() {
        System.out.println(". Cancel my reservation");
    }

    @Override
    public Command getCommand() {
        return cancelReservationCommand;
    }

}
