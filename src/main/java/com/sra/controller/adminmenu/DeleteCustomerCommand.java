package com.sra.controller.adminmenu;

import com.sra.controller.Command;
import com.sra.service.customeroperations.CustomerDeleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DeleteCustomerCommand implements Command {

    private final CustomerDeleter customerDeleter;

    @Autowired
    DeleteCustomerCommand(CustomerDeleter customerDeleter) {
        this.customerDeleter = customerDeleter;
    }

    public void execute() throws IOException {
        customerDeleter.start();
    }

    @Override
    public boolean returnToMenuAfterExecution() {
        return true;
    }

}
