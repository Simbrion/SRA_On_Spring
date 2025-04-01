package com.sra.controller.customermenu;

import com.sra.config.Config;
import com.sra.controller.LoggenInCommand;
import com.sra.controller.MainMenuNavigator;
import com.sra.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomerBackToLoginCommand implements LoggenInCommand {

    private MainMenuNavigator mainMenuNavigator;

    @Autowired
    public void setMainMenu(MainMenuNavigator mainMenuNavigator) {
        this.mainMenuNavigator = mainMenuNavigator;
    }

    @Override
    public void execute() throws UnsupportedOperationException {
        System.out.println(Config.RED_COLOUR + "Execute method in " + this.getClass() + " class invoked without logged in Customer passed as a parameter!" + Config.RESET_COLOUR);
        throw new UnsupportedOperationException();
    }

    @Override
    public void execute(Customer customer) throws IOException {
        mainMenuNavigator.navigate();
    }

    @Override
    public boolean returnToMenuAfterExecution() {
        return false;
    }


}
