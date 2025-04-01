package com.sra.controller.adminmenu;

import com.sra.config.Config;
import com.sra.controller.Menu;
import com.sra.controller.MenuButton;
import com.sra.util.UtilitiesToolSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class AdminMenu implements Menu {

    private final UtilitiesToolSet utilitiesToolSet;
    private final AdminMenuButtonsList adminMenuButtonsList;

    @Autowired
    AdminMenu(UtilitiesToolSet utilitiesToolSet, AdminMenuButtonsList adminMenuButtonsList) {
        this.utilitiesToolSet = utilitiesToolSet;
        this.adminMenuButtonsList = adminMenuButtonsList;
    }

    @Override
    public void startMenu() throws IOException {
        System.out.println("Administrator, what would you like me to do?");
        List<MenuButton> list = adminMenuButtonsList.get();
        for (MenuButton menuButton : list) {
            System.out.print(list.indexOf(menuButton)+1);
            menuButton.show();
        }
        MenuButton pushedButton = null;
        String userInput = utilitiesToolSet.getReader().readLine();
        if (utilitiesToolSet.getMenuInputValidator().isValidMenuInput(userInput, adminMenuButtonsList.get())) {
            pushedButton = adminMenuButtonsList.get().get(Integer.parseInt(userInput)-1);
            pushedButton.onPush();
            if (pushedButton.getCommand().returnToMenuAfterExecution()) startMenu();
        }
        else {
            System.out.println(Config.RED_COLOUR + "Wrong input! Please choose one of the options" + Config.RESET_COLOUR);
            this.startMenu();
        }
    }
}

