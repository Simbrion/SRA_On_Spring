package com.sra.util;

import com.sra.util.listviewers.CustomerListViewer;
import com.sra.util.listviewers.ReservationsListViewer;
import com.sra.util.listviewers.SpaceListViewer;
import com.sra.util.userinputvalidators.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtilitiesToolSet {

    private final Reader reader;
    private final InputValidator inputValidator;
    private final MenuInputValidator menuInputValidator;
    private final CharsOrDigitsInputValidator charsOrDigitsInputValidator;
    private final PositiveDigitValidator positiveDigitValidator;
    private final TimeInputValidator timeInputValidator;
    private final DateInputValidator dateInputValidator;
    private final ReservationsListViewer reservationsListViewer;
    private final SpaceListViewer spaceListViewer;
    private final CustomerListViewer customerListViewer;
    private final TimeOverlapChecker timeOverlapChecker;

    @Autowired
    public UtilitiesToolSet(Reader reader,
                            InputValidator inputValidator,
                            MenuInputValidator menuInputValidator,
                            CharsOrDigitsInputValidator charsOrDigitsInputValidator,
                            PositiveDigitValidator positiveDigitValidator,
                            TimeInputValidator timeInputValidator,
                            DateInputValidator dateInputValidator,
                            ReservationsListViewer reservationsListViewer,
                            SpaceListViewer spaceListViewer,
                            CustomerListViewer customerListViewer,
                            TimeOverlapChecker timeOverlapChecker) {
        this.reader = reader;
        this.inputValidator = inputValidator;
        this.menuInputValidator = menuInputValidator;
        this.charsOrDigitsInputValidator = charsOrDigitsInputValidator;
        this.dateInputValidator = dateInputValidator;
        this.positiveDigitValidator = positiveDigitValidator;
        this.timeInputValidator = timeInputValidator;
        this.reservationsListViewer = reservationsListViewer;
        this.customerListViewer = customerListViewer;
        this.spaceListViewer = spaceListViewer;
        this.timeOverlapChecker = timeOverlapChecker;
    }

    public Reader getReader() {
        return reader;
    }

    public InputValidator getInputValidator() {
        return inputValidator;
    }

    public MenuInputValidator getMenuInputValidator() {
        return menuInputValidator;
    }

    public CharsOrDigitsInputValidator getCharsOrDigitsInputValidator() {
        return charsOrDigitsInputValidator;
    }

    public PositiveDigitValidator getPositiveDigitValidator() {
        return positiveDigitValidator;
    }

    public TimeInputValidator getTimeInputValidator() {
        return timeInputValidator;
    }

    public DateInputValidator getDateInputValidator() {
        return dateInputValidator;
    }

    public ReservationsListViewer getReservationsListViewer() {
        return reservationsListViewer;
    }

    public SpaceListViewer getSpaceListViewer() {
        return spaceListViewer;
    }

    public CustomerListViewer getCustomerListViewer() {
        return customerListViewer;
    }

    public TimeOverlapChecker getTimeOverlapChecker() {
        return timeOverlapChecker;
    }



}
