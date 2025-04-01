package com.sra.controller.mainmenu;

import com.sra.controller.Command;
import com.sra.controller.MenuButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MainMenuAdminLoginButton implements MenuButton {

    private final AdminLoginCommand adminLoginCommand;

    @Autowired
    public MainMenuAdminLoginButton (AdminLoginCommand adminLoginCommand) {
        this.adminLoginCommand =   adminLoginCommand;
    }

    @Override
    public void onPush() throws IOException {
        adminLoginCommand.execute();
    }

    @Override
    public void show() {
        System.out.println(". Administrator");
    }

    @Override
    public Command getCommand() {
        return adminLoginCommand;
    }


}
