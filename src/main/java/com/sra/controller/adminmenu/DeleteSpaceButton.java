package com.sra.controller.adminmenu;

import com.sra.controller.Command;
import com.sra.controller.MenuButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DeleteSpaceButton implements MenuButton {

    private final DeleteSpaceCommand deleteSpaceCommand;

    @Autowired
    public DeleteSpaceButton(DeleteSpaceCommand deleteSpaceCommand) {
        this.deleteSpaceCommand = deleteSpaceCommand;
    }

    @Override
    public void onPush() throws IOException {
        deleteSpaceCommand.execute();
    }

    @Override
    public void show() {
        System.out.println(". Delete an existing space");
    }

    @Override
    public Command getCommand() {
        return deleteSpaceCommand;
    }
}
