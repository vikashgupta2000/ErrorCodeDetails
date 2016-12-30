package org.redBus.assignment.service;

import java.io.FileNotFoundException;
import java.text.ParseException;

public interface ErrorCodeService {
    void evaluate() throws FileNotFoundException, ParseException;
}
