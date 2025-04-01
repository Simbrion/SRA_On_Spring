package com.sra.controller.adminmenu;

import com.sra.controller.Command;
import com.sra.util.listviewers.ReservationsListViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ShowReservationsCommand implements Command {

    private final ReservationsListViewer reservationsListViewer;

    @Autowired
    ShowReservationsCommand(ReservationsListViewer reservationsListViewer) {
        this.reservationsListViewer = reservationsListViewer;
    }

    public void execute() throws IOException {
       reservationsListViewer.printList();
    }

    @Override
    public boolean returnToMenuAfterExecution() {
        return true;
    }

}
