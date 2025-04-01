package com.sra.controller.adminmenu;

import com.sra.controller.Command;
import com.sra.controller.MenuButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ShowCustomersButton implements MenuButton {

    private final ShowCustomersCommand showCustomersCommand;

    @Autowired
    public ShowCustomersButton(ShowCustomersCommand showCustomersCommand) {
        this.showCustomersCommand = showCustomersCommand;
    }

    @Override
    public void onPush() throws IOException {
        showCustomersCommand.execute();
    }

    @Override
    public void show() {
        System.out.println(". Show existing customers");
    }

    @Override
    public Command getCommand() {
        return showCustomersCommand;
    }
}
