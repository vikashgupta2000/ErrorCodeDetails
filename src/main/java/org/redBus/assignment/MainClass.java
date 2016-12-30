package org.redBus.assignment;

import org.redBus.assignment.adapter.ErrorCodeDisplayAdapter;
import org.redBus.assignment.handler.ErrorCodeHandler;
import org.redBus.assignment.service.ErrorCodeService;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class MainClass {

    private static final String FILE_NAME = "sampleLogFile.txt";
    private static final String REGEX_DATE_TIME_FORMAT = "\\d+-\\d+-\\d+ \\d+:\\d+:\\d+";
    private static final String SIMPLE_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        ErrorCodeService service = ErrorCodeHandler.MY_ERROR_CODE_SERVICE.errorFileReaderService(FILE_NAME, REGEX_DATE_TIME_FORMAT, SIMPLE_DATE_TIME_FORMAT);
        service.evaluate();
        new ErrorCodeDisplayAdapter().displayData();
    }
}
