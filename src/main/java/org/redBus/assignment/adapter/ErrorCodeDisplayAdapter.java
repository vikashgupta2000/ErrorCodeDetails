package org.redBus.assignment.adapter;

import org.redBus.assignment.model.ErrorData;
import org.redBus.assignment.singleton.ErrorCodeStorage;

import java.util.List;
import java.util.Map;

public class ErrorCodeDisplayAdapter {

    public void displayData() {
        ErrorCodeStorage instance = ErrorCodeStorage.getInstance();
        for(Map.Entry<String, Map<String, List<ErrorData>>> dateMapEntry : instance.getErrorDetailsMap().entrySet()) {
            System.out.println("Date : " + dateMapEntry.getKey());
            for(Map.Entry<String, List<ErrorData>> errorDataMapEntry : dateMapEntry.getValue().entrySet()) {
                System.out.println( "   Error Code : " + errorDataMapEntry.getKey() + " And number of times its present : " + errorDataMapEntry.getValue().size());
            }
        }
    }
}
