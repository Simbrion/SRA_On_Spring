package com.sra.controller.adminmenu;

import com.sra.controller.Command;
import com.sra.controller.MainMenuNavigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AdminBackToLoginCommand implements Command {


    private MainMenuNavigator mainMenuNavigator;

    @Autowired
    public void setMainMenuNavigator(MainMenuNavigator mainMenuNavigator) {
        this.mainMenuNavigator = mainMenuNavigator;
    }


    public void execute() throws IOException {
        mainMenuNavigator.navigate();
    }

    @Override
    public boolean returnToMenuAfterExecution() {
        return false;
    }

}
