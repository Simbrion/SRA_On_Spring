package com.sra.util.userinputvalidators;

import com.sra.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuInputValidator {

    private final PositiveDigitValidator positiveDigitValidator;
    private final InputValidator inputValidator;

    @Autowired
    public MenuInputValidator (PositiveDigitValidator positiveDigitValidator, InputValidator inputValidator) {
        this.positiveDigitValidator = positiveDigitValidator;
        this.inputValidator = inputValidator;
    }

    public boolean isValidMenuInput(String userInput, List<?> mainMenuButtonsList) {
        if (!inputValidator.validate(positiveDigitValidator, userInput)) {
            System.out.println(Config.WRONG_INPUT_MESSAGE);
            return false;
        }

        try {
            if (!mainMenuButtonsList.contains(mainMenuButtonsList.get(Integer.parseInt(userInput)-1))) {
                System.out.println(Config.WRONG_INPUT_MESSAGE);
                return false;
            }
        }
        catch (Exception e ) {
            return false;
        }
        return true;
    }

}
