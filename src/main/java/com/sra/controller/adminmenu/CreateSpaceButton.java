package com.sra.controller.adminmenu;

import com.sra.controller.Command;
import com.sra.controller.MenuButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CreateSpaceButton implements MenuButton {

    private final CreateSpaceCommand createSpaceCommand;

    @Autowired
    public CreateSpaceButton(CreateSpaceCommand createSpaceCommand) {
        this.createSpaceCommand = createSpaceCommand;
    }

    @Override
    public void onPush() throws IOException {
        createSpaceCommand.execute();
    }

    @Override
    public void show() {
        System.out.println(". Create new space");
    }

    @Override
    public Command getCommand() {
        return createSpaceCommand;
    }
}
