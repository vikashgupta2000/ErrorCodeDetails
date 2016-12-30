package org.redBus.assignment.singleton;

import junit.framework.Assert;
import org.junit.Test;
import org.redBus.assignment.model.ErrorData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorCodeStorageTest {
    @Test
    public void shouldCreateOneInstanceEvenCalledMultipleTimes() {
        ErrorCodeStorage errorCodeStorage1 = ErrorCodeStorage.getInstance();
        ErrorCodeStorage errorCodeStorage2 = ErrorCodeStorage.getInstance();

        Assert.assertEquals(errorCodeStorage1, errorCodeStorage2);
    }

    @Test
    public void shouldRetainDataOnceSavedEvenCalledMultipleTimes() {
        ErrorCodeStorage errorCodeStorage = ErrorCodeStorage.getInstance();
        Map<String, Map<String, List<ErrorData>>> errorDataMap = new HashMap<>();
        errorDataMap.put("Test_Date", new HashMap<>());
        errorCodeStorage.setErrorDetailsMap(errorDataMap);

        Assert.assertEquals(ErrorCodeStorage.getInstance().getErrorDetailsMap(), errorDataMap);
    }
}
