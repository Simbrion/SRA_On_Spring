package com.sra.controller.adminmenu;

import com.sra.controller.Command;
import com.sra.controller.MenuButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AdminBackToLoginButton implements MenuButton {


    private AdminBackToLoginCommand adminBackToLoginCommand;

    @Autowired
    public void setAdminBackToLoginCommand(AdminBackToLoginCommand adminBackToLoginCommand) {
        this.adminBackToLoginCommand = adminBackToLoginCommand;
    }

    @Override
    public void onPush() throws IOException {
        adminBackToLoginCommand.execute();
    }

    @Override
    public void show() {
        System.out.println(". Back to login menu");
    }

    @Override
    public Command getCommand() {
        return adminBackToLoginCommand;
    }
}
