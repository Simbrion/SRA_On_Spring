package com.sra.controller.mainmenu;

import com.sra.controller.Command;
import com.sra.controller.adminmenu.AdminMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AdminLoginCommand implements Command {

    private AdminMenu adminMenu;

    @Lazy
    @Autowired
    public void setAdminMenu(AdminMenu adminMenu) {
        this.adminMenu = adminMenu;
    }

    @Override
    public void execute() throws IOException {
        adminMenu.startMenu();
    }

    @Override
    public boolean returnToMenuAfterExecution() {
        return false;
    }

}
