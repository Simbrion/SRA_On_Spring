package com.sra.controller.mainmenu;

import com.sra.controller.Command;
import com.sra.service.customeroperations.CustomerLogIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustLoginCommand implements Command {

    private final CustomerLogIn customerLogIn;

    @Autowired
    public CustLoginCommand(CustomerLogIn customerLogIn) {
        this.customerLogIn = customerLogIn;
    }

    @Override
    public void execute() throws IOException {
        customerLogIn.logIn();
    }

    @Override
    public boolean returnToMenuAfterExecution() {
        return false;
    }
}
