package org.redBus.assignment.singleton;

import org.redBus.assignment.model.ErrorCode;
import org.redBus.assignment.model.ErrorData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ErrorCodeStorage {
    private final String DATE_FORMAT = "yyyy-MM-dd";
    private ErrorCodeStorage() {}
    private static ErrorCodeStorage errorCodeStorage;

    public static ErrorCodeStorage getInstance() {
        if(null == errorCodeStorage) {
            synchronized (ErrorCodeStorage.class) {
                if (null == errorCodeStorage) {
                    errorCodeStorage = new ErrorCodeStorage();
                }
            }
        }
        return errorCodeStorage;
    }

    private Map<String, Map<String, List<ErrorData>>> errorDetailsMap = new LinkedHashMap<>();

    public Map<String, Map<String, List<ErrorData>>> getErrorDetailsMap() {
        return errorDetailsMap;
    }

    public void setErrorDetailsMap(Map<String, Map<String, List<ErrorData>>> errorDetailsMap) {
        this.errorDetailsMap = errorDetailsMap;
    }

    public void addErrorCodeData(Date date, ErrorData errorData) {
        if(null == errorDetailsMap) {
            errorDetailsMap = new HashMap<>();
        }
        String dateString = new SimpleDateFormat(DATE_FORMAT).format(date);
        if(!errorDetailsMap.containsKey(dateString)) {
            Map<String, List<ErrorData>> errorDataMap = new HashMap<>();
            errorDetailsMap.put(dateString, errorDataMap);
        }
        Map<String, List<ErrorData>> errorDataMap = errorDetailsMap.get(dateString);
        String errorCode = errorData.getErrorCode().getValue();
        if(!errorDataMap.containsKey(errorCode)) {
            errorDataMap.put(errorCode, new ArrayList<>());
        }
        errorDataMap.get(errorCode).add(errorData);
    }
}
