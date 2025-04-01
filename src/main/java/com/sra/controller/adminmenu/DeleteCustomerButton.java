package com.sra.controller.adminmenu;

import com.sra.controller.Command;
import com.sra.controller.MenuButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DeleteCustomerButton implements MenuButton {


    private final DeleteCustomerCommand deleteCustomerCommand;

    @Autowired
    public DeleteCustomerButton(DeleteCustomerCommand deleteCustomerCommand) {
        this.deleteCustomerCommand = deleteCustomerCommand;
    }

    @Override
    public void onPush() throws IOException {
        deleteCustomerCommand.execute();
    }

    @Override
    public void show() {
        System.out.println(". Delete existing customer");
    }

    @Override
    public Command getCommand() {
        return deleteCustomerCommand;
    }
}
