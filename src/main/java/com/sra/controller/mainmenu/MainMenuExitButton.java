package com.sra.controller.mainmenu;

import com.sra.controller.Command;
import com.sra.controller.ExitCommand;
import com.sra.controller.MenuButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MainMenuExitButton implements MenuButton {

   private final ExitCommand exitCommand;

   @Autowired
   public MainMenuExitButton (ExitCommand exitCommand) {
       this.exitCommand = exitCommand;
   }

    @Override
    public void onPush() throws IOException {
        exitCommand.execute();
    }

    @Override
    public void show() {
        System.out.println(". Exit");
    }

    @Override
    public Command getCommand() {
        return exitCommand;
    }
}
