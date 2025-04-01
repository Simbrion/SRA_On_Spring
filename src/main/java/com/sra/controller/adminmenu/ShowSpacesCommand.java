package com.sra.controller.adminmenu;

import com.sra.controller.Command;
import com.sra.util.listviewers.SpaceListViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowSpacesCommand implements Command {

    private final SpaceListViewer spaceListViewer;

    @Autowired
    ShowSpacesCommand (SpaceListViewer spaceListViewer) {
        this.spaceListViewer = spaceListViewer;
    }

    public void execute() {
        spaceListViewer.printList();
    }

    @Override
    public boolean returnToMenuAfterExecution() {
        return true;
    }

}
