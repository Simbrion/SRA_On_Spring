package com.sra.controller.adminmenu;

import com.sra.controller.Command;
import com.sra.service.spaceoperations.SpaceDeleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DeleteSpaceCommand implements Command {

    private final SpaceDeleter spaceDeleter;

    @Autowired
    DeleteSpaceCommand(SpaceDeleter spaceDeleter) {
        this.spaceDeleter = spaceDeleter;
    }

    public void execute() throws IOException {
        spaceDeleter.start();
    }

    @Override
    public boolean returnToMenuAfterExecution() {
        return true;
    }

}
