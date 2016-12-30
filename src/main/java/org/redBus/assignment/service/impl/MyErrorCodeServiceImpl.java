package org.redBus.assignment.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.redBus.assignment.model.ErrorCode;
import org.redBus.assignment.model.ErrorData;
import org.redBus.assignment.service.ErrorCodeService;
import org.redBus.assignment.singleton.ErrorCodeStorage;
import org.redBus.assignment.util.FileReader;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyErrorCodeServiceImpl implements ErrorCodeService {
    private final String REGEX_DATE_PATTERN;
    private final String FILE_NAME;
    private final String SIMPLE_DATE_TIME_FORMAT;

    public MyErrorCodeServiceImpl(String fileName, String regexDatePattern, String simpleDateTimeFormat) {
        FILE_NAME = fileName;
        REGEX_DATE_PATTERN = regexDatePattern;
        SIMPLE_DATE_TIME_FORMAT =simpleDateTimeFormat;
    }

    @Override
    public void evaluate() throws FileNotFoundException, ParseException {
        List<String> logList = new FileReader().readFileAndConvertToList(FILE_NAME);
        if(CollectionUtils.isNotEmpty(logList)) {
            for(String logData : logList) {
                ErrorCode errorCode = getErrorCode(logData);
                if (null != errorCode) {
                    Date date = extractDateFromLog(logData);
                    if(null != date) {
                        ErrorData errorData = new ErrorData() {{setDate(date); setErrorCode(errorCode);}};
                        ErrorCodeStorage.getInstance().addErrorCodeData(date, errorData);
                    }
                }
            }
        }
    }

    private ErrorCode getErrorCode(String logData) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (logData.matches(".*\\b" + errorCode.getValue() + "\\b.*")) {
                return errorCode;
            }
        }
        return null;
    }

    private Date extractDateFromLog(String logData) throws ParseException {
        Pattern pattern = Pattern.compile(REGEX_DATE_PATTERN);
        Matcher matcher = pattern.matcher(logData);
        if(matcher.find()) {
            return new SimpleDateFormat(SIMPLE_DATE_TIME_FORMAT).parse(matcher.group());
        }
        return null;
    }
}
