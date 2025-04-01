package com.sra.controller.adminmenu;

import com.sra.controller.Command;
import com.sra.util.listviewers.CustomerListViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ShowCustomersCommand implements Command {

    private final CustomerListViewer customerListViewer;

    @Autowired
    ShowCustomersCommand(CustomerListViewer customerListViewer) {
        this.customerListViewer = customerListViewer;
    }

    public void execute() throws IOException {
       customerListViewer.printList();
    }

    @Override
    public boolean returnToMenuAfterExecution() {
        return true;
    }

}
