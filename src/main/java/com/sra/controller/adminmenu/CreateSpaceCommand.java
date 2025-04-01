package com.sra.controller.adminmenu;

import com.sra.controller.Command;
import com.sra.service.spaceoperations.SpaceCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CreateSpaceCommand implements Command {

    private final SpaceCreator spaceCreator;

    @Autowired
    CreateSpaceCommand(SpaceCreator spaceCreator) {
        this.spaceCreator = spaceCreator;
    }

    public void execute() throws IOException {
        spaceCreator.start();
    }

    @Override
    public boolean returnToMenuAfterExecution() {
        return true;
    }

}
